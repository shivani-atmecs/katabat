package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowProgressStep;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/17/2014 12:26
 */
@Entity
@Table(name = "EnterpriseWorkflowProgressStep")
public class EnterpriseWorkflowProgressStep extends BasicWorkflowProgressStep implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -1145321500032524654L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** The workflow which this step belong to. */
  @JoinColumn(
    name       = "workflowId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflow workflow;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  step  $param.type$
   */
  public void deepCopy(EnterpriseWorkflowProgressStep step) {
    this.setDescription(step.getDescription());
    this.setStepNumber(step.getStepNumber());
    this.setCreateDate(new Date());
    this.setLastUpdateDate(new Date());
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowProgressStep#getWorkflow()
   */
  @Override public EnterpriseWorkflow getWorkflow() {
    return workflow;
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
   * setWorkflow.
   *
   * @param  workflow  $param.type$
   */
  public void setWorkflow(EnterpriseWorkflow workflow) {
    this.workflow = workflow;
  }
} // end class EnterpriseWorkflowProgressStep
