package com.cmc.credagility.core.domain.payment;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;

import org.joda.time.DateTime;

import com.cmc.credagility.core.domain.type.ReminderStatus;
import com.cmc.credagility.core.domain.type.ReminderType;


/**
 * DOCUMENT ME!
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Embeddable public class PaymentReminder implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  private static final long serialVersionUID = -8475170269144858012L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "countryCode",
    length = 128
  )
  protected String countryCode;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "extension",
    length = 128
  )
  protected String extension;

  /** DOCUMENT ME! */
  @Transient protected boolean needEmailReminder = false;

  /**
   * This is a flag indicating whether the user chose reminder or not. It is mainly used to bind value in the web layer
   * in the form of a checkbox so it will not be persisted.
   */
  @Transient protected boolean needReminder = false;

  /** DOCUMENT ME! */
  @Transient protected String needReminderBbd = "";

  /** DOCUMENT ME! */
  @Transient protected boolean needSmsReminder = false;

  /** payment reminder. */
  @Column(name = "reminderAdvanceDay")
  protected Integer reminderAdvanceDay;

  /** payment reminder cc emailAddress address. */
  @Column(
    name   = "reminderCcEmails",
    length = 255
  )
  protected String reminderCcEmails;

  /** payment reminder emailAddress address. */
  @Column(
    name   = "reminderEmail",
    length = 128
  )
  protected String reminderEmail;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "reminderSMS",
    length   = 20
  )
  protected String reminderSMS;

  /** payment reminder type. */
  @Column(
    name   = "reminderType",
    length = 10
  )
  @Enumerated(EnumType.STRING)
  protected ReminderType reminderType = ReminderType.NONE;

  /** TODO: DOCUMENT ME! */
  @Transient protected boolean smsOptIn = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "telephoneCountryCode",
    length = 128
  )
  protected String telephoneCountryCode;

  /**
   * This is a configuration normally used in web layer. Just like needReminder, it should not be persisted. It should
   * not even be bound. It should be populated at the begining of creatingFormObject.
   */
  @Transient private Integer maxReminderDays;

  @Column(name = "reminderDate")
  private Date reminderDate     = null;
  @Column(name = "reminderSentDate")
  private Date reminderSentDate = null;

  @Column(
    name   = "reminderStatus",
    length = 4
  )
  @Enumerated(EnumType.STRING)
  private ReminderStatus reminderStatus = ReminderStatus.INIT;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Business equal comparison used to check whether Payment object is dirty. NULL and Reminder.NONE is considered
   * equal.
   *
   * @param   obj  DOCUMENT ME!
   *
   * @return  business equal comparison used to check whether Payment object is dirty.
   */
  public boolean businessEquals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return ReminderType.NONE.equals(this.reminderType);
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final PaymentReminder other = (PaymentReminder) obj;

    if (reminderAdvanceDay == null) {
      if (other.getReminderAdvanceDay() != null) {
        return false;
      }
    } else if (!reminderAdvanceDay.equals(other.getReminderAdvanceDay())) {
      return false;
    }

    if (reminderCcEmails == null) {
      if (other.getReminderCcEmails() != null) {
        return false;
      }
    } else if (!reminderCcEmails.equals(other.getReminderCcEmails())) {
      return false;
    }

    if (reminderEmail == null) {
      if (other.getReminderEmail() != null) {
        return false;
      }
    } else if (!reminderEmail.equals(other.getReminderEmail())) {
      return false;
    }

    if (reminderType == null) {
      if (other.getReminderType() != null) {
        return false;
      }
    } else if (!reminderType.equals(other.getReminderType())) {
      return false;
    }

    return true;
  } // end method businessEquals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentDate  DOCUMENT ME!
   */
  public void calculateReminderDate(Date paymentDate) {
    if ((paymentDate != null) && !ReminderType.NONE.equals(this.reminderType)
          && (this.reminderAdvanceDay != null)) {
      DateTime pDate = new DateTime(paymentDate);
      DateTime rDate = pDate.minusDays(this.reminderAdvanceDay);
      DateTime now   = new DateTime();

      if (rDate.isBefore(now)) {
        this.reminderDate = now.toDate();
      } else {
        this.reminderDate = rDate.toDate();
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Deep copy for the reminder.
   *
   * @param  paymentReminder  DOCUMENT ME!
   */
  public void deepCopy(PaymentReminder paymentReminder) {
    if (paymentReminder == null) {
      this.setNeedReminder(false);
      this.setReminderType(ReminderType.NONE);

      return;
    }

    this.needReminder      = paymentReminder.needReminder;
    this.reminderType      = paymentReminder.reminderType;
    this.reminderEmail     = paymentReminder.reminderEmail;
    this.reminderCcEmails  = paymentReminder.reminderCcEmails;
    this.reminderDate      = (paymentReminder.reminderDate == null) ? null
                                                                    : new Date(paymentReminder.reminderDate.getTime());
    this.reminderSentDate  = (paymentReminder.reminderSentDate == null)
      ? null : new Date(paymentReminder.reminderSentDate.getTime());
    this.reminderStatus    = paymentReminder.reminderStatus;
    this.needReminderBbd   = paymentReminder.needReminderBbd;
    this.smsOptIn          = paymentReminder.smsOptIn;
    this.reminderSMS       = paymentReminder.reminderSMS;
    this.needEmailReminder = paymentReminder.needEmailReminder;
    this.needSmsReminder   = paymentReminder.needSmsReminder;

    if (paymentReminder.reminderAdvanceDay != null) {
      this.reminderAdvanceDay = new Integer(paymentReminder.reminderAdvanceDay);
    }
  } // end method deepCopy

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    final PaymentReminder other = (PaymentReminder) obj;

    if (reminderDate == null) {
      if (other.getReminderDate() != null) {
        return false;
      }
    } else if (!reminderDate.equals(other.getReminderDate())) {
      return false;
    }

    if (reminderSentDate == null) {
      if (other.getReminderSentDate() != null) {
        return false;
      }
    } else if (!reminderSentDate.equals(other.getReminderSentDate())) {
      return false;
    }

    if (reminderStatus == null) {
      if (other.getReminderStatus() != null) {
        return false;
      }
    } else if (!reminderStatus.equals(other.getReminderStatus())) {
      return false;
    }

    return businessEquals(obj);
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for country code.
   *
   * @return  String
   */
  public String getCountryCode() {
    return countryCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for extension.
   *
   * @return  String
   */
  public String getExtension() {
    return extension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getMaxReminderDays() {
    return maxReminderDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNeedReminderBbd() {
    return needReminderBbd;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The reminderAdvanceDay.
   *
   * @return  the reminderAdvanceDay
   *
   *          <p>not-null = "false"</p>
   */
  public Integer getReminderAdvanceDay() {
    return this.reminderAdvanceDay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The reminderCcEmails.
   *
   * @return  the reminderCcEmails
   *
   *          <p>not-null = "false"</p>
   */
  public String getReminderCcEmails() {
    return this.reminderCcEmails;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The expected reminder sent date.
   *
   * @return  the expected reminder sent date.
   */
  public Date getReminderDate() {
    return reminderDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The reminderEmail.
   *
   * @return  the reminderEmail
   *
   *          <p>not-null = "false" length = "128"</p>
   */
  public String getReminderEmail() {
    return this.reminderEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The actual reminder sent date.
   *
   * @return  the actual reminder sent date.
   */
  public Date getReminderSentDate() {
    return reminderSentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getReminderSMS() {
    return reminderSMS;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The reminder status. "SENT" means already sent.
   *
   * @return  the reminder status.
   *
   *          <p>length = "4" not-null = "false" type = "com.cmc.dao.hibernate.support.ReminderStatusUserType"</p>
   */
  public ReminderStatus getReminderStatus() {
    return reminderStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The reminderType.
   *
   * @return  the reminderType
   *
   *          <p>length = "10" type = "com.cmc.dao.hibernate.support.ReminderTypeUserType"</p>
   */
  public ReminderType getReminderType() {
    return this.reminderType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get reminder type in string.
   *
   * @return  get reminder type in string
   */
  public String getReminderTypeString() {
    return reminderType.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for telephone country code.
   *
   * @return  String
   */
  public String getTelephoneCountryCode() {
    return telephoneCountryCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result)
      + ((reminderAdvanceDay == null) ? 0 : reminderAdvanceDay.hashCode());
    result = (prime * result)
      + ((reminderCcEmails == null) ? 0 : reminderCcEmails.hashCode());
    result = (prime * result)
      + ((reminderEmail == null) ? 0 : reminderEmail.hashCode());
    result = (prime * result)
      + ((reminderType == null) ? 0 : reminderType.hashCode());
    result = (prime * result)
      + ((reminderDate == null) ? 0 : reminderDate.hashCode());
    result = (prime * result)
      + ((reminderSentDate == null) ? 0 : reminderSentDate.hashCode());
    result = (prime * result)
      + ((reminderStatus == null) ? 0 : reminderStatus.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isNeedEmailReminder() {
    return needEmailReminder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isNeedReminder() {
    return needReminder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isNeedSmsReminder() {
    return needSmsReminder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isSmsOptIn() {
    return smsOptIn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for country code.
   *
   * @param  countryCode  String
   */
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for extension.
   *
   * @param  extension  String
   */
  public void setExtension(String extension) {
    this.extension = extension;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  maxReminderDays  DOCUMENT ME!
   */
  public void setMaxReminderDays(Integer maxReminderDays) {
    this.maxReminderDays = maxReminderDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  needEmailReminder  DOCUMENT ME!
   */
  public void setNeedEmailReminder(boolean needEmailReminder) {
    this.needEmailReminder = needEmailReminder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  needReminder  DOCUMENT ME!
   */
  public void setNeedReminder(boolean needReminder) {
    this.needReminder = needReminder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  needReminderBbd  DOCUMENT ME!
   */
  public void setNeedReminderBbd(String needReminderBbd) {
    this.needReminderBbd = needReminderBbd;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  needSmsReminder  DOCUMENT ME!
   */
  public void setNeedSmsReminder(boolean needSmsReminder) {
    this.needSmsReminder = needSmsReminder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  reminderAdvanceDay  the reminderAdvanceDay to set
   */
  public void setReminderAdvanceDay(Integer reminderAdvanceDay) {
    this.reminderAdvanceDay = reminderAdvanceDay;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  reminderCcEmail  DOCUMENT ME! the reminderCcEmails to set
   */
  public void setReminderCcEmails(String reminderCcEmail) {
    this.reminderCcEmails = reminderCcEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  reminderDate  DOCUMENT ME!
   */
  public void setReminderDate(Date reminderDate) {
    this.reminderDate = reminderDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  reminderEmail  the reminderEmail to set
   */
  public void setReminderEmail(String reminderEmail) {
    this.reminderEmail = reminderEmail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  reminderSentDate  DOCUMENT ME!
   */
  public void setReminderSentDate(Date reminderSentDate) {
    this.reminderSentDate = reminderSentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  reminderSMS  DOCUMENT ME!
   */
  public void setReminderSMS(String reminderSMS) {
    this.reminderSMS = reminderSMS;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  reminderStatus  DOCUMENT ME!
   */
  public void setReminderStatus(ReminderStatus reminderStatus) {
    this.reminderStatus = reminderStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  reminderType  the reminderType to set
   */
  public void setReminderType(ReminderType reminderType) {
    this.reminderType = reminderType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  smsOptIn  DOCUMENT ME!
   */
  public void setSmsOptIn(boolean smsOptIn) {
    this.smsOptIn = smsOptIn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for telephone country code.
   *
   * @param  telephoneCountryCode  String
   */
  public void setTelephoneCountryCode(String telephoneCountryCode) {
    this.telephoneCountryCode = telephoneCountryCode;
  }
} // end class PaymentReminder
