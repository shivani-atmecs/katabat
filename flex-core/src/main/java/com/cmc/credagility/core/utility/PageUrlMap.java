package com.cmc.credagility.core.utility;

import com.cmc.credagility.core.utility.RMap;


/**
 * Created by Yang Wang on 2/3/15.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  02/03/2015 15:54 PM
 */
public class PageUrlMap extends RMap {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  RMap#get(Object)
   */
  @Override public String get(Object key) {
    if (key != null) {
      String path = PageUrlMapping.getPath(key.toString());

      if (path == null) {
        return key.toString();
      } else {
        return path;
      }
    }

    return "";
  }
}
