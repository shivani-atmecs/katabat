package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.user.Division;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 15:13
 */
public interface DivisionRepository extends JpaRepository<Division, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findDivisionBylientDivisionCode.
   *
   * @param   clientDivisionCode  String
   * @param   portfolioId         Long
   *
   * @return  Division
   */

  @Query("select  d from Division d where d.clientDivisionCode= ?1 and d.portfolio.portfolioId=?2")
  Division findDivisionByClientDivisionCode(String clientDivisionCode, Long portfolioId);

}
