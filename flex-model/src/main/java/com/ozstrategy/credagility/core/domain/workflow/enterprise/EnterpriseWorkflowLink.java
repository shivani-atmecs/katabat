package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowLink;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/17/2014 11:35
 */
@Entity
@Table(
  name              = "EnterpriseWorkflowLink",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "fromId", "toId", "drivenType" }) }
)
public class EnterpriseWorkflowLink extends BasicWorkflowLink implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -1830238464394402197L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The start of this link. */
  @JoinColumn(
    name       = "fromId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowNode from;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** The end of this link. */
  @JoinColumn(
    name       = "toId",
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowNode to;

  /** The workflow which this link belong to. */
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
   * @param  newLink  $param.type$
   */
  public void deepCopy(EnterpriseWorkflowLink newLink) {
    setCriteria(newLink.getCriteria());
    setPriority(newLink.getPriority());
    setDrivenType(newLink.getDrivenType());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowLink#equals(Object)
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

    EnterpriseWorkflowLink that = (EnterpriseWorkflowLink) o;

    if (!from.equals(that.from)) {
      return false;
    }

    if (!to.equals(that.to)) {
      return false;
    }

    if (!workflow.equals(that.workflow)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowLink#getFrom()
   */
  @Override public EnterpriseWorkflowNode getFrom() {
    return from;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowLink#getTo()
   */
  @Override public EnterpriseWorkflowNode getTo() {
    return to;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowLink#getWorkflow()
   */
  @Override public EnterpriseWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + from.hashCode();
    result = (31 * result) + to.hashCode();
    result = (31 * result) + workflow.hashCode();

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setFrom.
   *
   * @param  from  $param.type$
   */
  public void setFrom(EnterpriseWorkflowNode from) {
    this.from = from;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setId.
   *
   * @param  id  $param.type$
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTo.
   *
   * @param  to  $param.type$
   */
  public void setTo(EnterpriseWorkflowNode to) {
    this.to = to;
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
} // end class EnterpriseWorkflowLink
