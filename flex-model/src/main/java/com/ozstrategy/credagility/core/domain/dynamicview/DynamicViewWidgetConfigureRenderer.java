package com.ozstrategy.credagility.core.domain.dynamicview;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/16/2014 15:16
 */
@Entity
@Table(name = "DynamicViewWidgetConfigureRenderer")
public class DynamicViewWidgetConfigureRenderer implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3011029424515464484L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "renderArgId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DynamicComponentRenderArgument renderArgument;

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

    DynamicViewWidgetConfigureRenderer that = (DynamicViewWidgetConfigureRenderer) o;

    if ((widget != null) ? (!widget.equals(that.widget)) : (that.widget != null)) {
      return false;
    }

    if ((renderArgument != null) ? (!renderArgument.equals(that.renderArgument)) : (that.renderArgument != null)) {
      return false;
    }

    return true;
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
   * getter method for render argument.
   *
   * @return  DynamicComponentRenderArgument
   */
  public DynamicComponentRenderArgument getRenderArgument() {
    return renderArgument;
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
    result = (31 * result) + ((renderArgument != null) ? renderArgument.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * paste.
   *
   * @param  newConfigureRenderer  DynamicViewWidgetConfigureRenderer
   */
  public void paste(DynamicViewWidgetConfigureRenderer newConfigureRenderer) {
    newConfigureRenderer.setRenderArgument(this.getRenderArgument());
    newConfigureRenderer.setValue(this.getValue());
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
   * setter method for render argument.
   *
   * @param  renderArgument  DynamicComponentRenderArgument
   */
  public void setRenderArgument(DynamicComponentRenderArgument renderArgument) {
    this.renderArgument = renderArgument;
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
} // end class DynamicViewWidgetConfigureRenderer
