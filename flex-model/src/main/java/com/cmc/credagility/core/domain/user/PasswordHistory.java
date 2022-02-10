package com.cmc.credagility.core.domain.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store user password history.
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 16:27
 */
@Entity @Table public class PasswordHistory extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2500649691371134705L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** PK. */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** User history password. */
  @Column(nullable = false)
  protected String password; // required

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "userId",
    nullable   = false,
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User user;

  /** User name. */
  @Column(
    nullable = false,
    length   = 50
  )
  protected String username;

  /** Password versions. */
  @Column(nullable = false)
  protected Integer version = 0;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PasswordHistory that = (PasswordHistory) o;

    if ((password != null) ? (!password.equals(that.password)) : (that.password != null)) {
      return false;
    }

    if ((username != null) ? (!username.equals(that.username)) : (that.username != null)) {
      return false;
    }

    return true;
  } // end method equals

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
   * getter method for password.
   *
   * @return  String
   */
  public String getPassword() {
    return password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user.
   *
   * @return  User
   */
  public User getUser() {
    return user;
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
   * getter method for version.
   *
   * @return  Integer
   */
  public Integer getVersion() {
    return version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((username != null) ? username.hashCode() : 0);
    result = (31 * result) + ((password != null) ? password.hashCode() : 0);

    return result;
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
   * setter method for password.
   *
   * @param  password  String
   */
  public void setPassword(String password) {
    this.password = password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user.
   *
   * @param  user  User
   */
  public void setUser(User user) {
    this.user = user;
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
   * setter method for version.
   *
   * @param  version  Integer
   */
  public void setVersion(Integer version) {
    this.version = version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PasswordHistory");
    sb.append("{id=").append(id);
    sb.append(", user=").append(user);
    sb.append(", username='").append(username).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append(", version=").append(version);
    sb.append('}');

    return sb.toString();
  }
} // end class PasswordHistory
