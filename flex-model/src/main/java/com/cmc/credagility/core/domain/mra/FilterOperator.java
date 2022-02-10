package com.cmc.credagility.core.domain.mra;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

import com.cmc.credagility.core.domain.base.CreatorEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 13:04
 */
@Entity public class FilterOperator extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  public static final String TYPE_LOGICAL = "logical";

  /** TODO: DOCUMENT ME! */
  public static final String TYPE_CRITERIA = "criteria";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String actualOperator;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String displayName;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  // support data type : int date string etc.
  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String support;

  // logical : and or not
  // criteria : >= <=  etc.
  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String type;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for type criteria.
   *
   * @return  String
   */
  public static String getTypeCriteria() {
    return TYPE_CRITERIA;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type logical.
   *
   * @return  String
   */
  public static String getTypeLogical() {
    return TYPE_LOGICAL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for actual operator.
   *
   * @return  String
   */
  public String getActualOperator() {
    return actualOperator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for display name.
   *
   * @return  String
   */
  public String getDisplayName() {
    return displayName;
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
   * getter method for support.
   *
   * @return  String
   */
  public String getSupport() {
    return support;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  String
   */
  public String getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for actual operator.
   *
   * @param  actualOperator  String
   */
  public void setActualOperator(String actualOperator) {
    this.actualOperator = actualOperator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for display name.
   *
   * @param  displayName  String
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
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
   * setter method for support.
   *
   * @param  support  String
   */
  public void setSupport(String support) {
    this.support = support;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type.
   *
   * @param  type  String
   */
  public void setType(String type) {
    this.type = type;
  }
} // end class FilterOperator
