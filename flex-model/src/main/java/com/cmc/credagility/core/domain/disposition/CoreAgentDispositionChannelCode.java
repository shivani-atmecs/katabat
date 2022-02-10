package com.cmc.credagility.core.domain.disposition;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.portfolio.PortfolioAgentDispositionCode;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.StatusType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 12:06
 */
@Entity
@Table(name = "CoreAgentDispositionChannelCode")
public class CoreAgentDispositionChannelCode extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  // ~ Instance fields
  // --------------------------------------------------------------------------------------------------

  private static final long serialVersionUID = 733734194851840195L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "canVerify",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean canVerify = Boolean.FALSE;

  /** reference CoreAgentDispositionChannel. */
  @JoinColumn(
    name     = "coreAgentDispositionChannelId",
    unique   = false,
    nullable = false
  )
  @ManyToOne protected CoreAgentDispositionChannel coreAgentDispositionChannel;

  /** CoreAgentDispositionDestination identifier PK. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long coreAgentDispositionChannelCodeId;

  /** reference PortfolioAgentDispositionCode. */
  @JoinColumn(
    name     = "portfolioAgentDispositionCodeId",
    unique   = false,
    nullable = false
  )
  @ManyToOne protected PortfolioAgentDispositionCode portfolioAgentDispositionCode;


  /** TODO: DOCUMENT ME! */
  @Column protected Integer priority;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "roleId",
    unique   = false,
    nullable = true
  )
  @ManyToOne protected Role role;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "status",
    nullable = true,
    length   = 20
  )
  @Enumerated(value = EnumType.STRING)
  protected StatusType status;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for can verify.
   *
   * @return  Boolean
   */
  public Boolean getCanVerify() {
    return canVerify;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for core agent disposition channel code id.
   *
   * @return  Long
   */
  public Long getCoreAgentDispositionChannelCodeId() {
    return coreAgentDispositionChannelCodeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio agent disposition code.
   *
   * @return  PortfolioAgentDispositionCode
   */
  public PortfolioAgentDispositionCode getPortfolioAgentDispositionCode() {
    return portfolioAgentDispositionCode;
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
   * getter method for role.
   *
   * @return  Role
   */
  public Role getRole() {
    return role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  StatusType
   */
  public StatusType getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for can verify.
   *
   * @param  canVerify  Boolean
   */
  public void setCanVerify(Boolean canVerify) {
    this.canVerify = canVerify;
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
   * setter method for core agent disposition channel code id.
   *
   * @param  coreAgentDispositionChannelCodeId  Long
   */
  public void setCoreAgentDispositionChannelCodeId(Long coreAgentDispositionChannelCodeId) {
    this.coreAgentDispositionChannelCodeId = coreAgentDispositionChannelCodeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio agent disposition code.
   *
   * @param  portfolioAgentDispositionCode  PortfolioAgentDispositionCode
   */
  public void setPortfolioAgentDispositionCode(PortfolioAgentDispositionCode portfolioAgentDispositionCode) {
    this.portfolioAgentDispositionCode = portfolioAgentDispositionCode;
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
   * setter method for role.
   *
   * @param  role  Role
   */
  public void setRole(Role role) {
    this.role = role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  StatusType
   */
  public void setStatus(StatusType status) {
    this.status = status;
  }
} // end class CoreAgentDispositionChannelCode
