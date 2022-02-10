package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store Payment service provider information.
 *
 * <p><a href="PaymentServiceProvider.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 *
 *           <p>table = "PaymentServiceProvider"</p>
 * @version  10/15/2014 11:45
 */
@Entity
@Table(name = "PaymentServiceProvider")
public class PaymentServiceProvider extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6174209376467271035L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** If there is no retry, we should wait checkClearDays and consider payment as PAID. */
  @Column(name = "checkClearDays")
  protected Integer checkClearDays;


  /** payment confirmed days, default is 3. */
  @Column(name = "maxRetryCount")
  protected Integer maxRetryCount = new Integer(3);

  // npelleti, 07/30, USBank, Added NotNull Annotation
  /** provider name. */
  @Column(
    name     = "name",
    nullable = false,
    length   = 80
  )
  protected String name;

  /** Payment service account password. */
  @Column(
    name   = "password",
    length = 128
  )
  protected String password;


  /**
   * Payment processing fee. default to 0.0. This is not the fee the processor charges CMC. It is the feeCMC will charge
   * the debtor when the debtor submit payment electronically.
   */

  // npelleti, 07/30, USBank, Added NotNull Annotation
  @Column(
    name      = "processingFee",
    nullable  = false,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal processingFee = new BigDecimal("0.00");

  // npelleti, 07/30, USBank, Added NotNull Annotation
  /** Processor time out minutes. */
  @Column(
    name     = "processorTimeOutMinutes",
    nullable = false,
    length   = 11
  )
  protected Integer processorTimeOutMinutes = 3;

  // npelleti, 07/30, USBank, Removed unique constraint
  /** payment service provider PK providerId. */
  @Column(
    name     = "providerId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long providerId;

  /**
   * payment confirmed days, default is 3. It is used when there is retry. If there is any retry, it has to wait after
   * paymentConfirmDays so that consider payment as Paid.
   */

  @Column(name = "retryConfirmDays")
  protected Integer retryConfirmDays = new Integer(7);

  /** the real time processor timeout value. */

  // npelleti, 08/10, USBank, Added NotNull Annotation
  /** payment service url. */
  @Column(
    name     = "serviceUrl",
    nullable = false,
    length   = 255
  )
  protected String serviceUrl;

  /** Payment service account user id. */
  @Column(
    name   = "userId",
    length = 20
  )
  protected String userId;

  // npelleti alter table after userId
  /** Payment service account vendor id. */
  @Column(
    name   = "vendorId",
    length = 20
  )
  protected String vendorId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (!(obj instanceof PaymentServiceProvider)) {
      return false;
    }

    final PaymentServiceProvider other = (PaymentServiceProvider) obj;

    if (createDate == null) {
      if (other.getCreateDate() != null) {
        return false;
      }
    } else if (!createDate.equals(other.getCreateDate())) {
      return false;
    }

    if (name == null) {
      if (other.getName() != null) {
        return false;
      }
    } else if (!name.equals(other.getName())) {
      return false;
    }

    if (retryConfirmDays == null) {
      if (other.getRetryConfirmDays() != null) {
        return false;
      }
    } else if (!retryConfirmDays.equals(other.getRetryConfirmDays())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getCheckClearDays() {
    return checkClearDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   *
   *          <p>not-null = "false"</p>
   */
  public Integer getMaxRetryCount() {
    return maxRetryCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The name.
   *
   * @return  the name
   *
   *          <p>not-null = "true" length = "80"</p>
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The password.
   *
   * @return  the password
   *
   *          <p>not-null = "false" length = "128"</p>
   */
  public String getPassword() {
    return this.password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Payment processing fee charged to debtor using this payment service provider.
   *
   * @return  payment processing fee charged to debtor using this payment service provider.
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getProcessingFee() {
    return processingFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Required. HTTP timeout time.
   *
   * @return  required.
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getProcessorTimeOutMinutes() {
    return processorTimeOutMinutes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The providerId.
   *
   * @return  the providerId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getProviderId() {
    return providerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The paymentConfirmDays.
   *
   * @return  the paymentConfirmDays
   */
  public Integer getRetryConfirmDays() {
    return retryConfirmDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The serviceUrl.
   *
   * @return  the serviceUrl
   *
   *          <p>not-null = "true"</p>
   */
  public String getServiceUrl() {
    return this.serviceUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The userId.
   *
   * @return  the userId
   *
   *          <p>not-null = "false" length = "20"</p>
   */
  public String getUserId() {
    return this.userId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The vendorId.
   *
   * @return  the vendorId
   *
   *          <p>not-null = "false" length = "20"</p>
   */
  public String getVendorId() {
    return this.vendorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result)
      + ((createDate == null) ? 0 : createDate.hashCode());
    result = (prime * result) + ((name == null) ? 0 : name.hashCode());
    result = (prime * result)
      + ((retryConfirmDays == null) ? 0 : retryConfirmDays.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for check clear days.
   *
   * @param  checkClearDays  Integer
   */
  public void setCheckClearDays(Integer checkClearDays) {
    this.checkClearDays = checkClearDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for max retry count.
   *
   * @param  maxRetryCount  Integer
   */
  public void setMaxRetryCount(Integer maxRetryCount) {
    this.maxRetryCount = maxRetryCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setName.
   *
   * @param  name  the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPassword.
   *
   * @param  password  the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for processing fee.
   *
   * @param  processingFee  BigDecimal
   */
  public void setProcessingFee(BigDecimal processingFee) {
    this.processingFee = processingFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for processor time out minutes.
   *
   * @param  processorTimeOutMinutes  Integer
   */
  public void setProcessorTimeOutMinutes(Integer processorTimeOutMinutes) {
    this.processorTimeOutMinutes = processorTimeOutMinutes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setProviderId.
   *
   * @param  providerId  the providerId to set
   */
  public void setProviderId(Long providerId) {
    this.providerId = providerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setRetryConfirmDays.
   *
   * @param  paymentConfirmDays  the paymentConfirmDays to set
   */
  public void setRetryConfirmDays(Integer paymentConfirmDays) {
    this.retryConfirmDays = paymentConfirmDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setServiceUrl.
   *
   * @param  serviceUrl  the serviceUrl to set
   */
  public void setServiceUrl(String serviceUrl) {
    this.serviceUrl = serviceUrl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setUserId.
   *
   * @param  userId  the userId to set
   */
  public void setUserId(String userId) {
    this.userId = userId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setVendorId.
   *
   * @param  vendorId  the vendorId to set
   */
  public void setVendorId(String vendorId) {
    this.vendorId = vendorId;
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

    retValue.append("PaymentServiceProvider ( ").append("name = ").append(
      this.name).append(TAB).append("password = ").append(this.password).append(TAB).append("paymentConfirmDays = ")
      .append(
        this.retryConfirmDays).append(TAB).append("providerId = ").append(
      this.providerId).append(TAB).append("serviceUrl = ").append(
      this.serviceUrl).append(TAB).append("userId = ").append(this.userId).append(TAB).append("vendorId = ").append(
      this.vendorId).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class PaymentServiceProvider
