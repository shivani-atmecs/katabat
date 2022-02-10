package com.cmc.credagility.core.domain.portfolio;

import com.cmc.credagility.core.domain.address.AddressType;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

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
import java.io.Serializable;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 12/20/12 Time: 9:37 AM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name              = "PortfolioAddressType",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "portfolioId", "addressTypeId" }) },
  indexes           = {
    @Index(
      name          = "FKDC_portfolioId",
      columnList    = "portfolioId"
    )
  }
)
public class PortfolioAddressType extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8147146442985865581L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** <code>true</code> allow permanence. */
  @Column(
    name             = "allowPermanence",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowPermanence;

  /** AddressType PK addressTypeId.* */
  @JoinColumn(
    name       = "addressTypeId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private AddressType addressType;
  @Column(
    name             = "enableFlexStationTimeZone",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean     enableFlexStationTimeZone;

  /** Which portfolio referenced. */
  @JoinColumn(
    name       = "portfolioId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Portfolio portfolio;

  /** Primary key.* */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long portfolioAddressTypeId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AddressType getAddressType() {
    return addressType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowPermanence() {
    return allowPermanence;
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
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getPortfolioAddressTypeId() {
    return portfolioAddressTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  addressType  DOCUMENT ME!
   */
  public void setAddressType(AddressType addressType) {
    this.addressType = addressType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowPermanence  DOCUMENT ME!
   */
  public void setAllowPermanence(Boolean allowPermanence) {
    this.allowPermanence = allowPermanence;
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
   * @param  portfolio  DOCUMENT ME!
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolioAddressTypeId  DOCUMENT ME!
   */
  public void setPortfolioAddressTypeId(Long portfolioAddressTypeId) {
    this.portfolioAddressTypeId = portfolioAddressTypeId;
  }
} // end class PortfolioAddressType
