package com.cmc.credagility.core.domain.client;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.activity.AgentCallActivity;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.AppointmentStatus;
import com.cmc.credagility.core.domain.util.DateUtil;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store all advisor appointment.
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/14/2014 16:13
 */
@Entity
@Table(name = "AdvisorAppointment")
public class AdvisorAppointment extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 898171682604492279L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account, Refers {@link Account}. */
  @JoinColumn(
    name       = "accountNum",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;


  /** Agent call activity, Refers {@link AgentCallActivity}. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "advisorAppointment",
    cascade       = { CascadeType.ALL },
    orphanRemoval = true
  )
  @OrderBy("createDate asc")
  protected Set<AgentCallActivity> agentCallActivities = new LinkedHashSet<AgentCallActivity>();

  // npelleti, 07/29, USB, Added Annotation for column NotNull
  /** appointment date. */
  @Column(
    name     = "appointmentDateStr",
    nullable = false,
    length   = 10
  )
  protected String appointmentDateStr;

  // npelleti, 07/29, USB, Added Annotation for column NotNull
  /** appointment time. */
  @Column(
    name     = "appointmentDateTime",
    nullable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date appointmentDateTime;

  // npelleti, 07/30, USBank, Removed unique constraint
  /** advisor appointment PK appointmentId. */
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long         appointmentId;

  // npelleti, 07/29, USB, Added Annotation for column NotNull
  /** appointment time. */
  @Column(
    name     = "appointmentStartTimeStr",
    nullable = false,
    length   = 10
  )
  protected String appointmentStartTimeStr;

  // npelleti, 07/29, USB, Added Annotation for column NotNull
  /** user time zone. */
  @Column(
    name     = "appointmentTimeZoneId",
    nullable = false,
    length   = 45
  )
  protected String appointmentTimeZoneId;


  /** Assigned agent id. */
  @Column(name = "assignedAgentId")
  protected Long assignedAgentId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "byAppointmentPhone",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean byAppointmentPhone;

  /** This is the flag representing the "otherPhoneNum" that can be manually entered on the appointment screens. */
  @Column(
    name             = "byApptOnlyOtherPhone",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean byApptOnlyOtherPhone;


  /** This is the flag representing the "homePhoneNum" that can be manually entered on the appointment screens. */
  @Column(
    name             = "byHomePhone",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean byHomePhone;


  /** This is the flag representing the "mobilePhoneNum" that can be manually entered on the appointment screens. */
  @Column(
    name             = "byMobilePhone",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean byMobilePhone;


  /** This is the flag representing the "otherPhoneNum" that can be manually entered on the appointment screens. */
  @Column(
    name             = "byOtherPhone",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean byOtherPhone;


  /** This is the flag representing the "schoolPhoneNum" that can be manually entered on the appointment screens. */
  @Column(
    name             = "bySchoolPhone",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean bySchoolPhone;


  /** This is the flag representing the "workPhoneNum" that can be manually entered on the appointment screens. */
  @Column(
    name             = "byWorkPhone",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean byWorkPhone;


  /** Call agent id. */
  @Column(name = "callAgentId")
  protected Long callAgentId;

  /** appointment comments. */
  @Column(
    name   = "comments",
    length = 1023
  )
  protected String comments;


  /** Contact phone types. */
  @Column(
    name     = "contactPhoneTypes",
    length   = 400,
    nullable = true
  )
  protected String contactPhoneTypes;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "countryCode",
    length = 3
  )
  protected String countryCode;


  /** Create agent id. */
  @Column(name = "createAgentId")
  protected Long createAgentId;

  // npelleti, 07/29, USB, Added Annotation for column NotNull

  /** Language. */
  @Column(
    name     = "language",
    nullable = false,
    length   = 30
  )
  protected String language;


  /** last update agent id. */
  @Column(name = "lastUpdateAgentId")
  protected Long lastUpdateAgentId;


  /** Other phone number. */
  @Column(
    name     = "otherPhoneNum",
    length   = 20,
    nullable = true
  )
  protected String otherPhoneNum;

  /** responsible. */
  @JoinColumn(
    name      = "responsibleId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;


  // npelleti, 07/30, USBank, Added NotNull Annotation
  /** Status. */
  @Column(
    name     = "status",
    nullable = false,
    length   = 20
  )
  @Enumerated(value = EnumType.STRING)
  protected AppointmentStatus status;
  @Column(
    name   = "telephoneCountryCode",
    length = 10
  )
  private String              telephoneCountryCode;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Adds a agent call activity for the account.
   *
   * @param   activity  invoice
   *
   * @return  adds a agent call activity for the account
   */
  public boolean addAgentCallActivity(AgentCallActivity activity) {
    activity.setAdvisorAppointment(this);

    return getAgentCallActivities().add(activity);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   obj  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean businessEqualsWithoutCheckingPhones(Object obj) {
    if (!this.equals(obj)) {
      return false;
    }

    AdvisorAppointment appt = (AdvisorAppointment) obj;

    if (comments == null) {
      if (appt.getAppointmentDateTime() != null) {
        return false;
      }
    } else if (!comments.equals(appt.getComments())) {
      return false;
    }

    if (this.getStatus() == null) {
      if (appt.getStatus() != null) {
        return false;
      }
    } else if (!this.getStatus().equals(appt.getStatus())) {
      return false;
    }

    // Now appt1 and appt2 all has value - compare contents
    if ((this.getByHomePhone() == appt.getByHomePhone())
          && (this.getByWorkPhone() == appt.getByWorkPhone())
          && (this.getByMobilePhone() == appt.getByMobilePhone())
          && (this.getByOtherPhone() == appt.getByOtherPhone())
          && this.getLanguage().equalsIgnoreCase(appt.getLanguage())) {
      return true;
    }

    return false;
  } // end method businessEqualsWithoutCheckingPhones

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */

  // end method businessEqualsWithoutCheckingPhones

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final AdvisorAppointment other = (AdvisorAppointment) obj;

    if (appointmentDateTime == null) {
      if (other.getAppointmentDateTime() != null) {
        return false;
      }
    } else if (!appointmentDateTime.equals(other.getAppointmentDateTime())) {
      return false;
    }

    if (this.getStatus() == null) {
      if (other.getStatus() != null) {
        return false;
      }
    } else if (!this.getStatus().equals(other.getStatus())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent call activities.
   *
   * @return  Set
   */
  public Set<AgentCallActivity> getAgentCallActivities() {
    return agentCallActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for appointment date str.
   *
   * @return  String
   */
  public String getAppointmentDateStr() {
    return appointmentDateStr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for appointment date time.
   *
   * @return  Date
   */
  public Date getAppointmentDateTime() {
    return appointmentDateTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for appointment id.
   *
   * @return  Long
   */
  public Long getAppointmentId() {
    return appointmentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for appointment start time str.
   *
   * @return  String
   */
  public String getAppointmentStartTimeStr() {
    return appointmentStartTimeStr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for appointment time zone id.
   *
   * @return  String
   */
  public String getAppointmentTimeZoneId() {
    return appointmentTimeZoneId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for assigned agent id.
   *
   * @return  Long
   */
  public Long getAssignedAgentId() {
    return assignedAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for by appointment phone.
   *
   * @return  Boolean
   */
  public Boolean getByAppointmentPhone() {
    if (byAppointmentPhone == null) {
      return false;
    } else {
      return byAppointmentPhone;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for by appt only other phone.
   *
   * @return  Boolean
   */
  public Boolean getByApptOnlyOtherPhone() {
    if (byApptOnlyOtherPhone == null) {
      return false;
    } else {
      return byApptOnlyOtherPhone;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for by home phone.
   *
   * @return  Boolean
   */
  public Boolean getByHomePhone() {
    if (byHomePhone == null) {
      return false;
    } else {
      return byHomePhone;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for by mobile phone.
   *
   * @return  Boolean
   */
  public Boolean getByMobilePhone() {
    if (byMobilePhone == null) {
      return false;
    } else {
      return byMobilePhone;
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for by other phone.
   *
   * @return  Boolean
   */
  public Boolean getByOtherPhone() {
    if (byOtherPhone == null) {
      return false;
    } else {
      return byOtherPhone;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for by school phone.
   *
   * @return  Boolean
   */
  public Boolean getBySchoolPhone() {
    if (bySchoolPhone == null) {
      return false;
    } else {
      return bySchoolPhone;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for by work phone.
   *
   * @return  Boolean
   */
  public Boolean getByWorkPhone() {
    if (byWorkPhone == null) {
      return false;
    } else {
      return byWorkPhone;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call agent id.
   *
   * @return  Long
   */
  public Long getCallAgentId() {
    return callAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for comments.
   *
   * @return  String
   */
  public String getComments() {
    return comments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact phone types.
   *
   * @return  List
   */
  public List<String> getContactPhoneTypes() {
    List<String> types = new ArrayList<String>();

    if (contactPhoneTypes != null) {
      String[] split = contactPhoneTypes.split("\\|");

      for (String s : split) {
        types.add(s);
      }
    }

    return types;
  }

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
   * getter method for create agent id.
   *
   * @return  Long
   */
  public Long getCreateAgentId() {
    return createAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for do not contact until.
   *
   * @return  Date
   */
  public Date getDoNotContactUntil() {
    Date d = null;

    if (appointmentDateTime == null) {
      d = new Date();
    } else {
      d = appointmentDateTime;
    }

    Integer days = getAccount().getPortfolio().getDoNotContactApptDays();

    return DateUtil.addDays(d, days);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for language.
   *
   * @return  String
   */
  public String getLanguage() {
    return language;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last update agent id.
   *
   * @return  Long
   */
  public Long getLastUpdateAgentId() {
    return lastUpdateAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other phone num.
   *
   * @return  String
   */
  public String getOtherPhoneNum() {
    return otherPhoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  AppointmentStatus
   */
  public AppointmentStatus getStatus() {
    return status;
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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result)
      + ((appointmentDateTime == null) ? 0 : appointmentDateTime.hashCode());
    result = (prime * result)
      + ((appointmentTimeZoneId == null) ? 0 : appointmentTimeZoneId.hashCode());
    result = (prime * result)
      + ((status == null) ? 0 : status.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent call activities.
   *
   * @param  agentCallActivities  Set
   */
  public void setAgentCallActivities(Set<AgentCallActivity> agentCallActivities) {
    this.agentCallActivities = agentCallActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for appointment date str.
   *
   * @param  appointmentDateStr  String
   */
  public void setAppointmentDateStr(String appointmentDateStr) {
    this.appointmentDateStr = appointmentDateStr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for appointment date time.
   *
   * @param  appointmentDateTime  Date
   */
  public void setAppointmentDateTime(Date appointmentDateTime) {
    this.appointmentDateTime = appointmentDateTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for appointment id.
   *
   * @param  appointmentId  Long
   */
  public void setAppointmentId(Long appointmentId) {
    this.appointmentId = appointmentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for appointment start time str.
   *
   * @param  appointmentStartTimeStr  String
   */
  public void setAppointmentStartTimeStr(String appointmentStartTimeStr) {
    this.appointmentStartTimeStr = appointmentStartTimeStr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for appointment time zone id.
   *
   * @param  appointmentTimeZoneId  String
   */
  public void setAppointmentTimeZoneId(String appointmentTimeZoneId) {
    this.appointmentTimeZoneId = appointmentTimeZoneId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for assigned agent id.
   *
   * @param  assignedAgentId  Long
   */
  public void setAssignedAgentId(Long assignedAgentId) {
    this.assignedAgentId = assignedAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for by appointment phone.
   *
   * @param  byAppointmentPhone  Boolean
   */
  public void setByAppointmentPhone(Boolean byAppointmentPhone) {
    this.byAppointmentPhone = byAppointmentPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for by appt only other phone.
   *
   * @param  byApptOnlyOtherPhone  Boolean
   */
  public void setByApptOnlyOtherPhone(Boolean byApptOnlyOtherPhone) {
    this.byApptOnlyOtherPhone = byApptOnlyOtherPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for by home phone.
   *
   * @param  byHomePhone  Boolean
   */
  public void setByHomePhone(Boolean byHomePhone) {
    this.byHomePhone = byHomePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for by mobile phone.
   *
   * @param  byMobilePhone  Boolean
   */
  public void setByMobilePhone(Boolean byMobilePhone) {
    this.byMobilePhone = byMobilePhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for by other phone.
   *
   * @param  byOtherPhone  Boolean
   */
  public void setByOtherPhone(Boolean byOtherPhone) {
    this.byOtherPhone = byOtherPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for by school phone.
   *
   * @param  bySchoolPhone  Boolean
   */
  public void setBySchoolPhone(Boolean bySchoolPhone) {
    this.bySchoolPhone = bySchoolPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for by work phone.
   *
   * @param  byWorkPhone  Boolean
   */
  public void setByWorkPhone(Boolean byWorkPhone) {
    this.byWorkPhone = byWorkPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call agent id.
   *
   * @param  callAgentId  Long
   */
  public void setCallAgentId(Long callAgentId) {
    this.callAgentId = callAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for comments.
   *
   * @param  comments  String
   */
  public void setComments(String comments) {
    this.comments = comments;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact phone types.
   *
   * @param  contactPhoneTypes  Collection
   */
  public void setContactPhoneTypes(Collection<String> contactPhoneTypes) {
    String contactPhonesString = null;

    if ((contactPhoneTypes != null) && !contactPhoneTypes.isEmpty()) {
      StringBuilder sb = new StringBuilder();

      for (String s : contactPhoneTypes) {
        sb.append(s).append("|");
      }

      contactPhonesString = sb.substring(0, sb.length() - 1).toString();
    }

    this.contactPhoneTypes = contactPhonesString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact phone types.
   *
   * @param  contactPhoneTypes  String
   */
  public void setContactPhoneTypes(String contactPhoneTypes) {
    this.contactPhoneTypes = contactPhoneTypes;
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
   * setter method for create agent id.
   *
   * @param  createAgentId  Long
   */
  public void setCreateAgentId(Long createAgentId) {
    this.createAgentId = createAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for language.
   *
   * @param  language  String
   */
  public void setLanguage(String language) {
    this.language = language;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last update agent id.
   *
   * @param  lastUpdateAgentId  Long
   */
  public void setLastUpdateAgentId(Long lastUpdateAgentId) {
    this.lastUpdateAgentId = lastUpdateAgentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other phone num.
   *
   * @param  otherPhoneNum  String
   */
  public void setOtherPhoneNum(String otherPhoneNum) {
    this.otherPhoneNum = otherPhoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  AppointmentStatus
   */
  public void setStatus(AppointmentStatus status) {
    this.status = status;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("AdvisorAppointment ( ").append("appointmentId = ").append(
      this.appointmentId).append(TAB).append("appointmentDateStr = ").append(
      this.appointmentDateStr).append(TAB).append("appointmentDateTime = ").append(this.appointmentDateTime).append(TAB)
      .append(
        "appointmentStartTimeStr = ").append(this.appointmentStartTimeStr).append(TAB).append("comments = ").append(
      this.comments).append(TAB).append("responsible = ").append(this.responsible).append(TAB).append(
      "appointmentTimeZoneId = ").append(this.appointmentTimeZoneId).append(TAB).append(" )");

    return retValue.toString();
  }
  // Added by RamaKrishna on 07/27/09 for SLM --END
} // end class AdvisorAppointment
