package com.ozstrategy.credagility.core.domain.workflow;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.BasicUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.workflow.basic.*;

import java.util.HashMap;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:50
 */
public abstract class WorkflowBusinessObject {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Long workflowInstanceId;
  protected User executor;

  private java.util.Map<String, Object> params = new HashMap<String, Object>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * createDocumentInstance.
   *
   * @return  BasicDocumentInstance
   */
  public abstract BasicDocumentInstance createDocumentInstance();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createDocumentMetaDataValue.
   *
   * @return  DocumentMetaDataValue
   */
  public abstract DocumentMetaDataValue createDocumentMetaDataValue();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createUploadDocumentBlob.
   *
   * @return  BasicUploadDocumentBlob
   */
  public abstract BasicUploadDocumentBlob createUploadDocumentBlob();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createWorkflowAuditInstance.
   *
   * @return  BasicWorkflowAuditInstance
   */
  public abstract BasicWorkflowAuditInstance createWorkflowAuditInstance();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createWorkflowAuditStep.
   *
   * @return  BasicWorkflowAuditStep
   */
  public abstract BasicWorkflowAuditStep createWorkflowAuditStep();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createWorkflowInstance.
   *
   * @return  BasicWorkflowInstance
   */
  public abstract BasicWorkflowInstance createWorkflowInstance();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createWorkflowSchedule.
   *
   * @return  BasicWorkflowSchedule
   */
  public abstract BasicWorkflowSchedule createWorkflowSchedule();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createWorkflowStep.
   *
   * @return  BasicWorkflowStep
   */
  public abstract BasicWorkflowStep createWorkflowStep();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createWorkflowTaskElementAnswer.
   *
   * @return  BasicWorkflowTaskElementAnswer
   */
  public abstract BasicWorkflowTaskElementAnswer createWorkflowTaskElementAnswer();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createWorkflowTaskElementTempAnswer.
   *
   * @return  BasicWorkflowTaskElementTempAnswer
   */
  public abstract BasicWorkflowTaskElementTempAnswer createWorkflowTaskElementTempAnswer();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createWorkflowVariableValue.
   *
   * @return  BasicWorkflowVariableValue
   */
  public abstract BasicWorkflowVariableValue createWorkflowVariableValue();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for object.
   *
   * @return  Object
   */
  public abstract Object getObject();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for object info.
   *
   * @return  String
   */
  public abstract String getObjectInfo();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for object.
   *
   * @param  obj  Object
   */
  public abstract void setObject(Object obj);

  //~ ------------------------------------------------------------------------------------------------------------------
  public void setExecutor(User executor) {
    this.executor = executor;
  }
  /**
   * addParam.
   *
   * @param  key    String
   * @param  value  Object
   */
  public void addParam(String key, Object value) {
    params.put(key, value);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyParam.
   *
   * @param  map  java.util.Map
   */
  public void copyParam(java.util.Map<String, Object> map) {
    params.putAll(map);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for param.
   *
   * @param   key  String
   *
   * @return  Object
   */
  public Object getParam(String key) {
    return params.get(key);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow instance id.
   *
   * @return  Long
   */
  public Long getWorkflowInstanceId() {
    return workflowInstanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow instance id.
   *
   * @param  workflowInstanceId  Long
   */
  public void setWorkflowInstanceId(Long workflowInstanceId) {
    this.workflowInstanceId = workflowInstanceId;
  }

} // end class WorkflowBusinessObject
