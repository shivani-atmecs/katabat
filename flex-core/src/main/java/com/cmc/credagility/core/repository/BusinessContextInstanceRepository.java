package com.cmc.credagility.core.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.cmc.credagility.core.domain.businesscontext.DynamicCase;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 16:02
 */
public interface BusinessContextInstanceRepository extends JpaRepository<BusinessContextInstance, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context instance count by case.
   *
   * @param   uniqueId  dynamicCase DynamicCase
   *
   * @return  Long
   */
  BusinessContextInstance findFirstByUniqueId(String uniqueId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for all child case.
   *
   * @param   caseId  Long
   *
   * @return  List
   */
  @Query("SELECT  b FROM BusinessContextInstance b WHERE b.dynamicCase.id=?1")
  List<BusinessContextInstance> getAllChildCase(Long caseId);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context instance count by case.
   *
   * @param   dynamicCase  DynamicCase
   *
   * @return  Long
   */
  @Query("select COUNT(b.id) from BusinessContextInstance b where b.dynamicCase=?1 ")
  Long getBusinessContextInstanceCountByCase(DynamicCase dynamicCase);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context instances by case.
   *
   * @param   dynamicCase  DynamicCase
   * @param   page         Pageable
   *
   * @return  List
   */
  @Query("select b from BusinessContextInstance b where b.dynamicCase=?1 ")
  List<BusinessContextInstance> getBusinessContextInstancesByCase(DynamicCase dynamicCase, Pageable page);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context instances by customer.
   *
   * @param   customerId  Long
   *
   * @return  List
   */
  @Query("SELECT  b FROM BusinessContextInstance b WHERE b.customer.customerId=?1")
  List<BusinessContextInstance> getBusinessContextInstancesByCustomer(Long customerId);
} // end interface BusinessContextInstanceRepository
