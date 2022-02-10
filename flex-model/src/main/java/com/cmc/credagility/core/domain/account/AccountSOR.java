package com.cmc.credagility.core.domain.account;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * Created by coin on 11/24/15.
 *
 * @author   <a href="mailto:Hao.Kang@ozstrategy.com">Hao Kang</a>
 * @version  11/24/2015 00:34
 */
@Entity
@Table(name = "AccountSOR")
public class AccountSOR extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4302774227096757618L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "accrueInterest",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean accrueInterest = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "legalClaimDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date legalClaimDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "legalJudgementDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date legalJudgementDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "legalJudgementExpirationDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date legalJudgementExpirationDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "postedDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date postedDate;

  @JoinColumn(
    name     = "accountNum",
    unique   = true,
    nullable = false
  )
  @ManyToOne private Account account;

  @Column(
    name   = "bureauAccountType",
    length = 2
  )
  private String bureauAccountType;

  @Column(
    name   = "bureauECOACode",
    length = 1
  )
  private String bureauECOACode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "bureauPortfolioType",
    length = 1
  )
  private String bureauPortfolioType;

  @Column(
    name   = "bureauStatus",
    length = 2
  )
  private String bureauStatus;

  @Column(name = "chargeOffFees1")
  private BigDecimal chargeOffFees1;

  @Column(name = "chargeOffFees2")
  private BigDecimal chargeOffFees2;

  @Column(name = "chargeOffFees3")
  private BigDecimal chargeOffFees3;

  @Column(name = "chargeOffFees4")
  private BigDecimal chargeOffFees4;

  /** TODO: DOCUMENT ME! */
  @Column(name = "chargeOffInterest")
  private BigDecimal chargeOffInterest;

  /** TODO: DOCUMENT ME! */
  @Column(name = "chargeOffPrincipal")
  private BigDecimal chargeOffPrincipal;


  @Column(
    name   = "compCallCode",
    length = 5
  )
  private String compCallCode;


  /** TODO: DOCUMENT ME! */
  @Column(name = "creditScore")
  private Integer creditScore;

  /** TODO: DOCUMENT ME! */
  @Column
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long         id;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "initialDelinquencyDate",
    nullable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  private Date initialDelinquencyDate;

  @Column(name = "originalLoanAmount")
  private BigDecimal originalLoanAmount;
  @Column(name = "preLegalFee1")
  private BigDecimal preLegalFee1;
  @Column(name = "preLegalFee2")
  private BigDecimal preLegalFee2;
  @Column(name = "preLegalInterest")
  private BigDecimal preLegalInterest;

  @Column(name = "preLegalPrincipal")
  private BigDecimal preLegalPrincipal;

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

    AccountSOR that = (AccountSOR) o;

    if ((accrueInterest != null) ? (!accrueInterest.equals(that.accrueInterest)) : (that.accrueInterest != null)) {
      return false;
    }

    if ((legalClaimDate != null) ? (!legalClaimDate.equals(that.legalClaimDate)) : (that.legalClaimDate != null)) {
      return false;
    }

    if ((legalJudgementDate != null) ? (!legalJudgementDate.equals(that.legalJudgementDate))
                                     : (that.legalJudgementDate != null)) {
      return false;
    }

    if ((legalJudgementExpirationDate != null)
          ? (!legalJudgementExpirationDate.equals(that.legalJudgementExpirationDate))
          : (that.legalJudgementExpirationDate != null)) {
      return false;
    }

    if ((postedDate != null) ? (!postedDate.equals(that.postedDate)) : (that.postedDate != null)) {
      return false;
    }

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((bureauAccountType != null) ? (!bureauAccountType.equals(that.bureauAccountType))
                                    : (that.bureauAccountType != null)) {
      return false;
    }

    if ((bureauECOACode != null) ? (!bureauECOACode.equals(that.bureauECOACode)) : (that.bureauECOACode != null)) {
      return false;
    }

    if ((bureauPortfolioType != null) ? (!bureauPortfolioType.equals(that.bureauPortfolioType))
                                      : (that.bureauPortfolioType != null)) {
      return false;
    }

    if ((bureauStatus != null) ? (!bureauStatus.equals(that.bureauStatus)) : (that.bureauStatus != null)) {
      return false;
    }

    if ((chargeOffFees1 != null) ? (!chargeOffFees1.equals(that.chargeOffFees1)) : (that.chargeOffFees1 != null)) {
      return false;
    }

    if ((chargeOffFees2 != null) ? (!chargeOffFees2.equals(that.chargeOffFees2)) : (that.chargeOffFees2 != null)) {
      return false;
    }

    if ((chargeOffFees3 != null) ? (!chargeOffFees3.equals(that.chargeOffFees3)) : (that.chargeOffFees3 != null)) {
      return false;
    }

    if ((chargeOffFees4 != null) ? (!chargeOffFees4.equals(that.chargeOffFees4)) : (that.chargeOffFees4 != null)) {
      return false;
    }

    if ((chargeOffInterest != null) ? (!chargeOffInterest.equals(that.chargeOffInterest))
                                    : (that.chargeOffInterest != null)) {
      return false;
    }

    if ((chargeOffPrincipal != null) ? (!chargeOffPrincipal.equals(that.chargeOffPrincipal))
                                     : (that.chargeOffPrincipal != null)) {
      return false;
    }

    if ((compCallCode != null) ? (!compCallCode.equals(that.compCallCode)) : (that.compCallCode != null)) {
      return false;
    }

    if ((creditScore != null) ? (!creditScore.equals(that.creditScore)) : (that.creditScore != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((initialDelinquencyDate != null) ? (!initialDelinquencyDate.equals(that.initialDelinquencyDate))
                                         : (that.initialDelinquencyDate != null)) {
      return false;
    }

    if ((originalLoanAmount != null) ? (!originalLoanAmount.equals(that.originalLoanAmount))
                                     : (that.originalLoanAmount != null)) {
      return false;
    }

    if ((preLegalFee1 != null) ? (!preLegalFee1.equals(that.preLegalFee1)) : (that.preLegalFee1 != null)) {
      return false;
    }

    if ((preLegalFee2 != null) ? (!preLegalFee2.equals(that.preLegalFee2)) : (that.preLegalFee2 != null)) {
      return false;
    }

    if ((preLegalInterest != null) ? (!preLegalInterest.equals(that.preLegalInterest))
                                   : (that.preLegalInterest != null)) {
      return false;
    }

    return (preLegalPrincipal != null) ? preLegalPrincipal.equals(that.preLegalPrincipal)
                                       : (that.preLegalPrincipal == null);

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
   * getter method for accrue interest.
   *
   * @return  Boolean
   */
  public Boolean getAccrueInterest() {
    return (accrueInterest == null) ? Boolean.FALSE : accrueInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau account type.
   *
   * @return  String
   */
  public String getBureauAccountType() {
    return bureauAccountType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau ECOACode.
   *
   * @return  String
   */
  public String getBureauECOACode() {
    return bureauECOACode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau portfolio type.
   *
   * @return  String
   */
  public String getBureauPortfolioType() {
    return bureauPortfolioType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau status.
   *
   * @return  String
   */
  public String getBureauStatus() {
    return bureauStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off fees1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getChargeOffFees1() {
    return (chargeOffFees1 != null) ? chargeOffFees1 : BigDecimal.ZERO;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off fees2.
   *
   * @return  BigDecimal
   */
  public BigDecimal getChargeOffFees2() {
    return (chargeOffFees2 != null) ? chargeOffFees2 : BigDecimal.ZERO;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off fees3.
   *
   * @return  BigDecimal
   */
  public BigDecimal getChargeOffFees3() {
    return chargeOffFees3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off fees4.
   *
   * @return  BigDecimal
   */
  public BigDecimal getChargeOffFees4() {
    return chargeOffFees4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getChargeOffInterest() {
    return (chargeOffInterest != null) ? chargeOffInterest : BigDecimal.ZERO;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off principal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getChargeOffPrincipal() {
    return (chargeOffPrincipal != null) ? chargeOffPrincipal : BigDecimal.ZERO;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for comp call code.
   *
   * @return  String
   */
  public String getCompCallCode() {
    return compCallCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for credit score.
   *
   * @return  Integer
   */
  public Integer getCreditScore() {
    return creditScore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for initial delinquency date.
   *
   * @return  Date
   */
  public Date getInitialDelinquencyDate() {
    return initialDelinquencyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for legal claim date.
   *
   * @return  Date
   */
  public Date getLegalClaimDate() {
    return legalClaimDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for legal judgement date.
   *
   * @return  Date
   */
  public Date getLegalJudgementDate() {
    return legalJudgementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for legal judgement expiration date.
   *
   * @return  Date
   */
  public Date getLegalJudgementExpirationDate() {
    return legalJudgementExpirationDate;
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
   * getter method for posted date.
   *
   * @return  Date
   */
  public Date getPostedDate() {
    return postedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pre legal fee1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPreLegalFee1() {
    return preLegalFee1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pre legal fee2.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPreLegalFee2() {
    return preLegalFee2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pre legal interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPreLegalInterest() {
    return preLegalInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pre legal principal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPreLegalPrincipal() {
    return preLegalPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((accrueInterest != null) ? accrueInterest.hashCode() : 0);
    result = (31 * result) + ((legalClaimDate != null) ? legalClaimDate.hashCode() : 0);
    result = (31 * result) + ((legalJudgementDate != null) ? legalJudgementDate.hashCode() : 0);
    result = (31 * result) + ((legalJudgementExpirationDate != null) ? legalJudgementExpirationDate.hashCode() : 0);
    result = (31 * result) + ((postedDate != null) ? postedDate.hashCode() : 0);
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((bureauAccountType != null) ? bureauAccountType.hashCode() : 0);
    result = (31 * result) + ((bureauECOACode != null) ? bureauECOACode.hashCode() : 0);
    result = (31 * result) + ((bureauPortfolioType != null) ? bureauPortfolioType.hashCode() : 0);
    result = (31 * result) + ((bureauStatus != null) ? bureauStatus.hashCode() : 0);
    result = (31 * result) + ((chargeOffFees1 != null) ? chargeOffFees1.hashCode() : 0);
    result = (31 * result) + ((chargeOffFees2 != null) ? chargeOffFees2.hashCode() : 0);
    result = (31 * result) + ((chargeOffFees3 != null) ? chargeOffFees3.hashCode() : 0);
    result = (31 * result) + ((chargeOffFees4 != null) ? chargeOffFees4.hashCode() : 0);
    result = (31 * result) + ((chargeOffInterest != null) ? chargeOffInterest.hashCode() : 0);
    result = (31 * result) + ((chargeOffPrincipal != null) ? chargeOffPrincipal.hashCode() : 0);
    result = (31 * result) + ((compCallCode != null) ? compCallCode.hashCode() : 0);
    result = (31 * result) + ((creditScore != null) ? creditScore.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((initialDelinquencyDate != null) ? initialDelinquencyDate.hashCode() : 0);
    result = (31 * result) + ((originalLoanAmount != null) ? originalLoanAmount.hashCode() : 0);
    result = (31 * result) + ((preLegalFee1 != null) ? preLegalFee1.hashCode() : 0);
    result = (31 * result) + ((preLegalFee2 != null) ? preLegalFee2.hashCode() : 0);
    result = (31 * result) + ((preLegalInterest != null) ? preLegalInterest.hashCode() : 0);
    result = (31 * result) + ((preLegalPrincipal != null) ? preLegalPrincipal.hashCode() : 0);

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
   * setter method for accrue interest.
   *
   * @param  accrueInterest  Boolean
   */
  public void setAccrueInterest(Boolean accrueInterest) {
    this.accrueInterest = accrueInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bureau account type.
   *
   * @param  bureauAccountType  String
   */
  public void setBureauAccountType(String bureauAccountType) {
    this.bureauAccountType = bureauAccountType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bureau ECOACode.
   *
   * @param  bureauECOACode  String
   */
  public void setBureauECOACode(String bureauECOACode) {
    this.bureauECOACode = bureauECOACode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bureau portfolio type.
   *
   * @param  bureauPortfolioType  String
   */
  public void setBureauPortfolioType(String bureauPortfolioType) {
    this.bureauPortfolioType = bureauPortfolioType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bureau status.
   *
   * @param  bureauStatus  String
   */
  public void setBureauStatus(String bureauStatus) {
    this.bureauStatus = bureauStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off fees1.
   *
   * @param  chargeOffFees1  BigDecimal
   */
  public void setChargeOffFees1(BigDecimal chargeOffFees1) {
    this.chargeOffFees1 = chargeOffFees1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off fees2.
   *
   * @param  chargeOffFees2  BigDecimal
   */
  public void setChargeOffFees2(BigDecimal chargeOffFees2) {
    this.chargeOffFees2 = chargeOffFees2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off fees3.
   *
   * @param  chargeOffFees3  BigDecimal
   */
  public void setChargeOffFees3(BigDecimal chargeOffFees3) {
    this.chargeOffFees3 = chargeOffFees3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off fees4.
   *
   * @param  chargeOffFees4  BigDecimal
   */
  public void setChargeOffFees4(BigDecimal chargeOffFees4) {
    this.chargeOffFees4 = chargeOffFees4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off interest.
   *
   * @param  chargeOffInterest  BigDecimal
   */
  public void setChargeOffInterest(BigDecimal chargeOffInterest) {
    this.chargeOffInterest = chargeOffInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off principal.
   *
   * @param  chargeOffPrincipal  BigDecimal
   */
  public void setChargeOffPrincipal(BigDecimal chargeOffPrincipal) {
    this.chargeOffPrincipal = chargeOffPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for comp call code.
   *
   * @param  compCallCode  String
   */
  public void setCompCallCode(String compCallCode) {
    this.compCallCode = compCallCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for credit score.
   *
   * @param  creditScore  Integer
   */
  public void setCreditScore(Integer creditScore) {
    this.creditScore = creditScore;
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
   * setter method for initial delinquency date.
   *
   * @param  initialDelinquencyDate  Date
   */
  public void setInitialDelinquencyDate(Date initialDelinquencyDate) {
    this.initialDelinquencyDate = initialDelinquencyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for legal claim date.
   *
   * @param  legalClaimDate  Date
   */
  public void setLegalClaimDate(Date legalClaimDate) {
    this.legalClaimDate = legalClaimDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for legal judgement date.
   *
   * @param  legalJudgementDate  Date
   */
  public void setLegalJudgementDate(Date legalJudgementDate) {
    this.legalJudgementDate = legalJudgementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for legal judgement expiration date.
   *
   * @param  legalJudgementExpirationDate  Date
   */
  public void setLegalJudgementExpirationDate(Date legalJudgementExpirationDate) {
    this.legalJudgementExpirationDate = legalJudgementExpirationDate;
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
   * setter method for posted date.
   *
   * @param  postedDate  Date
   */
  public void setPostedDate(Date postedDate) {
    this.postedDate = postedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre legal fee1.
   *
   * @param  preLegalFee1  BigDecimal
   */
  public void setPreLegalFee1(BigDecimal preLegalFee1) {
    this.preLegalFee1 = preLegalFee1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre legal fee2.
   *
   * @param  preLegalFee2  BigDecimal
   */
  public void setPreLegalFee2(BigDecimal preLegalFee2) {
    this.preLegalFee2 = preLegalFee2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre legal interest.
   *
   * @param  preLegalInterest  BigDecimal
   */
  public void setPreLegalInterest(BigDecimal preLegalInterest) {
    this.preLegalInterest = preLegalInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pre legal principal.
   *
   * @param  preLegalPrincipal  BigDecimal
   */
  public void setPreLegalPrincipal(BigDecimal preLegalPrincipal) {
    this.preLegalPrincipal = preLegalPrincipal;
  }
} // end class AccountSOR
