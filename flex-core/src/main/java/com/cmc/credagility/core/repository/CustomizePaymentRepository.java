package com.cmc.credagility.core.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.cmc.credagility.core.domain.payment.Payment;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 16:19
 */
public interface CustomizePaymentRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   accountNums  DOCUMENT ME!
   * @param   startTime    DOCUMENT ME!
   * @param   endTime      DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  List<Payment> getPaidPaymentsByAccountNum(List<Long> accountNums, Date startTime, Date endTime);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment activities by account num.
   *
   * @param   accountNums  List
   * @param   startTime    Date
   * @param   endTime      Date
   *
   * @return  List
   */
  List<Payment> getPaymentActivitiesByAccountNum(List<Long> accountNums, Date startTime, Date endTime);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   accountNums  DOCUMENT ME!
   * @param   startTime    DOCUMENT ME!
   * @param   endTime      DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  List<Payment> getScheduledAndInProcessPaymentsByAccountNum(Collection<Long> accountNums, Date startTime,
    Date endTime);
} // end interface CustomizePaymentRepository
