package com.cmc.credagility.core.domain.mra;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

import com.cmc.credagility.core.domain.base.CreatorEntity;


/**
 * Created by IntelliJ IDEA. User: Swhite Date: 12-18-2012
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo</a>
 * @version  10/19/2014 00:08
 */
@Entity public class QueueExportDestination extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  protected String path;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new QueueExportDestination object.
   */
  public QueueExportDestination() { }

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
   * getter method for path.
   *
   * @return  String
   */
  public String getPath() {
    return path;
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
   * setter method for path.
   *
   * @param  path  String
   */
  public void setPath(String path) {
    this.path = path;
  }
} // end class QueueExportDestination
