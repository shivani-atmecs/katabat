package com.cmc.credagility.core.domain.sor;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;


/**
 * Created by coin on 4/7/16.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  04/07/2016 09:58
 */

@Entity
@Table(
  name              = "PortfolioVariableWidget",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "widgetName", "portfolioId" }) }
)
public class PortfolioVariableWidget extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 838552414796284495L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column protected Integer displayOrder;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "portfolioId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio = new Portfolio();

  /** TODO: DOCUMENT ME! */
  @Column protected String widgetButtonIcon;

  /** TODO: DOCUMENT ME! */
  @Column protected String widgetButtonToolTips;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "portfolioVariableWidget",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  protected Set<PortfolioVariableWidgetColumn> widgetColumns = new HashSet<PortfolioVariableWidgetColumn>();

  /** TODO: DOCUMENT ME! */
  @Column protected String widgetName;

  /** TODO: DOCUMENT ME! */
  @Column protected String widgetWindowTitle;

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

    PortfolioVariableWidget that = (PortfolioVariableWidget) o;

    if ((displayOrder != null) ? (!displayOrder.equals(that.displayOrder)) : (that.displayOrder != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((widgetButtonIcon != null) ? (!widgetButtonIcon.equals(that.widgetButtonIcon))
                                   : (that.widgetButtonIcon != null)) {
      return false;
    }

    if ((widgetButtonToolTips != null) ? (!widgetButtonToolTips.equals(that.widgetButtonToolTips))
                                       : (that.widgetButtonToolTips != null)) {
      return false;
    }

    if ((widgetName != null) ? (!widgetName.equals(that.widgetName)) : (that.widgetName != null)) {
      return false;
    }

    return !((widgetWindowTitle != null) ? (!widgetWindowTitle.equals(that.widgetWindowTitle))
                                         : (that.widgetWindowTitle != null));

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
   * getter method for widget button icon.
   *
   * @return  String
   */
  public String getWidgetButtonIcon() {
    return widgetButtonIcon;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for widget button tool tips.
   *
   * @return  String
   */
  public String getWidgetButtonToolTips() {
    return widgetButtonToolTips;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for widget columns.
   *
   * @return  Set
   */
  public Set<PortfolioVariableWidgetColumn> getWidgetColumns() {
    return widgetColumns;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for widget name.
   *
   * @return  String
   */
  public String getWidgetName() {
    return widgetName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for widget window title.
   *
   * @return  String
   */
  public String getWidgetWindowTitle() {
    return widgetWindowTitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((displayOrder != null) ? displayOrder.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((widgetButtonIcon != null) ? widgetButtonIcon.hashCode() : 0);
    result = (31 * result) + ((widgetButtonToolTips != null) ? widgetButtonToolTips.hashCode() : 0);
    result = (31 * result) + ((widgetName != null) ? widgetName.hashCode() : 0);
    result = (31 * result) + ((widgetWindowTitle != null) ? widgetWindowTitle.hashCode() : 0);

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
   * setter method for widget button icon.
   *
   * @param  widgetButtonIcon  String
   */
  public void setWidgetButtonIcon(String widgetButtonIcon) {
    this.widgetButtonIcon = widgetButtonIcon;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for widget button tool tips.
   *
   * @param  widgetButtonToolTips  String
   */
  public void setWidgetButtonToolTips(String widgetButtonToolTips) {
    this.widgetButtonToolTips = widgetButtonToolTips;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for widget columns.
   *
   * @param  widgetColumns  Set
   */
  public void setWidgetColumns(Set<PortfolioVariableWidgetColumn> widgetColumns) {
    this.widgetColumns = widgetColumns;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for widget name.
   *
   * @param  widgetName  String
   */
  public void setWidgetName(String widgetName) {
    this.widgetName = widgetName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for widget window title.
   *
   * @param  widgetWindowTitle  String
   */
  public void setWidgetWindowTitle(String widgetWindowTitle) {
    this.widgetWindowTitle = widgetWindowTitle;
  }
} // end class PortfolioVariableWidget
