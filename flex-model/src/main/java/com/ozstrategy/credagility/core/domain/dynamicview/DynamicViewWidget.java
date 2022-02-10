package com.ozstrategy.credagility.core.domain.dynamicview;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/16/2014 15:14
 */
@Entity
@Table(name = "DynamicViewWidget")
public class DynamicViewWidget extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 31553810885281757L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected Integer colspan;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable         = false,
    columnDefinition = "int default 0"
  )
  protected Integer columnIndex = 0;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "componentId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DynamicComponent component;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    cascade  = CascadeType.ALL,
    mappedBy = "widget"
  )
  protected Set<DynamicViewWidgetConfigureData> dataConfigs = new LinkedHashSet<DynamicViewWidgetConfigureData>();

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 100
  )
  protected String headerCls;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected Integer height;

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean hideHeader = false;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected Integer priority;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    cascade  = CascadeType.ALL,
    mappedBy = "widget"
  )
  protected Set<DynamicViewWidgetConfigureRenderer> rendererConfigs =
    new LinkedHashSet<DynamicViewWidgetConfigureRenderer>();

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected Integer rowspan;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String title;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "viewId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DynamicView view;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * conventArgToConfig.
   *
   * @param   argument  DynamicComponentRenderArgument
   *
   * @return  DynamicViewWidgetConfigureRenderer
   */
  public DynamicViewWidgetConfigureRenderer conventArgToConfig(DynamicComponentRenderArgument argument) {
    DynamicViewWidgetConfigureRenderer renderConfig = new DynamicViewWidgetConfigureRenderer();
    renderConfig.setRenderArgument(argument);
    renderConfig.setWidget(this);
    renderConfig.setValue(argument.getDefaultValue());

    return renderConfig;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyRendererConfigs.
   *
   * @param  rendererArguments  Set
   */
  public void copyRendererConfigs(Set<DynamicComponentRenderArgument> rendererArguments) {
    rendererConfigs.clear();

    for (DynamicComponentRenderArgument argument : rendererArguments) {
      rendererConfigs.add(conventArgToConfig(argument));
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    DynamicViewWidget that = (DynamicViewWidget) o;

    if ((component != null) ? (!component.equals(that.component)) : (that.component != null)) {
      return false;
    }

    if ((priority != null) ? (!priority.equals(that.priority)) : (that.priority != null)) {
      return false;
    }

    if ((title != null) ? (!title.equals(that.title)) : (that.title != null)) {
      return false;
    }

    if ((view != null) ? (!view.equals(that.view)) : (that.view != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for colspan.
   *
   * @return  Integer
   */
  public Integer getColspan() {
    return colspan;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for column index.
   *
   * @return  Integer
   */
  public Integer getColumnIndex() {
    return columnIndex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for component.
   *
   * @return  DynamicComponent
   */
  public DynamicComponent getComponent() {
    return component;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data configs.
   *
   * @return  Set
   */
  public Set<DynamicViewWidgetConfigureData> getDataConfigs() {
    return dataConfigs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for header cls.
   *
   * @return  String
   */
  public String getHeaderCls() {
    return headerCls;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for height.
   *
   * @return  Integer
   */
  public Integer getHeight() {
    return height;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hide header.
   *
   * @return  Boolean
   */
  public Boolean getHideHeader() {
    if (hideHeader == null) {
      return Boolean.FALSE;
    }

    return hideHeader;
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
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for renderer configs.
   *
   * @return  Set
   */
  public Set<DynamicViewWidgetConfigureRenderer> getRendererConfigs() {
    return rendererConfigs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rowspan.
   *
   * @return  Integer
   */
  public Integer getRowspan() {
    return rowspan;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for title.
   *
   * @return  String
   */
  public String getTitle() {
    return title;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for view.
   *
   * @return  DynamicView
   */
  public DynamicView getView() {
    return view;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((component != null) ? component.hashCode() : 0);
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + ((title != null) ? title.hashCode() : 0);
    result = (31 * result) + ((view != null) ? view.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * paste.
   *
   * @param  newWidget  DynamicViewWidget
   */
  public void paste(DynamicViewWidget newWidget) {
    newWidget.setHeight(this.getHeight());
    newWidget.setTitle(this.getTitle());
    newWidget.setHeaderCls(this.getHeaderCls());
    newWidget.setColspan(this.getColspan());
    newWidget.setComponent(this.getComponent());
    newWidget.setPriority(this.getPriority());
    newWidget.setRowspan(this.getRowspan());
    newWidget.setColumnIndex(this.getColumnIndex());
    newWidget.setHideHeader(this.getHideHeader());

    for (DynamicViewWidgetConfigureData configureData : dataConfigs) {
      DynamicViewWidgetConfigureData newConfigureData = new DynamicViewWidgetConfigureData();
      configureData.paste(newConfigureData);
      newConfigureData.setWidget(newWidget);
      newWidget.getDataConfigs().add(newConfigureData);
    }

    for (DynamicViewWidgetConfigureRenderer configureRenderer : rendererConfigs) {
      DynamicViewWidgetConfigureRenderer newConfigureRenderer = new DynamicViewWidgetConfigureRenderer();
      configureRenderer.paste(newConfigureRenderer);
      newConfigureRenderer.setWidget(newWidget);
      newWidget.getRendererConfigs().add(newConfigureRenderer);
    }
  } // end method paste

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for colspan.
   *
   * @param  colspan  Integer
   */
  public void setColspan(Integer colspan) {
    this.colspan = colspan;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for column index.
   *
   * @param  columnIndex  Integer
   */
  public void setColumnIndex(Integer columnIndex) {
    this.columnIndex = columnIndex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for component.
   *
   * @param  component  DynamicComponent
   */
  public void setComponent(DynamicComponent component) {
    this.component = component;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data configs.
   *
   * @param  dataConfigs  Set
   */
  public void setDataConfigs(Set<DynamicViewWidgetConfigureData> dataConfigs) {
    this.dataConfigs = dataConfigs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for header cls.
   *
   * @param  headerCls  String
   */
  public void setHeaderCls(String headerCls) {
    this.headerCls = headerCls;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for height.
   *
   * @param  height  Integer
   */
  public void setHeight(Integer height) {
    this.height = height;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hide header.
   *
   * @param  hideHeader  Boolean
   */
  public void setHideHeader(Boolean hideHeader) {
    this.hideHeader = hideHeader;
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
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for renderer configs.
   *
   * @param  rendererConfigs  Set
   */
  public void setRendererConfigs(Set<DynamicViewWidgetConfigureRenderer> rendererConfigs) {
    this.rendererConfigs = rendererConfigs;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rowspan.
   *
   * @param  rowspan  Integer
   */
  public void setRowspan(Integer rowspan) {
    this.rowspan = rowspan;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for title.
   *
   * @param  title  String
   */
  public void setTitle(String title) {
    this.title = title;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for view.
   *
   * @param  view  DynamicView
   */
  public void setView(DynamicView view) {
    this.view = view;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#toString()
   */
  @Override public String toString() {
    return "DynamicViewWidget{"
      + "id=" + id
      + ", colSpan=" + colspan
      + ", component=" + component.getName()
      + ", columnIndex=" + columnIndex
      + ", rowSpan=" + rowspan
      + ", priority=" + priority
      + ", title='" + title + '\''
      + ", headerCls='" + headerCls + '\''
      + ", view=" + view.getName()
      + '}';
  }
} // end class DynamicViewWidget
