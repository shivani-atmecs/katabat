package com.ozstrategy.credagility.core.domain.workflow.agency;

import com.cmc.credagility.core.domain.user.Role;
import com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.BasicUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.agency.AgencyDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.agency.AgencyDocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.agency.AgencyUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/17/2014 11:31
 */
public class AgencyWorkflowBusinessObject extends EntWorkflowBusinessObject {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Role agency;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * createDocumentInstance.
   *
   * @return  BasicDocumentInstance
   */
  @Override public BasicDocumentInstance createDocumentInstance() {
    return new AgencyDocumentInstance();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createDocumentMetaDataValue.
   *
   * @return  DocumentMetaDataValue
   */
  @Override public DocumentMetaDataValue createDocumentMetaDataValue() {
    return new AgencyDocumentMetaDataValue();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createUploadDocumentBlob.
   *
   * @return  BasicUploadDocumentBlob
   */
  @Override public BasicUploadDocumentBlob createUploadDocumentBlob() {
    return new AgencyUploadDocumentBlob();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowAuditInstance()
   */
  @Override public WorkflowAuditInstance createWorkflowAuditInstance() {
    return new AgencyWorkflowAuditInstance();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowAuditStep()
   */
  @Override public WorkflowAuditStep createWorkflowAuditStep() {
    return new AgencyWorkflowAuditStep();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowInstance()
   */
  @Override public WorkflowInstance createWorkflowInstance() {
    return new AgencyWorkflowInstance();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowSchedule()
   */
  @Override public WorkflowSchedule createWorkflowSchedule() {
    return new AgencyWorkflowSchedule();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowStep()
   */
  @Override public WorkflowStep createWorkflowStep() {
    return new AgencyWorkflowStep();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowTaskElementAnswer()
   */
  @Override public WorkflowTaskElementAnswer createWorkflowTaskElementAnswer() {
    return new AgencyWorkflowTaskElementAnswer();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowTaskElementTempAnswer()
   */
  @Override public WorkflowTaskElementTempAnswer createWorkflowTaskElementTempAnswer() {
    AgencyWorkflowTaskElementTempAnswer tempAnswer = new AgencyWorkflowTaskElementTempAnswer();
    tempAnswer.setBusinessObject(agency);

    return tempAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowVariableValue()
   */
  @Override public WorkflowVariableValue createWorkflowVariableValue() {
    AgencyWorkflowVariableValue valValue = new AgencyWorkflowVariableValue();
    valValue.setBusinessObject(agency);

    return valValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency.
   *
   * @return  Role
   */
  public Role getAgency() {
    return agency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for object.
   *
   * @return  Object
   */
  @Override public Object getObject() {
    return agency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for object info.
   *
   * @return  String
   */
  @Override public String getObjectInfo() {
    return "Agency#" + agency.getId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency.
   *
   * @param  agency  Role
   */
  public void setAgency(Role agency) {
    this.agency = agency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for object.
   *
   * @param  obj  Object
   */
  @Override public void setObject(Object obj) {
    setAgency((Role) obj);
  }
} // end class AgencyWorkflowBusinessObject
