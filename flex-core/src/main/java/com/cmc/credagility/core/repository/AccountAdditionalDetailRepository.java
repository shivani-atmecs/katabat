package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.account.AccountAdditionalDetail;
import com.cmc.credagility.core.domain.payment.AutoDebitDetail;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 15:32
 */
@Repository public interface AccountAdditionalDetailRepository extends JpaRepository<AccountAdditionalDetail, Long> { }
