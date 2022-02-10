package com.ozstrategy.credagility.core.domain.workflow.basic;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 13-2-19 : PM4:49</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class BasicWorkflowProgressStep extends BaseEntity implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Primary key. */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String description;

  /** Primary key. */
  @Column(nullable = false)
  protected Integer stepNumber;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract BasicWorkflow getWorkflow();

  //~ ------------------------------------------------------------------------------------------------------------------

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

    if (!super.equals(o)) {
      return false;
    }

    BasicWorkflowProgressStep that = (BasicWorkflowProgressStep) o;

    if (!description.equals(that.description)) {
      return false;
    }

    if (!stepNumber.equals(that.stepNumber)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getStepNumber() {
    return stepNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + description.hashCode();
    result = (31 * result) + stepNumber.hashCode();
    result = (31 * result) + getWorkflow().hashCode();

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  description  DOCUMENT ME!
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  stepNumber  DOCUMENT ME!
   */
  public void setStepNumber(Integer stepNumber) {
    this.stepNumber = stepNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("WorkflowProgressStep");
    sb.append("{description='").append(description).append('\'');
    sb.append(", stepNumber=").append(stepNumber);
    sb.append(", workflow=").append(getWorkflow().name);
    sb.append('}');

    return sb.toString();
  }
} // end class BasicWorkflowProgressStep
