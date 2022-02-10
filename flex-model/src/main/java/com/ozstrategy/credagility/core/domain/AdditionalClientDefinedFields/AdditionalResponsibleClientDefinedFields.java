package com.ozstrategy.credagility.core.domain.AdditionalClientDefinedFields;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.portfolio.PortfolioVariable;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan zhu</a>
 * @version  03/01/2017 10:02
 */
@Entity
@Table(name = "AdditionalResponsibleClientDefinedFields")
public class AdditionalResponsibleClientDefinedFields extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4682139974725138572L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name     = "dataTypeId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AdditionalClientDefinedFieldsDataType dataType;

  /** DOCUMENT ME! */
  protected Integer dataTypePosition;

  /** DOCUMENT ME! */
  @Column(length = 512)
  protected String description;

  /** DOCUMENT ME! */
  @JoinColumn(name = "formatId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected AdditionalClientDefinedFieldsDataFormat format;

  /** DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** DOCUMENT ME! */
  @Column(
    length   = 255,
    nullable = false
  )
  protected String name;

  /** DOCUMENT ME! */
  @JoinColumn(
    name     = "portfolioId",
    unique   = false,
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** DOCUMENT ME! */
  @Column(nullable = false)
  protected Integer position;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean sticky;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "variableId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioVariable variable;

  /** DOCUMENT ME! */
  @Transient Long dataTypeId;

  /** DOCUMENT ME! */
  @Transient Long formatId;

  /** DOCUMENT ME! */
  @Transient Long portfolioId;

  /** DOCUMENT ME! */
  @Transient Long variableId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
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

    AdditionalResponsibleClientDefinedFields that = (AdditionalResponsibleClientDefinedFields) o;

    if ((dataType != null) ? (!dataType.equals(that.dataType)) : (that.dataType != null)) {
      return false;
    }

    if ((dataTypePosition != null) ? (!dataTypePosition.equals(that.dataTypePosition))
                                   : (that.dataTypePosition != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((format != null) ? (!format.equals(that.format)) : (that.format != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((portfolio != null) ? (!portfolio.equals(that.portfolio)) : (that.portfolio != null)) {
      return false;
    }

    if ((position != null) ? (!position.equals(that.position)) : (that.position != null)) {
      return false;
    }

    return !((variable != null) ? (!variable.equals(that.variable)) : (that.variable != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data type.
   *
   * @return  AdditionalClientDefinedFieldsDataType
   */
  public AdditionalClientDefinedFieldsDataType getDataType() {
    return dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data type id.
   *
   * @return  Long
   */
  public Long getDataTypeId() {
    return dataTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data type position.
   *
   * @return  Integer
   */
  public Integer getDataTypePosition() {
    return dataTypePosition;
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
   * getter method for format.
   *
   * @return  AdditionalClientDefinedFieldsDataFormat
   */
  public AdditionalClientDefinedFieldsDataFormat getFormat() {
    return format;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for format id.
   *
   * @return  Long
   */
  public Long getFormatId() {
    return formatId;
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
   * getter method for portfolio id.
   *
   * @return  Long
   */
  public Long getPortfolioId() {
    return portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for position.
   *
   * @return  Integer
   */
  public Integer getPosition() {
    return position;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sticky.
   *
   * @return  Boolean
   */
  public Boolean getSticky() {
    return sticky;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable.
   *
   * @return  PortfolioVariable
   */
  public PortfolioVariable getVariable() {
    return variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable id.
   *
   * @return  Long
   */
  public Long getVariableId() {
    return variableId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.model.BaseObject#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((dataType != null) ? dataType.hashCode() : 0);
    result = (31 * result) + ((dataTypePosition != null) ? dataTypePosition.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((format != null) ? format.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((portfolio != null) ? portfolio.hashCode() : 0);
    result = (31 * result) + ((position != null) ? position.hashCode() : 0);
    result = (31 * result) + ((variable != null) ? variable.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data type.
   *
   * @param  dataType  AdditionalClientDefinedFieldsDataType
   */
  public void setDataType(AdditionalClientDefinedFieldsDataType dataType) {
    this.dataType = dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data type id.
   *
   * @param  dataTypeId  Long
   */
  public void setDataTypeId(Long dataTypeId) {
    this.dataTypeId = dataTypeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data type position.
   *
   * @param  dataTypePosition  Integer
   */
  public void setDataTypePosition(Integer dataTypePosition) {
    this.dataTypePosition = dataTypePosition;
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
   * setter method for format.
   *
   * @param  format  AdditionalClientDefinedFieldsDataFormat
   */
  public void setFormat(AdditionalClientDefinedFieldsDataFormat format) {
    this.format = format;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for format id.
   *
   * @param  formatId  Long
   */
  public void setFormatId(Long formatId) {
    this.formatId = formatId;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio id.
   *
   * @param  portfolioId  Long
   */
  public void setPortfolioId(Long portfolioId) {
    this.portfolioId = portfolioId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for position.
   *
   * @param  position  Integer
   */
  public void setPosition(Integer position) {
    this.position = position;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sticky.
   *
   * @param  sticky  Boolean
   */
  public void setSticky(Boolean sticky) {
    this.sticky = sticky;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable.
   *
   * @param  variable  PortfolioVariable
   */
  public void setVariable(PortfolioVariable variable) {
    this.variable = variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable id.
   *
   * @param  variableId  Long
   */
  public void setVariableId(Long variableId) {
    this.variableId = variableId;
  }


} // end class AdditionalResponsibleClientDefinedFields
