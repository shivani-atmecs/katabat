package com.cmc.credagility.core.domain.customer;

import com.cmc.credagility.core.domain.channel.EmailType;
import com.cmc.credagility.core.domain.type.ContactChannel;
import com.cmc.credagility.core.domain.type.ContactChannelType;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/14/2014 17:53
 */
@Entity
@Table(
  name    = "CustomerContactEmail",
  indexes = {
    @Index(
      name = "historicalIndex",
      columnList = "historical"
    ), @Index(
      name = "optOutIndex",
      columnList = "optOut"
    ), @Index(
      name = "emailAddressIndex",
      columnList = "emailAddress"
    )
  }
)
public class CustomerContactEmail extends BaseCustomerContact {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3279055585627774133L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientEmailUpdateDate")
  @Temporal(TemporalType.DATE)
  protected Date clientEmailUpdateDate;

  /** Create date. */
  @JoinColumn(
    name       = "creatorId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User creator;

  /** Email address. */
  // npelleti, 07/30, USBank, Added Index
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

  /** Email type. */
  @JoinColumn(
    name       = "typeId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected EmailType emailType = new EmailType();

  /** Last Updater. */
  @JoinColumn(
    name       = "lastUpdaterId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User lastUpdater;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "permissionType",
    length = 255
  )
  protected String permissionType;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "updated",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean updated = Boolean.FALSE;

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

    final CustomerContactEmail other = (CustomerContactEmail) obj;

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

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
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

    final CustomerContactEmail other = (CustomerContactEmail) obj;

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
  public ContactChannel getContactChannel() {
    return ContactChannel.toContactChannel(getEmailType().getTypeId(),
        ContactChannelType.EMAIL);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for creator.
   *
   * @return  User
   */
  public User getCreator() {
    return creator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for creator name.
   *
   * @return  String
   */
  public String getCreatorName() {
    if (getCreator() != null) {
      return getCreator().getFullName();
    } else {
      return "";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the emailAddress
   *
   *          <p>not-null = "true" length = "80" index = "emailAddressIndex"</p>
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getEmailCount() {
    return emailCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get emailAddress id.
   *
   * @return  the emailId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getEmailId() {
    return emailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the emailType
   *
   *          <p>lazy = "false" column = "typeId" not-null = "true" class = "com.cmc.credagility.EmailType" insert =
   *          "true" update = "true" length = "20"</p>
   */
  public EmailType getEmailType() {
    return this.emailType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last updater.
   *
   * @return  User
   */
  public User getLastUpdater() {
    return lastUpdater;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last updater name.
   *
   * @return  String
   */
  public String getLastUpdaterName() {
    if (getLastUpdater() != null) {
      return getLastUpdater().getFullName();
    } else {
      return "";
    }
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
   * getter method for updated.
   *
   * @return  Boolean
   */
  public Boolean getUpdated() {
    return updated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
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
   * setter method for creator.
   *
   * @param  creator  User
   */
  public void setCreator(User creator) {
    this.creator = creator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for creator name.
   *
   * @param  name  String
   */
  public void setCreatorName(String name) { }

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
   * setter method for last updater.
   *
   * @param  lastUpdater  User
   */
  public void setLastUpdater(User lastUpdater) {
    this.lastUpdater = lastUpdater;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last updater name.
   *
   * @param  name  String
   */
  public void setLastUpdaterName(String name) { }

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
   * setter method for updated.
   *
   * @param  updated  Boolean
   */
  public void setUpdated(Boolean updated) {
    this.updated = updated;
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
} // end class CustomerContactEmail
