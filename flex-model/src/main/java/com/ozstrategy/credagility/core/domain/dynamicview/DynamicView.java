package com.ozstrategy.credagility.core.domain.dynamicview;

import com.cmc.credagility.core.domain.user.Role;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.type.DynamicViewLayout;
import com.ozstrategy.credagility.core.domain.type.DynamicViewStatus;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/16/2014 15:08
 */
@Entity
@Table(name = "DynamicView")
public class DynamicView extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3442520834104136511L;

  /** TODO: DOCUMENT ME! */
  public static final int DEFAULT_ROW_NUMBER = 1;

  /** TODO: DOCUMENT ME! */
  public static final int DEFAULT_COLUMN_NUMBER = 1;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "view",
    cascade  = CascadeType.ALL
  )
  protected Set<DynamicViewAssignedRole> assignedRoles = new LinkedHashSet<DynamicViewAssignedRole>();

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected Integer colNum;

  /** TODO: DOCUMENT ME! */
  @Embedded protected ContextObject contextObject = new ContextObject();

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String description;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(length = 16)
  @Enumerated(value = EnumType.STRING)
  protected DynamicViewLayout layout;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 64
  )
  protected String name;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "rendererId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DynamicViewRenderer renderer;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected Integer rowHeight = 200;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  protected Integer rowNum;

  /** TODO: DOCUMENT ME! */
  @Column(length = 16)
  @Enumerated(value = EnumType.STRING)
  protected DynamicViewStatus status = DynamicViewStatus.DRAFT;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    cascade       = CascadeType.ALL,
    orphanRemoval = true,
    mappedBy      = "view"
  )
  protected Set<DynamicViewToolbar> toolbars = new LinkedHashSet<DynamicViewToolbar>();

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String url;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    cascade       = CascadeType.ALL,
    orphanRemoval = true,
    mappedBy      = "view"
  )
  @OrderBy("priority asc")
  protected Set<DynamicViewWidget> widgets = new LinkedHashSet<DynamicViewWidget>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addRole.
   *
   * @param  role  DynamicViewAssignedRole
   */
  public void addRole(DynamicViewAssignedRole role) {
    role.setView(this);
    getAssignedRoles().add(role);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  roleId  DOCUMENT ME!
   */
  public void addRole(Long roleId) {
    DynamicViewAssignedRole assignedRole = getAssignedRole(roleId);

    if (assignedRole == null) {
      assignedRole = new DynamicViewAssignedRole();

      Role role = new Role();
      role.setId(roleId);
      assignedRole.setRole(role);
      addRole(assignedRole);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  role  DOCUMENT ME!
   */
  public void addRole(Role role) {
    DynamicViewAssignedRole assignedRole = getAssignedRole(role.getId());

    if (assignedRole == null) {
      assignedRole = new DynamicViewAssignedRole();
      assignedRole.setRole(role);
      addRole(assignedRole);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addToolbar.
   *
   * @param  tbar  DynamicViewToolbar
   */
  public void addToolbar(DynamicViewToolbar tbar) {
    tbar.setView(this);
    getToolbars().add(tbar);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addWidget.
   *
   * @param  widget  DynamicViewWidget
   */
  public void addWidget(DynamicViewWidget widget) {
    widget.setView(this);
    getWidgets().add(widget);
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

    DynamicView that = (DynamicView) o;

    if ((contextObject != null) ? (!contextObject.equals(that.contextObject)) : (that.contextObject != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((layout != null) ? (!layout.equals(that.layout)) : (that.layout != null)) {
      return false;
    }

    if ((renderer != null) ? (!renderer.equals(that.renderer)) : (that.renderer != null)) {
      return false;
    }

    if ((status != null) ? (!status.equals(that.status)) : (that.status != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for assigned roles.
   *
   * @return  Set
   */
  public Set<DynamicViewAssignedRole> getAssignedRoles() {
    return assignedRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for col num.
   *
   * @return  Integer
   */
  public Integer getColNum() {
    return colNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for context object.
   *
   * @return  ContextObject
   */
  public ContextObject getContextObject() {
    return contextObject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
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
   * getter method for layout.
   *
   * @return  DynamicViewLayout
   */
  public DynamicViewLayout getLayout() {
    if (layout == null) {
      return DynamicViewLayout.TABLE;
    }

    return layout;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for renderer.
   *
   * @return  DynamicViewRenderer
   */
  public DynamicViewRenderer getRenderer() {
    return renderer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for row height.
   *
   * @return  Integer
   */
  public Integer getRowHeight() {
    return rowHeight;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for row num.
   *
   * @return  Integer
   */
  public Integer getRowNum() {
    return rowNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  DynamicViewStatus
   */
  public DynamicViewStatus getStatus() {
    if (status == null) {
      return DynamicViewStatus.DRAFT;
    }

    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for toolbars.
   *
   * @return  Set
   */
  public Set<DynamicViewToolbar> getToolbars() {
    return toolbars;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for url.
   *
   * @return  String
   */
  public String getUrl() {
    return url;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for widgets.
   *
   * @return  Set
   */
  public Set<DynamicViewWidget> getWidgets() {
    return widgets;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((contextObject != null) ? contextObject.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((layout != null) ? layout.hashCode() : 0);
    result = (31 * result) + ((renderer != null) ? renderer.hashCode() : 0);
    result = (31 * result) + ((status != null) ? status.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for assigned roles.
   *
   * @param  assignedRoles  Set
   */
  public void setAssignedRoles(Set<DynamicViewAssignedRole> assignedRoles) {
    this.assignedRoles = assignedRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for col num.
   *
   * @param  colNum  Integer
   */
  public void setColNum(Integer colNum) {
    this.colNum = colNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for context object.
   *
   * @param  contextObject  ContextObject
   */
  public void setContextObject(ContextObject contextObject) {
    this.contextObject = contextObject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
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
   * setter method for layout.
   *
   * @param  layout  DynamicViewLayout
   */
  public void setLayout(DynamicViewLayout layout) {
    this.layout = layout;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for renderer.
   *
   * @param  renderer  DynamicViewRenderer
   */
  public void setRenderer(DynamicViewRenderer renderer) {
    this.renderer = renderer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for row height.
   *
   * @param  rowHeight  Integer
   */
  public void setRowHeight(Integer rowHeight) {
    this.rowHeight = rowHeight;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for row num.
   *
   * @param  rowNum  Integer
   */
  public void setRowNum(Integer rowNum) {
    this.rowNum = rowNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  DynamicViewStatus
   */
  public void setStatus(DynamicViewStatus status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for toolbars.
   *
   * @param  toolbars  Set
   */
  public void setToolbars(Set<DynamicViewToolbar> toolbars) {
    this.toolbars = toolbars;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for url.
   *
   * @param  url  String
   */
  public void setUrl(String url) {
    this.url = url;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for widgets.
   *
   * @param  widgets  Set
   */
  public void setWidgets(Set<DynamicViewWidget> widgets) {
    this.widgets = widgets;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private DynamicViewAssignedRole getAssignedRole(Long roleId) {
    for (DynamicViewAssignedRole assignedRole : assignedRoles) {
      if (assignedRole.getRole().getId().equals(roleId)) {
        return assignedRole;
      }
    }

    return null;
  }
} // end class DynamicView
