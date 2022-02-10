package com.cmc.credagility.core.domain.account;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import com.ozstrategy.credagility.core.domain.SurveyFlowStep;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/15/2014 10:45
 */
@Entity
@Table(name = "AccountFlowVariableValue")
public class AccountFlowVariableValue extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "metaDataDateValue",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  public Date metaDataDateValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "metaDataDecimalValue",
    nullable  = true,
    precision = 19,
    scale     = 8
  )
  public BigDecimal metaDataDecimalValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "metaDataIntegerValue",
    nullable = true
  )
  public Integer metaDataIntegerValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "metaDataLongValue",
    nullable = true
  )
  public Long metaDataLongValue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "metaDataStringValue",
    length   = 2048,
    nullable = true
  )
  public String metaDataStringValue;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  public Long surveyFlowInstanceId;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean metaDataBooleanValue;


  /** TODO: DOCUMENT ME! */
  @Column(length = 32)
  @Enumerated(value = EnumType.STRING)
  protected WorkflowNodeActionTriggerType triggerType;

  /** Account link accountNum. */
  @JoinColumn(
    name     = "accountNum",
    nullable = false
  )
  @ManyToOne private Account account;

  @Column(nullable = false)
  private String dataType;

  /** SurveyFlowStep link flowStepId. */
  @JoinColumn(
    name     = "flowStepId",
    nullable = true
  )
  @ManyToOne private SurveyFlowStep surveyFlowStep;

  @Column(
    nullable = true,
    length   = 512
  )
  private String value;


  /** SurveyFlowVariable link variableId. */
  @JoinColumn(
    name     = "variableId",
    nullable = false
  )
  @ManyToOne private BaseVariable variable;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * clearValue.
   */
  public void clearValue() {
    this.setMetaDataBooleanValue(null);
    this.setMetaDataDateValue(null);
    this.setMetaDataDecimalValue(null);
    this.setMetaDataIntegerValue(null);
    this.setMetaDataLongValue(null);
    this.setMetaDataStringValue(null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    AccountFlowVariableValue that = (AccountFlowVariableValue) o;

    if (!account.equals(that.account)) {
      return false;
    }

    if (!dataType.equals(that.dataType)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((value != null) ? (!value.equals(that.value)) : (that.value != null)) {
      return false;
    }

    if (!variable.equals(that.variable)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data boolean value.
   *
   * @return  Boolean
   */
  public Boolean getMetaDataBooleanValue() {
    return metaDataBooleanValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data date value.
   *
   * @return  Date
   */
  public Date getMetaDataDateValue() {
    return metaDataDateValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data decimal value.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMetaDataDecimalValue() {
    return metaDataDecimalValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data integer value.
   *
   * @return  Integer
   */
  public Integer getMetaDataIntegerValue() {
    return metaDataIntegerValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data long value.
   *
   * @return  Long
   */
  public Long getMetaDataLongValue() {
    return metaDataLongValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data string value.
   *
   * @return  String
   */
  public String getMetaDataStringValue() {
    return metaDataStringValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data value.
   *
   * @return  Object
   */
  public Object getMetaDataValue() {
    String type = this.dataType;

    if ("Integer".equalsIgnoreCase(type)
          || "java.lang.Integer".equalsIgnoreCase(type)) {
      return getMetaDataIntegerValue();
    } else if ("Long".equalsIgnoreCase(type)
          || "java.lang.Long".equalsIgnoreCase(type)) {
      return getMetaDataLongValue();
    } else if ("BigDecimal".equalsIgnoreCase(type)
          || "java.math.BigDecimal".equalsIgnoreCase(type)) {
      if (StringUtils.hasText(value)) {
        try {
          return new BigDecimal(value);
        } catch (Exception e) { }
      }

      return getMetaDataDecimalValue();
    } else if ("Boolean".equalsIgnoreCase(type)
          || "java.lang.Boolean".equalsIgnoreCase(type)) {
      return getMetaDataBooleanValue();
    } else if ("Date".equalsIgnoreCase(type)
          || "java.util.Date".equalsIgnoreCase(type)) {
      return getMetaDataDateValue();
    } else if ("String".equalsIgnoreCase(type)
          || "java.lang.String".equalsIgnoreCase(type)) {
      return getMetaDataStringValue();
    }

    return null;
  } // end method getMetaDataValue

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey flow instance id.
   *
   * @return  Long
   */
  public Long getSurveyFlowInstanceId() {
    return surveyFlowInstanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey flow step.
   *
   * @return  SurveyFlowStep
   */
  public SurveyFlowStep getSurveyFlowStep() {
    return surveyFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trigger type.
   *
   * @return  WorkflowNodeActionTriggerType
   */
  public WorkflowNodeActionTriggerType getTriggerType() {
    return triggerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for value.
   *
   * @return  String
   */
  public String getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable.
   *
   * @return  BaseVariable
   */
  public BaseVariable getVariable() {
    return variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + account.hashCode();
    result = (31 * result) + dataType.hashCode();
    result = (31 * result) + ((value != null) ? value.hashCode() : 0);
    result = (31 * result) + variable.hashCode();

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data boolean value.
   *
   * @param  metaDataBooleanValue  Boolean
   */
  public void setMetaDataBooleanValue(Boolean metaDataBooleanValue) {
    this.metaDataBooleanValue = metaDataBooleanValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data date value.
   *
   * @param  metaDataDateValue  Date
   */
  public void setMetaDataDateValue(Date metaDataDateValue) {
    this.metaDataDateValue = metaDataDateValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data decimal value.
   *
   * @param  metaDataDecimalValue  BigDecimal
   */
  public void setMetaDataDecimalValue(BigDecimal metaDataDecimalValue) {
    this.metaDataDecimalValue = metaDataDecimalValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data integer value.
   *
   * @param  metaDataIntegerValue  Integer
   */
  public void setMetaDataIntegerValue(Integer metaDataIntegerValue) {
    this.metaDataIntegerValue = metaDataIntegerValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data long value.
   *
   * @param  metaDataLongValue  Long
   */
  public void setMetaDataLongValue(Long metaDataLongValue) {
    this.metaDataLongValue = metaDataLongValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data string value.
   *
   * @param  metaDataStringValue  String
   */
  public void setMetaDataStringValue(String metaDataStringValue) {
    this.metaDataStringValue = metaDataStringValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  value  DOCUMENT ME!
   */
  public void setMetaDataValue(Object value) {
    String type = this.dataType;
    clearValue();

    if (value == null) {
      return;
    }

    if ("Integer".equalsIgnoreCase(type)
          || "java.lang.Integer".equalsIgnoreCase(type)) {
      setMetaDataIntegerValue(new Integer(value.toString()));
    } else if ("Long".equalsIgnoreCase(type)
          || "java.lang.Long".equalsIgnoreCase(type)) {
      setMetaDataLongValue(new Long(value.toString()));
    } else if ("BigDecimal".equalsIgnoreCase(type)
          || "java.math.BigDecimal".equalsIgnoreCase(type)) {
      setMetaDataDecimalValue(new BigDecimal(value.toString()));
    } else if ("Boolean".equalsIgnoreCase(type)
          || "java.lang.Boolean".equalsIgnoreCase(type)) {
      setMetaDataBooleanValue(new Boolean(value.toString()));
    } else if ("Date".equalsIgnoreCase(type)
          || "java.util.Date".equalsIgnoreCase(type)) {
      setMetaDataDateValue((Date) value);
    } else if ("String".equalsIgnoreCase(type)
          || "java.lang.String".equalsIgnoreCase(type)) {
      setMetaDataStringValue(value.toString());
    }

    this.value = value.toString();
  } // end method setMetaDataValue

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey flow instance id.
   *
   * @param  surveyFlowInstanceId  Long
   */
  public void setSurveyFlowInstanceId(Long surveyFlowInstanceId) {
    this.surveyFlowInstanceId = surveyFlowInstanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey flow step.
   *
   * @param  surveyFlowStep  SurveyFlowStep
   */
  public void setSurveyFlowStep(SurveyFlowStep surveyFlowStep) {
    this.surveyFlowStep = surveyFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trigger type.
   *
   * @param  triggerType  WorkflowNodeActionTriggerType
   */
  public void setTriggerType(WorkflowNodeActionTriggerType triggerType) {
    this.triggerType = triggerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value.
   *
   * @param  value  String
   */
  public void setValue(String value) {
    this.value = value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable.
   *
   * @param  variable  BaseVariable
   */
  public void setVariable(BaseVariable variable) {
    this.variable = variable;
  }


} // end class AccountFlowVariableValue
