package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by yongliu on 11/4/16.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  11/04/2016 15:43
 */
@Entity
@Table(
  name              = "BureauRequestType",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) }
)
public class BureauRequestType extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1860356405568301586L;

  /**
   * For <b>ATP</b> requests, only not monitored responsibles should be actioned on.
   *
   * <pre>
       e.g. If an account is already added for Bureau management, these accounts should not be sent to Bureau again.
   * </pre>
   */
  public static final String REQUEST_TYPE_ATP = "ATP";

  /**
   * For <b>FRP</b> requests, only monitored responsibles should be actioned on.
   *
   * <pre>
       e.g. only accounts that are already under Beureau mangement should be sent to Bureau.
   * </pre>
   */
  public static final String REQUEST_TYPE_FRP = "FRP";

  /** For <b>SCR</b> requests, only monitored responsibles should be actioned on. */
  public static final String REQUEST_TYPE_SCR = "SCR";

  /** For <b>SCO</b> requests, only non-monitored responsibles should be actioned on. */
  public static final String REQUEST_TYPE_SCO = "SCO";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(length = 255)
  private String   description;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  @Column(
    nullable = false,
    length   = 255
  )
  private String name;

  @Column(length = 9)
  private Integer priority;

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

    BureauRequestType that = (BureauRequestType) o;

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    return !((priority != null) ? (!priority.equals(that.priority)) : (that.priority != null));

  } // end method equals

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
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
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
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);

    return result;
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
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
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
} // end class BureauRequestType
