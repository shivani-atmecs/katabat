package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.payment.AggregatedPayment;
import com.cmc.credagility.core.domain.payment.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 16:19
 */
@Repository
public interface AggregatedPaymentRepository extends JpaRepository<AggregatedPayment, Long> { }
