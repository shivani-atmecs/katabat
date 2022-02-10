package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.cmc.credagility.core.domain.businesscontext.BCAssociatedField;
import com.cmc.credagility.core.domain.businesscontext.BCMetaDataField;
import com.cmc.credagility.core.domain.businesscontext.BCVariable;
import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.workflow.ContextType;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.bci.version.BCWorkflowTaskElementVersion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 13-2-26 : PM5:17</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name    = "BCWorkflowTaskElement",
  indexes = {
    @Index(
      name = "idx_questionCode",
      columnList = "questionCode"
    ), @Index(
      name = "FKB8_activeVersionId",
      columnList = "activeVersionId"
    ), @Index(
      name = "FKB8_variableId",
      columnList = "variableId"
    ), @Index(
      name = "FKB8_currentVersionId",
      columnList = "currentVersionId"
    )
  }
)
public class BCWorkflowTaskElement extends BasicWorkflowTaskElement implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8713643710450654535L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "activeVersionId",
    nullable   = true,
    insertable = true,
    updatable  = true,
    unique     = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTaskElementVersion activeVersion;

  /** CA-11591 Show/Hide Dependent Task Elements in Customer Portal Default is False. */
  @Column
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean         allowShowOrHideDependentTaskElements = Boolean.FALSE;

  /** BCWorkflowTaskAnswerOption PK taskElement. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "taskElement",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  @OrderBy("displayOrder asc")
  protected Set<BCWorkflowTaskAnswerOption> answerOptions = new LinkedHashSet<BCWorkflowTaskAnswerOption>();

  /** BCAnswerValidator PK taskElement. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "taskElement",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  @OrderBy("priority ASC")
  protected Set<BCAnswerValidator> answerValidators = new LinkedHashSet<BCAnswerValidator>();

  /** BCAssociatedField PK bcAssociatedFieldId. */
  @JoinColumn(
    name       = "bcAssociatedFieldId",
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

  /** BusinessContext PK businessContextId. */
  @JoinColumn(
    name       = "businessContextId",
    nullable   = false,
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContext businessContext;

  /** <code>true</code> allow download uploaded file. */
  @Transient protected Boolean canDownloadTemplate;

  /** BCWorkflowTaskElementVersion PK currentVersionId. */
  @JoinColumn(
    name       = "currentVersionId",
    nullable   = true,
    insertable = true,
    updatable  = true,
    unique     = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTaskElementVersion currentVersion;

  /** BCWorkflowTaskElementVersion PK workflowTaskElement. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowTaskElement",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<BCWorkflowTaskElementVersion> elementVersions = null;

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
  protected BCWorkflowTaskElement refContext;

  /** TODO: DOCUMENT ME! */
  @Transient protected String userSavedValue;

  /** BCVariable PK variableId. */
  @JoinColumn(
    name   = "variableId",
    unique = true
  )
  @ManyToOne(cascade = { CascadeType.ALL, CascadeType.REMOVE })
  protected BCVariable variable;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  option  DOCUMENT ME!
   */
  public void addAnswerOption(BCWorkflowTaskAnswerOption option) {
    option.setQuestion(this);
    this.answerOptions.add(option);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bcAnswerValidator  DOCUMENT ME!
   */
  public void addAnswerValidator(BCAnswerValidator bcAnswerValidator) {
    if (bcAnswerValidator != null) {
      this.answerValidators.add(bcAnswerValidator);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  validators  DOCUMENT ME!
   */

  /**
   * DOCUMENT ME!
   *
   * @param  validators  DOCUMENT ME!
   */
  public void copyBCValidatorData(BCAnswerValidator validators) {
    // create new
    if (validators != null) {
      validators.setId(null);
      validators.setTaskElement(this);
      answerValidators.add(validators);
    }

  }

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

      if (this.getBusinessContext() != null) {
        variable.setBusinessContext(this.getBusinessContext());
      }

      this.variable = variable;
    } else {
      this.variable.setName(this.name);
      this.variable.setDisplayName(this.name);
      this.variable.setDataType(this.getProcessedDataType(this.dataType));
      this.variable.setBusinessDataType(this.getProcessedBusinessDataType(this.businessDataType));
      this.variable.setLastUpdateDate(new Date());

      if (this.getBusinessContext() != null) {
        variable.setBusinessContext(this.getBusinessContext());
      }
    } // end if-else

    return this.variable;
  } // end method createVariable

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskElementVersion getActiveVersion() {
    return activeVersion;
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

    for (BCWorkflowTaskAnswerOption option : this.answerOptions) {
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
  public Set<BCWorkflowTaskAnswerOption> getAnswerOptions() {
    return answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCAnswerValidator> getAnswerValidators() {
    return answerValidators;
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
  public Long getBCFieldId() {
    if (bcMetaDataField != null) {
      return bcMetaDataField.getId();
    }

    return null;
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
  public BusinessContext getBusinessContext() {
    return businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for can download template.
   *
   * @return  Boolean
   */
  public Boolean getCanDownloadTemplate() {
    return canDownloadTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskElementVersion getCurrentVersion() {
    return currentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCWorkflowTaskElementVersion> getElementVersions() {
    return elementVersions;
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
  public BCWorkflowTaskElement getRefContext() {
    return refContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user saved value.
   *
   * @return  String
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
  public BCVariable getVariable() {
    return variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  activeVersion  DOCUMENT ME!
   */
  public void setActiveVersion(BCWorkflowTaskElementVersion activeVersion) {
    this.activeVersion = activeVersion;
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
            BCWorkflowTaskAnswerOption option = new BCWorkflowTaskAnswerOption(value);
            option.setDisplayOrder(index++);
            option.setQuestion(this);
            this.answerOptions.add(option);
          }
        }
      }
    } else {
      this.answerOptions.clear();
    } // end if-else
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerOptions  DOCUMENT ME!
   */
  public void setAnswerOptions(Set<BCWorkflowTaskAnswerOption> answerOptions) {
    this.answerOptions = answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerValidators  DOCUMENT ME!
   */
  public void setAnswerValidators(Set<BCAnswerValidator> answerValidators) {
    this.answerValidators = answerValidators;
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
   * @param  businessContext  DOCUMENT ME!
   */
  public void setBusinessContext(BusinessContext businessContext) {
    this.businessContext = businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for can download template.
   *
   * @param  canDownloadTemplate  Boolean
   */
  public void setCanDownloadTemplate(Boolean canDownloadTemplate) {
    this.canDownloadTemplate = canDownloadTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  currentVersion  DOCUMENT ME!
   */
  public void setCurrentVersion(BCWorkflowTaskElementVersion currentVersion) {
    this.currentVersion = currentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  elementVersions  DOCUMENT ME!
   */
  public void setElementVersions(Set<BCWorkflowTaskElementVersion> elementVersions) {
    this.elementVersions = elementVersions;
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
  public void setRefContext(BCWorkflowTaskElement refContext) {
    this.refContext = refContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user saved value.
   *
   * @param  userSavedValue  String
   */
  public void setUserSavedValue(String userSavedValue) {
    this.userSavedValue = userSavedValue;
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
} // end class BCWorkflowTaskElement
