package com.cmc.credagiltiy.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.portfolio.Portfolio;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

//    @Query(value = "SELECT smb.scheduleId FROM StrategyMasterBatch smb inner join `Schedule` sch on smb.scheduleId = sch.id WHERE smb.status='SUCCESS' AND smb.strategyReportType='STRATEGY' group by smb.portfolioId ORDER BY smb.startDate DESC", nativeQuery = true)
//    List<Long> getActiveQueueScheduleIds();

//    @Query(value = "SELECT DISTINCT QA.id "
//    		+ "FROM QueueAction QA "
//    		+ "LEFT JOIN QueueOrderResult qor ON QA.id = qor.queueActionId "
//    		+ "INNER JOIN NodeQueueAction nqa ON QA.id = nqa.queueActionId "
//    		+ "INNER JOIN Node n ON n.id = nqa.nodeId INNER JOIN Strategy s ON s.id = n.strategyId "
//    		+ "INNER JOIN `Schedule` sch ON sch.id = 2 "
//    		+ "INNER JOIN Portfolio p ON QA.portfolioId = 42 "
//    		+ "WHERE QA.actionType = 'Queue' "
//    		+ "AND s.scheduleId = 2", nativeQuery = true)
//    List<Long> getActiveAgentTreeQueuesByPortfolioIds();
    
	@Query(value = "SELECT DISTINCT QA.id, QA.`name`, QA.fixedPath, p.portfolioId as portfolioId, p.`name` as portfolioName, p.currencySymbol, p.currencySymbolPosition, QA.actionType "
    		+ "FROM QueueAction QA "
    		+ "LEFT JOIN QueueOrderResult qor ON QA.id = qor.queueActionId "
    		+ "INNER JOIN NodeQueueAction nqa ON QA.id = nqa.queueActionId "
    		+ "INNER JOIN Node n ON n.id = nqa.nodeId INNER JOIN Strategy s ON s.id = n.strategyId "
    		+ "INNER JOIN `Schedule` sch ON sch.id = s.scheduleId "
    		+ "INNER JOIN Portfolio p ON QA.portfolioId = p.portfolioId "
    		+ "WHERE QA.actionType = 'Queue' "
    		+ "AND s.scheduleId in (:ids) "
    		+ "AND QA.portfolioId IN (:pids)", nativeQuery = true)
    List<Object[]> getActiveAgentTreeQueuesByPortfolioIds(@Param("ids") List<Long> scheduleIds, @Param("pids") String portfolioIds);
    
}
