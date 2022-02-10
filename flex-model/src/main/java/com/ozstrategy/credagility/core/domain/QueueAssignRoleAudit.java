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
 * @version  10/16/2014 14:28
 */
@Entity
@Table(name = "QueueAssignRoleAudit")
public class QueueAssignRoleAudit extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -1817099968164407732L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  @Enumerated(value = EnumType.STRING)
  public AuditAction action;

  @Column(nullable = false)
  private Long queueActionId;

  @Column(
    nullable = false,
    length   = 255
  )
  private String queueActionName;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long queueAssignRoleAuditId;

  @Column(nullable = false)
  private Long roleId;

  @Column(
    nullable = false,
    length   = 255
  )
  private String roleName;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new QueueAssignRoleAudit object.
   */
  public QueueAssignRoleAudit() { }


  /**
   * Creates a new QueueAssignRoleAudit object.
   *
   * @param  queueAction  QueueAction
   * @param  role         Role
   * @param  action       AuditAction
   */
  public QueueAssignRoleAudit(QueueAction queueAction, Role role, AuditAction action) {
    this.queueActionId   = queueAction.getId();
    this.queueActionName = queueAction.getName();
    this.roleId          = role.getId();
    this.roleName        = role.getName();
    this.action          = action;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    QueueAssignRoleAudit that = (QueueAssignRoleAudit) o;

    if (action != that.action) {
      return false;
    }

    if ((queueActionId != null) ? (!queueActionId.equals(that.queueActionId)) : (that.queueActionId != null)) {
      return false;
    }

    if ((queueActionName != null) ? (!queueActionName.equals(that.queueActionName)) : (that.queueActionName != null)) {
      return false;
    }

    if ((queueAssignRoleAuditId != null) ? (!queueAssignRoleAuditId.equals(that.queueAssignRoleAuditId))
                                         : (that.queueAssignRoleAuditId != null)) {
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
   * getter method for queue action id.
   *
   * @return  Long
   */
  public Long getQueueActionId() {
    return queueActionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue action name.
   *
   * @return  String
   */
  public String getQueueActionName() {
    return queueActionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue assign role audit id.
   *
   * @return  Long
   */
  public Long getQueueAssignRoleAuditId() {
    return queueAssignRoleAuditId;
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
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (action != null) ? action.hashCode() : 0;
    result = (31 * result) + ((queueActionId != null) ? queueActionId.hashCode() : 0);
    result = (31 * result) + ((queueActionName != null) ? queueActionName.hashCode() : 0);
    result = (31 * result) + ((queueAssignRoleAuditId != null) ? queueAssignRoleAuditId.hashCode() : 0);
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
   * setter method for queue action id.
   *
   * @param  queueActionId  Long
   */
  public void setQueueActionId(Long queueActionId) {
    this.queueActionId = queueActionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue action name.
   *
   * @param  queueActionName  String
   */
  public void setQueueActionName(String queueActionName) {
    this.queueActionName = queueActionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue assign role audit id.
   *
   * @param  queueAssignRoleAuditId  Long
   */
  public void setQueueAssignRoleAuditId(Long queueAssignRoleAuditId) {
    this.queueAssignRoleAuditId = queueAssignRoleAuditId;
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
} // end class QueueAssignRoleAudit
