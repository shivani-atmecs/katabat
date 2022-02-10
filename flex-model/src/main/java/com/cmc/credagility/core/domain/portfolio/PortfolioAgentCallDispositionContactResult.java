package com.cmc.credagility.core.domain.portfolio;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.contact.ContactResult;
import com.cmc.credagility.core.domain.disposition.CoreAgentDispositionChannel;
import com.cmc.credagility.core.domain.disposition.CoreAgentDispositionDestination;
import com.cmc.credagility.core.domain.disposition.CoreAgentDispositionSpokeTo;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created with IntelliJ IDEA. User: l_python Date: 14/5/13 Time: 11:24 AM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity public class PortfolioAgentCallDispositionContactResult extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -3832962529131873813L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** ContactResult PK contactResultId. */
  @JoinColumn(
    name      = "contactResultId",
    updatable = true,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ContactResult contactResult;

  /** CoreAgentDispositionChannel PK coreAgentDispositionChannelId. */
  @JoinColumn(
    name      = "coreAgentDispositionChannelId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CoreAgentDispositionChannel coreAgentDispositionChannel = null;


  /** CoreAgentDispositionDestination PK coreAgentDispositionDestinationId. */
  @JoinColumn(
    name      = "coreAgentDispositionDestinationId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CoreAgentDispositionDestination coreAgentDispositionDestination = null;


  /** CoreAgentDispositionSpokeTo PK coreAgentDispositionSpokeToId. */
  @JoinColumn(
    name      = "coreAgentDispositionSpokeToId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CoreAgentDispositionSpokeTo coreAgentDispositionSpokeTo = null;

  /** Destination phone type. */
  @Column(
    length   = 50,
    nullable = true
  )
  protected String destinationPhoneType = null;


  /** Which portfolio referenced. */
  @JoinColumn(
    name     = "portfolioId",
    unique   = false,
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;


  /** PortfolioAgentDispositionCode. */
  @JoinColumn(
    name      = "portfolioAgentDispositionCodeId",
    updatable = true,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioAgentDispositionCode portfolioAgentDispositionCode = null;

  /** Spoke to source. */
  @Column(
    length   = 50,
    nullable = true
  )
  protected String spokeToSource = null;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean system;

  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ContactResult getContactResult() {
    return contactResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CoreAgentDispositionChannel getCoreAgentDispositionChannel() {
    return coreAgentDispositionChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CoreAgentDispositionDestination getCoreAgentDispositionDestination() {
    return coreAgentDispositionDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CoreAgentDispositionSpokeTo getCoreAgentDispositionSpokeTo() {
    return coreAgentDispositionSpokeTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDestinationPhoneType() {
    return destinationPhoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioAgentDispositionCode getPortfolioAgentDispositionCode() {
    return portfolioAgentDispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSpokeToSource() {
    return spokeToSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for system.
   *
   * @return  Boolean
   */
  public Boolean getSystem() {
    return system;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  contactResult  DOCUMENT ME!
   */
  public void setContactResult(ContactResult contactResult) {
    this.contactResult = contactResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  coreAgentDispositionChannel  DOCUMENT ME!
   */
  public void setCoreAgentDispositionChannel(CoreAgentDispositionChannel coreAgentDispositionChannel) {
    this.coreAgentDispositionChannel = coreAgentDispositionChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  coreAgentDispositionDestination  DOCUMENT ME!
   */
  public void setCoreAgentDispositionDestination(CoreAgentDispositionDestination coreAgentDispositionDestination) {
    this.coreAgentDispositionDestination = coreAgentDispositionDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  coreAgentDispositionSpokeTo  DOCUMENT ME!
   */
  public void setCoreAgentDispositionSpokeTo(CoreAgentDispositionSpokeTo coreAgentDispositionSpokeTo) {
    this.coreAgentDispositionSpokeTo = coreAgentDispositionSpokeTo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  destinationPhoneType  DOCUMENT ME!
   */
  public void setDestinationPhoneType(String destinationPhoneType) {
    this.destinationPhoneType = destinationPhoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioAgentDispositionCode  DOCUMENT ME!
   */
  public void setPortfolioAgentDispositionCode(PortfolioAgentDispositionCode portfolioAgentDispositionCode) {
    this.portfolioAgentDispositionCode = portfolioAgentDispositionCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  spokeToSource  DOCUMENT ME!
   */
  public void setSpokeToSource(String spokeToSource) {
    this.spokeToSource = spokeToSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for system.
   *
   * @param  system  Boolean
   */
  public void setSystem(Boolean system) {
    this.system = system;
  }
} // end class PortfolioAgentCallDispositionContactResult
