package com.ozstrategy.credagility.core.repository;

import com.ozstrategy.credagility.core.domain.decisiontree.agency.AgencyQueueAction;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  11/03/2014 14:42
 */
public interface AgencyQueueActionRepository extends JpaRepository<AgencyQueueAction, Long> { }
