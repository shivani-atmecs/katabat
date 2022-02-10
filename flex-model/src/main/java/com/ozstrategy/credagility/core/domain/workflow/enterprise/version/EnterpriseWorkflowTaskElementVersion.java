package com.ozstrategy.credagility.core.domain.workflow.enterprise.version;

import com.cmc.credagility.core.domain.variable.Variable;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseAnswerValidator;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseWorkflowTaskAnswerOption;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseWorkflowTaskElement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Enterprise WorkflowTask Element Version.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 10:55
 */
@Entity
@Table(
  name    = "EnterpriseWorkflowTaskElementVersion",
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
public class EnterpriseWorkflowTaskElementVersion extends BasicWorkflowTaskElement implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2173327094659476417L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** answer Options version. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "taskElement",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("displayOrder asc")
  protected Set<EnterpriseWorkflowTaskAnswerOptionVersion> answerOptions =
    new LinkedHashSet<EnterpriseWorkflowTaskAnswerOptionVersion>();


  /** Enterprise Answer Validator Version. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "taskElement",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("priority ASC")
  protected Set<EnterpriseAnswerValidatorVersion> answerValidators =
    new LinkedHashSet<EnterpriseAnswerValidatorVersion>();

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
  protected EnterpriseWorkflowTaskElementVersion refContext;

  /** Variable. */
  @JoinColumn(
    name       = "variableId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected Variable variable;


  /** version. */
  protected Integer version = 0;


  /** workflowTaskElement. */
  @JoinColumn(
    name       = "workflowTaskElementId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected EnterpriseWorkflowTaskElement workflowTaskElement;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addAnswerOption.
   *
   * @param  option  EnterpriseWorkflowTaskAnswerOptionVersion
   */
  public void addAnswerOption(EnterpriseWorkflowTaskAnswerOptionVersion option) {
    option.setTaskElement(this);
    this.answerOptions.add(option);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addAnswerValidator.
   *
   * @param  bcAnswerValidator  EnterpriseAnswerValidatorVersion
   */
  public void addAnswerValidator(EnterpriseAnswerValidatorVersion bcAnswerValidator) {
    if (bcAnswerValidator != null) {
      this.answerValidators.add(bcAnswerValidator);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyFrom.
   *
   * @param  element  EnterpriseWorkflowTaskElement
   */
  public void copyFrom(EnterpriseWorkflowTaskElement element) {
    super.copy(element);
    this.setRefContext((element.getCurrentVersion() != null) ? element.getCurrentVersion().getRefContext() : null);
    this.setWorkflowTaskElement(element);
    this.setVariable(element.getVariable());
    this.setWorkflowTaskElement(element);

    // add answer options
    for (EnterpriseWorkflowTaskAnswerOption answerOption : element.getAnswerOptions()) {
      EnterpriseWorkflowTaskAnswerOptionVersion optionVersion = new EnterpriseWorkflowTaskAnswerOptionVersion();
      optionVersion.copyFrom(answerOption);
      optionVersion.setTaskElement(this);
      this.getAnswerOptions().add(optionVersion);
    }

    // add answer validators
    for (EnterpriseAnswerValidator answerValidator : element.getAnswerValidators()) {
      EnterpriseAnswerValidatorVersion answerValidatorVersionVersion = new EnterpriseAnswerValidatorVersion();
      answerValidatorVersionVersion.copyFrom(answerValidator);
      answerValidatorVersionVersion.setTaskElement(this);
      this.getAnswerValidators().add(answerValidatorVersionVersion);
    }
  } // end method copyFrom

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
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof EnterpriseWorkflowTaskElementVersion)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    EnterpriseWorkflowTaskElementVersion that = (EnterpriseWorkflowTaskElementVersion) o;

    if ((version != null) ? (!version.equals(that.version)) : (that.version != null)) {
      return false;
    }

    return true;
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

    for (EnterpriseWorkflowTaskAnswerOptionVersion option : this.answerOptions) {
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
  public Set<EnterpriseWorkflowTaskAnswerOptionVersion> getAnswerOptions() {
    return answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer validators.
   *
   * @return  Set
   */
  public Set<EnterpriseAnswerValidatorVersion> getAnswerValidators() {
    return answerValidators;
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
   * @return  EnterpriseWorkflowTaskElementVersion
   */
  public EnterpriseWorkflowTaskElementVersion getRefContext() {
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
   * getter method for version.
   *
   * @return  Integer
   */
  public Integer getVersion() {
    return version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow task element.
   *
   * @return  EnterpriseWorkflowTaskElement
   */
  public EnterpriseWorkflowTaskElement getWorkflowTaskElement() {
    return workflowTaskElement;
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
            EnterpriseWorkflowTaskAnswerOptionVersion option = new EnterpriseWorkflowTaskAnswerOptionVersion(value);
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
   * setter method for answer options.
   *
   * @param  answerOptions  Set
   */
  public void setAnswerOptions(Set<EnterpriseWorkflowTaskAnswerOptionVersion> answerOptions) {
    this.answerOptions = answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for answer validators.
   *
   * @param  answerValidators  Set
   */
  public void setAnswerValidators(Set<EnterpriseAnswerValidatorVersion> answerValidators) {
    this.answerValidators = answerValidators;
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
   * @param  refContext  EnterpriseWorkflowTaskElementVersion
   */
  public void setRefContext(EnterpriseWorkflowTaskElementVersion refContext) {
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
   * setter method for version.
   *
   * @param  version  Integer
   */
  public void setVersion(Integer version) {
    this.version = version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow task element.
   *
   * @param  workflowTaskElement  EnterpriseWorkflowTaskElement
   */
  public void setWorkflowTaskElement(EnterpriseWorkflowTaskElement workflowTaskElement) {
    this.workflowTaskElement = workflowTaskElement;
  }
} // end class EnterpriseWorkflowTaskElementVersion
