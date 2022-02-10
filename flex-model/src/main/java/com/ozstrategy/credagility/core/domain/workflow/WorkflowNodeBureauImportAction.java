package com.ozstrategy.credagility.core.domain.workflow;


import com.ozstrategy.credagility.core.domain.BureauImportAction;
import com.ozstrategy.credagility.core.domain.SurveyFlowNodeAction;

import javax.persistence.*;


/**
 * Created by yongliu on 11/4/16.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  11/04/2016 15:58
 */
@Entity
@Table(name = "WorkflowNodeBureauImportAction")
public class WorkflowNodeBureauImportAction extends SurveyFlowNodeAction<BureauImportAction> {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6782820438798432860L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "actionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BureauImportAction action;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.SurveyFlowNodeActionInterface#getActionName()
   */
  @Override public String getActionName() {
    return (action != null) ? action.getName() : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.SurveyFlowNodeAction#getNodeAction()
   */
  @Override public BureauImportAction getNodeAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.SurveyFlowNodeAction#setNodeAction(com.ozstrategy.credagility.core.domain.BureauImportAction)
   */
  @Override public void setNodeAction(BureauImportAction bureauImportAction) {
    this.action = bureauImportAction;
  }
} // end class WorkflowNodeBureauImportAction
