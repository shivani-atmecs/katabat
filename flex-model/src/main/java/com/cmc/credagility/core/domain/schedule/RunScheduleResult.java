package com.cmc.credagility.core.domain.schedule;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.User;


/**
 * <p>This class is used to store portfolio schedule preview result information</p>
 *
 * <p><a href="BaseSchedule.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "RunScheduleResult")
public class RunScheduleResult extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  private static final long serialVersionUID = 700056915163741579L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Random Account count run. */
  @Column(name = "accountCount")
  private Long accountCount;

  /** completed date. */
  @Column(
    name     = "completedDate",
    nullable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  private Date completedDate;

  /** The user who created the schedule run. */
  @JoinColumn(
    name      = "creatorId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private User creator;

  /** The portfolio which schedule belong to. */
  @Column(
    name     = "portfolioId",
    nullable = false
  )
  private Long portfolioId;

  /** The portfolio name. */
  @Column(
    name     = "portfolioName",
    nullable = false,
    length   = 80
  )
  private String portfolioName;

  /** Account random digits for run. */
  @Column(
    name             = "randomDigits",
    columnDefinition = "LONGTEXT"
  )
  @Lob private String randomDigits;


  // npelleti, 07/30, USBank, Removed unique constraint
  /** primary key. */
  @Column(
    name     = "resultId",

    // unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long resultId;

  /** The rule set id array. */
  @Column(
    name             = "ruleIds",
    columnDefinition = "LONGTEXT"
  )
  @Lob private String ruleIds;

  /** The rule set names. */
  @Column(
    name             = "ruleNames",
    columnDefinition = "LONGTEXT"
  )
  @Lob private String ruleNames;

  /** Individul Rule Result. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "scheduleResult",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  private Set<RunRuleResult> ruleResults = new LinkedHashSet<RunRuleResult>();

  /** result schedule id. */
  @Column(
    name     = "scheduleId",
    nullable = false
  )
  private Long scheduleId;

  /** result schedult type. */
  @Column(
    name     = "scheduletype",
    nullable = false,
    length   = 32
  )
  private String scheduleType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addRuleResult.
   *
   * @param  runRuleResult  RunRuleResult
   */
  public void addRuleResult(RunRuleResult runRuleResult) {
    runRuleResult.setScheduleResult(this);
    ruleResults.add(runRuleResult);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account count.
   *
   * @return  Long
   */
  public Long getAccountCount() {
    return accountCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for completed date.
   *
   * @return  Date
   */
  public Date getCompletedDate() {
    return completedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for creator.
   *
   * @return  User
   */
  public User getCreator() {
    return creator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get duration for the processing time in string.
   *
   * @return  get duration for the processing time in string
   */
  public String getDuration() {
    String durationStr = "";
    long   duration    = completedDate.getTime() - createDate.getTime();
    int    ms          = (int) (duration % 1000L);
    duration /= 1000;

    int s = (int) (duration % 60L);
    duration /= 60;

    int m = (int) (duration % 60L);
    int h = (int) (duration / 60L);

    if (h > 0) {
      durationStr = h + "h ";
    }

    if (m > 0) {
      durationStr += (m + "m ");
    }

    if (s > 0) {
      durationStr += (s + "s ");
    }

    if (ms > 0) {
      durationStr += (ms + "ms ");
    }

    durationStr = durationStr.trim();

    if ((durationStr != null) && (!durationStr.isEmpty())) {
      return durationStr;
    } else {
      return "0s";
    }
  } // end method getDuration

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio id.
   *
   * @return  Long
   */
  public Long getPortfolioId() {
    return portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio name.
   *
   * @return  String
   */
  public String getPortfolioName() {
    return portfolioName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for random digits.
   *
   * @return  String
   */
  public String getRandomDigits() {
    return randomDigits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for result id.
   *
   * @return  Long
   */
  public Long getResultId() {
    return resultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule ids.
   *
   * @return  String
   */
  public String getRuleIds() {
    return ruleIds;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule names.
   *
   * @return  String
   */
  public String getRuleNames() {
    return ruleNames;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule result.
   *
   * @param   ruleId  Long
   *
   * @return  RunRuleResult
   */
  public RunRuleResult getRuleResult(Long ruleId) {
    for (RunRuleResult ruleResult : ruleResults) {
      if (ruleResult.getRuleId().equals(ruleId)) {
        return ruleResult;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule result map.
   *
   * @return  Map
   */
  public Map<Long, RunRuleResult> getRuleResultMap() {
    Map<Long, RunRuleResult> map = new LinkedHashMap<Long, RunRuleResult>();

    for (RunRuleResult ruleResult : ruleResults) {
      map.put(ruleResult.getRuleId(), ruleResult);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule results.
   *
   * @return  Set
   */
  public Set<RunRuleResult> getRuleResults() {
    return ruleResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule id.
   *
   * @return  Long
   */
  public Long getScheduleId() {
    return scheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The schedule type ChannelSchedule/ProgramSchedule/NegotiateSchedule/QueueSchedule.
   *
   * @return  the schedule type ChannelSchedule/ProgramSchedule/NegotiateSchedule/QueueSchedule
   */
  public String getScheduleType() {
    return scheduleType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all triggered accounts for schedule.
   *
   * @return  get all triggered accounts for schedule
   */
  public long getTriggeredCount() {
    long count = 0L;

    for (RunRuleResult ruleResult : this.ruleResults) {
      count += ruleResult.getTriggeredCount();
    }

    return count;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account count.
   *
   * @param  accountCount  Long
   */
  public void setAccountCount(final Long accountCount) {
    this.accountCount = accountCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for completed date.
   *
   * @param  completedDate  Date
   */
  public void setCompletedDate(Date completedDate) {
    this.completedDate = completedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for creator.
   *
   * @param  creator  User
   */
  public void setCreator(User creator) {
    this.creator = creator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio id.
   *
   * @param  portfolioId  Long
   */
  public void setPortfolioId(Long portfolioId) {
    this.portfolioId = portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio name.
   *
   * @param  portfolioName  String
   */
  public void setPortfolioName(final String portfolioName) {
    this.portfolioName = portfolioName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for random digits.
   *
   * @param  randomDigits  String
   */
  public void setRandomDigits(String randomDigits) {
    this.randomDigits = randomDigits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for result id.
   *
   * @param  resultId  Long
   */
  public void setResultId(Long resultId) {
    this.resultId = resultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule ids.
   *
   * @param  ruleIds  String
   */
  public void setRuleIds(String ruleIds) {
    this.ruleIds = ruleIds;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule names.
   *
   * @param  ruleNames  String
   */
  public void setRuleNames(final String ruleNames) {
    this.ruleNames = ruleNames;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule results.
   *
   * @param  ruleResults  Set
   */
  public void setRuleResults(Set<RunRuleResult> ruleResults) {
    this.ruleResults = ruleResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule id.
   *
   * @param  scheduleId  Long
   */
  public void setScheduleId(Long scheduleId) {
    this.scheduleId = scheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule type.
   *
   * @param  scheduleType  String
   */
  public void setScheduleType(String scheduleType) {
    this.scheduleType = scheduleType;
  }
} // end class RunScheduleResult
