package com.ozstrategy.credagility.core.repository;

import com.cmc.credagility.core.domain.variable.BaseVariable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  11/03/2014 15:36
 */
public interface VariableRepository extends JpaRepository<BaseVariable, Long> { }
