package com.cmc.credagility.core.domain.channel;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.apache.commons.lang3.StringUtils;


/**
 * Channel Vendor.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 14:49
 */
@Entity
@Table(
  name              = "ChannelVendor",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "channelTypeId" }) },
  indexes           = {
    @Index(
      name          = "postalCodeIndex",
      columnList    = "postalCode"
    )
  }
)
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="vendorId", scope = ChannelVendor.class)
public class ChannelVendor extends BaseServiceVendor {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Channel Type. */
// .CascadeType.SAVE_UPDATE
  @JoinColumn(
    name     = "channelTypeId",
    nullable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.MERGE, CascadeType.PERSIST }
  )
  protected ChannelType channelType;


  /** Vendor Channel ResultCode. */
// CascadeType.SAVE_UPDATE
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "channelVendor",
    cascade  = { CascadeType.PERSIST, CascadeType.MERGE }
  )
  protected Set<VendorChannelResultCode> vendorChannelResultCodes = new LinkedHashSet<VendorChannelResultCode>();


  /** vendor. */
  @Column(
    name     = "vendorId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long vendorId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel type.
   *
   * @return  ChannelType
   */
  public ChannelType getChannelType() {
    return channelType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vendor channel result code by code.
   *
   * @param   code  String
   *
   * @return  VendorChannelResultCode
   */
  public VendorChannelResultCode getVendorChannelResultCodeByCode(
    String code) {
    Set<VendorChannelResultCode> vendorChannelResultCodes = this.getVendorChannelResultCodes();

    for (VendorChannelResultCode vendorChannelResultCode : vendorChannelResultCodes) {
      String resultCode = StringUtils.trim(
          vendorChannelResultCode.getCode());

      if (StringUtils.equalsIgnoreCase(code, resultCode)) {
        return vendorChannelResultCode;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vendor channel result codes.
   *
   * @return  Set
   */
  public Set<VendorChannelResultCode> getVendorChannelResultCodes() {
    return vendorChannelResultCodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.BaseServiceVendor#getVendorId()
   */
  @Override public Long getVendorId() {
    return vendorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((this.name == null) ? 0 : this.name.hashCode());
    result = (prime * result)
      + ((this.channelType == null) ? 0 : this.channelType.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel type.
   *
   * @param  channelType  ChannelType
   */
  public void setChannelType(ChannelType channelType) {
    this.channelType = channelType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor channel result codes.
   *
   * @param  vendorChannelResultCodes  Set
   */
  public void setVendorChannelResultCodes(Set<VendorChannelResultCode> vendorChannelResultCodes) {
    this.vendorChannelResultCodes = vendorChannelResultCodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.BaseServiceVendor#setVendorId(java.lang.Long)
   */
  @Override public void setVendorId(Long vendorId) {
    this.vendorId = vendorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("ChannelVendor ( ").append(super.toString()).append(TAB).append("vendorId = ").append(this.vendorId)
      .append(TAB).append(
      " )");

    return retValue.toString();
  }

} // end class ChannelVendor
