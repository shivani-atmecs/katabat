package com.cmc.credagility.core.domain.account;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.DeferralSuspensionRecordType;
import com.cmc.credagility.core.domain.type.FLXGroupImportActionType;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 12:04
 */
@Entity
@Table(
  name    = "DeferralSuspension",
  indexes = {
    @Index(
      name = "recordTypeIndex",
      columnList = "recordType"
    )
  }
)
public class DeferralSuspension extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Relations Responsible Account : */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne(cascade = CascadeType.ALL)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean deleted;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  @Column(
    name   = "action",
    length = 1
  )
  @Enumerated(EnumType.STRING)
  private FLXGroupImportActionType action;

  @Column(name = "clientInfoUpdateDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date clientInfoUpdateDate;

  @Column(name = "fromDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fromDate;

  @Column(
    name   = "paymentNum",
    length = 30
  )
  private Integer paymentNum;

  @Column(
    name   = "reason",
    length = 255
  )
  private String reason;


  @Column(
    name   = "recordType",
    length = 1
  )
  @Enumerated(EnumType.STRING)
  private DeferralSuspensionRecordType recordType;

  @Column(name = "reinstateDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date reinstateDate;

  @Column(name = "toDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date toDate;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new DeferralSuspension object.
   */
  public DeferralSuspension() { }

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

    DeferralSuspension that = (DeferralSuspension) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if (action != that.action) {
      return false;
    }

    if ((clientInfoUpdateDate != null) ? (!clientInfoUpdateDate.equals(that.clientInfoUpdateDate))
                                       : (that.clientInfoUpdateDate != null)) {
      return false;
    }

    if ((deleted != null) ? (!deleted.equals(that.deleted)) : (that.deleted != null)) {
      return false;
    }

    if ((fromDate != null) ? (!fromDate.equals(that.fromDate)) : (that.fromDate != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((paymentNum != null) ? (!paymentNum.equals(that.paymentNum)) : (that.paymentNum != null)) {
      return false;
    }

    if ((reason != null) ? (!reason.equals(that.reason)) : (that.reason != null)) {
      return false;
    }

    if (recordType != that.recordType) {
      return false;
    }

    if ((reinstateDate != null) ? (!reinstateDate.equals(that.reinstateDate)) : (that.reinstateDate != null)) {
      return false;
    }

    if ((toDate != null) ? (!toDate.equals(that.toDate)) : (that.toDate != null)) {
      return false;
    }

    return true;
  } // end method equals

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
   * getter method for action.
   *
   * @return  FLXGroupImportActionType
   */
  public FLXGroupImportActionType getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client info update date.
   *
   * @return  Date
   */
  public Date getClientInfoUpdateDate() {
    return clientInfoUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deleted.
   *
   * @return  Boolean
   */
  public Boolean getDeleted() {
    return deleted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for from date.
   *
   * @return  Date
   */
  public Date getFromDate() {
    return fromDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment num.
   *
   * @return  Integer
   */
  public Integer getPaymentNum() {
    return paymentNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reason.
   *
   * @return  String
   */
  public String getReason() {
    return reason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for record type.
   *
   * @return  DeferralSuspensionRecordType
   */
  public DeferralSuspensionRecordType getRecordType() {
    return recordType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reinstate date.
   *
   * @return  Date
   */
  public Date getReinstateDate() {
    return reinstateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for to date.
   *
   * @return  Date
   */
  public Date getToDate() {
    return toDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((action != null) ? action.hashCode() : 0);
    result = (31 * result) + ((clientInfoUpdateDate != null) ? clientInfoUpdateDate.hashCode() : 0);
    result = (31 * result) + ((fromDate != null) ? fromDate.hashCode() : 0);
    result = (31 * result) + ((paymentNum != null) ? paymentNum.hashCode() : 0);
    result = (31 * result) + ((reason != null) ? reason.hashCode() : 0);
    result = (31 * result) + ((recordType != null) ? recordType.hashCode() : 0);
    result = (31 * result) + ((reinstateDate != null) ? reinstateDate.hashCode() : 0);
    result = (31 * result) + ((toDate != null) ? toDate.hashCode() : 0);
    result = (31 * result) + ((deleted != null) ? deleted.hashCode() : 0);

    return result;
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
   * setter method for action.
   *
   * @param  action  FLXGroupImportActionType
   */
  public void setAction(FLXGroupImportActionType action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client info update date.
   *
   * @param  clientInfoUpdateDate  Date
   */
  public void setClientInfoUpdateDate(Date clientInfoUpdateDate) {
    this.clientInfoUpdateDate = clientInfoUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for deleted.
   *
   * @param  deleted  Boolean
   */
  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for from date.
   *
   * @param  fromDate  Date
   */
  public void setFromDate(Date fromDate) {
    this.fromDate = fromDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment num.
   *
   * @param  paymentNum  Integer
   */
  public void setPaymentNum(Integer paymentNum) {
    this.paymentNum = paymentNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for reason.
   *
   * @param  reason  String
   */
  public void setReason(String reason) {
    this.reason = reason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for record type.
   *
   * @param  recordType  DeferralSuspensionRecordType
   */
  public void setRecordType(DeferralSuspensionRecordType recordType) {
    this.recordType = recordType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for reinstate date.
   *
   * @param  reinstateDate  Date
   */
  public void setReinstateDate(Date reinstateDate) {
    this.reinstateDate = reinstateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for to date.
   *
   * @param  toDate  Date
   */
  public void setToDate(Date toDate) {
    this.toDate = toDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "DeferralSuspension{"
      + "account=" + account
      + ", id=" + id
      + ", action=" + action
      + ", clientInfoUpdateDate=" + clientInfoUpdateDate
      + ", fromDate=" + fromDate
      + ", paymentNum=" + paymentNum
      + ", reason='" + reason + '\''
      + ", recordType=" + recordType
      + ", reinstateDate=" + reinstateDate
      + ", toDate=" + toDate
      + ", deleted=" + deleted
      + '}';
  }
} // end class DeferralSuspension
