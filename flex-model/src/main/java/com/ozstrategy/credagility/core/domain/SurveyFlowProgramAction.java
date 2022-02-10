package com.ozstrategy.credagility.core.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * Storage ProgramAction for flow .
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 15:06
 */
@Entity public class SurveyFlowProgramAction extends SurveyFlowAction<ProgramAction> {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8751567402605310455L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** node . */
  @JoinColumn(
    name       = "actionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ProgramAction action = new ProgramAction();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  SurveyFlowProgramAction
   */
  public void deepCopy(SurveyFlowProgramAction copyFrom) {
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

    SurveyFlowProgramAction that = (SurveyFlowProgramAction) o;

    if ((action != null) ? (!action.equals(that.action)) : (that.action != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action.
   *
   * @return  ProgramAction
   */
  public ProgramAction getAction() {
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
  @Override public ProgramAction getFlowAction() {
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
   * @param  action  ProgramAction
   */
  public void setAction(ProgramAction action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flowAction.
   *
   * @param  flowAction  ProgramAction
   */
  @Override public void setFlowAction(ProgramAction flowAction) {
    action = flowAction;
  }

} // end class SurveyFlowProgramAction
