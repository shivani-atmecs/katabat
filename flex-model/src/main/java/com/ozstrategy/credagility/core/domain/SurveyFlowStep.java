package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.PortfolioSurveyVersion;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeType;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowStepAction;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowStepStatus;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowTriggerSource;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * SurveyFlow Step.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 15:57
 */
@Entity
@Table(
  name    = "SurveyFlowStep",
  indexes = {
    @Index(
      name = "IDX_WORKFLOWINSTANCE_STEPNUMBER",
      columnList = "surveyFlowInstanceId,stepNumber"
    ),
    @Index(
      name = "depthPathIndex",
      columnList = "depthPath,status"
    )
  }
)
public class SurveyFlowStep extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3836773607461836040L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** action. */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowStepAction action = WorkflowStepAction.ENTRY_NODE;

  /** SurveyFlow AuditStep. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "flowStep",
    cascade  = CascadeType.ALL
  )
  @OrderBy protected Set<SurveyFlowAuditStep> auditSteps = new LinkedHashSet<SurveyFlowAuditStep>();


  /** current. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean current = false;


  /** depth Name Path. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String depthNamePath;


  /** depth Path. */
  @Column protected String depthPath;

  /** The microseconds between entry date and exit date. */
  @Column(name = "duration")
  protected Long duration;

  /** element Snapshots. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "surveyFlowStep",
    cascade  = CascadeType.ALL
  )
  protected Set<SurveyflowStepTaskElementSnapshot> elementSnapshots =
    new LinkedHashSet<SurveyflowStepTaskElementSnapshot>();


  /** entry Workflow TriggerSource. */
  @Column(length = 32)
  @Enumerated(value = EnumType.STRING)
  protected WorkflowTriggerSource entryChannel;

  /** Entry date. */
  @Column(
    name      = "entryDate",
    nullable  = false,
    updatable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date entryDate;

  /** The agent who execute this task. */
  @JoinColumn(
    name       = "executorId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User executor;


  /** exit Workflow TriggerSource. */
  @Column(length = 32)
  @Enumerated(value = EnumType.STRING)
  protected WorkflowTriggerSource exitChannel;

  /** Exit date. */
  @Column(name = "exitDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date exitDate;


  /** expiration Date. */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         expirationDate;


  /** flow! */
  @JoinColumn(
    name       = "flowId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlow flow;


  /** flow Depth. */
  @Column(nullable = false)
  protected Integer flowDepth = 0;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** mainFlow Step. */
  @JoinColumn(
    name       = "mainFlowStepId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowStep mainFlowStep;


  /** name. */
  @Column(
    nullable = false,
    length   = 256
  )
  protected String name;


  /** SurveyFlow Node. */
  @JoinColumn(
    name       = "nodeId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowNode node;


  /** previous SurveyFlowStep. */
  @JoinColumn(
    name     = "previousFlowStepId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowStep previousSurveyFlowStep;


  /** responsible. */
  @JoinColumn(
    name       = "responsibleId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean skipped;


  /** SurveyFlow Step Status. */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowStepStatus status = WorkflowStepStatus.IN_PROCESS;


  /** stepNumber. */
  @Column(nullable = false)
  protected Integer stepNumber = 1;


  /** sub Steps and status not RETIRED. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "mainFlowStep",
    cascade  = CascadeType.ALL
  )
  @OrderBy("stepNumber asc")
  @Where(clause = "status != 'RETIRED'")
  protected Set<SurveyFlowStep> subSteps = new LinkedHashSet<SurveyFlowStep>();


  /** SurveyFlow Instance. */
  @JoinColumn(
    name       = "surveyFlowInstanceId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowInstance surveyFlowInstance;


  /** task Snapshot. */
  @OneToOne(
    fetch    = FetchType.LAZY,
    mappedBy = "surveyFlowStep",
    cascade  = CascadeType.ALL
  )
  protected SurveyflowStepTaskSnapshot taskSnapshot;


  /** Portfolio Survey Version. */
  @JoinColumn(name = "taskVersionId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioSurveyVersion taskVersion;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * copy.
   *
   * @return  SurveyFlowStep
   */
  public SurveyFlowStep copy() {
    SurveyFlowStep step = new SurveyFlowStep();
    step.setAction(action);
    step.setCurrent(current);
    step.setResponsible(responsible);
    step.setDuration(duration);
    step.setFlow(flow);
    step.setFlowDepth(flowDepth);
    step.setMainFlowStep(mainFlowStep);
    step.setDepthPath(depthPath);
    step.setName(name);
    step.setNode(node);
    step.setPreviousSurveyFlowStep(previousSurveyFlowStep);
    step.setSurveyFlowInstance(surveyFlowInstance);
    step.setDepthNamePath(depthNamePath);
    step.setStepNumber(stepNumber);
    step.setEntryChannel(entryChannel);

    return step;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyWithSnapshot.
   *
   * @return  SurveyFlowStep
   */
  public SurveyFlowStep copyWithSnapshot() {
    SurveyFlowStep surveyFlowStep = copy();

    if (this.getTaskSnapshot() != null) {
      SurveyflowStepTaskSnapshot             snapshot    = this.getTaskSnapshot();
      SurveyflowStepTaskSnapshot             newSnapshot = snapshot.copy();
      Set<SurveyflowStepTaskElementSnapshot> elements    = getElementSnapshots();

      newSnapshot.setSurveyFlowStep(surveyFlowStep);
      surveyFlowStep.setTaskSnapshot(newSnapshot);

      for (SurveyflowStepTaskElementSnapshot element : elements) {
        element.copy();
        element.setSurveyFlowStep(surveyFlowStep);
        surveyFlowStep.getElementSnapshots().add(element);
      }
    }

    return surveyFlowStep;
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

    SurveyFlowStep that = (SurveyFlowStep) o;

    if (action != that.action) {
      return false;
    }

    if ((current != null) ? (!current.equals(that.current)) : (that.current != null)) {
      return false;
    }

    if ((duration != null) ? (!duration.equals(that.duration)) : (that.duration != null)) {
      return false;
    }

    if (!entryDate.equals(that.entryDate)) {
      return false;
    }

    if ((executor != null) ? (!executor.equals(that.executor)) : (that.executor != null)) {
      return false;
    }

    if ((exitDate != null) ? (!exitDate.equals(that.exitDate)) : (that.exitDate != null)) {
      return false;
    }

    if (!flow.equals(that.flow)) {
      return false;
    }

    if (!flowDepth.equals(that.flowDepth)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((mainFlowStep != null) ? (!mainFlowStep.equals(that.mainFlowStep)) : (that.mainFlowStep != null)) {
      return false;
    }

    if ((depthPath != null) ? (!depthPath.equals(that.depthPath)) : (that.depthPath != null)) {
      return false;
    }

    if ((depthNamePath != null) ? (!depthNamePath.equals(that.depthNamePath)) : (that.depthNamePath != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if (!node.equals(that.node)) {
      return false;
    }

    if ((previousSurveyFlowStep != null) ? (!previousSurveyFlowStep.equals(that.previousSurveyFlowStep))
                                         : (that.previousSurveyFlowStep != null)) {
      return false;
    }

    if (!responsible.equals(that.responsible)) {
      return false;
    }

    if (status != that.status) {
      return false;
    }

    if (!stepNumber.equals(that.stepNumber)) {
      return false;
    }

    if (!surveyFlowInstance.equals(that.surveyFlowInstance)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action.
   *
   * @return  WorkflowStepAction
   */
  public WorkflowStepAction getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for audit steps.
   *
   * @return  Set
   */
  public Set<SurveyFlowAuditStep> getAuditSteps() {
    return auditSteps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current.
   *
   * @return  Boolean
   */
  public Boolean getCurrent() {
    if (current == null) {
      return Boolean.FALSE;
    }

    return current;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for depth name path.
   *
   * @return  String
   */
  public String getDepthNamePath() {
    return depthNamePath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for depth path.
   *
   * @return  String
   */
  public String getDepthPath() {
    return depthPath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for duration.
   *
   * @return  Long
   */
  public Long getDuration() {
    return duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for element snapshots.
   *
   * @return  Set
   */
  public Set<SurveyflowStepTaskElementSnapshot> getElementSnapshots() {
    return elementSnapshots;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for element snapshots map.
   *
   * @return  Map
   */
  public Map<Long, SurveyflowStepTaskElementSnapshot> getElementSnapshotsMap() {
    Map<Long, SurveyflowStepTaskElementSnapshot> map = new HashMap<Long, SurveyflowStepTaskElementSnapshot>(
        elementSnapshots.size());

    for (SurveyflowStepTaskElementSnapshot elementSnapshot : elementSnapshots) {
      map.put(elementSnapshot.getPortfolioQuestion().getId(), elementSnapshot);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for entry channel.
   *
   * @return  WorkflowTriggerSource
   */
  public WorkflowTriggerSource getEntryChannel() {
    return entryChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for entry date.
   *
   * @return  Date
   */
  public Date getEntryDate() {
    return entryDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for executor.
   *
   * @return  User
   */
  public User getExecutor() {
    return executor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for exit channel.
   *
   * @return  WorkflowTriggerSource
   */
  public WorkflowTriggerSource getExitChannel() {
    return exitChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for exit date.
   *
   * @return  Date
   */
  public Date getExitDate() {
    return exitDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for expiration date.
   *
   * @return  Date
   */
  public Date getExpirationDate() {
    return expirationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flow.
   *
   * @return  SurveyFlow
   */
  public SurveyFlow getFlow() {
    return flow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flow depth.
   *
   * @return  Integer
   */
  public Integer getFlowDepth() {
    return flowDepth;
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
   * getter method for main flow step.
   *
   * @return  SurveyFlowStep
   */
  public SurveyFlowStep getMainFlowStep() {
    return mainFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next step.
   *
   * @return  SurveyFlowStep
   */
  public SurveyFlowStep getNextStep() {
    SurveyFlowStep      nextStep = null;
    SurveyFlowStep      pStep    = this.getMainFlowStep();
    Set<SurveyFlowStep> steps    = null;

// if (pStep != null) {
// steps = pStep.getSubSteps();
// } else {
    steps = this.getSurveyFlowInstance().getSteps();
// }

    if (steps != null) {
      for (SurveyFlowStep step : steps) {
        if (WorkflowStepStatus.FINISHED.equals(step.getStatus())
              && !WorkflowNodeType.END_NODE.equals(step.getNode().getType())
              && !WorkflowNodeType.STATIC_PAGE_NODE.equals(step.getNode().getType())) {
          if (step.getStepNumber().equals(this.getStepNumber())) {
            nextStep = step;
          } else if (step.getStepNumber() > this.getStepNumber()) {
            nextStep = step;

            break;
          }
        }
      }
    }

    return nextStep;
  } // end method getNextStep

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
   * getter method for previous survey flow step.
   *
   * @return  SurveyFlowStep
   */
  public SurveyFlowStep getPreviousSurveyFlowStep() {
    return previousSurveyFlowStep;
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
   * getter method for skipped.
   *
   * @return  Boolean
   */
  public Boolean getSkipped() {
    if (skipped == null) {
      return Boolean.FALSE;
    }

    return skipped;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  WorkflowStepStatus
   */
  public WorkflowStepStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for step number.
   *
   * @return  Integer
   */
  public Integer getStepNumber() {
    return stepNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sub steps.
   *
   * @return  Set
   */
  public Set<SurveyFlowStep> getSubSteps() {
    return subSteps;
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
   * getter method for task snapshot.
   *
   * @return  SurveyflowStepTaskSnapshot
   */
  public SurveyflowStepTaskSnapshot getTaskSnapshot() {
    return taskSnapshot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task version.
   *
   * @return  PortfolioSurveyVersion
   */
  public PortfolioSurveyVersion getTaskVersion() {
    return taskVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + action.hashCode();
    result = (31 * result) + ((current != null) ? current.hashCode() : 0);
    result = (31 * result) + responsible.hashCode();
    result = (31 * result) + ((duration != null) ? duration.hashCode() : 0);
    result = (31 * result) + entryDate.hashCode();
    result = (31 * result) + ((executor != null) ? executor.hashCode() : 0);
    result = (31 * result) + ((exitDate != null) ? exitDate.hashCode() : 0);
    result = (31 * result) + flow.hashCode();
    result = (31 * result) + flowDepth.hashCode();
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((mainFlowStep != null) ? mainFlowStep.hashCode() : 0);
    result = (31 * result) + ((depthPath != null) ? depthPath.hashCode() : 0);
    result = (31 * result) + ((depthNamePath != null) ? depthNamePath.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + node.hashCode();
    result = (31 * result) + ((previousSurveyFlowStep != null) ? previousSurveyFlowStep.hashCode() : 0);
    result = (31 * result) + status.hashCode();
    result = (31 * result) + stepNumber.hashCode();
    result = (31 * result) + surveyFlowInstance.hashCode();

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for editable.
   *
   * @return  Boolean
   */
  public Boolean isEditable() {
    try {
      if (FlowRunningStatus.FINISHED.equals(this.surveyFlowInstance.getStatus())) {
        return false;
      }

      Float f = new Float(flowDepth + "." + stepNumber);

      if (f > surveyFlowInstance.getAnchor()) {
        return true;
      }
    } catch (Exception e) { }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for entry sub flow step.
   *
   * @return  boolean
   */
  public boolean isEntrySubFlowStep() {
    return (subSteps != null) && !subSteps.isEmpty();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action.
   *
   * @param  action  WorkflowStepAction
   */
  public void setAction(WorkflowStepAction action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for audit steps.
   *
   * @param  auditSteps  Set
   */
  public void setAuditSteps(Set<SurveyFlowAuditStep> auditSteps) {
    this.auditSteps = auditSteps;
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
   * setter method for depth name path.
   *
   * @param  depthNamePath  String
   */
  public void setDepthNamePath(String depthNamePath) {
    this.depthNamePath = depthNamePath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for depth path.
   *
   * @param  depthPath  String
   */
  public void setDepthPath(String depthPath) {
    this.depthPath = depthPath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for duration.
   *
   * @param  duration  Long
   */
  public void setDuration(Long duration) {
    this.duration = duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for element snapshots.
   *
   * @param  elementSnapshots  Set
   */
  public void setElementSnapshots(Set<SurveyflowStepTaskElementSnapshot> elementSnapshots) {
    this.elementSnapshots = elementSnapshots;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for entry channel.
   *
   * @param  entryChannel  WorkflowTriggerSource
   */
  public void setEntryChannel(WorkflowTriggerSource entryChannel) {
    this.entryChannel = entryChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for entry date.
   *
   * @param  entryDate  Date
   */
  public void setEntryDate(Date entryDate) {
    this.entryDate = entryDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for executor.
   *
   * @param  executor  User
   */
  public void setExecutor(User executor) {
    this.executor = executor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for exit channel.
   *
   * @param  exitChannel  WorkflowTriggerSource
   */
  public void setExitChannel(WorkflowTriggerSource exitChannel) {
    this.exitChannel = exitChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for exit date.
   *
   * @param  exitDate  Date
   */
  public void setExitDate(Date exitDate) {
    this.exitDate = exitDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for expiration date.
   *
   * @param  expirationDate  Date
   */
  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flow.
   *
   * @param  flow  SurveyFlow
   */
  public void setFlow(SurveyFlow flow) {
    this.flow = flow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flow depth.
   *
   * @param  flowDepth  Integer
   */
  public void setFlowDepth(Integer flowDepth) {
    this.flowDepth = flowDepth;
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
   * setter method for main flow step.
   *
   * @param  mainFlowStep  SurveyFlowStep
   */
  public void setMainFlowStep(SurveyFlowStep mainFlowStep) {
    this.mainFlowStep = mainFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
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
   * setter method for previous survey flow step.
   *
   * @param  previousSurveyFlowStep  SurveyFlowStep
   */
  public void setPreviousSurveyFlowStep(SurveyFlowStep previousSurveyFlowStep) {
    this.previousSurveyFlowStep = previousSurveyFlowStep;
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
   * setter method for skipped.
   *
   * @param  skipped  Boolean
   */
  public void setSkipped(Boolean skipped) {
    this.skipped = skipped;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  WorkflowStepStatus
   */
  public void setStatus(WorkflowStepStatus status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for step number.
   *
   * @param  stepNumber  Integer
   */
  public void setStepNumber(Integer stepNumber) {
    this.stepNumber = stepNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sub steps.
   *
   * @param  subSteps  Set
   */
  public void setSubSteps(Set<SurveyFlowStep> subSteps) {
    this.subSteps = subSteps;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task snapshot.
   *
   * @param  taskSnapshot  SurveyflowStepTaskSnapshot
   */
  public void setTaskSnapshot(SurveyflowStepTaskSnapshot taskSnapshot) {
    this.taskSnapshot = taskSnapshot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task version.
   *
   * @param  taskVersion  PortfolioSurveyVersion
   */
  public void setTaskVersion(PortfolioSurveyVersion taskVersion) {
    this.taskVersion = taskVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("SurveyFlowStep{");
    sb.append("current=").append(current);
    sb.append(", depthNamePath='").append(depthNamePath).append('\'');
    sb.append(", depthPath='").append(depthPath).append('\'');
    sb.append(", duration=").append(duration);
    sb.append(", entryChannel=").append(entryChannel);
    sb.append(", entryDate=").append(entryDate);
    sb.append(", executor=").append(executor);
    sb.append(", exitDate=").append(exitDate);
    sb.append(", id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", stepNumber=").append(stepNumber);
    sb.append(", expirationDate=").append(expirationDate);
    sb.append(", flowDepth=").append(flowDepth);
    sb.append('}');

    return sb.toString();
  }
} // end class SurveyFlowStep
