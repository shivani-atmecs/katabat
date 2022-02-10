package com.cmc.credagility.core.security;

import java.io.Serializable;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import org.springframework.util.Assert;


/**
 * Created by rojer on 14-10-12.
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo</a>
 * @version  10/19/2014 00:08
 */
public class LoginCustomer extends User {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private boolean               accountNonExpired;
  private boolean               accountNonLocked;
  private Set<GrantedAuthority> authorities;
  private boolean               credentialsNonExpired;
  private Long                  customerId;
  private String                displayName;
  private boolean               enabled;
  private String                password;
  private String                userLogon;

  private final Collection<String> userLogonList;
  private String                   username; // ucid

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new LoginUser object.
   *
   * @param   customerId             Long
   * @param   displayName            String
   * @param   enabled                DOCUMENT ME!
   * @param   accountNonExpired      DOCUMENT ME!
   * @param   credentialsNonExpired  DOCUMENT ME!
   * @param   accountNonLocked       DOCUMENT ME!
   * @param   authorities            DOCUMENT ME!
   * @param   userLogonList          Collection
   * @param   userLogon              String
   *
   * @throws  IllegalArgumentException  DOCUMENT ME!
   */
  public LoginCustomer(Long customerId, String displayName, boolean enabled,
    boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
    Collection<GrantedAuthority> authorities, Collection<String> userLogonList, String userLogon) {
    this(customerId, customerId.toString(), displayName, customerId.toString(), enabled, accountNonExpired,
      credentialsNonExpired, accountNonLocked, authorities, userLogonList, userLogon);
  }

  /**
   * Creates a new LoginCustomer object.
   *
   * @param   customerId             Long
   * @param   username               String
   * @param   displayName            String
   * @param   password               String
   * @param   enabled                boolean
   * @param   accountNonExpired      boolean
   * @param   credentialsNonExpired  boolean
   * @param   accountNonLocked       boolean
   * @param   authorities            Collection
   * @param   userLogonList          Collection
   * @param   userLogon              String
   *
   * @throws  IllegalArgumentException  exception
   */
  public LoginCustomer(Long customerId, String username, String displayName, String password, boolean enabled,
    boolean accountNonExpired,
    boolean credentialsNonExpired, boolean accountNonLocked, Collection<GrantedAuthority> authorities,
    Collection<String> userLogonList, String userLogon) {
    super(username, password, enabled, accountNonExpired,
      credentialsNonExpired, accountNonLocked, authorities);

    if (((username == null) || "".equals(username)) || (password == null)) {
      throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
    }

    this.customerId            = customerId;
    this.displayName           = displayName;
    this.username              = username;
    this.password              = password;
    this.enabled               = enabled;
    this.accountNonExpired     = accountNonExpired;
    this.credentialsNonExpired = credentialsNonExpired;
    this.accountNonLocked      = accountNonLocked;
    this.authorities           = Collections.unmodifiableSet(sortAuthorities(authorities));
    this.userLogonList         = userLogonList;
    this.userLogon             = userLogon;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.security.core.userdetails.User#getAuthorities()
   */
  @Override public Set<GrantedAuthority> getAuthorities() {
    return authorities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer id.
   *
   * @return  Long
   */
  public Long getCustomerId() {
    return customerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for display name.
   *
   * @return  String
   */
  public String getDisplayName() {
    return displayName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.security.core.userdetails.User#getPassword()
   */
  @Override public String getPassword() {
    return password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user logon.
   *
   * @return  String
   */
  public String getUserLogon() {
    return userLogon;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user logon list.
   *
   * @return  Collection
   */
  public Collection<String> getUserLogonList() {
    return userLogonList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.security.core.userdetails.User#getUsername()
   */
  @Override public String getUsername() {
    return username;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int code = 31;

    for (GrantedAuthority authority : getAuthorities()) {
      code = code * (authority.hashCode());
    }

    if (this.getPassword() != null) {
      code = code * (this.getPassword().hashCode());
    }

    if (this.getUsername() != null) {
      code = code * (this.getUsername().hashCode());
    }

    if (this.isAccountNonExpired()) {
      code = code * -2;
    }

    if (this.isAccountNonLocked()) {
      code = code * -3;
    }

    if (this.isCredentialsNonExpired()) {
      code = code * -5;
    }

    if (this.isEnabled()) {
      code = code * -7;
    }

    return code;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.security.core.userdetails.User#isAccountNonExpired()
   */
  @Override public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.security.core.userdetails.User#isAccountNonLocked()
   */
  @Override public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.security.core.userdetails.User#isCredentialsNonExpired()
   */
  @Override public boolean isCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.security.core.userdetails.User#isEnabled()
   */
  @Override public boolean isEnabled() {
    return enabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account non expired.
   *
   * @param  accountNonExpired  boolean
   */
  public void setAccountNonExpired(boolean accountNonExpired) {
    this.accountNonExpired = accountNonExpired;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account non locked.
   *
   * @param  accountNonLocked  boolean
   */
  public void setAccountNonLocked(boolean accountNonLocked) {
    this.accountNonLocked = accountNonLocked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for authorities.
   *
   * @param  authorities  Set
   */
  public void setAuthorities(Set<GrantedAuthority> authorities) {
    this.authorities = authorities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for credentials non expired.
   *
   * @param  credentialsNonExpired  boolean
   */
  public void setCredentialsNonExpired(boolean credentialsNonExpired) {
    this.credentialsNonExpired = credentialsNonExpired;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer id.
   *
   * @param  customerId  Long
   */
  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for display name.
   *
   * @param  displayName  String
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
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
   * setter method for password.
   *
   * @param  password  String
   */
  public void setPassword(String password) {
    this.password = password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user logon.
   *
   * @param  userLogon  String
   */
  public void setUserLogon(String userLogon) {
    this.userLogon = userLogon;
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
   * @see  Object#toString()
   */
  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString()).append(": ");
    sb.append("Username: ").append(this.username).append("; ");
    sb.append("Password: [PROTECTED]; ");
    sb.append("UCID: ").append(this.username).append("; ");
    sb.append("Enabled: ").append(this.enabled).append("; ");
    sb.append("AccountNonExpired: ").append(this.accountNonExpired).append("; ");
    sb.append("credentialsNonExpired: ").append(this.credentialsNonExpired).append("; ");
    sb.append("AccountNonLocked: ").append(this.accountNonLocked).append("; ");

    if (!authorities.isEmpty()) {
      sb.append("Granted Authorities: ");

      boolean first = true;

      for (GrantedAuthority auth : authorities) {
        if (!first) {
          sb.append(",");
        }

        first = false;

        sb.append(auth);
      }
    } else {
      sb.append("Not granted any authorities");
    }

    return sb.toString();
  } // end method toString

  //~ ------------------------------------------------------------------------------------------------------------------

  private static SortedSet<GrantedAuthority> sortAuthorities(Collection<GrantedAuthority> authorities) {
    Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");

    // Ensure array iteration order is predictable (as per UserDetails.getAuthorities() contract and SEC-717)
    SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<GrantedAuthority>(new AuthorityComparator());

    for (GrantedAuthority grantedAuthority : authorities) {
      Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
      sortedAuthorities.add(grantedAuthority);
    }

    return sortedAuthorities;
  }

  //~ Inner Classes ----------------------------------------------------------------------------------------------------

  private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
    //~ Static fields/initializers -------------------------------------------------------------------------------------

    /** Use serialVersionUID for interoperability. */
    private static final long serialVersionUID = -741004248885463987L;

    //~ Methods --------------------------------------------------------------------------------------------------------

    @Override public int compare(GrantedAuthority g1, GrantedAuthority g2) {
      // Neither should ever be null as each entry is checked before adding it to the set.
      // If the authority is null, it is a custom authority and should precede others.
      if (g2.getAuthority() == null) {
        return -1;
      }

      if (g1.getAuthority() == null) {
        return 1;
      }

      return g1.getAuthority().compareTo(g2.getAuthority());
    }
  }
} // end class LoginCustomer
