package com.cmc.credagility.util.collectionutil;

import java.util.LinkedList;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/27/2014 10:27
 */
public class FixedSizeArrayList<T> extends LinkedList<T> {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private final int maxSize;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new FixedSizeArrayList object.
   *
   * @param  maxSize  int
   */
  public FixedSizeArrayList(int maxSize) {
    super();
    this.maxSize = maxSize;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.util.LinkedList#add(java.lang.Object)
   */
  @Override public boolean add(T t) {
    if (size() >= maxSize) {
      removeFirst();
    }

    return super.add(t);
  }


} // end class FixedSizeArrayList
