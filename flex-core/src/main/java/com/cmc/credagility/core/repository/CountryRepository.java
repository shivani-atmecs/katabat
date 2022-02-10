package com.cmc.credagility.core.repository;

import com.cmc.credagility.core.domain.address.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/31/2014 16:34
 */
public interface CountryRepository extends JpaRepository<Country, Long> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for country by country code.
   *
   * @param   countryCode  String
   *
   * @return  Country
   */
  Country getCountryByCountryCode(String countryCode);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tel country list.
   *
   * @return  List
   */
  @Query("FROM Country WHERE (telephoneCountryCode is not null AND telephoneCountryCode !='')")
  List<Country> getTelCountryList();
}
