package com.cmc.credagility.core.domain.assignmentaction;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.user.User;

import com.ozstrategy.credagility.core.domain.AgentAssignmentAction;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/14/2014 17:31
 */
@Entity public class AgentAssignmentUserRole extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5455001780847177170L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long agencyAssignmentUserRoleId;

  @JoinColumn(
    name       = "AgentAssignmentId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private AgentAssignmentAction agentAssignmentAction;

  @Column private Integer priority;

  @JoinColumn(
    name       = "roleId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Role role;

  @JoinColumn(
    name       = "userId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AgentAssignmentUserRole object.
   */
  public AgentAssignmentUserRole() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
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

    AgentAssignmentUserRole that = (AgentAssignmentUserRole) o;

    if ((agencyAssignmentUserRoleId != null) ? (!agencyAssignmentUserRoleId.equals(that.agencyAssignmentUserRoleId))
                                             : (that.agencyAssignmentUserRoleId != null)) {
      return false;
    }

    if ((role != null) ? (!role.equals(that.role)) : (that.role != null)) {
      return false;
    }

    if ((user != null) ? (!user.equals(that.user)) : (that.user != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency assignment user role id.
   *
   * @return  Long
   */
  public Long getAgencyAssignmentUserRoleId() {
    return agencyAssignmentUserRoleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent assignment action.
   *
   * @return  AgentAssignmentAction
   */
  public AgentAssignmentAction getAgentAssignmentAction() {
    return agentAssignmentAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role.
   *
   * @return  Role
   */
  public Role getRole() {
    return role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user.
   *
   * @return  User
   */
  public User getUser() {
    return user;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((agencyAssignmentUserRoleId != null) ? agencyAssignmentUserRoleId.hashCode() : 0);
    result = (31 * result) + ((role != null) ? role.hashCode() : 0);
    result = (31 * result) + ((user != null) ? user.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency assignment user role id.
   *
   * @param  agencyAssignmentUserRoleId  Long
   */
  public void setAgencyAssignmentUserRoleId(Long agencyAssignmentUserRoleId) {
    this.agencyAssignmentUserRoleId = agencyAssignmentUserRoleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent assignment action.
   *
   * @param  agentAssignmentAction  AgentAssignmentAction
   */
  public void setAgentAssignmentAction(AgentAssignmentAction agentAssignmentAction) {
    this.agentAssignmentAction = agentAssignmentAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role.
   *
   * @param  role  Role
   */
  public void setRole(Role role) {
    this.role = role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user.
   *
   * @param  user  User
   */
  public void setUser(User user) {
    this.user = user;
  }
} // end class AgentAssignmentUserRole
