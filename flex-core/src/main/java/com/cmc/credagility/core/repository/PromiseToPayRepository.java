package com.cmc.credagility.core.repository;

import java.util.List;

import com.cmc.credagility.core.domain.type.PromiseToPayStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.payment.PromiseToPay;
import com.cmc.credagility.core.domain.payment.PromiseToPayValidationRule;
import org.springframework.stereotype.Repository;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 17:09
 */
@Repository("promiseToPayRepository")
public interface PromiseToPayRepository extends JpaRepository<PromiseToPay, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for promise history list.
   *
   * @param   accountNum  Long
   * @param   page        Pageable
   *
   * @return  Page
   */
  @Query("select distinct p from PromiseToPay p where p.account.accountNum=?1")
  Page<PromiseToPay> getPromiseHistoryList(Long accountNum, Pageable page);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for promise to pay validation rules.
   *
   * @param   portfolioId  Long
   *
   * @return  List
   */
  @Query(
    "select distinct pvr from PromiseToPayValidationRule pvr where pvr.portfolio.portfolioId = ?1 order by pvr.priority asc"
  )
  List<PromiseToPayValidationRule> getPromiseToPayValidationRules(Long portfolioId);
  
  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for promise to pay by status and order.
   *
   * @param   accountNum  Long
   *
   * @return  List
   */
  @Query("select p from PromiseToPay p where p.account.accountNum=?1 and p.ptpStatus='BROKEN' order by p.brokenStatusDate desc")
  List<PromiseToPay> getPromiseToPayByStatusAndOrder(Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for promise to pay by status and order.
   *
   * @param   accountNum  Long
   *
   * @return  List
   */
  @Query("select p from PromiseToPay p where p.account.accountNum=?1 order by p.promiseId desc")
  List<PromiseToPay> getPromiseToPayByCreateDate(Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for promise to pay by status and order.
   *
   * @param   accountNum  Long
   *
   * @return  List
   */
  @Query("select p from PromiseToPay p where p.account.accountNum=?1 and p.ptpStatus=?2 order by p.keptStatusDate desc")
  List<PromiseToPay> getPromiseToPayByStatusAndCreateDate(Long accountNum, PromiseToPayStatus ptpStatus);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for promise to pay by status and order bye promiseToPay.createDate asc
   *
   * @param   accountNum  Long
   *                         
   *
   * @return  List
   */
  @Query("select p from PromiseToPay p where p.account.accountNum=?1 and p.ptpStatus=?2 order by p.createDate asc")
  List<PromiseToPay> getPromiseToPayByStatusAndOrder(Long accountNum, PromiseToPayStatus ptpStatus);


  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment by program.
   *
   * @param   programId  Long
   *
   * @return  List
   */
  @Query(
      "select ptp from PromiseToPay ptp left join PaymentProgramInstallment installment on ptp.paymentProgramInstallment.installmentId = installment.installmentId left join PaymentProgram pp on installment.paymentProgram.programId = pp.programId where pp.programId=?1 and ptp.paymentProgramInstallment.installmentId is not NULL order by ptp.paymentDate ASC")
  List<PromiseToPay> getPromiseToPayByProgramId(Long programId);
} // end interface PromiseToPayRepository
