package com.cmc.credagility.core.domain.schedule;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.type.ScheduleStatus;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store base portfolio schedule information.
 *
 * <p><a href="BaseSchedule.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class BaseSchedule extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -602289039478388533L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** complete package content. */
  @Column(
    columnDefinition = "LONGTEXT",
    name             = "packageContent"
  )
  @Lob protected String packageContent;

  /** flag for preview. */
  @Transient protected boolean preview = false;

  /** TODO: DOCUMENT ME! */
  @Column(name = "ruleBatchId")
  protected Long ruleBatchId;

  /** un-published changes *. */
  @Column(
    name             = "unPublishedChanges",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean unPublishedChanges = true;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "userData1",
    columnDefinition = "LONGTEXT"
  )
  @Lob protected String userData1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "userData2",
    columnDefinition = "LONGTEXT"
  )
  @Lob protected String userData2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "userData3",
    columnDefinition = "LONGBLOB"
  )
  @Lob protected byte[] userData3;

  /** The user who created the schedule. */
  @JoinColumn(
    name       = "creatorId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private User creator;

  /** Description for the schedule. */
  @Column(
    name   = "description",
    length = 255
  )
  private String description;

  /** The last user who updated the agencyQueue. */
  @JoinColumn(
    name       = "lastUpdateUserId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private User lastUpdateUser;

  /** The portfolio which schedule belong to. */
  @JoinColumn(
    name       = "portfolioId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Portfolio portfolio = new Portfolio();

  /** scheduled date. */
  @Column(name = "scheduleDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date scheduleDate;


// npelleti, 07/30, USBank, Removed unique constraint
  /** primary key. */
  @Column(
    name     = "scheduleId",

    // unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long scheduleId;

  /** Scheduled status. */
  @Column(
    name     = "scheduleStatus",
    length   = 12,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  private ScheduleStatus scheduleStatus;

  /** Flag for viewOnly. */
  @Transient private boolean viewOnly = true;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Deploy rules from draft set and discard the current deployed set.
   *
   * @return  deploy rules from draft set and discard the current deployed set
   */
  public abstract boolean deployRules();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Duplicate the schedule and all rules.
   *
   * @return  duplicate the schedule and all rules
   */
  public abstract BaseSchedule duplicate();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Duplicate the scheulde and all rules for other portfolio.
   *
   * @param   portfolio  DOCUMENT ME!
   *
   * @return  duplicate the scheulde and all rules for other portfolio
   */
  public abstract BaseSchedule duplicate(Portfolio portfolio);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the deployed rule set.
   *
   * @return  get the deployed rule set
   */
  public abstract Set<BaseRule> getDeployedRules();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the draft rule set.
   *
   * @return  get the draft rule set
   */
  public abstract Set<BaseRule> getDraftRules();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule type.
   *
   * @return  String
   */
  public abstract String getScheduleType();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The deployed.
   *
   * @return  the deployed
   */
  public abstract boolean isDeployed();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Reload rules from deployed set and discard the current draft set.
   */
  public abstract void reloadRules();

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

    BaseSchedule other = (BaseSchedule) obj;

    if (description == null) {
      if (other.description != null) {
        return false;
      }
    } else if (!description.equals(other.description)) {
      return false;
    }

    if (scheduleDate == null) {
      if (other.scheduleDate != null) {
        return false;
      }
    } else if (!scheduleDate.equals(other.scheduleDate)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all deployed rule of the schedule.
   *
   * @return  get all deployed rule of the schedule
   */
  public Set<BaseRule> getAllDeployedRules() {
    return getDeployedRules();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all draft rule of the schedule.
   *
   * @return  get all draft rule of the schedule
   */
  public Set<BaseRule> getAllDraftRules() {
    return getDraftRules();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for creator.
   *
   * @return  User
   */
  public User getCreator() {
    return creator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last update user.
   *
   * @return  User
   */
  public User getLastUpdateUser() {
    return lastUpdateUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for package content.
   *
   * @return  String
   */
  public String getPackageContent() {
    return packageContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule batch id.
   *
   * @return  Long
   */
  public Long getRuleBatchId() {
    return ruleBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule date.
   *
   * @return  Date
   */
  public Date getScheduleDate() {
    return scheduleDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule id.
   *
   * @return  Long
   */
  public Long getScheduleId() {
    return scheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule status.
   *
   * @return  ScheduleStatus
   */
  public ScheduleStatus getScheduleStatus() {
    return scheduleStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for un published changes.
   *
   * @return  Boolean
   */
  public Boolean getUnPublishedChanges() {
    return unPublishedChanges;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user data1.
   *
   * @return  String
   */
  public String getUserData1() {
    return userData1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user data2.
   *
   * @return  String
   */
  public String getUserData2() {
    return userData2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user data3.
   *
   * @return  byte[]
   */
  public byte[] getUserData3() {
    return userData3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((description == null) ? 0 : description.hashCode());
    result = (prime * result)
      + ((scheduleDate == null) ? 0 : scheduleDate.hashCode());
    result = (prime * result)
      + ((portfolio == null) ? 0 : portfolio.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Flag whether there is rule in rule repository.
   *
   * @return  flag whether there is rule in rule repository
   */
  public boolean hasRuleInRepo() {
    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * init.
   *
   * @param  other  BaseSchedule
   */
  public void init(BaseSchedule other) {
    this.scheduleDate   = new Date();
    this.scheduleStatus = ScheduleStatus.DRAFT;
    this.description    = other.getDescription();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for preview.
   *
   * @return  boolean
   */
  public boolean isPreview() {
    return preview;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Flag which the schedule could be changed.
   *
   * <p>1. ACTIVE/OLD schedule could not be changed</p>
   *
   * <p>2. Schedule belong to view only portfolio could not be changed</p>
   *
   * @return  the readOnly
   */
  public boolean isReadOnly() {
    if ((scheduleStatus == ScheduleStatus.ACTIVE)
          || (scheduleStatus == ScheduleStatus.OLD)) {
      return true;
    } else {
      return viewOnly;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The viewOnly.
   *
   * @return  the viewOnly
   */
  public boolean isViewOnly() {
    return viewOnly;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for creator.
   *
   * @param  creator  User
   */
  public void setCreator(User creator) {
    this.creator = creator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last update user.
   *
   * @param  lastUpdateUser  User
   */
  public void setLastUpdateUser(User lastUpdateUser) {
    this.lastUpdateUser = lastUpdateUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for package content.
   *
   * @param  packageContent  String
   */
  public void setPackageContent(String packageContent) {
    this.packageContent = packageContent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for preview.
   *
   * @param  preview  boolean
   */
  public void setPreview(boolean preview) {
    this.preview = preview;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule batch id.
   *
   * @param  ruleBatchId  Long
   */
  public void setRuleBatchId(Long ruleBatchId) {
    this.ruleBatchId = ruleBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule date.
   *
   * @param  scheduleDate  Date
   */
  public void setScheduleDate(Date scheduleDate) {
    this.scheduleDate = scheduleDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule id.
   *
   * @param  scheduleId  Long
   */
  public void setScheduleId(Long scheduleId) {
    this.scheduleId = scheduleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule status.
   *
   * @param  scheduleStatus  ScheduleStatus
   */
  public void setScheduleStatus(ScheduleStatus scheduleStatus) {
    this.scheduleStatus = scheduleStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for un published changes.
   *
   * @param  unPublishedChanges  Boolean
   */
  public void setUnPublishedChanges(Boolean unPublishedChanges) {
    this.unPublishedChanges = unPublishedChanges;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user data1.
   *
   * @param  userData1  String
   */
  public void setUserData1(String userData1) {
    this.userData1 = userData1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user data2.
   *
   * @param  userData2  String
   */
  public void setUserData2(String userData2) {
    this.userData2 = userData2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user data3.
   *
   * @param  userData3  byte[]
   */
  public void setUserData3(byte[] userData3) {
    this.userData3 = userData3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for view only.
   *
   * @param  viewOnly  boolean
   */
  public void setViewOnly(boolean viewOnly) {
    this.viewOnly = viewOnly;
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

    retValue.append("BaseSchedule ( ").append(super.toString()).append(TAB).append("creator = ").append(this.creator)
      .append(TAB).append(
      "description = ").append(this.description).append(TAB).append(
      "lastUpdateUser = ").append(this.lastUpdateUser).append(TAB).append("portfolio = ").append(this.portfolio).append(
      TAB).append(
      "scheduleDate = ").append(this.scheduleDate).append(TAB).append(
      "scheduleId = ").append(this.scheduleId).append(TAB).append(
      "scheduleStatus = ").append(this.scheduleStatus).append(TAB).append("viewOnly = ").append(this.viewOnly).append(
      TAB).append(" )");

    return retValue.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update schedule based on passed in template Only update schedule it self but not the related rules.
   *
   * @param   schedule  DOCUMENT ME!
   *
   * @return  update schedule based on passed in template Only update schedule it self but not the related rules
   */
  public boolean updateSchedule(BaseSchedule schedule) {
    if (!this.equals(schedule)) {
      this.description    = schedule.getDescription();
      this.lastUpdateDate = new Date();
      this.lastUpdateUser = schedule.getCreator();
      this.portfolio      = schedule.getPortfolio();

      Date date = schedule.getScheduleDate();

      if (date != null) {
        this.scheduleDate = new Date(date.getTime());
      }

      return true;
    }

    return false;
  }
} // end class BaseSchedule
