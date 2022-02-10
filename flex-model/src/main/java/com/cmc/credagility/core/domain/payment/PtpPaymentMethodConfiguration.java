package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;

import com.ozstrategy.credagility.core.domain.StatusType;


/**
 * Created by IntelliJ IDEA. User: adevan Date: 3/11/11 Time: 3:20 PM To change this template use File | Settings | File
 * Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "PtpPaymentMethodConfiguration")
public class PtpPaymentMethodConfiguration extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 7254573245446476717L;

  /** TODO: DOCUMENT ME! */
  protected static final transient Logger log = LoggerFactory.getLogger(PtpPaymentMethodConfiguration.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(name = "awMaxDaysCreateFutureSendDateUnsecuredPromise")
  protected Integer awMaxDaysCreateFutureSendDateUnsecuredPromise = 10;

  /** DOCUMENT ME! */
  @Column(name = "awMaxDaysCreatePastSendDateUnsecuredPromise")
  protected Integer awMaxDaysCreatePastSendDateUnsecuredPromise = 10;

  /** DOCUMENT ME! */
  @Column(name = "awMaxDaysSendArrivalDateUnsecuredPromise")
  protected Integer awMaxDaysSendArrivalDateUnsecuredPromise = 10;

  /** DOCUMENT ME! */
  @Column(name = "flexSiteMaxCreateToSendFuturePtpDays")
  protected Integer flexSiteMaxCreateToSendFuturePtpDays = 10;

  /** DOCUMENT ME! */
  @Column(name = "flexSiteMaxCreateToSendPastPtpDays")
  protected Integer flexSiteMaxCreateToSendPastPtpDays = 10;

  /** DOCUMENT ME! */
  @Column(name = "flexSiteMaxSendToArrivalDays")
  protected Integer flexSiteMaxSendToArrivalDays = 10;

  /** DOCUMENT ME! */
  @Column(name = "flexSiteMinCreateToArrivalDays")
  protected Integer flexSiteMinCreateToArrivalDays = 10;

  /** DOCUMENT ME! */
  @Column(
    name     = "minDaysCreateArrivalDatePromise",
    nullable = true
  )
  protected Integer minDaysCreateArrivalDatePromise = 10;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "minimumAmountRateToKeptPTP",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal minimumAmountRateToKeptPTP;

  /** Payment method. */
  @Column(
    name     = "paymentMethod",
    nullable = false,
    length   = 30
  )
  protected String paymentMethod;

  /** Portfolio which portfolio in used. */
  @JoinColumn(
    name     = "portfolioId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** Relation PtpPaymentMethodConfiguration. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "paymentMethodConfiguration",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  @OrderBy("arrivalDate asc")
  protected Set<PromiseToPay> promises = new LinkedHashSet<PromiseToPay>();

  /** Primary Key. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long ptpPaymentMethodConfigurationId;

  /**
   * @see  com.ozstrategy.credagility.core.domain.StatusType
   */
  @Column(
    name     = "status",
    length   = 20,
    nullable = true
  )
  @Enumerated(value = EnumType.STRING)
  protected StatusType status;

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

    PtpPaymentMethodConfiguration that = (PtpPaymentMethodConfiguration) o;

    if ((paymentMethod != null) ? (!paymentMethod.equals(that.paymentMethod)) : (that.paymentMethod != null)) {
      return false;
    }

    if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
      return false;
    }

    if ((ptpPaymentMethodConfigurationId != null)
          ? (!ptpPaymentMethodConfigurationId.equals(
              that.ptpPaymentMethodConfigurationId)) : (that.ptpPaymentMethodConfigurationId != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for aw max days create future send date unsecured promise.
   *
   * @return  Integer
   */
  public Integer getAwMaxDaysCreateFutureSendDateUnsecuredPromise() {
    return awMaxDaysCreateFutureSendDateUnsecuredPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for aw max days create past send date unsecured promise.
   *
   * @return  Integer
   */
  public Integer getAwMaxDaysCreatePastSendDateUnsecuredPromise() {
    return awMaxDaysCreatePastSendDateUnsecuredPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for aw max days send arrival date unsecured promise.
   *
   * @return  Integer
   */
  public Integer getAwMaxDaysSendArrivalDateUnsecuredPromise() {
    return awMaxDaysSendArrivalDateUnsecuredPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex site max create to send future ptp days.
   *
   * @return  Integer
   */
  public Integer getFlexSiteMaxCreateToSendFuturePtpDays() {
    return flexSiteMaxCreateToSendFuturePtpDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex site max create to send past ptp days.
   *
   * @return  Integer
   */
  public Integer getFlexSiteMaxCreateToSendPastPtpDays() {
    return flexSiteMaxCreateToSendPastPtpDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex site max send to arrival days.
   *
   * @return  Integer
   */
  public Integer getFlexSiteMaxSendToArrivalDays() {
    return flexSiteMaxSendToArrivalDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flex site min create to arrival days.
   *
   * @return  Integer
   */
  public Integer getFlexSiteMinCreateToArrivalDays() {
    return flexSiteMinCreateToArrivalDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for min days create arrival date promise.
   *
   * @return  Integer
   */
  public Integer getMinDaysCreateArrivalDatePromise() {
    return minDaysCreateArrivalDatePromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for minimum amount rate to kept PTP.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMinimumAmountRateToKeptPTP() {
    return minimumAmountRateToKeptPTP;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPaymentMethod() {
    return paymentMethod;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PromiseToPay> getPromises() {
    return promises;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPtpPaymentMethodConfigurationId() {
    return ptpPaymentMethodConfigurationId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  StatusType
   */
  public StatusType getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((paymentMethod != null) ? paymentMethod.hashCode() : 0);
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);
    result = (31 * result)
      + ((ptpPaymentMethodConfigurationId != null) ? ptpPaymentMethodConfigurationId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for aw max days create future send date unsecured promise.
   *
   * @param  awMaxDaysCreateFutureSendDateUnsecuredPromise  Integer
   */
  public void setAwMaxDaysCreateFutureSendDateUnsecuredPromise(Integer awMaxDaysCreateFutureSendDateUnsecuredPromise) {
    this.awMaxDaysCreateFutureSendDateUnsecuredPromise = awMaxDaysCreateFutureSendDateUnsecuredPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for aw max days create past send date unsecured promise.
   *
   * @param  awMaxDaysCreatePastSendDateUnsecuredPromise  Integer
   */
  public void setAwMaxDaysCreatePastSendDateUnsecuredPromise(Integer awMaxDaysCreatePastSendDateUnsecuredPromise) {
    this.awMaxDaysCreatePastSendDateUnsecuredPromise = awMaxDaysCreatePastSendDateUnsecuredPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for aw max days send arrival date unsecured promise.
   *
   * @param  awMaxDaysSendArrivalDateUnsecuredPromise  Integer
   */
  public void setAwMaxDaysSendArrivalDateUnsecuredPromise(Integer awMaxDaysSendArrivalDateUnsecuredPromise) {
    this.awMaxDaysSendArrivalDateUnsecuredPromise = awMaxDaysSendArrivalDateUnsecuredPromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex site max create to send future ptp days.
   *
   * @param  flexSiteMaxCreateToSendFuturePtpDays  Integer
   */
  public void setFlexSiteMaxCreateToSendFuturePtpDays(Integer flexSiteMaxCreateToSendFuturePtpDays) {
    this.flexSiteMaxCreateToSendFuturePtpDays = flexSiteMaxCreateToSendFuturePtpDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex site max create to send past ptp days.
   *
   * @param  flexSiteMaxCreateToSendPastPtpDays  Integer
   */
  public void setFlexSiteMaxCreateToSendPastPtpDays(Integer flexSiteMaxCreateToSendPastPtpDays) {
    this.flexSiteMaxCreateToSendPastPtpDays = flexSiteMaxCreateToSendPastPtpDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex site max send to arrival days.
   *
   * @param  flexSiteMaxSendToArrivalDays  Integer
   */
  public void setFlexSiteMaxSendToArrivalDays(Integer flexSiteMaxSendToArrivalDays) {
    this.flexSiteMaxSendToArrivalDays = flexSiteMaxSendToArrivalDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flex site min create to arrival days.
   *
   * @param  flexSiteMinCreateToArrivalDays  Integer
   */
  public void setFlexSiteMinCreateToArrivalDays(Integer flexSiteMinCreateToArrivalDays) {
    this.flexSiteMinCreateToArrivalDays = flexSiteMinCreateToArrivalDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for min days create arrival date promise.
   *
   * @param  minDaysCreateArrivalDatePromise  Integer
   */
  public void setMinDaysCreateArrivalDatePromise(Integer minDaysCreateArrivalDatePromise) {
    this.minDaysCreateArrivalDatePromise = minDaysCreateArrivalDatePromise;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for minimum amount rate to kept PTP.
   *
   * @param  minimumAmountRateToKeptPTP  BigDecimal
   */
  public void setMinimumAmountRateToKeptPTP(BigDecimal minimumAmountRateToKeptPTP) {
    this.minimumAmountRateToKeptPTP = minimumAmountRateToKeptPTP;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentMethod  DOCUMENT ME!
   */
  public void setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  promises  DOCUMENT ME!
   */
  public void setPromises(Set<PromiseToPay> promises) {
    this.promises = promises;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ptpPaymentMethodConfigurationId  DOCUMENT ME!
   */
  public void setPtpPaymentMethodConfigurationId(Long ptpPaymentMethodConfigurationId) {
    this.ptpPaymentMethodConfigurationId = ptpPaymentMethodConfigurationId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  StatusType
   */
  public void setStatus(StatusType status) {
    this.status = status;
  }
} // end class PtpPaymentMethodConfiguration
