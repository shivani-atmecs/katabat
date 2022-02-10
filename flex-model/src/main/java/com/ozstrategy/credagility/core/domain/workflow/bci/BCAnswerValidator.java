package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicAnswerValidator;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 2/21/14 Time: 3:48 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCAnswerValidator")
public class BCAnswerValidator extends BasicAnswerValidator implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3191669270768271501L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** BCWorkflowTaskElement PK taskElementId. */
  @JoinColumn(
    name     = "taskElementId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTaskElement taskElement;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskElement getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskElement  DOCUMENT ME!
   */
  public void setTaskElement(BCWorkflowTaskElement taskElement) {
    this.taskElement = taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  validator  DOCUMENT ME!
   */
  public void update(BCAnswerValidator validator) {
    this.minimumLength      = validator.getMinimumLength();
    this.maximumLength      = validator.getMaximumLength();
    this.minimumValue       = validator.getMinimumValue();
    this.maximumValue       = validator.getMinimumValue();
    this.errorText          = validator.getErrorText();
    this.regularExp         = validator.getRegularExp();
    this.numOfDecimalDigits = validator.getNumOfDecimalDigits();

  }
} // end class BCAnswerValidator
