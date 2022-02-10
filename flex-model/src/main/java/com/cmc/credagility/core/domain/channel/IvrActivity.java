package com.cmc.credagility.core.domain.channel;

import com.cmc.credagility.core.domain.activity.BaseActivity;


/**
 * This class is used to log all IVR activity.
 *
 * <p><a href="IvrActivity.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 11:24
 */
public class IvrActivity extends BaseActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7211607789630137866L;

  /** activity type. */
  private static String CHANNEL = "Ivr";

  /** activity type. */
  private static String NAME = "IvrActivity";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** IVR Activity PK activityId. */
  protected Long activityId;

  /** Agent connected. */
  protected Boolean agentConnected;

  /** TODO: DOCUMENT ME! */
  protected String attemptTime;

  /** duration in second. */
  protected Long duration;

  /** IVR result. */
  protected String ivrResult;

  /** TODO: DOCUMENT ME! */
  protected String phoneNumber;

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

    final IvrActivity other = (IvrActivity) obj;

    if (this.ivrResult == null) {
      if (other.getIvrResult() != null) {
        return false;
      }
    } else if (!this.ivrResult.equals(other.getIvrResult())) {
      return false;
    }

    if (this.activityId == null) {
      if (other.getActivityId() != null) {
        return false;
      }
    } else if (!this.activityId.equals(other.getActivityId())) {
      return false;
    }

    if (this.agentConnected == null) {
      if (other.getAgentConnected() != null) {
        return false;
      }
    } else if (!this.agentConnected.equals(other.getAgentConnected())) {
      return false;
    }

    if (this.duration == null) {
      if (other.getDuration() != null) {
        return false;
      }
    } else if (!this.duration.equals(other.getDuration())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The activityId.
   *
   * @return  the activityId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getActivityId() {
    return this.activityId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The agentConnected.
   *
   * @return  the agentConnected
   *
   *          <p>not-null = "false" type = "yes_no"</p>
   */
  public Boolean getAgentConnected() {
    return this.agentConnected;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The attemptTime.
   *
   * @return  the attemptTime
   */
  public String getAttemptTime() {
    return attemptTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#getChannel()
   */
  @Override public String getChannel() {
    return CHANNEL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The duration.
   *
   * @return  the duration
   *
   *          <p>not-null = "true"</p>
   */
  public Long getDuration() {
    return this.duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The iVRResult.
   *
   * @return  the iVRResult
   *
   *          <p>not-null = "false" length = "255"</p>
   */
  public String getIvrResult() {
    return this.ivrResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see com.cmc.credagility.BaseActivity#getName()
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

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = super.hashCode();
    result = (PRIME * result)
      + ((this.ivrResult == null) ? 0 : this.ivrResult.hashCode());
    result = (PRIME * result)
      + ((this.activityId == null) ? 0 : this.activityId.hashCode());
    result = (PRIME * result)
      + ((this.agentConnected == null) ? 0 : this.agentConnected.hashCode());
    result = (PRIME * result)
      + ((this.duration == null) ? 0 : this.duration.hashCode());

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
   * setAgentConnected.
   *
   * @param  agentConnected  the agentConnected to set
   */
  public void setAgentConnected(Boolean agentConnected) {
    this.agentConnected = agentConnected;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAttemptTime.
   *
   * @param  attemptTime  the attemptTime to set
   */
  public void setAttemptTime(String attemptTime) {
    this.attemptTime = attemptTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setDuration.
   *
   * @param  duration  the duration to set
   */
  public void setDuration(Long duration) {
    this.duration = duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setIvrResult.
   *
   * @param  result  the iVRResult to set
   */
  public void setIvrResult(String result) {
    this.ivrResult = result;
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
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("IvrActivity ( ").append(super.toString()).append(TAB).append("activityId = ").append(
      this.activityId).append(TAB).append(
      "agentConnected = ").append(this.agentConnected).append(TAB).append("attemptTime = ").append(this.attemptTime)
      .append(TAB).append(
      "duration = ").append(this.duration).append(TAB).append(
      "ivrResult = ").append(this.ivrResult).append(TAB).append(
      "phoneNumber = ").append(this.phoneNumber).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class IvrActivity
