package com.ozstrategy.credagility.core.domain.workflow.responsible;

import com.cmc.credagility.core.domain.responsible.Responsible;
import com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.BasicUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.*;


/**
 * Responsible Workflow BusinessObject.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 10:23
 */
public class ResponsibleWorkflowBusinessObject extends WorkflowBusinessObject {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Responsible responsible;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createDocumentInstance()
   */
  @Override public BasicDocumentInstance createDocumentInstance() {
    return null; // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createDocumentMetaDataValue()
   */
  @Override public DocumentMetaDataValue createDocumentMetaDataValue() {
    return null; // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createUploadDocumentBlob()
   */
  @Override public BasicUploadDocumentBlob createUploadDocumentBlob() {
    return null; // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowAuditInstance()
   */
  @Override public WorkflowAuditInstance createWorkflowAuditInstance() {
    return null; // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowAuditStep()
   */
  @Override public WorkflowAuditStep createWorkflowAuditStep() {
    return null; // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowInstance()
   */
  @Override public WorkflowInstance createWorkflowInstance() {
    return null; // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowSchedule()
   */
  @Override public WorkflowSchedule createWorkflowSchedule() {
    return null; // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowStep()
   */
  @Override public WorkflowStep createWorkflowStep() {
    return null; // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowTaskElementAnswer()
   */
  @Override public WorkflowTaskElementAnswer createWorkflowTaskElementAnswer() {
    return null; // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowTaskElementTempAnswer()
   */
  @Override public WorkflowTaskElementTempAnswer createWorkflowTaskElementTempAnswer() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowVariableValue()
   */
  @Override public WorkflowVariableValue createWorkflowVariableValue() {
    return null; // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#getObject()
   */
  @Override public Object getObject() {
    return null; // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#getObjectInfo()
   */
  @Override public String getObjectInfo() {
    return null; // To change body of implemented methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#setObject(Object)
   */
  @Override public void setObject(Object obj) {
    setResponsible((Responsible) obj);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }
} // end class ResponsibleWorkflowBusinessObject
