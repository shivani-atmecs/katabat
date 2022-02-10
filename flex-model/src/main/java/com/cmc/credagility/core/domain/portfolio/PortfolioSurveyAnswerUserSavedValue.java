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
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * Created by IntelliJ IDEA. User: liaodongming Date: 12-1-5 Time: PM2:27 To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name    = "PortfolioSurveyAnswerUserSavedValue",
  indexes = {
    @Index(
      name = "IDX_RESP_CREATEDATE",
      columnList = "responsibleId, createDate"
    ),
    @Index(
      name = "IDX_RESP_QUESTION",
      columnList = "responsibleId, questionId"
    ),
    @Index(
      name = "FKD2_responsibleId",
      columnList = "responsibleId"
    )
  }
)
public class PortfolioSurveyAnswerUserSavedValue extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -4162619580125452913L;

  private static transient Logger log = LoggerFactory.getLogger(
      PortfolioSurveyAnswerUserSavedValue.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  // npelleti 08/16 USB moved balance after data.
  /** DOCUMENT ME! */
  @Column(name = "balance")
  protected BigDecimal balance;


  /** DOCUMENT ME! */
  @Column(
    length   = 32,
    nullable = false
  )
  protected String businessDataType;

  /** DOCUMENT ME! */
  @Column(length = 20)
  protected String channel;


  /** Survey answer data. */
  @Column(
    name   = "data",
    length = 512
  )
  protected String data;

  /** DOCUMENT ME! */
  @Column(
    length   = 32,
    nullable = false
  )
  protected String dataType;


  /** DOCUMENT ME! */
  @Column(name = "delinquencyDays")
  protected Integer delinquencyDays;


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

  /** DOCUMENT ME! */
  @Column(
    name     = "savedId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long savedId;

  /** Survey submitted for this answer. */
  @JoinColumn(
    name      = "surveyId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioSurvey survey;

  /** Client defined code for survey. */
  @Column(
    length   = 16,
    nullable = false
  )
  protected String surveyCode;

  /** Survey taking date. */
  @Column(
    name      = "surveyDate",
    nullable  = false,
    updatable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date surveyDate;

  /** Survey Name. Should be uni within Portfolio */
  @Column(
    length   = 256,
    nullable = false
  )
  protected String surveyName;

  /** Survey taking round. */
  @Column(
    name     = "surveyRound",
    nullable = false
  )
  protected Integer surveyRound = 0;

  /** value format. */
  @Column(length = 255)
  protected String valueFormat;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioSurveyAnswerUserSavedValue)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioSurveyAnswerUserSavedValue that = (PortfolioSurveyAnswerUserSavedValue) o;

    if ((balance != null) ? (!balance.equals(that.balance)) : (that.balance != null)) {
      return false;
    }

    if ((businessDataType != null) ? (!businessDataType.equals(that.businessDataType))
                                   : (that.businessDataType != null)) {
      return false;
    }

    if ((channel != null) ? (!channel.equals(that.channel)) : (that.channel != null)) {
      return false;
    }

    if ((data != null) ? (!data.equals(that.data)) : (that.data != null)) {
      return false;
    }

    if ((dataType != null) ? (!dataType.equals(that.dataType)) : (that.dataType != null)) {
      return false;
    }

    if ((delinquencyDays != null) ? (!delinquencyDays.equals(that.delinquencyDays)) : (that.delinquencyDays != null)) {
      return false;
    }

    if ((question != null) ? (!question.equals(that.question)) : (that.question != null)) {
      return false;
    }

    if ((responsible != null) ? (!responsible.equals(that.responsible)) : (that.responsible != null)) {
      return false;
    }

    if ((savedId != null) ? (!savedId.equals(that.savedId)) : (that.savedId != null)) {
      return false;
    }

    if ((survey != null) ? (!survey.equals(that.survey)) : (that.survey != null)) {
      return false;
    }

    if ((surveyCode != null) ? (!surveyCode.equals(that.surveyCode)) : (that.surveyCode != null)) {
      return false;
    }

    if ((surveyDate != null) ? (!surveyDate.equals(that.surveyDate)) : (that.surveyDate != null)) {
      return false;
    }

    if ((surveyName != null) ? (!surveyName.equals(that.surveyName)) : (that.surveyName != null)) {
      return false;
    }

    if ((surveyRound != null) ? (!surveyRound.equals(that.surveyRound)) : (that.surveyRound != null)) {
      return false;
    }

    if ((valueFormat != null) ? (!valueFormat.equals(that.valueFormat)) : (that.valueFormat != null)) {
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
  public BigDecimal getBalance() {
    return balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBusinessDataType() {
    return businessDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getChannel() {
    return channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData() {
    return data;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDataType() {
    return dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDelinquencyDays() {
    return delinquencyDays;
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
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getSavedId() {
    return savedId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurvey getSurvey() {
    return survey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getValueFormat() {
    return valueFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((savedId != null) ? savedId.hashCode() : 0);
    result = (31 * result) + ((balance != null) ? balance.hashCode() : 0);
    result = (31 * result) + ((businessDataType != null) ? businessDataType.hashCode() : 0);
    result = (31 * result) + ((channel != null) ? channel.hashCode() : 0);
    result = (31 * result) + ((data != null) ? data.hashCode() : 0);
    result = (31 * result) + ((dataType != null) ? dataType.hashCode() : 0);
    result = (31 * result) + ((delinquencyDays != null) ? delinquencyDays.hashCode() : 0);
    result = (31 * result) + ((question != null) ? question.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);
    result = (31 * result) + ((survey != null) ? survey.hashCode() : 0);
    result = (31 * result) + ((surveyCode != null) ? surveyCode.hashCode() : 0);
    result = (31 * result) + ((surveyDate != null) ? surveyDate.hashCode() : 0);
    result = (31 * result) + ((surveyName != null) ? surveyName.hashCode() : 0);
    result = (31 * result) + ((surveyRound != null) ? surveyRound.hashCode() : 0);
    result = (31 * result) + ((valueFormat != null) ? valueFormat.hashCode() : 0);

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
   * @param  businessDataType  DOCUMENT ME!
   */
  public void setBusinessDataType(String businessDataType) {
    this.businessDataType = businessDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  channel  DOCUMENT ME!
   */
  public void setChannel(String channel) {
    this.channel = channel;
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
   * @param  dataType  DOCUMENT ME!
   */
  public void setDataType(String dataType) {
    this.dataType = dataType;
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
   * @param  savedId  DOCUMENT ME!
   */
  public void setSavedId(Long savedId) {
    this.savedId = savedId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  survey  DOCUMENT ME!
   */
  public void setSurvey(PortfolioSurvey survey) {
    this.survey = survey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  surveyCode  DOCUMENT ME!
   */
  public void setSurveyCode(String surveyCode) {
    this.surveyCode = surveyCode;
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
   * @param  surveyName  DOCUMENT ME!
   */
  public void setSurveyName(String surveyName) {
    this.surveyName = surveyName;
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
   * DOCUMENT ME!
   *
   * @param  valueFormat  DOCUMENT ME!
   */
  public void setValueFormat(String valueFormat) {
    this.valueFormat = valueFormat;
  }
} // end class PortfolioSurveyAnswerUserSavedValue
