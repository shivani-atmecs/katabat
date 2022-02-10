package com.cmc.credagility.core.domain.user;

import java.io.Serializable;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.activity.AgentCallActivity;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 17:00
 */
@Entity
@Table(
  name              = "UserLoadedAccount" /*uniqueConstraints = { @UniqueConstraint(columnNames = {}) }*/,
  uniqueConstraints = { @UniqueConstraint(columnNames = { "accountNum", "count" }) }
)
public class UserLoadedAccount extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6942063021948391030L;

  private static final transient Logger log = LoggerFactory.getLogger(UserLoadedAccount.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agentId",
    insertable = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;

  /** Relations UserLoadedAccount AgentCallActivity : */
  @OneToMany(
    cascade  = { CascadeType.REMOVE, CascadeType.ALL },
    fetch    = FetchType.LAZY,
    mappedBy = "userLoadedAccount"
  )
  @OrderBy("createDate desc")
  protected Set<AgentCallActivity> agentCallActivities = new LinkedHashSet<AgentCallActivity>();

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "current",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean current = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lockExpirationTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lockExpirationTime = null;

  /** UserLoadedAccount identifier PK. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long userLoadedAccountId;

  @Column(
    name     = "count",
    nullable = false
  )
  private Long count;

  @Column(name = "sessionDuration")
  private Long sessionDuration;

  @Column(name = "sessionEndTime")
  @Temporal(TemporalType.TIMESTAMP)
  private Date sessionEndTime;

  @Column(name = "sessionStartTime")
  @Temporal(TemporalType.TIMESTAMP)
  private Date sessionStartTime;

  @Column(name = "sessionTag")
  private String sessionTag;

  @Column(
    name   = "sourceType",
    length = 100
  )
  private String sourceType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * allowLoadNewAccount.
   *
   * @param   user               User
   * @param   hasReadOnlyAccess  Boolean
   *
   * @return  Boolean
   */
  public Boolean allowLoadNewAccount(User user, Boolean hasReadOnlyAccess) {
    if (Boolean.TRUE.equals(hasReadOnlyAccess)) {
      /**
       * Role.cmcOnly = 'Y'
       * ApplicationConfig.cmcOnlyRoleReadOnly = 'Y'/null
       */

      log.info(
        "Locked user.hasCmcOnlyRole(), cmcOnlyRoleReadOnly='Y'/null. Allow loading of target account.");

      return Boolean.TRUE;
    }

    if (Boolean.TRUE.equals(getAccount().getPortfolio().isAwReadOnly())) {
      /**
       * For ReadOnly Portfolios/Inactive accounts, allow one to load the next account
       * without asking the agent to dispose the current account.
       */
      log.info(
        "Locked Account's portfolio=Read Only (awReadOnly='Y'). Allow target account.");

      return Boolean.TRUE;
    }

    if ((Boolean.FALSE.equals(getAccount().isActive()))
          && (Boolean.TRUE.equals(getAccount().getPortfolio().isAwInactiveAccountReadOnly()))) {
      /**
       * Account.active = 'N' (Currently Loaded Account is INACTIVE) &
       * Portfolio.awReadOnly = 'N' &
       * Portfolio.awInactiveAccountReadOnly = 'Y'
       */

      log.info(
        "Locked Account=InActive, awReadOnly='N' & awInactiveAccountReadOnly='Y'. Allow target account.");

      return Boolean.TRUE;
    }

    if ((getLockExpirationTime() == null)
          || !getLockExpirationTime().after(new Date())) {
      /**
       * Account lock expiration time is in the past
       */
      log.info("Locked acct is expired at " + getLockExpirationTime() + ". Allow target account.");

      return Boolean.TRUE;
    } else if (getAgent().equals(user)) {
      /**
       * Account locked by current agent
       */
      if (isAccountDisposed()) {
        /**
         * Account disposed by current agent
         */
        log.info("Current Account is disposed. Allow target account.");

        return Boolean.TRUE;
      } else {
        log.info("Current Account is locked and not disposed. Do NOT load next account.");

        return Boolean.FALSE;
      }
    } else {
      /**
       * Current account has been loaded in read only mode by the current agent since its:
       * (a) not expired(userLoadedAccount != null);
       * (b) not disposed or locked by another agent;
       */
      log.info("Current Account is NOT locked by user: " + user.getUsername() + "(" + user.getId()
        + ")" + ". It is locked by " + user.getUsername() + "(" + user.getId() + "). Allow load next account.");

      return Boolean.TRUE;
    } // end if-else

  } // end method allowLoadNewAccount

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final UserLoadedAccount other = (UserLoadedAccount) obj;

    if (this.userLoadedAccountId == null) {
      if (other.getUserLoadedAccountId() != null) {
        return false;
      }
    } else if (!this.userLoadedAccountId.equals(other.getUserLoadedAccountId())) {
      return false;
    }

    if (this.account == null) {
      if (other.getAccount() != null) {
        return false;
      }
    } else if (!this.account.equals(other.getAccount())) {
      return false;
    }

    if (this.agent == null) {
      if (other.getAgent() != null) {
        return false;
      }
    } else if (!this.agent.equals(other.getAgent())) {
      return false;
    }

    if (this.lockExpirationTime == null) {
      if (other.getLockExpirationTime() != null) {
        return false;
      }
    } else if (!this.lockExpirationTime.equals(other.getLockExpirationTime())) {
      return false;
    }

    if (this.current == null) {
      if (other.isCurrent() != null) {
        return false;
      }
    } else if (!this.current.equals(other.isCurrent())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent.
   *
   * @return  User
   */
  public User getAgent() {
    return agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent call activities.
   *
   * @return  Set
   */
  public Set<AgentCallActivity> getAgentCallActivities() {
    return agentCallActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for count.
   *
   * @return  Long
   */
  public Long getCount() {
    return count;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for lock expiration time.
   *
   * @return  Date
   */
  public Date getLockExpirationTime() {
    return lockExpirationTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for session duration.
   *
   * @return  Long
   */
  public Long getSessionDuration() {
    return sessionDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for session end time.
   *
   * @return  Date
   */
  public Date getSessionEndTime() {
    return sessionEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for session start time.
   *
   * @return  Date
   */
  public Date getSessionStartTime() {
    return sessionStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for session tag.
   *
   * @return  String
   */
  public String getSessionTag() {
    return sessionTag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source type.
   *
   * @return  String
   */
  public String getSourceType() {
    return sourceType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user loaded account id.
   *
   * @return  Long
   */
  public Long getUserLoadedAccountId() {
    return userLoadedAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account disposed.
   *
   * @return  Boolean
   */
  public Boolean isAccountDisposed() {
    if (userLoadedAccountId != null) {
      log.info("Check isAccountDisposed: UserLoadedAccountId" + userLoadedAccountId);

      Set<AgentCallActivity> agentCallActivitySet = getAgentCallActivities();

      if ((agentCallActivitySet != null) && (agentCallActivitySet.size() > 0)) {
        log.info("Find disposition for userLoadedAccountId " + userLoadedAccountId);

        return Boolean.TRUE;
      }

      log.info("No disposition for userLoadedAccountId " + userLoadedAccountId);

      return Boolean.FALSE;
    }

    return Boolean.TRUE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current.
   *
   * @return  Boolean
   */
  public Boolean isCurrent() {
    return current;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent.
   *
   * @param  agent  User
   */
  public void setAgent(User agent) {
    this.agent = agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent call activities.
   *
   * @param  agentCallActivities  Set
   */
  public void setAgentCallActivities(Set<AgentCallActivity> agentCallActivities) {
    this.agentCallActivities = agentCallActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for count.
   *
   * @param  count  Long
   */
  public void setCount(Long count) {
    this.count = count;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current.
   *
   * @param  current  Boolean
   */
  public void setCurrent(Boolean current) {
    this.current = current;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for lock expiration time.
   *
   * @param  lockExpirationTime  Date
   */
  public void setLockExpirationTime(Date lockExpirationTime) {
    this.lockExpirationTime = lockExpirationTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for session duration.
   *
   * @param  sessionDuration  Long
   */
  public void setSessionDuration(Long sessionDuration) {
    this.sessionDuration = sessionDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for session end time.
   *
   * @param  sessionEndTime  Date
   */
  public void setSessionEndTime(Date sessionEndTime) {
    this.sessionEndTime = sessionEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for session start time.
   *
   * @param  sessionStartTime  Date
   */
  public void setSessionStartTime(Date sessionStartTime) {
    this.sessionStartTime = sessionStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for session tag.
   *
   * @param  sessionTag  String
   */
  public void setSessionTag(String sessionTag) {
    this.sessionTag = sessionTag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source type.
   *
   * @param  sourceType  String
   */
  public void setSourceType(String sourceType) {
    this.sourceType = sourceType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user loaded account id.
   *
   * @param  userLoadedAccountId  Long
   */
  public void setUserLoadedAccountId(Long userLoadedAccountId) {
    this.userLoadedAccountId = userLoadedAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("UserLoadedAccount ( ").append(super.toString()).append(TAB).append("userLoadedAccountId = ")
      .append(this.userLoadedAccountId).append(TAB).append("account = ").append(this.account).append(TAB).append(
      "agent = ").append(this.agent).append(TAB).append("lockExpirationTime = ").append(this.lockExpirationTime).append(
      TAB).append("current = ").append(this.current).append(" )");

    return retValue.toString();
  }
} // end class UserLoadedAccount
