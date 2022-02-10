package com.ozstrategy.credagility.core.domain.document;

import com.cmc.credagility.core.domain.document.DocumentStatus;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.type.LocaleType;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.StatusType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * This class is used to store EnterpriseDocumentVersion information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:36
 */
@Entity
@Table(
  indexes =
    @Index(
      name       = "statusIndex",
      columnList = "status"
    )
)
public class EnterpriseDocumentVersion extends BasicEnterpriseDocument implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 1606837904934545428L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "EnterpriseDocumentVersionMappedPortfolio",
    indexes            = { @Index(columnList = "documentId") },
    joinColumns        = {
      @JoinColumn(
        name           = "documentId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "portfolioId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected Set<Portfolio> assignedPortfolios = new LinkedHashSet<Portfolio>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "documentVersion"
  )
  protected Set<EnterpriseDocumentVersionTemplate> contents = new LinkedHashSet<EnterpriseDocumentVersionTemplate>();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "documentId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne protected EnterpriseDocument document;


  /** Document Status List. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "documentVersion",
    cascade  = CascadeType.ALL
  )
  protected Set<EnterpriseDocumentVersionStatus> documentStatuses =
    new LinkedHashSet<EnterpriseDocumentVersionStatus>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "documentVersion",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<EnterpriseDocumentVersionMetaData> documentVersionMetaDatas =
    new LinkedHashSet<EnterpriseDocumentVersionMetaData>();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "publishBy",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User publishBy;


  /** TODO: DOCUMENT ME! */
  @Column(
    name       = "publishDate",
// nullable = false,
    insertable = true,
    updatable  = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date publishDate;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "retireBy")
  @ManyToOne(fetch = FetchType.LAZY)
  protected User retireBy;


  /** TODO: DOCUMENT ME! */
  @Column(name = "retireDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date retireDate;

  /** Status: Active/Retired. */
  @Column(
    length   = 12,
    nullable = false
  )
  @Enumerated(EnumType.STRING)
  protected StatusType status;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "documentVersion",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("displayOrder asc")
  protected Set<EnterpriseDocumentVersionTemplateVariable> variables =
    new LinkedHashSet<EnterpriseDocumentVersionTemplateVariable>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addContents.
   *
   * @param  docContents  Set
   * @param  user         User
   */
  public void addContents(Set<EnterpriseDocumentTemplate> docContents, User user) {
    Date today = new Date();

    for (EnterpriseDocumentTemplate docContent : docContents) {
      if (docContent instanceof EnterpriseDocumentPDFTemplate) {
        EnterpriseDocumentVersionPDFTemplate pdfTemplate = new EnterpriseDocumentVersionPDFTemplate();
        pdfTemplate.setContentType(docContent.getContentType());
        pdfTemplate.setDocument(document);
        pdfTemplate.setDocumentVersion(this);
        pdfTemplate.setLocale(docContent.getLocale());
        pdfTemplate.setVersion(version);
        pdfTemplate.setFileContent(((EnterpriseDocumentPDFTemplate) docContent).getFileContent());
        pdfTemplate.setCreator(user);
        pdfTemplate.setCreateDate(today);
        contents.add(pdfTemplate);
      } else if (docContent instanceof EnterpriseDocumentHTMLTemplate) {
        EnterpriseDocumentVersionHTMLTemplate htmlTemplate = new EnterpriseDocumentVersionHTMLTemplate();
        htmlTemplate.setContentType(docContent.getContentType());
        htmlTemplate.setDocument(document);
        htmlTemplate.setDocumentVersion(this);
        htmlTemplate.setLocale(docContent.getLocale());
        htmlTemplate.setVersion(version);
        htmlTemplate.setContent(((EnterpriseDocumentHTMLTemplate) docContent).getContent());
        htmlTemplate.setTextContent(((EnterpriseDocumentHTMLTemplate) docContent).getTextContent());
        htmlTemplate.setCreator(user);
        htmlTemplate.setCreateDate(today);
        contents.add(htmlTemplate);
      }
    } // end for
  }   // end method addContents

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addDocumentStatus.
   *
   * @param  statusSet  Set
   * @param  user       User
   */
  public void addDocumentStatus(Set<EnterpriseDocumentStatus> statusSet, User user) {
    Date today = new Date();

    for (EnterpriseDocumentStatus documentStatus : statusSet) {
      addDocumentStatus(documentStatus.getDocumentStatus(), documentStatus.getFlowPosition(),
        documentStatus.getAsDefault(), today, user);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocument#addDocumentStatus(com.cmc.credagility.core.domain.document.DocumentStatus,
   *       String, java.util.Date, com.cmc.credagility.core.domain.user.User)
   */
  @Override public void addDocumentStatus(DocumentStatus documentStatus, String flowPosition, Date date, User user) {
    EnterpriseDocumentVersionStatus docStatus = new EnterpriseDocumentVersionStatus(documentStatus, flowPosition);
    docStatus.setCreateDate(date);
    docStatus.setCreator(user);
    docStatus.setDocument(document);
    docStatus.setDocumentVersion(this);
    documentStatuses.add(docStatus);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocument#addDocumentStatus(com.cmc.credagility.core.domain.document.DocumentStatus,
   *       String, Boolean, java.util.Date, com.cmc.credagility.core.domain.user.User)
   */
  @Override public void addDocumentStatus(DocumentStatus documentStatus, String flowPosition, Boolean asDefault,
    Date date, User user) {
    EnterpriseDocumentVersionStatus docStatus = new EnterpriseDocumentVersionStatus(documentStatus, flowPosition,
        asDefault);
    docStatus.setCreateDate(date);
    docStatus.setCreator(user);
    docStatus.setDocument(document);
    docStatus.setDocumentVersion(this);
    documentStatuses.add(docStatus);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addVariables.
   *
   * @param  docVars  Set
   * @param  user     User
   */
  public void addVariables(Set<EnterpriseDocumentTemplateVariable> docVars, User user) {
    Date                                      today    = new Date();
    EnterpriseDocumentVersionTemplateVariable variable = null;

    for (EnterpriseDocumentTemplateVariable docVar : docVars) {
      variable = new EnterpriseDocumentVersionTemplateVariable();
      variable.setDocument(document);
      variable.setDocumentVersion(this);
      variable.setExpression(docVar.getExpression());
      variable.setFormat(docVar.getFormat());
      variable.setType(docVar.getType());
      variable.setDisplayOrder(docVar.getDisplayOrder());
      variable.setDisplayName(docVar.getDisplayName());
      variable.setDescription(docVar.getDescription());
      variable.setCreator(user);
      variable.setCreateDate(today);

      // set businessDataType
      variable.setBusinessDataType(docVar.getBusinessDataType());
      variables.add(variable);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocument#copy()
   */
  @Override public EnterpriseDocumentVersion copy() {
    EnterpriseDocumentVersion documentVersion = new EnterpriseDocumentVersion();
    paste(documentVersion);

    return documentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyFrom.
   *
   * @param  document  EnterpriseDocument
   * @param  user      User
   */
  public void copyFrom(EnterpriseDocument document, User user) {
    this.name                 = document.getName();
    this.description          = document.getDescription();
    this.allowDocumentContent = document.getAllowDocumentContent();
    this.contentMode          = document.getContentMode();
    this.hotSpot              = document.getHotSpot();
    this.allowSMS             = document.getAllowSMS();
    this.allowLetter          = document.getAllowLetter();
    this.allowEmail           = document.getAllowEmail();
    this.allowDisclosure      = document.getAllowDisclosure();
    this.allowWorkflow        = document.getAllowWorkflow();
    this.mailFrom             = document.getMailFrom();
    this.mailSubject          = document.getMailSubject();
    this.status               = StatusType.DRAFT;
    this.version              = document.getVersion();
    this.document             = document;
    this.category             = document.getCategory();
    this.contextType          = document.getContextType();
    this.allowDialer          = document.getAllowDialer();
    this.allowIVR             = document.getAllowIVR();
    this.businessContext      = document.getBusinessContext();
    this.friendlyName         = document.getFriendlyName();
    this.replyToEmail         = document.getReplyToEmail();
    this.uniqueId             = document.getUniqueId();
    this.bcMetaDataField      = document.getBcMetaDataField();

    Set<EnterpriseDocumentStatus> docStatus = document.getDocumentStatuses();

    if ((docStatus != null) && !docStatus.isEmpty()) {
      addDocumentStatus(docStatus, user);
    }

    Set<EnterpriseDocumentTemplate> docContents = document.getContents();

    if ((docContents != null) && !docContents.isEmpty()) {
      addContents(docContents, user);
    }

    Set<EnterpriseDocumentTemplateVariable> docVars = document.getVariables();

    if ((docVars != null) && !docVars.isEmpty()) {
      addVariables(docVars, user);
    }

    Set<EnterpriseDocumentMetaData> docMetaDataSet = document.getDocumentMetaDatas();

    if ((docMetaDataSet != null) && !docMetaDataSet.isEmpty()) {
      addDocumentMetaData(docMetaDataSet);
    }

    Set<Portfolio> portfolios = document.getAssignedPortfolios();

    if ((portfolios != null) && !portfolios.isEmpty()) {
      for (Portfolio portfolio : portfolios) {
        this.assignedPortfolios.add(portfolio);
      }
    }
  } // end method copyFrom

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof EnterpriseDocumentVersion)) {
      return false;
    }

    if (!super.equals(obj)) {
      return false;
    }

    EnterpriseDocumentVersion that = (EnterpriseDocumentVersion) obj;

    if ((version != null) ? (!version.equals(that.version)) : (that.version != null)) {
      return false;
    }

    if ((document != null) ? (!document.equals(that.document)) : (that.document != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for assigned portfolio ids.
   *
   * @return  String
   */
  public String getAssignedPortfolioIds() {
    StringBuilder sb = new StringBuilder();

    for (Portfolio portfolio : assignedPortfolios) {
      sb.append(portfolio.getPortfolioId());
      sb.append(",");
    }

    if (sb.length() > 0) {
      sb.deleteCharAt(sb.length() - 1);
    }

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for assigned portfolios.
   *
   * @return  Set
   */
  public Set<Portfolio> getAssignedPortfolios() {
    return assignedPortfolios;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocument#getContent(com.cmc.credagility.core.domain.type.LocaleType)
   */
  @Override public EnterpriseDocumentVersionTemplate getContent(LocaleType localeType) {
    for (EnterpriseDocumentVersionTemplate content : contents) {
      if (content.getLocale().equals(localeType)) {
        return content;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contents.
   *
   * @return  Set
   */
  public Set<EnterpriseDocumentVersionTemplate> getContents() {
    return contents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default document status.
   *
   * @return  EnterpriseDocumentVersionStatus
   */
  public EnterpriseDocumentVersionStatus getDefaultDocumentStatus() {
    for (EnterpriseDocumentVersionStatus docStatus : documentStatuses) {
      if (docStatus.getAsDefault()) {
        return docStatus;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document.
   *
   * @return  EnterpriseDocument
   */
  public EnterpriseDocument getDocument() {
    return document;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document statuses.
   *
   * @return  Set
   */
  public Set<EnterpriseDocumentVersionStatus> getDocumentStatuses() {
    return documentStatuses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document version meta datas.
   *
   * @return  Set
   */
  public Set<EnterpriseDocumentVersionMetaData> getDocumentVersionMetaDatas() {
    return documentVersionMetaDatas;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for publish by.
   *
   * @return  User
   */
  public User getPublishBy() {
    return publishBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for publish date.
   *
   * @return  Date
   */
  public Date getPublishDate() {
    return publishDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for retire by.
   *
   * @return  User
   */
  public User getRetireBy() {
    return retireBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for retire date.
   *
   * @return  Date
   */
  public Date getRetireDate() {
    return retireDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  StatusType
   */
  public StatusType getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocument#getVariable(String)
   */
  @Override public EnterpriseDocumentVersionTemplateVariable getVariable(String variable) {
    for (EnterpriseDocumentVersionTemplateVariable EnterpriseDocumentVariable : variables) {
      if (EnterpriseDocumentVariable.getExpression().equalsIgnoreCase(variable)) {
        return EnterpriseDocumentVariable;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variables.
   *
   * @return  Set
   */
  public Set<EnterpriseDocumentVersionTemplateVariable> getVariables() {
    return variables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicEnterpriseDocument#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((version != null) ? version.hashCode() : 0);
    result = (31 * result) + ((document != null) ? document.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * orderVariables.
   */
  public void orderVariables() {
    int order = 1;

    for (EnterpriseDocumentVersionTemplateVariable variable : variables) {
      variable.setDisplayOrder(order++);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for assigned portfolios.
   *
   * @param  assignedPortfolios  Set
   */
  public void setAssignedPortfolios(Set<Portfolio> assignedPortfolios) {
    this.assignedPortfolios = assignedPortfolios;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contents.
   *
   * @param  contents  Set
   */
  public void setContents(Set<EnterpriseDocumentVersionTemplate> contents) {
    this.contents = contents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document.
   *
   * @param  document  EnterpriseDocument
   */
  public void setDocument(EnterpriseDocument document) {
    this.document = document;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document statuses.
   *
   * @param  documentStatuses  Set
   */
  public void setDocumentStatuses(Set<EnterpriseDocumentVersionStatus> documentStatuses) {
    this.documentStatuses = documentStatuses;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document version meta datas.
   *
   * @param  documentVersionMetaDatas  Set
   */
  public void setDocumentVersionMetaDatas(Set<EnterpriseDocumentVersionMetaData> documentVersionMetaDatas) {
    this.documentVersionMetaDatas = documentVersionMetaDatas;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for publish by.
   *
   * @param  publishBy  User
   */
  public void setPublishBy(User publishBy) {
    this.publishBy = publishBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for publish date.
   *
   * @param  publishDate  Date
   */
  public void setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for retire by.
   *
   * @param  retireBy  User
   */
  public void setRetireBy(User retireBy) {
    this.retireBy = retireBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for retire date.
   *
   * @param  retireDate  Date
   */
  public void setRetireDate(Date retireDate) {
    this.retireDate = retireDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  StatusType
   */
  public void setStatus(StatusType status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variables.
   *
   * @param  variables  Set
   */
  public void setVariables(Set<EnterpriseDocumentVersionTemplateVariable> variables) {
    this.variables = variables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private void addDocumentMetaData(Set<EnterpriseDocumentMetaData> documentMetaDataSet) {
    EnterpriseDocumentVersionMetaData metaData = null;

    for (EnterpriseDocumentMetaData documentMetaData : documentMetaDataSet) {
      metaData = new EnterpriseDocumentVersionMetaData();
      metaData.setDocumentVersion(this);
      metaData.copyFrom(documentMetaData);
      documentVersionMetaDatas.add(metaData);
    }
  }
} // end class EnterpriseDocumentVersion
