package com.ozstrategy.credagility.core.domain.decisiontree.agency;

import com.cmc.credagility.core.domain.agency.AgencyMetaDataField;
import com.cmc.credagility.core.domain.agency.AgencyQueueMappingField;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.cmc.credagility.core.domain.variable.Variable;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.BaseSortCriteria;
import com.ozstrategy.credagility.core.domain.Calculatable;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store AgencyQueueSortCriteria information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 17:04
 */
@Entity public class AgencyQueueSortCriteria extends BaseSortCriteria implements Serializable, Calculatable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7111829770938850256L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agencyMetaDataFieldId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyMetaDataField agencyMetaDataField;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agencyQueueMappingFieldId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyQueueMappingField agencyQueueMappingField = new AgencyQueueMappingField();


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean asMappingField = false;

  /** Queue sorting criteria. */
  @JoinColumn(
    name       = "variableId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BaseVariable criteriaVariable = new Variable();

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  /** Priority for the sorting criteria. */
  @Column(nullable = false)
  private Integer priority = 1;

  /** The queue action which this criteria belong to. */
  @JoinColumn(
    name       = "queueActionId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  private AgencyQueueAction queueAction  = new AgencyQueueAction();
  @Transient private String variableType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Calculate.
   *
   * @param   helper  for calculate
   *
   * @return  Calculate result
   */
  @Override public Object calculate(EvaluateHelper helper) {
    return helper.calculate(this);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  AgencyQueueSortCriteria
   */
  public AgencyQueueSortCriteria duplicate() {
    AgencyQueueSortCriteria newCopy = new AgencyQueueSortCriteria();
    newCopy.setDescription(description);
    newCopy.setDirection(direction);
    newCopy.setPriority(priority);
    newCopy.setQueueAction(queueAction);
    newCopy.setCriteriaVariable(criteriaVariable);
    newCopy.setAgencyMetaDataField(agencyMetaDataField);

    return newCopy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof AgencyQueueSortCriteria)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    AgencyQueueSortCriteria that = (AgencyQueueSortCriteria) o;

    if ((agencyMetaDataField != null) ? (!agencyMetaDataField.equals(that.agencyMetaDataField))
                                      : (that.agencyMetaDataField != null)) {
      return false;
    }

    if ((agencyQueueMappingField != null) ? (!agencyQueueMappingField.equals(that.agencyQueueMappingField))
                                          : (that.agencyQueueMappingField != null)) {
      return false;
    }

    if ((asMappingField != null) ? (!asMappingField.equals(that.asMappingField)) : (that.asMappingField != null)) {
      return false;
    }

    if ((criteriaVariable != null) ? (!criteriaVariable.equals(that.criteriaVariable))
                                   : (that.criteriaVariable != null)) {
      return false;
    }

    if ((priority != null) ? (!priority.equals(that.priority)) : (that.priority != null)) {
      return false;
    }

    if ((queueAction != null) ? (!queueAction.equals(that.queueAction)) : (that.queueAction != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency meta data field.
   *
   * @return  AgencyMetaDataField
   */
  public AgencyMetaDataField getAgencyMetaDataField() {
    return agencyMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency queue mapping field.
   *
   * @return  AgencyQueueMappingField
   */
  public AgencyQueueMappingField getAgencyQueueMappingField() {
    return agencyQueueMappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for as mapping field.
   *
   * @return  Boolean
   */
  public Boolean getAsMappingField() {
    return asMappingField;
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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mra criteria variable id.
   *
   * @return  String
   */
  public String getMraCriteriaVariableId() {
    if ((null != this.getAsMappingField()) && this.getAsMappingField()) {
      if (agencyQueueMappingField != null) {
        return "MappingField-" + agencyQueueMappingField.getId();
      } else {
        return null;
      }
    } else {
      if (criteriaVariable != null) {
        return "MetaData-" + criteriaVariable.getId();
      } else {
        return null;
      }
    }
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
   * getter method for queue action.
   *
   * @return  AgencyQueueAction
   */
  public AgencyQueueAction getQueueAction() {
    return queueAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable type.
   *
   * @return  String
   */
  public String getVariableType() {
    if ((null != this.getAsMappingField()) && this.getAsMappingField()) {
      variableType = (agencyQueueMappingField != null) ? agencyQueueMappingField.getDataType() : "";
    } else {
      variableType = (criteriaVariable != null) ? criteriaVariable.getDataType() : "";
    }

    return variableType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((agencyMetaDataField != null) ? agencyMetaDataField.hashCode() : 0);
    result = (31 * result) + ((agencyQueueMappingField != null) ? agencyQueueMappingField.hashCode() : 0);
    result = (31 * result) + ((asMappingField != null) ? asMappingField.hashCode() : 0);
    result = (31 * result) + ((criteriaVariable != null) ? criteriaVariable.hashCode() : 0);
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + ((queueAction != null) ? queueAction.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency meta data field.
   *
   * @param  agencyMetaDataField  AgencyMetaDataField
   */
  public void setAgencyMetaDataField(AgencyMetaDataField agencyMetaDataField) {
    this.agencyMetaDataField = agencyMetaDataField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency queue mapping field.
   *
   * @param  agencyQueueMappingField  AgencyQueueMappingField
   */
  public void setAgencyQueueMappingField(AgencyQueueMappingField agencyQueueMappingField) {
    this.agencyQueueMappingField = agencyQueueMappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for as mapping field.
   *
   * @param  asMappingField  Boolean
   */
  public void setAsMappingField(Boolean asMappingField) {
    this.asMappingField = asMappingField;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mra criteria variable id.
   *
   * @param  variableIdStr  String
   */
  public void setMraCriteriaVariableId(String variableIdStr) {
    if ((null != variableIdStr) && !"".equals(variableIdStr) && variableIdStr.contains("-")) {
      String[] tempIds = variableIdStr.split("-");

      if (tempIds.length > 1) {
        Long tempId = Long.valueOf(tempIds[1]);

        if ((null != this.getAsMappingField()) && this.getAsMappingField()) {
          if ((null != tempId) && (tempId != 0L)) {
            agencyQueueMappingField.setId(tempId);
          }
        } else {
          if ((null != tempId) && (tempId != 0L)) {
            criteriaVariable.setId(tempId);
          }
        }
      }

    }
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
   * setter method for queue action.
   *
   * @param  queueAction  AgencyQueueAction
   */
  public void setQueueAction(AgencyQueueAction queueAction) {
    this.queueAction = queueAction;
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
   * @see  com.ozstrategy.credagility.core.domain.CreatorEntity#toString()
   */
  @Override public String toString() {
    return "AgencyQueueSortCriteria{"
      + "id=" + id
      + ", agencyMetaDataField=" + agencyMetaDataField
      + ", agencyQueueMappingField=" + agencyQueueMappingField
      + ", asMappingField=" + asMappingField
      + ", priority=" + priority
      + ", queueAction=" + queueAction
      + '}';
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update schedule based on passed in template Only update schedule it self but not the related rules.
   *
   * @param   sortCriteria  schedule to use for update
   *
   * @return  update schedule based on passed in template Only update schedule it self but not the related rules
   */
  public boolean updateSortCriteria(AgencyQueueSortCriteria sortCriteria) {
    if ((null != sortCriteria.getAsMappingField()) && sortCriteria.getAsMappingField()) {
      this.agencyQueueMappingField = sortCriteria.getAgencyQueueMappingField();
      this.criteriaVariable        = null;
    } else {
      this.criteriaVariable        = sortCriteria.getCriteriaVariable();
      this.agencyQueueMappingField = null;
    }

    this.direction      = sortCriteria.getDirection();
    this.description    = sortCriteria.getDescription();
    this.priority       = sortCriteria.getPriority();
    this.lastUpdateDate = new Date();
    this.asMappingField = sortCriteria.getAsMappingField();
    this.variableType   = sortCriteria.getVariableType();

    return true;
  }


} // end class AgencyQueueSortCriteria
