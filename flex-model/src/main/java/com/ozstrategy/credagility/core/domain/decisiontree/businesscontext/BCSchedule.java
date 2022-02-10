package com.ozstrategy.credagility.core.domain.decisiontree.businesscontext;

import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
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

import javax.persistence.*;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store BCSchedule information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 11:06
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
public class BCSchedule extends BaseSchedule implements Evaluable, Executable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6549906935473480536L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The businessContext which schedule belong to. */
  @JoinColumn(
    name       = "businessContextId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContext businessContext = new BusinessContext();


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
  private Set<BCStrategy> eventStrategies = new LinkedHashSet<BCStrategy>();

  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "schedule",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @Where(clause = "type = 'General'")
  private Set<BCStrategy> generalStrategies = new LinkedHashSet<BCStrategy>();

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
  private Set<BCStrategy> strategies = new LinkedHashSet<BCStrategy>();

  /** Flag for viewOnly. */
  @Transient private boolean viewOnly = true;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new Schedule object.
   */
  public BCSchedule() { }

  /**
   * Creates a new BCSchedule object.
   *
   * @param  schedule  BCSchedule
   */
  public BCSchedule(BCSchedule schedule) {
    updateSchedule(schedule);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Add strategy to schedule.
   *
   * @param  strategy  to add
   */
  public void addStrategy(BCStrategy strategy) {
    strategy.setSchedule(this);

    // strategy.setPriority(1 + strategies.size());
    this.strategies.add(strategy);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  @Override public void beforeExecute() {
    this.triggered = false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyAllStrategy.
   *
   * @param  copyFrom  BCSchedule
   * @param  user      User
   */
  public void copyAllStrategy(BCSchedule copyFrom, User user) {
    for (BCStrategy strategy : copyFrom.getStrategies()) {
      addStrategy(strategy.duplicate(user));
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  BCSchedule
   * @param  infoOnly  boolean
   * @param  user      User
   */
  public void deepCopy(BCSchedule copyFrom, boolean infoOnly, User user) {
    updateSchedule(copyFrom);

    for (BCStrategy strategy : copyFrom.getStrategies()) {
      BCStrategy newStrategy = new BCStrategy();
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
   * @return  BCSchedule
   */
  public BCSchedule duplicate(User user) {
    BCSchedule newCopy = new BCSchedule();
    newCopy.setPreview(preview);
    newCopy.setDescription(getDescription());
    newCopy.setName(getName());
    newCopy.setBusinessContext(businessContext);
    newCopy.setScheduleDate(scheduleDate);
    newCopy.setScheduleStatus(ScheduleStatus.DRAFT);
    newCopy.setViewOnly(viewOnly);
    newCopy.setCreator(user);

    for (BCStrategy strategy : this.strategies) {
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
   * @see  com.ozstrategy.credagility.core.domain.BaseSchedule#equals(Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    BCSchedule other = (BCSchedule) obj;

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
      for (BCStrategy strategy : eventStrategies) {
        if ((helper.getParameters().get("eventId")).equals(strategy.getEvent().getEventId())) {
          if (strategy.evaluate(helper)) {
            evaluateResult = true;
          }
        }
      }
    } else {
      for (BCStrategy strategy : generalStrategies) {
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
      for (BCStrategy strategy : eventStrategies) {
        if ((evaluateHelper.getParameters().get("eventId")).equals(strategy.getEvent().getEventId())) {
          strategy.execute(evaluateHelper, executeHelper);

          if (strategy.isTriggered()) {
            this.triggered = true;
          }
        }
      }
    } else {
      for (BCStrategy strategy : generalStrategies) {
        strategy.execute(evaluateHelper, executeHelper);

        if (strategy.isTriggered()) {
          this.triggered = true;
        }
      }
    } // end if-else
  }   // end method execute

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Find strategy from schedule.
   *
   * @param   strategy  to find
   *
   * @return  matched strategy
   */
  public BCStrategy findStrategy(BCStrategy strategy) {
    if (strategy == null) {
      return null;
    }

    if ((strategy.getStrategyId() != null) && (strategy.getStrategyId().longValue() != 0L)) {
      // lookup through id
      for (BCStrategy curStrategy : this.strategies) {
        if (curStrategy.getStrategyId().equals(strategy.getStrategyId())) {
          return curStrategy;
        }
      }

      return null;
    } else {
      // lookup through equal
      Iterator<BCStrategy> it = this.strategies.iterator();

      while (it.hasNext()) {
        BCStrategy ret = it.next();

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
  public List<BCNode> getAllNodes() {
    List<BCNode> allNodes = new ArrayList<BCNode>();

    for (BCStrategy strategy : strategies) {
      allNodes.addAll(strategy.getNodes());
    }

    return allNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context.
   *
   * @return  BusinessContext
   */
  public BusinessContext getBusinessContext() {
    return businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context id.
   *
   * @return  Long
   */
  public Long getBusinessContextId() {
    return (this.businessContext == null) ? null : this.businessContext.getId();
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
  public Set<BCStrategy> getEventStrategies() {
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
  public Set<BCStrategy> getGeneralStrategies() {
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
  public Set<BCStrategy> getStrategies() {
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
   * @see  com.ozstrategy.credagility.core.domain.BaseSchedule#hashCode()
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
   * @return  dry run
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
  public BCStrategy removeStrategy(BCStrategy strategy) {
    for (BCStrategy curStrategy : this.strategies) {
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
   * setter method for business context.
   *
   * @param  businessContextType  BusinessContext
   */
  public void setBusinessContext(BusinessContext businessContextType) {
    this.businessContext = businessContextType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business context id.
   *
   * @param  businessContextId  Long
   */
  public void setBusinessContextId(Long businessContextId) {
    if (this.businessContext == null) {
      this.businessContext = new BusinessContext();
    }

    this.businessContext.setId(businessContextId);
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
  public void setEventStrategies(Set<BCStrategy> eventStrategies) {
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
  public void setGeneralStrategies(Set<BCStrategy> generalStrategies) {
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
   * @param  dryRun  dryRun
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
  public void setStrategies(Set<BCStrategy> strategies) {
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
    sb.append(", businessContext=").append(businessContext);
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
  public void updateSchedule(BCSchedule schedule) {
    this.setName(schedule.getName());
    this.setDescription(schedule.getDescription());
    this.setLastUpdateDate(new Date());
    this.setLastUpdater(schedule.getLastUpdater());
    this.setScheduleStatus(schedule.getScheduleStatus());
    this.setBusinessContext(schedule.getBusinessContext());
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

    for (BCStrategy strategy : strategies) {
      strategy.evaluate(helper);
    }
  }
} // end class BCSchedule
