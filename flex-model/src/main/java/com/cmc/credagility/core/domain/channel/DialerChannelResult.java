package com.cmc.credagility.core.domain.channel;

import java.util.Date;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.contact.ContactPhone;
import com.cmc.credagility.core.domain.mra.QueueExportRequest;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.ChannelResultStatus;


/**
 * This class is used to store manual call channel action information.
 *
 * <p><a href="DialerChannelResult.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 14:15
 */
@Entity
@Table(
  name    = "DialerChannelResult",
  indexes = {
    @Index(
      name = "createDateIndex",
      columnList = "createDate"
    ), @Index(
      name = "ruleBatchIdIndex",
      columnList = "ruleBatchId"
    ),
    @Index(
      name = "sourceIndex",
      columnList = "source"
    ),
    @Index(
      name = "statusIndex",
      columnList = "status"
    ),
    @Index(
      name = "strategyDateIndex",
      columnList = "strategyDate"
    ),
    @Index(
      name = "uniqueSessionIdIndex",
      columnList = "uniqueSessionId"
    )
  }
)
public class DialerChannelResult extends PhoneChannelResult {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1705004291521428508L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "dialerChannelResult",
    cascade  = CascadeType.ALL
  )
  @OrderBy("attemptStartTime asc")
  protected Set<DialerAudit> dialerAudits = new LinkedHashSet<DialerAudit>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "channelResult"
  )
  protected Set<DialerChannelResultDestination> dialerChannelResultDestination =
    new LinkedHashSet<DialerChannelResultDestination>();


  // npelleti, 07/30, USBank, Removed unique constraint
  /** Result Id, PK. */
  @Column(
    name     = "dialerResultId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long dialerResultId;


  /** dialer Status. */
  @Column(
    name   = "dialerStatus",
    length = 255
  )
  protected String dialerStatus;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "queueExportRequestId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected QueueExportRequest queueExportRequest;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "channelResult"
  )
  protected Set<DialerChannelResultVariableValue> variableValues =
    new LinkedHashSet<DialerChannelResultVariableValue>();


  /** Dialer Service Vendor. */
  @JoinColumn(
    name     = "vendorId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DialerServiceVendor vendor;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addDialerAudit.
   *
   * @param  dialerAudit  DialerAudit
   */
  public void addDialerAudit(DialerAudit dialerAudit) {
    dialerAudit.setDialerChannelResult(this);
    dialerAudits.add(dialerAudit);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    DialerChannelResult other = (DialerChannelResult) obj;

    if (vendor == null) {
      if (other.vendor != null) {
        return false;
      }
    } else if (!vendor.getVendorId().equals(other.vendor.getVendorId())) {
      return false;
    }

    if (ruleId == null) {
      if (other.ruleId != null) {
        return false;
      }
    } else if (!ruleId.equals(other.ruleId)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.AbstractChannelResult#getChannelVendor()
   */
  @Override public ChannelVendor getChannelVendor() {
    return channelVendor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The dialerAudit.
   *
   * @return  the dialerAudit
   *
   *          <p>column = "dialerResultId" xStreamConvert4EnterpriseTaskElements class =
   *          "com.cmc.credagility.DialerAudit"</p>
   *
   *          <p>lazy = "true" table = "DialerAudit" inverse = "true" cascade = "save-update" order-by =
   *          "attemptStartTime asc"</p>
   */
  public Set<DialerAudit> getDialerAudits() {
    return dialerAudits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dialer channel result destination.
   *
   * @return  Set
   */
  public Set<DialerChannelResultDestination> getDialerChannelResultDestination() {
    return dialerChannelResultDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The dialerResultId.
   *
   * @return  the dialerResultId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getDialerResultId() {
    return dialerResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dialer status.
   *
   * @return  String
   */
  public String getDialerStatus() {
    return dialerStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue export request.
   *
   * @return  QueueExportRequest
   */
  public QueueExportRequest getQueueExportRequest() {
    return queueExportRequest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.AbstractChannelResult#getResultId()
   */
  @Override public Long getResultId() {
    return this.dialerResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable values.
   *
   * @return  Set
   */
  public Set<DialerChannelResultVariableValue> getVariableValues() {
    return variableValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getVendor.
   *
   * @return  DialerServiceVendor
   *
   *          <p>column = "vendorId" not-null = "true" class = "com.cmc.credagility.DialerServiceVendor" insert = "true"
   *          update = "true" cascade = "save-update"</p>
   */
  public DialerServiceVendor getVendor() {
    return this.vendor;
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
      + ((vendor == null) ? 0 : vendor.getVendorId().hashCode());
    result = (prime * result)
      + ((channelVendor == null) ? 0 : channelVendor.getVendorId().hashCode());
    result = (prime * result)
      + ((ruleId == null) ? 0 : ruleId.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.AbstractChannelResult#setChannelVendor(com.cmc.credagility.core.domain.channel.ChannelVendor)
   */
  @Override public void setChannelVendor(ChannelVendor channelVendor) {
    this.channelVendor = channelVendor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dialer audits.
   *
   * @param  dialerAudit  Set
   */
  public void setDialerAudits(Set<DialerAudit> dialerAudit) {
    this.dialerAudits = dialerAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dialer channel result destination.
   *
   * @param  dialerChannelResultDestination  Set
   */
  public void setDialerChannelResultDestination(Set<DialerChannelResultDestination> dialerChannelResultDestination) {
    this.dialerChannelResultDestination = dialerChannelResultDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dialer result id.
   *
   * @param  dialerResultId  Long
   */
  public void setDialerResultId(Long dialerResultId) {
    this.dialerResultId = dialerResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dialer status.
   *
   * @param  dialerStatus  String
   */
  public void setDialerStatus(String dialerStatus) {
    this.dialerStatus = dialerStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue export request.
   *
   * @param  queueExportRequest  QueueExportRequest
   */
  public void setQueueExportRequest(QueueExportRequest queueExportRequest) {
    this.queueExportRequest = queueExportRequest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.AbstractChannelResult#setResultId(java.lang.Long)
   */
  @Override public void setResultId(Long resultId) {
    this.dialerResultId = resultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable values.
   *
   * @param  variableValues  Set
   */
  public void setVariableValues(Set<DialerChannelResultVariableValue> variableValues) {
    this.variableValues = variableValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor.
   *
   * @param  vendor  DialerServiceVendor
   */
  public void setVendor(DialerServiceVendor vendor) {
    this.vendor = vendor;
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

    retValue.append("DialerChannelResult ( ").append(super.toString()).append(
      TAB).append("vendor = ").append(this.vendor).append(TAB).append(
      "dialerResultId = ").append(this.dialerResultId).append(TAB).append(
      " )");

    return retValue.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateDialerChannelResult.
   *
   * @param  responsible   Responsible
   * @param  contactPhone  ContactPhone
   */
  public void updateDialerChannelResult(Responsible responsible, ContactPhone contactPhone) {
    Date now = new Date();
    this.responsible  = responsible;
    this.contactPhone = contactPhone;

    if (responsible != null) {
      this.account    = responsible.getAccount();
      this.balance    = responsible.getAccount().getBalance();
      this.currentDue = responsible.getAccount().getCurrentDue();
      this.pastDue    = responsible.getAccount().getPastDue();
    }

    if (contactPhone != null) {
      this.phoneNumber = contactPhone.getPhoneNum();
    }

    this.executeDate  = now;
    this.strategyDate = now;
    this.source       = "Manual";
    this.status       = ChannelResultStatus.SENT;
    this.template     = "";
  }
} // end class DialerChannelResult
