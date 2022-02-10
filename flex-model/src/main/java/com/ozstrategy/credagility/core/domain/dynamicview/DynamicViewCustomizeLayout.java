package com.ozstrategy.credagility.core.domain.dynamicview;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  07/17/2015 17:29
 */
@Entity
@Table(name = "DynamicViewCustomizeLayout")
public class DynamicViewCustomizeLayout extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -757092659403406763L;

  //~ Instance fields --------------------------------------------------------------------------------------------------


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agentId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean collapsible;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable         = false,
    columnDefinition = "int default 0"
  )
  protected Integer columnIndex = 0;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected Integer height;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected Integer priority;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "viewId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DynamicView view;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected Long widgetId;

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

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    DynamicViewCustomizeLayout that = (DynamicViewCustomizeLayout) o;

    if ((agent != null) ? (!agent.equals(that.agent)) : (that.agent != null)) {
      return false;
    }

    return !((widgetId != null) ? (!widgetId.equals(that.widgetId)) : (that.widgetId != null));

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * User.
   *
   * @return  User.
   */
  public User getAgent() {
    return agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Boolean.
   *
   * @return  Boolean.
   */
  public Boolean getCollapsible() {
    if (collapsible == null) {
      return Boolean.FALSE;
    }

    return collapsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getColumnIndex() {
    return columnIndex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getHeight() {
    return height;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DynamicView.
   *
   * @return  DynamicView.
   */
  public DynamicView getView() {
    return view;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getWidgetId() {
    return widgetId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.model.BaseObject#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((agent != null) ? agent.hashCode() : 0);
    result = (31 * result) + ((widgetId != null) ? widgetId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAgent.
   *
   * @param  agent  $param.type$
   */
  public void setAgent(User agent) {
    this.agent = agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setCollapsible.
   *
   * @param  collapsible  $param.type$
   */
  public void setCollapsible(Boolean collapsible) {
    this.collapsible = collapsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setColumnIndex.
   *
   * @param  columnIndex  $param.type$
   */
  public void setColumnIndex(Integer columnIndex) {
    this.columnIndex = columnIndex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setHeight.
   *
   * @param  height  $param.type$
   */
  public void setHeight(Integer height) {
    this.height = height;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setId.
   *
   * @param  id  $param.type$
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPriority.
   *
   * @param  priority  $param.type$
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setView.
   *
   * @param  view  $param.type$
   */
  public void setView(DynamicView view) {
    this.view = view;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setWidgetId.
   *
   * @param  widgetId  $param.type$
   */
  public void setWidgetId(Long widgetId) {
    this.widgetId = widgetId;
  }
} // end class DynamicViewCustomizeLayout
