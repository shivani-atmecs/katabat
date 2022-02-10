package com.cmc.credagility.core.repository;


import java.util.List;

import com.cmc.credagility.core.domain.responsible.ResponsibleIndex;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.cmc.credagility.core.domain.customer.Customer;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 16:26
 */
@Repository public interface CustomerRepository extends CrudRepository<Customer, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findFirstByUcid.
   *
   * @param   ucid  String
   *
   * @return  Customer
   */
  Customer findFirstByUcid(String ucid);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer by place of birth.
   *
   * @param   placeOfBirth  String
   * @param   dateOfBirth   Date
   *
   * @return  List
   */
  @Query(
    value       =
      "select c.* from Customer c where c.placeOfBirth=:placeOfBirth and DATE_FORMAT(c.dateOfBirth ,'%d/%m/%Y')=:dateOfBirth",
    nativeQuery = true
  )
  List<Customer> getCustomerByPlaceOfBirth(@Param("placeOfBirth") String placeOfBirth,
    @Param("dateOfBirth") String dateOfBirth);

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * getter method for responsible index by customer id.
   *
   * @param   customerId  Long
   *
   * @return  List
   */
  @Query(value = "select r from ResponsibleIndex r WHERE r.customer.customerId=?1")
  List<ResponsibleIndex> getResponsibleIndexByCustomerId(Long customerId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer by UCID.
   *
   * @param   ucId  String
   *
   * @return  Customer
   */
  @Query("FROM Customer c where c.ucid=?1")
  Customer getCustomerByUCID(String ucId);

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * hasAppointmentWithShareAccount.
   *
   * @param   appointmentId  Long
   * @param   customerId     Long
   *
   * @return  List
   */
  @Query(
    value =
      "select a.appointmentId from AdvisorAppointment a, Customer c left join c.responsibleIndexs ri left join ri.responsible r where r.account = a.account and c.customerId=?2 and a.appointmentId=?1"
  )
  List<Long> hasAppointmentWithShareAccount(Long appointmentId, Long customerId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasPaymentWithShareAccount.
   *
   * @param   paymentId   Long
   * @param   customerId  Long
   *
   * @return  List
   */
  @Query(
    value =
      "select p.paymentId from Payment p, Customer c left join c.responsibleIndexs ri left join ri.responsible r where r.account = p.account and c.customerId=?2 and p.paymentId=?1"
  )
  List<Long> hasPaymentWithShareAccount(Long paymentId, Long customerId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasProgramWithShareAccount.
   *
   * @param   programId   Long
   * @param   customerId  Long
   *
   * @return  List
   */
  @Query(
    value =
      "select p.programId from PaymentProgram p, Customer c left join c.responsibleIndexs ri left join ri.responsible r where r.account = p.account and c.customerId=?2 and p.programId=?1"
  )
  List<Long> hasProgramWithShareAccount(Long programId, Long customerId);
} // end interface CustomerRepository
