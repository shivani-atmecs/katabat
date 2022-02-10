package com.ozstrategy.credagility.core.domain.decisiontree.businesscontext;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import org.springframework.util.StringUtils;

import javax.persistence.*;


/**
 * Created by zhubq on 15/5/7.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  05/07/2015 23:18
 */
@Entity
@Table(name = "WorkflowAnswerOptionConfig")
public class WorkflowAnswerOptionConfig extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2929822748971708213L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 32
  )
  private String businessDataType;

  /** Responsible, Agency, Business.* */

  @Column(
    length   = 200,
    nullable = false
  )
  private String context;

  @Column(
    length   = 255,
    nullable = true
  )
  private String description;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  @Column(
    length   = 255,
    nullable = true
  )
  private String labelField;

  @Column(
    length   = 255,
    nullable = true
  )
  private String orderByQuery;


  @Column(
    length   = 1024,
    nullable = true
  )
  private String searchQuery;

  @Column(
    length   = 255,
    nullable = true
  )
  private String tableName;


  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean useSearchQuery = Boolean.FALSE;

  @Column(
    length   = 255,
    nullable = true
  )
  private String valueField;

  @Column(
    length   = 255,
    nullable = true
  )
  private String whereCause;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convertToHql.
   *
   * @return  String
   */
  public String convertToHql() {
    StringBuilder hql = new StringBuilder();
    hql.append("SELECT ").append(labelField).append(", ").append(valueField).append(" FROM ").append(tableName);

    if ((whereCause != null) && StringUtils.hasText(whereCause)) {
      hql.append(" WHERE ").append(whereCause);
    }

    return hql.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    WorkflowAnswerOptionConfig that = (WorkflowAnswerOptionConfig) o;

    if ((businessDataType != null) ? (!businessDataType.equals(that.businessDataType))
                                   : (that.businessDataType != null)) {
      return false;
    }

    if ((context != null) ? (!context.equals(that.context)) : (that.context != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((labelField != null) ? (!labelField.equals(that.labelField)) : (that.labelField != null)) {
      return false;
    }

    if ((orderByQuery != null) ? (!orderByQuery.equals(that.orderByQuery)) : (that.orderByQuery != null)) {
      return false;
    }

    if ((searchQuery != null) ? (!searchQuery.equals(that.searchQuery)) : (that.searchQuery != null)) {
      return false;
    }

    if ((tableName != null) ? (!tableName.equals(that.tableName)) : (that.tableName != null)) {
      return false;
    }

    if ((useSearchQuery != null) ? (!useSearchQuery.equals(that.useSearchQuery)) : (that.useSearchQuery != null)) {
      return false;
    }

    if ((valueField != null) ? (!valueField.equals(that.valueField)) : (that.valueField != null)) {
      return false;
    }

    return (whereCause != null) ? whereCause.equals(that.whereCause) : (that.whereCause == null);

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
   * getter method for context.
   *
   * @return  String
   */
  public String getContext() {
    return context;
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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for label field.
   *
   * @return  String
   */
  public String getLabelField() {
    return labelField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for order by query.
   *
   * @return  String
   */
  public String getOrderByQuery() {
    return orderByQuery;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for search query.
   *
   * @return  String
   */
  public String getSearchQuery() {
    return searchQuery;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for table name.
   *
   * @return  String
   */
  public String getTableName() {
    return tableName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for use search query.
   *
   * @return  Boolean
   */
  public Boolean getUseSearchQuery() {
    return useSearchQuery;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for value field.
   *
   * @return  String
   */
  public String getValueField() {
    return valueField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for where cause.
   *
   * @return  String
   */
  public String getWhereCause() {
    return whereCause;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((businessDataType != null) ? businessDataType.hashCode() : 0);
    result = (31 * result) + ((context != null) ? context.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((labelField != null) ? labelField.hashCode() : 0);
    result = (31 * result) + ((orderByQuery != null) ? orderByQuery.hashCode() : 0);
    result = (31 * result) + ((searchQuery != null) ? searchQuery.hashCode() : 0);
    result = (31 * result) + ((tableName != null) ? tableName.hashCode() : 0);
    result = (31 * result) + ((useSearchQuery != null) ? useSearchQuery.hashCode() : 0);
    result = (31 * result) + ((valueField != null) ? valueField.hashCode() : 0);
    result = (31 * result) + ((whereCause != null) ? whereCause.hashCode() : 0);

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
   * setter method for context.
   *
   * @param  context  String
   */
  public void setContext(String context) {
    this.context = context;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for label field.
   *
   * @param  labelField  String
   */
  public void setLabelField(String labelField) {
    this.labelField = labelField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for order by query.
   *
   * @param  orderByQuery  String
   */
  public void setOrderByQuery(String orderByQuery) {
    this.orderByQuery = orderByQuery;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for search query.
   *
   * @param  searchQuery  String
   */
  public void setSearchQuery(String searchQuery) {
    this.searchQuery = searchQuery;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for table name.
   *
   * @param  tableName  String
   */
  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for use search query.
   *
   * @param  useSearchQuery  Boolean
   */
  public void setUseSearchQuery(Boolean useSearchQuery) {
    this.useSearchQuery = useSearchQuery;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value field.
   *
   * @param  valueField  String
   */
  public void setValueField(String valueField) {
    this.valueField = valueField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for where cause.
   *
   * @param  whereCause  String
   */
  public void setWhereCause(String whereCause) {
    this.whereCause = whereCause;
  }
} // end class WorkflowAnswerOptionConfig
