package com.ozstrategy.credagility.core.domain.workflow;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseWorkflow;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:58
 */
@DiscriminatorColumn(
  name              = "context",
  discriminatorType = DiscriminatorType.STRING
)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "WorkflowBusinessProcessAssignment")
public abstract class WorkflowBusinessProcessAssignment extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 610078175677128765L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "businessProcessId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowBusinessProcess businessProcess;

  /** Category : Enterprise / Agency/ Agent. */
  @Column(
    nullable   = false,
    insertable = false,
    updatable  = false,
    length     = 10
  )
  protected String context;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "workflowId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflow workflow;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for business process.
   *
   * @return  WorkflowBusinessProcess
   */
  public WorkflowBusinessProcess getBusinessProcess() {
    return businessProcess;
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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
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
   * setter method for business process.
   *
   * @param  businessProcess  WorkflowBusinessProcess
   */
  public void setBusinessProcess(WorkflowBusinessProcess businessProcess) {
    this.businessProcess = businessProcess;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
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
} // end class BasicWorkflowBusinessProcessAssignment
