package com.ozstrategy.credagility.core.domain.workflow.ent;

import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowSchedule;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * Enterprise Workflow Schedule.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 10:02
 */
@DiscriminatorValue("Enterprise")
@Entity public class EnterpriseWorkflowSchedule extends WorkflowSchedule {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new EnterpriseWorkflowSchedule object.
   */
  public EnterpriseWorkflowSchedule() { }


  /**
   * Creates a new EnterpriseWorkflowSchedule object.
   *
   * @param  workflowSchedule  WorkflowSchedule
   */
  public EnterpriseWorkflowSchedule(WorkflowSchedule workflowSchedule) {
    super(workflowSchedule);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowSchedule#createSchedule()
   */
  @Override public WorkflowSchedule createSchedule() {
    return new EnterpriseWorkflowSchedule();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowSchedule#paste()
   */
  @Override public WorkflowSchedule paste() {
    EnterpriseWorkflowSchedule schedule = new EnterpriseWorkflowSchedule();
    schedule.setCopyFromId(this.getId());
    schedule.setCategory(this.getCategory());
    paste(schedule);

    return schedule;
  }
} // end class EnterpriseWorkflowSchedule
