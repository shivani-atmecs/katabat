package com.cmc.credagiltiy.api.repository;

import com.cmc.credagility.core.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoRepository extends JpaRepository<Account, Long> {
    @Query("select a from Account a join fetch a.accountDetail d where a.accountNum = ?1")
    Account findAccountWithDetailByAccountNum(Long accountNum);


    @Query(value = "SELECT smb.scheduleId FROM StrategyMasterBatch smb inner join `Schedule` sch on smb.scheduleId = sch.id WHERE smb.status='SUCCESS' AND smb.strategyReportType='STRATEGY' group by smb.portfolioId ORDER BY smb.startDate DESC", nativeQuery = true)
    List<Long> testQuery();
}
