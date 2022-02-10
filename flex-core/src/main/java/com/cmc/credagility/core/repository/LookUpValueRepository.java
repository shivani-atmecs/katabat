package com.cmc.credagility.core.repository;

import java.util.List;

import com.cmc.credagility.core.domain.config.LookUpValue;


/**
 * Created by Yang Wang on 1/20/15.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  01/20/2015 15:13 PM
 */
public interface LookUpValueRepository {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * findFirstByCategoryAndNameAndLocale.
   *
   * @param   category  String
   * @param   locale    String
   * @param   values    String
   *
   * @return  LookUpValue
   */
  LookUpValue findByCategoryAndLocale(String category, String locale, String... values);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByCategoryAndLocale.
   *
   * @param   category  String
   * @param   locale    String
   * @param   values    List
   *
   * @return  LookUpValue
   */
  LookUpValue findByCategoryAndLocale(String category, String locale, List<String> values);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByNameAndLocale.
   *
   * @param   locale  String
   * @param   values  String
   *
   * @return  LookUpValue
   */
  LookUpValue findByNameAndLocale(String locale, List<String> values);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findByNameAndLocale.
   *
   * @param   locale  String
   * @param   values  String
   *
   * @return  LookUpValue
   */
  LookUpValue findByNameAndLocale(String locale, String... values);
} // end interface LookUpValueRepository
