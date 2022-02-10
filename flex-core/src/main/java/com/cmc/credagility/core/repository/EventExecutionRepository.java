package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.credagility.core.domain.event.EventExecution;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/23/2014 14:30
 */
public interface EventExecutionRepository extends JpaRepository<EventExecution, Long> { } // end interface EventExecutionRepository
