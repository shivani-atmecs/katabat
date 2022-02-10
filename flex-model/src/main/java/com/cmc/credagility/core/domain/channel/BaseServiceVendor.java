package com.cmc.credagility.core.domain.channel;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store service vendor information.
 *
 * <p><a href="BaseServiceVendor.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 15:02
 */
@MappedSuperclass public abstract class BaseServiceVendor extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3667808529140408563L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Embedded protected Address address = new Address();

  // npelleti 08/11 made column length 200.

  /** comments. */
  @Column(
    name   = "comments",
    length = 200
  )
  protected String comments;


  /** contact Email. */
  @Column(
    name   = "contactEmail",
    length = 100
  )
  protected String contactEmail;


  /** contact Person. */
  @Column(
    name   = "contactPerson",
    length = 100
  )
  protected String contactPerson;


  /** vendor name. */
  @Column(
    name     = "name",
    length   = 100,
    nullable = false
  )
  protected String name;


  /** vendor phone Number. */
  @Column(
    name   = "phoneNum",
    length = 20
  )
  protected String phoneNum;


  /** vendor service id. */
  @Column(
    name   = "serviceId",
    length = 100
  )
  protected String serviceId;


  /** vendor service Password. */
  @Column(
    name   = "servicePassword",
    length = 20
  )
  protected String servicePassword;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * The vendorId.
   *
   * @return  the vendorId
   */
  public abstract Long getVendorId();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for vendor id.
   *
   * @param  vendorId  Long
   */
  public abstract void setVendorId(Long vendorId);

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

    BaseServiceVendor other = (BaseServiceVendor) obj;

    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }

    return true;
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

  /**
   * The comments.
   *
   * @return  the comments
   *
   *          <p>not-null = "false" length = "200"</p>
   */
  public String getComments() {
    return comments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact email.
   *
   * @return  String
   */
  public String getContactEmail() {
    return contactEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact person.
   *
   * @return  String
   */
  public String getContactPerson() {
    return contactPerson;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The name.
   *
   * @return  the name
   *
   *          <p>not-null = "true" length = "100" unique = "true"</p>
   */
  public String getName() {
    return name;
  }

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
   * getter method for service id.
   *
   * @return  String
   */
  public String getServiceId() {
    return serviceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for service password.
   *
   * @return  String
   */
  public String getServicePassword() {
    return servicePassword;
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
    result = (prime * result) + ((name == null) ? 0 : name.hashCode());

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
   * setter method for comments.
   *
   * @param  comments  String
   */
  public void setComments(String comments) {
    this.comments = comments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact email.
   *
   * @param  contactEmail  String
   */
  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact person.
   *
   * @param  contactPerson  String
   */
  public void setContactPerson(String contactPerson) {
    this.contactPerson = contactPerson;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name.
   *
   * @param  name  String
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
   * setter method for service id.
   *
   * @param  serviceId  String
   */
  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for service password.
   *
   * @param  servicePassword  String
   */
  public void setServicePassword(String servicePassword) {
    this.servicePassword = servicePassword;
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

    retValue.append("BaseServiceVendor ( ").append(super.toString()).append(TAB).append("comments = ").append(
      this.comments).append(TAB).append("name = ").append(this.name).append(TAB).append(" )");

    return retValue.toString();
  }

} // end class BaseServiceVendor
