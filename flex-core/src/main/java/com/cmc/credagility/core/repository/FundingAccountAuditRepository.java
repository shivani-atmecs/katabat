package com.cmc.credagility.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.payment.FundingAccountAudit;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Repository public interface FundingAccountAuditRepository extends CrudRepository<FundingAccountAudit, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   customerId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query("select f from FundingAccountAudit f where f.customerId=?1")
  List<FundingAccountAudit> findFundingAccountAuditsByCustomerId(Long customerId);

}
