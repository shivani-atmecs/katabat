package com.ozstrategy.credagility.core.domain.workflow.agent;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.document.BasicDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.BasicUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.agency.AgencyDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.agent.AgentDocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.agent.AgentUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.workflow.agency.AgencyWorkflowAuditInstance;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/17/2014 09:43
 */
public class AgentWorkflowBusinessObject extends EntWorkflowBusinessObject {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private User agent;

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
    return new AgentDocumentMetaDataValue();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createUploadDocumentBlob.
   *
   * @return  BasicUploadDocumentBlob
   */
  @Override public BasicUploadDocumentBlob createUploadDocumentBlob() {
    return new AgentUploadDocumentBlob();
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
    return new AgentWorkflowAuditStep();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowInstance()
   */
  @Override public WorkflowInstance createWorkflowInstance() {
    return new AgentWorkflowInstance();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowSchedule()
   */
  @Override public WorkflowSchedule createWorkflowSchedule() {
    return new AgentWorkflowSchedule();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowStep()
   */
  @Override public WorkflowStep createWorkflowStep() {
    return new AgentWorkflowStep();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowTaskElementAnswer()
   */
  @Override public WorkflowTaskElementAnswer createWorkflowTaskElementAnswer() {
    return new AgentWorkflowTaskElementAnswer();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowTaskElementTempAnswer()
   */
  @Override public WorkflowTaskElementTempAnswer createWorkflowTaskElementTempAnswer() {
    AgentWorkflowTaskElementTempAnswer tempAnswer = new AgentWorkflowTaskElementTempAnswer();
    tempAnswer.setBusinessObject(agent);

    return tempAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject#createWorkflowVariableValue()
   */
  @Override public WorkflowVariableValue createWorkflowVariableValue() {
    AgentWorkflowVariableValue valValue = new AgentWorkflowVariableValue();
    valValue.setBusinessObject(agent);

    return valValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent.
   *
   * @return  User
   */
  public User getAgent() {
    return agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for object.
   *
   * @return  Object
   */
  @Override public Object getObject() {
    return agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for object info.
   *
   * @return  String
   */
  @Override public String getObjectInfo() {
    return "Agent#" + agent.getId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent.
   *
   * @param  agent  User
   */
  public void setAgent(User agent) {
    this.agent = agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for object.
   *
   * @param  obj  Object
   */
  @Override public void setObject(Object obj) {
    setAgent((User) obj);
  }
} // end class AgentWorkflowBusinessObject
