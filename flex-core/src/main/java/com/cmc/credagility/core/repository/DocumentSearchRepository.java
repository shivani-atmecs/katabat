package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozstrategy.credagility.core.domain.document.DocumentSearchFilter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 15:14
 */
public interface DocumentSearchRepository extends JpaRepository<DocumentSearchFilter, Long> { }
