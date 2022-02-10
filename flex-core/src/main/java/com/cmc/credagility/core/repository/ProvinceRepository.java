package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.address.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 16:40
 */
public interface ProvinceRepository extends JpaRepository<Province, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for province by country country id.
   *
   * @param   countryId  Long
   *
   * @return  List
   */
  List<Province> getProvinceByCountryCountryId(Long countryId);
}
