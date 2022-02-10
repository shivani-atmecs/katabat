package com.cmc.credagility.core.domain.variable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.cmc.credagility.core.domain.portfolio.PortfolioDisplayVariable;
import com.cmc.credagility.core.domain.sor.PortfolioVariableWidgetDisplayVariable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 17:33
 */
@DiscriminatorColumn(
  name              = "variableType",
  discriminatorType = DiscriminatorType.STRING
)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(
  name    = "Variable",
  indexes = {
    @Index(
      name = "IDX_TYPE_CONTEXT_ID",
      columnList = "variableType,context,id"
    )
  }
)
public abstract class BaseVariable extends AbstractBaseVariable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(

// columnDefinition = "char",
// length           = 1,
    nullable   = true,
    insertable = false,
    updatable  = false
  )
// @Convert(converter = StringBooleanConverter.class)
  protected Boolean asCustomer;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch      = FetchType.LAZY,
    mappedBy   = "variable"
  )
  @Where(clause = "isDefault = 'Y'")
  protected Set<VariableValueOption> defaultValueOption = new LinkedHashSet<VariableValueOption>();

  /** PK , id. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = { CascadeType.ALL, CascadeType.REMOVE },
    fetch    = FetchType.LAZY,
    mappedBy = "variable"
  )
  protected Set<PortfolioDisplayVariable> portfolioDisplayVariables = new LinkedHashSet<PortfolioDisplayVariable>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = { CascadeType.ALL, CascadeType.REMOVE },
    fetch    = FetchType.LAZY,
    mappedBy = "variable"
  )
  protected Set<VariableValueOption> valueOptions = new LinkedHashSet<VariableValueOption>();

  /** Variable Type, System/Portfolio/SurveyFlow. */
  @Column(
    nullable   = false,
    insertable = false,
    updatable  = false,
    length     = 20
  )
  protected String variableType;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    cascade  = { CascadeType.ALL, CascadeType.REMOVE },
    fetch    = FetchType.LAZY,
    mappedBy = "variable"
  )
  protected Set<PortfolioVariableWidgetDisplayVariable> widgetDisplayVariables =
    new LinkedHashSet<PortfolioVariableWidgetDisplayVariable>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for as customer.
   *
   * @return  Boolean
   */
  public Boolean getAsCustomer() {
    if (null == asCustomer) {
      return Boolean.FALSE;
    }

    return asCustomer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data type class.
   *
   * @return  Class
   */
  public Class getDataTypeClass() {
    if ("String".equalsIgnoreCase(dataType) || "Text".equalsIgnoreCase(dataType)
          || "java.lang.String".equalsIgnoreCase(dataType)) {
      return String.class;
    } else if ("Currency".equalsIgnoreCase(dataType) || "BigDecimal".equalsIgnoreCase(dataType)
          || "java.math.BigDecimal".equalsIgnoreCase(dataType)) {
      return BigDecimal.class;
    } else if ("Integer".equalsIgnoreCase(dataType) || "java.lang.Integer".equalsIgnoreCase(dataType)) {
      return Integer.class;
    } else if ("Long".equalsIgnoreCase(dataType) || "java.lang.Long".equalsIgnoreCase(dataType)) {
      return Long.class;
    } else if ("Boolean".equalsIgnoreCase(dataType) || "java.lang.Boolean".equalsIgnoreCase(dataType)) {
      return Boolean.class;
    } else if ("Date".equalsIgnoreCase(dataType) || "java.util.Date".equalsIgnoreCase(dataType)) {
      return Date.class;
    }

    return Object.class;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default value option.
   *
   * @return  Set
   */
  public Set<VariableValueOption> getDefaultValueOption() {
    return defaultValueOption;
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
   * getter method for portfolio display variables.
   *
   * @return  Set
   */
  public Set<PortfolioDisplayVariable> getPortfolioDisplayVariables() {
    return portfolioDisplayVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for value options.
   *
   * @return  Set
   */
  public Set<VariableValueOption> getValueOptions() {
    return valueOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable type.
   *
   * @return  String
   */
  public String getVariableType() {
    return variableType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for widget display variables.
   *
   * @return  Set
   */
  public Set<PortfolioVariableWidgetDisplayVariable> getWidgetDisplayVariables() {
    return widgetDisplayVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for as customer.
   *
   * @param  asCustomer  Boolean
   */
  public void setAsCustomer(Boolean asCustomer) {
    this.asCustomer = asCustomer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default value option.
   *
   * @param  defaultValueOption  Set
   */
  public void setDefaultValueOption(Set<VariableValueOption> defaultValueOption) {
    this.defaultValueOption = defaultValueOption;
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
   * setter method for portfolio display variables.
   *
   * @param  portfolioDisplayVariables  Set
   */
  public void setPortfolioDisplayVariables(Set<PortfolioDisplayVariable> portfolioDisplayVariables) {
    this.portfolioDisplayVariables = portfolioDisplayVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value options.
   *
   * @param  valueOptions  Set
   */
  public void setValueOptions(Set<VariableValueOption> valueOptions) {
    this.valueOptions = valueOptions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable type.
   *
   * @param  variableType  String
   */
  public void setVariableType(String variableType) {
    this.variableType = variableType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for widget display variables.
   *
   * @param  widgetDisplayVariables  Set
   */
  public void setWidgetDisplayVariables(Set<PortfolioVariableWidgetDisplayVariable> widgetDisplayVariables) {
    this.widgetDisplayVariables = widgetDisplayVariables;
  }
} // end class BaseVariable
