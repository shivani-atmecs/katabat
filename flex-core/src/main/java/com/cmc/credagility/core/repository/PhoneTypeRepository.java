package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.contact.PhoneType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 16:28
 */
public interface PhoneTypeRepository extends JpaRepository<PhoneType, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone type by name.
   *
   * @param   name  String
   *
   * @return  PhoneType
   */
  @Query("from PhoneType pt where pt.name=?1")
  PhoneType getPhoneTypeByName(String name);
}
