package com.cmc.credagility.core.domain.dataexport;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.base.AbstractBaseActionResult;
import com.cmc.credagility.core.domain.util.DateUtil;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.ozstrategy.credagility.core.domain.DataExportAction;


/**
 * Created by yongliu on 2/17/17.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  02/17/2017 14:06
 */
@Entity
@Table(
  name    = "DataExportResult",
  indexes = {
    @Index(
      name = "createDateIndex",
      columnList = "createDate"
    ),
    @Index(
      name = "ruleBatchIdIndex",
      columnList = "ruleBatchId"
    ),
    @Index(
      name = "sourceIndex",
      columnList = "source"
    ),
    @Index(
      name = "statusIndex",
      columnList = "status"
    ),
    @Index(
      name = "strategyDateIndex",
      columnList = "strategyDate"
    )
  }
)
public class DataExportResult extends AbstractBaseActionResult {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6735414337461380817L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Column(
    name     = "dateValue",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  public Date dateValue;

  /** DOCUMENT ME! */
  @Column(
    name     = "booleanValue",
    nullable = true
  )
  @Type(type = "yes_no")
  protected Boolean booleanValue;

  /** DOCUMENT ME! */
  @Column(nullable = false)
  protected String dataType;

  /** DOCUMENT ME! */
  @Column(
    name      = "decimalValue",
    nullable  = true,
    precision = 19,
    scale     = 8
  )
  protected BigDecimal decimalValue;

  /** DOCUMENT ME! */
  @Column(
    name     = "integerValue",
    nullable = true
  )
  protected Integer integerValue;

  /** DOCUMENT ME! */
  @Column(
    name     = "longValue",
    nullable = true
  )
  protected Long longValue;

  /** DOCUMENT ME! */
  @Column(
    name     = "stringValue",
    length   = 2048,
    nullable = true
  )
  protected String stringValue;

  /** DOCUMENT ME! */
  @Column(nullable = true)
  protected String value;

  @JoinColumn(
    name     = "actionId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private DataExportAction action;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  @JoinColumn(
    name     = "variableId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private BaseVariable variable;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * clearValue.
   */
  public void clearValue() {
    this.setBooleanValue(null);
    this.setDateValue(null);
    this.setDecimalValue(null);
    this.setIntegerValue(null);
    this.setLongValue(null);
    this.setStringValue(null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * detectDataType.
   *
   * @param  businessDataType  String
   */
  public void detectDataType(String businessDataType) {
    if ("String".equalsIgnoreCase(businessDataType)) {
      dataType = "String";
    } else if ("Currency".equalsIgnoreCase(businessDataType)) {
      dataType = "BigDecimal";
    } else if ("Percentage".equalsIgnoreCase(businessDataType)) {
      dataType = "BigDecimal";
    } else if ("Decimal".equalsIgnoreCase(businessDataType)) {
      dataType = "BigDecimal";
    } else if ("Integer".equalsIgnoreCase(businessDataType)) {
      dataType = "Long";
    } else if ("Boolean".equalsIgnoreCase(businessDataType)) {
      dataType = "Boolean";
    } else if ("Date".equalsIgnoreCase(businessDataType)) {
      dataType = "Date";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.AbstractBaseActionResult#equals(java.lang.Object)
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

    DataExportResult that = (DataExportResult) o;

    if ((action != null) ? (!action.equals(that.action)) : (that.action != null)) {
      return false;
    }

    if ((variable != null) ? (!variable.equals(that.variable)) : (that.variable != null)) {
      return false;
    }

    if ((dateValue != null) ? (!dateValue.equals(that.dateValue)) : (that.dateValue != null)) {
      return false;
    }

    if ((dataType != null) ? (!dataType.equals(that.dataType)) : (that.dataType != null)) {
      return false;
    }

    if ((booleanValue != null) ? (!booleanValue.equals(that.booleanValue)) : (that.booleanValue != null)) {
      return false;
    }

    if ((decimalValue != null) ? (!decimalValue.equals(that.decimalValue)) : (that.decimalValue != null)) {
      return false;
    }

    if ((integerValue != null) ? (!integerValue.equals(that.integerValue)) : (that.integerValue != null)) {
      return false;
    }

    if ((longValue != null) ? (!longValue.equals(that.longValue)) : (that.longValue != null)) {
      return false;
    }

    if ((stringValue != null) ? (!stringValue.equals(that.stringValue)) : (that.stringValue != null)) {
      return false;
    }

    return (value != null) ? value.equals(that.value) : (that.value == null);

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action.
   *
   * @return  DataExportAction
   */
  public DataExportAction getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for boolean value.
   *
   * @return  Boolean
   */
  public Boolean getBooleanValue() {
    return booleanValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data type.
   *
   * @return  String
   */
  public String getDataType() {
    return dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data value.
   *
   * @return  Object
   */
  public Object getDataValue() {
    String type = this.dataType;

    if ("Integer".equalsIgnoreCase(type)
          || "java.lang.Integer".equalsIgnoreCase(type)) {
      return getIntegerValue();
    } else if ("Long".equalsIgnoreCase(type)
          || "java.lang.Long".equalsIgnoreCase(type)) {
      return getLongValue();
    } else if ("BigDecimal".equalsIgnoreCase(type)
          || "java.math.BigDecimal".equalsIgnoreCase(type)) {
      if (StringUtils.hasText(value)) {
        try {
          return new BigDecimal(value);
        } catch (Exception e) { }
      }

      return getDecimalValue();
    } else if ("Boolean".equalsIgnoreCase(type)
          || "java.lang.Boolean".equalsIgnoreCase(type)) {
      return getBooleanValue();
    } else if ("Date".equalsIgnoreCase(type)
          || "java.util.Date".equalsIgnoreCase(type)) {
      return getDateValue();
    } else if ("String".equalsIgnoreCase(type)
          || "java.lang.String".equalsIgnoreCase(type)) {
      return getStringValue();
    }

    return null;
  } // end method getDataValue

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for date value.
   *
   * @return  Date
   */
  public Date getDateValue() {
    return dateValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for decimal value.
   *
   * @return  BigDecimal
   */
  public BigDecimal getDecimalValue() {
    return decimalValue;
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
   * getter method for integer value.
   *
   * @return  Integer
   */
  public Integer getIntegerValue() {
    return integerValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for long value.
   *
   * @return  Long
   */
  public Long getLongValue() {
    return longValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for string value.
   *
   * @return  String
   */
  public String getStringValue() {
    return stringValue;
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
   * getter method for variable.
   *
   * @return  BaseVariable
   */
  public BaseVariable getVariable() {
    return variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.AbstractBaseActionResult#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((action != null) ? action.hashCode() : 0);
    result = (31 * result) + ((variable != null) ? variable.hashCode() : 0);
    result = (31 * result) + ((dateValue != null) ? dateValue.hashCode() : 0);
    result = (31 * result) + ((dataType != null) ? dataType.hashCode() : 0);
    result = (31 * result) + ((booleanValue != null) ? booleanValue.hashCode() : 0);
    result = (31 * result) + ((decimalValue != null) ? decimalValue.hashCode() : 0);
    result = (31 * result) + ((integerValue != null) ? integerValue.hashCode() : 0);
    result = (31 * result) + ((longValue != null) ? longValue.hashCode() : 0);
    result = (31 * result) + ((stringValue != null) ? stringValue.hashCode() : 0);
    result = (31 * result) + ((value != null) ? value.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action.
   *
   * @param  action  DataExportAction
   */
  public void setAction(DataExportAction action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for boolean value.
   *
   * @param  booleanValue  Boolean
   */
  public void setBooleanValue(Boolean booleanValue) {
    this.booleanValue = booleanValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data type.
   *
   * @param  dataType  String
   */
  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data value.
   *
   * @param  value  Object
   */
  public void setDataValue(Object value) {
    String type = this.dataType;
    clearValue();

    String tempValue = (value != null) ? value.toString() : null;

    this.value = tempValue;

    if ("Integer".equalsIgnoreCase(type)
          || "java.lang.Integer".equalsIgnoreCase(type)) {
      setIntegerValue((tempValue != null) ? new Integer(tempValue) : null);
    } else if ("Long".equalsIgnoreCase(type)
          || "java.lang.Long".equalsIgnoreCase(type)) {
      setLongValue((tempValue != null) ? new Long(tempValue) : null);
    } else if ("BigDecimal".equalsIgnoreCase(type)
          || "java.math.BigDecimal".equalsIgnoreCase(type)) {
      BigDecimal metaValue = (tempValue != null) ? new BigDecimal(tempValue.replaceAll(",", "")) : null;
      setDecimalValue(metaValue);
      this.value = metaValue.toPlainString();
    } else if ("Boolean".equalsIgnoreCase(type)
          || "java.lang.Boolean".equalsIgnoreCase(type)) {
      setBooleanValue(new Boolean(tempValue));
    } else if ("Date".equalsIgnoreCase(type)
          || "java.util.Date".equalsIgnoreCase(type)) {
      if (value != null) {
        if (value instanceof Date) {
          setDateValue((Date) value);
        } else if (value instanceof String) {
          setDateValue((tempValue != null) ? DateUtil.toDate(tempValue) : null);
        }
      }
    } else if ("String".equalsIgnoreCase(type)
          || "java.lang.String".equalsIgnoreCase(type)) {
      setStringValue(tempValue);
    } // end if-else
  }   // end method setDataValue

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for date value.
   *
   * @param  dateValue  Date
   */
  public void setDateValue(Date dateValue) {
    this.dateValue = dateValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for decimal value.
   *
   * @param  decimalValue  BigDecimal
   */
  public void setDecimalValue(BigDecimal decimalValue) {
    this.decimalValue = decimalValue;
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
   * setter method for integer value.
   *
   * @param  integerValue  Integer
   */
  public void setIntegerValue(Integer integerValue) {
    this.integerValue = integerValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for long value.
   *
   * @param  longValue  Long
   */
  public void setLongValue(Long longValue) {
    this.longValue = longValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for string value.
   *
   * @param  stringValue  String
   */
  public void setStringValue(String stringValue) {
    this.stringValue = stringValue;
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
   * setter method for variable.
   *
   * @param  variable  BaseVariable
   */
  public void setVariable(BaseVariable variable) {
    this.variable = variable;
  }
} // end class DataExportResult
