package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.businesscontext.DynamicCase;
import com.cmc.credagility.core.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 16:26
 */
public interface DynamicCaseRepository extends JpaRepository<DynamicCase, Long> {


  @Query(
      "select c from DynamicCase c where c.customer=?1 and caseNumber=?2"
  )
  List<DynamicCase> getDynamicCaseByCustomer(Customer customer,String caseNumber);



}
