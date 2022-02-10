package com.cmc.credagility.core.domain.twilio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * TODO:
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  11/19/2015 10:56
 */
@Entity public class CannotCallReasonPriority implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    unique   = true
  )
  protected Integer priority;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 100,
    unique   = true
  )
  protected String reasonMapping;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof CannotCallReasonPriority)) {
      return false;
    }

    CannotCallReasonPriority that = (CannotCallReasonPriority) o;

    if (!getPriority().equals(that.getPriority())) {
      return false;
    }

    return getReasonMapping().equals(that.getReasonMapping());

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getReasonMapping() {
    return reasonMapping;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = getPriority().hashCode();
    result = (31 * result) + getReasonMapping().hashCode();

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setId.
   *
   * @param  id  $param.type$
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPriority.
   *
   * @param  priority  $param.type$
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setReasonMapping.
   *
   * @param  reasonMapping  $param.type$
   */
  public void setReasonMapping(String reasonMapping) {
    this.reasonMapping = reasonMapping;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "CannotCallReasonPriority{"
      + "priority=" + priority
      + ", reasonMapping='" + reasonMapping + '\''
      + '}';
  }
} // end class CannotCallReasonPriority
