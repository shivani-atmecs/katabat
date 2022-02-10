package com.ozstrategy.credagility.core.domain.workflow.enterprise;

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
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/17/2014 12:28
 */
@Entity
@Table(
  name    = "EnterpriseWorkflowScheduleAudit",
  indexes = {
    @Index(
      name = "statusIndex",
      columnList = "scheduleStatus,preStatus"
    )
  }
)
public class EnterpriseWorkflowScheduleAudit extends BasicWorkflowSchedule implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2521946559985916462L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

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
   * Creates a new EnterpriseWorkflowScheduleAudit object.
   */
  public EnterpriseWorkflowScheduleAudit() { }

  /**
   * Creates a new EnterpriseWorkflowScheduleAudit object.
   *
   * @param  schedule  $param.type$
   */
  public EnterpriseWorkflowScheduleAudit(WorkflowSchedule schedule) {
    schedule.paste(this);
    this.createDate     = schedule.getCreateDate();
    this.creator        = schedule.getCreator();
    this.lastUpdateDate = schedule.getLastUpdateDate();
    this.lastUpdater    = schedule.getLastUpdater();
    this.scheduleId     = schedule.getId();
  }

  /**
   * Creates a new EnterpriseWorkflowScheduleAudit object.
   *
   * @param  schedule   $param.type$
   * @param  preStatus  $param.type$
   */
  public EnterpriseWorkflowScheduleAudit(WorkflowSchedule schedule, ScheduleStatus preStatus) {
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

    EnterpriseWorkflowScheduleAudit that = (EnterpriseWorkflowScheduleAudit) o;

    if (action != that.action) {
      return false;
    }

    if (preStatus != that.preStatus) {
      return false;
    }

    if ((scheduleId != null) ? (!scheduleId.equals(that.scheduleId)) : (that.scheduleId != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * AuditOperation.
   *
   * @return  AuditOperation.
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
   * Long.
   *
   * @return  Long.
   */
  @Override public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * ScheduleStatus.
   *
   * @return  ScheduleStatus.
   */
  public ScheduleStatus getPreStatus() {
    return preStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getScheduleId() {
    return scheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((action != null) ? action.hashCode() : 0);
    result = (31 * result) + ((preStatus != null) ? preStatus.hashCode() : 0);
    result = (31 * result) + ((scheduleId != null) ? scheduleId.hashCode() : 0);

    return result;
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
   * setAction.
   *
   * @param  action  $param.type$
   */
  public void setAction(AuditOperation action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setId.
   *
   * @param  id  $param.type$
   */
  @Override public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPreStatus.
   *
   * @param  preStatus  $param.type$
   */
  public void setPreStatus(ScheduleStatus preStatus) {
    this.preStatus = preStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setScheduleId.
   *
   * @param  scheduleId  $param.type$
   */
  public void setScheduleId(Long scheduleId) {
    this.scheduleId = scheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule#updateSchedule(com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule)
   */
  @Override public void updateSchedule(BasicWorkflowSchedule schedule) { }
} // end class EnterpriseWorkflowScheduleAudit
