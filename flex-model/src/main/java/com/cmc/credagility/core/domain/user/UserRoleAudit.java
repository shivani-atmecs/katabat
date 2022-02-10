package com.cmc.credagility.core.domain.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.AuditAction;


/**
 * This class is Role Function information.
 *
 * <p><a href="RoleFunction.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 17:05
 */
@Entity public class UserRoleAudit extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2533065309576251376L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  @Column(
    nullable = false,
    length   = 255
  )
  @Enumerated(value = EnumType.STRING)
  public AuditAction action;

  @Column(nullable = false)
  private Long roleId;

  @Column(
    nullable = false,
    length   = 255
  )
  private String roleName;

  @Column(nullable = false)
  private Long userId;

  @Column(
    nullable = false,
    length   = 255
  )
  private String userName;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long userRoleAuditId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new UserRoleAudit object.
   */
  public UserRoleAudit() { }

  /**
   * Creates a new UserRoleAudit object.
   *
   * @param  user    User
   * @param  role    Role
   * @param  action  AuditAction
   */
  public UserRoleAudit(User user, Role role, AuditAction action) {
    this.userId   = user.getId();
    this.userName = user.getUsername();

    this.roleId   = role.getId();
    this.roleName = role.getName();

    this.action = action;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    UserRoleAudit that = (UserRoleAudit) o;

    if (action != that.action) {
      return false;
    }

    if ((roleId != null) ? (!roleId.equals(that.roleId)) : (that.roleId != null)) {
      return false;
    }

    if ((roleName != null) ? (!roleName.equals(that.roleName)) : (that.roleName != null)) {
      return false;
    }

    if ((userId != null) ? (!userId.equals(that.userId)) : (that.userId != null)) {
      return false;
    }

    if ((userName != null) ? (!userName.equals(that.userName)) : (that.userName != null)) {
      return false;
    }

    return true;
  } // end method equals

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
   * getter method for user id.
   *
   * @return  Long
   */
  public Long getUserId() {
    return userId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user name.
   *
   * @return  String
   */
  public String getUserName() {
    return userName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user role audit id.
   *
   * @return  Long
   */
  public Long getUserRoleAuditId() {
    return userRoleAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((action != null) ? action.hashCode() : 0);
    result = (31 * result) + ((roleId != null) ? roleId.hashCode() : 0);
    result = (31 * result) + ((roleName != null) ? roleName.hashCode() : 0);
    result = (31 * result) + ((userId != null) ? userId.hashCode() : 0);
    result = (31 * result) + ((userName != null) ? userName.hashCode() : 0);

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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user id.
   *
   * @param  userId  Long
   */
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user name.
   *
   * @param  userName  String
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user role audit id.
   *
   * @param  userRoleAuditId  Long
   */
  public void setUserRoleAuditId(Long userRoleAuditId) {
    this.userRoleAuditId = userRoleAuditId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("UserRoleAudit");
    sb.append("{action=").append(action);
    sb.append(", roleId=").append(roleId);
    sb.append(", roleName='").append(roleName).append('\'');
    sb.append(", userId=").append(userId);
    sb.append(", userName='").append(userName).append('\'');
    sb.append(", userRoleAuditId=").append(userRoleAuditId);
    sb.append('}');

    return sb.toString();
  }
} // end class UserRoleAudit
