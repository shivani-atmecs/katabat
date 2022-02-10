package com.cmc.credagility.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.responsible.ResponsibleIndex;


/**
 * Created by tangwei on 1/9/15.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public interface ResponsibleIndexRepository extends JpaRepository<ResponsibleIndex, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for MRAResponsible index by responsible id.
   *
   * @param   responsibleId  Long
   *
   * @return  List
   */
  @Query(
    "select r from ResponsibleIndex r where r.customer.customerId=(select r.customer.customerId from ResponsibleIndex r where r.responsible.responsibleId = ?1)"
  )
  List<ResponsibleIndex> getMRAResponsibleIndexByResponsibleId(Long responsibleId);
}
