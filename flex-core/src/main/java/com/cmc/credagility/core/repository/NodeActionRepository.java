package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozstrategy.credagility.core.domain.BaseNodeAction;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 16:11
 */
public interface NodeActionRepository extends JpaRepository<BaseNodeAction, Long> { }
