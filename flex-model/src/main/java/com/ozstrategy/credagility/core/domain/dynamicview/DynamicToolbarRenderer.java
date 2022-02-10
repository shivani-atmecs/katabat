package com.ozstrategy.credagility.core.domain.dynamicview;

import com.ozstrategy.credagility.core.domain.type.DynamicViewStatus;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/16/2014 15:03
 */
@Entity
@Table(
  name              = "DynamicToolbarRenderer",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "rendererKey", "context", "contextId" }) }
)
public class DynamicToolbarRenderer extends AbstractContextRenderer {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4691572720836616427L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "renderer",
    cascade  = CascadeType.ALL
  )
  protected Set<DynamicToolbarRendererArgument> rendererArguments = new LinkedHashSet<DynamicToolbarRendererArgument>();

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

    DynamicToolbarRenderer that = (DynamicToolbarRenderer) o;

    if (status != that.status) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for renderer arguments.
   *
   * @return  Set
   */
  public Set<DynamicToolbarRendererArgument> getRendererArguments() {
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
   * setter method for renderer arguments.
   *
   * @param  rendererArguments  Set
   */
  public void setRendererArguments(Set<DynamicToolbarRendererArgument> rendererArguments) {
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
    return "DynamicToolbarRenderer{"
      + "name='" + name + '\''
      + ", status='" + status + '\''
      + ", rendererKey='" + rendererKey + '\''
      + ", " + contextObject
      + '}';
  }
} // end class DynamicToolbarRenderer
