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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.cmc.credagility.core.domain.mra.BCIBaseQueueSorter;
import com.cmc.credagility.core.domain.user.Role;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 11:08
 */
@Entity public class BCIQueueSorter extends BCIBaseQueueSorter {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    mappedBy = "bciQueueSorter",
    cascade  = CascadeType.ALL
  )
  @OrderBy(value = "priority asc")
  protected List<BCIQueueSorterCriteria> bciQueueSorterCriterias = new ArrayList<BCIQueueSorterCriteria>();

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "RoleAdvancedBCIQueueSorters",
    indexes            = { @Index(columnList = "bciQueueSorterId") },
    joinColumns        = {
      @JoinColumn(
        name           = "bciQueueSorterId",
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
   * getter method for bci queue sorter criterias.
   *
   * @return  List
   */
  public List<BCIQueueSorterCriteria> getBciQueueSorterCriterias() {
    return bciQueueSorterCriterias;
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
   * setter method for bci queue sorter criterias.
   *
   * @param  bciQueueSorterCriterias  List
   */
  public void setBciQueueSorterCriterias(List<BCIQueueSorterCriteria> bciQueueSorterCriterias) {
    this.bciQueueSorterCriterias = bciQueueSorterCriterias;
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
   * @param  sorter  BCIQueueSorter
   */
  public void updateSorter(BCIQueueSorter sorter) {
    this.name = sorter.getName();
    this.bciQueueSorterCriterias.clear();
    this.bciQueueSorterCriterias.addAll(sorter.getBciQueueSorterCriterias());
    this.lastUpdateDate = new Date();
  }

} // end class BCIQueueSorter
