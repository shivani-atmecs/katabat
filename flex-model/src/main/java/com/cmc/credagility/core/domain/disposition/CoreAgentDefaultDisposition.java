package com.cmc.credagility.core.domain.disposition;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.portfolio.PortfolioAgentDispositionCode;
import com.cmc.credagility.core.domain.user.Role;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  12/29/2014 10:57
 */
@Entity
@Table(
  name              = "CoreAgentDefaultDisposition",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "roleId", "portfolioId" }) }
)
public class CoreAgentDefaultDisposition extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 9218872357599688312L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  @JoinColumn(
    name       = "channelId",
    insertable = true,
    updatable  = true
  )
  @OneToOne(fetch = FetchType.LAZY)
  private CoreAgentDispositionChannel coreAgentDispositionChannel;


  @JoinColumn(
    name       = "destinationId",
    insertable = true,
    updatable  = true
  )
  @OneToOne(fetch = FetchType.LAZY)
  private CoreAgentDispositionDestination coreAgentDispositionDestination;

  @JoinColumn(
    name       = "spokeToId ",
    insertable = true,
    updatable  = true
  )
  @OneToOne(fetch = FetchType.LAZY)
  private CoreAgentDispositionSpokeTo coreAgentDispositionSpokeTo;

  @JoinColumn(
    name       = "portfolioId",
    insertable = true,
    updatable  = true
  )
  @OneToOne(fetch = FetchType.LAZY)
  private Portfolio portfolio;

  @JoinColumn(
    name       = "dispCodeId",
    insertable = true,
    updatable  = true
  )
  @OneToOne(fetch = FetchType.LAZY)
  private PortfolioAgentDispositionCode portfolioAgentDispositionCode;

  @JoinColumn(
    name       = "roleId",
    insertable = true,
    updatable  = true
  )
  @OneToOne(fetch = FetchType.LAZY)
  private Role role;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
  public Role getRole() {
    return role;
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
   * @param  role  DOCUMENT ME!
   */
  public void setRole(Role role) {
    this.role = role;
  }

} // end class CoreAgentDefaultDisposition
