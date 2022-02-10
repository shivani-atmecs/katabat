package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeType;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowStepStatus;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStep;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.version.EnterpriseWorkflowTaskVersion;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/17/2014 14:12
 */
@DiscriminatorColumn(
  name              = "category",
  discriminatorType = DiscriminatorType.STRING
)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(
  name    = "EnterpriseWorkflowStep",
  indexes =
    @Index(
      name = "categoryIndex",
      columnList = "category"
    )
)
public abstract class WorkflowStep extends BasicWorkflowStep implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1233049130478617382L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowStep",
    cascade  = CascadeType.ALL
  )
  @OrderBy protected Set<WorkflowAuditStep> auditSteps = new LinkedHashSet<WorkflowAuditStep>();

  /** Category : Enterprise / Agency/ Agent. */
  @Column(
    nullable   = false,
    insertable = false,
    updatable  = false,
    length     = 10
  )
  protected String category;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowStep",
    cascade  = CascadeType.ALL
  )
  protected Set<EnterpriseWorkflowStepTaskElementSnapshot> elementSnapshots =
    new LinkedHashSet<EnterpriseWorkflowStepTaskElementSnapshot>();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "mainFlowStepId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowStep mainFlowStep;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "nodeId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowNode node;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "previousStepId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowStep previousStep;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean      skipped;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "mainFlowStep",
    cascade  = CascadeType.ALL
  )
  @OrderBy("stepNumber asc")
  @Where(clause = "status != 'RETIRED'")
  protected Set<WorkflowStep> subSteps = new LinkedHashSet<WorkflowStep>();


  /** TODO: DOCUMENT ME! */
  @OneToOne(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowStep",
    cascade  = CascadeType.ALL
  )
  protected EnterpriseWorkflowStepTaskSnapshot taskSnapshot;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "taskVersionId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTaskVersion taskVersion;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "flowId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflow workflow;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "workflowInstanceId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowInstance workflowInstance;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * copy.
   *
   * @return  WorkflowStep
   */
  @Override public abstract WorkflowStep copy();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createBusinessObject.
   *
   * @return  EntWorkflowBusinessObject
   */
  public abstract EntWorkflowBusinessObject createBusinessObject();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business object.
   *
   * @param  businessObject  Object
   */
  public abstract void setBusinessObject(Object businessObject);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyWithSnapshot.
   *
   * @return  WorkflowStep
   */
  public WorkflowStep copyWithSnapshot() {
    WorkflowStep workflowStep = copy();

    if (this.getTaskSnapshot() != null) {
      EnterpriseWorkflowStepTaskSnapshot             snapshot    = this.getTaskSnapshot();
      EnterpriseWorkflowStepTaskSnapshot             newSnapshot = snapshot.copy();
      Set<EnterpriseWorkflowStepTaskElementSnapshot> elements    = getElementSnapshots();

      newSnapshot.setWorkflowStep(workflowStep);
      workflowStep.setTaskSnapshot(newSnapshot);

      for (EnterpriseWorkflowStepTaskElementSnapshot element : elements) {
        element.copy();
        element.setWorkflowStep(workflowStep);
        workflowStep.getElementSnapshots().add(element);
      }
    }

    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
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

    WorkflowStep that = (WorkflowStep) o;

    if ((mainFlowStep != null) ? (!mainFlowStep.equals(that.mainFlowStep)) : (that.mainFlowStep != null)) {
      return false;
    }

    if (!node.equals(that.node)) {
      return false;
    }

    if ((previousStep != null) ? (!previousStep.equals(that.previousStep)) : (that.previousStep != null)) {
      return false;
    }

// if ((subSteps != null) ? (!subSteps.equals(that.subSteps)) : (that.subSteps != null)) {
// return false;
// }

    if (!workflow.equals(that.workflow)) {
      return false;
    }

    if (!workflowInstance.equals(that.workflowInstance)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for audit steps.
   *
   * @return  Set
   */
  public Set<WorkflowAuditStep> getAuditSteps() {
    return auditSteps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category.
   *
   * @return  String
   */
  public String getCategory() {
    return category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for element snapshots.
   *
   * @return  Set
   */
  public Set<EnterpriseWorkflowStepTaskElementSnapshot> getElementSnapshots() {
    return elementSnapshots;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for element snapshots map.
   *
   * @return  Map
   */
  public Map<Long, EnterpriseWorkflowStepTaskElementSnapshot> getElementSnapshotsMap() {
    Map<Long, EnterpriseWorkflowStepTaskElementSnapshot> map =
      new HashMap<Long, EnterpriseWorkflowStepTaskElementSnapshot>(
        elementSnapshots.size());

    for (EnterpriseWorkflowStepTaskElementSnapshot elementSnapshot : elementSnapshots) {
      map.put(elementSnapshot.getTaskElement().getId(), elementSnapshot);
    }

    return map;
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
   * @return  WorkflowStep
   */
  @Override public WorkflowStep getMainFlowStep() {
    return mainFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next step.
   *
   * @return  WorkflowStep
   */
  public WorkflowStep getNextStep() {
    WorkflowStep      nextStep = null;
    Set<WorkflowStep> steps    = null;

    steps = this.getWorkflowInstance().getSteps();

    if (steps != null) {
      for (WorkflowStep step : steps) {
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
   * @return  EnterpriseWorkflowNode
   */
  @Override public EnterpriseWorkflowNode getNode() {
    return node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous step.
   *
   * @return  WorkflowStep
   */
  @Override public WorkflowStep getPreviousStep() {
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
   * getter method for sub steps.
   *
   * @return  Set
   */
  @Override public Set<WorkflowStep> getSubSteps() {
    return subSteps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task snapshot.
   *
   * @return  EnterpriseWorkflowStepTaskSnapshot
   */
  public EnterpriseWorkflowStepTaskSnapshot getTaskSnapshot() {
    return taskSnapshot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task version.
   *
   * @return  EnterpriseWorkflowTaskVersion
   */
  public EnterpriseWorkflowTaskVersion getTaskVersion() {
    return taskVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow.
   *
   * @return  EnterpriseWorkflow
   */
  @Override public EnterpriseWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow instance.
   *
   * @return  WorkflowInstance
   */
  @Override public WorkflowInstance getWorkflowInstance() {
    return workflowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + workflow.hashCode();
// result = (31 * result) + ((subSteps != null) ? subSteps.hashCode() : 0);
    result = (31 * result) + ((mainFlowStep != null) ? mainFlowStep.hashCode() : 0);
    result = (31 * result) + node.hashCode();
    result = (31 * result) + ((previousStep != null) ? previousStep.hashCode() : 0);
    result = (31 * result) + workflowInstance.hashCode();

    return result;
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
   * paste.
   *
   * @param  step  WorkflowStep
   */
  public void paste(WorkflowStep step) {
    super.paste(step);
    step.setWorkflow(workflow);
    step.setMainFlowStep(mainFlowStep);
    step.setNode(node);
    step.setPreviousStep(previousStep);
    step.setWorkflowInstance(workflowInstance);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for audit steps.
   *
   * @param  auditSteps  Set
   */
  public void setAuditSteps(Set<WorkflowAuditStep> auditSteps) {
    this.auditSteps = auditSteps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category.
   *
   * @param  category  String
   */
  public void setCategory(String category) {
    this.category = category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for element snapshots.
   *
   * @param  elementSnapshots  Set
   */
  public void setElementSnapshots(Set<EnterpriseWorkflowStepTaskElementSnapshot> elementSnapshots) {
    this.elementSnapshots = elementSnapshots;
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
   * @param  mainFlowStep  WorkflowStep
   */
  public void setMainFlowStep(WorkflowStep mainFlowStep) {
    this.mainFlowStep = mainFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node.
   *
   * @param  node  EnterpriseWorkflowNode
   */
  public void setNode(EnterpriseWorkflowNode node) {
    this.node = node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous step.
   *
   * @param  previousStep  WorkflowStep
   */
  public void setPreviousStep(WorkflowStep previousStep) {
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
   * setter method for sub steps.
   *
   * @param  subSteps  Set
   */
  public void setSubSteps(Set<WorkflowStep> subSteps) {
    this.subSteps = subSteps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task snapshot.
   *
   * @param  taskSnapshot  EnterpriseWorkflowStepTaskSnapshot
   */
  public void setTaskSnapshot(EnterpriseWorkflowStepTaskSnapshot taskSnapshot) {
    this.taskSnapshot = taskSnapshot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task version.
   *
   * @param  taskVersion  EnterpriseWorkflowTaskVersion
   */
  public void setTaskVersion(EnterpriseWorkflowTaskVersion taskVersion) {
    this.taskVersion = taskVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow.
   *
   * @param  workflow  EnterpriseWorkflow
   */
  public void setWorkflow(EnterpriseWorkflow workflow) {
    this.workflow = workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow instance.
   *
   * @param  workflowInstance  WorkflowInstance
   */
  public void setWorkflowInstance(WorkflowInstance workflowInstance) {
    this.workflowInstance = workflowInstance;
  }
} // end class WorkflowStep
