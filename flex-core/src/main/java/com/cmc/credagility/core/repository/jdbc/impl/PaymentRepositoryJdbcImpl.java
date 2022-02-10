package com.cmc.credagility.core.repository.jdbc.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Profile;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.stereotype.Component;

import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.repository.jdbc.PaymentRepositoryJdbc;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 16:22
 */
@Component("paymentRepositoryJdbcImpl")
@Profile("jdbc")
public class PaymentRepositoryJdbcImpl extends BaseJdbcRepositoryImpl implements PaymentRepositoryJdbc {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BaseJdbcRepositoryImpl object.
   *
   * @param  dataSource  DataSource
   */
  @Autowired public PaymentRepositoryJdbcImpl(DataSource dataSource) {
    super(dataSource);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------


  /**
   * @see  com.cmc.credagility.core.repository.jdbc.PaymentRepositoryJdbc#findByPaymentId(Long)
   */
  @Override public Payment findByPaymentId(Long id) {
    String sql = "SELECT * FROM Payment WHERE paymentId = ?";

    return (Payment) getJdbcTemplate().queryForObject(
        sql,
        new Object[] { id },
        new BeanPropertyRowMapper(Payment.class));

  }
} // end class PaymentRepositoryJdbcImpl
