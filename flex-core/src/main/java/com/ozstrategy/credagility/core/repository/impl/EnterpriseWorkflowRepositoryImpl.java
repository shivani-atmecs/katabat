package com.ozstrategy.credagility.core.repository.impl;

import com.cmc.credagility.core.domain.account.AccountFlowVariableValue;
import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.cmc.credagility.core.domain.portfolio.PortfolioSurveyAnswer;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.SurveyFlowAuditInstance;
import com.ozstrategy.credagility.core.domain.SurveyFlowAuditQuestion;
import com.ozstrategy.credagility.core.domain.SurveyFlowAuditStep;
import com.ozstrategy.credagility.core.domain.SurveyFlowInstance;
import com.ozstrategy.credagility.core.domain.audit.FindingType;
import com.ozstrategy.credagility.core.domain.document.DocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.agency.AgencyDocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.agent.AgentDocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.bci.BCIDocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.enterprise.EnterpriseDocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.document.responsible.ResponsibleDocumentMetaDataValue;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowAuditStepStatus;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowAuditingSeverity;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.agency.AgencyWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.agency.AgencyWorkflowTaskElementAnswer;
import com.ozstrategy.credagility.core.domain.workflow.agency.AgencyWorkflowVariableValue;
import com.ozstrategy.credagility.core.domain.workflow.agent.AgentWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.agent.AgentWorkflowTaskElementAnswer;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.ent.EnterpriseWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.ent.EnterpriseWorkflowTaskElementAnswer;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.*;
import com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  03/24/2015 17:03
 */
@Repository("enterpriseWorkflowRRepository")
public class EnterpriseWorkflowRepositoryImpl implements EnterpriseWorkflowRepository {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @PersistenceContext private EntityManager em;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#countCompletedTaskElements(com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject,
   *       String)
   */
  @Override public int countCompletedTaskElements(WorkflowBusinessObject businessObject, String tag) {
    String hql = null;

    if (businessObject instanceof EnterpriseWorkflowBusinessObject) {
      hql =
        "select count(distinct ans.taskElement) from EnterpriseWorkflowTaskElementAnswer ans, EnterpriseWorkflow flow , AgencyBusinessProcessInstance abpi, EnterpriseWorkflowSchedule sche where abpi.current = true and abpi.agency = :obj and abpi.schedule = sche and flow.tag =:tag and ans.workflow=flow and flow.schedule = sche and sche.scheduleStatus='ACTIVE' and ans.businessObject=:obj";
    } else if (businessObject instanceof AgentWorkflowBusinessObject) {
      hql =
        "select count(distinct ans.taskElement) from AgentWorkflowTaskElementAnswer ans, EnterpriseWorkflow flow , AgencyBusinessProcessInstance abpi, AgentWorkflowSchedule sche where abpi.current = true and abpi.agency = :obj and abpi.schedule = sche and flow.tag =:tag and ans.workflow=flow and flow.schedule = sche and sche.scheduleStatus='ACTIVE' and ans.businessObject=:obj";
    } else if (businessObject instanceof AgencyWorkflowBusinessObject) {
      hql =
        "select count(distinct ans.taskElement) from AgencyWorkflowTaskElementAnswer ans, EnterpriseWorkflow flow , AgencyBusinessProcessInstance abpi, AgencyWorkflowSchedule sche where abpi.current = true and abpi.agency = :obj and abpi.schedule = sche and flow.tag =:tag and ans.workflow=flow and flow.schedule = sche and sche.scheduleStatus='ACTIVE' and ans.businessObject=:obj";

// "select count(distinct ans.taskElement) from AgencyWorkflowTaskElementAnswer ans, EnterpriseWorkflow flow where flow.tag =:tag and ans.workflow=flow and flow.schedule.scheduleStatus='ACTIVE' and ans.businessObject=:obj";
    }

    Query query = em.createQuery(hql);
    query.setParameter("tag", tag);
    query.setParameter("obj", businessObject.getObject());

    Object obj   = query.getSingleResult();
    int    count = (obj instanceof BigInteger) ? ((BigInteger) obj).intValue() : ((Long) obj).intValue();

    return count;
  } // end method countCompletedTaskElements

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#get(Class, Object)
   */
  @Override public <T> T get(Class<T> entityClass, Object primaryKey) {
    return em.find(entityClass, primaryKey);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getAgencyWorkflowVariableValue(com.cmc.credagility.core.domain.user.Role,
   *       Long)
   */
  @Override public WorkflowVariableValue getAgencyWorkflowVariableValue(Role agency, Long variableId) {
    String hql =
      "select val from AgencyWorkflowVariableValue val where val.businessObject=:businessObject and val.variable.id =:variableId order by val.createDate desc";

    Query query = em.createQuery(hql).setParameter("businessObject", agency).setParameter("variableId",
        variableId);

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (WorkflowVariableValue) list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getAgentWorkflowVariableValue(com.cmc.credagility.core.domain.user.User,
   *       Long)
   */
  @Override public WorkflowVariableValue getAgentWorkflowVariableValue(User agent, Long variableId) {
    String hql =
      " select val from AgentWorkflowVariableValue val where val.businessObject=:businessObject and val.variable.id =:variableId order by val.createDate desc";

    Query query = em.createQuery(hql).setParameter("businessObject", agent).setParameter("variableId",
        variableId);

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (WorkflowVariableValue) list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getDocMetaDataByDoc(Long, String)
   */
  @Override public EnterpriseDocumentMetaDataValue getDocMetaDataByDoc(Long docId, String metaDataName) {
    String hql   =
      "select metaDataValue from EnterpriseDocumentInstance ins left join ins.metaDataValues metaDataValue where ins.document.id= :docId and ins.active = true and metaDataValue.name = :metaDataName";
    Query  query = em.createQuery(hql);
    query.setParameter("docId", docId).setParameter("metaDataName", metaDataName);

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (EnterpriseDocumentMetaDataValue) list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getDocMetaDataByDoc(com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject,
   *       Long, String)
   */
  @Override public DocumentMetaDataValue getDocMetaDataByDoc(WorkflowBusinessObject businessObject, Long docId,
    String metaDataName) {
    if (businessObject instanceof EnterpriseWorkflowBusinessObject) {
      return getDocMetaDataByDoc(docId, metaDataName);
    } else if (businessObject instanceof AgencyWorkflowBusinessObject) {
      return getDocMetaDataByDoc((Role) businessObject.getObject(), docId, metaDataName);
    } else if (businessObject instanceof AgentWorkflowBusinessObject) {
      return getDocMetaDataByDoc((User) businessObject.getObject(), docId, metaDataName);
    } else if (businessObject instanceof BCIWorkflowBusinessObject) {
      return getDocMetaDataByDoc(((BCIWorkflowBusinessObject) businessObject).getBci(), docId, metaDataName);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getDocMetaDataByDoc(com.cmc.credagility.core.domain.user.Role,
   *       Long, String)
   */
  @Override public AgencyDocumentMetaDataValue getDocMetaDataByDoc(Role agency, Long docId, String metaDataName) {
    String hql   =
      "select metaDataValue from AgencyDocumentInstance ins left join ins.metaDataValues metaDataValue where ins.document.id= :docId and ins.active = true and metaDataValue.name = :metaDataName and ins.owner = :agency ORDER BY metaDataValue.lastUpdateDate DESC";
    Query  query = em.createQuery(hql);
    query.setParameter("docId", docId).setParameter("metaDataName", metaDataName).setParameter("agency", agency);

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (AgencyDocumentMetaDataValue) list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getDocMetaDataByDoc(com.cmc.credagility.core.domain.user.User,
   *       Long, String)
   */
  @Override public AgentDocumentMetaDataValue getDocMetaDataByDoc(User agent, Long docId, String metaDataName) {
    String hql   =
      "select metaDataValue from AgentDocumentInstance ins left join ins.metaDataValues metaDataValue where ins.document.id= :docId and ins.active = true and metaDataValue.name = :metaDataName and ins.owner = :agent";
    Query  query = em.createQuery(hql);
    query.setParameter("docId", docId).setParameter("metaDataName", metaDataName).setParameter("agent", agent);

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (AgentDocumentMetaDataValue) list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getDocMetaDataByDoc(com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance,
   *       Long, String)
   */
  @Override public BCIDocumentMetaDataValue getDocMetaDataByDoc(BusinessContextInstance bci, Long docId,
    String metaDataName) {
    String hql   =
      "select metaDataValue from BCIDocumentInstance ins left join ins.metaDataValues metaDataValue where ins.document.id= :docId and ins.active = true and metaDataValue.name = :metaDataName and ins.bci = :bci";
    Query  query = em.createQuery(hql);
    query.setParameter("docId", docId).setParameter("metaDataName", metaDataName).setParameter("bci", bci);

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (BCIDocumentMetaDataValue) list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getDocMetaDataByDoc(com.cmc.credagility.core.domain.responsible.Responsible,
   *       Long, String)
   */
  @Override public ResponsibleDocumentMetaDataValue getDocMetaDataByDoc(Responsible responsible, Long docId,
    String metaDataName) {
    String hql   =
      "SELECT metaDataValue FROM ResponsibleDocumentInstance ins LEFT JOIN ins.metaDataValues metaDataValue WHERE ins.document.id= :docId AND ins.active =true AND metaDataValue.name = :metaDataName AND ins.owner = :responsible ORDER BY metaDataValue.lastUpdateDate DESC";
    Query  query = em.createQuery(hql);
    query.setParameter("docId", docId).setParameter("metaDataName", metaDataName).setParameter("responsible",
      responsible);

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (ResponsibleDocumentMetaDataValue) list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getEnterpriseWorkflowVariableValue(Long)
   */
  @Override public WorkflowVariableValue getEnterpriseWorkflowVariableValue(Long variableId) {
    String hql =
      "select val from EnterpriseWorkflowVariableValue val where val.businessObject=:businessObject and val.variable.id =:variableId order by val.createDate desc";

    Query query = em.createQuery(hql).setParameter("variableId", variableId);

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (WorkflowVariableValue) list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getLastAgencyUtilityData(com.ozstrategy.credagility.core.domain.workflow.agency.AgencyWorkflowBusinessObject,
   *       String)
   */
  @Override public AgencyWorkflowVariableValue getLastAgencyUtilityData(AgencyWorkflowBusinessObject businessObject,
    String variableName) {
    String hql =
      "SELECT v AgencyWorkflowVariableValue v WHERE v.variable.name=:variableName AND v.businessObject=:businessObject ORDER BY v.id DESC ";

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
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getLastPortfolioSurveyAnswerDataByCode(Long,
   *       Long, String)
   */
  @Override public PortfolioSurveyAnswer getLastPortfolioSurveyAnswerDataByCode(Long accountNum,
    Long workflowInstanceId, String questionCode) {
    StringBuffer hql = new StringBuffer();
    hql.append("FROM PortfolioSurveyAnswer answer WHERE answer.flowStep.status='FINISHED' ");
    hql.append(
      "AND (answer.flowStep.surveyFlowInstance.status='FINISHED' OR answer.flowStep.surveyFlowInstance.status='IN_PROCESS') ");
    hql.append(
      "AND answer.question.questionCode =:questionCode and answer.responsible.account.accountNum =:accountNum ");


    hql.append("ORDER BY ");

    if (workflowInstanceId != null) {
      hql.append(" CASE WHEN answer.flowStep.surveyFlowInstance.id =:workflowInstanceId THEN 1 END desc, ");
    }

    hql.append("answer.surveyDate DESC ");

    Query query = em.createQuery(hql.toString());

    query.setParameter("questionCode", questionCode).setParameter("accountNum", accountNum);

    if (workflowInstanceId != null) {
      query.setParameter("workflowInstanceId", workflowInstanceId);
    }

    query.setMaxResults(1);

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (PortfolioSurveyAnswer) list.get(0);
    }

    return null;
  } // end method getLastPortfolioSurveyAnswerDataByCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getLastTaskElementAnswerData(Long)
   */
  @Override public EnterpriseWorkflowTaskElementAnswer getLastTaskElementAnswerData(Long taskElementId) {
    String hql   = "from EnterpriseWorkflowTaskElementAnswer where taskElement.id = ? order by answerDate desc";
    Query  query = em.createQuery(hql).setParameter(0, taskElementId);

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (EnterpriseWorkflowTaskElementAnswer) list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getLastTaskElementAnswerData(com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject,
   *       Long)
   */
  @Override public WorkflowTaskElementAnswer getLastTaskElementAnswerData(WorkflowBusinessObject businessObject,
    Long taskElementId) {
    if (businessObject instanceof EnterpriseWorkflowBusinessObject) {
      return getLastTaskElementAnswerData(taskElementId);
    } else if (businessObject instanceof AgencyWorkflowBusinessObject) {
      return getLastTaskElementAnswerData((Role) businessObject.getObject(), taskElementId);
    } else if (businessObject instanceof AgentWorkflowBusinessObject) {
      return getLastTaskElementAnswerData((User) businessObject.getObject(), taskElementId);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getLastTaskElementAnswerData(com.cmc.credagility.core.domain.user.Role,
   *       Long)
   */
  @Override public AgencyWorkflowTaskElementAnswer getLastTaskElementAnswerData(Role agency, Long taskElementId) {
    String hql   =
      "from AgencyWorkflowTaskElementAnswer where taskElement.id = ? and businessObject = ? order by answerDate desc";
    Query  query = em.createQuery(hql).setParameter(0, taskElementId).setParameter(1, agency);

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (AgencyWorkflowTaskElementAnswer) list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getLastTaskElementAnswerData(com.cmc.credagility.core.domain.user.User,
   *       Long)
   */
  @Override public AgentWorkflowTaskElementAnswer getLastTaskElementAnswerData(User agent, Long taskElementId) {
    String hql   =
      "from AgentWorkflowTaskElementAnswer answer where answer.workflowStep.status='FINISHED' AND (answer.workflowStep.workflowInstance.status='FINISHED' OR answer.workflowStep.workflowInstance.status='IN_PROCESS') AND answer.taskElement.id = ? and answer.businessObject = ? order by answer.answerDate desc";
    Query  query = em.createQuery(hql).setParameter(0, taskElementId).setParameter(1, agent);

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (AgentWorkflowTaskElementAnswer) list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getLastTaskElementAnswerData(String,
   *       com.ozstrategy.credagility.core.domain.workflow.ent.EnterpriseWorkflowBusinessObject)
   */
  @Override public EnterpriseWorkflowTaskElementAnswer getLastTaskElementAnswerData(String taskElementCode,
    EnterpriseWorkflowBusinessObject businessObject) {
    StringBuffer hql = new StringBuffer();

    hql.append(
      "SELECT ans FROM EnterpriseWorkflowTaskElementAnswer ans WHERE taskElement.questionCode = :taskElementCode ");

    hql.append(" ORDER BY ");

    if (businessObject.getWorkflowInstanceId() != null) {
      hql.append(" CASE WHEN ans.workflowStep.workflowInstance.id =:workflowInstanceId then 1 END DESC, ");
    }

    hql.append(" answerDate DESC");

    Query query = em.createQuery(hql.toString()).setParameter("taskElementCode", taskElementCode);

    if (businessObject.getWorkflowInstanceId() != null) {
      query.setParameter("workflowInstanceId", businessObject.getWorkflowInstanceId());
    }

    query.setMaxResults(1);

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (EnterpriseWorkflowTaskElementAnswer) list.get(0);
    }

    return null;
  } // end method getLastTaskElementAnswerData

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getLastTaskElementAnswerData(com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject,
   *       String)
   */
  @Override public WorkflowTaskElementAnswer getLastTaskElementAnswerData(WorkflowBusinessObject businessObject,
    String taskElementCode) {
    if (businessObject instanceof EnterpriseWorkflowBusinessObject) {
      return getLastTaskElementAnswerData(taskElementCode, (EnterpriseWorkflowBusinessObject) businessObject);
    } else if (businessObject instanceof AgencyWorkflowBusinessObject) {
      return getLastTaskElementAnswerData((AgencyWorkflowBusinessObject) businessObject, taskElementCode);
    } else if (businessObject instanceof AgentWorkflowBusinessObject) {
      return getLastTaskElementAnswerData((AgentWorkflowBusinessObject) businessObject, taskElementCode);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getLastUtilityData(String, Long)
   */
  @Override public AccountFlowVariableValue getLastUtilityData(String variableName, Long accountNum) {
    String hql =
      "SELECT v AccountFlowVariableValue v WHERE v.variable.name=:variableName AND v.account.accountNum=:accountNum ORDER BY v.id DESC";

    Query query = em.createQuery(hql);
    query.setParameter("variableName", variableName).setParameter("accountNum", accountNum);
    query.setMaxResults(1);

    List list = query.getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (AccountFlowVariableValue) list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getTaskElementsByTag(String)
   */
  @Override public List<EnterpriseWorkflowTaskElement> getTaskElementsByTag(String tag) {
    StringBuffer hql   = new StringBuffer(
        "select distinct(wtge.taskElement) from EnterpriseWorkflowTaskGroupElement wtge, EnterpriseWorkflowTask wt,")
      .append(" EnterpriseWorkflowNode node, EnterpriseWorkflow flow").append(
        " where flow.tag = :tag and wtge.task = wt and node.workflowTask = wt and node.workflow = flow and flow.schedule.scheduleStatus='ACTIVE'");
    Query        query = em.createQuery(hql.toString());
    query.setParameter("tag", tag);

    return query.getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getWorkflowInstanceDocumentTemplate(Long,
   *       Long, String)
   */
  @Override public WorkflowInstanceDocumentTemplate getWorkflowInstanceDocumentTemplate(Long documentId,
    Long flowInstanceId, String locale) {
    String hql   =
      "FROM WorkflowInstanceDocumentTemplate s WHERE s.document.id = :dId AND s.instance.id = :iId AND s.locale=:locale";
    Query  query = em.createQuery(hql);
    query.setParameter("dId", documentId).setParameter("iId", flowInstanceId).setParameter("locale", locale);

    List<WorkflowInstanceDocumentTemplate> list = query.getResultList();

    return ((list != null) && (list.size() > 0)) ? list.get(0) : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#getWorkflowVariableValue(com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject,
   *       Long)
   */
  @Override public WorkflowVariableValue getWorkflowVariableValue(WorkflowBusinessObject businessObject,
    Long variableId) {
    if (businessObject instanceof EnterpriseWorkflowBusinessObject) {
      return getEnterpriseWorkflowVariableValue(variableId);
    } else if (businessObject instanceof AgencyWorkflowBusinessObject) {
      return getAgencyWorkflowVariableValue((Role) businessObject.getObject(), variableId);
    } else if (businessObject instanceof AgentWorkflowBusinessObject) {
      return getAgentWorkflowVariableValue((User) businessObject.getObject(), variableId);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#numberOfCompletedCustomerTasks(com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject,
   *       String)
   */
  @Override public List<EnterpriseWorkflowTask> numberOfCompletedCustomerTasks(WorkflowBusinessObject businessObject,
    String tag) {
    StringBuffer hql   = new StringBuffer("select distinct(wt) from ");
    Query        query = null;

    if (businessObject instanceof EnterpriseWorkflowBusinessObject) {
// hql.append("EnterpriseWorkflowTaskElementAnswer wea, EnterpriseWorkflow flow, EnterpriseWorkflowTask wt").append(
// " where flow.tag = :tag and wea.workflow = flow and wea.task = wt and wt.customerOnly = 'Y' and flow.schedule.scheduleStatus='ACTIVE' and wea.businessObject=:obj");

      hql.append("EnterpriseWorkflowTaskElementAnswer wea,").append(
        " EnterpriseWorkflow flow, EnterpriseWorkflowTask wt, AgencyBusinessProcessInstance abpi, EnterpriseWorkflowSchedule sche")
        .append(
          " where abpi.current = true and abpi.agency = :obj and abpi.schedule = sche and flow.tag = :tag and wea.workflow = flow and wea.task = wt and wt.customerOnly = true and flow.schedule = sche and sche.scheduleStatus='ACTIVE' and wea.businessObject=:obj");
      query = em.createQuery(hql.toString());
      query.setParameter("tag", tag);
      query.setParameter("obj", businessObject.getObject());
    } else if (businessObject instanceof AgentWorkflowBusinessObject) {
// hql.append("AgentWorkflowTaskElementAnswer wea,").append(" EnterpriseWorkflow flow, EnterpriseWorkflowTask wt").append(
// " where flow.tag = :tag and wea.workflow = flow and wea.task = wt and wt.customerOnly = true and flow.schedule.scheduleStatus='ACTIVE' and wea.businessObject=:obj");

      hql.append("AgentWorkflowTaskElementAnswer wea,").append(
        " EnterpriseWorkflow flow, EnterpriseWorkflowTask wt, AgencyBusinessProcessInstance abpi, AgentWorkflowSchedule sche")
        .append(
          " where abpi.current = true and abpi.agency = :obj and abpi.schedule = sche and flow.tag = :tag and wea.workflow = flow and wea.task = wt and wt.customerOnly = true and flow.schedule = sche and sche.scheduleStatus='ACTIVE' and wea.businessObject=:obj");
      query = em.createQuery(hql.toString());
      query.setParameter("tag", tag);
      query.setParameter("obj", businessObject.getObject());
    } else if (businessObject instanceof AgencyWorkflowBusinessObject) {
// hql.append("AgencyWorkflowTaskElementAnswer wea,").append(" EnterpriseWorkflow flow, EnterpriseWorkflowTask wt").append(
// " where flow.tag = :tag and wea.workflow = flow and wea.task = wt and wt.customerOnly = true and flow.schedule.scheduleStatus='ACTIVE' and wea.businessObject=:obj");

      hql.append("AgencyWorkflowTaskElementAnswer wea,").append(
        " EnterpriseWorkflow flow, EnterpriseWorkflowTask wt, AgencyBusinessProcessInstance abpi, AgencyWorkflowSchedule sche")
        .append(
          " where abpi.current = true and abpi.agency = :obj and abpi.schedule = sche and flow.tag = :tag and wea.workflow = flow and wea.task = wt and wt.customerOnly = true and flow.schedule = sche and sche.scheduleStatus='ACTIVE' and wea.businessObject=:obj");

      query = em.createQuery(hql.toString());
      query.setParameter("tag", tag);
      query.setParameter("obj", businessObject.getObject());
    } // end if-else

    if (query == null) {
      return Collections.emptyList();
    }

    return query.getResultList();
  } // end method numberOfCompletedCustomerTasks

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#numberOfCompletedTask(com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject,
   *       String)
   */
  @Override public int numberOfCompletedTask(WorkflowBusinessObject businessObject, String tag) {
    StringBuffer hql   = new StringBuffer("select count(distinct wea.task) from ");
    Query        query = null;

    if (businessObject instanceof EnterpriseWorkflowBusinessObject) {
      hql.append("EnterpriseWorkflowTaskElementAnswer wea,").append(
        " EnterpriseWorkflow flow, AgencyBusinessProcessInstance abpi, EnterpriseWorkflowSchedule sche").append(
        " where abpi.current = true and abpi.agency = :obj and abpi.schedule = sche and flow.tag = :tag and wea.workflow = flow and flow.schedule = sche and sche.scheduleStatus='ACTIVE' and wea.businessObject=:obj");
      query = em.createQuery(hql.toString());
      query.setParameter("tag", tag);
      query.setParameter("obj", businessObject.getObject());
    } else if (businessObject instanceof AgentWorkflowBusinessObject) {
      hql.append("AgentWorkflowTaskElementAnswer wea,").append(
        " EnterpriseWorkflow flow, AgencyBusinessProcessInstance abpi, AgentWorkflowSchedule sche").append(
        " where abpi.current = true and abpi.agency = :obj and abpi.schedule = sche and flow.tag = :tag and wea.workflow = flow and flow.schedule = sche and sche.scheduleStatus='ACTIVE' and wea.businessObject=:obj");
      query = em.createQuery(hql.toString());
      query.setParameter("tag", tag);
      query.setParameter("obj", businessObject.getObject());
    } else if (businessObject instanceof AgencyWorkflowBusinessObject) {
      hql.append("AgencyWorkflowTaskElementAnswer wea,").append(
        " EnterpriseWorkflow flow, AgencyBusinessProcessInstance abpi, AgencyWorkflowSchedule sche").append(
        " where abpi.current = true and abpi.agency = :obj and abpi.schedule = sche and flow.tag = :tag and wea.workflow = flow and flow.schedule = sche and sche.scheduleStatus='ACTIVE' and wea.businessObject=:obj");
      query = em.createQuery(hql.toString());
      query.setParameter("tag", tag);
      query.setParameter("obj", businessObject.getObject());
    } // end if-else
    if (query == null) {
      return 0;
    }
    Object obj   = query.getSingleResult();
    int    count = (obj instanceof BigInteger) ? ((BigInteger) obj).intValue() : ((Long) obj).intValue();

    return count;
  } // end method numberOfCompletedTask

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#numberOfCustomerTasks(String)
   */
  @Override public List<EnterpriseWorkflowTask> numberOfCustomerTasks(String tag) {
    StringBuffer hql   = new StringBuffer(
        "select distinct(wt) from EnterpriseWorkflowTask wt,").append(
        " EnterpriseWorkflowNode node, EnterpriseWorkflow flow").append(
        " where flow.tag = :tag and node.workflowTask = wt and wt.customerOnly = true and node.workflow = flow and flow.schedule.scheduleStatus='ACTIVE'");
    Query        query = em.createQuery(hql.toString());
    query.setParameter("tag", tag);

    return query.getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#numberOfSurveyQuestionFindings(String,
   *       String, Long)
   */
  @Override public int numberOfSurveyQuestionFindings(String level, String workflowName, Long responsibleId) {
    StringBuffer hql = new StringBuffer();
    hql.append(
      "SELECT DISTINCT ins FROM SurveyFlowInstance ins, Responsible res WHERE ins.account.accountNum=res.accountNum ");
    hql.append(" AND ins.flowId = w.id AND (ins.status='FINISHED' OR ins.status='IN_PROCESS') ");
    hql.append(" AND res.responsibleId=:responsibleId AND w.name=:wName ");
    hql.append(" ORDER BY ins.lastUpdateDate DESC, ins.id DESC ");

    Query query = em.createQuery(hql.toString());
    query.setParameter("responsibleId", responsibleId);
    query.setParameter("wName", workflowName);
    query.setMaxResults(1);

    List<SurveyFlowInstance> list  = query.getResultList();
    SurveyFlowInstance       wi    = (list.size() > 0) ? list.get(0) : null;
    WorkflowAuditingSeverity sev   = WorkflowAuditingSeverity.convert(level);
    int                      count = 0;

    if ((wi != null) && (sev != null)) {
      SurveyFlowAuditInstance ai = wi.getAuditInstance();

      if (ai != null) {
        Set<SurveyFlowAuditStep> aSteps = ai.getStepSet();

        for (SurveyFlowAuditStep aStep : aSteps) {
          if (WorkflowAuditStepStatus.FINISHED.equals(aStep.getStatus())
                || WorkflowAuditStepStatus.IN_PROCESS.equals(aStep.getStatus())) {
            Set<SurveyFlowAuditQuestion> teAudits = aStep.getQuestionAuditSet();

            for (SurveyFlowAuditQuestion teAudit : teAudits) {
              if (FindingType.YES.equals(teAudit.getFinding()) && sev.equals(teAudit.getSeverity())) {
                count++;
              }
            }
          }
        }
      }
    }

    return count;
  } // end method numberOfSurveyQuestionFindings

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#numberOfTask(String)
   */
  @Override public List<EnterpriseWorkflowTask> numberOfTask(String tag) {
    Query query = em.createQuery("select distinct(node.id) from EnterpriseWorkflowNode node, "
        + "EnterpriseWorkflow flow where flow.tag = :tag and node.type = 'SURVEY_NODE' and node.workflow = flow and flow.schedule.scheduleStatus='ACTIVE'");
    query.setParameter("tag", tag);

    return query.getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseWorkflowRepository#numberOfTaskElementFindings(String,
   *       String, String, Long)
   */
  @Override public int numberOfTaskElementFindings(String category, String level, String workflowName, Long ownerId) {
    String businessObjQuery = "";

    if ("Agency".equalsIgnoreCase(category)) {
      businessObjQuery = "AND agencyBusinessObjectId=:oid ";
    } else if ("Agent".equalsIgnoreCase(category)) {
      businessObjQuery = "AND agentBusinessObjectId=:oid ";
    }

    Query query = em.createQuery(
        "select distinct ins from WorkflowInstance ins where category = :category and (ins.status='FINISHED' OR ins.status='IN_PROCESS') and ins.workflow.name = :wName "
        + businessObjQuery + " ORDER BY ins.lastUpdateDate DESC, ins.id DESC");

    query.setParameter("category", category);
    query.setParameter("wName", workflowName);
    query.setMaxResults(1);

    if (StringUtils.hasText(businessObjQuery)) {
      query.setParameter("oid", ownerId);
    }

    List<WorkflowInstance>   list  = query.getResultList();
    WorkflowInstance         wi    = (list.size() > 0) ? list.get(0) : null;
    WorkflowAuditingSeverity sev   = WorkflowAuditingSeverity.convert(level);
    int                      count = 0;

    if ((wi != null) && (sev != null)) {
      WorkflowAuditInstance ai = wi.getAuditInstance();

      if (ai != null) {
        Set<WorkflowAuditStep> aSteps = ai.getStepSet();

        for (WorkflowAuditStep aStep : aSteps) {
          if (WorkflowAuditStepStatus.FINISHED.equals(aStep.getStatus())
                || WorkflowAuditStepStatus.IN_PROCESS.equals(aStep.getStatus())) {
            Set<EnterpriseWorkflowAuditTaskElement> teAudits = aStep.getTaskElementAuditSet();

            for (EnterpriseWorkflowAuditTaskElement teAudit : teAudits) {
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
} // end class EnterpriseWorkflowRepositoryImpl
