package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.cmc.credagility.core.domain.type.ScheduleStatus;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Created by tangwei on 17/3/6.
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  03/08/2017 14:43
 */
@Entity
@Table(name = "CustomerWorkflowSchedule")
public class CustomerWorkflowSchedule extends BasicWorkflowSchedule<CustomerWorkflowSchedule> implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 5789438573169693160L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Schedule flows . */
  @Cascade({ org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "schedule"
  )
  @OrderBy("priority asc")
  private Set<CustomerWorkflow> flows = new LinkedHashSet<CustomerWorkflow>();

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule#createSchedule()
   */
  @Override public CustomerWorkflowSchedule createSchedule() {
    return new CustomerWorkflowSchedule();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  copyFrom  DOCUMENT ME!
   * @param  user      DOCUMENT ME!
   */
  @Override public void deepCopy(CustomerWorkflowSchedule copyFrom, User user) {
    updateSchedule(copyFrom);

    for (CustomerWorkflow flow : copyFrom.getFlows()) {
      CustomerWorkflow newFlow = new CustomerWorkflow();
      newFlow.deepCopy(flow, user);

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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule#getFlows()
   */
  @Override public Set<CustomerWorkflow> getFlows() {
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
  public CustomerWorkflow getWorkflow(String name) {
    for (CustomerWorkflow workflow : flows) {
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
  @Override public CustomerWorkflowSchedule paste() {
    CustomerWorkflowSchedule schedule = new CustomerWorkflowSchedule();
    schedule.setCopyFromId(this.getId());

    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flows  DOCUMENT ME!
   */
  public void setFlows(Set<CustomerWorkflow> flows) {
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule#updateSchedule(CustomerWorkflowSchedule)
   */
  @Override public void updateSchedule(CustomerWorkflowSchedule schedule) {
    update(schedule);
  }
} // end class CustomerWorkflowSchedule
