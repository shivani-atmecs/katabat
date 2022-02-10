package com.cmc.credagility.core.domain.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * For test big file import.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/14/2014 16:35
 */
@Entity
@Table(name = "LargeField")
public class LargeField implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2923443645328610583L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Pk. */
  @Column(
    name     = "id",
    nullable = false,
    unique   = true
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected long id;


  /** test content. */
  @Column(
    name     = "largeField",
    nullable = false,
    length   = 1024 * 500
  )
  protected String largeField;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  long
   */
  public long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for large field.
   *
   * @return  String
   */
  public String getLargeField() {
    return largeField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  long
   */
  public void setId(long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for large field.
   *
   * @param  largeField  String
   */
  public void setLargeField(String largeField) {
    this.largeField = largeField;
  }
} // end class LargeField
