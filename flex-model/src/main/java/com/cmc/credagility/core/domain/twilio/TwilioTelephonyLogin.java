package com.cmc.credagility.core.domain.twilio;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.User;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 17:20
 */
@Entity
@Table(name = "TwilioTelephonyLogin")
public class TwilioTelephonyLogin extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7782569674520482206L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name       = "agentId",
    insertable = true,
    updatable  = true,
    nullable   = false,
    unique     = true
  )
  @OneToOne(fetch = FetchType.LAZY)
  private User agent;

  @Column(
    name     = "expirationDate",
    nullable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  private Date expirationDate;

  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  @Column(
    name     = "verificationCode",
    nullable = false,
    unique   = true,
    length   = 255
  )
  private String verificationCode;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    TwilioTelephonyLogin that = (TwilioTelephonyLogin) o;

    if ((agent != null) ? (!agent.equals(that.agent)) : (that.agent != null)) {
      return false;
    }

    if ((expirationDate != null) ? (!expirationDate.equals(that.expirationDate)) : (that.expirationDate != null)) {
      return false;
    }

    if ((verificationCode != null) ? (!verificationCode.equals(that.verificationCode))
                                   : (that.verificationCode != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * getter method for expiration date.
   *
   * @return  Date
   */
  public Date getExpirationDate() {
    return expirationDate;
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
   * getter method for verification code.
   *
   * @return  String
   */
  public String getVerificationCode() {
    return verificationCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((agent != null) ? agent.hashCode() : 0);
    result = (31 * result) + ((expirationDate != null) ? expirationDate.hashCode() : 0);
    result = (31 * result) + ((verificationCode != null) ? verificationCode.hashCode() : 0);

    return result;
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
   * setter method for expiration date.
   *
   * @param  expirationDate  Date
   */
  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
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
   * setter method for verification code.
   *
   * @param  verificationCode  String
   */
  public void setVerificationCode(String verificationCode) {
    this.verificationCode = verificationCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "TwilioTelephonyLogin{"
      + "id=" + id
      + ", agent=" + agent.getUsername()
      + ", verificationCode='" + verificationCode + '\''
      + ", expirationDate=" + expirationDate
      + '}';
  }
} // end class TwilioTelephonyLogin
