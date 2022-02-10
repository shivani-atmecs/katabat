package com.ozstrategy.credagility.core.domain.workflow;


import com.ozstrategy.credagility.core.domain.BureauImportAction;
import com.ozstrategy.credagility.core.domain.SurveyFlowAction;

import javax.persistence.*;


/**
 * Created by yongliu on 11/15/16.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  11/15/2016 16:57
 */
@Entity
@Table(name = "WorkflowBureauImportAction")
public class WorkflowBureauImportAction extends SurveyFlowAction<BureauImportAction> {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2172251680262080986L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "actionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BureauImportAction action = new BureauImportAction();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  WorkflowBureauImportAction
   */
  public void deepCopy(WorkflowBureauImportAction copyFrom) {
    super.deepCopy(copyFrom);
    setAction(copyFrom.getAction());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.SurveyFlowAction#equals(Object)
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

    WorkflowBureauImportAction that = (WorkflowBureauImportAction) o;

    return !((action != null) ? (!action.equals(that.action)) : (that.action != null));

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action.
   *
   * @return  BureauImportAction
   */
  public BureauImportAction getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  WorkflowNodeActionInterface#getActionName()
   */
  @Override public String getActionName() {
    if (this.action != null) {
      return this.action.getName();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  com.ozstrategy.credagility.core.domain.SurveyFlowAction#getFlowAction()
   */
  @Override public BureauImportAction getFlowAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  com.ozstrategy.credagility.core.domain.SurveyFlowAction#hashCode()
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
   * @param  action  BureauImportAction
   */
  public void setAction(BureauImportAction action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  com.ozstrategy.credagility.core.domain.SurveyFlowAction#setFlowAction(com.ozstrategy.credagility.core.domain.BureauImportAction)
   */
  @Override public void setFlowAction(BureauImportAction flowAction) {
    this.action = flowAction;
  }
} // end class WorkflowBureauImportAction
