package com.cmc.credagility.core.domain.disposition;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.contact.PhoneType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 11:12
 */
@Entity
@Table(name = "CoreAgentDispositionDestination")
public class CoreAgentDispositionDestination extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  // ~ Instance fields
  // --------------------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -3060539295057526647L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "coreAgentDispositionChannelId",
    unique   = false,
    nullable = false
  )
  @ManyToOne protected CoreAgentDispositionChannel coreAgentDispositionChannel;

  /** CoreAgentDispositionDestination identifier PK. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long coreAgentDispositionDestinationId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "destination",
    length = 100
  )
  protected String destination;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "typeId",
    unique   = false,
    nullable = true
  )
  @ManyToOne protected PhoneType phoneType;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "shortCode",
    length = 4
  )
  protected String shortCode;

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
   * getter method for core agent disposition destination id.
   *
   * @return  Long
   */
  public Long getCoreAgentDispositionDestinationId() {
    return coreAgentDispositionDestinationId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for destination.
   *
   * @return  String
   */
  public String getDestination() {
    return destination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone type.
   *
   * @return  PhoneType
   */
  public PhoneType getPhoneType() {
    return phoneType;
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
   * setter method for core agent disposition channel.
   *
   * @param  coreAgentDispositionChannel  CoreAgentDispositionChannel
   */
  public void setCoreAgentDispositionChannel(CoreAgentDispositionChannel coreAgentDispositionChannel) {
    this.coreAgentDispositionChannel = coreAgentDispositionChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for core agent disposition destination id.
   *
   * @param  coreAgentDispositionDestinationId  Long
   */
  public void setCoreAgentDispositionDestinationId(Long coreAgentDispositionDestinationId) {
    this.coreAgentDispositionDestinationId = coreAgentDispositionDestinationId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for destination.
   *
   * @param  destination  String
   */
  public void setDestination(String destination) {
    this.destination = destination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone type.
   *
   * @param  phoneType  PhoneType
   */
  public void setPhoneType(PhoneType phoneType) {
    this.phoneType = phoneType;
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
} // end class CoreAgentDispositionDestination
