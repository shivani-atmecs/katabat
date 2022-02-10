package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.responsible.Responsible;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store schedule processing information.
 *
 * <p><a href="Process.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/16/2014 14:56
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "processEndTimeIndex",
      columnList = "processEndTime"
    ),
    @Index(
      name = "deltaBatchIndex",
      columnList = "deltaBatch"
    ),
    @Index(
      name = "processStartTimeIndex",
      columnList = "processStartTime"
    ),
    @Index(
      name = "statusIndex",
      columnList = "status"
    )
  }
)
public class ScheduleProcess extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** process request channel: BCC/AW/DEBITSITE */
  @Column(length = 32)
  protected String channel;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean deltaBatch = Boolean.FALSE;

  /** primary key: Process Id: batchId/cidRunId .. */
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

  /** The portfolio which schedule belong to. */
  @JoinColumn(
    name       = "queueScheduleId",
    insertable = true,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Schedule queueSchedule;

  /** action run type: CID/Strategy/All. */
  @Column(length = 32)
  protected String runType;


  /** The portfolio which schedule belong to. */
  @JoinColumn(
    name       = "scheduleId",
    insertable = true,
    updatable  = false,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Schedule schedule;

  /** process running status: InProcess/Fail/Success */
  @Column(length = 32)
  protected String status;

  @Column private Long accountCount = 0L;

  /** Node actions. */
  @Transient private Set<ProcessActionResult> batchResults = new LinkedHashSet<ProcessActionResult>();

  /** Node actions. */
  @Transient private Set<ProcessActionCIDResult> cidResults = new LinkedHashSet<ProcessActionCIDResult>();

  @Transient private Set<Long> processedAccountNums = new HashSet<Long>();

  @Transient private Set<Long> processedResponsibleIds = new HashSet<Long>();

  @Column private Long responsibleCount = 0L;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addBatchResult.
   *
   * @param  result  ProcessActionResult
   */
  public void addBatchResult(ProcessActionResult result) {
    result.setProcess(this);
    this.batchResults.add(result);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addResponsible.
   *
   * @param  responsible  Responsible
   */
  public void addResponsible(Responsible responsible) {
    processedResponsibleIds.add(responsible.getResponsibleId());
    processedAccountNums.add(responsible.getAccount().getAccountNum());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * endProcess.
   */
  public void endProcess() {
    status           = "SUCCESS";
    processEndTime   = new Date();
    responsibleCount = new Long(processedResponsibleIds.size());
    accountCount     = new Long(processedAccountNums.size());
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

    ScheduleProcess process = (ScheduleProcess) o;

    if ((processId != null) ? (!processId.equals(process.processId)) : (process.processId != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account count.
   *
   * @return  Long
   */
  public Long getAccountCount() {
    return accountCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for batch results.
   *
   * @return  Set
   */
  public Set<ProcessActionResult> getBatchResults() {
    return batchResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel.
   *
   * @return  String
   */
  public String getChannel() {
    return channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cid results.
   *
   * @return  Set
   */
  public Set<ProcessActionCIDResult> getCidResults() {
    return cidResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delta batch.
   *
   * @return  Boolean
   */
  public Boolean getDeltaBatch() {
    return deltaBatch;
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
   * getter method for process end time.
   *
   * @return  Date
   */
  public Date getProcessEndTime() {
    return processEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for process id.
   *
   * @return  Long
   */
  public Long getProcessId() {
    return processId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for process start time.
   *
   * @return  Date
   */
  public Date getProcessStartTime() {
    return processStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue schedule.
   *
   * @return  Schedule
   */
  public Schedule getQueueSchedule() {
    return queueSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible count.
   *
   * @return  Long
   */
  public Long getResponsibleCount() {
    return responsibleCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for run type.
   *
   * @return  String
   */
  public String getRunType() {
    return runType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule.
   *
   * @return  Schedule
   */
  public Schedule getSchedule() {
    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  String
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
   * getter method for start.
   *
   * @return  boolean
   */
  public boolean isStart() {
    return (processStartTime != null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account count.
   *
   * @param  accountCount  Long
   */
  public void setAccountCount(Long accountCount) {
    this.accountCount = accountCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for batch results.
   *
   * @param  batchResults  Set
   */
  public void setBatchResults(Set<ProcessActionResult> batchResults) {
    this.batchResults = batchResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel.
   *
   * @param  channel  String
   */
  public void setChannel(String channel) {
    this.channel = channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cid results.
   *
   * @param  cidResults  Set
   */
  public void setCidResults(Set<ProcessActionCIDResult> cidResults) {
    this.cidResults = cidResults;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delta batch.
   *
   * @param  deltaBatch  Boolean
   */
  public void setDeltaBatch(Boolean deltaBatch) {
    this.deltaBatch = deltaBatch;
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
   * setter method for process end time.
   *
   * @param  processEndTime  Date
   */
  public void setProcessEndTime(Date processEndTime) {
    this.processEndTime = processEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for process id.
   *
   * @param  processId  Long
   */
  public void setProcessId(Long processId) {
    this.processId = processId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for process start time.
   *
   * @param  processStartTime  Date
   */
  public void setProcessStartTime(Date processStartTime) {
    this.processStartTime = processStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue schedule.
   *
   * @param  queueSchedule  Schedule
   */
  public void setQueueSchedule(Schedule queueSchedule) {
    this.queueSchedule = queueSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible count.
   *
   * @param  responsibleCount  Long
   */
  public void setResponsibleCount(Long responsibleCount) {
    this.responsibleCount = responsibleCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for run type.
   *
   * @param  runType  String
   */
  public void setRunType(String runType) {
    this.runType = runType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule.
   *
   * @param  schedule  Schedule
   */
  public void setSchedule(Schedule schedule) {
    this.schedule = schedule;
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
   * startProcess.
   *
   * @param  processId  Long
   * @param  schedule   Schedule
   */
  public void startProcess(Long processId, Schedule schedule) {
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
   * @param  other  ScheduleProcess
   */
  public void update(ScheduleProcess other) {
    this.processStartTime = other.processStartTime;
    this.processEndTime   = other.processEndTime;
    this.runType          = other.runType;
    this.status           = other.status;
  }
} // end class ScheduleProcess
