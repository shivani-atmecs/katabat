package com.cmc.credagility.core.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;


/**
 * This class is used to store Portfolio Channel Type information.
 *
 * <p><a href="PortfolioChannelType.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 16:48
 */
@Entity public class RoleFeaturePortfolio extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3655766185323016392L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "portfolioId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "roleFeatureId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected RoleFeature roleFeature;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long roleFeaturePortfolioId;

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

    RoleFeaturePortfolio that = (RoleFeaturePortfolio) o;

    if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
      return false;
    }

    if ((roleFeature != null) ? (!roleFeature.equals(that.roleFeature)) : (that.roleFeature != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role feature.
   *
   * @return  RoleFeature
   */
  public RoleFeature getRoleFeature() {
    return roleFeature;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role feature portfolio id.
   *
   * @return  Long
   */
  public Long getRoleFeaturePortfolioId() {
    return roleFeaturePortfolioId;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);
    result = (31 * result) + ((roleFeature != null) ? roleFeature.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role feature.
   *
   * @param  roleFeature  RoleFeature
   */
  public void setRoleFeature(RoleFeature roleFeature) {
    this.roleFeature = roleFeature;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role feature portfolio id.
   *
   * @param  roleFeaturePortfolioId  Long
   */
  public void setRoleFeaturePortfolioId(Long roleFeaturePortfolioId) {
    this.roleFeaturePortfolioId = roleFeaturePortfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("RoleFeaturePortfolio");
    sb.append("{portfolioRoleFeatureId=").append(roleFeaturePortfolioId);
    sb.append(", portfolio=").append(portfolio);
    sb.append(", roleFeature=").append(roleFeature);
    sb.append('}');

    return sb.toString();
  }
} // end class RoleFeaturePortfolio
