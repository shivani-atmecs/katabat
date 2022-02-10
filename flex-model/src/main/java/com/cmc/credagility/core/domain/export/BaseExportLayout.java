package com.cmc.credagility.core.domain.export;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.account.AccountExportLayout;
import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 13:20
 */
@MappedSuperclass public class BaseExportLayout extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String delimiter;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String description;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean historical = Boolean.FALSE;


  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String name;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    BaseExportLayout that = (BaseExportLayout) o;

    if ((delimiter != null) ? (!delimiter.equals(that.delimiter)) : (that.delimiter != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((historical != null) ? (!historical.equals(that.historical)) : (that.historical != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delimiter.
   *
   * @return  String
   */
  public String getDelimiter() {
    return delimiter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for historical.
   *
   * @return  Boolean
   */
  public Boolean getHistorical() {
    if (historical == null) {
      return Boolean.FALSE;
    }

    return historical;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((delimiter != null) ? delimiter.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((historical != null) ? historical.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delimiter.
   *
   * @param  delimiter  String
   */
  public void setDelimiter(String delimiter) {
    this.delimiter = delimiter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for historical.
   *
   * @param  historical  Boolean
   */
  public void setHistorical(Boolean historical) {
    this.historical = historical;
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
   * update.
   *
   * @param  layout  AccountExportLayout
   */
  public void update(AccountExportLayout layout) {
    this.name        = layout.getName();
    this.delimiter   = layout.getDelimiter();
    this.description = layout.getDescription();
  }
} // end class BaseExportLayout
