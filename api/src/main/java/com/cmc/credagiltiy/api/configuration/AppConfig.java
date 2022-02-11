package com.cmc.credagiltiy.api.configuration;

import com.ozstrategy.credagility.el.service.ExpressionService;
import com.ozstrategy.credagility.el.service.impl.ExpressionServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean @Qualifier
    public ExpressionService expressionService() {
        return new ExpressionServiceImpl();
    }
}
