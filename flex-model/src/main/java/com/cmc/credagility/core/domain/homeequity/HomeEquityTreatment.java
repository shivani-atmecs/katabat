package com.cmc.credagility.core.domain.homeequity;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.DTI;
import com.cmc.credagility.core.domain.type.HardShip;
import com.cmc.credagility.core.domain.type.MaxPayment;
import com.cmc.credagility.core.domain.type.Product;
import com.cmc.credagility.core.domain.type.Treatment;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to present the Treatment information.
 *
 * <p><a href="HomeEquityTreatment.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 *
 *           <p>table = "HomeEquityTreatment"</p>
 * @version  10/15/2014 13:44
 */
@Entity
@Table(
  name    = "HomeEquityTreatment",
  indexes = {
    @Index(
      name = "heTreatmentOrigAcctNumIndex",
      columnList = "originalAccountNum"
    )
  }
)
public class HomeEquityTreatment extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7764516908924321701L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  // npelleti, 07/30, USBank added notnull constraint
  /** allow Loan Modification. */
  @Column(
    name             = "allowLoanMod",
    nullable         = false,
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowLoanMod;

  // npelleti, 07/30, USBank, Added NotNull Annotation
  /** allow payment plan. */
  @Column(
    name             = "allowPaymentPlan",
    nullable         = false,
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowPaymentPlan;

  // npelleti, 07/30, USBank added notnull constraint
  /** allow Refi. */
  @Column(
    name             = "allowRefi",
    nullable         = false,
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowRefi;

  // npelleti, 07/30, USBank added notnull constraint
  /** allow settlement. */
  @Column(
    name             = "allowSettlement",
    nullable         = false,
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowSettlement;

  /** DTI. */
  @Column(
    name     = "dti",
    length   = 2,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected DTI dti;

  /** Hard Ship. */
  @Column(
    name     = "hardShip",
    length   = 2,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected HardShip hardShip;

  /** id PK. */

  // npelleti, 07/30, USBank, Removed unique constraint
  @Column(
    name     = "id", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Amrization 1. */
  @Column(
    name     = "loanMod1Amort",
    nullable = false
  )
  protected Integer loanMod1Amort;

  /** MAPR 1. */
  @Column(
    name     = "loanMod1MAPR",
    nullable = false
  )
  protected Integer loanMod1MAPR;
  // Loan Modification 2

  /** MIPR 1: Minial Principal Reduction */
  @Column(
    name     = "loanMod1MIPR",
    nullable = false
  )
  protected Integer loanMod1MIPR;

  /** Rate 1. */
  @Column(
    name     = "loanMod1Rate",
    nullable = false
  )
  protected BigDecimal loanMod1Rate;

  /** Amrization 2. */
  @Column(
    name     = "loanMod2Amort",
    nullable = false
  )
  protected Integer loanMod2Amort;

  /** MAPR 2. */
  @Column(
    name     = "loanMod2MAPR",
    nullable = false
  )
  protected Integer loanMod2MAPR;
  // Loan Modification 3

  /** MIPR 2: Minial Principal Reduction */
  @Column(
    name     = "loanMod2MIPR",
    nullable = false
  )
  protected Integer loanMod2MIPR;

  /** Rate 2. */
  @Column(
    name     = "loanMod2Rate",
    nullable = false
  )
  protected BigDecimal loanMod2Rate;

  /** Amrization 3. */
  @Column(
    name     = "loanMod3Amort",
    nullable = false
  )
  protected Integer loanMod3Amort;

  /** MAPR 3. */
  @Column(
    name     = "loanMod3MAPR",
    nullable = false
  )
  protected Integer loanMod3MAPR;
  // Settlement

  /** MIPR 3: Minial Principal Reduction */
  @Column(
    name     = "loanMod3MIPR",
    nullable = false
  )
  protected Integer loanMod3MIPR;

  /** Rate 3. */
  @Column(
    name     = "loanMod3Rate",
    nullable = false
  )
  protected BigDecimal loanMod3Rate;

  /** Max Monthly Payment. */
  @Column(
    name     = "maxMonthlyPayment",
    length   = 2,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected MaxPayment maxMonthlyPayment;

  /** Optimal Treatment. */
  @Column(
    name     = "optimalTreatment",
    length   = 2,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected Treatment optimalTreatment;
  // Playment Plan

  /** Original Account Number. */
  @Column(
    name     = "originalAccountNum",
    nullable = false,
    length   = 255
  )
  protected String originalAccountNum;

  /** Payment plan rate. */
  @Column(
    name     = "paymentPlanRate",
    nullable = false
  )
  protected BigDecimal paymentPlanRate;
  // Loan Modification 1

  /** Payment plan term. */
  @Column(
    name     = "paymentPlanTerm",
    nullable = false
  )
  protected Integer paymentPlanTerm;

  /** Product. */
  @Column(
    name     = "product",
    length   = 4,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected Product product;

  /** Refinance MAPR. */
  @Column(
    name     = "refiMAPR",
    nullable = false
  )
  protected Integer refiMAPR;

  /** Settlement MAPR. */
  @Column(
    name     = "settlementMAPR",
    nullable = false
  )
  protected Integer settlementMAPR;
  // Refinance

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */

  // Refinance

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

    final HomeEquityTreatment other = (HomeEquityTreatment) obj;

    if (dti == null) {
      if (other.dti != null) {
        return false;
      }
    } else if (!dti.equals(other.dti)) {
      return false;
    }

    if (hardShip == null) {
      if (other.hardShip != null) {
        return false;
      }
    } else if (!hardShip.equals(other.hardShip)) {
      return false;
    }

    if (maxMonthlyPayment == null) {
      if (other.maxMonthlyPayment != null) {
        return false;
      }
    } else if (!maxMonthlyPayment.equals(other.maxMonthlyPayment)) {
      return false;
    }

    if (originalAccountNum == null) {
      if (other.originalAccountNum != null) {
        return false;
      }
    } else if (!originalAccountNum.equals(other.originalAccountNum)) {
      return false;
    }

    if (product == null) {
      if (other.product != null) {
        return false;
      }
    } else if (!product.equals(other.product)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The allowLoanMod.
   *
   * @return  the allowLoanMod
   *
   *          <p>not-null = "true" type = "yes_no"</p>
   */
  public Boolean getAllowLoanMod() {
    return allowLoanMod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The allowPaymentPlan.
   *
   * @return  the allowPaymentPlan
   *
   *          <p>not-null = "true" type = "yes_no"</p>
   */
  public Boolean getAllowPaymentPlan() {
    return allowPaymentPlan;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The allowRefi.
   *
   * @return  the allowRefi
   *
   *          <p>not-null = "true" type = "yes_no"</p>
   */
  public Boolean getAllowRefi() {
    return allowRefi;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The allowSettlement.
   *
   * @return  the allowSettlement
   *
   *          <p>not-null = "true" type = "yes_no"</p>
   */
  public Boolean getAllowSettlement() {
    return allowSettlement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The dti.
   *
   * @return  the dti
   *
   *          <p>not-null = "true" length = "2" type = "com.cmc.dao.hibernate.support.DTIUserType"</p>
   */
  public DTI getDti() {
    return dti;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The hardShip.
   *
   * @return  the hardShip
   *
   *          <p>not-null = "true" length = "2" type = "com.cmc.dao.hibernate.support.HardShipUserType"</p>
   */
  public HardShip getHardShip() {
    return hardShip;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The id.
   *
   * @return  the id
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The loanMod1Amort.
   *
   * @return  the loanMod1Amort
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getLoanMod1Amort() {
    return loanMod1Amort;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The loanMod1MAPR.
   *
   * @return  the loanMod1MAPR
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getLoanMod1MAPR() {
    return loanMod1MAPR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getLoanMod1MIPR() {
    return loanMod1MIPR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The loanMod1Rate.
   *
   * @return  the loanMod1Rate
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getLoanMod1Rate() {
    return loanMod1Rate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The loanMod2Amort.
   *
   * @return  the loanMod2Amort
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getLoanMod2Amort() {
    return loanMod2Amort;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The loanMod2MAPR.
   *
   * @return  the loanMod2MAPR
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getLoanMod2MAPR() {
    return loanMod2MAPR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getLoanMod2MIPR() {
    return loanMod2MIPR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The loanMod2Rate.
   *
   * @return  the loanMod2Rate
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getLoanMod2Rate() {
    return loanMod2Rate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The loanMod3Amort.
   *
   * @return  the loanMod3Amort
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getLoanMod3Amort() {
    return loanMod3Amort;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The loanMod3MAPR.
   *
   * @return  the loanMod3MAPR
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getLoanMod3MAPR() {
    return loanMod3MAPR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getLoanMod3MIPR() {
    return loanMod3MIPR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The loanMod3Rate.
   *
   * @return  the loanMod3Rate
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getLoanMod3Rate() {
    return loanMod3Rate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The maxMonthlyPayment.
   *
   * @return  the maxMonthlyPayment
   *
   *          <p>not-null = "true" length = "2" type = "com.cmc.dao.hibernate.support.MaxPaymentUserType"</p>
   */
  public MaxPayment getMaxMonthlyPayment() {
    return maxMonthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The optimalTreatment.
   *
   * @return  the optimalTreatment
   *
   *          <p>not-null = "true" length = "2" type = "com.cmc.dao.hibernate.support.TreatmentUserType"</p>
   */
  public Treatment getOptimalTreatment() {
    return optimalTreatment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The orginalAccountNum.
   *
   * @return  the orginalAccountNum
   *
   *          <p>not-null = "true" index = "heTreatmentOrigAcctNumIndex"</p>
   */
  public String getOriginalAccountNum() {
    return originalAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The paymentPlanRate.
   *
   * @return  the paymentPlanRate
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getPaymentPlanRate() {
    return paymentPlanRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The paymentPlanTerm.
   *
   * @return  the paymentPlanTerm
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getPaymentPlanTerm() {
    return paymentPlanTerm;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The product.
   *
   * @return  the product
   *
   *          <p>not-null = "true" length = "4" type = "com.cmc.dao.hibernate.support.ProductUserType"</p>
   */
  public Product getProduct() {
    return product;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The refiMAPR.
   *
   * @return  the refiMAPR
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getRefiMAPR() {
    return refiMAPR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The settlementMAPR.
   *
   * @return  the settlementMAPR
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getSettlementMAPR() {
    return settlementMAPR;
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
    result = (prime * result) + ((dti == null) ? 0 : dti.hashCode());
    result = (prime * result) + ((hardShip == null) ? 0 : hardShip.hashCode());
    result = (prime * result)
      + ((maxMonthlyPayment == null) ? 0 : maxMonthlyPayment.hashCode());
    result = (prime * result)
      + ((originalAccountNum == null) ? 0 : originalAccountNum.hashCode());
    result = (prime * result) + ((product == null) ? 0 : product.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAllowLoanMod.
   *
   * @param  allowLoanMod  the allowLoanMod to set
   */
  public void setAllowLoanMod(Boolean allowLoanMod) {
    this.allowLoanMod = allowLoanMod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAllowPaymentPlan.
   *
   * @param  allowPaymentPlan  the allowPaymentPlan to set
   */
  public void setAllowPaymentPlan(Boolean allowPaymentPlan) {
    this.allowPaymentPlan = allowPaymentPlan;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAllowRefi.
   *
   * @param  allowRefi  the allowRefi to set
   */
  public void setAllowRefi(Boolean allowRefi) {
    this.allowRefi = allowRefi;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAllowSettlement.
   *
   * @param  allowSettlement  the allowSettlement to set
   */
  public void setAllowSettlement(Boolean allowSettlement) {
    this.allowSettlement = allowSettlement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setDti.
   *
   * @param  dti  the dti to set
   */
  public void setDti(DTI dti) {
    this.dti = dti;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setHardShip.
   *
   * @param  hardShip  the hardShip to set
   */
  public void setHardShip(HardShip hardShip) {
    this.hardShip = hardShip;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setId.
   *
   * @param  id  the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setLoanMod1Amort.
   *
   * @param  loanMod1Amort  the loanMod1Amort to set
   */
  public void setLoanMod1Amort(Integer loanMod1Amort) {
    this.loanMod1Amort = loanMod1Amort;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setLoanMod1MAPR.
   *
   * @param  loanMod1MAPR  the loanMod1MAPR to set
   */
  public void setLoanMod1MAPR(Integer loanMod1MAPR) {
    this.loanMod1MAPR = loanMod1MAPR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for loan mod1 MIPR.
   *
   * @param  loanMod1MIPR  Integer
   */
  public void setLoanMod1MIPR(Integer loanMod1MIPR) {
    this.loanMod1MIPR = loanMod1MIPR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setLoanMod1Rate.
   *
   * @param  loanMod1Rate  the loanMod1Rate to set
   */
  public void setLoanMod1Rate(BigDecimal loanMod1Rate) {
    this.loanMod1Rate = loanMod1Rate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setLoanMod2Amort.
   *
   * @param  loanMod2Amort  the loanMod2Amort to set
   */
  public void setLoanMod2Amort(Integer loanMod2Amort) {
    this.loanMod2Amort = loanMod2Amort;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setLoanMod2MAPR.
   *
   * @param  loanMod2MAPR  the loanMod2MAPR to set
   */
  public void setLoanMod2MAPR(Integer loanMod2MAPR) {
    this.loanMod2MAPR = loanMod2MAPR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for loan mod2 MIPR.
   *
   * @param  loanMod2MIPR  Integer
   */
  public void setLoanMod2MIPR(Integer loanMod2MIPR) {
    this.loanMod2MIPR = loanMod2MIPR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setLoanMod2Rate.
   *
   * @param  loanMod2Rate  the loanMod2Rate to set
   */
  public void setLoanMod2Rate(BigDecimal loanMod2Rate) {
    this.loanMod2Rate = loanMod2Rate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setLoanMod3Amort.
   *
   * @param  loanMod3Amort  the loanMod3Amort to set
   */
  public void setLoanMod3Amort(Integer loanMod3Amort) {
    this.loanMod3Amort = loanMod3Amort;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setLoanMod3MAPR.
   *
   * @param  loanMod3MAPR  the loanMod3MAPR to set
   */
  public void setLoanMod3MAPR(Integer loanMod3MAPR) {
    this.loanMod3MAPR = loanMod3MAPR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for loan mod3 MIPR.
   *
   * @param  loanMod3MIPR  Integer
   */
  public void setLoanMod3MIPR(Integer loanMod3MIPR) {
    this.loanMod3MIPR = loanMod3MIPR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setLoanMod3Rate.
   *
   * @param  loanMod3Rate  the loanMod3Rate to set
   */
  public void setLoanMod3Rate(BigDecimal loanMod3Rate) {
    this.loanMod3Rate = loanMod3Rate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setMaxMonthlyPayment.
   *
   * @param  maxMonthlyPayment  the maxMonthlyPayment to set
   */
  public void setMaxMonthlyPayment(MaxPayment maxMonthlyPayment) {
    this.maxMonthlyPayment = maxMonthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setOptimalTreatment.
   *
   * @param  optimalTreatment  the optimalTreatment to set
   */
  public void setOptimalTreatment(Treatment optimalTreatment) {
    this.optimalTreatment = optimalTreatment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for original account num.
   *
   * @param  originalAccountNum  String
   */
  public void setOriginalAccountNum(String originalAccountNum) {
    this.originalAccountNum = originalAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPaymentPlanRate.
   *
   * @param  paymentPlanRate  the paymentPlanRate to set
   */
  public void setPaymentPlanRate(BigDecimal paymentPlanRate) {
    this.paymentPlanRate = paymentPlanRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPaymentPlanTerm.
   *
   * @param  paymentPlanTerm  the paymentPlanTerm to set
   */
  public void setPaymentPlanTerm(Integer paymentPlanTerm) {
    this.paymentPlanTerm = paymentPlanTerm;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setProduct.
   *
   * @param  product  the product to set
   */
  public void setProduct(Product product) {
    this.product = product;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setRefiMAPR.
   *
   * @param  refiMAPR  the refiMAPR to set
   */
  public void setRefiMAPR(Integer refiMAPR) {
    this.refiMAPR = refiMAPR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setSettlementMAPR.
   *
   * @param  settlementMAPR  the settlementMAPR to set
   */
  public void setSettlementMAPR(Integer settlementMAPR) {
    this.settlementMAPR = settlementMAPR;
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

    retValue.append("HomeEquityTreatment ( ").append(super.toString()).append(
      TAB).append("allowLoanMod = ").append(this.allowLoanMod).append(TAB).append("allowPaymentPlan = ").append(
      this.allowPaymentPlan).append(TAB).append("allowRefi = ").append(this.allowRefi).append(TAB).append(
      "allowSettlement = ").append(this.allowSettlement).append(TAB).append("dti = ").append(this.dti).append(TAB)
      .append("hardShip = ").append(this.hardShip).append(TAB).append("id = ").append(this.id).append(TAB).append(
      "loanMod1Amort = ").append(this.loanMod1Amort).append(TAB).append("loanMod1MAPR = ").append(this.loanMod1MAPR)
      .append(TAB).append("loanMod1Rate = ").append(this.loanMod1Rate).append(TAB).append("loanMod2Amort = ").append(
      this.loanMod2Amort).append(TAB).append("loanMod2MAPR = ").append(this.loanMod2MAPR).append(TAB).append(
      "loanMod2Rate = ").append(this.loanMod2Rate).append(TAB).append("loanMod3Amort = ").append(this.loanMod3Amort)
      .append(TAB).append("loanMod3MAPR = ").append(this.loanMod3MAPR).append(TAB).append("loanMod3Rate = ").append(
      this.loanMod3Rate).append(TAB).append("maxMonthlyPayment = ").append(
      this.maxMonthlyPayment).append(TAB).append("optimalTreatment = ").append(this.optimalTreatment).append(TAB)
      .append(
        "orginalAccountNum = ").append(this.originalAccountNum).append(TAB).append("paymentPlanRate = ").append(
      this.paymentPlanRate).append(TAB).append("paymentPlanTerm = ").append(this.paymentPlanTerm).append(TAB).append(
      "product = ").append(this.product).append(TAB).append(
      "refiMAPR = ").append(this.refiMAPR).append(TAB).append(
      "settlementMAPR = ").append(this.settlementMAPR).append(TAB).append(" )");

    return retValue.toString();
  } // end method toString

} // end class HomeEquityTreatment
