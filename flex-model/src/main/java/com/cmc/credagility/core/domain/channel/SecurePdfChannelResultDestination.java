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
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.contact.ContactEmail;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 10:06
 */
@Entity
@Table(
  name              = "SecurePdfChannelResultDestination",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "channelResultId", "emailId" }) }
)
public class SecurePdfChannelResultDestination extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "channelResultId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  SecurePdfChannelResult channelResult;


  /** TODO: DOCUMENT ME! */
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

    final SecurePdfChannelResultDestination other = (SecurePdfChannelResultDestination) obj;

    if (id == null) {
      if (other.getId() != null) {
        return false;
      }
    } else if (!id.equals(other.getId())) {
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

    if (channelResult == null) {
      if (other.getChannelResult() != null) {
        return false;
      }
    } else if (!channelResult.equals(
            other.getChannelResult())) {
      return false;
    }


    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel result.
   *
   * @return  SecurePdfChannelResult
   */
  public SecurePdfChannelResult getChannelResult() {
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
      + ((email == null) ? 0 : email.hashCode());
    result = (prime * result)
      + ((channelResult == null) ? 0 : channelResult.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel result.
   *
   * @param  channelResult  SecurePdfChannelResult
   */
  public void setChannelResult(SecurePdfChannelResult channelResult) {
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "SecurePdfChannelResultDestination ( " + super.toString() + TAB
      + "Id = " + this.id + TAB + " )";

    return retValue;
  }
} // end class SecurePdfChannelResultDestination
