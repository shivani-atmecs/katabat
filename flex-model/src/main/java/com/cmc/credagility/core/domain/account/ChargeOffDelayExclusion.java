package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.type.ChargeOffDelayReason;
import com.cmc.credagility.core.domain.type.ChargeOffDelayStatus;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 11:57
 */
@Entity
@Table(name = "ChargeOffDelayExclusion")
public class ChargeOffDelayExclusion extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 8794524876073498792L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Relations ChargeOffDelayExclusion Account : */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne(cascade = CascadeType.ALL)
  protected Account account;


  /** TODO: DOCUMENT ME! */
  @Column(name = "cancelledStatusDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date cancelledStatusDate;

  /** Create date. */
  @Column(
    name      = "chargeOffDelayDate",
    nullable  = false,
    updatable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date chargeOffDelayDate;


  /** TODO: DOCUMENT ME! */
  @Column(length = 32)
  @Enumerated(value = EnumType.STRING)
  protected ChargeOffDelayReason chargeOffDelayReason;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "chargeOffDelayStatus",
    nullable = false,
    length   = 20
  )
  @Enumerated(EnumType.STRING)
  protected ChargeOffDelayStatus chargeOffDelayStatus;


  /** TODO: DOCUMENT ME! */
  @Column(name = "completedStatusDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date completedStatusDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "delayedStatusDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date delayedStatusDate;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    if (!super.equals(o)) {
      return false;
    }

    ChargeOffDelayExclusion that = (ChargeOffDelayExclusion) o;

    if (!account.equals(that.account)) {
      return false;
    }

    if (!chargeOffDelayStatus.equals(that.chargeOffDelayStatus)) {
      return false;
    }

    if (!chargeOffDelayDate.equals(that.chargeOffDelayDate)) {
      return false;
    }

    if (chargeOffDelayReason != that.chargeOffDelayReason) {
      return false;
    }

    if (!cancelledStatusDate.equals(that.cancelledStatusDate)) {
      return false;
    }

    if (!completedStatusDate.equals(that.completedStatusDate)) {
      return false;
    }

    if (!delayedStatusDate.equals(that.delayedStatusDate)) {
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
   * getter method for cancelled status date.
   *
   * @return  Date
   */
  public Date getCancelledStatusDate() {
    return cancelledStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off delay date.
   *
   * @return  Date
   */
  public Date getChargeOffDelayDate() {
    return chargeOffDelayDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off delay reason.
   *
   * @return  ChargeOffDelayReason
   */
  public ChargeOffDelayReason getChargeOffDelayReason() {
    return chargeOffDelayReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off delay status.
   *
   * @return  ChargeOffDelayStatus
   */
  public ChargeOffDelayStatus getChargeOffDelayStatus() {
    if (chargeOffDelayStatus == null) {
      return ChargeOffDelayStatus.PENDING;
    }

    return chargeOffDelayStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for completed status date.
   *
   * @return  Date
   */
  public Date getCompletedStatusDate() {
    return completedStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delayed status date.
   *
   * @return  Date
   */
  public Date getDelayedStatusDate() {
    return delayedStatusDate;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + account.hashCode();
    result = (31 * result) + chargeOffDelayStatus.hashCode();
    result = (31 * result) + chargeOffDelayDate.hashCode();
    result = (31 * result) + chargeOffDelayReason.hashCode();
    result = (31 * result) + cancelledStatusDate.hashCode();
    result = (31 * result) + completedStatusDate.hashCode();
    result = (31 * result) + delayedStatusDate.hashCode();

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
   * setter method for cancelled status date.
   *
   * @param  cancelledStatusDate  Date
   */
  public void setCancelledStatusDate(Date cancelledStatusDate) {
    this.cancelledStatusDate = cancelledStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off delay date.
   *
   * @param  chargeOffDelayDate  Date
   */
  public void setChargeOffDelayDate(Date chargeOffDelayDate) {
    this.chargeOffDelayDate = chargeOffDelayDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off delay reason.
   *
   * @param  chargeOffDelayReason  ChargeOffDelayReason
   */
  public void setChargeOffDelayReason(ChargeOffDelayReason chargeOffDelayReason) {
    this.chargeOffDelayReason = chargeOffDelayReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off delay status.
   *
   * @param  chargeOffDelayStatus  ChargeOffDelayStatus
   */
  public void setChargeOffDelayStatus(ChargeOffDelayStatus chargeOffDelayStatus) {
    this.chargeOffDelayStatus = chargeOffDelayStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for completed status date.
   *
   * @param  completedStatusDate  Date
   */
  public void setCompletedStatusDate(Date completedStatusDate) {
    this.completedStatusDate = completedStatusDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delayed status date.
   *
   * @param  delayedStatusDate  Date
   */
  public void setDelayedStatusDate(Date delayedStatusDate) {
    this.delayedStatusDate = delayedStatusDate;
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
} // end class ChargeOffDelayExclusion
