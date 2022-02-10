package com.cmc.credagility.core.domain.user;

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


/**
 * This class is Role Function information.
 *
 * <p><a href="RoleFunction.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 16:49
 */
@Entity public class RoleFunction extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8986960860922597008L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    nullable = false,
    length   = 64
  )
  private String accessLevel;

  @Column(
    nullable = false,
    length   = 16
  )
  private String application;

  @Column(
    nullable = false,
    length   = 256
  )
  private String functionName;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  @JoinColumn(
    name       = "roleId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Role role;

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

    RoleFunction that = (RoleFunction) o;

    if ((application != null) ? (!application.equals(that.application)) : (that.application != null)) {
      return false;
    }

    if ((functionName != null) ? (!functionName.equals(that.functionName)) : (that.functionName != null)) {
      return false;
    }

    if ((role != null) ? (!role.equals(that.role)) : (that.role != null)) {
      return false;
    }

    if ((accessLevel != null) ? (!accessLevel.equals(that.accessLevel)) : (that.accessLevel != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for access level.
   *
   * @return  String
   */
  public String getAccessLevel() {
    return accessLevel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for application.
   *
   * @return  String
   */
  public String getApplication() {
    return application;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for function name.
   *
   * @return  String
   */
  public String getFunctionName() {
    return functionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((role != null) ? role.hashCode() : 0);
    result = (31 * result) + ((application != null) ? application.hashCode() : 0);
    result = (31 * result) + ((functionName != null) ? functionName.hashCode() : 0);
    result = (31 * result) + ((accessLevel != null) ? accessLevel.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for access level.
   *
   * @param  accessLevel  String
   */
  public void setAccessLevel(String accessLevel) {
    this.accessLevel = accessLevel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for application.
   *
   * @param  application  String
   */
  public void setApplication(String application) {
    this.application = application;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for function name.
   *
   * @param  functionName  String
   */
  public void setFunctionName(String functionName) {
    this.functionName = functionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
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
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("RoleFunction");
    sb.append("{id=").append(id);
    sb.append(", role=").append(role);
    sb.append(", application='").append(application).append('\'');
    sb.append(", functionName='").append(functionName).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class RoleFunction
