package com.cmc.credagility.core.domain.homeequity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.activity.CTMSurveyActivity;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.util.FormatUtil;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 13:32
 */
@Entity
@Table(name = "HomeEquityCTMSurvey")
public class HomeEquityCTMSurvey extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3864463354401992235L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne protected Account account;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "responsibleId",
    updatable = false
  )
  @ManyToOne protected Responsible responsible;
  @Column(
    name   = "associationFeePaymentStatus",
    length = 255
  )
  private String                   associationFeePaymentStatus;
  @Column(name = "associationFeeRemainingBalance")
  private BigDecimal               associationFeeRemainingBalance;
  @Column(name = "autoMonthlyPayment")
  private BigDecimal               autoMonthlyPayment;
  @Column(
    name   = "autoPaymentStatus",
    length = 255
  )
  private String                   autoPaymentStatus;
  @Column(name = "autoRemainingBalance")
  private BigDecimal               autoRemainingBalance;
  @Column(
    name             = "continueToOwn",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean                  continueToOwn;
  @Column(name = "creditCardMonthlyPayment")
  private BigDecimal               creditCardMonthlyPayment;
  @Column(
    name   = "creditCardPaymentStatus",
    length = 255
  )
  private String                   creditCardPaymentStatus;
  @Column(name = "creditCardRemainingBalance")
  private BigDecimal               creditCardRemainingBalance;
  @Column(name = "currentValue")
  private BigDecimal               currentValue;
  @Column(
    name   = "firstMortgageAccountNumber",
    length = 255
  )
  private String                   firstMortgageAccountNumber;
  @Column(
    name   = "firstMortgageLenderName",
    length = 255
  )
  private String                   firstMortgageLenderName;
  @Column(name = "firstMortgageMonthlyPayment")
  private BigDecimal               firstMortgageMonthlyPayment;
  @Column(
    name   = "firstMortgagePaymentStatus",
    length = 255
  )
  private String                   firstMortgagePaymentStatus;
  @Column(name = "firstMortgageRemainingBalance")
  private BigDecimal               firstMortgageRemainingBalance;

  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long   id;
  @Column(
    name   = "insurancePaymentStatus",
    length = 255
  )
  private String     insurancePaymentStatus;
  @Column(name = "insuranceRemainingBalance")
  private BigDecimal insuranceRemainingBalance;
  @Column(name = "monthlyAssociationFee")
  private BigDecimal monthlyAssociationFee;
  @Column(name = "monthlyInsurance")
  private BigDecimal monthlyInsurance;

  /* Monthly Loan Expense */
  @Column(name = "monthlyTax")
  private BigDecimal monthlyTax;

  /* Mortgage Info */
  @Column(
    name   = "mortgageCount",
    length = 255
  )
  private String mortgageCount;

  /* Property Info */
  @Column(
    name   = "occupancyType",
    length = 20
  )
  private String occupancyType;

  @Column(
    name             = "onSale",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean onSale;
  @Column(
    name             = "onSaleForSixMonth",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean onSaleForSixMonth;

  /* Other Debt */
  @Column(name = "otherMortgageMonthlyPayment")
  private BigDecimal otherMortgageMonthlyPayment;
  @Column(
    name   = "otherMortgagePaymentStatus",
    length = 255
  )
  private String     otherMortgagePaymentStatus;
  @Column(name = "otherMortgageRemainingBalance")
  private BigDecimal otherMortgageRemainingBalance;
  @Column(name = "personalLoanMonthlyPayment")
  private BigDecimal personalLoanMonthlyPayment;
  @Column(
    name   = "personalLoanPaymentStatus",
    length = 255
  )
  private String     personalLoanPaymentStatus;
  @Column(name = "personalLoanRemainingBalance")
  private BigDecimal personalLoanRemainingBalance;

  // npelleti 08/11 altered the length to 255 chars
  /* Customer Info */
  @Column(
    name   = "primaryCellPhone",
    length = 255
  )
  private String primaryCellPhone;
  @Column(
    name   = "primaryContactMethod",
    length = 255
  )
  private String primaryContactMethod;
  @Column(
    name   = "primaryContactTime",
    length = 255
  )
  private String primaryContactTime;
  @Column(
    name   = "primaryEmailAddress",
    length = 255
  )
  private String primaryEmailAddress;

  // npelleti, 07/30, USBank Add a column
  // npelleti  08/17 Made PrimaryHome char type
  @Column(
    name             = "primaryHome",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  private String     primaryHome;
  @Column(
    name   = "primaryHomePhone",
    length = 16
  )
  private String     primaryHomePhone;
  @Column(name = "primaryMonthlyBonus")
  private BigDecimal primaryMonthlyBonus;
  @Column(name = "primaryMonthlyBsaseGrossIncome")
  private BigDecimal primaryMonthlyBsaseGrossIncome;

  /* Monthly Income */
  @Column(name = "primaryMonthlyBsaseNetIncome")
  private BigDecimal primaryMonthlyBsaseNetIncome;
  @Column(name = "primaryMonthlyCommission")
  private BigDecimal primaryMonthlyCommission;
  @Column(name = "primaryMonthlyDividentInterest")
  private BigDecimal primaryMonthlyDividentInterest;
  @Column(name = "primaryMonthlyNetRentalIncome")
  private BigDecimal primaryMonthlyNetRentalIncome;
  @Column(name = "primaryMonthlyOverTimeIncome")
  private BigDecimal primaryMonthlyOverTimeIncome;
  @Column(
    name   = "primaryWorkPhone",
    length = 255
  )
  private String     primaryWorkPhone;
  @Column(
    name   = "secondaryCellPhone",
    length = 255
  )
  private String     secondaryCellPhone;
  @Column(
    name   = "secondaryContactMethod",
    length = 255
  )
  private String     secondaryContactMethod;
  @Column(
    name   = "secondaryContactTime",
    length = 255
  )
  private String     secondaryContactTime;
  @Column(
    name   = "secondaryEmailAddress",
    length = 255
  )
  private String     secondaryEmailAddress;
  @Column(
    name   = "secondaryHomePhone",
    length = 16
  )
  private String     secondaryHomePhone;
  @Column(name = "secondaryMonthlyBonus")
  private BigDecimal secondaryMonthlyBonus;
  @Column(name = "secondaryMonthlyBsaseGrossIncome")
  private BigDecimal secondaryMonthlyBsaseGrossIncome;

  /* Monthly Income */
  @Column(name = "secondaryMonthlyBsaseNetIncome")
  private BigDecimal secondaryMonthlyBsaseNetIncome;
  @Column(name = "secondaryMonthlyCommission")
  private BigDecimal secondaryMonthlyCommission;
  @Column(name = "secondaryMonthlyDividentInterest")
  private BigDecimal secondaryMonthlyDividentInterest;
  @Column(name = "secondaryMonthlyNetRentalIncome")
  private BigDecimal secondaryMonthlyNetRentalIncome;
  @Column(name = "secondaryMonthlyOverTimeIncome")
  private BigDecimal secondaryMonthlyOverTimeIncome;
  @Column(
    name   = "secondaryWorkPhone",
    length = 255
  )
  private String     secondaryWorkPhone;
  @Column(
    name   = "secondMortgageAccountNumber",
    length = 255
  )
  private String     secondMortgageAccountNumber;
  @Column(
    name   = "secondMortgageLenderName",
    length = 255
  )
  private String     secondMortgageLenderName;
  @Column(name = "secondMortgageMonthlyPayment")
  private BigDecimal secondMortgageMonthlyPayment;
  @Column(
    name   = "secondMortgagePaymentStatus",
    length = 255
  )
  private String     secondMortgagePaymentStatus;
  @Column(name = "secondMortgageRemainingBalance")
  private BigDecimal secondMortgageRemainingBalance;
  @Column(name = "studentLoanMonthlyPayment")
  private BigDecimal studentLoanMonthlyPayment;
  @Column(
    name   = "studentLoanPaymentStatus",
    length = 255
  )
  private String     studentLoanPaymentStatus;
  @Column(name = "studentLoanRemainingBalance")
  private BigDecimal studentLoanRemainingBalance;
  @Column(
    name   = "taxPaymentStatus",
    length = 255
  )
  private String     taxPaymentStatus;
  @Column(name = "taxRemainingBalance")
  private BigDecimal taxRemainingBalance;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    HomeEquityCTMSurvey other = (HomeEquityCTMSurvey) obj;

    if (associationFeePaymentStatus == null) {
      if (other.associationFeePaymentStatus != null) {
        return false;
      }
    } else if (!associationFeePaymentStatus.equals(other.associationFeePaymentStatus)) {
      return false;
    }

    if (associationFeeRemainingBalance == null) {
      if (other.associationFeeRemainingBalance != null) {
        return false;
      }
    } else if (!associationFeeRemainingBalance.equals(other.associationFeeRemainingBalance)) {
      return false;
    }

    if (autoMonthlyPayment == null) {
      if (other.autoMonthlyPayment != null) {
        return false;
      }
    } else if (!autoMonthlyPayment.equals(other.autoMonthlyPayment)) {
      return false;
    }

    if (autoPaymentStatus == null) {
      if (other.autoPaymentStatus != null) {
        return false;
      }
    } else if (!autoPaymentStatus.equals(other.autoPaymentStatus)) {
      return false;
    }

    if (autoRemainingBalance == null) {
      if (other.autoRemainingBalance != null) {
        return false;
      }
    } else if (!autoRemainingBalance.equals(other.autoRemainingBalance)) {
      return false;
    }

    if (continueToOwn == null) {
      if (other.continueToOwn != null) {
        return false;
      }
    } else if (!continueToOwn.equals(other.continueToOwn)) {
      return false;
    }

    if (creditCardMonthlyPayment == null) {
      if (other.creditCardMonthlyPayment != null) {
        return false;
      }
    } else if (!creditCardMonthlyPayment.equals(other.creditCardMonthlyPayment)) {
      return false;
    }

    if (creditCardPaymentStatus == null) {
      if (other.creditCardPaymentStatus != null) {
        return false;
      }
    } else if (!creditCardPaymentStatus.equals(other.creditCardPaymentStatus)) {
      return false;
    }

    if (creditCardRemainingBalance == null) {
      if (other.creditCardRemainingBalance != null) {
        return false;
      }
    } else if (!creditCardRemainingBalance.equals(other.creditCardRemainingBalance)) {
      return false;
    }

    if (currentValue == null) {
      if (other.currentValue != null) {
        return false;
      }
    } else if (!currentValue.equals(other.currentValue)) {
      return false;
    }

    if (firstMortgageAccountNumber == null) {
      if (other.firstMortgageAccountNumber != null) {
        return false;
      }
    } else if (!firstMortgageAccountNumber.equals(other.firstMortgageAccountNumber)) {
      return false;
    }

    if (firstMortgageLenderName == null) {
      if (other.firstMortgageLenderName != null) {
        return false;
      }
    } else if (!firstMortgageLenderName.equals(other.firstMortgageLenderName)) {
      return false;
    }

    if (firstMortgageMonthlyPayment == null) {
      if (other.firstMortgageMonthlyPayment != null) {
        return false;
      }
    } else if (!firstMortgageMonthlyPayment.equals(other.firstMortgageMonthlyPayment)) {
      return false;
    }

    if (firstMortgagePaymentStatus == null) {
      if (other.firstMortgagePaymentStatus != null) {
        return false;
      }
    } else if (!firstMortgagePaymentStatus.equals(other.firstMortgagePaymentStatus)) {
      return false;
    }

    if (firstMortgageRemainingBalance == null) {
      if (other.firstMortgageRemainingBalance != null) {
        return false;
      }
    } else if (!firstMortgageRemainingBalance.equals(other.firstMortgageRemainingBalance)) {
      return false;
    }

    if (insurancePaymentStatus == null) {
      if (other.insurancePaymentStatus != null) {
        return false;
      }
    } else if (!insurancePaymentStatus.equals(other.insurancePaymentStatus)) {
      return false;
    }

    if (insuranceRemainingBalance == null) {
      if (other.insuranceRemainingBalance != null) {
        return false;
      }
    } else if (!insuranceRemainingBalance.equals(other.insuranceRemainingBalance)) {
      return false;
    }

    if (monthlyAssociationFee == null) {
      if (other.monthlyAssociationFee != null) {
        return false;
      }
    } else if (!monthlyAssociationFee.equals(other.monthlyAssociationFee)) {
      return false;
    }

    if (monthlyInsurance == null) {
      if (other.monthlyInsurance != null) {
        return false;
      }
    } else if (!monthlyInsurance.equals(other.monthlyInsurance)) {
      return false;
    }

    if (monthlyTax == null) {
      if (other.monthlyTax != null) {
        return false;
      }
    } else if (!monthlyTax.equals(other.monthlyTax)) {
      return false;
    }

    if (mortgageCount == null) {
      if (other.mortgageCount != null) {
        return false;
      }
    } else if (!mortgageCount.equals(other.mortgageCount)) {
      return false;
    }

    if (occupancyType == null) {
      if (other.occupancyType != null) {
        return false;
      }
    } else if (!occupancyType.equals(other.occupancyType)) {
      return false;
    }

    if (onSale == null) {
      if (other.onSale != null) {
        return false;
      }
    } else if (!onSale.equals(other.onSale)) {
      return false;
    }

    if (onSaleForSixMonth == null) {
      if (other.onSaleForSixMonth != null) {
        return false;
      }
    } else if (!onSaleForSixMonth.equals(other.onSaleForSixMonth)) {
      return false;
    }

    if (otherMortgageMonthlyPayment == null) {
      if (other.otherMortgageMonthlyPayment != null) {
        return false;
      }
    } else if (!otherMortgageMonthlyPayment.equals(other.otherMortgageMonthlyPayment)) {
      return false;
    }

    if (otherMortgagePaymentStatus == null) {
      if (other.otherMortgagePaymentStatus != null) {
        return false;
      }
    } else if (!otherMortgagePaymentStatus.equals(other.otherMortgagePaymentStatus)) {
      return false;
    }

    if (otherMortgageRemainingBalance == null) {
      if (other.otherMortgageRemainingBalance != null) {
        return false;
      }
    } else if (!otherMortgageRemainingBalance.equals(other.otherMortgageRemainingBalance)) {
      return false;
    }

    if (personalLoanMonthlyPayment == null) {
      if (other.personalLoanMonthlyPayment != null) {
        return false;
      }
    } else if (!personalLoanMonthlyPayment.equals(other.personalLoanMonthlyPayment)) {
      return false;
    }

    if (personalLoanPaymentStatus == null) {
      if (other.personalLoanPaymentStatus != null) {
        return false;
      }
    } else if (!personalLoanPaymentStatus.equals(other.personalLoanPaymentStatus)) {
      return false;
    }

    if (personalLoanRemainingBalance == null) {
      if (other.personalLoanRemainingBalance != null) {
        return false;
      }
    } else if (!personalLoanRemainingBalance.equals(other.personalLoanRemainingBalance)) {
      return false;
    }

    if (primaryCellPhone == null) {
      if (other.primaryCellPhone != null) {
        return false;
      }
    } else if (!primaryCellPhone.equals(other.primaryCellPhone)) {
      return false;
    }

    if (primaryContactMethod == null) {
      if (other.primaryContactMethod != null) {
        return false;
      }
    } else if (!primaryContactMethod.equals(other.primaryContactMethod)) {
      return false;
    }

    if (primaryContactTime == null) {
      if (other.primaryContactTime != null) {
        return false;
      }
    } else if (!primaryContactTime.equals(other.primaryContactTime)) {
      return false;
    }

    if (primaryEmailAddress == null) {
      if (other.primaryEmailAddress != null) {
        return false;
      }
    } else if (!primaryEmailAddress.equals(other.primaryEmailAddress)) {
      return false;
    }

    if (primaryHomePhone == null) {
      if (other.primaryHomePhone != null) {
        return false;
      }
    } else if (!primaryHomePhone.equals(other.primaryHomePhone)) {
      return false;
    }

    if (primaryMonthlyBonus == null) {
      if (other.primaryMonthlyBonus != null) {
        return false;
      }
    } else if (!primaryMonthlyBonus.equals(other.primaryMonthlyBonus)) {
      return false;
    }

    if (primaryMonthlyBsaseGrossIncome == null) {
      if (other.primaryMonthlyBsaseGrossIncome != null) {
        return false;
      }
    } else if (!primaryMonthlyBsaseGrossIncome.equals(other.primaryMonthlyBsaseGrossIncome)) {
      return false;
    }

    if (primaryMonthlyBsaseNetIncome == null) {
      if (other.primaryMonthlyBsaseNetIncome != null) {
        return false;
      }
    } else if (!primaryMonthlyBsaseNetIncome.equals(other.primaryMonthlyBsaseNetIncome)) {
      return false;
    }

    if (primaryMonthlyCommission == null) {
      if (other.primaryMonthlyCommission != null) {
        return false;
      }
    } else if (!primaryMonthlyCommission.equals(other.primaryMonthlyCommission)) {
      return false;
    }

    if (primaryMonthlyDividentInterest == null) {
      if (other.primaryMonthlyDividentInterest != null) {
        return false;
      }
    } else if (!primaryMonthlyDividentInterest.equals(other.primaryMonthlyDividentInterest)) {
      return false;
    }

    if (primaryMonthlyNetRentalIncome == null) {
      if (other.primaryMonthlyNetRentalIncome != null) {
        return false;
      }
    } else if (!primaryMonthlyNetRentalIncome.equals(other.primaryMonthlyNetRentalIncome)) {
      return false;
    }

    if (primaryMonthlyOverTimeIncome == null) {
      if (other.primaryMonthlyOverTimeIncome != null) {
        return false;
      }
    } else if (!primaryMonthlyOverTimeIncome.equals(other.primaryMonthlyOverTimeIncome)) {
      return false;
    }

    if (primaryWorkPhone == null) {
      if (other.primaryWorkPhone != null) {
        return false;
      }
    } else if (!primaryWorkPhone.equals(other.primaryWorkPhone)) {
      return false;
    }

    if (secondMortgageAccountNumber == null) {
      if (other.secondMortgageAccountNumber != null) {
        return false;
      }
    } else if (!secondMortgageAccountNumber.equals(other.secondMortgageAccountNumber)) {
      return false;
    }

    if (secondMortgageLenderName == null) {
      if (other.secondMortgageLenderName != null) {
        return false;
      }
    } else if (!secondMortgageLenderName.equals(other.secondMortgageLenderName)) {
      return false;
    }

    if (secondMortgageMonthlyPayment == null) {
      if (other.secondMortgageMonthlyPayment != null) {
        return false;
      }
    } else if (!secondMortgageMonthlyPayment.equals(other.secondMortgageMonthlyPayment)) {
      return false;
    }

    if (secondMortgagePaymentStatus == null) {
      if (other.secondMortgagePaymentStatus != null) {
        return false;
      }
    } else if (!secondMortgagePaymentStatus.equals(other.secondMortgagePaymentStatus)) {
      return false;
    }

    if (secondMortgageRemainingBalance == null) {
      if (other.secondMortgageRemainingBalance != null) {
        return false;
      }
    } else if (!secondMortgageRemainingBalance.equals(other.secondMortgageRemainingBalance)) {
      return false;
    }

    if (secondaryCellPhone == null) {
      if (other.secondaryCellPhone != null) {
        return false;
      }
    } else if (!secondaryCellPhone.equals(other.secondaryCellPhone)) {
      return false;
    }

    if (secondaryContactMethod == null) {
      if (other.secondaryContactMethod != null) {
        return false;
      }
    } else if (!secondaryContactMethod.equals(other.secondaryContactMethod)) {
      return false;
    }

    if (secondaryContactTime == null) {
      if (other.secondaryContactTime != null) {
        return false;
      }
    } else if (!secondaryContactTime.equals(other.secondaryContactTime)) {
      return false;
    }

    if (secondaryEmailAddress == null) {
      if (other.secondaryEmailAddress != null) {
        return false;
      }
    } else if (!secondaryEmailAddress.equals(other.secondaryEmailAddress)) {
      return false;
    }

    if (secondaryHomePhone == null) {
      if (other.secondaryHomePhone != null) {
        return false;
      }
    } else if (!secondaryHomePhone.equals(other.secondaryHomePhone)) {
      return false;
    }

    if (secondaryMonthlyBonus == null) {
      if (other.secondaryMonthlyBonus != null) {
        return false;
      }
    } else if (!secondaryMonthlyBonus.equals(other.secondaryMonthlyBonus)) {
      return false;
    }

    if (secondaryMonthlyBsaseGrossIncome == null) {
      if (other.secondaryMonthlyBsaseGrossIncome != null) {
        return false;
      }
    } else if (!secondaryMonthlyBsaseGrossIncome.equals(other.secondaryMonthlyBsaseGrossIncome)) {
      return false;
    }

    if (secondaryMonthlyBsaseNetIncome == null) {
      if (other.secondaryMonthlyBsaseNetIncome != null) {
        return false;
      }
    } else if (!secondaryMonthlyBsaseNetIncome.equals(other.secondaryMonthlyBsaseNetIncome)) {
      return false;
    }

    if (secondaryMonthlyCommission == null) {
      if (other.secondaryMonthlyCommission != null) {
        return false;
      }
    } else if (!secondaryMonthlyCommission.equals(other.secondaryMonthlyCommission)) {
      return false;
    }

    if (secondaryMonthlyDividentInterest == null) {
      if (other.secondaryMonthlyDividentInterest != null) {
        return false;
      }
    } else if (!secondaryMonthlyDividentInterest.equals(other.secondaryMonthlyDividentInterest)) {
      return false;
    }

    if (secondaryMonthlyNetRentalIncome == null) {
      if (other.secondaryMonthlyNetRentalIncome != null) {
        return false;
      }
    } else if (!secondaryMonthlyNetRentalIncome.equals(other.secondaryMonthlyNetRentalIncome)) {
      return false;
    }

    if (secondaryMonthlyOverTimeIncome == null) {
      if (other.secondaryMonthlyOverTimeIncome != null) {
        return false;
      }
    } else if (!secondaryMonthlyOverTimeIncome.equals(other.secondaryMonthlyOverTimeIncome)) {
      return false;
    }

    if (secondaryWorkPhone == null) {
      if (other.secondaryWorkPhone != null) {
        return false;
      }
    } else if (!secondaryWorkPhone.equals(other.secondaryWorkPhone)) {
      return false;
    }

    if (studentLoanMonthlyPayment == null) {
      if (other.studentLoanMonthlyPayment != null) {
        return false;
      }
    } else if (!studentLoanMonthlyPayment.equals(other.studentLoanMonthlyPayment)) {
      return false;
    }

    if (studentLoanPaymentStatus == null) {
      if (other.studentLoanPaymentStatus != null) {
        return false;
      }
    } else if (!studentLoanPaymentStatus.equals(other.studentLoanPaymentStatus)) {
      return false;
    }

    if (studentLoanRemainingBalance == null) {
      if (other.studentLoanRemainingBalance != null) {
        return false;
      }
    } else if (!studentLoanRemainingBalance.equals(other.studentLoanRemainingBalance)) {
      return false;
    }

    if (taxPaymentStatus == null) {
      if (other.taxPaymentStatus != null) {
        return false;
      }
    } else if (!taxPaymentStatus.equals(other.taxPaymentStatus)) {
      return false;
    }

    if (taxRemainingBalance == null) {
      if (other.taxRemainingBalance != null) {
        return false;
      }
    } else if (!taxRemainingBalance.equals(other.taxRemainingBalance)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Account.
   *
   * @return  Account.
   *
   *          <p>column = "accountNum" class = "com.cmc.credagility.Account" insert = "true" update = "false" cascade =
   *          "save-update"</p>
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "50</p>
   */
  public String getAssociationFeePaymentStatus() {
    return associationFeePaymentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getAssociationFeeRemainingBalance() {
    return associationFeeRemainingBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getAutoMonthlyPayment() {
    return autoMonthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "50</p>
   */
  public String getAutoPaymentStatus() {
    return autoPaymentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getAutoRemainingBalance() {
    return autoRemainingBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Boolean.
   *
   * @return  Boolean.
   *
   *          <p>type = "yes_no"</p>
   */
  public Boolean getContinueToOwn() {
    return continueToOwn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getCreditCardMonthlyPayment() {
    return creditCardMonthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "50</p>
   */
  public String getCreditCardPaymentStatus() {
    return creditCardPaymentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getCreditCardRemainingBalance() {
    return creditCardRemainingBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getCurrentValue() {
    return currentValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "20</p>
   */
  public String getFirstMortgageAccountNumber() {
    return firstMortgageAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "64</p>
   */
  public String getFirstMortgageLenderName() {
    return firstMortgageLenderName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getFirstMortgageMonthlyPayment() {
    return firstMortgageMonthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "50</p>
   */
  public String getFirstMortgagePaymentStatus() {
    return firstMortgagePaymentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getFirstMortgageRemainingBalance() {
    return firstMortgageRemainingBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "50</p>
   */
  public String getInsurancePaymentStatus() {
    return insurancePaymentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getInsuranceRemainingBalance() {
    return insuranceRemainingBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getMonthlyAssociationFee() {
    return monthlyAssociationFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getMonthlyInsurance() {
    return monthlyInsurance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getMonthlyTax() {
    return monthlyTax;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "16</p>
   */
  public String getMortgageCount() {
    return mortgageCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "20</p>
   */
  public String getOccupancyType() {
    return occupancyType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Boolean.
   *
   * @return  Boolean.
   *
   *          <p>type = "yes_no"</p>
   */
  public Boolean getOnSale() {
    return onSale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Boolean.
   *
   * @return  Boolean.
   *
   *          <p>type = "yes_no"</p>
   */
  public Boolean getOnSaleForSixMonth() {
    return onSaleForSixMonth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getOtherMortgageMonthlyPayment() {
    return otherMortgageMonthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "50</p>
   */
  public String getOtherMortgagePaymentStatus() {
    return otherMortgagePaymentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getOtherMortgageRemainingBalance() {
    return otherMortgageRemainingBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getPersonalLoanMonthlyPayment() {
    return personalLoanMonthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "50</p>
   */
  public String getPersonalLoanPaymentStatus() {
    return personalLoanPaymentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getPersonalLoanRemainingBalance() {
    return personalLoanRemainingBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "16</p>
   */
  public String getPrimaryCellPhone() {
    return primaryCellPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "20</p>
   */
  public String getPrimaryContactMethod() {
    return primaryContactMethod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "16</p>
   */
  public String getPrimaryContactTime() {
    return primaryContactTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "80</p>
   */
  public String getPrimaryEmailAddress() {
    return primaryEmailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // npelleti 08/02 Added get/set methods for PrimaryHome. START
  /**
   * getter method for primary home.
   *
   * @return  String
   */
  public String getPrimaryHome() {
    return primaryHome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "16</p>
   */
  public String getPrimaryHomePhone() {
    return primaryHomePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getPrimaryMonthlyBonus() {
    return primaryMonthlyBonus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getPrimaryMonthlyBsaseGrossIncome() {
    return primaryMonthlyBsaseGrossIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getPrimaryMonthlyBsaseNetIncome() {
    return primaryMonthlyBsaseNetIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getPrimaryMonthlyCommission() {
    return primaryMonthlyCommission;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getPrimaryMonthlyDividentInterest() {
    return primaryMonthlyDividentInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getPrimaryMonthlyNetRentalIncome() {
    return primaryMonthlyNetRentalIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getPrimaryMonthlyOverTimeIncome() {
    return primaryMonthlyOverTimeIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "16</p>
   */
  public String getPrimaryWorkPhone() {
    return primaryWorkPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The responsible.
   *
   * @return  the responsible
   *
   *          <p>column = "responsibleId" class = "com.cmc.credagility.Responsible" insert = "true" update = "false"
   *          cascade = "none"</p>
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "16</p>
   */
  public String getSecondaryCellPhone() {
    return secondaryCellPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "20</p>
   */
  public String getSecondaryContactMethod() {
    return secondaryContactMethod;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "16</p>
   */
  public String getSecondaryContactTime() {
    return secondaryContactTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "80</p>
   */
  public String getSecondaryEmailAddress() {
    return secondaryEmailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "16</p>
   */
  public String getSecondaryHomePhone() {
    return secondaryHomePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getSecondaryMonthlyBonus() {
    return secondaryMonthlyBonus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getSecondaryMonthlyBsaseGrossIncome() {
    return secondaryMonthlyBsaseGrossIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getSecondaryMonthlyBsaseNetIncome() {
    return secondaryMonthlyBsaseNetIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getSecondaryMonthlyCommission() {
    return secondaryMonthlyCommission;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getSecondaryMonthlyDividentInterest() {
    return secondaryMonthlyDividentInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getSecondaryMonthlyNetRentalIncome() {
    return secondaryMonthlyNetRentalIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getSecondaryMonthlyOverTimeIncome() {
    return secondaryMonthlyOverTimeIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "16</p>
   */
  public String getSecondaryWorkPhone() {
    return secondaryWorkPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "20</p>
   */
  public String getSecondMortgageAccountNumber() {
    return secondMortgageAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "64</p>
   */
  public String getSecondMortgageLenderName() {
    return secondMortgageLenderName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getSecondMortgageMonthlyPayment() {
    return secondMortgageMonthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "50</p>
   */
  public String getSecondMortgagePaymentStatus() {
    return secondMortgagePaymentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getSecondMortgageRemainingBalance() {
    return secondMortgageRemainingBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getStudentLoanMonthlyPayment() {
    return studentLoanMonthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "50</p>
   */
  public String getStudentLoanPaymentStatus() {
    return studentLoanPaymentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getStudentLoanRemainingBalance() {
    return studentLoanRemainingBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey activities.
   *
   * @return  List
   */
  public List<CTMSurveyActivity> getSurveyActivities() {
    List<CTMSurveyActivity> activities = new ArrayList<CTMSurveyActivity>();
    CTMSurveyActivity       activity   = new CTMSurveyActivity();
    activity.populateBasicInfo(this);

    // Primary Work Phone:
    activity.setQuestionId(60001L);
    activity.setData1(FormatUtil.stringNullFormat(getPrimaryWorkPhone()));
    activities.add(activity);

    // Primary Cell Phone:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60002L);
    activity.setData1(FormatUtil.stringNullFormat(this.getPrimaryCellPhone()));
    activities.add(activity);

    // Primary Home Phone:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60061L);
    activity.setData1(FormatUtil.stringNullFormat(this.getPrimaryHomePhone()));
    activities.add(activity);

    // Primary Email Address:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60062L);
    activity.setData1(FormatUtil.stringNullFormat(this.getPrimaryEmailAddress()));
    activities.add(activity);

    // Primary Contact Method:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60003L);
    activity.setData1(FormatUtil.stringNullFormat(this.getPrimaryContactMethod()));
    activities.add(activity);

    // Primary Contact Time:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60004L);
    activity.setData1(FormatUtil.stringNullFormat(this.getPrimaryContactTime()));
    activities.add(activity);

    // Primary Monthly Base Net Income:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60005L);
    activity.setData1(FormatUtil.currencyFormat(this.getPrimaryMonthlyBsaseNetIncome()));
    activities.add(activity);

    // Primary Monthly Base Gross Income:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60006L);
    activity.setData1(FormatUtil.currencyFormat(this.getPrimaryMonthlyBsaseGrossIncome()));
    activities.add(activity);

    // Primary Monthly Over Time Income:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60007L);
    activity.setData1(FormatUtil.currencyFormat(this.getPrimaryMonthlyOverTimeIncome()));
    activities.add(activity);

    // Primary Monthly Bonus Income:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60008L);
    activity.setData1(FormatUtil.currencyFormat(this.getPrimaryMonthlyBonus()));
    activities.add(activity);

    // Primary Monthly Commission Income:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60009L);
    activity.setData1(FormatUtil.currencyFormat(this.getPrimaryMonthlyCommission()));
    activities.add(activity);

    // Primary Monthly Divident Interest Income:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60010L);
    activity.setData1(FormatUtil.currencyFormat(this.getPrimaryMonthlyDividentInterest()));
    activities.add(activity);

    // Primary Monthly Net Rental Income:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60011L);
    activity.setData1(FormatUtil.currencyFormat(this.getPrimaryMonthlyNetRentalIncome()));
    activities.add(activity);

    // Secondary Work Phone:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60012L);
    activity.setData1(FormatUtil.stringNullFormat(this.getSecondaryWorkPhone()));
    activities.add(activity);

    // Secondary Cell Phone:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60013L);
    activity.setData1(FormatUtil.stringNullFormat(this.getSecondaryCellPhone()));
    activities.add(activity);

    // Secondary Home Phone:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60063L);
    activity.setData1(FormatUtil.stringNullFormat(this.getSecondaryHomePhone()));
    activities.add(activity);

    // Secondary Email Address:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60064L);
    activity.setData1(FormatUtil.stringNullFormat(this.getSecondaryEmailAddress()));
    activities.add(activity);

    // Secondary Contact Method:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60014L);
    activity.setData1(FormatUtil.stringNullFormat(this.getSecondaryContactMethod()));
    activities.add(activity);

    // Secondary Contact Time:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60015L);
    activity.setData1(FormatUtil.stringNullFormat(this.getSecondaryContactTime()));
    activities.add(activity);

    // Secondary Monthly Base Net Income:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60016L);
    activity.setData1(FormatUtil.currencyFormat(this.getSecondaryMonthlyBsaseNetIncome()));
    activities.add(activity);

    // Secondary Monthly Base Gross Income:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60017L);
    activity.setData1(FormatUtil.currencyFormat(this.getSecondaryMonthlyBsaseGrossIncome()));
    activities.add(activity);

    // Secondary Monthly Over Time Income:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60018L);
    activity.setData1(FormatUtil.currencyFormat(this.getSecondaryMonthlyOverTimeIncome()));
    activities.add(activity);

    // Secondary Monthly Bonus Income:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60019L);
    activity.setData1(FormatUtil.currencyFormat(this.getSecondaryMonthlyBonus()));
    activities.add(activity);

    // Secondary Monthly Commission Income:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60020L);
    activity.setData1(FormatUtil.currencyFormat(this.getSecondaryMonthlyCommission()));
    activities.add(activity);

    // Secondary Monthly Divident Interest Income:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60021L);
    activity.setData1(FormatUtil.currencyFormat(this.getSecondaryMonthlyDividentInterest()));
    activities.add(activity);

    // Secondary Monthly Net Rental Income:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60022L);
    activity.setData1(FormatUtil.currencyFormat(this.getSecondaryMonthlyNetRentalIncome()));
    activities.add(activity);

    // Is Primary Home?
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60023L);
    activity.setData1(FormatUtil.stringNullFormat(this.getOccupancyType()));
    activities.add(activity);

    // Is Currently On Sale?
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60024L);
    activity.setData1((this.getOnSale() == null) ? "N/A" : this.getOnSale().toString());
    activities.add(activity);

    // Is Currently On Sale for Six Months?
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60025L);
    activity.setData1((this.getOnSaleForSixMonth() == null) ? "N/A" : this.getOnSale().toString());
    activities.add(activity);

    // Continue to Own Property?
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60026L);
    activity.setData1((this.getContinueToOwn() == null) ? "N/A" : this.getOnSale().toString());
    activities.add(activity);

    // Current Home Value:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60027L);
    activity.setData1(FormatUtil.currencyFormat(this.getCurrentValue()));
    activities.add(activity);

    // Mortgage with Citi:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60028L);
    activity.setData1(FormatUtil.stringNullFormat(this.getMortgageCount()));
    activities.add(activity);

    // First Mortgage Lender Name:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60029L);
    activity.setData1(FormatUtil.stringNullFormat(this.getFirstMortgageLenderName()));
    activities.add(activity);

    // First Mortgage Account #:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60030L);
    activity.setData1(FormatUtil.stringNullFormat(this.getFirstMortgageAccountNumber()));
    activities.add(activity);

    // First Mortgage Monthly Payment:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60031L);
    activity.setData1(FormatUtil.currencyFormat(this.getFirstMortgageMonthlyPayment()));
    activities.add(activity);

    // First Mortgage Remaining Balance:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60032L);
    activity.setData1(FormatUtil.currencyFormat(this.getFirstMortgageRemainingBalance()));
    activities.add(activity);

    // First Mortgage Payment Status:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60033L);
    activity.setData1(FormatUtil.stringNullFormat(this.getFirstMortgagePaymentStatus()));
    activities.add(activity);

    // Monthly Tax:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60034L);
    activity.setData1(FormatUtil.currencyFormat(this.getMonthlyTax()));
    activities.add(activity);

    // Tax Remaining Balance:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60035L);
    activity.setData1(FormatUtil.currencyFormat(this.getTaxRemainingBalance()));
    activities.add(activity);

    // Tax Payment Status:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60036L);
    activity.setData1(FormatUtil.stringNullFormat(this.getTaxPaymentStatus()));
    activities.add(activity);

    // Monthly Insurance:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60037L);
    activity.setData1(FormatUtil.currencyFormat(this.getMonthlyInsurance()));
    activities.add(activity);

    // Insurance Remaining Balance:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60038L);
    activity.setData1(FormatUtil.currencyFormat(this.getInsuranceRemainingBalance()));
    activities.add(activity);

    // Insurance Payment Status:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60039L);
    activity.setData1(FormatUtil.stringNullFormat(this.getInsurancePaymentStatus()));
    activities.add(activity);

    // Monthly AssociationFee:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60040L);
    activity.setData1(FormatUtil.currencyFormat(this.getMonthlyAssociationFee()));
    activities.add(activity);

    // AssociationFee Remaining Balance:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60041L);
    activity.setData1(FormatUtil.currencyFormat(this.getAssociationFeeRemainingBalance()));
    activities.add(activity);

    // AssociationFee Payment Status:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60042L);
    activity.setData1(FormatUtil.stringNullFormat(this.getAssociationFeePaymentStatus()));
    activities.add(activity);

    // Second Mortgage Monthly Payment:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60043L);
    activity.setData1(FormatUtil.currencyFormat(this.getSecondMortgageMonthlyPayment()));
    activities.add(activity);

    // Second Mortgage Remaining Balance:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60044L);
    activity.setData1(FormatUtil.currencyFormat(this.getSecondMortgageRemainingBalance()));
    activities.add(activity);

    // Second Mortgage Payment Status:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60045L);
    activity.setData1(FormatUtil.stringNullFormat(this.getSecondMortgagePaymentStatus()));
    activities.add(activity);

    // Other Mortgage Payment Status:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60046L);
    activity.setData1(FormatUtil.currencyFormat(this.getOtherMortgageMonthlyPayment()));
    activities.add(activity);

    // Other Mortgage Remaining Balance:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60047L);
    activity.setData1(FormatUtil.currencyFormat(this.getOtherMortgageRemainingBalance()));
    activities.add(activity);

    // Other Mortgage Payment Status:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60048L);
    activity.setData1(FormatUtil.stringNullFormat(this.getOtherMortgagePaymentStatus()));
    activities.add(activity);

    // Auto Loan Monthly Payment:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60049L);
    activity.setData1(FormatUtil.currencyFormat(this.getAutoMonthlyPayment()));
    activities.add(activity);

    // Auto Loan Remaining Balance:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60050L);
    activity.setData1(FormatUtil.currencyFormat(this.getAutoRemainingBalance()));
    activities.add(activity);

    // Auto Loan Payment Status:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60051L);
    activity.setData1(FormatUtil.stringNullFormat(this.getAutoPaymentStatus()));
    activities.add(activity);

    // Personal Loan Monthly Payment:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60052L);
    activity.setData1(FormatUtil.currencyFormat(this.getPersonalLoanMonthlyPayment()));
    activities.add(activity);

    // Personal Loan Remaining Balance:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60053L);
    activity.setData1(FormatUtil.currencyFormat(this.getPersonalLoanRemainingBalance()));
    activities.add(activity);

    // Personal Loan Payment Status:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60054L);
    activity.setData1(FormatUtil.stringNullFormat(this.getPersonalLoanPaymentStatus()));
    activities.add(activity);

    // Student Loan Monthly Payment:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60055L);
    activity.setData1(FormatUtil.currencyFormat(this.getStudentLoanMonthlyPayment()));
    activities.add(activity);

    // Student Loan Remaining Balance:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60056L);
    activity.setData1(FormatUtil.currencyFormat(this.getStudentLoanRemainingBalance()));
    activities.add(activity);

    // Student Loan Payment Status:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60057L);
    activity.setData1(FormatUtil.stringNullFormat(this.getStudentLoanPaymentStatus()));
    activities.add(activity);

    // Credit Card Loan Payment Status:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60058L);
    activity.setData1(FormatUtil.currencyFormat(this.getCreditCardMonthlyPayment()));
    activities.add(activity);

    // Credit Card Loan Remaining Balance:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60059L);
    activity.setData1(FormatUtil.currencyFormat(this.getCreditCardRemainingBalance()));
    activities.add(activity);

    // Credit Card Loan Payment Status:
    activity = new CTMSurveyActivity();
    activity.populateBasicInfo(this);
    activity.setQuestionId(60060L);
    activity.setData1(this.getCreditCardPaymentStatus());
    activities.add(activity);

    return activities;
  } // end method getSurveyActivities

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>length = "50</p>
   */
  public String getTaxPaymentStatus() {
    return taxPaymentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getTaxRemainingBalance() {
    return taxRemainingBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = prime
      + ((associationFeePaymentStatus == null) ? 0 : associationFeePaymentStatus.hashCode());
    result = (prime
        * result)
      + ((associationFeeRemainingBalance == null) ? 0 : associationFeeRemainingBalance.hashCode());
    result = (prime * result)
      + ((autoMonthlyPayment == null) ? 0 : autoMonthlyPayment.hashCode());
    result = (prime * result)
      + ((autoPaymentStatus == null) ? 0 : autoPaymentStatus.hashCode());
    result = (prime
        * result)
      + ((autoRemainingBalance == null) ? 0 : autoRemainingBalance.hashCode());
    result = (prime * result)
      + ((continueToOwn == null) ? 0 : continueToOwn.hashCode());
    result = (prime
        * result)
      + ((creditCardMonthlyPayment == null) ? 0 : creditCardMonthlyPayment.hashCode());
    result = (prime
        * result)
      + ((creditCardPaymentStatus == null) ? 0 : creditCardPaymentStatus.hashCode());
    result = (prime
        * result)
      + ((creditCardRemainingBalance == null) ? 0 : creditCardRemainingBalance.hashCode());
    result = (prime * result)
      + ((currentValue == null) ? 0 : currentValue.hashCode());
    result = (prime
        * result)
      + ((firstMortgageAccountNumber == null) ? 0 : firstMortgageAccountNumber.hashCode());
    result = (prime
        * result)
      + ((firstMortgageLenderName == null) ? 0 : firstMortgageLenderName.hashCode());
    result = (prime
        * result)
      + ((firstMortgageMonthlyPayment == null) ? 0 : firstMortgageMonthlyPayment.hashCode());
    result = (prime
        * result)
      + ((firstMortgagePaymentStatus == null) ? 0 : firstMortgagePaymentStatus.hashCode());
    result = (prime
        * result)
      + ((firstMortgageRemainingBalance == null) ? 0 : firstMortgageRemainingBalance.hashCode());
    result = (prime
        * result)
      + ((insurancePaymentStatus == null) ? 0 : insurancePaymentStatus.hashCode());
    result = (prime
        * result)
      + ((insuranceRemainingBalance == null) ? 0 : insuranceRemainingBalance.hashCode());
    result = (prime
        * result)
      + ((monthlyAssociationFee == null) ? 0 : monthlyAssociationFee.hashCode());
    result = (prime * result)
      + ((monthlyInsurance == null) ? 0 : monthlyInsurance.hashCode());
    result = (prime * result)
      + ((monthlyTax == null) ? 0 : monthlyTax.hashCode());
    result = (prime * result)
      + ((mortgageCount == null) ? 0 : mortgageCount.hashCode());
    result = (prime * result)
      + ((occupancyType == null) ? 0 : occupancyType.hashCode());
    result = (prime * result) + ((onSale == null) ? 0 : onSale.hashCode());
    result = (prime * result)
      + ((onSaleForSixMonth == null) ? 0 : onSaleForSixMonth.hashCode());
    result = (prime
        * result)
      + ((otherMortgageMonthlyPayment == null) ? 0 : otherMortgageMonthlyPayment.hashCode());
    result = (prime
        * result)
      + ((otherMortgagePaymentStatus == null) ? 0 : otherMortgagePaymentStatus.hashCode());
    result = (prime
        * result)
      + ((otherMortgageRemainingBalance == null) ? 0 : otherMortgageRemainingBalance.hashCode());
    result = (prime
        * result)
      + ((personalLoanMonthlyPayment == null) ? 0 : personalLoanMonthlyPayment.hashCode());
    result = (prime
        * result)
      + ((personalLoanPaymentStatus == null) ? 0 : personalLoanPaymentStatus.hashCode());
    result = (prime
        * result)
      + ((personalLoanRemainingBalance == null) ? 0 : personalLoanRemainingBalance.hashCode());
    result = (prime * result)
      + ((primaryCellPhone == null) ? 0 : primaryCellPhone.hashCode());
    result = (prime
        * result)
      + ((primaryContactMethod == null) ? 0 : primaryContactMethod.hashCode());
    result = (prime * result)
      + ((primaryContactTime == null) ? 0 : primaryContactTime.hashCode());
    result = (prime * result)
      + ((primaryEmailAddress == null) ? 0 : primaryEmailAddress.hashCode());
    result = (prime * result)
      + ((primaryHomePhone == null) ? 0 : primaryHomePhone.hashCode());
    result = (prime * result)
      + ((primaryMonthlyBonus == null) ? 0 : primaryMonthlyBonus.hashCode());
    result = (prime
        * result)
      + ((primaryMonthlyBsaseGrossIncome == null) ? 0 : primaryMonthlyBsaseGrossIncome.hashCode());
    result = (prime
        * result)
      + ((primaryMonthlyBsaseNetIncome == null) ? 0 : primaryMonthlyBsaseNetIncome.hashCode());
    result = (prime
        * result)
      + ((primaryMonthlyCommission == null) ? 0 : primaryMonthlyCommission.hashCode());
    result = (prime
        * result)
      + ((primaryMonthlyDividentInterest == null) ? 0 : primaryMonthlyDividentInterest.hashCode());
    result = (prime
        * result)
      + ((primaryMonthlyNetRentalIncome == null) ? 0 : primaryMonthlyNetRentalIncome.hashCode());
    result = (prime
        * result)
      + ((primaryMonthlyOverTimeIncome == null) ? 0 : primaryMonthlyOverTimeIncome.hashCode());
    result = (prime * result)
      + ((primaryWorkPhone == null) ? 0 : primaryWorkPhone.hashCode());
    result = (prime
        * result)
      + ((secondMortgageAccountNumber == null) ? 0 : secondMortgageAccountNumber.hashCode());
    result = (prime
        * result)
      + ((secondMortgageLenderName == null) ? 0 : secondMortgageLenderName.hashCode());
    result = (prime
        * result)
      + ((secondMortgageMonthlyPayment == null) ? 0 : secondMortgageMonthlyPayment.hashCode());
    result = (prime
        * result)
      + ((secondMortgagePaymentStatus == null) ? 0 : secondMortgagePaymentStatus.hashCode());
    result = (prime
        * result)
      + ((secondMortgageRemainingBalance == null) ? 0 : secondMortgageRemainingBalance.hashCode());
    result = (prime * result)
      + ((secondaryCellPhone == null) ? 0 : secondaryCellPhone.hashCode());
    result = (prime
        * result)
      + ((secondaryContactMethod == null) ? 0 : secondaryContactMethod.hashCode());
    result = (prime
        * result)
      + ((secondaryContactTime == null) ? 0 : secondaryContactTime.hashCode());
    result = (prime
        * result)
      + ((secondaryEmailAddress == null) ? 0 : secondaryEmailAddress.hashCode());
    result = (prime * result)
      + ((secondaryHomePhone == null) ? 0 : secondaryHomePhone.hashCode());
    result = (prime
        * result)
      + ((secondaryMonthlyBonus == null) ? 0 : secondaryMonthlyBonus.hashCode());
    result = (prime
        * result)
      + ((secondaryMonthlyBsaseGrossIncome == null) ? 0 : secondaryMonthlyBsaseGrossIncome.hashCode());
    result = (prime
        * result)
      + ((secondaryMonthlyBsaseNetIncome == null) ? 0 : secondaryMonthlyBsaseNetIncome.hashCode());
    result = (prime
        * result)
      + ((secondaryMonthlyCommission == null) ? 0 : secondaryMonthlyCommission.hashCode());
    result = (prime
        * result)
      + ((secondaryMonthlyDividentInterest == null) ? 0 : secondaryMonthlyDividentInterest.hashCode());
    result = (prime
        * result)
      + ((secondaryMonthlyNetRentalIncome == null) ? 0 : secondaryMonthlyNetRentalIncome.hashCode());
    result = (prime
        * result)
      + ((secondaryMonthlyOverTimeIncome == null) ? 0 : secondaryMonthlyOverTimeIncome.hashCode());
    result = (prime * result)
      + ((secondaryWorkPhone == null) ? 0 : secondaryWorkPhone.hashCode());
    result = (prime
        * result)
      + ((studentLoanMonthlyPayment == null) ? 0 : studentLoanMonthlyPayment.hashCode());
    result = (prime
        * result)
      + ((studentLoanPaymentStatus == null) ? 0 : studentLoanPaymentStatus.hashCode());
    result = (prime
        * result)
      + ((studentLoanRemainingBalance == null) ? 0 : studentLoanRemainingBalance.hashCode());
    result = (prime * result)
      + ((taxPaymentStatus == null) ? 0 : taxPaymentStatus.hashCode());
    result = (prime * result)
      + ((taxRemainingBalance == null) ? 0 : taxRemainingBalance.hashCode());

    return result;
  } // end method hashCode

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
   * setter method for association fee payment status.
   *
   * @param  associationFeePaymentStatus  String
   */
  public void setAssociationFeePaymentStatus(String associationFeePaymentStatus) {
    this.associationFeePaymentStatus = FormatUtil.nullSafeSubstring(
        associationFeePaymentStatus, 50);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for association fee remaining balance.
   *
   * @param  associationFeeRemainingBalance  BigDecimal
   */
  public void setAssociationFeeRemainingBalance(
    BigDecimal associationFeeRemainingBalance) {
    this.associationFeeRemainingBalance = associationFeeRemainingBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for auto monthly payment.
   *
   * @param  autoMonthlyPayment  BigDecimal
   */
  public void setAutoMonthlyPayment(BigDecimal autoMonthlyPayment) {
    this.autoMonthlyPayment = autoMonthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for auto payment status.
   *
   * @param  autoPaymentStatus  String
   */
  public void setAutoPaymentStatus(String autoPaymentStatus) {
    this.autoPaymentStatus = FormatUtil.nullSafeSubstring(autoPaymentStatus, 50);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for auto remaining balance.
   *
   * @param  autoRemainingBalance  BigDecimal
   */
  public void setAutoRemainingBalance(BigDecimal autoRemainingBalance) {
    this.autoRemainingBalance = autoRemainingBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for continue to own.
   *
   * @param  continueToOwn  Boolean
   */
  public void setContinueToOwn(Boolean continueToOwn) {
    this.continueToOwn = continueToOwn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for credit card monthly payment.
   *
   * @param  creditCardMonthlyPayment  BigDecimal
   */
  public void setCreditCardMonthlyPayment(BigDecimal creditCardMonthlyPayment) {
    this.creditCardMonthlyPayment = creditCardMonthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for credit card payment status.
   *
   * @param  creditCardPaymentStatus  String
   */
  public void setCreditCardPaymentStatus(String creditCardPaymentStatus) {
    this.creditCardPaymentStatus = FormatUtil.nullSafeSubstring(
        creditCardPaymentStatus, 50);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for credit card remaining balance.
   *
   * @param  creditCardRemainingBalance  BigDecimal
   */
  public void setCreditCardRemainingBalance(
    BigDecimal creditCardRemainingBalance) {
    this.creditCardRemainingBalance = creditCardRemainingBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current value.
   *
   * @param  currentValue  BigDecimal
   */
  public void setCurrentValue(BigDecimal currentValue) {
    this.currentValue = currentValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for first mortgage account number.
   *
   * @param  firstMortgageAccountNumber  String
   */
  public void setFirstMortgageAccountNumber(String firstMortgageAccountNumber) {
    this.firstMortgageAccountNumber = FormatUtil.nullSafeSubstring(
        firstMortgageAccountNumber, 20);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for first mortgage lender name.
   *
   * @param  firstMortgageLenderName  String
   */
  public void setFirstMortgageLenderName(String firstMortgageLenderName) {
    // Prevent it from becoming more than 64 bytes
    this.firstMortgageLenderName = FormatUtil.nullSafeSubstring(
        firstMortgageLenderName, 64);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for first mortgage monthly payment.
   *
   * @param  firstMortgageMonthlyPayment  BigDecimal
   */
  public void setFirstMortgageMonthlyPayment(
    BigDecimal firstMortgageMonthlyPayment) {
    this.firstMortgageMonthlyPayment = firstMortgageMonthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for first mortgage payment status.
   *
   * @param  firstMortgagePaymentStatus  String
   */
  public void setFirstMortgagePaymentStatus(String firstMortgagePaymentStatus) {
    this.firstMortgagePaymentStatus = FormatUtil.nullSafeSubstring(
        firstMortgagePaymentStatus, 50);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for first mortgage remaining balance.
   *
   * @param  firstMortgageRemainingBalance  BigDecimal
   */
  public void setFirstMortgageRemainingBalance(
    BigDecimal firstMortgageRemainingBalance) {
    this.firstMortgageRemainingBalance = firstMortgageRemainingBalance;
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
   * setter method for insurance payment status.
   *
   * @param  insurancePaymentStatus  String
   */
  public void setInsurancePaymentStatus(String insurancePaymentStatus) {
    this.insurancePaymentStatus = FormatUtil.nullSafeSubstring(
        insurancePaymentStatus, 50);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for insurance remaining balance.
   *
   * @param  insuranceRemainingBalance  BigDecimal
   */
  public void setInsuranceRemainingBalance(BigDecimal insuranceRemainingBalance) {
    this.insuranceRemainingBalance = insuranceRemainingBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for monthly association fee.
   *
   * @param  monthlyAssociationFee  BigDecimal
   */
  public void setMonthlyAssociationFee(BigDecimal monthlyAssociationFee) {
    this.monthlyAssociationFee = monthlyAssociationFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for monthly insurance.
   *
   * @param  monthlyInsurance  BigDecimal
   */
  public void setMonthlyInsurance(BigDecimal monthlyInsurance) {
    this.monthlyInsurance = monthlyInsurance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for monthly tax.
   *
   * @param  monthlyTax  BigDecimal
   */
  public void setMonthlyTax(BigDecimal monthlyTax) {
    this.monthlyTax = monthlyTax;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mortgage count.
   *
   * @param  mortgageCount  String
   */
  public void setMortgageCount(String mortgageCount) {
    this.mortgageCount = FormatUtil.nullSafeSubstring(mortgageCount, 16);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for occupancy type.
   *
   * @param  occupancyType  String
   */
  public void setOccupancyType(String occupancyType) {
    this.occupancyType = FormatUtil.nullSafeSubstring(occupancyType, 20);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for on sale.
   *
   * @param  onSale  Boolean
   */
  public void setOnSale(Boolean onSale) {
    this.onSale = onSale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for on sale for six month.
   *
   * @param  onSaleForSixMonth  Boolean
   */
  public void setOnSaleForSixMonth(Boolean onSaleForSixMonth) {
    this.onSaleForSixMonth = onSaleForSixMonth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other mortgage monthly payment.
   *
   * @param  otherMortgageMonthlyPayment  BigDecimal
   */
  public void setOtherMortgageMonthlyPayment(
    BigDecimal otherMortgageMonthlyPayment) {
    this.otherMortgageMonthlyPayment = otherMortgageMonthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other mortgage payment status.
   *
   * @param  otherMortgagePaymentStatus  String
   */
  public void setOtherMortgagePaymentStatus(String otherMortgagePaymentStatus) {
    this.otherMortgagePaymentStatus = FormatUtil.nullSafeSubstring(
        otherMortgagePaymentStatus, 50);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other mortgage remaining balance.
   *
   * @param  otherMortgageRemainingBalance  BigDecimal
   */
  public void setOtherMortgageRemainingBalance(
    BigDecimal otherMortgageRemainingBalance) {
    this.otherMortgageRemainingBalance = otherMortgageRemainingBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for personal loan monthly payment.
   *
   * @param  personalLoanMonthlyPayment  BigDecimal
   */
  public void setPersonalLoanMonthlyPayment(
    BigDecimal personalLoanMonthlyPayment) {
    this.personalLoanMonthlyPayment = personalLoanMonthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for personal loan payment status.
   *
   * @param  personalLoanPaymentStatus  String
   */
  public void setPersonalLoanPaymentStatus(String personalLoanPaymentStatus) {
    this.personalLoanPaymentStatus = FormatUtil.nullSafeSubstring(
        personalLoanPaymentStatus, 50);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for personal loan remaining balance.
   *
   * @param  personalLoanRemainingBalance  BigDecimal
   */
  public void setPersonalLoanRemainingBalance(
    BigDecimal personalLoanRemainingBalance) {
    this.personalLoanRemainingBalance = personalLoanRemainingBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary cell phone.
   *
   * @param  primaryCellPhone  String
   */
  public void setPrimaryCellPhone(String primaryCellPhone) {
    this.primaryCellPhone = FormatUtil.nullSafeSubstring(primaryCellPhone, 16);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary contact method.
   *
   * @param  primaryContactMethod  String
   */
  public void setPrimaryContactMethod(String primaryContactMethod) {
    this.primaryContactMethod = FormatUtil.nullSafeSubstring(
        primaryContactMethod, 20);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary contact time.
   *
   * @param  primaryContactTime  String
   */
  public void setPrimaryContactTime(String primaryContactTime) {
    this.primaryContactTime = FormatUtil.nullSafeSubstring(primaryContactTime,
        16);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary email address.
   *
   * @param  primaryEmailAddress  String
   */
  public void setPrimaryEmailAddress(String primaryEmailAddress) {
    this.primaryEmailAddress = FormatUtil.nullSafeSubstring(
        primaryEmailAddress, 80);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary home.
   *
   * @param  primaryHome  String
   */
  public void setPrimaryHome(String primaryHome) {
    this.primaryHome = primaryHome;
  }
// npelleti 08/02 Added get/set methods for PrimaryHome. END

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary home phone.
   *
   * @param  primaryHomePhone  String
   */
  public void setPrimaryHomePhone(String primaryHomePhone) {
    this.primaryHomePhone = FormatUtil.nullSafeSubstring(primaryHomePhone, 16);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary monthly bonus.
   *
   * @param  primaryMonthlyBonus  BigDecimal
   */
  public void setPrimaryMonthlyBonus(BigDecimal primaryMonthlyBonus) {
    this.primaryMonthlyBonus = primaryMonthlyBonus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary monthly bsase gross income.
   *
   * @param  primaryMonthlyBsaseGrossIncome  BigDecimal
   */
  public void setPrimaryMonthlyBsaseGrossIncome(
    BigDecimal primaryMonthlyBsaseGrossIncome) {
    this.primaryMonthlyBsaseGrossIncome = primaryMonthlyBsaseGrossIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary monthly bsase net income.
   *
   * @param  primaryMonthlyBsaseNetIncome  BigDecimal
   */
  public void setPrimaryMonthlyBsaseNetIncome(
    BigDecimal primaryMonthlyBsaseNetIncome) {
    this.primaryMonthlyBsaseNetIncome = primaryMonthlyBsaseNetIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary monthly commission.
   *
   * @param  primaryMonthlyCommission  BigDecimal
   */
  public void setPrimaryMonthlyCommission(BigDecimal primaryMonthlyCommission) {
    this.primaryMonthlyCommission = primaryMonthlyCommission;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary monthly divident interest.
   *
   * @param  primaryMonthlyDividentInterest  BigDecimal
   */
  public void setPrimaryMonthlyDividentInterest(
    BigDecimal primaryMonthlyDividentInterest) {
    this.primaryMonthlyDividentInterest = primaryMonthlyDividentInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary monthly net rental income.
   *
   * @param  primaryMonthlyNetRentalIncome  BigDecimal
   */
  public void setPrimaryMonthlyNetRentalIncome(
    BigDecimal primaryMonthlyNetRentalIncome) {
    this.primaryMonthlyNetRentalIncome = primaryMonthlyNetRentalIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary monthly over time income.
   *
   * @param  primaryMonthlyOverTimeIncome  BigDecimal
   */
  public void setPrimaryMonthlyOverTimeIncome(
    BigDecimal primaryMonthlyOverTimeIncome) {
    this.primaryMonthlyOverTimeIncome = primaryMonthlyOverTimeIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for primary work phone.
   *
   * @param  primaryWorkPhone  String
   */
  public void setPrimaryWorkPhone(String primaryWorkPhone) {
    this.primaryWorkPhone = FormatUtil.nullSafeSubstring(primaryWorkPhone, 16);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for secondary cell phone.
   *
   * @param  secondaryCellPhone  String
   */
  public void setSecondaryCellPhone(String secondaryCellPhone) {
    this.secondaryCellPhone = FormatUtil.nullSafeSubstring(secondaryCellPhone,
        16);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for secondary contact method.
   *
   * @param  secondaryContactMethod  String
   */
  public void setSecondaryContactMethod(String secondaryContactMethod) {
    this.secondaryContactMethod = FormatUtil.nullSafeSubstring(
        secondaryContactMethod, 20);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for secondary contact time.
   *
   * @param  secondaryContactTime  String
   */
  public void setSecondaryContactTime(String secondaryContactTime) {
    this.secondaryContactTime = FormatUtil.nullSafeSubstring(
        secondaryContactTime, 16);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for secondary email address.
   *
   * @param  secondaryEmailAddress  String
   */
  public void setSecondaryEmailAddress(String secondaryEmailAddress) {
    this.secondaryEmailAddress = FormatUtil.nullSafeSubstring(
        secondaryEmailAddress, 80);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for secondary home phone.
   *
   * @param  secondaryHomePhone  String
   */
  public void setSecondaryHomePhone(String secondaryHomePhone) {
    this.secondaryHomePhone = FormatUtil.nullSafeSubstring(secondaryHomePhone,
        16);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for secondary monthly bonus.
   *
   * @param  secondaryMonthlyBonus  BigDecimal
   */
  public void setSecondaryMonthlyBonus(BigDecimal secondaryMonthlyBonus) {
    this.secondaryMonthlyBonus = secondaryMonthlyBonus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for secondary monthly bsase gross income.
   *
   * @param  secondaryMonthlyBsaseGrossIncome  BigDecimal
   */
  public void setSecondaryMonthlyBsaseGrossIncome(
    BigDecimal secondaryMonthlyBsaseGrossIncome) {
    this.secondaryMonthlyBsaseGrossIncome = secondaryMonthlyBsaseGrossIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for secondary monthly bsase net income.
   *
   * @param  secondaryMonthlyBsaseNetIncome  BigDecimal
   */
  public void setSecondaryMonthlyBsaseNetIncome(
    BigDecimal secondaryMonthlyBsaseNetIncome) {
    this.secondaryMonthlyBsaseNetIncome = secondaryMonthlyBsaseNetIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for secondary monthly commission.
   *
   * @param  secondaryMonthlyCommission  BigDecimal
   */
  public void setSecondaryMonthlyCommission(
    BigDecimal secondaryMonthlyCommission) {
    this.secondaryMonthlyCommission = secondaryMonthlyCommission;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for secondary monthly divident interest.
   *
   * @param  secondaryMonthlyDividentInterest  BigDecimal
   */
  public void setSecondaryMonthlyDividentInterest(
    BigDecimal secondaryMonthlyDividentInterest) {
    this.secondaryMonthlyDividentInterest = secondaryMonthlyDividentInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for secondary monthly net rental income.
   *
   * @param  secondaryMonthlyNetRentalIncome  BigDecimal
   */
  public void setSecondaryMonthlyNetRentalIncome(
    BigDecimal secondaryMonthlyNetRentalIncome) {
    this.secondaryMonthlyNetRentalIncome = secondaryMonthlyNetRentalIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for secondary monthly over time income.
   *
   * @param  secondaryMonthlyOverTimeIncome  BigDecimal
   */
  public void setSecondaryMonthlyOverTimeIncome(
    BigDecimal secondaryMonthlyOverTimeIncome) {
    this.secondaryMonthlyOverTimeIncome = secondaryMonthlyOverTimeIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for secondary work phone.
   *
   * @param  secondaryWorkPhone  String
   */
  public void setSecondaryWorkPhone(String secondaryWorkPhone) {
    this.secondaryWorkPhone = FormatUtil.nullSafeSubstring(secondaryWorkPhone,
        16);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for second mortgage account number.
   *
   * @param  secondMortgageAccountNumber  String
   */
  public void setSecondMortgageAccountNumber(String secondMortgageAccountNumber) {
    this.secondMortgageAccountNumber = FormatUtil.nullSafeSubstring(
        secondMortgageAccountNumber, 20);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for second mortgage lender name.
   *
   * @param  secondMortgageLenderName  String
   */
  public void setSecondMortgageLenderName(String secondMortgageLenderName) {
    this.secondMortgageLenderName = FormatUtil.nullSafeSubstring(
        secondMortgageLenderName, 64);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for second mortgage monthly payment.
   *
   * @param  secondMortgageMonthlyPayment  BigDecimal
   */
  public void setSecondMortgageMonthlyPayment(
    BigDecimal secondMortgageMonthlyPayment) {
    this.secondMortgageMonthlyPayment = secondMortgageMonthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for second mortgage payment status.
   *
   * @param  secondMortgagePaymentStatus  String
   */
  public void setSecondMortgagePaymentStatus(String secondMortgagePaymentStatus) {
    this.secondMortgagePaymentStatus = FormatUtil.nullSafeSubstring(
        secondMortgagePaymentStatus, 50);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for second mortgage remaining balance.
   *
   * @param  secondMortgageRemainingBalance  BigDecimal
   */
  public void setSecondMortgageRemainingBalance(
    BigDecimal secondMortgageRemainingBalance) {
    this.secondMortgageRemainingBalance = secondMortgageRemainingBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for student loan monthly payment.
   *
   * @param  studentLoanMonthlyPayment  BigDecimal
   */
  public void setStudentLoanMonthlyPayment(BigDecimal studentLoanMonthlyPayment) {
    this.studentLoanMonthlyPayment = studentLoanMonthlyPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for student loan payment status.
   *
   * @param  studentLoanPaymentStatus  String
   */
  public void setStudentLoanPaymentStatus(String studentLoanPaymentStatus) {
    this.studentLoanPaymentStatus = FormatUtil.nullSafeSubstring(
        studentLoanPaymentStatus, 50);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for student loan remaining balance.
   *
   * @param  studentLoanRemainingBalance  BigDecimal
   */
  public void setStudentLoanRemainingBalance(
    BigDecimal studentLoanRemainingBalance) {
    this.studentLoanRemainingBalance = studentLoanRemainingBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tax payment status.
   *
   * @param  taxPaymentStatus  String
   */
  public void setTaxPaymentStatus(String taxPaymentStatus) {
    this.taxPaymentStatus = FormatUtil.nullSafeSubstring(taxPaymentStatus, 50);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tax remaining balance.
   *
   * @param  taxRemainingBalance  BigDecimal
   */
  public void setTaxRemainingBalance(BigDecimal taxRemainingBalance) {
    this.taxRemainingBalance = taxRemainingBalance;
  }

} // end class HomeEquityCTMSurvey
