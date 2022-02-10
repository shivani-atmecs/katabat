package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.Table;


/**
 * Created by IntelliJ IDEA. User: ye Date: Apr 30, 2010 Time: 11:55:03 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "idx_questionCode",
      columnList = "questionCode"
    )
  }
)
public class PortfolioQuestionAudit extends AbstractPortfolioQuestion implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -3382005050837628149L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** PortfolioQuestion's questionId. */
  @Column(nullable = true)
  protected Long questionId;


  /** Portfolio Variable id. */
  @Column(nullable = true)
  protected Long variableId;

  /** Possible values are. */
  @Column(
    nullable = false,
    length   = 32
  )
  private String action;

  /** The answer options for dropdown or radio box. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob private String answerOptionString;


  /** The PortfolioQuestionVersion id. */
  private Long questionVersion;

  /** The version number. */
  private Integer version = 0;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.portfolio.AbstractPortfolioQuestion#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioQuestion)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAnswerOptionString() {
    return answerOptionString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
  public Long getQuestionId() {
    return questionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getQuestionVersion() {
    return questionVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getVariableId() {
    return variableId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getVersion() {
    return version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    return super.hashCode();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  action  DOCUMENT ME!
   */
  public void setAction(String action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerOptionString  DOCUMENT ME!
   */
  public void setAnswerOptionString(String answerOptionString) {
    this.answerOptionString = answerOptionString;
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
   * @param  questionId  DOCUMENT ME!
   */
  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  questionVersion  DOCUMENT ME!
   */
  public void setQuestionVersion(Long questionVersion) {
    this.questionVersion = questionVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variableId  DOCUMENT ME!
   */
  public void setVariableId(Long variableId) {
    this.variableId = variableId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  version  DOCUMENT ME!
   */
  public void setVersion(Integer version) {
    this.version = version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "PortfolioQuestionAudit{" + this.id
      + "} " + super.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  other  DOCUMENT ME!
   */
  public void update(PortfolioQuestionVersion other) {
    this.questionId            = other.getQuestion().getId();
    this.name                  = other.getName();
    this.businessDataType      = other.getBusinessDataType();
    this.dataType              = other.getBusinessDataType();
    this.questionCode          = other.getQuestionCode();
    this.questionText          = other.getQuestionText();
    this.questionText2         = other.getQuestionText2();
    this.answerType            = other.getAnswerType();
    this.portfolio             = other.getPortfolio();
    this.status                = other.getStatus();
    this.textAreaColumns       = other.getTextAreaColumns();
    this.textAreaRows          = other.getTextAreaRows();
    this.answerValidator       = (other.getAnswerValidators() != null) ? other.getAnswerValidators().toString() : null;
    this.prePopulateExpression = other.getPrePopulateExpression();
    this.variableId            = (other.getSurveyVariable() == null) ? null : other.getSurveyVariable().getId();
    this.answerOptionString    = (other.getAnswerOptions() != null) ? other.getAnswerOptions().toString() : null;
    this.requireAnswer         = other.getRequireAnswer();
    this.requireNewLine        = other.getRequireNewLine();
    this.allowEncrypt          = other.getAllowEncrypt();
    this.locale                = other.getLocale();
    this.questionLayout        = other.getQuestionLayout();
    this.page                  = other.getPage();
    this.roundType             = other.getRoundType();
    this.valueFormat           = other.getValueFormat();
    this.minSize               = other.getMinSize();
    this.maxSize               = other.getMaxSize();
    this.document              = other.getDocument();
    this.documentContentType   = other.getDocumentContentType();
    this.version               = other.getVersion();
    this.active                = other.getActive();
    this.creator               = other.getCreator();
    this.lastUpdater           = other.getLastUpdater();
    this.lastUpdateDate        = new Date();
    this.roundType             = other.getRoundType();
    this.scale                 = other.getScale();
    this.style                 = other.getStyle();
    this.leftText              = other.getLeftText();
    this.rightText             = other.getRightText();
    this.rows                  = other.getRows();
    this.width                 = other.getWidth();
    this.radioAlignment        = other.getRadioAlignment();
  } // end method update

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  other  DOCUMENT ME!
   */
  public void update(PortfolioQuestion other) {
    this.questionId       = other.getId();
    this.name             = other.getName();
    this.businessDataType = other.getBusinessDataType();
    this.dataType         = other.getBusinessDataType();
    this.questionCode     = other.getQuestionCode();
    this.questionText     = other.getQuestionText();
    this.questionText2    = other.getQuestionText2();
    this.answerType       = other.getAnswerType();
    this.portfolio        = other.getPortfolio();
    this.status           = other.getStatus();
    this.textAreaColumns  = other.getTextAreaColumns();
    this.textAreaRows     = other.getTextAreaRows();

    this.prePopulateExpression = other.getPrePopulateExpression();
    this.variableId            = (other.getSurveyVariable() == null) ? null : other.getSurveyVariable().getId();
    this.answerOptionString    = (other.getAnswerOptions() != null) ? other.getAnswerOptions().toString() : null;
    this.requireAnswer         = other.getRequireAnswer();
    this.requireNewLine        = other.getRequireNewLine();
    this.allowEncrypt          = other.getAllowEncrypt();
    this.locale                = other.getLocale();
    this.questionLayout        = other.getQuestionLayout();
    this.page                  = other.getPage();
    this.valueFormat           = other.getValueFormat();
    this.minSize               = other.getMinSize();
    this.maxSize               = other.getMaxSize();
    this.document              = other.getDocument();
    this.documentContentType   = other.getDocumentContentType();
    this.version               = (other.getCurrentVersion() != null) ? other.getCurrentVersion().getVersion() : 1;

    this.creator        = other.getCreator();
    this.lastUpdater    = other.getLastUpdater();
    this.lastUpdateDate = new Date();
    this.roundType      = other.getRoundType();
    this.scale          = other.getScale();
    this.style                 = other.getStyle();
    this.leftText              = other.getLeftText();
    this.rightText             = other.getRightText();
    this.rows                  = other.getRows();
    this.width                 = other.getWidth();
    this.radioAlignment        = other.getRadioAlignment();
  } // end method update


} // end class PortfolioQuestionAudit
