package com.cmc.credagility.core.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.payment.AutoDebitDetail;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 15:32
 */
@Repository public interface AutoDebitDetailRepository extends JpaRepository<AutoDebitDetail, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * countAutoDebitByCustomerAndFundingAccountNum.
   *
   * @param   fundingAccountId  Long
   *
   * @return  Long
   */
  @Query(
    "select count(*) from AutoDebitDetail a where a.fundingAccountId = ?1 and a.status in ('ENROLLED','ENROLL_PENDING')"
  )
  Long countAutoDebitByFundingAccountId(Long fundingAccountId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * countEnrolledAutoDebitByAccountNum.
   *
   * @param   accountNum  long
   *
   * @return  long
   */
  @Query(
    "select count(*) from AutoDebitDetail a where a.account.accountNum=?1 and a.historical = false and a.status = 'ENROLLED'"
  )
  Long countEnrolledAutoDebitDetailByAccountNum(long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding account.
   *
   * @param   autoDebitDetailId  fundingAccountId Long
   *
   * @return  FundingAccount
   */
  @Query("select a from AutoDebitDetail a where a.autoDebitDetailId=?1")
  AutoDebitDetail getAutoDebitDetail(Long autoDebitDetailId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for auto debit detail by RCustomer.
   *
   * @param   responsibleId  Long
   * @param   beforeDate     Date
   *
   * @return  List
   */
  @Query(
    "select distinct a from AutoDebitDetail a where a.createDate > ?2 and  a.account in (select distinct r1.account from Responsible r1, Responsible r2 where r1.responsibleIndex.customer.customerId=r2.responsibleIndex.customer.customerId and r2.responsibleId=?1 and (r1.primaryHolder=true or r1.responsibleId = r2.responsibleId) and r1.account.active=true and r1.account.allowWeb=true) and a.historical <> true and a.status in ('ENROLLED','CANCEL_PENDING') order by a.createDate desc"
  )
  List<AutoDebitDetail> getAutoDebitDetailByRCustomer(Long responsibleId, Date beforeDate);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   accountNum  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query("select a from AutoDebitDetail a where a.account.accountNum=?1 and a.historical = false")
  AutoDebitDetail getCurrentAutoDebitDetailByAccount(Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enrolled auto debit by account num.
   *
   * @param   accountNum  long
   *
   * @return  AutoDebitDetail
   */
  @Query(
    "select a from AutoDebitDetail a where a.account.accountNum=?1 and a.historical = false and a.status = 'ENROLLED'"
  )
  AutoDebitDetail getEnrolledAutoDebitByAccountNum(long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   accountNum  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select a from AutoDebitDetail a where a.account.accountNum=?1 and a.historical = false and (a.status = 'ENROLLED' or a.status = 'CANCEL_PENDING' or a.status = 'UPDATE_PENDING')"
  )
  AutoDebitDetail getEnrolledAutoDebitDetail(Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   accountNum  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select a from AutoDebitDetail a where a.account.accountNum=?1 and a.historical = false and (a.status = 'NOT_ENROLLED')"
  )
  AutoDebitDetail getNotEnrolledAutoDebitDetail(Long accountNum);

} // end interface AutoDebitDetailRepository
