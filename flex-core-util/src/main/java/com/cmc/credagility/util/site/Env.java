package com.cmc.credagility.util.site;

/**
 * Created by Yang Wang on 1/28/15.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  01/28/2015 17:14 PM
 */
public class Env {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static Env instance = new Env();

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private boolean allowAccountUrlPrefix;

  private String defaultTheme;

  private boolean enableSessionReplication;

  private boolean isAuthorInstance;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private Env() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for default theme.
   *
   * @return  String
   */
  public static String getDefaultTheme() {
    return instance.defaultTheme;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for instance.
   *
   * @return  Env
   */
  public static Env getInstance() {
    return instance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow url prefix.
   *
   * @return  boolean
   */
  public static boolean isAllowAccountUrlPrefix() {
    return instance.allowAccountUrlPrefix;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for author instance.
   *
   * @return  boolean
   */
  public static boolean isAuthorInstance() {
    return instance.isAuthorInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static boolean isEnableSessionReplication() {
    return instance.enableSessionReplication;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow url prefix.
   *
   * @param  allowAccountUrlPrefix  boolean
   */
  public static void setAllowAccountUrlPrefix(boolean allowAccountUrlPrefix) {
    instance.allowAccountUrlPrefix = allowAccountUrlPrefix;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for author instance.
   *
   * @param  isAuthorInstance  boolean
   */
  public static void setAuthorInstance(boolean isAuthorInstance) {
    instance.isAuthorInstance = isAuthorInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for default theme.
   *
   * @param  theme  String
   */
  public static void setDefaultTheme(String theme) {
    instance.defaultTheme = theme;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  enableSessionReplication  DOCUMENT ME!
   */
  public static void setEnableSessionReplication(boolean enableSessionReplication) {
    instance.enableSessionReplication = enableSessionReplication;
  }
} // end class Env
