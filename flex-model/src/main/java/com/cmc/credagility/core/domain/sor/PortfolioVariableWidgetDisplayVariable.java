package com.cmc.credagility.core.domain.sor;


import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.variable.BaseVariable;


/**
 * Created by coin on 4/5/16.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  04/05/2016 14:50
 */
@Entity
@Table(name = "PortfolioVariableWidgetDisplayVariable")
public class PortfolioVariableWidgetDisplayVariable extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -9142811535595848377L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column protected Integer displayOrder;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "columnId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioVariableWidgetColumn portfolioVariableWidgetColumn;

  /** Variable this display represent to. */
  @JoinColumn(
    name                 = "variableName",
    nullable             = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BaseVariable variable = null;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for serial version UID.
   *
   * @return  long
   */
  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    PortfolioVariableWidgetDisplayVariable that = (PortfolioVariableWidgetDisplayVariable) o;

    if ((displayOrder != null) ? (!displayOrder.equals(that.displayOrder)) : (that.displayOrder != null)) {
      return false;
    }

    return !((id != null) ? (!id.equals(that.id)) : (that.id != null));

  }

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
   * getter method for portfolio variable widget column.
   *
   * @return  PortfolioVariableWidgetColumn
   */
  public PortfolioVariableWidgetColumn getPortfolioVariableWidgetColumn() {
    return portfolioVariableWidgetColumn;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((displayOrder != null) ? displayOrder.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);

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
   * setter method for portfolio variable widget column.
   *
   * @param  portfolioVariableWidgetColumn  PortfolioVariableWidgetColumn
   */
  public void setPortfolioVariableWidgetColumn(PortfolioVariableWidgetColumn portfolioVariableWidgetColumn) {
    this.portfolioVariableWidgetColumn = portfolioVariableWidgetColumn;
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
} // end class PortfolioVariableWidgetDisplayVariable
