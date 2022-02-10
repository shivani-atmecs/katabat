package com.cmc.credagility.core.domain.agency;

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
import com.cmc.credagility.core.domain.variable.Variable;

import com.ozstrategy.credagility.core.domain.Calculatable;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/17/2014 10:00
 */
@Entity public class AgencyFilterSorterVariable extends CreatorEntity implements Calculatable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -9122417854790517570L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Queue sorting criteria. */
  @JoinColumn(
    name       = "variableId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BaseVariable criteriaVariable = new Variable();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agencyMetaDataFieldId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyMetaDataField metaDataField;

  /** Description for the sorting criteria. */
  @Column(length = 255)
  private String description;

  /** primary key. */
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
   * @return  AgencyFilterSorterVariable
   */
  public AgencyFilterSorterVariable duplicate() {
    AgencyFilterSorterVariable newCopy = new AgencyFilterSorterVariable();
    newCopy.setCriteriaVariable(criteriaVariable);
    newCopy.setDescription(description);
    newCopy.setMetaDataField(metaDataField);

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

    if (!(o instanceof AgencyFilterSorterVariable)) {
      return false;
    }

    AgencyFilterSorterVariable that = (AgencyFilterSorterVariable) o;

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

    return true;
  } // end method equals

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
   * @return  AgencyMetaDataField
   */
  public AgencyMetaDataField getMetaDataField() {
    return metaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((criteriaVariable != null) ? criteriaVariable.hashCode() : 0);
    result = (31 * result) + ((metaDataField != null) ? metaDataField.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);

    return result;
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
   * @param  metaDataField  AgencyMetaDataField
   */
  public void setMetaDataField(AgencyMetaDataField metaDataField) {
    this.metaDataField = metaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.CreatorEntity#toString()
   */
  @Override public String toString() {
    return "AgencyFilterSorterVariable{"
      + "id=" + id
      + ", description='" + description + '\''
      + ", metaDataField=" + metaDataField
      + ", criteriaVariable=" + criteriaVariable
      + '}';
  }
} // end class AgencyFilterSorterVariable
