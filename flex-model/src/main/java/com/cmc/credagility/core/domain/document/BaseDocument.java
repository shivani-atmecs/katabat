package com.cmc.credagility.core.domain.document;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.user.User;

import com.ozstrategy.credagility.core.domain.DocumentTemplateTypeEnum;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 11:18
 */
@MappedSuperclass public class BaseDocument extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8016297158386426401L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Document account. */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne protected Account account;

  /** Create agent. */
  @JoinColumn(
    name      = "createAgentId",
    updatable = false
  )
  @ManyToOne protected User createAgent;

  /** Document Type Description. */
  @Column(length = 250)
  protected String description;

  /** ChannelTemplate /PortfolioDocument.* */
  @Column(length = 32)
  @Enumerated(value = EnumType.STRING)
  protected DocumentTemplateTypeEnum documentTemplateType = DocumentTemplateTypeEnum.ChannelTemplate;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "lastUpdateAgentId",
    updatable = true
  )
  @ManyToOne /**
              * Last update agent
              */ protected User                                              lastUpdateAgent;

  /** Document Type Name. */
  @Column(length = 45)
  protected String name;

  /** Document responsible. */
  @JoinColumn(
    name      = "responsibleId",
    updatable = false
  )
  @ManyToOne protected Responsible responsible;

  /** Create date. */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         statusDate;

  /** Document type and status. */
  @JoinColumn(
    name       = "typeStatusTypeId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected DocumentTypeStatusType typeStatusType;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BaseDocument object.
   */
  public BaseDocument() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Duplicate document properties from other document.
   *
   * @param  other  $param.type$
   */
  public void copy(Document other) {
    this.typeStatusType  = other.getTypeStatusType();
    this.name            = other.getName();
    this.description     = other.getDescription();
    this.responsible     = other.getResponsible();
    this.account         = other.getAccount();
    this.createAgent     = other.getCreateAgent();
    this.lastUpdateAgent = other.getLastUpdateAgent();
    this.lastUpdateDate  = other.getLastUpdateDate();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    BaseDocument that = (BaseDocument) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((responsible != null) ? (!responsible.equals(that.responsible)) : (that.responsible != null)) {
      return false;
    }

    if ((typeStatusType != null) ? (!typeStatusType.equals(that.typeStatusType)) : (that.typeStatusType != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get document account.
   *
   * @return  get document account.
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get document create agent.
   *
   * @return  get document create agent.
   */
  public User getCreateAgent() {
    return createAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get document description.
   *
   * @return  get document description.
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get document status.
   *
   * @return  get document status.
   */
  public DocumentStatus getDocumentStatus() {
    return this.typeStatusType.getDocumentStatus();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document template type.
   *
   * @return  DocumentTemplateTypeEnum
   */
  public DocumentTemplateTypeEnum getDocumentTemplateType() {
    return documentTemplateType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get document type.
   *
   * @return  get document type.
   */
  public DocumentType getDocumentType() {
    return this.typeStatusType.getDocumentType();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get document last update agent.
   *
   * @return  get document last update agent.
   */
  public User getLastUpdateAgent() {
    return lastUpdateAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The name.
   *
   * @return  the name
   */
  public String getName() {
    return this.name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get document responsible.
   *
   * @return  get document responsible.
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status date.
   *
   * @return  Date
   */
  public Date getStatusDate() {
    return statusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get document type status type.
   *
   * @return  get document type status type.
   */
  public DocumentTypeStatusType getTypeStatusType() {
    return typeStatusType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((typeStatusType != null) ? typeStatusType.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set document account.
   *
   * @param  account  $param.type$
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set document create agent.
   *
   * @param  createAgent  $param.type$
   */
  public void setCreateAgent(User createAgent) {
    this.createAgent = createAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set document description.
   *
   * @param  description  $param.type$
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document template type.
   *
   * @param  documentTemplateType  DocumentTemplateTypeEnum
   */
  public void setDocumentTemplateType(DocumentTemplateTypeEnum documentTemplateType) {
    this.documentTemplateType = documentTemplateType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set document last update agent.
   *
   * @param  lastUpdateAgent  $param.type$
   */
  public void setLastUpdateAgent(User lastUpdateAgent) {
    this.lastUpdateAgent = lastUpdateAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set Document name.
   *
   * @param  name  the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set responsible.
   *
   * @param  responsible  $param.type$
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status date.
   *
   * @param  statusDate  Date
   */
  public void setStatusDate(Date statusDate) {
    this.statusDate = statusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set document type status type.
   *
   * @param  typeStatusType  $param.type$
   */
  public void setTypeStatusType(DocumentTypeStatusType typeStatusType) {
    this.typeStatusType = typeStatusType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("BaseDocument");
    sb.append("{typeStatusType=").append(typeStatusType);
    sb.append(", name='").append(name).append('\'');
    sb.append(", description='").append(description).append('\'');
    sb.append(", createAgent=").append(createAgent);
    sb.append(", lastUpdateAgent=").append(lastUpdateAgent);
    sb.append(", responsible=").append(responsible);
    sb.append(", account=").append(account);
    sb.append('}');

    return sb.toString();
  }
} // end class BaseDocument
