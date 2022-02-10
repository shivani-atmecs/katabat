package com.ozstrategy.credagility.core.domain.decisiontree.agency;

import com.cmc.credagility.core.domain.type.ScheduleStatus;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.util.DateUtil;
import com.ozstrategy.credagility.core.domain.BaseSchedule;
import com.ozstrategy.credagility.core.domain.Evaluable;
import com.ozstrategy.credagility.core.domain.Executable;
import com.ozstrategy.credagility.core.domain.RunType;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;
import org.hibernate.annotations.Where;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store AgencySchedule information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 17:12
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
public class AgencySchedule extends BaseSchedule implements Serializable, Evaluable, Executable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8513122630188027665L;

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

  /** flag for dry run. */
  @Transient protected boolean preview = false;


  /** TODO: DOCUMENT ME! */
  @Transient protected Long strategyMasterBatchId;


  /** TODO: DOCUMENT ME! */
  @Transient protected boolean triggered = false;

  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "schedule",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @Where(clause = "type = 'Event'")
  private Set<AgencyStrategy> eventStrategies = new LinkedHashSet<AgencyStrategy>();

  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "schedule",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @Where(clause = "type = 'General'")
  private Set<AgencyStrategy> generalStrategies = new LinkedHashSet<AgencyStrategy>();

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  @Transient private Date processEndTime;

  @Transient private Date processStartTime;

  /** Schedule strategies . */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "schedule",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("priority asc")
  private Set<AgencyStrategy> strategies = new LinkedHashSet<AgencyStrategy>();

  /** Flag for viewOnly. */
  @Transient private boolean viewOnly = true;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new Schedule object.
   */
  public AgencySchedule() { }

  /**
   * Creates a new AgencySchedule object.
   *
   * @param  schedule  AgencySchedule
   */
  public AgencySchedule(AgencySchedule schedule) {
    updateSchedule(schedule);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Add strategy to schedule.
   *
   * @param  strategy  to add
   */
  public void addStrategy(AgencyStrategy strategy) {
    strategy.setSchedule(this);

    // strategy.setPriority(1 + strategies.size());
    this.strategies.add(strategy);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.Executable#beforeExecute()
   */
  @Override public void beforeExecute() {
    this.triggered = false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyAllStrategy.
   *
   * @param  copyFrom  AgencySchedule
   * @param  user      User
   */
  public void copyAllStrategy(AgencySchedule copyFrom, User user) {
    for (AgencyStrategy strategy : copyFrom.getStrategies()) {
      addStrategy(strategy.duplicate(user));
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  AgencySchedule
   * @param  infoOnly  boolean
   * @param  user      User
   */
  public void deepCopy(AgencySchedule copyFrom, boolean infoOnly, User user) {
    updateSchedule(copyFrom);

    for (AgencyStrategy strategy : copyFrom.getStrategies()) {
      AgencyStrategy newStrategy = new AgencyStrategy();
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
   * @return  AgencySchedule
   */
  public AgencySchedule duplicate(User user) {
    AgencySchedule newCopy = new AgencySchedule();
    newCopy.setPreview(preview);
    newCopy.setDescription(getDescription());
    newCopy.setName(getName());
    newCopy.setScheduleDate(scheduleDate);
    newCopy.setScheduleStatus(ScheduleStatus.DRAFT);
    newCopy.setViewOnly(viewOnly);
    newCopy.setCreator(user);

    for (AgencyStrategy strategy : this.strategies) {
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
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    AgencySchedule other = (AgencySchedule) obj;

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
   * @see  com.ozstrategy.credagility.core.domain.Evaluable#evaluate(com.ozstrategy.credagility.core.helper.EvaluateHelper)
   */
  @Override public boolean evaluate(EvaluateHelper helper) {
    if (helper == null) {
      return false;
    }

    evaluateResult = false;

    if ((helper.getParameters().get("runType") != null)
          && ((RunType) helper.getParameters().get("runType")).isEvent()) {
      for (AgencyStrategy strategy : eventStrategies) {
        if ((helper.getParameters().get("eventId")).equals(strategy.getEvent().getEventId())) {
          if (strategy.evaluate(helper)) {
            evaluateResult = true;
          }
        }
      }
    } else {
      String c = getValidContext();

      for (AgencyStrategy strategy : generalStrategies) {
        if (!c.equalsIgnoreCase(strategy.getValidContext())) {
          continue;
        }

        if (strategy.evaluate(helper)) {
          evaluateResult = true;
        }
      }
    }


    return evaluateResult;
  } // end method evaluate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.Executable#execute(com.ozstrategy.credagility.core.helper.EvaluateHelper, com.ozstrategy.credagility.core.helper.ExecuteHelper)
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) {
    this.triggered = false;

    if ((evaluateHelper.getParameters().get("runType") != null)
          && ((RunType) evaluateHelper.getParameters().get("runType")).isEvent()) {
      for (AgencyStrategy strategy : eventStrategies) {
        if ((evaluateHelper.getParameters().get("eventId")).equals(strategy.getEvent().getEventId())) {
          strategy.execute(evaluateHelper, executeHelper);

          if (strategy.isTriggered()) {
            this.triggered = true;
          }
        }
      }
    } else {
      String c = getValidContext();

      for (AgencyStrategy strategy : generalStrategies) {
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

  // /**
  // * Execute account against schedule strategies.
  // *
  // * @param  domain  account to run strategies
  // */
  // public void execute(BaseDomain domain) {
  //
  // for (Strategy strategy : strategies) {
  // strategy.execute(domain);
  // }
  // }
  //
  // /**
  // * Execute account against schedule strategies.
  // *
  // * @param  domain        account to run strategies
  // * @param  evaluateOnly  only evaluate with out trigger action
  // */
  // public void execute(BaseDomain domain, boolean evaluateOnly) {
  //
  // for (Strategy strategy : strategies) {
  // strategy.execute(domain, evaluateOnly);
  // }
  // }

  /**
   * Find strategy from schedule.
   *
   * @param   strategy  to find
   *
   * @return  matched strategy
   */
  public AgencyStrategy findStrategy(AgencyStrategy strategy) {
    if (strategy == null) {
      return null;
    }

    if ((strategy.getStrategyId() != null) && (strategy.getStrategyId().longValue() != 0L)) {
      // lookup through id
      for (AgencyStrategy curStrategy : this.strategies) {
        if (curStrategy.getStrategyId().equals(strategy.getStrategyId())) {
          return curStrategy;
        }
      }

      return null;
    } else {
      // lookup through equal
      Iterator<AgencyStrategy> it = this.strategies.iterator();

      while (it.hasNext()) {
        AgencyStrategy ret = it.next();

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
  public List<AgencyNode> getAllNodes() {
    List<AgencyNode> allNodes = new ArrayList<AgencyNode>();

    for (AgencyStrategy strategy : strategies) {
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
  public Set<AgencyStrategy> getEventStrategies() {
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
  public Set<AgencyStrategy> getGeneralStrategies() {
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
   * <p>.@return strategies</p>
   *
   * @return  DOCUMENT ME!
   */

  /**
   * Get strategies.
   *
   * @return  strategies this schedule own
   */
  public Set<AgencyStrategy> getStrategies() {
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

    return "agency";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
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
   * @return  DOCUMENT ME!
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

  // @RemoteProperty
  // public boolean isRepublic() {
  // return republic;
  // }


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
  public AgencyStrategy removeStrategy(AgencyStrategy strategy) {
    for (AgencyStrategy curStrategy : this.strategies) {
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
  public void setEventStrategies(Set<AgencyStrategy> eventStrategies) {
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
  public void setGeneralStrategies(Set<AgencyStrategy> generalStrategies) {
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

  //~ ------------------------------------------------------------------------------------------------------------------

  // private boolean republic = false;

  /**
   * setter method for no date display name.
   *
   * @param  name  String
   */
  public void setNoDateDisplayName(String name) { }

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

  // public void setRepublic(boolean republic) {
  // this.republic = republic;
  // }


  /**
   * setter method for schedule date.
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

  //
  // /**
  // * Set schedule status
  // *
  // * @param scheduleStatus the scheduleStatus to set
  // */
  // public void setScheduleStatus(String scheduleStatus) {
  // if(scheduleStatus == null || scheduleStatus.trim().equals("")){
  // scheduleStatus = "DRAFT";
  // }
  //
  // this.scheduleStatus =
  // ScheduleStatus.valueOf(scheduleStatus.toUpperCase());
  // }


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
   * setter method for strategies.
   *
   * @param  strategies  Set
   */
  public void setStrategies(Set<AgencyStrategy> strategies) {
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
   * setter method for view only.
   *
   * @param  viewOnly  boolean
   */
  public void setViewOnly(boolean viewOnly) {
    this.viewOnly = viewOnly;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * startProcess.
   */
  public void startProcess() {
    if (processStartTime == null) {
      processStartTime = new Date();
    }
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
  public void updateSchedule(AgencySchedule schedule) {
    this.setName(schedule.getName());
    this.setDescription(schedule.getDescription());
    this.setLastUpdateDate(new Date());
    this.setLastUpdater(schedule.getLastUpdater());
    this.setScheduleStatus(schedule.getScheduleStatus());
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

    for (AgencyStrategy strategy : strategies) {
      strategy.evaluate(helper);
    }
  }
} // end class AgencySchedule
