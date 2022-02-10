package com.ozstrategy.credagility.core.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * storage the ReQueueAction for node.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 14:56
 */
@Entity public class SurveyFlowNodeReQueueAction extends SurveyFlowNodeAction<ReQueueAction> {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7473826835550526631L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** node . */
  @JoinColumn(
    name       = "actionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ReQueueAction action = new ReQueueAction();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  SurveyFlowNodeReQueueAction
   */
  public void deepCopy(SurveyFlowNodeReQueueAction copyFrom) {
    super.deepCopy(copyFrom);
    setAction(copyFrom.getAction());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  SurveyFlowNodeAction#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof SurveyFlowNodeReQueueAction)) {
      return false;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    SurveyFlowNodeReQueueAction that = (SurveyFlowNodeReQueueAction) o;

    if ((action != null) ? (!action.equals(that.action)) : (that.action != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action.
   *
   * @return  ReQueueAction
   */
  public ReQueueAction getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  SurveyFlowNodeActionInterface#getActionName()
   */
  @Override public String getActionName() {
    if (this.action != null) {
      return this.action.getName();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  SurveyFlowNodeAction#getNodeAction()
   */
  @Override public ReQueueAction getNodeAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  SurveyFlowNodeAction#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((action != null) ? action.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action.
   *
   * @param  action  ReQueueAction
   */
  public void setAction(ReQueueAction action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for nodeAction.
   *
   * @param  nodeAction  ReQueueAction
   */
  @Override public void setNodeAction(ReQueueAction nodeAction) {
    action = nodeAction;
  }

} // end class SurveyFlowNodeReQueueAction
