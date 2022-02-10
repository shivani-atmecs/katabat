package com.cmc.credagility.core.domain.user;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.cmc.credagility.core.domain.type.AuditAction;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 16:41
 */
@Entity
@Table(
  name    = "RoleAudit",
  indexes = {
    @Index(
      columnList = "roleId",
      name = "roleIdIndex"
    )
  }
)
public class RoleAudit extends AbstractRole implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 6169870210587977372L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "action",
    nullable = false,
    length   = 255
  )
  @Enumerated(value = EnumType.STRING)
  public AuditAction action;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 40,
    nullable = false
  )
  protected String name;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "roleId",
    nullable = false
  )
  protected Long   roleId;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long roleAuditId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new RoleAudit object.
   */
  public RoleAudit() { }

  /**
   * Creates a new RoleAudit object.
   *
   * @param  role    Role
   * @param  action  AuditAction
   */
  public RoleAudit(Role role, AuditAction action) {
    Date now = new Date();

    this.createDate        = now;
    this.lastUpdateDate    = now;
    this.creator           = role.getCreator();
    this.lastUpdater       = role.getLastUpdater();
    this.roleId            = role.getId();
    this.organizationRole  = role.getOrganizationRole();
    this.description       = role.getDescription();
    this.name              = role.getName();
    this.organizationLevel = role.getOrganizationLevel();
    this.action            = action;
    this.deleted           = role.deleted;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof RoleAudit)) {
      return false;
    }

    final RoleAudit role = (RoleAudit) o;

    return !((name != null) ? (!name.equals(role.name)) : (role.name != null));

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action.
   *
   * @return  AuditAction
   */
  public AuditAction getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return this.name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role audit id.
   *
   * @return  Long
   */
  public Long getRoleAuditId() {
    return roleAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role id.
   *
   * @return  Long
   */
  public Long getRoleId() {
    return roleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    return ((name != null) ? name.hashCode() : 0);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action.
   *
   * @param  action  AuditAction
   */
  public void setAction(AuditAction action) {
    this.action = action;
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
   * setter method for role audit id.
   *
   * @param  roleAuditId  Long
   */
  public void setRoleAuditId(Long roleAuditId) {
    this.roleAuditId = roleAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role id.
   *
   * @param  roleId  Long
   */
  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.CreatorEntity#toString()
   */
  @Override public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(
        this.name).toString();
  }
} // end class RoleAudit
