package com.cmc.credagility.core.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.account.DeferralSuspension;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 14:52
 */
public interface DeferralSuspensionRepository extends JpaRepository<DeferralSuspension, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   accountNum   DOCUMENT ME!
   * @param   paymentDate  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query("select d from DeferralSuspension d where d.account.accountNum=?1 and d.fromDate>=?2 and d.toDate<=?2 ")
  List<DeferralSuspension> getDeferralSuspension(Long accountNum, Date paymentDate);
}
