package com.cmc.credagility.core.domain.authorizedcontact;

import com.cmc.credagility.core.domain.channel.EmailType;
import com.cmc.credagility.core.domain.type.ContactChannel;
import com.cmc.credagility.core.domain.type.ContactChannelType;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/14/2014 17:44
 */
@Entity
@Table(
  name    = "AuthorizedContactEmail",
  indexes = {
    @Index(
      name = "emailAddressIndex",
      columnList = "emailAddress"
    ),
    @Index(
      name = "historicalIndex",
      columnList = "historical"
    ),
    @Index(
      name = "optOutIndex",
      columnList = "optOut"
    )
  }
)
public class AuthorizedContactEmail extends BaseAuthorizedContact {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3279055585627774133L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  // npelleti, 07/30, USBank, Added Index
  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "emailAddress",
    length   = 128,
    nullable = false
  )
  protected String emailAddress;

  /** TODO: DOCUMENT ME! */
  @Column(name = "emailCount")
  protected Integer emailCount;

  /** Email contact PK emailId. */
  // npelleti, 07/30, USBank, Remove Unique Index.
  @Column(
    name     = "emailId",

    // unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long emailId;

  /** TODO: DOCUMENT ME! */
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

    final AuthorizedContactEmail other = (AuthorizedContactEmail) obj;

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
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  email  AuthorizedContactEmail
   */
  public void deepCopy(AuthorizedContactEmail email) {
    if (email != null) {
      super.deepCopy(email);
      this.emailAddress = email.getEmailAddress();
      this.emailType.deepCopy(email.getEmailType());
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.AbstractBaseContact#equals(java.lang.Object)
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

    final AuthorizedContactEmail other = (AuthorizedContactEmail) obj;

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
   * getter method for contact channel.
   *
   * @return  ContactChannel
   */
  public ContactChannel getContactChannel() {
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
   * getter method for email type.
   *
   * @return  EmailType
   */
  public EmailType getEmailType() {
    return this.emailType;
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
   * Get Email Type lookup code.
   *
   * @return  get Email Type lookup code.
   */
  public String getType() {
    return this.emailType.getTypeCode();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.AbstractBaseContact#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result) + ((emailAddress == null) ? 0 : emailAddress.hashCode());
    result = (prime * result) + ((emailType == null) ? 0 : emailType.hashCode());
    result = (prime * result) + ((emailId == null) ? 0 : emailId.hashCode());

    return result;
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
} // end class AuthorizedContactEmail
