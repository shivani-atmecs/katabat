package com.cmc.credagility.core.domain.disposition;

import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 12:07
 */
@Entity
@Table(name = "CoreAgentDispositionSpokeTo")
public class CoreAgentDispositionSpokeTo extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -3115954044934447691L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "coreAgentDispositionChannelId",
    unique   = false,
    nullable = false
  )
  @ManyToOne protected CoreAgentDispositionChannel coreAgentDispositionChannel;

  /** CoreAgentDispositionSpokeTo identifier PK. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long coreAgentDispositionSpokeToId;


  /** TODO: DOCUMENT ME! */
  @Column protected Integer priority;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "shortCode",
    length = 4
  )
  protected String shortCode;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "spokeTo",
    length = 100
  )
  protected String spokeTo;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "spokeToType",
    length = 100
  )
  protected String spokeToType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for core agent disposition channel.
   *
   * @return  CoreAgentDispositionChannel
   */
  public CoreAgentDispositionChannel getCoreAgentDispositionChannel() {
    return coreAgentDispositionChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for core agent disposition spoke to id.
   *
   * @return  Long
   */
  public Long getCoreAgentDispositionSpokeToId() {
    return coreAgentDispositionSpokeToId;
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
   * getter method for short code.
   *
   * @return  String
   */
  public String getShortCode() {
    return shortCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spoke to.
   *
   * @return  String
   */
  public String getSpokeTo() {
    return spokeTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spoke to type.
   *
   * @return  String
   */
  public String getSpokeToType() {
    return spokeToType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for core agent disposition channel.
   *
   * @param  coreAgentDispositionChannel  CoreAgentDispositionChannel
   */
  public void setCoreAgentDispositionChannel(CoreAgentDispositionChannel coreAgentDispositionChannel) {
    this.coreAgentDispositionChannel = coreAgentDispositionChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for core agent disposition spoke to id.
   *
   * @param  coreAgentDispositionSpokeToId  Long
   */
  public void setCoreAgentDispositionSpokeToId(Long coreAgentDispositionSpokeToId) {
    this.coreAgentDispositionSpokeToId = coreAgentDispositionSpokeToId;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for short code.
   *
   * @param  shortCode  String
   */
  public void setShortCode(String shortCode) {
    this.shortCode = shortCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spoke to.
   *
   * @param  spokeTo  String
   */
  public void setSpokeTo(String spokeTo) {
    this.spokeTo = spokeTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spoke to type.
   *
   * @param  spokeToType  String
   */
  public void setSpokeToType(String spokeToType) {
    this.spokeToType = spokeToType;
  }
  // ~ Instance fields
  // --------------------------------------------------------------------------------------------------
} // end class CoreAgentDispositionSpokeTo
