package com.ozstrategy.credagility.core.domain.workflow.customer;


import com.ozstrategy.credagility.core.domain.workflow.basic.BasicAnswerValidator;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  04/10/2017 11:23
 */
@Entity
@Table(name = "CustomerAnswerValidator")
public class CustomerAnswerValidator extends BasicAnswerValidator implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3191669270768271501L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name     = "taskElementId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTaskElement taskElement;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskElement getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskElement  DOCUMENT ME!
   */
  public void setTaskElement(CustomerWorkflowTaskElement taskElement) {
    this.taskElement = taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  validator  DOCUMENT ME!
   */
  public void update(CustomerAnswerValidator validator) {
    this.minimumLength      = validator.getMinimumLength();
    this.maximumLength      = validator.getMaximumLength();
    this.minimumValue       = validator.getMinimumValue();
    this.maximumValue       = validator.getMinimumValue();
    this.errorText          = validator.getErrorText();
    this.regularExp         = validator.getRegularExp();
    this.numOfDecimalDigits = validator.getNumOfDecimalDigits();

  }
} // end class CustomerAnswerValidator
