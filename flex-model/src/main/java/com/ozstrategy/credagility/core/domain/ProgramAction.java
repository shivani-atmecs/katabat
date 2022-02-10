package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.payment.PaymentProgram;
import com.cmc.credagility.core.domain.payment.PaymentProgramInstallment;
import com.cmc.credagility.core.domain.payment.PaymentProgramType;
import com.cmc.credagility.core.domain.type.PaymentProgramMonitoringType;
import com.cmc.credagility.core.domain.type.ProgramStatus;
import com.cmc.credagility.core.domain.type.RoundType;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.cmc.credagility.core.domain.variable.Variable;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;


/**
 * This class is used to store program action information.
 *
 * <p><a href="ProgramAction.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/16/2014 14:12
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "actionNameIndex",
      columnList = "name"
    )
  }
)
public class ProgramAction extends PortfolioBaseNodeAction implements Calculatable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String agentProgramText;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "allowEagerPayment",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowEagerPayment;

  /** Allowed Payment Date Range. */
  @Column(
    nullable         = false,
    columnDefinition = "LONGTEXT"
  )
  @Lob protected String allowedPaymentDateRange = "1";


  /** TODO: DOCUMENT ME! */
  @Transient protected Integer allowedPaymentDateRangeValue = 1;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Integer duplicateCount = 0;

  /** Payment duration. */
  @Column(
    nullable         = false,
    columnDefinition = "LONGTEXT"
  )
  @Lob protected String duration;


  /** TODO: DOCUMENT ME! */
  @Transient protected Integer durationValue;

  /** Fix Fee amount. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String fixedFeeAmount = "0.00";


  /** TODO: DOCUMENT ME! */
  @Transient protected BigDecimal fixedFeeAmountValue = new BigDecimal("0.00");

  /** Payment frequency, null is monthly. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String frequency;


  /** TODO: DOCUMENT ME! */
  @Transient protected Integer frequencyValue;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "programAction",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("position asc")
  protected Set<ProgramIndividualInstallment> individualInstallments =
    new LinkedHashSet<ProgramIndividualInstallment>();


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable         = false,
    columnDefinition = "LONGTEXT"
  )
  @Lob protected String installmentDateTolerence = "1";


  /** TODO: DOCUMENT ME! */
  @Transient protected Integer installmentDateTolerenceValue = 1;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable         = false,
    columnDefinition = "LONGTEXT"
  )
  @Lob protected String installmentDollarTolerence = new String("1.00");


  /** TODO: DOCUMENT ME! */
  @Transient protected BigDecimal installmentDollarTolerenceValue = new BigDecimal("1.00");

  // default:'totalAmount', otherwise:'individual'

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 16,
    nullable = false
  )
  protected String installmentTermSelect = "totalAmount";

  /** TODO: DOCUMENT ME! */
  @Column(length = 50)
  @Enumerated(EnumType.STRING)
  protected PaymentProgramMonitoringType monitoringType;


  /** Percentage of principal. it will be removed in future */
  @Column(
    name      = "percentage",
    precision = 19,
    scale     = 4,
    nullable  = true
  )
  protected BigDecimal percentage;


  /** TODO: DOCUMENT ME! */
  @ManyToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "nodeProgramActions"
  )
  protected Set<Node> programNodes = new LinkedHashSet<Node>();

  /** Program valid days upon it was created. */
  @Column(
    nullable         = false,
    columnDefinition = "LONGTEXT"
  )
  @Lob protected String programValidDays = "30";

  /** TODO: DOCUMENT ME! */
  @Transient protected Integer programValidDaysValue = 30;


  /** TODO: DOCUMENT ME! */

  /** Required Payment. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String requiredPayments;


  /** TODO: DOCUMENT ME! */
  @Transient protected Integer requiredPaymentsValue;


  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String requiredPTPs;

  /** TODO: DOCUMENT ME! */
  @Transient protected Integer requiredPTPsValue;


  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "ProgramOfferedRole",
    indexes            = {
      @Index(
        name           = "programActionId",
        columnList     = "programActionId"
      )
    },
    joinColumns        = {
      @JoinColumn(
        name           = "programActionId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "roleId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.EAGER,
    cascade = { CascadeType.ALL }
  )
  protected Set<Role> roles = new HashSet<Role>();


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  @Enumerated(value = EnumType.STRING)
  protected RoundType roundType = RoundType.CENTS_UP;


  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String startDateExpression = "today";


  /** TODO: DOCUMENT ME! */
  @Transient protected Date startDateValue;


  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String totalAmountExpression;


  /** TODO: DOCUMENT ME! */
  @Transient protected BigDecimal totalAmountValue;

  /** Payment Program Type. */
  @JoinColumn(
    name     = "programTypeId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentProgramType type = new PaymentProgramType();


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean visible;


  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String webDetailProgramText;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "webOffer",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean webOffer;


  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String webSummaryProgramText;

  /** DOCUMENT ME! */
  @Column(
    name             = "cancelProgramUponRejectedPayment", 
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean cancelProgramUponRejectedPayment;


  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ProgramAction object.
   */
  public ProgramAction() {
    actionType = BaseNodeAction.ActionType_Program;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addIndividualInstallment.
   *
   * @param  individualInstallment  ProgramIndividualInstallment
   */
  public void addIndividualInstallment(ProgramIndividualInstallment individualInstallment) {
    individualInstallment.setProgramAction(this);

    // individualInstallment.setPosition(this.individualInstallments.size());
    this.individualInstallments.add(individualInstallment);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addOrgRole.
   *
   * @param  role  Role
   */
  public void addOrgRole(Role role) {
    this.roles.add(role);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addRole.
   *
   * @param  role  Role
   */
  public void addRole(Role role) {
    this.roles.add(role);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * beforeExecute.
   */
  @Override public void beforeExecute() {
    // To change body of implemented methods use File | Settings | File
    // Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * calculate.
   *
   * @param   helper  EvaluateHelper
   *
   * @return  Object
   */
  @Override public Object calculate(EvaluateHelper helper) {
    return helper.calculate(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * cleanIndividualInstallments.
   */
  public void cleanIndividualInstallments() {
    this.individualInstallments.clear();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createPaymentProgram.
   *
   * @param   amounts  BigDecimal[]
   *
   * @return  PaymentProgram
   */
  public PaymentProgram createPaymentProgram(BigDecimal[] amounts) {
    if (roundType == null) {
      roundType = RoundType.CENTS_UP;
    }

    if ((requiredPayments == null) && (durationValue > 0)) {
      requiredPayments = duration;
    }

    PaymentProgram paymentProgram = new PaymentProgram();

    paymentProgram.setActive(true);
    paymentProgram.setProgramOrder(this.priority);
    paymentProgram.setType(this.type);
    paymentProgram.setPrincipalType(null);
    paymentProgram.setPercentage(this.percentage);
    paymentProgram.setDuration(this.durationValue);
    paymentProgram.setFrequency(this.frequencyValue);
    paymentProgram.setFixedFeeAmount(this.fixedFeeAmountValue);
    paymentProgram.setProgramStatus(ProgramStatus.INIT);
    paymentProgram.setAllowedInstallmentDateRange(allowedPaymentDateRangeValue);
    paymentProgram.setInstallmentDateTolerence(installmentDateTolerenceValue);
    paymentProgram.setInstallmentDollarTolerence(installmentDollarTolerenceValue);

    // calculate the expiration date
    GregorianCalendar calbase = new GregorianCalendar();
    GregorianCalendar cal     = new GregorianCalendar(calbase.get(
          Calendar.YEAR), calbase.get(Calendar.MONTH),
        calbase.get(Calendar.DAY_OF_MONTH));
    cal.add(Calendar.DAY_OF_YEAR, programValidDaysValue);
    paymentProgram.setExpirationDate(cal.getTime());
    paymentProgram.setRequiredPayments(requiredPaymentsValue);

    // get the principalWhenCreated amount, and create installments

    try {
      BigDecimal programAmount = BigDecimal.ZERO;
      BigDecimal totalAmount   = null;

      BigDecimal principal = BigDecimal.ZERO;

      int installmentCount = durationValue;

      if (installmentCount < 0) {
        installmentCount = requiredPaymentsValue;
      }

      if (installmentCount > 0) {
        BigDecimal[] installmentAmounts = new BigDecimal[installmentCount];

        // get program amount from individual installment
        for (int i = 0; i < installmentCount; i++) {
          installmentAmounts[i] = roundAmount(amounts[i], roundType); // 2
          programAmount         = programAmount.add(installmentAmounts[i]);
        }

        // Now round the principal - sometimes it is needed if principal
        // uses
        // complex calculation.
        principal = programAmount;


        paymentProgram.setPrincipalWhenCreated(principal);

        // Check principal value: not null and not 0.0 and not less than 0.0
        if ((principal == null)
              || (principal.compareTo(BigDecimal.ZERO) <= 0)) {
          return null;
        }

        // validate program amount and installment amount
        if ((programAmount == null)
              || (programAmount.compareTo(BigDecimal.ZERO) <= 0)) {
          return null;
        }

        if (installmentCount > 1) {
          for (int i = 0; i < installmentCount; i++) {
            if ((installmentAmounts[i] == null)
                  || (installmentAmounts[i].compareTo(
                      BigDecimal.ZERO) <= 0)) {
              return null;
            }

          }
        }

        totalAmount = programAmount;
        paymentProgram.setProgramAmount(programAmount);

        int order = 1;

        if (fixedFeeAmountValue.compareTo(BigDecimal.ZERO) > 0) {
          // there is fixed fee, add fixed fee to installment
          PaymentProgramInstallment installment = new PaymentProgramInstallment();
          installment.setFixedFee(true);
          installment.setOrder(order++);
          installment.setPaymentAmount(fixedFeeAmountValue);

          paymentProgram.addFixedFeeInstallment(installment);
          totalAmount = programAmount.add(fixedFeeAmountValue);
        }

        if (installmentCount == 1) {
          // one payment
          PaymentProgramInstallment installment = new PaymentProgramInstallment();
          installment.setFixedFee(false);
          installment.setOrder(order++);
          installment.setPaymentAmount(programAmount);

          paymentProgram.addInstallment(installment);
        } else {
          for (int i = 0; i < installmentCount; i++) {
            PaymentProgramInstallment installment = new PaymentProgramInstallment();

            // frequency is null then go monthly
            if ((frequencyValue == null) || (frequencyValue <= 0)) {
              int f = 1;

              if (frequencyValue != null) {
                if (frequencyValue < 0) {
                  f = frequencyValue * (-1);
                }
              }


              // weekly payment
              installment.setPaymentMonthOffset(i * f);
              installment.setPaymentDateOffset(0);
            } else {
              installment.setPaymentMonthOffset(0);
              installment.setPaymentDateOffset(frequencyValue * i);
            }

            installment.setOrder(order++);
            installment.setFixedFee(false);
            installment.setPaymentAmount(installmentAmounts[i]);

            if (i < requiredPaymentsValue) {
              installment.setRequired(true);
            } else {
              installment.setRequired(false);
            }

            paymentProgram.addInstallment(installment);
          } // end for
        }   // end if-else

        // set total amount
        paymentProgram.setTotalAmount(totalAmount);
      } // end if

    } catch (Exception e) {
      paymentProgram = null;
      e.printStackTrace();
    } // end try-catch

    return paymentProgram;
  } // end method createPaymentProgram

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseNodeAction#duplicate()
   */
  @Override public BaseNodeAction duplicate() {
    // if (this.duplicateCount == null) {
    // this.duplicateCount = 0;
    // }
    //
    // this.duplicateCount++;

    ProgramAction programAction = new ProgramAction();
    programAction.updateNodeAction(this);
// programAction.setPortfolio(programAction.getPortfolio());
    programAction.setName(programAction.getName());
    programAction.setVisible(Boolean.TRUE);

    for (ProgramIndividualInstallment installment : this.individualInstallments) {
      programAction.addIndividualInstallment(installment.duplicate());
    }

    for (Role role : this.getRoles()) {
      programAction.addRole(role);
    }


    // for (ProgramAmountExpression amountExpression : this.amountExpressions) {
    // programAction.addAmountExpression(amountExpression.duplicate());
    // }
    //
    return programAction;
  } // end method duplicate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
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

    ProgramAction that = (ProgramAction) o;

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((allowedPaymentDateRange != null) ? (!allowedPaymentDateRange.equals(that.allowedPaymentDateRange))
                                          : (that.allowedPaymentDateRange != null)) {
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

    if ((programValidDays != null) ? (!programValidDays.equals(that.programValidDays))
                                   : (that.programValidDays != null)) {
      return false;
    }

    if ((requiredPTPs != null) ? (!requiredPTPs.equals(that.requiredPTPs)) : (that.requiredPTPs != null)) {
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
   * execute.
   *
   * @param  evaluateHelper  EvaluateHelper
   * @param  executeHelper   ExecuteHelper
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) {
    if (evaluate(evaluateHelper)) {
      this.triggered = true;

      // Map<String, Object> params = executeHelper.getParameters();
      // Responsible responsible = (Responsible) params.get("responsible");
      // Account account = (Account) params.get("account");
      //
      // AccountEligibleProgram aep = null;
      // for (AccountEligibleProgram eligibleProgram : account.getEligiblePrograms()) {
      // if (eligibleProgram.getAccount().getAccountNum().equals(account.getAccountNum())
      // && (eligibleProgram.getProgramAction().getId().equals(this.getId()))) {
      // eligibleProgram.setLastUpdateDate(new Date());
      // aep = eligibleProgram;
      // }
      // }
      // if (aep == null) {
      // aep = new AccountEligibleProgram();
      // aep.setProgramAction(this);
      // aep.setAccount(account);
      // }
      //
      // executeHelper.addResult(aep);
    } // end if-else
  }   // end method execute

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for allowed payment date range value.
   *
   * @return  Integer
   */
  public Integer getAllowedPaymentDateRangeValue() {
    return allowedPaymentDateRangeValue;
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
   * getter method for duration value.
   *
   * @return  Integer
   */
  public Integer getDurationValue() {
    return durationValue;
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
   * getter method for fixed fee amount value.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFixedFeeAmountValue() {
    return fixedFeeAmountValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for force mapping variable.
   *
   * @return  Map
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
   * @return  String
   */
  public String getFrequency() {
    return frequency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for frequency value.
   *
   * @return  Integer
   */
  public Integer getFrequencyValue() {
    return frequencyValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for individual installments.
   *
   * @return  Set
   */
  public Set<ProgramIndividualInstallment> getIndividualInstallments() {
    return individualInstallments;
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
   * getter method for installment date tolerence value.
   *
   * @return  Integer
   */
  public Integer getInstallmentDateTolerenceValue() {
    return installmentDateTolerenceValue;
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
   * getter method for installment dollar tolerence value.
   *
   * @return  BigDecimal
   */
  public BigDecimal getInstallmentDollarTolerenceValue() {
    return installmentDollarTolerenceValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for installment expressions.
   *
   * @param   duration  int
   *
   * @return  String[]
   */
  public String[] getInstallmentExpressions(int duration) {
    String[] exprs = null;

    if (duration > 0) {
      exprs = new String[duration];

      if ("individual".equals(this.installmentTermSelect)) {
        String defExpr = "";

        for (ProgramIndividualInstallment installment : individualInstallments) {
          if (Boolean.TRUE.equals(installment.getDefaulted())) {
            defExpr = installment.getAmountExpression();
          } else {
            int position = installment.getPosition() - 1;
            exprs[position] = installment.getAmountExpression();
          }
        }

        for (int i = 0; i < duration; i++) {
          if ((exprs[i] == null) || (exprs[i].length() == 0)) {
            exprs[i] = defExpr;
          }
        }
      } else if ("individualDate".equals(this.installmentTermSelect)) {
        String defExpr = "";

        for (ProgramIndividualInstallment installment : individualInstallments) {
          if (Boolean.TRUE.equals(installment.getDefaulted())) {
            defExpr = installment.getAmountExpression();
          } else {
            int position = installment.getPosition() - 1;
            exprs[position] = installment.getAmountExpression() + "#" + installment.getAmountDateExpression();
          }
        }

        for (int i = 0; i < duration; i++) {
          if ((exprs[i] == null) || (exprs[i].length() == 0)) {
            exprs[i] = defExpr;
          }
        }
      } else {
        for (int i = 0; i < duration; i++) {
          if ((exprs[i] == null) || (exprs[i].length() == 0)) {
            exprs[i] = "(" + totalAmountExpression + ") / " + duration;
          }
        }
      } // end if-else
    }   // end if

    return exprs;
  } // end method getInstallmentExpressions

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
   * getter method for monitoring type.
   *
   * @return  PaymentProgramMonitoringType
   */
  public PaymentProgramMonitoringType getMonitoringType() {
    if (monitoringType == null) {
      return PaymentProgramMonitoringType.NONMONITORING;
    }

    return monitoringType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for percentage.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPercentage() {
    return percentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program nodes.
   *
   * @return  Set
   */
  public Set<Node> getProgramNodes() {
    return programNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program type.
   *
   * @return  String
   */
  public String getProgramType() {
    String typeString = "";

    if (type != null) {
      typeString = type.getName();
    }

    return typeString;
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
   * getter method for program valid days value.
   *
   * @return  Integer
   */
  public Integer getProgramValidDaysValue() {
    return programValidDaysValue;
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
   * getter method for required payments value.
   *
   * @return  Integer
   */
  public Integer getRequiredPaymentsValue() {
    return requiredPaymentsValue;
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
   * getter method for required PTPs value.
   *
   * @return  Integer
   */
  public Integer getRequiredPTPsValue() {
    return requiredPTPsValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for roles.
   *
   * @return  Set
   */
  public Set<Role> getRoles() {
    return roles;
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
   * getter method for start date value.
   *
   * @return  Date
   */
  public Date getStartDateValue() {
    return startDateValue;
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
   * getter method for total amount value.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTotalAmountValue() {
    return totalAmountValue;
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
   * getter method for visible.
   *
   * @return  Boolean
   */
  public Boolean getVisible() {
    if (visible == null) {
      return Boolean.TRUE;
    }

    return visible;
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
   * @see  PortfolioBaseNodeAction#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((allowedPaymentDateRange != null) ? allowedPaymentDateRange.hashCode() : 0);
    result = (31 * result) + ((duration != null) ? duration.hashCode() : 0);
    result = (31 * result) + ((fixedFeeAmount != null) ? fixedFeeAmount.hashCode() : 0);
    result = (31 * result) + ((frequency != null) ? frequency.hashCode() : 0);
    result = (31 * result) + ((installmentDateTolerence != null) ? installmentDateTolerence.hashCode() : 0);
    result = (31 * result) + ((installmentDollarTolerence != null) ? installmentDollarTolerence.hashCode() : 0);
    result = (31 * result) + ((programValidDays != null) ? programValidDays.hashCode() : 0);
    result = (31 * result) + ((requiredPayments != null) ? requiredPayments.hashCode() : 0);
    result = (31 * result) + ((requiredPTPs != null) ? requiredPTPs.hashCode() : 0);
    result = (31 * result) + ((startDateExpression != null) ? startDateExpression.hashCode() : 0);
    result = (31 * result) + ((type != null) ? type.hashCode() : 0);
    result = (31 * result) + ((roundType != null) ? roundType.toString().hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeRole.
   *
   * @param  role  Role
   */
  public void removeRole(Role role) {
    if (role == null) {
      return;
    }

    for (Role curRole : this.roles) {
      if (curRole.getId().equals(role.getId())) {
        this.roles.remove(curRole);

        return;
      }
    }

    return;
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
   * setter method for allowed payment date range value.
   *
   * @param  allowedPaymentDateRangeValue  Integer
   */
  public void setAllowedPaymentDateRangeValue(Integer allowedPaymentDateRangeValue) {
    this.allowedPaymentDateRangeValue = allowedPaymentDateRangeValue;
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
   * setter method for duration value.
   *
   * @param  durationValue  Integer
   */
  public void setDurationValue(Integer durationValue) {
    this.durationValue = durationValue;
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
   * setter method for fixed fee amount value.
   *
   * @param  fixedFeeAmountValue  BigDecimal
   */
  public void setFixedFeeAmountValue(BigDecimal fixedFeeAmountValue) {
    this.fixedFeeAmountValue = fixedFeeAmountValue;
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
   * setter method for frequency value.
   *
   * @param  frequencyValue  Integer
   */
  public void setFrequencyValue(Integer frequencyValue) {
    this.frequencyValue = frequencyValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for individual installments.
   *
   * @param  individualInstallments  Set
   */
  public void setIndividualInstallments(Set<ProgramIndividualInstallment> individualInstallments) {
    this.individualInstallments = individualInstallments;
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
   * setter method for installment date tolerence value.
   *
   * @param  installmentDateTolerenceValue  Integer
   */
  public void setInstallmentDateTolerenceValue(Integer installmentDateTolerenceValue) {
    this.installmentDateTolerenceValue = installmentDateTolerenceValue;
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
   * setter method for installment dollar tolerence value.
   *
   * @param  installmentDollarTolerenceValue  BigDecimal
   */
  public void setInstallmentDollarTolerenceValue(BigDecimal installmentDollarTolerenceValue) {
    this.installmentDollarTolerenceValue = installmentDollarTolerenceValue;
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
   * setter method for monitoring type.
   *
   * @param  monitoringType  PaymentProgramMonitoringType
   */
  public void setMonitoringType(PaymentProgramMonitoringType monitoringType) {
    this.monitoringType = monitoringType;
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
   * setter method for program nodes.
   *
   * @param  programNodes  Set
   */
  public void setProgramNodes(Set<Node> programNodes) {
    this.programNodes = programNodes;
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
   * setter method for program valid days value.
   *
   * @param  programValidDaysValue  Integer
   */
  public void setProgramValidDaysValue(Integer programValidDaysValue) {
    this.programValidDaysValue = programValidDaysValue;
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
   * setter method for required payments value.
   *
   * @param  requiredPaymentsValue  Integer
   */
  public void setRequiredPaymentsValue(Integer requiredPaymentsValue) {
    this.requiredPaymentsValue = requiredPaymentsValue;
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
   * setter method for required PTPs value.
   *
   * @param  requiredPTPsValue  Integer
   */
  public void setRequiredPTPsValue(Integer requiredPTPsValue) {
    this.requiredPTPsValue = requiredPTPsValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for roles.
   *
   * @param  roles  Set
   */
  public void setRoles(Set<Role> roles) {
    this.roles = roles;
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
   * setter method for start date value.
   *
   * @param  startDateValue  Date
   */
  public void setStartDateValue(Date startDateValue) {
    this.startDateValue = startDateValue;
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
   * setter method for total amount value.
   *
   * @param  totalAmountValue  BigDecimal
   */
  public void setTotalAmountValue(BigDecimal totalAmountValue) {
    this.totalAmountValue = totalAmountValue;
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
   * setter method for visible.
   *
   * @param  visible  Boolean
   */
  public void setVisible(Boolean visible) {
    this.visible = visible;
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

  //~ ------------------------------------------------------------------------------------------------------------------
  
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getCancelProgramUponRejectedPayment() {
    if (cancelProgramUponRejectedPayment == null) {
      return Boolean.FALSE;
    }

    return cancelProgramUponRejectedPayment;
  }

  /**
   * DOCUMENT ME!
   *
   * @param  cancelProgramUponRejectedPayment  DOCUMENT ME!
   */
  public void setCancelProgramUponRejectedPayment(Boolean cancelProgramUponRejectedPayment) {
    this.cancelProgramUponRejectedPayment = cancelProgramUponRejectedPayment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("ProgramAction");
    sb.append("{allowedPaymentDateRange=").append(allowedPaymentDateRange);
    sb.append(", duration=").append(duration);
    sb.append(", fixedFeeAmount=").append(fixedFeeAmount);
    sb.append(", frequency=").append(frequency);
    sb.append(", installmentDateTolerence=").append(installmentDateTolerence);
    sb.append(", installmentDollarTolerence=").append(installmentDollarTolerence);
    sb.append(", programValidDays=").append(programValidDays);
    sb.append(", requiredPayments=").append(requiredPayments);
    sb.append(", requiredPTPs=").append(requiredPTPs);
    sb.append(", startDateExpression='").append(startDateExpression).append('\'');
    sb.append(", type=").append(type);
    sb.append(", roundType=").append(roundType);

    // sb.append(", amountExpressions=").append(amountExpressions);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateNodeAction.
   *
   * @param   programAction  BaseNodeAction
   *
   * @return  boolean
   */
  @Override public boolean updateNodeAction(BaseNodeAction programAction) {
    this.allowedPaymentDateRange    = ((ProgramAction) programAction).getAllowedPaymentDateRange();
    this.duration                   = ((ProgramAction) programAction).getDuration();
    this.fixedFeeAmount             = ((ProgramAction) programAction).getFixedFeeAmount();
    this.frequency                  = ((ProgramAction) programAction).getFrequency();
    this.installmentTermSelect      = ((ProgramAction) programAction).getInstallmentTermSelect();
    this.totalAmountExpression      = ((ProgramAction) programAction).getTotalAmountExpression();
    this.webOffer                   = ((ProgramAction) programAction).getWebOffer();
    this.installmentDateTolerence   = ((ProgramAction) programAction).getInstallmentDateTolerence();
    this.installmentDollarTolerence = ((ProgramAction) programAction).getInstallmentDollarTolerence();
    this.programValidDays           = ((ProgramAction) programAction).getProgramValidDays();
    this.requiredPayments           = ((ProgramAction) programAction).getRequiredPayments();
    this.requiredPTPs               = ((ProgramAction) programAction).getRequiredPTPs();
    this.startDateExpression        = ((ProgramAction) programAction).getStartDateExpression();
    this.type                       = ((ProgramAction) programAction).getType();
    this.roundType                  = ((ProgramAction) programAction).getRoundType();
    this.percentage                 = ((ProgramAction) programAction).getPercentage();
    this.allowEagerPayment          = ((ProgramAction) programAction).getAllowEagerPayment();
    
    this.cancelProgramUponRejectedPayment = ((ProgramAction) programAction).getCancelProgramUponRejectedPayment();


    return super.updateNodeAction(programAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * roundAmount.
   *
   * @param   amount     BigDecimal
   * @param   roundType  RoundType
   *
   * @return  BigDecimal
   */
  protected BigDecimal roundAmount(BigDecimal amount, RoundType roundType) {
    // round the total amount
    switch (roundType) {
      case CENTS_HALF_UP: {
        return amount.setScale(2, BigDecimal.ROUND_HALF_UP);
      }

      case CENTS_DOWN:
      case REMAINDER_FIRST:
      case SPREAD_REMAINDER: {
        return amount.setScale(2, BigDecimal.ROUND_DOWN);
      }

      case CENTS_UP: {
        return amount.setScale(2, BigDecimal.ROUND_UP);
      }

      // case DOLLARS_HALF_UP :
      // return amount.setScale(0, BigDecimal.ROUND_HALF_UP);
      //
      // case DOLLARS_DOWN :
      // return amount.setScale(0, BigDecimal.ROUND_DOWN);

      case DOLLARS_UP: {
        return amount.setScale(0, BigDecimal.ROUND_UP);
      }
    } // end switch

    // no round if not support
    return amount;
  } // end method roundAmount


} // end class ProgramAction
