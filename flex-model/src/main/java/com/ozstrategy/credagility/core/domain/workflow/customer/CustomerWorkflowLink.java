package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowLink;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  03/07/2017 17:19
 */
@Entity
@Table(
  name              = "CustomerWorkflowLink",
  uniqueConstraints = @UniqueConstraint(columnNames = { "fromId", "toId", "drivenType" })
)
public class CustomerWorkflowLink extends BasicWorkflowLink implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 8639432438336510206L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The start of this link. */
  @JoinColumn(
    name       = "fromId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowNode from;

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
  protected CustomerWorkflowNode to;

  /** The workflow which this link belong to. */
  @JoinColumn(
    name       = "workflowId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflow workflow;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  newLink  DOCUMENT ME!
   */
  public void deepCopy(CustomerWorkflowLink newLink) {
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

    CustomerWorkflowLink that = (CustomerWorkflowLink) o;

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
  @Override public CustomerWorkflowNode getFrom() {
    return from;
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowLink#getTo()
   */
  @Override public CustomerWorkflowNode getTo() {
    return to;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowLink#getWorkflow()
   */
  @Override public CustomerWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowLink#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((from != null) ? from.hashCode() : 0);
    result = (31 * result) + ((to != null) ? to.hashCode() : 0);
    result = (31 * result) + ((workflow != null) ? workflow.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  from  DOCUMENT ME!
   */
  public void setFrom(CustomerWorkflowNode from) {
    this.from = from;
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
   * @param  to  DOCUMENT ME!
   */
  public void setTo(CustomerWorkflowNode to) {
    this.to = to;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflow  DOCUMENT ME!
   */
  public void setWorkflow(CustomerWorkflow workflow) {
    this.workflow = workflow;
  }
} // end class CustomerWorkflowLink
