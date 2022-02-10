package com.cmc.credagility.core.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cmc.credagility.core.domain.event.EventInstance;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/23/2014 14:30
 */
public interface EventInstanceRepository extends JpaRepository<EventInstance, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * TODO: DOCUMENT ME!
   *
   * @param   portfolioId  Long
   * @param   date         Date
   *
   * @return  List
   */
  @Query(
    value =
      "select e from EventInstance e where e.event.portfolio.portfolioId = :portfolioId and ((e.status = 'FAILED') or (e.status in ('INIT', 'INPROCESS', 'RETRY') and e.createDate < :date))"
  )
  List<EventInstance> getFailedOrUnprocessedEventInstanceEarlierThan(@Param("portfolioId") Long portfolioId,
    @Param("date") Date date);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * get unprocessed event instance.
   *
   * @param   portfolios  String
   *
   * @return  List
   */
  @Query(
    value =
      "select e from EventInstance e where e.status in ('INIT', 'RETRY') and e.event.portfolio.portfolioId in (:portfolios)"
  )
  List<EventInstance> getUnprocessedEventInstance(@Param("portfolios") String portfolios);


  @Query(value =
      "select e from EventInstance e  where e.eventInstanceId=?1")
  EventInstance findFirstByEventInstanceId(Long eventInstanceId);

} // end interface EventInstanceRepository
