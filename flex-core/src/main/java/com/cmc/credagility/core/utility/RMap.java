package com.cmc.credagility.core.utility;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * This is used to process reflection variables ${r.fieldName}.
 *
 * @see {@link com.cmc.credagility.core.utility.RMap#get(Object)}
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  01/06/2015 15:06 PM
 */
public class RMap implements Map<String, String> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.util.Map#clear()
   */
  @Override public void clear() { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.util.Map#containsKey(Object)
   */
  @Override public boolean containsKey(Object key) {
    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.util.Map#containsValue(Object)
   */
  @Override public boolean containsValue(Object value) {
    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.util.Map#entrySet()
   */
  @Override public Set<Entry<String, String>> entrySet() {
    return new HashSet<Entry<String, String>>();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.util.Map#get(Object)
   */
  @Override public String get(Object key) {
    return (key == null) ? "" : key.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.util.Map#isEmpty()
   */
  @Override public boolean isEmpty() {
    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.util.Map#keySet()
   */
  @Override public Set<String> keySet() {
    return new HashSet<String>();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.util.Map#put(String, String)
   */
  @Override public String put(String key, String value) {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.util.Map#putAll(java.util.Map)
   */
  @Override public void putAll(Map<? extends String, ? extends String> m) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.util.Map#remove(Object)
   */
  @Override public String remove(Object key) {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.util.Map#size()
   */
  @Override public int size() {
    return 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.util.Map#values()
   */
  @Override public Collection<String> values() {
    return new HashSet<String>();
  }
} // end class RMap
