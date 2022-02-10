package com.ozstrategy.credagility.core.domain.workflow.customer.version;

import com.cmc.credagility.core.domain.variable.Variable;
import com.ozstrategy.credagility.core.domain.workflow.ContextType;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.customer.CustomerAnswerValidator;
import com.ozstrategy.credagility.core.domain.workflow.customer.CustomerWorkflowTaskAnswerOption;
import com.ozstrategy.credagility.core.domain.workflow.customer.CustomerWorkflowTaskElement;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Index;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Created by tangwei on 17/3/6.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  04/10/2017 11:23
 */
@Entity
@Table(name = "CustomerWorkflowTaskElementVersion")
public class CustomerWorkflowTaskElementVersion extends BasicWorkflowTaskElement implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -8931716132531813261L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Cascade({ CascadeType.DELETE_ORPHAN, CascadeType.ALL })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "taskElementVersion"
  )
  @OrderBy("displayOrder asc")
  protected Set<CustomerWorkflowTaskAnswerOptionVersion> answerOptions =
    new LinkedHashSet<CustomerWorkflowTaskAnswerOptionVersion>();

  /** DOCUMENT ME! */
  @Cascade({ CascadeType.DELETE_ORPHAN, CascadeType.ALL })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "taskElementVersion"
  )
  @OrderBy("priority ASC")
  protected Set<CustomerAnswerValidatorVersion> answerValidators = new LinkedHashSet<CustomerAnswerValidatorVersion>();

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
  protected CustomerWorkflowTaskElementVersion refContext;

  /** DOCUMENT ME! */
  @Cascade({ CascadeType.ALL, CascadeType.DELETE_ORPHAN })
  @JoinColumn(
    name       = "variableId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Variable variable;

  /** DOCUMENT ME! */
  @Index(name = "idx_version")
  protected Integer version = 0;

  /** DOCUMENT ME! */
  @Cascade({ CascadeType.ALL, CascadeType.DELETE_ORPHAN })
  @JoinColumn(
    name       = "workflowTaskElementId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTaskElement workflowTaskElement;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  option  DOCUMENT ME!
   */
  public void addAnswerOption(CustomerWorkflowTaskAnswerOptionVersion option) {
    option.setTaskElementVersion(this);
    this.answerOptions.add(option);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerValidator  DOCUMENT ME!
   */
  public void addAnswerValidator(CustomerAnswerValidatorVersion answerValidator) {
    if (answerValidator != null) {
      this.answerValidators.add(answerValidator);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  element  DOCUMENT ME!
   */
  public void copyFrom(CustomerWorkflowTaskElement element) {
    super.copy(element);
    this.setRefContext((element.getCurrentVersion() != null) ? element.getCurrentVersion().getRefContext() : null);
    this.setWorkflowTaskElement(element);
    this.setVariable(element.getVariable());
    this.setWorkflowTaskElement(element);

    // add answer options
    for (CustomerWorkflowTaskAnswerOption answerOption : element.getAnswerOptions()) {
      CustomerWorkflowTaskAnswerOptionVersion optionVersion = new CustomerWorkflowTaskAnswerOptionVersion();
      optionVersion.copyFrom(answerOption);
      optionVersion.setTaskElementVersion(this);
      this.getAnswerOptions().add(optionVersion);
    }

    // add answer validators
    for (CustomerAnswerValidator answerValidator : element.getAnswerValidators()) {
      CustomerAnswerValidatorVersion answerValidatorVersionVersion = new CustomerAnswerValidatorVersion();
      answerValidatorVersionVersion.copyFrom(answerValidator);
      answerValidatorVersionVersion.setTaskElementVersion(this);
      this.getAnswerValidators().add(answerValidatorVersionVersion);
    }
  } // end method copyFrom

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
    }

    return this.variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof CustomerWorkflowTaskElementVersion)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    CustomerWorkflowTaskElementVersion that = (CustomerWorkflowTaskElementVersion) o;

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
  public String getAnswerOptionFullString() {
    StringBuilder buf = new StringBuilder();

    int i = 1;

    for (CustomerWorkflowTaskAnswerOptionVersion option : this.answerOptions) {
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
  public Set<CustomerWorkflowTaskAnswerOptionVersion> getAnswerOptions() {
    return answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<CustomerAnswerValidatorVersion> getAnswerValidators() {
    return answerValidators;
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
  public CustomerWorkflowTaskElementVersion getRefContext() {
    return refContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Variable getVariable() {
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
  public CustomerWorkflowTaskElement getWorkflowTaskElement() {
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
            CustomerWorkflowTaskAnswerOptionVersion option = new CustomerWorkflowTaskAnswerOptionVersion(value);
            option.setDisplayOrder(index++);

            option.setTaskElementVersion(this);
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
  public void setAnswerOptions(Set<CustomerWorkflowTaskAnswerOptionVersion> answerOptions) {
    this.answerOptions = answerOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerValidators  DOCUMENT ME!
   */
  public void setAnswerValidators(Set<CustomerAnswerValidatorVersion> answerValidators) {
    this.answerValidators = answerValidators;
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
  public void setRefContext(CustomerWorkflowTaskElementVersion refContext) {
    this.refContext = refContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variable  DOCUMENT ME!
   */
  public void setVariable(Variable variable) {
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
  public void setWorkflowTaskElement(CustomerWorkflowTaskElement workflowTaskElement) {
    this.workflowTaskElement = workflowTaskElement;
  }
} // end class CustomerWorkflowTaskElementVersion
