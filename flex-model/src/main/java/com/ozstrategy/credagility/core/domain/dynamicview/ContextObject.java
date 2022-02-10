package com.ozstrategy.credagility.core.domain.dynamicview;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/16/2014 11:38
 */
@Embeddable public class ContextObject implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3143763223906657758L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable   = false,
    insertable = true,
    updatable  = false,
    length     = 15
  )
  protected String context;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable   = true,
    insertable = true,
    updatable  = false
  )
  protected Long contextId;

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

    ContextObject that = (ContextObject) o;

    if ((context != null) ? (!context.equals(that.context)) : (that.context != null)) {
      return false;
    }

    if ((contextId != null) ? (!contextId.equals(that.contextId)) : (that.contextId != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for context.
   *
   * @return  String
   */
  public String getContext() {
    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for context id.
   *
   * @return  Long
   */
  public Long getContextId() {
    return contextId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (context != null) ? context.hashCode() : 0;
    result = (31 * result) + ((contextId != null) ? contextId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for context.
   *
   * @param  context  String
   */
  public void setContext(String context) {
    this.context = context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for context id.
   *
   * @param  contextId  Long
   */
  public void setContextId(Long contextId) {
    this.contextId = contextId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    return "context='" + context + "\', contextId=" + contextId;
  }
} // end class ContextObject
