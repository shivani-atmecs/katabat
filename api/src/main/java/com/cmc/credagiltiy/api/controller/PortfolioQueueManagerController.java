package com.cmc.credagiltiy.api.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagiltiy.api.repository.PortfolioRepository;
import com.cmc.credagiltiy.api.repository.StrategyMasterBatchRepository;
import com.ozstrategy.credagility.core.domain.QueueAction;

@RestController
@RequestMapping("/api")
public class PortfolioQueueManagerController<PortfolioQueueNode> {
	
	private final Logger logger = LoggerFactory.getLogger(PortfolioQueueManagerController.class);
	
	@Autowired
	private PortfolioRepository portfolioRepository;
	
	@Autowired
	private StrategyMasterBatchRepository strategyMasterBatchRepository;
	
//	@Autowired
//	private UserManager userManager = null;

	
	@GetMapping("/portfolio")
	public List<Object[]> index() {
		
//	    String                   userName            = request.getRemoteUser();
//		User                     agent               = userManager.getUserByUsername(userName);
//	    List<PortfolioQueueNode> portfolioQueueNodes = null;
//	    String                   portfolioIds        = null;
	    
//	    portfolioIds = agent.getRoleManagedPortfolioMap().keySet().toString();
//	    portfolioIds = portfolioIds.substring(1, portfolioIds.length() - 1);
//
//	    if (portfolioIds.length() == 0) {
//	      portfolioIds = null;
//	    }
	    
	    List<PortfolioQueueNode> portfolioQueueNodes = null;
	    String                   portfolioIds        = "42";
	    
	    
		List<Long> scheduleIds = strategyMasterBatchRepository.getActiveQueueScheduleIds();
		
		logger.info("scheduleIds: {}", scheduleIds);
		 
		
//		 Map<PortfolioQueueNode, List<QueueAction>> allQueues = portfolioRepository.getActiveAgentTreeQueuesByPortfolioIds(
//			        longIds, portfolioIds);
		 
		List<Object[]> allQueues = portfolioRepository.getActiveAgentTreeQueuesByPortfolioIds(scheduleIds, portfolioIds);

        
        logger.info("allQueues: {}", allQueues.size());
        
        
        
//	    portfolioQueueNodes = portfolioQueueManager.getActiveAgentTreeQueuesByPortfolios(portfolioIds);

        return allQueues;
    } 
	
	
	
//	private Map<PortfolioQueueNode, List<QueueAction>> buildPortfolioQueueNodeMap(List queueActions) {
//	    Long                                       start             = System.currentTimeMillis();
//	    Map<PortfolioQueueNode, List<QueueAction>> portfolioQueueMap =
//	      new LinkedHashMap<PortfolioQueueNode, List<QueueAction>>();
//
//	    for (Object objs : queueActions) {
//	      Object[]           objects                         = (Object[]) objs;
//	      String             portfolioNameWithId             = (String) objects[4] + "!" + (BigInteger) objects[3];
//	      String             portfolioCurrencySymbol         = (objects.length > 5) ? (String) objects[5] : null;
//	      String             portfolioCurrencySymbolPosition = (objects.length > 6) ? (String) objects[6] : null;
//	      String             actionType                      = (objects.length > 7) ? (String) objects[7] : null;
//	      PortfolioQueueNode portfolioNode                   = new PortfolioQueueNode(portfolioNameWithId, "Portfolio", 0,
//	          portfolioCurrencySymbol, portfolioCurrencySymbolPosition);
//	      portfolioNode.setActionType(actionType);
//
//	      List<QueueAction> queues;
//
//	      if (portfolioQueueMap.containsKey(portfolioNode)) {
//	        queues = portfolioQueueMap.get(portfolioNode);
//	      } else {
//	        queues = new ArrayList<QueueAction>();
//	      }
//
//	      QueueAction queueAction = new QueueAction();
//	      queueAction.setPath((objects[2] == null) ? null : (String) objects[2]);
//	      queueAction.setId((objects[0] == null) ? null : ((BigInteger) objects[0]).longValue());
//	      queueAction.setName((objects[1] == null) ? null : (String) objects[1]);
//	      queueAction.setActionType(actionType);
//	      queues.add(queueAction);
//	      portfolioQueueMap.put(portfolioNode, queues);
//	    } // end for
//
//	    Long end = System.currentTimeMillis();
//
//	    if (log.isDebugEnabled()) {
//	      log.debug("buildPortfolioQueueNodeMap cost time : " + (end - start) + " ms.");
//	    }
//
//	    return portfolioQueueMap;
//	  }
//	

}
