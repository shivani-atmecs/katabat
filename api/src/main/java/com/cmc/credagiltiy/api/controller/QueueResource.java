package com.cmc.credagiltiy.api.controller;

import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmc.credagility.core.domain.mra.PortfolioQueueNode;
import com.cmc.credagiltiy.api.repository.PortfolioRepository;
import com.cmc.credagiltiy.api.repository.StrategyMasterBatchRepository;

@RestController
@RequestMapping("/api/queue")
public class QueueResource {

	private final Logger logger = LoggerFactory.getLogger(PortfolioQueueManagerController.class);
	
	@Autowired
	private PortfolioRepository portfolioRepository;
	
	@Autowired
	private StrategyMasterBatchRepository strategyMasterBatchRepository;
	
	
	@GetMapping
	public List<Object[]> findAllByPortfolioId(@RequestParam("portfolioId") String portfolioId) {
		
		logger.info("portfolioId: {}", portfolioId);
	    List<PortfolioQueueNode> portfolioQueueNodes = null;
	    String                   portfolioIds        = portfolioId;
	    
	    
		List<Long> scheduleIds = strategyMasterBatchRepository.getActiveQueueScheduleIds();
		
		logger.info("scheduleIds: {}", scheduleIds);
		 
				 
		List<Object[]> allQueues = portfolioRepository.getActiveAgentTreeQueuesByPortfolioIds(scheduleIds, portfolioIds);

        
        logger.info("allQueues: {}", allQueues.size());
        
        
        
//	    portfolioQueueNodes = portfolioQueueManager.getActiveAgentTreeQueuesByPortfolios(portfolioIds);

        return allQueues;
	}
}
