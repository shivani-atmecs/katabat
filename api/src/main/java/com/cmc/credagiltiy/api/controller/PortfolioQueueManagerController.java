package com.cmc.credagiltiy.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagiltiy.api.repository.PortfolioRepository;

@RestController
@RequestMapping("/api")
public class PortfolioQueueManagerController {
	
	private final Logger logger = LoggerFactory.getLogger(PortfolioQueueManagerController.class);
	
	private PortfolioRepository portfolioRepository;
	
	@GetMapping("/portfolio")
	public List<Long> index() {
		
		List
        long id = 1L;
        Account account = demoRepository.findAccountWithDetailByAccountNum(id);
        if (account == null) {
            logger.warn("Account not found by id: {}", id);
        } else {
            logger.info(account.getOriginalAccountNumber());
        }
        List<Long> test = demoRepository.testQuery();
        logger.info("Test: {}", test.size());
        return test;
    } 
	

}
