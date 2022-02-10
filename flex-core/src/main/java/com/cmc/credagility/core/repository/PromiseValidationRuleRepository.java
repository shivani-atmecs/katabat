package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.credagility.core.domain.payment.PromiseToPayValidationRule;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 17:13
 */
public interface PromiseValidationRuleRepository extends JpaRepository<PromiseToPayValidationRule, Long> { }
