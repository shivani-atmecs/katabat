package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.cmc.credagility.core.domain.type.ScheduleStatus;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.AuditOperation;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflow;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 12:21
 */
@Entity
@Table(
  name    = "BCWorkflowScheduleAudit",
  indexes = {
    @Index(
      name = "statusIndex",
      columnList = "scheduleStatus,preStatus"
    )
  }
)
public class BCWorkflowScheduleAudit extends BasicWorkflowSchedule implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -2219987783216730861L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.AuditOperation
   */
  @Column(
    length   = 32,
    nullable = true
  )
  @Enumerated(value = EnumType.STRING)
  private AuditOperation action;

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;


  @Column(
    length   = 12,
    nullable = true
  )
  @Enumerated(value = EnumType.STRING)
  private ScheduleStatus preStatus;

  @Column(nullable = false)
  private Long scheduleId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BCWorkflowScheduleAudit object.
   */
  public BCWorkflowScheduleAudit() { }

  /**
   * Creates a new BCWorkflowScheduleAudit object.
   *
   * @param  schedule  DOCUMENT ME!
   */
  public BCWorkflowScheduleAudit(BCWorkflowSchedule schedule) {
    schedule.paste(this);
    this.createDate     = schedule.getCreateDate();
    this.creator        = schedule.getCreator();
    this.lastUpdateDate = schedule.getLastUpdateDate();
    this.lastUpdater    = schedule.getLastUpdater();
    this.scheduleId     = schedule.getId();
  }

  /**
   * Creates a new BCWorkflowScheduleAudit object.
   *
   * @param  schedule   DOCUMENT ME!
   * @param  preStatus  DOCUMENT ME!
   */
  public BCWorkflowScheduleAudit(BCWorkflowSchedule schedule, ScheduleStatus preStatus) {
    this(schedule);
    this.preStatus = preStatus;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule#createSchedule()
   */
  @Override public BasicWorkflowSchedule createSchedule() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule#deepCopy(com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule,
   *       com.cmc.credagility.core.domain.user.User)
   */
  @Override public void deepCopy(BasicWorkflowSchedule schedule, User user) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public AuditOperation getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule#getFlows()
   */
  @Override public Set<? extends BasicWorkflow> getFlows() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule#getId()
   */
  @Override public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ScheduleStatus getPreStatus() {
    return preStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getScheduleId() {
    return scheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule#paste()
   */
  @Override public BasicWorkflowSchedule paste() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  action  DOCUMENT ME!
   */
  public void setAction(AuditOperation action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule#setId(Long)
   */
  @Override public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  preStatus  DOCUMENT ME!
   */
  public void setPreStatus(ScheduleStatus preStatus) {
    this.preStatus = preStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  scheduleId  DOCUMENT ME!
   */
  public void setScheduleId(Long scheduleId) {
    this.scheduleId = scheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule#updateSchedule(com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule)
   */
  @Override public void updateSchedule(BasicWorkflowSchedule schedule) { }
} // end class BCWorkflowScheduleAudit
