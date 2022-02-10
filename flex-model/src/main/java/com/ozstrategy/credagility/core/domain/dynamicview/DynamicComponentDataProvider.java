package com.ozstrategy.credagility.core.domain.dynamicview;

import com.ozstrategy.credagility.core.domain.type.DynamicViewStatus;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/16/2014 11:42
 */
@Entity
@Table(
  name              = "DynamicComponentDataProvider",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "context", "contextId" }) }
)
public class DynamicComponentDataProvider implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 733047078975490261L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 32
  )
  protected String beanName;

  /** TODO: DOCUMENT ME! */
  @Embedded protected ContextObject contextObject = new ContextObject();

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

  /** When 'DynamicViewStatus.DELETED', you can not use it. */
  @Column(length = 16)
  @Enumerated(value = EnumType.STRING)
  protected DynamicViewStatus status = DynamicViewStatus.ACTIVE;

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

    DynamicComponentDataProvider that = (DynamicComponentDataProvider) o;

    if ((beanName != null) ? (!beanName.equals(that.beanName)) : (that.beanName != null)) {
      return false;
    }

    if ((contextObject != null) ? (!contextObject.equals(that.contextObject)) : (that.contextObject != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if (status != that.status) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bean name.
   *
   * @return  String
   */
  public String getBeanName() {
    return beanName;
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
   * getter method for status.
   *
   * @return  DynamicViewStatus
   */
  public DynamicViewStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (beanName != null) ? beanName.hashCode() : 0;
    result = (31 * result) + ((contextObject != null) ? contextObject.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((status != null) ? status.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bean name.
   *
   * @param  beanName  String
   */
  public void setBeanName(String beanName) {
    this.beanName = beanName;
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
   * setter method for status.
   *
   * @param  status  DynamicViewStatus
   */
  public void setStatus(DynamicViewStatus status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    return "DynamicComponentDataProvider{"
      + "name='" + name + '\''
      + ", status=" + status
      + ", beanName='" + beanName + '\''
      + "," + contextObject
      + '}';
  }
} // end class DynamicComponentDataProvider
