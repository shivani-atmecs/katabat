package com.ozstrategy.credagility.core.repository.impl;

import com.cmc.credagility.core.domain.address.Timezone;
import com.cmc.credagility.core.domain.agency.AgencyContactAddress;
import com.cmc.credagility.core.domain.agency.AgencyContactEmail;
import com.cmc.credagility.core.domain.agency.AgencyContactPhone;
import com.cmc.credagility.core.domain.businesscontext.BCIMetaDataValue;
import com.cmc.credagility.core.domain.businesscontext.BCIStatusAudit;
import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.cmc.credagility.core.domain.channel.EmailChannelResult;
import com.cmc.credagility.core.domain.channel.LetterChannelResult;
import com.cmc.credagility.core.domain.externalentity.ExternalEntity;
import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.type.ScheduleStatus;
import com.cmc.credagility.core.domain.type.WebActivityChannel;
import com.ozstrategy.credagility.core.domain.audit.FindingType;
import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.BCIWorkflowNodeStatusAction;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocument;
import com.ozstrategy.credagility.core.domain.document.bci.BCIDocumentInstance;
import com.ozstrategy.credagility.core.domain.document.bci.BCIDocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.bci.BCIUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.workflow.*;
import com.ozstrategy.credagility.core.domain.workflow.agency.AgencyWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.agency.AgencyWorkflowVariableValue;
import com.ozstrategy.credagility.core.domain.workflow.bci.*;
import com.ozstrategy.credagility.core.domain.workflow.bci.version.BCWorkflowTaskAnswerOptionVersion;
import com.ozstrategy.credagility.core.domain.workflow.bci.version.BCWorkflowTaskElementVersion;
import com.ozstrategy.credagility.core.domain.workflow.bci.version.BCWorkflowTaskGroupVersion;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowInstanceDocumentTemplate;
import com.ozstrategy.credagility.core.repository.BCWorkflowRepository;
import com.ozstrategy.credagility.core.repository.OzHibernateDaoSupport;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  03/24/2015 17:03
 */
@Repository("bcWorkflowRepository")
public class BCWorkflowRepositoryImpl extends OzHibernateDaoSupport implements BCWorkflowRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#canAccessBCWorkflow(Long, Long)
   */
  @Override public boolean canAccessBCWorkflow(Long workflowId, Long userId) {
    String hql =
      "select flow.id from BCWorkflow flow left join flow.assignAgents user where user.id = :uid and flow.id = :fid";
    List   q   = em.createQuery(hql).setParameter("uid", userId).setParameter("fid", workflowId).getResultList();

    if (q.size() > 0) {
      return true;
    }

    hql =
      "select r1.id from User u left join u.roles r1, BCWorkflow flow left join flow.assignRoles r2 where r2=r1 and u.id = :uid and flow.id = :fid";
    q   = em.createQuery(hql).setParameter("uid", userId).setParameter("fid", workflowId).getResultList();

    if (q.size() > 0) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#canAccessWorkflowNode(Long, Long)
   */
  @Override public boolean canAccessWorkflowNode(Long nodeId, Long executorId) {
    String hql =
      "select node.id from BCWorkflowNode node left join node.assignAgents user where user.id = :uid and node.id = :nid";
    List   q   = em.createQuery(hql).setParameter("uid", executorId).setParameter("nid", nodeId).getResultList();

    if (q.size() > 0) {
      return Boolean.TRUE;
    }

    hql =
      "select r1.id from User u left join u.roles r1, BCWorkflowNode node left join node.assignRoles r2 where r2=r1 and u.id = :uid and node.id = :nid";
    q   = em.createQuery(hql).setParameter("uid", executorId).setParameter("nid", nodeId).getResultList();

    if (q.size() > 0) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#countBCIByCaseId(Long)
   */
  @Override public int countBCIByCaseId(Long dynamicCaseId) {
    Long count = (Long) em.createQuery(
        "SELECT COUNT(DISTINCT b.id) FROM BusinessContextInstance b WHERE b.dynamicCase.id =:dynamicCaseId")
      .setParameter("dynamicCaseId",
        dynamicCaseId).getSingleResult();

    return (count != null) ? count.intValue() : 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findAgencyContactAddressByRoleAndTypeName(Long,
   *       String)
   */
  @Override public AgencyContactAddress findAgencyContactAddressByRoleAndTypeName(Long roleId, String addressTypeName) {
    String hql =
      "FROM AgencyContactAddress a WHERE a.role.id=:roleId AND a.addressType.name=:addressTypeName AND a.historical = false";

    AgencyContactAddress agencyContactAddress = (AgencyContactAddress) getSession().createQuery(hql).setParameter(
        "addressTypeName", addressTypeName).setParameter("roleId", roleId).uniqueResult();

    return agencyContactAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findAgencyContactEmailByRoleAndTypeName(Long,
   *       String)
   */
  @Override public AgencyContactEmail findAgencyContactEmailByRoleAndTypeName(Long roleId, String emailTypeName) {
    String hql =
      "FROM AgencyContactEmail e WHERE e.role.id = :roleId and e.historical = false AND e.emailType.name=:emailTypeName";

    AgencyContactEmail agencyContactEmail = (AgencyContactEmail) getSession().createQuery(hql).setParameter(
        "emailTypeName", emailTypeName).setParameter("roleId", roleId).uniqueResult();

    return agencyContactEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findAgencyContactPhoneByRoleAndTypeName(Long,
   *       String)
   */
  @Override public AgencyContactPhone findAgencyContactPhoneByRoleAndTypeName(Long roleId, String phoneTypeName) {
    String hql =
      "FROM AgencyContactPhone a WHERE a.role.id = :roleId and a.historical = false AND a.phoneType.name=:phoneTypeName ";

    AgencyContactPhone agencyContactPhone = (AgencyContactPhone) getSession().createQuery(hql).setParameter(
        "phoneTypeName", phoneTypeName).setParameter("roleId", roleId).uniqueResult();

    return agencyContactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findBciByUniqueId(String)
   */
  @Override public BusinessContextInstance findBciByUniqueId(String bciUniqueId) {
    List<BusinessContextInstance> resutls = em.createQuery(
        "select from BusinessContextInstance bci where bci.uniqueId=:bciUniqueId ").setParameter("bciUniqueId",
        bciUniqueId).getResultList();

    return ((resutls != null) && !resutls.isEmpty()) ? resutls.get(0) : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findExternalEntityById(Long)
   */
  @Override public ExternalEntity findExternalEntityById(Long externalEntityId) {
    String         hql            = "from ExternalEntity e where e.id = ?";
    ExternalEntity externalEntity = (ExternalEntity) getSession().createQuery(hql).uniqueResult();

    return externalEntity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findWorkflowChannelActions(Long, com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType)
   */
  @Override public List<BCWorkflowChannelAction> findWorkflowChannelActions(Long flowId,
    WorkflowNodeActionTriggerType triggerType) {
    Query query = em.createQuery(
        "from BCWorkflowChannelAction action where action.flow.id = :flowId and action.triggerType = :triggerType ");
    query.setParameter("flowId", flowId).setParameter("triggerType", triggerType);

    return query.getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findWorkflowFlowActions(Long, com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType)
   */
  @Override public List<BCWorkflowFlowAction> findWorkflowFlowActions(Long flowId,
    WorkflowNodeActionTriggerType triggerType) {
    StringBuilder hql = new StringBuilder("FROM BCWorkflowFlowAction action ");
    hql.append("WHERE action.flow.id = :flowId AND action.triggerType = :triggerType");

    return em.createQuery(hql.toString()).setParameter("flowId", flowId).setParameter("triggerType",
        triggerType).getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findWorkflowNodeBCICreationActions(Long,
   *       com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType)
   */
  @Override public List<BCICreationAction> findWorkflowNodeBCICreationActions(Long nodeId,
    WorkflowNodeActionTriggerType triggerType) {
    StringBuilder hql = new StringBuilder("FROM BCICreationAction action ");
    hql.append("WHERE action.node.id = :nodeId AND action.triggerType = :triggerType");

    return em.createQuery(hql.toString()).setParameter("nodeId", nodeId).setParameter("triggerType",
        triggerType).getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findWorkflowNodeChannelActions(Long,
   *       com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType)
   */
  @Override public List<BCWorkflowNodeChannelAction> findWorkflowNodeChannelActions(Long nodeId,
    WorkflowNodeActionTriggerType triggerType) {
    Query query = em.createQuery(
        "from BCWorkflowNodeChannelAction action where action.node.id = :nodeId and action.triggerType = :triggerType ORDER BY action.priority ASC ");
    query.setParameter("nodeId", nodeId).setParameter("triggerType", triggerType);

    return query.getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findWorkflowNodeFlowActions(Long, com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType)
   */
  @Override public List<BCWorkflowNodeFlowAction> findWorkflowNodeFlowActions(Long nodeId,
    WorkflowNodeActionTriggerType triggerType) {
    StringBuilder hql = new StringBuilder("FROM BCWorkflowNodeFlowAction action ");
    hql.append("WHERE action.node.id = :nodeId AND action.triggerType = :triggerType ORDER BY action.priority ASC");

    return em.createQuery(hql.toString()).setParameter("nodeId", nodeId).setParameter("triggerType",
        triggerType).getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findWorkflowNodeStatusActions(Long, com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType)
   */
  @Override public List<BCIWorkflowNodeStatusAction> findWorkflowNodeStatusActions(Long nodeId,
    WorkflowNodeActionTriggerType triggerType) {
    return em.createQuery(
        "from BCIWorkflowNodeStatusAction action where action.node.id = :nodeId and action.triggerType = :triggerType ")
      .setParameter("nodeId", nodeId).setParameter("triggerType", triggerType).getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findWorkflowNodeUpdateVariableActions(Long,
   *       com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType)
   */
  @Override public List<BCWorkflowNodeUpdateVariableAction> findWorkflowNodeUpdateVariableActions(Long nodeId,
    WorkflowNodeActionTriggerType triggerType) {
    StringBuilder hql = new StringBuilder("FROM BCWorkflowNodeUpdateVariableAction action ");
    hql.append("WHERE action.node.id = :nodeId AND action.triggerType = :triggerType");

    return em.createQuery(hql.toString()).setParameter("nodeId", nodeId).setParameter("triggerType",
        triggerType).getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findWorkflowNodeVariableActions(Long,
   *       com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType)
   */
  @Override public List<BCWorkflowNodeVariableAction> findWorkflowNodeVariableActions(Long nodeId,
    WorkflowNodeActionTriggerType triggerType) {
    String hql =
      "FROM BCWorkflowNodeVariableAction action WHERE action.node.id = :nodeId AND action.triggerType = :triggerType ORDER BY action.priority ASC";

    return em.createQuery(hql).setParameter("nodeId", nodeId).setParameter("triggerType", triggerType).getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findWorkflowStatusActions.
   *
   * @param   flowId  Long
   *
   * @return  List
   */
  @Override public List<BCIWorkflowStatusAction> findWorkflowStatusActions(Long flowId) {
    return em.createQuery("FROM BCIWorkflowStatusAction action where action.flow.id = :flowId").setParameter("flowId",
        flowId).getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findWorkflowStepTaskElementSnapshot(Long,
   *       Long)
   */
  @Override public BCIWorkflowStepTaskElementSnapshot findWorkflowStepTaskElementSnapshot(Long workflowStepId,
    Long eleVersionId) {
    Query query = em.createQuery(
        "FROM BCIWorkflowStepTaskElementSnapshot audit where audit.workflowStep.id = :workflowStepId and audit.taskElementVersion.id = :eleVersionId ORDER BY audit.id DESC");
    query.setParameter("workflowStepId", workflowStepId).setParameter("eleVersionId", eleVersionId).setMaxResults(1);

    return (BCIWorkflowStepTaskElementSnapshot) query.getSingleResult();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findWorkflowStepTaskElementSnapshot(Long,
   *       Long, Long, Long)
   */
  @Override public BCIWorkflowStepTaskElementSnapshot findWorkflowStepTaskElementSnapshot(Long workflowInstanceId,
    Long taskVersionId, Long taskElementId, Long nodeId) {
    Query query = em.createQuery(
        "FROM BCIWorkflowStepTaskElementSnapshot snap WHERE snap.workflowStep.workflowInstance.id = :wId AND snap.taskVersion.id = :tvId AND snap.taskElement.id = :teId AND snap.workflowStep.node.id=:nid AND snap.workflowStep.status='FINISHED' ORDER BY snap.id DESC ");
    query.setParameter("wId", workflowInstanceId).setParameter("tvId", taskVersionId).setParameter("teId",
      taskElementId).setParameter("nid", nodeId).setMaxResults(1);

    return (BCIWorkflowStepTaskElementSnapshot) query.getSingleResult();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findWorkflowStepTaskSnapshot(Long, Long)
   */
  @Override public BCIWorkflowStepTaskSnapshot findWorkflowStepTaskSnapshot(Long stepId, Long taskId) {
    Query query = em.createQuery(
        "FROM BCIWorkflowStepTaskSnapshot audit where audit.workflowStep.id = :sId and audit.workflowTask.id = :tId");
    query.setParameter("sId", stepId).setParameter("tId", taskId).setMaxResults(1);

    return (BCIWorkflowStepTaskSnapshot) query.getSingleResult();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findWorkflowTaskSnapshot(Long, Long,
   *       Long)
   */
  @Override public BCIWorkflowStepTaskSnapshot findWorkflowTaskSnapshot(Long workflowInstanceId, Long taskId,
    Long nodeId) {
    Query query = em.createQuery(
        "FROM BCIWorkflowStepTaskSnapshot snapShot where snapShot.workflowTask.id=:taskId AND snapShot.workflowStep.node.id=:nodeId AND snapShot.workflowStep.workflowInstance.id=:workflowInstanceId AND snapShot.workflowStep.status='FINISHED' ");
    query.setParameter("taskId", taskId).setParameter("workflowInstanceId", workflowInstanceId).setParameter("nodeId",
      nodeId).setMaxResults(1);

    return (BCIWorkflowStepTaskSnapshot) query.getSingleResult();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findWorkflowUpdateVariableActions(Long,
   *       com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType)
   */
  @Override public List<BCWorkflowUpdateVariableAction> findWorkflowUpdateVariableActions(Long flowId,
    WorkflowNodeActionTriggerType triggerType) {
    StringBuilder hql = new StringBuilder("FROM BCWorkflowUpdateVariableAction action ");
    hql.append("WHERE action.flow.id = :flowId AND action.triggerType = :triggerType");

    return em.createQuery(hql.toString()).setParameter("flowId", flowId).setParameter("triggerType",
        triggerType).getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#findWorkflowVariableActions(Long, com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType)
   */
  @Override public List<BCWorkflowVariableAction> findWorkflowVariableActions(Long flowId,
    WorkflowNodeActionTriggerType triggerType) {
    String hql =
      "FROM BCWorkflowVariableAction action WHERE action.flow.id = :flowId AND action.triggerType = :triggerType order by action.priority asc";

    return em.createQuery(hql).setParameter("flowId", flowId).setParameter("triggerType", triggerType).getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#get(Class, java.io.Serializable)
   */
  @Override public <T> T get(Class<T> clazz, Serializable entityId) {
    return (T) em.find(clazz, entityId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getBCFieldElementAnswer(String, Long)
   */
  @Override public BCIWorkflowTaskElementAnswer getBCElementAnswerByDocInstance(Long bciDocumentInstanceId) {
    StringBuffer hql = new StringBuffer("SELECT {answer.*} ");
    hql.append("from BCIWorkflowTaskElementAnswer answer ");
    hql.append("LEFT JOIN BCIWorkflowStep step ON step.id = answer.workflowStepId ");
    hql.append("LEFT JOIN BCIDocumentInstance doc ON doc.id = answer.data AND step.id = doc.workflowStepId ");
    hql.append("WHERE doc.id = :docInstanceId ");
    hql.append("AND answer.businessDataType = 'Document Upload' ");
    hql.append("ORDER BY answer.answerId ASC");

    List<BCIWorkflowTaskElementAnswer> list = getSession().createSQLQuery(hql.toString()).addEntity("answer",
        BCIWorkflowTaskElementAnswer.class).setLong(
        "docInstanceId", bciDocumentInstanceId).list();

    if (list.size() > 0) {
      return list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getBCFieldAnswers(Long, Long)
   */
  @Override public List<BCIWorkflowTaskElementAnswer> getBCFieldAnswers(Long bciWorkflowInstanceId, Long bciId) {
    StringBuffer hql = new StringBuffer("SELECT {answer.*} ");
    hql.append("from BCIWorkflowTaskElementAnswer answer ");
    hql.append("LEFT JOIN BCIWorkflowStep step ON step.id = answer.workflowStepId ");
    hql.append("LEFT JOIN BCWorkflowTask task ON task.id = answer.taskId ");
    hql.append("LEFT JOIN BCIWorkflowInstance instance ON instance.id = step.workflowInstanceId ");
    hql.append("WHERE instance.id = :instanceId AND (instance.status='FINISHED' OR instance.status='IN_PROCESS') ");
    hql.append("AND (step.status='FINISHED' OR step.status='IN_PROCESS') ");
    hql.append("AND ((step.fixBciId is not null and step.fixBciId=:bciId) or (step.fixBciId is null)) ");
    hql.append("AND task.asGather='Y'  ");
    hql.append(
      "ORDER BY answer.answerId ASC, case when (step.fixBciId is not null and step.fixBciId=:bciId) then 1 else 0 end desc");

    return getSession().createSQLQuery(hql.toString()).addEntity("answer", BCIWorkflowTaskElementAnswer.class).setLong(
        "instanceId", bciWorkflowInstanceId).setLong("bciId", bciId).list();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getBCFieldElementAnswer(String, Long)
   */
  @Override public BCIWorkflowTaskElementAnswer getBCFieldElementAnswer(String bciFieldName,
    Long bciWorkflowInstanceId) {
    List<BCIWorkflowTaskElementAnswer> list = em.createQuery(
        "select distinct ans from BCIWorkflowTaskElementAnswer ans where ans.taskElementVersion.bcMetaDataField.fieldName=:fieldName "
        + "and ans.workflowStep.workflowInstance.id = :bciWorkflowInstanceId order by ans.workflowStep.createDate desc")
      .setParameter("fieldName", bciFieldName).setParameter("bciWorkflowInstanceId", bciWorkflowInstanceId)
      .getResultList();

    if (list.size() > 0) {
      return list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BCIEE.
   *
   * @param   bciFieldName  String
   * @param   bciId         Long
   *
   * @return  ExternalEntity
   */
  @Override public ExternalEntity getBCIEE(String bciFieldName, Long bciId) {
    ExternalEntity externalEntity = null;

    if (bciId != null) {
      BCIMetaDataValue metaDataValue = (BCIMetaDataValue) getSession().createQuery(
          "FROM BCIMetaDataValue v where v.businessContextInstance.id=:bciId AND v.fieldName=:fieldName ORDER BY v.createDate DESC")
        .setLong("bciId", bciId).setString("fieldName", bciFieldName).setMaxResults(1).uniqueResult();
      externalEntity = (ExternalEntity) getSession().createQuery("from ExternalEntity ee where ee.id=:eeId").setLong(
          "eeId", metaDataValue.getLongValue()).uniqueResult();
    }

    return externalEntity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BCIMeta data value.
   *
   * @param   bciId      Long
   * @param   fieldName  String
   *
   * @return  BCIMetaDataValue
   */
  @Override public BCIMetaDataValue getBCIMetaDataValue(Long bciId, String fieldName) {
    BCIMetaDataValue metaDataValue = (BCIMetaDataValue) getSession().createQuery(
        "FROM BCIMetaDataValue v where v.businessContextInstance.id=:bciId AND v.fieldName=:fieldName ORDER BY v.createDate DESC")
      .setLong("bciId", bciId).setString("fieldName", fieldName).setMaxResults(1).uniqueResult();

    return metaDataValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getBCIStatusAudit(Long, com.cmc.credagility.core.domain.type.WebActivityChannel)
   */
  @Override public BCIStatusAudit getBCIStatusAudit(Long bciId, WebActivityChannel webActivityChannel) {
    List<BCIStatusAudit> results = em.createQuery(
        "from BCIStatusAudit a where a.businessContextInstance.id =:bciId and a.source=:source order by a.id desc")
      .setParameter("bciId", bciId).setParameter("source", webActivityChannel.toString()).getResultList();

    return ((results != null) && !results.isEmpty()) ? results.get(0) : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getBCWorkflowProgressStepByFlowId(Long)
   */
  @Override public List<BCWorkflowProgressStep> getBCWorkflowProgressStepByFlowId(Long flowId) {
    String              hql   =
      "select step from SurveyFlowProgressStep step where step.surveyFlow.id = :flowId  order by step.stepNumber asc ";
    org.hibernate.Query query = getSession().createQuery(hql.toString()).setLong("flowId", flowId);

    return query.list();

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getBCWorkflowTaskAnswerOptionVersions(Long)
   */
  @Override public List<BCWorkflowTaskAnswerOptionVersion> getBCWorkflowTaskAnswerOptionVersions(
    Long elementVersionId) {
    return em.createQuery("from BCWorkflowTaskAnswerOptionVersion p where p.taskElement.id = :versionId").setParameter(
        "versionId", elementVersionId).getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getBCWorkflowVariableValue(com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject,
   *       Long)
   */
  @Override public BCIWorkflowVariableValue getBCWorkflowVariableValue(BCIWorkflowBusinessObject businessObject,
    Long variableId) {
    StringBuffer hql = new StringBuffer();

    hql.append("FROM BCIWorkflowVariableValue val ");
    hql.append("WHERE val.variable.id =:variableId ");

    if ((businessObject != null) && (businessObject.getBci() != null)) {
      hql.append(" AND val.bci=:bci ");
    }

    hql.append("ORDER BY val.createDate DESC");

    Query query = em.createQuery(hql.toString()).setParameter("variableId", variableId);

    if ((businessObject != null) && (businessObject.getBci() != null)) {
      query.setParameter("bci", businessObject.getBci());
    }

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (BCIWorkflowVariableValue) list.get(0);
    }

    return null;
  } // end method getBCWorkflowVariableValue

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context.
   *
   * @param   businessContextId  Long
   *
   * @return  BusinessContext
   */
  @Override public BusinessContext getBusinessContext(Long businessContextId) {
    List<BusinessContext> results = em.createQuery("select t FROM BusinessContext t where t.id= :businessContextId ")
      .setParameter("businessContextId", businessContextId).setMaxResults(1).getResultList();

    return ((results != null) && !results.isEmpty()) ? results.get(0) : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getBusinessContextByContextName(String)
   */
  @Override public BusinessContext getBusinessContextByContextName(String context) {
    List<BusinessContext> results = em.createQuery("select t FROM BusinessContext t where t.context= :businessContext ")
      .setParameter("businessContext", context).setMaxResults(1).getResultList();

    return ((results != null) && !results.isEmpty()) ? results.get(0) : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getBusinessContextInstance(Long)
   */
  @Override public BusinessContextInstance getBusinessContextInstance(Long bcInstanceId) {
    StringBuffer sb = new StringBuffer("select bci from BusinessContextInstance bci");
    sb.append(" left join fetch bci.customer");
    sb.append(" left join fetch bci.responsible r");
    sb.append(" left join fetch r.responsibleDetail ");
    sb.append(" left join fetch r.phones ");
    sb.append(" left join fetch r.addresses ");
    sb.append(" left join fetch r.emails ");

    sb.append(" left join fetch bci.account a ");
    sb.append(" left join fetch a.defaultResponsible ");

    sb.append(" left join fetch a.portfolio ");
// sb.append(" left join fetch a.portfolio.client ");
// sb.append(" left join fetch a.portfolio.industry ");
    // sb.append(" left join fetch a.portfolio.paymentServiceProvider ");

    sb.append(" left join fetch a.accountDetail ");
    sb.append(" left join fetch a.accountExtension ");

    sb.append(" left join fetch a.accountIndex ");
// sb.append(" left join fetch a.accountIndex.accountAggregate ");

    sb.append(" left join fetch a.tsysAccount ");
    sb.append(" left join fetch a.tsysAccountCustomData ");
    sb.append(" left join fetch a.tsysAccountStatusCode ");
    sb.append(" left join fetch a.accountConfig ");
    sb.append(" left join fetch a.accountDelinquent ");
    sb.append(" left join fetch a.accountDetail ");
    sb.append(" left join fetch a.accountExtension ");
    sb.append(" left join fetch a.expenseAudit ");
    sb.append(" left join fetch a.accountOverallStatusSet acctOverallStatus ");
// sb.append(" left join fetch acctOverallStatus.accountOverallStatusDetail ");

// sb.append(" left join fetch a.defaultResponsible.tsysDeceased  ");
// sb.append(" left join fetch a.defaultResponsible.responsiblePageVisit ");
// sb.append(" left join fetch a.defaultResponsible.responsibleDetail ");
// sb.append(" left join fetch a.defaultResponsible.responsibleIndex ");
// sb.append(" left join fetch a.defaultResponsible.responsibleConfig ");
    sb.append(" left join fetch bci.metaDataMap ");
    sb.append(" where bci.id = ").append(bcInstanceId);

    BusinessContextInstance entity = (BusinessContextInstance) getSession().createQuery(sb.toString()).uniqueResult();

    return entity;
  } // end method getBusinessContextInstance

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getCurrentBCIWorkflowInstance(com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject,
   *       Long)
   */
  @Override public BCIWorkflowInstance getCurrentBCIWorkflowInstance(BCIWorkflowBusinessObject businessObject,
    Long workflowId) {
    StringBuffer hql = new StringBuffer(
        "SELECT instance FROM BCIWorkflowInstance instance WHERE instance.status ='IN_PROCESS' AND instance.workflow.id = :workflowId ");

    if (businessObject.getBci() != null) {
      hql.append("AND instance.bci.id=:bcInstanceId ");
    }

    hql.append("ORDER BY instance.lastUpdateDate DESC");

    Query query = em.createQuery(hql.toString()).setParameter("workflowId", workflowId);

    if (businessObject.getBci() != null) {
      query.setParameter("bcInstanceId", businessObject.getBci().getId());
    }

    query.setMaxResults(1);

    List<BCIWorkflowInstance> list = query.getResultList();

    if ((list == null) || (list.size() == 0)) {
      return null;
    } else {
      return list.get(0);
    }
  } // end method getCurrentBCIWorkflowInstance

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getCustomerResponsibleTimeZone(Long)
   */
  @Override public List<Object> getCustomerResponsibleTimeZone(Long customerId) {
    String sql  =
      "( SELECT tz.offset FROM CustomerContactAddress ca LEFT JOIN ZipcodeTimezone ztz ON LEFT (ca.postalCode, 5) = ztz.zipcode LEFT JOIN Timezone tz ON ztz.timezoneId = tz.timezoneId LEFT JOIN Customer c ON ca.customerId = c.customerId WHERE c.customerId = :customerId AND ca.historical <> 'Y' AND tz.tzId IS NOT NULL GROUP BY ca.postalCode ) UNION ( SELECT tz.offset FROM CustomerContactPhone cp LEFT JOIN AreacodeTimezone atz ON LEFT (cp.phoneNum, 3) = atz.areacode LEFT JOIN Customer c ON cp.customerId = c.customerId LEFT JOIN Timezone tz ON atz.timezoneId = tz.timezoneId WHERE c.customerId = :customerId AND cp.historical <> 'Y' AND tz.tzId IS NOT NULL GROUP BY cp.phoneNum );";
    List   list = getSession().createSQLQuery(sql).setParameter("customerId", customerId).list();

    return list;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getDocMetaDataByDoc(com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject,
   *       Long, String)
   */
  @Override public BCIDocumentMetaDataValue getDocMetaDataByDoc(BCIWorkflowBusinessObject businessObject,
    Long documentId, String metaDataName) {
    StringBuffer hql = new StringBuffer(
        "select metaDataValue from BCIDocumentInstance ins left join ins.metaDataValues metaDataValue where ins.document.id=:dId and ins.active = true and metaDataValue.name = :name ");

    if (businessObject.getBci() != null) {
      hql.append(" and ins.bci.id = :bciId ");
    }

    hql.append("ORDER BY metaDataValue.lastUpdateDate DESC");

    Query query = em.createQuery(hql.toString()).setParameter("dId", documentId).setParameter("name", metaDataName);

    if (businessObject.getBci() != null) {
      query.setParameter("bciId", businessObject.getBci().getId());
    }

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (BCIDocumentMetaDataValue) list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getDocumentByBCI(com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance)
   */
  @Override public List<BCIUploadDocumentBlob> getDocumentByBCI(BusinessContextInstance bci) {
    String sql  = "select max(b.id)\n"
      + "from BCIDocumentInstance b,\n"
      + "(\n"
      + "select max(di.createDate) createDate,di.documentId from BCIDocumentInstance di \n"
      + "where di.bciId= :bciId\n"
      + "and di.active='Y'\n"
      + "group by di.documentId\n"
      + ") c\n"
      + "where b.bciId = :bciId and b.active='Y' and b.createDate=c.createDate\n"
      + " and b.documentId=c.documentId\n"
      + "group by b.documentId\n";
    List   list = getSession().createSQLQuery(sql).setParameter("bciId", bci.getId()).list();

    if ((list == null) || (list.size() == 0)) {
      return new ArrayList<>();
    }

    List<Long> ids = new ArrayList<Long>();

    for (Object o : list) {
      if (o != null) {
        ids.add(Long.parseLong(o.toString()));
      }
    }

    if (ids.size() == 0) {
      return new ArrayList<>();
    }

    String hql = "FROM " + BCIUploadDocumentBlob.class.getName()
      + " t where t.documentInstance.id in (:documentInstance) order by t.createDate asc ";

    return getSession().createQuery(hql).setParameterList("documentInstance", ids).list();
  } // end method getDocumentByBCI

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getDocumentInstanceByDoc(com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject,
   *       com.ozstrategy.credagility.core.domain.document.EnterpriseDocument)
   */
  @Override public BCIDocumentInstance getDocumentInstanceByDoc(BCIWorkflowBusinessObject businessObject,
    EnterpriseDocument document) {
    StringBuffer hql = new StringBuffer(
        "FROM BCIDocumentInstance ins WHERE ins.document=:document AND ins.active =true ");

    if (businessObject.getBci() != null) {
      hql.append(" AND ins.bci.id=:bciId ");
    }

    hql.append(" ORDER BY ins.createDate DESC ");

    Query query = em.createQuery(hql.toString()).setParameter("document", document);

    if (businessObject.getBci() != null) {
      query.setParameter("bciId", businessObject.getBci().getId());
    }

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (BCIDocumentInstance) list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getDocumentInstanceByDoc(com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject,
   *       Long, Long)
   */
  @Override public BCIDocumentInstance getDocumentInstanceByDoc(BCIWorkflowBusinessObject businessObject,
    Long workflowInstanceId, Long documentId) {
    StringBuffer sb = new StringBuffer();
    sb.append("SELECT ins.* FROM BCIDocumentInstance ins ");
    sb.append("LEFT JOIN BCIWorkflowStep step ON ins.workflowStepId=step.id ");
    sb.append("WHERE step.workflowInstanceId=:workflowInstanceId AND ins.active ='Y' AND ins.documentId=:documentId ");

    if (businessObject.getBci() != null) {
      sb.append(" AND ins.bciId=:bciId ");
    }

    sb.append(" ORDER BY ins.id DESC ");

    Query query = em.createNativeQuery(sb.toString(), BCIDocumentInstance.class).setParameter("workflowInstanceId",
        workflowInstanceId).setParameter("documentId", documentId);

    if (businessObject.getBci() != null) {
      query.setParameter("bciId", businessObject.getBci().getId());
    }

    List<BCIDocumentInstance> list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return list.get(0);
    }

    return null;
  } // end method getDocumentInstanceByDoc

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getFirstFindingWorkflowStep(com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject,
   *       Long, Long, Long)
   */
  @Override public BCIWorkflowStep getFirstFindingWorkflowStep(BCIWorkflowBusinessObject businessObject,
    Long workflowInstanceId, Long auditInstanceId, Long workflowId) {
    StringBuffer hql = new StringBuffer();
    hql.append("SELECT astep.workflowStep FROM BCIWorkflowAuditInstance ains ");
    hql.append("LEFT JOIN ains.steps astep LEFT JOIN astep.taskElementAuditSet aele ");
    hql.append(
      "WHERE ains.id = :auditInstanceId AND ains.workflow.id = :workflowId AND ains.status='FINISHED' AND (ains.auditStatus='FAIL' OR ains.auditStatus='FAILED') ");
    hql.append(
      "AND astep.workflowAuditInstance.id = :auditInstanceId AND astep.status='FINISHED' AND astep.workflowInstance.id= :workflowInstanceId AND astep.workflowInstance.status='FINISHED' ");
    hql.append("AND aele.finding='YES' ");

    if (businessObject.getBci() != null) {
      hql.append("AND ains.bci.id=:bciInstanceId ");
    }

    hql.append(" ORDER BY astep.workflowStep.stepNumber ASC ");

    Query query = em.createQuery(hql.toString()).setParameter("auditInstanceId", auditInstanceId).setParameter(
        "workflowInstanceId", workflowInstanceId).setParameter("workflowId", workflowId);

    if (businessObject.getBci() != null) {
      query.setParameter("bciInstanceId", businessObject.getBci().getId());
    }

    return (BCIWorkflowStep) query.setMaxResults(1).getSingleResult();
  } // end method getFirstFindingWorkflowStep

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getFlexiLetterDate(String, Long)
   */
  @Override public Date getFlexiLetterDate(String categoryName, Long accountNum) {
    String hql =
      "from LetterChannelResult l where l.channelAction.category =:categoryName and l.account.accountNum =:accountNum order by l.strategyDate desc,l.letterResultId desc";

    List<LetterChannelResult> letterChannelResultList =
      (getSession().createQuery(hql).setParameter("categoryName",
          categoryName).setParameter(
          "accountNum", accountNum)).list();

    LetterChannelResult letterChannelResult = null;

    if (letterChannelResultList.size() > 0) {
      letterChannelResult = letterChannelResultList.get(0);
    }

    if (letterChannelResult != null) {
      if ("CLEARED".equalsIgnoreCase(letterChannelResult.getBusinessStatus())) {
        return null;
      }

      return letterChannelResult.getStrategyDate();
    }

    return null;
  } // end method getFlexiLetterDate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getFlexiLetterStatus(String, Long)
   */
  @Override public String getFlexiLetterStatus(String categoryName, Long accountNum) {
    String hql =
      "from LetterChannelResult l where l.channelAction.category =:categoryName and l.account.accountNum =:accountNum order by l.strategyDate desc,l.letterResultId desc";

    List<LetterChannelResult> letterChannelResultList =
      (getSession().createQuery(hql).setParameter("categoryName",
          categoryName).setParameter(
          "accountNum", accountNum)).list();

    LetterChannelResult letterChannelResult = null;

    if (letterChannelResultList.size() > 0) {
      letterChannelResult = letterChannelResultList.get(0);
    }

    if (letterChannelResult != null) {
      if ("CLEARED".equalsIgnoreCase(letterChannelResult.getBusinessStatus())) {
        return "N";
      } else {
        if (null != letterChannelResult.getRecipientCode()) {
          return letterChannelResult.getRecipientCode();
        } else {
          String customerType = letterChannelResult.getResponsible().getCustomer().getType();

          if ("0".equals(customerType)) {
            return "I";
          } else if ("1".equals(customerType)) {
            return "C";
          }
        }
      }
    }

    return null;
  } // end method getFlexiLetterStatus

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getGatherWorkflowAnswers(Long)
   */
  @Override public List<BCIWorkflowTaskElementAnswer> getGatherWorkflowAnswers(Long instanceId) {
    return getSession().createQuery(
        "SELECT DISTINCT a FROM  BCIWorkflowTaskElementAnswer a LEFT JOIN a.workflowStep s LEFT JOIN s.workflowInstance i WHERE i.id=:instanceId AND s.status='FINISHED' AND a.bci.id is null")
      .setParameter("instanceId", instanceId).list();

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getLastActiveWorkflow(String)
   */
  @Override public BCWorkflow getLastActiveWorkflow(String name) {
    List<BCWorkflow> list = getSession().createQuery("FROM " + BCWorkflow.class.getName()
        + " b WHERE b.name=:name and b.schedule.scheduleStatus=:status order by b.createDate desc").setParameter("name",
        name).setParameter("status", ScheduleStatus.ACTIVE).list();

    if ((list == null) || (list.size() == 0)) {
      return null;
    }

    return list.get(0);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getLastAgencyUtilityData(com.ozstrategy.credagility.core.domain.workflow.agency.AgencyWorkflowBusinessObject,
   *       String)
   */
  @Override public AgencyWorkflowVariableValue getLastAgencyUtilityData(AgencyWorkflowBusinessObject businessObject,
    String variableName) {
    String hql =
      "SELECT v FROM AgencyWorkflowVariableValue v WHERE v.variable.name=:variableName AND v.businessObject=:businessObject ORDER BY v.id DESC ";

    Query query = em.createQuery(hql);
    query.setParameter("variableName", variableName).setParameter("businessObject", businessObject.getAgency());
    query.setMaxResults(1);

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (AgencyWorkflowVariableValue) list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getLastTaskElementAnswerData(com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject,
   *       String)
   */
  @Override public BCIWorkflowTaskElementAnswer getLastTaskElementAnswerData(WorkflowBusinessObject businessObject,
    String taskElementCode) {
    if (businessObject instanceof BCIWorkflowBusinessObject) {
      BCIWorkflowBusinessObject obj = (BCIWorkflowBusinessObject) businessObject;
      StringBuffer              hql = new StringBuffer();
      hql.append("SELECT ans FROM BCIWorkflowTaskElementAnswer ans LEFT JOIN ans.workflowStep step  ");
      hql.append("WHERE ans.taskElement.questionCode =:taskElementCode ");
      hql.append("AND (step.status='FINISHED' OR step.status='IN_PROCESS' ) ");
      hql.append("AND ans.bci.id=:bciId AND step.bci.id=:bciId ");
      hql.append("ORDER BY ans.answerDate DESC, ans.id DESC ");

      List<BCIWorkflowTaskElementAnswer> list = em.createQuery(hql.toString()).setParameter("taskElementCode",
          taskElementCode).setParameter("bciId",
          (obj.getBci() != null) ? obj.getBci().getId() : null).setMaxResults(1).getResultList();

      if (list.isEmpty()) {
        if (obj.getWorkflowInstanceId() != null) {
          hql = new StringBuffer();
          hql.append("SELECT ans FROM BCIWorkflowTaskElementAnswer ans LEFT JOIN ans.workflowStep step  ");
          hql.append("WHERE ans.taskElement.questionCode =:taskElementCode ");
          hql.append("AND (step.status='FINISHED' OR step.status='IN_PROCESS' ) ");
          hql.append("AND step.workflowInstance.id=:workflowInstanceId ");
          hql.append("ORDER BY ans.answerDate DESC, ans.id DESC ");
          list = em.createQuery(hql.toString()).setParameter("taskElementCode", taskElementCode).setParameter(
              "workflowInstanceId", obj.getWorkflowInstanceId()).setMaxResults(1).getResultList();
        } else if ((obj.getWorkflowInstanceId() == null) && (obj.getBci() != null)) {
          hql = new StringBuffer();
// hql.append(
// "SELECT ans FROM BCIWorkflowTaskElementAnswer ans LEFT JOIN ans.workflowStep step, BusinessContextInstance bci ");
// hql.append("WHERE ans.taskElement.questionCode =:taskElementCode ");
// hql.append("AND (step.status='FINISHED' OR step.status='IN_PROCESS' ) ");
// hql.append("AND step.workflowInstance = bci.workflowInstance AND bci.id=:bciId AND step.bci.id=:bciId ");
// hql.append("AND ((step.bci.id IS NOT NULL and step.bci.id=bci.id) OR (step.bci.id IS NULL)) ");
// hql.append("ORDER BY ans.answerDate DESC, ans.id DESC ");

          hql.append(
            "SELECT ans FROM BCIWorkflowTaskElementAnswer ans LEFT JOIN ans.workflowStep step, BusinessContextInstance bci ");
          hql.append("WHERE ans.taskElement.questionCode =:taskElementCode ");
          hql.append("AND (step.status='FINISHED' OR step.status='IN_PROCESS' ) ");
          hql.append("AND step.workflowInstance = bci.workflowInstance AND bci.id=:bciId ");
// hql.append("AND ((step.bci.id IS NOT NULL and step.bci.id=bci.id) OR (step.bci.id IS NULL)) ");
          hql.append("AND step.workflowInstance = bci.workflowInstance ");
          hql.append("ORDER BY ans.answerDate DESC, ans.id DESC ");

          list = em.createQuery(hql.toString()).setParameter("taskElementCode", taskElementCode).setParameter(
              "bciId", obj.getBci().getId()).setMaxResults(1).getResultList();
        } // end if-else
      }   // end if

      if (list.isEmpty() && (obj.getBci() != null)) {
        hql = new StringBuffer();
        hql.append(
          "SELECT ans FROM BCIWorkflowTaskElementAnswer ans LEFT JOIN ans.workflowStep step, BusinessContextInstance bci ");
        hql.append("WHERE ans.taskElement.questionCode =:taskElementCode ");
        hql.append("AND (step.status='FINISHED' OR step.status='IN_PROCESS' ) ");
        hql.append(
          "AND step.workflowInstance.uuId = bci.dynamicCase.caseNumber AND bci.id=:bciId AND step.bci.id=:bciId ");
        hql.append("AND ((step.fixBciId IS NOT NULL and step.fixBciId=bci.id) OR (step.fixBciId IS NULL)) ");
        hql.append("AND ans.createDate <= bci.createDate ");
        hql.append(
          "ORDER BY ans.answerDate DESC, ans.id DESC, case when (step.fixBciId is not null and step.fixBciId=:bciId) then 1 else 0 end desc ");
        list = em.createQuery(hql.toString()).setParameter("taskElementCode", taskElementCode).setParameter(
            "bciId", obj.getBci().getId()).setMaxResults(1).getResultList();
      }

      if (!list.isEmpty()) {
        return list.get(0);
      }
    } // end if

    return null;
  } // end method getLastTaskElementAnswerData

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getLastTaskElementAnswerData(com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject,
   *       Long)
   */
  @Override public BCIWorkflowTaskElementAnswer getLastTaskElementAnswerData(WorkflowBusinessObject businessObject,
    Long taskElementId) {
    if (businessObject instanceof BCIWorkflowBusinessObject) {
      BCIWorkflowBusinessObject obj  = (BCIWorkflowBusinessObject) businessObject;
      int                       flag = 0;
      String                    hql  =
        "select ans from BCIWorkflowTaskElementAnswer ans, BCIWorkflowStep step where ans.workflowStepId = step.id and ans.taskElement.id = ? ";

      if (obj.getBci() != null) {
        hql  += " and ans.bci = ? ";
        flag = 1;
      } else if (obj.getWorkflowInstanceId() != null) {
        hql  += " and step.workflowInstance.id=?";
        flag = 2;
      }

      hql += " ORDER BY ans.answerDate DESC ";

      org.hibernate.Query query = getSession().createQuery(hql).setParameter(0, taskElementId);

      if (flag == 1) {
        query.setParameter(1, obj.getBci());
      } else if (flag == 2) {
        query.setParameter(1, obj.getWorkflowInstanceId());
      }

      List list = query.list();

      if ((list != null) && (list.size() > 0)) {
        return (BCIWorkflowTaskElementAnswer) list.get(0);
      }
    } // end if

    return null;
  } // end method getLastTaskElementAnswerData

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getLastUtilityData(com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject,
   *       String)
   */
  @Override public BCIWorkflowVariableValue getLastUtilityData(BCIWorkflowBusinessObject businessObject,
    String variableName) {
    String hql   =
      "SELECT v FROM BCIWorkflowVariableValue v WHERE v.variable.name=:variableName AND v.bci=:bci ORDER BY v.id DESC ";
    Query  query = em.createQuery(hql);
    query.setParameter("variableName", variableName).setParameter("bci", businessObject.getBci());
    query.setMaxResults(1);

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (BCIWorkflowVariableValue) list.get(0);
    }

    return null;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getMostRecentPaymentDate(java.util.List, String,
   *       boolean)
   */
  @Override public Payment getMostRecentPaymentDate(List<Long> accountNums, String field, boolean isDesc) {
    Criteria      query = getSession().createCriteria(Payment.class).add(Restrictions.in("account.accountNum",
          accountNums)).addOrder(isDesc ? Order.desc(field) : Order.asc(field));
    List<Payment> list  = query.setMaxResults(1).list();

    if (list.size() > 0) {
      return list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getRemediatedFinishedAuditSteps(Long)
   */
  @Override public List<BCIWorkflowAuditStep> getRemediatedFinishedAuditSteps(Long bcWorkflowInstanceId) {
    String hql =
      "select distinct aStep FROM BCIWorkflowAuditStep aStep left join aStep.workflowStep step left join step.node node left join node.workflowTask where step.workflowInstance.id = :instanceId AND (aStep.status = 'FINISHED' or aStep.status = 'IN_PROCESS') AND aStep.remediate=true order by aStep.remediateDate desc";

    return em.createQuery(hql).setParameter("instanceId", bcWorkflowInstanceId).getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getTaskElementAnswersLabelByFlowStep(Long,
   *       Long)
   */
  @Override public Object[] getTaskElementAnswersLabelByFlowStep(Long taskElementId, Long workflowStepId) {
    String sql =
      "select (case answer.taskElement.businessDataType when 'Document Status' then answer.data else CASE WHEN( ( answer.taskElement.answerType = 'Radio' OR answer.taskElement.answerType = 'DROPDOWN' ) AND answer.data != '') THEN opt.name else answer.data end end), answer.taskElement.businessDataType, answer.data, answer.answerHashCode, answer.valueFormat "
      + "from BCIWorkflowTaskElementAnswer answer left join answer.taskElement.answerOptions opt "
      + "where ((case answer.taskElement.businessDataType when 'Document Status' then answer.data else case when ((answer.taskElement.answerType = 'Radio' or answer.taskElement.answerType ='DROPDOWN') AND answer.data != '' ) then opt.value else answer.data  end end) = answer.data OR answer.data is null) "
      + "and  answer.workflowStepId = :workflowStepId and answer.taskElement.id = :taskElementId order by answer.answerDate desc";

    Object[] result = (Object[]) em.createQuery(sql).setParameter("workflowStepId", workflowStepId).setParameter(
        "taskElementId", taskElementId).setMaxResults(1).getSingleResult();

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temp email channel result.
   *
   * @param   bciId  Long
   *
   * @return  List
   */
  @Override public List<EmailChannelResult> getTempEmailChannelResult(Long bciId) {
    return em.createQuery("FROM EmailChannelResult e WHERE e.businessContextInstance.id=:bciId AND e.status='TEMP' ")
      .setParameter("bciId", bciId).getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getTimezoneByOffset(Integer)
   */
  @Override public List<Timezone> getTimezoneByOffset(Integer offset) {
    String hql = "FROM Timezone t where t.offset=:offset";

    return getSession().createQuery(hql).setParameter("offset", offset).list();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getWorkflow(Long)
   */
  @Override public BCWorkflow getWorkflow(Long workflowId) {
    return em.find(BCWorkflow.class, workflowId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getWorkflowAuditStep(Long, Long,
   *       com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject)
   */
  @Override public BCIWorkflowAuditStep getWorkflowAuditStep(Long bcWorkflowInstanceId, Long workflowStepId,
    BCIWorkflowBusinessObject businessObject) {
    StringBuffer hql = new StringBuffer();
    hql.append("SELECT astep FROM BCIWorkflowAuditStep astep ");
    hql.append("WHERE astep.node.id IN(SELECT step.node.id FROM ");
    hql.append("BCIWorkflowStep step ");
    hql.append(
      "WHERE step.id=:stepId AND step.workflowInstance.id=:instanceId ) AND astep.workflowInstance.id=:instanceId ");
    hql.append(" ORDER BY astep.lastUpdateDate DESC ");

    List<BCIWorkflowAuditStep> list = em.createQuery(hql.toString()).setParameter("stepId", workflowStepId)
      .setParameter(
        "instanceId", bcWorkflowInstanceId).setMaxResults(1).getResultList();

    if ((list != null) && (list.size() > 0)) {
      return list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getWorkflowDocInstanceTemplate(Long,
   *       Long)
   */
  @Override public WorkflowInstanceDocumentTemplate getWorkflowDocInstanceTemplate(Long documentId,
    Long workflowInstanceId) {
    String              hql   =
      "FROM WorkflowInstanceDocumentTemplate s WHERE s.document.id = ? AND s.bciInstance.id = ?";
    org.hibernate.Query query = getSession().createQuery(hql);
    query.setLong(0, documentId).setLong(1, workflowInstanceId);

    List<WorkflowInstanceDocumentTemplate> list = query.list();

    return ((list != null) && (list.size() > 0)) ? list.get(0) : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getWorkflowDocumentInstance(com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject,
   *       Long)
   */
  @Override public BCIDocumentInstance getWorkflowDocumentInstance(BCIWorkflowBusinessObject businessObject,
    Long documentId) {
    StringBuffer hql = new StringBuffer("FROM BCIDocumentInstance WHERE document.id = :documentId AND active=true ");

    if (businessObject.getBci() != null) {
      hql.append("AND bci.id=:bciInstanceId ");
    }

    hql.append(" ORDER BY createDate DESC ");

    org.hibernate.Query query = getSession().createQuery(hql.toString()).setLong("documentId", documentId);

    if (businessObject.getBci() != null) {
      query.setLong("bciInstanceId", businessObject.getBci().getId());
    }

    List<BCIDocumentInstance> list = query.list();

    return ((list != null) && (list.size() > 0)) ? list.get(0) : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getWorkflowDocumentInstanceById(com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject,
   *       Long)
   */
  @Override public BCIDocumentInstance getWorkflowDocumentInstanceById(BCIWorkflowBusinessObject businessObject,
    Long docInstanceId) {
    Query query = em.createQuery("FROM BCIDocumentInstance WHERE id = :bciId ORDER BY createDate DESC ").setParameter(
        "bciId", docInstanceId);

    List<BCIDocumentInstance> list = query.getResultList();

    return ((list != null) && (list.size() > 0)) ? list.get(0) : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getWorkflowRootNode(Long)
   */
  @Override public BCWorkflowNode getWorkflowRootNode(Long workflowId) {
    List<BCWorkflowNode> result = em.createQuery(
        "select distinct node from BCWorkflowNode node where node.workflow.id=:workflowId and node.root = :root")
      .setParameter("workflowId",
        workflowId).setParameter("root", true).getResultList();

    if (result.size() > 0) {
      return result.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#getWorkflowTaskGroupVersion(Long)
   */
  @Override public List<BCWorkflowTaskGroupVersion> getWorkflowTaskGroupVersion(Long taskVersionId) {
    return em.createQuery("FROM BCWorkflowTaskGroupVersion g WHERE g.task.id = :tId").setParameter("tId", taskVersionId)
      .getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#isTooFrequency(Long,com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject,
   *       java.util.Date, java.util.Date)
   */
  @Override public Integer isTooFrequency(Long workflowId, BCIWorkflowBusinessObject businessObject, Date start,
    Date end) {
    StringBuffer hql   = new StringBuffer();
    Query        query = null;

    hql.append(
      "select count(distinct a.id) from BCIWorkflowInstance a where a.status='FINISHED' and a.workflow.id = :workflowId and a.lastUpdateDate between :startDate and :endDate order by a.lastUpdateDate DESC");
    query = em.createQuery(hql.toString());
    query.setParameter("workflowId", workflowId);
    query.setParameter("startDate", start);
    query.setParameter("endDate", end);

    Long count = null;
    count = (Long) query.getSingleResult();

    if (count != null) {
      return count.intValue();
    }

    return 0;
  } // end method isTooFrequency

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#listAllAnswersByWorkflowInstance(com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject,
   *       Long)
   */
  @Override public List<Object[]> listAllAnswersByWorkflowInstance(BCIWorkflowBusinessObject businessObject,
    Long workflowInstanceId) {
    StringBuffer hql = new StringBuffer();
    hql.append("SELECT distinct ans.id, ques.questionText, ");
    hql.append(
      "(CASE WHEN((ques.answerType = 'Radio' OR ques.answerType = 'DropDown') AND ques.businessDataType != 'Document Status' AND ans.data != '' AND ques.allowDataProvider != true )THEN opt.name ELSE ans.data END )AS answer, ");
    hql.append("step.depthNamePath, step.id, ques.businessDataType, ques.id, ques.allowEncrypt, ques.answerType ");
    hql.append("FROM BCIWorkflowInstance ins ");
    hql.append("LEFT JOIN ins.steps step ");
    hql.append("LEFT JOIN step.taskSnapshot taskSnap ");
    hql.append("LEFT JOIN step.elementSnapshots eleSnap ");
    hql.append("LEFT JOIN taskSnap.workflowTaskVersion task ");
    hql.append("LEFT JOIN task.groups g ");
    hql.append("LEFT JOIN g.groupElements el ");
    hql.append("LEFT JOIN eleSnap.taskElementVersion ques ");
    hql.append("LEFT JOIN ques.answerOptions opt, ");
    hql.append("BCIWorkflowTaskElementAnswer ans ");
    hql.append("WHERE ins.id=:workFlowInstanceId AND step.status = 'FINISHED' ");

    hql.append("AND ans.taskElement.id = eleSnap.taskElement.id ");
    hql.append("AND ans.workflowStep.id = step.id ");

    if (businessObject.getBci() != null) {
      hql.append(" AND step.workflowInstance.bci.id=:bciInstanceId ");
    }

    hql.append(
      "AND((ans.data = CASE WHEN(( ques.answerType = 'Radio' OR ques.answerType = 'DropDown' ) AND ques.businessDataType != 'Document Status' AND ans.data != '' AND ques.allowDataProvider != true ) THEN opt.value ELSE ans.data END ) OR( ques.answerType != 'Radio' AND ques.answerType != 'DropDown' )) ");
    hql.append("ORDER BY step.stepNumber ASC, step.exitDate ASC, g.displayOrder ASC, el.displayOrder ASC ");

    Query query = this.em.createQuery(hql.toString()).setParameter("workFlowInstanceId",
        workflowInstanceId);

    if (businessObject.getBci() != null) {
      query.setParameter("bciInstanceId", businessObject.getBci().getId());
    }


    return query.getResultList();
  } // end method listAllAnswersByWorkflowInstance

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#listTaskElementVersion(com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject,
   *       Long, Long, Long, Long, Integer)
   */
  @Override public List<Object[]> listTaskElementVersion(BCIWorkflowBusinessObject businessObject,
    Long workflowInstanceId, Long workflowId, Long workflowTaskId, Long flowStepId, Integer version) {
    StringBuffer sql = new StringBuffer();

    sql.append("SELECT {grp.*}, {ques.*}, {ans.*}, {tempAns.*}, {quesAudit.*} ");

    sql.append("FROM BCWorkflowTask tsk LEFT JOIN ");
    sql.append(
      "(SELECT t.* FROM BCWorkflowTaskVersion t WHERE t.workflowTaskId=:tid AND t.status = 'ACTIVE' AND t.version=:version ORDER BY t.lastUpdateDate DESC LIMIT 0, 1) task ON task.workflowTaskId = tsk.id ");
    sql.append("LEFT JOIN BCWorkflowTaskGroupVersion grp ON grp.taskId = task.id ");
    sql.append("LEFT JOIN BCWorkflowTaskGroupElementVersion grpEl ON grpEl.groupId = grp.id ");
    sql.append("LEFT JOIN BCWorkflowTaskElement question ON question.id = grpEl.questionId ");
    sql.append("LEFT JOIN BCWorkflowTaskElementVersion ques ON ques.id = question.activeVersionId ");
    sql.append("LEFT JOIN (SELECT b.* FROM ( ");
    sql.append(
      "SELECT DISTINCT a.* FROM BCIWorkflowTaskElementAnswer a WHERE a.workflowStepId=:sid ");
    sql.append(
      "ORDER BY a.answerDate DESC) b GROUP BY b.taskId, b.taskElementId) ans ON ans.taskElementId = question.id ");
    sql.append(
      "LEFT JOIN (SELECT DISTINCT b.* FROM (SELECT DISTINCT a.* FROM BCIWorkflowTaskElementTempAnswer a WHERE a.taskId=:tid ORDER BY a.createDate DESC LIMIT 0, 999999999999999) b GROUP BY b.taskElementId) tempAns ON tempAns.taskElementId = question.id ");
    sql.append("LEFT JOIN (SELECT eleAudit.* FROM ");
    sql.append("(SELECT * from BCIWorkflowAuditTaskElement where taskId=:tid ORDER BY createDate desc) eleAudit, ");
    sql.append(
      "(SELECT i.* FROM BCIWorkflowAuditInstance i LEFT JOIN BCIWorkflowInstance wi ON wi.auditInstanceId = i.id ");
    sql.append("WHERE i.status != 'CANCELLED' AND i.workflowId=:workflowId AND wi.id=:workflowInstanceId ");

    if (businessObject.getBci() != null) {
      sql.append("AND i.bciId=:bcInstanceId  ");
    }

    sql.append("ORDER BY i.createDate DESC LIMIT 0, 1) ins, ");
    sql.append(
      "(SELECT b.* FROM (SELECT a.* FROM BCIWorkflowAuditStep a WHERE a.workflowInstanceId=:workflowInstanceId AND (a.status = 'FINISHED' OR a.status='IN_PROCESS' ) ORDER BY a.createDate DESC) b GROUP BY b.workflowStepId )step, BCIWorkflowStep ws WHERE eleAudit.workflowAuditStepId = step.id AND step.workflowAuditInstanceId = ins.id AND ws.workflowInstanceId=:workflowInstanceId AND ((ws.status = 'IN_PROCESS' AND eleAudit.taskId=:tid) OR (ws.status = 'FINISHED' AND step.workflowStepId = ws.id AND ws.id = :sid )) GROUP BY eleAudit.taskElementId) quesAudit ON question.id = quesAudit.taskElementId ");
    sql.append(
      "WHERE tsk.id =:tid AND tsk.active = 'Y' AND ques.status='ACTIVE' AND task.status = 'ACTIVE' AND task.workflowTaskId =:tid ");
    sql.append("ORDER BY grp.displayOrder ASC, grpEl.displayOrder ASC ");

    org.hibernate.Query query = getSession().createSQLQuery(sql.toString()).addEntity("grp",
        BCWorkflowTaskGroupVersion.class).addEntity("ques", BCWorkflowTaskElementVersion.class).addEntity("ans",
        BCIWorkflowTaskElementAnswer.class).addEntity("tempAns", BCIWorkflowTaskElementTempAnswer.class).addEntity(
        "quesAudit",
        BCIWorkflowAuditTaskElement.class).setLong("tid", workflowTaskId).setLong("sid", flowStepId).setLong(
        "workflowId", workflowId).setInteger("version", version).setLong("workflowInstanceId", workflowInstanceId);

    if (businessObject.getBci() != null) {
      query.setLong("bcInstanceId", businessObject.getBci().getId());
    }


    return query.list();
  } // end method listTaskElementVersion

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#numberOfTaskElementFindings(String,
   *       String, com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance)
   */
  @Override public int numberOfTaskElementFindings(String level, String workflowName, BusinessContextInstance bci) {
    StringBuffer hql = new StringBuffer();
    hql.append("SELECT DISTINCT ins FROM BCIWorkflowInstance ins WHERE ins.bci.id=:bciId  ");
    hql.append(" AND (ins.status='FINISHED' OR ins.status='IN_PROCESS') AND ins.workflow.name = :wName ");
    hql.append(" ORDER BY ins.lastUpdateDate DESC, ins.id DESC ");

    Query query = em.createQuery(hql.toString());
    query.setParameter("bciId", bci.getId());
    query.setParameter("wName", workflowName);
    query.setMaxResults(1);

    List<BCIWorkflowInstance> list  = query.getResultList();
    BCIWorkflowInstance       wi    = (list.size() > 0) ? list.get(0) : null;
    WorkflowAuditingSeverity  sev   = WorkflowAuditingSeverity.convert(level);
    int                       count = 0;

    if ((wi != null) && (sev != null)) {
      BCIWorkflowAuditInstance ai = wi.getAuditInstance();

      if (ai != null) {
        Set<BCIWorkflowAuditStep> aSteps = ai.getStepSet();

        for (BCIWorkflowAuditStep aStep : aSteps) {
          if (WorkflowAuditStepStatus.FINISHED.equals(aStep.getStatus())
                || WorkflowAuditStepStatus.IN_PROCESS.equals(aStep.getStatus())) {
            Set<BCIWorkflowAuditTaskElement> teAudits = aStep.getTaskElementAuditSet();

            for (BCIWorkflowAuditTaskElement teAudit : teAudits) {
              if (FindingType.YES.equals(teAudit.getFinding()) && sev.equals(teAudit.getSeverity())) {
                count++;
              }
            }
          }
        }
      }
    }

    return count;
  } // end method numberOfTaskElementFindings

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#removeWorkflowTaskTempAnswers(Long, com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject)
   */
  @Override public void removeWorkflowTaskTempAnswers(Long taskId, BCIWorkflowBusinessObject businessObject) {
    String hql = "delete BCIWorkflowTaskElementTempAnswer es where es.task.id = :taskId and es.bci.id  = :bciId";
    em.createQuery(hql).setParameter("taskId", taskId).setParameter("bciId",
      ((BCIWorkflowBusinessObject) businessObject).getBci().getId()).executeUpdate();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#save(Object)
   */
  @Override public <T> T save(T entity) {
// getHibernateTemplate().getSessionFactory().openSession().saveOrUpdate(entity);

    return em.merge(entity);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#updateWorkflowStepsWithSpecialBCI(com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance,
   *       com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowStep)
   */
  @Override public void updateWorkflowStepsWithSpecialBCI(BusinessContextInstance instance,
    BCIWorkflowStep currentStep) {
    getSession().createSQLQuery(
      "UPDATE BCIWorkflowStep step, BCIWorkflowStep curStep, BCIWorkflowStep oldStep SET step.fixBciId=:bciId WHERE curStep.id = :curStepId "
      + "AND curStep.workflowInstanceId = oldStep.workflowInstanceId AND curStep.depthPath = oldStep.depthPath AND curStep.id <> oldStep.id "
      + "AND step.stepNumber > oldStep.stepNumber AND step.stepNumber <=  curStep.stepNumber "
      + "AND step.workflowInstanceId = oldStep.workflowInstanceId AND (step.status = 'FINISHED' or step.status = 'IN_PROCESS') AND step.fixBciId IS NULL ")
      .setParameter("curStepId", currentStep.getId()).setParameter("bciId", instance.getId()).executeUpdate();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#updateWorkflowStepsWithSpecialBCI(Long,
   *       Long, Long)
   */
  @Override public void updateWorkflowStepsWithSpecialBCI(Long previousBCIID, Long workflowInstanceId,
    Long workflowStepId) {
    StringBuffer updateSql = new StringBuffer();
    updateSql.append("UPDATE BCIWorkflowStep step, BCIWorkflowStep curStep, BCIWorkflowStep oldStep ");
    updateSql.append("SET step.fixBciId=:bciId ");
    updateSql.append("WHERE curStep.id =:workflowStepId ");
    updateSql.append(
      "AND curStep.workflowInstanceId = oldStep.workflowInstanceId AND curStep.depthPath = oldStep.depthPath ");
    updateSql.append("AND curStep.id <> oldStep.id AND oldStep.fixBciId IS NULL ");
    updateSql.append(
      "AND step.stepNumber <= oldStep.stepNumber AND step.stepNumber <  curStep.stepNumber AND oldStep.stepNumber <  curStep.stepNumber ");
    updateSql.append(
      "AND step.workflowInstanceId = oldStep.workflowInstanceId AND step.status = 'FINISHED' AND step.fixBciId IS NULL ");
    updateSql.append(
      "AND step.stepNumber >= (select min(a.stepNumber) from (select min(s.stepNumber) as stepNumber from BCIWorkflowStep s where s.workflowInstanceId =:workflowInstanceId AND s.status = 'FINISHED'   GROUP BY s.depthPath having count(s.id) >1 ) a) ");

    getSession().createSQLQuery(updateSql.toString()).setParameter("bciId", previousBCIID).setParameter(
      "workflowStepId", workflowStepId).setParameter("workflowInstanceId", workflowInstanceId).executeUpdate();
  }

  //~ ------------------------------------------------------------------------------------------------------------------
  
  /**
   * @see  com.ozstrategy.credagility.core.repository.BCWorkflowRepository#batchSave(java.util.List)
   */
  @Override @Transactional public List<Object> batchSave(List<Object> entities) {
    List<Object> savedEntities = new ArrayList<Object>(entities.size());

    for(Iterator<Object> iter = entities.iterator();iter.hasNext();){
      Object entity = iter.next();
      logger.info("Save object: " + entity.getClass().getName());
      entity = em.merge(entity);
      savedEntities.add(entity);
    }

    return savedEntities;
    
//    int idx       = 0;
//    int batchSize = 20;
//    int s         = 0;
//
//    int batches = new Double(Math.ceil(entities.size() / Double.parseDouble("" + batchSize))).intValue();
//
//    logger.info("total: " + entities.size() + ", batchSize: " + batchSize + ", batches: " + batches);
//
//    for (int i = 0; i < batches; i++) {
//      int          toIndex     = Math.min((i + 1) * batchSize, entities.size());
//      List<Object> subEntities = entities.subList(idx, toIndex);
//      idx += batchSize;
//
//      for (Object entity : subEntities) {
//        logger.info("save object: " + entity.getClass().getName() + ". >> index. " + (++s));
//        em.merge(entity);
//      }
//
//      em.flush();
//      em.clear();
//
//      try {
//        Thread.sleep(new Random().nextInt(50));
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//    }
  } // end method batchSave
} // end class BCWorkflowRepositoryImpl
