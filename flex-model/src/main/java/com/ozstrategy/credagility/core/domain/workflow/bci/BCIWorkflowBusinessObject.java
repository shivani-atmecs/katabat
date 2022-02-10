package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.ozstrategy.credagility.core.domain.document.bci.BCIDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.bci.BCIDocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.bci.BCIUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 11/19/13 : 2:32 PM</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class BCIWorkflowBusinessObject extends WorkflowBusinessObject {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private BusinessContextInstance bci;

  private BusinessContext context;

  private BCIWorkflowStep workflowStep;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createDocumentInstance()
   */
  @Override public BCIDocumentInstance createDocumentInstance() {
    return new BCIDocumentInstance();
  }

  public BusinessContext getContext() {
    return context;
  }

  public void setContext(BusinessContext context) {
    this.context = context;
  }
//~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createDocumentMetaDataValue()
   */
  @Override public BCIDocumentMetaDataValue createDocumentMetaDataValue() {
    return new BCIDocumentMetaDataValue();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createUploadDocumentBlob()
   */
  @Override public BCIUploadDocumentBlob createUploadDocumentBlob() {
    return new BCIUploadDocumentBlob();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowAuditInstance()
   */
  @Override public BCIWorkflowAuditInstance createWorkflowAuditInstance() {
    return new BCIWorkflowAuditInstance();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowAuditStep()
   */
  @Override public BCIWorkflowAuditStep createWorkflowAuditStep() {
    return new BCIWorkflowAuditStep();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowInstance()
   */
  @Override public BCIWorkflowInstance createWorkflowInstance() {
    return new BCIWorkflowInstance();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowSchedule()
   */
  @Override public BCWorkflowSchedule createWorkflowSchedule() {
    return new BCWorkflowSchedule();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowStep()
   */
  @Override public BCIWorkflowStep createWorkflowStep() {
    return new BCIWorkflowStep();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowTaskElementAnswer()
   */
  @Override public BCIWorkflowTaskElementAnswer createWorkflowTaskElementAnswer() {
    return new BCIWorkflowTaskElementAnswer();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowTaskElementTempAnswer()
   */
  @Override public BCIWorkflowTaskElementTempAnswer createWorkflowTaskElementTempAnswer() {
    return new BCIWorkflowTaskElementTempAnswer();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#createWorkflowVariableValue()
   */
  @Override public BCIWorkflowVariableValue createWorkflowVariableValue() {
    return new BCIWorkflowVariableValue();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BusinessContextInstance getBci() {
    return bci;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#getObject()
   */
  @Override public Object getObject() {
    return bci;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#getObjectInfo()
   */
  @Override public String getObjectInfo() {
    if (bci != null) {
      return "BCI#" + bci.getId();
    }

    return "BCI#NULL";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCIWorkflowStep getWorkflowStep() {
    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bci  DOCUMENT ME!
   */
  public void setBci(BusinessContextInstance bci) {
    this.bci = bci;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject#setObject(Object)
   */
  @Override public void setObject(Object obj) {
    setBci((BusinessContextInstance) obj);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowStep  DOCUMENT ME!
   */
  public void setWorkflowStep(BCIWorkflowStep workflowStep) {
    this.workflowStep = workflowStep;
  }
} // end class BCIWorkflowBusinessObject
