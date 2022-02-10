package com.ozstrategy.credagility.core.domain.workflow.customer.version;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicAnswerValidator;
import com.ozstrategy.credagility.core.domain.workflow.customer.CustomerAnswerValidator;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by tangwei on 17/3/6.
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  03/11/2017 10:39
 */
@Entity
@Table(name = "CustomerAnswerValidatorVersion")
public class CustomerAnswerValidatorVersion extends BasicAnswerValidator implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 4907878140133239875L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name     = "taskElementVersionId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private CustomerWorkflowTaskElementVersion taskElementVersion;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * copyFrom.
   *
   * @param  validator  CustomerAnswerValidator
   */
  public void copyFrom(CustomerAnswerValidator validator) {
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
   * getter method for task element version.
   *
   * @return  CustomerWorkflowTaskElementVersion
   */
  public CustomerWorkflowTaskElementVersion getTaskElementVersion() {
    return taskElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task element version.
   *
   * @param  taskElementVersion  CustomerWorkflowTaskElementVersion
   */
  public void setTaskElementVersion(CustomerWorkflowTaskElementVersion taskElementVersion) {
    this.taskElementVersion = taskElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("CustomerAnswerValidatorVersion{");
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
    sb.append(", taskElementVersion='").append(taskElementVersion).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class CustomerAnswerValidatorVersion
