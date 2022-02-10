package com.cmc.credagility.core.domain.customer;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 15:45
 */
@Entity
@Table(
  name    = "CustomerContactPhone",
  indexes = {
    @Index(
      name = "historicalIndex",
      columnList = "historical"
    ), @Index(
      name = "optOutIndex",
      columnList = "optOut"
    ), @Index(
      name = "phoneNumIndex",
      columnList = "phoneNum"
    )
  }
)
public class CustomerContactPhone extends BaseCustomerPhone {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2925957146094141761L;

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
  @Column(
    name   = "bureauPhoneSource",
    length = 20
  )
  protected String bureauPhoneSource;

  /** TODO: DOCUMENT ME! */
  @Column(name = "bureauUpdatedDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date bureauUpdatedDate;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "callTypeId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected CallType callType;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientPhoneUpdateDate")
  @Temporal(TemporalType.DATE)
  protected Date clientPhoneUpdateDate;

  /** Create date. */
  @JoinColumn(
    name       = "creatorId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User creator;


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
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isBadNumber;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "isMobile",
    length           = 1,
    columnDefinition = "char"
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

  /** Last Updater. */
  @JoinColumn(
    name       = "lastUpdaterId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User lastUpdater;


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

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "phoneIndicator",
    length = 20
  )
  protected String phoneIndicator;

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

  /** Phone type. */
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
  @Column(
    name             = "updated",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean updated = Boolean.FALSE;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
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

    final CustomerContactPhone other = (CustomerContactPhone) obj;

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
   * Copy phone.
   *
   * @param  phone  DOCUMENT ME!
   */
  public void deepCopy(CustomerContactPhone phone) {
    if (phone != null) {
      super.deepCopy(phone);
      this.phoneNum  = phone.getPhoneNum();
      this.extension = phone.getExtension();
      this.setTelephoneCountryCode(phone.getTelephoneCountryCode());
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
      this.setPhoneIndicator(phone.getPhoneIndicator());
      this.setStatus(phone.getStatus());
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

    final CustomerContactPhone other = (CustomerContactPhone) obj;

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
    } else if (!telephoneCountryCode.equals(other.getTelephoneCountryCode())) {
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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#getCallType()
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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#getContactChannel()
   */
  @Override public ContactChannel getContactChannel() {
    return ContactChannel.toContactChannel(getPhoneType().getTypeId(),
        ContactChannelType.PHONE);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for creator.
   *
   * @return  User
   */
  public User getCreator() {
    return creator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for creator name.
   *
   * @return  String
   */
  public String getCreatorName() {
    if (getCreator() != null) {
      return getCreator().getFullName();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The dialerAgentTalkCount.
   *
   * @return  the dialerAgentTalkCount
   */
  public Integer getDialerAgentTalkCount() {
    return dialerAgentTalkCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The dialerAnswerMachineCount.
   *
   * @return  the dialerAnswerMachineCount
   */
  public Integer getDialerAnswerMachineCount() {
    return dialerAnswerMachineCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The dialerCount.
   *
   * @return  the dialerCount
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>type = "yes_no"</p>
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
   * getter method for last updater.
   *
   * @return  User
   */
  public User getLastUpdater() {
    return lastUpdater;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last updater name.
   *
   * @return  String
   */
  public String getLastUpdaterName() {
    if (getLastUpdater() != null) {
      return getLastUpdater().getFullName();
    } else {
      return "";
    }
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>not-null = "false" length = "50"</p>
   */
  public String getPhoneCity() {
    return phoneCity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get phone id.
   *
   * @return  the phoneId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
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
   * The phoneNum.
   *
   * @return  the phoneNum
   *
   *          <p>not-null = "true" length = "20" index = "phoneNumIndex"</p>
   */
  @Override public String getPhoneNum() {
    return phoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>not-null = "false" length = "2"</p>
   */
  public String getPhoneState() {
    return phoneState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The phoneType.
   *
   * @return  the phoneType
   *
   *          <p>lazy = "false" column = "typeId" not-null = "true" class = "com.cmc.credagility.PhoneType" insert =
   *          "true" update = "true" length = "20"</p>
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
   * getter method for updated.
   *
   * @return  Boolean
   */
  public Boolean getUpdated() {
    return updated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   *          <p>lazy = "true" table = "VoiceMailActivity" inverse = "true" cascade = "all-delete-orphan" order-by =
   *          "vmDate asc"</p>
   *
   *          <p>column = "phoneId" xStreamConvert4EnterpriseTaskElements class =
   *          "com.cmc.credagility.VoiceMailActivity"</p>
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

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#setBadNumber(java.lang.Boolean)
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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#setCallType(com.cmc.credagility.core.domain.disposition.CallType)
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
   * setter method for creator.
   *
   * @param  creator  User
   */
  public void setCreator(User creator) {
    this.creator = creator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for creator name.
   *
   * @param  name  String
   */
  public void setCreatorName(String name) { }

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
   * setter method for dialer count.
   *
   * @param  dialerCount  Integer
   */
  public void setDialerCount(Integer dialerCount) {
    this.dialerCount = dialerCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#setExpressConsentSMS(com.cmc.credagility.core.domain.type.ExpressConsentType)
   */
  @Override public void setExpressConsentSMS(ExpressConsentType expressConsentSMS) {
    this.expressConsentSMS = expressConsentSMS;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#setExpressConsentVoice(com.cmc.credagility.core.domain.type.ExpressConsentType)
   */
  @Override public void setExpressConsentVoice(ExpressConsentType expressConsentVoice) {
    this.expressConsentVoice = expressConsentVoice;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#setExtension(java.lang.String)
   */
  @Override public void setExtension(String extension) {
    this.extension = extension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#setIsMobile(java.lang.Boolean)
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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#setLastExpressConsentSMSAgent(com.cmc.credagility.core.domain.user.User)
   */
  @Override public void setLastExpressConsentSMSAgent(User lastExpressConsentSMSAgent) {
    this.lastExpressConsentSMSAgent = lastExpressConsentSMSAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#setLastExpressConsentSMSUpdateDate(java.util.Date)
   */
  @Override public void setLastExpressConsentSMSUpdateDate(Date lastExpressConsentSMSUpdateDate) {
    this.lastExpressConsentSMSUpdateDate = lastExpressConsentSMSUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#setLastExpressConsentVoiceAgent(com.cmc.credagility.core.domain.user.User)
   */
  @Override public void setLastExpressConsentVoiceAgent(User lastExpressConsentVoiceAgent) {
    this.lastExpressConsentVoiceAgent = lastExpressConsentVoiceAgent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#setLastExpressConsentVoiceUpdateDate(java.util.Date)
   */
  @Override public void setLastExpressConsentVoiceUpdateDate(Date lastExpressConsentVoiceUpdateDate) {
    this.lastExpressConsentVoiceUpdateDate = lastExpressConsentVoiceUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last updater.
   *
   * @param  lastUpdater  User
   */
  public void setLastUpdater(User lastUpdater) {
    this.lastUpdater = lastUpdater;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last updater name.
   *
   * @param  name  String
   */
  public void setLastUpdaterName(String name) { }

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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#setPhoneNum(java.lang.String)
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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#setPhoneType(com.cmc.credagility.core.domain.contact.PhoneType)
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
   * setter method for updated.
   *
   * @param  updated  Boolean
   */
  public void setUpdated(Boolean updated) {
    this.updated = updated;
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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#updateNextEligibleCallDate(com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit)
   */
  @Override public void updateNextEligibleCallDate(BaseNextEligibleCallDateAudit accountRevisionAudit) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.AbstractBaseContact#deepCopy(com.cmc.credagility.core.domain.contact.AbstractBaseContact)
   */
  @Override protected void deepCopy(AbstractBaseContact baseContact) {
    super.deepCopy(baseContact); // To change body of overridden methods use File | Settings | File Templates.

    CustomerContactPhone phone = (CustomerContactPhone) baseContact;

    if (phone != null) {
      super.deepCopy(phone);
      this.phoneNum             = phone.getPhoneNum();
      this.extension            = phone.getExtension();
      this.telephoneCountryCode = phone.getTelephoneCountryCode();
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
} // end class CustomerContactPhone
