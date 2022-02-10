package com.ozstrategy.credagility.core.domain;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 12:50
 */
@Entity public class ExpQueryModel implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 6497373982214162021L;


  /** TODO: DOCUMENT ME! */
  public static final String CON_OPERATOR_AND = "AND";


  /** TODO: DOCUMENT ME! */
  public static final String CON_OPERATOR_OR = "OR";


  /** TODO: DOCUMENT ME! */
  public static final String REL_OPERATOR_EQ = "=";


  /** TODO: DOCUMENT ME! */
  public static final String REL_OPERATOR_GT = ">";


  /** TODO: DOCUMENT ME! */
  public static final String REL_OPERATOR_LT = "<";


  /** TODO: DOCUMENT ME! */
  public static final String REL_OPERATOR_LE = "<=";


  /** TODO: DOCUMENT ME! */
  public static final String REL_OPERATOR_GE = ">=";


  /** TODO: DOCUMENT ME! */
  public static final String REL_OPERATOR_LIKE = "LIKE";


  /** TODO: DOCUMENT ME! */
  public static final String REL_OPERATOR_NOT_LIKE = "Not LIKE";


  /** TODO: DOCUMENT ME! */
  public static final String DEFAULT_SQL_QUERY_CONN =
    "SELECT da.responsibleId FROM PreviewMetaData da left join PreviewMetaDataField df on da.previewMetaDataFieldId=df.previewMetaDataFieldId ";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String conditionOperator;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String data;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String dataType;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String expression;

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String relOperator;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "userSavedSearchQueryId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected UserPreviewResultSearch userSavedSearchQuery;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for column by data type.
   *
   * @return  String
   */
  public String getColumnByDataType() {
    if (this.dataType != null) {
      if ("INTEGER".equalsIgnoreCase(this.dataType)) {
        return "metaDataIntegerValue";
      } else if ("BIGDECIMAL".equalsIgnoreCase(this.dataType)) {
        return "BIGDECIMAL";
      } else if ("STRING".equalsIgnoreCase(this.dataType)) {
        return "metaDataStringValue";
      } else if ("DATE".equalsIgnoreCase(this.dataType)) {
        return "metaDataDateValue";
      } else if ("LONG".equalsIgnoreCase(this.dataType)) {
        return "metaDataLongValue";
      } else if ("BOOLEAN".equalsIgnoreCase(this.dataType)) {
        return "metaDataBooleanValue";
      } // end if-else
    }   // end if

    return "";
  } // end method getColumnByDataType

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for condition operator.
   *
   * @return  String
   */
  public String getConditionOperator() {
    return conditionOperator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data.
   *
   * @return  String
   */
  public String getData() {
    return data;
  } // end method getData

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
   * getter method for expression.
   *
   * @return  String
   */
  public String getExpression() {
    return expression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for query data.
   *
   * @return  String
   */
  public String getQueryData() {
    if (this.data != null) {
      if ("INTEGER".equalsIgnoreCase(this.dataType)) {
        return this.data;
      } else if ("BIGDECIMAL".equalsIgnoreCase(this.dataType)) {
        return this.data;
      } else if ("STRING".equalsIgnoreCase(this.dataType)) {
        if (this.data.contains("\"")) {
          this.data = this.data.substring(1, this.data.length() - 1);
        }

        if (REL_OPERATOR_LIKE.equalsIgnoreCase(this.relOperator)
              || REL_OPERATOR_NOT_LIKE.equalsIgnoreCase(this.relOperator)) {
          return "'%" + this.data + "%'";
        }

        return "'" + this.data + "'";
      } else if ("DATE".equalsIgnoreCase(this.dataType)) {
        return "'" + this.data + "'";
      } else if ("LONG".equalsIgnoreCase(this.dataType)) {
        return this.data;
      } else if ("BOOLEAN".equalsIgnoreCase(this.dataType)) {
        String queryData = "TRUE".equalsIgnoreCase(this.data) ? "Y" : "N";

        return "'" + queryData + "'";
      } // end if-else
    }   // end if

    return data;
  } // end method getQueryData

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rel operator.
   *
   * @return  String
   */
  public String getRelOperator() {
    return relOperator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user saved search query.
   *
   * @return  UserPreviewResultSearch
   */
  public UserPreviewResultSearch getUserSavedSearchQuery() {
    return userSavedSearchQuery;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for condition operator.
   *
   * @param  conditionOperator  String
   */
  public void setConditionOperator(String conditionOperator) {
    this.conditionOperator = conditionOperator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data.
   *
   * @param  data  String
   */
  public void setData(String data) {
    this.data = data;
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
   * setter method for expression.
   *
   * @param  expression  String
   */
  public void setExpression(String expression) {
    this.expression = expression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rel operator.
   *
   * @param  relOperator  String
   */
  public void setRelOperator(String relOperator) {
    this.relOperator = relOperator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user saved search query.
   *
   * @param  userSavedSearchQuery  UserPreviewResultSearch
   */
  public void setUserSavedSearchQuery(UserPreviewResultSearch userSavedSearchQuery) {
    this.userSavedSearchQuery = userSavedSearchQuery;
  }
} // end class ExpQueryModel
