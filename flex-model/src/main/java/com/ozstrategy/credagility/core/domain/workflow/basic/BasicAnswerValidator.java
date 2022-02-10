package com.ozstrategy.credagility.core.domain.workflow.basic;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 2/21/14 Time: 3:22 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class BasicAnswerValidator extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8379976125980304118L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Date value. */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         dateValue;

  /** Error text. */
  @Column(length = 255)
  protected String errorText;

  /** Expression for answer validator. */
  @Column(length = 255)
  protected String expression;

  /** Primary key. */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** Maximum date value. */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         maxDateValue;

  /** Maximum text length. */
  protected Long maximumLength;


  /** Minimum value. */
  protected Float maximumValue;

  /** Minimum date value. */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         miniDateValue;

  /** Minimum text length. */
  protected Long minimumLength;

  /** Minimum value. */
  protected Float minimumValue;

  /** Number value. */
  protected Float numberValue;

  /** Number of decimal digits. */
  protected Integer numOfDecimalDigits;

  /**
   * Operator.
   *
   * <pre>'gt'</pre>
   *
   * <pre>'ge'</pre>
   *
   * <pre>'lt'</pre>
   *
   * <pre>'le'</pre>
   *
   * <pre>'e'</pre>
   *
   * <pre>'ne'</pre>
   *
   * <pre>between and</pre>
   */
  protected String operator;

  /** Execute answer validator priority. */
  protected Integer priority;

  /** Regular expression. */
  @Column(length = 255)
  protected String regularExp;

  /** Text value. */
  protected String textValue;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    if (!(o instanceof BasicAnswerValidator)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BasicAnswerValidator that = (BasicAnswerValidator) o;

    if ((errorText != null) ? (!errorText.equals(that.errorText)) : (that.errorText != null)) {
      return false;
    }

    if ((maximumLength != null) ? (!maximumLength.equals(that.maximumLength)) : (that.maximumLength != null)) {
      return false;
    }

    if ((maximumValue != null) ? (!maximumValue.equals(that.maximumValue)) : (that.maximumValue != null)) {
      return false;
    }

    if ((minimumLength != null) ? (!minimumLength.equals(that.minimumLength)) : (that.minimumLength != null)) {
      return false;
    }

    if ((minimumValue != null) ? (!minimumValue.equals(that.minimumValue)) : (that.minimumValue != null)) {
      return false;
    }

    if ((numOfDecimalDigits != null) ? (!numOfDecimalDigits.equals(that.numOfDecimalDigits))
                                     : (that.numOfDecimalDigits != null)) {
      return false;
    }

    if ((dateValue != null) ? (!dateValue.equals(that.dateValue)) : (that.dateValue != null)) {
      return false;
    }

    if ((miniDateValue != null) ? (!miniDateValue.equals(that.miniDateValue)) : (that.miniDateValue != null)) {
      return false;
    }

    if ((maxDateValue != null) ? (!maxDateValue.equals(that.maxDateValue)) : (that.maxDateValue != null)) {
      return false;
    }

    if ((numberValue != null) ? (!numberValue.equals(that.numberValue)) : (that.numberValue != null)) {
      return false;
    }

    if ((operator != null) ? (!operator.equals(that.operator)) : (that.operator != null)) {
      return false;
    }

    if ((priority != null) ? (!priority.equals(that.priority)) : (that.priority != null)) {
      return false;
    }

    if ((regularExp != null) ? (!regularExp.equals(that.regularExp)) : (that.regularExp != null)) {
      return false;
    }

    if ((textValue != null) ? (!textValue.equals(that.textValue)) : (that.textValue != null)) {
      return false;
    }

    if ((expression != null) ? (!expression.equals(that.expression)) : (that.expression != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getDateValue() {
    return dateValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getErrorText() {
    return errorText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExpression() {
    return expression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMaxDateValue() {
    return maxDateValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getMaximumLength() {
    return maximumLength;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Float getMaximumValue() {
    return maximumValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getMiniDateValue() {
    return miniDateValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getMinimumLength() {
    return minimumLength;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Float getMinimumValue() {
    return minimumValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Float getNumberValue() {
    return numberValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getNumOfDecimalDigits() {
    return numOfDecimalDigits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getOperator() {
    return operator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getRegularExp() {
    return regularExp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTextValue() {
    return textValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((errorText != null) ? errorText.hashCode() : 0);
    result = (31 * result) + ((maximumLength != null) ? maximumLength.hashCode() : 0);
    result = (31 * result) + ((maximumValue != null) ? maximumValue.hashCode() : 0);
    result = (31 * result) + ((minimumLength != null) ? minimumLength.hashCode() : 0);
    result = (31 * result) + ((minimumValue != null) ? minimumValue.hashCode() : 0);
    result = (31 * result) + ((numberValue != null) ? numberValue.hashCode() : 0);
    result = (31 * result) + ((numOfDecimalDigits != null) ? numOfDecimalDigits.hashCode() : 0);
    result = (31 * result) + ((operator != null) ? operator.hashCode() : 0);
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + ((regularExp != null) ? regularExp.hashCode() : 0);
    result = (31 * result) + ((textValue != null) ? textValue.hashCode() : 0);
    result = (31 * result) + ((expression != null) ? expression.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dateValue  DOCUMENT ME!
   */
  public void setDateValue(Date dateValue) {
    this.dateValue = dateValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  errorText  DOCUMENT ME!
   */
  public void setErrorText(String errorText) {
    this.errorText = errorText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expression  DOCUMENT ME!
   */
  public void setExpression(String expression) {
    this.expression = expression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maxDateValue  DOCUMENT ME!
   */
  public void setMaxDateValue(Date maxDateValue) {
    this.maxDateValue = maxDateValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maximumLength  maxiDateValue DOCUMENT ME!
   */

  /**
   * DOCUMENT ME!
   *
   * @param  maximumLength  DOCUMENT ME!
   */
  public void setMaximumLength(Long maximumLength) {
    this.maximumLength = maximumLength;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maximumValue  DOCUMENT ME!
   */
  public void setMaximumValue(Float maximumValue) {
    this.maximumValue = maximumValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  miniDateValue  DOCUMENT ME!
   */
  public void setMiniDateValue(Date miniDateValue) {
    this.miniDateValue = miniDateValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  minimumLength  DOCUMENT ME!
   */
  public void setMinimumLength(Long minimumLength) {
    this.minimumLength = minimumLength;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  minimumValue  DOCUMENT ME!
   */
  public void setMinimumValue(Float minimumValue) {
    this.minimumValue = minimumValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  numberValue  DOCUMENT ME!
   */
  public void setNumberValue(Float numberValue) {
    this.numberValue = numberValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  numOfDecimalDigits  DOCUMENT ME!
   */
  public void setNumOfDecimalDigits(Integer numOfDecimalDigits) {
    this.numOfDecimalDigits = numOfDecimalDigits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  operator  DOCUMENT ME!
   */
  public void setOperator(String operator) {
    this.operator = operator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  priority  DOCUMENT ME!
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  regularExp  DOCUMENT ME!
   */
  public void setRegularExp(String regularExp) {
    this.regularExp = regularExp;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  textValue  DOCUMENT ME!
   */
  public void setTextValue(String textValue) {
    this.textValue = textValue;
  }
} // end class BasicAnswerValidator
