package com.cmc.credagility.core.domain.user;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 16:01
 */
@MappedSuperclass public class AbstractRole extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8544646254859038386L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean deleted = false;

  /** TODO: DOCUMENT ME! */
  @Column(length = 64)
  protected String description;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer organizationLevel = 0;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean organizationRole = false;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for deleted.
   *
   * @return  Boolean
   */
  public Boolean getDeleted() {
    if (deleted == null) {
      return Boolean.FALSE;
    }

    return deleted;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return this.description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for organization level.
   *
   * @return  Integer
   */
  public Integer getOrganizationLevel() {
    return organizationLevel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for organization role.
   *
   * @return  Boolean
   */
  public Boolean getOrganizationRole() {
    if (organizationRole == null) {
      return Boolean.FALSE;
    }

    return organizationRole;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for deleted.
   *
   * @param  deleted  Boolean
   */
  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
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
   * setter method for organization level.
   *
   * @param  organizationLevel  Integer
   */
  public void setOrganizationLevel(Integer organizationLevel) {
    this.organizationLevel = organizationLevel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for organization role.
   *
   * @param  organizationRole  Boolean
   */
  public void setOrganizationRole(Boolean organizationRole) {
    this.organizationRole = organizationRole;
  }


} // end class AbstractRole
