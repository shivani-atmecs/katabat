package com.ozstrategy.credagility.core.el;

import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.ozstrategy.credagility.core.domain.document.BasicEnterpriseDocumentTemplateVariable;
import com.ozstrategy.credagility.core.util.DataFormatter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 13-3-29 : PM2:40</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class VarObj {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String                                  businessDataType;
  private String                                  dataType;
  private String                                  name;
  private BasicEnterpriseDocumentTemplateVariable templateVariable;
  private Object                                  value;
  private BaseVariable                            variable;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new VarObj object.
   */
  public VarObj() { }

  /**
   * Creates a new VarObj object.
   *
   * @param  name              DOCUMENT ME!
   * @param  value             DOCUMENT ME!
   * @param  dataType          DOCUMENT ME!
   * @param  businessDataType  DOCUMENT ME!
   */
  public VarObj(String name, Object value, String dataType, String businessDataType) {
    this.name             = name;
    this.value            = value;
    this.dataType         = dataType;
    this.businessDataType = businessDataType;
  }

  /**
   * Creates a new VarObj object.
   *
   * @param  name              DOCUMENT ME!
   * @param  value             DOCUMENT ME!
   * @param  dataType          DOCUMENT ME!
   * @param  businessDataType  DOCUMENT ME!
   * @param  variable          DOCUMENT ME!
   */
  public VarObj(String name, Object value, String dataType, String businessDataType, BaseVariable variable) {
    this(name, value, dataType, businessDataType);
    this.variable = variable;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   value  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String detectBusinessDataType(Object value) {
    if (value != null) {
      return detectBusinessDataType(value.getClass());
    } else {
      return "String";
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   clazz  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String detectBusinessDataType(Class clazz) {
    String businessDataType = "String";

    if (clazz != null) {
      if (Integer.class.equals(clazz)) {
        businessDataType = "Integer";
      } else if (Long.class.equals(clazz)) {
        businessDataType = "Integer";
      } else if (Boolean.class.equals(clazz)) {
        businessDataType = "Boolean";
      } else if (BigDecimal.class.equals(clazz)) {
        businessDataType = "Decimal";
      } else if (Date.class.equals(clazz) || Timestamp.class.equals(clazz)) {
        businessDataType = "Date";
      } else if (String.class.equals(clazz)) {
        businessDataType = "String";
      }
    }

    return businessDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   businessDataType  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String detectDataType(String businessDataType) {
    String dataType = null;

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

    return dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   value       DOCUMENT ME!
   * @param   expression  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static VarObj generateObj(Object value, String expression) {
    String businessDataType = detectBusinessDataType(value);

    if (businessDataType != null) {
      return new VarObj(expression, value, detectDataType(businessDataType), businessDataType);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    VarObj varPojo = (VarObj) o;

    if ((name != null) ? (!name.equals(varPojo.name)) : (varPojo.name != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getBusinessDataType() {
    return businessDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDataType() {
    return dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFormatValue() {
    if (value == null) {
      return "";
    }

    if ("Date".equalsIgnoreCase(dataType)) {
      SimpleDateFormat sdf       = new SimpleDateFormat(DataFormatter.getDefaultDatePattern());
      Date             dateValue = (Date) value;

      return sdf.format(dateValue);
    }

    return value.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BasicEnterpriseDocumentTemplateVariable getTemplateVariable() {
    return templateVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Object getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BaseVariable getVariable() {
    return variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    return (name != null) ? name.hashCode() : 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  businessDataType  DOCUMENT ME!
   */
  public void setBusinessDataType(String businessDataType) {
    this.businessDataType = businessDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dataType  DOCUMENT ME!
   */
  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name  DOCUMENT ME!
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  templateVariable  DOCUMENT ME!
   */
  public void setTemplateVariable(BasicEnterpriseDocumentTemplateVariable templateVariable) {
    this.templateVariable = templateVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  value  DOCUMENT ME!
   */
  public void setValue(Object value) {
    this.value = value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variable  DOCUMENT ME!
   */
  public void setVariable(BaseVariable variable) {
    this.variable = variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("VarObj");
    sb.append("{name='").append(name).append('\'');
    sb.append(", value=").append(value);
    sb.append(", dataType='").append(dataType).append('\'');
    sb.append(", businessDataType='").append(businessDataType).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class VarObj
