package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   Ye Zhang
 *
 *           <p>table = "AccountMortgage"</p>
 * @version  10/16/2014 10:41
 */
@Entity
@Table(
  name    = "AccountMortgage",
  indexes = {
    @Index(
      name = "postalCodeIndex",
      columnList = "postalCode"
    )
  }
)
public class AccountMortgage extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2455202334781859161L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    insertable = true,
    updatable  = false
  )
  @OneToOne(mappedBy = "mortgage")
  private Account account;

  @Column(name = "escrowBalance")
  private BigDecimal escrowBalance;

  // , 07/29, USB, Added Annotation for column NotNull
  @Column(
    name      = "interestRate",
    nullable  = false,
    precision = 19,
    scale     = 4
  )
  private BigDecimal interestRate;

  @Column(name = "interestYearToDate")
  private BigDecimal interestYearToDate;

  // , 07/29, USB, Added Annotation for column NotNull
  @Column(
    name     = "loanDuration",
    nullable = false,
    length   = 11
  )
  private Integer loanDuration;


  @Column(
    name   = "loanNum",
    length = 20
  )
  private String loanNum;

  @Column(
    name   = "loanProvider",
    length = 100
  )
  private String loanProvider;

  /** FIXED, 5ARM, 15ARM, etc. */
  @Column(
    name   = "loanType",
    length = 10
  )
  private String loanType;


  @Column(
    name     = "mortgageId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long   mortgageId;
  @Column(name = "originalLoanAmount")
  private BigDecimal originalLoanAmount;

  @Embedded private Address propertyAddress;

  @Column(name = "taxYearToDate")
  private BigDecimal taxYearToDate;

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

    final AccountMortgage other = (AccountMortgage) obj;

    if (escrowBalance == null) {
      if (other.escrowBalance != null) {
        return false;
      }
    } else if (!escrowBalance.equals(other.escrowBalance)) {
      return false;
    }

    if (interestRate == null) {
      if (other.interestRate != null) {
        return false;
      }
    } else if (!interestRate.equals(other.interestRate)) {
      return false;
    }

    if (interestYearToDate == null) {
      if (other.interestYearToDate != null) {
        return false;
      }
    } else if (!interestYearToDate.equals(other.interestYearToDate)) {
      return false;
    }

    if (loanDuration == null) {
      if (other.loanDuration != null) {
        return false;
      }
    } else if (!loanDuration.equals(other.loanDuration)) {
      return false;
    }

    if (loanProvider == null) {
      if (other.loanProvider != null) {
        return false;
      }
    } else if (!loanProvider.equals(other.loanProvider)) {
      return false;
    }

    if (loanNum == null) {
      if (other.loanNum != null) {
        return false;
      }
    } else if (!loanNum.equals(other.loanNum)) {
      return false;
    }

    if (loanType == null) {
      if (other.loanType != null) {
        return false;
      }
    } else if (!loanType.equals(other.loanType)) {
      return false;
    }

    if (propertyAddress == null) {
      if (other.propertyAddress != null) {
        return false;
      }
    } else if (!propertyAddress.equals(other.propertyAddress)) {
      return false;
    }

    if (taxYearToDate == null) {
      if (other.taxYearToDate != null) {
        return false;
      }
    } else if (!taxYearToDate.equals(other.taxYearToDate)) {
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
   * getter method for escrow balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getEscrowBalance() {
    return escrowBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for interest rate.
   *
   * @return  BigDecimal
   */
  public BigDecimal getInterestRate() {
    return interestRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for interest year to date.
   *
   * @return  BigDecimal
   */
  public BigDecimal getInterestYearToDate() {
    return interestYearToDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for loan duration.
   *
   * @return  Integer
   */
  public Integer getLoanDuration() {
    return loanDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for loan num.
   *
   * @return  String
   */
  public String getLoanNum() {
    return loanNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for loan provider.
   *
   * @return  String
   */
  public String getLoanProvider() {
    return loanProvider;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for loan type.
   *
   * @return  String
   */
  public String getLoanType() {
    return loanType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for masked loan num.
   *
   * @return  String
   */
  public String getMaskedLoanNum() {
    if (!StringUtils.hasText(loanNum)) {
      return "";
    }

    int len = loanNum.length();

    if (len > 5) {
      return "XXXXXXXX-" + loanNum.substring(len - 4, len);
    }

    return "XXXXXXXX-" + loanNum.substring(len - 1, len);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mortgage id.
   *
   * @return  Long
   */
  public Long getMortgageId() {
    return mortgageId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original loan amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOriginalLoanAmount() {
    return originalLoanAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for property address.
   *
   * @return  Address
   */
  public Address getPropertyAddress() {
    return propertyAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for property address str.
   *
   * @return  String
   */
  public String getPropertyAddressStr() {
    return (propertyAddress == null) ? "" : propertyAddress.getFullDisplayAddress();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tax year to date.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTaxYearToDate() {
    return taxYearToDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result)
      + ((escrowBalance == null) ? 0 : escrowBalance.hashCode());
    result = (prime * result)
      + ((interestRate == null) ? 0 : interestRate.hashCode());
    result = (prime * result)
      + ((interestYearToDate == null) ? 0 : interestYearToDate.hashCode());
    result = (prime * result)
      + ((loanDuration == null) ? 0 : loanDuration.hashCode());
    result = (prime * result)
      + ((loanProvider == null) ? 0 : loanProvider.hashCode());
    result = (prime * result) + ((loanNum == null) ? 0 : loanNum.hashCode());
    result = (prime * result) + ((loanType == null) ? 0 : loanType.hashCode());
    result = (prime * result)
      + ((propertyAddress == null) ? 0 : propertyAddress.hashCode());
    result = (prime * result)
      + ((taxYearToDate == null) ? 0 : taxYearToDate.hashCode());

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
   * setter method for escrow balance.
   *
   * @param  escrowBalance  BigDecimal
   */
  public void setEscrowBalance(BigDecimal escrowBalance) {
    this.escrowBalance = escrowBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for interest rate.
   *
   * @param  interestRate  BigDecimal
   */
  public void setInterestRate(BigDecimal interestRate) {
    this.interestRate = interestRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for interest year to date.
   *
   * @param  interestYearToDate  BigDecimal
   */
  public void setInterestYearToDate(BigDecimal interestYearToDate) {
    this.interestYearToDate = interestYearToDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for loan duration.
   *
   * @param  loanDuration  Integer
   */
  public void setLoanDuration(Integer loanDuration) {
    this.loanDuration = loanDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for loan num.
   *
   * @param  loanNum  String
   */
  public void setLoanNum(String loanNum) {
    this.loanNum = loanNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for loan provider.
   *
   * @param  loanProvider  String
   */
  public void setLoanProvider(String loanProvider) {
    this.loanProvider = loanProvider;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for loan type.
   *
   * @param  loanType  String
   */
  public void setLoanType(String loanType) {
    this.loanType = loanType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mortgage id.
   *
   * @param  mortgageId  Long
   */
  public void setMortgageId(Long mortgageId) {
    this.mortgageId = mortgageId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for original loan amount.
   *
   * @param  originalLoanAmount  BigDecimal
   */
  public void setOriginalLoanAmount(BigDecimal originalLoanAmount) {
    this.originalLoanAmount = originalLoanAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for property address.
   *
   * @param  propertyAddress  Address
   */
  public void setPropertyAddress(Address propertyAddress) {
    this.propertyAddress = propertyAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tax year to date.
   *
   * @param  taxYearToDate  BigDecimal
   */
  public void setTaxYearToDate(BigDecimal taxYearToDate) {
    this.taxYearToDate = taxYearToDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "AccountMortgage ( " + "mortgageId = " + this.mortgageId + TAB
      + "propertyAddress = " + this.propertyAddress + TAB + "loanNum = "
      + this.loanNum + TAB + "interestRate = " + this.interestRate + TAB
      + "escrowBalance = " + this.escrowBalance + TAB
      + "interestYearToDate = " + this.interestYearToDate + TAB
      + "taxYearToDate = " + this.taxYearToDate + TAB + "loadDuration = "
      + this.loanDuration + TAB + "loadProvider = " + this.loanProvider + TAB
      + "loanType = " + this.loanType + TAB + " )";

    return retValue;
  }

} // end class AccountMortgage
