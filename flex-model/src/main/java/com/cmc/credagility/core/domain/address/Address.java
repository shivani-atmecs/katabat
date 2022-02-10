package com.cmc.credagility.core.domain.address;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.springframework.util.StringUtils;


/**
 * This class is used to represent an address1.
 *
 * <p><a href="Address.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * @version  $Revision$, $Date$
 */
@Embeddable public class Address implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  // ~ Static fields/initializers
  // ---------------------------------------------------------------------------------------
  private static final long serialVersionUID = 3617859655330969141L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "address1",
    length = 255
  )
  protected String address1 = "";


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "address2",
    length = 150
  )
  protected String address2 = "";


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "address3",
    length = 150
  )
  protected String address3 = "";

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "address4",
    length = 150
  )
  protected String address4 = "";


  // npelleti Made column non nullable 08/06
  // npelleti Made column nullable 08/19

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "city",
    length = 50 /*, nullable=false*/
  )
  protected String city = "";


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "country",
    length = 100
  )
  protected String country = "";

  // npelleti Add Index postalCodeIndex 08/06

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "postalCode",
    length   = 25,
    nullable = true
  )
  protected String postalCode = "";
  // ~ Instance fields
  // --------------------------------------------------------------------------------------------------


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "province",
    length = 100
  )
  protected String province = "";

  //~ Methods ----------------------------------------------------------------------------------------------------------

  // ~ Methods
  // ----------------------------------------------------------------------------------------------------------

  /**
   * Copy address1.
   *
   * @param  address  $param.type$
   */
  public void deepCopy(Address address) {
    if (address != null) {
      this.address1   = address.getAddress1();
      this.address2   = address.getAddress2();
      this.address3   = address.getAddress3();
      this.address4   = address.getAddress4();
      this.city       = address.getCity();
      this.province   = address.getProvince();
      this.country    = address.getCountry();
      this.postalCode = address.getPostalCode();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof Address)) {
      return false;
    }

    final Address other = (Address) o;

    if ((this.address1 != null) ? (!this.address1.equals(other.getAddress1())) : (other.getAddress1() != null)) {
      return false;
    }

    if ((this.address2 != null) ? (!this.address2.equals(other.getAddress2())) : (other.getAddress2() != null)) {
      return false;
    }

    if ((this.address3 != null) ? (!this.address3.equals(other.getAddress3())) : (other.getAddress3() != null)) {
      return false;
    }

    if ((this.address4 != null) ? (!this.address4.equals(other.getAddress4())) : (other.getAddress4() != null)) {
      return false;
    }

    if ((this.city != null) ? (!this.city.equals(other.getCity())) : (other.getCity() != null)) {
      return false;
    }

    if ((this.country != null) ? (!this.country.equals(other.getCountry())) : (other.getCountry() != null)) {
      return false;
    }

    if ((this.postalCode != null) ? (!this.postalCode.equals(other.getPostalCode()))
                                  : (other.getPostalCode() != null)) {
      return false;
    }

    if ((this.province != null) ? (!this.province.equals(other.getProvince())) : (other.getProvince() != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getAddress1() {
    return address1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getAddress2() {
    return address2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getAddress3() {
    return address3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address4.
   *
   * @return  String
   */
  public String getAddress4() {
    return address4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getBarclayConfirmationAddress() {
    StringBuilder sb = new StringBuilder();
    appendNotNullString(sb, this.getAddress1(), null);
    appendNotNullString(sb, this.getAddress2(), "<br/>");
    appendNotNullString(sb, this.getCity(), "<br/>");
    appendNotNullString(sb, this.getProvince(), ", ");
    sb.append(" ");
    appendNotNullString(sb, this.getPostalCode(), null);

    return sb.toString();

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getCity() {
    return city;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getCountry() {
    return country;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getFullAddress() {
    StringBuilder sb = new StringBuilder();
    appendString(sb, replaceComma(this.address1), null);
    appendString(sb, replaceComma(this.address2), ",");
    appendString(sb, replaceComma(this.address3), ",");
    appendString(sb, replaceComma(this.address4), ",");
    appendString(sb, replaceComma(this.city), ",");
    appendString(sb, replaceComma(this.province), ",");
    appendString(sb, replaceComma(this.postalCode), ",");
    appendString(sb, replaceComma(this.country), ",");

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the full DISPLAY address in one line.
   *
   * @return  the full address
   */
  public String getFullDisplayAddress() {
    StringBuilder sb = new StringBuilder();
    appendNotNullString(sb, this.address1, null);
    appendNotNullString(sb, this.address2, ",");

    if (StringUtils.hasText(this.address3)) {
      appendNotNullString(sb, this.address3, ",");
    }

    appendNotNullString(sb, this.city, ",");
    appendNotNullString(sb, this.province, ",");
    appendNotNullString(sb, this.postalCode, ",");
    appendNotNullString(sb, this.country, ",");

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getPostalCode() {
    return postalCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getProvince() {
    return province;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getSLMFullAddress() {
    StringBuilder sb = new StringBuilder();
    appendString(sb, this.address1, null);
    appendString(sb, this.address2, "~");
    appendString(sb, this.address3, "~");
    appendString(sb, this.address4, "~");
    appendString(sb, this.city, "~");
    appendString(sb, this.province, "~");
    appendString(sb, this.postalCode, "~");
    appendString(sb, this.country, "~");

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether there is text in either address1 or address2.
   *
   * @return  check whether there is text in either address1 or address2.
   */
  public boolean hasAddress1Or2() {
    return StringUtils.hasText(this.address1)
      || StringUtils.hasText(this.address2);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether there is any address info. Partial address is fine. The true condition is that any one of the fields
   * including address1, address2, address 3, city, province and postalCode contains text.
   *
   * @return  check whether there is any address info.
   */
  public boolean hasAddressInfo() {
    return StringUtils.hasText(this.address1)
      || StringUtils.hasText(this.address2) || StringUtils.hasText(this.address3) || StringUtils.hasText(this.city)
      || StringUtils.hasText(this.city)
      || StringUtils.hasText(this.province)
      || StringUtils.hasText(this.postalCode);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result;
    result = ((address1 != null) ? address1.hashCode() : 0);
    result = (29 * result) + ((address2 != null) ? address2.hashCode() : 0);
    result = (29 * result) + ((address3 != null) ? address3.hashCode() : 0);
    result = (29 * result) + ((address4 != null) ? address4.hashCode() : 0);
    result = (29 * result) + ((city != null) ? city.hashCode() : 0);
    result = (29 * result) + ((province != null) ? province.hashCode() : 0);
    result = (29 * result) + ((country != null) ? country.hashCode() : 0);
    result = (29 * result) + ((postalCode != null) ? postalCode.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * Check whether this is an empty or non-valid address. The true condition is that all required fields including
   * address1, city, province and postalCode must have text.
   *
   * <p>This method is useful during ScoreNet account import. May be useful for other import job too.</p>
   *
   * @return  check whether this is an empty or non-valid address.
   */
  public boolean isValidAddress() {
    return StringUtils.hasText(this.address1) && StringUtils.hasText(this.city);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @param   inputString  $param.type$
   *
   * @return  String.
   */
  public String replaceComma(String inputString) {
    if (StringUtils.hasText(inputString)) {
      return inputString.replaceAll(",", " ");
    }

    return "";

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * setAddress1.
   *
   * @param  address  $param.type$
   */
  public void setAddress1(String address) {
    this.address1 = address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * setAddress2.
   *
   * @param  address2  $param.type$
   */
  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * setAddress3.
   *
   * @param  address3  $param.type$
   */
  public void setAddress3(String address3) {
    this.address3 = address3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address4.
   *
   * @param  address4  String
   */
  public void setAddress4(String address4) {
    this.address4 = address4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * setCity.
   *
   * @param  city  $param.type$
   *
   *               <p>type = "required"</p>
   */
  public void setCity(String city) {
    this.city = city;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * setCountry.
   *
   * @param  country  $param.type$
   *
   *                  <p>type = "required"</p>
   */
  public void setCountry(String country) {
    this.country = country;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * setPostalCode.
   *
   * @param  postalCode  $param.type$
   *
   *                     <p>type = "required"</p>
   *
   *                     <p>type = "mask" msgkey = "errors.zip" name = "mask</p>
   */
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * setProvince.
   *
   * @param  province  $param.type$
   *
   *                   <p>type = "required"</p>
   */
  public void setProvince(String province) {
    this.province = province;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append(
        "country", this.country).append("address", this.address1).append(
        "address2", this.address2).append("address3", this.address3).append("address4", this.address4).append(
        "province", this.province).append("postalCode", this.postalCode).append("city", this.city).toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  private void appendNotNullString(StringBuilder sb, String s, String delimiter) {
    if (StringUtils.hasText(s)) {
      if (StringUtils.hasText(delimiter)) {
        sb.append(delimiter);
      }

      sb.append(s);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~
  // ------------------------------------------------------------------------------------------------------------------

  private void appendString(StringBuilder sb, String s, String delimiter) {
    if (StringUtils.hasText(delimiter)) {
      sb.append(delimiter);
    }

    if (StringUtils.hasText(s)) {
      sb.append(s);
    }
  }
} // end class Address
