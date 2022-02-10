package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.type.ScheduleStatus;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.util.DateUtil;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;
import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store portfolio schedule information.
 *
 * <p><a href="Schedule.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/16/2014 14:42
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "statusIndex",
      columnList = "scheduleStatus"
    )
  }
)
public class Schedule extends BaseSchedule implements Evaluable, Executable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -65673110064694206L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Transient protected String context = null;

  /** Scheduled CopyFrom. */
  @Column(nullable = true)
  protected Long copyFromId;

  /** Trigger flag for schedule. */
  @Transient protected boolean evaluateResult = false;


  /** TODO: DOCUMENT ME! */
  @Transient protected int eventStrategiesCount;


  /** TODO: DOCUMENT ME! */
  @Transient protected Boolean ifEventPortfolio;


  /** TODO: DOCUMENT ME! */
  @Transient protected Boolean ifScoreTypePortfolio;

  /** The portfolio which schedule belong to. */
  @JoinColumn(
    name       = "portfolioId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Portfolio portfolio = new Portfolio();

  /** flag for dry run. */
  @Transient protected boolean preview = false;


  /** TODO: DOCUMENT ME! */
  @Transient protected Long strategyMasterBatchId;


  /** TODO: DOCUMENT ME! */
  @Transient protected boolean triggered = false;

  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "schedule",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @Where(clause = "type = 'Event'")
  private Set<Strategy> eventStrategies = new LinkedHashSet<Strategy>();

  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "schedule",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @Where(clause = "type = 'General'")
  private Set<Strategy> generalStrategies = new LinkedHashSet<Strategy>();

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  private final transient Logger logger = LoggerFactory.getLogger(getClass());

  @Transient private Date processEndTime;

  @Transient private Date processStartTime;

  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "schedule",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @Where(clause = "type = 'ScoreCard'")
  private Set<Strategy> scoreCardStrategies = new LinkedHashSet<Strategy>();


  /** Schedule strategies . */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "schedule",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("priority asc")
  private Set<Strategy> strategies = new LinkedHashSet<Strategy>();

  /** Flag for viewOnly. */
  @Transient private boolean viewOnly = true;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new Schedule object.
   */
  public Schedule() { }

  /**
   * Creates a new Schedule object.
   *
   * @param  schedule  Schedule
   */
  public Schedule(Schedule schedule) {
    updateSchedule(schedule);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Add strategy to schedule.
   *
   * @param  strategy  to add
   */
  public void addStrategy(Strategy strategy) {
    strategy.setSchedule(this);

    // strategy.setPriority(1 + strategies.size());
    this.strategies.add(strategy);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * beforeExecute.
   */
  @Override public void beforeExecute() {
    this.triggered = false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyAllStrategy.
   *
   * @param  copyFrom  Schedule
   * @param  user      User
   */
  public void copyAllStrategy(Schedule copyFrom, User user) {
    for (Strategy strategy : copyFrom.getStrategies()) {
      addStrategy(strategy.duplicate(user));
    }
  }
  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  Schedule
   * @param  infoOnly  boolean
   * @param  user      User
   */
  public void deepCopy(Schedule copyFrom, boolean infoOnly, User user) {
    updateSchedule(copyFrom);

    for (Strategy strategy : copyFrom.getStrategies()) {
      Strategy newStrategy = new Strategy();
      newStrategy.deepCopy(strategy, infoOnly, user);

      if (user != null) {
        newStrategy.setCreator(user);
        newStrategy.setLastUpdater(user);
      } else {
        newStrategy.setCreator(this.getLastUpdater());
        newStrategy.setLastUpdater(this.getLastUpdater());
      }

      newStrategy.setLastUpdateDate(new Date());
      addStrategy(newStrategy);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @param   user  User
   *
   * @return  Schedule
   */
  public Schedule duplicate(User user) {
    Schedule newCopy = new Schedule();
    newCopy.setPreview(preview);
    newCopy.setDescription(getDescription());
    newCopy.setName(getName());
    newCopy.setPortfolio(portfolio);
    newCopy.setScheduleDate(scheduleDate);
    newCopy.setScheduleStatus(ScheduleStatus.DRAFT);
    newCopy.setViewOnly(viewOnly);
    newCopy.setCreator(user);

    for (Strategy strategy : this.strategies) {
      newCopy.addStrategy(strategy.duplicate(user));
    }

    return newCopy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * endProcess.
   *
   * @param  batchId  Long
   */
  public void endProcess(Long batchId) {
    this.processEndTime = new Date();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   obj  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    Schedule other = (Schedule) obj;

    if (getName() == null) {
      if (other.getName() != null) {
        return false;
      }
    } else if (!getName().equals(other.getName())) {
      return false;
    }

    if (scheduleDate == null) {
      if (other.scheduleDate != null) {
        return false;
      }
    } else if (!scheduleDate.equals(other.scheduleDate)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * evaluate.
   *
   * @param   helper  EvaluateHelper
   *
   * @return  boolean
   */
  @Override public boolean evaluate(EvaluateHelper helper) {
    if (helper == null) {
      return false;
    }

    evaluateResult = false;

    if ((helper.getParameters().get("runType") != null)
          && ((RunType) helper.getParameters().get("runType")).isEvent()) {
      
      boolean runAllPortfolios = false;
      
      if ((helper.getParameters().get("runAllPortfolios") != null) && helper.getParameters().get("runAllPortfolios").equals(Boolean.TRUE)) {
        runAllPortfolios = true;
      }
      
      for (Strategy strategy : eventStrategies) {
        if ((helper.getParameters().get("eventId")).equals(strategy.getEvent().getEventId()) 
                || (runAllPortfolios && strategy.getEvent().getEventName().equals(helper.getParameters().get("eventName")))) {
          if (strategy.evaluate(helper)) {
            evaluateResult = true;
          }
        }
      }
    } else {
      String c = getValidContext();

      for (Strategy strategy : generalStrategies) {
        if (!c.equalsIgnoreCase(strategy.getValidContext())) {
          continue;
        }

        if (strategy.evaluate(helper)) {
          evaluateResult = true;
        }
      }
    } // end if-else


    return evaluateResult;
  } // end method evaluate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * execute.
   *
   * @param  evaluateHelper  EvaluateHelper
   * @param  executeHelper   ExecuteHelper
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) {
    this.triggered = false;

    if ((evaluateHelper.getParameters().get("runType") != null)
          && ((RunType) evaluateHelper.getParameters().get("runType")).isEvent()) {
      
      boolean runAllPortfolios = false;
      
      if ((evaluateHelper.getParameters().get("runAllPortfolios") != null) && evaluateHelper.getParameters().get("runAllPortfolios").equals(Boolean.TRUE)) {
        runAllPortfolios = true;
      }
      
      for (Strategy strategy : eventStrategies) {
        if ((evaluateHelper.getParameters().get("eventId")).equals(strategy.getEvent().getEventId()) || 
                (runAllPortfolios && (strategy.getEvent() != null) && strategy.getEvent().getEventName().equals(evaluateHelper.getParameters().get("eventName")))) {
          strategy.execute(evaluateHelper, executeHelper);

          if (strategy.isTriggered()) {
            this.triggered = true;
          }
        }
      }
    } else {
      String c = getValidContext();

      for (Strategy strategy : generalStrategies) {
        logger.info("execute strategy isSkippedExecution : " + strategy.isSkippedExecution());

        if (Boolean.TRUE.equals(strategy.isSkippedExecution())) {
          continue;
        }

        if (!c.equalsIgnoreCase(strategy.getValidContext())) {
          continue;
        }

        strategy.execute(evaluateHelper, executeHelper);

        if (strategy.isTriggered()) {
          this.triggered = true;
        }
      }
    } // end if-else

  } // end method execute

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Find strategy from schedule.
   *
   * @param   strategy  to find
   *
   * @return  matched strategy
   */
  public Strategy findStrategy(Strategy strategy) {
    if (strategy == null) {
      return null;
    }

    if ((strategy.getStrategyId() != null) && (strategy.getStrategyId().longValue() != 0L)) {
      // lookup through id
      for (Strategy curStrategy : this.strategies) {
        if (curStrategy.getStrategyId().equals(strategy.getStrategyId())) {
          return curStrategy;
        }
      }

      return null;
    } else {
      // lookup through equal
      Iterator<Strategy> it = this.strategies.iterator();

      while (it.hasNext()) {
        Strategy ret = it.next();

        if (ret.equals(strategy)) {
          return ret;
        }
      }

    } // end if-else

    return null;
  } // end method findStrategy

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all nodes.
   *
   * @return  List
   */
  public List<Node> getAllNodes() {
    List<Node> allNodes = new ArrayList<Node>();

    for (Strategy strategy : strategies) {
      allNodes.addAll(strategy.getNodes());
    }

    return allNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for context.
   *
   * @return  String
   */
  public String getContext() {
    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for copy from id.
   *
   * @return  Long
   */
  public Long getCopyFromId() {
    return copyFromId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for display name.
   *
   * @return  String
   */
  public String getDisplayName() {
    String         displayName = null;
    ScheduleStatus status      = getScheduleStatus();

    if (status != null) {
      displayName = status.toString();

      if (ScheduleStatus.OLD.equals(getScheduleStatus())) {
        displayName = "Retired";
      }

      displayName = DateUtil.convertDateToString(this.scheduleDate) + " - '" + getName() + "' : " + displayName;
    }

    return displayName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event strategies.
   *
   * @return  Set
   */
  public Set<Strategy> getEventStrategies() {
    return eventStrategies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event strategies count.
   *
   * @return  int
   */
  public int getEventStrategiesCount() {
    return eventStrategies.size();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for general strategies.
   *
   * @return  Set
   */
  public Set<Strategy> getGeneralStrategies() {
    return generalStrategies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for if event portfolio.
   *
   * @return  Boolean
   */
  public Boolean getIfEventPortfolio() {
    if ((portfolio != null) && (portfolio.getEvents() != null) && (portfolio.getEvents().size() > 0)) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for if score type portfolio.
   *
   * @return  Boolean
   */
  public Boolean getIfScoreTypePortfolio() {
    if ((portfolio != null) && (portfolio.getScoreTypes() != null) && (portfolio.getScoreTypes().size() > 0)) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for no date display name.
   *
   * @return  String
   */
  public String getNoDateDisplayName() {
    String displayName = null;

    if (scheduleStatus != null) {
      if (ScheduleStatus.OLD.equals(scheduleStatus)) {
        displayName = "Retired";
      } else {
        displayName = scheduleStatus.toString();
      }

      displayName = " - '" + getName() + "' : " + displayName;
    }

    return displayName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio id.
   *
   * @return  Long
   */
  public Long getPortfolioId() {
    return portfolio.getPortfolioId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for process end time.
   *
   * @return  Date
   */
  public Date getProcessEndTime() {
    return processEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for process start time.
   *
   * @return  Date
   */
  public Date getProcessStartTime() {
    return processStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule id.
   *
   * @return  Long
   */
  public Long getScheduleId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score card strategies.
   *
   * @return  Set
   */
  public Set<Strategy> getScoreCardStrategies() {
    return scoreCardStrategies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status string.
   *
   * @return  String
   */
  public String getStatusString() {
    if (getScheduleStatus() != null) {
      return getScheduleStatus().toString().toUpperCase();
    }

    return "";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get strategies.
   *
   * @return  strategies this schedule own
   */
  public Set<Strategy> getStrategies() {
    return strategies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for strategy master batch id.
   *
   * @return  Long
   */
  public Long getStrategyMasterBatchId() {
    return strategyMasterBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for valid context.
   *
   * @return  String
   */
  public String getValidContext() {
    if (StringUtils.hasText(context)) {
      return context;
    }

    return "responsible";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */

  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result) + ((getName() == null) ? 0 : getName().hashCode());
    result = (prime * result)
      + ((scheduleDate == null) ? 0 : scheduleDate.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for editable status.
   *
   * @return  boolean
   */
  public boolean isEditableStatus() {
    if (this.scheduleStatus != null) {
      if (ScheduleStatus.DRAFT.equals(this.scheduleStatus) || ScheduleStatus.SCHEDULED.equals(this.scheduleStatus)) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for evaluate result.
   *
   * @return  boolean
   */
  public boolean isEvaluateResult() {
    return evaluateResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * dry run flag.
   *
   * <p>.@return dry run</p>
   *
   * @return  dry run flag.
   */
  public boolean isPreview() {
    return preview;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Flag which the schedule could be changed.
   *
   * <p>1. ACTIVE/OLD schedule could not be changed</p>
   *
   * <p>2. Schedule belong to view only portfolio could not be changed</p>
   *
   * @return  the readOnly
   */
  public boolean isReadOnly() {
    if ((getScheduleStatus() == ScheduleStatus.ACTIVE)
          || (getScheduleStatus() == ScheduleStatus.OLD)) {
      return true;
    } else {
      return false;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for triggered.
   *
   * @return  boolean
   */
  public boolean isTriggered() {
    return triggered;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The viewOnly.
   *
   * @return  the viewOnly
   */
  public boolean isViewOnly() {
    return viewOnly;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Remove strategy from schedule.
   *
   * @param   strategy  strategy to remove
   *
   * @return  removed strategy
   */
  public Strategy removeStrategy(Strategy strategy) {
    for (Strategy curStrategy : this.strategies) {
      if (curStrategy.getStrategyId().equals(strategy.getStrategyId())) {
        if (this.strategies.remove(curStrategy)) {
          curStrategy.setSchedule(null);

          return curStrategy;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for context.
   *
   * @param  context  String
   */
  public void setContext(String context) {
    this.context = context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for copy from id.
   *
   * @param  copyFromId  Long
   */
  public void setCopyFromId(Long copyFromId) {
    this.copyFromId = copyFromId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for display name.
   *
   * @param  name  String
   */
  public void setDisplayName(String name) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for evaluate result.
   *
   * @param  evaluateResult  boolean
   */
  public void setEvaluateResult(boolean evaluateResult) {
    this.evaluateResult = evaluateResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event strategies.
   *
   * @param  eventStrategies  Set
   */
  public void setEventStrategies(Set<Strategy> eventStrategies) {
    this.eventStrategies = eventStrategies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event strategies count.
   *
   * @param  eventStrategiesCount  int
   */
  public void setEventStrategiesCount(int eventStrategiesCount) {
    this.eventStrategiesCount = eventStrategiesCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for general strategies.
   *
   * @param  generalStrategies  Set
   */
  public void setGeneralStrategies(Set<Strategy> generalStrategies) {
    this.generalStrategies = generalStrategies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  // private boolean republic = false;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for if event portfolio.
   *
   * @param  ifEventPortfolio  Boolean
   */
  public void setIfEventPortfolio(Boolean ifEventPortfolio) {
    this.ifEventPortfolio = ifEventPortfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for if score type portfolio.
   *
   * @param  ifScoreTypePortfolio  Boolean
   */
  public void setIfScoreTypePortfolio(Boolean ifScoreTypePortfolio) {
    this.ifScoreTypePortfolio = ifScoreTypePortfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for no date display name.
   *
   * @param  name  String
   */
  public void setNoDateDisplayName(String name) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio id.
   *
   * @param  portfolioId  Long
   */
  public void setPortfolioId(Long portfolioId) {
    this.portfolio.setPortfolioId(portfolioId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set dry run flag.
   *
   * <p>.@param preview flag</p>
   *
   * @param  dryRun  boolean
   */
  public void setPreview(boolean dryRun) {
    this.preview = dryRun;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for process end time.
   *
   * @param  processEndTime  Date
   */
  public void setProcessEndTime(Date processEndTime) {
    this.processEndTime = processEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for process start time.
   *
   * @param  processStartTime  Date
   */
  public void setProcessStartTime(Date processStartTime) {
    this.processStartTime = processStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for read only.
   *
   * @param  readOnly  boolean
   */
  public void setReadOnly(boolean readOnly) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set schedule date.
   *
   * <p>.@param scheduleDate to set</p>
   *
   * @param  scheduleDate  Date
   */
  public void setScheduleDate(Date scheduleDate) {
    this.scheduleDate = scheduleDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule id.
   *
   * @param  scheduleId  Long
   */
  public void setScheduleId(Long scheduleId) {
    this.id = scheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score card strategies.
   *
   * @param  scoreCardStrategies  Set
   */
  public void setScoreCardStrategies(Set<Strategy> scoreCardStrategies) {
    this.scoreCardStrategies = scoreCardStrategies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status string.
   *
   * @param  status  String
   */
  public void setStatusString(String status) {
    this.setScheduleStatus(ScheduleStatus.valueOf(status));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set strategies.
   *
   * @param  strategies  to set
   */
  public void setStrategies(Set<Strategy> strategies) {
    this.strategies = strategies;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for strategy master batch id.
   *
   * @param  strategyMasterBatchId  Long
   */
  public void setStrategyMasterBatchId(Long strategyMasterBatchId) {
    this.strategyMasterBatchId = strategyMasterBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for triggered.
   *
   * @param  triggered  boolean
   */
  public void setTriggered(boolean triggered) {
    this.triggered = triggered;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * view only flag.
   *
   * <p>.@param viewOnly the viewOnly to set</p>
   *
   * @param  viewOnly  boolean
   */
  public void setViewOnly(boolean viewOnly) {
    this.viewOnly = viewOnly;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Schedule");
    sb.append("{id=").append(getScheduleId());
    sb.append(", preview=").append(preview);
    sb.append(", name='").append(getName()).append('\'');
    sb.append(", description='").append(getDescription()).append('\'');
    sb.append(", portfolio=").append(portfolio);
    sb.append(", scheduleDate=").append(scheduleDate);
    sb.append(", scheduleStatus=").append(getScheduleStatus());
    sb.append(", viewOnly=").append(viewOnly);
    sb.append('}');

    return sb.toString();
  } // end method toString

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update schedule based on passed in template Only update schedule it self but not the related rules.
   *
   * @param  schedule  to use for update
   */
  public void updateSchedule(Schedule schedule) {
    this.setName(schedule.getName());
    this.setPortfolioId(schedule.getPortfolio().getPortfolioId());
    this.setDescription(schedule.getDescription());
    this.setLastUpdateDate(new Date());
    this.setLastUpdater(schedule.getLastUpdater());
    this.setScheduleStatus(schedule.getScheduleStatus());
    this.setPortfolio(schedule.getPortfolio());
    this.setActiveDate(schedule.getActiveDate());
    this.setRetireUser(schedule.getRetireUser());
    this.setRetireDate(schedule.getRetireDate());
    this.setPublishUser(schedule.getPublishUser());
    this.setPublishDate(schedule.getPublishDate());

    Date date = schedule.getScheduleDate();

    if (date != null) {
      this.scheduleDate = new Date(date.getTime());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Verify.
   *
   * @param  helper  for verify
   */
  @Override public void verify(EvaluateHelper helper) {
    if (helper == null) {
      return;
    }

    for (Strategy strategy : strategies) {
      strategy.evaluate(helper);
    }
  }
} // end class Schedule
