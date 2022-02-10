package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowAuditStatus;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowAuditStepStatus;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowRunningStatus;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


/**
 * SurveyFlow Audit Instance.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 10:40
 */
@Entity
@Table(name = "SurveyFlowAuditInstance")
public class SurveyFlowAuditInstance extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1268030032979455851L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account. */
  @JoinColumn(
    name       = "accountNum",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** audit Status :pass or fail. */
  @Column(
    length   = 32,
    nullable = true
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowAuditStatus auditStatus;

  /** The agent who cancel this flow. */
  @JoinColumn(name = "cancelBy")
  @ManyToOne(fetch = FetchType.LAZY)
  protected User cancelBy;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** is remediated. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean remediated;


  /** remediate Date. */
  @Temporal(TemporalType.TIMESTAMP)
  protected Date remediateDate;


  /** responsible. */
  @JoinColumn(
    name       = "responsibleId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** The agent who start this flow. */
  @JoinColumn(
    name       = "starterId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User starter;


  /** Workflow Status. */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowRunningStatus status = WorkflowRunningStatus.IN_PROCESS;


  /** SurveyFlow Audit Step not contain RETIRED. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "surveyFlowAuditInstance"
  )
  @OrderBy("createDate asc")
  @Where(clause = "status != 'RETIRED'")
  protected Set<SurveyFlowAuditStep> steps = new LinkedHashSet<SurveyFlowAuditStep>();


  /** All SurveyFlow Audit Step. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "surveyFlowAuditInstance",
    cascade  = CascadeType.ALL
  )
  @OrderBy("createDate desc")
  protected Set<SurveyFlowAuditStep> stepSet = new LinkedHashSet<SurveyFlowAuditStep>();


  /** audit which surveyFlow. */
  @JoinColumn(
    name       = "workflowId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlow surveyFlow;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    SurveyFlowAuditInstance that = (SurveyFlowAuditInstance) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((cancelBy != null) ? (!cancelBy.equals(that.cancelBy)) : (that.cancelBy != null)) {
      return false;
    }

    if ((responsible != null) ? (!responsible.equals(that.responsible)) : (that.responsible != null)) {
      return false;
    }

    if ((starter != null) ? (!starter.equals(that.starter)) : (that.starter != null)) {
      return false;
    }

    if (status != that.status) {
      return false;
    }

    if ((surveyFlow != null) ? (!surveyFlow.equals(that.surveyFlow)) : (that.surveyFlow != null)) {
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
   * getter method for audit status.
   *
   * @return  WorkflowAuditStatus
   */
  public WorkflowAuditStatus getAuditStatus() {
    return auditStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cancel by.
   *
   * @return  User
   */
  public User getCancelBy() {
    return cancelBy;
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
   * getter method for last audit step.
   *
   * @return  SurveyFlowAuditStep
   */
  public SurveyFlowAuditStep getLastAuditStep() {
    SurveyFlowAuditStep       auditStep = null;
    List<SurveyFlowAuditStep> stepList  = new ArrayList<SurveyFlowAuditStep>();
    stepList.addAll(steps);

    if (!steps.isEmpty()) {
      Collections.sort(stepList, new Comparator<SurveyFlowAuditStep>() {
          @Override public int compare(SurveyFlowAuditStep o1, SurveyFlowAuditStep o2) {
            if ((o1.getFlowStep() == null) && (o1.getFlowStep().getStepNumber() != null)) {
              return 1;
            } else if ((o2.getFlowStep() == null) && (o2.getFlowStep().getStepNumber() != null)) {
              return -1;
            } else {
              return o1.getFlowStep().getStepNumber().compareTo(o2.getFlowStep().getStepNumber());
            }
          }
        });
    }

    if ((stepList != null) && !stepList.isEmpty()) {
      for (SurveyFlowAuditStep step : stepList) {
        if (WorkflowAuditStepStatus.FINISHED.equals(step.getStatus())
              || WorkflowAuditStepStatus.IN_PROCESS.equals(step.getStatus())) {
          auditStep = step;
        }
      }
    }

    return auditStep;
  } // end method getLastAuditStep

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for remediated.
   *
   * @return  Boolean
   */
  public Boolean getRemediated() {
    return remediated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for remediate date.
   *
   * @return  Date
   */
  public Date getRemediateDate() {
    return remediateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for starter.
   *
   * @return  User
   */
  public User getStarter() {
    return starter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  WorkflowRunningStatus
   */
  public WorkflowRunningStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for steps.
   *
   * @return  Set
   */
  public Set<SurveyFlowAuditStep> getSteps() {
    return steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for step set.
   *
   * @return  Set
   */
  public Set<SurveyFlowAuditStep> getStepSet() {
    return stepSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey flow.
   *
   * @return  SurveyFlow
   */
  public SurveyFlow getSurveyFlow() {
    return surveyFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((cancelBy != null) ? cancelBy.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);
    result = (31 * result) + ((starter != null) ? starter.hashCode() : 0);
    result = (31 * result) + ((status != null) ? status.hashCode() : 0);
    result = (31 * result) + ((surveyFlow != null) ? surveyFlow.hashCode() : 0);

    return result;
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
   * setter method for audit status.
   *
   * @param  auditStatus  WorkflowAuditStatus
   */
  public void setAuditStatus(WorkflowAuditStatus auditStatus) {
    this.auditStatus = auditStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cancel by.
   *
   * @param  cancelBy  User
   */
  public void setCancelBy(User cancelBy) {
    this.cancelBy = cancelBy;
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
   * setter method for remediated.
   *
   * @param  remediated  Boolean
   */
  public void setRemediated(Boolean remediated) {
    this.remediated = remediated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for remediate date.
   *
   * @param  remediateDate  Date
   */
  public void setRemediateDate(Date remediateDate) {
    this.remediateDate = remediateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for starter.
   *
   * @param  starter  User
   */
  public void setStarter(User starter) {
    this.starter = starter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  WorkflowRunningStatus
   */
  public void setStatus(WorkflowRunningStatus status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for steps.
   *
   * @param  steps  Set
   */
  public void setSteps(Set<SurveyFlowAuditStep> steps) {
    this.steps = steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for step set.
   *
   * @param  stepSet  Set
   */
  public void setStepSet(Set<SurveyFlowAuditStep> stepSet) {
    this.stepSet = stepSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey flow.
   *
   * @param  surveyFlow  SurveyFlow
   */
  public void setSurveyFlow(SurveyFlow surveyFlow) {
    this.surveyFlow = surveyFlow;
  }
} // end class SurveyFlowAuditInstance
