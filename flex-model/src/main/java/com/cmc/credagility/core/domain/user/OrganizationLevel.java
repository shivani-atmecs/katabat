package com.cmc.credagility.core.domain.user;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.base.CreatorEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 16:18
 */
@MappedSuperclass public abstract class OrganizationLevel extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String description;

  @Column(
    nullable = false,
    unique   = true,
    length   = 40
  )
  private String name;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long organizationLevelId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new OrganizationLevel object.
   */
  public OrganizationLevel() { }

  /**
   * Creates a new OrganizationLevel object.
   *
   * @param  id  Long
   */
  public OrganizationLevel(Long id) {
    this.organizationLevelId = id;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for active roles.
   *
   * @return  Set
   */
  public abstract Set<Role> getActiveRoles();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for deleted roles.
   *
   * @return  Set
   */
  public abstract Set<Role> getDeletedRoles();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for active roles.
   *
   * @param  activeRoles  Set
   */
  public abstract void setActiveRoles(Set<Role> activeRoles);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for deleted roles.
   *
   * @param  deletedRoles  Set
   */
  public abstract void setDeletedRoles(Set<Role> deletedRoles);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    OrganizationLevel that = (OrganizationLevel) o;

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((organizationLevelId != null) ? (!organizationLevelId.equals(that.organizationLevelId))
                                      : (that.organizationLevelId != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
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
   * getter method for organization level id.
   *
   * @return  Long
   */
  public Long getOrganizationLevelId() {
    return organizationLevelId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role names.
   *
   * @return  String
   */
  public String getRoleNames() {
    StringBuilder sb = new StringBuilder();

    for (Role role : this.getActiveRoles()) {
      sb.append(role.getName());
      sb.append(", ");
    }

    if (sb.length() > 0) {
      sb.deleteCharAt(sb.length() - 1);
      sb.deleteCharAt(sb.length() - 1);
    }

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((organizationLevelId != null) ? organizationLevelId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
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
   * setter method for organization level id.
   *
   * @param  organizationLevelId  Long
   */
  public void setOrganizationLevelId(Long organizationLevelId) {
    this.organizationLevelId = organizationLevelId;
  }
} // end class OrganizationLevel
