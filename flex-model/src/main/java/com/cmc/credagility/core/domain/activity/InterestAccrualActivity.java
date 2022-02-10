package com.cmc.credagility.core.domain.activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.User;


/**
 * Created by coin on 7/4/16.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  07/04/2016 10:59
 */
@Entity @Table public class InterestAccrualActivity extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4631020756980629340L;

  /** TODO: DOCUMENT ME! */
  public static final String STOP = "stopInterestAccrual";

  /** TODO: DOCUMENT ME! */
  public static final String START = "startInterestAccrual";

  /** TODO: DOCUMENT ME! */
  private static final String STARTED = "Started";

  /** TODO: DOCUMENT ME! */
  private static final String STOPPED = "Stopped";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column protected String currentStatus;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "executorId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected User executor;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column protected String previousStatus;

  /** TODO: DOCUMENT ME! */
  @Column protected String triggerSource;

  @JoinColumn(
    name     = "accountNum",
    nullable = false
  )
  @ManyToOne private Account account;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * init.
   *
   * @param  action         String
   * @param  account        Account
   * @param  executor       User
   * @param  triggerSource  String
   */
  public void audit(String action, Account account, User executor, String triggerSource) {
    if (START.equalsIgnoreCase(action)) {
      this.previousStatus = STOPPED;
      this.currentStatus  = STARTED;
    } else if (STOP.equalsIgnoreCase(action)) {
      this.previousStatus = STARTED;
      this.currentStatus  = STOPPED;
    }

    this.triggerSource = triggerSource;
    this.executor      = executor;
    this.account       = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    InterestAccrualActivity that = (InterestAccrualActivity) o;

    if ((currentStatus != null) ? (!currentStatus.equals(that.currentStatus)) : (that.currentStatus != null)) {
      return false;
    }

    if ((executor != null) ? (!executor.equals(that.executor)) : (that.executor != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((previousStatus != null) ? (!previousStatus.equals(that.previousStatus)) : (that.previousStatus != null)) {
      return false;
    }

    if ((triggerSource != null) ? (!triggerSource.equals(that.triggerSource)) : (that.triggerSource != null)) {
      return false;
    }

    return (account != null) ? account.equals(that.account) : (that.account == null);

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
   * getter method for current status.
   *
   * @return  String
   */
  public String getCurrentStatus() {
    return currentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for executor.
   *
   * @return  User
   */
  public User getExecutor() {
    return executor;
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
   * getter method for previous status.
   *
   * @return  String
   */
  public String getPreviousStatus() {
    return previousStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trigger source.
   *
   * @return  String
   */
  public String getTriggerSource() {
    return triggerSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((currentStatus != null) ? currentStatus.hashCode() : 0);
    result = (31 * result) + ((executor != null) ? executor.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((previousStatus != null) ? previousStatus.hashCode() : 0);
    result = (31 * result) + ((triggerSource != null) ? triggerSource.hashCode() : 0);
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);

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
   * setter method for current status.
   *
   * @param  currentStatus  String
   */
  public void setCurrentStatus(String currentStatus) {
    this.currentStatus = currentStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for executor.
   *
   * @param  executor  User
   */
  public void setExecutor(User executor) {
    this.executor = executor;
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
   * setter method for previous status.
   *
   * @param  previousStatus  String
   */
  public void setPreviousStatus(String previousStatus) {
    this.previousStatus = previousStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trigger source.
   *
   * @param  triggerSource  String
   */
  public void setTriggerSource(String triggerSource) {
    this.triggerSource = triggerSource;
  }

} // end class InterestAccrualActivity
