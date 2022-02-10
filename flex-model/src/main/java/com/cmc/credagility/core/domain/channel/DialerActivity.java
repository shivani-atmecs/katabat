package com.cmc.credagility.core.domain.channel;

import com.cmc.credagility.core.domain.activity.BaseActivity;


/**
 * This class is used to log all Dialer activity.
 *
 * <p><a href="DialerActivity.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 14:28
 */
public class DialerActivity extends BaseActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5149838671731031434L;

  /** activity type. */
  private static String CHANNEL = "Dialer";

  /** activity type. */
  private static String NAME = "DialerActivity";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** IVR Activity PK activityId. */
  protected Long activityId;

  /** phone number! */
  protected String phoneNumber;

  /** Dialer Activity result! */
  protected String result;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    DialerActivity other = (DialerActivity) obj;

    if (phoneNumber == null) {
      if (other.phoneNumber != null) {
        return false;
      }
    } else if (!phoneNumber.equals(other.phoneNumber)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The activityId.
   *
   * @return  the activityId
   */
  public Long getActivityId() {
    return activityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The cHANNEL.
   *
   * @return  the cHANNEL
   */
  @Override public String getChannel() {
    return CHANNEL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The nAME.
   *
   * @return  the nAME
   */
  @Override public String getName() {
    return NAME;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The phoneNumber.
   *
   * @return  the phoneNumber
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The result.
   *
   * @return  the result
   */
  public String getResult() {
    return this.result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setActivityId.
   *
   * @param  activityId  the activityId to set
   */
  public void setActivityId(Long activityId) {
    this.activityId = activityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setPhoneNumber.
   *
   * @param  phoneNumber  the phoneNumber to set
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setResult.
   *
   * @param  result  the result to set
   */
  public void setResult(String result) {
    this.result = result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("DialerActivity ( ").append(super.toString()).append(TAB).append("activityId = ").append(
      this.activityId).append(TAB).append(
      "phoneNumber = ").append(this.phoneNumber).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class DialerActivity
