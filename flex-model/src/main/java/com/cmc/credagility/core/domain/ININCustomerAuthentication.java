package com.cmc.credagility.core.domain;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by huailing on 15/8/12.
 *
 * @author   <a href="mailto:ailing.hu@ozstrategy.com">Ailing Hu</a>
 * @version  08/12/2015 14:16
 */
@Entity
@Table(name = "ININCustomerAuthentication")
public class ININCustomerAuthentication extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2923443645328610583L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "addressVerified",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean addressVerified = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "adminIdVerified",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean adminIdVerified = false;

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
    name   = "callType",
    length = 255
  )
  protected String callType;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "cellPhoneVerified",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean cellPhoneVerified = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "cinVerifed",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean cinVerifed = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "dobVerifed",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean dobVerifed = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "emailVerified",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean emailVerified = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "homePhoneVerified",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean homePhoneVerified = false;

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
    name             = "ininPhoneVerified",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean ininPhoneVerified = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "nameVerifed",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean nameVerifed = false;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "ssnVerified",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean ssnVerified = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "url",
    length = 255
  )
  protected String url;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "workPhoneVerified",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean workPhoneVerified = false;

  @JoinColumn(name = "agentId")
  @ManyToOne(fetch = FetchType.LAZY)
  private User agent;

  @JoinColumn(name = "customerId")
  @ManyToOne(fetch = FetchType.LAZY)
  private Customer customer;

  @JoinColumn(name = "ininCallId")
  @ManyToOne(fetch = FetchType.LAZY)
  private ININCall ininCall;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ININCustomerAuthentication object.
   */
  public ININCustomerAuthentication() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent.
   *
   * @return  User
   */
  public User getAgent() {
    return agent;
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
   * getter method for customer.
   *
   * @return  Customer
   */
  public Customer getCustomer() {
    return customer;
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
   * getter method for inin call.
   *
   * @return  ININCall
   */
  public ININCall getIninCall() {
    return ininCall;
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
   * getter method for address verified.
   *
   * @return  boolean
   */
  public boolean isAddressVerified() {
    return addressVerified;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for admin id verified.
   *
   * @return  boolean
   */
  public boolean isAdminIdVerified() {
    return adminIdVerified;
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
   * getter method for cell phone verified.
   *
   * @return  boolean
   */
  public boolean isCellPhoneVerified() {
    return cellPhoneVerified;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cin verifed.
   *
   * @return  boolean
   */
  public boolean isCinVerifed() {
    return cinVerifed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dob verifed.
   *
   * @return  boolean
   */
  public boolean isDobVerifed() {
    return dobVerifed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email verified.
   *
   * @return  boolean
   */
  public boolean isEmailVerified() {
    return emailVerified;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for home phone verified.
   *
   * @return  boolean
   */
  public boolean isHomePhoneVerified() {
    return homePhoneVerified;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for inin phone verified.
   *
   * @return  boolean
   */
  public boolean isIninPhoneVerified() {
    return ininPhoneVerified;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name verifed.
   *
   * @return  boolean
   */
  public boolean isNameVerifed() {
    return nameVerifed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ssn verified.
   *
   * @return  boolean
   */
  public boolean isSsnVerified() {
    return ssnVerified;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for work phone verified.
   *
   * @return  boolean
   */
  public boolean isWorkPhoneVerified() {
    return workPhoneVerified;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address verified.
   *
   * @param  addressVerified  boolean
   */
  public void setAddressVerified(boolean addressVerified) {
    this.addressVerified = addressVerified;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for admin id verified.
   *
   * @param  adminIdVerified  boolean
   */
  public void setAdminIdVerified(boolean adminIdVerified) {
    this.adminIdVerified = adminIdVerified;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent.
   *
   * @param  agent  User
   */
  public void setAgent(User agent) {
    this.agent = agent;
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
   * setter method for call type.
   *
   * @param  callType  String
   */
  public void setCallType(String callType) {
    this.callType = callType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cell phone verified.
   *
   * @param  cellPhoneVerified  boolean
   */
  public void setCellPhoneVerified(boolean cellPhoneVerified) {
    this.cellPhoneVerified = cellPhoneVerified;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cin verifed.
   *
   * @param  cinVerifed  boolean
   */
  public void setCinVerifed(boolean cinVerifed) {
    this.cinVerifed = cinVerifed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer.
   *
   * @param  customer  Customer
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dob verifed.
   *
   * @param  dobVerifed  boolean
   */
  public void setDobVerifed(boolean dobVerifed) {
    this.dobVerifed = dobVerifed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email verified.
   *
   * @param  emailVerified  boolean
   */
  public void setEmailVerified(boolean emailVerified) {
    this.emailVerified = emailVerified;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for home phone verified.
   *
   * @param  homePhoneVerified  boolean
   */
  public void setHomePhoneVerified(boolean homePhoneVerified) {
    this.homePhoneVerified = homePhoneVerified;
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
   * setter method for inin call.
   *
   * @param  ininCall  ININCall
   */
  public void setIninCall(ININCall ininCall) {
    this.ininCall = ininCall;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for inin phone verified.
   *
   * @param  ininPhoneVerified  boolean
   */
  public void setIninPhoneVerified(boolean ininPhoneVerified) {
    this.ininPhoneVerified = ininPhoneVerified;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name verifed.
   *
   * @param  nameVerifed  boolean
   */
  public void setNameVerifed(boolean nameVerifed) {
    this.nameVerifed = nameVerifed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ssn verified.
   *
   * @param  ssnVerified  boolean
   */
  public void setSsnVerified(boolean ssnVerified) {
    this.ssnVerified = ssnVerified;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for work phone verified.
   *
   * @param  workPhoneVerified  boolean
   */
  public void setWorkPhoneVerified(boolean workPhoneVerified) {
    this.workPhoneVerified = workPhoneVerified;
  }
} // end class ININCustomerAuthentication
