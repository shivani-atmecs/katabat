package com.cmc.credagility.core.domain.treatment;

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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.schedule.BaseRule;
import com.cmc.credagility.core.domain.type.TreatmentType;
import com.cmc.credagility.core.domain.util.CompareUtil;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store payment program rule information.
 *
 * <p><a href="TreatmentRule.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/15/2014 16:01
 */
@Entity
@Table(name = "TreatmentRule")
public class TreatmentRule extends BaseRule {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2571042068968270769L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

// npelleti, 07/30, USBank, Removed unique constraint
  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "ruleId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long ruleId;

  /** score formula. */
  @Column(
    name     = "scoreFormula",
    nullable = false,
    length   = 65535
  )
  @Lob protected String scoreFormula;

  /** TODO: DOCUMENT ME! */
  @Column(length = 65535)
  @Lob protected String scoreFormula2;

  /** Target Amount Expression. */
  @Column(
    name     = "targetAmountExpression",
    nullable = false,
    length   = 65535
  )
  @Lob protected String targetAmountExpression;

  /** TODO: DOCUMENT ME! */
  @Column(length = 65535)
  @Lob protected String targetAmountExpression2;

  /** treatement duration in months. */
  @Column(
    name     = "treatmentDuration",
    nullable = true
  )
  protected Integer treatmentDuration;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "scheduleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected TreatmentSchedule treatmentSchedule;

  /** treatment type. */
  @Column(
    name     = "type",
    nullable = false,
    length   = 20
  )
  @Enumerated(value = EnumType.STRING)
  protected TreatmentType type;

  /** adjustment formula. */
  @Column(
    name     = "adjustmentFormula",
    nullable = true,
    length   = 65535
  )
  @Lob private String adjustmentFormula;

  /** amort schedule. */
  @Column(
    name     = "amortSchedule",
    nullable = true
  )
  private Integer amortSchedule;

  /** allow further adjust treatment after apr adjustment even if there are any candidate found. */
  @Column(
    name             = "aprContinuation",
    nullable         = true,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean aprContinuation;

  /** enable apr adjust treatment. */
  @Column(
    name             = "aprEnabled",
    nullable         = true,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean aprEnabled;

  /** apr adjust treatment max apr. */
  @Column(
    name      = "aprMax",
    nullable  = true,
    precision = 19,
    scale     = 4
  )
  private BigDecimal aprMax;

  /** apr adjust treatment min apr. */
  @Column(
    name      = "aprMin",
    nullable  = true,
    precision = 19,
    scale     = 4
  )
  private BigDecimal aprMin;

  /** apr adjust treatment priority. */
  @Column(
    name     = "aprPriority",
    nullable = true
  )
  private Integer aprPriority;

  /** apr adjust treatment increasing step. */
  @Column(
    name      = "aprStep",
    nullable  = true,
    precision = 19,
    scale     = 4
  )
  private BigDecimal aprStep;

  /** house ratio cutoff goal. */
  @Column(
    name      = "housingRatioCutoffGoal",
    nullable  = true,
    precision = 19,
    scale     = 4
  )
  private BigDecimal housingRatioCutoffGoal;

  /** house ratio perferrered goal. */
  @Column(
    name      = "housingRatioPreferredGoal",
    nullable  = true,
    precision = 19,
    scale     = 4
  )
  private BigDecimal housingRatioPreferredGoal;

  /** allow further adjust treatment after interest only treatment even if there are any candidate found. */
  @Column(
    name             = "ioContinuation",
    nullable         = true,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean ioContinuation;

  /** interest only adjust treatment. */
  @Column(
    name             = "ioEnabled",
    nullable         = true,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean ioEnabled;

  /** interest only treatment priority. */
  @Column(
    name     = "ioPriority",
    nullable = true
  )
  private Integer ioPriority;

  /** left over cutoff goal. */

  @Column(
    name      = "leftOverCutoffGoal",
    nullable  = true,
    precision = 19,
    scale     = 4
  )
  private BigDecimal leftOverCutoffGoal;

  /** left over perferrered goal. */
  @Column(
    name      = "leftOverPreferredGoal",
    nullable  = true,
    precision = 19,
    scale     = 4
  )
  private BigDecimal leftOverPreferredGoal;

  /** Loan To Value cutoff goal. */
  @Column(
    name      = "ltvCutoffGoal",
    nullable  = true,
    precision = 19,
    scale     = 4
  )
  private BigDecimal ltvCutoffGoal;

  /** Loan To Value perferrered goal. */
  @Column(
    name      = "ltvPreferredGoal",
    nullable  = true,
    precision = 19,
    scale     = 4
  )
  private BigDecimal ltvPreferredGoal;

  /** allow further adjust treatment after principal adjust treatment even if there are any candidate found. */
  @Column(
    name             = "prContinuation",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean prContinuation;

  /** enable principal adjust treatment. */
  @Column(
    name             = "prEnabled",
    nullable         = true,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean prEnabled;

  /** principal adjust treatment max pricipal percentage. */
  @Column(
    name      = "prMax",
    nullable  = true,
    precision = 19,
    scale     = 4
  )
  private BigDecimal prMax;

  /** principal adjust treatment min pricipal percentage. */
  @Column(
    name      = "prMin",
    nullable  = true,
    precision = 19,
    scale     = 4
  )
  private BigDecimal prMin;

  /** principal adjust treatment priority. */
  @Column(
    name     = "prPriority",
    nullable = true
  )
  private Integer prPriority;

  /** principal adjust treatment percentage increase step. */
  @Column(
    name      = "prStep",
    nullable  = true,
    precision = 19,
    scale     = 4
  )
  private BigDecimal prStep;

  /** allow further adjust treatment after term adjustment even if there are any candidate found. */
  @Column(
    name             = "termContinuation",
    nullable         = true,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean termContinuation;

  /** enable trem adjust treatment. */
  @Column(
    name             = "termEnabled",
    nullable         = true,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean termEnabled;

  /** term adjust treatment max term. */
  @Column(
    name     = "termMax",
    nullable = true
  )
  private Integer termMax;

  /** term adjust treatment min term. */
  @Column(
    name     = "termMin",
    nullable = true
  )
  private Integer termMin;

  /** term adjust treatment priority. */
  @Column(
    name     = "termPriority",
    nullable = true
  )
  private Integer termPriority;

  /** term adjust treatment increasing step. */
  @Column(
    name     = "termStep",
    nullable = true
  )
  private Integer termStep;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Business equals does not care about the createDate. Only to check if two schedule are the identical from business
   * perspective. This is perfect for dirty check when update schedule
   *
   * @param   obj  $param.type$
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

    TreatmentRule that = (TreatmentRule) obj;

    if ((adjustmentFormula != null) ? (!adjustmentFormula.equals(that.adjustmentFormula))
                                    : (that.adjustmentFormula != null)) {
      return false;
    }

    if ((housingRatioCutoffGoal != null) ? (!housingRatioCutoffGoal.equals(that.housingRatioCutoffGoal))
                                         : (that.housingRatioCutoffGoal != null)) {
      return false;
    }

    if ((housingRatioPreferredGoal != null) ? (!housingRatioPreferredGoal.equals(that.housingRatioPreferredGoal))
                                            : (that.housingRatioPreferredGoal != null)) {
      return false;
    }

    if ((ltvCutoffGoal != null) ? (!ltvCutoffGoal.equals(that.ltvCutoffGoal)) : (that.ltvCutoffGoal != null)) {
      return false;
    }

    if ((ltvPreferredGoal != null) ? (!ltvPreferredGoal.equals(that.ltvPreferredGoal))
                                   : (that.ltvPreferredGoal != null)) {
      return false;
    }

    if ((leftOverCutoffGoal != null) ? (!leftOverCutoffGoal.equals(that.leftOverCutoffGoal))
                                     : (that.leftOverCutoffGoal != null)) {
      return false;
    }

    if ((leftOverPreferredGoal != null) ? (!leftOverPreferredGoal.equals(that.leftOverPreferredGoal))
                                        : (that.leftOverPreferredGoal != null)) {
      return false;
    }

    if ((targetAmountExpression != null) ? (!targetAmountExpression.equals(that.targetAmountExpression))
                                         : (that.targetAmountExpression != null)) {
      return false;
    }

    if ((treatmentSchedule != null) ? (!treatmentSchedule.equals(that.treatmentSchedule))
                                    : (that.treatmentSchedule != null)) {
      return false;
    }

    if ((amortSchedule != null) ? (!amortSchedule.equals(that.amortSchedule)) : (that.amortSchedule != null)) {
      return false;
    }

    if ((aprContinuation != null) ? (!aprContinuation.equals(that.aprContinuation)) : (that.aprContinuation != null)) {
      return false;
    }

    if ((aprEnabled != null) ? (!aprEnabled.equals(that.aprEnabled)) : (that.aprEnabled != null)) {
      return false;
    }

    if ((aprMax != null) ? (!aprMax.equals(that.aprMax)) : (that.aprMax != null)) {
      return false;
    }

    if ((aprMin != null) ? (!aprMin.equals(that.aprMin)) : (that.aprMin != null)) {
      return false;
    }

    if ((aprPriority != null) ? (!aprPriority.equals(that.aprPriority)) : (that.aprPriority != null)) {
      return false;
    }

    if ((aprStep != null) ? (!aprStep.equals(that.aprStep)) : (that.aprStep != null)) {
      return false;
    }

    if ((ioContinuation != null) ? (!ioContinuation.equals(that.ioContinuation)) : (that.ioContinuation != null)) {
      return false;
    }

    if ((ioEnabled != null) ? (!ioEnabled.equals(that.ioEnabled)) : (that.ioEnabled != null)) {
      return false;
    }

    if ((ioPriority != null) ? (!ioPriority.equals(that.ioPriority)) : (that.ioPriority != null)) {
      return false;
    }

    if ((prContinuation != null) ? (!prContinuation.equals(that.prContinuation)) : (that.prContinuation != null)) {
      return false;
    }

    if ((prEnabled != null) ? (!prEnabled.equals(that.prEnabled)) : (that.prEnabled != null)) {
      return false;
    }

    if ((prMax != null) ? (!prMax.equals(that.prMax)) : (that.prMax != null)) {
      return false;
    }

    if ((prMin != null) ? (!prMin.equals(that.prMin)) : (that.prMin != null)) {
      return false;
    }

    if ((prPriority != null) ? (!prPriority.equals(that.prPriority)) : (that.prPriority != null)) {
      return false;
    }

    if ((prStep != null) ? (!prStep.equals(that.prStep)) : (that.prStep != null)) {
      return false;
    }

    if ((scoreFormula != null) ? (!scoreFormula.equals(that.scoreFormula)) : (that.scoreFormula != null)) {
      return false;
    }

    if ((termContinuation != null) ? (!termContinuation.equals(that.termContinuation))
                                   : (that.termContinuation != null)) {
      return false;
    }

    if ((termEnabled != null) ? (!termEnabled.equals(that.termEnabled)) : (that.termEnabled != null)) {
      return false;
    }

    if ((termMax != null) ? (!termMax.equals(that.termMax)) : (that.termMax != null)) {
      return false;
    }

    if ((termMin != null) ? (!termMin.equals(that.termMin)) : (that.termMin != null)) {
      return false;
    }

    if ((termPriority != null) ? (!termPriority.equals(that.termPriority)) : (that.termPriority != null)) {
      return false;
    }

    if ((termStep != null) ? (!termStep.equals(that.termStep)) : (that.termStep != null)) {
      return false;
    }

    if ((treatmentDuration != null) ? (!treatmentDuration.equals(that.treatmentDuration))
                                    : (that.treatmentDuration != null)) {
      return false;
    }

    if (type != that.type) {
      return false;
    }

    return true;
  } // end method businessEquals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Copy criteria only rule.
   *
   * @param  other  $param.type$
   */
  public void copyCriteria(TreatmentRule other) {
    super.deepCopy(other);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Copy from other rule.
   *
   * @param  other  $param.type$
   */
  public void deepCopy(TreatmentRule other) {
    super.deepCopy(other);

    this.targetAmountExpression  = other.getTargetAmountExpression();
    this.targetAmountExpression2 = other.getTargetAmountExpression2();

    this.housingRatioPreferredGoal = other.getHousingRatioPreferredGoal();
    this.housingRatioCutoffGoal    = other.getHousingRatioCutoffGoal();
    this.leftOverPreferredGoal     = other.getLeftOverPreferredGoal();
    this.leftOverCutoffGoal        = other.getLeftOverCutoffGoal();
    this.ltvPreferredGoal          = other.getLtvPreferredGoal();
    this.ltvCutoffGoal             = other.getLtvCutoffGoal();
    this.adjustmentFormula         = other.getAdjustmentFormula();

    setType(other.getType());

    if (other.getTreatmentDuration() != null) {
      setTreatmentDuration(other.getTreatmentDuration().intValue());
    } else {
      setTreatmentDuration(null);
    }

    setScoreFormula(other.getScoreFormula());
    setScoreFormula2(other.getScoreFormula2());

    if (other.getAprEnabled() != null) {
      aprEnabled = other.getAprEnabled().booleanValue();
    } else {
      aprEnabled = null;
    }

    if (other.getAprPriority() != null) {
      aprPriority = other.getAprPriority().intValue();
    } else {
      aprPriority = null;
    }

    aprMin  = other.getAprMin();
    aprMax  = other.getAprMax();
    aprStep = other.getAprStep();

    if (other.getAprContinuation() != null) {
      aprContinuation = other.getAprContinuation().booleanValue();
    } else {
      aprContinuation = null;
    }

    if (other.getTermEnabled() != null) {
      termEnabled = other.getTermEnabled().booleanValue();
    } else {
      termEnabled = other.getTermEnabled();
    }

    if (other.getTermPriority() != null) {
      termPriority = other.getTermPriority().intValue();
    } else {
      termPriority = null;
    }

    if (other.getTermMin() != null) {
      termMin = other.getTermMin().intValue();
    } else {
      termMin = null;
    }

    if (other.getTermMax() != null) {
      termMax = other.getTermMax().intValue();
    } else {
      termMax = null;
    }

    if (other.getTermStep() != null) {
      termStep = other.getTermStep().intValue();
    } else {
      termStep = null;
    }

    if (other.getTermContinuation() != null) {
      termContinuation = other.getTermContinuation().booleanValue();
    } else {
      termContinuation = null;
    }

    if (other.getIoEnabled() != null) {
      ioEnabled = other.getIoEnabled().booleanValue();
    } else {
      ioEnabled = null;
    }

    if (other.getIoPriority() != null) {
      ioPriority = other.getIoPriority().intValue();
    } else {
      ioPriority = null;
    }

    if (other.getIoContinuation() != null) {
      ioContinuation = other.getIoContinuation().booleanValue();
    } else {
      ioContinuation = null;
    }

    if (other.getPrEnabled() != null) {
      prEnabled = other.getPrEnabled().booleanValue();
    } else {
      prEnabled = null;
    }

    if (other.getPrPriority() != null) {
      prPriority = other.getPrPriority().intValue();
    } else {
      prPriority = null;
    }

    prMin  = other.getPrMin();
    prMax  = other.getPrMax();
    prStep = other.getPrStep();

    if (other.getPrContinuation() != null) {
      prContinuation = other.getPrContinuation().booleanValue();
    } else {
      prContinuation = null;
    }

    if (other.getAmortSchedule() != null) {
      amortSchedule = other.getAmortSchedule().intValue();
    } else {
      amortSchedule = null;
    }

  } // end method deepCopy

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseRule#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof TreatmentRule)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    TreatmentRule that = (TreatmentRule) o;

    if ((adjustmentFormula != null) ? (!adjustmentFormula.equals(that.adjustmentFormula))
                                    : (that.adjustmentFormula != null)) {
      return false;
    }

    if ((housingRatioCutoffGoal != null) ? (!housingRatioCutoffGoal.equals(that.housingRatioCutoffGoal))
                                         : (that.housingRatioCutoffGoal != null)) {
      return false;
    }

    if ((housingRatioPreferredGoal != null) ? (!housingRatioPreferredGoal.equals(that.housingRatioPreferredGoal))
                                            : (that.housingRatioPreferredGoal != null)) {
      return false;
    }

    if ((ltvCutoffGoal != null) ? (!ltvCutoffGoal.equals(that.ltvCutoffGoal)) : (that.ltvCutoffGoal != null)) {
      return false;
    }

    if ((ltvPreferredGoal != null) ? (!ltvPreferredGoal.equals(that.ltvPreferredGoal))
                                   : (that.ltvPreferredGoal != null)) {
      return false;
    }

    if ((leftOverCutoffGoal != null) ? (!leftOverCutoffGoal.equals(that.leftOverCutoffGoal))
                                     : (that.leftOverCutoffGoal != null)) {
      return false;
    }

    if ((leftOverPreferredGoal != null) ? (!leftOverPreferredGoal.equals(that.leftOverPreferredGoal))
                                        : (that.leftOverPreferredGoal != null)) {
      return false;
    }

    if ((targetAmountExpression != null) ? (!targetAmountExpression.equals(that.targetAmountExpression))
                                         : (that.targetAmountExpression != null)) {
      return false;
    }

    if ((treatmentSchedule != null) ? (!treatmentSchedule.equals(that.treatmentSchedule))
                                    : (that.treatmentSchedule != null)) {
      return false;
    }

    if ((amortSchedule != null) ? (!amortSchedule.equals(that.amortSchedule)) : (that.amortSchedule != null)) {
      return false;
    }

    if ((aprContinuation != null) ? (!aprContinuation.equals(that.aprContinuation)) : (that.aprContinuation != null)) {
      return false;
    }

    if ((aprEnabled != null) ? (!aprEnabled.equals(that.aprEnabled)) : (that.aprEnabled != null)) {
      return false;
    }

    if ((aprMax != null) ? (!aprMax.equals(that.aprMax)) : (that.aprMax != null)) {
      return false;
    }

    if ((aprMin != null) ? (!aprMin.equals(that.aprMin)) : (that.aprMin != null)) {
      return false;
    }

    if ((aprPriority != null) ? (!aprPriority.equals(that.aprPriority)) : (that.aprPriority != null)) {
      return false;
    }

    if ((aprStep != null) ? (!aprStep.equals(that.aprStep)) : (that.aprStep != null)) {
      return false;
    }

    if ((ioContinuation != null) ? (!ioContinuation.equals(that.ioContinuation)) : (that.ioContinuation != null)) {
      return false;
    }

    if ((ioEnabled != null) ? (!ioEnabled.equals(that.ioEnabled)) : (that.ioEnabled != null)) {
      return false;
    }

    if ((ioPriority != null) ? (!ioPriority.equals(that.ioPriority)) : (that.ioPriority != null)) {
      return false;
    }

    if ((prContinuation != null) ? (!prContinuation.equals(that.prContinuation)) : (that.prContinuation != null)) {
      return false;
    }

    if ((prEnabled != null) ? (!prEnabled.equals(that.prEnabled)) : (that.prEnabled != null)) {
      return false;
    }

    if ((prMax != null) ? (!prMax.equals(that.prMax)) : (that.prMax != null)) {
      return false;
    }

    if ((prMin != null) ? (!prMin.equals(that.prMin)) : (that.prMin != null)) {
      return false;
    }

    if ((prPriority != null) ? (!prPriority.equals(that.prPriority)) : (that.prPriority != null)) {
      return false;
    }

    if ((prStep != null) ? (!prStep.equals(that.prStep)) : (that.prStep != null)) {
      return false;
    }

    if ((scoreFormula != null) ? (!scoreFormula.equals(that.scoreFormula)) : (that.scoreFormula != null)) {
      return false;
    }

    if ((termContinuation != null) ? (!termContinuation.equals(that.termContinuation))
                                   : (that.termContinuation != null)) {
      return false;
    }

    if ((termEnabled != null) ? (!termEnabled.equals(that.termEnabled)) : (that.termEnabled != null)) {
      return false;
    }

    if ((termMax != null) ? (!termMax.equals(that.termMax)) : (that.termMax != null)) {
      return false;
    }

    if ((termMin != null) ? (!termMin.equals(that.termMin)) : (that.termMin != null)) {
      return false;
    }

    if ((termPriority != null) ? (!termPriority.equals(that.termPriority)) : (that.termPriority != null)) {
      return false;
    }

    if ((termStep != null) ? (!termStep.equals(that.termStep)) : (that.termStep != null)) {
      return false;
    }

    if ((treatmentDuration != null) ? (!treatmentDuration.equals(that.treatmentDuration))
                                    : (that.treatmentDuration != null)) {
      return false;
    }

    if (type != that.type) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for adjustment formula.
   *
   * @return  String
   */
  public String getAdjustmentFormula() {
    return adjustmentFormula;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for amort schedule.
   *
   * @return  Integer
   */
  public Integer getAmortSchedule() {
    return amortSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for apr continuation.
   *
   * @return  Boolean
   */
  public Boolean getAprContinuation() {
    return aprContinuation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for apr enabled.
   *
   * @return  Boolean
   */
  public Boolean getAprEnabled() {
    return aprEnabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for apr max.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAprMax() {
    return aprMax;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for apr min.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAprMin() {
    return aprMin;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for apr priority.
   *
   * @return  Integer
   */
  public Integer getAprPriority() {
    return aprPriority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for apr step.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAprStep() {
    return aprStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for housing ratio cutoff goal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getHousingRatioCutoffGoal() {
    return housingRatioCutoffGoal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for housing ratio preferred goal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getHousingRatioPreferredGoal() {
    return housingRatioPreferredGoal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for io continuation.
   *
   * @return  Boolean
   */
  public Boolean getIoContinuation() {
    return ioContinuation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for io enabled.
   *
   * @return  Boolean
   */
  public Boolean getIoEnabled() {
    return ioEnabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for io priority.
   *
   * @return  Integer
   */
  public Integer getIoPriority() {
    return ioPriority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for left over cutoff goal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLeftOverCutoffGoal() {
    return leftOverCutoffGoal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for left over preferred goal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLeftOverPreferredGoal() {
    return leftOverPreferredGoal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ltv cutoff goal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLtvCutoffGoal() {
    return ltvCutoffGoal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ltv preferred goal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getLtvPreferredGoal() {
    return ltvPreferredGoal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pr continuation.
   *
   * @return  Boolean
   */
  public Boolean getPrContinuation() {
    return prContinuation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pr enabled.
   *
   * @return  Boolean
   */
  public Boolean getPrEnabled() {
    return prEnabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pr max.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPrMax() {
    return prMax;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pr min.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPrMin() {
    return prMin;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pr priority.
   *
   * @return  Integer
   */
  public Integer getPrPriority() {
    return prPriority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pr step.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPrStep() {
    return prStep;
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
    return "TreatmentRule";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score formula.
   *
   * @return  String
   */
  public String getScoreFormula() {
    return scoreFormula;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score formula2.
   *
   * @return  String
   */
  public String getScoreFormula2() {
    return scoreFormula2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for target amount expression.
   *
   * @return  String
   */
  public String getTargetAmountExpression() {
    return targetAmountExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for target amount expression2.
   *
   * @return  String
   */
  public String getTargetAmountExpression2() {
    return targetAmountExpression2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for term continuation.
   *
   * @return  Boolean
   */
  public Boolean getTermContinuation() {
    return termContinuation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for term enabled.
   *
   * @return  Boolean
   */
  public Boolean getTermEnabled() {
    return termEnabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for term max.
   *
   * @return  Integer
   */
  public Integer getTermMax() {
    return termMax;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for term min.
   *
   * @return  Integer
   */
  public Integer getTermMin() {
    return termMin;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for term priority.
   *
   * @return  Integer
   */
  public Integer getTermPriority() {
    return termPriority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for term step.
   *
   * @return  Integer
   */
  public Integer getTermStep() {
    return termStep;
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
   * getter method for treatment schedule.
   *
   * @return  TreatmentSchedule
   */
  public TreatmentSchedule getTreatmentSchedule() {
    return treatmentSchedule;
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
   * @see  com.cmc.credagility.core.domain.schedule.BaseRule#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((treatmentSchedule != null) ? treatmentSchedule.hashCode() : 0);
    result = (31 * result) + ((targetAmountExpression != null) ? targetAmountExpression.hashCode() : 0);
    result = (31 * result) + ((housingRatioPreferredGoal != null) ? housingRatioPreferredGoal.hashCode() : 0);
    result = (31 * result) + ((housingRatioCutoffGoal != null) ? housingRatioCutoffGoal.hashCode() : 0);
    result = (31 * result) + ((leftOverPreferredGoal != null) ? leftOverPreferredGoal.hashCode() : 0);
    result = (31 * result) + ((leftOverCutoffGoal != null) ? leftOverCutoffGoal.hashCode() : 0);
    result = (31 * result) + ((ltvPreferredGoal != null) ? ltvPreferredGoal.hashCode() : 0);
    result = (31 * result) + ((ltvCutoffGoal != null) ? ltvCutoffGoal.hashCode() : 0);
    result = (31 * result) + ((adjustmentFormula != null) ? adjustmentFormula.hashCode() : 0);

    result = (31 * result) + ((type != null) ? type.hashCode() : 0);
    result = (31 * result) + ((treatmentDuration != null) ? treatmentDuration.hashCode() : 0);
    result = (31 * result) + ((scoreFormula != null) ? scoreFormula.hashCode() : 0);
    result = (31 * result) + ((aprEnabled != null) ? aprEnabled.hashCode() : 0);
    result = (31 * result) + ((aprPriority != null) ? aprPriority.hashCode() : 0);
    result = (31 * result) + ((aprMin != null) ? aprMin.hashCode() : 0);
    result = (31 * result) + ((aprMax != null) ? aprMax.hashCode() : 0);
    result = (31 * result) + ((aprStep != null) ? aprStep.hashCode() : 0);
    result = (31 * result) + ((aprContinuation != null) ? aprContinuation.hashCode() : 0);
    result = (31 * result) + ((termEnabled != null) ? termEnabled.hashCode() : 0);
    result = (31 * result) + ((termPriority != null) ? termPriority.hashCode() : 0);
    result = (31 * result) + ((termMin != null) ? termMin.hashCode() : 0);
    result = (31 * result) + ((termMax != null) ? termMax.hashCode() : 0);
    result = (31 * result) + ((termStep != null) ? termStep.hashCode() : 0);
    result = (31 * result) + ((termContinuation != null) ? termContinuation.hashCode() : 0);
    result = (31 * result) + ((ioEnabled != null) ? ioEnabled.hashCode() : 0);
    result = (31 * result) + ((ioPriority != null) ? ioPriority.hashCode() : 0);
    result = (31 * result) + ((ioContinuation != null) ? ioContinuation.hashCode() : 0);
    result = (31 * result) + ((prEnabled != null) ? prEnabled.hashCode() : 0);
    result = (31 * result) + ((prPriority != null) ? prPriority.hashCode() : 0);
    result = (31 * result) + ((prMin != null) ? prMin.hashCode() : 0);
    result = (31 * result) + ((prMax != null) ? prMax.hashCode() : 0);
    result = (31 * result) + ((prStep != null) ? prStep.hashCode() : 0);
    result = (31 * result) + ((prContinuation != null) ? prContinuation.hashCode() : 0);
    result = (31 * result) + ((amortSchedule != null) ? amortSchedule.hashCode() : 0);

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for adjustment formula.
   *
   * @param  adjustmentFormula  String
   */
  public void setAdjustmentFormula(String adjustmentFormula) {
    this.adjustmentFormula = adjustmentFormula;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for amort schedule.
   *
   * @param  amortSchedule  Integer
   */
  public void setAmortSchedule(Integer amortSchedule) {
    this.amortSchedule = amortSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for apr continuation.
   *
   * @param  aprContinuation  Boolean
   */
  public void setAprContinuation(Boolean aprContinuation) {
    this.aprContinuation = aprContinuation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for apr enabled.
   *
   * @param  aprEnabled  Boolean
   */
  public void setAprEnabled(Boolean aprEnabled) {
    this.aprEnabled = aprEnabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for apr max.
   *
   * @param  aprMax  BigDecimal
   */
  public void setAprMax(BigDecimal aprMax) {
    this.aprMax = aprMax;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for apr min.
   *
   * @param  aprMin  BigDecimal
   */
  public void setAprMin(BigDecimal aprMin) {
    this.aprMin = aprMin;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for apr priority.
   *
   * @param  aprPriority  Integer
   */
  public void setAprPriority(Integer aprPriority) {
    this.aprPriority = aprPriority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for apr step.
   *
   * @param  aprStep  BigDecimal
   */
  public void setAprStep(BigDecimal aprStep) {
    this.aprStep = aprStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for housing ratio cutoff goal.
   *
   * @param  housingRatioCutoffGoal  BigDecimal
   */
  public void setHousingRatioCutoffGoal(BigDecimal housingRatioCutoffGoal) {
    this.housingRatioCutoffGoal = housingRatioCutoffGoal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for housing ratio preferred goal.
   *
   * @param  housingRatioPreferredGoal  BigDecimal
   */
  public void setHousingRatioPreferredGoal(BigDecimal housingRatioPreferredGoal) {
    this.housingRatioPreferredGoal = housingRatioPreferredGoal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for io continuation.
   *
   * @param  ioContinuation  Boolean
   */
  public void setIoContinuation(Boolean ioContinuation) {
    this.ioContinuation = ioContinuation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for io enabled.
   *
   * @param  ioEnabled  Boolean
   */
  public void setIoEnabled(Boolean ioEnabled) {
    this.ioEnabled = ioEnabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for io priority.
   *
   * @param  ioPriority  Integer
   */
  public void setIoPriority(Integer ioPriority) {
    this.ioPriority = ioPriority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for left over cutoff goal.
   *
   * @param  leftOverCutoffGoal  BigDecimal
   */
  public void setLeftOverCutoffGoal(BigDecimal leftOverCutoffGoal) {
    this.leftOverCutoffGoal = leftOverCutoffGoal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for left over preferred goal.
   *
   * @param  leftOverPreferredGoal  BigDecimal
   */
  public void setLeftOverPreferredGoal(BigDecimal leftOverPreferredGoal) {
    this.leftOverPreferredGoal = leftOverPreferredGoal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ltv cutoff goal.
   *
   * @param  ltvCutoffGoal  BigDecimal
   */
  public void setLtvCutoffGoal(BigDecimal ltvCutoffGoal) {
    this.ltvCutoffGoal = ltvCutoffGoal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ltv preferred goal.
   *
   * @param  ltvPreferredGoal  BigDecimal
   */
  public void setLtvPreferredGoal(BigDecimal ltvPreferredGoal) {
    this.ltvPreferredGoal = ltvPreferredGoal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pr continuation.
   *
   * @param  prContinuation  Boolean
   */
  public void setPrContinuation(Boolean prContinuation) {
    this.prContinuation = prContinuation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pr enabled.
   *
   * @param  prEnabled  Boolean
   */
  public void setPrEnabled(Boolean prEnabled) {
    this.prEnabled = prEnabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pr max.
   *
   * @param  prMax  BigDecimal
   */
  public void setPrMax(BigDecimal prMax) {
    this.prMax = prMax;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pr min.
   *
   * @param  prMin  BigDecimal
   */
  public void setPrMin(BigDecimal prMin) {
    this.prMin = prMin;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pr priority.
   *
   * @param  prPriority  Integer
   */
  public void setPrPriority(Integer prPriority) {
    this.prPriority = prPriority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pr step.
   *
   * @param  prStep  BigDecimal
   */
  public void setPrStep(BigDecimal prStep) {
    this.prStep = prStep;
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
   * setter method for score formula.
   *
   * @param  scoreFormula  String
   */
  public void setScoreFormula(String scoreFormula) {
    this.scoreFormula = scoreFormula;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score formula2.
   *
   * @param  scoreFormula2  String
   */
  public void setScoreFormula2(String scoreFormula2) {
    this.scoreFormula2 = scoreFormula2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for target amount expression.
   *
   * @param  targetAmountExpression  String
   */
  public void setTargetAmountExpression(String targetAmountExpression) {
    this.targetAmountExpression = targetAmountExpression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for target amount expression2.
   *
   * @param  targetAmountExpression2  String
   */
  public void setTargetAmountExpression2(String targetAmountExpression2) {
    this.targetAmountExpression2 = targetAmountExpression2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for term continuation.
   *
   * @param  termContinuation  Boolean
   */
  public void setTermContinuation(Boolean termContinuation) {
    this.termContinuation = termContinuation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for term enabled.
   *
   * @param  termEnabled  Boolean
   */
  public void setTermEnabled(Boolean termEnabled) {
    this.termEnabled = termEnabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for term max.
   *
   * @param  termMax  Integer
   */
  public void setTermMax(Integer termMax) {
    this.termMax = termMax;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for term min.
   *
   * @param  termMin  Integer
   */
  public void setTermMin(Integer termMin) {
    this.termMin = termMin;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for term priority.
   *
   * @param  termPriority  Integer
   */
  public void setTermPriority(Integer termPriority) {
    this.termPriority = termPriority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for term step.
   *
   * @param  termStep  Integer
   */
  public void setTermStep(Integer termStep) {
    this.termStep = termStep;
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
   * setter method for treatment schedule.
   *
   * @param  treatmentSchedule  TreatmentSchedule
   */
  public void setTreatmentSchedule(TreatmentSchedule treatmentSchedule) {
    this.treatmentSchedule = treatmentSchedule;
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
   * @see  com.cmc.credagility.core.domain.schedule.BaseRule#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("TreatmentRule");
    sb.append("{ruleId=").append(ruleId);
    sb.append(", treatmentSchedule=").append(treatmentSchedule);
    sb.append(", targetAmountExpression='").append(targetAmountExpression).append('\'');
    sb.append(", housingRatioPreferredGoal=").append(housingRatioPreferredGoal);
    sb.append(", housingRatioCutoffGoal=").append(housingRatioCutoffGoal);
    sb.append(", leftOverPreferredGoal=").append(leftOverPreferredGoal);
    sb.append(", leftOverCutoffGoal=").append(leftOverCutoffGoal);
    sb.append(", ltvPreferredGoal=").append(ltvPreferredGoal);
    sb.append(", ltvCutoffGoal=").append(ltvCutoffGoal);
    sb.append(", adjustmentFormula='").append(adjustmentFormula).append('\'');
    sb.append(", type=").append(type);
    sb.append(", treatmentDuration=").append(treatmentDuration);
    sb.append(", scoreFormula='").append(scoreFormula).append('\'');
    sb.append(", aprEnabled=").append(aprEnabled);
    sb.append(", aprPriority=").append(aprPriority);
    sb.append(", aprMin=").append(aprMin);
    sb.append(", aprMax=").append(aprMax);
    sb.append(", aprStep=").append(aprStep);
    sb.append(", aprContinuation=").append(aprContinuation);
    sb.append(", termEnabled=").append(termEnabled);
    sb.append(", termPriority=").append(termPriority);
    sb.append(", termMin=").append(termMin);
    sb.append(", termMax=").append(termMax);
    sb.append(", termStep=").append(termStep);
    sb.append(", termContinuation=").append(termContinuation);
    sb.append(", ioEnabled=").append(ioEnabled);
    sb.append(", ioPriority=").append(ioPriority);
    sb.append(", ioContinuation=").append(ioContinuation);
    sb.append(", prEnabled=").append(prEnabled);
    sb.append(", prPriority=").append(prPriority);
    sb.append(", prMin=").append(prMin);
    sb.append(", prMax=").append(prMax);
    sb.append(", prStep=").append(prStep);
    sb.append(", prContinuation=").append(prContinuation);
    sb.append(", amortSchedule=").append(amortSchedule);
    sb.append('}');

    return sb.toString();
  } // end method toString

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update rule form other rule return false if there is no difference return true if there are some difference and
   * update success.
   *
   * @param   treatmentRule  TreatmentRule
   *
   * @return  update rule form other rule return false if there is no difference return true if there are some
   *          difference and update success.
   */
  public boolean updateRule(TreatmentRule treatmentRule) {
    if (!businessEquals(treatmentRule) || !(CompareUtil.nullSafeEquals(this.priority, treatmentRule.priority))) {
      // there are difference, copy form it
      this.deepCopy(treatmentRule);

      return true;
    }

    return false;
  }
} // end class TreatmentRule
