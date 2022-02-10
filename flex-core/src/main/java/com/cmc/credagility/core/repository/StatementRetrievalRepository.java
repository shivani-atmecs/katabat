package com.cmc.credagility.core.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.account.GeneralBalanceInfo;
import com.cmc.credagility.core.domain.transaction.TransactionData;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 17:27
 */
@Repository public interface StatementRetrievalRepository extends JpaRepository<TransactionData, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction data by account num.
   *
   * @param   accountNum  Long
   * @param   beforeDate  Date
   * @param   page        Pageable
   *
   * @return  Page
   */
  @Query("select t from TransactionData t where t.dateEffect > ?2 and t.account.accountNum = ?1 order by t.dateEffect desc")
  Page<TransactionData> findByAccountAccountNum(Long accountNum, Date beforeDate, Pageable page);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for general balance data.
   *
   * @param   transViewKey  String
   *
   * @return  List
   */
  @Query("select gbf from GeneralBalanceInfo gbf where gbf.transViewKey=?1")
  List<GeneralBalanceInfo> getGeneralBalanceData(String transViewKey);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction data.
   *
   * @param   transViewKey  String
   * @param   page          pageRequest Pageable
   *
   * @return  Page
   */
  @Query("select t from TransactionData t where t.transViewKey=?1")
  Page<TransactionData> getTransactionData(String transViewKey, Pageable page);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction data in accounts.
   *
   * @param   accountNums  List
   * @param   beforeDate   Date
   * @param   page         Pageable
   *
   * @return  Page
   */
  @Query(
    "select t from TransactionData t where  t.dateEffect > ?2 and t.account.accountNum in ?1 order by t.dateEffect desc"
  )
  Page<TransactionData> getTransactionDataInAccounts(List<Long> accountNums, Date beforeDate, Pageable page);
} // end interface StatementRetrievalRepository
