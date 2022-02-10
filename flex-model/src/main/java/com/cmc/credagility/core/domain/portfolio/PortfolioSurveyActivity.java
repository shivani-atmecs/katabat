package com.cmc.credagility.core.domain.portfolio;

import java.util.Date;

import com.cmc.credagility.core.domain.activity.BaseActivity;
import com.cmc.credagility.core.domain.user.User;


/**
 * This class is used to log all survey activity.
 *
 * <p><a href="SurveyActivity.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/16/2014 10:37
 */
public class PortfolioSurveyActivity extends BaseActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7963653005972595483L;

  /** activity type. */
  private static String CHANNEL = "PortfolioSurvey";

  /** activity type. */
  private static String NAME = "PorfolioSurveyActivity";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Survey code. */
  protected User agent;

  /** answer data. */
  protected String answer;

  /** Activity PK answerId. */
  protected Long answerId;

  /** PortfolioQuestion PK question. */
  protected String question;

  /** Survey questionId. */
  protected Long questionId;

  /** Survey code. */
  protected String surveyCode;

  /** Survey date. */
  protected Date surveyDate;

  /** Survey name. */
  protected String surveyName;

  /** Survey round. */
  protected Integer surveyRound;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#equals(java.lang.Object)
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

    PortfolioSurveyActivity that = (PortfolioSurveyActivity) o;

    if ((answer != null) ? (!answer.equals(that.answer)) : (that.answer != null)) {
      return false;
    }

    if ((question != null) ? (!question.equals(that.question)) : (that.question != null)) {
      return false;
    }

    if ((surveyDate != null) ? (!surveyDate.equals(that.surveyDate)) : (that.surveyDate != null)) {
      return false;
    }

    if ((surveyRound != null) ? (!surveyRound.equals(that.surveyRound)) : (that.surveyRound != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent.
   *
   * @return  User
   */
  public User getAgent() {
    return agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAnswer() {
    return answer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the answerId
   */
  public Long getAnswerId() {
    return this.answerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * return activity type.
   *
   * @return  DOCUMENT ME!
   *
   * @see     BaseActivity#getChannel()
   */
  @Override public String getChannel() {
    return CHANNEL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see com.cmc.credagility.BaseActivity#getName()
   */
  @Override public String getName() {
    return NAME;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getQuestion() {
    return question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the questionId
   */
  public Long getQuestionId() {
    return this.questionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey code.
   *
   * @return  String
   */
  public String getSurveyCode() {
    return surveyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getSurveyDate() {
    return surveyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey name.
   *
   * @return  String
   */
  public String getSurveyName() {
    return surveyName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getSurveyRound() {
    return surveyRound;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((question != null) ? question.hashCode() : 0);
    result = (31 * result) + ((answer != null) ? answer.hashCode() : 0);
    result = (31 * result) + ((surveyRound != null) ? surveyRound.hashCode() : 0);
    result = (31 * result) + ((surveyDate != null) ? surveyDate.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioSurveyAnswer  DOCUMENT ME!
   */
  public void populate(PortfolioSurveyAnswer portfolioSurveyAnswer) {
    this.responsible     = portfolioSurveyAnswer.getResponsible();
    this.account         = portfolioSurveyAnswer.getResponsible().getAccount();
    this.balance         = portfolioSurveyAnswer.getBalance();
    this.delinquencyDays = portfolioSurveyAnswer.getDelinquencyDays();
    this.questionId      = portfolioSurveyAnswer.getQuestion().getId();
    this.question        = portfolioSurveyAnswer.getQuestion().getQuestionText();
    this.answerId        = portfolioSurveyAnswer.getAnswerId();
    this.answer          = portfolioSurveyAnswer.getData();
    this.surveyDate      = portfolioSurveyAnswer.getSurveyDate();
    this.surveyRound     = portfolioSurveyAnswer.getSurveyRound();
    this.createDate      = portfolioSurveyAnswer.getCreateDate();
    this.lastUpdateDate  = portfolioSurveyAnswer.getLastUpdateDate();
    this.surveyName      = portfolioSurveyAnswer.getSurveyName();
    this.surveyCode      = portfolioSurveyAnswer.getSurveyCode();
    this.agent           = portfolioSurveyAnswer.getAgent();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent.
   *
   * @param  agent  User
   */
  public void setAgent(User agent) {
    this.agent = agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerId  the answerId to set
   */
  public void setAnswerId(Long answerId) {
    this.answerId = answerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  questionId  the questionId to set
   */
  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey code.
   *
   * @param  surveyCode  String
   */
  public void setSurveyCode(String surveyCode) {
    this.surveyCode = surveyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey name.
   *
   * @param  surveyName  String
   */
  public void setSurveyName(String surveyName) {
    this.surveyName = surveyName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PortfolioSurveyActivity");
    sb.append("{questionId=").append(questionId);
    sb.append(", question='").append(question).append('\'');
    sb.append(", answerId=").append(answerId);
    sb.append(", answer='").append(answer).append('\'');
    sb.append(", surveyRound=").append(surveyRound);
    sb.append(", surveyDate=").append(surveyDate);
    sb.append('}');

    return sb.toString();
  }
} // end class PortfolioSurveyActivity
