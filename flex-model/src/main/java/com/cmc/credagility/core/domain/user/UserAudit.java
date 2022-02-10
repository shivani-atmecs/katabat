package com.cmc.credagility.core.domain.user;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmc.credagility.core.domain.type.AuditAction;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 16:57
 */
@Entity
@Table(
  name    = "UserAudit",
  indexes = {
    @Index(
      columnList = "userId",
      name = "userIdIndex"
    ), @Index(
      name = "postalCodeIndex",
      columnList = "postalCode"
    )
  }
)
public class UserAudit extends AbstractUser implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4056827615263788978L;

  /** DOCUMENT ME! */
  protected static final Logger log = LoggerFactory.getLogger(UserAudit.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "action",
    nullable = false,
    length   = 255
  )
  @Enumerated(value = EnumType.STRING)
  public AuditAction action;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "userId",
    nullable = false
  )
  protected Long userId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "username",
    nullable = false,
    length   = 50
  )
  protected String username;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new UserAudit object.
   */
  public UserAudit() { }

  /**
   * Creates a new UserAudit object.
   *
   * @param  user    User
   * @param  action  AuditAction
   */
  public UserAudit(User user, AuditAction action) {
    Date now = new Date();
    this.createDate                   = now;
    this.lastUpdateDate               = now;
    this.creator                      = user.getCreator();
    this.lastUpdater                  = user.getLastUpdater();
    this.userId                       = user.getId();
    this.accountExpired               = user.isAccountExpired();
    this.accountInUse                 = user.isAccountInUse();
    this.accountLocked                = user.isAccountLocked();
    this.address                      = user.getAddress();
    this.allowMail                    = user.getAllowMail();
    this.allowReport                  = user.getAllowReport();
    this.changePassword               = user.isChangePassword();
    this.clientAgentId                = user.getClientAgentId();
    this.commissionRate               = user.getCommissionRate();
    this.credentialsExpired           = user.isCredentialsExpired();
    this.email                        = user.getEmail();
    this.enabled                      = user.isEnabled();
    this.firstName                    = user.getFirstName();
    this.lastAccessTime               = user.getLastAccessTime();
    this.lastLoginDate                = user.getLastLoginDate();
    this.lastLoginFailureDate         = user.getLastLoginFailureDate();
    this.lastName                     = user.getLastName();
    this.loginFailureCount            = user.getLoginFailureCount();
    this.moneyCollected               = user.getMoneyCollected();
    this.moneyPromised                = user.getMoneyPromised();
    this.moneyScheduled               = user.getMoneyScheduled();
    this.numberOfPaymentCollected     = user.getNumberOfPaymentCollected();
    this.numberOfPaymentScheduled     = user.getNumberOfPaymentScheduled();
    this.password                     = user.getPassword();
    this.passwordFailureCount         = user.getPasswordFailureCount();
    this.passwordHint                 = user.getPasswordHint();
    this.passwordStartDate            = user.getPasswordStartDate();
    this.phoneNumber                  = user.getPhoneNumber();
    this.programFultilledCount        = user.getProgramFultilledCount();
    this.programScheduledCount        = user.getProgramScheduledCount();
    this.secondToLastLoginDate        = user.getSecondToLastLoginDate();
    this.secondToLastLoginFailureDate = user.getSecondToLastLoginFailureDate();
    this.username                     = user.getUsername();
    this.website                      = user.getWebsite();

    this.action = action;
  } // end ctor UserAudit

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for user id.
   *
   * @return  Long
   */
  public Long getUserId() {
    return userId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for username.
   *
   * @return  String
   */
  public String getUsername() {
    return username;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action.
   *
   * @param  action  AuditAction
   */
  public void setAction(AuditAction action) {
    this.action = action;
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
   * setter method for user id.
   *
   * @param  userId  Long
   */
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for username.
   *
   * @param  username  String
   */
  public void setUsername(String username) {
    this.username = username;
  }
} // end class UserAudit
