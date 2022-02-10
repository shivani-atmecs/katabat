package com.cmc.credagility.core.domain.user;

import java.io.Serializable;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is Role Function information.
 *
 * <p><a href="RoleFunction.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 16:44
 */
@Entity public class RoleFeature extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -5455001780847177170L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Lob protected String criteria;

  @JoinColumn(
    name       = "featureId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Feature feature;

  @JoinColumn(
    name       = "roleId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Role role;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long roleFeatureId;

  @OneToMany(
    cascade  = { CascadeType.ALL, CascadeType.REMOVE },
    fetch    = FetchType.LAZY,
    mappedBy = "roleFeature"
  )
  private Set<RoleFeaturePortfolio> roleFeaturePortfolios = new LinkedHashSet<RoleFeaturePortfolio>();

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

    RoleFeature that = (RoleFeature) o;

    if ((criteria != null) ? (!criteria.equals(that.criteria)) : (that.criteria != null)) {
      return false;
    }

    if ((feature != null) ? (!feature.equals(that.feature)) : (that.feature != null)) {
      return false;
    }

    if ((role != null) ? (!role.equals(that.role)) : (that.role != null)) {
      return false;
    }

    return true;
  } // end method equals

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
   * getter method for feature.
   *
   * @return  Feature
   */
  public Feature getFeature() {
    return feature;
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
   * getter method for role feature id.
   *
   * @return  Long
   */
  public Long getRoleFeatureId() {
    return roleFeatureId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role feature portfolios.
   *
   * @return  Set
   */
  public Set<RoleFeaturePortfolio> getRoleFeaturePortfolios() {
    return roleFeaturePortfolios;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((criteria != null) ? criteria.hashCode() : 0);
    result = (31 * result) + ((feature != null) ? feature.hashCode() : 0);
    result = (31 * result) + ((role != null) ? role.hashCode() : 0);

    return result;
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
   * setter method for feature.
   *
   * @param  feature  Feature
   */
  public void setFeature(Feature feature) {
    this.feature = feature;
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
   * setter method for role feature id.
   *
   * @param  roleFeatureId  Long
   */
  public void setRoleFeatureId(Long roleFeatureId) {
    this.roleFeatureId = roleFeatureId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role feature portfolios.
   *
   * @param  roleFeaturePortfolios  Set
   */
  public void setRoleFeaturePortfolios(Set<RoleFeaturePortfolio> roleFeaturePortfolios) {
    this.roleFeaturePortfolios = roleFeaturePortfolios;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("RoleFeature");
    sb.append("{criteria='").append(criteria).append('\'');
    sb.append(", feature=").append(feature);
    sb.append(", role=").append(role);
    sb.append(", roleFeatureId=").append(roleFeatureId);
    sb.append(", roleFeaturePortfolios=").append(roleFeaturePortfolios);
    sb.append('}');

    return sb.toString();
  }
} // end class RoleFeature
