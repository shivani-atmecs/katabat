package com.cmc.credagility.util;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  01/08/2015 16:05
 */
public class PageUtil {
  
  public static final int DEFAULT_PAGE_SIZE=10;
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected int currentPage;

  /** TODO: DOCUMENT ME! */
  protected int pageCount;

  /** TODO: DOCUMENT ME! */
  protected int pageSize ;

  /** TODO: DOCUMENT ME! */
  protected int recordCount;

  /** TODO: DOCUMENT ME! */
  protected int totalCount;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new PageUtil object.
   */
  public PageUtil() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for total page.
   *
   * @param   recordCount  int
   * @param   pageSize     int
   *
   * @return  int
   */
  public static int getTotalPage(int recordCount, int pageSize) {
    int size = recordCount / pageSize;
    int mod  = recordCount % pageSize;
    if (mod != 0) {
      size++;
    }

    return (recordCount == 0) ? 1 : size;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current page.
   *
   * @return  int
   */
  public int getCurrentPage() {
    return currentPage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for page count.
   *
   * @return  int
   */
  public int getPageCount() {
    return pageCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for page size.
   *
   * @return  int
   */
  public int getPageSize() {
    return pageSize;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for record count.
   *
   * @return  int
   */
  public int getRecordCount() {
    return recordCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total count.
   *
   * @return  int
   */
  public int getTotalCount() {
    return totalCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current page.
   *
   * @param  currentPage  int
   */
  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for page count.
   *
   * @param  pageCount  int
   */
  public void setPageCount(int pageCount) {
    this.pageCount = pageCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for page size.
   *
   * @param  pageSize  int
   */
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for record count.
   *
   * @param  recordCount  int
   */
  public void setRecordCount(int recordCount) {
    this.recordCount = recordCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total count.
   *
   * @param  totalCount  int
   */
  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }
} // end class PageUtil
