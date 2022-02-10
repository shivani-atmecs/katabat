package com.ozstrategy.credagility.core.domain;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 17:10
 */
@Entity
@Table(name = "WorkflowMigrateDataItem")
public class WorkflowMigrateDataItem implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6836937334872082618L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long         id;

  /** TODO: DOCUMENT ME! */
  @Column protected Long newValue;

  /** TODO: DOCUMENT ME! */
  @Column protected Long oldValue;

  /** TODO: DOCUMENT ME! */
  @Column(length = 32)
  protected String type;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer version;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for new value.
   *
   * @return  Long
   */
  public Long getNewValue() {
    return newValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for old value.
   *
   * @return  Long
   */
  public Long getOldValue() {
    return oldValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  String
   */
  public String getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for version.
   *
   * @return  Integer
   */
  public Integer getVersion() {
    return version;
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
   * setter method for new value.
   *
   * @param  newValue  Long
   */
  public void setNewValue(Long newValue) {
    this.newValue = newValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for old value.
   *
   * @param  oldValue  Long
   */
  public void setOldValue(Long oldValue) {
    this.oldValue = oldValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type.
   *
   * @param  type  String
   */
  public void setType(String type) {
    this.type = type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for version.
   *
   * @param  version  Integer
   */
  public void setVersion(Integer version) {
    this.version = version;
  }
} // end class WorkflowMigrateDataItem
