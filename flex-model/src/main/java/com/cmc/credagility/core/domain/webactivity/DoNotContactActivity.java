package com.cmc.credagility.core.domain.webactivity;

import java.text.SimpleDateFormat;

import java.util.Date;

import com.cmc.credagility.core.domain.type.DoNotContactLevel;
import com.cmc.credagility.core.domain.type.DoNotContactReason;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/16/2014 09:45
 */
public class DoNotContactActivity extends BaseWebActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2482307881503598299L;

  /** TODO: DOCUMENT ME! */
  public static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
      "MM/dd/yyyy");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private DoNotContactLevel  doNotContactLevel;
  private DoNotContactReason doNotContactReason;
  private Date               doNotContactUntil;

  /** The id of the object that causes the do-not-contact event. */
  private String reasonId;

  /** The id of the do-not-contact object. Could be acctNum, responsibleId, addressId, emailId, phoneId, smsId, etc. */
  private String targetId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for do not contact level.
   *
   * @return  DoNotContactLevel
   */
  public DoNotContactLevel getDoNotContactLevel() {
    return doNotContactLevel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for do not contact reason.
   *
   * @return  DoNotContactReason
   */
  public DoNotContactReason getDoNotContactReason() {
    return doNotContactReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for do not contact until.
   *
   * @return  Date
   */
  public Date getDoNotContactUntil() {
    return doNotContactUntil;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reason id.
   *
   * @return  String
   */
  public String getReasonId() {
    return reasonId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for target id.
   *
   * @return  String
   */
  public String getTargetId() {
    return targetId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for do not contact level.
   *
   * @param  doNotContactLevel  DoNotContactLevel
   */
  public void setDoNotContactLevel(DoNotContactLevel doNotContactLevel) {
    this.doNotContactLevel = doNotContactLevel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for do not contact level.
   *
   * @param  level  String
   */
  public void setDoNotContactLevel(String level) {
    this.doNotContactLevel = Enum.valueOf(DoNotContactLevel.class, level.toUpperCase());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for do not contact reason.
   *
   * @param  doNotContactReason  DoNotContactReason
   */
  public void setDoNotContactReason(DoNotContactReason doNotContactReason) {
    this.doNotContactReason = doNotContactReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for do not contact reason.
   *
   * @param  doNotContactReason  String
   */
  public void setDoNotContactReason(String doNotContactReason) {
    this.doNotContactReason = Enum.valueOf(DoNotContactReason.class,
        doNotContactReason.toUpperCase());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for do not contact until.
   *
   * @param  doNotContactUntil  Date
   */
  public void setDoNotContactUntil(Date doNotContactUntil) {
    this.doNotContactUntil = doNotContactUntil;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for do not contact until.
   *
   * @param  dateStr  String
   */
  public void setDoNotContactUntil(String dateStr) {
    try {
      this.doNotContactUntil = DATE_FORMATTER.parse(dateStr);
    } catch (Exception e) { }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for reason id.
   *
   * @param  reasonId  String
   */
  public void setReasonId(String reasonId) {
    this.reasonId = reasonId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for target id.
   *
   * @param  targetId  String
   */
  public void setTargetId(String targetId) {
    this.targetId = targetId;
  }

} // end class DoNotContactActivity
