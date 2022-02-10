package com.cmc.credagility.util;

import java.io.Serializable;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/23/2014 11:51
 */
public class CollectionUtil implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 8760286025632237337L;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addValueInMapValueCollection.
   *
   * @param   target  Map
   * @param   key     Object
   * @param   val     Object
   *
   * @return  boolean
   */
  public static boolean addValueInMapValueCollection(Map<?, ? extends Collection<Object>> target, Object key,
    Object val) {
    Collection<Object> existingVal = target.get(key);

    return (existingVal != null) && existingVal.add(val);

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * IsNullOrEmpty.
   *
   * @param   <T>   Collection
   * @param   list  Collection
   *
   * @return  boolean
   */
  public static <T> boolean IsNullOrEmpty(Collection<T> list) {
    return (list == null) || list.isEmpty();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * safeList.
   *
   * @param   <T>    Iterable
   * @param   other  Iterable
   *
   * @return  Iterable
   */
  public static <T> Iterable<T> safeList(Iterable<T> other) {
    return (other == null) ? Collections.<T>emptyList() : other;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * safeMap.
   *
   * @param   <K>    Map
   * @param   <V>    Map
   * @param   other  Map
   *
   * @return  Map
   */
  public static <K, V> Map<K, V> safeMap(Map<K, V> other) {
    return (other == null) ? Collections.<K, V>emptyMap() : other;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * safeSet.
   *
   * @param   <T>    Iterable
   * @param   other  Iterable
   *
   * @return  Iterable
   */
  public static <T> Iterable<T> safeSet(Iterable<T> other) {
    return (other == null) ? Collections.<T>emptySet() : other;
  }


} // end class CollectionUtil
