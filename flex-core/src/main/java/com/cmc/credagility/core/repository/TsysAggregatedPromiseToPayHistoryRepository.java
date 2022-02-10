package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.credagility.core.domain.tsys.TsysAggregatedPromiseToPayHistory;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/31/2014 17:05
 */
public interface TsysAggregatedPromiseToPayHistoryRepository
  extends JpaRepository<TsysAggregatedPromiseToPayHistory, Long> { }
