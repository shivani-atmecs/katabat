package com.cmc.credagility.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.account.AccountDetail;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 15:14
 */
public interface AccountDetailRepository extends JpaRepository<AccountDetail, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account detail by customer.
   *
   * @param   responsibleId  Long
   *
   * @return  List
   */
  @Query(
    "select distinct ad from AccountDetail ad where ad.accountDetailId in(select a.accountDetail.accountDetailId from Account a where a.accountNum in(select r1.account.accountNum from Responsible r1, Responsible r2 where r1.responsibleIndex.customer.customerId=r2.responsibleIndex.customer.customerId and r2.responsibleId=?1 and (r1.primaryHolder=true or r1.responsibleId = r2.responsibleId) and r1.account.active=true and r1.account.allowWeb=true)) order by ad.clientDefinedDate1"
  )
  List<AccountDetail> getAccountDetailByCustomer(Long responsibleId);

} // end interface AccountDetailRepository
