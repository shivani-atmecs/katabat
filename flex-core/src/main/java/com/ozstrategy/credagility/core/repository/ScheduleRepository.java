package com.ozstrategy.credagility.core.repository;

import com.ozstrategy.credagility.core.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  11/03/2014 15:26
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

  @Query("select s from Schedule s where s.portfolio.portfolioId = ?1 and (s.scheduleStatus = 'ACTIVE' or s.scheduleStatus = 'SCHEDULED') and s.scheduleDate <= ?2 order by s.scheduleDate desc, s.createDate desc")
  List<Schedule> getRunningSchedule(Long portfolioId,Date scheduleDate);

  @Query("select distinct s from Schedule s where s.scheduleStatus = 'ACTIVE' and s.portfolio.portfolioId = ?1 and s.id <> ?2 and s.scheduleStatus <> 'DELETED'")
  List<Schedule> getActiveScheduleExceptThis(Long portfolioId,Long scheduleId);
}
