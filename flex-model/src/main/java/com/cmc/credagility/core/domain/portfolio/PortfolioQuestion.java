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
import javax.persistence.Transient;

import com.ozstrategy.credagility.core.domain.type.BusinessDataType;
import com.ozstrategy.credagility.core.domain.workflow.responsible.ResponsibleAnswerValidator;


/**
 * This class is used to represent survey questions. Survey questions are a collection of facts we want to collect.
 * These facts can be grouped in different styles such as multi-choice, single-choice, etc in JSP.
 *
 * <p><a href="SurveyQuestion.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 *
 *           <p>table = "PortfolioQuestion"</p>
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "idx_questionCode",
      columnList = "questionCode"
    ), @Index(
      name = "FKC8_activeVersionId",
      columnList = "activeVersionId"
    ), @Index(
      name = "FKC8_currentVersionId",
      columnList = "currentVersionId"
    ),
  }
)
public class PortfolioQuestion extends AbstractPortfolioQuestion implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8373292945119504427L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** PortfolioQuestionVersion PK activeVersionId. */
  @JoinColumn(
    name       = "activeVersionId",
    nullable   = true,
    insertable = true,
    updatable  = true,
    unique     = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioQuestionVersion activeVersion;

  /** Question for this survey group. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "question",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  @OrderBy("displayOrder asc")
  protected Set<PortfolioSurveyAnswerOption> answerOptions = new LinkedHashSet<PortfolioSurveyAnswerOption>();

  /**
   * @see  ResponsibleAnswerValidator
   */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "portfolioQuestion",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  @OrderBy("priority ASC")
  protected Set<ResponsibleAnswerValidator> answerValidators = new LinkedHashSet<ResponsibleAnswerValidator>();

  /** <code>true</code> allow download uploaded file. */
  @Transient protected Boolean canDownloadTemplate;

  /** Question's comments. */
  @Transient protected String comments;

  /** PortfolioQuestionVersion PK currentVersionId. */
  @JoinColumn(
    name       = "currentVersionId",
    nullable   = true,
    insertable = true,
    updatable  = true,
    unique     = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioQuestionVersion currentVersion;

  /** Question audit finding <code>YES</code> <code>NO</code> <code>NOT Applicable</code> <code>NOT Asset.</code> */
  @Transient protected String finding;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /**
   * @see  com.cmc.credagility.core.domain.portfolio.PortfolioQuestionVersion
   */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "question",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<PortfolioQuestionVersion> questionVersions = null;

  /** Question's audit severity. */
  @Transient protected String severity;

  /** PortfolioVariable PK variableId. */
  @JoinColumn(
    name   = "variableId",
    unique = false /*, nullable = false*/
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected PortfolioVariable surveyVariable = null;

  /** Transient save temp answer. */
  @Transient protected String userSavedValue;

  @Transient private int version = 0;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  option  DOCUMENT ME!
   */

  /**
   * DOCUMENT ME!
   *
   * @param  option  DOCUMENT ME!
   */
  public void addAnswerOption(PortfolioSurveyAnswerOption option) {
    option.setQuestion(this);
    this.answerOptions.add(option);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bcAnswerValidator  DOCUMENT ME!
   */
  public void addAnswerValidator(ResponsibleAnswerValidator bcAnswerValidator) {
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

    for (PortfolioSurveyAnswerOption answerOption : other.getAnswerOptions()) {
      PortfolioSurveyAnswerOption optionVersion = new PortfolioSurveyAnswerOption();
      optionVersion.copy(answerOption);
      optionVersion.setQuestion(this);
      this.getAnswerOptions().add(optionVersion);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  validators  DOCUMENT ME!
   */
  public void copySurveyValidatorData(ResponsibleAnswerValidator validators) {
    if (validators != null) {
      validators.setId(null);
      validators.setPortfolioQuestion(this);
      answerValidators.add(validators);
    } // end if
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioVariable createVariable() {
    if (this.surveyVariable == null) {
      PortfolioVariable variable = new PortfolioVariable();

      variable.setName(this.name);
      variable.setDisplayName(this.name);
      variable.setCategory("survey");
      variable.setBuildType("source");
      variable.setDataType(this.getProcessedDataType(this.dataType));
      variable.setBusinessDataType(this.getProcessedBusinessDataType(this.businessDataType));
      variable.setPortfolio(this.portfolio);
      variable.setDisplayPosition("holder");

      this.surveyVariable = variable;
    } else {
      this.surveyVariable.setName(this.name);
      this.surveyVariable.setDisplayName(this.name);
      this.surveyVariable.setDataType(this.getProcessedDataType(this.dataType));
      this.surveyVariable.setBusinessDataType(this.getProcessedBusinessDataType(this.businessDataType));
      this.surveyVariable.setPortfolio(this.portfolio);
      this.surveyVariable.setLastUpdateDate(new Date());
    }

    return this.surveyVariable;
  } // end method createVariable

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
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
   * @param   name  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyAnswerOption findAnswerOptionByName(String name) {
    for (PortfolioSurveyAnswerOption option : this.answerOptions) {
      if (option.getName().equals(name)) {
        return option;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioQuestionVersion getActiveVersion() {
    return activeVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAnswerOptionFullString() {
    StringBuilder buf = new StringBuilder();

    int i = 1;

    for (PortfolioSurveyAnswerOption option : this.answerOptions) {
      buf.append("|");
      buf.append(option.getName());
      buf.append(":");

      if (option.getValue() != null) {
        buf.append(option.getValue());
      } else {
        buf.append(option.getName());
      }

      buf.append(":");
      buf.append(i++);
      buf.append(":").append(option.getDefault());
    }

    if (buf.length() > 0) {
      return buf.substring(1);
    } else {
      return "";
    }
  } // end method getAnswerOptionFullString

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getAnswerOptionIds() {
    StringBuilder buf = new StringBuilder();

    for (PortfolioSurveyAnswerOption option : this.answerOptions) {
      buf.append("," + option.getId());
    }

    if (buf.length() > 0) {
      return buf.substring(1);
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioSurveyAnswerOption> getAnswerOptions() {
    return answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Build comma separated string from answer options.
   *
   * @return  build comma separated string from answer options.
   */
  public String getAnswerOptionString() {
    StringBuilder buf = new StringBuilder();

    for (PortfolioSurveyAnswerOption option : this.answerOptions) {
      String name  = option.getName();
      String value = option.getValue();

      buf.append("," + name);

      if ((value != null) && (!name.equals(value))) {
        buf.append(":" + value);
      }
    }

    if (buf.length() > 0) {
      return buf.substring(1);
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<ResponsibleAnswerValidator> getAnswerValidators() {
    return answerValidators;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getCanDownloadTemplate() {
    if (canDownloadTemplate == null) {
      return Boolean.FALSE;
    }

    return canDownloadTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getComments() {
    return comments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioQuestionVersion getCurrentVersion() {
    return currentVersion;
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
  public Set<PortfolioQuestionVersion> getQuestionVersions() {
    return questionVersions;
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
  public String getUserSavedValue() {
    return userSavedValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public int getVersion() {
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
   * @param  activeVersion  DOCUMENT ME!
   */
  public void setActiveVersion(PortfolioQuestionVersion activeVersion) {
    this.activeVersion = activeVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerOptionFullString  DOCUMENT ME!
   */
  public void setAnswerOptionFullString(String answerOptionFullString) {
    if (answerOptionFullString != null) {
      answerOptionFullString = answerOptionFullString.trim();

      if (!answerOptionFullString.equals(getAnswerOptionFullString())) {
        // Not the same, changes found
        this.answerOptions.clear();

        String[] options = answerOptionFullString.split("\\|");
        int      index   = 1;

        for (String value : options) {
          if (value.length() > 0) {
            PortfolioSurveyAnswerOption option = new PortfolioSurveyAnswerOption(value);
            option.setDisplayOrder(index++);
            option.setQuestion(this);

            this.answerOptions.add(option);
          }
        }

      }
    } else {
      this.answerOptions.clear();
    } // end if-else

  } // end method setAnswerOptionFullString

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerOptions  DOCUMENT ME!
   */
  public void setAnswerOptions(Set<PortfolioSurveyAnswerOption> answerOptions) {
    this.answerOptions = answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Build answer options from string.
   *
   * @param  answerOptionString  DOCUMENT ME!
   */
  public void setAnswerOptionString(String answerOptionString) {
    this.answerOptions.clear();

    String[] buf   = answerOptionString.split("\t|\n|\r|,|;");
    int      index = 0;

    for (String value : buf) {
      if (value.length() > 0) {
        PortfolioSurveyAnswerOption option = new PortfolioSurveyAnswerOption(value);
        option.setDisplayOrder(index++);
        option.setQuestion(this);

        this.answerOptions.add(option);
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerValidators  DOCUMENT ME!
   */
  public void setAnswerValidators(Set<ResponsibleAnswerValidator> answerValidators) {
    this.answerValidators = answerValidators;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  canDownloadTemplate  DOCUMENT ME!
   */
  public void setCanDownloadTemplate(Boolean canDownloadTemplate) {
    this.canDownloadTemplate = canDownloadTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  comments  DOCUMENT ME!
   */
  public void setComments(String comments) {
    this.comments = comments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  currentVersion  DOCUMENT ME!
   */
  public void setCurrentVersion(PortfolioQuestionVersion currentVersion) {
    this.currentVersion = currentVersion;
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
   * @param  questionVersions  DOCUMENT ME!
   */
  public void setQuestionVersions(Set<PortfolioQuestionVersion> questionVersions) {
    this.questionVersions = questionVersions;
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
   * @param  userSavedValue  DOCUMENT ME!
   */
  public void setUserSavedValue(String userSavedValue) {
    this.userSavedValue = userSavedValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  version  DOCUMENT ME!
   */
  public void setVersion(int version) {
    this.version = version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "PortfolioQuestion{" + this.id
      + "} " + super.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  other  DOCUMENT ME!
   */
  public void update(PortfolioQuestion other) {
    this.name             = other.getName();
    this.businessDataType = other.getBusinessDataType();
    this.detectDataType();
    this.questionCode    = other.getQuestionCode();
    this.questionText    = other.getQuestionText();
    this.questionText2   = other.getQuestionText2();
    this.answerType      = other.getAnswerType();
    this.textAreaColumns = other.getTextAreaColumns();
    this.textAreaRows    = other.getTextAreaRows();
    this.roundType       = other.getRoundType();
    setAnswerOptionFullString(other.getAnswerOptionFullString());
    this.requireAnswer         = other.getRequireAnswer();
    this.requireNewLine        = other.getRequireNewLine();
    this.allowEncrypt          = other.getAllowEncrypt();
    this.locale                = other.getLocale();
    this.questionLayout        = other.getQuestionLayout();
    this.page                  = other.getPage();
    this.valueFormat           = other.getValueFormat();
    this.minSize               = other.getMinSize();
    this.maxSize               = other.getMaxSize();
    this.answerValidator       = other.getAnswerValidator();
    this.prePopulateExpression = other.getPrePopulateExpression();
    this.documentContentType   = other.getDocumentContentType();
    this.style                 = other.getStyle();
    this.leftText              = other.getLeftText();
    this.rightText             = other.getRightText();
    this.rows                  = other.getRows();
    this.width                 = other.getWidth();
    this.radioAlignment        = other.getRadioAlignment();
    this.setAllowShowOrHideDependentTaskElements(other.getAllowShowOrHideDependentTaskElements());

    this.lastUpdateDate = new Date();
  } // end method update

  //~ ------------------------------------------------------------------------------------------------------------------

  private String getProcessedBusinessDataType(String businessDataType) {
    if (BusinessDataType.DOCUMENT_PREVIEW.toString().equalsIgnoreCase(businessDataType)
          || BusinessDataType.DOCUMENT_UPLOAD.toString().equalsIgnoreCase(businessDataType)
          || BusinessDataType.DOCUMENT_STATUS.toString().equalsIgnoreCase(businessDataType)) {
      return "Integer";
    }

    return businessDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private String getProcessedDataType(String dataType) {
    if (BusinessDataType.DOCUMENT_PREVIEW.toString().equalsIgnoreCase(dataType)
          || BusinessDataType.DOCUMENT_UPLOAD.toString().equalsIgnoreCase(dataType)
          || BusinessDataType.DOCUMENT_STATUS.toString().equalsIgnoreCase(dataType)) {
      return "Long";
    }

    return dataType;
  }
} // end class PortfolioQuestion
