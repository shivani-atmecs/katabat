package com.ozstrategy.credagility.core.domain.dynamicview;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo</a>
 * @version  10/18/2014 11:49
 */
@Entity
@Table(name = "DynamicComponentRenderArgument")
public class DynamicComponentRenderArgument implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2355282269814839465L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String defaultValue;


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
  @JoinColumn(
    name       = "renderId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DynamicComponentRenderer renderer;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof DynamicComponentRenderArgument)) {
      return false;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    DynamicComponentRenderArgument that = (DynamicComponentRenderArgument) o;

    if ((renderer != null) ? (!renderer.equals(that.renderer)) : (that.renderer != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default value.
   *
   * @return  String
   */
  public String getDefaultValue() {
    return defaultValue;
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
   * getter method for renderer.
   *
   * @return  DynamicComponentRenderer
   */
  public DynamicComponentRenderer getRenderer() {
    return renderer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (renderer != null) ? renderer.hashCode() : 0;
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  defaultValue  DOCUMENT ME!
   */
  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
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
   * @param  renderer  DOCUMENT ME!
   */
  public void setRenderer(DynamicComponentRenderer renderer) {
    this.renderer = renderer;
  }
} // end class DynamicComponentRenderArgument
