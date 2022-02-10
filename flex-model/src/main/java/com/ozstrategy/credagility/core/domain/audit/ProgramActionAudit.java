package com.ozstrategy.credagility.core.domain.audit;

import com.cmc.credagility.core.domain.payment.PaymentProgramType;
import com.cmc.credagility.core.domain.type.RoundType;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.AbstractActionAudit;
import com.ozstrategy.credagility.core.domain.ProgramAction;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Program Action Audit.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 17:19
 */
@Entity public class ProgramActionAudit extends AbstractActionAudit {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** agent Program Text. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String agentProgramText;


  /** allow Eager Payment. */
  @Column(
    name             = "allowEagerPayment",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowEagerPayment;

  /** Allowed Payment Date Range. */
  @Column(
    columnDefinition = "LONGTEXT",
    nullable         = false
  )
  @Lob protected String allowedPaymentDateRange = "1";

  /** duplicate Count. */
  @Column(nullable = true)
  protected Integer duplicateCount = 0;

  /** Payment duration. */
  @Column(
    nullable         = false,
    columnDefinition = "LONGTEXT"
  )
  @Lob protected String duration;

  /** Fix Fee amount. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String fixedFeeAmount = "0.00";


  /** Payment frequency, null is monthly. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String frequency;

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** installment Date Tolerence! */
  @Column(
    columnDefinition = "LONGTEXT",
    nullable         = false
  )
  @Lob protected String installmentDateTolerence = "1";


  /** installment Dollar Tolerence. */
  @Column(
    columnDefinition = "LONGTEXT",
    nullable         = false
  )
  @Lob protected String installmentDollarTolerence = new String("1.00");


  /** default:'totalAmount', otherwise:'individual'. */
  @Column(
    length   = 16,
    nullable = false
  )
  protected String installmentTermSelect = "totalAmount";

  /** Program valid days upon it was created. */
  @Column(
    columnDefinition = "LONGTEXT",
    nullable         = false
  )
  @Lob protected String programValidDays = "30";


  /** Required Payment. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String requiredPayments;


  /** required PTPs. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String requiredPTPs;


  /** round Type. */
  @Column(length = 255)
  @Enumerated(EnumType.STRING)
  protected RoundType roundType = RoundType.CENTS_UP;


  /** start Date Expression. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String startDateExpression = "today";


  /** totalAmount Expression. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String totalAmountExpression;


  /** Payment Program Type. */
  @JoinColumn(
    name     = "programTypeId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentProgramType type = new PaymentProgramType();


  /** web Detail ProgramText! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String webDetailProgramText;


  /** web Offer. */
  @Column(
    name             = "webOffer",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean webOffer;


  /** web SummaryProgram Text. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String webSummaryProgramText;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ProgramActionAudit object.
   */
  public ProgramActionAudit() { }

  /**
   * Creates a new ProgramActionAudit object.
   *
   * @param  action  ProgramAction
   * @param  type    AuditType
   */
  public ProgramActionAudit(ProgramAction action, AuditType type) {
    super(action, type);
    this.agentProgramText           = action.getAgentProgramText();
    this.allowEagerPayment          = action.getAllowEagerPayment();
    this.allowedPaymentDateRange    = action.getAllowedPaymentDateRange();
    this.duplicateCount             = action.getDuplicateCount();
    this.duration                   = action.getDuration();
    this.fixedFeeAmount             = action.getFixedFeeAmount();
    this.frequency                  = action.getFrequency();
    this.installmentDateTolerence   = action.getInstallmentDateTolerence();
    this.installmentDollarTolerence = action.getInstallmentDollarTolerence();
    this.installmentTermSelect      = action.getInstallmentTermSelect();
    this.programValidDays           = action.getProgramValidDays();
    this.requiredPayments           = action.getRequiredPayments();
    this.requiredPTPs               = action.getRequiredPTPs();
    this.startDateExpression        = action.getStartDateExpression();
    this.totalAmountExpression      = action.getTotalAmountExpression();
    this.roundType                  = action.getRoundType();
    this.webDetailProgramText       = action.getWebDetailProgramText();
    this.webOffer                   = action.getWebOffer();
    this.webSummaryProgramText      = action.getWebSummaryProgramText();
    this.type                       = action.getType();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent program text.
   *
   * @return  String
   */
  public String getAgentProgramText() {
    return agentProgramText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow eager payment.
   *
   * @return  Boolean
   */
  public Boolean getAllowEagerPayment() {
    if (allowEagerPayment == null) {
      return Boolean.FALSE;
    }

    return allowEagerPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allowed payment date range.
   *
   * @return  String
   */
  public String getAllowedPaymentDateRange() {
    return allowedPaymentDateRange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for duplicate count.
   *
   * @return  Integer
   */
  public Integer getDuplicateCount() {
    return duplicateCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for duration.
   *
   * @return  String
   */
  public String getDuration() {
    return duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fixed fee amount.
   *
   * @return  String
   */
  public String getFixedFeeAmount() {
    return fixedFeeAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for frequency.
   *
   * @return  String
   */
  public String getFrequency() {
    return frequency;
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
   * getter method for installment date tolerence.
   *
   * @return  String
   */
  public String getInstallmentDateTolerence() {
    return installmentDateTolerence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for installment dollar tolerence.
   *
   * @return  String
   */
  public String getInstallmentDollarTolerence() {
    return installmentDollarTolerence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for installment term select.
   *
   * @return  String
   */
  public String getInstallmentTermSelect() {
    return installmentTermSelect;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program valid days.
   *
   * @return  String
   */
  public String getProgramValidDays() {
    return programValidDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for required payments.
   *
   * @return  String
   */
  public String getRequiredPayments() {
    return requiredPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for required PTPs.
   *
   * @return  String
   */
  public String getRequiredPTPs() {
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
   * getter method for start date expression.
   *
   * @return  String
   */
  public String getStartDateExpression() {
    return startDateExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total amount expression.
   *
   * @return  String
   */
  public String getTotalAmountExpression() {
    return totalAmountExpression;
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
   * getter method for web detail program text.
   *
   * @return  String
   */
  public String getWebDetailProgramText() {
    return webDetailProgramText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web offer.
   *
   * @return  Boolean
   */
  public Boolean getWebOffer() {
    if (webOffer == null) {
      return Boolean.FALSE;
    }

    return webOffer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web summary program text.
   *
   * @return  String
   */
  public String getWebSummaryProgramText() {
    return webSummaryProgramText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent program text.
   *
   * @param  agentProgramText  String
   */
  public void setAgentProgramText(String agentProgramText) {
    this.agentProgramText = agentProgramText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow eager payment.
   *
   * @param  allowEagerPayment  Boolean
   */
  public void setAllowEagerPayment(Boolean allowEagerPayment) {
    this.allowEagerPayment = allowEagerPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allowed payment date range.
   *
   * @param  allowedPaymentDateRange  String
   */
  public void setAllowedPaymentDateRange(String allowedPaymentDateRange) {
    this.allowedPaymentDateRange = allowedPaymentDateRange;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for duplicate count.
   *
   * @param  duplicateCount  Integer
   */
  public void setDuplicateCount(Integer duplicateCount) {
    this.duplicateCount = duplicateCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for duration.
   *
   * @param  duration  String
   */
  public void setDuration(String duration) {
    this.duration = duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fixed fee amount.
   *
   * @param  fixedFeeAmount  String
   */
  public void setFixedFeeAmount(String fixedFeeAmount) {
    this.fixedFeeAmount = fixedFeeAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for frequency.
   *
   * @param  frequency  String
   */
  public void setFrequency(String frequency) {
    this.frequency = frequency;
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
   * setter method for installment date tolerence.
   *
   * @param  installmentDateTolerence  String
   */
  public void setInstallmentDateTolerence(String installmentDateTolerence) {
    this.installmentDateTolerence = installmentDateTolerence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for installment dollar tolerence.
   *
   * @param  installmentDollarTolerence  String
   */
  public void setInstallmentDollarTolerence(String installmentDollarTolerence) {
    this.installmentDollarTolerence = installmentDollarTolerence;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for installment term select.
   *
   * @param  installmentTermSelect  String
   */
  public void setInstallmentTermSelect(String installmentTermSelect) {
    this.installmentTermSelect = installmentTermSelect;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program valid days.
   *
   * @param  programValidDays  String
   */
  public void setProgramValidDays(String programValidDays) {
    this.programValidDays = programValidDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for required payments.
   *
   * @param  requiredPayments  String
   */
  public void setRequiredPayments(String requiredPayments) {
    this.requiredPayments = requiredPayments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for required PTPs.
   *
   * @param  requiredPTPs  String
   */
  public void setRequiredPTPs(String requiredPTPs) {
    this.requiredPTPs = requiredPTPs;
  }

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
   * setter method for start date expression.
   *
   * @param  startDateExpression  String
   */
  public void setStartDateExpression(String startDateExpression) {
    this.startDateExpression = startDateExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total amount expression.
   *
   * @param  totalAmountExpression  String
   */
  public void setTotalAmountExpression(String totalAmountExpression) {
    this.totalAmountExpression = totalAmountExpression;
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
   * setter method for web detail program text.
   *
   * @param  webDetailProgramText  String
   */
  public void setWebDetailProgramText(String webDetailProgramText) {
    this.webDetailProgramText = webDetailProgramText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for web offer.
   *
   * @param  webOffer  Boolean
   */
  public void setWebOffer(Boolean webOffer) {
    this.webOffer = webOffer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for web summary program text.
   *
   * @param  webSummaryProgramText  String
   */
  public void setWebSummaryProgramText(String webSummaryProgramText) {
    this.webSummaryProgramText = webSummaryProgramText;
  }
} // end class ProgramActionAudit
