package com.cmc.credagility.core.domain.businesscontext;

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

import com.cmc.credagility.core.domain.mra.BCIBaseQueueFilter;
import com.cmc.credagility.core.domain.user.Role;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 11:04
 */
@Entity public class BCIQueueFilter extends BCIBaseQueueFilter {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    mappedBy = "bciQueueFilter",
    cascade  = CascadeType.ALL
  )
  protected List<BCIQueueFilterCriteria> bciQueueFilterCriterias = new ArrayList<BCIQueueFilterCriteria>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    mappedBy = "parentBCIQueueFilter",
    cascade  = CascadeType.ALL
  )
  protected List<BCIQueueFilter> childBCIQueueFilters = new ArrayList<BCIQueueFilter>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "parentBCIQueueFilterId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected BCIQueueFilter parentBCIQueueFilter;

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "RoleAdvancedBCIQueueFilters",
    indexes            = { @Index(columnList = "bciQueueFilterId") },
    joinColumns        = {
      @JoinColumn(
        name           = "bciQueueFilterId",
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
  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  protected Set<Role> roles = new LinkedHashSet<Role>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for bci queue filter criterias.
   *
   * @return  List
   */
  public List<BCIQueueFilterCriteria> getBciQueueFilterCriterias() {
    return bciQueueFilterCriterias;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for child BCIQueue filters.
   *
   * @return  List
   */
  public List<BCIQueueFilter> getChildBCIQueueFilters() {
    return childBCIQueueFilters;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for parent BCIQueue filter.
   *
   * @return  BCIQueueFilter
   */
  public BCIQueueFilter getParentBCIQueueFilter() {
    return parentBCIQueueFilter;
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
   * setter method for bci queue filter criterias.
   *
   * @param  bciQueueFilterCriterias  List
   */
  public void setBciQueueFilterCriterias(List<BCIQueueFilterCriteria> bciQueueFilterCriterias) {
    this.bciQueueFilterCriterias = bciQueueFilterCriterias;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for child BCIQueue filters.
   *
   * @param  childBCIQueueFilters  List
   */
  public void setChildBCIQueueFilters(List<BCIQueueFilter> childBCIQueueFilters) {
    this.childBCIQueueFilters = childBCIQueueFilters;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for parent BCIQueue filter.
   *
   * @param  parentBCIQueueFilter  BCIQueueFilter
   */
  public void setParentBCIQueueFilter(BCIQueueFilter parentBCIQueueFilter) {
    this.parentBCIQueueFilter = parentBCIQueueFilter;
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
   * @param  filter  BCIQueueFilter
   */
  public void updateFilter(BCIQueueFilter filter) {
    this.getBciQueueFilterCriterias().clear();
    this.getChildBCIQueueFilters().clear();
    this.getBciQueueFilterCriterias().addAll(filter.getBciQueueFilterCriterias());
    this.getChildBCIQueueFilters().addAll(filter.getChildBCIQueueFilters());

    this.name           = filter.getName();
    this.filterOperator = filter.getFilterOperator();
    this.sort           = filter.getSort();
    this.lastUpdater    = filter.getLastUpdater();
    this.lastUpdateDate = new Date();
  }
} // end class BCIQueueFilter
