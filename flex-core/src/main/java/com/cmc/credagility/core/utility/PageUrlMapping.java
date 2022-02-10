package com.cmc.credagility.core.utility;

import java.util.HashMap;
import java.util.Map;


/**
 * Mapping the page id and page url.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  02/03/2015 14:39 PM
 */
public class PageUrlMapping {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final Map<String, String> mapping = new HashMap<String, String>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addPage.
   *
   * @param  pageId   String
   * @param  pageUrl  String
   */
  public static void addPage(String pageId, String pageUrl) {
    mapping.put(pageId, pageUrl);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for path.
   *
   * @param   pageId  String
   *
   * @return  String
   */
  public static String getPath(String pageId) {
    return mapping.get(pageId);
  }
} // end class PageUrlMapping
