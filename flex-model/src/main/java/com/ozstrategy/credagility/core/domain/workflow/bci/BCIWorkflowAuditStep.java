package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowAuditStep;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 11/18/13 : 12:10 PM</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCIWorkflowAuditStep")
public class BCIWorkflowAuditStep extends BasicWorkflowAuditStep implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -204611727875473605L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** BusinessContextInstance PK bciId. */
  @JoinColumn(
    name       = "bciId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContextInstance bci;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** BCWorkflowNode PK nodeId. */
  @JoinColumn(
    name       = "nodeId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowNode node;

  /** BCIWorkflowAuditTaskElement PK workflowAuditStep. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowAuditStep",
    cascade  = { CascadeType.ALL }
  )
  @OrderBy("createDate asc")
  protected Set<BCIWorkflowAuditTaskElement> taskElementAuditSet = new LinkedHashSet<BCIWorkflowAuditTaskElement>();

  /** BCWorkflow PK flowId. */
  @JoinColumn(
    name       = "flowId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflow workflow;

  /** BCIWorkflowAuditInstance PK workflowAuditInstanceId. */
  @JoinColumn(
    name       = "workflowAuditInstanceId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIWorkflowAuditInstance workflowAuditInstance;

  /** BCIWorkflowInstance PK workflowInstanceId. */
  @JoinColumn(
    name       = "workflowInstanceId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIWorkflowInstance workflowInstance;

  /** BCIWorkflowStep PK workflowStepId. */
  @JoinColumn(
    name     = "workflowStepId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIWorkflowStep workflowStep;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  auditStep  DOCUMENT ME!
   */
  public void copy(BCIWorkflowAuditStep auditStep) {
    super.copy(auditStep);
    this.setNode(auditStep.getNode());
    this.setWorkflow(auditStep.getWorkflow());
    this.setWorkflowAuditInstance(auditStep.getWorkflowAuditInstance());
    this.setWorkflowInstance(auditStep.getWorkflowInstance());
    this.setWorkflowStep(auditStep.getWorkflowStep());
    this.setBci(auditStep.getBci());
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

    BCIWorkflowAuditStep that = (BCIWorkflowAuditStep) o;

    if ((bci != null) ? (!bci.equals(that.bci)) : (that.bci != null)) {
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
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowNode getNode() {
    return node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCIWorkflowAuditTaskElement> getTaskElementAuditSet() {
    return taskElementAuditSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCIWorkflowAuditInstance getWorkflowAuditInstance() {
    return workflowAuditInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCIWorkflowInstance getWorkflowInstance() {
    return workflowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCIWorkflowStep getWorkflowStep() {
    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((bci != null) ? bci.hashCode() : 0);
    result = (31 * result) + ((node != null) ? node.hashCode() : 0);
    result = (31 * result) + ((workflow != null) ? workflow.hashCode() : 0);
    result = (31 * result) + ((workflowAuditInstance != null) ? workflowAuditInstance.hashCode() : 0);
    result = (31 * result) + ((workflowInstance != null) ? workflowInstance.hashCode() : 0);
    result = (31 * result) + ((workflowStep != null) ? workflowStep.hashCode() : 0);

    return result;
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
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
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
   * @param  taskElementAuditSet  DOCUMENT ME!
   */
  public void setTaskElementAuditSet(Set<BCIWorkflowAuditTaskElement> taskElementAuditSet) {
    this.taskElementAuditSet = taskElementAuditSet;
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
   * @param  workflowAuditInstance  DOCUMENT ME!
   */
  public void setWorkflowAuditInstance(BCIWorkflowAuditInstance workflowAuditInstance) {
    this.workflowAuditInstance = workflowAuditInstance;
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
   * DOCUMENT ME!
   *
   * @param  workflowStep  DOCUMENT ME!
   */
  public void setWorkflowStep(BCIWorkflowStep workflowStep) {
    this.workflowStep = workflowStep;
  }
} // end class BCIWorkflowAuditStep
