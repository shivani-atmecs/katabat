package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/17/2014 12:30
 */
@Entity public class EnterpriseWorkflowScheduleProcess extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(length = 32)
  protected String channel;

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         processEndTime;

  /** Process Id: batchId/cidRunId .. */
  @Column(nullable = false)
  protected Long processId;


  /** TODO: DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         processStartTime;

  /** action run type: CID/Strategy/All. */
  @Column(length = 32)
  protected String runType;

  /** Schedule. */
  @JoinColumn(
    name       = "scheduleId",
    insertable = true,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowSchedule schedule;

  /** process running status: InProcess/Fail/Success */
  @Column(length = 32)
  protected String status;

  @Column private Long processedObjCount = 0L;

  @Transient private Set<Long> processedObjIds = new HashSet<Long>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addResponsible.
   *
   * @param  id  $param.type$
   */
  public void addResponsible(Long id) {
    processedObjIds.add(id);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * endProcess.
   */
  public void endProcess() {
    status            = "SUCCESS";
    processEndTime    = new Date();
    processedObjCount = new Long(processedObjIds.size());
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

    EnterpriseWorkflowScheduleProcess process = (EnterpriseWorkflowScheduleProcess) o;

    if ((processId != null) ? (!processId.equals(process.processId)) : (process.processId != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getChannel() {
    return channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getProcessedObjCount() {
    return processedObjCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set.
   *
   * @return  Set.
   */
  public Set<Long> getProcessedObjIds() {
    return processedObjIds;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getProcessEndTime() {
    return processEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getProcessId() {
    return processId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getProcessStartTime() {
    return processStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getRunType() {
    return runType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * WorkflowSchedule.
   *
   * @return  WorkflowSchedule.
   */
  public WorkflowSchedule getSchedule() {
    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result)
      + ((processId != null) ? processId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Boolean.
   *
   * @return  boolean
   */
  public boolean isStart() {
    return (processStartTime != null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setChannel.
   *
   * @param  channel  $param.type$
   */
  public void setChannel(String channel) {
    this.channel = channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setId.
   *
   * @param  id  $param.type$
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setProcessedObjCount.
   *
   * @param  processedObjCount  $param.type$
   */
  public void setProcessedObjCount(Long processedObjCount) {
    this.processedObjCount = processedObjCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setProcessedObjIds.
   *
   * @param  processedObjIds  $param.type$
   */
  public void setProcessedObjIds(Set<Long> processedObjIds) {
    this.processedObjIds = processedObjIds;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setProcessEndTime.
   *
   * @param  processEndTime  $param.type$
   */
  public void setProcessEndTime(Date processEndTime) {
    this.processEndTime = processEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setProcessId.
   *
   * @param  processId  $param.type$
   */
  public void setProcessId(Long processId) {
    this.processId = processId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setProcessStartTime.
   *
   * @param  processStartTime  $param.type$
   */
  public void setProcessStartTime(Date processStartTime) {
    this.processStartTime = processStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setRunType.
   *
   * @param  runType  $param.type$
   */
  public void setRunType(String runType) {
    this.runType = runType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setSchedule.
   *
   * @param  schedule  $param.type$
   */
  public void setSchedule(WorkflowSchedule schedule) {
    this.schedule = schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setStatus.
   *
   * @param  status  $param.type$
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * startProcess.
   *
   * @param  processId  $param.type$
   * @param  schedule   $param.type$
   */
  public void startProcess(Long processId, WorkflowSchedule schedule) {
    if (processStartTime == null) {
      this.processId   = processId;
      this.schedule    = schedule;
      processStartTime = schedule.getProcessStartTime();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Process");
    sb.append("{channel='").append(channel).append('\'');
    sb.append(", id=").append(id);
    sb.append(", processEndTime=").append(processEndTime);
    sb.append(", processId=").append(processId);
    sb.append(", processStartTime=").append(processStartTime);
    sb.append(", runType='").append(runType).append('\'');
    sb.append(", status='").append(status).append('\'');
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  other  $param.type$
   */
  public void update(EnterpriseWorkflowScheduleProcess other) {
    this.processStartTime = other.processStartTime;
    this.processEndTime   = other.processEndTime;
    this.runType          = other.runType;
    this.status           = other.status;
  }
} // end class EnterpriseWorkflowScheduleProcess
