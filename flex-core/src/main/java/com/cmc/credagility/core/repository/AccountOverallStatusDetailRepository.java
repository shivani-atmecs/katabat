package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.credagility.core.domain.account.AccountOverallStatusDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 15:16
 */
@Repository
public interface AccountOverallStatusDetailRepository extends JpaRepository<AccountOverallStatusDetail, Long> {
  
  @Query("select a from AccountOverallStatusDetail a where a.statusCode = ?1")
  List<AccountOverallStatusDetail> getAccountOverallStatusDetails(String code);

  AccountOverallStatusDetail findFirstByStatusCode(String statusCode);
}
