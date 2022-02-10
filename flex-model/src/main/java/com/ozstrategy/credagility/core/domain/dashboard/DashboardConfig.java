package com.ozstrategy.credagility.core.domain.dashboard;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is storage for Dashboard config.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 17:40
 */
@Entity public class DashboardConfig extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3274652185257249722L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** cellHover Text. */
  @Column(length = 255)
  protected String cellHoverText;


  /** this config for which Dashboard. */
  @JoinColumn(
    name      = "dashboardId",
    updatable = false
  )
  @ManyToOne protected Dashboard dashboard;


  /** display Order. */
  @Column protected Integer displayOrder = 0;


  /** config Dashboard header. */
  @Column(length = 45)
  protected String header;


  /** config Dashboard header Hover's Text. */
  @Column(length = 255)
  protected String headerHoverText;


  /** PK. */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** value. */
  @Column(length = 255)
  protected String value;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new DashboardConfig object.
   */
  public DashboardConfig() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
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

    DashboardConfig that = (DashboardConfig) o;

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((header != null) ? (!header.equals(that.header)) : (that.header != null)) {
      return false;
    }

    if ((value != null) ? (!value.equals(that.value)) : (that.value != null)) {
      return false;
    }

    if ((displayOrder != null) ? (!displayOrder.equals(that.displayOrder)) : (that.displayOrder != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cell hover text.
   *
   * @return  String
   */
  public String getCellHoverText() {
    return cellHoverText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dashboard.
   *
   * @return  Dashboard
   */
  public Dashboard getDashboard() {
    return dashboard;
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
   * getter method for header.
   *
   * @return  String
   */
  public String getHeader() {
    return header;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for header hover text.
   *
   * @return  String
   */
  public String getHeaderHoverText() {
    return headerHoverText;
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
   * getter method for value.
   *
   * @return  String
   */
  public String getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((header != null) ? header.hashCode() : 0);
    result = (31 * result) + ((value != null) ? value.hashCode() : 0);
    result = (31 * result) + ((displayOrder != null) ? displayOrder.hashCode() : 0);
    result = (31 * result) + ((headerHoverText != null) ? headerHoverText.hashCode() : 0);
    result = (31 * result) + ((cellHoverText != null) ? cellHoverText.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cell hover text.
   *
   * @param  cellHoverText  String
   */
  public void setCellHoverText(String cellHoverText) {
    this.cellHoverText = cellHoverText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dashboard.
   *
   * @param  dashboard  Dashboard
   */
  public void setDashboard(Dashboard dashboard) {
    this.dashboard = dashboard;
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
   * setter method for header.
   *
   * @param  header  String
   */
  public void setHeader(String header) {
    this.header = header;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for header hover text.
   *
   * @param  headerHoverText  String
   */
  public void setHeaderHoverText(String headerHoverText) {
    this.headerHoverText = headerHoverText;
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
   * setter method for value.
   *
   * @param  value  String
   */
  public void setValue(String value) {
    this.value = value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("DashboardConfig{");
    sb.append("id=").append(id);
    sb.append(", header='").append(header).append('\'');
    sb.append(", value='").append(value).append('\'');
    sb.append(", displayOrder=").append(displayOrder);
    sb.append(", headerHoverText=").append(headerHoverText);
    sb.append('}');

    return sb.toString();
  }
} // end class DashboardConfig
