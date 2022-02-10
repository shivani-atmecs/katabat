package com.cmc.credagility.core.domain.address;

import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/17/2014 10:20
 */
@Entity
@Table(
  name              = "Timezone",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "tzId", "tzCode", "offset" }) }
)
public class Timezone extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 7094158725686900082L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "code",
    length = 20
  )
  protected String code;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "description",
    length = 200
  )
  protected String description;


  /** TODO: DOCUMENT ME! */
  @Column(name = "offset")
  protected Integer offset;

  /** TODO: DOCUMENT ME! */

  @Column(
    name     = "timezoneId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long timezoneId;

  /** TODO: DOCUMENT ME! */

  @Column(
    name   = "tzCode",
    length = 10
  )
  protected String tzCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "tzId",
    length = 200
  )
  protected String tzId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  type  $param.type$
   */
  public void deepCopy(Timezone type) {
    if (type != null) {
      this.timezoneId = type.getTimezoneId();
      this.code       = type.getCode();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof Timezone)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    Timezone timezone = (Timezone) o;

    if ((code != null) ? (!code.equals(timezone.code)) : (timezone.code != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(timezone.description)) : (timezone.description != null)) {
      return false;
    }

    if ((offset != null) ? (!offset.equals(timezone.offset)) : (timezone.offset != null)) {
      return false;
    }

    if ((timezoneId != null) ? (!timezoneId.equals(timezone.timezoneId)) : (timezone.timezoneId != null)) {
      return false;
    }

    if ((tzCode != null) ? (!tzCode.equals(timezone.tzCode)) : (timezone.tzCode != null)) {
      return false;
    }

    if ((tzId != null) ? (!tzId.equals(timezone.tzId)) : (timezone.tzId != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getCode() {
    return this.code;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getOffset() {
    return offset;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getTimezoneId() {
    return timezoneId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tz code.
   *
   * @return  String
   */
  public String getTzCode() {
    return tzCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tz id.
   *
   * @return  String
   */
  public String getTzId() {
    return tzId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((code != null) ? code.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((offset != null) ? offset.hashCode() : 0);
    result = (31 * result) + ((timezoneId != null) ? timezoneId.hashCode() : 0);
    result = (31 * result) + ((tzCode != null) ? tzCode.hashCode() : 0);
    result = (31 * result) + ((tzId != null) ? tzId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setCode.
   *
   * @param  code  name the name to set
   */
  public void setCode(String code) {
    this.code = code;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setDescription.
   *
   * @param  description  $param.type$
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setOffset.
   *
   * @param  offset  timezoneCode
   */
  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTimezoneId.
   *
   * @param  timezoneId  $param.type$
   */
  public void setTimezoneId(Long timezoneId) {
    this.timezoneId = timezoneId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tz code.
   *
   * @param  tzCode  String
   */
  public void setTzCode(String tzCode) {
    this.tzCode = tzCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tz id.
   *
   * @param  tzId  String
   */
  public void setTzId(String tzId) {
    this.tzId = tzId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("Timezone ( ").append("code = ").append(
      this.code).append(TAB).append("description = ").append(this.description).append(" )");

    return retValue.toString();
  }
} // end class Timezone
