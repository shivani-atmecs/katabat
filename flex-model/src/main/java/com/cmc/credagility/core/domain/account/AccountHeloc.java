package com.cmc.credagility.core.domain.account;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/15/2014 10:47
 */
@Entity
@Table(
  name    = "AccountHeloc",
  indexes = {
    @Index(
      name = "postalCodeIndex",
      columnList = "postalCode"
    )
  }
)
public class AccountHeloc extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 234546567560L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name       = "accountNum",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Account account;

  // npelleti 08/11 dropped unique key
  @Column(
    name     = "helocId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long helocId;

  // npelleti, 07/29, USB, Added Annotation for column NotNull
  @Column(
    name      = "interestRate",
    nullable  = false,
    precision = 19,
    scale     = 4
  )
  private BigDecimal interestRate;

  // npelleti, 07/29, USB, Added Annotation for column NotNull
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
  private String  loanNum;

  @Column(
    name   = "loanProvider",
    length = 100
  )
  private String     loanProvider;
  @Column(name = "principalAmount")
  private BigDecimal principalAmount;

  @Embedded private Address propertyAddress;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final AccountHeloc other = (AccountHeloc) obj;

    if (interestRate == null) {
      if (other.interestRate != null) {
        return false;
      }
    } else if (!interestRate.equals(other.interestRate)) {
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
   * getter method for heloc id.
   *
   * @return  Long
   */
  public Long getHelocId() {
    return helocId;
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
   * getter method for principal amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPrincipalAmount() {
    return principalAmount;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result)
      + ((interestRate == null) ? 0 : interestRate.hashCode());
    result = (prime * result)
      + ((loanDuration == null) ? 0 : loanDuration.hashCode());
    result = (prime * result)
      + ((loanProvider == null) ? 0 : loanProvider.hashCode());
    result = (prime * result) + ((loanNum == null) ? 0 : loanNum.hashCode());

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
   * setter method for heloc id.
   *
   * @param  helocId  Long
   */
  public void setHelocId(Long helocId) {
    this.helocId = helocId;
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
   * setter method for principal amount.
   *
   * @param  principalAmount  BigDecimal
   */
  public void setPrincipalAmount(BigDecimal principalAmount) {
    this.principalAmount = principalAmount;
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
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "AccountHeloc ( " + "helocId = " + this.helocId + TAB
      + "propertyAddress = " + this.propertyAddress + TAB + "loanNum = "
      + this.loanNum + TAB + "interestRate = " + this.interestRate + TAB
      + this.loanDuration + TAB + "loadProvider = " + this.loanProvider + TAB
      + " )";

    return retValue;
  }
} // end class AccountHeloc
