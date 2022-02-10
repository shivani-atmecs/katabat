package com.ozstrategy.credagility.core.domain.workflow.customer;

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
 * Created by tangwei on 17/3/20.
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  06/27/2017 16:57
 */
@Entity
@Table(name = "CustomerWorkflowScheduleAudit")
public class CustomerWorkflowScheduleAudit extends BasicWorkflowSchedule implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -4518974477320351909L;

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
  @Enumerated(EnumType.STRING)
  private ScheduleStatus preStatus;

  @Column(nullable = false)
  private Long scheduleId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new EnterpriseWorkflowScheduleAudit object.
   */
  public CustomerWorkflowScheduleAudit() { }

  /**
   * Creates a new EnterpriseWorkflowScheduleAudit object.
   *
   * @param  schedule  DOCUMENT ME!
   */
  public CustomerWorkflowScheduleAudit(CustomerWorkflowSchedule schedule) {
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
   * @param  schedule   DOCUMENT ME!
   * @param  preStatus  DOCUMENT ME!
   */
  public CustomerWorkflowScheduleAudit(CustomerWorkflowSchedule schedule, ScheduleStatus preStatus) {
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

    CustomerWorkflowScheduleAudit that = (CustomerWorkflowScheduleAudit) o;

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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule#hashCode()
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
   * DOCUMENT ME!
   *
   * @param  action  DOCUMENT ME!
   */
  public void setAction(AuditOperation action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
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
} // end class CustomerWorkflowScheduleAudit
