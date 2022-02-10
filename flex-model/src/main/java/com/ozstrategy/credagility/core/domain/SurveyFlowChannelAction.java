package com.ozstrategy.credagility.core.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * storage ChannelAction for SurveyFlow !
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 11:00
 */
@Entity public class SurveyFlowChannelAction extends SurveyFlowAction<ChannelAction> {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6475820369583140950L;

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
   * @param  copyFrom  SurveyFlowChannelAction
   */
  public void deepCopy(SurveyFlowChannelAction copyFrom) {
    super.deepCopy(copyFrom);
    setAction(copyFrom.getAction());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  SurveyFlowAction#equals(Object)
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

    SurveyFlowChannelAction that = (SurveyFlowChannelAction) o;

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
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionInterface#getActionName()
   */
  @Override public String getActionName() {
    if (this.action != null) {
      return this.action.getName();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  SurveyFlowAction#getFlowAction()
   */
  @Override public ChannelAction getFlowAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  SurveyFlowAction#hashCode()
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
   * @see  SurveyFlowAction#setFlowAction(ChannelAction)
   */
  @Override public void setFlowAction(ChannelAction flowAction) {
    action = flowAction;
  }
} // end class SurveyFlowChannelAction
