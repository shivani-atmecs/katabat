package com.cmc.credagility.core.domain.schedule;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.StringUtils;


/**
 * This class is used to store channel rule information.
 *
 * <p><a href="ChannelRule.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/15/2014 13:54
 */
@Entity
@Table(name = "ChannelRule")
public class ChannelRule extends BaseRule {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2571042068968270769L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Channel schedule. */
  @JoinColumn(
    name       = "scheduleId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ChannelSchedule channelSchedule = new ChannelSchedule();

  /** Dialer. */
  @Column(
    name   = "dialerTemplate",
    length = 255
  )
  protected String dialerTemplate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "dialerVendorId",
    length = 255
  )
  protected String dialerVendorId;

  /** Templates for each channel. */
  /** Email. */
  @Column(
    name   = "emailTemplate",
    length = 32
  )
  protected String emailTemplate;

  // npelleti 08/11 Inc. len to 255.
  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "emailVendorId",
    length = 255
  )
  protected String emailVendorId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "ivrEndTime",
    length = 255
  )
  protected String ivrEndTime;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "ivrStartTime",
    length = 255
  )
  protected String ivrStartTime;

  // npelleti moved iVRTemplate after ivrStartTime.
  /** IVR. */
  @Column(
    name   = "ivrTemplate",
    length = 32
  )
  protected String ivrTemplate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "ivrVendorId",
    length = 255
  )
  protected String ivrVendorId;


  /** Letter. */
  @Column(
    name   = "letterTemplate",
    length = 32
  )
  protected String letterTemplate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "letterVendorId",
    length = 255
  )
  protected String letterVendorId;

  /** Rule Id, PK. */
  // npelleti, 07/30, USBank, Removed Unique Constraint
  @Column(
    name     = "ruleId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long ruleId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "smsEndTime",
    length = 255
  )
  protected String smsEndTime;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "smsStartTime",
    length = 10
  )
  protected String smsStartTime;

  /** SMS. */
  @Column(
    name   = "smsTemplate",
    length = 32
  )
  protected String smsTemplate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "smsVendorId",
    length = 10
  )
  protected String smsVendorId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Copy criteria only rule.
   *
   * @param  other  DOCUMENT ME!
   */
  public void copyCriteria(ChannelRule other) {
    super.deepCopy(other);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Copy from other rule.
   *
   * @param  other  DOCUMENT ME!
   */
  public void deepCopy(ChannelRule other) {
    super.deepCopy(other);

    this.emailTemplate  = other.getEmailTemplate();
    this.emailVendorId  = other.getEmailVendorId();
    this.letterTemplate = other.getLetterTemplate();
    this.letterVendorId = other.getLetterVendorId();
    this.smsTemplate    = other.getSmsTemplate();
    this.smsVendorId    = other.getSmsVendorId();
    this.smsStartTime   = other.getSmsStartTime();
    this.smsEndTime     = other.getSmsEndTime();
    this.ivrTemplate    = other.getIvrTemplate();
    this.ivrVendorId    = other.getIvrVendorId();
    this.ivrStartTime   = other.getIvrStartTime();
    this.ivrEndTime     = other.getIvrEndTime();
    this.dialerTemplate = other.getDialerTemplate();
    this.dialerVendorId = other.getDialerVendorId();
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

    ChannelRule other = (ChannelRule) obj;

    if (emailTemplate == null) {
      if (other.emailTemplate != null) {
        return false;
      }
    } else if (!emailTemplate.equals(other.emailTemplate)) {
      return false;
    }

    if (emailVendorId == null) {
      if (other.emailVendorId != null) {
        return false;
      }
    } else if (!emailVendorId.equals(other.emailVendorId)) {
      return false;
    }

    if (ivrEndTime == null) {
      if (other.ivrEndTime != null) {
        return false;
      }
    } else if (!ivrEndTime.equals(other.ivrEndTime)) {
      return false;
    }

    if (ivrStartTime == null) {
      if (other.ivrStartTime != null) {
        return false;
      }
    } else if (!ivrStartTime.equals(other.ivrStartTime)) {
      return false;
    }

    if (ivrTemplate == null) {
      if (other.ivrTemplate != null) {
        return false;
      }
    } else if (!ivrTemplate.equals(other.ivrTemplate)) {
      return false;
    }

    if (ivrVendorId == null) {
      if (other.ivrVendorId != null) {
        return false;
      }
    } else if (!ivrVendorId.equals(other.ivrVendorId)) {
      return false;
    }

    if (letterTemplate == null) {
      if (other.letterTemplate != null) {
        return false;
      }
    } else if (!letterTemplate.equals(other.letterTemplate)) {
      return false;
    }

    if (letterVendorId == null) {
      if (other.letterVendorId != null) {
        return false;
      }
    } else if (!letterVendorId.equals(other.letterVendorId)) {
      return false;
    }

    if (dialerVendorId == null) {
      if (other.dialerVendorId != null) {
        return false;
      }
    } else if (!dialerVendorId.equals(other.dialerVendorId)) {
      return false;
    }

    if (dialerTemplate == null) {
      if (other.dialerTemplate != null) {
        return false;
      }
    } else if (!dialerTemplate.equals(other.dialerTemplate)) {
      return false;
    }

    if (smsEndTime == null) {
      if (other.smsEndTime != null) {
        return false;
      }
    } else if (!smsEndTime.equals(other.smsEndTime)) {
      return false;
    }

    if (smsStartTime == null) {
      if (other.smsStartTime != null) {
        return false;
      }
    } else if (!smsStartTime.equals(other.smsStartTime)) {
      return false;
    }

    if (smsTemplate == null) {
      if (other.smsTemplate != null) {
        return false;
      }
    } else if (!smsTemplate.equals(other.smsTemplate)) {
      return false;
    }

    if (smsVendorId == null) {
      if (other.smsVendorId != null) {
        return false;
      }
    } else if (!smsVendorId.equals(other.smsVendorId)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel schedule.
   *
   * @return  ChannelSchedule
   */
  public ChannelSchedule getChannelSchedule() {
    return channelSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Flag for using manual call.
   *
   * @return  flag for using manual call.
   */
  public boolean getDialerInUse() {
    return StringUtils.hasText(dialerTemplate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dialer template.
   *
   * @return  String
   */
  public String getDialerTemplate() {
    return dialerTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dialer vendor id.
   *
   * @return  String
   */
  public String getDialerVendorId() {
    return dialerVendorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * flag for using email.
   *
   * @return  flag for using email.
   */
  public boolean getEmailInUse() {
    return StringUtils.hasText(emailTemplate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email template.
   *
   * @return  String
   */
  public String getEmailTemplate() {
    return emailTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email vendor id.
   *
   * @return  String
   */
  public String getEmailVendorId() {
    return emailVendorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ivr end time.
   *
   * @return  String
   */
  public String getIvrEndTime() {
    return ivrEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * flag for using ivr.
   *
   * @return  flag for using ivr.
   */
  public boolean getIvrInUse() {
    return StringUtils.hasText(ivrTemplate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ivr start time.
   *
   * @return  String
   */
  public String getIvrStartTime() {
    return ivrStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ivr template.
   *
   * @return  String
   */
  public String getIvrTemplate() {
    return ivrTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ivr vendor id.
   *
   * @return  String
   */
  public String getIvrVendorId() {
    return ivrVendorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * flag for using letter.
   *
   * @return  flag for using letter.
   */
  public boolean getLetterInUse() {
    return StringUtils.hasText(letterTemplate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter template.
   *
   * @return  String
   */
  public String getLetterTemplate() {
    return letterTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter vendor id.
   *
   * @return  String
   */
  public String getLetterVendorId() {
    return letterVendorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseRule#getRuleId()
   */
  @Override public Long getRuleId() {
    return ruleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.schedule.BaseRule#getRuleType()
   */
  @Override public String getRuleType() {
    return "ChannelRule";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sms end time.
   *
   * @return  String
   */
  public String getSmsEndTime() {
    return smsEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * flag for using sms.
   *
   * @return  flag for using sms.
   */
  public boolean getSmsInUse() {
    return StringUtils.hasText(smsTemplate);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sms start time.
   *
   * @return  String
   */
  public String getSmsStartTime() {
    return smsStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sms template.
   *
   * @return  String
   */
  public String getSmsTemplate() {
    return smsTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sms vendor id.
   *
   * @return  String
   */
  public String getSmsVendorId() {
    return smsVendorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all used templates.
   *
   * @return  get all used templates.
   */
  public String getSummary() {
    String templates = "";

    if (StringUtils.hasText(emailTemplate)) {
      templates += "email,";
    }

    if (StringUtils.hasText(letterTemplate)) {
      templates += "letter,";
    }

    if (StringUtils.hasText(smsTemplate)) {
      templates += "sms,";
    }

    if (StringUtils.hasText(ivrTemplate)) {
      templates += "ivr,";
    }

    if (StringUtils.hasText(dialerTemplate)) {
      templates += "dialer,";
    }

    if (StringUtils.hasText(templates)) {
      templates = templates.substring(0, templates.length() - 1);
    }

    return templates;
  } // end method getSummary

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all useed template summary.
   *
   * @return  get all useed template summary.
   */
  public List<String> getSummaryList() {
    List<String> list = new ArrayList<String>();

    if (StringUtils.hasText(emailTemplate)) {
      list.add("email");
    }

    if (StringUtils.hasText(letterTemplate)) {
      list.add("letter");
    }

    if (StringUtils.hasText(smsTemplate)) {
      list.add("sms");
    }

    if (StringUtils.hasText(ivrTemplate)) {
      list.add("ivr");
    }

    if (StringUtils.hasText(dialerTemplate)) {
      list.add("dialer");
    }

    return list;
  } // end method getSummaryList

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasChannelInUse.
   *
   * @return  boolean
   */
  public boolean hasChannelInUse() {
    return (getDialerInUse() || getEmailInUse() || getIvrInUse() || getLetterInUse() || getSmsInUse());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // end method getSummaryList

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((emailTemplate == null) ? 0 : emailTemplate.hashCode());
    result = (prime * result)
      + ((emailVendorId == null) ? 0 : emailVendorId.hashCode());
    result = (prime * result)
      + ((ivrEndTime == null) ? 0 : ivrEndTime.hashCode());
    result = (prime * result)
      + ((ivrStartTime == null) ? 0 : ivrStartTime.hashCode());
    result = (prime * result)
      + ((ivrTemplate == null) ? 0 : ivrTemplate.hashCode());
    result = (prime * result)
      + ((ivrVendorId == null) ? 0 : ivrVendorId.hashCode());
    result = (prime * result)
      + ((letterTemplate == null) ? 0 : letterTemplate.hashCode());
    result = (prime * result)
      + ((letterVendorId == null) ? 0 : letterVendorId.hashCode());
    result = (prime * result)
      + ((dialerVendorId == null) ? 0 : dialerVendorId.hashCode());
    result = (prime * result)
      + ((dialerTemplate == null) ? 0 : dialerTemplate.hashCode());
    result = (prime * result)
      + ((smsEndTime == null) ? 0 : smsEndTime.hashCode());
    result = (prime * result)
      + ((smsStartTime == null) ? 0 : smsStartTime.hashCode());
    result = (prime * result)
      + ((smsTemplate == null) ? 0 : smsTemplate.hashCode());
    result = (prime * result)
      + ((smsVendorId == null) ? 0 : smsVendorId.hashCode());

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel schedule.
   *
   * @param  channelSchedule  ChannelSchedule
   */
  public void setChannelSchedule(ChannelSchedule channelSchedule) {
    this.channelSchedule = channelSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dialer template.
   *
   * @param  dialerTemplate  String
   */
  public void setDialerTemplate(String dialerTemplate) {
    this.dialerTemplate = dialerTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dialer vendor id.
   *
   * @param  dialerExecutorId  String
   */
  public void setDialerVendorId(String dialerExecutorId) {
    this.dialerVendorId = dialerExecutorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email template.
   *
   * @param  emailTemplate  String
   */
  public void setEmailTemplate(String emailTemplate) {
    this.emailTemplate = emailTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email vendor id.
   *
   * @param  emailVendorId  String
   */
  public void setEmailVendorId(String emailVendorId) {
    this.emailVendorId = emailVendorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ivr end time.
   *
   * @param  ivrEndTime  String
   */
  public void setIvrEndTime(String ivrEndTime) {
    this.ivrEndTime = ivrEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ivr start time.
   *
   * @param  ivrStartTime  String
   */
  public void setIvrStartTime(String ivrStartTime) {
    this.ivrStartTime = ivrStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ivr template.
   *
   * @param  ivrTemplate  String
   */
  public void setIvrTemplate(String ivrTemplate) {
    this.ivrTemplate = ivrTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ivr vendor id.
   *
   * @param  ivrVendorId  String
   */
  public void setIvrVendorId(String ivrVendorId) {
    this.ivrVendorId = ivrVendorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter template.
   *
   * @param  letterTemplate  String
   */
  public void setLetterTemplate(String letterTemplate) {
    this.letterTemplate = letterTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter vendor id.
   *
   * @param  letterVendorId  String
   */
  public void setLetterVendorId(String letterVendorId) {
    this.letterVendorId = letterVendorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule id.
   *
   * @param  ruleId  Long
   */
  public void setRuleId(Long ruleId) {
    this.ruleId = ruleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms end time.
   *
   * @param  smsEndTime  String
   */
  public void setSmsEndTime(String smsEndTime) {
    this.smsEndTime = smsEndTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms start time.
   *
   * @param  smsStartTime  String
   */
  public void setSmsStartTime(String smsStartTime) {
    this.smsStartTime = smsStartTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms template.
   *
   * @param  smsTemplate  String
   */
  public void setSmsTemplate(String smsTemplate) {
    this.smsTemplate = smsTemplate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sms vendor id.
   *
   * @param  smsVendorId  String
   */
  public void setSmsVendorId(String smsVendorId) {
    this.smsVendorId = smsVendorId;
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

    retValue.append("ChannelRule ( ").append(super.toString()).append(TAB).append("channelSchedule = ").append(
      this.channelSchedule).append(TAB).append("emailTemplate = ").append(this.emailTemplate).append(TAB).append(
      "emailVendorId = ").append(this.emailVendorId).append(TAB).append("ivrEndTime = ").append(this.ivrEndTime).append(
      TAB).append(
      "ivrStartTime = ").append(this.ivrStartTime).append(TAB).append(
      "ivrTemplate = ").append(this.ivrTemplate).append(TAB).append(
      "ivrVendorId = ").append(this.ivrVendorId).append(TAB).append(
      "letterTemplate = ").append(this.letterTemplate).append(TAB).append("letterVendorId = ").append(
      this.letterVendorId).append(TAB).append("dialerVendorId = ").append(this.dialerVendorId).append(TAB).append(
      "dialerTemplate = ").append(this.dialerTemplate).append(TAB).append("ruleId = ").append(this.ruleId).append(TAB)
      .append(
        "smsEndTime = ").append(this.smsEndTime).append(TAB).append(
      "smsStartTime = ").append(this.smsStartTime).append(TAB).append(
      "smsTemplate = ").append(this.smsTemplate).append(TAB).append(
      "smsVendorId = ").append(this.smsVendorId).append(TAB).append(" )");

    return retValue.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update rule form other rule return false if there is no difference return true if there are some difference and
   * update success.
   *
   * @param   channelRule  DOCUMENT ME!
   *
   * @return  update rule form other rule return false if there is no difference return true if there are some
   *          difference and update success.
   */
  public boolean updateRule(ChannelRule channelRule) {
    // if (!equals(channelRule) || !(CompareUtil.nullSafeEquals(this.priority, channelRule.priority))) {

    // there are difference, copy form it
    this.deepCopy(channelRule);

    return true;
      // }
      //
      // return false;
  }
} // end class ChannelRule
