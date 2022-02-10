package com.cmc.credagility.core.domain.contact;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.activity.AgentCallActivity;
import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.type.CallType;


/**
 * Phone level audit need implement this class.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/14/2014 17:25
 */
@MappedSuperclass public abstract class BasePhoneNumberAudit extends CreatorEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4030232666983065376L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account, Refers {@link Account}. */
  @JoinColumn(
    name     = "accountNum",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Account account;


  /** Agent calla activity, Refers {@link AgentCallActivity}. */
  @JoinColumn(name = "activityId")
  @ManyToOne(fetch = FetchType.EAGER)
  protected AgentCallActivity activity;


  /** Call type, Refers {@link CallType}. */
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  protected CallType callType;


  /** PK. */
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long         id;


  /** phoneNum. */
  @Column(
    name     = "phoneNum",
    nullable = false,
    length   = 255
  )
  protected String phoneNum;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BasePhoneNumberAudit object.
   */
  protected BasePhoneNumberAudit() { }

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

    if (!(o instanceof BasePhoneNumberAudit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BasePhoneNumberAudit that = (BasePhoneNumberAudit) o;

    if (callType != that.callType) {
      return false;
    }

    if ((phoneNum != null) ? (!phoneNum.equals(that.phoneNum)) : (that.phoneNum != null)) {
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
   * getter method for activity.
   *
   * @return  AgentCallActivity
   */
  public AgentCallActivity getActivity() {
    return activity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for call type.
   *
   * @return  CallType
   */
  public CallType getCallType() {
    return callType;
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
   * getter method for phone num.
   *
   * @return  String
   */
  public String getPhoneNum() {
    return phoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((phoneNum != null) ? phoneNum.hashCode() : 0);
    result = (31 * result) + ((callType != null) ? callType.hashCode() : 0);

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
   * setter method for activity.
   *
   * @param  activity  AgentCallActivity
   */
  public void setActivity(AgentCallActivity activity) {
    this.activity = activity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for call type.
   *
   * @param  callType  CallType
   */
  public void setCallType(CallType callType) {
    this.callType = callType;
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
   * setter method for phone num.
   *
   * @param  phoneNum  String
   */
  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    return "BasePhoneNumberAudit{"
      + "id=" + id
      + ", activity=" + activity
      + ", phoneNum='" + phoneNum + '\''
      + ", account=" + account
      + ", callType=" + callType
      + '}';
  }
} // end class BasePhoneNumberAudit
