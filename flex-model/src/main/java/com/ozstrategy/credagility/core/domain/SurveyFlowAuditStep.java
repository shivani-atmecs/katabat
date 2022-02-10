package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowAuditStepStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * SurveyFlow Audit Step.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 11:07
 */
@Entity @Table public class SurveyFlowAuditStep extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5418051376434663921L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account! */
  @JoinColumn(
    name       = "accountNum",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** The agent who audit this task. */
  @JoinColumn(
    name       = "auditorId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User auditor;

  /** if all elements audit finding in this step are not Not Assessed then true, else false. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean finished;

  /** SurveyFlow Step. */
  @JoinColumn(
    name     = "flowStepId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowStep flowStep;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** SurveyFlow Node. */
  @JoinColumn(
    name       = "nodeId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowNode node;

  /** This step contain audit result for question. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "surveyFlowAuditStep",
    cascade  = CascadeType.ALL
  )
  @OrderBy("createDate asc")
  protected Set<SurveyFlowAuditQuestion> questionAuditSet = new LinkedHashSet<SurveyFlowAuditQuestion>();

  /** is remediate. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean remediate;

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

  /** Workflow AuditStep Status. */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowAuditStepStatus status = WorkflowAuditStepStatus.IN_PROCESS;

  /** SurveyFlow. */
  @JoinColumn(
    name       = "flowId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlow surveyFlow;

  /** SurveyFlow Audit Instance. */
  @JoinColumn(
    name       = "surveyFlowAuditInstanceId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowAuditInstance surveyFlowAuditInstance;

  /** SurveyFlow Instance. */
  @JoinColumn(
    name       = "surveyFlowInstanceId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowInstance surveyFlowInstance;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * copy.
   *
   * @param  auditStep  SurveyFlowAuditStep
   */
  public void copy(SurveyFlowAuditStep auditStep) {
    this.setStatus(auditStep.getStatus());
    this.setFinished(auditStep.getFinished());
    this.setCreator(auditStep.getCreator());
    this.setCreateDate(auditStep.getCreateDate());
    this.setNode(auditStep.getNode());
    this.setRemediate(auditStep.getRemediate());
    this.setRemediateDate(auditStep.getRemediateDate());
    this.setSurveyFlow(auditStep.getSurveyFlow());
    this.setSurveyFlowAuditInstance(auditStep.getSurveyFlowAuditInstance());
    this.setSurveyFlowInstance(auditStep.getSurveyFlowInstance());
    this.setFlowStep(auditStep.getFlowStep());
    this.setAuditor(auditStep.getAuditor());
    this.setAccount(auditStep.getAccount());
    this.setResponsible(auditStep.getResponsible());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    SurveyFlowAuditStep that = (SurveyFlowAuditStep) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((auditor != null) ? (!auditor.equals(that.auditor)) : (that.auditor != null)) {
      return false;
    }

    if ((flowStep != null) ? (!flowStep.equals(that.flowStep)) : (that.flowStep != null)) {
      return false;
    }

    if ((node != null) ? (!node.equals(that.node)) : (that.node != null)) {
      return false;
    }

    if ((status != null) ? (!status.equals(that.status)) : (that.status != null)) {
      return false;
    }

    if ((responsible != null) ? (!responsible.equals(that.responsible)) : (that.responsible != null)) {
      return false;
    }

    if ((surveyFlow != null) ? (!surveyFlow.equals(that.surveyFlow)) : (that.surveyFlow != null)) {
      return false;
    }

    if ((surveyFlowAuditInstance != null) ? (!surveyFlowAuditInstance.equals(that.surveyFlowAuditInstance))
                                          : (that.surveyFlowAuditInstance != null)) {
      return false;
    }

    if ((surveyFlowInstance != null) ? (!surveyFlowInstance.equals(that.surveyFlowInstance))
                                     : (that.surveyFlowInstance != null)) {
      return false;
    }

    if ((finished != null) ? (!finished.equals(that.finished)) : (that.finished != null)) {
      return false;
    }

    if ((remediate != null) ? (!remediate.equals(that.remediate)) : (that.remediate != null)) {
      return false;
    }

    if ((remediateDate != null) ? (!remediateDate.equals(that.remediateDate)) : (that.remediateDate != null)) {
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
   * getter method for auditor.
   *
   * @return  User
   */
  public User getAuditor() {
    return auditor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for finished.
   *
   * @return  Boolean
   */
  public Boolean getFinished() {
    return finished;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flow step.
   *
   * @return  SurveyFlowStep
   */
  public SurveyFlowStep getFlowStep() {
    return flowStep;
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
   * getter method for node.
   *
   * @return  SurveyFlowNode
   */
  public SurveyFlowNode getNode() {
    return node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for question audit set.
   *
   * @return  Set
   */
  public Set<SurveyFlowAuditQuestion> getQuestionAuditSet() {
    return questionAuditSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for remediate.
   *
   * @return  Boolean
   */
  public Boolean getRemediate() {
    return remediate;
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
   * getter method for status.
   *
   * @return  WorkflowAuditStepStatus
   */
  public WorkflowAuditStepStatus getStatus() {
    return status;
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
   * getter method for survey flow audit instance.
   *
   * @return  SurveyFlowAuditInstance
   */
  public SurveyFlowAuditInstance getSurveyFlowAuditInstance() {
    return surveyFlowAuditInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey flow instance.
   *
   * @return  SurveyFlowInstance
   */
  public SurveyFlowInstance getSurveyFlowInstance() {
    return surveyFlowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((auditor != null) ? auditor.hashCode() : 0);
    result = (31 * result) + ((flowStep != null) ? flowStep.hashCode() : 0);
    result = (31 * result) + ((node != null) ? node.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);
    result = (31 * result) + ((status != null) ? status.hashCode() : 0);
    result = (31 * result) + ((surveyFlow != null) ? surveyFlow.hashCode() : 0);
    result = (31 * result) + ((surveyFlowAuditInstance != null) ? surveyFlowAuditInstance.hashCode() : 0);
    result = (31 * result) + ((surveyFlowInstance != null) ? surveyFlowInstance.hashCode() : 0);
    result = (31 * result) + ((finished != null) ? finished.hashCode() : 0);
    result = (31 * result) + ((remediate != null) ? remediate.hashCode() : 0);
    result = (31 * result) + ((remediateDate != null) ? remediateDate.hashCode() : 0);

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
   * setter method for auditor.
   *
   * @param  auditor  User
   */
  public void setAuditor(User auditor) {
    this.auditor = auditor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for finished.
   *
   * @param  finished  Boolean
   */
  public void setFinished(Boolean finished) {
    this.finished = finished;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flow step.
   *
   * @param  flowStep  SurveyFlowStep
   */
  public void setFlowStep(SurveyFlowStep flowStep) {
    this.flowStep = flowStep;
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
   * setter method for node.
   *
   * @param  node  SurveyFlowNode
   */
  public void setNode(SurveyFlowNode node) {
    this.node = node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for question audit set.
   *
   * @param  questionAuditSet  Set
   */
  public void setQuestionAuditSet(Set<SurveyFlowAuditQuestion> questionAuditSet) {
    this.questionAuditSet = questionAuditSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for remediate.
   *
   * @param  remediate  Boolean
   */
  public void setRemediate(Boolean remediate) {
    this.remediate = remediate;
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
   * setter method for status.
   *
   * @param  status  WorkflowAuditStepStatus
   */
  public void setStatus(WorkflowAuditStepStatus status) {
    this.status = status;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey flow audit instance.
   *
   * @param  surveyFlowAuditInstance  SurveyFlowAuditInstance
   */
  public void setSurveyFlowAuditInstance(SurveyFlowAuditInstance surveyFlowAuditInstance) {
    this.surveyFlowAuditInstance = surveyFlowAuditInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey flow instance.
   *
   * @param  surveyFlowInstance  SurveyFlowInstance
   */
  public void setSurveyFlowInstance(SurveyFlowInstance surveyFlowInstance) {
    this.surveyFlowInstance = surveyFlowInstance;
  }
} // end class SurveyFlowAuditStep
