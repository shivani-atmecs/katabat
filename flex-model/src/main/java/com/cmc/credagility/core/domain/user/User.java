package com.cmc.credagility.core.domain.user;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.common.LabelValue;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.twilio.TwilioNumber;
import com.cmc.credagility.core.domain.type.ViewMode;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.cmc.credagility.util.constant.Constants;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * This class is used to generate Spring Validation rules as well as the Hibernate mapping file.
 *
 * <p><a href="User.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>Updated by Dan Kibler (dan@getrolling.com) Extended to
 *           implement Acegi UserDetails interface by David Carter david@carter.net
 * @version  10/15/2014 16:55
 */
@Entity
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class,
  property  = "id",
  scope     = User.class
)
@Table(
  name              = "User",
  uniqueConstraints = { @UniqueConstraint(columnNames = "username") },
  indexes           = {
    @Index(
      name          = "postalCodeIndex",
      columnList    = "postalCode"
    )
  }
)
public class User extends AbstractUser implements Serializable, UserDetails {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3832626162173359411L;

  /** TODO: DOCUMENT ME! */
  protected static final Logger log = LoggerFactory.getLogger(User.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** this is the accountNum agent is currently accessing. */
  /** Account. */
  @JoinColumn(
    name       = "accountNum",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "defaultRoleId",
    updatable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Role defaultRole;

  /** TODO: DOCUMENT ME! */
  @Column(length = 50)
  protected String defaultStationView;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String extension;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** Agent password history. */
  @OneToMany(
    cascade  = CascadeType.ALL,
    fetch    = FetchType.LAZY,
    mappedBy = "user"
  )
  @OrderBy("createDate desc")
  protected Set<PasswordHistory> passwordHistories = new LinkedHashSet<PasswordHistory>();

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "UserRole",
    indexes            = { @Index(columnList = "userId") },
    joinColumns        = {
      @JoinColumn(
        name           = "userId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "roleId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.EAGER,
    cascade = { CascadeType.PERSIST, CascadeType.MERGE }
  )
  protected Set<Role> roles = new HashSet<Role>();

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean twilioClear = false;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "twilioNumberId",
    insertable = false,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected TwilioNumber twilioNumber;

  /** TODO: DOCUMENT ME! */
  protected Long twilioNumberId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "username",
    nullable = false,
    unique   = true,
    length   = 50
  )
  protected String username;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "viewMode",
    length = 20
  )
  @Enumerated(value = EnumType.STRING)
  protected ViewMode viewMode = ViewMode.MANUAL;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new User object.
   */
  public User() { }

  /**
   * Creates a new User object.
   *
   * @param  username  String
   */
  public User(String username) {
    this.username = username;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addLoginFailureCount.
   */
  public void addLoginFailureCount() {
    if (this.loginFailureCount == null) {
      this.loginFailureCount = 1;
    } else {
      this.loginFailureCount++;
    }

    if (loginFailureCount >= retryCount) {
      this.setAccountLocked(true);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addRole.
   *
   * @param  role  Role
   */
  public void addRole(Role role) {
    if (getRoles().add(role)) {
      setUpdateRole();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * auditEquals.
   *
   * @param   that  User
   *
   * @return  boolean
   */
  public boolean auditEquals(User that) {
    if (this == that) {
      return true;
    }

    if ((that == null) || (getClass() != that.getClass())) {
      return false;
    }

    if (accountExpired != that.accountExpired) {
      return false;
    }

    if ((accountInUse != null) ? (!accountInUse.equals(that.accountInUse)) : (that.accountInUse != null)) {
      return false;
    }

    if (accountLocked != that.accountLocked) {
      return false;
    }

    if ((address != null) ? (!address.equals(that.address)) : (that.address != null)) {
      return false;
    }

    if ((allowMail != null) ? (!allowMail.equals(that.allowMail)) : (that.allowMail != null)) {
      return false;
    }

    if ((allowReport != null) ? (!allowReport.equals(that.allowReport)) : (that.allowReport != null)) {
      return false;
    }

    if ((changePassword != null) ? (!changePassword.equals(that.changePassword)) : (that.changePassword != null)) {
      return false;
    }

    if ((clientAgentId != null) ? (!clientAgentId.equals(that.clientAgentId)) : (that.clientAgentId != null)) {
      return false;
    }

    if ((commissionRate != null) ? (!commissionRate.equals(that.commissionRate)) : (that.commissionRate != null)) {
      return false;
    }

    if (credentialsExpired != that.credentialsExpired) {
      return false;
    }

    if ((email != null) ? (!email.equals(that.email)) : (that.email != null)) {
      return false;
    }

    if (enabled != that.enabled) {
      return false;
    }

    if ((firstName != null) ? (!firstName.equals(that.firstName)) : (that.firstName != null)) {
      return false;
    }

    if ((lastAccessTime != null) ? (!lastAccessTime.equals(that.lastAccessTime)) : (that.lastAccessTime != null)) {
      return false;
    }

    if ((lastLoginDate != null) ? (!lastLoginDate.equals(that.lastLoginDate)) : (that.lastLoginDate != null)) {
      return false;
    }

    if ((lastLoginFailureDate != null) ? (!lastLoginFailureDate.equals(that.lastLoginFailureDate))
                                       : (that.lastLoginFailureDate != null)) {
      return false;
    }

    if ((lastName != null) ? (!lastName.equals(that.lastName)) : (that.lastName != null)) {
      return false;
    }

    if ((loginFailureCount != null) ? (!loginFailureCount.equals(that.loginFailureCount))
                                    : (that.loginFailureCount != null)) {
      return false;
    }

    if ((moneyCollected != null) ? (!moneyCollected.equals(that.moneyCollected)) : (that.moneyCollected != null)) {
      return false;
    }

    if ((moneyPromised != null) ? (!moneyPromised.equals(that.moneyPromised)) : (that.moneyPromised != null)) {
      return false;
    }

    if ((moneyScheduled != null) ? (!moneyScheduled.equals(that.moneyScheduled)) : (that.moneyScheduled != null)) {
      return false;
    }

    if ((numberOfPaymentCollected != null) ? (!numberOfPaymentCollected.equals(that.numberOfPaymentCollected))
                                           : (that.numberOfPaymentCollected != null)) {
      return false;
    }

    if ((numberOfPaymentScheduled != null) ? (!numberOfPaymentScheduled.equals(that.numberOfPaymentScheduled))
                                           : (that.numberOfPaymentScheduled != null)) {
      return false;
    }

    if ((password != null) ? (!password.equals(that.password)) : (that.password != null)) {
      return false;
    }

    if ((passwordFailureCount != null) ? (!passwordFailureCount.equals(that.passwordFailureCount))
                                       : (that.passwordFailureCount != null)) {
      return false;
    }

    if ((passwordHint != null) ? (!passwordHint.equals(that.passwordHint)) : (that.passwordHint != null)) {
      return false;
    }

    if ((passwordStartDate != null) ? (!passwordStartDate.equals(that.passwordStartDate))
                                    : (that.passwordStartDate != null)) {
      return false;
    }

    if ((phoneNumber != null) ? (!phoneNumber.equals(that.phoneNumber)) : (that.phoneNumber != null)) {
      return false;
    }

    if ((programFultilledCount != null) ? (!programFultilledCount.equals(that.programFultilledCount))
                                        : (that.programFultilledCount != null)) {
      return false;
    }

    if ((programScheduledCount != null) ? (!programScheduledCount.equals(that.programScheduledCount))
                                        : (that.programScheduledCount != null)) {
      return false;
    }

    if ((secondToLastLoginDate != null) ? (!secondToLastLoginDate.equals(that.secondToLastLoginDate))
                                        : (that.secondToLastLoginDate != null)) {
      return false;
    }

    if ((secondToLastLoginFailureDate != null)
          ? (!secondToLastLoginFailureDate.equals(that.secondToLastLoginFailureDate))
          : (that.secondToLastLoginFailureDate != null)) {
      return false;
    }

    if ((username != null) ? (!username.equals(that.username)) : (that.username != null)) {
      return false;
    }

    if ((website != null) ? (!website.equals(that.website)) : (that.website != null)) {
      return false;
    }

    return true;
  } // end method auditEquals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * canManagePortfolio.
   *
   * @param   portfolioId  String
   *
   * @return  boolean
   */
  public boolean canManagePortfolio(String portfolioId) {
    if (isAdmin()) {
      return true;
    }

    return this.getRoleManagedPortfolioMap().keySet().contains(portfolioId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * clearUpdateAction.
   */
  public void clearUpdateAction() {
    updateAction = null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof User)) {
      return false;
    }

    final User user = (User) o;

    if ((username != null) ? (!username.equals(user.getUsername())) : (user.getUsername() != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.security.core.userdetails.UserDetails#getAuthorities()
   */
  @Override @Transient public Collection<GrantedAuthority> getAuthorities() {
    return Arrays.asList(roles.toArray(new GrantedAuthority[0]));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default role.
   *
   * @return  Role
   */
  public Role getDefaultRole() {
    return defaultRole;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default station view.
   *
   * @return  String
   */
  public String getDefaultStationView() {
    return defaultStationView;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for extension.
   *
   * @return  String
   */
  public String getExtension() {
    return extension;
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
   * getter method for password histories.
   *
   * @return  Set
   */
  public Set<PasswordHistory> getPasswordHistories() {
    return passwordHistories;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role list.
   *
   * @return  List
   */
  @Transient public List<LabelValue> getRoleList() {
    List<LabelValue> userRoles = new ArrayList<LabelValue>();

    if (this.roles != null) {
      for (Iterator<Role> it = roles.iterator(); it.hasNext();) {
        Role role = it.next();

        // convert the user's roles to LabelValue Objects
        userRoles.add(new LabelValue(role.getId().toString(), role.getName()));
      }
    }

    return userRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role managed portfolio map.
   *
   * @return  Map
   */
  public Map<String, Portfolio> getRoleManagedPortfolioMap() {
    Map<String, Portfolio> map = new HashMap<String, Portfolio>();

    for (Role r : roles) {
      for (Portfolio portfolio : r.getRoleManagedPortfolios()) {
        map.put(portfolio.getPortfolioId().toString(), portfolio);
      }
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role maps.
   *
   * @return  Map
   */
  @Transient public Map<Long, String> getRoleMaps() {
    Map<Long, String> data = new HashMap<Long, String>();

    if (this.roles != null) {
      for (Iterator<Role> it = roles.iterator(); it.hasNext();) {
        Role role = it.next();
        data.put(role.getId(), role.getName());
      }
    }

    return data;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for roles.
   *
   * @return  Set
   */
  public Set<Role> getRoles() {
    return roles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role string.
   *
   * @return  String
   */
  @Transient public String getRoleString() {
    StringBuilder sb = new StringBuilder();

    if (this.roles != null) {
      for (Iterator<Role> it = roles.iterator(); it.hasNext();) {
        Role role = it.next();

        // convert the user's roles to LabelValue Objects
        sb.append("," + role.getName());
      }
    }

    return (sb.length() > 0) ? sb.substring(1) : "";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for twilio clear.
   *
   * @return  Boolean
   */
  public Boolean getTwilioClear() {
    return twilioClear;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for twilio number.
   *
   * @return  TwilioNumber
   */
  public TwilioNumber getTwilioNumber() {
    return twilioNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for twilio number id.
   *
   * @return  Long
   */
  public Long getTwilioNumberId() {
    return twilioNumberId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for update action.
   *
   * @return  String
   */
  public String getUpdateAction() {
    return updateAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.security.core.userdetails.UserDetails#getUsername()
   */
  @Override public String getUsername() {
// return escapeString(username);
    return username;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for view mode.
   *
   * @return  ViewMode
   */
  public ViewMode getViewMode() {
    return viewMode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasCmcOnlyRole.
   *
   * @return  boolean
   */
  public boolean hasCmcOnlyRole() {
    for (Role role : roles) {
      if (Boolean.TRUE.equals(role.getCmcOnly())) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasFeature.
   *
   * @param   featureName  String
   *
   * @return  boolean
   */
  public boolean hasFeature(String featureName) {
    if ((roles == null) || !StringUtils.hasText(featureName)
          || (roles.size() <= 0)) {
      return false;
    }

    for (Role role : roles) {
      if (role.hasFeature(featureName)) {
        return true;
      }
    }

    return false;

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    return ((username != null) ? username.hashCode() : 0);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * increasePasswordFailure.
   */
  public void increasePasswordFailure() {
    if (passwordFailureCount == null) {
      passwordFailureCount = 1;
    } else {
      passwordFailureCount++;
    }

    if (passwordFailureCount >= retryCount) {
      this.setAccountLocked(true);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
   */
  @Override public boolean isAccountNonExpired() {
    return !isAccountExpired();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
   */
  @Override public boolean isAccountNonLocked() {
    return !isAccountLocked();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for admin.
   *
   * @return  boolean
   */
  public boolean isAdmin() {
    for (Object obj : getRoles()) {
      Role role = (Role) obj;

      if (Constants.ADMIN_ROLE.equals(role.getName())) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * is Agency Admin Role.
   *
   * @return  is Agency Admin Role.
   */
  public boolean isCallCenterAdmin() {
    for (Object obj : getRoles()) {
      Role role = (Role) obj;

      if (Constants.CALL_CENTER_ADMIN_ROLE.equals(role.getName())) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for credentials expired.
   *
   * @return  boolean
   */
  public boolean isCredentialsExpired() {
    return credentialsExpired;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
   */
  @Override public boolean isCredentialsNonExpired() {
    return !credentialsExpired;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.security.core.userdetails.UserDetails#isEnabled()
   */
  @Override public boolean isEnabled() {
    return enabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * is Manager Role.
   *
   * @return  is Manager Role.
   */
  public boolean isManager() {
    for (Object obj : getRoles()) {
      Role role = (Role) obj;

      if (Constants.MANAGER_ROLE.equals(role.getName())) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * is User Role.
   *
   * @return  is User Role.
   */
  public boolean isUser() {
    for (Object obj : getRoles()) {
      Role role = (Role) obj;

      if (Constants.USER_ROLE.equals(role.getName())) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeRole.
   *
   * @param  role  Role
   */
  public void removeRole(Role role) {
    if (role == null) {
      return;
    }

    for (Role curRole : this.roles) {
      if (curRole.getId().equals(role.getId())) {
        this.roles.remove(curRole);

        return;
      }
    }

    return;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * resetLoginFailureCount.
   */
  public void resetLoginFailureCount() {
    this.loginFailureCount = 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * resetPasswordFailureCount.
   */
  public void resetPasswordFailureCount() {
    passwordFailureCount = 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account expired.
   *
   * @param  accountExpired  boolean
   */
  public void setAccountExpired(boolean accountExpired) {
    this.accountExpired = accountExpired;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account in use.
   *
   * @param  accountInUse  Boolean
   */
  public void setAccountInUse(Boolean accountInUse) {
    this.accountInUse = accountInUse;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account locked.
   *
   * @param  accountLocked  boolean
   */
  public void setAccountLocked(boolean accountLocked) {
    this.accountLocked = accountLocked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for assign team.
   */
  public void setAssignTeam() {
    updateAction = "AssignTeam";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default role.
   *
   * @param  defaultRole  Role
   */
  public void setDefaultRole(Role defaultRole) {
    this.defaultRole = defaultRole;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default station view.
   *
   * @param  defaultStationView  String
   */
  public void setDefaultStationView(String defaultStationView) {
    this.defaultStationView = defaultStationView;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for extension.
   *
   * @param  extension  String
   */
  public void setExtension(String extension) {
    this.extension = extension;
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
   * setter method for password histories.
   *
   * @param  passwordHistories  Set
   */
  public void setPasswordHistories(Set<PasswordHistory> passwordHistories) {
    this.passwordHistories = passwordHistories;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for reset password.
   */
  public void setResetPassword() {
    updateAction = "ResetPassword";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for roles.
   *
   * @param  roles  Set
   */
  public void setRoles(Set<Role> roles) {
    this.roles = roles;
    setUpdateRole();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for twilio clear.
   *
   * @param  twilioClear  Boolean
   */
  public void setTwilioClear(Boolean twilioClear) {
    this.twilioClear = twilioClear;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for twilio number.
   *
   * @param  twilioNumber  TwilioNumber
   */
  public void setTwilioNumber(TwilioNumber twilioNumber) {
    this.twilioNumber = twilioNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for twilio number id.
   *
   * @param  twilioNumberId  Long
   */
  public void setTwilioNumberId(Long twilioNumberId) {
    this.twilioNumberId = twilioNumberId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for un assign team.
   */
  public void setUnAssignTeam() {
    updateAction = "UnAssignTeam";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for update password.
   */
  public void setUpdatePassword() {
    updateAction = "UpdatePassword";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for update role.
   */
  public void setUpdateRole() {
    updateAction = "UpdateRole";
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for view mode.
   *
   * @param  viewMode  ViewMode
   */
  public void setViewMode(ViewMode viewMode) {
    this.viewMode = viewMode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.CreatorEntity#toString()
   */
  @Override public String toString() {
    ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).append("username", this.username)
      .append("enabled", this.enabled).append("accountExpired", this.accountExpired).append(
        "credentialsExpired", this.credentialsExpired).append(
        "accountLocked", this.accountLocked);

    Collection<GrantedAuthority> auths = this.getAuthorities();

    if (auths != null) {
      sb.append("Granted Authorities: ");

      int i = 0;

      for (GrantedAuthority auth : auths) {
        if (i > 0) {
          sb.append(", ");
        }

        i++;
        sb.append(auths.toString());
      }
    } else {
      sb.append("No Granted Authorities");
    }

    return sb.toString();
  } // end method toString

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  user  User
   */
  public void update(User user) {
    this.username      = user.getUsername();
    this.firstName     = user.getFirstName();
    this.lastName      = user.getLastName();
    this.accountLocked = user.isAccountLocked();
    this.enabled       = user.isEnabled();
    this.email         = user.getEmail();
    this.phoneNumber   = user.getPhoneNumber();
    this.clientAgentId = user.getClientAgentId();
    this.defaultRole   = user.getDefaultRole();

    this.loginFailureCount            = user.getLoginFailureCount();
    this.lastAccessTime               = user.getLastAccessTime();
    this.lastLoginDate                = user.getLastLoginDate();
    this.lastLoginFailureDate         = user.getLastLoginFailureDate();
    this.secondToLastLoginDate        = user.getSecondToLastLoginDate();
    this.secondToLastLoginFailureDate = user.getSecondToLastLoginDate();
    this.defaultStationView           = user.getDefaultStationView();
    this.twilioNumberId               = user.getTwilioNumberId();
    this.lastUpdateDate               = new Date();
  }
} // end class User
