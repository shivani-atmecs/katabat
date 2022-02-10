package com.cmc.credagility.core.domain.variable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 17:29
 */
@MappedSuperclass public abstract class AbstractBaseVariable extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** build type buildTypeRegEx. */
  public static String buildTypeRegEx = ".+\\.get[A-Z_][_a-zA-Z0-9]+\\(\\)";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Building type: 'source'/'eval' */
  @Column(length = 16)
  protected String buildType = "eval";

  /** data business type: ex. Percentage, Amount... */
  @Column(
    nullable = false,
    length   = 32
  )
  protected String businessDataType;

  /** Variable Category: System/portfolio/function/survey */
  @Column(
    nullable = false,
    length   = 32
  )
  protected String category;

  /** context: ex. global, responsible, customer, agency, agent */
  @Column(
    nullable = false,
    length   = 32
  )
  protected String context;

  /** data type, in Java Type. */
  @Column(
    nullable = false,
    length   = 32
  )
  protected String dataType;

  /** Variable description. */
  @Column(length = 768)
  protected String description;

  /** Display name, showed on AW. */
  @Column(length = 255)
  protected String displayName;

  /** display position: Account level or holder level */
  @Column(
    nullable = true,
    length   = 32
  )
  protected String displayPosition;

  /** value expression. */
  @Column(nullable = false)
  @Lob protected String expression;

  /** value expression2. */
  @Lob protected String expression2;

  /** TODO: DOCUMENT ME! */
  @Lob protected byte[] expression3;

  /** Variable need to be locked to prevent change if it was refereed by others. */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean locked;

  /** variable name. */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String name;

  /** using params in reflection building type. */
  @Lob protected String params;

  /** Tag for variable. */
  @Column(
    nullable = true,
    length   = 255
  )
  protected String tag;

  /** value format. */
  @Column(length = 255)
  protected String valueFormat;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Detect build type by expression.
   *
   * @param   expression  to detect build type
   *
   * @return  build type
   */
  public static String detectBuildType(String expression) {
    return "eval";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Auto update build type based on expression.
   */
  public void autoSetBuildType() {
    setBuildType(detectBuildType());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Make a copy of variable.
   *
   * @param  o  DOCUMENT ME!
   */
  public void copy(AbstractBaseVariable o) {
    this.name             = o.getName();
    this.displayName      = o.getDisplayName();
    this.category         = o.getCategory();
    this.displayPosition  = o.getDisplayPosition();
    this.description      = o.getDescription();
    this.expression       = o.getExpression();
    this.buildType        = o.getBuildType();
    this.locked           = o.getLocked();
    this.params           = o.getParams();
    this.dataType         = o.getDataType();
    this.businessDataType = o.getBusinessDataType();
    this.valueFormat      = o.getValueFormat();
    this.tag              = o.getTag();
    this.createDate       = o.getCreateDate();
    this.lastUpdateDate   = o.getLastUpdateDate();
    this.creator          = o.getCreator();
    this.lastUpdater      = o.getLastUpdater();
    this.context          = o.getContext();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Auto detect build type.
   *
   * @return  detected build type
   */
  public String detectBuildType() {
    return detectBuildType(getExpression());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * detect data type form business data type.
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
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    AbstractBaseVariable variable = (AbstractBaseVariable) o;

    if ((buildType != null) ? (!buildType.equals(variable.buildType)) : (variable.buildType != null)) {
      return false;
    }

    if ((category != null) ? (!category.equals(variable.category)) : (variable.category != null)) {
      return false;
    }

    if ((expression != null) ? (!expression.equals(variable.expression)) : (variable.expression != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(variable.name)) : (variable.name != null)) {
      return false;
    }

    if ((params != null) ? (!params.equals(variable.params)) : (variable.params != null)) {
      return false;
    }

    if ((dataType != null) ? (!dataType.equals(variable.dataType)) : (variable.dataType != null)) {
      return false;
    }

    if ((businessDataType != null) ? (!businessDataType.equals(variable.businessDataType))
                                   : (variable.businessDataType != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for build type.
   *
   * @return  String
   */
  public String getBuildType() {
    return buildType;
  }

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
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for display name.
   *
   * @return  String
   */
  public String getDisplayName() {
    return displayName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for display position.
   *
   * @return  String
   */
  public String getDisplayPosition() {
    return displayPosition;
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
   * getter method for expression2.
   *
   * @return  String
   */
  public String getExpression2() {
    return expression2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for expression3.
   *
   * @return  byte[]
   */
  public byte[] getExpression3() {
    return expression3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for locked.
   *
   * @return  Boolean
   */
  public Boolean getLocked() {
    if (locked == null) {
      return Boolean.FALSE;
    }

    return locked;
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
   * getter method for params.
   *
   * @return  String
   */
  public String getParams() {
    return params;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tag.
   *
   * @return  String
   */
  public String getTag() {
    return tag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for value format.
   *
   * @return  String
   */
  public String getValueFormat() {
    return valueFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((category != null) ? category.hashCode() : 0);
    result = (31 * result) + ((expression != null) ? expression.hashCode() : 0);
    result = (31 * result) + ((buildType != null) ? buildType.hashCode() : 0);
    result = (31 * result) + ((params != null) ? params.hashCode() : 0);
    result = (31 * result) + ((dataType != null) ? dataType.hashCode() : 0);
    result = (31 * result) + ((businessDataType != null) ? businessDataType.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasParams.
   *
   * @return  boolean
   */
  public boolean hasParams() {
    return ((params != null) && (params.trim().length() > 0));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for locked.
   *
   * @return  boolean
   */
  public boolean isLocked() {
    return Boolean.TRUE.equals(locked);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Normalize variable name, trim extra space and make all lower case.
   */
  public void normalize() {
    if ((this.name != null) && (this.name.length() > 0)) {
      this.name = this.name.trim().toLowerCase();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for build type.
   *
   * @param  buildType  String
   */
  public void setBuildType(String buildType) {
    this.buildType = buildType;
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
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for display name.
   *
   * @param  displayName  String
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for display position.
   *
   * @param  displayPosition  String
   */
  public void setDisplayPosition(String displayPosition) {
    this.displayPosition = displayPosition;
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
   * setter method for expression2.
   *
   * @param  expression2  String
   */
  public void setExpression2(String expression2) {
    this.expression2 = expression2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for expression3.
   *
   * @param  expression3  byte[]
   */
  public void setExpression3(byte[] expression3) {
    this.expression3 = expression3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for locked.
   *
   * @param  locked  Boolean
   */
  public void setLocked(Boolean locked) {
    this.locked = locked;
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
   * setter method for params.
   *
   * @param  params  String
   */
  public void setParams(String params) {
    this.params = params;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tag.
   *
   * @param  tag  String
   */
  public void setTag(String tag) {
    this.tag = tag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value format.
   *
   * @param  valueFormat  String
   */
  public void setValueFormat(String valueFormat) {
    this.valueFormat = valueFormat;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.CreatorEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Variable");
    sb.append("{name='").append(name).append('\'');
    sb.append(", displayName='").append(displayName).append('\'');
    sb.append(", category='").append(category).append('\'');
    sb.append(", displayPosition='").append(displayPosition).append('\'');
    sb.append(", description='").append(description).append('\'');
    sb.append(", expression='").append(expression).append('\'');
    sb.append(", buildType='").append(buildType).append('\'');
    sb.append(", params='").append(params).append('\'');
    sb.append(", context='").append(context).append('\'');
    sb.append(", dataType='").append(dataType).append('\'');
    sb.append(", businessDataType='").append(businessDataType).append('\'');
    sb.append(", valueFormat='").append(valueFormat).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class AbstractBaseVariable
