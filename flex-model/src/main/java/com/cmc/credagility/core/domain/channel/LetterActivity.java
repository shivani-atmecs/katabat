package com.cmc.credagility.core.domain.channel;

import com.cmc.credagility.core.domain.activity.BaseActivity;
import com.cmc.credagility.core.domain.payment.PaymentProgram;
import com.cmc.credagility.core.domain.user.User;


/**
 * This class is used to log all letter activity.
 *
 * <p><a href="LetterActivity.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 11:03
 */
public class LetterActivity extends BaseActivity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 982751356398398358L;

  /** activity type. */
  private static String CHANNEL = "Letter";

  /** activity type. */
  private static String NAME = "LetterActivity";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Letter Activity PK activityId. */
  protected Long activityId;

  /** Request agent. */
  protected User agent;

  /** data field 1. */
  protected String data1;

  /** data field 2. */
  protected String data2;

  /** data field 3. */
  protected String data3;

  /** data field 4. */
  protected String data4;

  /** data field 5. */
  protected String data5;

  /** Accept program. */
  protected PaymentProgram program;

  /** Letter status. */
  protected String status;

  /** Letter templateType Id. */
  protected String templateId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * The Channel.
   *
   * @return  the Channel
   */
  public static String getCHANNEL() {
    return CHANNEL;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The Name.
   *
   * @return  the Name
   */
  public static String getNAME() {
    return NAME;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setCHANNEL.
   *
   * @param  channel  the cHANNEL to set
   */
  public static void setCHANNEL(String channel) {
    CHANNEL = channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setNAME.
   *
   * @param  name  the nAME to set
   */
  public static void setNAME(String name) {
    NAME = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    final LetterActivity other = (LetterActivity) obj;

    if (this.agent == null) {
      if (other.getAgent() != null) {
        return false;
      }
    } else if (!this.agent.equals(other.getAgent())) {
      return false;
    }

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

    if (this.program == null) {
      if (other.getProgram() != null) {
        return false;
      }
    } else if (!this.program.equals(other.getProgram())) {
      return false;
    }

    if (this.templateId == null) {
      if (other.getTemplateId() != null) {
        return false;
      }
    } else if (!this.templateId.equals(other.getTemplateId())) {
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
   * The agent.
   *
   * @return  the agent
   *
   *          <p>lazy = "proxy" column = "agentId" not-null = "false" class = "com.cmc.credagility.User" insert = "true"
   *          update = "true"</p>
   */
  public User getAgent() {
    return this.agent;
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

  /**
   * @see  com.cmc.credagility.core.domain.activity.BaseActivity#getName()
   */
  @Override public String getName() {
    return NAME;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The program.
   *
   * @return  the program
   *
   *          <p>lazy = "proxy" column = "programId" not-null = "false" class = "com.cmc.credagility.PaymentProgram"
   *          insert = "true" update = "false" length = "20"</p>
   */
  public PaymentProgram getProgram() {
    return this.program;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The status.
   *
   * @return  the status
   *
   *          <p>not-null = "true" length = "16"</p>
   */
  @Override public String getStatus() {
    return this.status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The templateType.
   *
   * @return  the templateType
   *
   *          <p>not-null = "false"</p>
   */
  public String getTemplateId() {
    return this.templateId;
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
      + ((this.agent == null) ? 0 : this.agent.hashCode());
    result = (prime * result)
      + ((this.data1 == null) ? 0 : this.data1.hashCode());
    result = (prime * result)
      + ((this.data2 == null) ? 0 : this.data2.hashCode());
    result = (prime * result)
      + ((this.data3 == null) ? 0 : this.data3.hashCode());
    result = (prime * result)
      + ((this.data4 == null) ? 0 : this.data4.hashCode());
    result = (prime * result)
      + ((this.data5 == null) ? 0 : this.data5.hashCode());
    result = (prime * result)
      + ((this.program == null) ? 0 : this.program.hashCode());
    result = (prime * result)
      + ((this.templateId == null) ? 0 : this.templateId.hashCode());

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
   * setAgent.
   *
   * @param  agent  the agent to set
   */
  public void setAgent(User agent) {
    this.agent = agent;
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
   * setProgram.
   *
   * @param  program  the payment program to set
   */
  public void setProgram(PaymentProgram program) {
    this.program = program;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setStatus.
   *
   * @param  status  the status to set
   */
  @Override public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTemplateId.
   *
   * @param  templateId  the templateId to set
   */
  public void setTemplateId(String templateId) {
    this.templateId = templateId;
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

    retValue.append("LetterActivity ( ").append(super.toString()).append(TAB).append("activityId = ").append(
      this.activityId).append(TAB).append(
      "agent = ").append(this.agent).append(TAB).append("data1 = ").append(this.data1).append(TAB).append("data2 = ")
      .append(this.data2).append(TAB).append("data3 = ").append(this.data3).append(TAB).append(
      "data4 = ").append(this.data4).append(TAB).append("data5 = ").append(this.data5).append(TAB).append(
      "programId = ").append(
      this.program).append(TAB).append("status = ").append(this.status).append(TAB).append("templateId = ").append(
      this.templateId).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class LetterActivity
