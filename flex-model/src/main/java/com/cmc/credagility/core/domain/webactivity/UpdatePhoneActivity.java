package com.cmc.credagility.core.domain.webactivity;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 10:01
 */
public class UpdatePhoneActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1523377758309489084L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String newNum;
  private String oldNum;
  private String phoneType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for new num.
   *
   * @return  String
   */
  public String getNewNum() {
    return newNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for old num.
   *
   * @return  String
   */
  public String getOldNum() {
    return oldNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone type.
   *
   * @return  String
   */
  public String getPhoneType() {
    return phoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for new num.
   *
   * @param  newNum  String
   */
  public void setNewNum(String newNum) {
    this.newNum = newNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for old num.
   *
   * @param  oldNum  String
   */
  public void setOldNum(String oldNum) {
    this.oldNum = oldNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone type.
   *
   * @param  phoneType  String
   */
  public void setPhoneType(String phoneType) {
    this.phoneType = phoneType;
  }

} // end class UpdatePhoneActivity
