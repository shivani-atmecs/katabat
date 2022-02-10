package com.ozstrategy.credagility.core.repository;

import com.cmc.credagility.core.domain.account.AccountFlowVariableValue;
import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.cmc.credagility.core.domain.portfolio.PortfolioSurveyAnswer;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.agency.AgencyDocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.agent.AgentDocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.bci.BCIDocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.enterprise.EnterpriseDocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.responsible.ResponsibleDocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.agency.AgencyWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.agency.AgencyWorkflowTaskElementAnswer;
import com.ozstrategy.credagility.core.domain.workflow.agency.AgencyWorkflowVariableValue;
import com.ozstrategy.credagility.core.domain.workflow.agent.AgentWorkflowTaskElementAnswer;
import com.ozstrategy.credagility.core.domain.workflow.ent.EnterpriseWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.ent.EnterpriseWorkflowTaskElementAnswer;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.*;

import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  11/03/2014 15:14
 */
public interface EnterpriseWorkflowRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * countCompletedTaskElements.
   *
   * @param   businessObject  WorkflowBusinessObject
   * @param   tag             String
   *
   * @return  int
   */
  int countCompletedTaskElements(WorkflowBusinessObject businessObject, String tag);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last portfolio survey answer data by code.
   *
   * @param   <T>          Object
   * @param   entityClass  Class
   * @param   primaryKey   Object
   *
   * @return  T
   */
  <T> T get(Class<T> entityClass, Object primaryKey);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency workflow variable value.
   *
   * @param   agency      Role
   * @param   variableId  Long
   *
   * @return  WorkflowVariableValue
   */
  WorkflowVariableValue getAgencyWorkflowVariableValue(Role agency, Long variableId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent workflow variable value.
   *
   * @param   agent       User
   * @param   variableId  Long
   *
   * @return  WorkflowVariableValue
   */
  WorkflowVariableValue getAgentWorkflowVariableValue(User agent, Long variableId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for doc meta data by doc.
   *
   * @param   docId         Long
   * @param   metaDataName  String
   *
   * @return  EnterpriseDocumentMetaDataValue
   */
  EnterpriseDocumentMetaDataValue getDocMetaDataByDoc(Long docId, String metaDataName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for doc meta data by doc.
   *
   * @param   businessObject  WorkflowBusinessObject
   * @param   docId           Long
   * @param   metaDataName    String
   *
   * @return  DocumentMetaDataValue
   */
  DocumentMetaDataValue getDocMetaDataByDoc(WorkflowBusinessObject businessObject, Long docId, String metaDataName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for doc meta data by doc.
   *
   * @param   responsible   Responsible
   * @param   docId         Long
   * @param   metaDataName  String
   *
   * @return  ResponsibleDocumentMetaDataValue
   */
  ResponsibleDocumentMetaDataValue getDocMetaDataByDoc(Responsible responsible, Long docId, String metaDataName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for doc meta data by doc.
   *
   * @param   agency        Role
   * @param   docId         Long
   * @param   metaDataName  String
   *
   * @return  AgencyDocumentMetaDataValue
   */
  AgencyDocumentMetaDataValue getDocMetaDataByDoc(Role agency, Long docId, String metaDataName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for doc meta data by doc.
   *
   * @param   agent         User
   * @param   docId         Long
   * @param   metaDataName  String
   *
   * @return  AgentDocumentMetaDataValue
   */
  AgentDocumentMetaDataValue getDocMetaDataByDoc(User agent, Long docId, String metaDataName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for doc meta data by doc.
   *
   * @param   bci           BusinessContextInstance
   * @param   docId         Long
   * @param   metaDataName  String
   *
   * @return  BCIDocumentMetaDataValue
   */
  BCIDocumentMetaDataValue getDocMetaDataByDoc(BusinessContextInstance bci, Long docId, String metaDataName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enterprise workflow variable value.
   *
   * @param   variableId  Long
   *
   * @return  WorkflowVariableValue
   */
  WorkflowVariableValue getEnterpriseWorkflowVariableValue(Long variableId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last agency utility data.
   *
   * @param   businessObject  AgencyWorkflowBusinessObject
   * @param   variableName    String
   *
   * @return  AgencyWorkflowVariableValue
   */
  AgencyWorkflowVariableValue getLastAgencyUtilityData(AgencyWorkflowBusinessObject businessObject,
    final String variableName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last portfolio survey answer data by code.
   *
   * @param   accountNum          Long
   * @param   workflowInstanceId  Long
   * @param   questionCode        String
   *
   * @return  PortfolioSurveyAnswer
   */
  PortfolioSurveyAnswer getLastPortfolioSurveyAnswerDataByCode(final Long accountNum, final Long workflowInstanceId,
    final String questionCode);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last task element answer data.
   *
   * @param   taskElementId  Long
   *
   * @return  EnterpriseWorkflowTaskElementAnswer
   */
  EnterpriseWorkflowTaskElementAnswer getLastTaskElementAnswerData(Long taskElementId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last task element answer data.
   *
   * @param   businessObject  WorkflowBusinessObject
   * @param   taskElementId   Long
   *
   * @return  WorkflowTaskElementAnswer
   */
  WorkflowTaskElementAnswer getLastTaskElementAnswerData(WorkflowBusinessObject businessObject, Long taskElementId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last task element answer data.
   *
   * @param   agency         Role
   * @param   taskElementId  Long
   *
   * @return  AgencyWorkflowTaskElementAnswer
   */
  AgencyWorkflowTaskElementAnswer getLastTaskElementAnswerData(Role agency, Long taskElementId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last task element answer data.
   *
   * @param   agent          User
   * @param   taskElementId  Long
   *
   * @return  AgentWorkflowTaskElementAnswer
   */
  AgentWorkflowTaskElementAnswer getLastTaskElementAnswerData(User agent, Long taskElementId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last task element answer data.
   *
   * @param   taskElementCode  String
   * @param   businessObject   EnterpriseWorkflowBusinessObject
   *
   * @return  EnterpriseWorkflowTaskElementAnswer
   */
  EnterpriseWorkflowTaskElementAnswer getLastTaskElementAnswerData(String taskElementCode,
    EnterpriseWorkflowBusinessObject businessObject);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last task element answer data.
   *
   * @param   businessObject   WorkflowBusinessObject
   * @param   taskElementCode  String
   *
   * @return  WorkflowTaskElementAnswer
   */
  WorkflowTaskElementAnswer getLastTaskElementAnswerData(WorkflowBusinessObject businessObject,
    String taskElementCode);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last utility data.
   *
   * @param   variableName  String
   * @param   accountNum    Long
   *
   * @return  AccountFlowVariableValue
   */
  AccountFlowVariableValue getLastUtilityData(final String variableName, final Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task elements by tag.
   *
   * @param   tag  String
   *
   * @return  List
   */
  List<EnterpriseWorkflowTaskElement> getTaskElementsByTag(String tag);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * >>>>>>> Stashed changes getter method for workflow instance document template.
   *
   * @param   documentId      Long
   * @param   flowInstanceId  Long
   * @param   locale          String
   *
   * @return  WorkflowInstanceDocumentTemplate
   */
  WorkflowInstanceDocumentTemplate getWorkflowInstanceDocumentTemplate(Long documentId, Long flowInstanceId,
    String locale);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow variable value.
   *
   * @param   businessObject  WorkflowBusinessObject
   * @param   variableId      Long
   *
   * @return  WorkflowVariableValue
   */
  WorkflowVariableValue getWorkflowVariableValue(WorkflowBusinessObject businessObject, Long variableId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * numberOfCompletedCustomerTasks.
   *
   * @param   businessObject  WorkflowBusinessObject
   * @param   tag             String
   *
   * @return  List
   */
  List<EnterpriseWorkflowTask> numberOfCompletedCustomerTasks(WorkflowBusinessObject businessObject, String tag);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * numberOfCompletedTask.
   *
   * @param   businessObject  WorkflowBusinessObject
   * @param   tag             String
   *
   * @return  int
   */
  int numberOfCompletedTask(WorkflowBusinessObject businessObject, String tag);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * numberOfCustomerTasks.
   *
   * @param   tag  String
   *
   * @return  List
   */
  List<EnterpriseWorkflowTask> numberOfCustomerTasks(String tag);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * numberOfSurveyQuestionFindings.
   *
   * @param   level          String
   * @param   workflowName   String
   * @param   responsibleId  Long
   *
   * @return  int
   */
  int numberOfSurveyQuestionFindings(final String level, final String workflowName, final Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * numberOfTask.
   *
   * @param   tag  String
   *
   * @return  List
   */
  List<EnterpriseWorkflowTask> numberOfTask(String tag);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * numberOfTaskElementFindings.
   *
   * @param   category      String
   * @param   level         String
   * @param   workflowName  String
   * @param   ownerId       Long
   *
   * @return  int
   */
  int numberOfTaskElementFindings(String category, String level, String workflowName, Long ownerId);
} // end interface EnterpriseWorkflowRepository
