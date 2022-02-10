package com.ozstrategy.credagility.core.domain.document;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;


/**
 * EnterpriseDocumentMetaData Abstract Class.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 11:40
 */
@MappedSuperclass public abstract class BasicEnterpriseDocumentMetaData extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /**
   * Type List.
   *
   * <ul>
   *   <li>TextField</li>
   *   <li>TextArea</li>
   *   <li>DropDown</li>
   *   <li>Radio</li>
   *   <li>File</li>
   * </ul>
   */
  @Column(length = 255)
  protected String answerType = "TextField";


  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 100,
    nullable = false
  )
  protected String dataType;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String description;


  /** TODO: DOCUMENT ME! */
  protected Integer displayOrder;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 255,
    nullable = false
  )
  protected String name;


  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String questionText;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean required;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return Boolean.TRUE;
    }

    if (!(o instanceof EnterpriseDocumentMetaData)) {
      return Boolean.FALSE;
    }

    EnterpriseDocumentMetaData metaData = (EnterpriseDocumentMetaData) o;

    if ((name != null) ? (!name.equals(metaData.getName())) : (metaData.getName() != null)) {
      return Boolean.FALSE;
    }

    if ((dataType != null) ? (!dataType.equals(metaData.getDataType())) : (metaData.getDataType() != null)) {
      return Boolean.FALSE;
    }

    if ((questionText != null) ? (!questionText.equals(metaData.getQuestionText()))
                               : (metaData.getQuestionText() != null)) {
      return Boolean.FALSE;
    }

    return Boolean.TRUE;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer type.
   *
   * @return  String
   */
  public String getAnswerType() {
    return answerType;
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
   * getter method for display order.
   *
   * @return  Integer
   */
  public Integer getDisplayOrder() {
    return displayOrder;
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
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((dataType != null) ? dataType.hashCode() : 0);
    result = (31 * result) + ((questionText != null) ? questionText.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for answer type.
   *
   * @param  answerType  String
   */
  public void setAnswerType(String answerType) {
    this.answerType = answerType;
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
   * setter method for display order.
   *
   * @param  displayOrder  Integer
   */
  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
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
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("BasicEnterpriseDocumentMetaData");
    sb.append("{answerType='").append(answerType).append('\'');
    sb.append(", dataType='").append(dataType).append('\'');
    sb.append(", description='").append(description).append('\'');
    sb.append(", displayOrder=").append(displayOrder);
    sb.append(", id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", questionText='").append(questionText).append('\'');
    sb.append(", required=").append(required);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  metaData  EnterpriseDocumentMetaData
   */
  public void update(EnterpriseDocumentMetaData metaData) {
    this.name         = metaData.getName();
    this.description  = metaData.getDescription();
    this.questionText = metaData.getQuestionText();
    this.dataType     = metaData.getDataType();
    this.required     = metaData.getRequired();
    this.answerType   = metaData.getAnswerType();
    this.displayOrder = metaData.getDisplayOrder();
  }
} // end class BasicEnterpriseDocumentMetaData
