package com.cmc.credagility.core.domain.businesscontext;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.base.CreatorEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 11:17
 */
@Entity public class BCIStatusColorConfig extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8454774239269030231L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "businessContextId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContext businessContext;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String color;

  /** TODO: DOCUMENT ME! */
  protected String expression;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer priority;
  @Column(length = 255)
  private String            name;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof BCIStatusColorConfig)) {
      return false;
    }

    BCIStatusColorConfig that = (BCIStatusColorConfig) o;

    if ((businessContext != null) ? (!businessContext.equals(that.businessContext)) : (that.businessContext != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context.
   *
   * @return  BusinessContext
   */
  public BusinessContext getBusinessContext() {
    return businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for color.
   *
   * @return  String
   */
  public String getColor() {
    return color;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for expression.
   *
   * @return  String
   */
  public String getExpression() {
    return expression;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((businessContext != null) ? businessContext.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business context.
   *
   * @param  businessContext  BusinessContext
   */
  public void setBusinessContext(BusinessContext businessContext) {
    this.businessContext = businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for color.
   *
   * @param  color  String
   */
  public void setColor(String color) {
    this.color = color;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for expression.
   *
   * @param  expression  String
   */
  public void setExpression(String expression) {
    this.expression = expression;
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
   * @see  com.cmc.credagility.core.domain.base.CreatorEntity#toString()
   */
  @Override public String toString() {
    return "BCIGridConfig{"
      + "id=" + id
      + ", businessContext=" + businessContext
      + ", priority=" + priority
      + '}';
  }
} // end class BCIStatusColorConfig
