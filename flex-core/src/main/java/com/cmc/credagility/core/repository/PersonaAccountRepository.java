package com.cmc.credagility.core.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.ozstrategy.credagility.core.domain.PersonaAccount;


/**
 * Created by zhubq on 6/11/15.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  06/11/2015 11:48
 */
@Repository public interface PersonaAccountRepository extends CrudRepository<PersonaAccount, Long>,
  PersonaAccountRepositoryCustom {
  /*/**
   * DOCUMENT ME!
   *
   * @param  customerId      accountNums DOCUMENT ME!
   * @param  lastUpdateDate  Date
   *
  @Modifying
  @Query(
    "update PersonaAccount p set p.historical = true,p.lastUpdateDate = ?2 where (p.historical is null or p.historical=false) and p.responsible.responsibleId in ?1"
  )
  void updatePersonaAccountsHistorical(List<Long> responsibleIds, Date lastUpdateDate);*/
}
