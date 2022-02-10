package com.cmc.credagility.core.domain.channel;

import com.cmc.credagility.core.domain.contact.ContactEmail;
import com.cmc.credagility.core.domain.externalentity.ExternalEntity;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocumentVersionTemplate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store email channel action information.
 *
 * <p><a href="EmailChannelResult.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 12:47
 */
@Entity
@Table(
  name    = "EmailChannelResult",
  indexes = {
    @Index(
      name = "createDateIndex",
      columnList = "createDate"
    ), @Index(
      name = "ruleBatchIdIndex",
      columnList = "ruleBatchId"
    ),
    @Index(
      name = "sourceIndex",
      columnList = "source"
    ),
    @Index(
      name = "statusIndex",
      columnList = "status"
    ),
    @Index(
      name = "strategyDateIndex",
      columnList = "strategyDate"
    ),
    @Index(
      name = "uniqueSessionIdIndex",
      columnList = "uniqueSessionId"
    )
  }
)
public class EmailChannelResult extends BaseChannelResult {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2971719629524709723L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Relations emailChannel. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "emailChannelResult",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected Set<EmailChannelActualResult> actualResults = new LinkedHashSet<EmailChannelActualResult>();


  /** Contact Email. */
  @JoinColumn(
    name     = "contactEmailId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ContactEmail contactEmail;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "documentVersionTemplateId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocumentVersionTemplate documentVersionTemplate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "emailAddress",
    length = 128
  )
  protected String emailAddress;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "emailCampaignId",
    updatable = true
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected EmailCampaign emailCampaign;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "channelResult"
  )
  protected Set<EmailChannelResultDestination> emailChannelResultDestination =
    new LinkedHashSet<EmailChannelResultDestination>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade       = CascadeType.ALL,
    fetch         = FetchType.LAZY,
    mappedBy      = "emailChannelResult",
    orphanRemoval = true
  )
  protected Set<EmailChannelResultDocument> emailChannelResultDocuments =
    new LinkedHashSet<EmailChannelResultDocument>();

  /** Result Id, PK. */
  @Column(
    name     = "emailResultId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long emailResultId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "endTime",
    length = 255
  )
  protected String         endTime;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "externalEntity",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ExternalEntity externalEntity;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "startTime",
    length = 255
  )
  protected String startTime;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "statusDescription",
    length = 250
  )
  protected String statusDescription;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "templateContentId",
    nullable = true
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected BasePortfolioChannelTemplateContent templateContent;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade       = CascadeType.ALL,
    fetch         = FetchType.LAZY,
    mappedBy      = "channelResult",
    orphanRemoval = true
  )
  protected Set<EmailChannelResultVariableValue> variableValues = new LinkedHashSet<EmailChannelResultVariableValue>();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "vendorId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EmailServiceVendor vendor;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addEmailChannelActual.
   *
   * @param  emailChannelActualResult  EmailChannelActualResult
   */
  public void addEmailChannelActual(EmailChannelActualResult emailChannelActualResult) {
    emailChannelActualResult.setEmailChannelResult(this);
    getActualResults().add(emailChannelActualResult);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addEmailChannelResultContent.
   *
   * @param  resultDocument  EmailChannelResultDocument
   */
  public void addEmailChannelResultContent(EmailChannelResultDocument resultDocument) {
    if (resultDocument != null) {
      this.emailChannelResultDocuments.add(resultDocument);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addVariableValue.
   *
   * @param  variableValue  EmailChannelResultVariableValue
   */
  public void addVariableValue(EmailChannelResultVariableValue variableValue) {
    if (variableValue != null) {
      this.variableValues.add(variableValue);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.AbstractChannelResult#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    EmailChannelResult other = (EmailChannelResult) obj;

    if (this.emailAddress == null) {
      if (other.emailAddress != null) {
        return false;
      }
    } else if (!this.emailAddress.equals(other.emailAddress)) {
      return false;
    }

    if (this.vendor == null) {
      if (other.vendor != null) {
        return false;
      }
    } else if (!this.vendor.equals(other.vendor)) {
      return false;
    }

    if (this.endTime == null) {
      if (other.endTime != null) {
        return false;
      }
    } else if (!this.endTime.equals(other.endTime)) {
      return false;
    }

    if (this.startTime == null) {
      if (other.startTime != null) {
        return false;
      }
    } else if (!this.startTime.equals(other.startTime)) {
      return false;
    }

    if (this.externalEntity == null) {
      if (other.externalEntity != null) {
        return false;
      }
    } else if (!this.externalEntity.equals(other.externalEntity)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for actual results.
   *
   * @return  Set
   */
  public Set<EmailChannelActualResult> getActualResults() {
    return actualResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact email.
   *
   * @return  ContactEmail
   */
  public ContactEmail getContactEmail() {
    return contactEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document version template.
   *
   * @return  EnterpriseDocumentVersionTemplate
   */
  public EnterpriseDocumentVersionTemplate getDocumentVersionTemplate() {
    return documentVersionTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email address.
   *
   * @return  String
   */
  public String getEmailAddress() {
    return this.emailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email campaign.
   *
   * @return  EmailCampaign
   */
  public EmailCampaign getEmailCampaign() {
    return emailCampaign;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email channel result destination.
   *
   * @return  Set
   */
  public Set<EmailChannelResultDestination> getEmailChannelResultDestination() {
    return emailChannelResultDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email channel result documents.
   *
   * @return  Set
   */
  public Set<EmailChannelResultDocument> getEmailChannelResultDocuments() {
    return emailChannelResultDocuments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email result id.
   *
   * @return  Long
   */
  public Long getEmailResultId() {
    return emailResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end time.
   *
   * @return  String
   */
  public String getEndTime() {
    return endTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for external entity.
   *
   * @return  ExternalEntity
   */
  public ExternalEntity getExternalEntity() {
    return externalEntity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.AbstractChannelResult#getResultId()
   */
  @Override public Long getResultId() {
    return getEmailResultId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for start time.
   *
   * @return  String
   */
  public String getStartTime() {
    return startTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status description.
   *
   * @return  String
   */
  public String getStatusDescription() {
    return statusDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for template content.
   *
   * @return  BasePortfolioChannelTemplateContent
   */
  public BasePortfolioChannelTemplateContent getTemplateContent() {
    return templateContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable values.
   *
   * @return  Set
   */
  public Set<EmailChannelResultVariableValue> getVariableValues() {
    return variableValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getVendor.
   *
   * @return  EmailServiceVendor
   *
   *          <p>column = "vendorId" not-null = "true" class = "com.cmc.credagility.EmailServiceVendor" insert = "true"
   *          update = "true" cascade = "save-update"</p>
   */
  public EmailServiceVendor getVendor() {
    return vendor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((this.emailAddress == null) ? 0 : this.emailAddress.hashCode());
    result = (prime * result)
      + ((this.vendor == null) ? 0 : this.vendor.hashCode());
    result = (prime * result)
      + ((this.endTime == null) ? 0 : this.endTime.hashCode());
    result = (prime * result)
      + ((this.startTime == null) ? 0 : this.startTime.hashCode());
    result = (prime * result)
      + ((this.externalEntity == null) ? 0 : this.externalEntity.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for actual results.
   *
   * @param  actualResults  Set
   */
  public void setActualResults(Set<EmailChannelActualResult> actualResults) {
    this.actualResults = actualResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact email.
   *
   * @param  contactEmail  ContactEmail
   */
  public void setContactEmail(ContactEmail contactEmail) {
    this.contactEmail = contactEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document version template.
   *
   * @param  documentVersionTemplate  EnterpriseDocumentVersionTemplate
   */
  public void setDocumentVersionTemplate(EnterpriseDocumentVersionTemplate documentVersionTemplate) {
    this.documentVersionTemplate = documentVersionTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email address.
   *
   * @param  emailAddress  String
   */
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email campaign.
   *
   * @param  emailCampaign  EmailCampaign
   */
  public void setEmailCampaign(EmailCampaign emailCampaign) {
    this.emailCampaign = emailCampaign;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email channel result destination.
   *
   * @param  emailChannelResultDestination  Set
   */
  public void setEmailChannelResultDestination(Set<EmailChannelResultDestination> emailChannelResultDestination) {
    this.emailChannelResultDestination = emailChannelResultDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email channel result documents.
   *
   * @param  emailChannelResultDocuments  Set
   */
  public void setEmailChannelResultDocuments(Set<EmailChannelResultDocument> emailChannelResultDocuments) {
    this.emailChannelResultDocuments = emailChannelResultDocuments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email result id.
   *
   * @param  emailResultId  Long
   */
  public void setEmailResultId(Long emailResultId) {
    this.emailResultId = emailResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end time.
   *
   * @param  endTime  String
   */
  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for external entity.
   *
   * @param  externalEntity  ExternalEntity
   */
  public void setExternalEntity(ExternalEntity externalEntity) {
    this.externalEntity = externalEntity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.AbstractChannelResult#setResultId(java.lang.Long)
   */
  @Override public void setResultId(Long resultId) {
    setEmailResultId(resultId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for start time.
   *
   * @param  startTime  String
   */
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status description.
   *
   * @param  statusDescription  String
   */
  public void setStatusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for template content.
   *
   * @param  templateContent  BasePortfolioChannelTemplateContent
   */
  public void setTemplateContent(BasePortfolioChannelTemplateContent templateContent) {
    this.templateContent = templateContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable values.
   *
   * @param  variableValues  Set
   */
  public void setVariableValues(Set<EmailChannelResultVariableValue> variableValues) {
    this.variableValues = variableValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor.
   *
   * @param  vendor  EmailServiceVendor
   */
  public void setVendor(EmailServiceVendor vendor) {
    this.vendor = vendor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("emailChannelResult ( ").append(super.toString()).append(TAB).append("emailResultId = ").append(
      this.emailResultId).append(TAB).append("vendor = ").append(this.vendor).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class EmailChannelResult
