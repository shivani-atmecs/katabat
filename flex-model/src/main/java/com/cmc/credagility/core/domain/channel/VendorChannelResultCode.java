package com.cmc.credagility.core.domain.channel;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/14/2014 17:00
 */
@Entity
@Table(
  name              = "VendorChannelResultCode",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "code", "channelTypeId", "vendorId" }) }
)
public class VendorChannelResultCode extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "channelTypeId",
    nullable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected ChannelType channelType;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "vendorId",
    nullable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected ChannelVendor channelVendor;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "cmcChannelResultCodeId",
    nullable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected CMCChannelResultCode cmcChannelResultCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "code",
    length   = 255,
    nullable = false
  )
  protected String code;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "description",
    length = 255
  )
  protected String description;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "generateContactResult",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean generateContactResult;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "pk.vendorChannelResultCode"
  )
  protected Set<VendorChannelContactResult> vendorChannelContactResults = new HashSet<VendorChannelContactResult>();

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "vendorResultCodeId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long vendorResultCodeId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    VendorChannelResultCode that = (VendorChannelResultCode) o;

    if ((channelType != null) ? (!channelType.equals(that.channelType)) : (that.channelType != null)) {
      return false;
    }

    if ((channelVendor != null) ? (!channelVendor.equals(that.channelVendor)) : (that.channelVendor != null)) {
      return false;
    }

    if ((cmcChannelResultCode != null) ? (!cmcChannelResultCode.equals(that.cmcChannelResultCode))
                                       : (that.cmcChannelResultCode != null)) {
      return false;
    }

    if ((code != null) ? (!code.equals(that.code)) : (that.code != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((generateContactResult != null) ? (!generateContactResult.equals(that.generateContactResult))
                                        : (that.generateContactResult != null)) {
      return false;
    }

    if ((vendorResultCodeId != null) ? (!vendorResultCodeId.equals(that.vendorResultCodeId))
                                     : (that.vendorResultCodeId != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for channel vendor.
   *
   * @return  ChannelVendor
   */
  public ChannelVendor getChannelVendor() {
    return channelVendor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cmc channel result code.
   *
   * @return  CMCChannelResultCode
   */
  public CMCChannelResultCode getCmcChannelResultCode() {
    return cmcChannelResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for code.
   *
   * @return  String
   */
  public String getCode() {
    return code;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for generate contact result.
   *
   * @return  Boolean
   */
  public Boolean getGenerateContactResult() {
    if (generateContactResult == null) {
      return Boolean.FALSE;
    }

    return generateContactResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vendor channel contact results.
   *
   * @return  Set
   */
  public Set<VendorChannelContactResult> getVendorChannelContactResults() {
    return vendorChannelContactResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vendor result code id.
   *
   * @return  Long
   */
  public Long getVendorResultCodeId() {
    return vendorResultCodeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((channelType != null) ? channelType.hashCode() : 0);
    result = (31 * result) + ((channelVendor != null) ? channelVendor.hashCode() : 0);
    result = (31 * result) + ((cmcChannelResultCode != null) ? cmcChannelResultCode.hashCode() : 0);
    result = (31 * result) + ((code != null) ? code.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((generateContactResult != null) ? generateContactResult.hashCode() : 0);
    result = (31 * result) + ((vendorResultCodeId != null) ? vendorResultCodeId.hashCode() : 0);

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
   * setter method for channel vendor.
   *
   * @param  channelVendor  ChannelVendor
   */
  public void setChannelVendor(ChannelVendor channelVendor) {
    this.channelVendor = channelVendor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cmc channel result code.
   *
   * @param  cmcChannelResultCode  CMCChannelResultCode
   */
  public void setCmcChannelResultCode(
    CMCChannelResultCode cmcChannelResultCode) {
    this.cmcChannelResultCode = cmcChannelResultCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for code.
   *
   * @param  code  String
   */
  public void setCode(String code) {
    this.code = code;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for generate contact result.
   *
   * @param  generateContactResult  Boolean
   */
  public void setGenerateContactResult(Boolean generateContactResult) {
    this.generateContactResult = generateContactResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor channel contact results.
   *
   * @param  vendorChannelContactResults  Set
   */
  public void setVendorChannelContactResults(Set<VendorChannelContactResult> vendorChannelContactResults) {
    this.vendorChannelContactResults = vendorChannelContactResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor result code id.
   *
   * @param  vendorResultCodeId  Long
   */
  public void setVendorResultCodeId(Long vendorResultCodeId) {
    this.vendorResultCodeId = vendorResultCodeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("VendorChannelResultCode ( ").append(
      "vendorResultCodeId = ").append(this.vendorResultCodeId).append(TAB).append("code = ").append(this.code).append(
      TAB).append(
      "description = ").append(this.description).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class VendorChannelResultCode
