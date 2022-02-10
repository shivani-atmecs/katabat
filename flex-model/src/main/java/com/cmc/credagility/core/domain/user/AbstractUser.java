package com.cmc.credagility.core.domain.user;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang3.StringEscapeUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 16:10
 */
@MappedSuperclass public class AbstractUser extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected static final Logger log = LoggerFactory.getLogger(AbstractUser.class);

  private static final long serialVersionUID = -3845749392372856326L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1,
    name             = "accountExpired",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean accountExpired;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "accountInUse",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean accountInUse = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1,
    name             = "accountLocked",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean accountLocked;

  /** TODO: DOCUMENT ME! */
  @Embedded protected Address address = new Address();

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable         = true,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowMail;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1,
    name             = "allowReport",
    nullable         = true
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowReport;

  /** Flag for required user change password. */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean changePassword;

  /** Agent Id in client system. */

  @Column(length = 50)
  protected String clientAgentId;

  /** TODO: DOCUMENT ME! */
  @Column(name = "commissionRate")
  protected BigDecimal commissionRate;

  /** TODO: DOCUMENT ME! */
  @Transient protected String confirmPassword;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1,
    name             = "credentialsExpired",
    nullable         = false
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean credentialsExpired;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "email",
    nullable = true,
    length   = 80
  )
  protected String email; // required

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "accountEnabled",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected boolean enabled;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "firstName",
    nullable = false,
    length   = 50
  )
  protected String firstName;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "flowWorkMode",
    length = 100
  )
  protected String flowWorkMode;

  /**
   * DOCUMENT ME! this is for storing the last accessed time,depening on which we will set the time expiration limit for
   * 8 hrs if the account is left inactive
   */
  @Column(name = "lastAccessTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastAccessTime;

  /** last web login date for this accoun. */
  @Column(name = "lastLoginDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastLoginDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lastLoginFailureDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastLoginFailureDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "lastName",
    nullable = false,
    length   = 50
  )
  protected String lastName; // required

  /** TODO: DOCUMENT ME! */
  @Column(name = "loginFailureCount")
  protected Integer loginFailureCount = 0;

  /** TODO: DOCUMENT ME! */
  @Column(name = "moneyCollected")
  protected BigDecimal moneyCollected;

  /** TODO: DOCUMENT ME! */
  @Column(name = "moneyPromised")
  protected BigDecimal moneyPromised;

  /** TODO: DOCUMENT ME! */
  @Column(name = "moneyScheduled")
  protected BigDecimal moneyScheduled;

  /** TODO: DOCUMENT ME! */
  @Column(name = "numberOfPaymentCollected")
  protected Integer numberOfPaymentCollected;

  /** TODO: DOCUMENT ME! */
  @Column(name = "numberOfPaymentScheduled")
  protected Integer numberOfPaymentScheduled;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "password",
    nullable = false
  )
  protected String password; // required

  /** TODO: DOCUMENT ME! */
  @Column protected Integer passwordFailureCount = 0;

  /** TODO: DOCUMENT ME! */
  @Column(name = "passwordHint")
  protected String passwordHint;

  /** TODO: DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         passwordStartDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "phoneNumber",
    length = 20
  )
  protected String phoneNumber;

  /** TODO: DOCUMENT ME! */
  @Column(name = "programFultilledCount")
  protected Integer programFultilledCount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "programScheduledCount")
  protected Integer programScheduledCount;

  /** TODO: DOCUMENT ME! */
  @Transient protected Integer retryCount = 6;

  /** second to last web login date for this accoun. */
  @Column(name = "secondToLastLoginDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date secondToLastLoginDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "secondToLastLoginFailureDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date secondToLastLoginFailureDate;

  /** User upadte action, for logging. */
  @Transient protected String updateAction = null;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "version", /*nullable = false,*/
    length = 11
  )
  @Version protected Integer version = 0;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "website",
    length = 255
  )
  protected String website;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for address.
   *
   * @return  Address
   */
  public Address getAddress() {
    return address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow mail.
   *
   * @return  Boolean
   */
  public Boolean getAllowMail() {
    return allowMail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow report.
   *
   * @return  Boolean
   */
  public Boolean getAllowReport() {
    return allowReport;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client agent id.
   *
   * @return  String
   */
  public String getClientAgentId() {
    return escapeString(clientAgentId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for commission rate.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCommissionRate() {
    return commissionRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for confirm password.
   *
   * @return  String
   */
  public String getConfirmPassword() {
    return escapeString(confirmPassword);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email.
   *
   * @return  String
   */
  public String getEmail() {
    return email;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first name.
   *
   * @return  String
   */
  public String getFirstName() {
// return escapeString(firstName);
    return firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flow work mode.
   *
   * @return  String
   */
  public String getFlowWorkMode() {
    return escapeString(flowWorkMode);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for full name.
   *
   * @return  String
   */
  public String getFullName() {
// return escapeString(firstName + ' ' + lastName);
    return firstName + ' ' + lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last access time.
   *
   * @return  Date
   */
  public Date getLastAccessTime() {
    return lastAccessTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last login date.
   *
   * @return  Date
   */
  public Date getLastLoginDate() {
    return lastLoginDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last login failure date.
   *
   * @return  Date
   */
  public Date getLastLoginFailureDate() {
    return lastLoginFailureDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last name.
   *
   * @return  String
   */
  public String getLastName() {
// return escapeString(lastName);
    return lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for login failure count.
   *
   * @return  Integer
   */
  public Integer getLoginFailureCount() {
    return loginFailureCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for money collected.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMoneyCollected() {
    return moneyCollected;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for money promised.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMoneyPromised() {
    return moneyPromised;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Money scheduled by this agent so far. Some of them may not scheduled.
   *
   * @return  money scheduled by this agent so far.
   */
  public BigDecimal getMoneyScheduled() {
    return moneyScheduled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for number of payment collected.
   *
   * @return  Integer
   */
  public Integer getNumberOfPaymentCollected() {
    return numberOfPaymentCollected;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for number of payment scheduled.
   *
   * @return  Integer
   */
  public Integer getNumberOfPaymentScheduled() {
    return numberOfPaymentScheduled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for password.
   *
   * @return  String
   */
  public String getPassword() {
    return password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for password failure count.
   *
   * @return  Integer
   */
  public Integer getPasswordFailureCount() {
    return passwordFailureCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for password hint.
   *
   * @return  String
   */
  public String getPasswordHint() {
    return escapeString(passwordHint);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for password start date.
   *
   * @return  Date
   */
  public Date getPasswordStartDate() {
    return passwordStartDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone number.
   *
   * @return  String
   */
  public String getPhoneNumber() {
    return escapeString(phoneNumber);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Number of payment program successfully fulfilled by this agent.
   *
   * @return  number of payment program successfully fulfilled by this agent.
   */
  public Integer getProgramFultilledCount() {
    return programFultilledCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Number of payment program scheduled by this agent.
   *
   * @return  number of payment program scheduled by this agent.
   */
  public Integer getProgramScheduledCount() {
    return programScheduledCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for second to last login date.
   *
   * @return  Date
   */
  public Date getSecondToLastLoginDate() {
    return secondToLastLoginDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for second to last login failure date.
   *
   * @return  Date
   */
  public Date getSecondToLastLoginFailureDate() {
    return secondToLastLoginFailureDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for version.
   *
   * @return  Integer
   */
  public Integer getVersion() {
    return version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for website.
   *
   * @return  String
   */
  public String getWebsite() {
    return escapeString(website);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account expired.
   *
   * @return  boolean
   */
  public boolean isAccountExpired() {
    return accountExpired;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account in use.
   *
   * @return  Boolean
   */
  public Boolean isAccountInUse() {
    return accountInUse;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account locked.
   *
   * @return  boolean
   */
  public boolean isAccountLocked() {
    return accountLocked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for change password.
   *
   * @return  Boolean
   */
  public Boolean isChangePassword() {
    if (changePassword != null) {
      return changePassword;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address.
   *
   * @param  address  Address
   */
  public void setAddress(Address address) {
    this.address = address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow mail.
   *
   * @param  allowMail  Boolean
   */
  public void setAllowMail(Boolean allowMail) {
    this.allowMail = allowMail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow report.
   *
   * @param  allowReport  Boolean
   */
  public void setAllowReport(Boolean allowReport) {
    this.allowReport = allowReport;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for change password.
   *
   * @param  changePassword  Boolean
   */
  public void setChangePassword(Boolean changePassword) {
    this.changePassword = changePassword;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client agent id.
   *
   * @param  clientAgentId  String
   */
  public void setClientAgentId(String clientAgentId) {
    this.clientAgentId = clientAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for commission rate.
   *
   * @param  commissionRate  BigDecimal
   */
  public void setCommissionRate(BigDecimal commissionRate) {
    this.commissionRate = commissionRate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for confirm password.
   *
   * @param  confirmPassword  String
   */
  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for credentials expired.
   *
   * @param  credentialsExpired  boolean
   */
  public void setCredentialsExpired(boolean credentialsExpired) {
    this.credentialsExpired = credentialsExpired;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email.
   *
   * @param  email  String
   */
  public void setEmail(String email) {
    this.email = email;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for enabled.
   *
   * @param  enabled  boolean
   */
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for first name.
   *
   * @param  firstName  String
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flow work mode.
   *
   * @param  flowWorkMode  String
   */
  public void setFlowWorkMode(String flowWorkMode) {
    this.flowWorkMode = flowWorkMode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last access time.
   *
   * @param  lastAccessTime  Date
   */
  public void setLastAccessTime(Date lastAccessTime) {
    this.lastAccessTime = lastAccessTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last login date.
   *
   * @param  lastLoginDate  Date
   */
  public void setLastLoginDate(final Date lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last login failure date.
   *
   * @param  lastLoginFailureDate  Date
   */
  public void setLastLoginFailureDate(final Date lastLoginFailureDate) {
    this.lastLoginFailureDate = lastLoginFailureDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last name.
   *
   * @param  lastName  String
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for login failure count.
   *
   * @param  loginFailureCount  Integer
   */
  public void setLoginFailureCount(final Integer loginFailureCount) {
    this.loginFailureCount = loginFailureCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for money collected.
   *
   * @param  moneyCollected  BigDecimal
   */
  public void setMoneyCollected(BigDecimal moneyCollected) {
    this.moneyCollected = moneyCollected;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for money promised.
   *
   * @param  moneyPromised  BigDecimal
   */
  public void setMoneyPromised(BigDecimal moneyPromised) {
    this.moneyPromised = moneyPromised;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for money scheduled.
   *
   * @param  moneyScheduled  BigDecimal
   */
  public void setMoneyScheduled(BigDecimal moneyScheduled) {
    this.moneyScheduled = moneyScheduled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for number of payment collected.
   *
   * @param  numberOfPaymentCollected  Integer
   */
  public void setNumberOfPaymentCollected(Integer numberOfPaymentCollected) {
    this.numberOfPaymentCollected = numberOfPaymentCollected;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for number of payment scheduled.
   *
   * @param  numberOfPaymentScheduled  Integer
   */
  public void setNumberOfPaymentScheduled(Integer numberOfPaymentScheduled) {
    this.numberOfPaymentScheduled = numberOfPaymentScheduled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPassword.
   *
   * @param  password  $param.type$
   *
   *                   <p>type = "required"</p>
   *
   *                   <p>type = "twofields" msgkey = "errors.twofields" -args arg1resource = "user.password" -args
   *                   arg1resource = "user.confirmPassword" -var name = "secondProperty" value = "confirmPassword"</p>
   */
  public void setPassword(String password) {
    this.password = password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for password failure count.
   *
   * @param  passwordFailureCount  Integer
   */
  public void setPasswordFailureCount(Integer passwordFailureCount) {
    this.passwordFailureCount = passwordFailureCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for password hint.
   *
   * @param  passwordHint  String
   */
  public void setPasswordHint(String passwordHint) {
    this.passwordHint = passwordHint;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for password start date.
   *
   * @param  passwordStartDate  Date
   */
  public void setPasswordStartDate(Date passwordStartDate) {
    this.passwordStartDate = passwordStartDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPhoneNumber.
   *
   * @param  phoneNumber  $param.type$
   *
   *                      <p>type = "mask" msgkey = "errors.phone" -var name = "mask" value = "${phone}"</p>
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program fultilled count.
   *
   * @param  programFultilledCount  Integer
   */
  public void setProgramFultilledCount(Integer programFultilledCount) {
    this.programFultilledCount = programFultilledCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program scheduled count.
   *
   * @param  programScheduledCount  Integer
   */
  public void setProgramScheduledCount(Integer programScheduledCount) {
    this.programScheduledCount = programScheduledCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for retry count.
   *
   * @param  retryCount  Integer
   */
  public void setRetryCount(Integer retryCount) {
    this.retryCount = retryCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for second to last login date.
   *
   * @param  secondToLastLoginDate  Date
   */
  public void setSecondToLastLoginDate(final Date secondToLastLoginDate) {
    this.secondToLastLoginDate = secondToLastLoginDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for second to last login failure date.
   *
   * @param  secondToLastLoginFailureDate  Date
   */
  public void setSecondToLastLoginFailureDate(final Date secondToLastLoginFailureDate) {
    this.secondToLastLoginFailureDate = secondToLastLoginFailureDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for version.
   *
   * @param  version  Integer
   */
  public void setVersion(Integer version) {
    this.version = version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for website.
   *
   * @param  website  String
   */
  public void setWebsite(String website) {
    this.website = website;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * escapeString.
   *
   * @param   val  String
   *
   * @return  String
   */
  protected String escapeString(String val) {
    if (StringUtils.hasText(val)) {
      val = StringEscapeUtils.escapeHtml4(val);
      val = StringEscapeUtils.escapeEcmaScript(val);
    }

    return val;
  }


} // end class AbstractUser
