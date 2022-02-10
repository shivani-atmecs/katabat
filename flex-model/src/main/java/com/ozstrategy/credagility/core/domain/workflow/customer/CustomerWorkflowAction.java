package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionInterface;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  04/10/2017 11:24
 */
@MappedSuperclass public abstract class CustomerWorkflowAction extends CreatorEntity implements Serializable,
  WorkflowNodeActionInterface {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Column(length = 2147483647)
  @Type(type = "text")
  protected String criteria;

  /** SurveyFlowNode . */
  @JoinColumn(
    name     = "flowId",
// unique   = true,
    nullable = false
  )
  @ManyToOne protected CustomerWorkflow flow = new CustomerWorkflow();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** DOCUMENT ME! */
  @Column protected Integer priority = 1;

  /** DOCUMENT ME! */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowNodeActionTriggerType triggerType = WorkflowNodeActionTriggerType.ENTRY;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  copyFrom  DOCUMENT ME!
   */
  public void deepCopy(CustomerWorkflowAction copyFrom) {
    setTriggerType(copyFrom.getTriggerType());
    setCriteria(copyFrom.getCriteria());
    setPriority(copyFrom.getPriority());
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

    CustomerWorkflowAction that = (CustomerWorkflowAction) o;

    if ((criteria != null) ? (!criteria.equals(that.criteria)) : (that.criteria != null)) {
      return false;
    }

    if ((flow != null) ? (!flow.equals(that.flow)) : (that.flow != null)) {
      return false;
    }

    if ((priority != null) ? (!priority.equals(that.priority)) : (that.priority != null)) {
      return false;
    }

    if (triggerType != that.triggerType) {
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
  @Override public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflow getFlow() {
    return flow;
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
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionInterface#getTriggerType()
   */
  @Override public WorkflowNodeActionTriggerType getTriggerType() {
    return triggerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((criteria != null) ? criteria.hashCode() : 0);
    result = (31 * result) + ((flow != null) ? flow.hashCode() : 0);
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + ((triggerType != null) ? triggerType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  criteria  DOCUMENT ME!
   */
  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flow  DOCUMENT ME!
   */
  public void setFlow(CustomerWorkflow flow) {
    this.flow = flow;
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
   * @param  priority  DOCUMENT ME!
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  triggerType  DOCUMENT ME!
   */
  public void setTriggerType(WorkflowNodeActionTriggerType triggerType) {
    this.triggerType = triggerType;
  }
} // end class CustomerWorkflowAction
