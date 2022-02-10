package com.cmc.credagility.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.account.GeneralBalanceInfo;
import com.cmc.credagility.core.domain.transaction.TransactionData;

import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/31/2014 17:03
 */
public interface TransactionDataRepository extends JpaRepository<TransactionData, Long> {

  /**
   * getter method for general balance data.
   *
   * @param transViewKey String
   * @return List
   */
  @Query("select gbf from GeneralBalanceInfo gbf where gbf.transViewKey=?1")
  List<GeneralBalanceInfo> getGeneralBalanceData(String transViewKey);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction data.
   *
   * @param transViewKey String
   * @param page         pageRequest Pageable
   * @return Page
   */
  @Query("select t from TransactionData t where t.transViewKey=?1")
  Page<TransactionData> getTransactionData(String transViewKey, Pageable page);

  @Query("select t from TransactionData t where t.account.accountNum=?1")
  Page<TransactionData> getTransactionDataByAccountNum(Long accountNum, Pageable page);

  @Query("select COUNT(t.transactionId) from TransactionData t where t.account.accountNum=?1")
  Long countTransactionDataByAccountNum(Long accountNum);
}
