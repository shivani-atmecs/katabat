package com.cmc.credagility.core.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.payment.PaymentSchedule;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 16:25
 */
public interface PaymentScheduleRepository extends JpaRepository<PaymentSchedule, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------


  /**
   * getter method for first payment schedule by payment date.
   *
   * @param   accountNum  Long
   *
   * @return  List
   */
  @Query(
    "select p  FROM PaymentSchedule p where  p.account.accountNum=?1  and  (p.deleted =false or p.deleted IS NULL) order by p.paymentDate "
  )
  List<PaymentSchedule> getFirstPaymentScheduleByPaymentDate(Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment by account num and after start date and payment type.
   *
   * @param   accountNum   Long
   * @param   startDate    Date
   * @param   paymentType  String
   *
   * @return  List
   */
  @Query(
    "select p FROM PaymentSchedule p Where p.account.accountNum = ?1 And (p.deleted =false or p.deleted IS NULL) And p.paymentDate > ?2 And p.paymentType = ?3 order by p.paymentDate"
  )
  List<PaymentSchedule> getPaymentByAccountNumAndAfterStartDateAndPaymentType(Long accountNum, Date startDate,
    String paymentType);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   accountNum   DOCUMENT ME!
   * @param   paymentDate  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select p from PaymentSchedule p where p.account.accountNum=?1 and p.paymentDate>=?2 and (p.deleted =false or p.deleted IS NULL ) order by p.paymentNumber asc "
  )
  List<PaymentSchedule> getPaymentSchedule(Long accountNum, Date paymentDate);
} // end interface PaymentScheduleRepository
