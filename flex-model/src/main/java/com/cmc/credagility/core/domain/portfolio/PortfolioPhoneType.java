package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.contact.PhoneType;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 12/20/12 Time: 9:56 AM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name              = "PortfolioPhoneType",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "portfolioId", "phoneTypeId" }) },
  indexes           = {
    @Index(
      name          = "FK71_portfolioId",
      columnList    = "portfolioId"
    )
  }
)
public class PortfolioPhoneType extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8249043291776738673L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** <code>true</code> allow display on queue export. */
  @Column(
    name             = "displayOnQueueExport",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean displayOnQueueExport;

  /** <code>true</code> enable call type control. */
  @Column(
    name             = "enableCallTypeControl",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean enableCallTypeControl;

  @Column(
    name             = "enableFlexStationTimeZone",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean enableFlexStationTimeZone;

  /** <code>true</code> enable preview dialing. */
  @Column(
    name             = "enablePreviewDialing",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean enablePreviewDialing;

  /** PhoneType PK phoneTypeId. */
  @JoinColumn(
    name       = "phoneTypeId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private PhoneType phoneType;

  /** Portfolio PK portfolioId. */
  @JoinColumn(
    name       = "portfolioId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Portfolio portfolio;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long portfolioPhoneTypeId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getDisplayOnQueueExport() {
    return displayOnQueueExport;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getEnableCallTypeControl() {
    return enableCallTypeControl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enable flex station time zone.
   *
   * @return  Boolean
   */
  public Boolean getEnableFlexStationTimeZone() {
    return enableFlexStationTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getEnablePreviewDialing() {
    return enablePreviewDialing;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PhoneType getPhoneType() {
    return phoneType;
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
  public Long getPortfolioPhoneTypeId() {
    return portfolioPhoneTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  displayOnQueueExport  DOCUMENT ME!
   */
  public void setDisplayOnQueueExport(Boolean displayOnQueueExport) {
    this.displayOnQueueExport = displayOnQueueExport;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  enableCallTypeControl  DOCUMENT ME!
   */
  public void setEnableCallTypeControl(Boolean enableCallTypeControl) {
    this.enableCallTypeControl = enableCallTypeControl;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enable flex station time zone.
   *
   * @param  enableFlexStationTimeZone  Boolean
   */
  public void setEnableFlexStationTimeZone(Boolean enableFlexStationTimeZone) {
    this.enableFlexStationTimeZone = enableFlexStationTimeZone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  enablePreviewDialing  DOCUMENT ME!
   */
  public void setEnablePreviewDialing(Boolean enablePreviewDialing) {
    this.enablePreviewDialing = enablePreviewDialing;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneType  DOCUMENT ME!
   */
  public void setPhoneType(PhoneType phoneType) {
    this.phoneType = phoneType;
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
   * @param  portfolioPhoneTypeId  DOCUMENT ME!
   */
  public void setPortfolioPhoneTypeId(Long portfolioPhoneTypeId) {
    this.portfolioPhoneTypeId = portfolioPhoneTypeId;
  }
} // end class PortfolioPhoneType
