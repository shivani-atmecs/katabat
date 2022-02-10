package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.credagility.core.domain.payment.PtpPaymentMethodConfiguration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 17:14
 */
@Repository
public interface PtpPaymentMethodConfigurationRepository extends JpaRepository<PtpPaymentMethodConfiguration, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for ptp payment method configuration.
   *
   * @param   portfolioId    Long
   * @param   paymentMethod  String
   *
   * @return  PtpPaymentMethodConfiguration
   */
  @Query("select pc from PtpPaymentMethodConfiguration pc where pc.portfolio.portfolioId=?1 and pc.paymentMethod=?2 and pc.status <> 'DISABLE' ")
  PtpPaymentMethodConfiguration getPtpPaymentMethodConfiguration(Long portfolioId, String paymentMethod);
}
