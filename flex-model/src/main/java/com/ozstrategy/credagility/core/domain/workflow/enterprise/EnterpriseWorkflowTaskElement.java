package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.cmc.credagility.core.domain.variable.Variable;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.version.EnterpriseWorkflowTaskElementVersion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/17/2014 13:37
 */
@Entity
@Table(
  name    = "EnterpriseWorkflowTaskElement",
  indexes = {
    @Index(
      name = "idx_questionCode",
      columnList = "questionCode"
    )
  }
)
public class EnterpriseWorkflowTaskElement extends BasicWorkflowTaskElement implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4993659539056609978L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "activeVersionId",
    nullable   = true,
    insertable = true,
    updatable  = true,
    unique     = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTaskElementVersion activeVersion;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "taskElement",
    cascade  = CascadeType.ALL
  )
  @OrderBy("displayOrder asc")
  protected Set<EnterpriseWorkflowTaskAnswerOption> answerOptions =
    new LinkedHashSet<EnterpriseWorkflowTaskAnswerOption>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "taskElement",
    cascade  = CascadeType.ALL
  )
  @OrderBy("priority ASC")
  protected Set<EnterpriseAnswerValidator> answerValidators = new LinkedHashSet<EnterpriseAnswerValidator>();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "currentVersionId",
    nullable   = true,
    insertable = true,
    updatable  = true,
    unique     = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTaskElementVersion currentVersion;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowTaskElement",
    cascade  = CascadeType.ALL
  )
  protected Set<EnterpriseWorkflowTaskElementVersion> elementVersions = null;

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
  protected EnterpriseWorkflowTaskElement refContext;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name   = "variableId",
    unique = true
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected Variable variable;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addAnswerOption.
   *
   * @param  option  EnterpriseWorkflowTaskAnswerOption
   */
  public void addAnswerOption(EnterpriseWorkflowTaskAnswerOption option) {
    option.setQuestion(this);
    this.answerOptions.add(option);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addAnswerValidator.
   *
   * @param  bcAnswerValidator  EnterpriseAnswerValidator
   */
  public void addAnswerValidator(EnterpriseAnswerValidator bcAnswerValidator) {
    if (bcAnswerValidator != null) {
      this.answerValidators.add(bcAnswerValidator);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // end method addValidatorData
  /**
   * copyFrom.
   *
   * @param  element  EnterpriseWorkflowTaskElement
   */
  public void copyFrom(EnterpriseWorkflowTaskElement element) {
    super.copy(element);
    this.setRefContext(element.getRefContext());
    this.setVariable(element.getVariable());

    ///////// add answer options
    for (EnterpriseWorkflowTaskAnswerOption answerOption : element.getAnswerOptions()) {
      EnterpriseWorkflowTaskAnswerOption optionVersion = new EnterpriseWorkflowTaskAnswerOption();
      optionVersion.copyFrom(answerOption);
      optionVersion.setTaskElement(this);
      this.getAnswerOptions().add(optionVersion);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyValidatorData.
   *
   * @param  validators  EnterpriseAnswerValidator
   */
  public void copyValidatorData(EnterpriseAnswerValidator validators) {
    if (validators != null) {
      validators.setId(null);
      validators.setTaskElement(this);
      answerValidators.add(validators);
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createVariable.
   *
   * @return  Variable
   */
  public Variable createVariable() {
    if (this.variable == null) {
      Variable variable = new Variable();

      variable.setName(this.name);
      variable.setDisplayName(this.name);
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
   * getter method for active version.
   *
   * @return  EnterpriseWorkflowTaskElementVersion
   */
  public EnterpriseWorkflowTaskElementVersion getActiveVersion() {
    return activeVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer option full string.
   *
   * @return  String
   */
  public String getAnswerOptionFullString() {
    StringBuilder buf = new StringBuilder();

    int i = 1;

    for (EnterpriseWorkflowTaskAnswerOption option : this.answerOptions) {
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
   * getter method for answer options.
   *
   * @return  Set
   */
  public Set<EnterpriseWorkflowTaskAnswerOption> getAnswerOptions() {
    return answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer validators.
   *
   * @return  Set
   */
  public Set<EnterpriseAnswerValidator> getAnswerValidators() {
    return answerValidators;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current version.
   *
   * @return  EnterpriseWorkflowTaskElementVersion
   */
  public EnterpriseWorkflowTaskElementVersion getCurrentVersion() {
    return currentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for element versions.
   *
   * @return  Set
   */
  public Set<EnterpriseWorkflowTaskElementVersion> getElementVersions() {
    return elementVersions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ref context.
   *
   * @return  EnterpriseWorkflowTaskElement
   */
  public EnterpriseWorkflowTaskElement getRefContext() {
    return refContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable.
   *
   * @return  Variable
   */
  public Variable getVariable() {
    return variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for active version.
   *
   * @param  activeVersion  EnterpriseWorkflowTaskElementVersion
   */
  public void setActiveVersion(EnterpriseWorkflowTaskElementVersion activeVersion) {
    this.activeVersion = activeVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for answer option full string.
   *
   * @param  answerOptionFullString  String
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
            EnterpriseWorkflowTaskAnswerOption option = new EnterpriseWorkflowTaskAnswerOption(value);
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
   * setter method for answer options.
   *
   * @param  answerOptions  Set
   */
  public void setAnswerOptions(Set<EnterpriseWorkflowTaskAnswerOption> answerOptions) {
    this.answerOptions = answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for answer validators.
   *
   * @param  answerValidators  Set
   */
  public void setAnswerValidators(Set<EnterpriseAnswerValidator> answerValidators) {
    this.answerValidators = answerValidators;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current version.
   *
   * @param  currentVersion  EnterpriseWorkflowTaskElementVersion
   */
  public void setCurrentVersion(EnterpriseWorkflowTaskElementVersion currentVersion) {
    this.currentVersion = currentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for element versions.
   *
   * @param  elementVersions  Set
   */
  public void setElementVersions(Set<EnterpriseWorkflowTaskElementVersion> elementVersions) {
    this.elementVersions = elementVersions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ref context.
   *
   * @param  refContext  EnterpriseWorkflowTaskElement
   */
  public void setRefContext(EnterpriseWorkflowTaskElement refContext) {
    this.refContext = refContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable.
   *
   * @param  variable  Variable
   */
  public void setVariable(Variable variable) {
    this.variable = variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateAnswerValidators.
   *
   * @param  metaData  EnterpriseWorkflowTaskElement
   */
  public void updateAnswerValidators(EnterpriseWorkflowTaskElement metaData) {
    Set<EnterpriseAnswerValidator> awOptions = metaData.getAnswerValidators();

    if (!answerValidators.isEmpty()) {
      answerValidators.clear();
    }

    if (!awOptions.isEmpty()) {
      answerValidators.addAll(awOptions);
    }
  }


} // end class EnterpriseWorkflowTaskElement
