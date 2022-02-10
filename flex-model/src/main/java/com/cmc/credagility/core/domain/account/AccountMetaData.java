package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/15/2014 11:22
 */
@Entity
@Table(
  name              = "AccountMetaData",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "accountNum", "accountMetaDataFieldId" }) },
  indexes           = {
    @Index(
      name          = "meta_boolean_value_idx",
      columnList    = "metaDataBooleanValue"
    ),
    @Index(
      name          = "meta_date_value_idx",
      columnList    = "metaDataDateValue"
    ),
    @Index(
      name          = "meta_decimal_value_idx",
      columnList    = "metaDataDecimalValue"
    ),
    @Index(
      name          = "meta_integer_value_idx",
      columnList    = "metaDataIntegerValue"
    ),
    @Index(
      name          = "meta_long_value_idx",
      columnList    = "metaDataLongValue"

// ),
// @Index(
// name          = "meta_string_value_idx",
// columnList    = "metaDataStringValue"
// ),
// @Index(
// name          = "raw_value_idx",
// columnList    = "value"
    )
  }
)
public class AccountMetaData extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 4149739284317745434L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  public Boolean metaDataBooleanValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "metaDataDateValue",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  public Date metaDataDateValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "metaDataDecimalValue",
    nullable  = true,
    precision = 19,
    scale     = 8
  )
  public BigDecimal metaDataDecimalValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "metaDataIntegerValue",
    nullable = true
  )
  public Integer metaDataIntegerValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "metaDataLongValue",
    nullable = true
  )
  public Long metaDataLongValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "metaDataStringValue",
    nullable = true,
    length   = 2048
  )
  public String metaDataStringValue;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "accountNum",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "accountMetaDataFieldId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected AccountMetaDataField accountMetaDataField;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "accountMetaDataId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long accountMetaDataId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "value",
    length   = 2048,
    nullable = true
  )
  protected String value;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final AccountMetaData other = (AccountMetaData) obj;

    if (this.account == null) {
      if (other.getAccount() != null) {
        return false;
      }
    } else if (!this.account.equals(other.getAccount())) {
      return false;
    }

    if (this.accountMetaDataField == null) {
      if (other.getAccountMetaDataField() != null) {
        return false;
      }
    } else if (!this.accountMetaDataField.equals(other.getAccountMetaDataField())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account meta data field.
   *
   * @return  AccountMetaDataField
   */
  public AccountMetaDataField getAccountMetaDataField() {
    return accountMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account meta data id.
   *
   * @return  Long
   */
  public Long getAccountMetaDataId() {
    return accountMetaDataId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data boolean value.
   *
   * @return  Boolean
   */
  public Boolean getMetaDataBooleanValue() {
    return metaDataBooleanValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data date value.
   *
   * @return  Date
   */
  public Date getMetaDataDateValue() {
    return metaDataDateValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data decimal value.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMetaDataDecimalValue() {
    return metaDataDecimalValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data integer value.
   *
   * @return  Integer
   */
  public Integer getMetaDataIntegerValue() {
    return metaDataIntegerValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data long value.
   *
   * @return  Long
   */
  public Long getMetaDataLongValue() {
    return metaDataLongValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data string value.
   *
   * @return  String
   */
  public String getMetaDataStringValue() {
    return metaDataStringValue;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = 1;
    result = (PRIME * result)
      + ((this.account == null) ? 0 : this.account.hashCode());
    result = (PRIME * result)
      + ((this.accountMetaDataField == null) ? 0 : this.accountMetaDataField.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account meta data field.
   *
   * @param  accountMetaDataField  AccountMetaDataField
   */
  public void setAccountMetaDataField(AccountMetaDataField accountMetaDataField) {
    this.accountMetaDataField = accountMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account meta data id.
   *
   * @param  accountMetaDataId  Long
   */
  public void setAccountMetaDataId(Long accountMetaDataId) {
    this.accountMetaDataId = accountMetaDataId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data boolean value.
   *
   * @param  metaDataBooleanValue  Boolean
   */
  public void setMetaDataBooleanValue(Boolean metaDataBooleanValue) {
    this.metaDataBooleanValue = metaDataBooleanValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data date value.
   *
   * @param  metaDataDateValue  Date
   */
  public void setMetaDataDateValue(Date metaDataDateValue) {
    this.metaDataDateValue = metaDataDateValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data decimal value.
   *
   * @param  metaDataDecimalValue  BigDecimal
   */
  public void setMetaDataDecimalValue(BigDecimal metaDataDecimalValue) {
    this.metaDataDecimalValue = metaDataDecimalValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data integer value.
   *
   * @param  metaDataIntegerValue  Integer
   */
  public void setMetaDataIntegerValue(Integer metaDataIntegerValue) {
    this.metaDataIntegerValue = metaDataIntegerValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data long value.
   *
   * @param  metaDataLongValue  Long
   */
  public void setMetaDataLongValue(Long metaDataLongValue) {
    this.metaDataLongValue = metaDataLongValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data string value.
   *
   * @param  metaDataStringValue  String
   */
  public void setMetaDataStringValue(String metaDataStringValue) {
    this.metaDataStringValue = metaDataStringValue;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateMetaData.
   *
   * @param  metaData  AccountMetaData
   */
  public void updateMetaData(AccountMetaData metaData) {
    this.account              = metaData.getAccount();
    this.accountMetaDataField = metaData.getAccountMetaDataField();
    this.metaDataBooleanValue = metaData.getMetaDataBooleanValue();
    this.metaDataDateValue    = metaData.getMetaDataDateValue();
    this.metaDataDecimalValue = metaData.getMetaDataDecimalValue();
    this.metaDataIntegerValue = metaData.getMetaDataIntegerValue();
    this.metaDataLongValue    = metaData.getMetaDataLongValue();
    this.metaDataStringValue  = metaData.getMetaDataStringValue();
  }
} // end class AccountMetaData
