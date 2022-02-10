package com.cmc.credagility.core.domain.businesscontext;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.variable.BaseVariable;

import com.ozstrategy.credagility.core.domain.Calculatable;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 10:52
 */
@Entity public class BCFilterSorterVariable extends CreatorEntity implements Calculatable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

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
  protected BaseVariable criteriaVariable = new BCVariable();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "bcMetaDataFieldId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCMetaDataField metaDataField;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "variableMetaDataFieldId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCVariableMetaDataField variableMetaDataField;

  @Column(length = 255)
  private String description;

  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * calculate.
   *
   * @param   helper  EvaluateHelper
   *
   * @return  Object
   */
  @Override public Object calculate(EvaluateHelper helper) {
    return helper.calculate(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  BCFilterSorterVariable
   */
  public BCFilterSorterVariable duplicate() {
    BCFilterSorterVariable newCopy = new BCFilterSorterVariable();
    newCopy.setCriteriaVariable(criteriaVariable);
    newCopy.setDescription(description);
    newCopy.setBusinessContext(businessContext);
    newCopy.setMetaDataField(metaDataField);
    newCopy.setVariableMetaDataField(variableMetaDataField);

    return newCopy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof BCFilterSorterVariable)) {
      return false;
    }

    BCFilterSorterVariable that = (BCFilterSorterVariable) o;

    if ((businessContext != null) ? (!businessContext.equals(that.businessContext)) : (that.businessContext != null)) {
      return false;
    }

    if ((criteriaVariable != null) ? (!criteriaVariable.equals(that.criteriaVariable))
                                   : (that.criteriaVariable != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(that.description)) : (that.description != null)) {
      return false;
    }

    if ((metaDataField != null) ? (!metaDataField.equals(that.metaDataField)) : (that.metaDataField != null)) {
      return false;
    }

    if ((variableMetaDataField != null) ? (!variableMetaDataField.equals(that.variableMetaDataField))
                                        : (that.variableMetaDataField != null)) {
      return false;
    }

    return true;
  } // end method equals

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
   * getter method for criteria variable id.
   *
   * @return  Long
   */
  public Long getCriteriaVariableId() {
    if (criteriaVariable != null) {
      return criteriaVariable.getId();
    } else {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria variable name.
   *
   * @return  String
   */
  public String getCriteriaVariableName() {
    if (criteriaVariable != null) {
      return criteriaVariable.getName();
    } else {
      return null;
    }
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
   * getter method for meta data field.
   *
   * @return  BCMetaDataField
   */
  public BCMetaDataField getMetaDataField() {
    return metaDataField;
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
    result = (31 * result) + ((businessContext != null) ? businessContext.hashCode() : 0);
    result = (31 * result) + ((criteriaVariable != null) ? criteriaVariable.hashCode() : 0);
    result = (31 * result) + ((metaDataField != null) ? metaDataField.hashCode() : 0);
    result = (31 * result) + ((variableMetaDataField != null) ? variableMetaDataField.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);

    return result;
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
   * setter method for criteria variable id.
   *
   * @param  variableId  Long
   */
  public void setCriteriaVariableId(Long variableId) {
    criteriaVariable.setId(variableId);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for criteria variable name.
   *
   * @param  name  String
   */
  public void setCriteriaVariableName(String name) {
    criteriaVariable.setName(name);
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
   * setter method for meta data field.
   *
   * @param  metaDataField  BCMetaDataField
   */
  public void setMetaDataField(BCMetaDataField metaDataField) {
    this.metaDataField = metaDataField;
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
    return "BCFilterSorterVariable{"
      + "id=" + id
      + ", description='" + description + '\''
      + ", businessContext=" + businessContext
      + ", metaDataField=" + metaDataField
      + ", variableMetaDataField=" + variableMetaDataField
      + ", criteriaVariable=" + criteriaVariable
      + '}';
  }
} // end class BCFilterSorterVariable
