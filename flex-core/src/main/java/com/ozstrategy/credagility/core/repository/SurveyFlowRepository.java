package com.ozstrategy.credagility.core.repository;

import com.ozstrategy.credagility.core.domain.*;
import com.ozstrategy.credagility.core.domain.workflow.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Data repository for SurveyFlow.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  11/21/2014 15:51 PM
 */
public interface SurveyFlowRepository extends JpaRepository<SurveyFlow, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * canAccessSurveyFlowRole.
   *
   * @param   flowId      Long
   * @param   executorId  Long
   *
   * @return  boolean
   */
  @Query(
    "select distinct flow.id from SurveyFlow flow left join flow.assignAgents user where user.id = :executorId and flow.id = :flowId"
  )
  List canAccessSurveyFlowRole(@Param("flowId") Long flowId,
    @Param("executorId") Long executorId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * canAccessSurveyFlowUser.
   *
   * @param   flowId      Long
   * @param   executorId  Long
   *
   * @return  boolean
   */
  @Query(
    "select distinct r1.id from User u left join u.roles r1, SurveyFlow flow left join flow.assignRoles r2 where r2=r1 and u.id = :executorId and flow.id = :flowId"
  )
  List canAccessSurveyFlowUser(@Param("flowId") Long flowId,
    @Param("executorId") Long executorId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for retired in process workflow by persistence code.
   *
   * @param   persistenceCode  String
   * @param   accountNum       Long
   *
   * @return  List
   */
  @Query(
    "select distinct flow FROM SurveyFlow flow left join flow.schedule ss, SurveyFlowInstance ins where ins.flow.id = flow.id and ins.account.accountNum=:accountNum and ss.scheduleStatus = 'OLD' and ins.status='IN_PROCESS' and flow.persistenceCode =:persistenceCode order by ss.activeDate ASC, flow.priority "
  )
  List<SurveyFlow> getRetiredInProcessWorkflowByPersistenceCode(@Param("persistenceCode") final String persistenceCode,
    @Param("accountNum") Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey flow progress step by flow id.
   *
   * @param   flowId  Long
   *
   * @return  List
   */
  @Query(
    "select step from SurveyFlowProgressStep step where step.surveyFlow.id = :flowId  order by step.stepNumber asc "
  )
  List<SurveyFlowProgressStep> getSurveyFlowProgressStepByFlowId(@Param("flowId") Long flowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey flow root node.
   *
   * @param   flowId  Long
   *
   * @return  SurveyFlowNode
   */
  @Query("select distinct node from SurveyFlowNode node where node.surveyFlow.id=:flowId and node.root = true")
  SurveyFlowNode getSurveyFlowRootNode(@Param("flowId") Long flowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * find survey flows by event id.
   *
   * @param   evtId  Long
   *
   * @return  List
   */
  @Query(
    "select distinct flow FROM SurveyFlow flow, SurveyFlowEvent fEvent, Event evt where flow.schedule.scheduleStatus = 'Active' and flow.event.id = fEvent.id  and evt member of fEvent.events and evt.id = :evtId"
  )
  List<SurveyFlow> getSurveyFlowsByEventId(@Param("evtId") Long evtId);

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * listSurveyFlowEndNodeBureauImportActions.
   *
   * @param   flowId  Long
   *
   * @return  List
   */
  @Query("select distinct action from WorkflowBureauImportAction action where action.flow.id = ?1")
  List<WorkflowBureauImportAction> listSurveyFlowEndNodeBureauImportActions(Long flowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  @Query("select distinct action from WorkflowDataExportAction action where action.flow.id = ?1")
  List<WorkflowDataExportAction> listSurveyFlowEndNodeDataExportActions(Long flowId);


  /**
   * listSurveyFlowEndNodeChannelActions.
   *
   * @param   flowId  Long
   *
   * @return  List
   */
  @Query("select distinct action from SurveyFlowChannelAction action where action.flow.id = ?1")
  List<SurveyFlowChannelAction> listSurveyFlowEndNodeChannelActions(Long flowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listSurveyFlowEndNodeChargeOffActions.
   *
   * @param   flowId  Long
   *
   * @return  List
   */
  @Query("select distinct action from SurveyFlowChargeOffAction action where action.flow.id = ?1")
  List<SurveyFlowChargeOffAction> listSurveyFlowEndNodeChargeOffActions(Long flowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listSurveyFlowEndNodeFlowActions.
   *
   * @param   flowId  Long
   *
   * @return  List
   */
  @Query("select distinct action from SurveyFlowFlowAction action where action.flow.id = ?1")
  List<SurveyFlowFlowAction> listSurveyFlowEndNodeFlowActions(Long flowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listSurveyFlowEndNodeProgramActions.
   *
   * @param   flowId  Long
   *
   * @return  List
   */
  @Query("select distinct action from SurveyFlowProgramAction action where action.flow.id = ?1")
  List<SurveyFlowProgramAction> listSurveyFlowEndNodeProgramActions(Long flowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listSurveyFlowEndNodeRecallActions.
   *
   * @param   flowId  Long
   *
   * @return  List
   */
  @Query("select distinct action from SurveyFlowRecallAction action where action.flow.id = ?1")
  List<SurveyFlowRecallAction> listSurveyFlowEndNodeRecallActions(Long flowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listSurveyFlowEndNodeReQueueActions.
   *
   * @param   flowId  Long
   *
   * @return  List
   */
  @Query("select distinct action from SurveyFlowReQueueAction action where action.flow.id = ?1")
  List<SurveyFlowReQueueAction> listSurveyFlowEndNodeReQueueActions(Long flowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listSurveyFlowEndNodeStatusActions.
   *
   * @param   flowId  Long
   *
   * @return  List
   */
  @Query("select distinct action from SurveyFlowStatusAction action where action.flow.id = ?1")
  List<SurveyFlowStatusAction> listSurveyFlowEndNodeStatusActions(Long flowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listSurveyFlowEndNodeUpdateVariableActions.
   *
   * @param   flowId  Long
   *
   * @return  List
   */
  @Query("select distinct action from SurveyFlowUpdateVariableAction action where action.flow.id = ?1")
  List<SurveyFlowUpdateVariableAction> listSurveyFlowEndNodeUpdateVariableActions(Long flowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listSurveyFlowEndNodeVariableActions.
   *
   * @param   flowId  Long
   *
   * @return  List
   */
  @Query("select distinct action from SurveyFlowVariableAction action where action.flow.id = ?1")
  List<SurveyFlowVariableAction> listSurveyFlowEndNodeVariableActions(Long flowId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listSurveyFlowNodeBureauImportActions.
   *
   * @param   nodeId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  @Query(
    "select distinct action from WorkflowNodeBureauImportAction action where action.node.id = :nodeId and action.triggerType = :triggerType"
  )
  List<WorkflowNodeBureauImportAction> listSurveyFlowNodeBureauImportActions(@Param("nodeId") Long nodeId,
    @Param("triggerType") WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------


  @Query(
    "select distinct action from WorkflowNodeDataExportAction action where action.node.id = :nodeId and action.triggerType = :triggerType"
  )
  List<WorkflowNodeDataExportAction> listSurveyFlowNodeDataExportActions(@Param("nodeId") Long nodeId,
                                                                             @Param("triggerType") WorkflowNodeActionTriggerType triggerType);



  /**
   * listSurveyFlowNodeChannelActions.
   *
   * @param   nodeId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  @Query(
    "select distinct action from SurveyFlowNodeChannelAction action where action.node.id = :nodeId and action.triggerType = :triggerType"
  )
  List<SurveyFlowNodeChannelAction> listSurveyFlowNodeChannelActions(@Param("nodeId") Long nodeId,
    @Param("triggerType") WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listSurveyFlowNodeChargeOffActions.
   *
   * @param   nodeId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  @Query(
    "select distinct action from SurveyFlowNodeChargeOffAction action where action.node.id = :nodeId and action.triggerType = :triggerType"
  )
  List<SurveyFlowNodeChargeOffAction> listSurveyFlowNodeChargeOffActions(@Param("nodeId") Long nodeId,
    @Param("triggerType") WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listSurveyFlowNodeFlowActions.
   *
   * @param   nodeId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  @Query(
    "select distinct action from SurveyFlowNodeFlowAction action where action.node.id = :nodeId and action.triggerType = :triggerType"
  )
  List<SurveyFlowNodeFlowAction> listSurveyFlowNodeFlowActions(@Param("nodeId") Long nodeId,
    @Param("triggerType") WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listSurveyFlowNodeProgramActions.
   *
   * @param   nodeId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  @Query(
    "select distinct action from SurveyFlowNodeProgramAction action where action.node.id = :nodeId and action.triggerType = :triggerType"
  )
  List<SurveyFlowNodeProgramAction> listSurveyFlowNodeProgramActions(@Param("nodeId") Long nodeId,
    @Param("triggerType") WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listSurveyFlowNodeRecallActions.
   *
   * @param   nodeId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  @Query(
    "select distinct action from SurveyFlowNodeRecallAction action where action.node.id = :nodeId and action.triggerType = :triggerType"
  )
  List<SurveyFlowNodeRecallAction> listSurveyFlowNodeRecallActions(@Param("nodeId") Long nodeId,
    @Param("triggerType") WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listSurveyFlowNodeReQueueActions.
   *
   * @param   nodeId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  @Query(
    "select distinct action from SurveyFlowNodeReQueueAction action where action.node.id = :nodeId and action.triggerType = :triggerType"
  )
  List<SurveyFlowNodeReQueueAction> listSurveyFlowNodeReQueueActions(@Param("nodeId") Long nodeId,
    @Param("triggerType") WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listSurveyFlowNodeStatusActions.
   *
   * @param   nodeId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  @Query(
    "select distinct action from SurveyFlowNodeStatusAction action where action.node.id = :nodeId and action.triggerType = :triggerType"
  )
  List<SurveyFlowNodeStatusAction> listSurveyFlowNodeStatusActions(@Param("nodeId") Long nodeId,
    @Param("triggerType") WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listSurveyFlowNodeUpdateVariableActions.
   *
   * @param   nodeId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  @Query(
    "select distinct action from SurveyFlowNodeUpdateVariableAction action where action.node.id = :nodeId and action.triggerTime = :triggerType"
  )
  List<SurveyFlowNodeUpdateVariableAction> listSurveyFlowNodeUpdateVariableActions(@Param("nodeId") Long nodeId,
    @Param("triggerType") WorkflowNodeActionTriggerType triggerType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listSurveyFlowNodeVariableActions.
   *
   * @param   nodeId       Long
   * @param   triggerType  WorkflowNodeActionTriggerType
   *
   * @return  List
   */
  @Query(
    "select distinct action from SurveyFlowNodeVariableAction action where action.node.id = :nodeId and action.triggerTime = :triggerType"
  )
  List<SurveyFlowNodeVariableAction> listSurveyFlowNodeVariableActions(@Param("nodeId") Long nodeId,
    @Param("triggerType") WorkflowNodeActionTriggerType triggerType);
} // end interface SurveyFlowRepository
