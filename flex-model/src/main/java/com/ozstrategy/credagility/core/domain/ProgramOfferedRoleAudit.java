package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.type.AuditAction;
import com.cmc.credagility.core.domain.user.Role;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 14:19
 */
@Entity
@Table(name = "ProgramOfferedRoleAudit")
public class ProgramOfferedRoleAudit extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -8436370843593767628L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  @Enumerated(value = EnumType.STRING)
  public AuditAction action;

  @Column(nullable = false)
  private Long programActionId;

  @Column(
    nullable = false,
    length   = 255
  )
  private String programActionName;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long programOfferedRoleAuditId;

  @Column(nullable = false)
  private Long roleId;

  @Column(
    nullable = false,
    length   = 255
  )
  private String roleName;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ProgramOfferedRoleAudit object.
   */
  public ProgramOfferedRoleAudit() { }


  /**
   * Creates a new ProgramOfferedRoleAudit object.
   *
   * @param  program  ProgramAction
   * @param  role     Role
   * @param  action   AuditAction
   */
  public ProgramOfferedRoleAudit(ProgramAction program, Role role, AuditAction action) {
    this.programActionId   = program.getId();
    this.programActionName = program.getName();
    this.roleId            = role.getId();
    this.roleName          = role.getName();
    this.action            = action;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
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

    ProgramOfferedRoleAudit that = (ProgramOfferedRoleAudit) o;

    if (action != that.action) {
      return false;
    }

    if ((programActionId != null) ? (!programActionId.equals(that.programActionId)) : (that.programActionId != null)) {
      return false;
    }

    if ((programActionName != null) ? (!programActionName.equals(that.programActionName))
                                    : (that.programActionName != null)) {
      return false;
    }

    if ((programOfferedRoleAuditId != null) ? (!programOfferedRoleAuditId.equals(that.programOfferedRoleAuditId))
                                            : (that.programOfferedRoleAuditId != null)) {
      return false;
    }

    if ((roleId != null) ? (!roleId.equals(that.roleId)) : (that.roleId != null)) {
      return false;
    }

    if ((roleName != null) ? (!roleName.equals(that.roleName)) : (that.roleName != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Use serialVersionUID for interoperability.
   *
   * @return  use serialVersionUID for interoperability.
   */
  public AuditAction getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program action id.
   *
   * @return  Long
   */
  public Long getProgramActionId() {
    return programActionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program action name.
   *
   * @return  String
   */
  public String getProgramActionName() {
    return programActionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program offered role audit id.
   *
   * @return  Long
   */
  public Long getProgramOfferedRoleAuditId() {
    return programOfferedRoleAuditId;
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
   * getter method for role name.
   *
   * @return  String
   */
  public String getRoleName() {
    return roleName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((action != null) ? action.hashCode() : 0);
    result = (31 * result) + ((programActionId != null) ? programActionId.hashCode() : 0);
    result = (31 * result) + ((programActionName != null) ? programActionName.hashCode() : 0);
    result = (31 * result) + ((programOfferedRoleAuditId != null) ? programOfferedRoleAuditId.hashCode() : 0);
    result = (31 * result) + ((roleId != null) ? roleId.hashCode() : 0);
    result = (31 * result) + ((roleName != null) ? roleName.hashCode() : 0);

    return result;
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
   * setter method for program action id.
   *
   * @param  programActionId  Long
   */
  public void setProgramActionId(Long programActionId) {
    this.programActionId = programActionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program action name.
   *
   * @param  programActionName  String
   */
  public void setProgramActionName(String programActionName) {
    this.programActionName = programActionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program offered role audit id.
   *
   * @param  programOfferedRoleAuditId  Long
   */
  public void setProgramOfferedRoleAuditId(Long programOfferedRoleAuditId) {
    this.programOfferedRoleAuditId = programOfferedRoleAuditId;
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
   * setter method for role name.
   *
   * @param  roleName  String
   */
  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }


} // end class ProgramOfferedRoleAudit
