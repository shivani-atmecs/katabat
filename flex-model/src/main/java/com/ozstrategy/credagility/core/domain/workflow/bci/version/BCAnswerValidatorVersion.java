package com.ozstrategy.credagility.core.domain.workflow.bci.version;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicAnswerValidator;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCAnswerValidator;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 2/21/14 Time: 3:50 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCAnswerValidatorVersion")
public class BCAnswerValidatorVersion extends BasicAnswerValidator implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 577247940710967220L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** BCWorkflowTaskElementVersion PK taskElementId. */
  @JoinColumn(
    name     = "taskElementId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTaskElementVersion taskElement;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  validator  DOCUMENT ME!
   */
  public void copyFrom(BCAnswerValidator validator) {
    this.minimumValue       = validator.getMinimumValue();
    this.maximumValue       = validator.getMaximumValue();
    this.maximumLength      = validator.getMaximumLength();
    this.minimumLength      = validator.getMinimumLength();
    this.numOfDecimalDigits = validator.getNumOfDecimalDigits();
    this.regularExp         = validator.getRegularExp();
    this.errorText          = validator.getErrorText();
    this.operator           = validator.getOperator();
    this.textValue          = validator.getTextValue();
    this.numberValue        = validator.getNumberValue();
    this.priority           = validator.getPriority();
    this.dateValue          = validator.getDateValue();
    this.maxDateValue       = validator.getMaxDateValue();
    this.miniDateValue      = validator.getMiniDateValue();
    this.dateValue          = validator.getDateValue();
    this.expression         = validator.getExpression();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskElementVersion getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskElement  DOCUMENT ME!
   */
  public void setTaskElement(BCWorkflowTaskElementVersion taskElement) {
    this.taskElement = taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("BCWorkflowTaskElementVersion{");
    sb.append("minimumLength=").append(minimumLength);
    sb.append(", maximumLength=").append(maximumLength);
    sb.append(", minimumValue=").append(minimumValue);
    sb.append(", maximumValue='").append(maximumValue);
    sb.append(", numberValue='").append(numberValue);
    sb.append(", dateValue=").append(dateValue);
    sb.append(", miniDateValue='").append(miniDateValue);
    sb.append(", maxDateValue='").append(maxDateValue);
    sb.append(", priority='").append(priority);
    sb.append(", operator='").append(operator);
    sb.append(", textValue='").append(textValue);
    sb.append(", errorText=").append(errorText);
    sb.append(", regularExp='").append(regularExp);
    sb.append(", id=").append(id);
    sb.append(", numOfDecimalDigits='").append(numOfDecimalDigits).append('\'');
    sb.append(", taskElement='").append(taskElement).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class BCAnswerValidatorVersion
