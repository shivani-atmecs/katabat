package com.cmc.credagility.core.domain.type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:25
 */
public enum MetaDataValueType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  INTEGER("Integer"), BIGDECIMAL("BigDecimal"), STRING("String"), DATE("Date"), LONG("Long"), BOOLEAN("Boolean"),
  TEXT("Text"),EXTERNALENTITY("Externalentity");

  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected static final transient Logger log = LoggerFactory.getLogger(MetaDataValueType.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private MetaDataValueType(String strValue) {
    this.strValue = strValue;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convertToMetaType.
   *
   * @param   type   MetaDataValueType
   * @param   value  Object
   *
   * @return  Object
   */
  public static Object convertToMetaType(MetaDataValueType type, Object value) {
    if (value == null) {
      return null;
    }

    switch (type) {
      case INTEGER: {
        if (value instanceof Integer) {
          return (Integer) value;
        } else if (value instanceof Long) {
          return new Integer(((Long) value).intValue());
        } else if (value instanceof BigDecimal) {
          return new Integer(((BigDecimal) value).intValue());
        }

        log.error("meta data value type is not Integer: " + value);

        break;
      }

      case LONG: {
        if (value instanceof Integer) {
          return new Long((Integer) value);
        } else if (value instanceof Long) {
          return (Long) value;
        } else if (value instanceof BigDecimal) {
          return new Long(((BigDecimal) value).longValue());
        }

        log.error("meta data value type is not Long: " + value);

        break;
      }

      case BIGDECIMAL: {
        if (value instanceof Integer) {
          return new BigDecimal((Integer) value);
        } else if (value instanceof Long) {
          return new BigDecimal((Long) value);
        } else if (value instanceof BigDecimal) {
          return (BigDecimal) value;
        }

        log.error("meta data value type is not BigDecimal: " + value);

        break;
      }

      case DATE: {
        if (value instanceof Date) {
          return (Date) value;
        }

        log.error("meta data value type is not Date: " + value);

        break;
      }

      case STRING: {
        if (value instanceof String) {
          return (String) value;
        }

        log.error("meta data value type is not String: " + value);

        break;
      }

      case TEXT: {
        if (value instanceof String) {
          return (String) value;
        }

        log.error("meta data value type is not text: " + value);

        break;
      }

      case BOOLEAN: {
        if (value instanceof Boolean) {
          return (Boolean) value;
        }

        log.error("meta data value type is not Boolean: " + value);

        break;
      }
    } // end switch

    return null;
  } // end method convertToMetaType

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toMetaDataValueType.
   *
   * @param   strValue  String
   *
   * @return  MetaDataValueType
   */
  public static MetaDataValueType toMetaDataValueType(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for str value.
   *
   * @return  String
   */
  public String getStrValue() {
    return strValue;
  }
}
