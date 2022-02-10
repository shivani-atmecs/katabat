package com.cmc.credagility.core.domain.channel;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.contact.ContactResult;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/14/2014 17:05
 */
@AssociationOverrides(
  {
    @AssociationOverride(
      name = "pk.vendorChannelResultCode",
      joinColumns = @JoinColumn(name = "vendorResultCodeId")
    ),
    @AssociationOverride(
      name = "pk.contactResult",
      joinColumns = @JoinColumn(name = "contactResultId")
    )
  }
)
@Entity
@Table(name = "VendorChannelContactResult")
public class VendorChannelContactResult implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6205764491140939408L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(
    name     = "campaignType",
    nullable = true,
    length   = 255
  )
  private String                           campaignType;
  @Id private VendorChannelContactResultId pk = new VendorChannelContactResultId();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new VendorChannelContactResult object.
   */
  public VendorChannelContactResult() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    VendorChannelContactResult that = (VendorChannelContactResult) o;

    if ((campaignType != null) ? (!campaignType.equals(that.campaignType)) : (that.campaignType != null)) {
      return false;
    }

    if ((pk != null) ? (!pk.equals(that.pk)) : (that.pk != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for campaign type.
   *
   * @return  String
   */
  public String getCampaignType() {
    return campaignType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact result.
   *
   * @return  ContactResult
   */
  @Transient public ContactResult getContactResult() {
    return getPk().getContactResult();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pk.
   *
   * @return  VendorChannelContactResultId
   */
  public VendorChannelContactResultId getPk() {
    return pk;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vendor channel result code.
   *
   * @return  VendorChannelResultCode
   */
  @Transient public VendorChannelResultCode getVendorChannelResultCode() {
    return getPk().getVendorChannelResultCode();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = (campaignType != null) ? campaignType.hashCode() : 0;
    result = (31 * result) + ((pk != null) ? pk.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for campaign type.
   *
   * @param  campaignType  String
   */
  public void setCampaignType(String campaignType) {
    this.campaignType = campaignType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact result.
   *
   * @param  contactResult  ContactResult
   */
  public void setContactResult(ContactResult contactResult) {
    getPk().setContactResult(contactResult);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pk.
   *
   * @param  pk  VendorChannelContactResultId
   */
  public void setPk(VendorChannelContactResultId pk) {
    this.pk = pk;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor channel result code.
   *
   * @param  vendorChannelResultCode  VendorChannelResultCode
   */
  public void setVendorChannelResultCode(VendorChannelResultCode vendorChannelResultCode) {
    getPk().setVendorChannelResultCode(vendorChannelResultCode);
  }

  //~ Inner Classes ----------------------------------------------------------------------------------------------------

  @Embeddable public static class VendorChannelContactResultId implements Serializable {
    //~ Static fields/initializers -------------------------------------------------------------------------------------

    private static final long serialVersionUID = 3840639908224762631L;

    //~ Instance fields ------------------------------------------------------------------------------------------------

    @JoinColumn(name = "contactResultId")
    @ManyToOne private ContactResult contactResult;

    @JoinColumn(name = "vendorResultCodeId")
    @ManyToOne private VendorChannelResultCode vendorChannelResultCode;

    //~ Methods --------------------------------------------------------------------------------------------------------

    @Override public boolean equals(Object o) {
      if (this == o) {
        return true;
      }

      if ((o == null) || (getClass() != o.getClass())) {
        return false;
      }

      VendorChannelContactResultId that = (VendorChannelContactResultId) o;

      if ((contactResult != null) ? (!contactResult.equals(that.contactResult)) : (that.contactResult != null)) {
        return false;
      }

      if ((vendorChannelResultCode != null) ? (!vendorChannelResultCode.equals(that.vendorChannelResultCode))
                                            : (that.vendorChannelResultCode != null)) {
        return false;
      }

      return true;
    }

    //~ ----------------------------------------------------------------------------------------------------------------

    public ContactResult getContactResult() {
      return contactResult;
    }

    //~ ----------------------------------------------------------------------------------------------------------------

    public VendorChannelResultCode getVendorChannelResultCode() {
      return vendorChannelResultCode;
    }

    //~ ----------------------------------------------------------------------------------------------------------------

    @Override public int hashCode() {
      int result = (contactResult != null) ? contactResult.hashCode() : 0;
      result = (31 * result) + ((vendorChannelResultCode != null) ? vendorChannelResultCode.hashCode() : 0);

      return result;
    }

    //~ ----------------------------------------------------------------------------------------------------------------

    public void setContactResult(ContactResult contactResult) {
      this.contactResult = contactResult;
    }

    //~ ----------------------------------------------------------------------------------------------------------------

    public void setVendorChannelResultCode(VendorChannelResultCode vendorChannelResultCode) {
      this.vendorChannelResultCode = vendorChannelResultCode;
    }
  } // end class VendorChannelContactResultId
} // end class VendorChannelContactResult
