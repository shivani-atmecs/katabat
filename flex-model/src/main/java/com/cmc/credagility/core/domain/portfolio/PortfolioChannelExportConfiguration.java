package com.cmc.credagility.core.domain.portfolio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.channel.ChannelType;


/**
 * Created by IntelliJ IDEA. User: ysun Date: 11/19/11 Time: 8:59 PM To change this template use File | Settings | File
 * Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name              = "PortfolioChannelExportConfiguration",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "portfolioId", "channelTypeId" }) },
  indexes           = {
    @Index(
      name          = "FKC8_portfolioId",
      columnList    = "portfolioId"
    )
  }
)
public class PortfolioChannelExportConfiguration extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Export end time, default is 20:00:00. */
  @Column(
    name   = "exportEndTime",
    length = 8
  )
  protected String exportEndTime = "20:00:00";

  /** Export start time, default is: 9:00:00 */
  @Column(
    name   = "exportStartTime",
    length = 8
  )
  protected String exportStartTime = "9:00:00";

  /** ChannelType PK channelTypeId. */
  @JoinColumn(
    name     = "channelTypeId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private ChannelType channelType;

  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  /** Portfolio PK portfolioId. */
  @JoinColumn(
    name     = "portfolioId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Portfolio portfolio;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ChannelType getChannelType() {
    return channelType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExportEndTime() {
    return exportEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getExportStartTime() {
    return exportStartTime;
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
   * @param  channelType  DOCUMENT ME!
   */
  public void setChannelType(ChannelType channelType) {
    this.channelType = channelType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  exportEndTime  DOCUMENT ME!
   */
  public void setExportEndTime(String exportEndTime) {
    this.exportEndTime = exportEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  exportStartTime  DOCUMENT ME!
   */
  public void setExportStartTime(String exportStartTime) {
    this.exportStartTime = exportStartTime;
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
} // end class PortfolioChannelExportConfiguration
