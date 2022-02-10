package com.cmc.credagility.core.domain.schedule;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.type.ScheduleStatus;


/**
 * This class is used to store Portfolio Channel schedule information.
 *
 * <p><a href="ChannelSchedule.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/15/2014 13:55
 */
@Entity
@Table(
  name    = "ChannelSchedule",
  indexes = {
    @Index(
      name = "statusIndex",
      columnList = "scheduleStatus"
    )
  }
)
public class ChannelSchedule extends BaseSchedule {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6374123749245225324L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The deployed channel rules. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "channelSchedule",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("priority desc")
  @Where(clause = "deployed='Y'")
  private Set<ChannelRule> deployedChannelRules = new LinkedHashSet<ChannelRule>();

  /** The draft channel rules. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "channelSchedule",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("priority desc")
  @Where(clause = "deployed='N'")
  private Set<ChannelRule> draftChannelRules = new LinkedHashSet<ChannelRule>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Add channel rule to schedule.
   *
   * @param   channelRule  $param.type$
   *
   * @return  add channel rule to schedule.
   */
  public boolean addChannelRule(ChannelRule channelRule) {
    Long portfolioId = this.getPortfolio().getPortfolioId();

    if (portfolioId != null) {
      channelRule.setPortfolioId(portfolioId.longValue());
    }

    channelRule.setChannelSchedule(this);

    return draftChannelRules.add(channelRule);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add or Update draft rule.
   *
   * @param   userId       $param.type$
   * @param   channelRule  $param.type$
   *
   * @return  add or Update draft rule.
   */
  public ChannelRule addOrUpdateDraftRule(Long userId, ChannelRule channelRule) {
    Map<Long, ChannelRule> myRules = getDraftChannelRuleMap();
    Long                   ruleId  = channelRule.getRuleId();

    if (ruleId != null) {
      // do update if it exists
      ChannelRule myChannelRule = myRules.get(ruleId);
      myChannelRule.updateRule(channelRule);
      myChannelRule.setLastUpdateAgentId(userId);
      myChannelRule.setLastUpdateDate(new Date());

// myChannelRule.setDeployed(false);
// myChannelRule.setComplied(false);
      myChannelRule.setValid(channelRule.getValid());

      return myChannelRule;
    } else {
      channelRule.setCreateAgentId(userId);
      channelRule.setCreateDate(new Date());

      channelRule.setDeployed(false);
      channelRule.setComplied(false);
      channelRule.setValid(false);

      channelRule.setChannelSchedule(this);
      this.draftChannelRules.add(channelRule);

      return channelRule;
    } // end if-else
  }   // end method addOrUpdateDraftRule

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Deploy rules from draft set and discard the current deployed set.
   *
   * @return  DOCUMENT ME!
   */
  @Override public boolean deployRules() {
    boolean          ret           = true;
    Set<ChannelRule> rulesToDeploy = new LinkedHashSet<ChannelRule>();

    for (ChannelRule channelRule : draftChannelRules) {
      // double confirm the rule status before deploy
      // only valid and compiled rule could be deploy
      if (Boolean.TRUE.equals(channelRule.getValid())) {
        ChannelRule newChannelRule = new ChannelRule();
        newChannelRule.deepCopy(channelRule);

        if (channelRule.getCreateAgentId() != null) {
          newChannelRule.setCreateAgentId(new Long(channelRule.getCreateAgentId()));
        }

        newChannelRule.setDeployed(true);
        newChannelRule.setValid(true);
        newChannelRule.setComplied(true);
        newChannelRule.setRuleContent(channelRule.getRuleContent());

        Long portfolioId = this.getPortfolio().getPortfolioId();

        if (portfolioId != null) {
          newChannelRule.setPortfolioId(portfolioId.longValue());
        }

        newChannelRule.setChannelSchedule(this);

        // add to deploy set
        rulesToDeploy.add(newChannelRule);
      } else {
        // deploy fail if the draft rule is not compiled or not valid
        ret = false;

        break;
      } // end if-else
    }   // end for

    if (ret) {
      setScheduleStatus(ScheduleStatus.SCHEDULED);

      // all done, update the deployed set now
      deployedChannelRules.clear();
      deployedChannelRules.addAll(rulesToDeploy);
    }

    return ret;
  } // end method deployRules

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#duplicate()
   */
  @Override public BaseSchedule duplicate() {
    ChannelSchedule newSchedule = new ChannelSchedule();
    newSchedule.init(this);

    // duplicate rules to schedule
    for (ChannelRule rule : this.draftChannelRules) {
      ChannelRule newRule = new ChannelRule();
      newRule.deepCopy(rule);
      newSchedule.addChannelRule(newRule);
    }

    return newSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#duplicate(com.cmc.credagility.core.domain.portfolio.Portfolio)
   */
  @Override public BaseSchedule duplicate(Portfolio portfolio) {
    boolean samePortfolio = this.getPortfolio().isSame(portfolio);

    ChannelSchedule newSchedule = new ChannelSchedule();
    newSchedule.init(this);
    newSchedule.setPortfolio(portfolio);

    // duplicate rules to schedule
    for (ChannelRule rule : this.draftChannelRules) {
      ChannelRule newRule = new ChannelRule();

      if (samePortfolio) {
        newRule.deepCopy(rule);
      } else {
        newRule.copyCriteria(rule);
      }

      newSchedule.addChannelRule(newRule);
    }

    return newSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the map for the Deploy channel Rule using ruleId as key.
   *
   * @return  get the map for the Deploy channel Rule using ruleId as key.
   */
  public Map<Long, ChannelRule> getDeployedChannelRuleMap() {
    Map<Long, ChannelRule> map = new HashMap<Long, ChannelRule>();

    for (ChannelRule channelRule : deployedChannelRules) {
      map.put(channelRule.getRuleId(), channelRule);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deployed channel rules.
   *
   * @return  Set
   */
  public Set<ChannelRule> getDeployedChannelRules() {
    return deployedChannelRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#getDeployedRules()
   */
  @Override public Set<BaseRule> getDeployedRules() {
    Set<BaseRule> rules = new LinkedHashSet<BaseRule>();
    rules.addAll(deployedChannelRules);

    return rules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the map for the draft channel rule using ruleId as key.
   *
   * @return  get the map for the draft channel rule using ruleId as key.
   */
  public Map<Long, ChannelRule> getDraftChannelRuleMap() {
    Map<Long, ChannelRule> map = new HashMap<Long, ChannelRule>();

    for (ChannelRule channelRule : draftChannelRules) {
      map.put(channelRule.getRuleId(), channelRule);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for draft channel rules.
   *
   * @return  Set
   */
  public Set<ChannelRule> getDraftChannelRules() {
    return draftChannelRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see com.cmc.credagility.BaseSchedule#getDraftRules()
   */
  @Override public Set<BaseRule> getDraftRules() {
    Set<BaseRule> rules = new LinkedHashSet<BaseRule>();
    rules.addAll(draftChannelRules);

    return rules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see com.cmc.credagility.BaseSchedule#getScheduleType()
   */
  @Override public String getScheduleType() {
    return "ChannelSchedule";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseSchedule#isDeployed()
   */
  @Override public boolean isDeployed() {
    for (@SuppressWarnings("unused")
      ChannelRule rule : deployedChannelRules) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Reload rules from deployed set and discard the current draft set.
   */
  @Override public void reloadRules() {
    // clear the current set
    draftChannelRules.clear();

    for (ChannelRule channelRule : deployedChannelRules) {
      ChannelRule newChannelRule = new ChannelRule();
      newChannelRule.deepCopy(channelRule);

      if (channelRule.getCreateAgentId() != null) {
        newChannelRule.setCreateAgentId(new Long(channelRule.getCreateAgentId()));
      }

      newChannelRule.setDeployed(false);
      newChannelRule.setValid(true);
      newChannelRule.setComplied(true);
      newChannelRule.setRuleContent(channelRule.getRuleContent());

      Long portfolioId = this.getPortfolio().getPortfolioId();

      if (portfolioId != null) {
        newChannelRule.setPortfolioId(portfolioId.longValue());
      }

      newChannelRule.setChannelSchedule(this);

      // add to draft set
      draftChannelRules.add(newChannelRule);
    }
  } // end method reloadRules

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Remove draft rule.
   *
   * @param   userId  $param.type$
   * @param   ruleId  agencyQueueId
   *
   * @return  DOCUMENT ME!
   */
  public boolean removeDraftRule(Long userId, Long ruleId) {
    if (ruleId != null) {
      // do update if it exists
      ChannelRule channelRule = getDraftChannelRuleMap().get(ruleId);

      draftChannelRules.remove(channelRule);
      channelRule.setChannelSchedule(null);

      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for deployed channel rules.
   *
   * @param  deployedChannelRules  Set
   */
  public void setDeployedChannelRules(Set<ChannelRule> deployedChannelRules) {
    this.deployedChannelRules = deployedChannelRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for draft channel rules.
   *
   * @param  channelRules  Set
   */
  public void setDraftChannelRules(Set<ChannelRule> channelRules) {
    this.draftChannelRules = channelRules;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("ChannelSchedule ( ").append(super.toString()).append(TAB).append("deployedChannelRules = ").append(
      this.deployedChannelRules).append(TAB).append("draftChannelRules = ").append(
      this.draftChannelRules).append(TAB).append(" )");

    return retValue.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update draft rule set.
   *
   * @param   userId  $param.type$
   * @param   rules   $param.type$
   *
   * @return  DOCUMENT ME!
   */
  public boolean updateDraftRules(Long userId, List<ChannelRule> rules) {
    Set<ChannelRule>       channelRules = new LinkedHashSet<ChannelRule>();
    Map<Long, ChannelRule> myRules      = getDraftChannelRuleMap();

    for (ChannelRule channelRule : rules) {
      Long ruleId = channelRule.getRuleId();

      channelRule.setCreateAgentId(userId);
      channelRule.setCreateDate(new Date());
      channelRule.setDeployed(false);

      if (ruleId != null) {
        // do update if it exists
        ChannelRule myChannelRule = myRules.get(ruleId);
        myChannelRule.updateRule(channelRule);
        channelRule = myChannelRule;
      }

      // add rule to set with the order
      channelRule.setChannelSchedule(this);
      channelRule.setPortfolioId(this.getPortfolio().getPortfolioId());
      channelRules.add(channelRule);
    }

    this.draftChannelRules.clear();
    this.draftChannelRules.addAll(channelRules);

    return true;
  } // end method updateDraftRules
} // end class ChannelSchedule
