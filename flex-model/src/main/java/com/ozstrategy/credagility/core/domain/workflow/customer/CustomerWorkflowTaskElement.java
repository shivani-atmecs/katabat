package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.cmc.credagility.core.domain.variable.Variable;
import com.ozstrategy.credagility.core.domain.workflow.ContextType;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.customer.version.CustomerWorkflowTaskElementVersion;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Created by tangwei on 17/3/6.
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  03/06/2017 23:26
 */
@Entity
@Table(name = "CustomerWorkflowTaskElement")
public class CustomerWorkflowTaskElement extends BasicWorkflowTaskElement implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 2395589350469176707L;

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
  protected CustomerWorkflowTaskElementVersion activeVersion;

  /** DOCUMENT ME! */
  @Cascade({ CascadeType.DELETE_ORPHAN, CascadeType.ALL })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "taskElement"
  )
  @OrderBy("displayOrder asc")
  protected Set<CustomerWorkflowTaskAnswerOption> answerOptions = new LinkedHashSet<CustomerWorkflowTaskAnswerOption>();

  /** DOCUMENT ME! */
  @Cascade({ CascadeType.DELETE_ORPHAN, CascadeType.ALL })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "taskElement"
  )
  @OrderBy("priority ASC")
  protected Set<CustomerAnswerValidator> answerValidators = new LinkedHashSet<CustomerAnswerValidator>();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "currentVersionId",
    nullable   = true,
    insertable = true,
    updatable  = true,
    unique     = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTaskElementVersion currentVersion;

  /** DOCUMENT ME! */
  @Cascade({ CascadeType.ALL, CascadeType.DELETE_ORPHAN })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowTaskElement"
  )
  protected Set<CustomerWorkflowTaskElementVersion> elementVersions = null;

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
  protected CustomerWorkflowTaskElement refContext;

  /** DOCUMENT ME! */
  @Cascade({ CascadeType.ALL, CascadeType.DELETE_ORPHAN })
  @JoinColumn(
    name   = "variableId",
    unique = true
  )
  @ManyToOne protected Variable variable;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  option  DOCUMENT ME!
   */
  public void addAnswerOption(CustomerWorkflowTaskAnswerOption option) {
    option.setQuestion(this);
    this.answerOptions.add(option);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerValidator  DOCUMENT ME!
   */
  public void addAnswerValidator(CustomerAnswerValidator answerValidator) {
    if (answerValidator != null) {
      this.answerValidators.add(answerValidator);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyFrom.
   *
   * @param  element  CustomerWorkflowTaskElement
   */
  public void copyFrom(CustomerWorkflowTaskElement element) {
    super.copy(element);
    this.setRefContext(element.getRefContext());
    this.setVariable(element.getVariable());

    ///////// add answer options
    for (CustomerWorkflowTaskAnswerOption answerOption : element.getAnswerOptions()) {
      CustomerWorkflowTaskAnswerOption optionVersion = new CustomerWorkflowTaskAnswerOption();
      optionVersion.copyFrom(answerOption);
      optionVersion.setTaskElement(this);
      this.getAnswerOptions().add(optionVersion);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyValidatorData.
   *
   * @param  validators  CustomerAnswerValidator
   */
  public void copyValidatorData(CustomerAnswerValidator validators) {
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
  public Variable createVariable() {
    if (this.variable == null) {
      Variable variable = new Variable();

      variable.setName(this.name);
      variable.setDisplayName(this.name);
      variable.setContext(ContextType.CUSTOMER.name().toLowerCase());
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

    } // end if-else

    return this.variable;
  } // end method createVariable

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskElementVersion getActiveVersion() {
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

    for (CustomerWorkflowTaskAnswerOption option : this.answerOptions) {
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
  public Set<CustomerWorkflowTaskAnswerOption> getAnswerOptions() {
    return answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<CustomerAnswerValidator> getAnswerValidators() {
    return answerValidators;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskElementVersion getCurrentVersion() {
    return currentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<CustomerWorkflowTaskElementVersion> getElementVersions() {
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
  public CustomerWorkflowTaskElement getRefContext() {
    return refContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable.
   *
   * @return  CustomerVariable
   */
  public Variable getVariable() {
    return variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  activeVersion  DOCUMENT ME!
   */
  public void setActiveVersion(CustomerWorkflowTaskElementVersion activeVersion) {
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
            CustomerWorkflowTaskAnswerOption option = new CustomerWorkflowTaskAnswerOption(value);
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
  public void setAnswerOptions(Set<CustomerWorkflowTaskAnswerOption> answerOptions) {
    this.answerOptions = answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerValidators  DOCUMENT ME!
   */
  public void setAnswerValidators(Set<CustomerAnswerValidator> answerValidators) {
    this.answerValidators = answerValidators;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  currentVersion  DOCUMENT ME!
   */
  public void setCurrentVersion(CustomerWorkflowTaskElementVersion currentVersion) {
    this.currentVersion = currentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  elementVersions  DOCUMENT ME!
   */
  public void setElementVersions(Set<CustomerWorkflowTaskElementVersion> elementVersions) {
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
  public void setRefContext(CustomerWorkflowTaskElement refContext) {
    this.refContext = refContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable.
   *
   * @param  variable  CustomerVariable
   */
  public void setVariable(Variable variable) {
    this.variable = variable;
  }

} // end class CustomerWorkflowTaskElement
