package com.cmc.credagiltiy.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ozstrategy.credagility.core.domain.StrategyMasterBatch;


@Repository
public interface StrategyMasterBatchRepository extends JpaRepository<StrategyMasterBatch, Long> {

    @Query(value = "SELECT smb.scheduleId FROM StrategyMasterBatch smb inner join `Schedule` sch on smb.scheduleId = sch.id WHERE smb.status='SUCCESS' AND smb.strategyReportType='STRATEGY' group by smb.portfolioId ORDER BY smb.startDate DESC", nativeQuery = true)
    List<Long> getActiveQueueScheduleIds();

}
