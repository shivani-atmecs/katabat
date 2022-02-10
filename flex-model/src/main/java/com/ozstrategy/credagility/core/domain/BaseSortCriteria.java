package com.ozstrategy.credagility.core.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 11:24
 */
@MappedSuperclass public class BaseSortCriteria extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Description for the sorting criteria. */
  @Column(length = 255)
  protected String description;

  /** direction for the sorting criteria. ASC/DESC */
  @Column(
    length   = 8,
    nullable = false
  )
  protected String direction;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    BaseSortCriteria that = (BaseSortCriteria) o;

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((direction != null) ? (!direction.equals(that.direction)) : (that.direction != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The description.
   *
   * @return  the description
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for direction.
   *
   * @return  String
   */
  public String getDirection() {
    return direction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = 47;
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((direction != null) ? direction.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set description.
   *
   * <p>.@param description the description to set</p>
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for direction.
   *
   * @param  direction  String
   */
  public void setDirection(String direction) {
    this.direction = direction;
  }

} // end class BaseSortCriteria
