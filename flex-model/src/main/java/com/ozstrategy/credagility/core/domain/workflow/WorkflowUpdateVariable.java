package com.ozstrategy.credagility.core.domain.workflow;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 17:06
 */
@Entity
@Table(name = "WorkflowUpdateVariable")
public class WorkflowUpdateVariable extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7774050092867204368L;

  /** TODO: DOCUMENT ME! */
  public static final String PROPERTY_TYPE = "property";

  /** TODO: DOCUMENT ME! */
  public static final String FUNCTION_TYPE = "function";

  /** TODO: DOCUMENT ME! */
  public static final String UTILITY_TYPE = "utility";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 32
  )
  protected String businessDataType;

  /** variable type. The value can be: property, function. */
  @Column(
    nullable = false,
    length   = 32
  )
  protected String category;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 32
  )
  protected String context;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 32
  )
  protected String dataType;

  /** TODO: DOCUMENT ME! */
  protected String expression;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  protected String name;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "portfolioId",
    nullable  = true,
    updatable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * detectDataType.
   */
  public void detectDataType() {
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
    } else if ("Float".equalsIgnoreCase(businessDataType) || "Double".equalsIgnoreCase(businessDataType)) {
      dataType = "BigDecimal";
    }
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

    if (!super.equals(o)) {
      return false;
    }

    WorkflowUpdateVariable that = (WorkflowUpdateVariable) o;

    if ((context != null) ? (!context.equals(that.context)) : (that.context != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((expression != null) ? (!expression.equals(that.expression)) : (that.expression != null)) {
      return false;
    }

    if ((dataType != null) ? (!dataType.equals(that.dataType)) : (that.dataType != null)) {
      return false;
    }

    if ((businessDataType != null) ? (!businessDataType.equals(that.businessDataType))
                                   : (that.businessDataType != null)) {
      return false;
    }

    return true;

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business data type.
   *
   * @return  String
   */
  public String getBusinessDataType() {
    return businessDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category.
   *
   * @return  String
   */
  public String getCategory() {
    if (category == null) {
      return PROPERTY_TYPE;
    }

    return category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for context.
   *
   * @return  String
   */
  public String getContext() {
    return context;
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
   * getter method for expression.
   *
   * @return  String
   */
  public String getExpression() {
    return expression;
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
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((context != null) ? context.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((expression != null) ? expression.hashCode() : 0);
    result = (31 * result) + ((dataType != null) ? dataType.hashCode() : 0);
    result = (31 * result) + ((businessDataType != null) ? businessDataType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business data type.
   *
   * @param  businessDataType  String
   */
  public void setBusinessDataType(String businessDataType) {
    this.businessDataType = businessDataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category.
   *
   * @param  category  String
   */
  public void setCategory(String category) {
    this.category = category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for context.
   *
   * @param  context  String
   */
  public void setContext(String context) {
    this.context = context;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
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
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }
} // end class WorkflowUpdateVariable
