package com.cmc.credagility.core.domain.channel;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.contact.ContactAddress;
import com.cmc.credagility.core.domain.externalentity.ExternalEntity;
import com.cmc.credagility.core.domain.payment.PaymentProgram;

import com.ozstrategy.credagility.core.domain.document.EnterpriseDocumentVersionTemplate;


/**
 * This class is used to store letter channel action information.
 *
 * <p><a href="LetterChannelResult.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 10:43
 */
@Entity
@Table(
  name    = "LetterChannelResult",
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
public class LetterChannelResult extends BaseChannelResult {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2126559549345576964L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 20)
  protected String businessStatus;

  /** Contact Address! */
  @JoinColumn(
    name     = "contactAddressId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ContactAddress contactAddress;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String documentType;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "documentVersionTemplateId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocumentVersionTemplate documentVersionTemplate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "expiryDate1")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date expiryDate1;

  /** DOCUMENT ME! */
  @Column(name = "expiryDate2")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date expiryDate2;

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
  @OneToMany(
    cascade       = CascadeType.ALL,
    fetch         = FetchType.LAZY,
    orphanRemoval = true,
    mappedBy      = "letterChannelResult"
  )
  protected Set<LetterChannelActualResult> letterChannelActualResults = new LinkedHashSet<LetterChannelActualResult>();

  /** Result Id, PK. */
  @Column(
    name     = "letterResultId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long letterResultId;


  /** Payment Program. */
  @JoinColumn(
    name      = "programId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentProgram program;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  protected String recipientCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "statusDescription",
    length = 250
  )
  protected String statusDescription;

  /** template Content. */
  @JoinColumn(
    name     = "templateContentId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BasePortfolioChannelTemplateContent templateContent;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade       = CascadeType.ALL,
    fetch         = FetchType.LAZY,
    orphanRemoval = true,
    mappedBy      = "channelResult"
  )
  protected Set<LetterChannelResultVariableValue> variableValues =
    new LinkedHashSet<LetterChannelResultVariableValue>();


  /** Letter Service Vendor. */
  @JoinColumn(
    name     = "vendorId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected LetterServiceVendor vendor;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  letterChannelActualResult  DOCUMENT ME!
   */
  public void addLetterChannelActualResult(LetterChannelActualResult letterChannelActualResult) {
    letterChannelActualResult.setLetterChannelResult(this);
    getLetterChannelActualResults().add(letterChannelActualResult);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variableValue  DOCUMENT ME!
   */
  public void addVariableValue(LetterChannelResultVariableValue variableValue) {
    if (variableValue != null) {
      variableValues.add(variableValue);
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

    LetterChannelResult other = (LetterChannelResult) obj;

    if (vendor == null) {
      if (other.vendor != null) {
        return false;
      }
    } else if (!vendor.getVendorId().equals(other.vendor.getVendorId())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business status.
   *
   * @return  String
   */
  public String getBusinessStatus() {
    return businessStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact address.
   *
   * @return  ContactAddress
   */
  public ContactAddress getContactAddress() {
    return contactAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document type.
   *
   * @return  String
   */
  public String getDocumentType() {
    return documentType;
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
   * getter method for expiry date1.
   *
   * @return  Date
   */
  public Date getExpiryDate1() {
    return expiryDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for expiry date2.
   *
   * @return  Date
   */
  public Date getExpiryDate2() {
    return expiryDate2;
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
   * getter method for letter channel actual results.
   *
   * @return  Set
   */
  public Set<LetterChannelActualResult> getLetterChannelActualResults() {
    return letterChannelActualResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // npelleti, 07/30, USBank, Removed unique constraint

  /**
   * DOCUMENT ME!
   *
   * @return  the letterResultId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getLetterResultId() {
    return letterResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the program
   *
   *          <p>lazy = "proxy" column = "programId" not-null = "false" class = "com.cmc.credagility.PaymentProgram"
   *          insert = "true" update = "false" length = "20"</p>
   */
  public PaymentProgram getProgram() {
    return this.program;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recipient code.
   *
   * @return  String
   */
  public String getRecipientCode() {
    return recipientCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.AbstractChannelResult#getResultId()
   */
  @Override public Long getResultId() {
    return getLetterResultId();
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
  public Set<LetterChannelResultVariableValue> getVariableValues() {
    return variableValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getVendor.
   *
   * @return  LetterServiceVendor
   *
   *          <p>column = "vendorId" not-null = "true" class = "com.cmc.credagility.LetterServiceVendor" insert = "true"
   *          update = "true" cascade = "save-update"</p>
   */
  public LetterServiceVendor getVendor() {
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
      + ((vendor == null) ? 0 : vendor.getVendorId().hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business status.
   *
   * @param  businessStatus  String
   */
  public void setBusinessStatus(String businessStatus) {
    this.businessStatus = businessStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact address.
   *
   * @param  contactAddress  ContactAddress
   */
  public void setContactAddress(ContactAddress contactAddress) {
    this.contactAddress = contactAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document type.
   *
   * @param  documentType  String
   */
  public void setDocumentType(String documentType) {
    this.documentType = documentType;
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
   * setter method for expiry date1.
   *
   * @param  expiryDate1  Date
   */
  public void setExpiryDate1(Date expiryDate1) {
    this.expiryDate1 = expiryDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for expiry date2.
   *
   * @param  expiryDate2  Date
   */
  public void setExpiryDate2(Date expiryDate2) {
    this.expiryDate2 = expiryDate2;
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
   * setter method for letter channel actual results.
   *
   * @param  letterChannelActualResults  Set
   */
  public void setLetterChannelActualResults(Set<LetterChannelActualResult> letterChannelActualResults) {
    this.letterChannelActualResults = letterChannelActualResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter result id.
   *
   * @param  letterResultId  Long
   */
  public void setLetterResultId(Long letterResultId) {
    this.letterResultId = letterResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program.
   *
   * @param  program  PaymentProgram
   */
  public void setProgram(PaymentProgram program) {
    this.program = program;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recipient code.
   *
   * @param  recipientCode  String
   */
  public void setRecipientCode(String recipientCode) {
    this.recipientCode = recipientCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.AbstractChannelResult#setResultId(java.lang.Long)
   */
  @Override public void setResultId(Long resultId) {
    setLetterResultId(resultId);
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
  public void setVariableValues(Set<LetterChannelResultVariableValue> variableValues) {
    this.variableValues = variableValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor.
   *
   * @param  vendor  LetterServiceVendor
   */
  public void setVendor(LetterServiceVendor vendor) {
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

    retValue.append("LetterChannelResult ( ").append(super.toString()).append(
      TAB).append("letterResultId = ").append(this.letterResultId).append(TAB).append("vendor = ").append(this.vendor)
      .append(TAB).append(" )");

    return retValue.toString();
  }
} // end class LetterChannelResult
