package com.cmc.credagility.core.domain.survey;

import com.cmc.credagility.core.domain.activity.BaseActivity;
import com.cmc.credagility.core.domain.portfolio.PortfolioSurveyAnswer;


/**
 * This class is used to log all survey activity.
 *
 * <p><a href="SurveyActivity.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/15/2014 15:15
 */
public class SurveyActivity extends BaseActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7963653005972595483L;

  private static String CHANNEL = "Survey";

  private static String NAME = "SurveyActivity";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Long answerId;

  /** TODO: DOCUMENT ME! */
  protected String data1;

  /** TODO: DOCUMENT ME! */
  protected String data2;

  /** TODO: DOCUMENT ME! */
  protected String data3;

  /** TODO: DOCUMENT ME! */
  protected String data4;

  /** TODO: DOCUMENT ME! */
  protected String data5;

  /** TODO: DOCUMENT ME! */
  protected Long questionId;

  /** TODO: DOCUMENT ME! */
  protected String surveyCode;

  /** TODO: DOCUMENT ME! */
  protected String surveyName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final SurveyActivity other = (SurveyActivity) obj;

    if (this.answerId == null) {
      if (other.getAnswerId() != null) {
        return false;
      }
    } else if (!this.answerId.equals(other.getAnswerId())) {
      return false;
    }

    if (this.data1 == null) {
      if (other.getData1() != null) {
        return false;
      }
    } else if (!this.data1.equals(other.getData1())) {
      return false;
    }

    if (this.data2 == null) {
      if (other.getData2() != null) {
        return false;
      }
    } else if (!this.data2.equals(other.getData2())) {
      return false;
    }

    if (this.data3 == null) {
      if (other.getData3() != null) {
        return false;
      }
    } else if (!this.data3.equals(other.getData3())) {
      return false;
    }

    if (this.data4 == null) {
      if (other.getData4() != null) {
        return false;
      }
    } else if (!this.data4.equals(other.getData4())) {
      return false;
    }

    if (this.data5 == null) {
      if (other.getData5() != null) {
        return false;
      }
    } else if (!this.data5.equals(other.getData5())) {
      return false;
    }

    if (this.questionId == null) {
      if (other.getQuestionId() != null) {
        return false;
      }
    } else if (!this.questionId.equals(other.getQuestionId())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer id.
   *
   * @return  Long
   */
  public Long getAnswerId() {
    return this.answerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#getChannel()
   */
  @Override public String getChannel() {
    return CHANNEL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data1.
   *
   * @return  String
   */
  public String getData1() {
    return this.data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data2.
   *
   * @return  String
   */
  public String getData2() {
    return this.data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data3.
   *
   * @return  String
   */
  public String getData3() {
    return this.data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data4.
   *
   * @return  String
   */
  public String getData4() {
    return this.data4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data5.
   *
   * @return  String
   */
  public String getData5() {
    return this.data5;
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
   * getter method for question id.
   *
   * @return  Long
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
   * getter method for survey name.
   *
   * @return  String
   */
  public String getSurveyName() {
    return surveyName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((this.answerId == null) ? 0 : this.answerId.hashCode());
    result = (prime * result)
      + ((this.data1 == null) ? 0 : this.data1.hashCode());
    result = (prime * result)
      + ((this.data2 == null) ? 0 : this.data2.hashCode());
    result = (prime * result)
      + ((this.data3 == null) ? 0 : this.data3.hashCode());
    result = (prime * result)
      + ((this.data4 == null) ? 0 : this.data4.hashCode());
    result = (prime * result)
      + ((this.data5 == null) ? 0 : this.data5.hashCode());
    result = (prime * result)
      + ((this.questionId == null) ? 0 : this.questionId.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * populate.
   *
   * @param  surveyAnswer  SurveyAnswer
   */
  public void populate(SurveyAnswer surveyAnswer) {
    this.responsible     = surveyAnswer.getResponsible();
    this.account         = surveyAnswer.getResponsible().getAccount();
    this.balance         = surveyAnswer.getBalance();
    this.delinquencyDays = surveyAnswer.getDelinquencyDays();
    this.questionId      = surveyAnswer.getSurveyQuestion().getSurveyQuestionId();
    this.answerId        = surveyAnswer.getSurveyAnswerId();
    this.data1           = surveyAnswer.getData1();
    this.data2           = surveyAnswer.getData2();
    this.data3           = surveyAnswer.getData3();
    this.data4           = surveyAnswer.getData4();
    this.data5           = surveyAnswer.getData5();
    this.createDate      = surveyAnswer.getCreateDate();
    this.lastUpdateDate  = surveyAnswer.getLastUpdateDate();
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
    this.answerId        = portfolioSurveyAnswer.getAnswerId();
    this.data1           = portfolioSurveyAnswer.getData();
    this.data2           = portfolioSurveyAnswer.getSurveyRound().toString();
    this.data3           = portfolioSurveyAnswer.getSurveyDate().toString();
    this.createDate      = portfolioSurveyAnswer.getCreateDate();
    this.lastUpdateDate  = portfolioSurveyAnswer.getLastUpdateDate();
    portfolioSurveyAnswer.getSurveyName();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for answer id.
   *
   * @param  answerId  Long
   */
  public void setAnswerId(Long answerId) {
    this.answerId = answerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data1.
   *
   * @param  data1  String
   */
  public void setData1(String data1) {
    this.data1 = data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data2.
   *
   * @param  data2  String
   */
  public void setData2(String data2) {
    this.data2 = data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data3.
   *
   * @param  data3  String
   */
  public void setData3(String data3) {
    this.data3 = data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data4.
   *
   * @param  data4  String
   */
  public void setData4(String data4) {
    this.data4 = data4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data5.
   *
   * @param  data5  String
   */
  public void setData5(String data5) {
    this.data5 = data5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for question id.
   *
   * @param  questionId  Long
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
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("SurveyActivity ( ").append(super.toString()).append(TAB).append("answerId = ").append(
      this.answerId).append(TAB).append(
      "data1 = ").append(this.data1).append(TAB).append("data2 = ").append(this.data2).append(TAB).append("data3 = ")
      .append(this.data3).append(TAB).append("data4 = ").append(this.data4).append(TAB).append(
      "data5 = ").append(this.data5).append(TAB).append("questionId = ").append(this.questionId).append(TAB).append(
      " )");

    return retValue.toString();
  }
} // end class SurveyActivity
