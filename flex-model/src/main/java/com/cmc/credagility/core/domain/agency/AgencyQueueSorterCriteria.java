package com.cmc.credagility.core.domain.agency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.mra.AgencyBaseCriteria;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/17/2014 10:21
 */
@Entity public class AgencyQueueSorterCriteria extends AgencyBaseCriteria {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agencyQueueSorterId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected AgencyQueueSorter agencyQueueSorter;

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
   * getter method for agency queue sorter.
   *
   * @return  AgencyQueueSorter
   */
  public AgencyQueueSorter getAgencyQueueSorter() {
    return agencyQueueSorter;
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
   * setter method for agency queue sorter.
   *
   * @param  agencyQueueSorter  AgencyQueueSorter
   */
  public void setAgencyQueueSorter(AgencyQueueSorter agencyQueueSorter) {
    this.agencyQueueSorter = agencyQueueSorter;
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
} // end class AgencyQueueSorterCriteria
