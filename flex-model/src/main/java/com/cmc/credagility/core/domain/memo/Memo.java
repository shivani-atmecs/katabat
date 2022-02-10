package com.cmc.credagility.core.domain.memo;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.activity.AgentCallActivity;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * note for users.
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 12:06
 */
@Entity
@Table(
  name    = "Memo",
  indexes = {
    @Index(
      name = "idx_clientNoteId",
      columnList = "clientNoteId"
    )
  }
)
public class Memo extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7751174048396380965L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** FK link to account. */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;


  /** FK link to user. */
  @JoinColumn(
    name       = "agentId",
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;


  /** FK link to agentCallActivity. */
  @JoinColumn(
    name      = "activityId",
    updatable = false
  )
  @OneToOne(fetch = FetchType.LAZY)
  protected AgentCallActivity agentCallActivity;


  /** PK of Note from client. */
  @Column(name = "clientNoteId")
  protected Integer clientNoteId;


  /** TFK link to customer. */
  @JoinColumn(
    name      = "customerId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;


  /** content of note. */
  @Column(
    name     = "data",
    length   = 8192,
    nullable = false
  )
  protected String data;


  /** create time of note. */
  @Column(name = "dataCreateDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date dataCreateDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "dataOrder")
  protected Integer dataOrder;

  /** Memo identifier PK. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long memoId;


  /** source of note. */
  @Column(
    name     = "source",
    length   = 50,
    nullable = false
  )
  protected String source;


  /** subject of note. */
  @Column(
    name   = "subject",
    length = 255
  )
  protected String subject;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "userName",
    length   = 50,
    nullable = true
  )
  protected String userName;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    final Memo other = (Memo) obj;

    if (this.memoId == null) {
      if (other.getMemoId() != null) {
        return false;
      }
    } else if (!this.memoId.equals(other.getMemoId())) {
      return false;
    }

    if (this.data == null) {
      if (other.getData() != null) {
        return false;
      }
    } else if (!this.data.equals(other.getData())) {
      return false;
    }

    if (this.dataCreateDate == null) {
      if (other.getDataCreateDate() != null) {
        return false;
      }
    } else if (!this.dataCreateDate.equals(other.getDataCreateDate())) {
      return false;
    }

    if (this.dataOrder == null) {
      if (other.getDataOrder() != null) {
        return false;
      }
    } else if (!this.dataOrder.equals(other.getDataOrder())) {
      return false;
    }

    if (this.account == null) {
      if (other.getAccount() != null) {
        return false;
      }
    } else if (!this.account.equals(other.getAccount())) {
      return false;
    }

    if (this.agent == null) {
      if (other.getAgent() != null) {
        return false;
      }
    } else if (!this.agent.equals(other.getAgent())) {
      return false;
    }

    if (this.source == null) {
      if (other.getSource() != null) {
        return false;
      }
    } else if (!this.source.equals(other.getSource())) {
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
   * getter method for agent.
   *
   * @return  User
   */
  public User getAgent() {
    return agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent call activity.
   *
   * @return  AgentCallActivity
   */
  public AgentCallActivity getAgentCallActivity() {
    return agentCallActivity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client note id.
   *
   * @return  Integer
   */
  public Integer getClientNoteId() {
    return clientNoteId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer.
   *
   * @return  Customer
   */
  public Customer getCustomer() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data.
   *
   * @return  String
   */
  public String getData() {
    return data;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data create date.
   *
   * @return  Date
   */
  public Date getDataCreateDate() {
    return dataCreateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data order.
   *
   * @return  Integer
   */
  public Integer getDataOrder() {
    return dataOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for memo id.
   *
   * @return  Long
   */
  public Long getMemoId() {
    return memoId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source.
   *
   * @return  String
   */
  public String getSource() {
    return source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for subject.
   *
   * @return  String
   */
  public String getSubject() {
    return subject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user name.
   *
   * @return  String
   */
  public String getUserName() {
    return userName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result) + ((createDate == null) ? 0 : createDate.hashCode());
    result = (prime * result) + ((memoId == null) ? 0 : memoId.hashCode());
    result = (prime * result) + ((data == null) ? 0 : data.hashCode());
    result = (prime * result) + ((dataCreateDate == null) ? 0 : dataCreateDate.hashCode());
    result = (prime * result) + ((dataOrder == null) ? 0 : dataOrder.hashCode());
    result = (prime * result) + ((account == null) ? 0 : account.hashCode());
    result = (prime * result) + ((agent == null) ? 0 : agent.hashCode());
    result = (prime * result) + ((source == null) ? 0 : source.hashCode());
    result = (prime * result) + ((userName == null) ? 0 : userName.hashCode());

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
   * setter method for agent.
   *
   * @param  agent  User
   */
  public void setAgent(User agent) {
    this.agent = agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent call activity.
   *
   * @param  agentCallActivity  AgentCallActivity
   */
  public void setAgentCallActivity(AgentCallActivity agentCallActivity) {
    this.agentCallActivity = agentCallActivity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client note id.
   *
   * @param  clientNoteId  Integer
   */
  public void setClientNoteId(Integer clientNoteId) {
    this.clientNoteId = clientNoteId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer.
   *
   * @param  customer  Customer
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data.
   *
   * @param  data  String
   */
  public void setData(String data) {
    this.data = data;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data create date.
   *
   * @param  dataCreateDate  Date
   */
  public void setDataCreateDate(Date dataCreateDate) {
    this.dataCreateDate = dataCreateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data order.
   *
   * @param  dataOrder  Integer
   */
  public void setDataOrder(Integer dataOrder) {
    this.dataOrder = dataOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for memo id.
   *
   * @param  memoId  Long
   */
  public void setMemoId(Long memoId) {
    this.memoId = memoId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source.
   *
   * @param  source  String
   */
  public void setSource(String source) {
    this.source = source;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for subject.
   *
   * @param  subject  String
   */
  public void setSubject(String subject) {
    this.subject = subject;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user name.
   *
   * @param  userName  String
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("Memo ( ").append(super.toString()).append(TAB).append("memoId = ").append(
      this.memoId).append(TAB).append("data = ").append(this.data).append(TAB).append("dataCreateDate = ").append(
      this.dataCreateDate).append(TAB).append("dataOrder = ").append(this.dataOrder).append(TAB).append(
      "account = ").append(this.account).append(TAB).append("agent = ").append(this.agent).append(TAB).append(
      "source = ").append(this.source).append(TAB).append("userName = ").append(this.userName).append(" )");

    return retValue.toString();
  }
} // end class Memo
