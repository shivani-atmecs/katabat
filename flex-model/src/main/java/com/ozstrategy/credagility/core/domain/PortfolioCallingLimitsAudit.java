package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 13:45
 */
@Entity
@Table(name = "PortfolioCallingLimitsAudit")
public class PortfolioCallingLimitsAudit extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "action",
    length = 255
  )
  protected String action;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "active",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean active = Boolean.TRUE;


  /** TODO: DOCUMENT ME! */
  @Column(name = "daysDelayToMessage")
  protected Integer daysDelayToMessage;


  /** TODO: DOCUMENT ME! */
  @Column(name = "hoursDelayToCallAlternate")
  protected Integer hoursDelayToCallAlternate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "hoursDelayToCallHome")
  protected Integer hoursDelayToCallHome;


  /** TODO: DOCUMENT ME! */
  @Column(name = "hoursDelayToCallWork")
  protected Integer hoursDelayToCallWork;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "issuerNo",
    length = 100
  )
  protected String issuerNo;


  /** TODO: DOCUMENT ME! */
  @Column(name = "maxAlternateAttempts")
  protected Integer maxAlternateAttempts;


  /** TODO: DOCUMENT ME! */
  @Column(name = "maxHomeAttempts")
  protected Integer maxHomeAttempts;


  /** TODO: DOCUMENT ME! */
  @Column(name = "maxRightPartyContacts")
  protected Integer maxRightPartyContacts;


  /** TODO: DOCUMENT ME! */
  @Column(name = "maxRPCAge")
  protected Integer maxRPCAge;


  /** TODO: DOCUMENT ME! */
  @Column(name = "maxVoiceMessageLimit")
  protected Integer maxVoiceMessageLimit;


  /** TODO: DOCUMENT ME! */
  @Column(name = "maxWorkAttempts")
  protected Integer maxWorkAttempts;


  /** TODO: DOCUMENT ME! */
  @Column(name = "portfolioId")
  protected Long portfolioId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * copy.
   *
   * @param  callingLimit  PortfolioCallingLimits
   * @param  portfolioId   Long
   */
  public void copy(PortfolioCallingLimits callingLimit, Long portfolioId) {
    this.issuerNo                  = callingLimit.getIssuerNo();
    this.maxRightPartyContacts     = callingLimit.getMaxRightPartyContacts();
    this.maxRPCAge                 = callingLimit.getMaxRPCAge();
    this.maxHomeAttempts           = callingLimit.getMaxHomeAttempts();
    this.maxWorkAttempts           = callingLimit.getMaxWorkAttempts();
    this.maxAlternateAttempts      = callingLimit.getMaxAlternateAttempts();
    this.hoursDelayToCallHome      = callingLimit.getHoursDelayToCallHome();
    this.hoursDelayToCallWork      = callingLimit.getHoursDelayToCallWork();
    this.hoursDelayToCallAlternate = callingLimit.getHoursDelayToCallAlternate();
    this.daysDelayToMessage        = callingLimit.getDaysDelayToMessage();
    this.maxVoiceMessageLimit      = callingLimit.getMaxVoiceMessageLimit();
    this.portfolioId               = portfolioId;
    this.createDate                = new Date();
    this.lastUpdateDate            = new Date();
    this.active                    = callingLimit.getActive();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action.
   *
   * @return  String
   */
  public String getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active.
   *
   * @return  Boolean
   */
  public Boolean getActive() {
    if (active == null) {
      return Boolean.FALSE;
    }

    return active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for days delay to message.
   *
   * @return  Integer
   */
  public Integer getDaysDelayToMessage() {
    return daysDelayToMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hours delay to call alternate.
   *
   * @return  Integer
   */
  public Integer getHoursDelayToCallAlternate() {
    return hoursDelayToCallAlternate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hours delay to call home.
   *
   * @return  Integer
   */
  public Integer getHoursDelayToCallHome() {
    return hoursDelayToCallHome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hours delay to call work.
   *
   * @return  Integer
   */
  public Integer getHoursDelayToCallWork() {
    return hoursDelayToCallWork;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for issuer no.
   *
   * @return  String
   */
  public String getIssuerNo() {
    return issuerNo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for max alternate attempts.
   *
   * @return  Integer
   */
  public Integer getMaxAlternateAttempts() {
    return maxAlternateAttempts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for max home attempts.
   *
   * @return  Integer
   */
  public Integer getMaxHomeAttempts() {
    return maxHomeAttempts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for max right party contacts.
   *
   * @return  Integer
   */
  public Integer getMaxRightPartyContacts() {
    return maxRightPartyContacts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for max RPCAge.
   *
   * @return  Integer
   */
  public Integer getMaxRPCAge() {
    return maxRPCAge;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for max voice message limit.
   *
   * @return  Integer
   */
  public Integer getMaxVoiceMessageLimit() {
    return maxVoiceMessageLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for max work attempts.
   *
   * @return  Integer
   */
  public Integer getMaxWorkAttempts() {
    return maxWorkAttempts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio id.
   *
   * @return  Long
   */
  public Long getPortfolioId() {
    return portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action.
   *
   * @param  action  String
   */
  public void setAction(String action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for active.
   *
   * @param  active  Boolean
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for days delay to message.
   *
   * @param  daysDelayToMessage  Integer
   */
  public void setDaysDelayToMessage(Integer daysDelayToMessage) {
    this.daysDelayToMessage = daysDelayToMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hours delay to call alternate.
   *
   * @param  hoursDelayToCallAlternate  Integer
   */
  public void setHoursDelayToCallAlternate(Integer hoursDelayToCallAlternate) {
    this.hoursDelayToCallAlternate = hoursDelayToCallAlternate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hours delay to call home.
   *
   * @param  hoursDelayToCallHome  Integer
   */
  public void setHoursDelayToCallHome(Integer hoursDelayToCallHome) {
    this.hoursDelayToCallHome = hoursDelayToCallHome;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hours delay to call work.
   *
   * @param  hoursDelayToCallWork  Integer
   */
  public void setHoursDelayToCallWork(Integer hoursDelayToCallWork) {
    this.hoursDelayToCallWork = hoursDelayToCallWork;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for issuer no.
   *
   * @param  issuerNo  String
   */
  public void setIssuerNo(String issuerNo) {
    this.issuerNo = issuerNo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for max alternate attempts.
   *
   * @param  maxAlternateAttempts  Integer
   */
  public void setMaxAlternateAttempts(Integer maxAlternateAttempts) {
    this.maxAlternateAttempts = maxAlternateAttempts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for max home attempts.
   *
   * @param  maxHomeAttempts  Integer
   */
  public void setMaxHomeAttempts(Integer maxHomeAttempts) {
    this.maxHomeAttempts = maxHomeAttempts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for max right party contacts.
   *
   * @param  maxRightPartyContacts  Integer
   */
  public void setMaxRightPartyContacts(Integer maxRightPartyContacts) {
    this.maxRightPartyContacts = maxRightPartyContacts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for max RPCAge.
   *
   * @param  maxRPCAge  Integer
   */
  public void setMaxRPCAge(Integer maxRPCAge) {
    this.maxRPCAge = maxRPCAge;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for max voice message limit.
   *
   * @param  maxVoiceMessageLimit  Integer
   */
  public void setMaxVoiceMessageLimit(Integer maxVoiceMessageLimit) {
    this.maxVoiceMessageLimit = maxVoiceMessageLimit;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for max work attempts.
   *
   * @param  maxWorkAttempts  Integer
   */
  public void setMaxWorkAttempts(Integer maxWorkAttempts) {
    this.maxWorkAttempts = maxWorkAttempts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio id.
   *
   * @param  portfolioId  Long
   */
  public void setPortfolioId(Long portfolioId) {
    this.portfolioId = portfolioId;
  }
} // end class PortfolioCallingLimitsAudit
