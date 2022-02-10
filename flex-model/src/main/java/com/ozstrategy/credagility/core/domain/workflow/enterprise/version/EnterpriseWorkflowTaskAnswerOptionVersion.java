package com.ozstrategy.credagility.core.domain.workflow.enterprise.version;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.EnterpriseWorkflowTaskAnswerOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Enterprise WorkflowTask Answer Option Version!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 10:50
 */
@Entity
@Table(name = "EnterpriseWorkflowTaskAnswerOptionVersion")
public class EnterpriseWorkflowTaskAnswerOptionVersion extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3919986364133470720L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** display Order. */
  @Column protected Integer displayOrder;

  /** Primary key. */

  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Default to selected. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isDefault;

  /** option Name. */
  @Column(length = 256)
  protected String name;

  /** The portfolio which schedule belong to. */
  @JoinColumn(
    name       = "questionVersionId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected EnterpriseWorkflowTaskElementVersion taskElement = new EnterpriseWorkflowTaskElementVersion();


  /** option description. */
  @Column(length = 1024)
  protected String value;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new EnterpriseWorkflowTaskAnswerOptionVersion object.
   */
  public EnterpriseWorkflowTaskAnswerOptionVersion() { }


  /**
   * Creates a new EnterpriseWorkflowTaskAnswerOptionVersion object.
   *
   * @param  value  String
   */
  public EnterpriseWorkflowTaskAnswerOptionVersion(String value) {
    if (value != null) {
      String[] buf = value.split(":");

      if (buf.length > 0) {
        name = buf[0].trim();
      }

      if (buf.length > 1) {
        this.value = buf[1].trim();
      } else {
        this.value = name;
      }

      if (buf.length == 3) {
        this.isDefault = new Boolean(buf[2].trim()).booleanValue();
      } else if (buf.length == 4) {
        this.isDefault = new Boolean(buf[3].trim()).booleanValue();
      }
    }
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * copyFrom.
   *
   * @param  optionVersion  EnterpriseWorkflowTaskAnswerOption
   */
  public void copyFrom(EnterpriseWorkflowTaskAnswerOption optionVersion) {
    this.name           = optionVersion.getName();
    this.value          = optionVersion.getValue();
    this.isDefault      = optionVersion.getDefault();
    this.displayOrder   = optionVersion.getDisplayOrder();
    this.createDate     = new Date();
    this.lastUpdateDate = new Date();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof EnterpriseWorkflowTaskAnswerOptionVersion)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    EnterpriseWorkflowTaskAnswerOptionVersion that = (EnterpriseWorkflowTaskAnswerOptionVersion) o;

    if ((displayOrder != null) ? (!displayOrder.equals(that.displayOrder)) : (that.displayOrder != null)) {
      return false;
    }

    if ((isDefault != null) ? (!isDefault.equals(that.isDefault)) : (that.isDefault != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((value != null) ? (!value.equals(that.value)) : (that.value != null)) {
      return false;
    }


    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default.
   *
   * @return  Boolean
   */
  public Boolean getDefault() {
    if (isDefault == null) {
      return false;
    }

    return isDefault;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for display order.
   *
   * @return  Integer
   */
  public Integer getDisplayOrder() {
    return displayOrder;
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
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task element.
   *
   * @return  EnterpriseWorkflowTaskElementVersion
   */
  public EnterpriseWorkflowTaskElementVersion getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for value.
   *
   * @return  String
   */
  public String getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((displayOrder != null) ? displayOrder.hashCode() : 0);
    result = (31 * result) + ((isDefault != null) ? isDefault.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((value != null) ? value.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default.
   *
   * @param  aDefault  Boolean
   */
  public void setDefault(Boolean aDefault) {
    isDefault = aDefault;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for display order.
   *
   * @param  displayOrder  Integer
   */
  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
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
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task element.
   *
   * @param  taskElement  EnterpriseWorkflowTaskElementVersion
   */
  public void setTaskElement(EnterpriseWorkflowTaskElementVersion taskElement) {
    this.taskElement = taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value.
   *
   * @param  value  String
   */
  public void setValue(String value) {
    this.value = value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("EnterpriseWorkflowTaskAnswerOptionVersion{");
    sb.append("displayOrder=").append(displayOrder);
    sb.append(", id=").append(id);
    sb.append(", isDefault=").append(isDefault);
    sb.append(", name='").append(name).append('\'');
    sb.append(", taskElement=").append(taskElement);
    sb.append(", value='").append(value).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class EnterpriseWorkflowTaskAnswerOptionVersion
