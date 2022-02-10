package com.cmc.credagility.core.domain.businesscontext;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 10:55
 */
@Entity public class BCIGridConfig extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5090445756358841329L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "availableMappingFieldId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCAvailableMappingField availableMappingField;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "businessContextId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContext businessContext;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "variableId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BaseVariable criteriaVariable;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean defaultShow;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String displayName;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String format;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer priority;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "variableMetaDataFieldId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCVariableMetaDataField variableMetaDataField;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof BCIGridConfig)) {
      return false;
    }

    BCIGridConfig that = (BCIGridConfig) o;

    if ((availableMappingField != null) ? (!availableMappingField.equals(that.availableMappingField))
                                        : (that.availableMappingField != null)) {
      return false;
    }

    if ((businessContext != null) ? (!businessContext.equals(that.businessContext)) : (that.businessContext != null)) {
      return false;
    }

    if ((criteriaVariable != null) ? (!criteriaVariable.equals(that.criteriaVariable))
                                   : (that.criteriaVariable != null)) {
      return false;
    }

    if ((defaultShow != null) ? (!defaultShow.equals(that.defaultShow)) : (that.defaultShow != null)) {
      return false;
    }

    if ((variableMetaDataField != null) ? (!variableMetaDataField.equals(that.variableMetaDataField))
                                        : (that.variableMetaDataField != null)) {
      return false;
    }

    if ((displayName != null) ? (!displayName.equals(that.displayName)) : (that.displayName != null)) {
      return false;
    }

    if ((format != null) ? (!format.equals(that.format)) : (that.format != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for available mapping field.
   *
   * @return  BCAvailableMappingField
   */
  public BCAvailableMappingField getAvailableMappingField() {
    return availableMappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context.
   *
   * @return  BusinessContext
   */
  public BusinessContext getBusinessContext() {
    return businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria variable.
   *
   * @return  BaseVariable
   */
  public BaseVariable getCriteriaVariable() {
    return criteriaVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for default show.
   *
   * @return  Boolean
   */
  public Boolean getDefaultShow() {
    return defaultShow;
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
   * getter method for format.
   *
   * @return  String
   */
  public String getFormat() {
    return format;
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
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable meta data field.
   *
   * @return  BCVariableMetaDataField
   */
  public BCVariableMetaDataField getVariableMetaDataField() {
    return variableMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((availableMappingField != null) ? availableMappingField.hashCode() : 0);
    result = (31 * result) + ((businessContext != null) ? businessContext.hashCode() : 0);
    result = (31 * result) + ((criteriaVariable != null) ? criteriaVariable.hashCode() : 0);
    result = (31 * result) + ((defaultShow != null) ? defaultShow.hashCode() : 0);
    result = (31 * result) + ((variableMetaDataField != null) ? variableMetaDataField.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for available mapping field.
   *
   * @param  availableMappingField  BCAvailableMappingField
   */
  public void setAvailableMappingField(BCAvailableMappingField availableMappingField) {
    this.availableMappingField = availableMappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business context.
   *
   * @param  businessContext  BusinessContext
   */
  public void setBusinessContext(BusinessContext businessContext) {
    this.businessContext = businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for criteria variable.
   *
   * @param  criteriaVariable  BaseVariable
   */
  public void setCriteriaVariable(BaseVariable criteriaVariable) {
    this.criteriaVariable = criteriaVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default show.
   *
   * @param  defaultShow  Boolean
   */
  public void setDefaultShow(Boolean defaultShow) {
    this.defaultShow = defaultShow;
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
   * setter method for format.
   *
   * @param  format  String
   */
  public void setFormat(String format) {
    this.format = format;
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
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable meta data field.
   *
   * @param  variableMetaDataField  BCVariableMetaDataField
   */
  public void setVariableMetaDataField(BCVariableMetaDataField variableMetaDataField) {
    this.variableMetaDataField = variableMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.CreatorEntity#toString()
   */
  @Override public String toString() {
    return "BCIGridConfig{"
      + "id=" + id
      + ", businessContext=" + businessContext
      + ", availableMappingField=" + availableMappingField
      + ", defaultShow=" + defaultShow
      + ", criteriaVariable=" + criteriaVariable
      + ", variableMetaDataField=" + variableMetaDataField
      + ", priority=" + priority
      + ", displayName=" + displayName
      + ", format=" + format
      + '}';
  }
} // end class BCIGridConfig
