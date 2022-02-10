package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.ozstrategy.credagility.core.domain.CreatorEntity;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 11/20/13 : 3:54 PM</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCWorkflowUpdateVariable")
public class BCWorkflowUpdateVariable extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  public static final String PROPERTY_TYPE = "property";

  /** TODO: DOCUMENT ME! */
  public static final String FUNCTION_TYPE    = "function";
  private static final long  serialVersionUID = 9946665132412566L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** BusinessContext PK businessContextId. */
  @JoinColumn(
    name       = "businessContextId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContext businessContext;

  /** Business data type. */
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

  /** Data type. */
  @Column(
    nullable = false,
    length   = 32
  )
  protected String dataType;

  /** expression. */
  protected String expression;

  /** Primary key. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Update variable name. */
  @Column(nullable = false)
  protected String name;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
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

    BCWorkflowUpdateVariable that = (BCWorkflowUpdateVariable) o;

    if ((businessContext != null) ? (!businessContext.equals(that.businessContext)) : (that.businessContext != null)) {
      return false;
    }

    if ((businessDataType != null) ? (!businessDataType.equals(that.businessDataType))
                                   : (that.businessDataType != null)) {
      return false;
    }

    if ((category != null) ? (!category.equals(that.category)) : (that.category != null)) {
      return false;
    }

    if ((dataType != null) ? (!dataType.equals(that.dataType)) : (that.dataType != null)) {
      return false;
    }

    if ((expression != null) ? (!expression.equals(that.expression)) : (that.expression != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BusinessContext getBusinessContext() {
    return businessContext;
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
  public String getCategory() {
    if (category == null) {
      return PROPERTY_TYPE;
    }

    return category;
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
  public String getExpression() {
    return expression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
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
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((businessContext != null) ? businessContext.hashCode() : 0);
    result = (31 * result) + ((businessDataType != null) ? businessDataType.hashCode() : 0);
    result = (31 * result) + ((category != null) ? category.hashCode() : 0);
    result = (31 * result) + ((dataType != null) ? dataType.hashCode() : 0);
    result = (31 * result) + ((expression != null) ? expression.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  businessContext  DOCUMENT ME!
   */
  public void setBusinessContext(BusinessContext businessContext) {
    this.businessContext = businessContext;
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
   * @param  category  DOCUMENT ME!
   */
  public void setCategory(String category) {
    this.category = category;
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
   * @param  expression  DOCUMENT ME!
   */
  public void setExpression(String expression) {
    this.expression = expression;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
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
} // end class BCWorkflowUpdateVariable
