package com.cmc.credagility.core.domain.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.AuditAction;


/**
 * This class is Role Function information.
 *
 * <p><a href="RoleFunction.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 16:47
 */
@Entity public class RoleFeatureAudit extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2533065309576251376L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  @Enumerated(value = EnumType.STRING)
  public AuditAction action;

  /** TODO: DOCUMENT ME! */
  @Lob protected String criteria;

  @Column(nullable = false)
  private Long featureId;

  @Column(
    nullable = false,
    length   = 255
  )
  private String featureName;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long roleFeatureAuditId;

  @Column(nullable = false)
  private Long roleId;

  @Column(
    nullable = false,
    length   = 255
  )
  private String roleName;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new RoleFeatureAudit object.
   */
  public RoleFeatureAudit() { }


  /**
   * Creates a new RoleFeatureAudit object.
   *
   * @param  roleFeature  RoleFeature
   * @param  action       AuditAction
   */
  public RoleFeatureAudit(RoleFeature roleFeature, AuditAction action) {
    this.criteria = roleFeature.getCriteria();

    Feature feature = roleFeature.getFeature();
    this.featureId   = feature.getFeatureId();
    this.featureName = feature.getFeatureName();

    Role role = roleFeature.getRole();
    this.roleId   = role.getId();
    this.roleName = role.getName();

    this.action = action;
  }

  /**
   * Creates a new RoleFeatureAudit object.
   *
   * @param  role      Role
   * @param  feature   Feature
   * @param  criteria  String
   * @param  action    AuditAction
   */
  public RoleFeatureAudit(Role role, Feature feature, String criteria, AuditAction action) {
    this.criteria = criteria;

    this.featureId   = feature.getFeatureId();
    this.featureName = feature.getFeatureName();

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

    RoleFeatureAudit that = (RoleFeatureAudit) o;

    if ((criteria != null) ? (!criteria.equals(that.criteria)) : (that.criteria != null)) {
      return false;
    }

    if ((featureId != null) ? (!featureId.equals(that.featureId)) : (that.featureId != null)) {
      return false;
    }

    if ((featureName != null) ? (!featureName.equals(that.featureName)) : (that.featureName != null)) {
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
   * getter method for action.
   *
   * @return  AuditAction
   */
  public AuditAction getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria.
   *
   * @return  String
   */
  public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for feature id.
   *
   * @return  Long
   */
  public Long getFeatureId() {
    return featureId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for feature name.
   *
   * @return  String
   */
  public String getFeatureName() {
    return featureName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role feature audit id.
   *
   * @return  Long
   */
  public Long getRoleFeatureAuditId() {
    return roleFeatureAuditId;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((criteria != null) ? criteria.hashCode() : 0);
    result = (31 * result) + ((featureId != null) ? featureId.hashCode() : 0);
    result = (31 * result) + ((featureName != null) ? featureName.hashCode() : 0);
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
   * setter method for criteria.
   *
   * @param  criteria  String
   */
  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for feature id.
   *
   * @param  featureId  Long
   */
  public void setFeatureId(Long featureId) {
    this.featureId = featureId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for feature name.
   *
   * @param  featureName  String
   */
  public void setFeatureName(String featureName) {
    this.featureName = featureName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role feature audit id.
   *
   * @param  roleFeatureAuditId  Long
   */
  public void setRoleFeatureAuditId(Long roleFeatureAuditId) {
    this.roleFeatureAuditId = roleFeatureAuditId;
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
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("RoleFeatureAudit");
    sb.append("{criteria='").append(criteria).append('\'');
    sb.append(", featureId=").append(featureId);
    sb.append(", featureName='").append(featureName).append('\'');
    sb.append(", roleFeatureAuditId=").append(roleFeatureAuditId);
    sb.append(", roleId=").append(roleId);
    sb.append(", roleName=").append(roleName);
    sb.append('}');

    return sb.toString();
  }
} // end class RoleFeatureAudit
