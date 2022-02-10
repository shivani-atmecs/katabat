package com.ozstrategy.credagility.core.domain.dynamicview;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/16/2014 11:36
 */
@MappedSuperclass public class AbstractContextRenderer extends AbstractRenderer {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Embedded protected ContextObject contextObject = new ContextObject();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  AbstractRenderer#equals(Object)
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

    AbstractContextRenderer that = (AbstractContextRenderer) o;

    if ((contextObject != null) ? (!contextObject.equals(that.contextObject)) : (that.contextObject != null)) {
      return false;
    }

    return true;
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
   * @see  AbstractRenderer#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((contextObject != null) ? contextObject.hashCode() : 0);

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
} // end class AbstractContextRenderer
