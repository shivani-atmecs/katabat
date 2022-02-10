package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.type.PaymentMethodSubType;
import com.cmc.credagility.core.domain.type.PaymentMethodType;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "PaymentFeeConfiguration")
public class PaymentFeeConfiguration extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7789295642155307653L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Default payment fee <code>BigDecimal.</code> */
  @Column(
    name      = "defaultPaymentFee",
    nullable  = true,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal defaultPaymentFee;

  /** The maximum payment fee <code>BigDecimal.</code> */
  @Column(
    name      = "maxPaymentFee",
    nullable  = true,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal maxPaymentFee;

  /** The minimum payment fee <code>BigDecimal.</code> */
  @Column(
    name      = "minPaymentFee",
    nullable  = true,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal minPaymentFee;

  /** flag the payment fee if required for a Payment. */
  @Column(
    name             = "paymentFeeEditable",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean paymentFeeEditable;

  /** flag the payment fee if required for a Payment. */
  @Column(
    name             = "paymentFeeRequired",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean paymentFeeRequired;

  /**
   * Payment method sub type.
   *
   * @see  com.cmc.credagility.core.domain.type.PaymentMethodSubType
   */
  @Column(
    name     = "paymentMethodSubType",
    nullable = false,
    length   = 20
  )
  @Enumerated(EnumType.STRING)
  protected PaymentMethodSubType paymentMethodSubType;

  /**
   * Payment method type.
   *
   * @see  com.cmc.credagility.core.domain.type.PaymentMethodType
   */
  @Column(
    name     = "paymentMethodType",
    nullable = false,
    length   = 20
  )
  @Enumerated(EnumType.STRING)
  protected PaymentMethodType paymentMethodType;

  @Column(
    name     = "paymentFeeConfigurationId",
    nullable = false
  )
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  @JoinColumn(
    name     = "portfolioId",
    nullable = false
  )
  @ManyToOne private Portfolio portfolio;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PaymentFeeConfiguration)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PaymentFeeConfiguration that = (PaymentFeeConfiguration) o;

    if ((defaultPaymentFee != null) ? (!defaultPaymentFee.equals(that.defaultPaymentFee))
                                    : (that.defaultPaymentFee != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((maxPaymentFee != null) ? (!maxPaymentFee.equals(that.maxPaymentFee)) : (that.maxPaymentFee != null)) {
      return false;
    }

    if ((minPaymentFee != null) ? (!minPaymentFee.equals(that.minPaymentFee)) : (that.minPaymentFee != null)) {
      return false;
    }

    if ((paymentFeeEditable != null) ? (!paymentFeeEditable.equals(that.paymentFeeEditable))
                                     : (that.paymentFeeEditable != null)) {
      return false;
    }

    if ((paymentFeeRequired != null) ? (!paymentFeeRequired.equals(that.paymentFeeRequired))
                                     : (that.paymentFeeRequired != null)) {
      return false;
    }

    if (paymentMethodSubType != that.paymentMethodSubType) {
      return false;
    }

    if (paymentMethodType != that.paymentMethodType) {
      return false;
    }

    if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getDefaultPaymentFee() {
    return defaultPaymentFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getMaxPaymentFee() {
    return maxPaymentFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getMinPaymentFee() {
    return minPaymentFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getPaymentFeeEditable() {
    if (paymentFeeEditable == null) {
      return Boolean.FALSE;
    }

    return paymentFeeEditable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getPaymentFeeRequired() {
    if (paymentFeeRequired == null) {
      return Boolean.FALSE;
    }

    return paymentFeeRequired;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentMethodSubType getPaymentMethodSubType() {
    return paymentMethodSubType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PaymentMethodType getPaymentMethodType() {
    return paymentMethodType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((defaultPaymentFee != null) ? defaultPaymentFee.hashCode() : 0);
    result = (31 * result) + ((maxPaymentFee != null) ? maxPaymentFee.hashCode() : 0);
    result = (31 * result) + ((minPaymentFee != null) ? minPaymentFee.hashCode() : 0);
    result = (31 * result) + ((paymentFeeEditable != null) ? paymentFeeEditable.hashCode() : 0);
    result = (31 * result) + ((paymentFeeRequired != null) ? paymentFeeRequired.hashCode() : 0);
    result = (31 * result) + ((paymentMethodSubType != null) ? paymentMethodSubType.hashCode() : 0);
    result = (31 * result) + ((paymentMethodType != null) ? paymentMethodType.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  defaultPaymentFee  DOCUMENT ME!
   */
  public void setDefaultPaymentFee(BigDecimal defaultPaymentFee) {
    this.defaultPaymentFee = defaultPaymentFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maxPaymentFee  DOCUMENT ME!
   */
  public void setMaxPaymentFee(BigDecimal maxPaymentFee) {
    this.maxPaymentFee = maxPaymentFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  minPaymentFee  DOCUMENT ME!
   */
  public void setMinPaymentFee(BigDecimal minPaymentFee) {
    this.minPaymentFee = minPaymentFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentFeeEditable  DOCUMENT ME!
   */
  public void setPaymentFeeEditable(Boolean paymentFeeEditable) {
    this.paymentFeeEditable = paymentFeeEditable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentFeeRequired  DOCUMENT ME!
   */
  public void setPaymentFeeRequired(Boolean paymentFeeRequired) {
    this.paymentFeeRequired = paymentFeeRequired;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentMethodSubType  DOCUMENT ME!
   */
  public void setPaymentMethodSubType(PaymentMethodSubType paymentMethodSubType) {
    this.paymentMethodSubType = paymentMethodSubType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentMethodType  DOCUMENT ME!
   */
  public void setPaymentMethodType(PaymentMethodType paymentMethodType) {
    this.paymentMethodType = paymentMethodType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }
} // end class PaymentFeeConfiguration
