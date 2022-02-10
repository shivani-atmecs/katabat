package com.ozstrategy.credagility.core.domain.workflow.bci.version;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCWorkflowTaskAnswerOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 10/9/13 Time: 3:19 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCWorkflowTaskAnswerOptionVersion")
public class BCWorkflowTaskAnswerOptionVersion extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8238046873392030619L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Answer option priority. */
  @Column protected Integer displayOrder;

  /** Primary key. */

  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** <code>true</code> selected this answer option automatic. */
  @Column(
    name             = "isDefault",
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
  protected BCWorkflowTaskElementVersion taskElement = new BCWorkflowTaskElementVersion();


  /** option description. */
  @Column(length = 1024)
  protected String value;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BCWorkflowTaskAnswerOption object.
   */
  public BCWorkflowTaskAnswerOptionVersion() { }

  /**
   * Creates a new BCWorkflowTaskAnswerOption object.
   *
   * @param  value  DOCUMENT ME!
   */
  public BCWorkflowTaskAnswerOptionVersion(String value) {
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
   * DOCUMENT ME!
   *
   * @param  optionVersion  DOCUMENT ME!
   */
  public void copyFrom(BCWorkflowTaskAnswerOption optionVersion) {
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

    if (!(o instanceof BCWorkflowTaskAnswerOptionVersion)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BCWorkflowTaskAnswerOptionVersion that = (BCWorkflowTaskAnswerOptionVersion) o;

    if ((displayOrder != null) && !displayOrder.equals(that.displayOrder)) {
      return false;
    }

    if ((isDefault != null) && !isDefault.equals(that.isDefault)) {
      return false;
    }

    if ((name != null) && !name.equals(that.name)) {
      return false;
    }

    if ((value != null) && !value.equals(that.value)) {
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
  public Boolean getDefault() {
    if (isDefault == null) {
      return false;
    }

    return isDefault;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDisplayOrder() {
    return displayOrder;
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
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskElementVersion getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
    result = (31 * result) + ((displayOrder != null) ? displayOrder.hashCode() : 0);
    result = (31 * result) + ((isDefault != null) ? isDefault.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((value != null) ? value.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  aDefault  DOCUMENT ME!
   */
  public void setDefault(Boolean aDefault) {
    isDefault = aDefault;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  displayOrder  DOCUMENT ME!
   */
  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
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
   * @param  name  DOCUMENT ME!
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskElement  DOCUMENT ME!
   */
  public void setTaskElement(BCWorkflowTaskElementVersion taskElement) {
    this.taskElement = taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  value  DOCUMENT ME!
   */
  public void setValue(String value) {
    this.value = value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("BCWorkflowTaskAnswerOptionVersion{");
    sb.append("displayOrder=").append(displayOrder);
    sb.append(", id=").append(id);
    sb.append(", isDefault=").append(isDefault);
    sb.append(", name='").append(name).append('\'');
    sb.append(", taskElement=").append(taskElement);
    sb.append(", value='").append(value).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class BCWorkflowTaskAnswerOptionVersion
