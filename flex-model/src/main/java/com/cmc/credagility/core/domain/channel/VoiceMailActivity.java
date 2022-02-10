package com.cmc.credagility.core.domain.channel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.activity.AgentCallActivity;
import com.cmc.credagility.core.domain.activity.BaseActivity;
import com.cmc.credagility.core.domain.contact.ContactPhone;
import com.cmc.credagility.core.domain.type.CallType;
import com.cmc.credagility.core.domain.type.VoiceMailRecipient;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/14/2014 16:16
 */
@Entity
@Table(name = "VoiceMailActivity")
public class VoiceMailActivity extends BaseActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8182974555988627680L;

  /** activity type. */
  private static String CHANNEL = "VoiceMail";

  /** activity type. */
  private static String NAME = "VoiceMailActivity";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @OneToOne(mappedBy = "voiceMail")
  private AgentCallActivity agentCallActivity;

  @Column(
    name     = "callType",
    nullable = false,
    length   = 15
  )
  @Enumerated(EnumType.STRING)
  private CallType callType;

  @JoinColumn(
    name      = "phoneId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private ContactPhone contactPhone;

  /**
   * This field is for IVR outbound compaign. When we receive IVR return file from our vendor, we may find that the
   * vendor has left a voice mail to a particular phone number.
   */
  @OneToOne(mappedBy = "voiceMail")
  private IvrOutboundAudit ivrOutboundAudit;

  @Column(
    name   = "scriptId",
    length = 5
  )
  private String scriptId;

  @Column(name = "vmDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date     vmDate;
  @Column(
    name     = "vmId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long vmId;

  @Column(
    name     = "vmRecipient",
    nullable = false,
    length   = 9
  )
  @Enumerated(EnumType.STRING)
  private VoiceMailRecipient vmRecipient;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#equals(java.lang.Object)
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

    final VoiceMailActivity other = (VoiceMailActivity) obj;

    if (callType == null) {
      if (other.callType != null) {
        return false;
      }
    } else if (!callType.equals(other.callType)) {
      return false;
    }

    if (contactPhone == null) {
      if (other.contactPhone != null) {
        return false;
      }
    } else if (!contactPhone.equals(other.contactPhone)) {
      return false;
    }

    if (vmDate == null) {
      if (other.vmDate != null) {
        return false;
      }
    } else if (!vmDate.equals(other.vmDate)) {
      return false;
    }

    if (vmRecipient == null) {
      if (other.vmRecipient != null) {
        return false;
      }
    } else if (!vmRecipient.equals(other.vmRecipient)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * If this voice mail is left by IVR outbound compaign, then agentCallActivity should be null.
   *
   * @return  if this voice mail is left by IVR outbound compaign, then agentCallActivity should be null.
   *
   *          <p>property-ref = "voiceMail" class = "com.cmc.credagility.AgentCallActivity"</p>
   */
  public AgentCallActivity getAgentCallActivity() {
    return agentCallActivity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call type.
   *
   * @return  CallType
   */
  public CallType getCallType() {
    return callType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel.
   *
   * @return  String
   */
  @Override public String getChannel() {
    return CHANNEL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact phone.
   *
   * @return  ContactPhone
   */
  public ContactPhone getContactPhone() {
    return contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ivr outbound audit.
   *
   * @return  IvrOutboundAudit
   */
  public IvrOutboundAudit getIvrOutboundAudit() {
    return ivrOutboundAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  @Override public String getName() {
    return NAME;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for script id.
   *
   * @return  String
   */
  public String getScriptId() {
    return scriptId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vm date.
   *
   * @return  Date
   */
  public Date getVmDate() {
    return vmDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vm id.
   *
   * @return  Long
   */
  public Long getVmId() {
    return vmId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for vm recipient.
   *
   * @return  VoiceMailRecipient
   */
  public VoiceMailRecipient getVmRecipient() {
    return vmRecipient;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result) + ((callType == null) ? 0 : callType.hashCode());
    result = (prime * result)
      + ((contactPhone == null) ? 0 : contactPhone.hashCode());
    result = (prime * result) + ((vmDate == null) ? 0 : vmDate.hashCode());
    result = (prime * result)
      + ((vmRecipient == null) ? 0 : vmRecipient.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent call activity.
   *
   * @param  agentCallActivity  AgentCallActivity
   */
  public void setAgentCallActivity(AgentCallActivity agentCallActivity) {
    this.agentCallActivity = agentCallActivity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call type.
   *
   * @param  callType  CallType
   */
  public void setCallType(CallType callType) {
    this.callType = callType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact phone.
   *
   * @param  contactPhone  ContactPhone
   */
  public void setContactPhone(ContactPhone contactPhone) {
    this.contactPhone = contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ivr outbound audit.
   *
   * @param  ivrOutboundAudit  IvrOutboundAudit
   */
  public void setIvrOutboundAudit(IvrOutboundAudit ivrOutboundAudit) {
    this.ivrOutboundAudit = ivrOutboundAudit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for script id.
   *
   * @param  scriptId  String
   */
  public void setScriptId(String scriptId) {
    this.scriptId = scriptId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vm date.
   *
   * @param  vmDate  Date
   */
  public void setVmDate(Date vmDate) {
    this.vmDate = vmDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vm id.
   *
   * @param  vmId  Long
   */
  public void setVmId(Long vmId) {
    this.vmId = vmId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vm recipient.
   *
   * @param  vmRecipient  VoiceMailRecipient
   */
  public void setVmRecipient(VoiceMailRecipient vmRecipient) {
    this.vmRecipient = vmRecipient;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vm type.
   *
   * @param  vmType  CallType
   */
  public void setVmType(CallType vmType) {
    this.callType = callType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "VoiceMailActivity ( " + super.toString() + TAB + "vmId = "
      + this.vmId + TAB + "phone = " + this.contactPhone + TAB
      + "callType = " + this.callType + TAB + "vmRecipient = "
      + this.vmRecipient + TAB + "vmDate = " + this.vmDate + TAB
      + "scriptId = " + this.scriptId + TAB + "agentCallActivity = "
      + this.agentCallActivity + TAB + " )";

    return retValue;
  }

} // end class VoiceMailActivity
