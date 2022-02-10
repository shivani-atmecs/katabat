package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowInstance;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/17/2014 13:58
 */
@DiscriminatorColumn(
  name              = "category",
  discriminatorType = DiscriminatorType.STRING
)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "EnterpriseWorkflowInstance")
public abstract class WorkflowInstance extends BasicWorkflowInstance<WorkflowStep> implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3203678187361165083L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "auditInstanceId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowAuditInstance auditInstance;

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
    mappedBy = "workflowInstance"
  )
  @OrderBy("stepNumber asc")
  @Where(clause = "current = 'Y'")
  protected Set<WorkflowStep> currentStepSet = new LinkedHashSet<WorkflowStep>();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "previousAuditInstanceId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowAuditInstance previousAuditInstance;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowInstance"
  )
  @OrderBy("stepNumber asc")
  @Where(clause = "status != 'RETIRED'")
  protected Set<WorkflowStep> steps = new LinkedHashSet<WorkflowStep>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowInstance",
    cascade  = CascadeType.ALL
  )
  @OrderBy("stepNumber asc")
  protected Set<WorkflowStep> stepSet = new LinkedHashSet<WorkflowStep>();

  /** The triggerWorkflowInstance which trigger this flow. See Flow Action */
  @JoinColumn(
    name       = "triggerWorkflowInstanceId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowInstance triggerWorkflowInstance;

  /** The triggerWorkflowStep which trigger this flow. See Flow Action */
  @JoinColumn(
    name       = "triggerWorkflowStepId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowStep triggerWorkflowStep;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "workflowId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflow workflow;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * setter method for business object.
   *
   * @param  businessObject  Object
   */
  public abstract void setBusinessObject(Object businessObject);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for audit instance.
   *
   * @return  WorkflowAuditInstance
   */
  public WorkflowAuditInstance getAuditInstance() {
    return auditInstance;
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
   * getter method for current step set.
   *
   * @return  Set
   */
  @Override public Set<WorkflowStep> getCurrentStepSet() {
    return currentStepSet;
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
   * getter method for previous audit instance.
   *
   * @return  WorkflowAuditInstance
   */
  public WorkflowAuditInstance getPreviousAuditInstance() {
    return previousAuditInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for steps.
   *
   * @return  Set
   */
  @Override public Set<WorkflowStep> getSteps() {
    return steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for step set.
   *
   * @return  Set
   */
  @Override public Set<WorkflowStep> getStepSet() {
    return stepSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trigger workflow instance.
   *
   * @return  WorkflowInstance
   */
  public WorkflowInstance getTriggerWorkflowInstance() {
    return triggerWorkflowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trigger workflow step.
   *
   * @return  WorkflowStep
   */
  public WorkflowStep getTriggerWorkflowStep() {
    return triggerWorkflowStep;
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
   * setter method for audit instance.
   *
   * @param  auditInstance  WorkflowAuditInstance
   */
  public void setAuditInstance(WorkflowAuditInstance auditInstance) {
    this.auditInstance = auditInstance;
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
   * setter method for current step set.
   *
   * @param  currentStepSet  Set
   */
  public void setCurrentStepSet(Set<WorkflowStep> currentStepSet) {
    this.currentStepSet = currentStepSet;
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
   * setter method for previous audit instance.
   *
   * @param  previousAuditInstance  WorkflowAuditInstance
   */
  public void setPreviousAuditInstance(WorkflowAuditInstance previousAuditInstance) {
    this.previousAuditInstance = previousAuditInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for steps.
   *
   * @param  steps  Set
   */
  public void setSteps(Set<WorkflowStep> steps) {
    this.steps = steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for step set.
   *
   * @param  stepSet  Set
   */
  public void setStepSet(Set<WorkflowStep> stepSet) {
    this.stepSet = stepSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trigger workflow instance.
   *
   * @param  triggerWorkflowInstance  WorkflowInstance
   */
  public void setTriggerWorkflowInstance(WorkflowInstance triggerWorkflowInstance) {
    this.triggerWorkflowInstance = triggerWorkflowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trigger workflow step.
   *
   * @param  triggerWorkflowStep  WorkflowStep
   */
  public void setTriggerWorkflowStep(WorkflowStep triggerWorkflowStep) {
    this.triggerWorkflowStep = triggerWorkflowStep;
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
} // end class WorkflowInstance
