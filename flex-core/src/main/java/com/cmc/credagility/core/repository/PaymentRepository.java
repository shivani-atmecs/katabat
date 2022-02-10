package com.cmc.credagility.core.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.type.PaymentChannel;
import com.cmc.credagility.core.domain.type.PaymentStatus;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 16:19
 */
@Repository public interface PaymentRepository extends JpaRepository<Payment, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findByAggregatedPaymentAggregatedPaymentId.
   *
   * @param   aggregatedPaymentId  Long
   *
   * @return  List
   */
  List<Payment> findByAggregatedPaymentAggregatedPaymentId(Long aggregatedPaymentId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active account payment history by customer id.
   *
   * @param   customerId  Long
   * @param   page        Pageable
   *
   * @return  Page
   */
  @Query(
    "select distinct p from Payment p where p.responsible.responsibleIndex.customer.customerId = ?1 And (p.account.active is null or p.account.active = true)"
  )
  Page<Payment> getActiveAccountPaymentHistoryByCustomerId(Long customerId, Pageable page);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active account payments by logged customer.
   *
   * @param   customerId  Long
   * @param   sorter      Sort
   *
   * @return  List
   */
  @Query(
    "select distinct p from Payment p where p.responsible.responsibleIndex.customer.customerId = ?1 And (p.account.active is null or p.account.active = true)"
  )
  List<Payment> getActiveAccountPaymentsByLoggedCustomer(Long customerId, Sort sorter);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent updated payments.
   *
   * @param   accountNum  Long
   * @param   targetDate  Date
   *
   * @return  List
   */
  @Query(
    "select p from Payment p where p.account.accountNum =?1 and (p.agentUpdatedPaymentDate=?2 and p.createDate<>?2) order by p.paymentDate ASC"
  )
  List<Payment> getAgentUpdatedPayments(Long accountNum, Date targetDate);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment history by customer id.
   *
   * @param   customerId  Long
   * @param   page        Pageable
   *
   * @return  Page
   */
  @Query("select distinct p from Payment p where p.responsible.responsibleIndex.customer.customerId = ?1")
  Page<Payment> getAllPaymentHistoryByCustomerId(Long customerId, Pageable page);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all payments by account.
   *
   * @param   accountNum  Long
   *
   * @return  List
   */
  @Query(
    "select distinct p from Payment p where p.account.accountNum = ?1 AND p.executePaymentGroup IS NOT NULL ORDER BY p.createDate DESC"
  )
  List<Payment> getAllPaymentsByAccount(Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all payments by account and group.
   *
   * @param   accountNum           Long
   * @param   executePaymentGroup  String
   *
   * @return  Object[]
   */
  @Query(
    "select p,f.fundingInformation from Payment p LEFT JOIN FundingAccount f ON f.fundingAccountId = p.fundingAccountId WHERE p.account.accountNum = ?1 AND p.executePaymentGroup= ?2 ORDER BY p.paymentDate ASC"
  )
  List<Object[]> getAllPaymentsByAccountAndGroup(Long accountNum, String executePaymentGroup);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all payments by account num.
   *
   * @param   accountNum  Long
   * @param   sorter      String
   *
   * @return  List
   */
  @Query("select distinct p from Payment p where p.account.accountNum=?1")
  List<Payment> getAllPaymentsByAccountNum(Long accountNum, Sort sorter);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all payments by account num and status.
   *
   * @param   accountNum       Long
   * @param   sorter           Sort
   * @param   paymentChannels  PaymentStatus
   *
   * @return  List
   */
  @Query("select distinct p from Payment p where p.account.accountNum=?1 and p.paymentChannel in ?2")
  List<Payment> getAllPaymentsByAccountNumAndChannels(Long accountNum, Sort sorter, PaymentChannel... paymentChannels);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all payments by account num and status.
   *
   * @param   accountNum  Long
   * @param   sorter      Sort
   * @param   statuses    PaymentStatus
   *
   * @return  List
   */
  @Query("select distinct p from Payment p where p.account.accountNum=?1 and p.paymentStatus in ?2")
  List<Payment> getAllPaymentsByAccountNumAndStatus(Long accountNum, Sort sorter, PaymentStatus... statuses);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all payments by logged customer.
   *
   * @param   customerId  Long
   * @param   sorter      Sort
   *
   * @return  List
   */
  @Query("select distinct p from Payment p where p.responsible.responsibleIndex.customer.customerId = ?1")
  List<Payment> getAllPaymentsByLoggedCustomer(Long customerId, Sort sorter);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all payments by RCustomer.
   *
   * @param   responsibleId  Long
   *
   * @return  List
   */
  @Query(
    "select distinct p from Payment p where p.account in (select distinct r1.account from Responsible r1, Responsible r2 where r1.responsibleIndex.customer.customerId=r2.responsibleIndex.customer.customerId and r2.responsibleId=?1 and r1.primaryHolder=true) order by p.createDate desc"
  )
  List<Payment> getAllPaymentsByRCustomer(Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for future scheduled non program payments.
   *
   * @param   responsibleId  Long
   *
   * @return  List
   */
  @Query(
    "select p from Payment p where p.responsible.responsibleId =?1 and p.paymentProgram.programId IS NULL and p.paymentStatus='SCHEDULED' order by p.paymentDate DESC"
  )
  List<Payment> getFutureScheduledNonProgramPayments(Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   originalAccountNumberHash  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select p from Payment p where p.account.accountIndex.originalAccountNumberHash = ?1 and p.paymentStatus='SCHEDULED'"
  )
  List<Payment> getFutureScheduledPaymentsByAccountHash(String originalAccountNumberHash);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   responsibleId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query("select p from Payment p where p.responsible.responsibleId =?1 and p.paymentStatus='SCHEDULED'")
  List<Payment> getFutureScheduledPaymentsByResponsible(Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   accountNums  DOCUMENT ME!
   * @param   status       DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    value       =
      "select p.* from Payment p inner join (select max(p2.paymentId) as paymentId from Payment p2 where p2.accountNum in :accountNums and p2.paymentStatus = :status group by p2.accountNum) p3 on p3.paymentId=p.paymentId",
    nativeQuery = true
  )
  List<Payment> getMostRecentPaymentsByAccountsAndStatus(@Param("accountNums") Collection<Long> accountNums,
    @Param("status") String status);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   programId    DOCUMENT ME!
   * @param   paymentDate  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query("select p from Payment p where p.paymentProgram.programId=?1 and p.paymentDate>?2 order by p.paymentDate asc")
  List<Payment> getNextPaymentInAProgram(Long programId, Date paymentDate);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   accountNum  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select p from Payment p where p.account.accountNum = ?1 AND p.paymentStatus='PAID' order by p.createDate desc"
  )
  List<Payment> getPaidPaymentsByAccountNum(Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for scheduled payments in payment program.
   *
   * @param   externalReferenceNumber  string
   *
   * @return  List
   */
  @Query("select distinct p from Payment p where p.externalReferenceNumber=?1")
  Payment getPaymentByExternalRefNum(String externalReferenceNumber);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment by group id.
   *
   * @param   groupId  String
   *
   * @return  List
   */
  @Query("select distinct p from Payment p where p.paymentGroup.paymentGroupId = ?1")
  List<Payment> getPaymentByGroupId(Long groupId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment by program.
   *
   * @param   programId      Long
   * @param   responsibleId  Long
   *
   * @return  List
   */
  @Query(
    "select p from Payment p where p.paymentProgram.programId=?1 and p.responsible.responsibleId=?2 and p.paymentStatus <> 'DELETED' "
  )
  List<Payment> getPaymentByProgram(Long programId, Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payments history.
   *
   * @param   accountNum  Long
   * @param   page        Pageable
   *
   * @return  Page
   */
  @Query("select distinct p from Payment p where p.account.accountNum=?1")
  Page<Payment> getPaymentHistoryList(Long accountNum, Pageable page);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payments by RCustomer.
   *
   * @param   accountNums  List
   * @param   beforeDate   Date
   *
   * @return  List
   */
  @Query(
    "select p from Payment p where p.createDate > ?2 and  p.account.accountNum in ?1 order by p.createDate desc, p.paymentId desc"
  )
  List<Payment> getPaymentsByAccountNum(List<Long> accountNums, Date beforeDate);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payments by account num and status.
   *
   * @param   accountNum       Long
   * @param   page             Pageable
   * @param   paymentChannels  PaymentStatus
   *
   * @return  Page
   */
  @Query("select distinct p from Payment p where p.account.accountNum=?1 and p.paymentChannel in ?2")
  Page<Payment> getPaymentsByAccountNumAndChannels(Long accountNum, Pageable page, PaymentChannel... paymentChannels);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payments by account num and status.
   *
   * @param   accountNum  Long
   * @param   page        Pageable
   * @param   statuses    PaymentStatus
   *
   * @return  Page
   */
  @Query("select distinct p from Payment p where p.account.accountNum=?1 and p.paymentStatus in ?2")
  Page<Payment> getPaymentsByAccountNumAndStatus(Long accountNum, Pageable page, PaymentStatus... statuses);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment by program.
   *
   * @param   programId  Long
   *
   * @return  List
   */
  @Query(
    "SELECT p,f.fundingInformation from Payment p LEFT JOIN FundingAccount f on f.fundingAccountId=p.fundingAccountId where p.paymentProgram.programId=?1 order by p.paymentDate"
  )
  List<Object[]> getPaymentsByProgramId(Long programId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payments by RCustomer.
   *
   * @param   responsibleId  Long
   * @param   page           Pageable
   *
   * @return  List
   */
  @Query(
    "select distinct p from Payment p where p.account in (select distinct r1.account from Responsible r1, Responsible r2 where r1.responsibleIndex.customer.customerId=r2.responsibleIndex.customer.customerId and r2.responsibleId=?1 and (r1.primaryHolder=true or r1.responsibleId = r2.responsibleId)) order by p.createDate desc"
  )
  Page<Payment> getPaymentsByRCustomer(Long responsibleId, Pageable page);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payments by RCustomer.
   *
   * @param   responsibleId    Long
   * @param   loginCustomerId  Long
   * @param   beforeDate       Date
   *
   * @return  List
   */
  @Query(
    "select distinct p from Payment p where p.createDate > ?3 and  p.account in (select distinct r1.account from Responsible r1, Responsible r2, Responsible r3 where r1.responsibleIndex.customer.customerId=r2.responsibleIndex.customer.customerId and r2.responsibleId=?1 and (r1.primaryHolder=true or r1.responsibleId = r2.responsibleId) and r1.account.active=true and r1.account.allowWeb=true and r1.account=r3.account and r3.responsibleIndex.customer.customerId=?2) order by p.createDate desc, p.paymentId desc"
  )
  List<Payment> getPaymentsByRCustomer(Long responsibleId, Long loginCustomerId, Date beforeDate);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payments by RCustomer.
   *
   * @param   responsibleId  Long
   * @param   startDate      Date
   * @param   endDate        Date
   *
   * @return  List
   */
  @Query(
    "select distinct p from Payment p where p.createDate >= ?2 and p.createDate <= ?3 and  p.account in (select distinct r1.account from Responsible r1, Responsible r2 where r1.responsibleIndex.customer.customerId=r2.responsibleIndex.customer.customerId and r2.responsibleId=?1 and (r1.primaryHolder=true or r1.responsibleId = r2.responsibleId)) order by p.createDate desc"
  )
  List<Payment> getPaymentsByRCustomer(Long responsibleId, Date startDate, Date endDate);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payments list.
   *
   * @param   accountNum  Long
   * @param   page        Pageable
   *
   * @return  Page
   */
  @Query("select distinct p from Payment p where p.account.accountNum=?1 order by p.createDate desc")
  Page<Payment> getPaymentsList(Long accountNum, Pageable page);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for scheduled payments in payment program.
   *
   * @param   startDate              date
   * @param   endDate                DOCUMENT ME!
   * @param   originalAccountNumber  DOCUMENT ME!
   *
   * @return  List
   */
  @Query("from Payment p where p.paymentDate >= ?1 and p.paymentDate <= ?2 and p.account.originalAccountNumber = ?3")
  List<Payment> getPaymentsWithinPeriod(Date startDate, Date endDate, String originalAccountNumber);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for scheduled and in process payments.
   *
   * @param   responsibleId  Long
   *
   * @return  Long
   */
  @Query(
    "select count(p.paymentId) from Payment p where p.responsible.responsibleId =?1 and p.paymentStatus in ('SCHEDULED','INPROCESS')"
  )
  Long getScheduledAndInProcessPayments(Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   accountNum  DOCUMENT ME!
   * @param   page        DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select distinct p from Payment p where p.account.accountNum=?1 and p.paymentStatus in ('SCHEDULED','Paid') order by p.createDate desc "
  )
  Page<Payment> getScheduledAndPaidPaymentHistoryList(Long accountNum, Pageable page);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   responsibleId  DOCUMENT ME!
   * @param   fundAcctId     DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select distinct p from Payment p where p.responsible.responsibleId =?1 and p.fundingAccountId=?2 and p.paymentStatus='SCHEDULED' order by p.paymentDate ASC"
  )
  List<Payment> getScheduledPaymentsForFundingAccount(Long responsibleId, Long fundAcctId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for scheduled payments in payment program.
   *
   * @param   responsibleId  Long
   * @param   programId      Long
   * @param   oldFundAcctId  Long
   *
   * @return  List
   */
  @Query(
    "select distinct p from Payment p where p.responsible.responsibleId =?1 and p.paymentProgram.programId=?2 and p.fundingAccountId=?3 and p.paymentStatus='SCHEDULED' order by p.paymentDate ASC"
  )
  List<Payment> getScheduledPaymentsInPaymentProgram(Long responsibleId, Long programId, Long oldFundAcctId);

} // end interface PaymentRepository
