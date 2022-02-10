package com.ozstrategy.credagility.core.repository;

import com.cmc.credagility.core.domain.portfolio.PortfolioSurveyAnswerOptionVersion;
import com.ozstrategy.credagility.core.domain.SurveyFlowAuditStep;
import com.ozstrategy.credagility.core.domain.SurveyFlowStep;
import com.ozstrategy.credagility.core.domain.SurveyflowStepTaskElementSnapshot;
import com.ozstrategy.credagility.core.domain.SurveyflowStepTaskSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Data repository for SurveyFlowStep.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/21/2014 15:51 PM
 */
public interface SurveyFlowStepRepository extends JpaRepository<SurveyFlowStep, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findFirstBySurveyFlowAuditStep.
   *
   * @param   workflowInstanceId  Long
   * @param   workflowStepId      Long
   * @param   responsibleId       Long
   *
   * @return  SurveyFlowAuditStep
   */
  @Query(
    "SELECT astep FROM SurveyFlowAuditStep astep WHERE astep.node.id IN "
    + "(SELECT step.node.id FROM SurveyFlowStep step WHERE step.id=:stepId AND step.surveyFlowInstance.id=:instanceId ) "
    + "AND astep.surveyFlowInstance.id=:instanceId ORDER BY astep.lastUpdateDate DESC"
  )
  SurveyFlowAuditStep findFirstBySurveyFlowAuditStep(@Param("instanceId") Long workflowInstanceId,
    @Param("stepId") Long workflowStepId,
    @Param("instanceId") Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findFirstBySurveyflowStepTaskElementSnapshot.
   *
   * @param   workflowInstanceId  Long
   * @param   taskVersionId       Long
   * @param   taskElementId       Long
   * @param   nodeId              Long
   *
   * @return  SurveyflowStepTaskElementSnapshot
   */
  @Query(
    "from SurveyflowStepTaskElementSnapshot snap WHERE snap.surveyFlowStep.surveyFlowInstance.id = ?1  AND snap.portfolioSurveyVersion.id=?2 AND snap.portfolioQuestion.id = ?3 AND snap.surveyFlowStep.node.id= ?4 AND snap.surveyFlowStep.status='FINISHED' ORDER BY snap.id DESC"
  )
  SurveyflowStepTaskElementSnapshot findFirstBySurveyflowStepTaskElementSnapshot(Long workflowInstanceId,
    Long taskVersionId, Long taskElementId, Long nodeId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findFirstBySurveyflowTaskSnapshot.
   *
   * @param   workflowInstanceId  Long
   * @param   taskId              Long
   * @param   nodeId              Long
   *
   * @return  SurveyflowStepTaskSnapshot
   */
  @Query(
    "from SurveyflowStepTaskSnapshot snapShot where snapShot.portfolioSurvey.id = :taskId and snapShot.surveyFlowStep.surveyFlowInstance.id=:workflowInstanceId AND snapShot.surveyFlowStep.node.id=:nodeId AND snapShot.surveyFlowStep.status='FINISHED'"
  )
  SurveyflowStepTaskSnapshot findFirstBySurveyflowTaskSnapshot(@Param("workflowInstanceId") Long workflowInstanceId,
    @Param("taskId") Long taskId,
    @Param("nodeId") Long nodeId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first answer by flow step.
   *
   * @param   responsibleId  Long
   * @param   questionId     Long
   * @param   flowStepId     Long
   *
   * @return  String
   */
  @Query(
    "select answer.data from PortfolioSurveyAnswer answer where answer.flowStepId = :flowStepId and answer.responsible.responsibleId=:responsibleId and answer.question.id = :questionId order by answer.surveyDate desc"
  )
  String getFirstAnswerByFlowStep(@Param("responsibleId") Long responsibleId,
    @Param("questionId") Long questionId,
    @Param("flowStepId") Long flowStepId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio survey answer option versions.
   *
   * @param   questionVersionId  Long
   *
   * @return  List
   */
  @Query("from PortfolioSurveyAnswerOptionVersion p where p.questionVersion.id = ?1")
  List<PortfolioSurveyAnswerOptionVersion> getPortfolioSurveyAnswerOptionVersions(Long questionVersionId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey flow step.
   *
   * @param   surveyFlowStepId  Long
   *
   * @return  SurveyFlowStep
   */
  @Query("from SurveyFlowStep s where s.id = ?1")
  SurveyFlowStep getSurveyFlowStep(Long surveyFlowStepId);
} // end interface SurveyFlowStepRepository
