package com.cmc.credagility.core.utility;

import com.cmc.credagility.core.domain.config.LookUpValue;
import com.cmc.credagility.core.repository.LookUpValueRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Yang Wang on 1/20/15.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  01/20/2015 15:15 PM
 */
public class LookUpValueHelper {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static LookUpValueHelper instance = new LookUpValueHelper();

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String locale = "en_US";

  private LookUpValueRepository repository;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private LookUpValueHelper() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for instance.
   *
   * @return  LookUpValueHelper
   */
  public static LookUpValueHelper getInstance() {
    return instance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookup only with keys.
   *
   * @param   key        String
   * @param   otherKeys  String
   *
   * @return  String
   */
  public static String lookup(String key, String... otherKeys) {
    return lookupWithoutCategory(getInstance().locale, key, otherKeys);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookup with category and key(s).
   *
   * @param   category  String
   * @param   key       String
   * @param   keys      String
   *
   * @return  String
   */
  public static String lookupC(String category, String key, String... keys) {
    return lookupCL(category, getInstance().locale, key, keys);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookup with category, locale and key(s).
   *
   * @param   category  String
   * @param   locale    String
   * @param   key       String
   * @param   keys      String
   *
   * @return  String
   */
  public static String lookupCL(String category, String locale, String key, String... keys) {
    List<String> values = Arrays.asList(keys);
    values = new ArrayList<String>(values);
    values.add(0, key);

    LookUpValue lookupValue = getInstance().repository.findByCategoryAndLocale(category, locale,
        values);

    if (lookupValue != null) {
      return lookupValue.getValue();
    }

    return "";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookup with locale and key(s).
   *
   * @param   locale     String
   * @param   key        String
   * @param   otherKeys  String
   *
   * @return  String
   */
  public static String lookupL(String locale, String key, String... otherKeys) {
    return lookupWithoutCategory(locale, key, otherKeys);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * lookupWithoutCategory.
   *
   * @param   locale  String
   * @param   key     String
   * @param   keys    String
   *
   * @return  String
   */
  public static String lookupWithoutCategory(String locale, String key, String... keys) {
    List<String> values = Arrays.asList(keys);
    values = new ArrayList<String>(values);
    values.add(0, key);

    LookUpValue lookupValue = getInstance().repository.findByNameAndLocale(locale, values);

    if (lookupValue != null) {
      return lookupValue.getValue();
    }

    return "";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for locale.
   *
   * @param  locale  String
   */
  public static void setLocale(String locale) {
    getInstance().locale = locale;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for repository.
   *
   * @param  repository  LookUpValueRepository
   */
  public static void setRepository(LookUpValueRepository repository) {
    getInstance().repository = repository;
  }
} // end class LookUpValueHelper
