package com.cmc.credagility.core.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.payment.PaymentProgram;
import com.cmc.credagility.core.domain.payment.PaymentProgramInstallment;
import com.cmc.credagility.core.domain.payment.PaymentSchedule;

import com.ozstrategy.credagility.core.domain.NodeStrategyResult;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  01/07/2015 16:46
 */
@Repository public interface PaymentProgramRepository extends JpaRepository<PaymentProgram, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * countPaymentByAccountNumAndAfterStartDate.
   *
   * @param   accountNum  Long
   * @param   startDate   Date
   *
   * @return  Long
   */
  @Query(
    "select count(*) FROM PaymentSchedule p Where p.account.accountNum = ?1 And p.paymentGrossAmount > 0 And (p.deleted = false or p.deleted is NULL) And p.paymentDate > ?2 And p.paymentType = 'Firm Term' order by p.paymentDate"
  )
  Long countPaymentByAccountNumAndAfterStartDate(Long accountNum, Date startDate);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for accepted payment program.
   *
   * @param   accountNum  Long
   *
   * @return  Object
   */
  @Query(
    "select a.acceptedProgram.programId from Account a left join a.acceptedProgram p where a.accountNum=?1 and p.programStatus='ACCEPTED' "
  )
  Object getAcceptedPaymentProgram(Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for completed payment program.
   *
   * @param   accountNum  Long
   *
   * @return  Object
   */
  @Query(
    "select p from PaymentProgram p where p.account.accountNum=?1 and p.acceptDate is not null order by p.acceptDate desc"
  )
  List<PaymentProgram> getCompletedPaymentProgram(Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for failed payment program.
   *
   * @param   accountNum  Long
   *
   * @return  Object
   */
  @Query(
    "select p from PaymentProgram p where p.account.accountNum=?1 and p.acceptDate is not null order by p.acceptDate desc"
  )
  List<PaymentProgram> getFailedPaymentProgram(Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for installments.
   *
   * @param   programId  Long
   *
   * @return  Set
   */
  @Query("select i from PaymentProgramInstallment i where i.paymentProgram.programId=?1")
  List<PaymentProgramInstallment> getInstallments(Long programId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment program.
   *
   * @param   programId  Long
   *
   * @return  PaymentProgram
   */
  @Query("select p from PaymentProgram p where p.programId=?1")
  PaymentProgram getPaymentProgram(Long programId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment schedule by account.
   *
   * @param   accountNum  Long
   *
   * @return  List
   */
  @Query("select r FROM PaymentSchedule r where r.account.accountNum = ?1 and r.deleted = false")
  List<PaymentSchedule> getPaymentScheduleByAccount(Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program node strategy results.
   *
   * @param   responsibleId  Long
   *
   * @return  List
   */
  @Query(
    "select nsr from NodeStrategyResult nsr, Responsible r where nsr.account.accountNum = r.account.accountNum and (nsr.programAction = true or nsr.programAction is NULL) and r.responsibleId=?1 order by nsr.createDate DESC"
  )
  List<NodeStrategyResult> getProgramNodeStrategyResults(Long responsibleId);

} // end interface PaymentProgramRepository
