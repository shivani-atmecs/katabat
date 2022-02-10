package com.cmc.credagility.core.domain.agency;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.Role;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/17/2014 10:03
 */
@Entity public class AgencyMetaData extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -321390184799588407L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agencyId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Role agency;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agencyMetaDataFieldId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected AgencyMetaDataField metaDataField;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy = "metaData",
    cascade  = CascadeType.ALL
  )
  protected AgencyMetaDataValueBoolean metaDataValueBoolean = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy = "metaData",
    cascade  = CascadeType.ALL
  )
  protected AgencyMetaDataValueDate metaDataValueDate = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy = "metaData",
    cascade  = CascadeType.ALL
  )
  protected AgencyMetaDataValueDecimal metaDataValueDecimal = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy = "metaData",
    cascade  = CascadeType.ALL
  )
  protected AgencyMetaDataValueInteger metaDataValueInteger = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy = "metaData",
    cascade  = CascadeType.ALL
  )
  protected AgencyMetaDataValueLong metaDataValueLong = null;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy = "metaData",
    cascade  = CascadeType.ALL
  )
  protected AgencyMetaDataValueString metaDataValueString = null;

  /** TODO: DOCUMENT ME! */
  @Lob protected String textValue;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String value;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency.
   *
   * @return  Role
   */
  public Role getAgency() {
    return agency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data field.
   *
   * @return  AgencyMetaDataField
   */
  public AgencyMetaDataField getMetaDataField() {
    return metaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data value boolean.
   *
   * @return  AgencyMetaDataValueBoolean
   */
  public AgencyMetaDataValueBoolean getMetaDataValueBoolean() {
    return metaDataValueBoolean;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data value date.
   *
   * @return  AgencyMetaDataValueDate
   */
  public AgencyMetaDataValueDate getMetaDataValueDate() {
    return metaDataValueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data value decimal.
   *
   * @return  AgencyMetaDataValueDecimal
   */
  public AgencyMetaDataValueDecimal getMetaDataValueDecimal() {
    return metaDataValueDecimal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data value integer.
   *
   * @return  AgencyMetaDataValueInteger
   */
  public AgencyMetaDataValueInteger getMetaDataValueInteger() {
    return metaDataValueInteger;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data value long.
   *
   * @return  AgencyMetaDataValueLong
   */
  public AgencyMetaDataValueLong getMetaDataValueLong() {
    return metaDataValueLong;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data value string.
   *
   * @return  AgencyMetaDataValueString
   */
  public AgencyMetaDataValueString getMetaDataValueString() {
    return metaDataValueString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for text value.
   *
   * @return  String
   */
  public String getTextValue() {
    return textValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for value.
   *
   * @return  String
   */
  public String getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency.
   *
   * @param  agency  Role
   */
  public void setAgency(Role agency) {
    this.agency = agency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data field.
   *
   * @param  metaDataField  AgencyMetaDataField
   */
  public void setMetaDataField(AgencyMetaDataField metaDataField) {
    this.metaDataField = metaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data value boolean.
   *
   * @param  metaDataValueBoolean  AgencyMetaDataValueBoolean
   */
  public void setMetaDataValueBoolean(AgencyMetaDataValueBoolean metaDataValueBoolean) {
    this.metaDataValueBoolean = metaDataValueBoolean;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data value date.
   *
   * @param  metaDataValueDate  AgencyMetaDataValueDate
   */
  public void setMetaDataValueDate(AgencyMetaDataValueDate metaDataValueDate) {
    this.metaDataValueDate = metaDataValueDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data value decimal.
   *
   * @param  metaDataValueDecimal  AgencyMetaDataValueDecimal
   */
  public void setMetaDataValueDecimal(AgencyMetaDataValueDecimal metaDataValueDecimal) {
    this.metaDataValueDecimal = metaDataValueDecimal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data value integer.
   *
   * @param  metaDataValueInteger  AgencyMetaDataValueInteger
   */
  public void setMetaDataValueInteger(AgencyMetaDataValueInteger metaDataValueInteger) {
    this.metaDataValueInteger = metaDataValueInteger;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data value long.
   *
   * @param  metaDataValueLong  AgencyMetaDataValueLong
   */
  public void setMetaDataValueLong(AgencyMetaDataValueLong metaDataValueLong) {
    this.metaDataValueLong = metaDataValueLong;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data value string.
   *
   * @param  metaDataValueString  AgencyMetaDataValueString
   */
  public void setMetaDataValueString(AgencyMetaDataValueString metaDataValueString) {
    this.metaDataValueString = metaDataValueString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for text value.
   *
   * @param  textValue  String
   */
  public void setTextValue(String textValue) {
    this.textValue = textValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value.
   *
   * @param  value  String
   */
  public void setValue(String value) {
    this.value = value;
  }
} // end class AgencyMetaData
