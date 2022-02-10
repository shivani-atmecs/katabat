package com.cmc.credagility.core.domain.client;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store Client information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  $Revision$, 10/14/14 2:42 PM
 */
@Entity
@Table(
    name = "Client",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "identityCode")
    }
)
public class Client extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  private static final long serialVersionUID = -4248231217060699251L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Embedded protected Address address = new Address();

  /** client PK - clientId. */
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long         clientId;

  /** comments. */
  @Column(
    name   = "comments",
    length = 1024
  )
  protected String comments;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "federalIdentificationNum",
    nullable = true,
    length   = 80
  )
  protected String federalIdentificationNum;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "identityCode",
    length   = 36,
    nullable = true
  )
  protected String identityCode;

  /** client name. */
  @Column(
    name     = "name",
    nullable = false,
    length   = 80
  )
  protected String name;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "phoneNum",
    length   = 20,
    nullable = true
  )
  protected String phoneNum;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for serial version UID.
   *
   * @return  long
   */
  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    Client client = (Client) o;

    if ((address != null) ? (!address.equals(client.address)) : (client.address != null)) {
      return false;
    }

    if ((clientId != null) ? (!clientId.equals(client.clientId)) : (client.clientId != null)) {
      return false;
    }

    if ((comments != null) ? (!comments.equals(client.comments)) : (client.comments != null)) {
      return false;
    }

    if ((federalIdentificationNum != null) ? (!federalIdentificationNum.equals(client.federalIdentificationNum))
                                           : (client.federalIdentificationNum != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(client.name)) : (client.name != null)) {
      return false;
    }

    return !((phoneNum != null) ? (!phoneNum.equals(client.phoneNum)) : (client.phoneNum != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address.
   *
   * @return  Address
   */
  public Address getAddress() {
    return address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getClientId() {
    return clientId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getComments() {
    return comments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for full info.
   *
   * @return  String
   */
  public String getCreditorInfo() {
    StringBuffer creditorInfo = new StringBuffer(this.name + ",");

    Address      address = getAddress();
    StringBuffer street  = new StringBuffer();

    if (StringUtils.hasText(address.getAddress1())) {
      street.append(address.getAddress1()).append(" ");
    }

    if (StringUtils.hasText(address.getAddress2())) {
      street.append(address.getAddress2()).append(" ");
    }

    if (StringUtils.hasText(address.getAddress3())) {
      street.append(address.getAddress3()).append(" ");
    }

    if (StringUtils.hasText(address.getAddress4())) {
      street.append(address.getAddress4()).append(" ");
    }

    if (street.length() > 0) {
      creditorInfo.append(street.substring(0, street.length() - 1)).append(",");
    }

    if (StringUtils.hasText(address.getCity())) {
      creditorInfo.append(address.getCity()).append(",");
    }

    if (StringUtils.hasText(address.getProvince())) {
      creditorInfo.append(address.getProvince()).append(",");
    }

    if (StringUtils.hasText(address.getCountry())) {
      creditorInfo.append(address.getCountry()).append(",");
    }

    if (StringUtils.hasText(address.getPostalCode())) {
      creditorInfo.append(address.getPostalCode()).append(",");
    }

    if (creditorInfo.length() > 0) {
      creditorInfo = creditorInfo.deleteCharAt(creditorInfo.length() - 1);
    }

    return creditorInfo.toString();
  } // end method getCreditorInfo

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for federal identification num.
   *
   * @return  String
   */
  public String getFederalIdentificationNum() {
    return federalIdentificationNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getName() {
    return name;
  }

  // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone num.
   *
   * @return  String
   */
  public String getPhoneNum() {
    return phoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((address != null) ? address.hashCode() : 0);
    result = (31 * result) + ((clientId != null) ? clientId.hashCode() : 0);
    result = (31 * result) + ((comments != null) ? comments.hashCode() : 0);
    result = (31 * result) + ((federalIdentificationNum != null) ? federalIdentificationNum.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((phoneNum != null) ? phoneNum.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address.
   *
   * @param  address  Address
   */
  public void setAddress(Address address) {
    this.address = address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientId  DOCUMENT ME!
   */
  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  comments  DOCUMENT ME!
   */
  public void setComments(String comments) {
    this.comments = comments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for federal identification num.
   *
   * @param  federalIdentificationNum  String
   */
  public void setFederalIdentificationNum(String federalIdentificationNum) {
    this.federalIdentificationNum = federalIdentificationNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name  DOCUMENT ME!
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone num.
   *
   * @param  phoneNum  String
   */
  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
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

    retValue.append("Client ( ").append("clientId = ").append(this.clientId).append(TAB).append("comments = ").append(
      this.comments).append(TAB).append("name = ").append(this.name).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class Client
