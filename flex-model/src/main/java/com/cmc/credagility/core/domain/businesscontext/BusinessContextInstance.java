package com.cmc.credagility.core.domain.businesscontext;

import java.io.Serializable;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.transaction.TransactionData;
import com.cmc.credagility.core.domain.type.ActivityChannelType;
import com.cmc.credagility.core.domain.type.BCISourceType;
import com.cmc.credagility.core.domain.type.MetaDataValueType;

import com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowInstance;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCIWorkflowStep;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 11:46
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "sourceIndex",
      columnList = "source"
    )
  }
)
public class BusinessContextInstance extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID       = 988231950388290742L;
  private static String     DEFAULT_DATE_FORMATTER = "MM/dd/yyyy";

  /** TODO: DOCUMENT ME! */
  protected static final transient Logger log = LoggerFactory.getLogger(BusinessContextInstance.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    nullable  = true,
    updatable = true
  )
  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  protected Account account;


  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 32,
    nullable = true
  )
  @Enumerated(value = EnumType.STRING)
  protected ActivityChannelType activityChannel;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "businessContextId",
    nullable = false
  )
  @ManyToOne protected BusinessContext businessContext;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String color;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "customerId",
    nullable = true
  )
  @ManyToOne protected Customer customer;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "dynamicCaseId",
    nullable  = true,
    updatable = true
  )
  @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
  protected DynamicCase dynamicCase;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @MapKey(name = "fieldName")
  @OneToMany(
    mappedBy = "businessContextInstance",
    fetch    = FetchType.LAZY,
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected Map<String, BCIMetaDataValue> metaDataMap = new HashMap<String, BCIMetaDataValue>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "businessContextInstance"
  )
  protected Set<BCIMetaDataValue> metaDataSet = new HashSet<BCIMetaDataValue>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "responsibleId",
    nullable = true
  )
  @ManyToOne protected Responsible responsible;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 32,
    nullable = true
  )
  @Enumerated(value = EnumType.STRING)
  protected BCISourceType source = BCISourceType.W;

  /** TODO: DOCUMENT ME! */
  @Column(length = 100)
  protected String status = "Open";

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "transactionDataId",
    nullable  = true,
    updatable = true
  )
  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  protected TransactionData transactionData;

  /** TODO: DOCUMENT ME! */
  @Column(
    unique = true,
    length = 255
  )
  protected String uniqueId;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "businessContextInstance"
  )
  protected Set<BCIVariableMetaData> variableMetaDataSet = new HashSet<BCIVariableMetaData>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "workflowInstanceId",
    nullable  = true,
    updatable = true
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected BCIWorkflowInstance workflowInstance;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "triggerStepId",
    nullable  = true,
    updatable = true
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected BCIWorkflowStep workflowStep;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addBCIMetaDataValue.
   *
   * @param   fieldName         String
   * @param   bciMetaDataValue  BCIMetaDataValue
   *
   * @return  BCIMetaDataValue
   */
  public BCIMetaDataValue addBCIMetaDataValue(String fieldName, BCIMetaDataValue bciMetaDataValue) {
    bciMetaDataValue.setBusinessContextInstance(this);

    return getMetaDataMap().put(fieldName, bciMetaDataValue);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * createBCVariableMetaData.
   *
   * @param   field          BCVariableMetaDataField
   * @param   metaDataValue  Object
   *
   * @return  BCIVariableMetaData
   */
  public BCIVariableMetaData createBCVariableMetaData(BCVariableMetaDataField field, Object metaDataValue) {
    Object targetValue = null;

    if (metaDataValue == null) {
      log.info("Meta data value is null.");
    } else {
      targetValue = MetaDataValueType.convertToMetaType(field.getType(), metaDataValue);

      if (targetValue == null) {
        log.error("Meta data value type is not correct type.");
      }
    }


    Date now = new Date();

    BCIVariableMetaData curMetaData = new BCIVariableMetaData();
    curMetaData.setBusinessContextInstance(this);
    curMetaData.setBcVariableMetaDataField(field);
    curMetaData.setCreateDate(now);
    curMetaData.setLastUpdateDate(now);

    switch (field.getType()) {
      case INTEGER: {
        if (targetValue != null) {
          Integer intVal = (Integer) targetValue;
          curMetaData.setMetaDataIntegerValue(intVal);
          curMetaData.setValue(intVal.toString());
        }

        break;
      }

      case LONG: {
        if (targetValue != null) {
          Long longVal = (Long) targetValue;
          curMetaData.setMetaDataLongValue(longVal);
          curMetaData.setValue(longVal.toString());
        }

        break;
      }

      case BIGDECIMAL: {
        if (targetValue != null) {
          BigDecimal decimalVal = (BigDecimal) targetValue;
          curMetaData.setMetaDataDecimalValue(decimalVal);
          curMetaData.setValue(decimalVal.toString());
        }

        curMetaData.setLastUpdateDate(now);

        break;
      }

      case DATE: {
        if (targetValue != null) {
          Date dateVal = (Date) targetValue;
          curMetaData.setMetaDataDateValue(dateVal);

          SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMATTER);
          curMetaData.setValue(sdf.format(dateVal));
        }

        break;
      }

      case STRING: {
        if (targetValue != null) {
          curMetaData.setMetaDataStringValue(targetValue.toString());
          curMetaData.setValue(targetValue.toString());
        }

        break;
      }

      case BOOLEAN: {
        if (targetValue != null) {
          Boolean booleanVal = (Boolean) targetValue;
          curMetaData.setMetaDataBooleanValue(booleanVal);
          curMetaData.setValue(booleanVal.toString());
        }

        break;
      }
    } // end switch

    return curMetaData;
  } // end method createBCVariableMetaData

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof BusinessContextInstance)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BusinessContextInstance that = (BusinessContextInstance) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((businessContext != null) ? (!businessContext.equals(that.businessContext)) : (that.businessContext != null)) {
      return false;
    }

    if ((customer != null) ? (!customer.equals(that.customer)) : (that.customer != null)) {
      return false;
    }

    if ((responsible != null) ? (!responsible.equals(that.responsible)) : (that.responsible != null)) {
      return false;
    }

    if ((uniqueId != null) ? (!uniqueId.equals(that.uniqueId)) : (that.uniqueId != null)) {
      return false;
    }

    if ((activityChannel != null) ? (!activityChannel.equals(that.activityChannel)) : (that.activityChannel != null)) {
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
   * getter method for activity channel.
   *
   * @return  ActivityChannelType
   */
  public ActivityChannelType getActivityChannel() {
    return activityChannel;
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
   * getter method for color.
   *
   * @return  String
   */
  public String getColor() {
    return color;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer.
   *
   * @return  Customer
   */
  public Customer getCustomer() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dynamic case.
   *
   * @return  DynamicCase
   */
  public DynamicCase getDynamicCase() {
    return dynamicCase;
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
   * getter method for meta data map.
   *
   * @return  Map
   */
  public Map<String, BCIMetaDataValue> getMetaDataMap() {
    return metaDataMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for meta data set.
   *
   * @return  Set
   */
  public Set<BCIMetaDataValue> getMetaDataSet() {
    return metaDataSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source.
   *
   * @return  BCISourceType
   */
  public BCISourceType getSource() {
    return source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  String
   */
  public String getStatus() {
    if (StringUtils.isEmpty(status)) {
      return "Open";
    }

    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction data.
   *
   * @return  TransactionData
   */
  public TransactionData getTransactionData() {
    return transactionData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unique id.
   *
   * @return  String
   */
  public String getUniqueId() {
    return uniqueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for value.
   *
   * @param   fieldName  String
   *
   * @return  Object
   */
  public Object getValue(String fieldName) {
    Object           value    = null;
    BCIMetaDataValue metaData = metaDataMap.get(fieldName);

    if (log.isDebugEnabled()) {
      log.debug("BCI: " + this);
      log.debug("metaData: " + metaData);
    }

    if ((metaData != null)) {
      BCMetaDataField field = metaData.getMetaDataField();

      if (log.isDebugEnabled()) {
        log.debug("field: " + field);
      }

      if (field != null) {
        MetaDataValueType dataType = field.getType();

        switch (dataType) {
          case BOOLEAN: {
            value = metaData.getBooleanValue();
          }

          break;

          case DATE: {
            value = metaData.getDateValue();
          }

          break;

          case BIGDECIMAL: {
            if (org.springframework.util.StringUtils.hasText(metaData.getValue())) {
              try {
                return new BigDecimal(metaData.getValue());
              } catch (Exception e) { }
            }

            value = metaData.getDecimalValue();
          }

          break;

          case INTEGER: {
            value = metaData.getIntValue();
          }

          break;

          case LONG: {
            value = metaData.getLongValue();
          }

          break;

          case STRING: {
            value = metaData.getStringValue();
          }

          break;

          case TEXT: {
            value = metaData.getTextValue();
          }

          break;
        } // end switch
      }   // end if
    }     // end if

    return value;
  } // end method getValue

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable meta data set.
   *
   * @return  Set
   */
  public Set<BCIVariableMetaData> getVariableMetaDataSet() {
    return variableMetaDataSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow instance.
   *
   * @return  BCIWorkflowInstance
   */
  public BCIWorkflowInstance getWorkflowInstance() {
    return workflowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow step.
   *
   * @return  BCIWorkflowStep
   */
  public BCIWorkflowStep getWorkflowStep() {
    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((businessContext != null) ? businessContext.hashCode() : 0);
    result = (31 * result) + ((customer != null) ? customer.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);
    result = (31 * result) + ((uniqueId != null) ? uniqueId.hashCode() : 0);
    result = (31 * result) + ((activityChannel != null) ? activityChannel.hashCode() : 0);

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
   * setter method for activity channel.
   *
   * @param  activityChannel  ActivityChannelType
   */
  public void setActivityChannel(ActivityChannelType activityChannel) {
    this.activityChannel = activityChannel;
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
   * setter method for color.
   *
   * @param  color  String
   */
  public void setColor(String color) {
    this.color = color;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer.
   *
   * @param  customer  Customer
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dynamic case.
   *
   * @param  dynamicCase  DynamicCase
   */
  public void setDynamicCase(DynamicCase dynamicCase) {
    this.dynamicCase = dynamicCase;
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
   * setter method for meta data map.
   *
   * @param  metaDataMap  Map
   */
  public void setMetaDataMap(Map<String, BCIMetaDataValue> metaDataMap) {
    this.metaDataMap = metaDataMap;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for meta data set.
   *
   * @param  metaDataSet  Set
   */
  public void setMetaDataSet(Set<BCIMetaDataValue> metaDataSet) {
    this.metaDataSet = metaDataSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source.
   *
   * @param  source  BCISourceType
   */
  public void setSource(BCISourceType source) {
    this.source = source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  String
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transaction data.
   *
   * @param  transactionData  TransactionData
   */
  public void setTransactionData(TransactionData transactionData) {
    this.transactionData = transactionData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unique id.
   *
   * @param  uniqueId  String
   */
  public void setUniqueId(String uniqueId) {
    this.uniqueId = uniqueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable meta data set.
   *
   * @param  variableMetaDataSet  Set
   */
  public void setVariableMetaDataSet(Set<BCIVariableMetaData> variableMetaDataSet) {
    this.variableMetaDataSet = variableMetaDataSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow instance.
   *
   * @param  workflowInstance  BCIWorkflowInstance
   */
  public void setWorkflowInstance(BCIWorkflowInstance workflowInstance) {
    this.workflowInstance = workflowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow step.
   *
   * @param  workflowStep  BCIWorkflowStep
   */
  public void setWorkflowStep(BCIWorkflowStep workflowStep) {
    this.workflowStep = workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.CreatorEntity#toString()
   */
  @Override public String toString() {
    return "BusinessContextInstance{"
      + "id=" + id
      + ", uniqueId='" + uniqueId + '\''
      + ", businessContext=" + businessContext
      + ", account=" + account
      + ", responsible=" + responsible
      + ", customer=" + customer
      + ", dynamicCase=" + dynamicCase
      + ", color=" + color
      + '}';
  }
} // end class BusinessContextInstance
