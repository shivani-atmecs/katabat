package com.cmc.credagility.core.domain.businesscontext;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.mra.BCIBaseCriteria;
import com.cmc.credagility.core.domain.mra.FilterOperator;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 11:05
 */
@Entity public class BCIQueueFilterCriteria extends BCIBaseCriteria {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "bciQueueFilterId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected BCIQueueFilter bciQueueFilter;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fieldName;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fieldValue;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "filterOperatorId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected FilterOperator filterOperator;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for bci queue filter.
   *
   * @return  BCIQueueFilter
   */
  public BCIQueueFilter getBciQueueFilter() {
    return bciQueueFilter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for filter operator.
   *
   * @return  FilterOperator
   */
  public FilterOperator getFilterOperator() {
    return filterOperator;
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
   * setter method for bci queue filter.
   *
   * @param  bciQueueFilter  BCIQueueFilter
   */
  public void setBciQueueFilter(BCIQueueFilter bciQueueFilter) {
    this.bciQueueFilter = bciQueueFilter;
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
   * setter method for filter operator.
   *
   * @param  filterOperator  FilterOperator
   */
  public void setFilterOperator(FilterOperator filterOperator) {
    this.filterOperator = filterOperator;
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
} // end class BCIQueueFilterCriteria
