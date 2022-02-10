package com.cmc.credagility.core.domain.homeequity;

import java.io.Serializable;

import java.math.BigDecimal;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.survey.SurveyActivity;
import com.cmc.credagility.core.domain.type.CTMBorrowerIndicator;
import com.cmc.credagility.core.domain.type.CTMRefinanceIndicator;
import com.cmc.credagility.core.domain.type.CTMResidenceIndicator;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to present the Survey information.
 *
 * <p><a href="HomeEquityRefiSurvey.java.html"><i>View Source</i></a></p>
 *
 * @author   Karthik Palanivelu
 *
 *           <p>table = "HomeEquityRefiSurvey"</p>
 * @version  10/15/2014 13:37
 */
@Entity
@Table(name = "HomeEquityRefiSurvey")
public class HomeEquityRefiSurvey extends BaseEntity implements Serializable {
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
  // npelleti, 08/02, USBank, Added NotNull Annotation and unique constraint
  @JoinColumn(
    name     = "accountNum",
    nullable = false /*, unique = true*/
  )
  @OneToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @Column(name = "balance")
  protected BigDecimal balance;

  /** borrower Type. */
  @Column(
    name   = "borrowerType",
    length = 3
  )
  protected String borrowerType;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "emailAddress",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean emailAddress;

  // npelleti, 07/30, USBank Removed unique key constraint.
  /** id PK. */
  @Column(
    name     = "id", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Amount to Borrow. */
  @Column(name = "loanAmount")
  protected BigDecimal loanAmount;

// npelleti, 08/02, USBank, Added NotNull Annotation
  /** Monthly Living expense. */
  @Column(
    name      = "monthlyLivingExpense",
    nullable  = false,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal monthlyLivingExpense;

  /** Property Type. */
  @Column(
    name   = "propertyType",
    length = 30
  )
  protected String propertyType;


  /** Refi Type. */
  @Column(
    name   = "refiType",
    length = 3
  )
  protected String refiType;

  /** Residence Type. */
  @Column(
    name   = "residenceType",
    length = 3
  )
  protected String residenceType;

  // npelleti, 08/02, USBank, Added NotNull Annotation and Unique constraint
  /** Responsible id. */
  @JoinColumn(
    name     = "responsibleId",
    nullable = false /*, unique = true*/
  )
  @OneToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** Monthly household income. */
  // protected BigDecimal monthlyHouseholdIncome;
  /** Annual household income. */
  @Column(name = "totalAnnualIncome")
  protected BigDecimal totalAnnualIncome;

  /** Estimated value of Property. */
  @Column(name = "valueOfProperty")
  protected BigDecimal valueOfProperty;

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

    final HomeEquityRefiSurvey other = (HomeEquityRefiSurvey) obj;

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
   * String.
   *
   * @return  String.
   *
   *          <p>not-null = "false" length = "3"</p>
   */
  public String getBorrowerType() {
    return borrowerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Returns a Yes/No value whether this offer has a Email Address entered by a Customer.
   *
   * <p>type = "yes_no"</p>
   *
   * @return  Boolean
   */
  public Boolean getEmailAddress() {
    return emailAddress;
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
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getLoanAmount() {
    return loanAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  //
  // /**
  // * @return the monthlyHouseholdIncome
  // *  not-null="true"
  // */
  // public BigDecimal getMonthlyHouseholdIncome() {
  // return monthlyHouseholdIncome;
  // }
  //
  // /**
  // * @param monthlyHouseholdIncome
  // * the monthlyHouseholdIncome to set
  // */
  // public void setMonthlyHouseholdIncome(BigDecimal monthlyHouseholdIncome) {
  // this.monthlyHouseholdIncome = monthlyHouseholdIncome;
  // }

  /**
   * The.
   *
   * @return  the
   *
   *          <p>not-null = "true"</p>
   */
  public BigDecimal getMonthlyLivingExpense() {
    return monthlyLivingExpense;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>not-null = "false" length = "30"</p>
   */

  public String getPropertyType() {
    return propertyType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>not-null = "false" length = "3"</p>
   */
  public String getRefiType() {
    return refiType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   *
   *          <p>not-null = "false" length = "3"</p>
   */

  public String getResidenceType() {
    return residenceType;
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
    surveyActivity.setQuestionId(20L);
    surveyActivity.setData1(CTMRefinanceIndicator.toCTMRefinanceIndicator(
        this.refiType).getDescription());
    surveyActivities.add(surveyActivity);

    surveyActivity = new SurveyActivity();
    surveyActivity.setCreateDate(this.createDate);
    surveyActivity.setBalance(this.balance);
    surveyActivity.setQuestionId(21L);
    surveyActivity.setData1(CTMBorrowerIndicator.toCTMBorrowerIndicator(
        this.borrowerType).getDescription());
    surveyActivities.add(surveyActivity);

    surveyActivity = new SurveyActivity();
    surveyActivity.setCreateDate(this.createDate);
    surveyActivity.setBalance(this.balance);
    surveyActivity.setQuestionId(22L);
    surveyActivity.setData1(df.format(this.totalAnnualIncome));
    surveyActivities.add(surveyActivity);

    surveyActivity = new SurveyActivity();
    surveyActivity.setCreateDate(this.createDate);
    surveyActivity.setBalance(this.balance);
    surveyActivity.setQuestionId(23L);
    surveyActivity.setData1(df.format(this.monthlyLivingExpense));
    surveyActivities.add(surveyActivity);

    surveyActivity = new SurveyActivity();
    surveyActivity.setCreateDate(this.createDate);
    surveyActivity.setBalance(this.balance);
    surveyActivity.setQuestionId(24L);
    surveyActivity.setData1(df.format(this.valueOfProperty));
    surveyActivities.add(surveyActivity);

    surveyActivity = new SurveyActivity();
    surveyActivity.setCreateDate(this.createDate);
    surveyActivity.setBalance(this.balance);
    surveyActivity.setQuestionId(25L);
    surveyActivity.setData1(df.format(this.loanAmount));
    surveyActivities.add(surveyActivity);

    surveyActivity = new SurveyActivity();
    surveyActivity.setCreateDate(this.createDate);
    surveyActivity.setBalance(this.balance);
    surveyActivity.setQuestionId(26L);
    surveyActivity.setData1(df.format(
        CTMResidenceIndicator.toCTMResidenceIndicator(this.residenceType).getDescription()));
    surveyActivities.add(surveyActivity);

    surveyActivity = new SurveyActivity();
    surveyActivity.setCreateDate(this.createDate);
    surveyActivity.setBalance(this.balance);
    surveyActivity.setQuestionId(27L);
    surveyActivity.setData1(df.format(this.propertyType));
    surveyActivities.add(surveyActivity);

    return surveyActivities;
  } // end method getSurveyActivities

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getTotalAnnualIncome() {
    return totalAnnualIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getValueOfProperty() {
    return valueOfProperty;
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
   * setter method for borrower type.
   *
   * @param  borrowerType  String
   */
  public void setBorrowerType(String borrowerType) {
    this.borrowerType = borrowerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setEmailAddress.
   *
   * @param  emailAddress  $param.type$
   */
  public void setEmailAddress(Boolean emailAddress) {
    this.emailAddress = emailAddress;
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
   * setter method for loan amount.
   *
   * @param  loanAmount  BigDecimal
   */
  public void setLoanAmount(BigDecimal loanAmount) {
    this.loanAmount = loanAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setMonthlyLivingExpense.
   *
   * @param  monthlyLivingExpense  the to set
   */
  public void setMonthlyLivingExpense(BigDecimal monthlyLivingExpense) {
    this.monthlyLivingExpense = monthlyLivingExpense;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for property type.
   *
   * @param  propertyType  String
   */
  public void setPropertyType(String propertyType) {
    this.propertyType = propertyType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for refi type.
   *
   * @param  refiType  String
   */
  public void setRefiType(String refiType) {
    this.refiType = refiType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for residence type.
   *
   * @param  residenceType  String
   */
  public void setResidenceType(String residenceType) {
    this.residenceType = residenceType;
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
   * setter method for total annual income.
   *
   * @param  totalAnnualIncome  BigDecimal
   */
  public void setTotalAnnualIncome(BigDecimal totalAnnualIncome) {
    this.totalAnnualIncome = totalAnnualIncome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value of property.
   *
   * @param  valueOfProperty  BigDecimal
   */
  public void setValueOfProperty(BigDecimal valueOfProperty) {
    this.valueOfProperty = valueOfProperty;
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
      "acceptedByAgent = ").append(this.acceptedByAgent).append(TAB).append("id = ").append(this.id).append(TAB).append(
      "monthlyHouseholdIncome = ").append(this.totalAnnualIncome).append(
      TAB).append("loanAmount = ").append(this.loanAmount).append(TAB).append("monthlyLivingExpense = ").append(
      this.monthlyLivingExpense).append(TAB).append("borrowerType = ").append(this.borrowerType).append(TAB).append(
      "ResidenceType = ").append(this.residenceType).append(TAB).append("Refi Type = ").append(this.refiType).append(
      TAB).append("responsibleId = ").append(this.responsible).append(TAB).append("ValueOfProperty = ").append(
      this.valueOfProperty).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class HomeEquityRefiSurvey
