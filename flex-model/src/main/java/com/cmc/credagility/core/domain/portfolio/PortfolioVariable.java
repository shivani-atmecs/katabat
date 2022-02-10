package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.variable.AbstractBaseVariable;
import com.cmc.credagility.core.domain.variable.BaseVariable;


/**
 * DOCUMENT ME!
 *
 * @author   Rojer Luo Jun
 * @version  $Revision$, $Date$
 */
@DiscriminatorValue("Portfolio")
@Entity public class PortfolioVariable extends BaseVariable implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2461659013548901079L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Whether Variable is MAPPED/DERIVED. */
  @Column(nullable = true)
  protected String groupName;

  /** Portfolio which the variable belong to. */
  @JoinColumn(
    name       = "portfolioId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio = new Portfolio();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Copy Portfolio Variable.
   *
   * @param  o  varibale to copy
   */
  @Override public void copy(AbstractBaseVariable o) {
    super.copy(o);

    if (o instanceof PortfolioVariable) {
      this.groupName = ((PortfolioVariable) o).getGroupName();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    PortfolioVariable that = (PortfolioVariable) o;

    // if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
    // return false;
    // }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getGroupName() {
    return groupName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.variable.BaseVariable#getId()
   */
  @Override public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.variable.AbstractBaseVariable#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    // result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groupName  DOCUMENT ME!
   */
  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.variable.BaseVariable#setId(java.lang.Long)
   */
  @Override public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PortfolioVariable{");

    // sb.append("{portfolio=").append(portfolio);
    sb.append(super.toString());
    sb.append('}');

    return sb.toString();
  }
} // end class PortfolioVariable
