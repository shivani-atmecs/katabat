package com.cmc.credagility.core.domain.channel;

import java.math.BigDecimal;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.contact.ContactAddress;
import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.payment.PaymentProgram;

import com.ozstrategy.credagility.core.domain.document.EnterpriseDocumentVersionTemplate;


/**
 * This class is used to store letter channel action information.
 *
 * <p><a href="LetterChannelResult.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 10:55
 */
@Entity
@Table(
  name    = "LetterChannelActualResult",
  indexes = {
    @Index(
      name = "createDateIndex",
      columnList = "createDate"
    ), @Index(
      name = "uniqueSessionIdIndex",
      columnList = "uniqueSessionId"
    )
  }
)
public class LetterChannelActualResult extends BaseChannelActualResult {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2126559549534576964L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Contact Address. */
  @JoinColumn(
    name     = "contactAddressId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ContactAddress contactAddress;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "deliveryStatus",
    length = 20
  )
  protected String deliveryStatus;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "documentVersionTemplateId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseDocumentVersionTemplate documentVersionTemplate;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "letterChannelActualResultDocumentId",
    nullable = true
  )
  @OneToOne(
    fetch         = FetchType.LAZY,
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected LetterChannelActualResultDocument letterChannelActualResultDocument;

  /** Result Id, PK. */
  @JoinColumn(
    name      = "letterResultId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected LetterChannelResult letterChannelResult;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    orphanRemoval = true,
    cascade       = CascadeType.ALL,
    mappedBy      = "letterChannelActualResult"
  )
  protected Set<LetterChannelVerifiedAddress> letterChannelVerifiedAddress =
    new LinkedHashSet<LetterChannelVerifiedAddress>();


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "letterData1",
    length = 100
  )
  protected String letterData1;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "letterData10",
    length = 100
  )
  protected String letterData10;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "letterData2",
    length = 100
  )
  protected String letterData2;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "letterData3",
    length = 100
  )
  protected String letterData3;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "letterData4",
    length = 100
  )
  protected String letterData4;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "letterData5",
    length = 150
  )
  protected String letterData5;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "letterData6",
    length = 2048
  )
  protected String letterData6;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "letterData7",
    length = 2048
  )
  protected String letterData7;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "letterData8",
    length = 2048
  )
  protected String letterData8;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "letterData9",
    length = 100
  )
  protected String letterData9;


  /** TODO: DOCUMENT ME! */
  @Column(name = "letterDate1")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date letterDate1;


  /** TODO: DOCUMENT ME! */
  @Column(name = "letterDate2")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date letterDate2;


  /** TODO: DOCUMENT ME! */
  @Column(name = "letterDecimal1")
  protected BigDecimal letterDecimal1;


  /** TODO: DOCUMENT ME! */
  @Column(name = "letterDecimal2")
  protected BigDecimal letterDecimal2;


  /** TODO: DOCUMENT ME! */
  @Column(name = "letterInteger1")
  protected Integer letterInteger1;


  /** TODO: DOCUMENT ME! */
  @Column(name = "letterInteger2")
  protected Integer letterInteger2;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "letterResultActualId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long letterResultActualId;


  /** Payment. */
  @JoinColumn(
    name      = "paymentId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Payment payment;


  /** Payment Program. */
  @JoinColumn(
    name      = "programId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentProgram program;


  /** status description. */
  @Column(
    name   = "statusDescription",
    length = 50
  )
  protected String statusDescription;


  /** Base Portfolio Channel Template Content. */
  @JoinColumn(
    name     = "templateContentId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BasePortfolioChannelTemplateContent templateContent;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addLetterChannelVerifiedAddress.
   *
   * @param  letterChannelVerifiedAddress  LetterChannelVerifiedAddress
   */
  public void addLetterChannelVerifiedAddress(LetterChannelVerifiedAddress letterChannelVerifiedAddress) {
    if (letterChannelVerifiedAddress != null) {
      this.letterChannelVerifiedAddress.add(letterChannelVerifiedAddress);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.BaseChannelActualResult#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof LetterChannelActualResult)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    LetterChannelActualResult that = (LetterChannelActualResult) o;

    if ((contactAddress != null) ? (!contactAddress.equals(that.contactAddress)) : (that.contactAddress != null)) {
      return false;
    }

    if ((documentVersionTemplate != null) ? (!documentVersionTemplate.equals(that.documentVersionTemplate))
                                          : (that.documentVersionTemplate != null)) {
      return false;
    }

    if ((letterChannelResult != null) ? (!letterChannelResult.equals(that.letterChannelResult))
                                      : (that.letterChannelResult != null)) {
      return false;
    }

    if ((letterResultActualId != null) ? (!letterResultActualId.equals(that.letterResultActualId))
                                       : (that.letterResultActualId != null)) {
      return false;
    }

    if ((payment != null) ? (!payment.equals(that.payment)) : (that.payment != null)) {
      return false;
    }

    if ((program != null) ? (!program.equals(that.program)) : (that.program != null)) {
      return false;
    }

    if ((templateContent != null) ? (!templateContent.equals(that.templateContent)) : (that.templateContent != null)) {
      return false;
    }

    return true;
  } // end method equals

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
   * getter method for delivery status.
   *
   * @return  String
   */
  public String getDeliveryStatus() {
    return deliveryStatus;
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
   * getter method for letter channel actual result document.
   *
   * @return  LetterChannelActualResultDocument
   */
  public LetterChannelActualResultDocument getLetterChannelActualResultDocument() {
    return letterChannelActualResultDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter channel result.
   *
   * @return  LetterChannelResult
   */
  public LetterChannelResult getLetterChannelResult() {
    return letterChannelResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter channel verified address.
   *
   * @return  Set
   */
  public Set<LetterChannelVerifiedAddress> getLetterChannelVerifiedAddress() {
    return letterChannelVerifiedAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter data1.
   *
   * @return  String
   */
  public String getLetterData1() {
    return letterData1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter data10.
   *
   * @return  String
   */
  public String getLetterData10() {
    return letterData10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter data2.
   *
   * @return  String
   */
  public String getLetterData2() {
    return letterData2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter data3.
   *
   * @return  String
   */
  public String getLetterData3() {
    return letterData3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter data4.
   *
   * @return  String
   */
  public String getLetterData4() {
    return letterData4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter data5.
   *
   * @return  String
   */
  public String getLetterData5() {
    return letterData5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter data6.
   *
   * @return  String
   */
  public String getLetterData6() {
    return letterData6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter data7.
   *
   * @return  String
   */
  public String getLetterData7() {
    return letterData7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter data8.
   *
   * @return  String
   */
  public String getLetterData8() {
    return letterData8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter data9.
   *
   * @return  String
   */
  public String getLetterData9() {
    return letterData9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter date1.
   *
   * @return  Date
   */
  public Date getLetterDate1() {
    return letterDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter date2.
   *
   * @return  Date
   */
  public Date getLetterDate2() {
    return letterDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter decimal1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLetterDecimal1() {
    return letterDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter decimal2.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLetterDecimal2() {
    return letterDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter integer1.
   *
   * @return  Integer
   */
  public Integer getLetterInteger1() {
    return letterInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter integer2.
   *
   * @return  Integer
   */
  public Integer getLetterInteger2() {
    return letterInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter result actual id.
   *
   * @return  Long
   */
  public Long getLetterResultActualId() {
    return letterResultActualId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment.
   *
   * @return  Payment
   */
  public Payment getPayment() {
    return payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program.
   *
   * @return  PaymentProgram
   */
  public PaymentProgram getProgram() {
    return this.program;
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
   * @see  com.cmc.credagility.core.domain.channel.BaseChannelActualResult#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((contactAddress != null) ? contactAddress.hashCode() : 0);
    result = (31 * result) + ((documentVersionTemplate != null) ? documentVersionTemplate.hashCode() : 0);
    result = (31 * result) + ((letterChannelResult != null) ? letterChannelResult.hashCode() : 0);
    result = (31 * result) + ((letterResultActualId != null) ? letterResultActualId.hashCode() : 0);
    result = (31 * result) + ((payment != null) ? payment.hashCode() : 0);
    result = (31 * result) + ((program != null) ? program.hashCode() : 0);
    result = (31 * result) + ((templateContent != null) ? templateContent.hashCode() : 0);

    return result;
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
   * setter method for delivery status.
   *
   * @param  deliveryStatus  String
   */
  public void setDeliveryStatus(String deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
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
   * setter method for letter channel actual result document.
   *
   * @param  letterChannelActualResultDocument  LetterChannelActualResultDocument
   */
  public void setLetterChannelActualResultDocument(
    LetterChannelActualResultDocument letterChannelActualResultDocument) {
    this.letterChannelActualResultDocument = letterChannelActualResultDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter channel result.
   *
   * @param  letterChannelResult  LetterChannelResult
   */
  public void setLetterChannelResult(LetterChannelResult letterChannelResult) {
    this.letterChannelResult = letterChannelResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter channel verified address.
   *
   * @param  letterChannelVerifiedAddress  Set
   */
  public void setLetterChannelVerifiedAddress(Set<LetterChannelVerifiedAddress> letterChannelVerifiedAddress) {
    this.letterChannelVerifiedAddress = letterChannelVerifiedAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter data1.
   *
   * @param  letterData1  String
   */
  public void setLetterData1(String letterData1) {
    this.letterData1 = letterData1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter data10.
   *
   * @param  letterData10  String
   */
  public void setLetterData10(String letterData10) {
    this.letterData10 = letterData10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter data2.
   *
   * @param  letterData2  String
   */
  public void setLetterData2(String letterData2) {
    this.letterData2 = letterData2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter data3.
   *
   * @param  letterData3  String
   */
  public void setLetterData3(String letterData3) {
    this.letterData3 = letterData3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter data4.
   *
   * @param  letterData4  String
   */
  public void setLetterData4(String letterData4) {
    this.letterData4 = letterData4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter data5.
   *
   * @param  letterData5  String
   */
  public void setLetterData5(String letterData5) {
    this.letterData5 = letterData5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter data6.
   *
   * @param  letterData6  String
   */
  public void setLetterData6(String letterData6) {
    this.letterData6 = letterData6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter data7.
   *
   * @param  letterData7  String
   */
  public void setLetterData7(String letterData7) {
    this.letterData7 = letterData7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter data8.
   *
   * @param  letterData8  String
   */
  public void setLetterData8(String letterData8) {
    this.letterData8 = letterData8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter data9.
   *
   * @param  letterData9  String
   */
  public void setLetterData9(String letterData9) {
    this.letterData9 = letterData9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter date1.
   *
   * @param  letterDate1  Date
   */
  public void setLetterDate1(Date letterDate1) {
    this.letterDate1 = letterDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter date2.
   *
   * @param  letterDate2  Date
   */
  public void setLetterDate2(Date letterDate2) {
    this.letterDate2 = letterDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter decimal1.
   *
   * @param  letterDecimal1  BigDecimal
   */
  public void setLetterDecimal1(BigDecimal letterDecimal1) {
    this.letterDecimal1 = letterDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter decimal2.
   *
   * @param  letterDecimal2  BigDecimal
   */
  public void setLetterDecimal2(BigDecimal letterDecimal2) {
    this.letterDecimal2 = letterDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter integer1.
   *
   * @param  letterInteger1  Integer
   */
  public void setLetterInteger1(Integer letterInteger1) {
    this.letterInteger1 = letterInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter integer2.
   *
   * @param  letterInteger2  Integer
   */
  public void setLetterInteger2(Integer letterInteger2) {
    this.letterInteger2 = letterInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter result actual id.
   *
   * @param  letterResultActualId  Long
   */
  public void setLetterResultActualId(Long letterResultActualId) {
    this.letterResultActualId = letterResultActualId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment.
   *
   * @param  payment  Payment
   */
  public void setPayment(Payment payment) {
    this.payment = payment;
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


} // end class LetterChannelActualResult
