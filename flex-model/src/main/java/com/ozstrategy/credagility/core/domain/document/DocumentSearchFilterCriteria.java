package com.ozstrategy.credagility.core.domain.document;

import com.cmc.credagility.core.domain.mra.FilterOperator;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store DocumentSearchFilterCriteria information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 14:16
 */
@Entity public class DocumentSearchFilterCriteria extends AbstractBaseDocumentSearchCriteria {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "filterId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected DocumentSearchFilter documentSearchFilter;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fieldName;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fieldValue;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "operatorId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected FilterOperator operator;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for document search filter.
   *
   * @return  DocumentSearchFilter
   */
  public DocumentSearchFilter getDocumentSearchFilter() {
    return documentSearchFilter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for field name.
   *
   * @return  String
   */
  public String getFieldName() {
    return fieldName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for field value.
   *
   * @return  String
   */
  public String getFieldValue() {
    return fieldValue;
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
   * getter method for operator.
   *
   * @return  FilterOperator
   */
  public FilterOperator getOperator() {
    return operator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document search filter.
   *
   * @param  documentSearchFilter  DocumentSearchFilter
   */
  public void setDocumentSearchFilter(DocumentSearchFilter documentSearchFilter) {
    this.documentSearchFilter = documentSearchFilter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for field name.
   *
   * @param  fieldName  String
   */
  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for field value.
   *
   * @param  fieldValue  String
   */
  public void setFieldValue(String fieldValue) {
    this.fieldValue = fieldValue;
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
   * setter method for operator.
   *
   * @param  operator  FilterOperator
   */
  public void setOperator(FilterOperator operator) {
    this.operator = operator;
  }
} // end class DocumentSearchFilterCriteria
