package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozstrategy.credagility.core.domain.QueueAccount;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 17:16
 */
public interface QueueAccountRepository extends JpaRepository<QueueAccount, Long> { }
