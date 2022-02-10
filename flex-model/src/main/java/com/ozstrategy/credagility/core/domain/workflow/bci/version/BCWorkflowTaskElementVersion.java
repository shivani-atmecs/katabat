package com.ozstrategy.credagility.core.domain.workflow.bci.version;

import com.cmc.credagility.core.domain.businesscontext.BCAssociatedField;
import com.cmc.credagility.core.domain.businesscontext.BCMetaDataField;
import com.cmc.credagility.core.domain.businesscontext.BCVariable;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.workflow.ContextType;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCAnswerValidator;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCWorkflowTaskAnswerOption;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCWorkflowTaskElement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * DOCUMENT ME!
 *
 * @author   Yong Liu
 * @version  10/9/13 Time: 2:36 PM
 */
@Entity
@Table(
  name    = "BCWorkflowTaskElementVersion",
  indexes = {
    @Index(
      name = "idx_version",
      columnList = "version"
    ),
    @Index(
      name = "idx_questionCode",
      columnList = "questionCode"
    )
  }
)
public class BCWorkflowTaskElementVersion extends BasicWorkflowTaskElement implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2783458810584718588L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** CA-11591 Show/Hide Dependent Task Elements in Customer Portal Default is False. */
  @Column
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean         allowShowOrHideDependentTaskElements = Boolean.FALSE;

  /** BCWorkflowTaskAnswerOptionVersion. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "taskElement",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  @OrderBy("displayOrder asc")
  protected Set<BCWorkflowTaskAnswerOptionVersion> answerOptions =
    new LinkedHashSet<BCWorkflowTaskAnswerOptionVersion>();

  /** BCAnswerValidatorVersion. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "taskElement",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  @OrderBy("priority ASC")
  protected Set<BCAnswerValidatorVersion> answerValidators = new LinkedHashSet<BCAnswerValidatorVersion>();

  /** DOCUMENT ME! */
  @Transient protected String answerValidatorStrs;

  /** BCAssociatedField PK bcMappingFieldId. */
  @JoinColumn(
    name       = "bcMappingFieldId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCAssociatedField bcAssociatedField;

  /** BCMetaDataField PK bcFieldId. */
  @JoinColumn(
    name       = "bcFieldId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCMetaDataField bcMetaDataField;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** Load context instance by previously answered task element. */
  @JoinColumn(
    name       = "refContextId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTaskElementVersion refContext;

  /** BCVariable. */
  @JoinColumn(
    name       = "variableId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected BCVariable variable;

  /** Version number. */
  protected Integer version = 0;

  /** BCWorkflowTaskElement PK workflowTaskElementId. */
  @JoinColumn(
    name       = "workflowTaskElementId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected BCWorkflowTaskElement workflowTaskElement;

  /** DOCUMENT ME! */
  @Transient protected Long workflowTaskElementId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  option  DOCUMENT ME!
   */
  public void addAnswerOption(BCWorkflowTaskAnswerOptionVersion option) {
    option.setTaskElement(this);
    this.answerOptions.add(option);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bcAnswerValidator  DOCUMENT ME!
   */
  public void addAnswerValidator(BCAnswerValidatorVersion bcAnswerValidator) {
    if (bcAnswerValidator != null) {
      this.answerValidators.add(bcAnswerValidator);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  element  DOCUMENT ME!
   */
  public void copyFrom(BCWorkflowTaskElement element) {
    this.name                  = element.getName();
    this.businessDataType      = element.getBusinessDataType();
    this.dataType              = element.getDataType();
    this.questionCode          = element.getQuestionCode();
    this.questionText          = element.getQuestionText();
    this.questionText2         = element.getQuestionText2();
    this.answerType            = element.getAnswerType();
    this.maxSize               = element.getMaxSize();
    this.minSize               = element.getMinSize();
    this.requireAnswer         = element.getRequireAnswer();
    this.requireNewLine        = element.getRequireNewLine();
    this.allowEncrypt          = element.getAllowEncrypt();
    this.locale                = element.getLocale();
    this.questionLayout        = element.getQuestionLayout();
    this.answerValidator       = element.getAnswerValidator();
    this.prePopulateExpression = element.getPrePopulateExpression();
    this.allowAudit            = element.getAllowAudit();
    this.contextInstanceScope  = element.getContextInstanceScope();
    this.valueFormat           = element.getValueFormat();
    this.roundType             = element.getRoundType();
    this.scale                 = element.getScale();
    this.documentContentType   = element.getDocumentContentType();
    this.contextType           = element.getContextType();
    this.status                = element.getStatus();
    this.active                = element.getActive();
    this.activeBy              = element.getActiveBy();
    this.activeDate            = element.getActiveDate();
    this.bcAssociatedField     = element.getBcAssociatedField();
    this.setRefContext((element.getCurrentVersion() != null) ? element.getCurrentVersion().getRefContext() : null);
    this.setWorkflowTaskElement(element);
    this.setDocument(element.getDocument());
    this.setVariable(element.getVariable());
    this.setActiveBy(element.getActiveBy());
    this.setActiveDate(element.getActiveDate());
    this.setLastUpdateDate(element.getLastUpdateDate());
    this.setLastUpdater(element.getLastUpdater());
    this.setCreateDate(new Date());
    this.setCreator(element.getCreator());
    this.setWorkflowTaskElement(element);
    this.setBcMetaDataField(element.getBcMetaDataField());
    this.setAllowShowOrHideDependentTaskElements(element.getAllowShowOrHideDependentTaskElements());

    ///////// add answer options
    for (BCWorkflowTaskAnswerOption answerOption : element.getAnswerOptions()) {
      BCWorkflowTaskAnswerOptionVersion optionVersion = new BCWorkflowTaskAnswerOptionVersion();
      optionVersion.copyFrom(answerOption);
      optionVersion.setTaskElement(this);
      this.getAnswerOptions().add(optionVersion);
    }

    for (BCAnswerValidator bcValidator : element.getAnswerValidators()) {
      BCAnswerValidatorVersion bcAnswerValidatorVersion = new BCAnswerValidatorVersion();
      bcAnswerValidatorVersion.copyFrom(bcValidator);
      bcAnswerValidatorVersion.setTaskElement(this);
      this.getAnswerValidators().add(bcAnswerValidatorVersion);
    }
  } // end method copyFrom

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCVariable createVariable() {
    if (this.variable == null) {
      BCVariable variable = new BCVariable();

      variable.setName(this.name);
      variable.setDisplayName(this.name);
      variable.setContext(ContextType.BUSINESS.name().toLowerCase());
      variable.setCategory("taskElement");
      variable.setBuildType("source");
      variable.setDataType(this.getProcessedDataType(this.dataType));
      variable.setBusinessDataType(this.getProcessedBusinessDataType(this.businessDataType));
      variable.setDisplayPosition("holder");
      this.variable = variable;
    } else {
      this.variable.setName(this.name);
      this.variable.setDisplayName(this.name);
      this.variable.setDataType(this.getProcessedDataType(this.dataType));
      this.variable.setBusinessDataType(this.getProcessedBusinessDataType(this.businessDataType));
      this.variable.setLastUpdateDate(new Date());
    }

    return this.variable;
  }

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

    if (!(o instanceof BCWorkflowTaskElementVersion)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BCWorkflowTaskElementVersion that = (BCWorkflowTaskElementVersion) o;

    if ((version != null) ? (!version.equals(that.version)) : (that.version != null)) {
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
  public Boolean getAllowShowOrHideDependentTaskElements() {
    if (allowShowOrHideDependentTaskElements == null) {
      return Boolean.FALSE;
    }

    return allowShowOrHideDependentTaskElements;
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

    for (BCWorkflowTaskAnswerOptionVersion option : this.answerOptions) {
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
  public Set<BCWorkflowTaskAnswerOptionVersion> getAnswerOptions() {
    return answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCAnswerValidatorVersion> getAnswerValidators() {
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
  public BCAssociatedField getBcAssociatedField() {
    return bcAssociatedField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getBcMappingFieldId() {
    if (bcAssociatedField != null) {
      return bcAssociatedField.getId();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCMetaDataField getBcMetaDataField() {
    return bcMetaDataField;
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
  public BCWorkflowTaskElementVersion getRefContext() {
    return refContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCVariable getVariable() {
    return variable;
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
  public BCWorkflowTaskElement getWorkflowTaskElement() {
    return workflowTaskElement;
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((version != null) ? version.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowShowOrHideDependentTaskElements  DOCUMENT ME!
   */
  public void setAllowShowOrHideDependentTaskElements(Boolean allowShowOrHideDependentTaskElements) {
    this.allowShowOrHideDependentTaskElements = allowShowOrHideDependentTaskElements;
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
            BCWorkflowTaskAnswerOptionVersion option = new BCWorkflowTaskAnswerOptionVersion(value);
            option.setDisplayOrder(index++);

            option.setTaskElement(this);
            this.answerOptions.add(option);
          }
        }
      }
    } else {
      this.answerOptions.clear();
    } // end if-else
  }   // end method setAnswerOptionFullString

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerOptions  DOCUMENT ME!
   */
  public void setAnswerOptions(Set<BCWorkflowTaskAnswerOptionVersion> answerOptions) {
    this.answerOptions = answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerValidators  DOCUMENT ME!
   */
  public void setAnswerValidators(Set<BCAnswerValidatorVersion> answerValidators) {
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
   * @param  bcAssociatedField  DOCUMENT ME!
   */
  public void setBcAssociatedField(BCAssociatedField bcAssociatedField) {
    this.bcAssociatedField = bcAssociatedField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bcMetaDataField  DOCUMENT ME!
   */
  public void setBcMetaDataField(BCMetaDataField bcMetaDataField) {
    this.bcMetaDataField = bcMetaDataField;
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
   * @param  refContext  DOCUMENT ME!
   */
  public void setRefContext(BCWorkflowTaskElementVersion refContext) {
    this.refContext = refContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variable  DOCUMENT ME!
   */
  public void setVariable(BCVariable variable) {
    this.variable = variable;
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
   * @param  workflowTaskElement  DOCUMENT ME!
   */
  public void setWorkflowTaskElement(BCWorkflowTaskElement workflowTaskElement) {
    this.workflowTaskElement = workflowTaskElement;
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
} // end class BCWorkflowTaskElementVersion
