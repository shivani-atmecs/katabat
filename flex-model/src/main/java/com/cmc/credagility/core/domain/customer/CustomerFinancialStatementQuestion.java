package com.cmc.credagility.core.domain.customer;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * Created by tangwei on 1/6/17.
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  01/06/2017 17:32
 */
@Entity
@Table(name = "CustomerFinancialStatementQuestion")
public class CustomerFinancialStatementQuestion extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 32)
  protected String businessDataType;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 32,
    nullable = false
  )
  protected String dataType;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer displayOrder;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean historical;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer maxSize;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable         = false,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected String questionText;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean required;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 32,
    nullable = false
  )
  protected String statementType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof CustomerFinancialStatementQuestion)) {
      return false;
    }

    CustomerFinancialStatementQuestion that = (CustomerFinancialStatementQuestion) obj;

    if ((id != null) ? (!id.equals(that.getId())) : (that.getId() != null)) {
      return false;
    }

    if ((questionText != null) ? (!questionText.equals(that.getQuestionText())) : (that.getQuestionText() != null)) {
      return false;
    }

    if ((dataType != null) ? (!dataType.equals(that.getDataType())) : (that.getDataType() != null)) {
      return false;
    }

    if ((statementType != null) ? (!statementType.equals(that.getStatementType()))
                                : (that.getStatementType() != null)) {
      return false;
    }

    return super.equals(obj);
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
   * getter method for data type.
   *
   * @return  String
   */
  public String getDataType() {
    return dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for display order.
   *
   * @return  Integer
   */
  public Integer getDisplayOrder() {
    return displayOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active.
   *
   * @return  Boolean
   */
  public Boolean getHistorical() {
    return historical;
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
   * getter method for max size.
   *
   * @return  Integer
   */
  public Integer getMaxSize() {
    return maxSize;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for question text.
   *
   * @return  String
   */
  public String getQuestionText() {
    return questionText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for required.
   *
   * @return  Boolean
   */
  public Boolean getRequired() {
    return required;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for statement type.
   *
   * @return  String
   */
  public String getStatementType() {
    return statementType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((questionText != null) ? questionText.hashCode() : 0);
    result = (31 * result) + ((dataType != null) ? dataType.hashCode() : 0);
    result = (31 * result) + ((statementType != null) ? statementType.hashCode() : 0);

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
   * setter method for data type.
   *
   * @param  dataType  String
   */
  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for display order.
   *
   * @param  displayOrder  Integer
   */
  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for active.
   *
   * @param  historical  Boolean
   */
  public void setHistorical(Boolean historical) {
    this.historical = historical;
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
   * setter method for max size.
   *
   * @param  maxSize  Integer
   */
  public void setMaxSize(Integer maxSize) {
    this.maxSize = maxSize;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for question text.
   *
   * @param  questionText  String
   */
  public void setQuestionText(String questionText) {
    this.questionText = questionText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for required.
   *
   * @param  required  Boolean
   */
  public void setRequired(Boolean required) {
    this.required = required;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for statement type.
   *
   * @param  statementType  String
   */
  public void setStatementType(String statementType) {
    this.statementType = statementType;
  }
} // end class CustomerFinancialStatementQuestion
