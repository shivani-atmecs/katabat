package com.ozstrategy.credagility.core.domain.workflow.basic;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowAuditStatus;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowRunningStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 13-6-17 : PM2:25</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class BasicWorkflowAuditInstance<Step extends BasicWorkflowAuditStep>
  extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5428181188787008516L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowAuditStatus
   */
  @Column(
    length   = 32,
    nullable = true
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowAuditStatus auditStatus;

  /** The agent who cancel this flow. */
  @JoinColumn(name = "cancelBy")
  @ManyToOne(fetch = FetchType.LAZY)
  protected User cancelBy;


  /** <code>true</code> this workflow was update answer by remediation. */
  @Column(
    name             = "remediated",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean remediated;

  /** Workflow instance remediation date. */
  @Temporal(TemporalType.TIMESTAMP)
  protected Date remediateDate;

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

    BasicWorkflowAuditInstance that = (BasicWorkflowAuditInstance) o;

    if (auditStatus != that.auditStatus) {
      return false;
    }

    if ((remediateDate != null) ? (!remediateDate.equals(that.remediateDate)) : (that.remediateDate != null)) {
      return false;
    }

    if ((remediated != null) ? (!remediated.equals(that.remediated)) : (that.remediated != null)) {
      return false;
    }

    if (status != that.status) {
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
  public WorkflowAuditStatus getAuditStatus() {
    return auditStatus;
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
  public Boolean getRemediated() {
    return remediated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getRemediateDate() {
    return remediateDate;
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
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((auditStatus != null) ? auditStatus.hashCode() : 0);
    result = (31 * result) + ((remediated != null) ? remediated.hashCode() : 0);
    result = (31 * result) + ((remediateDate != null) ? remediateDate.hashCode() : 0);
    result = (31 * result) + ((status != null) ? status.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  auditStatus  DOCUMENT ME!
   */
  public void setAuditStatus(WorkflowAuditStatus auditStatus) {
    this.auditStatus = auditStatus;
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
   * @param  remediated  DOCUMENT ME!
   */
  public void setRemediated(Boolean remediated) {
    this.remediated = remediated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  remediateDate  DOCUMENT ME!
   */
  public void setRemediateDate(Date remediateDate) {
    this.remediateDate = remediateDate;
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
} // end class BasicWorkflowAuditInstance
