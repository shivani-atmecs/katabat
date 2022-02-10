package com.ozstrategy.credagility.core.repository;

import com.cmc.credagility.core.domain.address.Timezone;
import com.cmc.credagility.core.domain.agency.AgencyContactAddress;
import com.cmc.credagility.core.domain.agency.AgencyContactEmail;
import com.cmc.credagility.core.domain.agency.AgencyContactPhone;
import com.cmc.credagility.core.domain.businesscontext.BCIMetaDataValue;
import com.cmc.credagility.core.domain.businesscontext.BCIStatusAudit;
import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.cmc.credagility.core.domain.channel.EmailChannelResult;
import com.cmc.credagility.core.domain.externalentity.ExternalEntity;
import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.type.WebActivityChannel;
import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.BCIWorkflowNodeStatusAction;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocument;
import com.ozstrategy.credagility.core.domain.document.bci.BCIDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.bci.BCIDocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.bci.BCIUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.workflow.BCIWorkflowStatusAction;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType;
import com.ozstrategy.credagility.core.domain.workflow.agency.AgencyWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.agency.AgencyWorkflowVariableValue;
import com.ozstrategy.credagility.core.domain.workflow.bci.*;
import com.ozstrategy.credagility.core.domain.workflow.bci.version.BCWorkflowTaskAnswerOptionVersion;
import com.ozstrategy.credagility.core.domain.workflow.bci.version.BCWorkflowTaskGroupVersion;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowInstanceDocumentTemplate;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  11/03/2014 14:53
 */
public interface BCWorkflowRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * canAccessBCWorkflow.
   *
   * @param   workflowId  Long
   * @param   userId      Long
   *
   * @return  boolean
   */
  boolean canAccessBCWorkflow(Long workflowId, Long userId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * canAccessWorkflowNode.
   *
   * @param   nodeId      Long
   * @param   executorId  Long
   *
   * @return  boolean
   */
  boolean canAccessWorkflowNode(Long nodeId, Long executorId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * countBCIByCaseId.
   *
   * @param   dynamicCaseId  Long
   *
   * @return  int
   */
  int countBCIByCaseId(final Long dynamicCaseId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findAgencyContactAddressByRoleAndTypeName.
   *
   * @param   roleId           Long
   * @param   addressTypeName  String
   *
   * @return  AgencyContactAddress
   */
  AgencyContactAddress findAgencyContactAddressByRoleAndTypeName(Long roleId, String addressTypeName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findAgencyContactEmailByRoleAndTypeName.
   *
   * @param   roleId         Long
   * @param   emailTypeName  String
   *
   * @return  AgencyContactEmail
   */
  AgencyContactEmail findAgencyContactEmailByRoleAndTypeName(Long roleId, String emailTypeName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findAgencyContactPhoneByRoleAndTypeName.
   *
   * @param   roleId         Long
   * @param   phoneTypeName  String
   *
   * @return  AgencyContactPhone
   */
  AgencyContactPhone findAgencyContactPhoneByRoleAndTypeName(Long roleId, String phoneTypeName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findBciByUniqueId.
   *
   * @param   bciUniqueId  String
   *
   * @return  BusinessContextInstance
   */
  BusinessContextInstance findBciByUniqueId(String bciUniqueId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findExternalEntityById.
   *
   * @param   externalEntityId  Long
   *
   * @return  ExternalEntity
   */
  ExternalEntity findExternalEntityById(Long externalEntityId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findWorkflowChannelActions.
   *
   * @param   flowId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  List<BCWorkflowChannelAction> findWorkflowChannelActions(Long flowId, WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findWorkflowFlowActions.
   *
   * @param   flowId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  List<BCWorkflowFlowAction> findWorkflowFlowActions(Long flowId, WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findWorkflowNodeBCICreationActions.
   *
   * @param   nodeId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  List<BCICreationAction> findWorkflowNodeBCICreationActions(Long nodeId, WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findWorkflowNodeChannelActions.
   *
   * @param   id           Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  List<BCWorkflowNodeChannelAction> findWorkflowNodeChannelActions(Long id, WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findWorkflowNodeFlowActions.
   *
   * @param   nodeId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  List<BCWorkflowNodeFlowAction> findWorkflowNodeFlowActions(Long nodeId, WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findWorkflowNodeStatusActions.
   *
   * @param   nodeId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  List<BCIWorkflowNodeStatusAction> findWorkflowNodeStatusActions(Long nodeId,
    WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findWorkflowNodeUpdateVariableActions.
   *
   * @param   nodeId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  List<BCWorkflowNodeUpdateVariableAction> findWorkflowNodeUpdateVariableActions(Long nodeId,
    WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findWorkflowNodeVariableActions.
   *
   * @param   nodeId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  List<BCWorkflowNodeVariableAction> findWorkflowNodeVariableActions(Long nodeId,
    WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findWorkflowStatusActions.
   *
   * @param   flowId  statusId Long
   *
   * @return  List
   */
  List<BCIWorkflowStatusAction> findWorkflowStatusActions(Long flowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findWorkflowStepTaskElementSnapshot.
   *
   * @param   workflowStepId  Long
   * @param   eleVersionId    Long
   *
   * @return  BCIWorkflowStepTaskElementSnapshot
   */
  BCIWorkflowStepTaskElementSnapshot findWorkflowStepTaskElementSnapshot(Long workflowStepId, Long eleVersionId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findWorkflowStepTaskElementSnapshot.
   *
   * @param   workflowInstanceId  Long
   * @param   taskVersionId       Long
   * @param   taskElementId       Long
   * @param   nodeId              Long
   *
   * @return  BCIWorkflowStepTaskElementSnapshot
   */
  BCIWorkflowStepTaskElementSnapshot findWorkflowStepTaskElementSnapshot(Long workflowInstanceId,
    Long taskVersionId, Long taskElementId, Long nodeId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findWorkflowStepTaskSnapshot.
   *
   * @param   stepId  Long
   * @param   taskId  Long
   *
   * @return  BCIWorkflowStepTaskSnapshot
   */
  BCIWorkflowStepTaskSnapshot findWorkflowStepTaskSnapshot(Long stepId, Long taskId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findWorkflowTaskSnapshot.
   *
   * @param   workflowInstanceId  Long
   * @param   taskId              Long
   * @param   nodeId              Long
   *
   * @return  BCIWorkflowStepTaskSnapshot
   */
  BCIWorkflowStepTaskSnapshot findWorkflowTaskSnapshot(Long workflowInstanceId, Long taskId, Long nodeId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findWorkflowUpdateVariableActions.
   *
   * @param   flowId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  List<BCWorkflowUpdateVariableAction> findWorkflowUpdateVariableActions(Long flowId,
    WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findWorkflowVariableActions.
   *
   * @param   flowId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  List<BCWorkflowVariableAction> findWorkflowVariableActions(Long flowId,
    WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * get.
   *
   * @param   <T>       Serializable
   * @param   clazz     Class
   * @param   entityId  Serializable
   *
   * @return  T
   */
  <T> T get(Class<T> clazz, Serializable entityId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BCElement answer by doc instance.
   *
   * @param   bciDocumentInstanceId  Long
   *
   * @return  BCIWorkflowTaskElementAnswer
   */
  BCIWorkflowTaskElementAnswer getBCElementAnswerByDocInstance(Long bciDocumentInstanceId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BCField answers.
   *
   * @param   bciWorkflowInstanceId  Long
   * @param   bciId                  Long
   *
   * @return  List
   */
  List<BCIWorkflowTaskElementAnswer> getBCFieldAnswers(final Long bciWorkflowInstanceId, final Long bciId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BCField element answer.
   *
   * @param   bciFieldName           String
   * @param   bciWorkflowInstanceId  Long
   *
   * @return  BCIWorkflowTaskElementAnswer
   */
  BCIWorkflowTaskElementAnswer getBCFieldElementAnswer(String bciFieldName, Long bciWorkflowInstanceId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BCIEE.
   *
   * @param   bciFieldName  String
   * @param   bciId         Long
   *
   * @return  ExternalEntity
   */
  ExternalEntity getBCIEE(String bciFieldName, Long bciId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BCIMeta data value.
   *
   * @param   businessContextInstanceId  Long
   * @param   fieldName                  String
   *
   * @return  BCIMetaDataValue
   */
  BCIMetaDataValue getBCIMetaDataValue(Long businessContextInstanceId, String fieldName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BCIStatus audit.
   *
   * @param   bciId               Long
   * @param   webActivityChannel  WebActivityChannel
   *
   * @return  BCIStatusAudit
   */
  BCIStatusAudit getBCIStatusAudit(Long bciId, WebActivityChannel webActivityChannel);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BCWorkflow progress step by flow id.
   *
   * @param   flowId  Long
   *
   * @return  List
   */
  List<BCWorkflowProgressStep> getBCWorkflowProgressStepByFlowId(Long flowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BCWorkflow task answer option versions.
   *
   * @param   elementVersionId  Long
   *
   * @return  List
   */
  List<BCWorkflowTaskAnswerOptionVersion> getBCWorkflowTaskAnswerOptionVersions(Long elementVersionId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BCWorkflow variable value.
   *
   * @param   businessObject  BCIWorkflowBusinessObject
   * @param   variableId      Long
   *
   * @return  BCIWorkflowVariableValue
   */
  BCIWorkflowVariableValue getBCWorkflowVariableValue(BCIWorkflowBusinessObject businessObject,
    Long variableId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context.
   *
   * @param   businessContextId  Long
   *
   * @return  BusinessContext
   */
  BusinessContext getBusinessContext(Long businessContextId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context by context name.
   *
   * @param   context  String
   *
   * @return  BusinessContext
   */
  BusinessContext getBusinessContextByContextName(String context);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context instance.
   *
   * @param   bcInstanceId  Long
   *
   * @return  BusinessContextInstance
   */
  BusinessContextInstance getBusinessContextInstance(Long bcInstanceId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current BCIWorkflow instance.
   *
   * @param   businessObject  BCIWorkflowBusinessObject
   * @param   workflowId      Long
   *
   * @return  BCIWorkflowInstance
   */
  BCIWorkflowInstance getCurrentBCIWorkflowInstance(BCIWorkflowBusinessObject businessObject, Long workflowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer responsible time zone.
   *
   * @param   customerId  Long
   *
   * @return  List
   */
  List<Object> getCustomerResponsibleTimeZone(Long customerId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for doc meta data by doc.
   *
   * @param   businessObject  BCIWorkflowBusinessObject
   * @param   documentId      Long
   * @param   metaDataName    String
   *
   * @return  BCIDocumentMetaDataValue
   */
  BCIDocumentMetaDataValue getDocMetaDataByDoc(BCIWorkflowBusinessObject businessObject, Long documentId,
    String metaDataName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document by BCI.
   *
   * @param   bci  BusinessContextInstance
   *
   * @return  List
   */
  List<BCIUploadDocumentBlob> getDocumentByBCI(BusinessContextInstance bci);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document instance by doc.
   *
   * @param   businessObject  BCIWorkflowBusinessObject
   * @param   document        EnterpriseDocument
   *
   * @return  BCIDocumentInstance
   */
  BCIDocumentInstance getDocumentInstanceByDoc(BCIWorkflowBusinessObject businessObject, EnterpriseDocument document);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document instance by doc.
   *
   * @param   businessObject      BCIWorkflowBusinessObject
   * @param   workflowInstanceId  BCIWorkflowInstanceId
   * @param   documentId          EnterpriseDocumentId
   *
   * @return  BCIDocumentInstance
   */
  BCIDocumentInstance getDocumentInstanceByDoc(BCIWorkflowBusinessObject businessObject, Long workflowInstanceId,
    Long documentId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first finding workflow step.
   *
   * @param   businessObject      BCIWorkflowBusinessObject
   * @param   workflowInstanceId  Long
   * @param   auditInstanceId     Long
   * @param   workflowId          Long
   *
   * @return  BCIWorkflowStep
   */
  BCIWorkflowStep getFirstFindingWorkflowStep(BCIWorkflowBusinessObject businessObject, Long workflowInstanceId,
    Long auditInstanceId, Long workflowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flexi letter date.
   *
   * @param   categoryName  String
   * @param   accountNum    Long
   *
   * @return  Date
   */
  Date getFlexiLetterDate(String categoryName, Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flexi letter status.
   *
   * @param   categoryName  String
   * @param   accountNum    Long
   *
   * @return  String
   */
  String getFlexiLetterStatus(String categoryName, Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for gather workflow answers.
   *
   * @param   instanceId  Long
   *
   * @return  List
   */
  List<BCIWorkflowTaskElementAnswer> getGatherWorkflowAnswers(final Long instanceId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last active workflow.
   *
   * @param   name  String
   *
   * @return  BCWorkflow
   */
  BCWorkflow getLastActiveWorkflow(String name);

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
   * getter method for last task element answer data.
   *
   * @param   businessObject   WorkflowBusinessObject
   * @param   taskElementCode  String
   *
   * @return  BCIWorkflowTaskElementAnswer
   */
  BCIWorkflowTaskElementAnswer getLastTaskElementAnswerData(WorkflowBusinessObject businessObject,
    String taskElementCode);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last task element answer data.
   *
   * @param   businessObject  WorkflowBusinessObject
   * @param   taskElementId   Long
   *
   * @return  BCIWorkflowTaskElementAnswer
   */
  BCIWorkflowTaskElementAnswer getLastTaskElementAnswerData(WorkflowBusinessObject businessObject,
    Long taskElementId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last utility data.
   *
   * @param   businessObject  BCIWorkflowBusinessObject
   * @param   variableName    String
   *
   * @return  BCIWorkflowVariableValue
   */
  BCIWorkflowVariableValue getLastUtilityData(BCIWorkflowBusinessObject businessObject, final String variableName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for most recent payment date.
   *
   * @param   accountNums  List
   * @param   field        String
   * @param   isDesc       boolean
   *
   * @return  Payment
   */
  Payment getMostRecentPaymentDate(List<Long> accountNums, String field, boolean isDesc);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for remediated finished audit steps.
   *
   * @param   bcWorkflowInstanceId  Long
   *
   * @return  List
   */
  List<BCIWorkflowAuditStep> getRemediatedFinishedAuditSteps(Long bcWorkflowInstanceId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task element answers label by flow step.
   *
   * @param   taskElementId   Long
   * @param   workflowStepId  Long
   *
   * @return  Object[]
   */
  Object[] getTaskElementAnswersLabelByFlowStep(Long taskElementId, Long workflowStepId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temp email channel result.
   *
   * @param   bciId  Long
   *
   * @return  List
   */
  List<EmailChannelResult> getTempEmailChannelResult(Long bciId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for timezone by offset.
   *
   * @param   offset  Integer
   *
   * @return  List
   */
  List<Timezone> getTimezoneByOffset(Integer offset);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow.
   *
   * @param   workflowId  Long
   *
   * @return  BCWorkflow
   */
  BCWorkflow getWorkflow(Long workflowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow audit step.
   *
   * @param   bcWorkflowInstanceId  Long
   * @param   workflowStepId        Long
   * @param   businessObject        BCIWorkflowBusinessObject
   *
   * @return  BCIWorkflowAuditStep
   */
  BCIWorkflowAuditStep getWorkflowAuditStep(Long bcWorkflowInstanceId, Long workflowStepId,
    BCIWorkflowBusinessObject businessObject);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow doc instance template.
   *
   * @param   documentId          Long
   * @param   workflowInstanceId  Long
   *
   * @return  WorkflowInstanceDocumentTemplate
   */
  WorkflowInstanceDocumentTemplate getWorkflowDocInstanceTemplate(final Long documentId, final Long workflowInstanceId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow document instance.
   *
   * @param   businessObject  BCIWorkflowBusinessObject
   * @param   documentId      Long
   *
   * @return  BCIDocumentInstance
   */
  BCIDocumentInstance getWorkflowDocumentInstance(BCIWorkflowBusinessObject businessObject, final Long documentId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow document instance by id.
   *
   * @param   businessObject  BCIWorkflowBusinessObject
   * @param   docInstanceId   Long
   *
   * @return  BCIDocumentInstance
   */
  BCIDocumentInstance getWorkflowDocumentInstanceById(BCIWorkflowBusinessObject businessObject,
    final Long docInstanceId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow root node.
   *
   * @param   workflowId  Long
   *
   * @return  BCWorkflowNode
   */
  BCWorkflowNode getWorkflowRootNode(Long workflowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow task group version.
   *
   * @param   taskVersionId  Long
   *
   * @return  List
   */
  List<BCWorkflowTaskGroupVersion> getWorkflowTaskGroupVersion(Long taskVersionId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for too frequency.
   *
   * @param   workflowId      Long
   * @param   businessObject  BCIWorkflowBusinessObject
   * @param   start           Date
   * @param   end             Date
   *
   * @return  Integer
   */
  Integer isTooFrequency(Long workflowId, BCIWorkflowBusinessObject businessObject, Date start, Date end);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listAllAnswersByWorkflowInstance.
   *
   * @param   businessObject      BCIWorkflowBusinessObject
   * @param   workflowInstanceId  Long
   *
   * @return  List
   */
  List<Object[]> listAllAnswersByWorkflowInstance(BCIWorkflowBusinessObject businessObject, Long workflowInstanceId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listTaskElementVersion.
   *
   * @param   businessObject      BCIWorkflowBusinessObject
   * @param   workflowInstanceId  Long
   * @param   workflowId          Long
   * @param   workflowTaskId      Long
   * @param   flowStepId          Long
   * @param   version             Integer
   *
   * @return  List
   */
  List<Object[]> listTaskElementVersion(BCIWorkflowBusinessObject businessObject, Long workflowInstanceId,
    Long workflowId, Long workflowTaskId, Long flowStepId, Integer version);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * numberOfTaskElementFindings.
   *
   * @param   level         String
   * @param   workflowName  String
   * @param   bci           BusinessContextInstance
   *
   * @return  int
   */
  int numberOfTaskElementFindings(String level, String workflowName, BusinessContextInstance bci);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeWorkflowTaskTempAnswers.
   *
   * @param  taskId          Long
   * @param  businessObject  BCIWorkflowBusinessObject
   */
  void removeWorkflowTaskTempAnswers(Long taskId, BCIWorkflowBusinessObject businessObject);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * save.
   *
   * @param   <T>     T
   * @param   entity  T
   *
   * @return  T
   */
  <T> T save(T entity);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateWorkflowStepsWithSpecialBCI.
   *
   * @param  bci          BusinessContextInstance
   * @param  currentStep  BCIWorkflowStep
   */
  void updateWorkflowStepsWithSpecialBCI(BusinessContextInstance bci, BCIWorkflowStep currentStep);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateWorkflowStepsWithSpecialBCI.
   *
   * @param  previousBCIID       Long
   * @param  workflowInstanceId  Long
   * @param  workflowStepId      Long
   */
  void updateWorkflowStepsWithSpecialBCI(Long previousBCIID, Long workflowInstanceId, Long workflowStepId);

  //~ ------------------------------------------------------------------------------------------------------------------
  
  /**
   * DOCUMENT ME!
   *
   * @param  entities  DOCUMENT ME!
   */
  List<Object> batchSave(List<Object> entities);
} // end interface BCWorkflowRepository
