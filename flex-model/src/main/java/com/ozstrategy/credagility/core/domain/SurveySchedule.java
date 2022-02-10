package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.type.ScheduleStatus;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store portfolio schedule information.
 *
 * <p><a href="Schedule.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 16:46
 */
@Entity
@Table(
  name    = "SurveySchedule",
  indexes = {
    @Index(
      name = "statusIndex",
      columnList = "scheduleStatus"
    )
  }
)
public class SurveySchedule extends BaseSchedule implements Evaluable, Executable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4833486708966623161L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The portfolio which schedule belong to. */
  @JoinColumn(
    name       = "portfolioId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Portfolio portfolio = new Portfolio();

  @Column(nullable = true)
  private Long copyFromId;

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;


  @Transient private Date processEndTime;

  @Transient private Date processStartTime;

  /** Schedule flows . */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "schedule"
  )
  @OrderBy("priority asc")
  private Set<SurveyFlow> surveyFlows = new LinkedHashSet<SurveyFlow>();

  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "schedule",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  private Set<WorkflowMenu> workflowMenus = new LinkedHashSet<WorkflowMenu>();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new Schedule object.
   */
  public SurveySchedule() { }

  /**
   * Creates a new Schedule object.
   *
   * @param  schedule  DOCUMENT ME!
   */
  public SurveySchedule(SurveySchedule schedule) {
    updateSchedule(schedule);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Executable#beforeExecute()
   */
  @Override public void beforeExecute() { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  SurveySchedule
   * @param  user      User
   */
  public void deepCopy(SurveySchedule copyFrom, User user) {
    updateSchedule(copyFrom);

    for (SurveyFlow flow : copyFrom.getSurveyFlows()) {
      SurveyFlow newFlow = new SurveyFlow();
      newFlow.deepCopy(flow, user);

      if (user != null) {
        newFlow.setCreator(user);
        newFlow.setLastUpdater(user);
      } else {
        newFlow.setCreator(this.getLastUpdater());
        newFlow.setLastUpdater(this.getLastUpdater());
      }

      newFlow.setLastUpdateDate(new Date());
      newFlow.setSchedule(this);
      this.getSurveyFlows().add(newFlow);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseSchedule#equals(Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    SurveySchedule other = (SurveySchedule) obj;

    if (getName() == null) {
      if (other.getName() != null) {
        return false;
      }
    } else if (!getName().equals(other.getName())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Evaluable#evaluate(com.ozstrategy.credagility.core.helper.EvaluateHelper)
   */
  @Override public boolean evaluate(EvaluateHelper helper) {
    if (helper == null) {
      return false;
    }

    return true;
  } // end method evaluate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Executable#execute(com.ozstrategy.credagility.core.helper.EvaluateHelper, com.ozstrategy.credagility.core.helper.ExecuteHelper)
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) { } // end method execute

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
   * getter method for flow by copy from id.
   *
   * @param   subFlowCopyFromId  Long
   *
   * @return  SurveyFlow
   */
  public SurveyFlow getFlowByCopyFromId(Long subFlowCopyFromId) {
    for (SurveyFlow surveyFlow : surveyFlows) {
      if (subFlowCopyFromId.equals(surveyFlow.getCopyFromId())) {
        return surveyFlow;
      }
    }

    return null;
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
   * getter method for survey flow.
   *
   * @param   name  String
   *
   * @return  SurveyFlow
   */
  public SurveyFlow getSurveyFlow(String name) {
    for (SurveyFlow surveyFlow : surveyFlows) {
      if (surveyFlow.getName().equals(name)) {
        return surveyFlow;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey flows.
   *
   * @return  Set
   */
  public Set<SurveyFlow> getSurveyFlows() {
    return surveyFlows;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow menus.
   *
   * @return  Set
   */
  public Set<WorkflowMenu> getWorkflowMenus() {
    return workflowMenus;
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
      if ((ScheduleStatus.DRAFT.equals(this.scheduleStatus) || ScheduleStatus.SCHEDULED.equals(this.scheduleStatus))
            || ScheduleStatus.ACTIVE.equals(this.scheduleStatus)) {
        // base on 05/12/2013 zhang ye said: both TAG and HotSPOT should be able to change
        // so add ScheduleStatus.ACTIVE.equals(this.scheduleStatus)
        return true;
      }
    }

    return false;
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
   * setter method for copy from id.
   *
   * @param  copyFromId  Long
   */
  public void setCopyFromId(Long copyFromId) {
    this.copyFromId = copyFromId;
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
   * setter method for survey flows.
   *
   * @param  surveyFlows  Set
   */
  public void setSurveyFlows(Set<SurveyFlow> surveyFlows) {
    this.surveyFlows = surveyFlows;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow menus.
   *
   * @param  workflowMenus  Set
   */
  public void setWorkflowMenus(Set<WorkflowMenu> workflowMenus) {
    this.workflowMenus = workflowMenus;
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
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Schedule");
    sb.append("{id=").append(getId());
    sb.append(", name='").append(getName()).append('\'');
    sb.append(", description='").append(getDescription()).append('\'');
    sb.append(", portfolio=").append(portfolio);
    sb.append(", scheduleStatus=").append(getScheduleStatus());
    sb.append('}');

    return sb.toString();
  } // end method toString

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update schedule based on passed in template Only update schedule it self but not the related rules.
   *
   * @param  schedule  to use for update
   */
  public void updateSchedule(SurveySchedule schedule) {
    this.setName(schedule.getName());
    this.setCopyFromId(schedule.getId());
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
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Evaluable#verify(com.ozstrategy.credagility.core.helper.EvaluateHelper)
   */
  @Override public void verify(EvaluateHelper helper) {
    if (helper == null) {
      return;
    }


  }
} // end class SurveySchedule
