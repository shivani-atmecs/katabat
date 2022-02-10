package com.cmc.credagility.core.repository;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.type.PaymentStatus;
import com.cmc.credagility.core.domain.util.DateUtil;

import com.ozstrategy.credagility.core.repository.OzHibernateDaoSupport;


/**
 * Created by Yang Wang on 12/14/15.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  12/14/2015 16:40 PM
 */
@Repository("customizePaymentRepository")
public class CustomizePaymentRepositoryImpl extends OzHibernateDaoSupport implements CustomizePaymentRepository {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @PersistenceContext private EntityManager em;

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
  @Override public List<Payment> getPaidPaymentsByAccountNum(List<Long> accountNums, Date startTime, Date endTime) {
    Junction statusCriteria = Restrictions.disjunction().add(getPaidPaymentCriterion(startTime, endTime));

    return getSession().createCriteria(Payment.class).add(Restrictions.and(getAccountCriterion(accountNums),
          statusCriteria)).addOrder(getOrderBy()).list();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  CustomizePaymentRepository#getPaymentActivitiesByAccountNum(java.util.List,
   *       java.util.Date, java.util.Date)
   */
  @Override public List<Payment> getPaymentActivitiesByAccountNum(List<Long> accountNums, Date startTime,
    Date endTime) {
    Junction statusCriteria = Restrictions.disjunction().add(getInProcessPaymentCriterion(startTime, endTime)).add(
        getScheduledPaymentCriterion(getDate(Calendar.DAY_OF_MONTH, 1), endTime)).add(getRejectedPaymentCriterion(
          startTime, endTime)).add(
        getPaidPaymentCriterion(startTime, getDate(Calendar.DAY_OF_MONTH, 1))).add(getDeletedPaymentCriterion(startTime,
          endTime));

    return getSession().createCriteria(Payment.class).add(Restrictions.and(getAccountCriterion(accountNums),
          statusCriteria)).addOrder(getOrderBy()).list();
  } // end method getPaymentActivitiesByAccountNum

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
  @Override public List<Payment> getScheduledAndInProcessPaymentsByAccountNum(Collection<Long> accountNums,
    Date startTime,
    Date endTime) {
    Junction statusCriteria = Restrictions.disjunction().add(getInProcessPaymentCriterion(startTime, endTime)).add(
        getScheduledPaymentCriterion(getDate(Calendar.DAY_OF_MONTH, 1), endTime));

    return getSession().createCriteria(Payment.class).add(Restrictions.and(getAccountCriterion(accountNums),
          statusCriteria)).addOrder(getOrderBy()).list();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private Criterion getAccountCriterion(Collection<Long> accountNums) {
    return Restrictions.in("account.accountNum", accountNums);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private Date getDate(int type, int offset) {
    Date date;

    Calendar cal = Calendar.getInstance();

    if (offset != 0) {
      cal.add(type, offset);
    }

    DateUtil.clearTime(cal);
    date = cal.getTime();

    return date;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private Criterion getDeletedPaymentCriterion(Date startTime, Date endTime) {
    return Restrictions.and(Restrictions.eq("paymentStatus", PaymentStatus.DELETED),
        Restrictions.between("deletedStatusDate", startTime, endTime));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private Criterion getInProcessPaymentCriterion(Date startTime, Date endTime) {
    return Restrictions.and(Restrictions.eq("paymentStatus", PaymentStatus.INPROCESS),
        Restrictions.between("postDate", startTime, endTime));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private Order getOrderBy() {
    return Order.desc("paymentId");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private Criterion getPaidPaymentCriterion(Date startTime, Date endTime) {
    return Restrictions.and(Restrictions.eq("paymentStatus", PaymentStatus.PAID),
        Restrictions.between("paidStatusDate", startTime, endTime));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private Criterion getRejectedPaymentCriterion(Date startTime, Date endTime) {
    return Restrictions.and(Restrictions.eq("paymentStatus", PaymentStatus.REJECTED),
        Restrictions.between("rejectedAtAuthorizationDate", startTime, endTime));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private Criterion getScheduledPaymentCriterion(Date startTime, Date endTime) {
    return Restrictions.and(Restrictions.eq("paymentStatus", PaymentStatus.SCHEDULED),
        Restrictions.between("paymentDate", startTime, endTime));
  }
} // end class CustomizePaymentRepositoryImpl
