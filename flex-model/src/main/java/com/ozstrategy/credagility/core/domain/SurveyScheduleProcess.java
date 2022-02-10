package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.responsible.Responsible;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store schedule processing information.
 *
 * <p><a href="Process.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 16:59
 */
@Entity public class SurveyScheduleProcess extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** channel! */
  @Column(length = 32)
  protected String channel;

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** process EndTime. */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         processEndTime;

  /** Process Id: batchId/cidRunId .. */
  @Column(nullable = false)
  protected Long processId;

  /** process StartTime. */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         processStartTime;

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
  protected SurveySchedule schedule;

  /** process running status: InProcess/Fail/Success */
  @Column(length = 32)
  protected String status;

  @Column private Long accountCount = 0L;

  @Transient private Set<Long> processedAccountNums = new HashSet<Long>();

  @Transient private Set<Long> processedResponsibleIds = new HashSet<Long>();

  @Column private Long responsibleCount = 0L;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    SurveyScheduleProcess process = (SurveyScheduleProcess) o;

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
   * getter method for channel.
   *
   * @return  String
   */
  public String getChannel() {
    return channel;
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
   * @return  SurveySchedule
   */
  public SurveySchedule getSchedule() {
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
   * setter method for channel.
   *
   * @param  channel  String
   */
  public void setChannel(String channel) {
    this.channel = channel;
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
   * @param  schedule  SurveySchedule
   */
  public void setSchedule(SurveySchedule schedule) {
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
   * @param  schedule   SurveySchedule
   */
  public void startProcess(Long processId, SurveySchedule schedule) {
    if (processStartTime == null) {
      this.processId   = processId;
      this.schedule    = schedule;
      processStartTime = schedule.getProcessStartTime();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#toString()
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
   * @param  other  SurveyScheduleProcess
   */
  public void update(SurveyScheduleProcess other) {
    this.processStartTime = other.processStartTime;
    this.processEndTime   = other.processEndTime;
    this.runType          = other.runType;
    this.status           = other.status;
  }
} // end class SurveyScheduleProcess
