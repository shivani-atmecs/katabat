package com.cmc.credagility.core.domain.payment;

import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  01/07/2015 14:08
 */
@Entity
@Table(name = "PaidPromiseToPay")
public class PaidPromiseToPay extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8939441162724270063L;

  //~ Instance fields --------------------------------------------------------------------------------------------------


  /** TODO: DOCUMENT ME! */
  @Column(name = "evalationDate")
  protected Date evalationDate;

  /** paidPtpId - used for performance tracking purpose. */
  @Column(name = "paidPtpId")
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long paidPtpId;


  /** TODO: DOCUMENT ME! */
  @Column(name = "paymentId")
  protected Long paymentId;


  /** promise id. */
  @Column(name = "promiseId")
  protected Long promiseId;


  /** TODO: DOCUMENT ME! */
  @Column(name = "startDate")
  protected Date startDate;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for serial version UID.
   *
   * @return  long
   */
  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createPaidPromiseToPay.
   *
   * @param   paymentId      Long
   * @param   promiseId      Long
   * @param   startDate      Date
   * @param   evalationDate  Date
   *
   * @return  PaidPromiseToPay
   */
  public PaidPromiseToPay createPaidPromiseToPay(Long paymentId, Long promiseId, Date startDate, Date evalationDate) {
    PaidPromiseToPay paidPtp = new PaidPromiseToPay();
    paidPtp.setPaymentId(paymentId);
    paidPtp.setPromiseId(promiseId);
    paidPtp.setStartDate(startDate);
    paidPtp.setEvalationDate(evalationDate);

    // paidPtp.setAmountProcessed(amountProcessed);
    return paidPtp;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#getCreateDate()
   */
  @Override public Date getCreateDate() {
    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for evalation date.
   *
   * @return  Date
   */
  public Date getEvalationDate() {
    return evalationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for paid ptp id.
   *
   * @return  Long
   */
  public Long getPaidPtpId() {
    return paidPtpId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment id.
   *
   * @return  Long
   */
  public Long getPaymentId() {
    return paymentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for promise id.
   *
   * @return  Long
   */
  public Long getPromiseId() {
    return promiseId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for start date.
   *
   * @return  Date
   */
  public Date getStartDate() {
    return startDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = super.hashCode();
    result = (PRIME * result)
      + ((this.paymentId == null) ? 0 : this.paymentId.hashCode());
    result = (PRIME * result)
      + ((this.createDate == null) ? 0 : this.createDate.hashCode());
    result = (PRIME * result)
      + ((this.promiseId == null) ? 0 : this.promiseId.hashCode());
    result = (PRIME * result)
      + ((this.paymentId == null) ? 0 : this.paymentId.hashCode());
    result = (PRIME * result)
      + ((this.startDate == null) ? 0 : this.startDate.hashCode());
    result = (PRIME * result)
      + ((this.evalationDate == null) ? 0 : this.evalationDate.hashCode());

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#setCreateDate(java.util.Date)
   */
  @Override public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for evalation date.
   *
   * @param  evalationDate  Date
   */
  public void setEvalationDate(Date evalationDate) {
    this.evalationDate = evalationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for paid ptp id.
   *
   * @param  paidPtpId  Long
   */
  public void setPaidPtpId(Long paidPtpId) {
    this.paidPtpId = paidPtpId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment id.
   *
   * @param  paymentId  Long
   */
  public void setPaymentId(Long paymentId) {
    this.paymentId = paymentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for promise id.
   *
   * @param  promiseId  Long
   */
  public void setPromiseId(Long promiseId) {
    this.promiseId = promiseId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for start date.
   *
   * @param  startDate  Date
   */
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
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

    retValue.append("paidPtpId ( ").append(this.paidPtpId).append(TAB).append("createDate = ").append(
      this.createDate).append(TAB).append(TAB).append("promiseId = ").append(this.promiseId).append(TAB).append(
      "paymentId = ").append(this.paymentId).append(TAB).append("startDate = ").append(this.startDate).append(TAB)
      .append("evalationDate = ").append(this.evalationDate).append(TAB).append(" )");

    return retValue.toString();
  } // end method toString

} // end class PaidPromiseToPay
