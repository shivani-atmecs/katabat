package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.activity.AgentCallActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 15:37
 */
public interface AgentCallActivityRepository extends JpaRepository<AgentCallActivity, Long> {


  /**
   * getter method for Latest AgentCallActivity
   *
   * @param accountNum Long
   * @return
   */
  @Query("select a From AgentCallActivity a where a.account.accountNum =:accountNum ORDER BY a.createDate DESC")
  List<AgentCallActivity> getLatestAgentCallActivityByAccount(Long accountNum);

}
