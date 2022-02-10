package com.cmc.credagility.core.domain.authorizeduser;

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
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.channel.VoiceMailActivity;
import com.cmc.credagility.core.domain.contact.AbstractBaseContact;
import com.cmc.credagility.core.domain.contact.PhoneType;
import com.cmc.credagility.core.domain.disposition.CallType;
import com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit;
import com.cmc.credagility.core.domain.type.ContactChannel;
import com.cmc.credagility.core.domain.type.ContactChannelType;
import com.cmc.credagility.core.domain.type.ExpressConsentType;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 09:37
 */
@Entity
@Table(
  name    = "AuthorizedUserPhone",
  indexes = {
    @Index(
      name = "phoneNumIndex",
      columnList = "phoneNum"
    ),
    @Index(
      name = "historicalIndex",
      columnList = "historical"
    ),
    @Index(
      name = "optOutIndex",
      columnList = "optOut"
    )
  }
)
public class AuthorizedUserPhone extends BaseAuthorizedUserPhone {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5242372643570613913L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(name = "agentCallCount")
  protected Integer agentCallCount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "agentTalkCount")
  protected Integer agentTalkCount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "answerMachineCount")
  protected Integer answerMachineCount;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "callTypeId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CallType callType;

  /** TODO: DOCUMENT ME! */
  @Column(name = "dialerAgentTalkCount")
  protected Integer dialerAgentTalkCount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "dialerAnswerMachineCount")
  protected Integer dialerAnswerMachineCount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "dialerCount")
  protected Integer dialerCount;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "expressConsentSMS",
    nullable = true,
    length   = 5
  )
  @Enumerated(EnumType.STRING)
  protected ExpressConsentType expressConsentSMS;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "expressConsentVoice",
    nullable = true,
    length   = 5
  )
  @Enumerated(EnumType.STRING)
  protected ExpressConsentType expressConsentVoice;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "extension",
    length = 20
  )
  protected String extension;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "isBadNumber",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isBadNumber;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "isMobile",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isMobile;

  /** TODO: DOCUMENT ME! */
  @Column(name = "ivrCount")
  protected Integer ivrCount;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "lastExpressConsentSMSAgentId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected User lastExpressConsentSMSAgent;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastExpressConsentSMSUpdateDate")
  protected Date lastExpressConsentSMSUpdateDate;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "lastExpressConsentVoiceAgentId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected User lastExpressConsentVoiceAgent;


  /** TODO: DOCUMENT ME! */
  @Column(name = "lastExpressConsentVoiceUpdateDate")
  protected Date lastExpressConsentVoiceUpdateDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "phoneCity",
    length = 50
  )
  protected String phoneCity;

  /** Phone contact PK phoneId. */
  // npelleti, 07/30, USBank, Removed unique constraint
  @Column(
    name     = "phoneId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long phoneId;

  // npelleti, 07/30, USBank, Added Index
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

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "typeId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected PhoneType phoneType = new PhoneType();

  /** TODO: DOCUMENT ME! */
  @Column(name = "smsCount")
  protected Integer smsCount;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = { CascadeType.ALL, CascadeType.REMOVE },
    fetch    = FetchType.LAZY,
    mappedBy = "contactPhone"
  )
  @OrderBy("vmDate asc")
  protected Set<VoiceMailActivity> voiceMailActivities = new LinkedHashSet<VoiceMailActivity>();

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

    if (obj == null) {
      return !StringUtils.hasText(this.phoneNum);
    }

    final AuthorizedUserPhone other = (AuthorizedUserPhone) obj;

    if (StringUtils.hasText(this.phoneNum)) {
      tempNum = Pattern.compile("\\(?\\-?\\)?\\ ?").matcher(this.phoneNum).replaceAll("");
    }

    if (StringUtils.hasText(phoneNum)
          ^ StringUtils.hasText(other.getPhoneNum())) {
      return false;
    } else if ((tempNum != null) && !tempNum.equals(other.getPhoneNum())) {
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
   * @param  phone  AuthorizedUserPhone
   */
  public void deepCopy(AuthorizedUserPhone phone) {
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
      this.phoneType.deepCopy(phone.getPhoneType());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.AbstractBaseContact#equals(java.lang.Object)
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

    final AuthorizedUserPhone other = (AuthorizedUserPhone) obj;

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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#getBadNumber()
   */
  @Override public Boolean getBadNumber() {
    return isBadNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#getCallType()
   */
  @Override public CallType getCallType() {
    return callType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#getContactChannel()
   */
  @Override public ContactChannel getContactChannel() {
    return ContactChannel.toContactChannel(getPhoneType().getTypeId(),
        ContactChannelType.PHONE);
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
   * getter method for dialer count.
   *
   * @return  Integer
   */
  public Integer getDialerCount() {
    return dialerCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#getExpressConsentSMS()
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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#getExpressConsentVoice()
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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#getExtension()
   */
  @Override public String getExtension() {
    return extension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#getIsMobile()
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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#getLastExpressConsentSMSAgent()
   */
  @Override public User getLastExpressConsentSMSAgent() {
    return lastExpressConsentSMSAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#getLastExpressConsentSMSUpdateDate()
   */
  @Override public Date getLastExpressConsentSMSUpdateDate() {
    return lastExpressConsentSMSUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#getLastExpressConsentVoiceAgent()
   */
  @Override public User getLastExpressConsentVoiceAgent() {
    return lastExpressConsentVoiceAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#getLastExpressConsentVoiceUpdateDate()
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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#getPhoneNum()
   */
  @Override public String getPhoneNum() {
    return phoneNum;
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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#getPhoneType()
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
   * @see  com.cmc.credagility.core.domain.contact.AbstractBaseContact#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result) + ((phoneNum == null) ? 0 : phoneNum.hashCode());
    result = (prime * result) + ((phoneType == null) ? 0 : phoneType.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * increaseAgentCallCount.
   */
  public void increaseAgentCallCount() {
    if ((agentCallCount == null) || (agentCallCount < 0)) {
      agentCallCount = 0;
    }

    agentCallCount++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * increaseAgentTalkCount.
   */
  public void increaseAgentTalkCount() {
    if ((agentTalkCount == null) || (agentTalkCount < 0)) {
      agentTalkCount = 0;
    }

    agentTalkCount++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * increaseAnswerMachineCount.
   */
  public void increaseAnswerMachineCount() {
    if ((answerMachineCount == null) || (answerMachineCount < 0)) {
      answerMachineCount = 0;
    }

    answerMachineCount++;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * increaseDialerAgentCallCount.
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
   * DOCUMENT ME!
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
   * DOCUMENT ME!
   *
   * @param  agentCallCount  DOCUMENT ME!
   */
  public void setAgentCallCount(Integer agentCallCount) {
    this.agentCallCount = agentCallCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agentTalkCount  DOCUMENT ME!
   */
  public void setAgentTalkCount(Integer agentTalkCount) {
    this.agentTalkCount = agentTalkCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  answerMachineCount  DOCUMENT ME!
   */
  public void setAnswerMachineCount(Integer answerMachineCount) {
    this.answerMachineCount = answerMachineCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  badNumber  DOCUMENT ME!
   */
  @Override public void setBadNumber(Boolean badNumber) {
    isBadNumber = badNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  callType  DOCUMENT ME!
   */
  @Override public void setCallType(CallType callType) {
    this.callType = callType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dialerAgentTalkCount  the dialerAgentTalkCount to set
   */
  public void setDialerAgentTalkCount(Integer dialerAgentTalkCount) {
    this.dialerAgentTalkCount = dialerAgentTalkCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dialerAnswerMachineCount  the dialerAnswerMachineCount to set
   */
  public void setDialerAnswerMachineCount(Integer dialerAnswerMachineCount) {
    this.dialerAnswerMachineCount = dialerAnswerMachineCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dialerCount  the dialerCount to set
   */
  public void setDialerCount(Integer dialerCount) {
    this.dialerCount = dialerCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expressConsentSMS  DOCUMENT ME!
   */
  @Override public void setExpressConsentSMS(ExpressConsentType expressConsentSMS) {
    this.expressConsentSMS = expressConsentSMS;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  expressConsentVoice  DOCUMENT ME!
   */
  @Override public void setExpressConsentVoice(ExpressConsentType expressConsentVoice) {
    this.expressConsentVoice = expressConsentVoice;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  extension  DOCUMENT ME!
   */
  @Override public void setExtension(String extension) {
    this.extension = extension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  isMobile  DOCUMENT ME!
   */
  @Override public void setIsMobile(Boolean isMobile) {
    this.isMobile = isMobile;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ivrCount  DOCUMENT ME!
   */
  public void setIvrCount(Integer ivrCount) {
    this.ivrCount = ivrCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastExpressConsentSMSAgent  DOCUMENT ME!
   */
  @Override public void setLastExpressConsentSMSAgent(User lastExpressConsentSMSAgent) {
    this.lastExpressConsentSMSAgent = lastExpressConsentSMSAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastExpressConsentSMSUpdateDate  DOCUMENT ME!
   */
  @Override public void setLastExpressConsentSMSUpdateDate(Date lastExpressConsentSMSUpdateDate) {
    this.lastExpressConsentSMSUpdateDate = lastExpressConsentSMSUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastExpressConsentVoiceAgent  DOCUMENT ME!
   */
  @Override public void setLastExpressConsentVoiceAgent(User lastExpressConsentVoiceAgent) {
    this.lastExpressConsentVoiceAgent = lastExpressConsentVoiceAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastExpressConsentVoiceUpdateDate  DOCUMENT ME!
   */
  @Override public void setLastExpressConsentVoiceUpdateDate(Date lastExpressConsentVoiceUpdateDate) {
    this.lastExpressConsentVoiceUpdateDate = lastExpressConsentVoiceUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  mobile  DOCUMENT ME!
   */
  public void setMobile(Boolean mobile) {
    isMobile = mobile;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneCity  DOCUMENT ME!
   */
  public void setPhoneCity(String phoneCity) {
    this.phoneCity = phoneCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneId  the phoneId to set *
   */
  public void setPhoneId(Long phoneId) {
    this.phoneId = phoneId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneNum  the phoneNum to set
   */
  @Override public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneState  DOCUMENT ME!
   */
  public void setPhoneState(String phoneState) {
    this.phoneState = phoneState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneType  the phoneType to set
   */
  @Override public void setPhoneType(PhoneType phoneType) {
    this.phoneType = phoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  smsCount  DOCUMENT ME!
   */
  public void setSmsCount(Integer smsCount) {
    this.smsCount = smsCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  voiceMailActivities  DOCUMENT ME!
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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#updateNextEligibleCallDate(com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit)
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
   * DOCUMENT ME!
   *
   * @param  accountRevisionAudit  DOCUMENT ME!
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
   * @see  com.cmc.credagility.core.domain.contact.AbstractBaseContact#deepCopy(com.cmc.credagility.core.domain.contact.AbstractBaseContact)
   */
  @Override protected void deepCopy(AbstractBaseContact baseContact) {
    super.deepCopy(baseContact); // To change body of overridden methods use File | Settings | File Templates.

    AuthorizedUserPhone phone = (AuthorizedUserPhone) baseContact;

    if (phone != null) {
      super.deepCopy(phone);
      this.phoneNum  = phone.getPhoneNum();
      this.extension = phone.getExtension();
      this.phoneType.deepCopy(phone.getPhoneType());
      this.expressConsentSMS                 = phone.getExpressConsentSMS();
      this.lastExpressConsentSMSAgent        = phone.getLastExpressConsentSMSAgent();
      this.lastExpressConsentSMSUpdateDate   = phone.getLastExpressConsentSMSUpdateDate();
      this.expressConsentVoice               = phone.getExpressConsentVoice();
      this.lastExpressConsentVoiceAgent      = phone.getLastExpressConsentVoiceAgent();
      this.lastExpressConsentVoiceUpdateDate = phone.getLastExpressConsentVoiceUpdateDate();
      this.isBadNumber                       = phone.getBadNumber();
    }
  }
} // end class AuthorizedUserPhone
