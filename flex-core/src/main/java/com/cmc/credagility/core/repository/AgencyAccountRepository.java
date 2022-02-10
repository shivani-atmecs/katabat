package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.AssignmentTrace;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.credagility.core.domain.assignmentaction.AgencyAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 15:20
 */
@Repository public interface AgencyAccountRepository extends JpaRepository<AgencyAccount, Long> {

  /**
   * DOCUMENT ME!
   *
   * @param   accountNum  DOCUMENT ME!
   * @param   page       DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
      "select a from AssignmentTrace a where a.account.accountNum = ?1 order by a.createDate desc "
  )
  Page<AssignmentTrace> listAssignmentTracesByAccountNum(Long accountNum, Pageable page);

  //~ ------------------------------------------------------------------------------------------------------------------

}
