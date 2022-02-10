package com.ozstrategy.credagility.core.util;


import com.ozstrategy.credagility.core.domain.workflow.WorkflowTriggerSource;


/**
 * Document for new class.
 *
 * <p>: Wang Yang : 12-11-8 : AM10:04</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class OzEnv {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static OzEnv instance;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String                appAddress;
  private Boolean               disablePreFetch       = Boolean.FALSE;
  private Boolean               enableAdvanceDocument = false;
  private String                version               = "4.61.19";
  private WorkflowTriggerSource webChannel;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private OzEnv() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getAppAddress() {
    return getInstance().appAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static WorkflowTriggerSource getWebChannel() {
    return getInstance().webChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static Boolean isDisablePreFetch() {
    return Boolean.TRUE.equals(getInstance().disablePreFetch);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static Boolean isEnableAdvanceDocument() {
    return getInstance().enableAdvanceDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  appAddress  DOCUMENT ME!
   */
  public static void setAppAddress(String appAddress) {
    getInstance().appAddress = appAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  disablePreFetch  DOCUMENT ME!
   */
  public static void setDisablePreFetch(Boolean disablePreFetch) {
    getInstance().disablePreFetch = disablePreFetch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  enableAdvanceDocument  DOCUMENT ME!
   */
  public static void setEnableAdvanceDocument(Boolean enableAdvanceDocument) {
    getInstance().enableAdvanceDocument = enableAdvanceDocument;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  webChannel  DOCUMENT ME!
   */
  public static void setWebChannel(WorkflowTriggerSource webChannel) {
    getInstance().webChannel = webChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String version() {
    return getInstance().version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private static OzEnv getInstance() {
    if (instance == null) {
      instance = new OzEnv();
    }

    return instance;
  }
} // end class OzEnv
