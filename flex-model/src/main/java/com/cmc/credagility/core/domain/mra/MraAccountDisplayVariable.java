package com.cmc.credagility.core.domain.mra;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.variable.BaseVariable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 13:05
 */
@Entity public class MraAccountDisplayVariable extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Display order in AW. */
  @Column protected Integer displayOrder;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Portfolio which the variable belong to. */
  @JoinColumn(
    name       = "portfolioId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio = new Portfolio();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "roleId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Role role = null;

  /** Variable this display represent to. */
  @JoinColumn(
    name       = "variableId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BaseVariable variable = null;

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

    if (!(o instanceof MraAccountDisplayVariable)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    MraAccountDisplayVariable display1 = (MraAccountDisplayVariable) o;

// if ((displayOrder != null) ? (!displayOrder.equals(display1.displayOrder)) : (display1.displayOrder != null)) {
// return false;
// }

    if ((portfolio != null) ? (!portfolio.equals(display1.portfolio)) : (display1.portfolio != null)) {
      return false;
    }

    if ((variable != null) ? (!variable.equals(display1.variable)) : (display1.variable != null)) {
      return false;
    }

    if ((role != null) ? (!role.equals(display1.role)) : (display1.role != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for display order.
   *
   * @return  Integer
   */
  public Integer getDisplayOrder() {
    return displayOrder;
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
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
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
   * getter method for variable.
   *
   * @return  BaseVariable
   */
  public BaseVariable getVariable() {
    return variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
// result = (31 * result) + ((displayOrder != null) ? displayOrder.hashCode() : 0);
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);
    result = (31 * result) + ((variable != null) ? variable.hashCode() : 0);
    result = (31 * result) + ((role != null) ? role.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for display order.
   *
   * @param  displayOrder  Integer
   */
  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
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
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
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
   * setter method for variable.
   *
   * @param  variable  BaseVariable
   */
  public void setVariable(BaseVariable variable) {
    this.variable = variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PortfolioDisplayVariable");
    sb.append("{displayOrder=").append(displayOrder);
    sb.append(", id=").append(id);
    sb.append(", portfolio=").append(portfolio);
    sb.append(", variable=").append(variable);
    sb.append('}');

    return sb.toString();
  }
} // end class MraAccountDisplayVariable
