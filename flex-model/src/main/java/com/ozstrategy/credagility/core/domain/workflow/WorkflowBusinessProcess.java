package com.ozstrategy.credagility.core.domain.workflow;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:55
 */
@Entity
@Table(name = "WorkflowBusinessProcess")
public class WorkflowBusinessProcess extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4370627977711575369L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** Name for the schedule. */
  @Column(
    length   = 100,
    nullable = false,
    unique   = true
  )
  protected String name;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
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

    WorkflowBusinessProcess that = (WorkflowBusinessProcess) o;

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    return true;
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
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);

    return result;
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
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }
} // end class WorkflowBusinessProcess
