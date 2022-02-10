package com.cmc.credagility.core.domain.preview;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.contact.PhoneType;
import com.cmc.credagility.core.domain.type.PreviewDialingStatus;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/14/2014 18:17
 */
@Entity
@Table(name = "PreviewDialing")
public class PreviewDialing extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -19485719834756197L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "PreviewDialingAccountList",
    indexes            = { @Index(columnList = "previewDialingId") },
    joinColumns        = {
      @JoinColumn(
        name           = "previewDialingId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "accountNum",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(cascade = { CascadeType.ALL })
  protected List<Account> accountList = new ArrayList<Account>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agentId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected User agent;

  /** TODO: DOCUMENT ME! */
  @Column protected BigDecimal balanceWorked;

  /** TODO: DOCUMENT ME! */
  @Column protected Long dialingInterval;

  /** TODO: DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         endDate;

  /** TODO: DOCUMENT ME! */
  @Column protected Long filterId;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean isDialed = false;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer lockedByOther;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer noPhoneNumFound;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer notWorkable;

  /** TODO: DOCUMENT ME! */
  @Column protected Long queueId;

  /** TODO: DOCUMENT ME! */
  @Column protected Long sorterId;

  /** TODO: DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         startDate;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  @Enumerated(value = EnumType.STRING)
  protected PreviewDialingStatus status = PreviewDialingStatus.WAITING;

  /** TODO: DOCUMENT ME! */
  @Column protected String target;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "phoneTypeId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected PhoneType targetPhoneType;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean toBeNextAccount;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer totalAccounts;

  /** TODO: DOCUMENT ME! */
  @Column protected Integer totalDialed;

  /** TODO: DOCUMENT ME! */
  @Column protected Long workCount;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PreviewDialing)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PreviewDialing that = (PreviewDialing) o;

    if ((accountList != null) ? (!accountList.equals(that.accountList)) : (that.accountList != null)) {
      return false;
    }

    if ((agent != null) ? (!agent.equals(that.agent)) : (that.agent != null)) {
      return false;
    }

    if ((balanceWorked != null) ? (!balanceWorked.equals(that.balanceWorked)) : (that.balanceWorked != null)) {
      return false;
    }

    if ((dialingInterval != null) ? (!dialingInterval.equals(that.dialingInterval)) : (that.dialingInterval != null)) {
      return false;
    }

    if ((endDate != null) ? (!endDate.equals(that.endDate)) : (that.endDate != null)) {
      return false;
    }

    if ((filterId != null) ? (!filterId.equals(that.filterId)) : (that.filterId != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((isDialed != null) ? (!isDialed.equals(that.isDialed)) : (that.isDialed != null)) {
      return false;
    }

    if ((lockedByOther != null) ? (!lockedByOther.equals(that.lockedByOther)) : (that.lockedByOther != null)) {
      return false;
    }

    if ((noPhoneNumFound != null) ? (!noPhoneNumFound.equals(that.noPhoneNumFound)) : (that.noPhoneNumFound != null)) {
      return false;
    }

    if ((notWorkable != null) ? (!notWorkable.equals(that.notWorkable)) : (that.notWorkable != null)) {
      return false;
    }

    if ((queueId != null) ? (!queueId.equals(that.queueId)) : (that.queueId != null)) {
      return false;
    }

    if ((sorterId != null) ? (!sorterId.equals(that.sorterId)) : (that.sorterId != null)) {
      return false;
    }

    if ((startDate != null) ? (!startDate.equals(that.startDate)) : (that.startDate != null)) {
      return false;
    }

    if (status != that.status) {
      return false;
    }

    if ((target != null) ? (!target.equals(that.target)) : (that.target != null)) {
      return false;
    }

    if ((targetPhoneType != null) ? (!targetPhoneType.equals(that.targetPhoneType)) : (that.targetPhoneType != null)) {
      return false;
    }

    if ((toBeNextAccount != null) ? (!toBeNextAccount.equals(that.toBeNextAccount)) : (that.toBeNextAccount != null)) {
      return false;
    }

    if ((totalAccounts != null) ? (!totalAccounts.equals(that.totalAccounts)) : (that.totalAccounts != null)) {
      return false;
    }

    if ((totalDialed != null) ? (!totalDialed.equals(that.totalDialed)) : (that.totalDialed != null)) {
      return false;
    }

    if ((workCount != null) ? (!workCount.equals(that.workCount)) : (that.workCount != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account list.
   *
   * @return  List
   */
  public List<Account> getAccountList() {
    return accountList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent.
   *
   * @return  User
   */
  public User getAgent() {
    return agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for balance worked.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBalanceWorked() {
    return balanceWorked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dialed.
   *
   * @return  Boolean
   */
  public Boolean getDialed() {
    if (isDialed == null) {
      return Boolean.FALSE;
    }

    return isDialed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dialing interval.
   *
   * @return  Long
   */
  public Long getDialingInterval() {
    return dialingInterval;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end date.
   *
   * @return  Date
   */
  public Date getEndDate() {
    return endDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for filter id.
   *
   * @return  Long
   */
  public Long getFilterId() {
    return filterId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for locked by other.
   *
   * @return  Integer
   */
  public Integer getLockedByOther() {
    return lockedByOther;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for no phone num found.
   *
   * @return  Integer
   */
  public Integer getNoPhoneNumFound() {
    return noPhoneNumFound;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for not workable.
   *
   * @return  Integer
   */
  public Integer getNotWorkable() {
    return notWorkable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue id.
   *
   * @return  Long
   */
  public Long getQueueId() {
    return queueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sorter id.
   *
   * @return  Long
   */
  public Long getSorterId() {
    return sorterId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for start date.
   *
   * @return  Date
   */
  public Date getStartDate() {
    return startDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  PreviewDialingStatus
   */
  public PreviewDialingStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for target.
   *
   * @return  String
   */
  public String getTarget() {
    return target;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for target phone type.
   *
   * @return  PhoneType
   */
  public PhoneType getTargetPhoneType() {
    return targetPhoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for to be next account.
   *
   * @return  Boolean
   */
  public Boolean getToBeNextAccount() {
    if (toBeNextAccount == null) {
      return Boolean.FALSE;
    }

    return toBeNextAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total accounts.
   *
   * @return  Integer
   */
  public Integer getTotalAccounts() {
    return totalAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total dialed.
   *
   * @return  Integer
   */
  public Integer getTotalDialed() {
    return totalDialed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for work count.
   *
   * @return  Long
   */
  public Long getWorkCount() {
    return workCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((isDialed != null) ? isDialed.hashCode() : 0);
    result = (31 * result) + ((agent != null) ? agent.hashCode() : 0);
    result = (31 * result) + ((queueId != null) ? queueId.hashCode() : 0);
    result = (31 * result) + ((filterId != null) ? filterId.hashCode() : 0);
    result = (31 * result) + ((sorterId != null) ? sorterId.hashCode() : 0);
    result = (31 * result) + ((accountList != null) ? accountList.hashCode() : 0);
    result = (31 * result) + ((target != null) ? target.hashCode() : 0);
    result = (31 * result) + ((targetPhoneType != null) ? targetPhoneType.hashCode() : 0);
    result = (31 * result) + ((dialingInterval != null) ? dialingInterval.hashCode() : 0);
    result = (31 * result) + ((workCount != null) ? workCount.hashCode() : 0);
    result = (31 * result) + ((toBeNextAccount != null) ? toBeNextAccount.hashCode() : 0);
    result = (31 * result) + ((startDate != null) ? startDate.hashCode() : 0);
    result = (31 * result) + ((endDate != null) ? endDate.hashCode() : 0);
    result = (31 * result) + ((status != null) ? status.hashCode() : 0);
    result = (31 * result) + ((totalAccounts != null) ? totalAccounts.hashCode() : 0);
    result = (31 * result) + ((totalDialed != null) ? totalDialed.hashCode() : 0);
    result = (31 * result) + ((noPhoneNumFound != null) ? noPhoneNumFound.hashCode() : 0);
    result = (31 * result) + ((lockedByOther != null) ? lockedByOther.hashCode() : 0);
    result = (31 * result) + ((notWorkable != null) ? notWorkable.hashCode() : 0);
    result = (31 * result) + ((balanceWorked != null) ? balanceWorked.hashCode() : 0);

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account list.
   *
   * @param  accountList  List
   */
  public void setAccountList(List<Account> accountList) {
    this.accountList = accountList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent.
   *
   * @param  agent  User
   */
  public void setAgent(User agent) {
    this.agent = agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for balance worked.
   *
   * @param  balanceWorked  BigDecimal
   */
  public void setBalanceWorked(BigDecimal balanceWorked) {
    this.balanceWorked = balanceWorked;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dialed.
   *
   * @param  dialed  Boolean
   */
  public void setDialed(Boolean dialed) {
    isDialed = dialed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dialing interval.
   *
   * @param  dialingInterval  Long
   */
  public void setDialingInterval(Long dialingInterval) {
    this.dialingInterval = dialingInterval;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for end date.
   *
   * @param  endDate  Date
   */
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for filter id.
   *
   * @param  filterId  Long
   */
  public void setFilterId(Long filterId) {
    this.filterId = filterId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for locked by other.
   *
   * @param  lockedByOther  Integer
   */
  public void setLockedByOther(Integer lockedByOther) {
    this.lockedByOther = lockedByOther;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for no phone num found.
   *
   * @param  noPhoneNumFound  Integer
   */
  public void setNoPhoneNumFound(Integer noPhoneNumFound) {
    this.noPhoneNumFound = noPhoneNumFound;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for not workable.
   *
   * @param  notWorkable  Integer
   */
  public void setNotWorkable(Integer notWorkable) {
    this.notWorkable = notWorkable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue id.
   *
   * @param  queueId  Long
   */
  public void setQueueId(Long queueId) {
    this.queueId = queueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sorter id.
   *
   * @param  sorterId  Long
   */
  public void setSorterId(Long sorterId) {
    this.sorterId = sorterId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for start date.
   *
   * @param  startDate  Date
   */
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  PreviewDialingStatus
   */
  public void setStatus(PreviewDialingStatus status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for target.
   *
   * @param  target  String
   */
  public void setTarget(String target) {
    this.target = target;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for target phone type.
   *
   * @param  targetPhoneType  PhoneType
   */
  public void setTargetPhoneType(PhoneType targetPhoneType) {
    this.targetPhoneType = targetPhoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for to be next account.
   *
   * @param  toBeNextAccount  Boolean
   */
  public void setToBeNextAccount(Boolean toBeNextAccount) {
    this.toBeNextAccount = toBeNextAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total accounts.
   *
   * @param  totalAccounts  Integer
   */
  public void setTotalAccounts(Integer totalAccounts) {
    this.totalAccounts = totalAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total dialed.
   *
   * @param  totalDialed  Integer
   */
  public void setTotalDialed(Integer totalDialed) {
    this.totalDialed = totalDialed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for work count.
   *
   * @param  workCount  Long
   */
  public void setWorkCount(Long workCount) {
    this.workCount = workCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    return "PreviewDialing{"
      + "workCount=" + workCount
      + ", totalDialed=" + totalDialed
      + ", totalAccounts=" + totalAccounts
      + ", toBeNextAccount=" + toBeNextAccount
      + ", targetPhoneType=" + targetPhoneType
      + ", target='" + target + '\''
      + ", status=" + status
      + ", agent=" + agent
      + ", balanceWorked=" + balanceWorked
      + ", dialingInterval=" + dialingInterval
      + ", endDate=" + endDate
      + ", filterId=" + filterId
      + ", id=" + id
      + ", isDialed=" + isDialed
      + ", lockedByOther=" + lockedByOther
      + ", noPhoneNumFound=" + noPhoneNumFound
      + ", notWorkable=" + notWorkable
      + ", queueId=" + queueId
      + ", sorterId=" + sorterId
      + ", startDate=" + startDate
      + '}';
  }
} // end class PreviewDialing
