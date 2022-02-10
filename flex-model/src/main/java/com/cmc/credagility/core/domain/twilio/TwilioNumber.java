package com.cmc.credagility.core.domain.twilio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  08/19/2015 10:41
 */
@Entity
@Table(name = "TwilioNumber")
public class TwilioNumber extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -467828296573116177L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean asCallerID = false;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isAgentCallInNum = false;


  /** TODO: DOCUMENT ME! */
  protected String         phoneNumber;
  @JoinColumn(
    name       = "twilioSubAccountId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  private TwilioSubAccount twilioSubAccount;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for as caller ID.
   *
   * @return  Boolean
   */
  public Boolean getAsCallerID() {
    return asCallerID;
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
   * getter method for is agent call in num.
   *
   * @return  Boolean
   */
  public Boolean getIsAgentCallInNum() {
    return isAgentCallInNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone number.
   *
   * @return  String
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for twilio sub account.
   *
   * @return  TwilioSubAccount
   */
  public TwilioSubAccount getTwilioSubAccount() {
    return twilioSubAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for as caller ID.
   *
   * @param  asCallerID  Boolean
   */
  public void setAsCallerID(Boolean asCallerID) {
    this.asCallerID = asCallerID;
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
   * setter method for is agent call in num.
   *
   * @param  isAgentCallInNum  Boolean
   */
  public void setIsAgentCallInNum(Boolean isAgentCallInNum) {
    this.isAgentCallInNum = isAgentCallInNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone number.
   *
   * @param  phoneNumber  String
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for twilio sub account.
   *
   * @param  twilioSubAccount  TwilioSubAccount
   */
  public void setTwilioSubAccount(TwilioSubAccount twilioSubAccount) {
    this.twilioSubAccount = twilioSubAccount;
  }
} // end class TwilioNumber
