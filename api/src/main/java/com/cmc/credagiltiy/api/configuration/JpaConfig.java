package com.cmc.credagiltiy.api.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = {
    "com.cmc.credagiltiy.api.repository"
})
@ComponentScan(basePackages = {
    "com.cmc.credagility.util.*",
    "com.cmc.credagility.core.*",
    "com.ozstrategy.credagility.core.*",
    "com.ozstrategy.credagility.el.*",
    "com.ozstrategy.credagility.el.service.*",
})
@EntityScan(basePackages = {
    "com.cmc.credagility.core.*",
    "com.ozstrategy.credagility.core.*",
    "com.ozstrategy.credagility.el.*"
})
public class JpaConfig {

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
