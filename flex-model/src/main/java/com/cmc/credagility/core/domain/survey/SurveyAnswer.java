package com.cmc.credagility.core.domain.survey;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.activity.AgentCallActivity;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * This class is used to represent survey answers. Survey answers are a collection of facts collected by the survey
 * questions. It may be more appropriate to call them survey facts. These facts do not care how you organize the
 * questions - facts are facts. You can organize them as multiple choice, single choice, or drop down choice in the JSP.
 * Each choice represents a fact and will be gathered in this class.
 *
 * <p><a href="SurveyAnswer.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:yzhang@bridgeforce.com">Ye Zhang</a>
 * @version  10/15/2014 15:20
 */
@Entity
@Table(name = "SurveyAnswer")
public class SurveyAnswer extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2490005346279599224L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "activityId",
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgentCallActivity agentCallActivity;

  /** Survey answer data. */

  @Column(name = "balance")
  protected BigDecimal balance;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data1",
    length = 512
  )
  protected String data1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data2",
    length = 512
  )
  protected String data2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data3",
    length = 512
  )
  protected String data3;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data4",
    length = 512
  )
  protected String data4;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data5",
    length = 512
  )
  protected String data5;

  /** TODO: DOCUMENT ME! */
  @Column(name = "delinquencyDays")
  protected Integer delinquencyDays;

  /** Responsible party submitted this survey. */
  @JoinColumn(
    name      = "responsibleId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** Primary key. */

  // npelleti, 07/30, USBank, Removed unique constraint
  @Column(
    name     = "surveyAnswerId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long surveyAnswerId;

  /** Question for this survey. */
  @JoinColumn(
    name      = "surveyQuestionId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyQuestion surveyQuestion = new SurveyQuestion();

  /** Used in UI automatic binding. No need to persist. */
  @Transient protected boolean validAnswer = false;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
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

    final SurveyAnswer other = (SurveyAnswer) obj;

    if (data1 == null) {
      if (other.getData1() != null) {
        return false;
      }
    } else if (!data1.equals(other.getData1())) {
      return false;
    }

    if (data2 == null) {
      if (other.getData2() != null) {
        return false;
      }
    } else if (!data2.equals(other.getData2())) {
      return false;
    }

    if (data3 == null) {
      if (other.getData3() != null) {
        return false;
      }
    } else if (!data3.equals(other.getData3())) {
      return false;
    }

    if (data4 == null) {
      if (other.getData4() != null) {
        return false;
      }
    } else if (!data4.equals(other.getData4())) {
      return false;
    }

    if (data5 == null) {
      if (other.getData5() != null) {
        return false;
      }
    } else if (!data5.equals(other.getData5())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AgentCallActivity getAgentCallActivity() {
    return agentCallActivity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBalance() {
    return balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data1.
   *
   * @return  String
   */
  public String getData1() {
    return data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data2.
   *
   * @return  String
   */
  public String getData2() {
    return data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data3.
   *
   * @return  String
   */
  public String getData3() {
    return data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data4.
   *
   * @return  String
   */
  public String getData4() {
    return data4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data5.
   *
   * @return  String
   */
  public String getData5() {
    return data5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquency days.
   *
   * @return  Integer
   */
  public Integer getDelinquencyDays() {
    return delinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey answer id.
   *
   * @return  Long
   */
  public Long getSurveyAnswerId() {
    return surveyAnswerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey question.
   *
   * @return  SurveyQuestion
   */
  public SurveyQuestion getSurveyQuestion() {
    return surveyQuestion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = super.hashCode();
    result = (PRIME * result) + ((data1 == null) ? 0 : data1.hashCode());
    result = (PRIME * result) + ((data2 == null) ? 0 : data2.hashCode());
    result = (PRIME * result) + ((data3 == null) ? 0 : data3.hashCode());
    result = (PRIME * result) + ((data4 == null) ? 0 : data4.hashCode());
    result = (PRIME * result) + ((data5 == null) ? 0 : data5.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Whether this answer has at least one meaningful data field.
   *
   * @return  whether this answer has at least one meaningful data field.
   */
  public boolean hasValidData() {
    return StringUtils.hasText(data1) || StringUtils.hasText(data2)
      || StringUtils.hasText(data3) || StringUtils.hasText(data4)
      || StringUtils.hasText(data5);

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for valid answer.
   *
   * @return  boolean
   */
  public boolean isValidAnswer() {
    return validAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent call activity.
   *
   * @param  agentCallActivity  AgentCallActivity
   */
  public void setAgentCallActivity(AgentCallActivity agentCallActivity) {
    this.agentCallActivity = agentCallActivity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for balance.
   *
   * @param  balance  BigDecimal
   */
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
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
   * setter method for delinquency days.
   *
   * @param  delinquencyDays  Integer
   */
  public void setDelinquencyDays(Integer delinquencyDays) {
    this.delinquencyDays = delinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey answer id.
   *
   * @param  surveyAnswerId  Long
   */
  public void setSurveyAnswerId(Long surveyAnswerId) {
    this.surveyAnswerId = surveyAnswerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey question.
   *
   * @param  surveyQuestion  SurveyQuestion
   */
  public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
    this.surveyQuestion = surveyQuestion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for valid answer.
   *
   * @param  validAnswer  boolean
   */
  public void setValidAnswer(boolean validAnswer) {
    this.validAnswer = validAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("SurveyAnswer ( ").append(super.toString()).append(TAB).append("data1 = ").append(this.data1)
      .append(TAB).append("data2 = ").append(this.data2).append(TAB).append("data3 = ").append(this.data3).append(TAB)
      .append("data4 = ").append(this.data4).append(TAB).append(
      "data5 = ").append(this.data5).append(TAB).append("questionId = ").append(this.surveyQuestion
      .getSurveyQuestionId()).append(
      "questionText = ").append(
      this.surveyQuestion.getSurveyQuestionText()).append(TAB).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class SurveyAnswer
