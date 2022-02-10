package com.ozstrategy.credagility.core.domain;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * node channel action.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 14:49
 */
@Entity public class SurveyFlowNodeChannelAction extends SurveyFlowNodeAction<ChannelAction> {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** node action. */
  @JoinColumn(
    name       = "actionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ChannelAction action = new ChannelAction();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  SurveyFlowNodeChannelAction
   */
  public void deepCopy(SurveyFlowNodeChannelAction copyFrom) {
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

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    SurveyFlowNodeChannelAction that = (SurveyFlowNodeChannelAction) o;

    if ((action != null) ? (!action.equals(that.action)) : (that.action != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action.
   *
   * @return  ChannelAction
   */
  public ChannelAction getAction() {
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
  @Override public ChannelAction getNodeAction() {
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
   * @param  action  ChannelAction
   */
  public void setAction(ChannelAction action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  SurveyFlowNodeAction#setNodeAction(ChannelAction)
   */
  @Override public void setNodeAction(ChannelAction nodeAction) {
    action = nodeAction;
  }
} // end class SurveyFlowNodeChannelAction
