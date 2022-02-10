package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.user.User;

import com.ozstrategy.credagility.core.domain.workflow.responsible.ResponsibleAnswerValidator;
import com.ozstrategy.credagility.core.domain.workflow.responsible.version.ResponsibleAnswerValidatorVersion;


/**
 * Created with IntelliJ IDEA. User: weitang Date: 13-10-9 Time: PM3:28 To change this template use File | Settings |
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
    ),
    @Index(
      name = "idx_version",
      columnList = "version"
    )
  }
)
public class PortfolioQuestionVersion extends AbstractPortfolioQuestion implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6211159644285036856L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.portfolio.PortfolioSurveyAnswerOptionVersion
   */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "questionVersion",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  @OrderBy("displayOrder asc")
  protected Set<PortfolioSurveyAnswerOptionVersion> answerOptions =
    new LinkedHashSet<PortfolioSurveyAnswerOptionVersion>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolioQuestion",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  @OrderBy("priority ASC")
  protected Set<ResponsibleAnswerValidatorVersion> answerValidators =
    new LinkedHashSet<ResponsibleAnswerValidatorVersion>();

  /** DOCUMENT ME! */
  @Transient protected String answerValidatorStrs;

  /** Question audit finding <code>YES</code> <code>NO</code> <code>NOT Applicable</code> <code>NOT Asset.</code> */
  @Transient protected String finding;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Published this question's user. */
  @JoinColumn(
    name       = "publishBy",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User publishBy;

  /** Published this question's date. */
  @Column(
    name       = "publishDate",
    insertable = true,
    updatable  = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date publishDate;


  /** PortfolioQuestion PK questionId. */
  @JoinColumn(
    name       = "questionId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected PortfolioQuestion question;

  /** Retired this question's user. */
  @JoinColumn(name = "retireBy")
  @ManyToOne(fetch = FetchType.LAZY)
  protected User retireBy;

  /** Retired this question's date. */
  @Column(name = "retireDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date retireDate;

  /** DOCUMENT ME! */
  @Transient protected String severity;

  /** PortfolioVariable PK variableId. */
  @JoinColumn(
    name       = "variableId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected PortfolioVariable surveyVariable = null;

  /** The version number. */
  protected Integer version;

  /** DOCUMENT ME! */
  @Transient protected Long workflowTaskElementId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bcAnswerValidator  DOCUMENT ME!
   */
  public void addAnswerValidator(ResponsibleAnswerValidatorVersion bcAnswerValidator) {
    if (bcAnswerValidator != null) {
      this.answerValidators.add(bcAnswerValidator);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  other  DOCUMENT ME!
   */
  public void copyFrom(PortfolioQuestion other) {
    super.copyFrom(other);
    this.surveyVariable = other.getSurveyVariable();
    this.setQuestion(other);

    for (PortfolioSurveyAnswerOption answerOption : other.getAnswerOptions()) {
      PortfolioSurveyAnswerOptionVersion optionVersion = new PortfolioSurveyAnswerOptionVersion();
      optionVersion.copyFrom(answerOption);
      optionVersion.setQuestionVersion(this);
      this.getAnswerOptions().add(optionVersion);
    }

    for (ResponsibleAnswerValidator answerValidator : other.getAnswerValidators()) {
      ResponsibleAnswerValidatorVersion validatorVersion = new ResponsibleAnswerValidatorVersion();
      validatorVersion.copyFrom(answerValidator);
      validatorVersion.setPortfolioQuestion(this);
      this.getAnswerValidators().add(validatorVersion);
    }
  } // end method copyFrom

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioQuestionVersion)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioQuestionVersion that = (PortfolioQuestionVersion) o;

    if ((publishDate != null) ? (!publishDate.equals(that.publishDate)) : (that.publishDate != null)) {
      return false;
    }

    if ((retireDate != null) ? (!retireDate.equals(that.retireDate)) : (that.retireDate != null)) {
      return false;
    }

    if ((version != null) ? (!version.equals(that.version)) : (that.version != null)) {
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
  public Set<PortfolioSurveyAnswerOptionVersion> getAnswerOptions() {
    return answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<ResponsibleAnswerValidatorVersion> getAnswerValidators() {
    return answerValidators;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAnswerValidatorStrs() {
    return answerValidatorStrs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFinding() {
    return finding;
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
  public User getPublishBy() {
    return publishBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPublishDate() {
    return publishDate;
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
  public User getRetireBy() {
    return retireBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getRetireDate() {
    return retireDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSeverity() {
    return severity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioVariable getSurveyVariable() {
    return surveyVariable;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getWorkflowTaskElementId() {
    return workflowTaskElementId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((publishDate != null) ? publishDate.hashCode() : 0);
    result = (31 * result) + ((retireDate != null) ? retireDate.hashCode() : 0);
    result = (31 * result) + ((version != null) ? version.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   ver  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioQuestionVersion paste(PortfolioQuestionVersion ver) {
    ver.copyFrom(this);

    return ver;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerOptions  DOCUMENT ME!
   */
  public void setAnswerOptions(Set<PortfolioSurveyAnswerOptionVersion> answerOptions) {
    this.answerOptions = answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerValidators  DOCUMENT ME!
   */
  public void setAnswerValidators(Set<ResponsibleAnswerValidatorVersion> answerValidators) {
    this.answerValidators = answerValidators;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerValidatorStrs  DOCUMENT ME!
   */
  public void setAnswerValidatorStrs(String answerValidatorStrs) {
    this.answerValidatorStrs = answerValidatorStrs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  finding  DOCUMENT ME!
   */
  public void setFinding(String finding) {
    this.finding = finding;
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
   * @param  publishBy  DOCUMENT ME!
   */
  public void setPublishBy(User publishBy) {
    this.publishBy = publishBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  publishDate  DOCUMENT ME!
   */
  public void setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
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
   * @param  retireBy  DOCUMENT ME!
   */
  public void setRetireBy(User retireBy) {
    this.retireBy = retireBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  retireDate  DOCUMENT ME!
   */
  public void setRetireDate(Date retireDate) {
    this.retireDate = retireDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  severity  DOCUMENT ME!
   */
  public void setSeverity(String severity) {
    this.severity = severity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  surveyVariable  DOCUMENT ME!
   */
  public void setSurveyVariable(PortfolioVariable surveyVariable) {
    this.surveyVariable = surveyVariable;
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
   * DOCUMENT ME!
   *
   * @param  workflowTaskElementId  DOCUMENT ME!
   */
  public void setWorkflowTaskElementId(Long workflowTaskElementId) {
    this.workflowTaskElementId = workflowTaskElementId;
  }
} // end class PortfolioQuestionVersion
