package com.cmc.credagility.core.domain.twilio;

import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  08/19/2015 10:43
 */
@Entity
@Table(name = "TwilioSubAccount")
public class TwilioSubAccount extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -467828296573116177L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected String accountSid;


  /** TODO: DOCUMENT ME! */
  protected String authToken;

  /** TODO: DOCUMENT ME! */
  @Column(length = 500)
  protected String callBackBaseDomain;


  /** TODO: DOCUMENT ME! */
  protected String description;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  protected String name;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account sid.
   *
   * @return  String
   */
  public String getAccountSid() {
    return accountSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for auth token.
   *
   * @return  String
   */
  public String getAuthToken() {
    return authToken;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call back base domain.
   *
   * @return  String
   */
  public String getCallBackBaseDomain() {
    return callBackBaseDomain;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
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
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account sid.
   *
   * @param  accountSid  String
   */
  public void setAccountSid(String accountSid) {
    this.accountSid = accountSid;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for auth token.
   *
   * @param  authToken  String
   */
  public void setAuthToken(String authToken) {
    this.authToken = authToken;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call back base domain.
   *
   * @param  callBackBaseDomain  String
   */
  public void setCallBackBaseDomain(String callBackBaseDomain) {
    this.callBackBaseDomain = callBackBaseDomain;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
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
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }
} // end class TwilioSubAccount
