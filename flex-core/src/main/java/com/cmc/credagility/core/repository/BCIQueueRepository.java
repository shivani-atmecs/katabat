package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.BCIQueue;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 17:03
 */
public interface BCIQueueRepository extends JpaRepository<BCIQueue, Long> { }
