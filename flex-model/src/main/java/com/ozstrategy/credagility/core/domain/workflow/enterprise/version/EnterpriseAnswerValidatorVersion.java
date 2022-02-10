package com.ozstrategy.credagility.core.domain.workflow.enterprise.version;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicAnswerValidator;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseAnswerValidator;

import javax.persistence.*;
import java.io.Serializable;


/**
 * EnterpriseAnswer Validator Version.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 10:45
 */
@Entity
@Table(name = "EnterpriseAnswerValidatorVersion")
public class EnterpriseAnswerValidatorVersion extends BasicAnswerValidator implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 949886774451322201L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Enterprise WorkflowTask ElementVersion. */
  @JoinColumn(
    name     = "taskElementId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTaskElementVersion taskElement;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * copyFrom.
   *
   * @param  validator  EnterpriseAnswerValidator
   */
  public void copyFrom(EnterpriseAnswerValidator validator) {
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
    this.miniDateValue      = validator.getMiniDateValue();
    this.maxDateValue       = validator.getMaxDateValue();
    this.expression         = validator.getExpression();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task element.
   *
   * @return  EnterpriseWorkflowTaskElementVersion
   */
  public EnterpriseWorkflowTaskElementVersion getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task element.
   *
   * @param  taskElement  EnterpriseWorkflowTaskElementVersion
   */
  public void setTaskElement(EnterpriseWorkflowTaskElementVersion taskElement) {
    this.taskElement = taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("EnterpriseWorkflowTaskAnswerOptionVersion{");
    sb.append("minimumLength=").append(minimumLength);
    sb.append(", maximumLength=").append(maximumLength);
    sb.append(", minimumValue=").append(minimumValue);
    sb.append(", maximumValue='").append(maximumValue);
    sb.append(", numberValue='").append(numberValue);
    sb.append(", dateValue=").append(dateValue);
    sb.append(", maxDateValue='").append(maxDateValue);
    sb.append(", miniDateValue='").append(miniDateValue);
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
} // end class EnterpriseAnswerValidatorVersion
