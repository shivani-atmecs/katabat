package com.cmc.credagility.core.domain.program;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.payment.PaymentProgramType;
import com.cmc.credagility.core.domain.schedule.BaseRule;
import com.cmc.credagility.core.domain.type.AmountType;
import com.cmc.credagility.core.domain.type.RoundType;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.cmc.credagility.core.domain.variable.Variable;


/**
 * This class is used to store payment program rule information.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 10:40
 */
@Entity
@Table(name = "ProgramRule")
public class ProgramRule extends BaseRule {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2571042068968270769L;

  /** TODO: DOCUMENT ME! */
  @Transient public static String expressionDelimiter = "|";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Allowed Payment Date Range. */
  @Column(
    name     = "allowedPaymentDateRange",
    nullable = false
  )
  protected Integer allowedPaymentDateRange = 1;

  /** Installment details. */
  @Column(
    columnDefinition = "LONGTEXT",
    name             = "amountExpressions"
  )
  @Lob protected String amountExpressions;

  /** Installment details. */
  @Column(
    columnDefinition = "LONGTEXT",
    name             = "amountExpressions2"
  )
  @Lob protected String amountExpressions2;

  // npelleti, 07/30, USBank, Added NotNull Annotation
  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "amountType", /*nullable=false,*/
    length = 255
  )
  @Enumerated(value = EnumType.STRING)
  protected AmountType amountType = AmountType.TOTAL_AMOUNT;

  /** Payment duration. */
  @Column(
    name     = "duration",
    nullable = false
  )
  protected Integer duration;

  /** Fix Fee amount. */
  @Column(name = "fixedFeeAmount")
  protected BigDecimal fixedFeeAmount = new BigDecimal(
      "0.00");

  /** Payment frequency, null is monthly. */
  @Column(
    name   = "frequency",
    length = 255
  )
  protected Integer frequency;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "installmentDateTolerence",
    nullable = false
  )
  protected Integer installmentDateTolerence = 1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "installmentDollarTolerence",
    nullable = false
  )
  protected BigDecimal installmentDollarTolerence = new BigDecimal(
      "1.00");

  /** Percentage of principal. */
  @Column(
    name      = "percentage",
    precision = 19,
    scale     = 4,
    nullable  = false
  )
  protected BigDecimal percentage;

  /**
   * The principal type used to calculate the payment amount. Could be totalDue, pastDue, currentDue, overLimit,
   * balance, etc.
   */
  @Column(
    name     = "principalType",
    nullable = false,
    length   = 64
  )
  protected String principalType;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "scheduleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected ProgramSchedule programSchedule = new ProgramSchedule();

  /** Program valid days upon it was created. */
  // npelleti, 07/30, USBank, Added NotNull Annotation
  @Column(
    name   = "programValidDays", /*nullable=false,*/
    length = 11
  )
  protected Integer programValidDays = 30;

  /** Required Payment. */
  @Column(name = "requiredPayments")
  protected Integer requiredPayments;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer requiredPTPs;

  // npelleti, 07/30, USBank, Added NotNull Annotation
  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "roundType", /*nullable=false,*/
    length = 255
  )
  @Enumerated(value = EnumType.STRING)
  protected RoundType roundType = RoundType.CENTS_UP;

  /** Rule Id, PK. */
  @Column(
    name     = "ruleId",

    /*unique   = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long ruleId;

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String startDateExpression = "today";


  /** Payment Program Type. */
  @JoinColumn(
    name     = "programTypeId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected PaymentProgramType type = new PaymentProgramType();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Business equals does not care about the createDate. Only to check if two schedule are the identical from business
   * perspective. This is perfect for dirty check when update schedule
   *
   * @param   obj  DOCUMENT ME!
   *
   * @return  business equals does not care about the createDate.
   */
  public boolean businessEquals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (this.equals(obj)) {
      return true;
    }

    ProgramRule other = (ProgramRule) obj;

    if (type == null) {
      if (other.type != null) {
        return false;
      }
    } else if (!type.equals(other.type)) {
      return false;
    }

    if (duration == null) {
      if (other.duration != null) {
        return false;
      }
    } else if (!duration.equals(other.duration)) {
      return false;
    }

    if (frequency == null) {
      if (other.frequency != null) {
        return false;
      }
    } else if (!frequency.equals(other.frequency)) {
      return false;
    }

    if (requiredPayments == null) {
      if (other.requiredPayments != null) {
        return false;
      }
    } else if (!requiredPayments.equals(other.requiredPayments)) {
      return false;
    }

    if (amountExpressions == null) {
      if (other.amountExpressions != null) {
        return false;
      }
    } else if (!amountExpressions.equals(other.amountExpressions)) {
      return false;
    }

    if (startDateExpression == null) {
      if (other.startDateExpression != null) {
        return false;
      }
    } else if (!startDateExpression.equals(other.startDateExpression)) {
      return false;
    }

    if (fixedFeeAmount == null) {
      if (other.fixedFeeAmount != null) {
        return false;
      }
    } else if (fixedFeeAmount.compareTo(other.fixedFeeAmount) != 0) {
      return false;
    }

    if (percentage == null) {
      if (other.percentage != null) {
        return false;
      }
    } else if (percentage.compareTo(other.percentage) != 0) {
      return false;
    }

    if (allowedPaymentDateRange == null) {
      if (other.allowedPaymentDateRange != null) {
        return false;
      }
    } else if (allowedPaymentDateRange.compareTo(other.allowedPaymentDateRange) != 0) {
      return false;
    }

    if (installmentDateTolerence == null) {
      if (other.installmentDateTolerence != null) {
        return false;
      }
    } else if (installmentDateTolerence.compareTo(other.installmentDateTolerence) != 0) {
      return false;
    }

    if (installmentDollarTolerence == null) {
      if (other.installmentDollarTolerence != null) {
        return false;
      }
    } else if (installmentDollarTolerence.compareTo(other.installmentDollarTolerence) != 0) {
      return false;
    }

    return true;
  } // end method businessEquals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Copy criteria only rule.
   *
   * @param  other  DOCUMENT ME!
   */
  public void copyCriteria(ProgramRule other) {
    super.deepCopy(other);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Copy from other rule.
   *
   * @param  o  other DOCUMENT ME!
   */
  @Override public void deepCopy(BaseRule o) {
    ProgramRule other = (ProgramRule) o;
    super.deepCopy(other);

    this.type = other.getType();

    if (other.getDuration() != null) {
      this.duration = new Integer(other.getDuration());
    } else {
      this.duration = null;
    }

    if (other.getFrequency() != null) {
      this.frequency = new Integer(other.getFrequency());
    } else {
      this.frequency = null;
    }

    if (other.getRequiredPayments() != null) {
      this.requiredPayments = new Integer(other.getRequiredPayments());
    } else {
      this.requiredPayments = null;
    }

    if (other.getRequiredPTPs() != null) {
      this.requiredPTPs = new Integer(other.getRequiredPTPs());
    } else {
      this.requiredPTPs = null;
    }

    this.startDateExpression = other.getStartDateExpression();
    this.amountExpressions   = other.getAmountExpressions();
    this.amountExpressions2  = other.getAmountExpressions2();
    this.percentage          = other.getPercentage();
    this.principalType       = other.getPrincipalType();
    this.fixedFeeAmount      = other.getFixedFeeAmount();

    if (other.getProgramValidDays() != null) {
      this.programValidDays = other.getProgramValidDays().intValue();
    } else {
      this.programValidDays = null;
    }

    if (other.getAllowedPaymentDateRange() != null) {
      this.allowedPaymentDateRange = other.getAllowedPaymentDateRange().intValue();
    } else {
      this.allowedPaymentDateRange = null;
    }

    if (other.getInstallmentDateTolerence() != null) {
      this.installmentDateTolerence = other.getInstallmentDateTolerence().intValue();
    } else {
      this.installmentDateTolerence = null;
    }

    if (other.getInstallmentDollarTolerence() != null) {
      this.installmentDollarTolerence = other.getInstallmentDollarTolerence();
    } else {
      this.installmentDollarTolerence = null;
    }

    this.amountType = other.amountType;
    this.roundType  = other.roundType;
  } // end method deepCopy

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseRule#equals(java.lang.Object)
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

    ProgramRule that = (ProgramRule) o;

    if ((allowedPaymentDateRange != null) ? (!allowedPaymentDateRange.equals(that.allowedPaymentDateRange))
                                          : (that.allowedPaymentDateRange != null)) {
      return false;
    }

    if ((amountExpressions != null) ? (!amountExpressions.equals(that.amountExpressions))
                                    : (that.amountExpressions != null)) {
      return false;
    }

    if ((amountExpressions2 != null) ? (!amountExpressions2.equals(that.amountExpressions2))
                                     : (that.amountExpressions2 != null)) {
      return false;
    }

    if (amountType != that.amountType) {
      return false;
    }

    if ((duration != null) ? (!duration.equals(that.duration)) : (that.duration != null)) {
      return false;
    }

    if ((fixedFeeAmount != null) ? (!fixedFeeAmount.equals(that.fixedFeeAmount)) : (that.fixedFeeAmount != null)) {
      return false;
    }

    if ((frequency != null) ? (!frequency.equals(that.frequency)) : (that.frequency != null)) {
      return false;
    }

    if ((installmentDateTolerence != null) ? (!installmentDateTolerence.equals(that.installmentDateTolerence))
                                           : (that.installmentDateTolerence != null)) {
      return false;
    }

    if ((installmentDollarTolerence != null) ? (!installmentDollarTolerence.equals(that.installmentDollarTolerence))
                                             : (that.installmentDollarTolerence != null)) {
      return false;
    }

    if ((percentage != null) ? (!percentage.equals(that.percentage)) : (that.percentage != null)) {
      return false;
    }

    if ((principalType != null) ? (!principalType.equals(that.principalType)) : (that.principalType != null)) {
      return false;
    }

    if ((programValidDays != null) ? (!programValidDays.equals(that.programValidDays))
                                   : (that.programValidDays != null)) {
      return false;
    }

    if ((requiredPayments != null) ? (!requiredPayments.equals(that.requiredPayments))
                                   : (that.requiredPayments != null)) {
      return false;
    }

    if (roundType != that.roundType) {
      return false;
    }

    if ((startDateExpression != null) ? (!startDateExpression.equals(that.startDateExpression))
                                      : (that.startDateExpression != null)) {
      return false;
    }

    if ((type != null) ? (!type.equals(that.type)) : (that.type != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allowed payment date range.
   *
   * @return  Integer
   */
  public Integer getAllowedPaymentDateRange() {
    return allowedPaymentDateRange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for amount expressions.
   *
   * @return  String
   */
  public String getAmountExpressions() {
    return amountExpressions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for amount expressions2.
   *
   * @return  String
   */
  public String getAmountExpressions2() {
    return amountExpressions2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for amount type.
   *
   * @return  AmountType
   */
  public AmountType getAmountType() {
    return amountType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for duration.
   *
   * @return  Integer
   */
  public Integer getDuration() {
    return duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fixed fee amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFixedFeeAmount() {
    return fixedFeeAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseRule#getForceMapping()
   */
  @Override public Map<String, String> getForceMapping() {
    Map<String, String> mapping = new HashMap<String, String>();
    mapping.put("calculatedFinalInstallmentDueDate",
      "calculatedFinalInstallmentDueDate(" + getFrequency() + ", " + getDuration() + ")");

    return mapping;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseRule#getForceMappingVariable()
   */
  @Override public Map<String, BaseVariable> getForceMappingVariable() {
    Map<String, BaseVariable> mapping      = new HashMap<String, BaseVariable>();
    BaseVariable              baseVariable = new Variable();
    baseVariable.setName("calculatedFinalInstallmentDueDate");
    baseVariable.setDataType("Date");
    baseVariable.setBusinessDataType("Date");
    baseVariable.setBuildType("evel");
    baseVariable.setCategory("forceMapping");
    baseVariable.setExpression("getCalculatedFinalInstallmentDueDate(" + getFrequency() + ", " + getDuration() + ")");

    mapping.put("calculatedFinalInstallmentDueDate", baseVariable);

    return mapping;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for frequency.
   *
   * @return  Integer
   */
  public Integer getFrequency() {
    return frequency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for installment date tolerence.
   *
   * @return  Integer
   */
  public Integer getInstallmentDateTolerence() {
    return installmentDateTolerence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for installment dollar tolerence.
   *
   * @return  BigDecimal
   */
  public BigDecimal getInstallmentDollarTolerence() {
    return installmentDollarTolerence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * In theory, this percentage equals programAmount divided by principalWhenCreated. In practice, when we strategize a
   * payment program, we specify the percentage. However, However the totlAmount may not be divisible by the duration.
   * Say, if balance is $1,000 and we want to offer a 70% settlement and a duration of 3. Then we get $700/3 =
   * $233.33333333... So in practice, we re-adjust the program: 1. Mathmatically round installment amount of
   * $233.33333333... to $233.33 2. Readjust the total amount to $233.33 * 3 = $699.99 (not $700 any more) 3. Keep the
   * percentage as 70% (no need to adjust to 69.99%)
   *
   * @return  in theory, this percentage equals programAmount divided by principalWhenCreated.
   */
  public BigDecimal getPercentage() {
    return percentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the type of the principalWhenCreated used to calculate the total amount of the program. Could be
   *          "balance", "totalDue", etc.
   */
  public String getPrincipalType() {
    return principalType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program schedule.
   *
   * @return  ProgramSchedule
   */
  public ProgramSchedule getProgramSchedule() {
    return programSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program valid days.
   *
   * @return  Integer
   */
  public Integer getProgramValidDays() {
    return programValidDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for required payments.
   *
   * @return  Integer
   */
  public Integer getRequiredPayments() {
    if (requiredPayments == null) {
      requiredPayments = duration;
    }

    return requiredPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for required PTPs.
   *
   * @return  Integer
   */
  public Integer getRequiredPTPs() {
    return requiredPTPs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for round type.
   *
   * @return  RoundType
   */
  public RoundType getRoundType() {
    return roundType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseRule#getRuleId()
   */
  @Override public Long getRuleId() {
    return ruleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseRule#getRuleType()
   */
  @Override public String getRuleType() {
    return "ProgramRule";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for start date expression.
   *
   * @return  String
   */
  public String getStartDateExpression() {
    return startDateExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  PaymentProgramType
   */
  public PaymentProgramType getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseRule#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((allowedPaymentDateRange != null) ? allowedPaymentDateRange.hashCode() : 0);
    result = (31 * result) + ((amountExpressions != null) ? amountExpressions.hashCode() : 0);
    result = (31 * result) + ((amountExpressions2 != null) ? amountExpressions2.hashCode() : 0);
    result = (31 * result) + ((duration != null) ? duration.hashCode() : 0);
    result = (31 * result) + ((fixedFeeAmount != null) ? fixedFeeAmount.hashCode() : 0);
    result = (31 * result) + ((frequency != null) ? frequency.hashCode() : 0);
    result = (31 * result) + ((installmentDateTolerence != null) ? installmentDateTolerence.hashCode() : 0);
    result = (31 * result) + ((installmentDollarTolerence != null) ? installmentDollarTolerence.hashCode() : 0);
    result = (31 * result) + ((percentage != null) ? percentage.hashCode() : 0);
    result = (31 * result) + ((principalType != null) ? principalType.hashCode() : 0);
    result = (31 * result) + ((programValidDays != null) ? programValidDays.hashCode() : 0);
    result = (31 * result) + ((requiredPayments != null) ? requiredPayments.hashCode() : 0);
    result = (31 * result) + ((startDateExpression != null) ? startDateExpression.hashCode() : 0);
    result = (31 * result) + ((type != null) ? type.hashCode() : 0);
    result = (31 * result) + ((amountType != null) ? amountType.hashCode() : 0);
    result = (31 * result) + ((roundType != null) ? roundType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allowed payment date range.
   *
   * @param  allowedPaymentDateRange  Integer
   */
  public void setAllowedPaymentDateRange(Integer allowedPaymentDateRange) {
    this.allowedPaymentDateRange = allowedPaymentDateRange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for amount expressions.
   *
   * @param  amountExpressions  String
   */
  public void setAmountExpressions(String amountExpressions) {
    this.amountExpressions = amountExpressions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for amount expressions2.
   *
   * @param  amountExpressions2  String
   */
  public void setAmountExpressions2(String amountExpressions2) {
    this.amountExpressions2 = amountExpressions2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for amount type.
   *
   * @param  amountType  AmountType
   */
  public void setAmountType(AmountType amountType) {
    this.amountType = amountType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for duration.
   *
   * @param  duration  Integer
   */
  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fixed fee amount.
   *
   * @param  fixedFeeAmount  BigDecimal
   */
  public void setFixedFeeAmount(BigDecimal fixedFeeAmount) {
    this.fixedFeeAmount = fixedFeeAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for frequency.
   *
   * @param  frequency  Integer
   */
  public void setFrequency(Integer frequency) {
    this.frequency = frequency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for installment date tolerence.
   *
   * @param  installmentDateTolerence  Integer
   */
  public void setInstallmentDateTolerence(Integer installmentDateTolerence) {
    this.installmentDateTolerence = installmentDateTolerence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for installment dollar tolerence.
   *
   * @param  installmentDollarTolerence  BigDecimal
   */
  public void setInstallmentDollarTolerence(BigDecimal installmentDollarTolerence) {
    this.installmentDollarTolerence = installmentDollarTolerence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for percentage.
   *
   * @param  percentage  BigDecimal
   */
  public void setPercentage(BigDecimal percentage) {
    this.percentage = percentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for principal type.
   *
   * @param  principalType  String
   */
  public void setPrincipalType(String principalType) {
    this.principalType = principalType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program schedule.
   *
   * @param  programSchedule  ProgramSchedule
   */
  public void setProgramSchedule(ProgramSchedule programSchedule) {
    this.programSchedule = programSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program valid days.
   *
   * @param  programValidDays  Integer
   */
  public void setProgramValidDays(Integer programValidDays) {
    this.programValidDays = programValidDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for required payments.
   *
   * @param  requiredPayments  Integer
   */
  public void setRequiredPayments(Integer requiredPayments) {
    this.requiredPayments = requiredPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for required PTPs.
   *
   * @param  requiredPTPs  Integer
   */
  public void setRequiredPTPs(Integer requiredPTPs) {
    this.requiredPTPs = requiredPTPs;
  }
  // npelleti, 07/30, USBank, Removed unique constraint

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for round type.
   *
   * @param  roundType  RoundType
   */
  public void setRoundType(RoundType roundType) {
    this.roundType = roundType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule id.
   *
   * @param  ruleId  Long
   */
  public void setRuleId(Long ruleId) {
    this.ruleId = ruleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for start date expression.
   *
   * @param  startDateExpression  String
   */
  public void setStartDateExpression(String startDateExpression) {
    this.startDateExpression = startDateExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type.
   *
   * @param  type  PaymentProgramType
   */
  public void setType(PaymentProgramType type) {
    this.type = type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseRule#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("ruleId = ").append(this.ruleId).append("ProgramRule ( ").append(super.toString()).append(TAB)
      .append("duration = ").append(this.duration).append(TAB).append("frequency = ").append(this.frequency).append(
      TAB).append("requiredPayments = ").append(
      this.requiredPayments).append(TAB).append("amountExpressions = ").append(
      this.amountExpressions).append(TAB).append("fixedFeeAmount = ").append(
      this.fixedFeeAmount).append(TAB).append("percentage = ").append(
      this.percentage).append(TAB).append("principalType = ").append(
      this.principalType).append(TAB).append("programSchedule = ").append(this.programSchedule).append(TAB).append(
      "type = ").append(
      this.type).append(TAB).append(" )");

    return retValue.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update rule form other rule return false if there is no difference return true if there are some difference and
   * update success.
   *
   * @param   programRule  DOCUMENT ME!
   *
   * @return  update rule form other rule return false if there is no difference return true if there are some
   *          difference and update success.
   */
  public boolean updateRule(ProgramRule programRule) {
    // if (!businessEquals(programRule) || !(CompareUtil.nullSafeEquals(this.priority, programRule.priority))) {
    //
    // // there are difference, copy form it
    this.deepCopy(programRule);

    return true;
      // }
      //
      // return false;
  }
} // end class ProgramRule
