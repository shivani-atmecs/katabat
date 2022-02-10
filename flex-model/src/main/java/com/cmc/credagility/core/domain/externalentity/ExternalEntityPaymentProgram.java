package com.cmc.credagility.core.domain.externalentity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.ProgramStatus;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/09/2015 10:55
 */
@Entity
@Table(
  name    = "ExternalEntityPaymentProgram",
  indexes = {
    @Index(
      name = "referenceNumberIndex",
      columnList = "externalReferenceNumber"
    )
  }
)
public class ExternalEntityPaymentProgram extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  // ~ Static fields/initializers
  // ---------------------------------------------------------------------------------------


  private static final long serialVersionUID = -6115332306825824552L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The timestamp when the payment program is accepted. */
  @Column(name = "acceptDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date acceptDate;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "cancelledDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date cancelledDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "duration")
  protected Integer duration;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "externalEntityId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ExternalEntity externalEntity;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "externalReferenceNumber",
    length = 20
  )
  protected String externalReferenceNumber;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "name",
    length = 200
  )
  protected String name;

  /** TODO: DOCUMENT ME! */
  @Column(name = "programAmount")
  protected BigDecimal programAmount;


  /** Payment program PK. */
  @Column(
    name     = "programId",
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long programId;

  /**
   * The status of this program. It could be: INIT("Init"), ACCEPTED("Accepted"), BROKENPROMISE("BrokenPromise"), or
   * FULFILLED("Fulfilled").
   */
  @Column(
    name   = "programStatus",
    length = 25
  )
  @Enumerated(EnumType.STRING)
  protected ProgramStatus programStatus;

  /**
   * The responsible party that accepted this program. This is only meaningful when the program status is ACCEPTED.
   * Otherwise it should be null.
   */
  @JoinColumn(name = "responsibleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "source",
    length = 20
  )
  protected String source;
  @Column(
    name   = "clientDefined80CharCode1",
    length = 80
  )
  private String   clientDefined80CharCode1;

  @Column(
    name   = "clientDefined80CharCode2",
    length = 80
  )
  private String clientDefined80CharCode2;

  @Column(name = "clientDefinedDate1")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate1;

  @Column(name = "clientDefinedDate2")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientDefinedDate2;

  @Column(
    name      = "clientDefinedDecimal1",
    precision = 19,
    scale     = 2
  )
  private BigDecimal clientDefinedDecimal1;

  @Column(
    name      = "clientDefinedDecimal2",
    precision = 19,
    scale     = 2
  )
  private BigDecimal clientDefinedDecimal2;

  @Column(
    name   = "clientDefinedFlag1",
    length = 1
  )
  private String clientDefinedFlag1;

  @Column(
    name   = "clientDefinedFlag2",
    length = 1
  )
  private String clientDefinedFlag2;

  @Column(
    name   = "clientDefinedInteger1",
    length = 11
  )
  private Integer clientDefinedInteger1;

  @Column(
    name   = "clientDefinedInteger2",
    length = 11
  )
  private Integer clientDefinedInteger2;

  @Column(name = "clientDefinedLong1")
  private Long clientDefinedLong1;

  @Column(name = "clientDefinedLong2")
  private Long clientDefinedLong2;

  @Column(
    name   = "clientDefinedString1",
    length = 256
  )
  private String clientDefinedString1;

  @Column(
    name   = "clientDefinedString2",
    length = 256
  )
  private String clientDefinedString2;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    ExternalEntityPaymentProgram that = (ExternalEntityPaymentProgram) o;

    if ((acceptDate != null) ? (!acceptDate.equals(that.acceptDate)) : (that.acceptDate != null)) {
      return false;
    }

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((cancelledDate != null) ? (!cancelledDate.equals(that.cancelledDate)) : (that.cancelledDate != null)) {
      return false;
    }

    if ((duration != null) ? (!duration.equals(that.duration)) : (that.duration != null)) {
      return false;
    }

    if ((externalEntity != null) ? (!externalEntity.equals(that.externalEntity)) : (that.externalEntity != null)) {
      return false;
    }

    if ((externalReferenceNumber != null) ? (!externalReferenceNumber.equals(that.externalReferenceNumber))
                                          : (that.externalReferenceNumber != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((programAmount != null) ? (!programAmount.equals(that.programAmount)) : (that.programAmount != null)) {
      return false;
    }

    if ((programId != null) ? (!programId.equals(that.programId)) : (that.programId != null)) {
      return false;
    }

    if (programStatus != that.programStatus) {
      return false;
    }

    if ((responsible != null) ? (!responsible.equals(that.responsible)) : (that.responsible != null)) {
      return false;
    }

    if ((source != null) ? (!source.equals(that.source)) : (that.source != null)) {
      return false;
    }

    if ((clientDefined80CharCode1 != null) ? (!clientDefined80CharCode1.equals(that.clientDefined80CharCode1))
                                           : (that.clientDefined80CharCode1 != null)) {
      return false;
    }

    if ((clientDefined80CharCode2 != null) ? (!clientDefined80CharCode2.equals(that.clientDefined80CharCode2))
                                           : (that.clientDefined80CharCode2 != null)) {
      return false;
    }

    if ((clientDefinedDate1 != null) ? (!clientDefinedDate1.equals(that.clientDefinedDate1))
                                     : (that.clientDefinedDate1 != null)) {
      return false;
    }

    if ((clientDefinedDate2 != null) ? (!clientDefinedDate2.equals(that.clientDefinedDate2))
                                     : (that.clientDefinedDate2 != null)) {
      return false;
    }

    if ((clientDefinedDecimal1 != null) ? (!clientDefinedDecimal1.equals(that.clientDefinedDecimal1))
                                        : (that.clientDefinedDecimal1 != null)) {
      return false;
    }

    if ((clientDefinedDecimal2 != null) ? (!clientDefinedDecimal2.equals(that.clientDefinedDecimal2))
                                        : (that.clientDefinedDecimal2 != null)) {
      return false;
    }

    if ((clientDefinedFlag1 != null) ? (!clientDefinedFlag1.equals(that.clientDefinedFlag1))
                                     : (that.clientDefinedFlag1 != null)) {
      return false;
    }

    if ((clientDefinedFlag2 != null) ? (!clientDefinedFlag2.equals(that.clientDefinedFlag2))
                                     : (that.clientDefinedFlag2 != null)) {
      return false;
    }

    if ((clientDefinedInteger1 != null) ? (!clientDefinedInteger1.equals(that.clientDefinedInteger1))
                                        : (that.clientDefinedInteger1 != null)) {
      return false;
    }

    if ((clientDefinedInteger2 != null) ? (!clientDefinedInteger2.equals(that.clientDefinedInteger2))
                                        : (that.clientDefinedInteger2 != null)) {
      return false;
    }

    if ((clientDefinedLong1 != null) ? (!clientDefinedLong1.equals(that.clientDefinedLong1))
                                     : (that.clientDefinedLong1 != null)) {
      return false;
    }

    if ((clientDefinedLong2 != null) ? (!clientDefinedLong2.equals(that.clientDefinedLong2))
                                     : (that.clientDefinedLong2 != null)) {
      return false;
    }

    if ((clientDefinedString1 != null) ? (!clientDefinedString1.equals(that.clientDefinedString1))
                                       : (that.clientDefinedString1 != null)) {
      return false;
    }

    return (clientDefinedString2 != null) ? clientDefinedString2.equals(that.clientDefinedString2)
                                          : (that.clientDefinedString2 == null);

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for accept date.
   *
   * @return  Date
   */
  public Date getAcceptDate() {
    return acceptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cancelled date.
   *
   * @return  Date
   */
  public Date getCancelledDate() {
    return cancelledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined80 char code1.
   *
   * @return  String
   */
  public String getClientDefined80CharCode1() {
    return clientDefined80CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined80 char code2.
   *
   * @return  String
   */
  public String getClientDefined80CharCode2() {
    return clientDefined80CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date1.
   *
   * @return  Date
   */
  public Date getClientDefinedDate1() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date2.
   *
   * @return  Date
   */
  public Date getClientDefinedDate2() {
    return clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal1() {
    return clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal2.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal2() {
    return clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag1.
   *
   * @return  String
   */
  public String getClientDefinedFlag1() {
    return clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag2.
   *
   * @return  String
   */
  public String getClientDefinedFlag2() {
    return clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer1.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger1() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer2.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger2() {
    return clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined long1.
   *
   * @return  Long
   */
  public Long getClientDefinedLong1() {
    return clientDefinedLong1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined long2.
   *
   * @return  Long
   */
  public Long getClientDefinedLong2() {
    return clientDefinedLong2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string1.
   *
   * @return  String
   */
  public String getClientDefinedString1() {
    return clientDefinedString1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined string2.
   *
   * @return  String
   */
  public String getClientDefinedString2() {
    return clientDefinedString2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for duration.
   *
   * @return  Integer
   */
  public Integer getDuration() {
    return duration;
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
   * getter method for external reference number.
   *
   * @return  String
   */
  public String getExternalReferenceNumber() {
    return externalReferenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getProgramAmount() {
    return programAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program id.
   *
   * @return  Long
   */
  public Long getProgramId() {
    return programId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program status.
   *
   * @return  ProgramStatus
   */
  public ProgramStatus getProgramStatus() {
    return programStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source.
   *
   * @return  String
   */
  public String getSource() {
    return source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((acceptDate != null) ? acceptDate.hashCode() : 0);
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((cancelledDate != null) ? cancelledDate.hashCode() : 0);
    result = (31 * result) + ((duration != null) ? duration.hashCode() : 0);
    result = (31 * result) + ((externalEntity != null) ? externalEntity.hashCode() : 0);
    result = (31 * result) + ((externalReferenceNumber != null) ? externalReferenceNumber.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((programAmount != null) ? programAmount.hashCode() : 0);
    result = (31 * result) + ((programId != null) ? programId.hashCode() : 0);
    result = (31 * result) + ((programStatus != null) ? programStatus.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);
    result = (31 * result) + ((source != null) ? source.hashCode() : 0);
    result = (31 * result) + ((clientDefined80CharCode1 != null) ? clientDefined80CharCode1.hashCode() : 0);
    result = (31 * result) + ((clientDefined80CharCode2 != null) ? clientDefined80CharCode2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate1 != null) ? clientDefinedDate1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDate2 != null) ? clientDefinedDate2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDecimal1 != null) ? clientDefinedDecimal1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedDecimal2 != null) ? clientDefinedDecimal2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedFlag1 != null) ? clientDefinedFlag1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedFlag2 != null) ? clientDefinedFlag2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger1 != null) ? clientDefinedInteger1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedInteger2 != null) ? clientDefinedInteger2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedLong1 != null) ? clientDefinedLong1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedLong2 != null) ? clientDefinedLong2.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString1 != null) ? clientDefinedString1.hashCode() : 0);
    result = (31 * result) + ((clientDefinedString2 != null) ? clientDefinedString2.hashCode() : 0);

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for accept date.
   *
   * @param  acceptDate  Date
   */
  public void setAcceptDate(Date acceptDate) {
    this.acceptDate = acceptDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cancelled date.
   *
   * @param  cancelledDate  Date
   */
  public void setCancelledDate(Date cancelledDate) {
    this.cancelledDate = cancelledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined80 char code1.
   *
   * @param  clientDefined80CharCode1  String
   */
  public void setClientDefined80CharCode1(String clientDefined80CharCode1) {
    this.clientDefined80CharCode1 = clientDefined80CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined80 char code2.
   *
   * @param  clientDefined80CharCode2  String
   */
  public void setClientDefined80CharCode2(String clientDefined80CharCode2) {
    this.clientDefined80CharCode2 = clientDefined80CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date1.
   *
   * @param  clientDefinedDate1  Date
   */
  public void setClientDefinedDate1(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date2.
   *
   * @param  clientDefinedDate2  Date
   */
  public void setClientDefinedDate2(Date clientDefinedDate2) {
    this.clientDefinedDate2 = clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal1.
   *
   * @param  clientDefinedDecimal1  BigDecimal
   */
  public void setClientDefinedDecimal1(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal2.
   *
   * @param  clientDefinedDecimal2  BigDecimal
   */
  public void setClientDefinedDecimal2(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag1.
   *
   * @param  clientDefinedFlag1  String
   */
  public void setClientDefinedFlag1(String clientDefinedFlag1) {
    this.clientDefinedFlag1 = clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag2.
   *
   * @param  clientDefinedFlag2  String
   */
  public void setClientDefinedFlag2(String clientDefinedFlag2) {
    this.clientDefinedFlag2 = clientDefinedFlag2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer1.
   *
   * @param  clientDefinedInteger1  Integer
   */
  public void setClientDefinedInteger1(Integer clientDefinedInteger1) {
    this.clientDefinedInteger1 = clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer2.
   *
   * @param  clientDefinedInteger2  Integer
   */
  public void setClientDefinedInteger2(Integer clientDefinedInteger2) {
    this.clientDefinedInteger2 = clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined long1.
   *
   * @param  clientDefinedLong1  Long
   */
  public void setClientDefinedLong1(Long clientDefinedLong1) {
    this.clientDefinedLong1 = clientDefinedLong1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined long2.
   *
   * @param  clientDefinedLong2  Long
   */
  public void setClientDefinedLong2(Long clientDefinedLong2) {
    this.clientDefinedLong2 = clientDefinedLong2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string1.
   *
   * @param  clientDefinedString1  String
   */
  public void setClientDefinedString1(String clientDefinedString1) {
    this.clientDefinedString1 = clientDefinedString1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined string2.
   *
   * @param  clientDefinedString2  String
   */
  public void setClientDefinedString2(String clientDefinedString2) {
    this.clientDefinedString2 = clientDefinedString2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for duration.
   *
   * @param  duration  Integer
   */
  public void setDuration(Integer duration) {
    this.duration = duration;
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
   * setter method for external reference number.
   *
   * @param  externalReferenceNumber  String
   */
  public void setExternalReferenceNumber(String externalReferenceNumber) {
    this.externalReferenceNumber = externalReferenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program amount.
   *
   * @param  programAmount  BigDecimal
   */
  public void setProgramAmount(BigDecimal programAmount) {
    this.programAmount = programAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program id.
   *
   * @param  programId  Long
   */
  public void setProgramId(Long programId) {
    this.programId = programId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program status.
   *
   * @param  programStatus  ProgramStatus
   */
  public void setProgramStatus(ProgramStatus programStatus) {
    this.programStatus = programStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source.
   *
   * @param  source  String
   */
  public void setSource(String source) {
    this.source = source;
  }
} // end class ExternalEntityPaymentProgram
