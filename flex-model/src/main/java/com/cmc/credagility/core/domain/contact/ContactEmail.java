package com.cmc.credagility.core.domain.contact;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.channel.EmailType;
import com.cmc.credagility.core.domain.customer.CustomerContactEmail;
import com.cmc.credagility.core.domain.type.ContactChannel;
import com.cmc.credagility.core.domain.type.ContactChannelType;


/**
 * This class is used to store responsible emailAddress contact.
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/14/2014 17:35
 */
@Entity
@Table(
  name    = "ContactEmail",
  indexes = {
    @Index(
      name = "historicalIndex",
      columnList = "historical"
    ),
    @Index(
      name = "optOutIndex",
      columnList = "optOut"
    ),
    @Index(
      name = "emailAddressIndex",
      columnList = "emailAddress"
    )
  }
)
public class ContactEmail extends BaseContact {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5726282642327071972L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Client email update date. */
  @Column(name = "clientEmailUpdateDate")
  @Temporal(TemporalType.DATE)
  protected Date clientEmailUpdateDate;

  /** Email address. */
  @Column(
    name     = "emailAddress",
    length   = 128,
    nullable = false
  )
  protected String emailAddress;

  /** Email count. */
  @Column(name = "emailCount")
  protected Integer emailCount;

  /** Email contact PK emailId. */
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long         emailId;

  /** Email type, Refers {@link EmailType}. */
  @JoinColumn(
    name       = "typeId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected EmailType emailType = new EmailType();

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "permissionType",
    length = 255
  )
  protected String permissionType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * businessEquals.
   *
   * @param   obj  Object
   *
   * @return  boolean
   */
  public boolean businessEquals(Object obj) {
    if (obj == null) {
      return !StringUtils.hasText(this.emailAddress);
    }

    final ContactEmail other = (ContactEmail) obj;

    if (StringUtils.hasText(emailAddress) ^ StringUtils.hasText(other.getEmailAddress())) {
      return false;
    } else if ((emailAddress != null) && !emailAddress.equals(other.getEmailAddress())) {
      return false;
    }

    if (emailType == null) {
      if (other.getEmailType() != null) {
        return false;
      }
    } else if (!emailType.equals(other.getEmailType())) {
      return false;
    }

    return true;
  } // end method businessEquals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  email  ContactEmail
   */
  public void deepCopy(ContactEmail email) {
    if (email != null) {
      super.deepCopy(email);
      this.emailAddress = email.getEmailAddress();
      this.emailType.deepCopy(email.getEmailType());
      this.permissionType = email.getPermissionType();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  email  CustomerContactEmail
   */
  public void deepCopy(CustomerContactEmail email) {
    if (email != null) {
      super.deepCopy(email);
      this.emailAddress = email.getEmailAddress();
      this.emailType.deepCopy(email.getEmailType());
      this.permissionType = email.getPermissionType();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   obj  Object
   *
   * @return  boolean
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

    final ContactEmail other = (ContactEmail) obj;

    if (emailAddress == null) {
      if (other.getEmailAddress() != null) {
        return false;
      }
    } else if (!emailAddress.equals(other.getEmailAddress())) {
      return false;
    }

    if (emailType == null) {
      if (other.getEmailType() != null) {
        return false;
      }
    } else if (!emailType.equals(other.getEmailType())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client email update date.
   *
   * @return  Date
   */
  public Date getClientEmailUpdateDate() {
    return clientEmailUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact channel.
   *
   * @return  ContactChannel
   */
  @Override public ContactChannel getContactChannel() {
    return ContactChannel.toContactChannel(getEmailType().getTypeId(),
        ContactChannelType.EMAIL);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email address.
   *
   * @return  String
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email count.
   *
   * @return  Integer
   */
  public Integer getEmailCount() {
    return emailCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email id.
   *
   * @return  Long
   */
  public Long getEmailId() {
    return emailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email domain.
   *
   * @return  String
   */
  public String getEmailNoDomain() {
    if (StringUtils.hasText(this.emailAddress)) {
      if (this.emailAddress.contains("@")) {
        return this.emailAddress.substring(0, this.emailAddress.indexOf("@"));
      } else {
        return "";
      }
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email type.
   *
   * @return  EmailType
   */
  public EmailType getEmailType() {
    return emailType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for permission type.
   *
   * @return  String
   */
  public String getPermissionType() {
    return permissionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  String
   */
  public String getType() {
    return this.emailType.getTypeCode();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result) + ((emailAddress == null) ? 0 : emailAddress.hashCode());
    result = (prime * result) + ((emailType == null) ? 0 : emailType.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client email update date.
   *
   * @param  clientEmailUpdateDate  Date
   */
  public void setClientEmailUpdateDate(Date clientEmailUpdateDate) {
    this.clientEmailUpdateDate = clientEmailUpdateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email address.
   *
   * @param  emailAddress  String
   */
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email count.
   *
   * @param  emailCount  Integer
   */
  public void setEmailCount(Integer emailCount) {
    this.emailCount = emailCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email id.
   *
   * @param  emailId  Long
   */
  public void setEmailId(Long emailId) {
    this.emailId = emailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email type.
   *
   * @param  emailType  EmailType
   */
  public void setEmailType(EmailType emailType) {
    this.emailType = emailType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for permission type.
   *
   * @param  permissionType  String
   */
  public void setPermissionType(String permissionType) {
    this.permissionType = permissionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("ContactEmail ( ").append(super.toString()).append(TAB).append("emailAddress = ").append(
      this.emailAddress).append(TAB).append("emailId = ").append(this.emailId).append(TAB).append(
      "emailType = ").append(this.emailType).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class ContactEmail
