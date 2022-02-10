package com.ozstrategy.credagility.core.domain.document;

import com.cmc.credagility.core.domain.mra.FilterOperator;
import com.ozstrategy.credagility.core.domain.CreatorEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store DocumentSearchFilter information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:14
 */
@Entity public class DocumentSearchFilter extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    mappedBy      = "parentFilter",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected List<DocumentSearchFilter> childFilters = new ArrayList<DocumentSearchFilter>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    mappedBy      = "documentSearchFilter",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected List<DocumentSearchFilterCriteria> criteriaSet = new ArrayList<DocumentSearchFilterCriteria>();


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  protected String name;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "operatorId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected FilterOperator operator;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "parentFilterId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected DocumentSearchFilter parentFilter;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String sort;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for child filters.
   *
   * @return  List
   */
  public List<DocumentSearchFilter> getChildFilters() {
    return childFilters;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria set.
   *
   * @return  List
   */
  public List<DocumentSearchFilterCriteria> getCriteriaSet() {
    return criteriaSet;
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
   * getter method for operator.
   *
   * @return  FilterOperator
   */
  public FilterOperator getOperator() {
    return operator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for parent filter.
   *
   * @return  DocumentSearchFilter
   */
  public DocumentSearchFilter getParentFilter() {
    return parentFilter;
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
   * setter method for child filters.
   *
   * @param  childFilters  List
   */
  public void setChildFilters(List<DocumentSearchFilter> childFilters) {
    this.childFilters = childFilters;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for criteria set.
   *
   * @param  criteriaSet  List
   */
  public void setCriteriaSet(List<DocumentSearchFilterCriteria> criteriaSet) {
    this.criteriaSet = criteriaSet;
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
   * setter method for operator.
   *
   * @param  operator  FilterOperator
   */
  public void setOperator(FilterOperator operator) {
    this.operator = operator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for parent filter.
   *
   * @param  parentFilter  DocumentSearchFilter
   */
  public void setParentFilter(DocumentSearchFilter parentFilter) {
    this.parentFilter = parentFilter;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateFilter.
   *
   * @param  filter  DocumentSearchFilter
   */
  public void updateFilter(DocumentSearchFilter filter) {
    this.getCriteriaSet().clear();
    this.getChildFilters().clear();
    this.getChildFilters().addAll(filter.getChildFilters());
    this.getCriteriaSet().addAll(filter.getCriteriaSet());
    this.name           = filter.getName();
    this.operator       = filter.getOperator();
    this.sort           = filter.getSort();
    this.lastUpdater    = filter.getLastUpdater();
    this.lastUpdateDate = new Date();
  }
} // end class DocumentSearchFilter
