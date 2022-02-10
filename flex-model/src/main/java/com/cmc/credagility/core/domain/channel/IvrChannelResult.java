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
import javax.persistence.OrderBy;
import javax.persistence.Table;


/**
 * This class is used to store ivr channel action information.
 *
 * <p><a href="IvrChannelResult.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 11:20
 */
@Entity
@Table(
  name    = "IvrChannelResult",
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
public class IvrChannelResult extends PhoneChannelResult {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5776881652180392513L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** end time. */
  @Column(
    name   = "endTime",
    length = 255
  )
  protected String endTime;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "channelResult"
  )
  protected Set<IvrChannelResultDestination> ivrChannelResultDestination =
    new LinkedHashSet<IvrChannelResultDestination>();

  /** Result Id, PK. */
  @Column(
    name     = "ivrResultId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long ivrResultId;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "ivrChannelResult",
    cascade  = CascadeType.ALL
  )
  @OrderBy("attemptStartTime asc")
  protected Set<IvrOutboundAudit> outboundAudits = new LinkedHashSet<IvrOutboundAudit>();


  /** start time. */
  @Column(
    name   = "startTime",
    length = 255
  )
  protected String startTime;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "channelResult"
  )
  protected Set<IvrChannelResultVariableValue> variableValues = new LinkedHashSet<IvrChannelResultVariableValue>();


  /** Ivr Service Vendor! */
  @JoinColumn(
    name     = "vendorId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected IvrServiceVendor vendor;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addOutboundAudit.
   *
   * @param  ivrOutboundAudit  IvrOutboundAudit
   */
  public void addOutboundAudit(IvrOutboundAudit ivrOutboundAudit) {
    ivrOutboundAudit.setIvrChannelResult(this);
    outboundAudits.add(ivrOutboundAudit);
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

    IvrChannelResult other = (IvrChannelResult) obj;

    if (endTime == null) {
      if (other.endTime != null) {
        return false;
      }
    } else if (!endTime.equals(other.endTime)) {
      return false;
    }

    if (startTime == null) {
      if (other.startTime != null) {
        return false;
      }
    } else if (!startTime.equals(other.startTime)) {
      return false;
    }

    if (vendor == null) {
      if (other.vendor != null) {
        return false;
      }
    } else if (!vendor.getVendorId().equals(other.vendor.getVendorId())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end time.
   *
   * @return  String
   */
  public String getEndTime() {
    return endTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ivr channel result destination.
   *
   * @return  Set
   */
  public Set<IvrChannelResultDestination> getIvrChannelResultDestination() {
    return ivrChannelResultDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ivr result id.
   *
   * @return  Long
   */
  public Long getIvrResultId() {
    return ivrResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for outbound audits.
   *
   * @return  Set
   */
  public Set<IvrOutboundAudit> getOutboundAudits() {
    return this.outboundAudits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.AbstractChannelResult#getResultId()
   */
  @Override public Long getResultId() {
    return getIvrResultId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for start time.
   *
   * @return  String
   */
  public String getStartTime() {
    return startTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable values.
   *
   * @return  Set
   */
  public Set<IvrChannelResultVariableValue> getVariableValues() {
    return variableValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vendor.
   *
   * @return  IvrServiceVendor
   */
  public IvrServiceVendor getVendor() {
    return vendor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.PhoneChannelResult#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result) + ((endTime == null) ? 0 : endTime.hashCode());
    result = (prime * result) + ((startTime == null) ? 0 : startTime.hashCode());
    result = (prime * result)
      + ((vendor == null) ? 0 : vendor.getVendorId().hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end time.
   *
   * @param  endTime  String
   */
  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ivr channel result destination.
   *
   * @param  ivrChannelResultDestination  Set
   */
  public void setIvrChannelResultDestination(Set<IvrChannelResultDestination> ivrChannelResultDestination) {
    this.ivrChannelResultDestination = ivrChannelResultDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ivr result id.
   *
   * @param  ivrResultId  Long
   */
  public void setIvrResultId(Long ivrResultId) {
    this.ivrResultId = ivrResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for outbound audits.
   *
   * @param  outboundAudits  Set
   */
  public void setOutboundAudits(Set<IvrOutboundAudit> outboundAudits) {
    this.outboundAudits = outboundAudits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.AbstractChannelResult#setResultId(java.lang.Long)
   */
  @Override public void setResultId(Long resultId) {
    setIvrResultId(resultId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for start time.
   *
   * @param  startTime  String
   */
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable values.
   *
   * @param  variableValues  Set
   */
  public void setVariableValues(Set<IvrChannelResultVariableValue> variableValues) {
    this.variableValues = variableValues;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor.
   *
   * @param  vendor  IvrServiceVendor
   */
  public void setVendor(IvrServiceVendor vendor) {
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

    retValue.append("IvrChannelResult ( ").append(super.toString()).append(TAB).append("endTime = ").append(
      this.endTime).append(TAB).append(
      "ivrResultId = ").append(this.ivrResultId).append(TAB).append(
      "startTime = ").append(this.startTime).append(TAB).append(
      "vendor = ").append(this.vendor).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class IvrChannelResult
