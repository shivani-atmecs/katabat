package com.ozstrategy.credagility.core.domain;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by IntelliJ IDEA. User: Swhite Date: 06-04-2013
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name              = "StrategyRunType",
  uniqueConstraints = { @UniqueConstraint(columnNames = "runTypeName") }
)
public class StrategyRunType implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  public static final String TYPE_OPERATIONAL = "Operational";


  /** TODO: DOCUMENT ME! */
  public static final String TYPE_NON_OPERATIONAL = "Non-Operational";


  /** TODO: DOCUMENT ME! */
  public static final String TYPE_BOTH = "Both";

  private static final long serialVersionUID = -5518564934963942537L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Operational/Non-Operational. */
  @Column(
    unique = true,
    length = 255
  )
  protected String runTypeName;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new StrategyRunType object.
   */
  public StrategyRunType() { }

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

    StrategyRunType that = (StrategyRunType) o;

    if (!id.equals(that.id)) {
      return false;
    }

    if ((runTypeName != null) ? (!runTypeName.equals(that.runTypeName)) : (that.runTypeName != null)) {
      return false;
    }

    return true;
  } // end method equals

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
   * getter method for run type name.
   *
   * @return  String
   */
  public String getRunTypeName() {
    return runTypeName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + id.hashCode();
    result = (31 * result) + ((runTypeName != null) ? runTypeName.hashCode() : 0);

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
   * setter method for run type name.
   *
   * @param  runTypeName  String
   */
  public void setRunTypeName(String runTypeName) {
    this.runTypeName = runTypeName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    return "StrategyRunType{"
      + "id=" + id
      + ", runTypeName='" + runTypeName + '\''
      + '}';
  }
} // end class StrategyRunType
