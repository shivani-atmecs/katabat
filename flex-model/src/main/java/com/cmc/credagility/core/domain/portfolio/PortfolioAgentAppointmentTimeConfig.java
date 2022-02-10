package com.cmc.credagility.core.domain.portfolio;

import com.cmc.credagility.core.domain.address.Timezone;
import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  01/09/2015 16:27
 */
@Entity
@Table(
  name              = "PortfolioAgentAppointmentTimeConfig",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "portfolioId", "dayOfWeek" }) }
)
public class PortfolioAgentAppointmentTimeConfig extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -3138112546712793057L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "agentApptEndTimeStr",
    nullable = false
  )
  protected String agentApptEndTimeStr;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "agentApptStartTimeStr",
    nullable = false
  )
  protected String agentApptStartTimeStr;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "agentTimeZoneId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Timezone agentTimeZone;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "dayOfWeek",
    nullable = false
  )
  protected String dayOfWeek;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "portfolioId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Portfolio portfolio;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent appt end time str.
   *
   * @return  String
   */
  public String getAgentApptEndTimeStr() {
    return agentApptEndTimeStr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent appt start time str.
   *
   * @return  String
   */
  public String getAgentApptStartTimeStr() {
    return agentApptStartTimeStr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent time zone.
   *
   * @return  Timezone
   */
  public Timezone getAgentTimeZone() {
    return agentTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDayOfWeek() {
    return dayOfWeek;
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
   * setter method for agent appt end time str.
   *
   * @param  agentApptEndTimeStr  String
   */
  public void setAgentApptEndTimeStr(String agentApptEndTimeStr) {
    this.agentApptEndTimeStr = agentApptEndTimeStr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent appt start time str.
   *
   * @param  agentApptStartTimeStr  String
   */
  public void setAgentApptStartTimeStr(String agentApptStartTimeStr) {
    this.agentApptStartTimeStr = agentApptStartTimeStr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent time zone.
   *
   * @param  agentTimeZone  Timezone
   */
  public void setAgentTimeZone(Timezone agentTimeZone) {
    this.agentTimeZone = agentTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dayOfWeek  DOCUMENT ME!
   */
  public void setDayOfWeek(String dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
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
} // end class PortfolioAgentAppointmentTimeConfig
