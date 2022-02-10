package com.ozstrategy.credagility.core.repository;

import com.ozstrategy.credagility.core.domain.SurveyFlowInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


/**
 * Created by wangy on 11/21/14.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/21/2014 16:00 PM
 */
public interface SurveyFlowInstanceRepository extends JpaRepository<SurveyFlowInstance, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for current account flow instance.
   *
   * @param   accountNum  Long
   * @param   id          Long
   *
   * @return  SurveyFlowInstance
   */
  @Query(
    "select distinct instance from SurveyFlowInstance instance where instance.status = 'IN_PROCESS' and instance.account.accountNum = :acct and instance.flow.id = :flowId order by instance.lastUpdateDate DESC"
  )
  List<SurveyFlowInstance> getCurrentAccountFlowInstance(@Param("acct") Long accountNum,
                                                         @Param("flowId") Long id);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for too frequency.
   *
   * @param   flowId      Long
   * @param   accountNum  Long
   * @param   start       Date
   * @param   end         Date
   *
   * @return  Integer
   */
  @Query(
    "select count(distinct a.id) from SurveyFlowInstance a where a.status='FINISHED' and a.flow.id = :flowId and a.account.accountNum = :accountNum and  a.lastUpdateDate between :start and :end order by a.lastUpdateDate DESC"
  )
  Integer isTooFrequency(@Param("flowId") Long flowId,
    @Param("accountNum") Long accountNum,
    @Param("start") Date start,
    @Param("end") Date end);
} // end interface SurveyFlowInstanceRepository
