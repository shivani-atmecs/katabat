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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.cmc.credagility.core.domain.mra.AgencyBaseQueueSorter;
import com.cmc.credagility.core.domain.user.Role;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/17/2014 10:20
 */
@Entity public class AgencyQueueSorter extends AgencyBaseQueueSorter {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3898387344224272940L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    mappedBy = "agencyQueueSorter",
    cascade  = CascadeType.ALL
  )
  @OrderBy(value = "priority asc")
  protected List<AgencyQueueSorterCriteria> agencyQueueSorterCriterias = new ArrayList<AgencyQueueSorterCriteria>();

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "RoleAdvancedAgencyQueueSorters",
    indexes            = { @Index(columnList = "agencyQueueSorterId") },
    joinColumns        = {
      @JoinColumn(
        name           = "agencyQueueSorterId",
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
  @ManyToMany(cascade = javax.persistence.CascadeType.ALL)
  protected Set<Role> roles = new LinkedHashSet<Role>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency queue sorter criterias.
   *
   * @return  List
   */
  public List<AgencyQueueSorterCriteria> getAgencyQueueSorterCriterias() {
    return agencyQueueSorterCriterias;
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
   * setter method for agency queue sorter criterias.
   *
   * @param  agencyQueueSorterCriterias  List
   */
  public void setAgencyQueueSorterCriterias(List<AgencyQueueSorterCriteria> agencyQueueSorterCriterias) {
    this.agencyQueueSorterCriterias = agencyQueueSorterCriterias;
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
   * updateSorter.
   *
   * @param  sorter  AgencyQueueSorter
   */
  public void updateSorter(AgencyQueueSorter sorter) {
    this.name = sorter.getName();
    this.agencyQueueSorterCriterias.clear();
    this.agencyQueueSorterCriterias.addAll(sorter.getAgencyQueueSorterCriterias());
    this.lastUpdateDate = new Date();
  }
} // end class AgencyQueueSorter
