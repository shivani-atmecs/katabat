package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowAuditStep;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/17/2014 13:56
 */
@DiscriminatorColumn(
  name              = "category",
  discriminatorType = DiscriminatorType.STRING
)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "EnterpriseWorkflowAuditStep")
public abstract class WorkflowAuditStep extends BasicWorkflowAuditStep implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -1639959651208788576L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Category: Enterprise / Agency/ Agent. */
  @Column(
    nullable   = false,
    insertable = false,
    updatable  = false,
    length     = 10
  )
  protected String category;


  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


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
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowAuditStep",
    cascade  = CascadeType.ALL
  )
  @OrderBy("createDate asc")
  protected Set<EnterpriseWorkflowAuditTaskElement> taskElementAuditSet =
    new LinkedHashSet<EnterpriseWorkflowAuditTaskElement>();


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
    name       = "workflowAuditInstanceId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowAuditInstance workflowAuditInstance;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "workflowInstanceId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowInstance workflowInstance;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "workflowStepId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowStep workflowStep;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * createBusinessObject.
   *
   * @return  WorkflowBusinessObject
   */
  public abstract WorkflowBusinessObject createBusinessObject();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business object.
   *
   * @param  businessObject  Object
   */
  public abstract void setBusinessObject(Object businessObject);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copy.
   *
   * @param  auditStep  WorkflowAuditStep
   */
  public void copy(WorkflowAuditStep auditStep) {
    super.copy(auditStep);
    this.setCategory(auditStep.getCategory());
    this.setNode(auditStep.getNode());
    this.setWorkflow(auditStep.getWorkflow());
    this.setWorkflowAuditInstance(auditStep.getWorkflowAuditInstance());
    this.setWorkflowInstance(auditStep.getWorkflowInstance());
    this.setWorkflowStep(auditStep.getWorkflowStep());
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

    WorkflowAuditStep that = (WorkflowAuditStep) o;

    if ((category != null) ? (!category.equals(that.category)) : (that.category != null)) {
      return false;
    }

    if ((node != null) ? (!node.equals(that.node)) : (that.node != null)) {
      return false;
    }

    if ((workflow != null) ? (!workflow.equals(that.workflow)) : (that.workflow != null)) {
      return false;
    }

    if ((workflowAuditInstance != null) ? (!workflowAuditInstance.equals(that.workflowAuditInstance))
                                        : (that.workflowAuditInstance != null)) {
      return false;
    }

    if ((workflowInstance != null) ? (!workflowInstance.equals(that.workflowInstance))
                                   : (that.workflowInstance != null)) {
      return false;
    }

    if ((workflowStep != null) ? (!workflowStep.equals(that.workflowStep)) : (that.workflowStep != null)) {
      return false;
    }

    return true;
  } // end method equals

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
   * @return  EnterpriseWorkflowNode
   */
  public EnterpriseWorkflowNode getNode() {
    return node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task element audit set.
   *
   * @return  Set
   */
  public Set<EnterpriseWorkflowAuditTaskElement> getTaskElementAuditSet() {
    return taskElementAuditSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow.
   *
   * @return  EnterpriseWorkflow
   */
  public EnterpriseWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow audit instance.
   *
   * @return  WorkflowAuditInstance
   */
  public WorkflowAuditInstance getWorkflowAuditInstance() {
    return workflowAuditInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow instance.
   *
   * @return  WorkflowInstance
   */
  public WorkflowInstance getWorkflowInstance() {
    return workflowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow step.
   *
   * @return  WorkflowStep
   */
  public WorkflowStep getWorkflowStep() {
    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((category != null) ? category.hashCode() : 0);
    result = (31 * result) + ((node != null) ? node.hashCode() : 0);
    result = (31 * result) + ((workflow != null) ? workflow.hashCode() : 0);
    result = (31 * result) + ((workflowAuditInstance != null) ? workflowAuditInstance.hashCode() : 0);
    result = (31 * result) + ((workflowInstance != null) ? workflowInstance.hashCode() : 0);
    result = (31 * result) + ((workflowStep != null) ? workflowStep.hashCode() : 0);

    return result;
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
   * @param  node  EnterpriseWorkflowNode
   */
  public void setNode(EnterpriseWorkflowNode node) {
    this.node = node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task element audit set.
   *
   * @param  taskElementAuditSet  Set
   */
  public void setTaskElementAuditSet(Set<EnterpriseWorkflowAuditTaskElement> taskElementAuditSet) {
    this.taskElementAuditSet = taskElementAuditSet;
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
   * setter method for workflow audit instance.
   *
   * @param  workflowAuditInstance  WorkflowAuditInstance
   */
  public void setWorkflowAuditInstance(WorkflowAuditInstance workflowAuditInstance) {
    this.workflowAuditInstance = workflowAuditInstance;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow step.
   *
   * @param  workflowStep  WorkflowStep
   */
  public void setWorkflowStep(WorkflowStep workflowStep) {
    this.workflowStep = workflowStep;
  }
} // end class WorkflowAuditStep
