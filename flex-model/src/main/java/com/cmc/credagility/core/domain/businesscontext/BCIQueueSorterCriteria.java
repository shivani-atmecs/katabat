package com.cmc.credagility.core.domain.businesscontext;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.mra.BCIBaseCriteria;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 11:09
 */
@Entity public class BCIQueueSorterCriteria extends BCIBaseCriteria {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "bciQueueSorterId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected BCIQueueSorter bciQueueSorter;

  @Column(length = 255)
  private String description;

  @Column(
    length   = 8,
    nullable = false
  )
  private String direction;

  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for bci queue sorter.
   *
   * @return  BCIQueueSorter
   */
  public BCIQueueSorter getBciQueueSorter() {
    return bciQueueSorter;
  }

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
   * setter method for bci queue sorter.
   *
   * @param  bciQueueSorter  BCIQueueSorter
   */
  public void setBciQueueSorter(BCIQueueSorter bciQueueSorter) {
    this.bciQueueSorter = bciQueueSorter;
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
} // end class BCIQueueSorterCriteria
