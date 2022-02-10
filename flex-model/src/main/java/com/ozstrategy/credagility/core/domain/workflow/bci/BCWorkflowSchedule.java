package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.cmc.credagility.core.domain.type.ScheduleStatus;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 13-3-15 : PM3:50</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  name    = "BCWorkflowSchedule",
  indexes = {
    @Index(
      name = "statusIndex",
      columnList = "scheduleStatus"
    )
  }
)
public class BCWorkflowSchedule extends BasicWorkflowSchedule<BCWorkflowSchedule> implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6498869020747807990L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "businessContextId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContext businessContext;

  /** Schedule flows . */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "schedule",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  @OrderBy("priority asc")
  private Set<BCWorkflow> flows = new LinkedHashSet<BCWorkflow>();

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule#createSchedule()
   */
  @Override public BCWorkflowSchedule createSchedule() {
    return new BCWorkflowSchedule();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  copyFrom  DOCUMENT ME!
   * @param  user      DOCUMENT ME!
   */
  @Override public void deepCopy(BCWorkflowSchedule copyFrom, User user) {
    updateSchedule(copyFrom);

    for (BCWorkflow flow : copyFrom.getFlows()) {
      BCWorkflow newFlow = new BCWorkflow();
      newFlow.deepCopy(flow, user);
      newFlow.setAsGather(flow.getAsGather());

      if (user != null) {
        newFlow.setCreator(user);
        newFlow.setLastUpdater(user);
      } else {
        newFlow.setCreator(this.getLastUpdater());
        newFlow.setLastUpdater(this.getLastUpdater());
      }

      newFlow.setLastUpdateDate(new Date());
      newFlow.setSchedule(this);
      this.getFlows().add(newFlow);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BusinessContext getBusinessContext() {
    return businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule#getFlows()
   */
  @Override public Set<BCWorkflow> getFlows() {
    return flows;
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
   * @param   name  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflow getWorkflow(String name) {
    for (BCWorkflow workflow : flows) {
      if (workflow.getName().equals(name)) {
        return workflow;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule#paste()
   */
  @Override public BCWorkflowSchedule paste() {
    BCWorkflowSchedule schedule = new BCWorkflowSchedule();
    schedule.setCopyFromId(this.getId());
    schedule.setBusinessContext(this.getBusinessContext());

    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  businessContext  DOCUMENT ME!
   */
  public void setBusinessContext(BusinessContext businessContext) {
    this.businessContext = businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flows  DOCUMENT ME!
   */
  public void setFlows(Set<BCWorkflow> flows) {
    this.flows = flows;
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
   * @param  scheduleStatus  DOCUMENT ME!
   */
  @Override public void setScheduleStatus(ScheduleStatus scheduleStatus) {
    super.setScheduleStatus(scheduleStatus); // To change body of overridden methods use File | Settings | File Templates.
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update Schedule for bc.
   *
   * @param  schedule  BCWorkflowSchedule
   */
  @Override public void updateSchedule(BCWorkflowSchedule schedule) {
    update(schedule);
    this.setBusinessContext(schedule.getBusinessContext());
  }
} // end class BCWorkflowSchedule
