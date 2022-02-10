package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.ozstrategy.credagility.core.domain.type.BusinessDataType;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElementAnswer;
import com.ozstrategy.credagility.core.domain.workflow.bci.version.BCWorkflowTaskElementVersion;
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
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 11/18/13 : 3:00 PM</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCIWorkflowTaskElementAnswer")
public class BCIWorkflowTaskElementAnswer extends BasicWorkflowTaskElementAnswer implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6735737335701406562L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** BusinessContextInstance PK bciId. */
  @JoinColumn(
    name       = "bciId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContextInstance bci;

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
  protected BCWorkflowTask task;

  /** Task element for this answer. */
  @JoinColumn(
    name      = "taskElementId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTaskElement taskElement = new BCWorkflowTaskElement();


  /** BCWorkflowTaskElementVersion PK taskElementVersionId. */
  @JoinColumn(
    name     = "taskElementVersionId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTaskElementVersion taskElementVersion;

  /** BCWorkflow PK workflowId. */
  @JoinColumn(
    name       = "workflowId",
    updatable  = false,
    insertable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflow workflow;

  /** workflowId. */
  @Column(name = "workflowId")
  protected Long workflowId;

  /** BCIWorkflowStep PK workflowStepId. */
  @JoinColumn(
    name       = "workflowStepId",
    updatable  = false,
    insertable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIWorkflowStep workflowStep;

  /** workflowStepId. */
  @Column(name = "workflowStepId")
  protected Long workflowStepId;

  private final transient Logger logger = LoggerFactory.getLogger(getClass());

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BusinessContextInstance getBci() {
    return bci;
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
  public BCWorkflowTask getTask() {
    return task;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskElement getTaskElement() {
    return taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskElementVersion getTaskElementVersion() {
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
  public BCWorkflow getWorkflow() {
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
  public BCIWorkflowStep getWorkflowStep() {
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
   * DOCUMENT ME!
   *
   * @param  bci  DOCUMENT ME!
   */
  public void setBci(BusinessContextInstance bci) {
    this.bci = bci;
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
  public void setTask(BCWorkflowTask task) {
    this.task = task;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskElement  DOCUMENT ME!
   */
  public void setTaskElement(BCWorkflowTaskElement taskElement) {
    this.taskElement = taskElement;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskElementVersion  DOCUMENT ME!
   */
  public void setTaskElementVersion(BCWorkflowTaskElementVersion taskElementVersion) {
    this.taskElementVersion = taskElementVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflow  DOCUMENT ME!
   */
  public void setWorkflow(BCWorkflow workflow) {
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
  public void setWorkflowStep(BCIWorkflowStep workflowStep) {
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
} // end class BCIWorkflowTaskElementAnswer
