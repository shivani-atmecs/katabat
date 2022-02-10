package com.cmc.credagility.core.domain.memo;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.user.User;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 12:12
 */
@Entity
@Table(name = "MemoryMessage")
public class MemoryMessage extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 127387672486165585L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** FK link to account. */
  @JoinColumn(
    name      = "accountNum",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;


  /** FK link to user! */
  @JoinColumn(
    name       = "agentId",
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;


  /** FK link to customer. */
  @JoinColumn(
    name      = "customerId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;


  /** content of memory message. */
  @Column(
    name     = "data",
    length   = 400,
    nullable = false
  )
  protected String data;


  /** create time of memory message. */
  @Column(name = "dataCreateDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date dataCreateDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "dataOrder")
  protected Integer dataOrder;

  /** memory message identifier PK. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long memoryMessageId;


  /** source of memory message. */
  @Column(
    name     = "source",
    length   = 50,
    nullable = false
  )
  protected String source;


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

    final MemoryMessage other = (MemoryMessage) obj;

    if (this.memoryMessageId == null) {
      if (other.getMemoryMessageId() != null) {
        return false;
      }
    } else if (!this.memoryMessageId.equals(other.getMemoryMessageId())) {
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
   * getter method for memory message id.
   *
   * @return  Long
   */
  public Long getMemoryMessageId() {
    return memoryMessageId;
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
    result = (prime * result) + ((memoryMessageId == null) ? 0 : memoryMessageId.hashCode());
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
   * setter method for memory message id.
   *
   * @param  memoryMessageId  Long
   */
  public void setMemoryMessageId(Long memoryMessageId) {
    this.memoryMessageId = memoryMessageId;
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

    retValue.append("MemoryMessage ( ").append(super.toString()).append(TAB).append("memoryMessageId = ").append(
      this.memoryMessageId).append(TAB).append("data = ").append(this.data).append(TAB).append("dataCreateDate = ")
      .append(this.dataCreateDate).append(TAB).append("dataOrder = ").append(this.dataOrder).append(TAB).append(
      "account = ").append(this.account).append(TAB).append("agent = ").append(this.agent).append(TAB).append(
      "source = ").append(this.source).append(TAB).append("userName = ").append(this.userName).append(" )");

    return retValue.toString();
  }
} // end class MemoryMessage
