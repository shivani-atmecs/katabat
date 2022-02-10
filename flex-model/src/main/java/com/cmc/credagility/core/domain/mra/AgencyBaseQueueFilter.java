package com.cmc.credagility.core.domain.mra;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 12:34
 */
@MappedSuperclass public abstract class AgencyBaseQueueFilter extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

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

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String name;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "historical",
    nullable         = true,
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean historical = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String shared;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String sort;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for historical.
   *
   * @return  Boolean
   */
  public Boolean getHistorical() {
    if (historical == null) {
      return Boolean.FALSE;
    }

    return historical;
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
   * getter method for shared.
   *
   * @return  String
   */
  public String getShared() {
    return shared;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sort.
   *
   * @return  String
   */
  public String getSort() {
    return sort;
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
   * setter method for historical.
   *
   * @param  historical  Boolean
   */
  public void setHistorical(Boolean historical) {
    this.historical = historical;
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
   * setter method for shared.
   *
   * @param  shared  String
   */
  public void setShared(String shared) {
    this.shared = shared;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sort.
   *
   * @param  sort  String
   */
  public void setSort(String sort) {
    this.sort = sort;
  }
} // end class AgencyBaseQueueFilter
