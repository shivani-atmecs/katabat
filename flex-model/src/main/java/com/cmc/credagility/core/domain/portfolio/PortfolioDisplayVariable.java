package com.cmc.credagility.core.domain.portfolio;

import com.cmc.credagility.core.domain.base.BaseEntity;
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
 * This class is used to store the display order of variables for each portfolio.
 *
 * <p><a href="PortfolioDisplayVariable.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/16/2014 10:07
 */
@Entity public class PortfolioDisplayVariable extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Display order in AW. */
  @Column protected Integer displayOrder;

  /** Primary key. */
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

    if (!(o instanceof PortfolioDisplayVariable)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioDisplayVariable display1 = (PortfolioDisplayVariable) o;

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
   * Get Variable display order.
   *
   * @return  display order
   */
  public Integer getDisplayOrder() {
    return displayOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the id.
   *
   * @return  the id
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get Portfolio.
   *
   * @return  the portfolio
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
   * Get Variable.
   *
   * @return  the variable
   */
  public BaseVariable getVariable() {
    return variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
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
   * Set Display order.
   *
   * @param  displayOrder  to set
   */
  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set id.
   *
   * @param  id  to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set portfolio.
   *
   * @param  portfolio  to set
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
   * Set Varibale.
   *
   * @param  variable  to set
   */
  public void setVariable(BaseVariable variable) {
    this.variable = variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
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
} // end class PortfolioDisplayVariable
