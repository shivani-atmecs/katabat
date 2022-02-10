package com.ozstrategy.credagility.core.domain;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 12:42
 */
public class CopyType {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  // Only copy child Node
  private boolean childOnly;

  // allow copy channel action
  private boolean copyChannel;

  // allow copy program action
  private boolean copyProgram;

  // allow copy queue action
  private boolean copyQueue;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for child only.
   *
   * @return  boolean
   */
  public boolean isChildOnly() {
    return childOnly;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for copy channel.
   *
   * @return  boolean
   */
  public boolean isCopyChannel() {
    return copyChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for copy program.
   *
   * @return  boolean
   */
  public boolean isCopyProgram() {
    return copyProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for copy queue.
   *
   * @return  boolean
   */
  public boolean isCopyQueue() {
    return copyQueue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for child only.
   *
   * @param  childOnly  boolean
   */
  public void setChildOnly(boolean childOnly) {
    this.childOnly = childOnly;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for copy channel.
   *
   * @param  copyChannel  boolean
   */
  public void setCopyChannel(boolean copyChannel) {
    this.copyChannel = copyChannel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for copy program.
   *
   * @param  copyProgram  boolean
   */
  public void setCopyProgram(boolean copyProgram) {
    this.copyProgram = copyProgram;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for copy queue.
   *
   * @param  copyQueue  boolean
   */
  public void setCopyQueue(boolean copyQueue) {
    this.copyQueue = copyQueue;
  }
} // end class CopyType
