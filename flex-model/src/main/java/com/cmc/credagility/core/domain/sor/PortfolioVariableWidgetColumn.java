package com.cmc.credagility.core.domain.sor;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * Created by coin on 4/7/16.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  04/07/2016 09:56
 */
@Entity
@Table(name = "PortfolioVariableWidgetColumn")
public class PortfolioVariableWidgetColumn extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -9009394497535744290L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column protected String columnTitle;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer displayOrder;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "widgetId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioVariableWidget portfolioVariableWidget;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "portfolioVariableWidgetColumn",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected Set<PortfolioVariableWidgetDisplayVariable> portfolioVariableWidgetDisplayVariables =
    new HashSet<PortfolioVariableWidgetDisplayVariable>();

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

    PortfolioVariableWidgetColumn that = (PortfolioVariableWidgetColumn) o;

    if ((columnTitle != null) ? (!columnTitle.equals(that.columnTitle)) : (that.columnTitle != null)) {
      return false;
    }

    if ((displayOrder != null) ? (!displayOrder.equals(that.displayOrder)) : (that.displayOrder != null)) {
      return false;
    }

    return !((id != null) ? (!id.equals(that.id)) : (that.id != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for column title.
   *
   * @return  String
   */
  public String getColumnTitle() {
    return columnTitle;
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
   * getter method for portfolio variable widget.
   *
   * @return  PortfolioVariableWidget
   */
  public PortfolioVariableWidget getPortfolioVariableWidget() {
    return portfolioVariableWidget;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio variable widget display variables.
   *
   * @return  Set
   */
  public Set<PortfolioVariableWidgetDisplayVariable> getPortfolioVariableWidgetDisplayVariables() {
    return portfolioVariableWidgetDisplayVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((columnTitle != null) ? columnTitle.hashCode() : 0);
    result = (31 * result) + ((displayOrder != null) ? displayOrder.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for column title.
   *
   * @param  columnTitle  String
   */
  public void setColumnTitle(String columnTitle) {
    this.columnTitle = columnTitle;
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
   * setter method for portfolio variable widget.
   *
   * @param  portfolioVariableWidget  PortfolioVariableWidget
   */
  public void setPortfolioVariableWidget(PortfolioVariableWidget portfolioVariableWidget) {
    this.portfolioVariableWidget = portfolioVariableWidget;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio variable widget display variables.
   *
   * @param  portfolioVariableWidgetDisplayVariables  Set
   */
  public void setPortfolioVariableWidgetDisplayVariables(
    Set<PortfolioVariableWidgetDisplayVariable> portfolioVariableWidgetDisplayVariables) {
    this.portfolioVariableWidgetDisplayVariables = portfolioVariableWidgetDisplayVariables;
  }
} // end class PortfolioVariableWidgetColumn
