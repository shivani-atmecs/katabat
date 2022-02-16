package com.cmc.credagiltiy.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ozstrategy.credagility.core.domain.QueueAction;

@Repository
public interface PortfolioQueueRepository extends JpaRepository<QueueAction, Long> {

	@Query(value = "SELECT DISTINCT QA.id, QA.`name`, QA.fixedPath, p.portfolioId as portfolioId, p.`name` as portfolioName, p.currencySymbol, p.currencySymbolPosition, QA.actionType "
			+ "FROM QueueAction QA " + "LEFT JOIN QueueOrderResult qor ON QA.id = qor.queueActionId "
			+ "INNER JOIN NodeQueueAction nqa ON QA.id = nqa.queueActionId "
			+ "INNER JOIN Node n ON n.id = nqa.nodeId INNER JOIN Strategy s ON s.id = n.strategyId "
			+ "INNER JOIN `Schedule` sch ON sch.id = s.scheduleId "
			+ "INNER JOIN Portfolio p ON QA.portfolioId = p.portfolioId " + "WHERE QA.actionType = 'Queue' "
			+ "AND s.scheduleId in (:ids) " + "AND QA.portfolioId IN (:pids)", nativeQuery = true)
	List<Object[]> getActiveAgentTreeQueuesByPortfolioIds(@Param("ids") List<Long> scheduleIds,
			@Param("pids") Long portfolioIds);

	@Query(value = "SELECT q.id, q.name, q.fixedPath, p.portfolioId as portfolioId, p.name as portfolioName, p.currencySymbol, p.currencySymbolPosition, q.actionType "
			+ "FROM QueueAction q " + "JOIN Portfolio p ON q.portfolioId=p.portfolioId "
			+ "WHERE q.actionType='AgentAssignment' "
			+ "AND p.portfolioId IN (:pids) GROUP by q.id;", nativeQuery = true)
	List<Object[]> getAllAgentAccountAssignmentQueues(@Param("pids") Long portfolioIds);

}