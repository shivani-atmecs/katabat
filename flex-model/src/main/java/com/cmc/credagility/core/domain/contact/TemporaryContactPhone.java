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

import com.cmc.credagility.core.domain.channel.VoiceMailActivity;
import com.cmc.credagility.core.domain.disposition.CallType;
import com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit;
import com.cmc.credagility.core.domain.type.ContactChannel;
import com.cmc.credagility.core.domain.type.ContactChannelType;
import com.cmc.credagility.core.domain.type.ExpressConsentType;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store responsible level TemporaryContactPhone information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 10:09
 */
@Entity
@Table(
  name    = "TemporaryContactPhone",
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
public class TemporaryContactPhone extends BaseContactPhone {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5363038072166292814L;

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


  /** Call type, Refers {@link CallType}. */
  @JoinColumn(
    name       = "callTypeId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CallType callType;


  /** Agent call this phone by dialer count. */
  @Column(name = "dialerAgentTalkCount")
  protected Integer dialerAgentTalkCount;


  /** Agent call this phone by dialer answer machine count. */
  @Column(name = "dialerAnswerMachineCount")
  protected Integer dialerAnswerMachineCount;


  /** Dialer count. */
  @Column(name = "dialerCount")
  protected Integer dialerCount;


  /** End date. */
  @Column(name = "endDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date endDate;


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


  /** Start date. */
  @Column(name = "startDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date startDate;


  /** Voice mail activity of this phone, Refers {@link VoiceMailActivity}. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "contactPhone",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("vmDate asc")
  protected Set<VoiceMailActivity> voiceMailActivities = new LinkedHashSet<VoiceMailActivity>();

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

    if (obj == null) {
      return !StringUtils.hasText(this.phoneNum);
    }

    final TemporaryContactPhone other = (TemporaryContactPhone) obj;

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
   * @param  phone  TemporaryContactPhone
   */
  public void deepCopy(TemporaryContactPhone phone) {
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
      this.setStartDate(phone.getStartDate());
      this.setEndDate(phone.getEndDate());
      this.setTelephoneCountryCode(phone.getTelephoneCountryCode());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.AbstractBaseContact#equals(java.lang.Object)
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

    TemporaryContactPhone that = (TemporaryContactPhone) o;

    if ((agentCallCount != null) ? (!agentCallCount.equals(that.agentCallCount)) : (that.agentCallCount != null)) {
      return false;
    }

    if ((agentTalkCount != null) ? (!agentTalkCount.equals(that.agentTalkCount)) : (that.agentTalkCount != null)) {
      return false;
    }

    if ((answerMachineCount != null) ? (!answerMachineCount.equals(that.answerMachineCount))
                                     : (that.answerMachineCount != null)) {
      return false;
    }

    if ((callType != null) ? (!callType.equals(that.callType)) : (that.callType != null)) {
      return false;
    }

    if ((dialerAgentTalkCount != null) ? (!dialerAgentTalkCount.equals(that.dialerAgentTalkCount))
                                       : (that.dialerAgentTalkCount != null)) {
      return false;
    }

    if ((dialerAnswerMachineCount != null) ? (!dialerAnswerMachineCount.equals(that.dialerAnswerMachineCount))
                                           : (that.dialerAnswerMachineCount != null)) {
      return false;
    }

    if ((dialerCount != null) ? (!dialerCount.equals(that.dialerCount)) : (that.dialerCount != null)) {
      return false;
    }

    if ((disclosure != null) ? (!disclosure.equals(that.disclosure)) : (that.disclosure != null)) {
      return false;
    }

    if ((endDate != null) ? (!endDate.equals(that.endDate)) : (that.endDate != null)) {
      return false;
    }

    if (expressConsentSMS != that.expressConsentSMS) {
      return false;
    }

    if (expressConsentVoice != that.expressConsentVoice) {
      return false;
    }

    if ((extension != null) ? (!extension.equals(that.extension)) : (that.extension != null)) {
      return false;
    }

    if ((isBadNumber != null) ? (!isBadNumber.equals(that.isBadNumber)) : (that.isBadNumber != null)) {
      return false;
    }

    if ((isMobile != null) ? (!isMobile.equals(that.isMobile)) : (that.isMobile != null)) {
      return false;
    }

    if ((ivrCount != null) ? (!ivrCount.equals(that.ivrCount)) : (that.ivrCount != null)) {
      return false;
    }

    if ((lastExpressConsentSMSAgent != null) ? (!lastExpressConsentSMSAgent.equals(that.lastExpressConsentSMSAgent))
                                             : (that.lastExpressConsentSMSAgent != null)) {
      return false;
    }

    if ((lastExpressConsentSMSUpdateDate != null)
          ? (!lastExpressConsentSMSUpdateDate.equals(that.lastExpressConsentSMSUpdateDate))
          : (that.lastExpressConsentSMSUpdateDate != null)) {
      return false;
    }

    if ((lastExpressConsentVoiceAgent != null)
          ? (!lastExpressConsentVoiceAgent.equals(that.lastExpressConsentVoiceAgent))
          : (that.lastExpressConsentVoiceAgent != null)) {
      return false;
    }

    if ((lastExpressConsentVoiceUpdateDate != null)
          ? (!lastExpressConsentVoiceUpdateDate.equals(that.lastExpressConsentVoiceUpdateDate))
          : (that.lastExpressConsentVoiceUpdateDate != null)) {
      return false;
    }

    if ((phoneCity != null) ? (!phoneCity.equals(that.phoneCity)) : (that.phoneCity != null)) {
      return false;
    }

    if ((phoneId != null) ? (!phoneId.equals(that.phoneId)) : (that.phoneId != null)) {
      return false;
    }

    if ((phoneNum != null) ? (!phoneNum.equals(that.phoneNum)) : (that.phoneNum != null)) {
      return false;
    }

    if ((phoneState != null) ? (!phoneState.equals(that.phoneState)) : (that.phoneState != null)) {
      return false;
    }

    if ((phoneType != null) ? (!phoneType.equals(that.phoneType)) : (that.phoneType != null)) {
      return false;
    }

    if ((smsCount != null) ? (!smsCount.equals(that.smsCount)) : (that.smsCount != null)) {
      return false;
    }

    if ((telephoneCountryCode != null) ? (!telephoneCountryCode.equals(that.telephoneCountryCode))
                                       : (that.telephoneCountryCode != null)) {
      return false;
    }

    if ((startDate != null) ? (!startDate.equals(that.startDate)) : (that.startDate != null)) {
      return false;
    }

    if ((voiceMailActivities != null) ? (!voiceMailActivities.equals(that.voiceMailActivities))
                                      : (that.voiceMailActivities != null)) {
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
   * getter method for disclosure.
   *
   * @return  Long
   */
  public Long getDisclosure() {
    return disclosure;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end date.
   *
   * @return  Date
   */
  public Date getEndDate() {
    return endDate;
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
   * getter method for start date.
   *
   * @return  Date
   */
  public Date getStartDate() {
    return startDate;
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
    int result = super.hashCode();
    result = (31 * result) + ((agentCallCount != null) ? agentCallCount.hashCode() : 0);
    result = (31 * result) + ((agentTalkCount != null) ? agentTalkCount.hashCode() : 0);
    result = (31 * result) + ((answerMachineCount != null) ? answerMachineCount.hashCode() : 0);
    result = (31 * result) + ((dialerAgentTalkCount != null) ? dialerAgentTalkCount.hashCode() : 0);
    result = (31 * result) + ((dialerAnswerMachineCount != null) ? dialerAnswerMachineCount.hashCode() : 0);
    result = (31 * result) + ((dialerCount != null) ? dialerCount.hashCode() : 0);
    result = (31 * result) + ((expressConsentSMS != null) ? expressConsentSMS.hashCode() : 0);
    result = (31 * result) + ((expressConsentVoice != null) ? expressConsentVoice.hashCode() : 0);
    result = (31 * result) + ((extension != null) ? extension.hashCode() : 0);
    result = (31 * result) + ((isBadNumber != null) ? isBadNumber.hashCode() : 0);
    result = (31 * result) + ((isMobile != null) ? isMobile.hashCode() : 0);
    result = (31 * result) + ((ivrCount != null) ? ivrCount.hashCode() : 0);
    result = (31 * result) + ((lastExpressConsentSMSAgent != null) ? lastExpressConsentSMSAgent.hashCode() : 0);
    result = (31 * result)
      + ((lastExpressConsentSMSUpdateDate != null) ? lastExpressConsentSMSUpdateDate.hashCode() : 0);
    result = (31 * result) + ((lastExpressConsentVoiceAgent != null) ? lastExpressConsentVoiceAgent.hashCode() : 0);
    result = (31 * result)
      + ((lastExpressConsentVoiceUpdateDate != null) ? lastExpressConsentVoiceUpdateDate.hashCode() : 0);
    result = (31 * result) + ((phoneCity != null) ? phoneCity.hashCode() : 0);
    result = (31 * result) + ((phoneId != null) ? phoneId.hashCode() : 0);
    result = (31 * result) + ((phoneNum != null) ? phoneNum.hashCode() : 0);
    result = (31 * result) + ((phoneState != null) ? phoneState.hashCode() : 0);
    result = (31 * result) + ((phoneType != null) ? phoneType.hashCode() : 0);
    result = (31 * result) + ((smsCount != null) ? smsCount.hashCode() : 0);
    result = (31 * result) + ((callType != null) ? callType.hashCode() : 0);
    result = (31 * result) + ((voiceMailActivities != null) ? voiceMailActivities.hashCode() : 0);
    result = (31 * result) + ((disclosure != null) ? disclosure.hashCode() : 0);
    result = (31 * result) + ((startDate != null) ? startDate.hashCode() : 0);
    result = (31 * result) + ((endDate != null) ? endDate.hashCode() : 0);
    result = (31 * result) + ((telephoneCountryCode != null) ? telephoneCountryCode.hashCode() : 0);

    return result;
  } // end method hashCode

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
   * @see  com.cmc.credagility.core.domain.contact.GeneralContactPhone#setBadNumber(java.lang.Boolean)
   */
  @Override public void setBadNumber(Boolean badNumber) {
    isBadNumber = badNumber;
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
   * setter method for disclosure.
   *
   * @param  disclosure  Long
   */
  public void setDisclosure(Long disclosure) {
    this.disclosure = disclosure;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end date.
   *
   * @param  endDate  Date
   */
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
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
   * setter method for start date.
   *
   * @param  startDate  Date
   */
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
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

    retValue.append("TemporaryContactPhone ( ").append(super.toString()).append(TAB).append("phoneId = ").append(
      this.phoneId).append(TAB).append(
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
   * @see  com.cmc.credagility.core.domain.contact.AbstractBaseContact#deepCopy(com.cmc.credagility.core.domain.contact.AbstractBaseContact)
   */
  @Override protected void deepCopy(AbstractBaseContact baseContact) {
    super.deepCopy(baseContact); // To change body of overridden methods use File | Settings | File Templates.

    TemporaryContactPhone phone = (TemporaryContactPhone) baseContact;

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
      this.setStartDate(phone.getStartDate());
      this.setEndDate(phone.getEndDate());
    }
  }
} // end class TemporaryContactPhone
