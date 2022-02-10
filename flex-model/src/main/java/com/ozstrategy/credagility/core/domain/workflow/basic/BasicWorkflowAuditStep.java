package com.ozstrategy.credagility.core.domain.workflow.basic;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowAuditStepStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 13-6-17 : PM2:26</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public class BasicWorkflowAuditStep extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7407562447469097224L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The agent who execute this task. */
  @JoinColumn(
    name       = "auditorId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User auditor;

  /** if all elements audit finding in this step are not Not Assessed then true, else false. */
  @Column(
    name             = "finished",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean finished;

  /** <code>true</code> this workflow was update answer by remediation. */
  @Column(
    name             = "remediate",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean remediate;

  /** Workflow audit step remediation date. */
  @Temporal(TemporalType.TIMESTAMP)
  protected Date remediateDate;

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowAuditStepStatus
   */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowAuditStepStatus status = WorkflowAuditStepStatus.IN_PROCESS;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  auditStep  DOCUMENT ME!
   */
  public void copy(BasicWorkflowAuditStep auditStep) {
    this.setStatus(auditStep.getStatus());
    this.setFinished(auditStep.getFinished());
    this.setCreator(auditStep.getCreator());
    this.setCreateDate(auditStep.getCreateDate());
    this.setRemediate(auditStep.getRemediate());
    this.setRemediateDate(auditStep.getRemediateDate());
    this.setAuditor(auditStep.getAuditor());
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

    BasicWorkflowAuditStep that = (BasicWorkflowAuditStep) o;

    if ((auditor != null) ? (!auditor.equals(that.auditor)) : (that.auditor != null)) {
      return false;
    }

    if ((finished != null) ? (!finished.equals(that.finished)) : (that.finished != null)) {
      return false;
    }

    if ((remediate != null) ? (!remediate.equals(that.remediate)) : (that.remediate != null)) {
      return false;
    }

    if ((remediateDate != null) ? (!remediateDate.equals(that.remediateDate)) : (that.remediateDate != null)) {
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
  public User getAuditor() {
    return auditor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getFinished() {
    return finished;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getRemediate() {
    return remediate;
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
  public WorkflowAuditStepStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((auditor != null) ? auditor.hashCode() : 0);
    result = (31 * result) + ((status != null) ? status.hashCode() : 0);
    result = (31 * result) + ((finished != null) ? finished.hashCode() : 0);
    result = (31 * result) + ((remediate != null) ? remediate.hashCode() : 0);
    result = (31 * result) + ((remediateDate != null) ? remediateDate.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  auditor  DOCUMENT ME!
   */
  public void setAuditor(User auditor) {
    this.auditor = auditor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  finished  DOCUMENT ME!
   */
  public void setFinished(Boolean finished) {
    this.finished = finished;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  remediate  DOCUMENT ME!
   */
  public void setRemediate(Boolean remediate) {
    this.remediate = remediate;
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
   * @param  status  DOCUMENT ME!
   */
  public void setStatus(WorkflowAuditStepStatus status) {
    this.status = status;
  }
} // end class BasicWorkflowAuditStep
