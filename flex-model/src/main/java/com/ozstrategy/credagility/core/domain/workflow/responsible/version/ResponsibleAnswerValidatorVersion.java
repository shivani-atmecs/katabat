package com.ozstrategy.credagility.core.domain.workflow.responsible.version;

import com.cmc.credagility.core.domain.portfolio.PortfolioQuestionVersion;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicAnswerValidator;
import com.ozstrategy.credagility.core.domain.workflow.responsible.ResponsibleAnswerValidator;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Responsible Answer Validator Version.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 10:10
 */
@Entity
@Table(
  name    = "ResponsibleAnswerValidatorVersion",
  indexes = {
    @Index(
      name = "IDX_QUESTION_PRIORITY_ID",
      columnList = "portfolioQuestionId, priority, id"
    )
  }
)
public class ResponsibleAnswerValidatorVersion extends BasicAnswerValidator implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2774493694210882465L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** PortfolioQuestionVersion. */
  @JoinColumn(
    name     = "portfolioQuestionId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioQuestionVersion portfolioQuestion;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  validator  DOCUMENT ME!
   */
  public void copyFrom(ResponsibleAnswerValidator validator) {
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
   * getter method for portfolio question.
   *
   * @return  PortfolioQuestionVersion
   */
  public PortfolioQuestionVersion getPortfolioQuestion() {
    return portfolioQuestion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio question.
   *
   * @param  portfolioQuestion  PortfolioQuestionVersion
   */
  public void setPortfolioQuestion(PortfolioQuestionVersion portfolioQuestion) {
    this.portfolioQuestion = portfolioQuestion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("PortfolioQuestionVersion{");
    sb.append("minimumLength=").append(minimumLength);
    sb.append(", maximumLength=").append(maximumLength);
    sb.append(", minimumValue=").append(minimumValue);
    sb.append(", maximumValue='").append(maximumValue);
    sb.append(", numberValue='").append(numberValue);
    sb.append(", priority='").append(priority);
    sb.append(", operator='").append(operator);
    sb.append(", textValue='").append(textValue);
    sb.append(", errorText=").append(errorText);
    sb.append(", regularExp='").append(regularExp);
    sb.append(", id=").append(id);
    sb.append(", numOfDecimalDigits='").append(numOfDecimalDigits).append('\'');
    sb.append(", portfolioQuestion='").append(portfolioQuestion).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class ResponsibleAnswerValidatorVersion
