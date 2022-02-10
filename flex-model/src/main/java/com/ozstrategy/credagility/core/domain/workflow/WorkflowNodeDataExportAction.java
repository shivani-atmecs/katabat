package com.ozstrategy.credagility.core.domain.workflow;

import com.ozstrategy.credagility.core.domain.DataExportAction;
import com.ozstrategy.credagility.core.domain.SurveyFlowNodeAction;

import javax.persistence.*;


/**
 * Created by yongliu on 2/17/17.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  02/17/2017 13:10
 */
@Entity
@Table(name = "WorkflowNodeDataExportAction")
public class WorkflowNodeDataExportAction extends SurveyFlowNodeAction<DataExportAction> {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3913812157444340435L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "actionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DataExportAction action;

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
  @Override public DataExportAction getNodeAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.SurveyFlowNodeAction#setNodeAction(com.ozstrategy.credagility.core.domain.DataExportAction)
   */
  @Override public void setNodeAction(DataExportAction nodeAction) {
    this.action = nodeAction;
  }
} // end class WorkflowNodeDataExportAction
