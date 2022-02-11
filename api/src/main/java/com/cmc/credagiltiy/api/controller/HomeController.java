package com.cmc.credagiltiy.api.controller;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagiltiy.api.repository.DemoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private DemoRepository demoRepository;

    @GetMapping("/hello")
    public String index() {
        long id = 1L;
        Account account = demoRepository.findAccountWithDetailByAccountNum(id);
        if (account == null) {
            logger.warn("Account not found by id: {}", id);
        } else {
            logger.info(account.getOriginalAccountNumber());
        }
        List<Long> test = demoRepository.testQuery();
        logger.info("Test: {}", test.size());
        return "Hello World!";
    }
}
