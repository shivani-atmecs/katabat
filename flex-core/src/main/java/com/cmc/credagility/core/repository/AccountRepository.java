package com.cmc.credagility.core.repository;

import java.util.List;

import com.cmc.credagility.core.domain.account.AccountAudit;
import com.cmc.credagility.core.domain.customer.CustomLoanProgramCalculateResult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.account.AccountFlowVariableValue;
import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * Created by rojer on 14-10-2.
 *
 * @author   Yang Wang
 * @version  $Revision$, $Date$
 */
@Repository public interface AccountRepository extends CrudRepository<Account, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account by original account number.
   *
   * @param   originalAccountNumber  String
   * @param   portfolioId            Long
   *
   * @return  Account
   */
  @Query("select a from Account a where a.originalAccountNumber =?1 and a.portfolio.portfolioId =?2 ")
  Account getAccountByOriginalAccountNumber(String originalAccountNumber, Long portfolioId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account by original account number hash.
   *
   * @param   originalAccountNumberHash  String
   * @param   portfolioId                Long
   *
   * @return  Account
   */
  @Query("select a from Account a where a.accountIndex.originalAccountNumberHash =?1 and a.portfolio.portfolioId =?2 ")
  Account getAccountByOriginalAccountNumberHash(String originalAccountNumberHash, Long portfolioId);

  @Query("select a from Account a where a.accountIndex.originalAccountNumberHash =?1 ")
  Account getAccountByOriginalAccountNumber(String originalAccountNumberHash);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account by original account number hash.
   *
   * @param   last4OriginalAccountNumber  String
   * @param   portfolioId                Long
   *
   * @return  List
   */
  @Query("select a from Account a where a.accountIndex.last4OriginalAccountNumber =?1 and a.portfolio.portfolioId =?2 ")
  List<Account> getAccountByLast4OriginalAccountNumber(String last4OriginalAccountNumber, Long portfolioId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account flow variable value.
   *
   * @param   accountNum  Long
   * @param   variableId  Long
   *
   * @return  List
   */
  @Query(
    "select val from AccountFlowVariableValue val left join fetch val.variable left join fetch val.surveyFlowStep where val.account.accountNum=?1 and val.variable.id =?2 order by val.createDate desc, val.id desc"
  )
  List<AccountFlowVariableValue> getAccountFlowVariableValue(Long accountNum, Long variableId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last account audit.
   *
   * @param   accountNum  Long
   *
   * @return  List
   */
  @Query("select aa from AccountAudit aa where aa.account.accountNum=:accountNum order by aa.lastUpdateDate desc")
  List<AccountAudit> getLastAccountAudit(Long accountNum);
  
  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for FLXAccount by SSOKey.
   *
   * @param   ssoKey  String
   *
   * @return  List
   */
  @Query("select a from Account a where a.accountIndex.originalAccountNumberHash=?1 ")
  List<Account> getFLXAccountBySSOKey(String ssoKey);


  /**
   * SMW-2320
   * @param customerId
   * @return
   */
  @Query("select CLPR from CustomLoanProgramCalculateResult CLPR where CLPR.customer.customerId=?1 order by CLPR.createDate desc")
  public CustomLoanProgramCalculateResult getLastSMWLoanProgramCalculate(Long customerId);

} // end interface AccountRepository
