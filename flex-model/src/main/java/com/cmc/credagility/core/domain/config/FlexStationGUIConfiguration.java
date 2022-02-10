package com.cmc.credagility.core.domain.config;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.User;


/**
 * This class is used to store FlexStationGUIConfiguration information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 14:49
 */
@Entity
@Table(name = "FlexStationGUIConfiguration")
public class FlexStationGUIConfiguration extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  private static final long serialVersionUID = -1654055496869316586L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(name = "collapsable")
  private Boolean collapsable;

  @Column(name = "height")
  private Float height;

  @Column(
    name     = "guiId",
    nullable = false
  )
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  @Column(name = "lastUsedDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUsedDate;

  @Column(
    name   = "resolution",
    length = 50
  )
  private String resolution;

  @JoinColumn(
    name       = "userId",
    insertable = true,
    nullable   = false,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  @Column(
    name     = "widgetId",
    length   = 100,
    nullable = false
  )
  private String widgetId;

  @Column(name = "width")
  private Float width;

  @Column(name = "x")
  private int x;

  @Column(name = "y")
  private int y;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new FlexStationGUIConfiguration object.
   */
  public FlexStationGUIConfiguration() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for collapsable.
   *
   * @return  Boolean
   */
  public Boolean getCollapsable() {
    return collapsable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for height.
   *
   * @return  Float
   */
  public Float getHeight() {
    return height;
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
   * getter method for last used date.
   *
   * @return  Date
   */
  public Date getLastUsedDate() {
    return lastUsedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for resolution.
   *
   * @return  String
   */
  public String getResolution() {
    return resolution;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user.
   *
   * @return  User
   */
  public User getUser() {
    return user;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for widget id.
   *
   * @return  String
   */
  public String getWidgetId() {
    return widgetId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for width.
   *
   * @return  Float
   */
  public Float getWidth() {
    return width;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for x.
   *
   * @return  int
   */
  public int getX() {
    return x;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for y.
   *
   * @return  int
   */
  public int getY() {
    return y;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for collapsable.
   *
   * @param  collapsable  Boolean
   */
  public void setCollapsable(Boolean collapsable) {
    this.collapsable = collapsable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for height.
   *
   * @param  height  Float
   */
  public void setHeight(Float height) {
    this.height = height;
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
   * setter method for last used date.
   *
   * @param  lastUsedDate  Date
   */
  public void setLastUsedDate(Date lastUsedDate) {
    this.lastUsedDate = lastUsedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for resolution.
   *
   * @param  resolution  String
   */
  public void setResolution(String resolution) {
    this.resolution = resolution;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user.
   *
   * @param  user  User
   */
  public void setUser(User user) {
    this.user = user;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for widget id.
   *
   * @param  widgetId  String
   */
  public void setWidgetId(String widgetId) {
    this.widgetId = widgetId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for width.
   *
   * @param  width  Float
   */
  public void setWidth(Float width) {
    this.width = width;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for x.
   *
   * @param  x  int
   */
  public void setX(int x) {
    this.x = x;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for y.
   *
   * @param  y  int
   */
  public void setY(int y) {
    this.y = y;
  }
} // end class FlexStationGUIConfiguration
