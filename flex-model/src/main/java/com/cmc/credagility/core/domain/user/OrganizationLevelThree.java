package com.cmc.credagility.core.domain.user;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 16:22
 */
@Entity public class OrganizationLevelThree extends OrganizationLevel {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "organizationLevelThree"
  )
  @Where(clause = "deleted is null or deleted != 'Y'")
  private Set<Role> activeRoles = new LinkedHashSet<Role>();

  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "organizationLevelThree"
  )
  @Where(clause = "deleted = 'Y'")
  private Set<Role> deletedRoles = new LinkedHashSet<Role>();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new OrganizationLevelThree object.
   */
  public OrganizationLevelThree() { }

  /**
   * Creates a new OrganizationLevelThree object.
   *
   * @param  id  Long
   */
  public OrganizationLevelThree(Long id) {
    super(id);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.user.OrganizationLevel#getActiveRoles()
   */
  @Override public Set<Role> getActiveRoles() {
    return activeRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.user.OrganizationLevel#getDeletedRoles()
   */
  @Override public Set<Role> getDeletedRoles() {
    return deletedRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.user.OrganizationLevel#setActiveRoles(java.util.Set)
   */
  @Override public void setActiveRoles(Set<Role> activeRoles) {
    this.activeRoles = activeRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.user.OrganizationLevel#setDeletedRoles(java.util.Set)
   */
  @Override public void setDeletedRoles(Set<Role> deletedRoles) {
    this.deletedRoles = deletedRoles;
  }
} // end class OrganizationLevelThree
