package com.ozstrategy.credagility.core.repository;

import com.cmc.credagility.core.domain.businesscontext.BusinessContext;
import com.cmc.credagility.core.domain.type.ScheduleStatus;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCWorkflowAssignedHotSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Created by liuqian on 5/12/15.
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  05/12/2015 15:02
 */
public interface BCWorkflowAssignedHotSpotRepository extends JpaRepository<BCWorkflowAssignedHotSpot, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow by hot spot name.
   *
   * @param   hotSpotName     String
   * @param   scheduleStatus  ScheduleStatus
   * @param   flag            Boolean
   *
   * @return  List
   */
  @Query(
    value = "SELECT DISTINCT ass FROM BCWorkflowAssignedHotSpot ass LEFT JOIN ass.workflow w LEFT JOIN w.schedule s "
      + "WHERE  s.scheduleStatus =?2 "
      + "AND (w.asSubFlow is null or w.asSubFlow = ?3) AND ass.hotSpot.value =?1  ORDER BY w.priority asc"
  )
  List<BCWorkflowAssignedHotSpot> getWorkflowByHotSpotNameAndStatus(String hotSpotName,
    ScheduleStatus scheduleStatus, Boolean flag);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow by hot spot name and status.
   *
   * @param   hotSpotName     String
   * @param   context         BusinessContext
   * @param   scheduleStatus  ScheduleStatus
   * @param   flag            Boolean
   *
   * @return  List
   */
  @Query(
    value = "SELECT DISTINCT ass FROM BCWorkflowAssignedHotSpot ass LEFT JOIN ass.workflow w LEFT JOIN w.schedule s "
      + "WHERE  s.scheduleStatus =?3 and s.businessContext = ?2 "
      + "AND (w.asSubFlow is null or w.asSubFlow = ?4) AND ass.hotSpot.value =?1  ORDER BY w.priority asc"
  )
  List<BCWorkflowAssignedHotSpot> getWorkflowByHotSpotNameAndStatusAndContext(String hotSpotName, BusinessContext context,
    ScheduleStatus scheduleStatus, Boolean flag);
} // end interface BCWorkflowAssignedHotSpotRepository
