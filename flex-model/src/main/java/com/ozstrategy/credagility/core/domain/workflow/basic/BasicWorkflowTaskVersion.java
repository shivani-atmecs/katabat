package com.ozstrategy.credagility.core.domain.workflow.basic;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 11/21/13 : 5:08 PM</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class BasicWorkflowTaskVersion extends BasicWorkflowTask {
  //~ Instance fields --------------------------------------------------------------------------------------------------
  /** DOCUMENT ME! */ @Column protected Integer version = 1;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicWorkflowTask#copy(BasicWorkflowTask)
   */
  @Override public void copy(BasicWorkflowTask o) {
    super.copy(o);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicWorkflowTask#equals(Object)
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

    BasicWorkflowTaskVersion that = (BasicWorkflowTaskVersion) o;

    if ((version != null) ? (!version.equals(that.version)) : (that.version != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getVersion() {
    return version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BasicWorkflowTask#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((version != null) ? version.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  version  DOCUMENT ME!
   */
  public void setVersion(Integer version) {
    this.version = version;
  }
} // end class BasicWorkflowTaskVersion
