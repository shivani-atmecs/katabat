package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * Created by IntelliJ IDEA. User: YongLiu Date: 11-3-29 Time: am 11:06 To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "FundingAccountValidation")
public class FundingAccountValidation extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6808726345202898091L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    name             = "acceptPayment",
    columnDefinition = "char",
    length           = 1,
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean acceptPayment;

  @Column(
    name     = "bankIdentificationNumber",
    length   = 80,
    nullable = false
  )
  private String bankIdentificationNumber;

  @Column(
    name   = "cardSubType",
    length = 20
  )
  private String cardSubType;

  @Column(
    name     = "cardType",
    length   = 20,
    nullable = false
  )
  private String cardType;

  @Column(name = "fundingAccountValidationId")
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long fundingAccountValidationId;

  @JoinColumn(
    name     = "portfolioId",
    unique   = false,
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Portfolio portfolio;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    FundingAccountValidation that = (FundingAccountValidation) o;

    if ((acceptPayment != null) ? (!acceptPayment.equals(that.acceptPayment)) : (that.acceptPayment != null)) {
      return false;
    }

    if ((bankIdentificationNumber != null) ? (!bankIdentificationNumber.equals(that.bankIdentificationNumber))
                                           : (that.bankIdentificationNumber != null)) {
      return false;
    }

    if ((cardSubType != null) ? (!cardSubType.equals(that.cardSubType)) : (that.cardSubType != null)) {
      return false;
    }

    if ((cardType != null) ? (!cardType.equals(that.cardType)) : (that.cardType != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for accept payment.
   *
   * @return  Boolean
   */
  public Boolean getAcceptPayment() {
    return acceptPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bank identification number.
   *
   * @return  String
   */
  public String getBankIdentificationNumber() {
    return bankIdentificationNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for card sub type.
   *
   * @return  String
   */
  public String getCardSubType() {
    return cardSubType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for card type.
   *
   * @return  String
   */
  public String getCardType() {
    return cardType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding account validation id.
   *
   * @return  Long
   */
  public Long getFundingAccountValidationId() {
    return fundingAccountValidationId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (acceptPayment != null) ? acceptPayment.hashCode() : 0;
    result = (31 * result) + ((bankIdentificationNumber != null) ? bankIdentificationNumber.hashCode() : 0);
    result = (31 * result) + ((cardSubType != null) ? cardSubType.hashCode() : 0);
    result = (31 * result) + ((cardType != null) ? cardType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for accept payment.
   *
   * @param  acceptPayment  Boolean
   */
  public void setAcceptPayment(Boolean acceptPayment) {
    this.acceptPayment = acceptPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bank identification number.
   *
   * @param  bankIdentificationNumber  String
   */
  public void setBankIdentificationNumber(String bankIdentificationNumber) {
    this.bankIdentificationNumber = bankIdentificationNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for card sub type.
   *
   * @param  cardSubType  String
   */
  public void setCardSubType(String cardSubType) {
    this.cardSubType = cardSubType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for card type.
   *
   * @param  cardType  String
   */
  public void setCardType(String cardType) {
    this.cardType = cardType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for funding account validation id.
   *
   * @param  fundingAccountValidationId  Long
   */
  public void setFundingAccountValidationId(Long fundingAccountValidationId) {
    this.fundingAccountValidationId = fundingAccountValidationId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }
} // end class FundingAccountValidation
