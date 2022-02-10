package com.ozstrategy.credagility.core.domain.dynamicview;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/16/2014 15:11
 */
@Entity
@Table(name = "DynamicViewToolbarConfigureRenderer")
public class DynamicViewToolbarConfigureRenderer implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7699688739157425878L;

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
  protected DynamicToolbarRendererArgument renderArgument;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String value;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "viewToolbarId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DynamicViewToolbar viewToolbar;

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

    DynamicViewToolbarConfigureRenderer that = (DynamicViewToolbarConfigureRenderer) o;

    if ((renderArgument != null) ? (!renderArgument.equals(that.renderArgument)) : (that.renderArgument != null)) {
      return false;
    }

    if ((viewToolbar != null) ? (!viewToolbar.equals(that.viewToolbar)) : (that.viewToolbar != null)) {
      return false;
    }

    if ((value != null) ? (!value.equals(that.value)) : (that.value != null)) {
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
   * getter method for render argument.
   *
   * @return  DynamicToolbarRendererArgument
   */
  public DynamicToolbarRendererArgument getRenderArgument() {
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
   * getter method for view toolbar.
   *
   * @return  DynamicViewToolbar
   */
  public DynamicViewToolbar getViewToolbar() {
    return viewToolbar;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (renderArgument != null) ? renderArgument.hashCode() : 0;
    result = (31 * result) + ((viewToolbar != null) ? viewToolbar.hashCode() : 0);
    result = (31 * result) + ((value != null) ? value.hashCode() : 0);

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
   * setter method for render argument.
   *
   * @param  renderArgument  DynamicToolbarRendererArgument
   */
  public void setRenderArgument(DynamicToolbarRendererArgument renderArgument) {
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
   * setter method for view toolbar.
   *
   * @param  viewToolbar  DynamicViewToolbar
   */
  public void setViewToolbar(DynamicViewToolbar viewToolbar) {
    this.viewToolbar = viewToolbar;
  }


} // end class DynamicViewToolbarConfigureRenderer
