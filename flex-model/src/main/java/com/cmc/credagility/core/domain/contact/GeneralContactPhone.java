package com.cmc.credagility.core.domain.contact;

import java.util.Date;

import com.cmc.credagility.core.domain.disposition.CallType;
import com.cmc.credagility.core.domain.portfolio.BaseNextEligibleCallDateAudit;
import com.cmc.credagility.core.domain.portfolio.PortfolioPhoneTypeDependency;
import com.cmc.credagility.core.domain.type.ContactChannel;
import com.cmc.credagility.core.domain.type.ExpressConsentType;
import com.cmc.credagility.core.domain.user.User;


/**
 * All level phone need implement this class.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/14/2014 18:20
 */
public interface GeneralContactPhone {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for bad number.
   *
   * @return  Boolean
   */
  Boolean getBadNumber();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call type.
   *
   * @return  CallType
   */
  CallType getCallType();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact channel.
   *
   * @return  ContactChannel
   */
  ContactChannel getContactChannel();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for express consent SMS.
   *
   * @return  ExpressConsentType
   */
  ExpressConsentType getExpressConsentSMS();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for express consent voice.
   *
   * @return  ExpressConsentType
   */
  ExpressConsentType getExpressConsentVoice();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for extension.
   *
   * @return  String
   */
  String getExtension();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for is mobile.
   *
   * @return  Boolean
   */
  Boolean getIsMobile();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last express consent SMSAgent.
   *
   * @return  User
   */
  User getLastExpressConsentSMSAgent();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last express consent SMSUpdate date.
   *
   * @return  Date
   */
  Date getLastExpressConsentSMSUpdateDate();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last express consent voice agent.
   *
   * @return  User
   */
  User getLastExpressConsentVoiceAgent();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last express consent voice update date.
   *
   * @return  Date
   */
  Date getLastExpressConsentVoiceUpdateDate();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone num.
   *
   * @return  String
   */
  String getPhoneNum();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone type.
   *
   * @return  PhoneType
   */
  PhoneType getPhoneType();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bad number.
   *
   * @param  badNumber  Boolean
   */
  void setBadNumber(Boolean badNumber);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call type.
   *
   * @param  callType  CallType
   */
  void setCallType(CallType callType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for do not call.
   *
   * @param  doNotCall  Boolean
   */
  void setDoNotCall(Boolean doNotCall);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for express consent SMS.
   *
   * @param  expressConsentSMS  ExpressConsentType
   */
  void setExpressConsentSMS(ExpressConsentType expressConsentSMS);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for express consent voice.
   *
   * @param  expressConsentVoice  ExpressConsentType
   */
  void setExpressConsentVoice(ExpressConsentType expressConsentVoice);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for extension.
   *
   * @param  extension  String
   */
  void setExtension(String extension);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for is mobile.
   *
   * @param  isMobile  Boolean
   */
  void setIsMobile(Boolean isMobile);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last express consent SMSAgent.
   *
   * @param  lastExpressConsentSMSAgent  User
   */
  void setLastExpressConsentSMSAgent(User lastExpressConsentSMSAgent);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last express consent SMSUpdate date.
   *
   * @param  lastExpressConsentSMSUpdateDate  Date
   */
  void setLastExpressConsentSMSUpdateDate(Date lastExpressConsentSMSUpdateDate);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last express consent voice agent.
   *
   * @param  lastExpressConsentVoiceAgent  User
   */
  void setLastExpressConsentVoiceAgent(User lastExpressConsentVoiceAgent);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last express consent voice update date.
   *
   * @param  lastExpressConsentVoiceUpdateDate  Date
   */
  void setLastExpressConsentVoiceUpdateDate(Date lastExpressConsentVoiceUpdateDate);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone num.
   *
   * @param  phoneNum  String
   */
  void setPhoneNum(String phoneNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone type.
   *
   * @param  phoneType  PhoneType
   */
  void setPhoneType(PhoneType phoneType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone type dependency.
   *
   * @param  phoneTypeDependency  PortfolioPhoneTypeDependency
   */
  void setPhoneTypeDependency(PortfolioPhoneTypeDependency phoneTypeDependency);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateNextEligibleCallDate.
   *
   * @param  accountRevisionAudit  BaseNextEligibleCallDateAudit
   */
  void updateNextEligibleCallDate(BaseNextEligibleCallDateAudit accountRevisionAudit);

} // end interface GeneralContactPhone
