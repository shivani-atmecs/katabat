package com.cmc.credagility.core.domain.webactivity;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:48
 */
public class PageViewActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3632706899093497867L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String data1;
  private String pageName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for data1.
   *
   * @return  String
   */
  public String getData1() {
    return data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for page name.
   *
   * @return  String
   */
  public String getPageName() {
    return pageName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data1.
   *
   * @param  data1  String
   */
  public void setData1(String data1) {
    this.data1 = data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for page name.
   *
   * @param  pageName  String
   */
  public void setPageName(String pageName) {
    this.pageName = pageName;
  }

} // end class PageViewActivity
