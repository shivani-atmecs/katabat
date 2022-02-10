package com.cmc.credagility.core.domain.income;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/14/2014 16:08
 */
@MappedSuperclass public abstract class AbstractIncome extends BaseEntity implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "alimony",
    nullable = true
  )
  protected BigDecimal alimony;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "bonusIncome",
    nullable = true
  )
  protected BigDecimal bonusIncome;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "borrowerPosition",
    length = 1
  )
  protected String borrowerPosition;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "childSupport",
    nullable = true
  )
  protected BigDecimal childSupport;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "disability",
    nullable = true
  )
  protected BigDecimal disability;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "locationCode",
    length   = 6,
    nullable = true
  )
  protected String locationCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "monthlyTakeHomePay",
    nullable = true
  )
  protected BigDecimal monthlyTakeHomePay;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "netRentalIncome",
    nullable = true
  )
  protected BigDecimal netRentalIncome;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "other1",
    length = 20
  )
  protected String other1 = "Other Income1";

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "other1Amount",
    nullable = true
  )
  protected BigDecimal other1Amount;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "other2",
    length = 20
  )
  protected String other2 = "Other Income2";

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "other2Amount",
    nullable = true
  )
  protected BigDecimal other2Amount;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "other3",
    length = 20
  )
  protected String other3 = "Other Income3";

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "other3Amount",
    nullable = true
  )
  protected BigDecimal other3Amount;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "other4",
    length = 20
  )
  protected String other4 = "Other Income4";

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "other4Amount",
    nullable = true
  )
  protected BigDecimal other4Amount;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "other5",
    length = 20
  )
  protected String other5 = "Other Income5";

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "other5Amount",
    nullable = true
  )
  protected BigDecimal other5Amount;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "other6",
    length = 20
  )
  protected String other6 = "Other Income6";

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "other6Amount",
    nullable = true
  )
  protected BigDecimal other6Amount;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "plan401K",
    nullable = true
  )
  protected BigDecimal plan401K;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "stocksBonds",
    nullable = true
  )
  protected BigDecimal stocksBonds;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "unemployment",
    nullable = true
  )
  protected BigDecimal unemployment;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for alimony.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAlimony() {
    return alimony;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bonus income.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBonusIncome() {
    return bonusIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for borrower position.
   *
   * @return  String
   */
  public String getBorrowerPosition() {
    return borrowerPosition;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for child support.
   *
   * @return  BigDecimal
   */
  public BigDecimal getChildSupport() {
    return childSupport;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disability.
   *
   * @return  BigDecimal
   */
  public BigDecimal getDisability() {
    return disability;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for location code.
   *
   * @return  String
   */
  public String getLocationCode() {
    return locationCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for monthly take home pay.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMonthlyTakeHomePay() {
    return monthlyTakeHomePay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for net rental income.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNetRentalIncome() {
    return netRentalIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other1.
   *
   * @return  String
   */
  public String getOther1() {
    return other1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other1 amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOther1Amount() {
    return other1Amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other2.
   *
   * @return  String
   */
  public String getOther2() {
    return other2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other2 amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOther2Amount() {
    return other2Amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other3.
   *
   * @return  String
   */
  public String getOther3() {
    return other3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other3 amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOther3Amount() {
    return other3Amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other4.
   *
   * @return  String
   */
  public String getOther4() {
    return other4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other4 amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOther4Amount() {
    return other4Amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other5.
   *
   * @return  String
   */
  public String getOther5() {
    return other5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other5 amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOther5Amount() {
    return other5Amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other6.
   *
   * @return  String
   */
  public String getOther6() {
    return other6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other6 amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOther6Amount() {
    return other6Amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for plan401 k.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPlan401K() {
    return plan401K;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stocks bonds.
   *
   * @return  BigDecimal
   */
  public BigDecimal getStocksBonds() {
    return stocksBonds;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unemployment.
   *
   * @return  BigDecimal
   */
  public BigDecimal getUnemployment() {
    return unemployment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for alimony.
   *
   * @param  alimony  BigDecimal
   */
  public void setAlimony(BigDecimal alimony) {
    this.alimony = alimony;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bonus income.
   *
   * @param  bonusIncome  BigDecimal
   */
  public void setBonusIncome(BigDecimal bonusIncome) {
    this.bonusIncome = bonusIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for borrower position.
   *
   * @param  borrowerPosition  String
   */
  public void setBorrowerPosition(String borrowerPosition) {
    this.borrowerPosition = borrowerPosition;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for child support.
   *
   * @param  childSupport  BigDecimal
   */
  public void setChildSupport(BigDecimal childSupport) {
    this.childSupport = childSupport;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disability.
   *
   * @param  disability  BigDecimal
   */
  public void setDisability(BigDecimal disability) {
    this.disability = disability;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for location code.
   *
   * @param  locationCode  String
   */
  public void setLocationCode(String locationCode) {
    this.locationCode = locationCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for monthly take home pay.
   *
   * @param  monthlyTakeHomePay  BigDecimal
   */
  public void setMonthlyTakeHomePay(BigDecimal monthlyTakeHomePay) {
    this.monthlyTakeHomePay = monthlyTakeHomePay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for net rental income.
   *
   * @param  netRentalIncome  BigDecimal
   */
  public void setNetRentalIncome(BigDecimal netRentalIncome) {
    this.netRentalIncome = netRentalIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other1.
   *
   * @param  other1  String
   */
  public void setOther1(String other1) {
    this.other1 = other1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other1 amount.
   *
   * @param  other1Amount  BigDecimal
   */
  public void setOther1Amount(BigDecimal other1Amount) {
    this.other1Amount = other1Amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other2.
   *
   * @param  other2  String
   */
  public void setOther2(String other2) {
    this.other2 = other2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other2 amount.
   *
   * @param  other2Amount  BigDecimal
   */
  public void setOther2Amount(BigDecimal other2Amount) {
    this.other2Amount = other2Amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other3.
   *
   * @param  other3  String
   */
  public void setOther3(String other3) {
    this.other3 = other3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other3 amount.
   *
   * @param  other3Amount  BigDecimal
   */
  public void setOther3Amount(BigDecimal other3Amount) {
    this.other3Amount = other3Amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other4.
   *
   * @param  other4  String
   */
  public void setOther4(String other4) {
    this.other4 = other4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other4 amount.
   *
   * @param  other4Amount  BigDecimal
   */
  public void setOther4Amount(BigDecimal other4Amount) {
    this.other4Amount = other4Amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other5.
   *
   * @param  other5  String
   */
  public void setOther5(String other5) {
    this.other5 = other5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other5 amount.
   *
   * @param  other5Amount  BigDecimal
   */
  public void setOther5Amount(BigDecimal other5Amount) {
    this.other5Amount = other5Amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other6.
   *
   * @param  other6  String
   */
  public void setOther6(String other6) {
    this.other6 = other6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other6 amount.
   *
   * @param  other6Amount  BigDecimal
   */
  public void setOther6Amount(BigDecimal other6Amount) {
    this.other6Amount = other6Amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for plan401 k.
   *
   * @param  plan401K  BigDecimal
   */
  public void setPlan401K(BigDecimal plan401K) {
    this.plan401K = plan401K;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stocks bonds.
   *
   * @param  stocksBonds  BigDecimal
   */
  public void setStocksBonds(BigDecimal stocksBonds) {
    this.stocksBonds = stocksBonds;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unemployment.
   *
   * @param  unemployment  BigDecimal
   */
  public void setUnemployment(BigDecimal unemployment) {
    this.unemployment = unemployment;
  }

} // end class AbstractIncome
