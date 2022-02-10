package com.ozstrategy.credagility.core.domain.workflow.agency;

import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowSchedule;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/17/2014 11:32
 */
@DiscriminatorValue("Agency")
@Entity public class AgencyWorkflowSchedule extends WorkflowSchedule {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowSchedule#createSchedule()
   */
  @Override public WorkflowSchedule createSchedule() {
    return new AgencyWorkflowSchedule();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowSchedule#paste()
   */
  @Override public WorkflowSchedule paste() {
    AgencyWorkflowSchedule schedule = new AgencyWorkflowSchedule();
    schedule.setCopyFromId(this.getId());
    schedule.setCategory(this.getCategory());
    paste(schedule);

    return schedule;
  }
} // end class AgencyWorkflowSchedule
