package com.ozstrategy.credagility.core.domain.workflow;

import com.ozstrategy.credagility.core.domain.DataExportAction;
import com.ozstrategy.credagility.core.domain.SurveyFlowAction;

import javax.persistence.*;


/**
 * Created by yongliu on 2/17/17.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  02/17/2017 13:05
 */
@Entity
@Table(name = "WorkflowDataExportAction")
public class WorkflowDataExportAction extends SurveyFlowAction<DataExportAction> {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 150556465216933972L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "actionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DataExportAction action = new DataExportAction();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  WorkflowNodeActionInterface#getActionName()
   */
  @Override public String getActionName() {
    return (action != null) ? action.getName() : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.SurveyFlowAction#getFlowAction()
   */
  @Override public DataExportAction getFlowAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.SurveyFlowAction#setFlowAction(com.ozstrategy.credagility.core.domain.DataExportAction)
   */
  @Override public void setFlowAction(DataExportAction flowAction) {
    this.action = flowAction;
  }
} // end class WorkflowDataExportAction
