package com.cmc.credagility.core.domain.customer;


import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:ailing.hu@ozstrategy.com">Ailing Hu</a>
 * @version  11/02/2015 14:40
 */
@Entity
@Table(name = "CustomLoanProgramCalculateResultItem")
public class CustomLoanProgramCalculateResultItem extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2923443645328610583L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** account number. */
  @JoinColumn(name = "accountNum")
  @ManyToOne protected Account account;

  /** Current Rate. */
  @Column(name = "apr")
  protected BigDecimal apr;

  /** cosigner. */
  @JoinColumn(name = "cosignedResponsibleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible cosigner;

  /** current payment. */
  @Column(name = "currentDue")
  protected BigDecimal currentDue;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "customLoanProgramCalculateResultId",
    nullable = true
  )
  @ManyToOne protected CustomLoanProgramCalculateResult customLoanProgramCalculateResult;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "CustomLoanProgramCalculateResultItemId",
    nullable = false,
    unique   = true
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long CustomLoanProgramCalculateResultItemId;

  /** rate. */
  @Column(
    name     = "hardshipPGRate",
    nullable = true
  )
  protected BigDecimal hardshipPGRate;

  /** new payment. */
  @Column(name = "newPaymentAmount")
  protected BigDecimal newPaymentAmount;

  /** new term. */
  @Column(name = "newTerm")
  protected Long newTerm;

  /** Current Payoff. */
  @Column(name = "pastDue")
  protected BigDecimal pastDue;

  /** Borrower. */
  @JoinColumn(name = "responsibleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** terms left. */
  @Column(name = "termsLeft")
  protected Long termsLeft;

  /** total terms. */
  @Column(name = "totalTerms")
  protected Long totalTerms;

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

    CustomLoanProgramCalculateResultItem that = (CustomLoanProgramCalculateResultItem) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((apr != null) ? (!apr.equals(that.apr)) : (that.apr != null)) {
      return false;
    }

    if ((cosigner != null) ? (!cosigner.equals(that.cosigner)) : (that.cosigner != null)) {
      return false;
    }

    if ((currentDue != null) ? (!currentDue.equals(that.currentDue)) : (that.currentDue != null)) {
      return false;
    }

    if ((customLoanProgramCalculateResult != null)
          ? (!customLoanProgramCalculateResult.equals(that.customLoanProgramCalculateResult))
          : (that.customLoanProgramCalculateResult != null)) {
      return false;
    }

    if ((CustomLoanProgramCalculateResultItemId != null)
          ? (!CustomLoanProgramCalculateResultItemId.equals(that.CustomLoanProgramCalculateResultItemId))
          : (that.CustomLoanProgramCalculateResultItemId != null)) {
      return false;
    }

    if ((hardshipPGRate != null) ? (!hardshipPGRate.equals(that.hardshipPGRate)) : (that.hardshipPGRate != null)) {
      return false;
    }

    if ((newPaymentAmount != null) ? (!newPaymentAmount.equals(that.newPaymentAmount))
                                   : (that.newPaymentAmount != null)) {
      return false;
    }

    if ((newTerm != null) ? (!newTerm.equals(that.newTerm)) : (that.newTerm != null)) {
      return false;
    }

    if ((pastDue != null) ? (!pastDue.equals(that.pastDue)) : (that.pastDue != null)) {
      return false;
    }

    if ((responsible != null) ? (!responsible.equals(that.responsible)) : (that.responsible != null)) {
      return false;
    }

    if ((termsLeft != null) ? (!termsLeft.equals(that.termsLeft)) : (that.termsLeft != null)) {
      return false;
    }

    return !((totalTerms != null) ? (!totalTerms.equals(that.totalTerms)) : (that.totalTerms != null));

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
   * getter method for apr.
   *
   * @return  BigDecimal
   */
  public BigDecimal getApr() {
    return apr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cosigner.
   *
   * @return  Responsible
   */
  public Responsible getCosigner() {
    return cosigner;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCurrentDue() {
    return currentDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom loan program calculate result.
   *
   * @return  CustomLoanProgramCalculateResult
   */
  public CustomLoanProgramCalculateResult getCustomLoanProgramCalculateResult() {
    return customLoanProgramCalculateResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom loan program calculate result item id.
   *
   * @return  Long
   */
  public Long getCustomLoanProgramCalculateResultItemId() {
    return CustomLoanProgramCalculateResultItemId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hardship PGRate.
   *
   * @return  BigDecimal
   */
  public BigDecimal getHardshipPGRate() {
    return hardshipPGRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for new payment amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getNewPaymentAmount() {
    return newPaymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for new term.
   *
   * @return  Long
   */
  public Long getNewTerm() {
    return newTerm;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for past due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPastDue() {
    return pastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for terms left.
   *
   * @return  Long
   */
  public Long getTermsLeft() {
    return termsLeft;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total terms.
   *
   * @return  Long
   */
  public Long getTotalTerms() {
    return totalTerms;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((apr != null) ? apr.hashCode() : 0);
    result = (31 * result) + ((cosigner != null) ? cosigner.hashCode() : 0);
    result = (31 * result) + ((currentDue != null) ? currentDue.hashCode() : 0);
    result = (31 * result)
      + ((customLoanProgramCalculateResult != null) ? customLoanProgramCalculateResult.hashCode() : 0);
    result = (31 * result)
      + ((CustomLoanProgramCalculateResultItemId != null) ? CustomLoanProgramCalculateResultItemId.hashCode() : 0);
    result = (31 * result) + ((hardshipPGRate != null) ? hardshipPGRate.hashCode() : 0);
    result = (31 * result) + ((newPaymentAmount != null) ? newPaymentAmount.hashCode() : 0);
    result = (31 * result) + ((newTerm != null) ? newTerm.hashCode() : 0);
    result = (31 * result) + ((pastDue != null) ? pastDue.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);
    result = (31 * result) + ((termsLeft != null) ? termsLeft.hashCode() : 0);
    result = (31 * result) + ((totalTerms != null) ? totalTerms.hashCode() : 0);

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
   * setter method for apr.
   *
   * @param  apr  BigDecimal
   */
  public void setApr(BigDecimal apr) {
    this.apr = apr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cosigner.
   *
   * @param  cosigner  Responsible
   */
  public void setCosigner(Responsible cosigner) {
    this.cosigner = cosigner;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current due.
   *
   * @param  currentDue  BigDecimal
   */
  public void setCurrentDue(BigDecimal currentDue) {
    this.currentDue = currentDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom loan program calculate result.
   *
   * @param  customLoanProgramCalculateResult  CustomLoanProgramCalculateResult
   */
  public void setCustomLoanProgramCalculateResult(CustomLoanProgramCalculateResult customLoanProgramCalculateResult) {
    this.customLoanProgramCalculateResult = customLoanProgramCalculateResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom loan program calculate result item id.
   *
   * @param  customLoanProgramCalculateResultItemId  Long
   */
  public void setCustomLoanProgramCalculateResultItemId(Long customLoanProgramCalculateResultItemId) {
    CustomLoanProgramCalculateResultItemId = customLoanProgramCalculateResultItemId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hardship PGRate.
   *
   * @param  hardshipPGRate  BigDecimal
   */
  public void setHardshipPGRate(BigDecimal hardshipPGRate) {
    this.hardshipPGRate = hardshipPGRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for new payment amount.
   *
   * @param  newPaymentAmount  BigDecimal
   */
  public void setNewPaymentAmount(BigDecimal newPaymentAmount) {
    this.newPaymentAmount = newPaymentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for new term.
   *
   * @param  newTerm  Long
   */
  public void setNewTerm(Long newTerm) {
    this.newTerm = newTerm;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for past due.
   *
   * @param  pastDue  BigDecimal
   */
  public void setPastDue(BigDecimal pastDue) {
    this.pastDue = pastDue;
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
   * setter method for terms left.
   *
   * @param  termsLeft  Long
   */
  public void setTermsLeft(Long termsLeft) {
    this.termsLeft = termsLeft;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total terms.
   *
   * @param  totalTerms  Long
   */
  public void setTotalTerms(Long totalTerms) {
    this.totalTerms = totalTerms;
  }
} // end class CustomLoanProgramCalculateResultItem
