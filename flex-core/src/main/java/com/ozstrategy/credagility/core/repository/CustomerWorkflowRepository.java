package com.ozstrategy.credagility.core.repository;

import com.ozstrategy.credagility.core.domain.workflow.customer.CustomerEventMapSurveyFlow;
import com.ozstrategy.credagility.core.domain.workflow.customer.CustomerWorkflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Created by tangwei on 17/7/4.
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  07/04/2017 15:18
 */
public interface CustomerWorkflowRepository extends JpaRepository<CustomerWorkflow, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer event map survey flow.
   *
   * @param   surveyFlowInstanceId  Long
   *
   * @return  List
   */
  @Query(
    "select distinct flow FROM CustomerEventMapSurveyFlow flow where flow.surveyFlowInstance.id = :surveyFlowInstanceId and (flow.isFinished is null or flow.isFinished = 'N')"
  )
  List<CustomerEventMapSurveyFlow> getCustomerEventMapSurveyFlow(
    @Param("surveyFlowInstanceId") Long surveyFlowInstanceId);

}
