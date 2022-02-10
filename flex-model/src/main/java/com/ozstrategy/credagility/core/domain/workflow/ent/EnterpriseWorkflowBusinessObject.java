package com.ozstrategy.credagility.core.domain.workflow.ent;

import com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.BasicUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.enterprise.EnterpriseDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.enterprise.EnterpriseDocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.enterprise.EnterpriseUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.*;


/**
 * Enterprise Workflow BusinessObject.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 09:59
 */
public class EnterpriseWorkflowBusinessObject extends EntWorkflowBusinessObject {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * createDocumentInstance.
   *
   * @return  BasicDocumentInstance
   */
  @Override public BasicDocumentInstance createDocumentInstance() {
    return new EnterpriseDocumentInstance();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createDocumentMetaDataValue.
   *
   * @return  DocumentMetaDataValue
   */
  @Override public DocumentMetaDataValue createDocumentMetaDataValue() {
    return new EnterpriseDocumentMetaDataValue();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createUploadDocumentBlob.
   *
   * @return  BasicUploadDocumentBlob
   */
  @Override public BasicUploadDocumentBlob createUploadDocumentBlob() {
    return new EnterpriseUploadDocumentBlob();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowAuditInstance()
   */
  @Override public WorkflowAuditInstance createWorkflowAuditInstance() {
    return new EnterpriseWorkflowAuditInstance();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowAuditStep()
   */
  @Override public WorkflowAuditStep createWorkflowAuditStep() {
    return new EnterpriseWorkflowAuditStep();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowInstance()
   */
  @Override public WorkflowInstance createWorkflowInstance() {
    return new EnterpriseWorkflowInstance();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowSchedule()
   */
  @Override public WorkflowSchedule createWorkflowSchedule() {
    return new EnterpriseWorkflowSchedule();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowStep()
   */
  @Override public WorkflowStep createWorkflowStep() {
    return new EnterpriseWorkflowStep();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowTaskElementAnswer()
   */
  @Override public WorkflowTaskElementAnswer createWorkflowTaskElementAnswer() {
    return new EnterpriseWorkflowTaskElementAnswer();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowTaskElementTempAnswer()
   */
  @Override public WorkflowTaskElementTempAnswer createWorkflowTaskElementTempAnswer() {
    return new EnterpriseWorkflowTaskElementTempAnswer();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowVariableValue()
   */
  @Override public WorkflowVariableValue createWorkflowVariableValue() {
    return new EnterpriseWorkflowVariableValue();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for object.
   *
   * @return  Object
   */
  @Override public Object getObject() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for object info.
   *
   * @return  String
   */
  @Override public String getObjectInfo() {
    return "Enterprise";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for object.
   *
   * @param  obj  Object
   */
  @Override public void setObject(Object obj) { }
} // end class EnterpriseWorkflowBusinessObject
