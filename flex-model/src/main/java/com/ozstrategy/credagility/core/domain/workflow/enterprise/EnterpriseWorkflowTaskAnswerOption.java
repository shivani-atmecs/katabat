package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/17/2014 12:34
 */
@Entity @Table public class EnterpriseWorkflowTaskAnswerOption extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8750322391434620842L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column protected Integer displayOrder;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isDefault;

  /** option Name. */
  @Column(length = 256)
  protected String name;

  /** The portfolio which schedule belong to. */
  @JoinColumn(
    name       = "questionId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected EnterpriseWorkflowTaskElement taskElement = new EnterpriseWorkflowTaskElement();

  /** option description. */
  @Column(length = 1024)
  protected String value;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new EnterpriseWorkflowTaskAnswerOption object.
   */
  public EnterpriseWorkflowTaskAnswerOption() { }

  /**
   * Creates a new EnterpriseWorkflowTaskAnswerOption object.
   *
   * @param  value  $param.type$
   */
  public EnterpriseWorkflowTaskAnswerOption(String value) {
    if (value != null) {
      String[] buf = value.split("##::");

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
   * @param  optionVersion  $param.type$
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
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    EnterpriseWorkflowTaskAnswerOption that = (EnterpriseWorkflowTaskAnswerOption) o;

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((value != null) ? (!value.equals(that.value)) : (that.value != null)) {
      return false;
    }

    if ((isDefault != null) ? (!isDefault.equals(that.isDefault)) : (that.isDefault != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Boolean.
   *
   * @return  Boolean.
   */
  public Boolean getDefault() {
    if (isDefault == null) {
      return false;
    }

    return isDefault;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getDisplayOrder() {
    return displayOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * EnterpriseWorkflowTaskElement.
   *
   * @return  EnterpriseWorkflowTaskElement.
   */
  public EnterpriseWorkflowTaskElement getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((value != null) ? value.hashCode() : 0);
    result = (31 * result) + ((isDefault != null) ? isDefault.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setDefault.
   *
   * @param  aDefault  $param.type$
   */
  public void setDefault(Boolean aDefault) {
    isDefault = aDefault;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setDisplayOrder.
   *
   * @param  displayOrder  $param.type$
   */
  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setId.
   *
   * @param  id  $param.type$
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setName.
   *
   * @param  name  $param.type$
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setQuestion.
   *
   * @param  question  $param.type$
   */
  public void setQuestion(EnterpriseWorkflowTaskElement question) {
    this.taskElement = question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTaskElement.
   *
   * @param  taskElement  $param.type$
   */
  public void setTaskElement(EnterpriseWorkflowTaskElement taskElement) {
    this.taskElement = taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setValue.
   *
   * @param  value  $param.type$
   */
  public void setValue(String value) {
    this.value = value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("EnterpriseWorkflowTaskAnswerOption");
    sb.append("{id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", value='").append(value).append('\'');
    sb.append(", isDefault='").append(isDefault).append('\'');
// sb.append(", question=").append(question);
    sb.append('}');

    return sb.toString();
  }
} // end class EnterpriseWorkflowTaskAnswerOption
