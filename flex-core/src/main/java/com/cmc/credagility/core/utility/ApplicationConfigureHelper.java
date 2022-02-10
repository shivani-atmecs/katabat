package com.cmc.credagility.core.utility;

import com.cmc.credagility.core.domain.config.ApplicationConfig;
import com.cmc.credagility.core.repository.ApplicationConfigRepository;


/**
 * Created by Yang Wang on 1/20/15.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  01/20/2015 15:15 PM
 */
public class ApplicationConfigureHelper {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static ApplicationConfigureHelper instance = new ApplicationConfigureHelper();

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private ApplicationConfigRepository repository;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private ApplicationConfigureHelper() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * get.
   *
   * @param   key  String
   *
   * @return  Object
   */
  public static String get(String key) {
    ApplicationConfig config = instance.repository.findFirstByFeatureName(key);

    if (config != null) {
      return config.getFeatureValue();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for config.
   *
   * @param   key  String
   *
   * @return  ApplicationConfig
   */
  public static ApplicationConfig getConfig(String key) {
    ApplicationConfig config = instance.repository.findFirstByFeatureName(key);

    return config;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for instance.
   *
   * @return  LookUpValueHelper
   */
  public static ApplicationConfigureHelper getInstance() {
    return instance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for repository.
   *
   * @param  repository  ApplicationConfigRepository
   */
  public static void setRepository(ApplicationConfigRepository repository) {
    getInstance().repository = repository;
  }
} // end class ApplicationConfigureHelper
