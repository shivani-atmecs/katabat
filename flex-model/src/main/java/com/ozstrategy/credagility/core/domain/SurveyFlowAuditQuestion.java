package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.PortfolioQuestion;
import com.cmc.credagility.core.domain.portfolio.PortfolioSurvey;
import com.cmc.credagility.core.domain.portfolio.PortfolioSurveyAnswer;
import com.ozstrategy.credagility.core.domain.audit.FindingType;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowAuditingSeverity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * this class used for storage the audit result for flow.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 10:52
 */
@Entity
@Table(name = "SurveyFlowAuditQuestion")
public class SurveyFlowAuditQuestion extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 864077777717813548L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** to audit which PortfolioSurvey Answer. */
  @JoinColumn(
    name       = "answerId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioSurveyAnswer answer;

  /** Primary key. */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String comments;

  /** FindingType result. */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected FindingType finding;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** audit for which quesition. */
  @JoinColumn(
    name       = "questionId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioQuestion question;

  /** severity result. */
  @Column(
    length   = 32,
    nullable = true
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowAuditingSeverity severity = WorkflowAuditingSeverity.LOW;

  /** to audit which PortfolioSurvey. */
  @JoinColumn(
    name       = "surveyId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioSurvey survey;

  /** to audit which SurveyFlow Audit Step. */
  @JoinColumn(
    name       = "surveyFlowAuditStepId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowAuditStep surveyFlowAuditStep;

  // get from answer
  @Column private Integer answerHashCode;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * copy.
   *
   * @param  auditTaskElement  SurveyFlowAuditQuestion
   */
  public void copy(SurveyFlowAuditQuestion auditTaskElement) {
    this.setCreateDate(auditTaskElement.getCreateDate());
    this.setCreator(auditTaskElement.getCreator());
    this.setLastUpdateDate(new Date());
    this.setAnswerHashCode(auditTaskElement.getAnswerHashCode());
    this.setComments(auditTaskElement.getComments());
    this.setFinding(auditTaskElement.getFinding());
    this.setSeverity(auditTaskElement.getSeverity());
    this.setSurvey(auditTaskElement.getSurvey());
    this.setQuestion(auditTaskElement.getQuestion());
    this.setAnswerHashCode(auditTaskElement.getAnswerHashCode());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    SurveyFlowAuditQuestion that = (SurveyFlowAuditQuestion) o;

    if ((comments != null) ? (!comments.equals(that.comments)) : (that.comments != null)) {
      return false;
    }

    if ((finding != null) ? (!finding.equals(that.finding)) : (that.finding != null)) {
      return false;
    }

    if ((question != null) ? (!question.equals(that.question)) : (that.question != null)) {
      return false;
    }

    if ((answer != null) ? (!answer.equals(that.answer)) : (that.answer != null)) {
      return false;
    }

    if ((answerHashCode != null) ? (!answerHashCode.equals(that.answerHashCode)) : (that.answerHashCode != null)) {
      return false;
    }

    if (severity != that.severity) {
      return false;
    }

    if ((surveyFlowAuditStep != null) ? (!surveyFlowAuditStep.equals(that.surveyFlowAuditStep))
                                      : (that.surveyFlowAuditStep != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer.
   *
   * @return  PortfolioSurveyAnswer
   */
  public PortfolioSurveyAnswer getAnswer() {
    return answer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer hash code.
   *
   * @return  Integer
   */
  public Integer getAnswerHashCode() {
    return answerHashCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for comments.
   *
   * @return  String
   */
  public String getComments() {
    return comments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for finding.
   *
   * @return  FindingType
   */
  public FindingType getFinding() {
    return finding;
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
   * getter method for question.
   *
   * @return  PortfolioQuestion
   */
  public PortfolioQuestion getQuestion() {
    return question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for severity.
   *
   * @return  WorkflowAuditingSeverity
   */
  public WorkflowAuditingSeverity getSeverity() {
    return severity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey.
   *
   * @return  PortfolioSurvey
   */
  public PortfolioSurvey getSurvey() {
    return survey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey flow audit step.
   *
   * @return  SurveyFlowAuditStep
   */
  public SurveyFlowAuditStep getSurveyFlowAuditStep() {
    return surveyFlowAuditStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((comments != null) ? comments.hashCode() : 0);
    result = (31 * result) + ((finding != null) ? finding.hashCode() : 0);
    result = (31 * result) + ((question != null) ? question.hashCode() : 0);
    result = (31 * result) + ((answer != null) ? answer.hashCode() : 0);
    result = (31 * result) + ((severity != null) ? severity.hashCode() : 0);
    result = (31 * result) + ((surveyFlowAuditStep != null) ? surveyFlowAuditStep.hashCode() : 0);
    result = (31 * result) + ((answerHashCode != null) ? answerHashCode.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for answer.
   *
   * @param  answer  PortfolioSurveyAnswer
   */
  public void setAnswer(PortfolioSurveyAnswer answer) {
    this.answer = answer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for answer hash code.
   *
   * @param  answerHashCode  Integer
   */
  public void setAnswerHashCode(Integer answerHashCode) {
    this.answerHashCode = answerHashCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for comments.
   *
   * @param  comments  String
   */
  public void setComments(String comments) {
    this.comments = comments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for finding.
   *
   * @param  finding  FindingType
   */
  public void setFinding(FindingType finding) {
    this.finding = finding;
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
   * setter method for question.
   *
   * @param  question  PortfolioQuestion
   */
  public void setQuestion(PortfolioQuestion question) {
    this.question = question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for severity.
   *
   * @param  severity  WorkflowAuditingSeverity
   */
  public void setSeverity(WorkflowAuditingSeverity severity) {
    this.severity = severity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey.
   *
   * @param  survey  PortfolioSurvey
   */
  public void setSurvey(PortfolioSurvey survey) {
    this.survey = survey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey flow audit step.
   *
   * @param  surveyFlowAuditStep  SurveyFlowAuditStep
   */
  public void setSurveyFlowAuditStep(SurveyFlowAuditStep surveyFlowAuditStep) {
    this.surveyFlowAuditStep = surveyFlowAuditStep;
  }
} // end class SurveyFlowAuditQuestion
