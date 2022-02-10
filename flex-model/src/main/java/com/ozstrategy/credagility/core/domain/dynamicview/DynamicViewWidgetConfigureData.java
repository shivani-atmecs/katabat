package com.ozstrategy.credagility.core.domain.dynamicview;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/16/2014 15:15
 */
@Entity
@Table(name = "DynamicViewWidgetConfigureData")
public class DynamicViewWidgetConfigureData implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5780495213054302201L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String format;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String header;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 64
  )
  protected String name;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer priority;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String value;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "widgetId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DynamicViewWidget widget;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    DynamicViewWidgetConfigureData that = (DynamicViewWidgetConfigureData) o;

    if ((widget != null) ? (!widget.equals(that.widget)) : (that.widget != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for format.
   *
   * @return  String
   */
  public String getFormat() {
    return format;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for header.
   *
   * @return  String
   */
  public String getHeader() {
    return header;
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
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
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
   * getter method for widget.
   *
   * @return  DynamicViewWidget
   */
  public DynamicViewWidget getWidget() {
    return widget;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (widget != null) ? widget.hashCode() : 0;
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * paste.
   *
   * @param  newConfigureData  DynamicViewWidgetConfigureData
   */
  public void paste(DynamicViewWidgetConfigureData newConfigureData) {
    newConfigureData.setName(this.getName());
    newConfigureData.setValue(this.getValue());
    newConfigureData.setPriority(this.getPriority());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for format.
   *
   * @param  format  String
   */
  public void setFormat(String format) {
    this.format = format;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for header.
   *
   * @param  header  String
   */
  public void setHeader(String header) {
    this.header = header;
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
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
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
   * setter method for widget.
   *
   * @param  widget  DynamicViewWidget
   */
  public void setWidget(DynamicViewWidget widget) {
    this.widget = widget;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuffer sb = new StringBuffer("DynamicViewWidgetConfigureData{");
    sb.append("id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", priority=").append(priority);
    sb.append(", value='").append(value).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class DynamicViewWidgetConfigureData
