package com.cmc.credagility.core.domain.homeequity;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Convert;
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
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.Treatment;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to present the Accept treatment information.
 *
 * <p><a href="HomeEquityAcceptedTreatment.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 *
 *           <p>table = "HomeEquityAcceptedTreatment"</p>
 * @version  10/15/2014 13:30
 */
@Entity
@Table(
  name              = "HomeEquityAcceptedTreatment",
  uniqueConstraints = { @UniqueConstraint(columnNames = "responsibleId") }
)
public class HomeEquityAcceptedTreatment extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6091045659821147027L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "acceptedByAgent",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean acceptedByAgent;

  /** Account. */
  @JoinColumn(
    name     = "accountNum",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** id PK. */
  // npelleti, 07/30, USBank, Removed unique constraint
  @Column(
    name     = "id", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** MAPR. */
  @Column(
    name     = "MAPR",
    nullable = false
  )
  protected BigDecimal MAPR;

  /** principal reduction. */
  @Column(
    name     = "principalReduction",
    nullable = false
  )
  protected BigDecimal principalReduction;

  /** Rate. */
  @Column(
    name     = "rate",
    nullable = false
  )
  protected BigDecimal rate;

  /** Responsible. */
  @JoinColumn(
    name     = "responsibleId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** term. */
  @Column(
    name     = "term",
    nullable = false
  )
  protected Integer term;

  // npelleti, 07/30, USBank, Added NotNull Annotation
  /** treatment type. */
  @Column(
    name     = "treatment",
    nullable = false,
    length   = 2
  )
  @Enumerated(value = EnumType.STRING)
  protected Treatment treatment;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final HomeEquityAcceptedTreatment other = (HomeEquityAcceptedTreatment) obj;

    if (responsible == null) {
      if (other.responsible != null) {
        return false;
      }
    } else if (!responsible.getResponsibleId().equals(
            other.responsible.getResponsibleId())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns a Yes/No value whether this offer is accepted by agent on behalf of customer.
   *
   * <p>type = "yes_no"</p>
   *
   * @return  Boolean
   */
  public Boolean getAcceptedByAgent() {
    return acceptedByAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The account.
   *
   * @return  the account
   *
   *          <p>column = "accountNum" class = "com.cmc.credagility.Account" insert = "true" update = "true" cascade =
   *          "none" not-null = "true"</p>
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The id.
   *
   * @return  the id
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The MAPR.
   *
   * @return  the MAPR
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getMAPR() {
    return MAPR;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The principalReduction.
   *
   * @return  the principalReduction
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getPrincipalReduction() {
    return principalReduction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The rate.
   *
   * @return  the rate
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getRate() {
    return rate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The responsible.
   *
   * @return  the responsible
   *
   *          <p>unique = "true" column = "responsibleId" class = "com.cmc.credagility.Responsible" insert = "true"
   *          update = "true" not-null = "true"</p>
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The term.
   *
   * @return  the term
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getTerm() {
    return term;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The treatment.
   *
   * @return  the treatment
   *
   *          <p>not-null = "true" length = "2" type = "com.cmc.dao.hibernate.support.TreatmentUserType"</p>
   */
  public Treatment getTreatment() {
    return treatment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime
        * result)
      + ((responsible == null) ? 0 : responsible.getResponsibleId().hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Sets the acceptedByAgent property.
   *
   * @param  acceptedByAgent  $param.type$
   */
  public void setAcceptedByAgent(Boolean acceptedByAgent) {
    this.acceptedByAgent = acceptedByAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAccount.
   *
   * @param  account  the account to set
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setId.
   *
   * @param  id  the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Sets the value to MAPR.
   *
   * @param  mapr  $param.type$
   */
  public void setMAPR(BigDecimal mapr) {
    MAPR = mapr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPrincipalReduction.
   *
   * @param  principalReduction  the principalReduction to set
   */
  public void setPrincipalReduction(BigDecimal principalReduction) {
    this.principalReduction = principalReduction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setRate.
   *
   * @param  rate  the rate to set
   */
  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setResponsible.
   *
   * @param  responsible  the responsible to set
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTerm.
   *
   * @param  term  the term to set
   */
  public void setTerm(Integer term) {
    this.term = term;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTreatment.
   *
   * @param  treatment  the treatment to set
   */
  public void setTreatment(Treatment treatment) {
    this.treatment = treatment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("HomeEquityAcceptedTreatment ( ").append(super.toString()).append(TAB).append("accountNum = ")
      .append(this.account).append(TAB).append("id = ").append(this.id).append(TAB).append(
      "principalReduction = ").append(this.principalReduction).append(TAB).append("rate = ").append(this.rate).append(
      TAB).append(
      "responsibleId = ").append(this.responsible).append(TAB).append(
      "term = ").append(this.term).append(TAB).append("treatment = ").append(this.treatment).append(TAB).append(" )");

    return retValue.toString();
  }

} // end class HomeEquityAcceptedTreatment
