package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowProgressStep;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 13-3-5 : AM10:03</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCWorkflowProgressStep")
public class BCWorkflowProgressStep extends BasicWorkflowProgressStep implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -1319879656123954585L;

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
  protected BCWorkflow workflow;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  step  DOCUMENT ME!
   */
  public void deepCopy(BCWorkflowProgressStep step) {
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
  @Override public BCWorkflow getWorkflow() {
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
   * DOCUMENT ME!
   *
   * @param  workflow  DOCUMENT ME!
   */
  public void setWorkflow(BCWorkflow workflow) {
    this.workflow = workflow;
  }
} // end class BCWorkflowProgressStep
