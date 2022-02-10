package com.cmc.credagility.core.domain.batch;

import java.io.Serializable;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 10:36
 */
public class BatchJobInstance extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 81793446568957775L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Long   jobInstanceId;
  private String jobKey;
  private String jobName;
  private Long   version;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BatchJobInstance object.
   */
  public BatchJobInstance() { }

  /**
   * Creates a new BatchJobInstance object.
   *
   * @param  jobName  String
   */
  public BatchJobInstance(String jobName) {
    this.jobName = jobName;
  }

  /**
   * Creates a new BatchJobInstance object.
   *
   * @param  version  Long
   * @param  jobName  String
   * @param  jobKey   String
   */
  public BatchJobInstance(Long version, String jobName, String jobKey) {
    this.version = version;
    this.jobName = jobName;
    this.jobKey  = jobKey;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object other) {
    if ((this == other)) {
      return true;
    }

    if ((other == null)) {
      return false;
    }

    if (!(other instanceof BatchJobInstance)) {
      return false;
    }

    BatchJobInstance castOther = (BatchJobInstance) other;

    return ((this.getJobInstanceId() == castOther.getJobInstanceId())
        || ((this.getJobInstanceId() != null)
          && (castOther.getJobInstanceId() != null) && this.getJobInstanceId().equals(castOther.getJobInstanceId())))
      && ((this.getVersion() == castOther.getVersion())
        || ((this.getVersion() != null)
          && (castOther.getVersion() != null) && this.getVersion().equals(
            castOther.getVersion())))
      && ((this.getJobName() == castOther.getJobName())
        || ((this.getJobName() != null)
          && (castOther.getJobName() != null) && this.getJobName().equals(
            castOther.getJobName())))
      && ((this.getJobKey() == castOther.getJobKey())
        || ((this.getJobKey() != null)
          && (castOther.getJobKey() != null) && this.getJobKey().equals(
            castOther.getJobKey())));
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for job instance id.
   *
   * @return  Long
   */
  public Long getJobInstanceId() {
    return this.jobInstanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for job key.
   *
   * @return  String
   */
  public String getJobKey() {
    return this.jobKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for job name.
   *
   * @return  String
   */
  public String getJobName() {
    return this.jobName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for version.
   *
   * @return  Long
   */
  public Long getVersion() {
    return this.version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 17;

    result = (37 * result)
      + ((getJobInstanceId() == null) ? 0 : this.getJobInstanceId().hashCode());
    result = (37 * result)
      + ((getVersion() == null) ? 0 : this.getVersion().hashCode());
    result = (37 * result)
      + ((getJobName() == null) ? 0 : this.getJobName().hashCode());
    result = (37 * result)
      + ((getJobKey() == null) ? 0 : this.getJobKey().hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for job instance id.
   *
   * @param  jobInstanceId  Long
   */
  public void setJobInstanceId(Long jobInstanceId) {
    this.jobInstanceId = jobInstanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for job key.
   *
   * @param  jobKey  String
   */
  public void setJobKey(String jobKey) {
    this.jobKey = jobKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for job name.
   *
   * @param  jobName  String
   */
  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for version.
   *
   * @param  version  Long
   */
  public void setVersion(Long version) {
    this.version = version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    StringBuffer buffer = new StringBuffer();

    buffer.append(getClass().getName()).append("@").append(
      Integer.toHexString(hashCode())).append(" [");
    buffer.append("version").append("='").append(getVersion()).append("' ");
    buffer.append("jobName").append("='").append(getJobName()).append("' ");
    buffer.append("jobKey").append("='").append(getJobKey()).append("' ");
    buffer.append("]");

    return buffer.toString();
  }
} // end class BatchJobInstance
