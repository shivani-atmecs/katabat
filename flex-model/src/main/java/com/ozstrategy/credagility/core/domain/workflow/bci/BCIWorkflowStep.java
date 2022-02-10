package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeType;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowStepStatus;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStep;
import com.ozstrategy.credagility.core.domain.workflow.bci.version.BCWorkflowTaskVersion;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 11/18/13 : 12:08 PM</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCIWorkflowStep")
public class BCIWorkflowStep extends BasicWorkflowStep implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8656109308832466399L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** BCIWorkflowAuditStep PK workflowStep. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowStep",
    cascade  = { CascadeType.ALL }
  )
  @OrderBy protected Set<BCIWorkflowAuditStep> auditSteps = new LinkedHashSet<BCIWorkflowAuditStep>();

  /** BusinessContextInstance PK bciId. */
  @JoinColumn(
    name       = "bciId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContextInstance bci;

  /** BCIWorkflowStepTaskElementSnapshot PK workflowStep. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowStep",
    cascade  = { CascadeType.ALL }
  )
  protected Set<BCIWorkflowStepTaskElementSnapshot> elementSnapshots =
    new LinkedHashSet<BCIWorkflowStepTaskElementSnapshot>();

  /** set as current BCI when the workflow path back to a executed node. */
  @Column protected Long fixBciId = null;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** BCIWorkflowStep PK mainFlowStepId. */
  @JoinColumn(
    name       = "mainFlowStepId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIWorkflowStep mainFlowStep;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "nodeId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowNode node;

  /** BCIWorkflowStep PK previousStepId. */
  @JoinColumn(
    name     = "previousStepId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIWorkflowStep previousStep;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean skipped;

  /** BCIWorkflowStep. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "mainFlowStep",
    cascade  = { CascadeType.ALL }
  )
  @OrderBy("stepNumber asc")
  @Where(clause = "status != 'RETIRED'")
  protected Set<BCIWorkflowStep> subSteps = new LinkedHashSet<BCIWorkflowStep>();

  /** BCIWorkflowStepTaskSnapshot. */
  @OneToOne(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowStep",
    cascade  = { CascadeType.ALL }
  )
  protected BCIWorkflowStepTaskSnapshot taskSnapshot;

  /** BCWorkflowTaskVersion PK taskVersionId. */
  @JoinColumn(
    name      = "taskVersionId",
    nullable  = true,
    updatable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTaskVersion taskVersion;

  /** BCWorkflow PK flowId. */
  @JoinColumn(
    name       = "flowId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflow workflow;

  /** BCIWorkflowInstance PK workflowInstanceId. */
  @JoinColumn(
    name       = "workflowInstanceId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected BCIWorkflowInstance workflowInstance;

  @Transient private Map<String, BCIWorkflowTaskElementAnswer> tempAnswers =
    new HashMap<String, BCIWorkflowTaskElementAnswer>();

  @Transient private Map<String, String> updateActionResponse = new HashMap<String, String>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addTempAnswer.
   *
   * @param  name    String
   * @param  answer  BCIWorkflowTaskElementAnswer
   */
  public void addTempAnswer(String name, BCIWorkflowTaskElementAnswer answer) {
    tempAnswers.put(name, answer);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStep#copy()
   */
  @Override public BCIWorkflowStep copy() {
    BCIWorkflowStep step = new BCIWorkflowStep();
    paste(step);

    return step;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCIWorkflowStep copyWithSnapshot() {
    BCIWorkflowStep workflowStep = copy();

    if (this.getTaskSnapshot() != null) {
      BCIWorkflowStepTaskSnapshot             snapshot    = this.getTaskSnapshot();
      BCIWorkflowStepTaskSnapshot             newSnapshot = snapshot.copy();
      Set<BCIWorkflowStepTaskElementSnapshot> elements    = getElementSnapshots();

      newSnapshot.setWorkflowStep(workflowStep);
      workflowStep.setTaskSnapshot(newSnapshot);

      for (BCIWorkflowStepTaskElementSnapshot element : elements) {
        element.copy();
        element.setWorkflowStep(workflowStep);
        workflowStep.getElementSnapshots().add(element);
      }
    }

    return workflowStep;
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

    BCIWorkflowStep that = (BCIWorkflowStep) o;

    if ((bci != null) ? (!bci.equals(that.bci)) : (that.bci != null)) {
      return false;
    }

    if ((mainFlowStep != null) ? (!mainFlowStep.equals(that.mainFlowStep)) : (that.mainFlowStep != null)) {
      return false;
    }

    if ((node != null) ? (!node.equals(that.node)) : (that.node != null)) {
      return false;
    }

    if ((previousStep != null) ? (!previousStep.equals(that.previousStep)) : (that.previousStep != null)) {
      return false;
    }

    if ((workflow != null) ? (!workflow.equals(that.workflow)) : (that.workflow != null)) {
      return false;
    }

    if ((workflowInstance != null) ? (!workflowInstance.equals(that.workflowInstance))
                                   : (that.workflowInstance != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCIWorkflowAuditStep> getAuditSteps() {
    return auditSteps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BusinessContextInstance getBci() {
    return bci;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCIWorkflowStepTaskElementSnapshot> getElementSnapshots() {
    return elementSnapshots;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<Long, BCIWorkflowStepTaskElementSnapshot> getElementSnapshotsMap() {
    Map<Long, BCIWorkflowStepTaskElementSnapshot> map = new HashMap<Long, BCIWorkflowStepTaskElementSnapshot>(
        elementSnapshots.size());

    for (BCIWorkflowStepTaskElementSnapshot elementSnapshot : elementSnapshots) {
      map.put(elementSnapshot.getTaskElement().getId(), elementSnapshot);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fix bci id.
   *
   * @return  Long
   */
  public Long getFixBciId() {
    return fixBciId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStep#getMainFlowStep()
   */
  @Override public BCIWorkflowStep getMainFlowStep() {
    return mainFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCIWorkflowStep getNextStep() {
    BCIWorkflowStep      nextStep = null;
    BCIWorkflowStep      pStep    = this.getMainFlowStep();
    Set<BCIWorkflowStep> steps    = null;

    steps = this.getWorkflowInstance().getSteps();

    if (steps != null) {
      for (BCIWorkflowStep step : steps) {
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStep#getNode()
   */
  @Override public BCWorkflowNode getNode() {
    return node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStep#getPreviousStep()
   */
  @Override public BCIWorkflowStep getPreviousStep() {
    return previousStep;
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStep#getSubSteps()
   */
  @Override public Set<BCIWorkflowStep> getSubSteps() {
    return subSteps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCIWorkflowStepTaskSnapshot getTaskSnapshot() {
    return taskSnapshot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskVersion getTaskVersion() {
    return taskVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temp answer.
   *
   * @param   name  String
   *
   * @return  BCIWorkflowTaskElementAnswer
   */
  public BCIWorkflowTaskElementAnswer getTempAnswer(String name) {
    return tempAnswers.get(name);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for update action response.
   *
   * @return  Map
   */
  public Map<String, String> getUpdateActionResponse() {
    return updateActionResponse;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStep#getWorkflow()
   */
  @Override public BCWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStep#getWorkflowInstance()
   */
  @Override public BCIWorkflowInstance getWorkflowInstance() {
    return workflowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((bci != null) ? bci.hashCode() : 0);
    result = (31 * result) + ((mainFlowStep != null) ? mainFlowStep.hashCode() : 0);
    result = (31 * result) + ((node != null) ? node.hashCode() : 0);
    result = (31 * result) + ((previousStep != null) ? previousStep.hashCode() : 0);
    result = (31 * result) + ((workflow != null) ? workflow.hashCode() : 0);
    result = (31 * result) + ((workflowInstance != null) ? workflowInstance.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isEntrySubFlowStep() {
    return (subSteps != null) && !subSteps.isEmpty();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  step  DOCUMENT ME!
   */
  public void paste(BCIWorkflowStep step) {
    super.paste(step);
    step.setWorkflow(workflow);
    step.setMainFlowStep(mainFlowStep);
    step.setNode(node);
    step.setPreviousStep(previousStep);
    step.setWorkflowInstance(workflowInstance);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  auditSteps  DOCUMENT ME!
   */
  public void setAuditSteps(Set<BCIWorkflowAuditStep> auditSteps) {
    this.auditSteps = auditSteps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bci  DOCUMENT ME!
   */
  public void setBci(BusinessContextInstance bci) {
    this.bci = bci;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  elementSnapshots  DOCUMENT ME!
   */
  public void setElementSnapshots(Set<BCIWorkflowStepTaskElementSnapshot> elementSnapshots) {
    this.elementSnapshots = elementSnapshots;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fix bci id.
   *
   * @param  fixBciId  Long
   */
  public void setFixBciId(Long fixBciId) {
    this.fixBciId = fixBciId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  mainFlowStep  DOCUMENT ME!
   */
  public void setMainFlowStep(BCIWorkflowStep mainFlowStep) {
    this.mainFlowStep = mainFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  node  DOCUMENT ME!
   */
  public void setNode(BCWorkflowNode node) {
    this.node = node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  previousStep  DOCUMENT ME!
   */
  public void setPreviousStep(BCIWorkflowStep previousStep) {
    this.previousStep = previousStep;
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
   * DOCUMENT ME!
   *
   * @param  subSteps  DOCUMENT ME!
   */
  public void setSubSteps(Set<BCIWorkflowStep> subSteps) {
    this.subSteps = subSteps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskSnapshot  DOCUMENT ME!
   */
  public void setTaskSnapshot(BCIWorkflowStepTaskSnapshot taskSnapshot) {
    this.taskSnapshot = taskSnapshot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskVersion  DOCUMENT ME!
   */
  public void setTaskVersion(BCWorkflowTaskVersion taskVersion) {
    this.taskVersion = taskVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for update action response.
   *
   * @param  updateActionResponse  Map
   */
  public void setUpdateActionResponse(Map<String, String> updateActionResponse) {
    this.updateActionResponse = updateActionResponse;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflow  DOCUMENT ME!
   */
  public void setWorkflow(BCWorkflow workflow) {
    this.workflow = workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowInstance  DOCUMENT ME!
   */
  public void setWorkflowInstance(BCIWorkflowInstance workflowInstance) {
    this.workflowInstance = workflowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateActionResponse.
   *
   * @param   key  String
   *
   * @return  String
   */
  public String updateActionResponse(String key) {
    return updateActionResponse.get(key);
  }
} // end class BCIWorkflowStep
