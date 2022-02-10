package com.cmc.credagility.core.domain.channel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

import com.cmc.credagility.core.domain.activity.BaseActivity;


/**
 * This class is used to log all Sms activity.
 *
 * <p><a href="SmsActivity.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 10:04
 */
public class SmsActivity extends BaseActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5553879490170922847L;

  /** activity type. */
  private static String CHANNEL = "Sms";

  /** activity type. */
  private static String NAME = "SmsActivity";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Sms Activity PK activityId. */
  @Column(
    name     = "activityId",
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long activityId;

  /** data field 1. */
  @Column(
    name   = "data1",
    length = 80
  )
  protected String data1;

  /** data field 2. */
  @Column(
    name   = "data2",
    length = 80
  )
  protected String data2;

  /** data field 3. */
  @Column(
    name   = "data3",
    length = 80
  )
  protected String data3;

  /** data field 4. */
  @Column(
    name   = "data4",
    length = 80
  )
  protected String data4;

  /** data field 5. */
  @Column(
    name   = "data5",
    length = 80
  )
  protected String data5;

  /** TODO: DOCUMENT ME! */

  protected String phoneNumber;

  /** TODO: DOCUMENT ME! */
  protected String result;

  /** TODO: DOCUMENT ME! */
  protected String template;

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

    final SmsActivity other = (SmsActivity) obj;

    if (this.data1 == null) {
      if (other.getData1() != null) {
        return false;
      }
    } else if (!this.data1.equals(other.getData1())) {
      return false;
    }

    if (this.data2 == null) {
      if (other.getData2() != null) {
        return false;
      }
    } else if (!this.data2.equals(other.getData2())) {
      return false;
    }

    if (this.data3 == null) {
      if (other.getData3() != null) {
        return false;
      }
    } else if (!this.data3.equals(other.getData3())) {
      return false;
    }

    if (this.data4 == null) {
      if (other.getData4() != null) {
        return false;
      }
    } else if (!this.data4.equals(other.getData4())) {
      return false;
    }

    if (this.data5 == null) {
      if (other.getData5() != null) {
        return false;
      }
    } else if (!this.data5.equals(other.getData5())) {
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
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#getChannel()
   */
  @Override public String getChannel() {
    return CHANNEL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The data1.
   *
   * @return  the data1
   *
   *          <p>not-null = "false" length = "80"</p>
   */
  public String getData1() {
    return this.data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The data2.
   *
   * @return  the data2
   *
   *          <p>not-null = "false" length = "80"</p>
   */
  public String getData2() {
    return this.data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The data3.
   *
   * @return  the data3
   *
   *          <p>not-null = "false" length = "80"</p>
   */
  public String getData3() {
    return this.data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The data4.
   *
   * @return  the data4
   *
   *          <p>not-null = "false" length = "80"</p>
   */
  public String getData4() {
    return this.data4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The data5.
   *
   * @return  the data5
   *
   *          <p>not-null = "false" length = "80"</p>
   */
  public String getData5() {
    return this.data5;
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

  /**
   * The result.
   *
   * @return  the result
   */
  public String getResult() {
    return this.result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The template.
   *
   * @return  the template
   */
  public String getTemplate() {
    return template;
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
      + ((this.data1 == null) ? 0 : this.data1.hashCode());
    result = (PRIME * result)
      + ((this.data2 == null) ? 0 : this.data2.hashCode());
    result = (PRIME * result)
      + ((this.data3 == null) ? 0 : this.data3.hashCode());
    result = (PRIME * result)
      + ((this.data4 == null) ? 0 : this.data4.hashCode());
    result = (PRIME * result)
      + ((this.data5 == null) ? 0 : this.data5.hashCode());

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
   * setData1.
   *
   * @param  data1  the data1 to set
   */
  public void setData1(String data1) {
    this.data1 = data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setData2.
   *
   * @param  data2  the data2 to set
   */
  public void setData2(String data2) {
    this.data2 = data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setData3.
   *
   * @param  data3  the data3 to set
   */
  public void setData3(String data3) {
    this.data3 = data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setData4.
   *
   * @param  data4  the data4 to set
   */
  public void setData4(String data4) {
    this.data4 = data4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setData5.
   *
   * @param  data5  the data5 to set
   */
  public void setData5(String data5) {
    this.data5 = data5;
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
   * setTemplate.
   *
   * @param  template  the template to set
   */
  public void setTemplate(String template) {
    this.template = template;
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

    retValue.append("SmsActivity ( ").append(super.toString()).append(TAB).append("activityId = ").append(
      this.activityId).append(TAB).append(
      "data1 = ").append(this.data1).append(TAB).append("data2 = ").append(this.data2).append(TAB).append("data3 = ")
      .append(this.data3).append(TAB).append("data4 = ").append(this.data4).append(TAB).append(
      "data5 = ").append(this.data5).append(TAB).append("phoneNumber = ").append(this.phoneNumber).append(TAB).append(
      "template = ").append(
      this.template).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class SmsActivity
