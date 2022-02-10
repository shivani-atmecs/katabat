package com.cmc.credagility.core.domain.channel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.contact.ContactEmail;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 11:47
 */
@Entity
@Table(name = "EmailChannelResultDestination")
public class EmailChannelResultDestination extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Pk. */
  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** Email Channel Result! */
  @JoinColumn(
    name     = "channelResultId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  EmailChannelResult channelResult;


  /** Contact email. */
  @JoinColumn(
    name     = "emailId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  ContactEmail email;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final EmailChannelResultDestination other = (EmailChannelResultDestination) obj;

    if (channelResult == null) {
      if (other.getChannelResult() != null) {
        return false;
      }
    } else if (!channelResult.equals(
            other.getChannelResult())) {
      return false;
    }

    if (email == null) {
      if (other.getEmail() != null) {
        return false;
      }
    } else if (!email.equals(
            other.getEmail())) {
      return false;
    }

    if (id == null) {
      if (other.getId() != null) {
        return false;
      }
    } else if (!id.equals(other.getId())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel result.
   *
   * @return  EmailChannelResult
   */
  public EmailChannelResult getChannelResult() {
    return channelResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email.
   *
   * @return  ContactEmail
   */
  public ContactEmail getEmail() {
    return email;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((this.email == null) ? 0 : email.hashCode())
      + ((this.channelResult == null) ? 0 : channelResult.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel result.
   *
   * @param  channelResult  EmailChannelResult
   */
  public void setChannelResult(EmailChannelResult channelResult) {
    this.channelResult = channelResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email.
   *
   * @param  email  ContactEmail
   */
  public void setEmail(ContactEmail email) {
    this.email = email;
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


} // end class EmailChannelResultDestination
