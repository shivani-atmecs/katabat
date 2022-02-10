package com.ozstrategy.credagility.core.domain.dynamicview;

import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.type.DynamicViewStatus;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/16/2014 14:09
 */
@Entity
@Table(name = "DynamicToolbar")
public class DynamicToolbar extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4475790736967341838L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Embedded protected ContextObject contextObject = new ContextObject();

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String name;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "rendererId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DynamicToolbarRenderer renderer;

  /** When 'DynamicViewStatus.DELETED', you can not use it. */
  @Column(length = 16)
  @Enumerated(value = EnumType.STRING)
  protected DynamicViewStatus status = DynamicViewStatus.ACTIVE;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    DynamicToolbar that = (DynamicToolbar) o;

    if ((contextObject != null) ? (!contextObject.equals(that.contextObject)) : (that.contextObject != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((renderer != null) ? (!renderer.equals(that.renderer)) : (that.renderer != null)) {
      return false;
    }

    if (status != that.status) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for context object.
   *
   * @return  ContextObject
   */
  public ContextObject getContextObject() {
    return contextObject;
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
   * @return  DynamicToolbarRenderer
   */
  public DynamicToolbarRenderer getRenderer() {
    return renderer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  DynamicViewStatus
   */
  public DynamicViewStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((contextObject != null) ? contextObject.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((renderer != null) ? renderer.hashCode() : 0);
    result = (31 * result) + ((status != null) ? status.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for context object.
   *
   * @param  contextObject  ContextObject
   */
  public void setContextObject(ContextObject contextObject) {
    this.contextObject = contextObject;
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
   * setter method for renderer.
   *
   * @param  renderer  DynamicToolbarRenderer
   */
  public void setRenderer(DynamicToolbarRenderer renderer) {
    this.renderer = renderer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  DynamicViewStatus
   */
  public void setStatus(DynamicViewStatus status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.CreatorEntity#toString()
   */
  @Override public String toString() {
    return "DynamicToolbar{"
      + "id=" + id
      + ", name='" + name + '\''
      + ", renderer=" + renderer
      + ", status=" + status
      + ", " + contextObject
      + '}';
  }
} // end class DynamicToolbar
