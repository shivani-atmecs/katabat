package com.cmc.credagility.core.domain.disposition;

import java.io.Serializable;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 11:11
 */
@Entity
@Table(name = "CoreAgentDispositionChannel")
public class CoreAgentDispositionChannel extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  // ~ Instance fields
  // --------------------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 2849745769600614321L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "channel",
    length = 100
  )
  protected String channel;

  /** CoreAgentDispositionChannel identifier PK. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long coreAgentDispositionChannelId;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "coreAgentDispositionChannel"
  )
  protected Set<CoreAgentDispositionDestination> coreAgentDispositionDestination =
    new LinkedHashSet<CoreAgentDispositionDestination>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "coreAgentDispositionChannel"
  )
  protected Set<CoreAgentDispositionSpokeTo> coreAgentDispositionSpokeTo =
    new LinkedHashSet<CoreAgentDispositionSpokeTo>();


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "shortCode",
    length = 4
  )
  protected String shortCode;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel.
   *
   * @return  String
   */
  public String getChannel() {
    return channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for core agent disposition channel id.
   *
   * @return  Long
   */
  public Long getCoreAgentDispositionChannelId() {
    return coreAgentDispositionChannelId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for core agent disposition destination.
   *
   * @return  Set
   */
  public Set<CoreAgentDispositionDestination> getCoreAgentDispositionDestination() {
    return coreAgentDispositionDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for core agent disposition spoke to.
   *
   * @return  Set
   */
  public Set<CoreAgentDispositionSpokeTo> getCoreAgentDispositionSpokeTo() {
    return coreAgentDispositionSpokeTo;
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
   * setter method for channel.
   *
   * @param  channel  String
   */
  public void setChannel(String channel) {
    this.channel = channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for core agent disposition channel id.
   *
   * @param  coreAgentDispositionChannelId  Long
   */
  public void setCoreAgentDispositionChannelId(Long coreAgentDispositionChannelId) {
    this.coreAgentDispositionChannelId = coreAgentDispositionChannelId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for core agent disposition destination.
   *
   * @param  coreAgentDispositionDestination  Set
   */
  public void setCoreAgentDispositionDestination(Set<CoreAgentDispositionDestination> coreAgentDispositionDestination) {
    this.coreAgentDispositionDestination = coreAgentDispositionDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for core agent disposition spoke to.
   *
   * @param  coreAgentDispositionSpokeTo  Set
   */
  public void setCoreAgentDispositionSpokeTo(Set<CoreAgentDispositionSpokeTo> coreAgentDispositionSpokeTo) {
    this.coreAgentDispositionSpokeTo = coreAgentDispositionSpokeTo;
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
} // end class CoreAgentDispositionChannel
