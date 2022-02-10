package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Target BaseType Configuration.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 17:02
 */
@MappedSuperclass public abstract class TargetBaseTypeConfiguration {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** primary key. */

  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** multiple. */
  @Column(
    name             = "multiple",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean multiple = true;


  /** priority. */
  @Column(name = "priority")
  protected Integer priority = 1;


  /** selected. */
  @Column(
    name             = "selected",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean selected = true;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * copy.
   *
   * @param   configuration  TargetBaseTypeConfiguration
   *
   * @return  TargetBaseTypeConfiguration
   */
  public TargetBaseTypeConfiguration copy(TargetBaseTypeConfiguration configuration) {
    this.multiple = configuration.getMultiple();
    this.priority = configuration.getPriority();
    this.selected = configuration.getSelected();

    return this;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    TargetBaseTypeConfiguration that = (TargetBaseTypeConfiguration) o;

    if ((multiple != null) ? (!multiple.equals(that.multiple)) : (that.multiple != null)) {
      return false;
    }

    if ((priority != null) ? (!priority.equals(that.priority)) : (that.priority != null)) {
      return false;
    }

    if ((selected != null) ? (!selected.equals(that.selected)) : (that.selected != null)) {
      return false;
    }

    return true;
  } // end method equals

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
   * getter method for multiple.
   *
   * @return  Boolean
   */
  public Boolean getMultiple() {
    if (multiple == null) {
      return Boolean.FALSE;
    }

    return multiple;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for selected.
   *
   * @return  Boolean
   */
  public Boolean getSelected() {
    if (selected == null) {
      return Boolean.FALSE;
    }

    return selected;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (multiple != null) ? multiple.hashCode() : 0;
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + ((selected != null) ? selected.hashCode() : 0);

    return result;
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
   * setter method for multiple.
   *
   * @param  multiple  Boolean
   */
  public void setMultiple(Boolean multiple) {
    this.multiple = multiple;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for selected.
   *
   * @param  selected  Boolean
   */
  public void setSelected(Boolean selected) {
    this.selected = selected;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("TargetBaseTypeConfiguration");
    sb.append("{id=").append(id);
    sb.append(", multiple=").append(multiple);
    sb.append(", priority=").append(priority);
    sb.append(", selected=").append(selected);
    sb.append('}');

    return sb.toString();
  }
} // end class TargetBaseTypeConfiguration
