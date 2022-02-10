package com.cmc.credagility.core.repository;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.address.ZipcodeTimezone;
import com.cmc.credagility.core.domain.channel.EmailChannelResult;
import com.cmc.credagility.core.domain.channel.LetterChannelResult;
import com.cmc.credagility.core.domain.contact.ContactAddress;
import com.cmc.credagility.core.domain.contact.ContactEmail;
import com.cmc.credagility.core.domain.contact.ContactPhone;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.payment.PromiseToPay;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.webactivity.WebActivity;

import com.ozstrategy.credagility.core.domain.NodeStrategyResult;


/**
 * Created by rojer on 14-10-2.
 *
 * @author   Yang Wang
 * @version  $Revision$, $Date$
 */
@Repository public interface ResponsibleRepository extends JpaRepository<Responsible, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * countCustomerAllowWebAccounts.
   *
   * @param   customerId  Long
   *
   * @return  Long
   */
  @Query(
    "select count(distinct r.account.accountNum) from Responsible r where r.account.allowWeb=true and r.responsibleIndex.customer.customerId=?1"
  )
  Long countCustomerAllowWebAccounts(Long customerId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * countCustomerBorrowers.
   *
   * @param   customerId  Long
   *
   * @return  Long
   */
  @Query(
    "select count(distinct r.responsibleId) from Responsible r where r.account.active=true and r.account.clientDefinedFlag1=true and r.account.allowWeb=true and r.customerType in ('G') and r.responsibleIndex.customer.customerId=?1"
  )
  Long countCustomerBorrowers(Long customerId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * countCustomerBorrowers.
   *
   * @param   customerId   Long
   * @param   portfolioId  String
   *
   * @return  Long
   */
  @Query(
    "select count(distinct r.responsibleId) from Responsible r where r.account.active=true and r.account.clientDefinedFlag1=true and r.account.allowWeb=true and r.customerType in ('G') and r.responsibleIndex.customer.customerId=?1 and r.account.portfolio.portfolioId in (?2)"
  )
  Long countCustomerBorrowers(Long customerId, List<Long> portfolioId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByDateOfBirthAndResponsibleIndexLast4OriginalAccountNumber.
   *
   * @param   date                        Date
   * @param   last4OriginalAccountNumber  String
   *
   * @return  List
   */
  @Query(
    "select r from Responsible r where r.dateOfBirth =?1 and r.account.accountIndex.last4OriginalAccountNumber = ?2 and r.responsibleIndex.responsibleDeleteDate is NULL"
  )
  List<Responsible> findByDateOfBirthAndAccountAccountIndexLast4OriginalAccountNumber(Date date,
    String last4OriginalAccountNumber);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByDateOfBirthAndResponsibleIndexLast4OriginalAccountNumber.
   *
   * @param   date                        Date
   * @param   last4OriginalAccountNumber  String
   *
   * @return  List
   */
  @Query(
    "select r from Responsible r where r.dateOfBirth =?1 and r.responsibleExtensionChar.clientDefinedChar3 = ?2 and r.responsibleIndex.responsibleDeleteDate is NULL and r.account.active=true and r.account.allowWeb=true"
  )
  List<Responsible> findByDateOfBirthAndLast4ResponsibleExtentionCharClientDefinedChar3(Date date,
    String last4OriginalAccountNumber);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByFirstNameAndLastNameAndDateOfBirthAndLast4OriginalAccountNumber.
   *
   * @param   firstName                   String
   * @param   lastName                    String
   * @param   date                        Date
   * @param   last4OriginalAccountNumber  String
   *
   * @return  List
   */
  @Query(
    "select r from Responsible r where r.firstName = ?1 and r.lastName = ?2 and r.dateOfBirth =?3 and r.account.accountIndex.last4OriginalAccountNumber = ?4 and r.responsibleIndex.customer is not null and r.account.allowWeb=true and r.responsibleIndex.responsibleDeleteDate is NULL "
  )
  List<Responsible> findByFirstNameAndLastNameAndDateOfBirthAndLast4OriginalAccountNumber(String firstName,
    String lastName, Date date,
    String last4OriginalAccountNumber);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByFirstNameAndLastNameAndDateOfBirthAndLast4OriginalAccountNumberAndZipCode.
   *
   * @param   firstName                   String
   * @param   lastName                    String
   * @param   date                        Date
   * @param   last4OriginalAccountNumber  String
   * @param   zipCode                     String
   *
   * @return  List
   */
  @Query(
    "select r from Responsible r where r.firstName = ?1 and r.lastName = ?2 and r.dateOfBirth =?3 and r.account.accountIndex.last4OriginalAccountNumber = ?4 and r.zipCode = ?5 and r.responsibleIndex.customer is not null and r.account.allowWeb=true"
  )
  List<Responsible> findByFirstNameAndLastNameAndDateOfBirthAndLast4OriginalAccountNumberAndZipCode(String firstName,
    String lastName, Date date,
    String last4OriginalAccountNumber, String zipCode);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByFirstNameAndLastNameAndDateOfBirthAndLast4OriginalAccountNumber.
   *
   * @param   firstName  String
   * @param   lastName   String
   * @param   date       Date
   * @param   last4Ssn   String
   *
   * @return  List
   */
  @Query(
    "select r from Responsible r where r.firstName = ?1 and r.lastName = ?2 and r.dateOfBirth =?3 and r.last4Ssn = ?4 and r.account.allowWeb=true and r.responsibleIndex.responsibleDeleteDate is NULL "
  )
  List<Responsible> findByFirstNameAndLastNameAndDateOfBirthAndLast4Ssn(String firstName,
    String lastName, Date date,
    String last4Ssn);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByFirstNameAndLastNameAndDateOfBirthAndOriginalAccountNumberHashAndZipCode.
   *
   * @param   firstName                  String
   * @param   lastName                   String
   * @param   date                       Date
   * @param   originalAccountNumberHash  String
   * @param   zipCode                    String
   *
   * @return  List
   */
  @Query(
    "select r from Responsible r where r.firstName = ?1 and r.lastName = ?2 and r.dateOfBirth =?3 and r.account.accountIndex.originalAccountNumberHash = ?4 and r.zipCode = ?5 and r.responsibleIndex.customer is not null and r.account.allowWeb=true"
  )
  List<Responsible> findByFirstNameAndLastNameAndDateOfBirthAndOriginalAccountNumberHashAndZipCode(String firstName,
    String lastName, Date date,
    String originalAccountNumberHash, String zipCode);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   firstName                   DOCUMENT ME!
   * @param   lastName                    DOCUMENT ME!
   * @param   last4OriginalAccountNumber  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select r from Responsible r where r.firstName = ?1 and r.lastName = ?2 and r.account.accountIndex.last4OriginalAccountNumber = ?3 and r.responsibleIndex.customer is not null and r.account.allowWeb=true and r.responsibleIndex.responsibleDeleteDate is NULL "
  )
  List<Responsible> findByFirstNameAndLastNameAndLast4OriginalAccountNumber(String firstName,
    String lastName,
    String last4OriginalAccountNumber);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByOriginalAccountNumberHashAndPortfolio.
   *
   * @param   originalAccountNumberHash  String
   *
   * @return  List
   */
  @Query("select r from Responsible r where r.account.accountIndex.originalAccountNumberHash = ?1")
  List<Responsible> findByOriginalAccountNumberHash(String originalAccountNumberHash);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByOriginalAccountNumberHashAndCustomerUCIDAndDateOfBirth.
   *
   * @param   originalAccountNumberHash  String
   * @param   ucid                       String
   * @param   dateOfBirth                Date
   * @param   firstName                  String
   * @param   lastName                   String
   *
   * @return  List
   */
  @Query(
    "select r from Responsible r where r.account.accountIndex.originalAccountNumberHash = ?1 and r.responsibleIndex.customer.ucid = ?2 and r.dateOfBirth = ?3 and r.firstName = ?4 and r.lastName = ?5 and r.responsibleIndex.customer is not null and r.account.allowWeb=true"
  )
  List<Responsible> findByOriginalAccountNumberHashAndCustomerUCIDAndDateOfBirth(
    String originalAccountNumberHash, String ucid, Date dateOfBirth, String firstName, String lastName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByOriginalAccountNumberHashAndDateOfBirth.
   *
   * @param   originalAccountNumberHash  String
   * @param   dateOfBirth                Date
   *
   * @return  List
   */
  @Query(
    "select r from Responsible r where r.account.accountIndex.originalAccountNumberHash = ?1 and r.dateOfBirth = ?2 "
  )
  List<Responsible> findByOriginalAccountNumberHashAndDateOfBirth(String originalAccountNumberHash, Date dateOfBirth);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByOriginalAccountNumberHashAndPortfolioAndzipCodeAndDateOfBirth.
   *
   * @param   originalAccountNumberHash  String
   * @param   zip                        String
   * @param   dateOfBirth                Date
   *
   * @return  List
   */
  @Query(
    "select r from Responsible r where r.account.accountIndex.originalAccountNumberHash = ?1 and r.zipCode =?2 and r.dateOfBirth=?3"
  )
  List<Responsible> findByOriginalAccountNumberHashAndzipCodeAndDateOfBirth(
    String originalAccountNumberHash, String zip, Date dateOfBirth);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findCustomerByDateOfBirthAndCustomerUCIDAndOriginalAccountNumberHash.
   *
   * @param   originalAccountNumberHash  String
   * @param   ucid                       String
   * @param   dateOfBirth                Date
   * @param   firstName                  String
   * @param   lastName                   String
   *
   * @return  List
   */
  @Query(
    "select distinct r.responsibleIndex.customer from Responsible r where r.account.accountIndex.originalAccountNumberHash = ?1 and r.responsibleIndex.customer.ucid = ?2 and r.dateOfBirth = ?3 and r.firstName = ?4 and r.lastName = ?5 and r.responsibleIndex.customer is not null"
  )
  List<Customer> findCustomerByDateOfBirthAndCustomerUCIDAndOriginalAccountNumberHash(
    String originalAccountNumberHash, String ucid, Date dateOfBirth, String firstName, String lastName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findCustomerByFirstNameAndLastNameAndDateOfBirthAndLast4OriginalAccountNumber.
   *
   * @param   firstName                   String
   * @param   lastName                    String
   * @param   date                        Date
   * @param   last4OriginalAccountNumber  String
   *
   * @return  List
   */
  @Query(
    "select distinct r.responsibleIndex.customer from Responsible r where r.firstName = ?1 and r.lastName = ?2 and r.dateOfBirth =?3 and r.account.accountIndex.last4OriginalAccountNumber = ?4 and r.responsibleIndex.customer is not null and r.responsibleIndex.responsibleDeleteDate is NULL"
  )
  List<Customer> findCustomerByFirstNameAndLastNameAndDateOfBirthAndLast4OriginalAccountNumber(String firstName,
    String lastName, Date date, String last4OriginalAccountNumber);

  /**
   * findCustomerByFirstNameAndLastNameAndDateOfBirthAndLast4OriginalAccountNumber.
   *
   * @param   firstName                   String
   * @param   lastName                    String
   * @param   date                        Date
   * @param   last4Ssn  String
   *
   * @return  List
   */
  @Query(
          "select distinct r.responsibleIndex.customer from Responsible r where r.firstName = ?1 and r.lastName = ?2 and r.dateOfBirth =?3 and r.last4Ssn = ?4 and r.responsibleIndex.customer is not null and r.responsibleIndex.responsibleDeleteDate is NULL"
  )
  List<Customer> findCustomerByFirstNameAndLastNameAndDateOfBirthAndLast4Ssn(String firstName,                                                                                               String lastName, Date date, String last4Ssn);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findCustomerByFirstNameAndLastNameAndDateOfBirthAndLast4OriginalAccountNumberAndZipCode.
   *
   * @param   firstName                   String
   * @param   lastName                    String
   * @param   date                        Date
   * @param   last4OriginalAccountNumber  String
   * @param   zipCode                     String
   *
   * @return  List
   */
  @Query(
    "select distinct r.responsibleIndex.customer from Responsible r where r.firstName = ?1 and r.lastName = ?2 and r.dateOfBirth =?3 and r.account.accountIndex.last4OriginalAccountNumber = ?4 and r.zipCode = ?5 and r.responsibleIndex.customer is not null"
  )
  List<Customer> findCustomerByFirstNameAndLastNameAndDateOfBirthAndLast4OriginalAccountNumberAndZipCode(
    String firstName,
    String lastName, Date date, String last4OriginalAccountNumber, String zipCode);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findCustomerByFirstNameAndLastNameAndDateOfBirthAndOriginalAccountNumberHashAndZipCode.
   *
   * @param   firstName                  String
   * @param   lastName                   String
   * @param   date                       Date
   * @param   originalAccountNumberHash  String
   * @param   zipCode                    String
   *
   * @return  List
   */
  @Query(
    "select distinct r.responsibleIndex.customer from Responsible r where r.firstName = ?1 and r.lastName = ?2 and r.dateOfBirth =?3 and r.account.accountIndex.originalAccountNumberHash = ?4 and r.zipCode = ?5 and r.responsibleIndex.customer is not null"
  )
  List<Customer> findCustomerByFirstNameAndLastNameAndDateOfBirthAndOriginalAccountNumberHashAndZipCode(
    String firstName,
    String lastName, Date date, String originalAccountNumberHash, String zipCode);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   firstName                   DOCUMENT ME!
   * @param   lastName                    DOCUMENT ME!
   * @param   last4OriginalAccountNumber  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select distinct r.responsibleIndex.customer from Responsible r where r.firstName = ?1 and r.lastName = ?2 and r.account.accountIndex.last4OriginalAccountNumber = ?3 and r.responsibleIndex.customer is not null and r.responsibleIndex.responsibleDeleteDate is NULL"
  )
  List<Customer> findCustomerByFirstNameAndLastNameAndLast4OriginalAccountNumber(String firstName,
    String lastName, String last4OriginalAccountNumber);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * get responsible by ssn.
   *
   * @param   ssn  String
   *
   * @return  Responsible
   */
  @Query(
    "select r from Responsible r where r.responsibleIndex.ssnHash = ?1 and (r.responsibleIndex.deleted is null or r.responsibleIndex.deleted=false)"
  )
  Responsible findFirstByResponsibleIndexSsnHash(String ssn);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findFirstByUserLogon.
   *
   * @param   userLogon  String
   *
   * @return  Responsible
   */
  Responsible findFirstByUserLogon(String userLogon);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findResponsibleByName.
   *
   * @param   firstName  String
   * @param   lastName   String
   *
   * @return  List
   */
  @Query("select r from Responsible r where r.firstName like ?1 and r.lastName like ?2")
  List<Responsible> findResponsibleByName(String firstName, String lastName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   oanHash  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select r from Responsible r where r.account.accountIndex.originalAccountNumberHash = ?1 and (r.responsibleIndex.deleted is null or r.responsibleIndex.deleted=false)"
  )
  List<Responsible> findResponsibleByOANHash(String oanHash);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   responsibleIdentificationNumberHash  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select r from Responsible r where r.responsibleIndex.responsibleIdentificationNumberHash = ?1 and (r.responsibleIndex.deleted is null or r.responsibleIndex.deleted=false)"
  )
  List<Responsible> findResponsibleByResponsibleIndexResponsibleIdentificationNumberHash(
    String responsibleIdentificationNumberHash);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * get responsible by ssn.
   *
   * @param   ssn  String
   *
   * @return  Responsible
   */
  @Query(
    "select r from Responsible r where r.responsibleIndex.ssnHash = ?1 and (r.responsibleIndex.deleted is null or r.responsibleIndex.deleted=false)"
  )
  List<Responsible> findResponsibleByResponsibleIndexSsnHash(String ssn);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findResponsibleByUserLogon.
   *
   * @param   userLogon  String
   *
   * @return  List
   */
  @Query("select r from Responsible r where r.userLogon like ?1")
  List<Responsible> findResponsibleByUserLogon(String userLogon);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   responsibleId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query("select r.account from Responsible r where r.responsibleId=?1")
  Account getAccount(Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account by user logon.
   *
   * @param   userLogon  String
   *
   * @return  Account
   */
  @Query("select r.account from Responsible r where r.userLogon=?1")
  Account getAccountByUserLogon(String userLogon);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * get <b>Customer#currentCustomerId</b>'s accounts which have relationship between <b>Customer#loginCustomerId.</b>
   *
   * @param   currentCustomerId  Long
   * @param   loginCustomerId    Long
   *
   * @return  List
   */
  @Query(
    "select r.responsibleId, r.account.accountNum from Responsible r where r.responsibleIndex.customer.customerId = ?1 and r.account.accountNum in (select r1.account from Responsible r1 where r1.responsibleIndex.customer.customerId = ?2 and r1.account.active=true and r1.account.clientDefinedFlag1=true and r1.account.allowWeb=true) and r.account.active=true and r.account.clientDefinedFlag1=true and r.account.allowWeb=true"
  )
  List<Long[]> getAccountNumbers(Long currentCustomerId, Long loginCustomerId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * get <b>Customer#currentCustomerId</b>'s accounts which have relationship between <b>Customer#loginCustomerId.</b>
   *
   * @param   currentCustomerId  Long
   * @param   loginCustomerId    Long
   * @param   portfolioIds       List
   *
   * @return  List
   */
  @Query(
    "select r.responsibleId, r.account.accountNum from Responsible r where r.responsibleIndex.customer.customerId = ?1 and r.account.accountNum in (select r1.account from Responsible r1 where r1.responsibleIndex.customer.customerId = ?2 and r1.account.active=true and r1.account.clientDefinedFlag1=true and r1.account.allowWeb=true) and r.account.active=true and r.account.clientDefinedFlag1=true and r.account.allowWeb=true and r.account.portfolio.portfolioId in (?3)"
  )
  List<Long[]> getAccountNumbers(Long currentCustomerId, Long loginCustomerId, List<Long> portfolioIds);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for active allow web responsibles by customer id.
   *
   * @param   loggedCustomerId  Long
   *
   * @return  List
   */
  @Query(
    "SELECT distinct r FROM Responsible r WHERE r.account.active = true and r.account.allowWeb = true and r.responsibleIndex.customer.customerId = ?1 order by r.account.portfolio.portfolioId"
  )
  List<Responsible> getActiveAllowWebResponsiblesByCustomerId(Long loggedCustomerId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for addresses.
   *
   * @param   responsibleId  Long
   *
   * @return  List
   */
  @Query(
    "select r from ContactAddress r where r.responsible.responsibleId = ?1 and (r.historical is null or r.historical=false)"
  )
  List<ContactAddress> getAddresses(Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow web responsibles by customer id.
   *
   * @param   loggedCustomerId  Long
   *
   * @return  List
   */
  @Query(
    "SELECT distinct r FROM Responsible r WHERE r.account.allowWeb = true and r.responsibleIndex.customer.customerId = ?1 order by r.account.portfolio.portfolioId"
  )
  List<Responsible> getAllowWebResponsiblesByCustomerId(Long loggedCustomerId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ATPRequest responsible.
   *
   * @return  List
   */
  @Query(
    "SELECT distinct r.responsible.responsibleId FROM BureauDataRequest r LEFT JOIN r.bureauRequestType t WHERE t.name='ATP' AND (r.status='INIT' OR r.status='SUCCESS') "
  )
  List<Long> getATPRequestResponsible();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ATPRequest responsible.
   *
   * @param   responsibleId  Long
   *
   * @return  List
   */
  @Query(
    "SELECT distinct r.responsible.responsibleId FROM BureauDataRequest r LEFT JOIN r.bureauRequestType t WHERE t.name='ATP' AND r.responsible.responsibleId=?1  AND (r.status='INIT' OR r.status='SUCCESS') "
  )
  List<Long> getATPRequestResponsible(Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   responsibleId  DOCUMENT ME!
   * @param   typeId         DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select c from ContactAddress c where c.responsible.responsibleId=?1 and c.addressType.id=?2 and (c.historical is null or c.historical = false)"
  )
  ContactAddress getContactAddress(Long responsibleId, Long typeId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   responsibleId  DOCUMENT ME!
   * @param   typeId         DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select c from ContactEmail c where c.responsible.responsibleId=?1 and c.emailType.id=?2 and (c.historical is null or c.historical = false)"
  )
  ContactEmail getContactEmail(Long responsibleId, Long typeId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   responsibleId  DOCUMENT ME!
   * @param   typeId         DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select c from ContactPhone c where c.responsible.responsibleId=?1 and c.phoneType.id=?2 and (c.historical is null or c.historical = false)"
  )
  ContactPhone getContactPhone(Long responsibleId, Long typeId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cosigner borrower.
   *
   * @param   responsibleId  Long
   *
   * @return  List
   */
  @Query(
    "select r from Responsible r where r.customerType='P' and r.account.active=true and r.account.clientDefinedFlag1=true and r.account.allowWeb=true and r.account in (select distinct r1.account from Responsible r1, Responsible r2 where r1.responsibleIndex.customer.customerId=r2.responsibleIndex.customer.customerId and r2.responsibleId=?1 and r1.account.active=true and r1.account.clientDefinedFlag1=true and r1.account.allowWeb=true and r1.customerType in ('P','G')) group by r.responsibleIndex.customer.customerId order by r.account.accountDetail.clientDefinedDate1"
  )
  List<Responsible> getCosignerBorrower(Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cosigner borrower.
   *
   * @param   responsibleId  Long
   * @param   portfolioId    responsibleId String
   *
   * @return  List
   */
  @Query(
    "select r from Responsible r where r.customerType='P' and r.account.active=true and r.account.clientDefinedFlag1=true and r.account.allowWeb=true and r.account in (select distinct r1.account from Responsible r1, Responsible r2 where r1.responsibleIndex.customer.customerId=r2.responsibleIndex.customer.customerId and r2.responsibleId=?1 and r1.account.active=true and r1.account.clientDefinedFlag1=true and r1.account.allowWeb=true and r1.account.portfolio.portfolioId in (?2) and r1.customerType in ('P','G')) group by r.responsibleIndex.customer.customerId order by r.account.accountDetail.clientDefinedDate1"
  )
  List<Responsible> getCosignerBorrower(Long responsibleId, List<Long> portfolioId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer accounts balance.
   *
   * @param   responsibleId  Long
   *
   * @return  BigDecimal
   */
  @Query(
    "SELECT ri.responsible.account.balance FROM ResponsibleIndex ri WHERE ri.responsible.account.active = true AND ri.customer.customerId = (SELECT ri.customer.customerId FROM ResponsibleIndex ri WHERE ri.responsible.responsibleId = ?1) "
  )
  List<BigDecimal> getCustomerAccountsBalances(Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for emails.
   *
   * @param   responsibleId  Long
   *
   * @return  List
   */
  @Query(
    "select r from ContactEmail r where r.responsible.responsibleId = ?1 and (r.historical is null or r.historical=false)"
  )
  List<ContactEmail> getEmails(Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   responsibleId  DOCUMENT ME!
   * @param   template       DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select e from EmailChannelResult e where e.responsible.responsibleId=?1 and status = 'EXPORTED' and template=?2 order by exportDate desc"
  )
  List<EmailChannelResult> getLastExportedEmailChannelByTemplate(Long responsibleId, String template);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last promise to pay.
   *
   * @param   accountNum  Long
   * @param   ptpStatus   String
   *
   * @return  List
   */
  @Query(
    "SELECT ptp FROM PromiseToPay ptp WHERE ptp.account.accountNum = ?1 AND ptp.ptpStatus = ?2 ORDER BY ABS(DATEDIFF(ptp.arrivalDate, current_date)) ASC, ptp.createDate DESC "
  )
  List<PromiseToPay> getLastPromiseToPay(Long accountNum, String ptpStatus);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   responsibleId  DOCUMENT ME!
   * @param   activityName   DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query("select w from WebActivity w where w.responsible.responsibleId=?1 and name=?2 order by createDate desc")
  List<WebActivity> getLastWebActivityByName(Long responsibleId, String activityName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter channel results.
   *
   * @param   responsibleId  Long
   *
   * @return  List
   */
  @Query(
    "select l from LetterChannelResult l where l.responsible.responsibleId=?1 and l.status in ('INIT','SKIPPED','EXPORTED') order by l.strategyDate DESC,l.letterResultId DESC "
  )
  List<LetterChannelResult> getLetterChannelResults(Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phones.
   *
   * @param   responsibleId  Long
   *
   * @return  List
   */
  @Query(
    "select r from ContactPhone r where r.responsible.responsibleId = ?1 and (r.historical is null or r.historical=false)"
  )
  List<ContactPhone> getPhones(Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   responsibleId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query("select r.account.portfolio from Responsible r where r.responsibleId=?1")
  Portfolio getPortfolio(Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program node strategy results.
   *
   * @param   responsibleId  Long
   *
   * @return  List
   */
  @Query(
    "select distinct nsr from NodeStrategyResult nsr, Responsible r where nsr.account = r.account and nsr.programAction = true and r.responsibleId = ?1 order by nsr.createDate DESC"
  )
  List<NodeStrategyResult> getProgramNodeStrategyResults(Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for resides node names.
   *
   * @param   responsibleId  Long
   *
   * @return  List
   */
  @Query(
    "SELECT r.node.name FROM NodeStrategyResult r  WHERE r.responsible.responsibleId = ?1 GROUP BY r.account.accountNum, r.node.name ORDER BY r.createDate "
  )
  List<String> getResidesNodeNames(Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for resides queue names.
   *
   * @param   accountNum  Long
   *
   * @return  List
   */
  @Query(
    "SELECT qa.queueAction.name FROM QueueAccount qa WHERE qa.account.accountNum = ?1  GROUP BY qa.account.accountNum, qa.queueAction.name ORDER BY qa.createDate "
  )
  List<String> getResidesQueueNames(Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   ssn          DOCUMENT ME!
   * @param   accountNum   DOCUMENT ME!
   * @param   dateOfBirth  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select distinct r1 from Responsible r1 where r1.responsibleIndex.ssnHash=?1 and r1.account.accountNum=?2 and r1.dateOfBirth=?3"
  )
  Responsible getResponsible(String ssn, Long accountNum, Date dateOfBirth);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   userLogon    DOCUMENT ME!
   * @param   ssn          DOCUMENT ME!
   * @param   accountNum   DOCUMENT ME!
   * @param   dateOfBirth  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select distinct r1 from Responsible r1 where r1.userLogon=?1 and r1.responsibleIndex.ssnHash=?2 and r1.account.accountNum=?3 and r1.dateOfBirth=?4"
  )
  Responsible getResponsible(String userLogon, String ssn, Long accountNum, Date dateOfBirth);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible by customer id order by priorityScore.
   *
   * @param   customerId  Long
   *
   * @return  List
   */
  @Query(
    value =
      "select r from Responsible r WHERE r.responsibleIndex.customer.customerId=?1 ORDER BY r.account.accountIndex.priorityScore DESC"
  )
  List<Responsible> getResponsibleByCustomerIdOrderByPriority(Long customerId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   last4AcctNum  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select r from Responsible r where r.account.accountIndex.last4OriginalAccountNumber=?1  and (r.responsibleIndex.deleted is null or r.responsibleIndex.deleted=false)"
  )
  List<Responsible> getResponsibleByLast4AcctNum(String last4AcctNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   last4SSN  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select r from Responsible r where r.last4Ssn=?1  and (r.responsibleIndex.deleted is null or r.responsibleIndex.deleted=false)"
  )
  List<Responsible> getResponsibleByLast4SSN(String last4SSN);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   originalAccountNumber  DOCUMENT ME!
   * @param   ucid                   DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select distinct r from Responsible r where r.account.originalAccountNumber=?1 and r.responsibleIndex.customer.ucid=?2"
  )
  Responsible getResponsibleByOriginalAccountNumberAndUcid(String originalAccountNumber, String ucid);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible by ssn and portfolio id.
   *
   * @param   ssn          String
   * @param   portfolioId  Long
   *
   * @return  Responsible
   */
  @Query(
    "select distinct r1 from Responsible r1 where r1.responsibleIndex.ssnHash=?1 and r1.account.portfolio.portfolioId=?2"
  )
  Responsible getResponsibleBySsnAndPortfolioId(String ssn, Long portfolioId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible id by logon.
   *
   * @param   principal  String
   *
   * @return  String
   */
  @Query("select distinct r.responsibleId from Responsible r left join r.phones where r.userLogon=?1")
  String getResponsibleIdByLogon(String principal);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   accountNum  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query("select distinct r from Responsible r where r.account.accountNum=?1")
  List<Responsible> getResponsibleListByAccountNum(Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible list by ssn.
   *
   * @param   ssn  String
   *
   * @return  List
   */
  @Query("select distinct r from Responsible r where r.responsibleIndex.ssnHash=?1")
  List<Responsible> getResponsibleListBySsn(String ssn);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible list by ssn and portfolio id.
   *
   * @param   ssn          String
   * @param   portfolioId  Long
   *
   * @return  List
   */
  @Query(
    "select distinct r from Responsible r where r.responsibleIndex.ssnHash=?1 and r.account.portfolio.portfolioId=?2"
  )
  List<Responsible> getResponsibleListBySsnAndPortfolioId(String ssn, Long portfolioId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsibles by customer id.
   *
   * @param   loggedCustomerId  Long
   *
   * @return  List
   */
  @Query(
    "SELECT distinct r FROM Responsible r WHERE  r.responsibleIndex.customer.customerId = ?1 order by r.account.portfolio.portfolioId"
  )
  List<Responsible> getResponsiblesByCustomerId(Long loggedCustomerId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   loginCustomerId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query("select distinct r from Responsible r where r.responsibleIndex.customer.customerId = ?1")
  List<Responsible> getResponsiblesByLoggedCustomer(Long loginCustomerId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsibles by PCAReferenceId and PIN.
   *
   * @param   PCAReferenceId  String
   * @param   Pin             String
   *
   * @return  List
   */

  @Query(
    "select distinct r from ResponsibleExtensionChar rc left join rc.responsible r where rc.clientDefinedChar2=?1 and r.account.clientDefined4CharCode2=?2"
  )
  List<Responsible> getResponsiblesByPCAReferenceIdAndPin(String PCAReferenceId, String Pin);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsibles by PCUReferenceId and PIN.
   *
   * @param   PCAReferenceId  String
   * @param   Pin             String
   *
   * @return  List
   */

  @Query(
    "select distinct r from ResponsibleExtensionChar rc left join rc.responsible r where rc.clientDefinedChar2=?1 and r.account.clientDefined4CharCode2=?2"
  )
  List<Responsible> getResponsiblesByPCUReferenceIdAndPin(String PCAReferenceId, String Pin);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *

   * @param   date       DOCUMENT ME!
   * @param   last4Ssn   DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
          "select r from Responsible r where r.firstName = ?1 and r.lastName = ?2 and r.dateOfBirth =?3 and r.last4Ssn = ?4 and r.responsibleIndex.customer is not null and r.account.allowWeb=true and r.responsibleIndex.responsibleDeleteDate is NULL "
  )
  List<Responsible> findByDateOfBirthAndLast4Ssn(String firstName,String lastName,Date date,String last4Ssn);

  /**
   * DOCUMENT ME!
   *
   * @param   last4Ssn     DOCUMENT ME!
   * @param   zip          DOCUMENT ME!
   * @param   last4ActNum  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */


  @Query(
    "select r from Responsible r where r.zipCode = ?2 and r.last4Ssn =?1 and r.account.clientDefined4CharCode1 = ?3"
  )
  List<Responsible> getResposiblesByUPCCredentials(String last4Ssn, String zip, String last4ActNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   last4Ssn     DOCUMENT ME!
   * @param   zip          DOCUMENT ME!
   * @param   last4ActNum  DOCUMENT ME!
   * @param   lastName     DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */

  @Query(
    "select r from Responsible r where r.zipCode = ?2 and r.lastName = ?4 and r.last4Ssn =?1 and r.account.clientDefined4CharCode1 = ?3"
  )
  List<Responsible> getResposiblesByUPCCredentialsPlusLastName(String last4Ssn, String zip, String last4ActNum,
    String lastName);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user logon by responsible index customer customer id.
   *
   * @param   customerId  Long
   *
   * @return  List
   */
  @Query("select r.userLogon from Responsible r where r.responsibleIndex.customer.customerId=?1")
  List<String> getUserLogonByResponsibleIndexCustomerCustomerId(Long customerId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for zipcode time zone by zip code.
   *
   * @param   zipCode  String
   *
   * @return  List
   */
  @Query("SELECT  z From ZipcodeTimezone z where z.zipcode = ?1")
  List<ZipcodeTimezone> getZipcodeTimeZoneByZipCode(String zipCode);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasAppointmentWithShareAccount.
   *
   * @param   appointmentId  Long
   * @param   userLogon      String
   *
   * @return  List
   */
  @Query(
    value =
      "select a.appointmentId from AdvisorAppointment a, Responsible r where r.account = a.account and a.appointmentId=?1 and r.userLogon=?2"
  )
  List<Long> hasAppointmentWithShareAccount(Long appointmentId, String userLogon);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasPaymentWithShareAccount.
   *
   * @param   paymentId  Long
   * @param   userLogon  String
   *
   * @return  List
   */
  @Query(
    value =
      "select p.paymentId from Payment p, Responsible r where r.account = p.account and p.paymentId=?1 and r.userLogon=?2"
  )
  List<Long> hasPaymentWithShareAccount(Long paymentId, String userLogon);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasProgramWithShareAccount.
   *
   * @param   programId  Long
   * @param   userLogon  String
   *
   * @return  List
   */
  @Query(
    value =
      "select p.programId from PaymentProgram p, Responsible r where r.account = p.account and p.programId=?1 and r.userLogon=?2"
  )
  List<Long> hasProgramWithShareAccount(Long programId, String userLogon);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   currentResponsibleId  DOCUMENT ME!
   * @param   accountNum            DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query(
    "select distinct r1 from Responsible r1, Responsible r2 where r1.customerType='G' and r1.responsibleIndex.customer.customerId=r2.responsibleIndex.customer.customerId and r2.responsibleId=?1 and r1.account.accountNum=?2"
  )
  List<Responsible> listAccountCosignersByResponsible(Long currentResponsibleId, Long accountNum);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listCustomerBorrowers.
   *
   * @param   cosignedResponsibleId  Long
   *
   * @return  List
   */
  @Query(
    "select distinct r1 from Responsible r1, Responsible r2 where r1.customerType = 'P' and r1.responsibleIndex.customer.customerId=r2.responsibleIndex.customer.customerId and r2.responsibleId=?1 and r1.account.active=true and r1.account.clientDefinedFlag1=true and r1.account.allowWeb=true order by r1.account.portfolio.portfolioId asc"
  )
  List<Responsible> listCustomerAllBorrowers(Long cosignedResponsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listCustomerBorrowers.
   *
   * @param   cosignedResponsibleId  Long
   * @param   portfolioId            String
   *
   * @return  List
   */
  @Query(
    "select distinct r1 from Responsible r1, Responsible r2 where r1.customerType = 'P' and r1.responsibleIndex.customer.customerId=r2.responsibleIndex.customer.customerId and r2.responsibleId=?1 and r1.account.active=true and r1.account.clientDefinedFlag1=true and r1.account.allowWeb=true and r1.account.portfolio.portfolioId in (?2)"
  )
  List<Responsible> listCustomerAllBorrowers(Long cosignedResponsibleId, List<Long> portfolioId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listCustomerAllBorrowersAndCosigners.
   *
   * @param   cosignedResponsibleId  Long
   *
   * @return  List
   */
  @Query(
    "select distinct r1 from Responsible r1, Responsible r2 where r1.customerType in ('P', 'G') and r1.responsibleIndex.customer.customerId=r2.responsibleIndex.customer.customerId and r2.responsibleId=?1 and r1.account.active=true and r1.account.clientDefinedFlag1=true and r1.account.allowWeb=true"
  )
  List<Responsible> listCustomerAllBorrowersAndCosigners(Long cosignedResponsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * listCustomerAllBorrowersAndCosigners.
   *
   * @param   cosignedResponsibleId  Long
   * @param   portfolioList          List
   *
   * @return  List
   */
  @Query(
    "select distinct r1 from Responsible r1, Responsible r2 where r1.customerType in ('P', 'G') and r1.responsibleIndex.customer.customerId=r2.responsibleIndex.customer.customerId and r2.responsibleId=?1 and r1.account.active=true and r1.account.clientDefinedFlag1=true and r1.account.allowWeb=true and r1.account.portfolio.portfolioId in (?2)"
  )
  List<Responsible> listCustomerAllBorrowersAndCosigners(Long cosignedResponsibleId, List<Long> portfolioList);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * 1. find out the customer (responsible.responsibleIndex.customer); 2. list all responsible's account who's belonged
   * to this customer; 3. list all accounts' primary responsible
   *
   * @param   responsibleId  DOCUMENT ME!
   *
   * @return  1.
   */
  // @Query("select r1.account.accountNum from Responsible r1, Responsible r2 where r1.responsibleIndex.customer.customerId=r2.responsibleIndex.customer.customerId and r2.responsibleId=?1 and r1.primaryHolder=true")
  @Query(
    "select distinct r from Responsible r where r.account.accountNum in (select r1.account.accountNum from Responsible r1, Responsible r2 where r1.responsibleIndex.customer.customerId=r2.responsibleIndex.customer.customerId and r2.responsibleId=?1) and r.primaryHolder=true and r.account.active=true and r.account.clientDefinedFlag1=true and r.account.allowWeb=true group by r.responsibleIndex.customer.customerId order by r.account.accountDetail.clientDefinedDate1"
  )
  List<Responsible> listCustomersAccountPResponsibleByResponsible(Long responsibleId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   responsibleId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Query("select r from Responsible r left join r.phones where r.responsibleId=?1")
  Responsible preFetchResponsible(Long responsibleId);

  Responsible findByUserLogon(String userLogon);
} // end interface ResponsibleRepository
