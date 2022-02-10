package com.cmc.credagility.core.domain.address;

import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/17/2014 10:13
 */
@Entity
@Table(
  name    = "AreacodeTimezone",
  indexes = {
    @Index(
      name = "areaCodeIndex",
      columnList = "areacode"
    ),
    @Index(
      name = "prefixCodeIndex",
      columnList = "prefixcode"
    )
  }
)
public class AreacodeTimezone extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 9138003215558881520L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "areacode",
    length = 20
  )
  protected String areacode;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** GMT offset. */
  @Column(name = "offset")
  protected Integer offset;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "prefixcode",
    length = 20
  )
  protected String  prefixcode;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "provinceId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Province province;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "timezoneId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Timezone timezone;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof AreacodeTimezone)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    AreacodeTimezone that = (AreacodeTimezone) o;

    if ((areacode != null) ? (!areacode.equals(that.areacode)) : (that.areacode != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((offset != null) ? (!offset.equals(that.offset)) : (that.offset != null)) {
      return false;
    }

    if ((prefixcode != null) ? (!prefixcode.equals(that.prefixcode)) : (that.prefixcode != null)) {
      return false;
    }

    if ((province != null) ? (!province.equals(that.province)) : (that.province != null)) {
      return false;
    }

    if ((timezone != null) ? (!timezone.equals(that.timezone)) : (that.timezone != null)) {
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
  public String getAreacode() {
    return areacode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getId() {
    return id;
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
   * getter method for prefixcode.
   *
   * @return  String
   */
  public String getPrefixcode() {
    return prefixcode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Province.
   *
   * @return  Province.
   */
  public Province getProvince() {
    return province;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Timezone.
   *
   * @return  Timezone.
   */
  public Timezone getTimezone() {
    return timezone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((areacode != null) ? areacode.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((offset != null) ? offset.hashCode() : 0);
    result = (31 * result) + ((prefixcode != null) ? prefixcode.hashCode() : 0);
    result = (31 * result) + ((province != null) ? province.hashCode() : 0);
    result = (31 * result) + ((timezone != null) ? timezone.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAreacode.
   *
   * @param  areacode  $param.type$
   */
  public void setAreacode(String areacode) {
    this.areacode = areacode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setId.
   *
   * @param  id  $param.type$
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setOffset.
   *
   * @param  offset  $param.type$
   */
  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prefixcode.
   *
   * @param  prefixcode  String
   */
  public void setPrefixcode(String prefixcode) {
    this.prefixcode = prefixcode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setProvince.
   *
   * @param  province  $param.type$
   */
  public void setProvince(Province province) {
    this.province = province;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTimezone.
   *
   * @param  timezone  $param.type$
   */
  public void setTimezone(Timezone timezone) {
    this.timezone = timezone;
  }
} // end class AreacodeTimezone
