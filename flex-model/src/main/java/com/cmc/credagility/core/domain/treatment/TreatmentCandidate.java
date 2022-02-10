package com.cmc.credagility.core.domain.treatment;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.TreatmentType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 15:53
 */
@Entity
@Table(name = "TreatmentCandidate")
public class TreatmentCandidate extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** treatment account. */
  // npelleti 08/10 Made accountNum nullable
  @JoinColumn(
    name      = "accountNum",
    updatable = false /*, nullable = false*/
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  private Account account;

  /** treatment apr. */
  @Column(
    name      = "apr",
    nullable  = false,
    precision = 19,
    scale     = 4
  )
  private BigDecimal apr;

  // npelleti, 07/30, USBank, Removed unique constraint
  @Column(
    name     = "id", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  /** the percentage of total treatment pricipal amount. */
  @Column(
    name      = "prPercentage",
    nullable  = false,
    precision = 19,
    scale     = 4
  )
  private BigDecimal prPercentage;

  /** treatment request id. */
  @Column(
    name     = "requestId",
    nullable = false
  )
  private Long requestId;

  /** treatment score. */
  @Column(
    name     = "score",
    nullable = false
  )
  private Integer score;

  /** treatment terms in years. */
  @Column(
    name     = "trem",
    nullable = false,
    length   = 11
  )
  private Integer term;

  /** treatment duration in months. */
  @Column(
    name     = "treatmentDuration",
    nullable = false
  )
  private Integer treatmentDuration;

  // npelleti 08/10 Made ruleId nullable
  @JoinColumn(
    name      = "ruleId", /*nullable = false,*/
    updatable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  private TreatmentRule treatmentRule;

  /** treatment type. */
  @Column(
    name     = "type",
    nullable = false,
    length   = 20
  )
  @Enumerated(value = EnumType.STRING)
  private TreatmentType type;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof TreatmentCandidate)) {
      return false;
    }

    TreatmentCandidate that = (TreatmentCandidate) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((apr != null) ? (!apr.equals(that.apr)) : (that.apr != null)) {
      return false;
    }

    if ((prPercentage != null) ? (!prPercentage.equals(that.prPercentage)) : (that.prPercentage != null)) {
      return false;
    }

    if ((requestId != null) ? (!requestId.equals(that.requestId)) : (that.requestId != null)) {
      return false;
    }

    if ((term != null) ? (!term.equals(that.term)) : (that.term != null)) {
      return false;
    }

    if ((treatmentDuration != null) ? (!treatmentDuration.equals(that.treatmentDuration))
                                    : (that.treatmentDuration != null)) {
      return false;
    }

    if ((treatmentRule != null) ? (!treatmentRule.equals(that.treatmentRule)) : (that.treatmentRule != null)) {
      return false;
    }

    if (type != that.type) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the account relate to this card holder.
   *
   * @return  get the account relate to this card holder.
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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pr percentage.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPrPercentage() {
    return prPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for request id.
   *
   * @return  Long
   */
  public Long getRequestId() {
    return requestId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score.
   *
   * @return  Integer
   */
  public Integer getScore() {
    return score;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for term.
   *
   * @return  Integer
   */
  public Integer getTerm() {
    return term;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for treatment duration.
   *
   * @return  Integer
   */
  public Integer getTreatmentDuration() {
    return treatmentDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the treatmentRule relate to this account.
   *
   * @return  get the treatmentRule relate to this account.
   */
  public TreatmentRule getTreatmentRule() {
    return treatmentRule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  TreatmentType
   */
  public TreatmentType getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 17;
    result = (31 * result) + ((requestId != null) ? requestId.hashCode() : 0);
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((treatmentRule != null) ? treatmentRule.hashCode() : 0);
    result = (31 * result) + ((type != null) ? type.hashCode() : 0);
    result = (31 * result) + ((apr != null) ? apr.hashCode() : 0);
    result = (31 * result) + ((prPercentage != null) ? prPercentage.hashCode() : 0);
    result = (31 * result) + ((term != null) ? term.hashCode() : 0);
    result = (31 * result) + ((treatmentDuration != null) ? treatmentDuration.hashCode() : 0);

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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pr percentage.
   *
   * @param  prPercentage  BigDecimal
   */
  public void setPrPercentage(BigDecimal prPercentage) {
    this.prPercentage = prPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for request id.
   *
   * @param  requestId  Long
   */
  public void setRequestId(Long requestId) {
    this.requestId = requestId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score.
   *
   * @param  score  Integer
   */
  public void setScore(Integer score) {
    this.score = score;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for term.
   *
   * @param  term  Integer
   */
  public void setTerm(Integer term) {
    this.term = term;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for treatment duration.
   *
   * @param  treatmentDuration  Integer
   */
  public void setTreatmentDuration(Integer treatmentDuration) {
    this.treatmentDuration = treatmentDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for treatment rule.
   *
   * @param  treatmentRule  TreatmentRule
   */
  public void setTreatmentRule(TreatmentRule treatmentRule) {
    this.treatmentRule = treatmentRule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type.
   *
   * @param  type  TreatmentType
   */
  public void setType(TreatmentType type) {
    this.type = type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("TreatmentCandidate");
    sb.append("{id=").append(id);
    sb.append(", requestId=").append(requestId);
    sb.append(", account=").append(account);
    sb.append(", treatmentRule=").append(treatmentRule);
    sb.append(", type=").append(type);
    sb.append(", apr=").append(apr);
    sb.append(", prPercentage=").append(prPercentage);
    sb.append(", term=").append(term);
    sb.append(", treatmentDuration=").append(treatmentDuration);
    sb.append(", score=").append(score);
    sb.append('}');

    return sb.toString();
  }
} // end class TreatmentCandidate
