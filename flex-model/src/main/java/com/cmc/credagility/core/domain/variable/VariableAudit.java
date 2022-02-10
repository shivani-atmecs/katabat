package com.cmc.credagility.core.domain.variable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.businesscontext.BCVariable;
import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.portfolio.PortfolioVariable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 17:35
 */
@Entity
@Table(name = "VariableAudit")
public class VariableAudit extends AbstractBaseVariable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name     = "businessContextId",
    nullable = true
  )
  @ManyToOne protected BusinessContext businessContext;

  /** Whether Variable is MAPPED/DERIVED. */
  @Column(nullable = true)
  protected String groupName;

  /** PK , id. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Portfolio which the variable belong to. */
  @JoinColumn(
    name       = "portfolioId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio = null;

  /** DOCUMENT ME! */
  @Column(nullable = false)
  protected Long variableId;

  /** Variable Type, System/Portfolio. */
  @Column(
    nullable = false,
    length   = 20
  )
  protected String variableType;

  /** Possible values are. */
  @Column(
    nullable = false,
    length   = 32
  )
  private String action;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new VariableAudit object.
   */
  public VariableAudit() { }

  /**
   * Creates a new VariableAudit object.
   *
   * @param  v  AbstractBaseVariable
   */
  public VariableAudit(AbstractBaseVariable v) {
    this.copy(v);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Copy Portfolio Variable.
   *
   * @param  o  varibale to copy
   */
  @Override public void copy(AbstractBaseVariable o) {
    super.copy(o);

    if (o instanceof PortfolioVariable) {
      this.groupName    = ((PortfolioVariable) o).getGroupName();
      this.portfolio    = ((PortfolioVariable) o).getPortfolio();
      this.variableType = "Portfolio";
    } else if (o instanceof BCVariable) {
      BCVariable v = (BCVariable) o;
      this.businessContext = v.getBusinessContext();
      this.variableType    = "BusinessContext";
    } else {
      this.variableType = "System";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.variable.AbstractBaseVariable#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof VariableAudit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    VariableAudit that = (VariableAudit) o;

    if ((action != null) ? (!action.equals(that.action)) : (that.action != null)) {
      return false;
    }

    if ((groupName != null) ? (!groupName.equals(that.groupName)) : (that.groupName != null)) {
      return false;
    }

    if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action.
   *
   * @return  String
   */
  public String getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context.
   *
   * @return  BusinessContext
   */
  public BusinessContext getBusinessContext() {
    return businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for group name.
   *
   * @return  String
   */
  public String getGroupName() {
    return groupName;
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
   * getter method for variable id.
   *
   * @return  Long
   */
  public Long getVariableId() {
    return variableId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.variable.AbstractBaseVariable#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((groupName != null) ? groupName.hashCode() : 0);
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);
    result = (31 * result) + ((action != null) ? action.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action.
   *
   * @param  action  String
   */
  public void setAction(String action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business context.
   *
   * @param  businessContext  BusinessContext
   */
  public void setBusinessContext(BusinessContext businessContext) {
    this.businessContext = businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for group name.
   *
   * @param  groupName  String
   */
  public void setGroupName(String groupName) {
    this.groupName = groupName;
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
   * setter method for variable id.
   *
   * @param  variableId  Long
   */
  public void setVariableId(Long variableId) {
    this.variableId = variableId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.variable.AbstractBaseVariable#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Variable audit:");
    sb.append("{portfolio=").append(portfolio);
    sb.append(super.toString());
    sb.append('}');

    return sb.toString();
  }


} // end class VariableAudit
