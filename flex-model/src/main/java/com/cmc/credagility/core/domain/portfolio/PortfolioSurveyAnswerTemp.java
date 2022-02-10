package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * This class is used to represent unfinished survey answers, so that customer can come to fill the survey again. Each
 * choice represents a fact and will be gathered in this class.
 *
 * <p><a href="PortfolioSurveyAnswerTemp.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojerluo@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
@Entity @Table public class PortfolioSurveyAnswerTemp extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5233381072747839222L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  // npelleti 08/16 USB moved balance after data.
  /** Account's balance. */
  @Column protected BigDecimal balance;

  /** Survey answer data. */
  @Column(length = 2048)
  protected String data;

  /** Delinquency Days. */
  @Column protected Integer delinquencyDays;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Question for this survey. */
  @JoinColumn(
    name      = "questionId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioQuestion question = new PortfolioQuestion();

  /** Responsible party submitted this survey. */
  @JoinColumn(
    name      = "responsibleId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** Survey taking date. */
  @Column(
    nullable  = false,
    updatable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date surveyDate;

  /** Survey taking round. */
  @Column(nullable = false)
  protected Integer surveyRound = 0;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioSurveyAnswerTemp)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioSurveyAnswerTemp answer = (PortfolioSurveyAnswerTemp) o;

    if ((data != null) ? (!data.equals(answer.data)) : (answer.data != null)) {
      return false;
    }

    if ((surveyDate != null) ? (!surveyDate.equals(answer.surveyDate)) : (answer.surveyDate != null)) {
      return false;
    }

    if ((question != null) ? (!question.equals(answer.question)) : (answer.question != null)) {
      return false;
    }

    if ((surveyRound != null) ? (!surveyRound.equals(answer.surveyRound)) : (answer.surveyRound != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>not-null = "false"</p>
   */
  public BigDecimal getBalance() {
    return balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>length = "512"</p>
   */
  public String getData() {
    return data;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>not-null = "false"</p>
   */
  public Integer getDelinquencyDays() {
    return delinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioQuestion getQuestion() {
    return question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>lazy = "proxy" column = "responsibleId" not-null = "true" class = "com.cmc.credagility.Responsible"
   *          update = "false"</p>
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>not-null = "true" update = "false"</p>
   */
  public Date getSurveyDate() {
    return surveyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>lazy = "proxy" column = "questionId" not-null = "true" class = "com.cmc.credagility.PortfolioQuestion"
   *          update = "false"</p>
   */
  public PortfolioQuestion getSurveyQuestion() {
    return question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getSurveyRound() {
    return surveyRound;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((question != null) ? question.hashCode() : 0);
    result = (31 * result) + ((data != null) ? data.hashCode() : 0);
    result = (31 * result) + ((surveyDate != null) ? surveyDate.hashCode() : 0);
    result = (31 * result) + ((surveyRound != null) ? surveyRound.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  balance  DOCUMENT ME!
   */
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data  DOCUMENT ME!
   */
  public void setData(String data) {
    this.data = data;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  delinquencyDays  DOCUMENT ME!
   */
  public void setDelinquencyDays(Integer delinquencyDays) {
    this.delinquencyDays = delinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  question  DOCUMENT ME!
   */
  public void setQuestion(PortfolioQuestion question) {
    this.question = question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  responsible  DOCUMENT ME!
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  surveyDate  DOCUMENT ME!
   */
  public void setSurveyDate(Date surveyDate) {
    this.surveyDate = surveyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  question  DOCUMENT ME!
   */
  public void setSurveyQuestion(PortfolioQuestion question) {
    this.question = question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  surveyRound  DOCUMENT ME!
   */
  public void setSurveyRound(Integer surveyRound) {
    this.surveyRound = surveyRound;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PortfolioSurveyAnswer");
    sb.append("{Id=").append(id);
    sb.append(", question=").append(question);
    sb.append(", responsible=").append(responsible);
    sb.append(", data='").append(data).append('\'');
    sb.append(", surveyDate=").append(surveyDate);
    sb.append(", surveyRound=").append(surveyRound);
    sb.append(", balance=").append(balance);
    sb.append(", delinquencyDays=").append(delinquencyDays);
    sb.append('}');

    return sb.toString();
  }
} // end class PortfolioSurveyAnswerTemp
