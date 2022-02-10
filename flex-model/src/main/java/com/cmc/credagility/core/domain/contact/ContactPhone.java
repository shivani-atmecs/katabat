package com.cmc.credagility.core.domain.contact;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.channel.DialerAudit;
import com.cmc.credagility.core.domain.channel.VoiceMailActivity;
import com.cmc.credagility.core.domain.customer.CustomerContactPhone;
import com.cmc.credagility.core.domain.disposition.CallType;
import com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit;
import com.cmc.credagility.core.domain.type.ContactChannel;
import com.cmc.credagility.core.domain.type.ContactChannelType;
import com.cmc.credagility.core.domain.type.ExpressConsentType;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store responsible phone contact.
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/14/2014 17:38
 */
@Entity
@Table(
  name    = "ContactPhone",
  indexes = {
    @Index(
      name = "historicalIndex",
      columnList = "historical"
    ),
    @Index(
      name = "optOutIndex",
      columnList = "optOut"
    ),
    @Index(
      name = "phoneNumIndex",
      columnList = "phoneNum"
    )
  }
)
public class ContactPhone extends BaseContactPhone {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 539603936721010931L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Agent call this phone count. */
  @Column(name = "agentCallCount")
  protected Integer agentCallCount;


  /** Agent talk to this phone count. */
  @Column(name = "agentTalkCount")
  protected Integer agentTalkCount;


  /** Agent call this phone by answer machine count. */
  @Column(name = "answerMachineCount")
  protected Integer answerMachineCount;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "bureauPhoneSource",
    length = 20
  )
  protected String bureauPhoneSource;

  /** TODO: DOCUMENT ME! */
  @Column(name = "bureauUpdatedDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date bureauUpdatedDate;


  /** Call type, Refers {@link CallType}. */
  @JoinColumn(
    name       = "callTypeId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected CallType callType;


  /** Client phone update date. */
  @Column(name = "clientPhoneUpdateDate")
  @Temporal(TemporalType.DATE)
  protected Date clientPhoneUpdateDate;

  /** Agent call this phone by dialer count. */
  @Column(name = "dialerAgentTalkCount")
  protected Integer dialerAgentTalkCount;


  /** Agent call this phone by dialer answer machine count. */
  @Column(name = "dialerAnswerMachineCount")
  protected Integer dialerAnswerMachineCount;


  /** Dialer audit, Refers {@link DialerAudit}. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "contactPhone",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("createDate desc")
  protected Set<DialerAudit> dialerAudits = new LinkedHashSet<DialerAudit>();

  /** Dialer count. */
  @Column(name = "dialerCount")
  protected Integer dialerCount;


  /** Express consent SMS type, Refers {@link ExpressConsentType}. */
  @Column(
    name     = "expressConsentSMS",
    nullable = true,
    length   = 5
  )
  @Enumerated(EnumType.STRING)
  protected ExpressConsentType expressConsentSMS;


  /** Express consent voice type, Refers {@link ExpressConsentType}. */
  @Column(
    name     = "expressConsentVoice",
    nullable = true,
    length   = 5
  )
  @Enumerated(EnumType.STRING)
  protected ExpressConsentType expressConsentVoice;


  /** The extension number. */
  @Column(
    name   = "extension",
    length = 20
  )
  protected String extension;


  /** If this phone cannot use. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isBadNumber;


  /** If this phone is the mobile phone. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isMobile;


  /** Connected count. */
  @Column(name = "ivrCount")
  protected Integer ivrCount;


  /** Last update the express consent type SMS agent, Refers {@link User}. */
  @JoinColumn(
    name       = "lastExpressConsentSMSAgentId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected User lastExpressConsentSMSAgent;


  /** Last update the express consent type SMS date. */
  @Column(name = "lastExpressConsentSMSUpdateDate")
  protected Date lastExpressConsentSMSUpdateDate;


  /** Last update the express consent type voice agent, Refers {@link User}. */
  @JoinColumn(
    name       = "lastExpressConsentVoiceAgentId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected User lastExpressConsentVoiceAgent;


  /** Last update the express consent type voice date. */
  @Column(name = "lastExpressConsentVoiceUpdateDate")
  protected Date lastExpressConsentVoiceUpdateDate;


  /** These values will be set by NANPA service for compliance purpose. */
  @Column(
    name   = "phoneCity",
    length = 50
  )
  protected String phoneCity;

  /** Phone contact PK phoneId. */
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long         phoneId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "phoneIndicator",
    length = 20
  )
  protected String phoneIndicator;

  /** Phone number. */
  @Column(
    name     = "phoneNum",
    length   = 20,
    nullable = false
  )
  protected String phoneNum;

  /** These values will be set by NANPA service for compliance purpose. */
  @Column(
    name   = "phoneState",
    length = 2
  )
  protected String phoneState;

  /** Phone type. Refers {@link PhoneType} */
  @JoinColumn(
    name       = "typeId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected PhoneType phoneType = new PhoneType();


  /** Send sms to this phone count. */
  @Column(name = "smsCount")
  protected Integer smsCount;


  /** Voice mail activity of this phone, Refers {@link VoiceMailActivity}. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "contactPhone",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("vmDate asc")
  protected Set<VoiceMailActivity> voiceMailActivities = new LinkedHashSet<VoiceMailActivity>();
  @Transient private String        countryCode;

  @Transient private Long disclosure;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addVoiceMailActivity.
   *
   * @param   vma  VoiceMailActivity
   *
   * @return  boolean
   */
  public boolean addVoiceMailActivity(VoiceMailActivity vma) {
    if (vma == null) {
      return false;
    }

    return this.voiceMailActivities.add(vma);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * businessEquals.
   *
   * @param   obj  Object
   *
   * @return  boolean
   */
  public boolean businessEquals(Object obj) {
    // this is a temporary variable to hold phoneNum after removing all special chars like '-', '(' , ')' and ' '.
    String tempNum = null;
    String tempExt = null;

    if (obj == null) {
      return !StringUtils.hasText(this.phoneNum);
    }

    final ContactPhone other = (ContactPhone) obj;

    if (StringUtils.hasText(this.phoneNum)) {
      tempNum = Pattern.compile("\\(?\\-?\\)?\\ ?").matcher(this.phoneNum).replaceAll("");
    }

    if (StringUtils.hasText(phoneNum)
          ^ StringUtils.hasText(other.getPhoneNum())) {
      return false;
    } else if ((tempNum != null) && !tempNum.equals(other.getPhoneNum())) {
      return false;
    }

    if (StringUtils.hasText(extension)) {
      tempExt = Pattern.compile("\\(?\\-?\\)?\\ ?").matcher(this.extension).replaceAll("");
    }

    if (StringUtils.hasText(extension)
          ^ StringUtils.hasText(other.getExtension())) {
      return false;
    } else if ((tempExt != null) && !tempExt.equals(other.getExtension())) {
      return false;
    }

    if (StringUtils.hasText(countryCode)
          ^ StringUtils.hasText(other.getCountryCode())) {
      return false;
    } else if ((countryCode != null) && !countryCode.equals(other.getCountryCode())) {
      return false;
    }

    if (phoneType == null) {
      if (other.getPhoneType() != null) {
        return false;
      }
    } else if (!phoneType.equals(other.getPhoneType())) {
      return false;
    }

    return true;
  } // end method businessEquals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  phone  ContactPhone
   */
  public void deepCopy(ContactPhone phone) {
    if (phone != null) {
      super.deepCopy(phone);
      this.phoneNum             = phone.getPhoneNum();
      this.extension            = phone.getExtension();
      this.telephoneCountryCode = phone.getTelephoneCountryCode();
      this.setCountryCode(phone.getCountryCode());
      this.setExpressConsentVoice(phone.getExpressConsentVoice());
      this.setLastExpressConsentVoiceAgent(phone.getLastExpressConsentVoiceAgent());
      this.setLastExpressConsentVoiceUpdateDate(phone.getLastExpressConsentVoiceUpdateDate());
      this.setExpressConsentSMS(phone.getExpressConsentSMS());
      this.setLastExpressConsentSMSAgent(phone.getLastExpressConsentSMSAgent());
      this.setLastExpressConsentSMSUpdateDate(phone.getLastExpressConsentSMSUpdateDate());
      this.setBadNumber(phone.getBadNumber());
      this.setIsMobile(phone.getIsMobile());
      this.setCallType(phone.getCallType());
      this.setBureauPhoneSource(phone.getBureauPhoneSource());
      this.setBureauUpdatedDate(phone.getBureauUpdatedDate());
      this.phoneType.deepCopy(phone.getPhoneType());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  phone  CustomerContactPhone
   */
  public void deepCopy(CustomerContactPhone phone) {
    if (phone != null) {
      super.deepCopy(phone);
      this.phoneNum  = phone.getPhoneNum();
      this.extension = phone.getExtension();
      this.setExpressConsentVoice(phone.getExpressConsentVoice());
      this.setLastExpressConsentVoiceAgent(phone.getLastExpressConsentVoiceAgent());
      this.setLastExpressConsentVoiceUpdateDate(phone.getLastExpressConsentVoiceUpdateDate());
      this.setExpressConsentSMS(phone.getExpressConsentSMS());
      this.setLastExpressConsentSMSAgent(phone.getLastExpressConsentSMSAgent());
      this.setLastExpressConsentSMSUpdateDate(phone.getLastExpressConsentSMSUpdateDate());
      this.setBadNumber(phone.getBadNumber());
      this.setIsMobile(phone.getIsMobile());
      this.setCallType(phone.getCallType());
      this.setBureauPhoneSource(phone.getBureauPhoneSource());
      this.setBureauUpdatedDate(phone.getBureauUpdatedDate());
      this.phoneType.deepCopy(phone.getPhoneType());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add phoneType so that we allow different phone type has the same phone number.
   *
   * @param   obj  DOCUMENT ME!
   *
   * @return  add phoneType so that we allow different phone type has the same phone number.
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

    final ContactPhone other = (ContactPhone) obj;

    if (phoneNum == null) {
      if (other.getPhoneNum() != null) {
        return false;
      }
    } else if (!phoneNum.equals(other.getPhoneNum())) {
      return false;
    }

    if (extension == null) {
      if (other.getExtension() != null) {
        return false;
      }
    } else if (!extension.equals(other.getExtension())) {
      return false;
    }

    if (telephoneCountryCode == null) {
      if (other.getTelephoneCountryCode() != null) {
        return false;
      }
    } else if (!telephoneCountryCode.equals(other.getExtension())) {
      return false;
    }

    if (phoneType == null) {
      if (other.getPhoneType() != null) {
        return false;
      }
    } else if (!phoneType.equals(other.getPhoneType())) {
      return false;
    }

    Long callTypeId      = 0L;
    Long otherCallTypeId = 0L;

    if (callType != null) {
      callTypeId = callType.getId();
    }

    if (other.getCallType() != null) {
      otherCallTypeId = other.getCallType().getId();
    }

    if (callTypeId != otherCallTypeId) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent call count.
   *
   * @return  Integer
   */
  public Integer getAgentCallCount() {
    return agentCallCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent talk count.
   *
   * @return  Integer
   */
  public Integer getAgentTalkCount() {
    return agentTalkCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer machine count.
   *
   * @return  Integer
   */
  public Integer getAnswerMachineCount() {
    return answerMachineCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for area code.
   *
   * @param   startIndex  int
   * @param   endIndex    int
   *
   * @return  String
   */
  public String getAreaCode(int startIndex, int endIndex) {
    if (phoneNum == null) {
      return null;
    } else if (phoneNum.length() >= endIndex) {
      return phoneNum.substring(startIndex, endIndex);
    } else {
      return phoneNum;
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bad number.
   *
   * @return  Boolean
   */
  @Override public Boolean getBadNumber() {
    return isBadNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau phone source.
   *
   * @return  String
   */
  public String getBureauPhoneSource() {
    return bureauPhoneSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau updated date.
   *
   * @return  Date
   */
  public Date getBureauUpdatedDate() {
    return bureauUpdatedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call type.
   *
   * @return  CallType
   */
  @Override public CallType getCallType() {
    return callType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client phone update date.
   *
   * @return  Date
   */
  public Date getClientPhoneUpdateDate() {
    return clientPhoneUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact channel.
   *
   * @return  ContactChannel
   */
  @Override public ContactChannel getContactChannel() {
    return ContactChannel.toContactChannel(getPhoneType().getTypeId(),
        ContactChannelType.PHONE);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for country code.
   *
   * @return  String
   */
  @Override public String getCountryCode() {
    return countryCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dialer agent talk count.
   *
   * @return  Integer
   */
  public Integer getDialerAgentTalkCount() {
    return dialerAgentTalkCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dialer answer machine count.
   *
   * @return  Integer
   */
  public Integer getDialerAnswerMachineCount() {
    return dialerAnswerMachineCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dialer audits.
   *
   * @return  Set
   */
  public Set<DialerAudit> getDialerAudits() {
    return dialerAudits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dialer count.
   *
   * @return  Integer
   */
  public Integer getDialerCount() {
    return dialerCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disclosure.
   *
   * @return  Long
   */
  public Long getDisclosure() {
    return disclosure;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for express consent SMS.
   *
   * @return  ExpressConsentType
   */
  @Override public ExpressConsentType getExpressConsentSMS() {
    if (ExpressConsentType.YES.equals(expressConsentSMS)) {
      return ExpressConsentType.YES;
    } else if (ExpressConsentType.NO.equals(expressConsentSMS)) {
      return ExpressConsentType.NO;
    } else {
      return ExpressConsentType.NA;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for express consent voice.
   *
   * @return  ExpressConsentType
   */
  @Override public ExpressConsentType getExpressConsentVoice() {
    if (ExpressConsentType.YES.equals(expressConsentVoice)) {
      return ExpressConsentType.YES;
    } else if (ExpressConsentType.NO.equals(expressConsentVoice)) {
      return ExpressConsentType.NO;
    } else {
      return ExpressConsentType.NA;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for extension.
   *
   * @return  String
   */
  @Override public String getExtension() {
    return extension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is mobile.
   *
   * @return  Boolean
   */
  @Override public Boolean getIsMobile() {
    return isMobile;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ivr count.
   *
   * @return  Integer
   */
  public Integer getIvrCount() {
    return ivrCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last express consent SMSAgent.
   *
   * @return  User
   */
  @Override public User getLastExpressConsentSMSAgent() {
    return lastExpressConsentSMSAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last express consent SMSUpdate date.
   *
   * @return  Date
   */
  @Override public Date getLastExpressConsentSMSUpdateDate() {
    return lastExpressConsentSMSUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last express consent voice agent.
   *
   * @return  User
   */
  @Override public User getLastExpressConsentVoiceAgent() {
    return lastExpressConsentVoiceAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last express consent voice update date.
   *
   * @return  Date
   */
  @Override public Date getLastExpressConsentVoiceUpdateDate() {
    return lastExpressConsentVoiceUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mobile.
   *
   * @return  Boolean
   */
  public Boolean getMobile() {
    return isMobile;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone city.
   *
   * @return  String
   */
  public String getPhoneCity() {
    return phoneCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone id.
   *
   * @return  Long
   */
  public Long getPhoneId() {
    return phoneId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone indicator.
   *
   * @return  String
   */
  public String getPhoneIndicator() {
    return phoneIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone num.
   *
   * @return  String
   */
  @Override public String getPhoneNum() {
    return phoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone num last3.
   *
   * @return  String
   */
  public String getPhoneNumLast3() {
    if (StringUtils.hasText(this.phoneNum)) {
      return (this.phoneNum.length() > 3) ? this.phoneNum.substring(this.phoneNum.length() - 3,
          this.phoneNum.length()) : this.phoneNum;
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone state.
   *
   * @return  String
   */
  public String getPhoneState() {
    return phoneState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone type.
   *
   * @return  PhoneType
   */
  @Override public PhoneType getPhoneType() {
    return this.phoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sms count.
   *
   * @return  Integer
   */
  public Integer getSmsCount() {
    return smsCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This is the phone type code as used in internationalization. Internationalization purpose only.
   *
   * <p>Examples: PhoneType1</p>
   *
   * @return  this is the phone type code as used in internationalization.
   */
  public String getType() {
    return this.phoneType.getTypeCode();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for voice mail activities.
   *
   * @return  Set
   */
  public Set<VoiceMailActivity> getVoiceMailActivities() {
    return voiceMailActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for voice mail count.
   *
   * @return  Integer
   */
  public Integer getVoiceMailCount() {
    if (voiceMailActivities == null) {
      return new Integer(0);
    }

    return voiceMailActivities.size();
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
    result = (prime * result) + ((phoneNum == null) ? 0 : phoneNum.hashCode());
    result = (prime * result) + ((phoneType == null) ? 0 : phoneType.hashCode());
    result = (prime * result) + ((extension == null) ? 0 : extension.hashCode());
    result = (prime * result) + ((telephoneCountryCode == null) ? 0 : telephoneCountryCode.hashCode());
    result = (prime * result) + ((phoneType == null) ? 0 : phoneType.hashCode());
    result = (prime * result) + ((callType == null) ? 0 : callType.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Increase agent call count.
   */
  public void increaseAgentCallCount() {
    if ((agentCallCount == null) || (agentCallCount < 0)) {
      agentCallCount = 0;
    }

    agentCallCount++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Increase Agent talk count.
   */
  public void increaseAgentTalkCount() {
    if ((agentTalkCount == null) || (agentTalkCount < 0)) {
      agentTalkCount = 0;
    }

    agentTalkCount++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Increase answer machine call count.
   */
  public void increaseAnswerMachineCount() {
    if ((answerMachineCount == null) || (answerMachineCount < 0)) {
      answerMachineCount = 0;
    }

    answerMachineCount++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Increase dialer agent call count.
   */
  public void increaseDialerAgentCallCount() {
    if ((dialerAgentTalkCount == null) || (dialerAgentTalkCount < 0)) {
      dialerAgentTalkCount = 0;
    }

    dialerAgentTalkCount++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Increase dialer answer machine call count.
   */
  public void increaseDialerAnswerMachineCount() {
    if ((dialerAnswerMachineCount == null) || (dialerAnswerMachineCount < 0)) {
      dialerAnswerMachineCount = 0;
    }

    dialerAnswerMachineCount++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Increase dialer call count.
   */
  public void increaseDialerCount() {
    if ((dialerCount == null) || (dialerCount < 0)) {
      dialerCount = 0;
    }

    dialerCount++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Increase Ivr call count.
   */
  public void increaseIvrCount() {
    if ((ivrCount == null) || (ivrCount < 0)) {
      ivrCount = 0;
    }

    ivrCount++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Increase sms count.
   */
  public void increaseSmsCount() {
    if ((smsCount == null) || (smsCount < 0)) {
      smsCount = 0;
    }

    smsCount++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether the phone number is valid.
   *
   * @return  check whether the phone number is valid.
   */
  public boolean isValidNumber() {
    try {
      if (StringUtils.hasText(phoneNum)) {
        if (Long.parseLong(phoneNum) > 0) {
          if (phoneNum.matches("0+|9+")) {
            // all 0/9 consider not valid number
            return false;
          }

          return true;
        }
      }
    } catch (Exception e) { }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * resetNextEligibleCallDateConditional.
   */
  public void resetNextEligibleCallDateConditional() {
    this.nextEligibleCallDate      = null;
    this.appliedContactResultLimit = null;
    this.appliedPhoneTypeDelay     = null;
    this.appliedPhoneTypeLimit     = null;
    this.rpcAudit                  = null;
    this.phoneNumberAttemptAudit   = null;
    this.connectAudit              = null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent call count.
   *
   * @param  agentCallCount  Integer
   */
  public void setAgentCallCount(Integer agentCallCount) {
    this.agentCallCount = agentCallCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent talk count.
   *
   * @param  agentTalkCount  Integer
   */
  public void setAgentTalkCount(Integer agentTalkCount) {
    this.agentTalkCount = agentTalkCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for answer machine count.
   *
   * @param  answerMachineCount  Integer
   */
  public void setAnswerMachineCount(Integer answerMachineCount) {
    this.answerMachineCount = answerMachineCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bad number.
   *
   * @param  badNumber  Boolean
   */
  @Override public void setBadNumber(Boolean badNumber) {
    isBadNumber = badNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bureau phone source.
   *
   * @param  bureauPhoneSource  String
   */
  public void setBureauPhoneSource(String bureauPhoneSource) {
    this.bureauPhoneSource = bureauPhoneSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bureau updated date.
   *
   * @param  bureauUpdatedDate  Date
   */
  public void setBureauUpdatedDate(Date bureauUpdatedDate) {
    this.bureauUpdatedDate = bureauUpdatedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call type.
   *
   * @param  callType  CallType
   */
  @Override public void setCallType(CallType callType) {
    this.callType = callType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client phone update date.
   *
   * @param  clientPhoneUpdateDate  Date
   */
  public void setClientPhoneUpdateDate(Date clientPhoneUpdateDate) {
    this.clientPhoneUpdateDate = clientPhoneUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for country code.
   *
   * @param  countryCode  String
   */
  @Override public void setCountryCode(String countryCode) {
    if ((countryCode != null) && countryCode.contains(",")) {
      String[] codes = countryCode.split(",");
      this.countryCode = codes[1];

    } else {
      this.countryCode = countryCode;
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dialer agent talk count.
   *
   * @param  dialerAgentTalkCount  Integer
   */
  public void setDialerAgentTalkCount(Integer dialerAgentTalkCount) {
    this.dialerAgentTalkCount = dialerAgentTalkCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dialer answer machine count.
   *
   * @param  dialerAnswerMachineCount  Integer
   */
  public void setDialerAnswerMachineCount(Integer dialerAnswerMachineCount) {
    this.dialerAnswerMachineCount = dialerAnswerMachineCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dialer audits.
   *
   * @param  dialerAudits  Set
   */
  public void setDialerAudits(Set<DialerAudit> dialerAudits) {
    this.dialerAudits = dialerAudits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dialer count.
   *
   * @param  dialerCount  Integer
   */
  public void setDialerCount(Integer dialerCount) {
    this.dialerCount = dialerCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disclosure.
   *
   * @param  disclosure  Long
   */
  public void setDisclosure(Long disclosure) {
    this.disclosure = disclosure;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for express consent SMS.
   *
   * @param  expressConsentSMS  ExpressConsentType
   */
  @Override public void setExpressConsentSMS(ExpressConsentType expressConsentSMS) {
    this.expressConsentSMS = expressConsentSMS;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for express consent voice.
   *
   * @param  expressConsentVoice  ExpressConsentType
   */
  @Override public void setExpressConsentVoice(ExpressConsentType expressConsentVoice) {
    this.expressConsentVoice = expressConsentVoice;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for extension.
   *
   * @param  extension  String
   */
  @Override public void setExtension(String extension) {
    this.extension = extension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for is mobile.
   *
   * @param  isMobile  Boolean
   */
  @Override public void setIsMobile(Boolean isMobile) {
    this.isMobile = isMobile;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ivr count.
   *
   * @param  ivrCount  Integer
   */
  public void setIvrCount(Integer ivrCount) {
    this.ivrCount = ivrCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last express consent SMSAgent.
   *
   * @param  lastExpressConsentSMSAgent  User
   */
  @Override public void setLastExpressConsentSMSAgent(User lastExpressConsentSMSAgent) {
    this.lastExpressConsentSMSAgent = lastExpressConsentSMSAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last express consent SMSUpdate date.
   *
   * @param  lastExpressConsentSMSUpdateDate  Date
   */
  @Override public void setLastExpressConsentSMSUpdateDate(Date lastExpressConsentSMSUpdateDate) {
    this.lastExpressConsentSMSUpdateDate = lastExpressConsentSMSUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last express consent voice agent.
   *
   * @param  lastExpressConsentVoiceAgent  User
   */
  @Override public void setLastExpressConsentVoiceAgent(User lastExpressConsentVoiceAgent) {
    this.lastExpressConsentVoiceAgent = lastExpressConsentVoiceAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last express consent voice update date.
   *
   * @param  lastExpressConsentVoiceUpdateDate  Date
   */
  @Override public void setLastExpressConsentVoiceUpdateDate(Date lastExpressConsentVoiceUpdateDate) {
    this.lastExpressConsentVoiceUpdateDate = lastExpressConsentVoiceUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mobile.
   *
   * @param  mobile  Boolean
   */
  public void setMobile(Boolean mobile) {
    isMobile = mobile;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone city.
   *
   * @param  phoneCity  String
   */
  public void setPhoneCity(String phoneCity) {
    this.phoneCity = phoneCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone id.
   *
   * @param  phoneId  Long
   */
  public void setPhoneId(Long phoneId) {
    this.phoneId = phoneId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone indicator.
   *
   * @param  phoneIndicator  String
   */
  public void setPhoneIndicator(String phoneIndicator) {
    this.phoneIndicator = phoneIndicator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone num.
   *
   * @param  phoneNum  String
   */
  @Override public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone state.
   *
   * @param  phoneState  String
   */
  public void setPhoneState(String phoneState) {
    this.phoneState = phoneState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone type.
   *
   * @param  phoneType  PhoneType
   */
  @Override public void setPhoneType(PhoneType phoneType) {
    this.phoneType = phoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms count.
   *
   * @param  smsCount  Integer
   */
  public void setSmsCount(Integer smsCount) {
    this.smsCount = smsCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for voice mail activities.
   *
   * @param  voiceMailActivities  Set
   */
  public void setVoiceMailActivities(Set<VoiceMailActivity> voiceMailActivities) {
    this.voiceMailActivities = voiceMailActivities;
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

    retValue.append("ContactPhone ( ").append(super.toString()).append(TAB).append("phoneId = ").append(this.phoneId)
      .append(TAB).append(
      "phoneNum = ").append(this.phoneNum).append(TAB).append(
      "phoneType = ").append(this.phoneType).append(TAB).append(" )");

    return retValue.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateNextEligibleCallDate.
   *
   * @param  accountRevisionAudit  BaseNextEligibleCallDateAudit
   */
  @Override public void updateNextEligibleCallDate(BaseNextEligibleCallDateAudit accountRevisionAudit) {
    this.nextEligibleCallDate      = accountRevisionAudit.getNextEligibleCallDate();
    this.appliedContactResultLimit = accountRevisionAudit.getAppliedContactResultLimit();
    this.appliedPhoneTypeDelay     = accountRevisionAudit.getAppliedPhoneTypeDelay();
    this.appliedPhoneTypeLimit     = accountRevisionAudit.getAppliedPhoneTypeLimit();
    this.rpcAudit                  = accountRevisionAudit.getRpcAudit();
    this.phoneNumberAttemptAudit   = accountRevisionAudit.getPhoneNumberAttemptAudit();
    this.connectAudit              = accountRevisionAudit.getConnectAudit();
    this.contactResultAudit        = accountRevisionAudit.getContactResultAudit();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateNextEligibleCallDateConditional.
   *
   * @param  accountRevisionAudit  BaseNextEligibleCallDateAudit
   */
  public void updateNextEligibleCallDateConditional(BaseNextEligibleCallDateAudit accountRevisionAudit) {
    if ((this.nextEligibleCallDate == null)
          || ((accountRevisionAudit.getNextEligibleCallDate() != null)
            && accountRevisionAudit.getNextEligibleCallDate().after(this.nextEligibleCallDate))) {
      this.nextEligibleCallDate      = accountRevisionAudit.getNextEligibleCallDate();
      this.appliedContactResultLimit = accountRevisionAudit.getAppliedContactResultLimit();
      this.appliedPhoneTypeDelay     = accountRevisionAudit.getAppliedPhoneTypeDelay();
      this.appliedPhoneTypeLimit     = accountRevisionAudit.getAppliedPhoneTypeLimit();
      this.rpcAudit                  = accountRevisionAudit.getRpcAudit();
      this.phoneNumberAttemptAudit   = accountRevisionAudit.getPhoneNumberAttemptAudit();
      this.connectAudit              = accountRevisionAudit.getConnectAudit();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  baseContact  AbstractBaseContact
   */
  @Override protected void deepCopy(AbstractBaseContact baseContact) {
    super.deepCopy(baseContact); // To change body of overridden methods use File | Settings | File Templates.

    ContactPhone phone = (ContactPhone) baseContact;

    if (phone != null) {
      super.deepCopy(phone);
      this.phoneNum             = phone.getPhoneNum();
      this.extension            = phone.getExtension();
      this.telephoneCountryCode = phone.getTelephoneCountryCode();
      this.setExpressConsentVoice(phone.getExpressConsentVoice());
      this.setLastExpressConsentVoiceAgent(phone.getLastExpressConsentVoiceAgent());
      this.setLastExpressConsentVoiceUpdateDate(phone.getLastExpressConsentVoiceUpdateDate());
      this.setExpressConsentSMS(phone.getExpressConsentSMS());
      this.setLastExpressConsentSMSAgent(phone.getLastExpressConsentSMSAgent());
      this.setLastExpressConsentSMSUpdateDate(phone.getLastExpressConsentSMSUpdateDate());
      this.setBadNumber(phone.getBadNumber());
      this.setIsMobile(phone.getIsMobile());
      this.setCallType(phone.getCallType());
      this.phoneType.deepCopy(phone.getPhoneType());
    }
  }

} // end class ContactPhone
