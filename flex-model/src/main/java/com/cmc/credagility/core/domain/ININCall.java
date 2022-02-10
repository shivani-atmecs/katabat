package com.cmc.credagility.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * Created by huailing on 15/7/31.
 *
 * @author   <a href="mailto:ailing.hu@ozstrategy.com">Ailing Hu</a>
 * @version  08/03/2015 17:01
 */
@Entity
@Table(name = "ININCall")
public class ININCall extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2923443645328610583L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "adminId",
    length = 255
  )
  protected String adminId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "adminIdMatch",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean adminIdMatch = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "agentId",
    nullable = false
  )
  protected Long agentId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "authFlag",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean authFlag = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "callStatus",
    length = 255
  )
  protected String callStatus;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "callType",
    length = 255
  )
  protected String callType;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "cinMatch",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean cinMatch = false;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientId")
  protected Long clientId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "dialed",
    length = 255
  )
  protected String dialed;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "dobMatch",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean dobMatch = false;

  /** TODO: DOCUMENT ME! */
  @Column(name = "fromAgentId")
  protected Long fromAgentId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "id",
    nullable = false,
    unique   = true
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "interactionIdKey",
    length = 255
  )
  protected String interactionIdKey;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "landingView",
    length = 255
  )
  protected String landingView;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "phone",
    length = 255
  )
  protected String phone;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "phoneMatch",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean phoneMatch = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "ssn",
    length = 255
  )
  protected String ssn;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "ssnMatch",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean ssnMatch = false;

  @Column(
    name   = "url",
    length = 750
  )
  private String url;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new LoadININEntityRecord object.
   */
  public ININCall() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for admin id.
   *
   * @return  String
   */
  public String getAdminId() {
    return adminId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent id.
   *
   * @return  Long
   */
  public Long getAgentId() {
    return agentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call status.
   *
   * @return  String
   */
  public String getCallStatus() {
    return callStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call type.
   *
   * @return  String
   */
  public String getCallType() {
    return callType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client id.
   *
   * @return  Long
   */
  public Long getClientId() {
    return clientId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dialed.
   *
   * @return  String
   */
  public String getDialed() {
    return dialed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for from agent id.
   *
   * @return  Long
   */
  public Long getFromAgentId() {
    return fromAgentId;
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
   * getter method for interaction id key.
   *
   * @return  String
   */
  public String getInteractionIdKey() {
    return interactionIdKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for landing view.
   *
   * @return  String
   */
  public String getLandingView() {
    return landingView;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone.
   *
   * @return  String
   */
  public String getPhone() {
    return phone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ssn.
   *
   * @return  String
   */
  public String getSsn() {
    return ssn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for url.
   *
   * @return  String
   */
  public String getUrl() {
    return url;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for admin id match.
   *
   * @return  boolean
   */
  public boolean isAdminIdMatch() {
    return adminIdMatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for auth flag.
   *
   * @return  boolean
   */
  public boolean isAuthFlag() {
    return authFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cin match.
   *
   * @return  boolean
   */
  public boolean isCinMatch() {
    return cinMatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dob match.
   *
   * @return  boolean
   */
  public boolean isDobMatch() {
    return dobMatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone match.
   *
   * @return  boolean
   */
  public boolean isPhoneMatch() {
    return phoneMatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ssn match.
   *
   * @return  boolean
   */
  public boolean isSsnMatch() {
    return ssnMatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for admin id.
   *
   * @param  adminId  String
   */
  public void setAdminId(String adminId) {
    this.adminId = adminId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for admin id match.
   *
   * @param  adminIdMatch  boolean
   */
  public void setAdminIdMatch(boolean adminIdMatch) {
    this.adminIdMatch = adminIdMatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent id.
   *
   * @param  agentId  Long
   */
  public void setAgentId(Long agentId) {
    this.agentId = agentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for auth flag.
   *
   * @param  authFlag  boolean
   */
  public void setAuthFlag(boolean authFlag) {
    this.authFlag = authFlag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call status.
   *
   * @param  callStatus  String
   */
  public void setCallStatus(String callStatus) {
    this.callStatus = callStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call type.
   *
   * @param  callType  String
   */
  public void setCallType(String callType) {
    this.callType = callType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cin match.
   *
   * @param  cinMatch  boolean
   */
  public void setCinMatch(boolean cinMatch) {
    this.cinMatch = cinMatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client id.
   *
   * @param  clientId  Long
   */
  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dialed.
   *
   * @param  dialed  String
   */
  public void setDialed(String dialed) {
    this.dialed = dialed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dob match.
   *
   * @param  dobMatch  boolean
   */
  public void setDobMatch(boolean dobMatch) {
    this.dobMatch = dobMatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for from agent id.
   *
   * @param  fromAgentId  Long
   */
  public void setFromAgentId(Long fromAgentId) {
    this.fromAgentId = fromAgentId;
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
   * setter method for interaction id key.
   *
   * @param  interactionIdKey  String
   */
  public void setInteractionIdKey(String interactionIdKey) {
    this.interactionIdKey = interactionIdKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for landing view.
   *
   * @param  landingView  String
   */
  public void setLandingView(String landingView) {
    this.landingView = landingView;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone.
   *
   * @param  phone  String
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone match.
   *
   * @param  phoneMatch  boolean
   */
  public void setPhoneMatch(boolean phoneMatch) {
    this.phoneMatch = phoneMatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ssn.
   *
   * @param  ssn  String
   */
  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ssn match.
   *
   * @param  ssnMatch  boolean
   */
  public void setSsnMatch(boolean ssnMatch) {
    this.ssnMatch = ssnMatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for url.
   *
   * @param  url  String
   */
  public void setUrl(String url) {
    this.url = url;
  }
} // end class ININCall
