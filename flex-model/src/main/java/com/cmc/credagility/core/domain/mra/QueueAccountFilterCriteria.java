package com.cmc.credagility.core.domain.mra;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 14:11
 */
@Entity public class QueueAccountFilterCriteria extends AbstractBaseCriteria {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fieldName;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fieldValue;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "operatorId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected FilterOperator operator;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "filterId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected QueueAccountFilter queueAccountFilter;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for field name.
   *
   * @return  String
   */
  public String getFieldName() {
    return fieldName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for field value.
   *
   * @return  String
   */
  public String getFieldValue() {
    return fieldValue;
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
   * getter method for operator.
   *
   * @return  FilterOperator
   */
  public FilterOperator getOperator() {
    return operator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue account filter.
   *
   * @return  QueueAccountFilter
   */
  public QueueAccountFilter getQueueAccountFilter() {
    return queueAccountFilter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for field name.
   *
   * @param  fieldName  String
   */
  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for field value.
   *
   * @param  fieldValue  String
   */
  public void setFieldValue(String fieldValue) {
    this.fieldValue = fieldValue;
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
   * setter method for operator.
   *
   * @param  operator  FilterOperator
   */
  public void setOperator(FilterOperator operator) {
    this.operator = operator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue account filter.
   *
   * @param  queueAccountFilter  QueueAccountFilter
   */
  public void setQueueAccountFilter(QueueAccountFilter queueAccountFilter) {
    this.queueAccountFilter = queueAccountFilter;
  }

} // end class QueueAccountFilterCriteria
