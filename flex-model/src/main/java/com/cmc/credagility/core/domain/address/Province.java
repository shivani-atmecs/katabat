package com.cmc.credagility.core.domain.address;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/17/2014 10:18
 */
@Entity
@Table(name = "Province")
public class Province extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -928812866780351991L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** country. */
  @JoinColumn(
    name     = "countryId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Country country;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "name",
    length = 100
  )
  protected String name;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "provinceCode",
    length = 10
  )
  protected String provinceCode;

  /** Document PK. */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long provinceId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for country.
   *
   * @return  Country
   */
  public Country getCountry() {
    return country;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for province code.
   *
   * @return  String
   */
  public String getProvinceCode() {
    return provinceCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for province id.
   *
   * @return  Long
   */
  public Long getProvinceId() {
    return provinceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for country.
   *
   * @param  country  Country
   */
  public void setCountry(Country country) {
    this.country = country;
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
   * setter method for province code.
   *
   * @param  provinceCode  String
   */
  public void setProvinceCode(String provinceCode) {
    this.provinceCode = provinceCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for province id.
   *
   * @param  ProvinceId  Long
   */
  public void setProvinceId(Long ProvinceId) {
    this.provinceId = ProvinceId;
  }
} // end class Province
