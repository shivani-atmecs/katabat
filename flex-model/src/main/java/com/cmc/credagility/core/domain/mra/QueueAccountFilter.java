package com.cmc.credagility.core.domain.mra;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 14:10
 */
@Entity public class QueueAccountFilter extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    mappedBy      = "parentFilter",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected List<QueueAccountFilter> childFilters = new ArrayList<QueueAccountFilter>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    mappedBy      = "queueAccountFilter",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected List<QueueAccountFilterCriteria> criteriaSet = new ArrayList<QueueAccountFilterCriteria>();

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
  @ManyToOne protected QueueAccountFilter parentFilter;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "portfolioId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "RoleAdvancedFilters",
    indexes            = { @Index(columnList = "filterId") },
    joinColumns        = {
      @JoinColumn(
        name           = "filterId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "roleId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(cascade = CascadeType.ALL)
  protected Set<Role> roles = new LinkedHashSet<Role>();

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String shared;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String sort;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for child filters.
   *
   * @return  List
   */
  public List<QueueAccountFilter> getChildFilters() {
    return childFilters;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria set.
   *
   * @return  List
   */
  public List<QueueAccountFilterCriteria> getCriteriaSet() {
    return criteriaSet;
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
   * @return  QueueAccountFilter
   */
  public QueueAccountFilter getParentFilter() {
    return parentFilter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for roles.
   *
   * @return  Set
   */
  public Set<Role> getRoles() {
    return roles;
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
   * removeRole.
   *
   * @param  role  Role
   */
  public void removeRole(Role role) {
    if (role == null) {
      return;
    }

    for (Role curRole : this.roles) {
      if (curRole.getId().equals(role.getId())) {
        this.roles.remove(curRole);

        return;
      }
    }

    return;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for child filters.
   *
   * @param  childFilters  List
   */
  public void setChildFilters(List<QueueAccountFilter> childFilters) {
    this.childFilters = childFilters;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for criteria set.
   *
   * @param  criteriaSet  List
   */
  public void setCriteriaSet(List<QueueAccountFilterCriteria> criteriaSet) {
    this.criteriaSet = criteriaSet;
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
   * @param  parentFilter  QueueAccountFilter
   */
  public void setParentFilter(QueueAccountFilter parentFilter) {
    this.parentFilter = parentFilter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for roles.
   *
   * @param  roles  Set
   */
  public void setRoles(Set<Role> roles) {
    this.roles = roles;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateFilter.
   *
   * @param  filter  QueueAccountFilter
   */
  public void updateFilter(QueueAccountFilter filter) {
    this.getCriteriaSet().clear();
    this.getChildFilters().clear();
    this.getChildFilters().addAll(filter.getChildFilters());
    this.getCriteriaSet().addAll(filter.getCriteriaSet());
    this.name           = filter.getName();
    this.operator       = filter.getOperator();
    this.sort           = filter.getSort();
    this.portfolio      = filter.getPortfolio();
    this.lastUpdater    = filter.getLastUpdater();
    this.lastUpdateDate = new Date();
  }
} // end class QueueAccountFilter
