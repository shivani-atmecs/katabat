package com.cmc.credagility.core.domain.channel;

import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  04/16/2015 14:32
 */
@Entity
@Table(name = "ChannelVendorStatusConfig")
public class ChannelVendorStatusConfig extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2571042067878780769L;

  //~ Instance fields --------------------------------------------------------------------------------------------------


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "channelTypeId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ChannelType channelType;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "channelVendorStatusId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long channelVendorStatusId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "strategyStatus",
    length = 3
  )
  protected String strategyStatus;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "vendorId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ChannelVendor vendor;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "vendorStatusCode",
    length = 32
  )
  protected String vendorStatusCode;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "vendorStatusDescription",
    length = 250
  )
  protected String vendorStatusDescription;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * ChannelType.
   *
   * @return  ChannelType.
   */
  public ChannelType getChannelType() {
    return channelType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getChannelVendorStatusId() {
    return channelVendorStatusId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getStrategyStatus() {
    return strategyStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * ChannelVendor.
   *
   * @return  ChannelVendor.
   */
  public ChannelVendor getVendor() {
    return vendor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getVendorStatusCode() {
    return vendorStatusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getVendorStatusDescription() {
    return vendorStatusDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setChannelType.
   *
   * @param  channelType  $param.type$
   */
  public void setChannelType(ChannelType channelType) {
    this.channelType = channelType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setChannelVendorStatusId.
   *
   * @param  channelVendorStatusId  $param.type$
   */
  public void setChannelVendorStatusId(Long channelVendorStatusId) {
    this.channelVendorStatusId = channelVendorStatusId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setStrategyStatus.
   *
   * @param  strategyStatus  $param.type$
   */
  public void setStrategyStatus(String strategyStatus) {
    this.strategyStatus = strategyStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setVendor.
   *
   * @param  vendor  $param.type$
   */
  public void setVendor(ChannelVendor vendor) {
    this.vendor = vendor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setVendorStatusCode.
   *
   * @param  vendorStatusCode  $param.type$
   */
  public void setVendorStatusCode(String vendorStatusCode) {
    this.vendorStatusCode = vendorStatusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   *
   * setVendorStatusDescription.
   *
   * @param  vendorStatusDescription  $param.type$
   */
  public void setVendorStatusDescription(String vendorStatusDescription) {
    this.vendorStatusDescription = vendorStatusDescription;
  }
} // end class ChannelVendorStatusConfig
