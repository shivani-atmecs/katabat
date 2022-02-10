package com.ozstrategy.credagility.core.repository;

import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.cmc.credagility.core.domain.document.DocumentStatus;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.LocaleType;
import com.ozstrategy.credagility.core.domain.SurveyFlowInstanceDocumentTemplate;
import com.ozstrategy.credagility.core.domain.document.*;
import com.ozstrategy.credagility.core.domain.document.agency.AgencyUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.document.agent.AgentUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.document.enterprise.EnterpriseUploadDocumentBlob;
import com.ozstrategy.credagility.core.domain.document.responsible.ResponsibleDocumentInstance;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;

import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  11/03/2014 14:41
 */
public interface EnterpriseDocumentRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findEnterPriseDocumentByNameAndContext.
   *
   * @param   name         String
   * @param   contextType  String
   *
   * @return  List
   */
  List<EnterpriseDocument> findEnterPriseDocumentByNameAndContext(String name, String contextType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findFirstByNameAndContextType.
   *
   * @param   name         String
   * @param   contextType  String
   *
   * @return  EnterpriseDocument
   */
  EnterpriseDocument findFirstByNameAndContextType(String name, String contextType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first by res doc id.
   *
   * @param   responsibleId  Long
   * @param   documentId     Long
   *
   * @return  ResponsibleDocumentInstance
   */

  List<ResponsibleDocumentInstance> findFirstByResDocId(Long responsibleId, Long documentId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findFirstByUniqueIdAndContextType.
   *
   * @param   uniqueId     String
   * @param   contextType  String
   *
   * @return  EnterpriseDocument
   */
  EnterpriseDocument findFirstByUniqueIdAndContextType(String uniqueId, String contextType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findWorkflowDocumentInstance.
   *
   * @param   category       String
   * @param   docInstanceId  Long
   *
   * @return  BasicDocumentInstance
   */
  BasicDocumentInstance findWorkflowDocumentInstance(String category, Long docInstanceId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * get.
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
   * getter method for account document html content.
   *
   * @param   responsible   Responsible
   * @param   documentName  String
   *
   * @return  String
   */
  String getAccountDocumentHtmlContent(Responsible responsible, String documentName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account document html content.
   *
   * @param   responsible   Responsible
   * @param   documentName  String
   * @param   locale        String
   *
   * @return  String
   */
  String getAccountDocumentHtmlContent(Responsible responsible, String documentName, String locale);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account enterprise document version.
   *
   * @param   documentName  String
   * @param   portfolioId   Long
   *
   * @return  EnterpriseDocumentVersion
   */
  EnterpriseDocumentVersion getAccountEnterpriseDocumentVersion(String documentName,
    Long portfolioId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency document blob.
   *
   * @param   documentInstanceId  Long
   *
   * @return  AgencyUploadDocumentBlob
   */
  AgencyUploadDocumentBlob getAgencyDocumentBlob(Long documentInstanceId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency document html content.
   *
   * @param   documentName  String
   *
   * @return  String
   */
  String getAgencyDocumentHtmlContent(String documentName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency document html content.
   *
   * @param   documentName  String
   * @param   locale        String
   *
   * @return  String
   */
  String getAgencyDocumentHtmlContent(String documentName, String locale);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency document version.
   *
   * @param   documentName  String
   *
   * @return  EnterpriseDocumentVersion
   */
  EnterpriseDocumentVersion getAgencyDocumentVersion(String documentName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent document blob.
   *
   * @param   documentInstanceId  Long
   *
   * @return  AgentUploadDocumentBlob
   */
  AgentUploadDocumentBlob getAgentDocumentBlob(Long documentInstanceId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for base url info.
   *
   * @param   strKey      String
   * @param   divisionId  Long
   *
   * @return  String
   */
  String getBaseUrlInfo(String strKey, Long divisionId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BCDocument html content.
   *
   * @param   businessContext  BusinessContext
   * @param   documentName     String
   * @param   localeType       LocaleType
   *
   * @return  String
   */
  String getBCDocumentHtmlContent(BusinessContext businessContext, String documentName,
    LocaleType localeType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for BCEnterprise document version.
   *
   * @param   businessContextId  Long
   * @param   documentName       String
   *
   * @return  EnterpriseDocumentVersion
   */
  EnterpriseDocumentVersion getBCEnterpriseDocumentVersion(Long businessContextId,
    String documentName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for doc meta data by doc.
   *
   * @param   responsible   Responsible
   * @param   documentId    Long
   * @param   metaDataName  String
   *
   * @return  DocumentMetaDataValue
   */
  DocumentMetaDataValue getDocMetaDataByDoc(Responsible responsible, Long documentId, String metaDataName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document instance by doc.
   *
   * @param   responsible  Responsible
   * @param   document     EnterpriseDocument
   *
   * @return  ResponsibleDocumentInstance
   */
  ResponsibleDocumentInstance getDocumentInstanceByDoc(Responsible responsible, EnterpriseDocument document);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document status name.
   *
   * @param   docVersionStatusId  Long
   *
   * @return  DocumentStatus
   */
  DocumentStatus getDocumentStatusName(final Long docVersionStatusId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document version template.
   *
   * @param   documentVersionTemplateId  Long
   *
   * @return  EnterpriseDocumentVersionTemplate
   */
  EnterpriseDocumentVersionTemplate getDocumentVersionTemplate(Long documentVersionTemplateId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for doc version template.
   *
   * @param   documentVersionId  Long
   * @param   locale             LocaleType
   *
   * @return  List
   */
  List<EnterpriseDocumentVersionTemplate> getDocVersionTemplate(Long documentVersionId, LocaleType locale);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enterprise document blob.
   *
   * @param   documentInstanceId  Long
   *
   * @return  EnterpriseUploadDocumentBlob
   */
  EnterpriseUploadDocumentBlob getEnterpriseDocumentBlob(Long documentInstanceId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enterprise document meta data.
   *
   * @param   docVersionId  Long
   *
   * @return  List
   */
  List<EnterpriseDocumentVersionMetaData> getEnterpriseDocumentMetaData(Long docVersionId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for number of uploaded document instances.
   *
   * @param   businessObject  WorkflowBusinessObject
   * @param   documentName    String
   *
   * @return  int
   */
  int getNumberOfUploadedDocumentInstances(WorkflowBusinessObject businessObject, String... documentName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey flow document template.
   *
   * @param   documentId      Long
   * @param   flowInstanceId  Long
   *
   * @return  SurveyFlowInstanceDocumentTemplate
   */
  SurveyFlowInstanceDocumentTemplate getSurveyFlowDocumentTemplate(Long documentId, Long flowInstanceId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for version meta data.
   *
   * @param   metaDataItemId  Long
   *
   * @return  EnterpriseDocumentVersionMetaData
   */
  EnterpriseDocumentVersionMetaData getVersionMetaData(Long metaDataItemId);
} // end interface EnterpriseDocumentRepository
