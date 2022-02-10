package com.cmc.credagility.core.domain.mra;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 14:13
 */
@Entity public class QueueAccountSorterCriteria extends AbstractBaseCriteria {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "sorterId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected QueueAccountSorter queueAccountSorter;


  /** Description for the sorting criteria. */
  @Column(length = 255)
  private String description;

  /** direction for the sorting criteria. ASC/DESC */
  @Column(
    length   = 8,
    nullable = false
  )
  private String direction;

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for direction.
   *
   * @return  String
   */
  public String getDirection() {
    return direction;
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
   * getter method for queue account sorter.
   *
   * @return  QueueAccountSorter
   */
  public QueueAccountSorter getQueueAccountSorter() {
    return queueAccountSorter;
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
   * setter method for direction.
   *
   * @param  direction  String
   */
  public void setDirection(String direction) {
    this.direction = direction;
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
   * setter method for queue account sorter.
   *
   * @param  queueAccountSorter  QueueAccountSorter
   */
  public void setQueueAccountSorter(QueueAccountSorter queueAccountSorter) {
    this.queueAccountSorter = queueAccountSorter;
  }

} // end class QueueAccountSorterCriteria
