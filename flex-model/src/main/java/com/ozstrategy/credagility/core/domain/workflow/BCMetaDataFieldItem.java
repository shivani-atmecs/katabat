package com.ozstrategy.credagility.core.domain.workflow;

import com.ozstrategy.credagility.core.util.DataFormatter;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:42
 */
public class BCMetaDataFieldItem {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Long id;

  private String value;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BCMetaDataFieldItem object.
   */
  public BCMetaDataFieldItem() { }

  /**
   * Creates a new BCMetaDataFieldItem object.
   *
   * @param  value  DOCUMENT ME!
   */
  public BCMetaDataFieldItem(String value) {
    this.value = value;
  }

  /**
   * Creates a new BCMetaDataFieldItem object.
   *
   * @param  id     DOCUMENT ME!
   * @param  value  DOCUMENT ME!
   */
  public BCMetaDataFieldItem(Long id, String value) {
    this.id    = id;
    this.value = value;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for boolean value.
   *
   * @return  Boolean
   */
  public Boolean getBooleanValue() {
    if ("Y".equalsIgnoreCase(value) || "YES".equalsIgnoreCase(value) || "true".equalsIgnoreCase(value)) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date value.
   *
   * @return  Date
   */
  public Date getDateValue() {
    if (!StringUtils.hasText(value) || "".equalsIgnoreCase(value)) {
      return null;
    }

    SimpleDateFormat sdf = new SimpleDateFormat(DataFormatter.getDefaultDatePattern());

    try {
      return sdf.parse(value);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for decimal value.
   *
   * @return  BigDecimal
   */
  public BigDecimal getDecimalValue() {
    if (!StringUtils.hasText(value)) {
      return null;
    }

    return BigDecimal.valueOf(new Double(value));
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
   * getter method for int value.
   *
   * @return  Integer
   */
  public Integer getIntValue() {
    if (!StringUtils.hasText(value) || "".equalsIgnoreCase(value)) {
      return null;
    }

    return Integer.parseInt(value);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for long value.
   *
   * @return  Long
   */
  public Long getLongValue() {
    if (!StringUtils.hasText(value) || "".equalsIgnoreCase(value)) {
      return null;
    }

    return new Long(value);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for value.
   *
   * @return  String
   */
  public String getValue() {
    if (!StringUtils.hasText(value) || "".equalsIgnoreCase(value)) {
      return null;
    }

    return value;
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
   * setter method for value.
   *
   * @param  value  String
   */
  public void setValue(String value) {
    this.value = value;
  }
} // end class BCMetaDataFieldItem
