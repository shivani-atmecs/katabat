package com.cmc.credagility.core.domain.address;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/17/2014 10:23
 */
@Entity
@Table(
  name    = "ZipcodeTimezone",
  indexes = {
    @javax.persistence.Index(
      name = "zipcodeIndex",
      columnList = "zipcode"
    )
  }
)
public class ZipcodeTimezone extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -1744489504524568016L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "isMilitary",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isMilitary;

  /** GMT offset. */
  @Column(name = "offset")
  protected Integer offset;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "zipcode",
    length = 20
  )
  protected String zipcode;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "timezoneId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  Timezone timezone;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for is military.
   *
   * @return  Boolean
   */
  public Boolean getIsMilitary() {
    return isMilitary;
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
   * Timezone.
   *
   * @return  Timezone.
   */
  public Timezone getTimezone() {
    return timezone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getZipcode() {
    return zipcode;
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
   * setter method for is military.
   *
   * @param  isMilitary  Boolean
   */
  public void setIsMilitary(Boolean isMilitary) {
    this.isMilitary = isMilitary;
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
   * setTimezone.
   *
   * @param  timezone  $param.type$
   */
  public void setTimezone(Timezone timezone) {
    this.timezone = timezone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setZipcode.
   *
   * @param  zipcode  $param.type$
   */
  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }
} // end class ZipcodeTimezone
