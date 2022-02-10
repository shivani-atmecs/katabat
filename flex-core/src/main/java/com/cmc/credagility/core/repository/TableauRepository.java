package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.credagility.core.domain.tableau.TableauFeatureViewConfig;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/31/2014 16:58
 */
public interface TableauRepository extends JpaRepository<TableauFeatureViewConfig, Long> { }
