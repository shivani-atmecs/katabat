package com.ozstrategy.credagility.core.domain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 12:52
 */
@Entity
@Table(
  name              = "GenerateAssignIds",
  uniqueConstraints = { @UniqueConstraint(columnNames = "generatedTable") }
)
public class GenerateAssignIds implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -1242926239554551471L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(name = "currGeneratedId")
  protected Long currGeneratedId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "generatedTable",
    length = 255
  )
  @Id protected String generatedTable;

  /** TODO: DOCUMENT ME! */
  @Column(name = "incrementValue")
  protected Long incrementValue;

  /** TODO: DOCUMENT ME! */
  @Column(name = "initialStartValue")
  protected Long initialStartValue;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for curr generated id.
   *
   * @return  Long
   */
  public Long getCurrGeneratedId() {
    return currGeneratedId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for generated table.
   *
   * @return  String
   */
  public String getGeneratedTable() {
    return generatedTable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for increment value.
   *
   * @return  Long
   */
  public Long getIncrementValue() {
    return incrementValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for initial start value.
   *
   * @return  Long
   */
  public Long getInitialStartValue() {
    return initialStartValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for curr generated id.
   *
   * @param  currGeneratedId  Long
   */
  public void setCurrGeneratedId(Long currGeneratedId) {
    this.currGeneratedId = currGeneratedId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for generated table.
   *
   * @param  generatedTable  String
   */
  public void setGeneratedTable(String generatedTable) {
    this.generatedTable = generatedTable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for increment value.
   *
   * @param  incrementValue  Long
   */
  public void setIncrementValue(Long incrementValue) {
    this.incrementValue = incrementValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for initial start value.
   *
   * @param  initialStartValue  Long
   */
  public void setInitialStartValue(Long initialStartValue) {
    this.initialStartValue = initialStartValue;
  }


} // end class GenerateAssignIds
