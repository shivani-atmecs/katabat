package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.account.AccountMetaDataField;
import com.cmc.credagility.core.domain.mra.QueueAccountMappingField;
import com.cmc.credagility.core.domain.portfolio.PortfolioVariable;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store queue sorting criteria information.
 *
 * <p><a href="QueueSortCriteria.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/16/2014 14:32
 */
@Entity public class QueueSortCriteria extends BaseSortCriteria implements Calculatable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "accountMetaDataFieldId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AccountMetaDataField accountMetaDataField;


  /** TODO: DOCUMENT ME! */
  @Column protected Boolean asMappingField = false;

  /** Queue sorting criteria. */
  @JoinColumn(
    name       = "variableId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BaseVariable criteriaVariable = new PortfolioVariable();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "queueAccountMappingFieldId",
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected QueueAccountMappingField queueAccountMappingField = new QueueAccountMappingField();

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
  private QueueAction queueAction = new QueueAction();

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
   * @return  QueueSortCriteria
   */
  public QueueSortCriteria duplicate() {
    QueueSortCriteria newCopy = new QueueSortCriteria();
    newCopy.setDescription(description);
    newCopy.setDirection(direction);
    newCopy.setPriority(priority);
    newCopy.setQueueAction(queueAction);

    newCopy.setAsMappingField(asMappingField);

    if ((null != this.getAsMappingField()) && this.getAsMappingField()) {
      newCopy.setQueueAccountMappingField(queueAccountMappingField);
    } else {
      newCopy.setCriteriaVariable(criteriaVariable);
      newCopy.setAccountMetaDataField(accountMetaDataField);
    }

    return newCopy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
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

    QueueSortCriteria that = (QueueSortCriteria) o;

    if ((accountMetaDataField != null) ? (!accountMetaDataField.equals(that.accountMetaDataField))
                                       : (that.accountMetaDataField != null)) {
      return false;
    }

    if ((asMappingField != null) ? (!asMappingField.equals(that.asMappingField)) : (that.asMappingField != null)) {
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

    if ((queueAccountMappingField != null) ? (!queueAccountMappingField.equals(that.queueAccountMappingField))
                                           : (that.queueAccountMappingField != null)) {
      return false;
    }

    if ((queueAction != null) ? (!queueAction.equals(that.queueAction)) : (that.queueAction != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account meta data field.
   *
   * @return  AccountMetaDataField
   */
  public AccountMetaDataField getAccountMetaDataField() {
    return accountMetaDataField;
  }

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
   * schedule name.
   *
   * <p>.@return schedule name</p>
   *
   * @return  schedule name.
   */
  public String getCriteriaVariableName() {
    if ((null == this.getAsMappingField()) || !this.getAsMappingField()) {
      if (criteriaVariable != null) {
        return criteriaVariable.getName();
      } else {
        return null;
      }
    } else {
      if (queueAccountMappingField != null) {
        return queueAccountMappingField.getDisplayName();
      } else {
        return null;
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * schedule id.
   *
   * <p>.@return schedule id</p>
   *
   * @return  schedule id.
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
      if (queueAccountMappingField != null) {
        return "MappingField-" + queueAccountMappingField.getId();
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
   * getter method for queue account mapping field.
   *
   * @return  QueueAccountMappingField
   */
  public QueueAccountMappingField getQueueAccountMappingField() {
    return queueAccountMappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue action.
   *
   * @return  QueueAction
   */
  public QueueAction getQueueAction() {
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
      variableType = (queueAccountMappingField != null) ? queueAccountMappingField.getDataType() : "";
    } else {
      variableType = (criteriaVariable != null) ? criteriaVariable.getDataType() : "";
    }

    return variableType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((accountMetaDataField != null) ? accountMetaDataField.hashCode() : 0);
    result = (31 * result) + ((queueAccountMappingField != null) ? queueAccountMappingField.hashCode() : 0);
    result = (31 * result) + ((asMappingField != null) ? asMappingField.hashCode() : 0);
    result = (31 * result) + ((criteriaVariable != null) ? criteriaVariable.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + ((queueAction != null) ? queueAction.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account meta data field.
   *
   * @param  accountMetaDataField  AccountMetaDataField
   */
  public void setAccountMetaDataField(AccountMetaDataField accountMetaDataField) {
    this.accountMetaDataField = accountMetaDataField;
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
   * Set schedule name.
   *
   * <p>.@param name</p>
   *
   * @param  name  String
   */
  public void setCriteriaVariableName(String name) {
    if ((null == this.getAsMappingField()) || !this.getAsMappingField()) {
      criteriaVariable.setName(name);
    } else {
      queueAccountMappingField.setDisplayName(name);
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * schedule id.
   *
   * <p>.@param id</p>
   *
   * @param  id  DOCUMENT ME!
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
            queueAccountMappingField.setId(tempId);
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
   * setter method for queue account mapping field.
   *
   * @param  queueAccountMappingField  QueueAccountMappingField
   */
  public void setQueueAccountMappingField(QueueAccountMappingField queueAccountMappingField) {
    this.queueAccountMappingField = queueAccountMappingField;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue action.
   *
   * @param  queueAction  QueueAction
   */
  public void setQueueAction(QueueAction queueAction) {
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
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    return "QueueSortCriteria{"
      + "accountMetaDataField=" + accountMetaDataField
      + ", queueAccountMappingField=" + queueAccountMappingField
      + ", asMappingField=" + asMappingField
      + ", criteriaVariable=" + criteriaVariable
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
  public boolean updateSortCriteria(QueueSortCriteria sortCriteria) {
    if ((null != sortCriteria.getAsMappingField()) && sortCriteria.getAsMappingField()) {
      this.queueAccountMappingField = sortCriteria.getQueueAccountMappingField();
      this.criteriaVariable         = null;
    } else {
      this.criteriaVariable         = sortCriteria.getCriteriaVariable();
      this.queueAccountMappingField = null;
    }

    this.direction      = sortCriteria.getDirection();
    this.description    = sortCriteria.getDescription();
    this.asMappingField = sortCriteria.getAsMappingField();
    this.priority       = sortCriteria.getPriority();
    this.lastUpdateDate = new Date();
    setLastUpdater(sortCriteria.getCreator());

    return true;
  }
} // end class QueueSortCriteria
