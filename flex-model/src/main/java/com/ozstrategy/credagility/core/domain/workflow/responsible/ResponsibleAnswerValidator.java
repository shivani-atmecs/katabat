package com.ozstrategy.credagility.core.domain.workflow.responsible;

import com.cmc.credagility.core.domain.portfolio.PortfolioQuestion;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicAnswerValidator;

import javax.persistence.*;
import java.io.Serializable;


/**
 * ResponsibleAnswer Validator.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 10:15
 */
@Entity
@Table(
  name    = "ResponsibleAnswerValidator",
  indexes = {
    @Index(
      name = "IDX_QUESTION_PRIORITY_ID",
      columnList = "portfolioQuestionId, priority, id"
    )
  }
)
public class ResponsibleAnswerValidator extends BasicAnswerValidator implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6638887156517470629L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** PortfolioQuestion. */
  @JoinColumn(
    name     = "portfolioQuestionId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioQuestion portfolioQuestion;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio question.
   *
   * @return  PortfolioQuestion
   */
  public PortfolioQuestion getPortfolioQuestion() {
    return portfolioQuestion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio question.
   *
   * @param  portfolioQuestion  PortfolioQuestion
   */
  public void setPortfolioQuestion(PortfolioQuestion portfolioQuestion) {
    this.portfolioQuestion = portfolioQuestion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  validator  ResponsibleAnswerValidator
   */
  public void update(ResponsibleAnswerValidator validator) {
    this.minimumLength      = validator.getMinimumLength();
    this.maximumLength      = validator.getMaximumLength();
    this.minimumValue       = validator.getMinimumValue();
    this.maximumValue       = validator.getMinimumValue();
    this.errorText          = validator.getErrorText();
    this.regularExp         = validator.getRegularExp();
    this.numOfDecimalDigits = validator.getNumOfDecimalDigits();

  }
} // end class ResponsibleAnswerValidator
