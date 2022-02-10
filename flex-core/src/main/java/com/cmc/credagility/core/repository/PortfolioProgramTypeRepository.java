package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.payment.PaymentProgramType;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.credagility.core.domain.portfolio.PortfolioProgramType;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 16:42
 */
public interface PortfolioProgramTypeRepository extends JpaRepository<PortfolioProgramType, Long> {

  @Query("from PortfolioProgramType where paymentProgramType.programTypeId = ?1 and portfolio.portfolioId=?2 ")
  List<PortfolioProgramType> findPortfolioProgramType(Long programTypeId, Long portfolioId);
}
