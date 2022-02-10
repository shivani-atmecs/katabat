package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.cmc.credagility.core.domain.customer.Customer;
import com.ozstrategy.credagility.core.domain.type.BusinessDataType;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElementAnswer;
import com.ozstrategy.credagility.core.domain.workflow.customer.version.CustomerWorkflowTaskElementVersion;
import com.ozstrategy.credagility.core.util.DataFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  04/07/2017 15:18
 */
@Entity
@Table(name = "CustomerWorkflowTaskElementAnswer")
public class CustomerWorkflowTaskElementAnswer extends BasicWorkflowTaskElementAnswer implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -1351274070577871643L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "customerId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;

  /** Primary key. */
  @Column(
    name     = "answerId",
    nullable = false
  )
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** Task submitted for this answer. */
  @JoinColumn(
    name      = "taskId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTask task;

  /** Task element for this answer. */
  @JoinColumn(
    name      = "taskElementId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTaskElement taskElement = new CustomerWorkflowTaskElement();


  /** DOCUMENT ME! */
  @JoinColumn(
    name     = "taskElementVersionId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTaskElementVersion taskElementVersion;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "workflowId",
    updatable  = false,
    insertable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflow workflow;

  /** DOCUMENT ME! */
  @Column(name = "workflowId")
  protected Long workflowId;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "workflowStepId",
    updatable  = false,
    insertable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowStep workflowStep;

  /** DOCUMENT ME! */
  @Column(name = "workflowStepId")
  protected Long workflowStepId;

  private final transient Logger logger = LoggerFactory.getLogger(getClass());

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTask getTask() {
    return task;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskElement getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskElementVersion getTaskElementVersion() {
    return taskElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Object getTypedData() {
    if (this.data == null) {
      return null;
    }

    String dataStr = this.data.trim();

    try {
      if ("Currency".equalsIgnoreCase(this.businessDataType)
            || "Decimal".equalsIgnoreCase(this.businessDataType)
            || "Percentage".equalsIgnoreCase(this.businessDataType)) {
        BigDecimal ret = null;

        if (StringUtils.hasText(dataStr)) {
          dataStr = dataStr.replaceAll("\\,", "");

          try {
            ret = new BigDecimal(dataStr);
          } catch (Exception e) {
            ret = null;
          }
        }

        return ret;
      } else if ("Date".equalsIgnoreCase(this.businessDataType)) {
        try {
          if (StringUtils.hasText(this.valueFormat)) {
            SimpleDateFormat sdf = new SimpleDateFormat(this.valueFormat);
            Date             d   = sdf.parse(dataStr);

            return d;
          }
        } catch (Exception e) { }

        return DataFormatter.toDate(dataStr);
      } else if ("Long".equalsIgnoreCase(this.businessDataType)
            || "Integer".equalsIgnoreCase(this.businessDataType)) {
        Long ret = null;

        if (StringUtils.hasText(dataStr)) {
          try {
            ret = new Long(dataStr);
          } catch (Exception e) {
            ret = null;
          }
        }

        return ret;
      } else if ("String".equalsIgnoreCase(this.businessDataType)) {
        return data;
      } else if ("Boolean".equalsIgnoreCase(this.businessDataType)) {
        return "YES".equalsIgnoreCase(dataStr)
          || "TRUE".equalsIgnoreCase(dataStr);
      } else if (BusinessDataType.DOCUMENT_UPLOAD.toString().equalsIgnoreCase(this.businessDataType)
            || BusinessDataType.DOCUMENT_PREVIEW.toString().equalsIgnoreCase(this.businessDataType)
            || BusinessDataType.DOCUMENT_STATUS.toString().equalsIgnoreCase(this.businessDataType)) {
        Long ret = null;

        if (StringUtils.hasText(dataStr)) {
          try {
            ret = new Long(dataStr);
          } catch (Exception e) {
            ret = null;
          }
        }

        return ret;
      } // end if-else
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      logger.error(dataStr + " is not a valid value for task code: "
        + this.task.getTaskCode() + " at " + this.answerDate
        + ". Can not convert to " + this.businessDataType + ".");
    }   // end try-catch

    return null;
  } // end method getTypedData

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getWorkflowId() {
    return workflowId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowStep getWorkflowStep() {
    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getWorkflowStepId() {
    return workflowStepId;
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
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  task  DOCUMENT ME!
   */
  public void setTask(CustomerWorkflowTask task) {
    this.task = task;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskElement  DOCUMENT ME!
   */
  public void setTaskElement(CustomerWorkflowTaskElement taskElement) {
    this.taskElement = taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskElementVersion  DOCUMENT ME!
   */
  public void setTaskElementVersion(CustomerWorkflowTaskElementVersion taskElementVersion) {
    this.taskElementVersion = taskElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflow  DOCUMENT ME!
   */
  public void setWorkflow(CustomerWorkflow workflow) {
    this.workflow = workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowId  DOCUMENT ME!
   */
  public void setWorkflowId(Long workflowId) {
    this.workflowId = workflowId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowStep  DOCUMENT ME!
   */
  public void setWorkflowStep(CustomerWorkflowStep workflowStep) {
    this.workflowStep = workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowStepId  DOCUMENT ME!
   */
  public void setWorkflowStepId(Long workflowStepId) {
    this.workflowStepId = workflowStepId;
  }
} // end class CustomerWorkflowTaskElementAnswer
