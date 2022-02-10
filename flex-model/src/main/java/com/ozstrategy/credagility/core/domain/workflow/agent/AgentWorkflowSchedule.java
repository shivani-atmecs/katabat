package com.ozstrategy.credagility.core.domain.workflow.agent;

import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowSchedule;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/17/2014 09:45
 */
@DiscriminatorValue("Agent")
@Entity public class AgentWorkflowSchedule extends WorkflowSchedule {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowSchedule#createSchedule()
   */
  @Override public WorkflowSchedule createSchedule() {
    return new AgentWorkflowSchedule();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowSchedule#paste()
   */
  @Override public WorkflowSchedule paste() {
    AgentWorkflowSchedule schedule = new AgentWorkflowSchedule();
    schedule.setCopyFromId(this.getId());
    schedule.setCategory(this.getCategory());
    paste(schedule);

    return schedule;
  }
} // end class AgentWorkflowSchedule
