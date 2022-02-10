package com.cmc.credagility.core.domain.webactivity;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:38
 */
public class AcctVerificationUpdatedActivity extends BaseWebActivity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private String customerId;

  private String fieldName;

  private String newValue;

  private String oldValue;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer id.
   *
   * @return  String
   */
  public String getCustomerId() {
    return customerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for field name.
   *
   * @return  String
   */
  public String getFieldName() {
    return fieldName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for new value.
   *
   * @return  String
   */
  public String getNewValue() {
    return newValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for old value.
   *
   * @return  String
   */
  public String getOldValue() {
    return oldValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer id.
   *
   * @param  customerId  String
   */
  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for field name.
   *
   * @param  fieldName  String
   */
  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for new value.
   *
   * @param  newValue  String
   */
  public void setNewValue(String newValue) {
    this.newValue = newValue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for old value.
   *
   * @param  oldValue  String
   */
  public void setOldValue(String oldValue) {
    this.oldValue = oldValue;
  }
} // end class AcctVerificationUpdatedActivity
