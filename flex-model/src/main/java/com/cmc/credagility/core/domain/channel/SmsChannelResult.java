package com.cmc.credagility.core.domain.channel;

import com.cmc.credagility.core.domain.externalentity.ExternalEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocumentVersionTemplate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store sms channel action information.
 *
 * <p><a href="SmsChannelResult.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/14/2014 17:52
 */
@Entity
@Table(
  name    = "SmsChannelResult",
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
public class SmsChannelResult extends PhoneChannelResult {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6536467001196901188L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Relations smsChannel. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "smsChannelResult",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<SmsChannelActualResult> actualResults = new LinkedHashSet<SmsChannelActualResult>();

  // Following is the result

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "contactable",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean contactable;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "documentVersionTemplateId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocumentVersionTemplate documentVersionTemplate;


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
    name   = "messageReference",
    length = 50
  )
  protected String messageReference;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "optOut",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean optOut;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "smsChannelResult"
  )
  protected Set<SmsOutboundAudit> outboundAudits = new LinkedHashSet<SmsOutboundAudit>();


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "responseMessage",
    length = 255
  )
  protected String responseMessage;


  /** TODO: DOCUMENT ME! */
  @Column(name = "responseTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date responseTime;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "returnCode",
    length = 4
  )
  protected String returnCode;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "smsCampaignId",
    updatable = true
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected SmsCampaign smsCampaign;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "channelResult"
  )
  protected Set<SmsChannelResultDestination> smsChannelResultDestination =
    new LinkedHashSet<SmsChannelResultDestination>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade       = CascadeType.ALL,
    fetch         = FetchType.LAZY,
    mappedBy      = "smsChannelResult",
    orphanRemoval = true
  )
  protected Set<SmsChannelResultDocument> smsChannelResultDocuments = new LinkedHashSet<SmsChannelResultDocument>();

  // npelleti, 07/30, USBank, Removed unique constraint
  /** Result Id, PK. */
  @Column(
    name     = "smsResultId",

    // unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long smsResultId;


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
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "channelResult"
  )
  protected Set<SmsChannelResultVariableValue> variableValues = new LinkedHashSet<SmsChannelResultVariableValue>();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "vendorId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SmsServiceVendor vendor;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addOutboundAudit.
   *
   * @param  smsOutboundAudit  SmsOutboundAudit
   */
  public void addOutboundAudit(SmsOutboundAudit smsOutboundAudit) {
    smsOutboundAudit.setSmsChannelResult(this);
    outboundAudits.add(smsOutboundAudit);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addSmsChannelActual.
   *
   * @param  smsChannelActualResult  SmsChannelActualResult
   */
  public void addSmsChannelActual(SmsChannelActualResult smsChannelActualResult) {
    getActualResults().add(smsChannelActualResult);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addSmsChannelResultContent.
   *
   * @param  resultDocument  SmsChannelResultDocument
   */
  public void addSmsChannelResultContent(SmsChannelResultDocument resultDocument) {
    if (resultDocument != null) {
      this.smsChannelResultDocuments.add(resultDocument);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addVariableValue.
   *
   * @param  variableValue  SmsChannelResultVariableValue
   */
  public void addVariableValue(SmsChannelResultVariableValue variableValue) {
    if (variableValue != null) {
      this.variableValues.add(variableValue);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
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

    SmsChannelResult other = (SmsChannelResult) obj;

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

    if (this.vendor == null) {
      if (other.vendor != null) {
        return false;
      }
    } else if (!this.vendor.equals(other.vendor)) {
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
  public Set<SmsChannelActualResult> getActualResults() {
    return actualResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contactable.
   *
   * @return  Boolean
   */
  public Boolean getContactable() {
    return contactable;
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
   * The endTime.
   *
   * @return  the endTime
   *
   *          <p>not-null = "false"</p>
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
   * getter method for message reference.
   *
   * @return  String
   */
  public String getMessageReference() {
    return messageReference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getOptOut.
   *
   * @return  Boolean
   *
   *          <p>not-null = "false" type = "yes_no"</p>
   */
  public Boolean getOptOut() {
    return optOut;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The Set.
   *
   * @return  the Set
   *
   *          <p>column = "smsResultId"</p>
   *
   *          <p>column = "smsResultId" class = "com.cmc.credagility.SmsOutboundAudit" insert = "true" update = "true"
   *          inverse = "true" cascade = "none"</p>
   *
   *          <p>lazy = "true" table = "SmsOutboundAudit" inverse = "true"</p>
   */
  public Set<SmsOutboundAudit> getOutboundAudits() {
    return this.outboundAudits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for response message.
   *
   * @return  String
   */
  public String getResponseMessage() {
    return responseMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for response time.
   *
   * @return  Date
   */
  public Date getResponseTime() {
    return responseTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for result id.
   *
   * @return  Long
   */
  @Override public Long getResultId() {
    return getSmsResultId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for return code.
   *
   * @return  String
   */
  public String getReturnCode() {
    return returnCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sms campaign.
   *
   * @return  SmsCampaign
   */
  public SmsCampaign getSmsCampaign() {
    return smsCampaign;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sms channel result destination.
   *
   * @return  Set
   */
  public Set<SmsChannelResultDestination> getSmsChannelResultDestination() {
    return smsChannelResultDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sms channel result documents.
   *
   * @return  Set
   */
  public Set<SmsChannelResultDocument> getSmsChannelResultDocuments() {
    return smsChannelResultDocuments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The SmsResultId.
   *
   * @return  the SmsResultId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getSmsResultId() {
    return smsResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The startTime.
   *
   * @return  the startTime
   *
   *          <p>not-null = "false"</p>
   */
  public String getStartTime() {
    return startTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getStatusDescription() {
    return statusDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable values.
   *
   * @return  Set
   */
  public Set<SmsChannelResultVariableValue> getVariableValues() {
    return variableValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The vendor.
   *
   * @return  the vendor
   *
   *          <p>column = "vendorId" not-null = "true" class = "com.cmc.credagility.SmsServiceVendor" insert = "true"
   *          update = "true" cascade = "save-update"</p>
   */
  public SmsServiceVendor getVendor() {
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
      + ((this.endTime == null) ? 0 : this.endTime.hashCode());
    result = (prime * result)
      + ((this.phoneNumber == null) ? 0 : this.phoneNumber.hashCode());
    result = (prime * result)
      + ((this.startTime == null) ? 0 : this.startTime.hashCode());
    result = (prime * result)
      + ((this.vendor == null) ? 0 : this.vendor.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for actual results.
   *
   * @param  actualResults  Set
   */
  public void setActualResults(Set<SmsChannelActualResult> actualResults) {
    this.actualResults = actualResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contactable.
   *
   * @param  contactable  Boolean
   */
  public void setContactable(Boolean contactable) {
    this.contactable = contactable;
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
   * setter method for message reference.
   *
   * @param  messageReference  String
   */
  public void setMessageReference(String messageReference) {
    this.messageReference = messageReference;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for opt out.
   *
   * @param  optOut  Boolean
   */
  public void setOptOut(Boolean optOut) {
    this.optOut = optOut;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for outbound audits.
   *
   * @param  outboundAudits  Set
   */
  public void setOutboundAudits(Set<SmsOutboundAudit> outboundAudits) {
    this.outboundAudits = outboundAudits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone number.
   *
   * @param  phoneNumber  String
   */
  @Override public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for response message.
   *
   * @param  responseMessage  String
   */
  public void setResponseMessage(String responseMessage) {
    this.responseMessage = responseMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for response time.
   *
   * @param  responseTime  Date
   */
  public void setResponseTime(Date responseTime) {
    this.responseTime = responseTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for result id.
   *
   * @param  resultId  Long
   */
  @Override public void setResultId(Long resultId) {
    setSmsResultId(resultId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for return code.
   *
   * @param  returnCode  String
   */
  public void setReturnCode(String returnCode) {
    this.returnCode = returnCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms campaign.
   *
   * @param  smsCampaign  SmsCampaign
   */
  public void setSmsCampaign(SmsCampaign smsCampaign) {
    this.smsCampaign = smsCampaign;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms channel result destination.
   *
   * @param  smsChannelResultDestination  Set
   */
  public void setSmsChannelResultDestination(Set<SmsChannelResultDestination> smsChannelResultDestination) {
    this.smsChannelResultDestination = smsChannelResultDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms channel result documents.
   *
   * @param  smsChannelResultDocuments  Set
   */
  public void setSmsChannelResultDocuments(Set<SmsChannelResultDocument> smsChannelResultDocuments) {
    this.smsChannelResultDocuments = smsChannelResultDocuments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms result id.
   *
   * @param  smsResultId  Long
   */
  public void setSmsResultId(Long smsResultId) {
    this.smsResultId = smsResultId;
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
   * setter method for variable values.
   *
   * @param  variableValues  Set
   */
  public void setVariableValues(Set<SmsChannelResultVariableValue> variableValues) {
    this.variableValues = variableValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor.
   *
   * @param  vendor  SmsServiceVendor
   */
  public void setVendor(SmsServiceVendor vendor) {
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

    retValue.append("SmsChannelResult ( ").append(super.toString()).append(TAB).append("endTime = ").append(
      this.endTime).append(TAB).append(
      "smsResultId = ").append(this.smsResultId).append(TAB).append(
      "startTime = ").append(this.startTime).append(TAB).append(
      "vendor = ").append(this.vendor).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class SmsChannelResult
