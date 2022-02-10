package com.ozstrategy.credagility.core.util;

import com.ozstrategy.credagility.core.domain.document.EnterpriseDocumentMetaData;
import com.ozstrategy.credagility.core.domain.document.EnterpriseDocumentVersionMetaData;

import java.util.*;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 3/11/13 Time: 3:04 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class ListUtils {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   list1  DOCUMENT ME!
   * @param   list2  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static List<Long> getDifferentId(List<Long> list1, List<Long> list2) {
    // if equal
    if (list1.containsAll(list2)) {
      return null;
    }

    // The Map Long, count
    Map<Long, Integer> map1   = new HashMap<Long, Integer>(20);
    List<Long>         difIDs = new ArrayList<Long>(20);

    int index = 0;

    for (Long ele : list1) {
      map1.put(ele, ++index);
    }

    for (Long ele : list2) {
      // if the ele not found in map1, then this ele is different in these two lists.
      if (map1.get(ele) == null) {
        difIDs.add(ele);
      }
    }

    return difIDs;
  } // end method getDifferentId

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  metaDataSet  DOCUMENT ME!
   */
  public static void sortDocVersionMetaData(Set<EnterpriseDocumentVersionMetaData> metaDataSet) {
    List<EnterpriseDocumentVersionMetaData> metaDataList = new ArrayList<EnterpriseDocumentVersionMetaData>(
        metaDataSet);

    if (!metaDataList.isEmpty()) {
      Collections.sort(metaDataList, new Comparator<EnterpriseDocumentVersionMetaData>() {
          @Override public int compare(EnterpriseDocumentVersionMetaData o1, EnterpriseDocumentVersionMetaData o2) {
            if (o1.getDisplayOrder() == null) {
              return 1;
            } else if (o2.getDisplayOrder() == null) {
              return -1;
            } else {
              return o1.getDisplayOrder().compareTo(o2.getDisplayOrder());
            }
          }
        });
    }

    if (!metaDataList.isEmpty()) {
      metaDataSet.clear();
      metaDataSet.addAll(metaDataList);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  metaDataSet  DOCUMENT ME!
   */
  public static void sortMetaData(Set<EnterpriseDocumentMetaData> metaDataSet) {
    List<EnterpriseDocumentMetaData> metaDataList = new ArrayList<EnterpriseDocumentMetaData>(metaDataSet);

    if (!metaDataList.isEmpty()) {
      Collections.sort(metaDataList, new Comparator<EnterpriseDocumentMetaData>() {
          @Override public int compare(EnterpriseDocumentMetaData o1, EnterpriseDocumentMetaData o2) {
            if (o1.getDisplayOrder() == null) {
              return 1;
            } else if (o2.getDisplayOrder() == null) {
              return -1;
            } else {
              return o1.getDisplayOrder().compareTo(o2.getDisplayOrder());
            }
          }
        });
    }

    if (!metaDataList.isEmpty()) {
      metaDataSet.clear();
      metaDataSet.addAll(metaDataList);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  metaDataList  DOCUMENT ME!
   */
  public static void sortMetaData(List<EnterpriseDocumentVersionMetaData> metaDataList) {
    if ((metaDataList != null) && !metaDataList.isEmpty()) {
      Collections.sort(metaDataList, new Comparator<EnterpriseDocumentVersionMetaData>() {
          @Override public int compare(EnterpriseDocumentVersionMetaData o1, EnterpriseDocumentVersionMetaData o2) {
            if (o1.getDisplayOrder() == null) {
              return 1;
            } else if (o2.getDisplayOrder() == null) {
              return -1;
            } else {
              return o1.getDisplayOrder().compareTo(o2.getDisplayOrder());
            }
          }
        });
    }
  }
} // end class ListUtils
