package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicAnswerValidator;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/17/2014 11:23
 */
@Entity
@Table(name = "EnterpriseAnswerValidator")
public class EnterpriseAnswerValidator extends BasicAnswerValidator implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4255851211298168349L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "taskElementId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTaskElement taskElement;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * EnterpriseWorkflowTaskElement.
   *
   * @return  EnterpriseWorkflowTaskElement.
   */
  public EnterpriseWorkflowTaskElement getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTaskElement.
   *
   * @param  taskElement  $param.type$
   */
  public void setTaskElement(EnterpriseWorkflowTaskElement taskElement) {
    this.taskElement = taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  validator  $param.type$
   */
  public void update(EnterpriseAnswerValidator validator) {
    this.minimumLength      = validator.getMinimumLength();
    this.maximumLength      = validator.getMaximumLength();
    this.minimumValue       = validator.getMinimumValue();
    this.maximumValue       = validator.getMinimumValue();
    this.errorText          = validator.getErrorText();
    this.regularExp         = validator.getRegularExp();
    this.numOfDecimalDigits = validator.getNumOfDecimalDigits();

  }
} // end class EnterpriseAnswerValidator
