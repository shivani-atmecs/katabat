package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.PortfolioQuestion;
import com.cmc.credagility.core.domain.portfolio.PortfolioQuestionVersion;
import com.cmc.credagility.core.domain.portfolio.PortfolioSurveyVersion;
import com.ozstrategy.credagility.core.annotations.EvaluateMessageProperty;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Survey flow Step TaskElement Snapshot.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 16:11
 */
@Entity @Table public class SurveyflowStepTaskElementSnapshot implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2463933343181953275L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** PK. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** is active. */
  @Transient protected boolean inactive;


  /** PortfolioQuestion. */
  @JoinColumn(
    name       = "taskElementId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioQuestion portfolioQuestion;


  /** PortfolioQuestionVersion. */
  @JoinColumn(
    name       = "taskElementVersionId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioQuestionVersion portfolioQuestionVersion;


  /** PortfolioSurveyVersion. */
  @JoinColumn(
    name       = "taskVersionId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioSurveyVersion portfolioSurveyVersion;


  /** questionText. */
  @Column(columnDefinition = "LONGTEXT")
  @EvaluateMessageProperty @Lob protected String questionText;


  /** questionText2. */
  @Column(columnDefinition = "LONGTEXT")
  @EvaluateMessageProperty @Lob protected String questionText2;


  /** SurveyFlowStep. */
  @JoinColumn(
    name       = "stepId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowStep surveyFlowStep;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new SurveyflowStepTaskElementSnapshot object.
   */
  public SurveyflowStepTaskElementSnapshot() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * copy.
   *
   * @return  SurveyflowStepTaskElementSnapshot
   */
  public SurveyflowStepTaskElementSnapshot copy() {
    SurveyflowStepTaskElementSnapshot elementSnapshot = new SurveyflowStepTaskElementSnapshot();
    elementSnapshot.setPortfolioQuestionVersion(this.getPortfolioQuestionVersion());
    elementSnapshot.setPortfolioSurveyVersion(this.getPortfolioSurveyVersion());
    elementSnapshot.setQuestionText(this.getQuestionText());
    elementSnapshot.setQuestionText2(this.getQuestionText2());
    elementSnapshot.setPortfolioQuestion(this.getPortfolioQuestion());

    return elementSnapshot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for portfolio question version.
   *
   * @return  PortfolioQuestionVersion
   */
  public PortfolioQuestionVersion getPortfolioQuestionVersion() {
    return portfolioQuestionVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio survey version.
   *
   * @return  PortfolioSurveyVersion
   */
  public PortfolioSurveyVersion getPortfolioSurveyVersion() {
    return portfolioSurveyVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for question text.
   *
   * @return  String
   */
  public String getQuestionText() {
    return questionText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for question text2.
   *
   * @return  String
   */
  public String getQuestionText2() {
    return questionText2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey flow step.
   *
   * @return  SurveyFlowStep
   */
  public SurveyFlowStep getSurveyFlowStep() {
    return surveyFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for inactive.
   *
   * @return  boolean
   */
  public boolean isInactive() {
    return inactive;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for inactive.
   *
   * @param  inactive  boolean
   */
  public void setInactive(boolean inactive) {
    this.inactive = inactive;
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
   * setter method for portfolio question version.
   *
   * @param  portfolioQuestionVersion  PortfolioQuestionVersion
   */
  public void setPortfolioQuestionVersion(PortfolioQuestionVersion portfolioQuestionVersion) {
    this.portfolioQuestionVersion = portfolioQuestionVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio survey version.
   *
   * @param  portfolioSurveyVersion  PortfolioSurveyVersion
   */
  public void setPortfolioSurveyVersion(PortfolioSurveyVersion portfolioSurveyVersion) {
    this.portfolioSurveyVersion = portfolioSurveyVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for question text.
   *
   * @param  questionText  String
   */
  public void setQuestionText(String questionText) {
    this.questionText = questionText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for question text2.
   *
   * @param  questionText2  String
   */
  public void setQuestionText2(String questionText2) {
    this.questionText2 = questionText2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey flow step.
   *
   * @param  surveyFlowStep  SurveyFlowStep
   */
  public void setSurveyFlowStep(SurveyFlowStep surveyFlowStep) {
    this.surveyFlowStep = surveyFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("SurveyflowStepTaskElementSnapshot{");
    sb.append("id=").append(id);
    sb.append(", questionText2='").append(questionText2).append('\'');
    sb.append(", questionText='").append(questionText).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class SurveyflowStepTaskElementSnapshot
