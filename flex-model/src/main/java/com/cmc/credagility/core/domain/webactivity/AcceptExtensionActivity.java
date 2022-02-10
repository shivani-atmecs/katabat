package com.cmc.credagility.core.domain.webactivity;

/**
 * AcceptExtensionActivity.java is the class for defining setters and getters for the Transaction a_AcceptExtension.
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:37
 */
public class AcceptExtensionActivity extends AcceptPaymentProgramActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Integer ExtensionLength;
  private String  ReasonForDelinquency;
  private String  Resolution;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for extension length.
   *
   * @return  Integer
   */
  public Integer getExtensionLength() {
    return ExtensionLength;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reason for delinquency.
   *
   * @return  String
   */
  public String getReasonForDelinquency() {
    return ReasonForDelinquency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for resolution.
   *
   * @return  String
   */
  public String getResolution() {
    return Resolution;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for extension length.
   *
   * @param  extensionLength  Integer
   */
  public void setExtensionLength(Integer extensionLength) {
    ExtensionLength = extensionLength;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for reason for delinquency.
   *
   * @param  reasonForDelinquency  String
   */
  public void setReasonForDelinquency(String reasonForDelinquency) {
    ReasonForDelinquency = reasonForDelinquency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for resolution.
   *
   * @param  resolution  String
   */
  public void setResolution(String resolution) {
    Resolution = resolution;
  }
} // end class AcceptExtensionActivity
