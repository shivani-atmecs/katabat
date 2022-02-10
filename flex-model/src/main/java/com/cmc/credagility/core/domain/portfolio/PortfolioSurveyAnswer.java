package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

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

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.activity.AgentCallActivity;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.user.User;

import com.ozstrategy.credagility.core.domain.SurveyFlow;
import com.ozstrategy.credagility.core.domain.SurveyFlowStep;
import com.ozstrategy.credagility.core.domain.type.BusinessDataType;
import com.ozstrategy.credagility.core.util.DataFormatter;


/**
 * This class is used to represent survey answers. Survey answers are a collection of facts collected by the survey
 * questions. It may be more appropriate to call them survey facts. These facts do not care how you organize the
 * questions - facts are facts. You can organize them as multiple choice, single choice, or drop down choice in the JSP.
 * Each choice represents a fact and will be gathered in this class.
 *
 * <p><a href="PortfolioSurveyAnswer.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojerluo@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 *
 *           <p>table = "PortfolioSurveyAnswer"</p>
 */
@Entity
@Table(
  name    = "PortfolioSurveyAnswer",
  indexes = {
    @Index(
      name = "IDX_RESP_SURVEYDATE",
      columnList = "responsibleId, surveyDate"
    ),
    @Index(
      name = "idx_surveyDate",
      columnList = "surveyDate"
    ),
    @Index(
      name = "FKD6_responsibleId",
      columnList = "responsibleId"
    )
  }
)
public class PortfolioSurveyAnswer extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2490005346279599224L;

  private static transient Logger log = LoggerFactory.getLogger(
      PortfolioSurveyAnswer.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** working agent. */
  @JoinColumn(
    name       = "agentId",
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "agentCallActivityId",
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgentCallActivity agentCallActivity;

  /** Primary key. */

  @Column(
    name     = "answerId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long answerId;

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
    length = 1024
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

  /** Ref SurveyFlow. */
  @JoinColumn(
    name       = "flowId",
    updatable  = false,
    insertable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlow flow;

  /** Ref SurveyFlow. */
  @Column(name = "flowId")
  protected Long flowId;

  /** Ref SurveyFlow. */
  @JoinColumn(
    name       = "flowStepId",
    updatable  = false,
    insertable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowStep flowStep;

  /** Ref SurveyFlowStep. */
  @Column(name = "flowStepId")
  protected Long flowStepId;

  /** DOCUMENT ME! */
  @JoinColumn(
    name      = "portfolioQuestionVersionId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioQuestionVersion portfolioQuestionVersion;


  /** DOCUMENT ME! */
  @JoinColumn(
    name     = "portfolioSurveyVersionId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioSurveyVersion portfolioSurveyVersion;

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

  /** DOCUMENT ME! */
// @Column protected Long surveyNodeId;

  /** Survey taking round. */
  @Column(
    name     = "surveyRound",
    nullable = false
  )
  protected Integer surveyRound = 0;

  /** value format. */
  @Column(length = 255)
  protected String valueFormat;

  /** Hash code of answer = hashCode(task code) + hashCode(answer data). */
  @Column private Integer answerHashCode;

  @Column private Date exportDate;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   taskCode  DOCUMENT ME!
   * @param   answer    DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static int calAnswerHashCode(String taskCode, String answer) {
    int result = 0;

    result = ((taskCode != null) ? taskCode.hashCode() : 0);
    result = (31 * result) + ((answer != null) ? answer.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioSurveyAnswer)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioSurveyAnswer answer = (PortfolioSurveyAnswer) o;

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
  public AgentCallActivity getAgentCallActivity() {
    return agentCallActivity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getAnswerHashCode() {
    return answerHashCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getAnswerId() {
    return answerId;
  }

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
   */
  public String getDataType() {
    return dataType;
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
   */
  public Date getExportDate() {
    return exportDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public SurveyFlow getFlow() {
    return flow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getFlowId() {
    return flowId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public SurveyFlowStep getFlowStep() {
    return flowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getFlowStepId() {
    return flowStepId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioQuestionVersion getPortfolioQuestionVersion() {
    return portfolioQuestionVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyVersion getPortfolioSurveyVersion() {
    return portfolioSurveyVersion;
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
   */
  public String getSurveyName() {
    return surveyName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

// //~ ------------------------------------------------------------------------------------------------------------------
//
// /**
// * DOCUMENT ME!
// *
// * @return  DOCUMENT ME!
// */
// public Long getSurveyNodeId() {
// return surveyNodeId;
// }

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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Object getTypedData() {
    if (this.data == null) {
      return null;
    }

    String dataStr = this.data.trim();

    try {
      if ("Currency".equalsIgnoreCase(this.businessDataType)
            || "Decimal".equalsIgnoreCase(this.businessDataType)
            || "Percentage".equalsIgnoreCase(this.businessDataType)) {
        BigDecimal ret = null;

        if (StringUtils.hasText(dataStr)) {
          dataStr = dataStr.replaceAll("\\,", "");

          try {
            ret = new BigDecimal(dataStr);
          } catch (Exception e) {
            ret = null;
          }
        }

        return ret;
      } else if ("Date".equalsIgnoreCase(this.businessDataType)) {
        try {
          if (StringUtils.hasText(this.valueFormat)) {
            SimpleDateFormat sdf = new SimpleDateFormat(this.valueFormat);
            Date             d   = sdf.parse(dataStr);

            return d;
          }
        } catch (Exception e) { }

        return DataFormatter.toDate(dataStr);
      } else if ("Long".equalsIgnoreCase(this.businessDataType)
            || "Integer".equalsIgnoreCase(this.businessDataType)) {
        Long ret = null;

        if (StringUtils.hasText(dataStr)) {
          try {
            ret = new Long(dataStr);
          } catch (Exception e) {
            ret = null;
          }
        }

        return ret;
      } else if(BusinessDataType.EXTERNAL_ENTITY.toString().equalsIgnoreCase(this.businessDataType)){
        Long ret = null;

        if (StringUtils.hasText(dataStr)) {
          try {
            ret = new Long(dataStr);
          } catch (Exception e) {
            ret = null;
          }
        }

        return ret;
      } else if ("String".equalsIgnoreCase(this.businessDataType)) {
        return data;
      } else if ("Boolean".equalsIgnoreCase(this.businessDataType)) {
        return "YES".equalsIgnoreCase(dataStr)
          || "TRUE".equalsIgnoreCase(dataStr);
      } else if (BusinessDataType.DOCUMENT_PREVIEW.toString().equalsIgnoreCase(this.businessDataType)
            || BusinessDataType.DOCUMENT_UPLOAD.toString().equalsIgnoreCase(this.businessDataType)
            || BusinessDataType.DOCUMENT_STATUS.toString().equalsIgnoreCase(this.businessDataType)) {
        Long ret = null;

        if (StringUtils.hasText(dataStr)) {
          try {
            ret = new Long(dataStr);
          } catch (Exception e) {
            ret = null;
          }
        }

        return ret;
      } // end if-else
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      log.error(dataStr + " is not a valid value for survey code: "
        + this.surveyCode + " at " + this.surveyDate
        + ". Can not convert to " + this.businessDataType + ".");
    }   // end try-catch

    return null;
  } // end method getTypedData

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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((question != null) ? question.hashCode() : 0);
    result = (31 * result) + ((data != null) ? data.hashCode() : 0);
    result = (31 * result)
      + ((surveyDate != null) ? surveyDate.hashCode() : 0);
    result = (31 * result)
      + ((surveyRound != null) ? surveyRound.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agent  DOCUMENT ME!
   */
  public void setAgent(User agent) {
    this.agent = agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agentCallActivity  DOCUMENT ME!
   */
  public void setAgentCallActivity(AgentCallActivity agentCallActivity) {
    this.agentCallActivity = agentCallActivity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerHashCode  DOCUMENT ME!
   */
  public void setAnswerHashCode(Integer answerHashCode) {
    this.answerHashCode = answerHashCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerId  DOCUMENT ME!
   */
  public void setAnswerId(Long answerId) {
    this.answerId = answerId;
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
   * @param  exportDate  DOCUMENT ME!
   */
  public void setExportDate(Date exportDate) {
    this.exportDate = exportDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flow  DOCUMENT ME!
   */
  public void setFlow(SurveyFlow flow) {
    this.flow = flow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flowId  DOCUMENT ME!
   */
  public void setFlowId(Long flowId) {
    this.flowId = flowId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flowStep  DOCUMENT ME!
   */
  public void setFlowStep(SurveyFlowStep flowStep) {
    this.flowStep = flowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flowStepId  DOCUMENT ME!
   */
  public void setFlowStepId(Long flowStepId) {
    this.flowStepId = flowStepId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioQuestionVersion  DOCUMENT ME!
   */
  public void setPortfolioQuestionVersion(PortfolioQuestionVersion portfolioQuestionVersion) {
    this.portfolioQuestionVersion = portfolioQuestionVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioSurveyVersion  DOCUMENT ME!
   */
  public void setPortfolioSurveyVersion(PortfolioSurveyVersion portfolioSurveyVersion) {
    this.portfolioSurveyVersion = portfolioSurveyVersion;
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

// //~ ------------------------------------------------------------------------------------------------------------------
//
// /**
// * DOCUMENT ME!
// *
// * @param  surveyNodeId  DOCUMENT ME!
// */
// public void setSurveyNodeId(Long surveyNodeId) {
// this.surveyNodeId = surveyNodeId;
// }

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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PortfolioSurveyAnswer");
    sb.append("{answerId=").append(answerId);
    sb.append(", question=").append(question);
    sb.append(", responsible=").append(responsible);
    sb.append(", data='").append(data).append('\'');
    sb.append(", surveyDate=").append(surveyDate);
    sb.append(", surveyRound=").append(surveyRound);
    sb.append(", balance=").append(balance);
    sb.append(", delinquencyDays=").append(delinquencyDays);
    sb.append(", answerHashCode=").append(answerHashCode);
    sb.append('}');

    return sb.toString();
  }
} // end class PortfolioSurveyAnswer
