package com.cmc.credagility.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.account.AccountScore;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 15:17
 */
public interface AccountScoreRepository extends JpaRepository<AccountScore, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account score.
   *
   * @param   accountNum  Long
   * @param   scoreName   String
   *
   * @return  List
   */
  @Query("select a from AccountScore a where a.account.accountNum = ?1 and a.scoreType.scoreName = ?2")
  List<AccountScore> getAccountScore(Long accountNum, String scoreName);
}
