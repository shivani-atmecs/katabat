package com.cmc.credagility.core.domain.homeequity;

import java.io.Serializable;

import java.math.BigDecimal;
import java.math.MathContext;

import java.text.DecimalFormat;

import java.util.LinkedHashSet;
import java.util.Set;

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
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.survey.SurveyActivity;
import com.cmc.credagility.core.domain.type.DTI;
import com.cmc.credagility.core.domain.type.HardShip;
import com.cmc.credagility.core.domain.type.MaxPayment;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to present the Survey information.
 *
 * <p><a href="HomeEquitySurvey.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 *
 *           <p>table = "HomeEquitySurvey"</p>
 * @version  10/15/2014 13:41
 */
@Entity
@Table(name = "HomeEquitySurvey")
public class HomeEquitySurvey extends BaseEntity implements Serializable {
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

  /** TODO: DOCUMENT ME! */
  @Column(name = "balance")
  protected BigDecimal balance;

  /** TODO: DOCUMENT ME! */
  @Column(name = "delinquencyDays")
  protected Integer delinquencyDays;

  /** Hard Ship. */
  @Column(name = "hardShip")
  protected Integer hardShip;

  /** id PK. */

  // npelleti, 07/30, USBank, Removed unique constraint
  @Column(
    name     = "id", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Monthly household income. */
  @Column(
    name     = "monthlyHouseholdIncome",
    nullable = false
  )
  protected BigDecimal monthlyHouseholdIncome;

  /** Monthly Living expense. */
  @Column(
    name     = "monthlyLivingExpense",
    nullable = false
  )
  protected BigDecimal monthlyLivingExpense;

  /** Monthly loan payment. */
  @Column(
    name     = "monthlyLoanPayment",
    nullable = false
  )
  protected BigDecimal monthlyLoanPayment;

  /** Payment Difficulty. */
  @Column(
    name             = "paymentDifficulty",
    nullable         = false,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean paymentDifficulty;

  /** Primary Residence. */
  @Column(
    name             = "primaryResidence",
    nullable         = false,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean primaryResidence;

  /** Reason for Difficulty. */
  @Column(name = "reasonForDifficulty")
  protected String reasonForDifficulty;

  /** Responsible id. */
  @JoinColumn(
    name     = "responsibleId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** Self employed. */

  // npelleti, 07/30, USBank, Added NotNull Annotation
  @Column(
    name             = "selfEmployed",
    nullable         = false,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean selfEmployed;

  /** Selling Home. */
  @Column(
    name             = "sellingHome",
    nullable         = false,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean sellingHome;

  /** Terms Agreed. */
  @Column(
    name             = "termsAgreed",
    nullable         = false,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean                      termsAgreed;
  @Transient private Set<SurveyActivity> surveyActivities;

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

    final HomeEquitySurvey other = (HomeEquitySurvey) obj;

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
   *          <p>column = "accountNum" class = "com.cmc.credagility.Account" insert = "true" update = "true" not-null =
   *          "true" cascade = "none"</p>
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getBalance() {
    return balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   *
   *          <p>not-null = "false"</p>
   */
  public Integer getDelinquencyDays() {
    return delinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get DTI.
   *
   * @return  get DTI.
   */
  public Integer getDTI() {
    BigDecimal dti = null;

    if (monthlyHouseholdIncome.intValue() > 0) {
      dti = monthlyLoanPayment.add(monthlyLivingExpense).divide(
          monthlyHouseholdIncome, new MathContext(2));
    } else {
      dti = new BigDecimal(1);
    }

    return dti.intValue();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get DTI type.
   *
   * @return  get DTI type.
   */
  public DTI getDTIType() {
    int dti = getDTI();

    if (dti < 40) {
      return DTI.D1;
    } else if (dti < 50) {
      return DTI.D2;
    } else if (dti < 60) {
      return DTI.D3;
    } else {
      return DTI.D4;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The hardShip.
   *
   * @return  the hardShip
   *
   *          <p>not-null = "false"</p>
   */
  public Integer getHardShip() {
    return hardShip;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The hardShip.
   *
   * @return  the hardShip
   */
  public HardShip getHardShipType() {
    if (hardShip == null) {
      return HardShip.NA;
    } else {
      if (hardShip <= 18) {
        return HardShip.ST;
      } else {
        return HardShip.LT;
      }
    }
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
   * Get max affortable payment.
   *
   * @return  get max affortable payment.
   */
  public BigDecimal getMaxAffortablePayment() {
    BigDecimal currentDue = new BigDecimal(0.00);

    if ((account != null) && (account.getCurrentDue() != null)
          && (account.getCurrentDue().compareTo(currentDue) < 0)) {
      currentDue = account.getCurrentDue();
    }

    BigDecimal maxPayment = monthlyHouseholdIncome.subtract(
        monthlyLivingExpense).add(currentDue).subtract(new BigDecimal("100.00"));

    return maxPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get max payment type.
   *
   * @return  get max payment type.
   */
  public MaxPayment getMaxPaymentType() {
    BigDecimal maxPayment = getMaxAffortablePayment();

    if (maxPayment.compareTo(new BigDecimal(0.00)) < 0) {
      return null;
    } else if (maxPayment.compareTo(new BigDecimal("250.00")) < 0) {
      return MaxPayment.P1;
    } else if (maxPayment.compareTo(new BigDecimal("500.00")) < 0) {
      return MaxPayment.P2;
    } else if (maxPayment.compareTo(new BigDecimal("750.00")) < 0) {
      return MaxPayment.P3;
    } else if (maxPayment.compareTo(new BigDecimal("1000.00")) < 0) {
      return MaxPayment.P4;
    } else {
      return MaxPayment.P5;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The monthlyHouseholdIncome.
   *
   * @return  the monthlyHouseholdIncome
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getMonthlyHouseholdIncome() {
    return monthlyHouseholdIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The mothlyLivingExpense.
   *
   * @return  the mothlyLivingExpense
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getMonthlyLivingExpense() {
    return monthlyLivingExpense;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The monthlyLoanPayment.
   *
   * @return  the monthlyLoanPayment
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getMonthlyLoanPayment() {
    return monthlyLoanPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The paymentDifficulty.
   *
   * @return  the paymentDifficulty
   *
   *          <p>not-null = "true" type = "yes_no"</p>
   */
  public Boolean getPaymentDifficulty() {
    return paymentDifficulty;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The primaryResidence.
   *
   * @return  the primaryResidence
   *
   *          <p>not-null = "true" type = "yes_no"</p>
   */
  public Boolean getPrimaryResidence() {
    return primaryResidence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The reasonForDifficulty.
   *
   * @return  the reasonForDifficulty
   *
   *          <p>not-null = "false"</p>
   */
  public String getReasonForDifficulty() {
    return reasonForDifficulty;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The responsible.
   *
   * @return  the responsible
   *
   *          <p>column = "responsibleId" class = "com.cmc.credagility.Responsible" insert = "true" update = "true"
   *          not-null = "true" cascade = "none"</p>
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The selfEmployed.
   *
   * @return  the selfEmployed
   *
   *          <p>not-null = "true" type = "yes_no"</p>
   */
  public Boolean getSelfEmployed() {
    return selfEmployed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The sellingHome.
   *
   * @return  the sellingHome
   *
   *          <p>not-null = "true" type = "yes_no"</p>
   */
  public Boolean getSellingHome() {
    return sellingHome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey activities.
   *
   * @return  Set
   */
  public Set<SurveyActivity> getSurveyActivities() {
    surveyActivities = new LinkedHashSet<SurveyActivity>();

    DecimalFormat  df             = new DecimalFormat("$###,###,###,###.00");
    SurveyActivity surveyActivity = new SurveyActivity();
    surveyActivity.setCreateDate(this.createDate);
    surveyActivity.setBalance(this.balance);
    surveyActivity.setQuestionId(10L);
    surveyActivity.setData1(df.format(this.monthlyHouseholdIncome));
    surveyActivities.add(surveyActivity);

    surveyActivity = new SurveyActivity();
    surveyActivity.setCreateDate(this.createDate);
    surveyActivity.setBalance(this.balance);
    surveyActivity.setQuestionId(11L);
    surveyActivity.setData1(Boolean.TRUE.equals(this.selfEmployed) ? "Yes" : "No");
    surveyActivities.add(surveyActivity);

    surveyActivity = new SurveyActivity();
    surveyActivity.setCreateDate(this.createDate);
    surveyActivity.setBalance(this.balance);
    surveyActivity.setQuestionId(12L);
    surveyActivity.setData1(df.format(this.monthlyLoanPayment));
    surveyActivities.add(surveyActivity);

    surveyActivity = new SurveyActivity();
    surveyActivity.setCreateDate(this.createDate);
    surveyActivity.setBalance(this.balance);
    surveyActivity.setQuestionId(13L);
    surveyActivity.setData1(df.format(this.monthlyLivingExpense));
    surveyActivities.add(surveyActivity);

    surveyActivity = new SurveyActivity();
    surveyActivity.setCreateDate(this.createDate);
    surveyActivity.setBalance(this.balance);
    surveyActivity.setQuestionId(14L);
    surveyActivity.setData1((Boolean.TRUE.equals(this.paymentDifficulty) ? "Yes" : "No"));
    surveyActivities.add(surveyActivity);

    surveyActivity = new SurveyActivity();
    surveyActivity.setCreateDate(this.createDate);
    surveyActivity.setBalance(this.balance);
    surveyActivity.setQuestionId(15L);
    surveyActivity.setData1(this.reasonForDifficulty);
    surveyActivities.add(surveyActivity);

    surveyActivity = new SurveyActivity();
    surveyActivity.setCreateDate(this.createDate);
    surveyActivity.setBalance(this.balance);
    surveyActivity.setQuestionId(16L);

    String hardShipStr = "";

    if (this.hardShip != null) {
      hardShipStr = this.hardShip.toString();
    }

    surveyActivity.setData1(hardShipStr);
    surveyActivities.add(surveyActivity);

    surveyActivity = new SurveyActivity();
    surveyActivity.setCreateDate(this.createDate);
    surveyActivity.setBalance(this.balance);
    surveyActivity.setQuestionId(17L);
    surveyActivity.setData1((Boolean.TRUE.equals(this.sellingHome) ? "Yes" : "No"));
    surveyActivities.add(surveyActivity);

    surveyActivity = new SurveyActivity();
    surveyActivity.setCreateDate(this.createDate);
    surveyActivity.setBalance(this.balance);
    surveyActivity.setQuestionId(18L);
    surveyActivity.setData1((Boolean.TRUE.equals(this.primaryResidence) ? "Yes" : "No"));
    surveyActivities.add(surveyActivity);

    surveyActivity = new SurveyActivity();
    surveyActivity.setCreateDate(this.createDate);
    surveyActivity.setBalance(this.balance);
    surveyActivity.setQuestionId(19L);
    surveyActivity.setData1((Boolean.TRUE.equals(this.termsAgreed) ? "Yes" : "No"));
    surveyActivities.add(surveyActivity);

    return surveyActivities;
  } // end method getSurveyActivities

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The termsAgreed.
   *
   * @return  the termsAgreed
   *
   *          <p>not-null = "true" type = "yes_no"</p>
   */
  public Boolean getTermsAgreed() {
    return termsAgreed;
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
   * setter method for balance.
   *
   * @param  balance  BigDecimal
   */
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delinquency days.
   *
   * @param  delinquencyDays  Integer
   */
  public void setDelinquencyDays(Integer delinquencyDays) {
    this.delinquencyDays = delinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setHardShip.
   *
   * @param  hardShip  the hardShip to set
   */
  public void setHardShip(Integer hardShip) {
    this.hardShip = hardShip;
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
   * setMonthlyHouseholdIncome.
   *
   * @param  monthlyHouseholdIncome  the monthlyHouseholdIncome to set
   */
  public void setMonthlyHouseholdIncome(BigDecimal monthlyHouseholdIncome) {
    this.monthlyHouseholdIncome = monthlyHouseholdIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setMonthlyLivingExpense.
   *
   * @param  mothlyLivingExpense  the mothlyLivingExpense to set
   */
  public void setMonthlyLivingExpense(BigDecimal mothlyLivingExpense) {
    this.monthlyLivingExpense = mothlyLivingExpense;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setMonthlyLoanPayment.
   *
   * @param  monthlyLoanPayment  the monthlyLoanPayment to set
   */
  public void setMonthlyLoanPayment(BigDecimal monthlyLoanPayment) {
    this.monthlyLoanPayment = monthlyLoanPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPaymentDifficulty.
   *
   * @param  paymentDifficulty  the paymentDifficulty to set
   */
  public void setPaymentDifficulty(Boolean paymentDifficulty) {
    this.paymentDifficulty = paymentDifficulty;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPrimaryResidence.
   *
   * @param  primaryResidence  the primaryResidence to set
   */
  public void setPrimaryResidence(Boolean primaryResidence) {
    this.primaryResidence = primaryResidence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setReasonForDifficulty.
   *
   * @param  reasonForDifficulty  the reasonForDifficulty to set
   */
  public void setReasonForDifficulty(String reasonForDifficulty) {
    this.reasonForDifficulty = reasonForDifficulty;
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
   * setSelfEmployed.
   *
   * @param  selfEmployed  the selfEmployed to set
   */
  public void setSelfEmployed(Boolean selfEmployed) {
    this.selfEmployed = selfEmployed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setSellingHome.
   *
   * @param  sellingHome  the sellingHome to set
   */
  public void setSellingHome(Boolean sellingHome) {
    this.sellingHome = sellingHome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTermsAgreed.
   *
   * @param  termsAgreed  the termsAgreed to set
   */
  public void setTermsAgreed(Boolean termsAgreed) {
    this.termsAgreed = termsAgreed;
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

    retValue.append("HomeEquitySurvey ( ").append(super.toString()).append(TAB).append("accountNum = ").append(
      this.account).append(TAB).append(
      "hardShip = ").append(this.hardShip).append(TAB).append("id = ").append(this.id).append(TAB).append(
      "monthlyHouseholdIncome = ").append(this.monthlyHouseholdIncome).append(TAB).append(
      "monthlyLoanPayment = ").append(this.monthlyLoanPayment).append(TAB).append("mothlyLivingExpense = ").append(
      this.monthlyLivingExpense).append(TAB).append(
      "paymentDifficulty = ").append(this.paymentDifficulty).append(TAB).append("primaryResidence = ").append(
      this.primaryResidence).append(TAB).append("reasonForDifficulty = ").append(
      this.reasonForDifficulty).append(TAB).append("responsibleId = ").append(this.responsible).append(TAB).append(
      "selfEmployed = ").append(
      this.selfEmployed).append(TAB).append("sellingHome = ").append(
      this.sellingHome).append(TAB).append("termsAgreed = ").append(
      this.termsAgreed).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class HomeEquitySurvey
