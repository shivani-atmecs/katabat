package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.payment.PaymentGroup;


/**
 * Created by tangwei on 8/16/16.
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  08/16/2016 12:46
 */
@Repository public interface PaymentGroupRepository extends JpaRepository<PaymentGroup, Long> { }
