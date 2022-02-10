package com.ozstrategy.credagility.core.util;

import java.util.concurrent.ConcurrentHashMap;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 7/31/13 Time: 2:57 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class Constant {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  public static final String KEY_WORKFLOW_NAME = "WorkflowName";

  /** DOCUMENT ME! */
  public static final String KEY_TRIGGER_TYPE = "triggerType";

  /** DOCUMENT ME! */
  public static final String KEY_FLOW_STEP = "WorkflowStep";

  /** DOCUMENT ME! */
  public static final String PLACEHOLDER_VALUE            = "_value_";

  /** TODO: DOCUMENT ME! */
  public static final String PREFIX_HYPERLINK_DOC_PREVIEW = "<span style='color:blue'>Preview Template: </span>";

  /** TODO: DOCUMENT ME! */
  public static final String                      REQUEST_GET_TASK_DETAILS_KEY = "responsibleGetTaskDetails";

  /** TODO: DOCUMENT ME! */
  public static ConcurrentHashMap<String, String> requestMap             = new ConcurrentHashMap<String, String>(50);

  /** TODO: DOCUMENT ME! */
  public static final String                      WORKFLOW_UPDATE_ACTION = "workflow_UpdateAction";

  /** TODO: DOCUMENT ME! */
  public static final String BATCH = "batch";

  /** TODO: DOCUMENT ME! */
  public static final String STRATEGY_UPDATE_ACTION = "strategy_UpdateAction";
} // end class Constant
