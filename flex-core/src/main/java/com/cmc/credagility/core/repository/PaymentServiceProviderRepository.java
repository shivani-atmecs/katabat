package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.credagility.core.domain.payment.PaymentServiceProvider;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 16:26
 */
public interface PaymentServiceProviderRepository extends JpaRepository<PaymentServiceProvider, Long> { }
