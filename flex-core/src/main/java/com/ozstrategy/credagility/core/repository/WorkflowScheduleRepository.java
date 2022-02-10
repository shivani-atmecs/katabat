package com.ozstrategy.credagility.core.repository;

import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowSchedule;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  11/03/2014 15:15
 */
public interface WorkflowScheduleRepository extends JpaRepository<WorkflowSchedule, Long> { }
