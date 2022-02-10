package com.ozstrategy.credagility.core.repository;

import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.BCDefaultQueueSortCriteria;
import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.BCSchedule;

import java.sql.SQLException;
import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 15:52
 */
public interface BCScheduleRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for active schedules.
   *
   * @param   businessContextId  Long
   *
   * @return  List
   */
  List<BCSchedule> getActiveSchedules(Long businessContextId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * populateQueueOrderResultInBusinessContext.
   *
   * @param   context  String
   *
   * @throws  java.sql.SQLException  exception
   */
  void populateQueueOrderResultInBusinessContext(String context) throws SQLException;

  //~ ------------------------------------------------------------------------------------------------------------------
  
  /**
   * DOCUMENT ME!
   *
   * @param   context  DOCUMENT ME!
   *
   * @throws  java.sql.SQLException  DOCUMENT ME!
   */
  void populateQueueOrderResultInBusinessContextWithNewSession(String context) throws SQLException;

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * queryQueueSortCriteria.
   *
   * @param   businessContext  String
   *
   * @return  List
   */
  List<BCDefaultQueueSortCriteria> queryQueueSortCriteria(String businessContext);

} // end interface BCScheduleRepository
