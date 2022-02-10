package com.cmc.credagility.core.domain.payment;

import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.type.BankAccountType;
import com.cmc.credagility.core.domain.type.CardType;
import com.cmc.credagility.core.domain.type.FundingAccountType;
import com.cmc.credagility.core.domain.util.CompareUtil;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;


/**
 * This class is used to store all funding account information.
 *
 * <p><a href="FundingAccount.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
@Embeddable public class FundingInformation implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  // ~ Static fields/initializers
  // ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4952221061915847017L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  // ~ Instance fields
  // --------------------------------------------------------------------------------------------------

  /** funding account address. */
  @Embedded protected Address address = new Address();

  /** check Number. */ @Transient protected String checkNumber;

  /** Credit card CVV number. */
  @Column(
    name       = "cvv",
    length     = 5,
    insertable = false,
    updatable  = false
  )
  @Transient protected String cvv;

  /** Account expire date. */
  @Column(name = "expirationDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date expirationDate;

  /** funding account number. */
  @Column(
    name     = "fundingAccountNum",
    length   = 80,
    nullable = true
  )
  @Convert(converter = StringEncryptionConverter.class)
  protected String fundingAccountNum;

  /** holder full name. */
  @Column(
    name     = "holderFullName",
    length   = 102,
    nullable = true
  )
  protected String holderFullName;

  /** Account nick name. */
  @Column(
    name     = "nickName",
    length   = 60,
    nullable = true
  )
  protected String nickName;

  /** funding account routing number. */
  @Column(
    name   = "routingNumber",
    length = 20
  )
  protected String routingNumber;

  /** funding account sub type. */
  @Column(
    name   = "subType",
    length = 20
  )
  protected String subType;

  /** funding account type. */
  @Column(
    name     = "type",
    length   = 20,
    nullable = true
  )
  protected String type;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  // ~ Methods
  // ----------------------------------------------------------------------------------------------------------

  /**
   * Make a copy for funding information.
   *
   * @param  fundingInformation  DOCUMENT ME!
   */
  public void deepCopy(FundingInformation fundingInformation) {
    this.fundingAccountNum = fundingInformation.getFundingAccountNum();
    this.holderFullName    = fundingInformation.getHolderFullName();
    this.routingNumber     = fundingInformation.getRoutingNumber();
    this.type              = fundingInformation.getType();
    this.subType           = fundingInformation.getSubType();
    this.address.deepCopy(fundingInformation.getAddress());
    this.nickName = fundingInformation.getNickName();

    if (fundingInformation.getExpirationDate() != null) {
      this.expirationDate = new Date(fundingInformation.getExpirationDate().getTime());
    } else {
      this.expirationDate = null;
    }

    this.cvv = fundingInformation.getCvv();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   portfolioId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean ensureNickName(Long portfolioId) {
    if ((nickName == null) || "".equals(nickName)) {
      if ((this.fundingAccountNum != null)
            && !"".equals(this.fundingAccountNum)) {
        if (this.fundingAccountNum.length() > 5) {
          if ((portfolioId == 150003L) || (portfolioId == 220001L)) {
            nickName = "***-"
              + this.fundingAccountNum.substring(fundingAccountNum.length() - 4);
          } else {
            nickName = "***-"
              + this.fundingAccountNum.substring(fundingAccountNum.length() - 3);
          }
        } else {
          nickName = "***-"
            + this.fundingAccountNum.substring(fundingAccountNum.length() - 1);
        }

        return true;
      }

      return false; // no funding account num, no nick name - error!
    }

    return true;
  } // end method ensureNickName

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

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

    if (getClass() != obj.getClass()) {
      return false;
    }

    final FundingInformation other = (FundingInformation) obj;

    // Added by RamaKrishna on 9/12/2009 to fix SM-76 --START

    if (other.getType() != null) {
      if ((other.getType().equals(FundingAccountType.CREDITCARD.toString())
              || other.getType().equals(FundingAccountType.DEBITCARD.toString()))
            && (getType().equals(FundingAccountType.CREDITCARD.toString())
              || getType().equals(FundingAccountType.DEBITCARD.toString()))) {
        if (this.fundingAccountNum == null) {
          if (other.getFundingAccountNum() != null) {
            return false;
          }
        } else if (this.fundingAccountNum.equals(other.getFundingAccountNum())) {
          return true;
        }
      }

      if (other.getType().equals(getType())
            && getType().equals(FundingAccountType.BANKACCOUNT.toString())) {
        if ((other.getFundingAccountNum() != null)
              && (other.getRoutingNumber() != null)
              && getFundingAccountNum().equals(other.getFundingAccountNum())
              && getRoutingNumber().equals(other.getRoutingNumber())) {
          return true;
        }
      }
    }

    // Added by RamaKrishna on 9/12/2009 to fix SM-76 --END
    if (this.cvv == null) {
      if (other.getCvv() != null) {
        return false;
      }
    } else if (!this.cvv.equals(other.getCvv())) {
      return false;
    }

    if (this.expirationDate == null) {
      if (other.getExpirationDate() != null) {
        return false;
      }
    } else if (!CompareUtil.isDateEqual(this.expirationDate, other.getExpirationDate())) {
      return false;
    }

    if (this.fundingAccountNum == null) {
      if (other.getFundingAccountNum() != null) {
        return false;
      }
    } else if (!this.fundingAccountNum.equals(other.getFundingAccountNum())) {
      return false;
    }

    if (this.holderFullName == null) {
      if (other.getHolderFullName() != null) {
        return false;
      }
    } else if (!this.holderFullName.equals(other.getHolderFullName())) {
      return false;
    }

    if (this.routingNumber == null) {
      if (other.getRoutingNumber() != null) {
        return false;
      }
    } else if (!this.routingNumber.equals(other.getRoutingNumber())) {
      return false;
    }

    if (this.subType == null) {
      if (other.getSubType() != null) {
        return false;
      }
    } else if (!this.subType.equals(other.getSubType())) {
      return false;
    }

    if (this.type == null) {
      if (other.getType() != null) {
        return false;
      }
    } else if (!this.type.equals(other.getType())) {
      return false;
    }

    if (this.address == null) {
      if (other.getAddress() != null) {
        return false;
      }
    } else if (!this.address.equals(other.getAddress())) {
      return false;
    }

    if (this.nickName == null) {
      if (other.getNickName() != null) {
        return false;
      }
    } else if (!this.nickName.equals(other.getNickName())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The address.
   *
   * @return  the address
   *
   *          <p>not-null = "false"</p>
   */
  public Address getAddress() {
    return address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BankAccountType getBankAccountType() {
    if (!isBankAccount()) {
      return null;
    }

    for (BankAccountType value : BankAccountType.values()) {
      if (value.toString().equalsIgnoreCase(getSubType())) {
        return value;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CardType getCardType() {
    if (!isCardAccount()) {
      return null;
    }

    for (CardType value : CardType.values()) {
      if (value.toString().equalsIgnoreCase(getSubType())) {
        return value;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getCheckNumber() {
    return checkNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The cvv.
   *
   * @return  the cvv
   *
   *          <p>not-null = "false" length = "5"</p>
   */
  public String getCvv() {
    return this.cvv;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The expirationDate.
   *
   * @return  the expirationDate
   *
   *          <p>not-null = "false"</p>
   */
  public Date getExpirationDate() {
    return expirationDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The accountNum.
   *
   * @return  the accountNum
   *
   *          <p>not-null = "false" length = "20"</p>
   */
  public String getFundingAccountNum() {
    return fundingAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding account num last4.
   *
   * @return  String
   */
  public String getFundingAccountNumLast4() {
    if(StringUtils.hasText(this.fundingAccountNum)) {
      return (this.fundingAccountNum.length() > 4)
          ? this.fundingAccountNum.substring(this.fundingAccountNum.length() - 4, this.fundingAccountNum.length())
          : this.fundingAccountNum;
    }else{
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The holderFullName.
   *
   * @return  the holderFullName
   *
   *          <p>not-null = "false" length = "102"</p>
   */
  public String getHolderFullName() {
    return holderFullName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The nickName.
   *
   * @return  the nickName
   *
   *          <p>not-null = "false" length = "40"</p>
   */
  public String getNickName() {
    return nickName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The routingNumber.
   *
   * @return  the routingNumber
   *
   *          <p>not-null = "false" length = "20"</p>
   */
  public String getRoutingNumber() {
    return routingNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The subType.
   *
   * @return  the subType
   *
   *          <p>not-null = "false" length = "20"</p>
   */
  public String getSubType() {
    return subType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * The type.
   *
   * @return  the type
   *
   *          <p>not-null = "false" length = "20"</p>
   */
  public String getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = 1;
    result = (PRIME * result) + ((this.cvv == null) ? 0 : this.cvv.hashCode());
    result = (PRIME * result)
      + ((this.expirationDate == null) ? 0 : this.expirationDate.hashCode());
    result = (PRIME * result)
      + ((this.fundingAccountNum == null) ? 0 : this.fundingAccountNum.hashCode());
    result = (PRIME * result)
      + ((this.holderFullName == null) ? 0 : this.holderFullName.hashCode());
    result = (PRIME * result)
      + ((this.routingNumber == null) ? 0 : this.routingNumber.hashCode());
    result = (PRIME * result)
      + ((this.subType == null) ? 0 : this.subType.hashCode());
    result = (PRIME * result)
      + ((this.type == null) ? 0 : this.type.hashCode());
    result = (PRIME * result)
      + ((this.address == null) ? 0 : this.address.hashCode());
    result = (PRIME * result)
      + ((this.nickName == null) ? 0 : this.nickName.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isAmex() {
    return CardType.AMERICANEEXPRESS.toString().equalsIgnoreCase((subType));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * return true if the account is a bank account.
   *
   * @return  return true if the account is a bank account
   */
  public boolean isBankAccount() {
    return FundingAccountType.BANKACCOUNT.toString().equalsIgnoreCase(type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * return true if the account is a card account.
   *
   * @return  return true if the account is a card account
   */
  public boolean isCardAccount() {
    return FundingAccountType.CREDITCARD.toString().equalsIgnoreCase(type)
      || FundingAccountType.DEBITCARD.toString().equalsIgnoreCase(type)
      || FundingAccountType.CARD.toString().equalsIgnoreCase(type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * return true if the account is a credit card account.
   *
   * @return  return true if the account is a credit card account
   */
  public boolean isCreditCard() {
    return (FundingAccountType.CREDITCARD.toString().equalsIgnoreCase(type));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * return true if the account is a debit card account.
   *
   * @return  return true if the account is a debit card account
   */
  public boolean isDebitCard() {
    return (FundingAccountType.DEBITCARD.toString().equalsIgnoreCase(type));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isDinersClub() {
    return CardType.DINERSCLUB.toString().equalsIgnoreCase((subType));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isDiscover() {
    return CardType.DISCOVER.toString().equalsIgnoreCase((subType));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isJCB() {
    return CardType.JCB.toString().equalsIgnoreCase((subType));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isMasterCard() {
    return CardType.MASTERCARD.toString().equalsIgnoreCase((subType));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isMoneyMarket() {
    return FundingAccountType.MONEYMARKET.toString().equalsIgnoreCase(type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isVisa() {
    return CardType.VISA.toString().equalsIgnoreCase((subType));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  address  the address to set
   */
  public void setAddress(Address address) {
    this.address = address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  checkNumber  DOCUMENT ME!
   */
  public void setCheckNumber(String checkNumber) {
    this.checkNumber = checkNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cvv  the cvv to set
   */
  public void setCvv(String cvv) {
    this.cvv = cvv;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expireDate  the expirationDate to set
   */
  public void setExpirationDate(Date expireDate) {
    this.expirationDate = expireDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fundingAccountNum  the accountNum to set
   */
  public void setFundingAccountNum(String fundingAccountNum) {
    this.fundingAccountNum = fundingAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  holderFullName  the holderFullName to set
   */
  public void setHolderFullName(String holderFullName) {
    this.holderFullName = holderFullName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  nickName  the nickName to set
   */
  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  routingNumber  the routingNumber to set
   */
  public void setRoutingNumber(String routingNumber) {
    this.routingNumber = routingNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  subType  the subType to set
   */
  public void setSubType(String subType) {
    this.subType = subType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  type  the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("FundingAccount ( ").append("address = ").append(
      this.address).append(TAB).append("expirationDate = ").append(
      this.expirationDate).append(TAB).append("fundingAccountNum = ").append(
      this.fundingAccountNum).append(TAB).append("holderFullName = ").append(
      this.holderFullName).append(TAB).append("nickName = ").append(
      this.nickName).append(TAB).append("routingNumber = ").append(
      this.routingNumber).append(TAB).append("subType = ").append(
      this.subType).append(TAB).append("type = ").append(this.type).append(
      TAB).append(" )");

    return retValue.toString();
  }
} // end class FundingInformation
