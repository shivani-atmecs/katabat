package com.ozstrategy.credagility.core.repository.impl;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.cmc.credagility.core.domain.client.BaseUrlInfo;
import com.cmc.credagility.core.domain.document.DocumentStatus;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.LocaleType;
import com.ozstrategy.credagility.core.domain.SurveyFlowInstanceDocumentTemplate;
import com.ozstrategy.credagility.core.domain.document.*;
import com.ozstrategy.credagility.core.domain.document.agency.AgencyUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.document.agent.AgentUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.document.enterprise.EnterpriseUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.document.responsible.ResponsibleDocumentInstance;
import com.ozstrategy.credagility.core.domain.workflow.ContextType;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.agency.AgencyWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.agent.AgentWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.ent.EnterpriseWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.responsible.ResponsibleWorkflowBusinessObject;
import com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository;
import com.ozstrategy.credagility.core.repository.OzHibernateDaoSupport;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.util.List;
import java.util.Locale;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 15:52
 */
@Repository("enterpriseDocumentRepository")
public class EnterpriseDocumentRepositoryImpl extends OzHibernateDaoSupport implements EnterpriseDocumentRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findEnterPriseDocumentByNameAndContext.
   *
   * @param   name         String
   * @param   contextType  String
   *
   * @return  List
   */
  @Override public List<EnterpriseDocument> findEnterPriseDocumentByNameAndContext(String name, String contextType) {
    StringBuffer queryStr = new StringBuffer("SELECT e FROM EnterpriseDocument e");

    if ("account".equalsIgnoreCase(contextType) || "responsible".equalsIgnoreCase(contextType)) {
      queryStr.append(" JOIN e.assignedPortfolios p ");
    }

    queryStr.append(" WHERE e.status='ENABLE' AND e.name=:docName AND e.contextType=:contextType ");


    List list = em.createQuery(queryStr.toString()).setParameter("docName", name).setParameter("contextType",
        contextType).getResultList();

    return list;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#findFirstByNameAndContextType(String,
   *       String)
   */
  @Override public EnterpriseDocument findFirstByNameAndContextType(String name, String contextType) {
    List list = em.createQuery("from EnterpriseDocument e where e.name=:name and e.contextType=:contextType")
      .setParameter("name", name).setParameter("contextType", contextType).getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (EnterpriseDocument) list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#findFirstByResDocId(Long, Long)
   */
  @Override public List<ResponsibleDocumentInstance> findFirstByResDocId(Long responsibleId, Long documentId) {
    String hql =
      "    from ResponsibleDocumentInstance where owner.responsibleId = :responsibleId AND document.id = :documentId AND active=true ORDER BY createDate DESC";

    return em.createQuery(hql).setParameter("responsibleId", responsibleId).setParameter("documentId", documentId)
      .getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#findFirstByUniqueIdAndContextType(String,
   *       String)
   */
  @Override public EnterpriseDocument findFirstByUniqueIdAndContextType(String uniqueId, String contextType) {
    List list = em.createQuery("from EnterpriseDocument e where e.uniqueId=:uniqueId and e.contextType=:contextType")
      .setParameter("uniqueId", uniqueId).setParameter("contextType", contextType).getResultList();

    if ((list != null) && (list.size() > 0)) {
      return (EnterpriseDocument) list.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#findWorkflowDocumentInstance(String,
   *       Long)
   */
  @Override public BasicDocumentInstance findWorkflowDocumentInstance(String category, Long docInstanceId) {
    Query query = null;

    if (ContextType.AGENCY.name().equalsIgnoreCase(category)) {
      query = getSession().createQuery(" from AgencyDocumentInstance where id = ?");
    } else if (ContextType.AGENT.name().equalsIgnoreCase(category)) {
      query = getSession().createQuery(" from AgentDocumentInstance where id = ?");
    } else if (ContextType.RESPONSIBLE.name().equalsIgnoreCase(category)) {
      query = getSession().createQuery(" from ResponsibleDocumentInstance where id = ?");
    } else if (ContextType.ENTERPRISE.name().equalsIgnoreCase(category)) {
      query = getSession().createQuery(" from EnterpriseDocumentInstance where id = ?");
    } else if (ContextType.BUSINESS.name().equalsIgnoreCase(category)) {
      query = getSession().createQuery(" from BCIDocumentInstance where id= ? ");
    }

    if (query == null) {
      return null;
    } else {
      return (BasicDocumentInstance) query.setParameter(0, docInstanceId).uniqueResult();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#get(Class, Object)
   */
  @Override public <T> T get(Class<T> entityClass, Object primaryKey) {
    return em.find(entityClass, primaryKey);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getAccountDocumentHtmlContent(com.cmc.credagility.core.domain.responsible.Responsible,
   *       String)
   */
  @Override public String getAccountDocumentHtmlContent(Responsible responsible, String documentName) {
    if ((!StringUtils.hasText(documentName)) || (responsible == null)) {
      return null;
    }

    Account                   account     = responsible.getAccount();
    Long                      portfolioId = account.getPortfolio().getPortfolioId();
    EnterpriseDocumentVersion doc         = getAccountEnterpriseDocumentVersion(documentName, portfolioId);

    if (doc != null) {
      Locale     awareLocale = LocaleContextHolder.getLocale();
      LocaleType localeType  = LocaleType.ENGLISH;


      if (awareLocale != null) {
        localeType = LocaleType.convert(awareLocale.getLanguage() + "-" + awareLocale.getCountry());
      }

      if ((localeType != null) && StringUtils.hasText(responsible.getLocaleString())) {
        localeType = LocaleType.convert(responsible.getLocaleString());
      }

      EnterpriseDocumentVersionTemplate content = doc.getContent(localeType);

      if ((content == null) && !(LocaleType.ENGLISH.equals(localeType))) {
        content = doc.getContent(LocaleType.ENGLISH);
      }

      if (content == null) {
        content = doc.getContents().iterator().next();
      }

      if ((content != null) && (content instanceof EnterpriseDocumentVersionHTMLTemplate)) {
        return ((EnterpriseDocumentVersionHTMLTemplate) content).getContent();
      }
    } // end if

    return null;
  } // end method getAccountDocumentHtmlContent

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   responsible   DOCUMENT ME!
   * @param   documentName  DOCUMENT ME!
   * @param   locale        DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public String getAccountDocumentHtmlContent(Responsible responsible, String documentName, String locale) {
    if ((!StringUtils.hasText(documentName)) || (!StringUtils.hasText(locale)) || (responsible == null)) {
      return null;
    }

    Account                   account     = responsible.getAccount();
    Long                      portfolioId = account.getPortfolio().getPortfolioId();
    EnterpriseDocumentVersion doc         = getAccountEnterpriseDocumentVersion(documentName,
        portfolioId);

    if (doc != null) {
      LocaleType localeType = LocaleType.convert(locale);

      if (localeType != null) {
        EnterpriseDocumentVersionTemplate content = doc.getContent(localeType);

        if ((content != null) && (content instanceof EnterpriseDocumentVersionHTMLTemplate)) {
          return ((EnterpriseDocumentVersionHTMLTemplate) content).getContent();
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getAccountEnterpriseDocumentVersion(String,
   *       Long)
   */
  @Override public EnterpriseDocumentVersion getAccountEnterpriseDocumentVersion(String documentName,
    Long portfolioId) {
    String hql   =
      "select ves from EnterpriseDocumentVersion ves left join fetch ves.contents left join ves.assignedPortfolios p where p.portfolioId = :portfolioId and ves.document.name = :name and ves.document.status != 'DELETED' and ves.document.status != 'DISABLED' and ves.document.active =true and ves.status = 'ACTIVE' and ves.contextType = 'Account'";
    Query  query = getSession().createQuery(hql);
    query.setParameter("name", documentName);
    query.setParameter("portfolioId", portfolioId);

    List list = query.list();

    if (list.size() > 0) {
      return (EnterpriseDocumentVersion) list.get(0);
    } else {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getAgencyDocumentBlob(Long)
   */
  @Override public AgencyUploadDocumentBlob getAgencyDocumentBlob(Long documentInstanceId) {
    List list = getHibernateTemplate().find(
        "FROM AgencyUploadDocumentBlob WHERE documentInstance.id = ?", documentInstanceId);

    return ((list != null) && !list.isEmpty()) ? ((AgencyUploadDocumentBlob) list.get(0)) : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getAgencyDocumentHtmlContent(String)
   */
  @Override public String getAgencyDocumentHtmlContent(String documentName) {
    EnterpriseDocumentVersion doc = getAgencyDocumentVersion(documentName);

    if (doc != null) {
      EnterpriseDocumentVersionTemplate content = doc.getContent(LocaleType.ENGLISH);

      if (content == null) {
        content = doc.getContents().iterator().next();
      }

      if ((content != null) && (content instanceof EnterpriseDocumentVersionHTMLTemplate)) {
        return ((EnterpriseDocumentVersionHTMLTemplate) content).getContent();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getAgencyDocumentHtmlContent(String,
   *       String)
   */
  @Override public String getAgencyDocumentHtmlContent(String documentName, String locale) {
    if (!StringUtils.hasText(locale)) {
      return null;
    }

    EnterpriseDocumentVersion doc = getAgencyDocumentVersion(documentName);

    if (doc != null) {
      LocaleType localeType = LocaleType.convert(locale);

      if (localeType != null) {
        EnterpriseDocumentVersionTemplate content = doc.getContent(localeType);

        if ((content != null) && (content instanceof EnterpriseDocumentVersionHTMLTemplate)) {
          return ((EnterpriseDocumentVersionHTMLTemplate) content).getContent();
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getAgencyDocumentVersion(String)
   */
  @Override public EnterpriseDocumentVersion getAgencyDocumentVersion(String documentName) {
    String hql   =
      "select ver from EnterpriseDocumentVersion ver left join fetch ver.contents where ver.document.name = :name and ver.document.status != 'DELETED' and ver.document.status != 'DISABLED' and ver.status = 'ACTIVE' and ver.document.active =true and ver.contextType = 'Agency'";
    Query  query = getSession().createQuery(hql);
    query.setParameter("name", documentName);

    List list = query.list();

    if (list.size() > 0) {
      return (EnterpriseDocumentVersion) list.get(0);
    } else {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getAgentDocumentBlob(Long)
   */
  @Override public AgentUploadDocumentBlob getAgentDocumentBlob(Long documentInstanceId) {
    List list = getHibernateTemplate().find(
        "FROM AgentUploadDocumentBlob WHERE documentInstance.id = ?1", documentInstanceId);

    return ((list != null) && !list.isEmpty()) ? ((AgentUploadDocumentBlob) list.get(0)) : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getBaseUrlInfo(String, Long)
   */
  @Override public String getBaseUrlInfo(String strKey, Long divisionId) {
    BaseUrlInfo baseUrlInfo = (BaseUrlInfo) getSession().createQuery(
        "FROM BaseUrlInfo WHERE strKey=? AND division.divisionId=?").setString(0, strKey).setLong(1,
        divisionId).setMaxResults(1).uniqueResult();

    return (baseUrlInfo != null) ? baseUrlInfo.getUrl() : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getBCDocumentHtmlContent(com.cmc.credagility.core.domain.businesscontext.BusinessContext,
   *       String, com.cmc.credagility.core.domain.type.LocaleType)
   */
  @Override public String getBCDocumentHtmlContent(BusinessContext businessContext, String documentName,
    LocaleType localeType) {
    if ((!StringUtils.hasText(documentName)) || (localeType == null) || (businessContext == null)) {
      return null;
    }

    EnterpriseDocumentVersion doc = getBCEnterpriseDocumentVersion(businessContext.getId(), documentName);

    if (doc != null) {
      EnterpriseDocumentVersionTemplate content = doc.getContent(localeType);

      if ((content != null) && (content instanceof EnterpriseDocumentVersionHTMLTemplate)) {
        return ((EnterpriseDocumentVersionHTMLTemplate) content).getContent();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getBCEnterpriseDocumentVersion(Long,
   *       String)
   */
  @Override public EnterpriseDocumentVersion getBCEnterpriseDocumentVersion(Long businessContextId,
    String documentName) {
    Query query = getSession().createQuery(
        "from EnterpriseDocumentVersion doc where doc.name=:documentName AND  doc.businessContext.id =:businessContextId and doc.status='ACTIVE' and doc.document.status != 'DISABLED' and doc.document.active =true and doc.document.contextType='business'")
      .setString("documentName", documentName).setLong("businessContextId", businessContextId).setMaxResults(1);

    if (!query.list().isEmpty()) {
      return (EnterpriseDocumentVersion) query.uniqueResult();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getDocMetaDataByDoc(com.cmc.credagility.core.domain.responsible.Responsible,
   *       Long, String)
   */
  @Override public DocumentMetaDataValue getDocMetaDataByDoc(Responsible responsible, Long documentId,
    String metaDataName) {
    String hql =
      "     SELECT metaDataValue FROM ResponsibleDocumentInstance ins LEFT JOIN ins.metaDataValues metaDataValue WHERE ins.document.id=:documentId AND ins.active =true AND metaDataValue.name = :metaDataName AND ins.owner = :responsible ORDER BY metaDataValue.lastUpdateDate DESC";

    Object o = em.createQuery(hql).setParameter("responsible", responsible).setParameter("documentId", documentId)
      .setParameter("metaDataName", metaDataName).getSingleResult();

    return (o == null) ? null : ((DocumentMetaDataValue) o);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getDocumentInstanceByDoc(com.cmc.credagility.core.domain.responsible.Responsible,
   *       com.ozstrategy.credagility.core.domain.document.EnterpriseDocument)
   */
  @Override public ResponsibleDocumentInstance getDocumentInstanceByDoc(Responsible responsible,
    EnterpriseDocument document) {
    String hql =
      "select distinct ins from ResponsibleDocumentInstance ins where ins.owner=:responsible and ins.document=:document and ins.active = true order by ins.createDate DESC";
    List   l   = em.createQuery(hql).setParameter("responsible", responsible).setParameter("document", document)
      .getResultList();

    return ((l == null) || (l.size() == 0)) ? null : ((ResponsibleDocumentInstance) l.get(0));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getDocumentStatusName(Long)
   */
  @Override public DocumentStatus getDocumentStatusName(Long docVersionStatusId) {
    List<DocumentStatus> list = em.createQuery(
        "select dvs.documentStatus from EnterpriseDocumentVersionStatus dvs where dvs.id = :dId").setParameter("dId",
        docVersionStatusId).getResultList();

    return (list != null) ? list.get(0) : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getDocumentVersionTemplate(Long)
   */
  @Override public EnterpriseDocumentVersionTemplate getDocumentVersionTemplate(Long documentVersionTemplateId) {
    List list = em.createQuery("from EnterpriseDocumentVersionTemplate where id = :id").setParameter("id",
        documentVersionTemplateId).getResultList();

    if (list.size() > 0) {
      EnterpriseDocumentVersionTemplate entity = (EnterpriseDocumentVersionTemplate) list.get(0);
      Hibernate.initialize(entity);

      if (entity instanceof HibernateProxy) {
        entity = (EnterpriseDocumentVersionTemplate) ((HibernateProxy) entity).getHibernateLazyInitializer()
          .getImplementation();
      }

      return entity;
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getDocVersionTemplate(Long, com.cmc.credagility.core.domain.type.LocaleType)
   */
  @Override public List<EnterpriseDocumentVersionTemplate> getDocVersionTemplate(Long documentVersionId,
    LocaleType locale) {
    return em.createQuery(
        "from EnterpriseDocumentVersionTemplate where documentVersion.id=:documentVersionId and locale=:locale")
      .setParameter("documentVersionId", documentVersionId).setParameter("locale", locale).getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getEnterpriseDocumentBlob(Long)
   */
  @Override public EnterpriseUploadDocumentBlob getEnterpriseDocumentBlob(Long documentInstanceId) {
    List list = getHibernateTemplate().find(
        "FROM EnterpriseUploadDocumentBlob WHERE documentInstance.id = ?", documentInstanceId);

    return ((list != null) && !list.isEmpty()) ? ((EnterpriseUploadDocumentBlob) list.get(0)) : null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getEnterpriseDocumentMetaData(Long)
   */
  @Override public List<EnterpriseDocumentVersionMetaData> getEnterpriseDocumentMetaData(Long docVersionId) {
    String hql =
      "FROM EnterpriseDocumentVersionMetaData m WHERE m.documentVersion.id = :docVersionId ORDER BY m.displayOrder ASC";

    return em.createQuery(hql).setParameter("docVersionId", docVersionId).getResultList();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getNumberOfUploadedDocumentInstances(com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject,
   *       String[])
   */
  @Override public int getNumberOfUploadedDocumentInstances(WorkflowBusinessObject businessObject,
    String... documentName) {
    String       tableName = "EnterpriseDocumentInstance";
    StringBuffer hql       = new StringBuffer("select count(distinct ins) ");
    String       condition = null;

    if (businessObject != null) {
      if (businessObject instanceof AgencyWorkflowBusinessObject) {
        tableName = "AgencyDocumentInstance ins";
        condition = " AND ins.owner= :owner";
      } else if (businessObject instanceof AgentWorkflowBusinessObject) {
        tableName = "AgentDocumentInstance ins";
        condition = " AND ins.owner= :owner";
      } else if (businessObject instanceof EnterpriseWorkflowBusinessObject) {
        tableName = "EnterpriseDocumentInstance ins";
      } else if (businessObject instanceof ResponsibleWorkflowBusinessObject) {
        tableName = "ResponsibleDocumentInstance ins";
        condition = " AND ins.owner= :owner";
      } else if (businessObject instanceof BCIWorkflowBusinessObject) {
        tableName = "BCIDocumentInstance ins";
        condition = " AND ins.bci= :owner";
      } else {
        return 0;
      }
    } else {
      return 0;
    }

    hql.append("FROM ").append(tableName).append(
      " WHERE ins.document.name in (:docNames) AND ins.active=true AND ins.uploaded=true ").append(
      (condition != null) ? condition : "");

    Query query = getSession().createQuery(hql.toString()).setParameterList("docNames", documentName);

    if (condition != null) {
      query.setEntity("owner", businessObject.getObject());
    }

    Object obj   = query.uniqueResult();
    int    count = (obj instanceof BigInteger) ? ((BigInteger) obj).intValue() : ((Long) obj).intValue();

    return count;
  } // end method getNumberOfUploadedDocumentInstances

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getSurveyFlowDocumentTemplate(Long,
   *       Long)
   */
  @Override public SurveyFlowInstanceDocumentTemplate getSurveyFlowDocumentTemplate(Long documentId,
    Long flowInstanceId) {
    String hql =
      "FROM SurveyFlowInstanceDocumentTemplate s WHERE s.document.id = :documentId AND s.instance.id = :flowInstanceId";
    List   l   = em.createQuery(hql).setParameter("documentId", documentId).setParameter("flowInstanceId",
        flowInstanceId).getResultList();

    return ((l == null) || (l.size() == 0)) ? null : ((SurveyFlowInstanceDocumentTemplate) l.get(0));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.EnterpriseDocumentRepository#getVersionMetaData(Long)
   */
  @Override public EnterpriseDocumentVersionMetaData getVersionMetaData(Long metaDataItemId) {
    String hql = "from EnterpriseDocumentVersionMetaData where id=:metaDataItemId";
    List   l   = em.createQuery(hql).setParameter("metaDataItemId", metaDataItemId).getResultList();

    return ((l == null) || (l.size() == 0)) ? null : ((EnterpriseDocumentVersionMetaData) l.get(0));
  }
} // end class EnterpriseDocumentRepositoryImpl
