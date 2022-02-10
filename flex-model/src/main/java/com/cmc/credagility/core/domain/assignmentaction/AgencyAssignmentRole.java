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

import com.ozstrategy.credagility.core.domain.AgencyAssignmentAction;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/14/2014 17:24
 */
@Entity public class AgencyAssignmentRole extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5455001780847177170L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name       = "AgencyAssignmentId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private AgencyAssignmentAction agencyAssignmentAction;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long agencyAssignmentRoleId;

  @Column private Integer priority;

  @JoinColumn(
    name       = "roleId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Role role;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AgencyAssignmentRole object.
   */
  public AgencyAssignmentRole() { }

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

    AgencyAssignmentRole that = (AgencyAssignmentRole) o;

    if ((agencyAssignmentRoleId != null) ? (!agencyAssignmentRoleId.equals(that.agencyAssignmentRoleId))
                                         : (that.agencyAssignmentRoleId != null)) {
      return false;
    }

    if ((role != null) ? (!role.equals(that.role)) : (that.role != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency assignment action.
   *
   * @return  AgencyAssignmentAction
   */
  public AgencyAssignmentAction getAgencyAssignmentAction() {
    return agencyAssignmentAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency assignment role id.
   *
   * @return  Long
   */
  public Long getAgencyAssignmentRoleId() {
    return agencyAssignmentRoleId;
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
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((agencyAssignmentRoleId != null) ? agencyAssignmentRoleId.hashCode() : 0);
    result = (31 * result) + ((role != null) ? role.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency assignment action.
   *
   * @param  agencyAssignmentAction  AgencyAssignmentAction
   */
  public void setAgencyAssignmentAction(AgencyAssignmentAction agencyAssignmentAction) {
    this.agencyAssignmentAction = agencyAssignmentAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency assignment role id.
   *
   * @param  agencyAssignmentRoleId  Long
   */
  public void setAgencyAssignmentRoleId(Long agencyAssignmentRoleId) {
    this.agencyAssignmentRoleId = agencyAssignmentRoleId;
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
} // end class AgencyAssignmentRole
