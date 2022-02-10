package com.ozstrategy.credagility.core.domain.workflow;

import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.BCIStatusAction;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCWorkflow;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  07/25/2015 17:45
 */
@Entity @Table public class BCIWorkflowStatusAction extends CreatorEntity implements Serializable,
  WorkflowNodeActionInterface {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 5877547592879711548L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String criteria;

  /** node . */
  @JoinColumn(
    name       = "flowId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflow flow = new BCWorkflow();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** node . */
  @JoinColumn(
    name       = "statusActionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIStatusAction statusAction = new BCIStatusAction();


  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowNodeActionTriggerType triggerType = WorkflowNodeActionTriggerType.ENTRY;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  $param.type$
   */
  public void deepCopy(BCIWorkflowStatusAction copyFrom) {
    setCriteria(copyFrom.getCriteria());
    setStatusAction(copyFrom.getStatusAction());
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

    BCIWorkflowStatusAction that = (BCIWorkflowStatusAction) o;

    if ((criteria != null) ? (!criteria.equals(that.criteria)) : (that.criteria != null)) {
      return false;
    }

    if (!flow.equals(that.flow)) {
      return false;
    }

    if (triggerType != that.triggerType) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((statusAction != null) ? (!statusAction.equals(that.statusAction)) : (that.statusAction != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  WorkflowNodeActionInterface#getActionName()
   */
  @Override public String getActionName() {
    if ((this.statusAction != null) && (this.statusAction.getStatusDetail() != null)) {
      return this.statusAction.getStatusDetail().getStatusCode() + ":"
        + this.statusAction.getStatusDetail().getDescription();
    } else if (this.statusAction != null) {
      return this.statusAction.getName();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  @Override public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BCWorkflow.
   *
   * @return  BCWorkflow.
   */
  public BCWorkflow getFlow() {
    return flow;
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
   * BCIStatusAction.
   *
   * @return  BCIStatusAction.
   */
  public BCIStatusAction getStatusAction() {
    return statusAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * WorkflowNodeActionTriggerType.
   *
   * @return  WorkflowNodeActionTriggerType.
   */
  @Override public WorkflowNodeActionTriggerType getTriggerType() {
    return triggerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((criteria != null) ? criteria.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + flow.hashCode();
    result = (31 * result) + triggerType.hashCode();

    result = (31 * result) + ((statusAction != null) ? statusAction.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setCriteria.
   *
   * @param  criteria  $param.type$
   */
  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setFlow.
   *
   * @param  flow  $param.type$
   */
  public void setFlow(BCWorkflow flow) {
    this.flow = flow;
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
   * setStatusAction.
   *
   * @param  statusAction  $param.type$
   */
  public void setStatusAction(BCIStatusAction statusAction) {
    this.statusAction = statusAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTriggerType.
   *
   * @param  triggerType  $param.type$
   */
  public void setTriggerType(WorkflowNodeActionTriggerType triggerType) {
    this.triggerType = triggerType;
  }
} // end class BCIWorkflowStatusAction
