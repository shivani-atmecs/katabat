package com.cmc.credagility.core.repository.jdbc;


import com.cmc.credagility.core.domain.payment.Payment;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 16:21
 */
public interface PaymentRepositoryJdbc {

    /**
     * DOCUMENT ME!
     *
     * @param   id  DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    Payment findByPaymentId(Long id);
}
