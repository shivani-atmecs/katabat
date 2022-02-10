package com.ozstrategy.credagility.core.repository;

import com.cmc.credagility.core.domain.portfolio.PortfolioSurveyGroupQuestionVersion;
import com.ozstrategy.credagility.core.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  11/03/2014 15:33
 */
@Repository public interface SurveyScheduleRepository extends JpaRepository<SurveySchedule, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * canAccessSurveyFlowByAgents.
   *
   * @param   flowId   Long
   * @param   agentId  Long
   *
   * @return  Long
   */
  @Query("select flow.id from SurveyFlow flow left join flow.assignAgents user where user.id = ?2 and flow.id = ?1")
  Long canAccessSurveyFlowByAgents(Long flowId, Long agentId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * canAccessSurveyFlowByRoles.
   *
   * @param   flowId   Long
   * @param   agentId  Long
   *
   * @return  Long
   */
  @Query(
    "select r1.id from User u left join u.roles r1, SurveyFlow flow left join flow.assignRoles r2 where r2=r1 and u.id = ?2 and flow.id = ?1"
  )
  Long canAccessSurveyFlowByRoles(Long flowId, Long agentId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * canAccessSurveyFlowNodeByAgents.
   *
   * @param   nodeId   Long
   * @param   agentId  Long
   *
   * @return  Long
   */
  @Query(
    "select count(distinct node.id) from SurveyFlowNode node left join node.assignAgents user where user.id =?2 and node.id =?1"
  )
  Long canAccessSurveyFlowNodeByAgents(Long nodeId, Long agentId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * canAccessSurveyFlowByRoles.
   *
   * @param   nodeId   Long
   * @param   agentId  Long
   *
   * @return  Long
   */
  @Query(
    "select count(distinct r1.id) from User u left join u.roles r1, SurveyFlowNode node left join node.assignRoles r2 where r2=r1 and u.id =?2 and node.id =?1 "
  )
  Long canAccessSurveyFlowNodeByRoles(Long nodeId, Long agentId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findSurveyflowStepTaskElementSnapshot.
   *
   * @param   stepId        Long
   * @param   eleVersionId  Long
   *
   * @return  SurveyflowStepTaskElementSnapshot
   */
  @Query(
    "from SurveyflowStepTaskElementSnapshot audit where audit.surveyFlowStep.id = ?1 and audit.portfolioQuestionVersion.id = ?2"
  )
  SurveyflowStepTaskElementSnapshot findSurveyflowStepTaskElementSnapshot(Long stepId, Long eleVersionId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for entry survey by hot spot name.
   *
   * @param   portfolioId  Long
   *
   * @return  List
   */
  @Query(
    "select distinct ass from SurveyFlowHotSpotsAssignment ass where ass.surveyFlow.schedule.portfolio.portfolioId=?1 and ass.surveyFlow.schedule.scheduleStatus = 'ACTIVE'  and (ass.surveyFlow.asSubFlow is null or ass.surveyFlow.asSubFlow = false) and  (ass.hotSpot.type is null or ass.hotSpot.type != 'menu' ) order by ass.surveyFlow.priority asc"
  )
  List<SurveyFlowHotSpotsAssignment> getEntrySurveyByHotSpotName(Long portfolioId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for entry survey by hot spot name.

   * @param   portfolioId  Long
   * @param   hotSpotName  String
   *
   * @return  List
   */
  @Query(
    "select distinct ass from SurveyFlowHotSpotsAssignment ass where ass.surveyFlow.schedule.portfolio.portfolioId=?1 and ass.surveyFlow.schedule.scheduleStatus = 'ACTIVE'  and (ass.surveyFlow.asSubFlow is null or ass.surveyFlow.asSubFlow =false)  and ass.hotSpot.value=?2 and (ass.hotSpot.type is null or ass.hotSpot.type != 'menu' ) order by ass.surveyFlow.priority asc"
  )
  List<SurveyFlowHotSpotsAssignment> getEntrySurveyByHotSpotName(Long portfolioId, String hotSpotName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for higher priority entry survey by hot spot name.
   *
   * @param   portfolioId   Long
   * @param   hotSpotValue  String
   * @param   flowId        Long
   *
   * @return  List
   */
  @Query(
    "select distinct ass from SurveyFlowHotSpotsAssignment ass, SurveyFlow flow where ass.surveyFlow.schedule.portfolio.portfolioId = ?1 and ass.surveyFlow.schedule.scheduleStatus = 'ACTIVE'  and (ass.surveyFlow.asSubFlow is null or ass.surveyFlow.asSubFlow =false) and ass.surveyFlow <> flow and ass.surveyFlow.priority >= flow.priority and flow.id=?3 and ass.hotSpot.value = ?2 and (ass.hotSpot.type is null or ass.hotSpot.type != 'menu') order by ass.surveyFlow.priority asc "
  )
  List<SurveyFlowHotSpotsAssignment> getHigherPriorityEntrySurveyByHotSpotName(Long portfolioId,
    String hotSpotValue, Long flowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for lower priority entry survey by hot spot name.
   *
   * @param   portfolioId   Long
   * @param   hotSpotValue  String
   * @param   flowId        Long
   *
   * @return  List
   */
  @Query(
    "select distinct ass from SurveyFlowHotSpotsAssignment ass, SurveyFlow flow where ass.surveyFlow.schedule.portfolio.portfolioId = ?1 and ass.surveyFlow.schedule.scheduleStatus = 'ACTIVE'  and (ass.surveyFlow.asSubFlow is null or ass.surveyFlow.asSubFlow =false) and ass.surveyFlow <> flow and ass.surveyFlow.priority <= flow.priority and flow.id=?3 and ass.hotSpot.value = ?2 and (ass.hotSpot.type is null or ass.hotSpot.type != 'menu') order by ass.surveyFlow.priority asc "
  )
  List<SurveyFlowHotSpotsAssignment> getLowerPriorityEntrySurveyByHotSpotName(Long portfolioId,
    String hotSpotValue, Long flowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey flow root node.
   *
   * @param   surveyFlowId  Long
   *
   * @return  List
   */
  @Query("select distinct node from SurveyFlowNode node where node.surveyFlow.id=?1 and node.root = true")
  List<SurveyFlowNode> getSurveyFlowRootNode(Long surveyFlowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey questions.
   *
   * @param   taskVersionId  Long
   *
   * @return  List
   */
  @Query("select distinct v from PortfolioSurveyGroupQuestionVersion v where v.survey.id=?1")
  List<PortfolioSurveyGroupQuestionVersion> getSurveyQuestions(Long taskVersionId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow menu.
   *
   * @param   portfolioId  Long
   *
   * @return  WorkflowMenu
   */
  @Query(
    "select distinct wm from WorkflowMenu wm where wm.portfolio.portfolioId=?2 and wm.schedule.scheduleStatus = 'ACTIVE' and wm.hotSpot.type = 'menu' and wm.hotSpot.value = ?1 "
  )
  WorkflowMenu getWorkflowMenu(String tag, Long portfolioId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for too frequency.
   *
   * @param   flowId      Long
   * @param   accountNum  Long
   * @param   start       Date
   * @param   end         Date
   *
   * @return  Long
   */
  @Query(
    "select count(distinct a.id) from SurveyFlowInstance a where a.status='FINISHED' and a.flow.id =?1 and a.account.accountNum =?2 and a.lastUpdateDate between ?3 and ?4 order by a.lastUpdateDate DESC"
  )
  Long isTooFrequency(Long flowId, Long accountNum, Date start, Date end);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listAllAnswersByInstance.
   *
   * @param   flowInstanceId  Long
   *
   * @return  List
   */
  @Query(
    "SELECT distinct ans.answerId, ques.questionText, CASE WHEN((ques.answerType = 'Radio' OR ques.answerType = 'DropDown') AND ques.businessDataType != 'Document Status' AND ans.data != '' )THEN opt.name ELSE ans.data END AS answer, step.depthNamePath, step.id, ques.businessDataType, ques.id, ques.allowEncrypt, ques.answerType "
    + "FROM SurveyFlowInstance ins LEFT JOIN ins.steps step LEFT JOIN step.taskSnapshot taskSnap LEFT JOIN step.elementSnapshots eleSnap LEFT JOIN taskSnap.portfolioSurveyVersion task "
    + "LEFT JOIN task.groups g LEFT JOIN g.groupQuestions el  LEFT JOIN eleSnap.portfolioQuestionVersion ques LEFT JOIN ques.answerOptions opt, PortfolioSurveyAnswer ans WHERE ins.id=?1 AND step.status='FINISHED' AND ans.question.id = eleSnap.portfolioQuestion.id AND ans.flowStep.id = step.id "
    + "AND((ans.data = CASE WHEN(( ques.answerType = 'Radio' OR ques.answerType = 'DropDown' ) AND ques.businessDataType != 'Document Status' AND ans.data != '' ) THEN opt.value ELSE ans.data END ) OR( ques.answerType != 'Radio' AND ques.answerType != 'DropDown' )) ORDER BY step.stepNumber ASC, step.exitDate ASC, g.displayOrder ASC, el.displayOrder ASC "
  )
  List<Object[]> listAllAnswersByInstance(Long flowInstanceId);
} // end interface SurveyScheduleRepository
