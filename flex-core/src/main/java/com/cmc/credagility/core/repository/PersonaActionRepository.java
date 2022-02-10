package com.cmc.credagility.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.ozstrategy.credagility.core.domain.PersonaAction;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  01/22/2015 12:46
 */
@Repository public interface PersonaActionRepository extends CrudRepository<PersonaAction, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findAccountPersonaActions.
   *
   * @param   accountNum  Long
   *
   * @return  List
   */
  @Query(
    "select distinct pa.personaAction from PersonaAccount pa where pa.account.accountNum = ?1 order by pa.personaAction.priority asc"
  )
  List<PersonaAction> findAccountPersonaActions(Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findCustomerPersonaActions.
   *
   * @param   customerId  accountNum Long
   *
   * @return  List
   */
  @Query(
    "select distinct pa.personaAction from PersonaAccount pa where pa.account in(select ri.responsible.account from ResponsibleIndex ri where ri.customer.customerId = ?1) order by pa.personaAction.priority asc"
  )
  List<PersonaAction> findCustomerPersonaActions(Long customerId);

} // end interface PersonaActionRepository
