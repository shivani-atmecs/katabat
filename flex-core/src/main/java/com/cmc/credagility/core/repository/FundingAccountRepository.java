package com.cmc.credagility.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.payment.FundingAccount;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 15:32
 */
@Repository public interface FundingAccountRepository extends JpaRepository<FundingAccount, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding account.
   *
   * @param   fundingAccountId  Long
   *
   * @return  FundingAccount
   */
  @Query("select f from FundingAccount f where f.fundingAccountId=?1")
  FundingAccount getFundingAccount(Long fundingAccountId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for funding account by account num.
   *
   * @param   fundingAccountNum  String
   *
   * @return  List
   */
  @Query("select f from FundingAccount f where f.fundingInformation.fundingAccountNum=?1")
  List<FundingAccount> getFundingAccountByAccountNum(String fundingAccountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   fundingAccountReference  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query("select f from FundingAccount f where f.externalReferenceNumber=?1")
  FundingAccount getFundingAccountByExternalRefNumber(String fundingAccountReference);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   fundingAccountReference  DOCUMENT ME!
   * @param   responsibleId            DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query("select f from FundingAccount f where f.externalReferenceNumber=?1 and f.responsible.responsibleId=?2")
  FundingAccount getFundingAccountByResponsibleAndRefNum(String fundingAccountReference, Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listFundingAccountByAccount.
   *
   * @param   accountNum  Long
   *
   * @return  List
   */
  @Query("select fdc from FundingAccount fdc where fdc.responsible.account.accountNum=?1")
  List<FundingAccount> listFundingAccountByAccount(Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listFundingAccountByCustomer.
   *
   * @param   customerId  Long
   *
   * @return  List
   */
  @Query("select fdc from FundingAccount fdc where fdc.customer.customerId=?1 order by fdc.customerDefault DESC")
  List<FundingAccount> listFundingAccountByCustomer(Long customerId);


} // end interface FundingAccountRepository
