package com.ozstrategy.credagility.core.domain.dynamicview;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/16/2014 15:10
 */
@Entity
@Table(name = "DynamicViewToolbar")
public class DynamicViewToolbar extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5204694959769361641L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    cascade  = CascadeType.ALL,
    mappedBy = "viewToolbar"
  )
  protected Set<DynamicViewToolbarConfigureRenderer> configRenders =
    new LinkedHashSet<DynamicViewToolbarConfigureRenderer>();

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String position;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "toolbar",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DynamicToolbar toolbar;

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
   * @param   argument  DynamicToolbarRendererArgument
   *
   * @return  DynamicViewToolbarConfigureRenderer
   */
  public DynamicViewToolbarConfigureRenderer conventArgToConfig(DynamicToolbarRendererArgument argument) {
    DynamicViewToolbarConfigureRenderer renderConfig = new DynamicViewToolbarConfigureRenderer();
    renderConfig.setRenderArgument(argument);
    renderConfig.setViewToolbar(this);
    renderConfig.setValue(argument.getDefaultValue());

    return renderConfig;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyRendererConfigs.
   *
   * @param  rendererArguments  Set
   */
  public void copyRendererConfigs(Set<DynamicToolbarRendererArgument> rendererArguments) {
    configRenders.clear();

    for (DynamicToolbarRendererArgument argument : rendererArguments) {
      configRenders.add(conventArgToConfig(argument));
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

    DynamicViewToolbar that = (DynamicViewToolbar) o;

    if ((position != null) ? (!position.equals(that.position)) : (that.position != null)) {
      return false;
    }

    if ((toolbar != null) ? (!toolbar.equals(that.toolbar)) : (that.toolbar != null)) {
      return false;
    }

    if ((view != null) ? (!view.equals(that.view)) : (that.view != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for config renders.
   *
   * @return  Set
   */
  public Set<DynamicViewToolbarConfigureRenderer> getConfigRenders() {
    return configRenders;
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
   * getter method for position.
   *
   * @return  String
   */
  public String getPosition() {
    return position;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for toolbar.
   *
   * @return  DynamicToolbar
   */
  public DynamicToolbar getToolbar() {
    return toolbar;
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
    result = (31 * result) + ((position != null) ? position.hashCode() : 0);
    result = (31 * result) + ((toolbar != null) ? toolbar.hashCode() : 0);
    result = (31 * result) + ((view != null) ? view.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * paste.
   *
   * @param  newToolbar  DynamicViewToolbar
   */
  public void paste(DynamicViewToolbar newToolbar) {
    newToolbar.setToolbar(this.getToolbar());
    newToolbar.setPosition(this.getPosition());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for config renders.
   *
   * @param  configRenders  Set
   */
  public void setConfigRenders(Set<DynamicViewToolbarConfigureRenderer> configRenders) {
    this.configRenders = configRenders;
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
   * setter method for position.
   *
   * @param  position  String
   */
  public void setPosition(String position) {
    this.position = position;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for toolbar.
   *
   * @param  toolbar  DynamicToolbar
   */
  public void setToolbar(DynamicToolbar toolbar) {
    this.toolbar = toolbar;
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
} // end class DynamicViewToolbar
