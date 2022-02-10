package com.cmc.credagility.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.credagility.core.domain.address.AddressType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 15:19
 */
public interface AddressTypeRepository extends JpaRepository<AddressType, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for address type by name.
   *
   * @param   name  String
   *
   * @return  AddressType
   */
  @Query("from AddressType at where at.name=?1")
  AddressType getAddressTypeByName(String name);
}
