package com.ozstrategy.credagility.core.domain.workflow.basic;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowRunningStatus;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowStepAction;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowStepStatus;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowTriggerSource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 13-2-19 : PM5:48</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class BasicWorkflowStep extends CreatorEntity implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowStepAction
   */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowStepAction action = WorkflowStepAction.ENTRY_NODE;

  /** <code>true</code> this step is currently execute. */
  @Column(
    name             = "current",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean current = false;

  /** Record the path like parent node name and current node name. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String depthNamePath;

  /** Record the path. */
  @Column protected String depthPath;

  /** The microseconds between entry date and exit date. */
  @Column(name = "duration")
  protected Long duration;

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowTriggerSource
   */
  @Column(length = 32)
  @Enumerated(value = EnumType.STRING)
  protected WorkflowTriggerSource entryChannel;

  /** Entry date. */
  @Column(
    name      = "entryDate",
    nullable  = false,
    updatable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date entryDate;

  /** The agent who execute this task. */
  @JoinColumn(
    name       = "executorId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User executor;

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowTriggerSource
   */
  @Column(length = 32)
  @Enumerated(value = EnumType.STRING)
  protected WorkflowTriggerSource exitChannel;

  /** Exit date. */
  @Column(name = "exitDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date exitDate;

  /** Step depth. */
  @Column(nullable = false)
  protected Integer flowDepth = 0;

  /** Task node name. */
  @Column(
    nullable = false,
    length   = 256
  )
  protected String name;

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowStepStatus
   */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowStepStatus status = WorkflowStepStatus.IN_PROCESS;

  /** DOCUMENT ME! */
  @Column(nullable = false)
  protected Integer stepNumber = 1;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract BasicWorkflowStep copy();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract BasicWorkflowStep getMainFlowStep();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract BasicWorkflowNode getNode();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract BasicWorkflowStep getPreviousStep();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<? extends BasicWorkflowStep> getSubSteps();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract BasicWorkflow getWorkflow();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract BasicWorkflowInstance getWorkflowInstance();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public WorkflowStepAction getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getCurrent() {
    if (current == null) {
      return Boolean.FALSE;
    }

    return current;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDepthNamePath() {
    return depthNamePath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDepthPath() {
    return depthPath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getDuration() {
    return duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public WorkflowTriggerSource getEntryChannel() {
    return entryChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getEntryDate() {
    return entryDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public User getExecutor() {
    return executor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public WorkflowTriggerSource getExitChannel() {
    return exitChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getExitDate() {
    return exitDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getFlowDepth() {
    return flowDepth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public WorkflowStepStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getStepNumber() {
    return stepNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isEditable() {
    try {
      if (WorkflowRunningStatus.FINISHED.equals(this.getWorkflowInstance().getStatus())) {
        return false;
      }

      Float f = new Float(flowDepth + "." + stepNumber);

      if (f > getWorkflowInstance().getAnchor()) {
        return true;
      }
    } catch (Exception e) { }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  step  DOCUMENT ME!
   */
  public void paste(BasicWorkflowStep step) {
    step.setAction(action);
    step.setCurrent(current);
    step.setDuration(duration);
    step.setFlowDepth(flowDepth);
    step.setDepthPath(depthPath);
    step.setName(name);
    step.setDepthNamePath(depthNamePath);
    step.setStepNumber(stepNumber);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  action  DOCUMENT ME!
   */
  public void setAction(WorkflowStepAction action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  current  DOCUMENT ME!
   */
  public void setCurrent(Boolean current) {
    this.current = current;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  depthNamePath  DOCUMENT ME!
   */
  public void setDepthNamePath(String depthNamePath) {
    this.depthNamePath = depthNamePath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  depthPath  DOCUMENT ME!
   */
  public void setDepthPath(String depthPath) {
    this.depthPath = depthPath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  duration  DOCUMENT ME!
   */
  public void setDuration(Long duration) {
    this.duration = duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  entryChannel  DOCUMENT ME!
   */
  public void setEntryChannel(WorkflowTriggerSource entryChannel) {
    this.entryChannel = entryChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  entryDate  DOCUMENT ME!
   */
  public void setEntryDate(Date entryDate) {
    this.entryDate = entryDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  executor  DOCUMENT ME!
   */
  public void setExecutor(User executor) {
    this.executor = executor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  exitChannel  DOCUMENT ME!
   */
  public void setExitChannel(WorkflowTriggerSource exitChannel) {
    this.exitChannel = exitChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  exitDate  DOCUMENT ME!
   */
  public void setExitDate(Date exitDate) {
    this.exitDate = exitDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flowDepth  DOCUMENT ME!
   */
  public void setFlowDepth(Integer flowDepth) {
    this.flowDepth = flowDepth;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name  DOCUMENT ME!
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  status  DOCUMENT ME!
   */
  public void setStatus(WorkflowStepStatus status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  stepNumber  DOCUMENT ME!
   */
  public void setStepNumber(Integer stepNumber) {
    this.stepNumber = stepNumber;
  }
} // end class BasicWorkflowStep
