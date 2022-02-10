package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * Created by IntelliJ IDEA. User: ysun Date: Aug 19, 2010 Time: 1:39:23 PM To change this template use File | Settings
 * | File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class AbstractExpense extends BaseEntity implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Auto fuel repairs <code>BigDecimal.</code> */
  @Column(
    name     = "autoFuelRepairs",
    nullable = true
  )
  protected BigDecimal autoFuelRepairs;

  /** Auto insurance <code>BigDecimal.</code> */
  @Column(
    name     = "autoInsurance",
    nullable = true
  )
  protected BigDecimal autoInsurance;

  /** Auto payment <code>BigDecimal.</code> */
  @Column(
    name     = "autoPayments",
    nullable = true
  )
  protected BigDecimal autoPayments;

  /** cable TV. */
  @Column(
    name     = "cableTV",
    nullable = true
  )
  protected BigDecimal cableTV;

  /** Cell phone <code>BigDecimal.</code> */
  @Column(
    name     = "cellPhone",
    nullable = true
  )
  protected BigDecimal cellPhone;

  /** Child care tuition <code>BigDecimal.</code> */
  @Column(
    name     = "childCareTuition",
    nullable = true
  )
  protected BigDecimal childCareTuition;

  /** Child support alimony <code>BigDecimal.</code> */
  @Column(
    name     = "childSupportAlimony",
    nullable = true
  )
  protected BigDecimal childSupportAlimony;

  /** First mortgage <code>BigDecimal.</code> */
  @Column(
    name     = "firstMortgage",
    nullable = true
  )
  protected BigDecimal firstMortgage;

  /** First mortgage lien holder. */
  @Column(
    name     = "firstMortgageLienholder",
    length   = 20,
    nullable = true
  )
  protected String firstMortgageLienholder;

  /** food. */
  @Column(
    name     = "food",
    nullable = true
  )
  protected BigDecimal food;

  /** HOA Dues <code>BigDecimal.</code> */
  @Column(
    name     = "HOADues",
    nullable = true
  )
  protected BigDecimal hoaDues;

  /** Internet <code>BigDecimal.</code> */
  @Column(
    name     = "internet",
    nullable = true
  )
  protected BigDecimal internet;

  /** Location code. */
  @Column(
    name     = "locationCode",
    length   = 6,
    nullable = true
  )
  protected String locationCode;

  /** Medical <code>BigDecimal.</code> */
  @Column(
    name     = "medical",
    nullable = true
  )
  protected BigDecimal medical;

  /** The number of in house hold <code>Integer.</code> */
  @Column(name = "numberInHousehold")
  protected Integer numberInHousehold;

  /** The number of auto payments <code>Integer.</code> */
  @Column(name = "numberOfAutoPayments")
  protected Integer numberOfAutoPayments;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "otherAmount1",
    nullable = true
  )
  protected BigDecimal otherAmount1;

  /** Other amount2. */
  @Column(
    name     = "otherAmount2",
    nullable = true
  )
  protected BigDecimal otherAmount2;

  /** Other amount3. */
  @Column(
    name     = "otherAmount3",
    nullable = true
  )
  protected BigDecimal otherAmount3;

  /** Other amount4. */
  @Column(
    name     = "otherAmount4",
    nullable = true
  )
  protected BigDecimal otherAmount4;

  /** Other amount5. */
  @Column(
    name     = "otherAmount5",
    nullable = true
  )
  protected BigDecimal otherAmount5;

  /** Other amount6. */
  @Column(
    name     = "otherAmount6",
    nullable = true
  )
  protected BigDecimal otherAmount6;

  /** Other liens. */
  @Column(
    name     = "otherLiens",
    nullable = true
  )
  protected BigDecimal otherLiens;

  /** Other loan payments. */
  @Column(
    name     = "otherLoanPayments",
    nullable = true
  )
  protected BigDecimal otherLoanPayments;

  /** Other mortgage Lisen holder. */
  @Column(
    name     = "otherMortgageLienholder",
    length   = 20,
    nullable = true
  )
  protected String otherMortgageLienholder;

  /** Other name1. */
  @Column(
    name     = "otherName1",
    length   = 20,
    nullable = true
  )
  protected String otherName1 = "Other Expense1";

  /** Other name2. */
  @Column(
    name     = "otherName2",
    length   = 20,
    nullable = true
  )
  protected String otherName2 = "Other Expense2";

  /** Other name3. */
  @Column(
    name     = "otherName3",
    length   = 20,
    nullable = true
  )
  protected String otherName3 = "Other Expense3";

  /** Other name4. */
  @Column(
    name     = "otherName4",
    length   = 20,
    nullable = true
  )
  protected String otherName4 = "Other Expense4";

  /** Other name5! */
  @Column(
    name     = "otherName5",
    length   = 20,
    nullable = true
  )
  protected String otherName5 = "Other Expense5";

  /** Other name6. */
  @Column(
    name     = "otherName6",
    length   = 20,
    nullable = true
  )
  protected String otherName6 = "Other Expense6";

  /** Other property payments <code>BigDecimal.</code> */
  @Column(
    name     = "otherPropPayments",
    nullable = true
  )
  protected BigDecimal otherPropPayments;

  /** pay roll deduction loan. */
  @Column(
    name     = "payrollDeductionLoan",
    nullable = true
  )
  protected BigDecimal payrollDeductionLoan;

  /** Property insurance <code>BigDecimal.</code> */
  @Column(
    name     = "propertyInsurance",
    nullable = true
  )
  protected BigDecimal propertyInsurance;

  /** Property taxes <code>BigDecimal.</code> */
  @Column(
    name     = "propertyTaxes",
    nullable = true
  )
  protected BigDecimal propertyTaxes;

  /** Second Mortgage <code>BigDecimal.</code> */
  @Column(
    name     = "secondMortgage",
    nullable = true
  )
  protected BigDecimal secondMortgage;

  /** telephone <code>BigDecimal.</code> */
  @Column(
    name     = "telephone",
    nullable = true
  )
  protected BigDecimal telephone;

  /** Total credit card payments <code>BigDecimal.</code> */
  @Column(
    name     = "totalCreditCardPayments",
    nullable = true
  )
  protected BigDecimal totalCreditCardPayments;


  /** Utilities <code>BigDecimal.</code> */
  @Column(
    name     = "utilities",
    nullable = true
  )
  protected BigDecimal utilities;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * The autoFuelRepairs.
   *
   * @return  the autoFuelRepairs
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getAutoFuelRepairs() {
    return autoFuelRepairs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The autoInsurance.
   *
   * @return  the autoInsurance
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getAutoInsurance() {
    return autoInsurance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The autoPayments.
   *
   * @return  the autoPayments
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getAutoPayments() {
    return autoPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The cableTV.
   *
   * @return  the cableTV
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getCableTV() {
    return cableTV;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The cellPhone.
   *
   * @return  the cellPhone
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getCellPhone() {
    return cellPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The childCareTuition.
   *
   * @return  the childCareTuition
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getChildCareTuition() {
    return childCareTuition;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The childSupportAlimony.
   *
   * @return  the childSupportAlimony
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getChildSupportAlimony() {
    return childSupportAlimony;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The firstMortgage.
   *
   * @return  the firstMortgage
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getFirstMortgage() {
    return firstMortgage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * FirstMortgageLienholder.
   *
   * @return  firstMortgageLienholder
   *
   *          <p>not-null = "false" length = "20"</p>
   */
  public String getFirstMortgageLienholder() {
    return firstMortgageLienholder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The food.
   *
   * @return  the food
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getFood() {
    return food;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The hoaDues.
   *
   * @return  the hoaDues
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getHoaDues() {
    return hoaDues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The internet.
   *
   * @return  the internet
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getInternet() {
    return internet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * LocationCode.
   *
   * @return  locationCode
   *
   *          <p>not-null = "false" length = "6"</p>
   */
  public String getLocationCode() {
    return locationCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The medical.
   *
   * @return  the medical
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getMedical() {
    return medical;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The numberInHousehold.
   *
   * @return  the numberInHousehold
   *
   *          <p>not-null = "false"</p>
   */
  public Integer getNumberInHousehold() {
    return numberInHousehold;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The numberOfAutoPayments.
   *
   * @return  the numberOfAutoPayments
   *
   *          <p>not-null = "false"</p>
   */
  public Integer getNumberOfAutoPayments() {
    return numberOfAutoPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The otherAmount1.
   *
   * @return  the otherAmount1
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getOtherAmount1() {
    return otherAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The otherAmount2.
   *
   * @return  the otherAmount2
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getOtherAmount2() {
    return otherAmount2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The otherAmount3.
   *
   * @return  the otherAmount3
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getOtherAmount3() {
    return otherAmount3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The otherAmount4.
   *
   * @return  the otherAmount4
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getOtherAmount4() {
    return otherAmount4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The otherAmount5.
   *
   * @return  the otherAmount5
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getOtherAmount5() {
    return otherAmount5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The otherAmount6.
   *
   * @return  the otherAmount6
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getOtherAmount6() {
    return otherAmount6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The otherLiens.
   *
   * @return  the otherLiens
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getOtherLiens() {
    return otherLiens;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The otherLoanPayments.
   *
   * @return  the otherLoanPayments
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getOtherLoanPayments() {
    return otherLoanPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * OtherMortgageLienholder.
   *
   * @return  otherMortgageLienholder
   *
   *          <p>not-null = "false" length = "20"</p>
   */
  public String getOtherMortgageLienholder() {
    return otherMortgageLienholder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * OtherName1.
   *
   * @return  otherName1
   *
   *          <p>not-null = "false" length = "20"</p>
   */
  public String getOtherName1() {
    return otherName1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * OtherName2.
   *
   * @return  otherName2
   *
   *          <p>not-null = "false" length = "20"</p>
   */
  public String getOtherName2() {
    return otherName2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * OtherName3.
   *
   * @return  otherName3
   *
   *          <p>not-null = "false" length = "20"</p>
   */
  public String getOtherName3() {
    return otherName3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * OtherName4.
   *
   * @return  otherName4
   *
   *          <p>not-null = "false" length = "20"</p>
   */
  public String getOtherName4() {
    return otherName4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * OtherName5.
   *
   * @return  otherName5
   *
   *          <p>not-null = "false" length = "20"</p>
   */
  public String getOtherName5() {
    return otherName5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * OtherName6.
   *
   * @return  otherName6
   *
   *          <p>not-null = "false" length = "20"</p>
   */
  public String getOtherName6() {
    return otherName6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The otherPropPayments.
   *
   * @return  the otherPropPayments
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getOtherPropPayments() {
    return otherPropPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The payrollDeductionLoan.
   *
   * @return  the payrollDeductionLoan
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getPayrollDeductionLoan() {
    return payrollDeductionLoan;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The propertyInsurance.
   *
   * @return  the propertyInsurance
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getPropertyInsurance() {
    return propertyInsurance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The propertyTaxes.
   *
   * @return  the propertyTaxes
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getPropertyTaxes() {
    return propertyTaxes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The secondMortgage.
   *
   * @return  the secondMortgage
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getSecondMortgage() {
    return secondMortgage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The telephone.
   *
   * @return  the telephone
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getTelephone() {
    return telephone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The totalCreditCardPayments.
   *
   * @return  the totalCreditCardPayments
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getTotalCreditCardPayments() {
    return totalCreditCardPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The utilities.
   *
   * @return  the utilities
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getUtilities() {
    return utilities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  autoFuelRepairs  the autoFuelRepairs to set
   */
  public void setAutoFuelRepairs(BigDecimal autoFuelRepairs) {
    this.autoFuelRepairs = autoFuelRepairs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  autoInsurance  the autoInsurance to set
   */
  public void setAutoInsurance(BigDecimal autoInsurance) {
    this.autoInsurance = autoInsurance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  autoPayments  the autoPayments to set
   */
  public void setAutoPayments(BigDecimal autoPayments) {
    this.autoPayments = autoPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cableTV  the cableTV to set
   */
  public void setCableTV(BigDecimal cableTV) {
    this.cableTV = cableTV;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cellPhone  the cellPhone to set
   */
  public void setCellPhone(BigDecimal cellPhone) {
    this.cellPhone = cellPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  childCareTuition  the childCareTuition to set
   */
  public void setChildCareTuition(BigDecimal childCareTuition) {
    this.childCareTuition = childCareTuition;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  childSupportAlimony  the childSupportAlimony to set
   */
  public void setChildSupportAlimony(BigDecimal childSupportAlimony) {
    this.childSupportAlimony = childSupportAlimony;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  firstMortgage  the firstMortgage to set
   */
  public void setFirstMortgage(BigDecimal firstMortgage) {
    this.firstMortgage = firstMortgage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  firstMortgageLienholder  the firstMortgageLienholder to set
   */
  public void setFirstMortgageLienholder(String firstMortgageLienholder) {
    this.firstMortgageLienholder = firstMortgageLienholder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  food  the food to set
   */
  public void setFood(BigDecimal food) {
    this.food = food;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  hoaDues  the hoaDues to set
   */
  public void setHoaDues(BigDecimal hoaDues) {
    this.hoaDues = hoaDues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  internet  the internet to set
   */
  public void setInternet(BigDecimal internet) {
    this.internet = internet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  locationCode  the locationCode to set
   */
  public void setLocationCode(String locationCode) {
    this.locationCode = locationCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  medical  the medical to set
   */
  public void setMedical(BigDecimal medical) {
    this.medical = medical;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  numberInHousehold  the numberInHousehold to set
   */
  public void setNumberInHousehold(Integer numberInHousehold) {
    this.numberInHousehold = numberInHousehold;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  numberOfAutoPayments  the numberOfAutoPayments to set
   */
  public void setNumberOfAutoPayments(Integer numberOfAutoPayments) {
    this.numberOfAutoPayments = numberOfAutoPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  otherAmount1  the otherAmount1 to set
   */
  public void setOtherAmount1(BigDecimal otherAmount1) {
    this.otherAmount1 = otherAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  otherAmount2  the otherAmount2 to set
   */
  public void setOtherAmount2(BigDecimal otherAmount2) {
    this.otherAmount2 = otherAmount2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  otherAmount3  the otherAmount3 to set
   */
  public void setOtherAmount3(BigDecimal otherAmount3) {
    this.otherAmount3 = otherAmount3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  otherAmount4  the otherAmount4 to set
   */
  public void setOtherAmount4(BigDecimal otherAmount4) {
    this.otherAmount4 = otherAmount4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  otherAmount5  the otherAmount5 to set
   */
  public void setOtherAmount5(BigDecimal otherAmount5) {
    this.otherAmount5 = otherAmount5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  otherAmount6  the otherAmount6 to set
   */
  public void setOtherAmount6(BigDecimal otherAmount6) {
    this.otherAmount6 = otherAmount6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  otherLiens  the otherLiens to set
   */
  public void setOtherLiens(BigDecimal otherLiens) {
    this.otherLiens = otherLiens;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  otherLoanPayments  the otherLoanPayments to set
   */
  public void setOtherLoanPayments(BigDecimal otherLoanPayments) {
    this.otherLoanPayments = otherLoanPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  otherMortgageLienholder  the otherMortgageLienholder to set
   */
  public void setOtherMortgageLienholder(String otherMortgageLienholder) {
    this.otherMortgageLienholder = otherMortgageLienholder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  otherName1  the otherName1 to set
   */
  public void setOtherName1(String otherName1) {
    this.otherName1 = otherName1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  otherName2  the otherName2 to set
   */
  public void setOtherName2(String otherName2) {
    this.otherName2 = otherName2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  otherName3  the otherName3 to set
   */
  public void setOtherName3(String otherName3) {
    this.otherName3 = otherName3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  otherName4  the otherName4 to set
   */
  public void setOtherName4(String otherName4) {
    this.otherName4 = otherName4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  otherName5  the otherName5 to set
   */
  public void setOtherName5(String otherName5) {
    this.otherName5 = otherName5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  otherName6  the otherName6 to set
   */
  public void setOtherName6(String otherName6) {
    this.otherName6 = otherName6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  otherPropPayments  the otherPropPayments to set
   */
  public void setOtherPropPayments(BigDecimal otherPropPayments) {
    this.otherPropPayments = otherPropPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  payrollDeductionLoan  the payrollDeductionLoan to set
   */
  public void setPayrollDeductionLoan(BigDecimal payrollDeductionLoan) {
    this.payrollDeductionLoan = payrollDeductionLoan;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  propertyInsurance  the propertyInsurance to set
   */
  public void setPropertyInsurance(BigDecimal propertyInsurance) {
    this.propertyInsurance = propertyInsurance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  propertyTaxes  the propertyTaxes to set
   */
  public void setPropertyTaxes(BigDecimal propertyTaxes) {
    this.propertyTaxes = propertyTaxes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  secondMortgage  the secondMortgage to set
   */
  public void setSecondMortgage(BigDecimal secondMortgage) {
    this.secondMortgage = secondMortgage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  telephone  the telephone to set
   */
  public void setTelephone(BigDecimal telephone) {
    this.telephone = telephone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  totalCreditCardPayments  DOCUMENT ME! the TotalCreditCardPayments to set
   */
  public void setTotalCreditCardPayments(BigDecimal totalCreditCardPayments) {
    this.totalCreditCardPayments = totalCreditCardPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  utilities  the utilities to set
   */
  public void setUtilities(BigDecimal utilities) {
    this.utilities = utilities;
  }

} // end class AbstractExpense
