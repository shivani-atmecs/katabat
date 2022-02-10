package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.credagility.core.domain.program.ProgramRule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 17:04
 */
@Repository
public interface ProgramRuleRepository extends JpaRepository<ProgramRule, Long> {
  
  @Query("select r from ProgramRule r where r.ruleId=?1")
  ProgramRule getProgramRule(Long ruleId);
}
