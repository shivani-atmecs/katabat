package com.ozstrategy.credagility.core.domain.workflow.basic;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.EnterpriseHotSpot;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowRunningStatus;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowTriggerSource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 13-2-19 : PM5:48</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class BasicWorkflowInstance<Step extends BasicWorkflowStep> extends CreatorEntity
  implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The workflow instance anchor. */
  @Column protected Float anchor = 0.0F;

  /** The agent who cancel this flow. */
  @JoinColumn(name = "cancelBy")
  @ManyToOne(fetch = FetchType.LAZY)
  protected User cancelBy;

  /** The hotSpot which trigger this flow. */
  @JoinColumn(
    name       = "hotSpotId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseHotSpot hotSpot;

  /** The agent who start this flow. */
  @JoinColumn(
    name       = "starterId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User starter;

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowRunningStatus
   */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowRunningStatus status = WorkflowRunningStatus.IN_PROCESS;

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowTriggerSource
   */
  @Column(length = 32)
  @Enumerated(value = EnumType.STRING)
  protected WorkflowTriggerSource triggerSource;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<Step> getSteps();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public abstract Set<Step> getStepSet();

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
   * @param  step  DOCUMENT ME!
   */
  public void addWorkflowStep(Step step) {
    getStepSet().add(step);
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

    BasicWorkflowInstance that = (BasicWorkflowInstance) o;

    if ((anchor != null) ? (!anchor.equals(that.anchor)) : (that.anchor != null)) {
      return false;
    }

    if (status != that.status) {
      return false;
    }

    if (triggerSource != that.triggerSource) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Float getAnchor() {
    return anchor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public User getCancelBy() {
    return cancelBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Step getCurrentStep() {
    for (Step step : getCurrentStepSet()) {
      if (Boolean.TRUE.equals(step.getCurrent())) {
        return step;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public EnterpriseHotSpot getHotSpot() {
    return hotSpot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   curStep  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BasicWorkflowStep getNextStep(BasicWorkflowStep curStep) {
    BasicWorkflowStep nextStep = null;

    for (BasicWorkflowStep step : getSteps()) {
      if (curStep.equals(step.getPreviousStep())) {
        nextStep = step;

        break;
      }
    }

    return nextStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public User getStarter() {
    return starter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public WorkflowRunningStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public WorkflowTriggerSource getTriggerSource() {
    return triggerSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((anchor != null) ? anchor.hashCode() : 0);
    result = (31 * result) + ((status != null) ? status.hashCode() : 0);
    result = (31 * result) + ((triggerSource != null) ? triggerSource.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  anchor  DOCUMENT ME!
   */
  public void setAnchor(Float anchor) {
    this.anchor = anchor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cancelBy  DOCUMENT ME!
   */
  public void setCancelBy(User cancelBy) {
    this.cancelBy = cancelBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  hotSpot  DOCUMENT ME!
   */
  public void setHotSpot(EnterpriseHotSpot hotSpot) {
    this.hotSpot = hotSpot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  starter  DOCUMENT ME!
   */
  public void setStarter(User starter) {
    this.starter = starter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  status  DOCUMENT ME!
   */
  public void setStatus(WorkflowRunningStatus status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  triggerSource  DOCUMENT ME!
   */
  public void setTriggerSource(WorkflowTriggerSource triggerSource) {
    this.triggerSource = triggerSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  protected abstract Set<Step> getCurrentStepSet();
} // end class BasicWorkflowInstance
