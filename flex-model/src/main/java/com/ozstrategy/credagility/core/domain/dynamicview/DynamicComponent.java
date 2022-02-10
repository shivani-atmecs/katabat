package com.ozstrategy.credagility.core.domain.dynamicview;

import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.type.DynamicViewStatus;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/16/2014 11:40
 */
@Entity
@Table(name = "DynamicComponent")
public class DynamicComponent extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4082336602169322708L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String cls;

  /** TODO: DOCUMENT ME! */
  @Embedded protected ContextObject contextObject = new ContextObject();

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String description;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String extraConfig;


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
    name       = "providerId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DynamicComponentDataProvider provider;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "rendererId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DynamicComponentRenderer renderer;


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

    DynamicComponent component = (DynamicComponent) o;

    if ((cls != null) ? (!cls.equals(component.cls)) : (component.cls != null)) {
      return false;
    }

    if ((contextObject != null) ? (!contextObject.equals(component.contextObject))
                                : (component.contextObject != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(component.name)) : (component.name != null)) {
      return false;
    }

    if ((provider != null) ? (!provider.equals(component.provider)) : (component.provider != null)) {
      return false;
    }

    if ((renderer != null) ? (!renderer.equals(component.renderer)) : (component.renderer != null)) {
      return false;
    }

    if (status != component.status) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cls.
   *
   * @return  String
   */
  public String getCls() {
    return cls;
  }

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
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for extra config.
   *
   * @return  String
   */
  public String getExtraConfig() {
    return extraConfig;
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
   * getter method for provider.
   *
   * @return  DynamicComponentDataProvider
   */
  public DynamicComponentDataProvider getProvider() {
    return provider;
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
    result = (31 * result) + ((cls != null) ? cls.hashCode() : 0);
    result = (31 * result) + ((contextObject != null) ? contextObject.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((provider != null) ? provider.hashCode() : 0);
    result = (31 * result) + ((renderer != null) ? renderer.hashCode() : 0);
    result = (31 * result) + ((status != null) ? status.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cls.
   *
   * @param  cls  String
   */
  public void setCls(String cls) {
    this.cls = cls;
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
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for extra config.
   *
   * @param  extraConfig  String
   */
  public void setExtraConfig(String extraConfig) {
    this.extraConfig = extraConfig;
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
   * setter method for provider.
   *
   * @param  provider  DynamicComponentDataProvider
   */
  public void setProvider(DynamicComponentDataProvider provider) {
    this.provider = provider;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for renderer.
   *
   * @param  renderer  DynamicComponentRenderer
   */
  public void setRenderer(DynamicComponentRenderer renderer) {
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
} // end class DynamicComponent
