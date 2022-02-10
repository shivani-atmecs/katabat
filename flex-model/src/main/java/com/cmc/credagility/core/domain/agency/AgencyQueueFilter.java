package com.cmc.credagility.core.domain.agency;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.cmc.credagility.core.domain.mra.AgencyBaseQueueFilter;
import com.cmc.credagility.core.domain.user.Role;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/17/2014 10:15
 */
@Entity public class AgencyQueueFilter extends AgencyBaseQueueFilter {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6709393067266415520L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    mappedBy = "agencyQueueFilter",
    cascade  = CascadeType.ALL
  )
  protected List<AgencyQueueFilterCriteria> agencyQueueFilterCriterias = new ArrayList<AgencyQueueFilterCriteria>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    mappedBy = "parentAgencyQueueFilter",
    cascade  = CascadeType.ALL
  )
  protected List<AgencyQueueFilter> childAgencyQueueFilters = new ArrayList<AgencyQueueFilter>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "parentAgencyQueueFilterId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected AgencyQueueFilter parentAgencyQueueFilter;

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "RoleAdvancedAgencyQueueFilters",
    indexes            = { @Index(columnList = "agencyQueueFilterId") },
    joinColumns        = {
      @JoinColumn(
        name           = "agencyQueueFilterId",
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

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency queue filter criterias.
   *
   * @return  List
   */
  public List<AgencyQueueFilterCriteria> getAgencyQueueFilterCriterias() {
    return agencyQueueFilterCriterias;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for child agency queue filters.
   *
   * @return  List
   */
  public List<AgencyQueueFilter> getChildAgencyQueueFilters() {
    return childAgencyQueueFilters;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for parent agency queue filter.
   *
   * @return  AgencyQueueFilter
   */
  public AgencyQueueFilter getParentAgencyQueueFilter() {
    return parentAgencyQueueFilter;
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
   * setter method for agency queue filter criterias.
   *
   * @param  agencyQueueFilterCriterias  List
   */
  public void setAgencyQueueFilterCriterias(List<AgencyQueueFilterCriteria> agencyQueueFilterCriterias) {
    this.agencyQueueFilterCriterias = agencyQueueFilterCriterias;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for child agency queue filters.
   *
   * @param  childAgencyQueueFilters  List
   */
  public void setChildAgencyQueueFilters(List<AgencyQueueFilter> childAgencyQueueFilters) {
    this.childAgencyQueueFilters = childAgencyQueueFilters;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for parent agency queue filter.
   *
   * @param  parentAgencyQueueFilter  AgencyQueueFilter
   */
  public void setParentAgencyQueueFilter(AgencyQueueFilter parentAgencyQueueFilter) {
    this.parentAgencyQueueFilter = parentAgencyQueueFilter;
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
   * updateFilter.
   *
   * @param  filter  AgencyQueueFilter
   */
  public void updateFilter(AgencyQueueFilter filter) {
    this.getAgencyQueueFilterCriterias().clear();
    this.getChildAgencyQueueFilters().clear();
    this.getAgencyQueueFilterCriterias().addAll(filter.getAgencyQueueFilterCriterias());
    this.getChildAgencyQueueFilters().addAll(filter.getChildAgencyQueueFilters());

    this.name           = filter.getName();
    this.filterOperator = filter.getFilterOperator();
    this.sort           = filter.getSort();
    this.lastUpdater    = filter.getLastUpdater();
    this.lastUpdateDate = new Date();
  }
} // end class AgencyQueueFilter
