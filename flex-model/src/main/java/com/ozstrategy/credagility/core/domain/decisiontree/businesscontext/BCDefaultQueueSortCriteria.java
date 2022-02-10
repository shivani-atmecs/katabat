package com.ozstrategy.credagility.core.domain.decisiontree.businesscontext;

import com.cmc.credagility.core.domain.businesscontext.BCAvailableMappingField;
import com.cmc.credagility.core.domain.businesscontext.BCVariable;
import com.cmc.credagility.core.domain.businesscontext.BCVariableMetaDataField;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.BaseSortCriteria;
import com.ozstrategy.credagility.core.domain.Calculatable;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store BCDefaultQueueSortCriteria information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 10:45
 */
@Entity public class BCDefaultQueueSortCriteria extends BaseSortCriteria implements Calculatable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7972766054064421890L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean asMappingField = false;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "bcAvailableMappingFieldId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCAvailableMappingField bcAvailableMappingField = new BCAvailableMappingField();

  /** Queue sorting criteria. */
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
    name       = "variableMetaDataFieldId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCVariableMetaDataField variableMetaDataField;

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
  private BCQueueAction queueAction = new BCQueueAction();

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
   * @return  BCDefaultQueueSortCriteria
   */
  public BCDefaultQueueSortCriteria duplicate() {
    BCDefaultQueueSortCriteria newCopy = new BCDefaultQueueSortCriteria();
    newCopy.setDescription(description);
    newCopy.setDirection(direction);
    newCopy.setPriority(priority);
    newCopy.setQueueAction(queueAction);
    newCopy.setAsMappingField(asMappingField);

    if ((null != this.getAsMappingField()) && this.getAsMappingField()) {
      newCopy.setBcAvailableMappingField(bcAvailableMappingField);
    } else {
      newCopy.setCriteriaVariable(criteriaVariable);
      newCopy.setVariableMetaDataField(variableMetaDataField);
    }

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

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BCDefaultQueueSortCriteria that = (BCDefaultQueueSortCriteria) o;

    if ((variableMetaDataField != null) ? (!variableMetaDataField.equals(that.variableMetaDataField))
                                        : (that.variableMetaDataField != null)) {
      return false;
    }

    if ((asMappingField != null) ? (!asMappingField.equals(that.asMappingField)) : (that.asMappingField != null)) {
      return false;
    }

    if ((bcAvailableMappingField != null) ? (!bcAvailableMappingField.equals(that.bcAvailableMappingField))
                                          : (that.bcAvailableMappingField != null)) {
      return false;
    }

    if ((criteriaVariable != null) ? (!criteriaVariable.equals(that.criteriaVariable))
                                   : (that.criteriaVariable != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
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
   * getter method for as mapping field.
   *
   * @return  Boolean
   */
  public Boolean getAsMappingField() {
    if (asMappingField == null) {
      return Boolean.FALSE;
    }

    return asMappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bc available mapping field.
   *
   * @return  BCAvailableMappingField
   */
  public BCAvailableMappingField getBcAvailableMappingField() {
    return bcAvailableMappingField;
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
    if ((null == this.getAsMappingField()) || !this.getAsMappingField()) {
      if (criteriaVariable != null) {
        return criteriaVariable.getName();
      } else {
        return null;
      }
    } else {
      if (bcAvailableMappingField != null) {
        return bcAvailableMappingField.getDisplayName();
      } else {
        return null;
      }
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
      if (bcAvailableMappingField != null) {
        return "MappingField-" + bcAvailableMappingField.getId();
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
   * @return  BCQueueAction
   */
  public BCQueueAction getQueueAction() {
    return queueAction;
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
   * getter method for variable type.
   *
   * @return  String
   */
  public String getVariableType() {
    if ((null != this.getAsMappingField()) && this.getAsMappingField()) {
      variableType = (bcAvailableMappingField != null) ? bcAvailableMappingField.getDataType() : "";
    } else {
      variableType = (criteriaVariable != null) ? criteriaVariable.getDataType() : "";
    }

    return variableType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.BaseSortCriteria#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((variableMetaDataField != null) ? variableMetaDataField.hashCode() : 0);
    result = (31 * result) + ((criteriaVariable != null) ? criteriaVariable.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((bcAvailableMappingField != null) ? bcAvailableMappingField.hashCode() : 0);
    result = (31 * result) + ((asMappingField != null) ? asMappingField.hashCode() : 0);
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + ((queueAction != null) ? queueAction.hashCode() : 0);

    return result;
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
   * setter method for bc available mapping field.
   *
   * @param  bcAvailableMappingField  BCAvailableMappingField
   */
  public void setBcAvailableMappingField(BCAvailableMappingField bcAvailableMappingField) {
    this.bcAvailableMappingField = bcAvailableMappingField;
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
    if ((null == this.getAsMappingField()) || !this.getAsMappingField()) {
      criteriaVariable.setName(name);
    } else {
      bcAvailableMappingField.setDisplayName(name);
    }
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
            bcAvailableMappingField.setId(tempId);
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
   * @param  queueAction  BCQueueAction
   */
  public void setQueueAction(BCQueueAction queueAction) {
    this.queueAction = queueAction;
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
   * setter method for variable type.
   *
   * @param  variableType  String
   */
  public void setVariableType(String variableType) {
    this.variableType = variableType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public String toString() {
    return "QueueSortCriteria{"
      + "variableMetaDataField=" + variableMetaDataField
      + ", criteriaVariable=" + criteriaVariable
      + ", asMappingField=" + asMappingField
      + ", bcAvailableMappingField=" + bcAvailableMappingField
      + ", id=" + id
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
  public boolean updateSortCriteria(BCDefaultQueueSortCriteria sortCriteria) {
    if ((null != sortCriteria.getAsMappingField()) && sortCriteria.getAsMappingField()) {
      this.bcAvailableMappingField = sortCriteria.getBcAvailableMappingField();
      this.criteriaVariable        = null;
    } else {
      this.criteriaVariable        = sortCriteria.getCriteriaVariable();
      this.bcAvailableMappingField = null;
    }

    this.direction      = sortCriteria.getDirection();
    this.description    = sortCriteria.getDescription();
    this.priority       = sortCriteria.getPriority();
    this.lastUpdateDate = new Date();
    this.asMappingField = sortCriteria.getAsMappingField();
    this.variableType   = sortCriteria.getVariableType();

    return true;
  }
} // end class BCDefaultQueueSortCriteria
