package com.cmc.credagility.core.domain.contact;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.channel.VendorChannelContactResult;
import com.cmc.credagility.core.domain.portfolio.PortfolioAgentDispositionCode;


/**
 * This class is used to store ContactResult information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 11:21
 */
@Entity
@Table(name = "ContactResult")
public class ContactResult extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Portfolio agent disposition code. Refers {@link PortfolioAgentDispositionCode} */
  @JoinTable(
    name               = "ContactResultDispositionCode",
    indexes            = { @Index(columnList = "contactResultId") },
    joinColumns        = {
      @JoinColumn(
        name           = "contactResultId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "dispositionCodeId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.EAGER,
    cascade = CascadeType.ALL
  )
  protected Set<PortfolioAgentDispositionCode> dispositionCodes = new HashSet<PortfolioAgentDispositionCode>();


  /** Vendor channel contact result. Refers {@link VendorChannelContactResult} */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "pk.contactResult"
  )
  protected Set<VendorChannelContactResult> vendorChannelContactResults = new HashSet<VendorChannelContactResult>();

  @Column(length = 10) // eg: 'RPC'
  private String contactResult;

  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long contactResultId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof ContactResult)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    ContactResult that = (ContactResult) o;

    if ((contactResult != null) ? (!contactResult.equals(that.contactResult)) : (that.contactResult != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact result.
   *
   * @return  String
   */
  public String getContactResult() {
    return contactResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact result id.
   *
   * @return  Long
   */
  public Long getContactResultId() {
    return contactResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disposition codes.
   *
   * @return  Set
   */
  public Set<PortfolioAgentDispositionCode> getDispositionCodes() {
    return dispositionCodes;
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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((contactResult != null) ? contactResult.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact result.
   *
   * @param  contactResult  String
   */
  public void setContactResult(String contactResult) {
    this.contactResult = contactResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact result id.
   *
   * @param  contactResultId  Long
   */
  public void setContactResultId(Long contactResultId) {
    this.contactResultId = contactResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disposition codes.
   *
   * @param  dispositionCodes  Set
   */
  public void setDispositionCodes(Set<PortfolioAgentDispositionCode> dispositionCodes) {
    this.dispositionCodes = dispositionCodes;
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
   * update.
   *
   * @param   contactResult  ContactResult
   *
   * @return  ContactResult
   */
  public ContactResult update(ContactResult contactResult) {
    this.contactResult  = contactResult.getContactResult();
    this.lastUpdateDate = contactResult.getLastUpdateDate();

    return this; // To change body of created methods use File | Settings | File Templates.
  }
} // end class ContactResult
