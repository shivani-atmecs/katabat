package com.cmc.credagility.core.domain.customer;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.PortfolioProgramType;


/**
 * Created by huailing on 15/11/2.
 *
 * @author   <a href="mailto:ailing.hu@ozstrategy.com">Ailing Hu</a>
 * @version  11/02/2015 14:31
 */

@Entity
@Table(name = "CustomLoanProgramCalculateResult")
public class CustomLoanProgramCalculateResult extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2923443645328610583L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "customerInfoId",
    nullable = true
  )
  @ManyToOne protected Customer customer;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "customLoanProgramCalculateResultId",
    nullable = false,
    unique   = true
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long customLoanProgramCalculateResultId;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "customLoanProgramCalculateResult"
  )
  protected Set<CustomLoanProgramCalculateResultItem> customLoanProgramCalculateResultItems =
    new LinkedHashSet<CustomLoanProgramCalculateResultItem>();

  /** TODO: DOCUMENT ME! */
  @Column(name = "maxForbMonths")
  protected Long maxForbMonths;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "portfolioProgramTypeId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioProgramType portfolioProgramType;


  /** TODO: DOCUMENT ME! */
  @Column(name = "totalCurrentPayment")
  protected BigDecimal totalCurrentPayment;

  /** TODO: DOCUMENT ME! */
  @Column(name = "totalNewPayment")
  protected BigDecimal totalNewPayment;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer.
   *
   * @return  Customer
   */
  public Customer getCustomer() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom loan program calculate result id.
   *
   * @return  Long
   */
  public Long getCustomLoanProgramCalculateResultId() {
    return customLoanProgramCalculateResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom loan program calculate result items.
   *
   * @return  Set
   */
  public Set<CustomLoanProgramCalculateResultItem> getCustomLoanProgramCalculateResultItems() {
    return customLoanProgramCalculateResultItems;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for max forb months.
   *
   * @return  Long
   */
  public Long getMaxForbMonths() {
    return maxForbMonths;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio program type.
   *
   * @return  PortfolioProgramType
   */
  public PortfolioProgramType getPortfolioProgramType() {
    return portfolioProgramType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total current payment.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTotalCurrentPayment() {
    return totalCurrentPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total new payment.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTotalNewPayment() {
    return totalNewPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer.
   *
   * @param  customer  Customer
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom loan program calculate result id.
   *
   * @param  customLoanProgramCalculateResultId  Long
   */
  public void setCustomLoanProgramCalculateResultId(Long customLoanProgramCalculateResultId) {
    this.customLoanProgramCalculateResultId = customLoanProgramCalculateResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom loan program calculate result items.
   *
   * @param  customLoanProgramCalculateResultItems  Set
   */
  public void setCustomLoanProgramCalculateResultItems(
    Set<CustomLoanProgramCalculateResultItem> customLoanProgramCalculateResultItems) {
    this.customLoanProgramCalculateResultItems = customLoanProgramCalculateResultItems;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for max forb months.
   *
   * @param  maxForbMonths  Long
   */
  public void setMaxForbMonths(Long maxForbMonths) {
    this.maxForbMonths = maxForbMonths;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio program type.
   *
   * @param  portfolioProgramType  PortfolioProgramType
   */
  public void setPortfolioProgramType(PortfolioProgramType portfolioProgramType) {
    this.portfolioProgramType = portfolioProgramType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total current payment.
   *
   * @param  totalCurrentPayment  BigDecimal
   */
  public void setTotalCurrentPayment(BigDecimal totalCurrentPayment) {
    this.totalCurrentPayment = totalCurrentPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total new payment.
   *
   * @param  totalNewPayment  BigDecimal
   */
  public void setTotalNewPayment(BigDecimal totalNewPayment) {
    this.totalNewPayment = totalNewPayment;
  }
} // end class CustomLoanProgramCalculateResult
