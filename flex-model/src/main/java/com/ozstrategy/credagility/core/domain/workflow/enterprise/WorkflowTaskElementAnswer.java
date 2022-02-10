package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.type.BusinessDataType;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElementAnswer;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.version.EnterpriseWorkflowTaskElementVersion;
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
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/17/2014 14:20
 */
@DiscriminatorColumn(
  name              = "category",
  discriminatorType = DiscriminatorType.STRING
)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(
  name    = "EnterpriseWorkflowTaskElementAnswer",
  indexes =
    @Index(
      name = "categoryIndex",
      columnList = "category"
    )
)
public abstract class WorkflowTaskElementAnswer extends BasicWorkflowTaskElementAnswer implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4918964053733540985L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Primary key. */
  @Column(
    name     = "answerId",
    nullable = false
  )
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long answerId;

  /** Category : Enterprise / Agency/ Agent. */
  @Column(
    nullable   = false,
    insertable = false,
    updatable  = false,
    length     = 10
  )
  protected String category;

  /** Task submitted for this answer. */
  @JoinColumn(
    name      = "taskId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTask task;

  /** Task element for this answer. */
  @JoinColumn(
    name      = "taskElementId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTaskElement taskElement = new EnterpriseWorkflowTaskElement();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "taskElementVersionId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTaskElementVersion taskElementVersion;

  /** Ref SurveyFlow. */
  @JoinColumn(
    name       = "workflowId",
    updatable  = false,
    insertable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflow workflow;

  /** Ref Workflow. */
  @Column(name = "workflowId")
  protected Long workflowId;

  /** Ref SurveyFlow. */
  @JoinColumn(
    name       = "workflowStepId",
    updatable  = false,
    insertable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowStep workflowStep;

  /** Ref SurveyFlowStep. */
  @Column(name = "workflowStepId")
  protected Long workflowStepId;

  private final transient Logger logger = LoggerFactory.getLogger(getClass());

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for business object.
   *
   * @return  Object
   */
  public abstract Object getBusinessObject();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  businessObject  DOCUMENT ME!
   */
  public abstract void setBusinessObject(Object businessObject);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer id.
   *
   * @return  Long
   */
  public Long getAnswerId() {
    return answerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category.
   *
   * @return  String
   */
  public String getCategory() {
    return category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task.
   *
   * @return  EnterpriseWorkflowTask
   */
  public EnterpriseWorkflowTask getTask() {
    return task;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task element.
   *
   * @return  EnterpriseWorkflowTaskElement
   */
  public EnterpriseWorkflowTaskElement getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task element version.
   *
   * @return  EnterpriseWorkflowTaskElementVersion
   */
  public EnterpriseWorkflowTaskElementVersion getTaskElementVersion() {
    return taskElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for typed data.
   *
   * @return  Object
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
        return data;
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
   * getter method for workflow.
   *
   * @return  EnterpriseWorkflow
   */
  public EnterpriseWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow id.
   *
   * @return  Long
   */
  public Long getWorkflowId() {
    return workflowId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow step.
   *
   * @return  WorkflowStep
   */
  public WorkflowStep getWorkflowStep() {
    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow step id.
   *
   * @return  Long
   */
  public Long getWorkflowStepId() {
    return workflowStepId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for answer id.
   *
   * @param  answerId  Long
   */
  public void setAnswerId(Long answerId) {
    this.answerId = answerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category.
   *
   * @param  category  String
   */
  public void setCategory(String category) {
    this.category = category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task.
   *
   * @param  task  EnterpriseWorkflowTask
   */
  public void setTask(EnterpriseWorkflowTask task) {
    this.task = task;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task element.
   *
   * @param  taskElement  EnterpriseWorkflowTaskElement
   */
  public void setTaskElement(EnterpriseWorkflowTaskElement taskElement) {
    this.taskElement = taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task element version.
   *
   * @param  taskElementVersion  EnterpriseWorkflowTaskElementVersion
   */
  public void setTaskElementVersion(EnterpriseWorkflowTaskElementVersion taskElementVersion) {
    this.taskElementVersion = taskElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow.
   *
   * @param  workflow  EnterpriseWorkflow
   */
  public void setWorkflow(EnterpriseWorkflow workflow) {
    this.workflow = workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow id.
   *
   * @param  workflowId  Long
   */
  public void setWorkflowId(Long workflowId) {
    this.workflowId = workflowId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow step.
   *
   * @param  workflowStep  WorkflowStep
   */
  public void setWorkflowStep(WorkflowStep workflowStep) {
    this.workflowStep = workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow step id.
   *
   * @param  workflowStepId  Long
   */
  public void setWorkflowStepId(Long workflowStepId) {
    this.workflowStepId = workflowStepId;
  }
} // end class WorkflowTaskElementAnswer
