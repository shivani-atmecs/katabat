package com.ozstrategy.credagility.core.domain.dynamicview;

import com.ozstrategy.credagility.core.domain.type.DynamicViewStatus;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/16/2014 14:05
 */
@Entity
@Table(
  name              = "DynamicComponentRenderer",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "rendererKey", "context", "contextId" }) }
)
public class DynamicComponentRenderer extends AbstractContextRenderer {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2859306893568858291L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "renderer",
    cascade  = CascadeType.ALL
  )
  protected Set<DynamicComponentRenderArgument> rendererArguments = new LinkedHashSet<DynamicComponentRenderArgument>();

  /** When 'DynamicViewStatus.DELETED', you can not use it. */
  @Column(length = 16)
  @Enumerated(value = EnumType.STRING)
  protected DynamicViewStatus status = DynamicViewStatus.ACTIVE;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  AbstractContextRenderer#equals(Object)
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

    DynamicComponentRenderer renderer = (DynamicComponentRenderer) o;

    if (status != renderer.status) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  AbstractContextRenderer#getContextObject()
   */
  @Override public ContextObject getContextObject() {
    return contextObject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for renderer arguments.
   *
   * @return  Set
   */
  public Set<DynamicComponentRenderArgument> getRendererArguments() {
    return rendererArguments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  DynamicViewStatus
   */
  public DynamicViewStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  AbstractContextRenderer#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((status != null) ? status.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  AbstractContextRenderer#setContextObject(ContextObject)
   */
  @Override public void setContextObject(ContextObject contextObject) {
    this.contextObject = contextObject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for renderer arguments.
   *
   * @param  rendererArguments  Set
   */
  public void setRendererArguments(Set<DynamicComponentRenderArgument> rendererArguments) {
    this.rendererArguments = rendererArguments;
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
   * @see  AbstractRenderer#toString()
   */
  @Override public String toString() {
    return "DynamicComponentRenderer{"
      + "name='" + name + '\''
      + ", rendererKey='" + rendererKey + '\''
      + ", " + contextObject
      + '}';
  }
} // end class DynamicComponentRenderer
