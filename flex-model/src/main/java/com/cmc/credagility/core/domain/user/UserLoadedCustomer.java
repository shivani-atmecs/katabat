package com.cmc.credagility.core.domain.user;

import java.io.Serializable;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmc.credagility.core.domain.activity.AgentCallActivity;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 17:03
 */
@Entity
@Table(
  name              = "UserLoadedCustomer" /*uniqueConstraints = { @UniqueConstraint(columnNames = {}) }*/,
  uniqueConstraints = { @UniqueConstraint(columnNames = { "customerNum", "count" }) }
)
public class UserLoadedCustomer extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 6942063021948391031L;

  private static final transient Logger log = LoggerFactory.getLogger(UserLoadedCustomer.class);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agentId",
    insertable = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;

  /** Relations UserLoadedCustomer AgentCallActivity : */
  @OneToMany(
    cascade  = { CascadeType.REMOVE, CascadeType.ALL },
    fetch    = FetchType.LAZY,
    mappedBy = "userLoadedCustomer"
  )
  @OrderBy("createDate desc")
  protected Set<AgentCallActivity> agentCallActivities = new LinkedHashSet<AgentCallActivity>();

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "current",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean current = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "customerNum",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "finishedWork",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean finishedWork = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "loadedResponsibleId",
    updatable = true,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible loadedResponsible;

  /** TODO: DOCUMENT ME! */
  @Column(name = "lockExpirationTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lockExpirationTime = null;

  /** UserLoadedCustomer identifier PK. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long userLoadedCustomerId;

  @Column(
    name     = "count",
    nullable = false
  )
  private Long count;

  @Column(
    name   = "sourceType",
    length = 100
  )
  private String sourceType;

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

    final UserLoadedCustomer other = (UserLoadedCustomer) obj;

    if (this.userLoadedCustomerId == null) {
      if (other.getUserLoadedCustomerId() != null) {
        return false;
      }
    } else if (!this.userLoadedCustomerId.equals(other.getUserLoadedCustomerId())) {
      return false;
    }

    if (this.customer == null) {
      if (other.getCustomer() != null) {
        return false;
      }
    } else if (!this.customer.equals(other.getCustomer())) {
      return false;
    }

    if (this.agent == null) {
      if (other.getAgent() != null) {
        return false;
      }
    } else if (!this.agent.equals(other.getAgent())) {
      return false;
    }

    if (this.lockExpirationTime == null) {
      if (other.getLockExpirationTime() != null) {
        return false;
      }
    } else if (!this.lockExpirationTime.equals(other.getLockExpirationTime())) {
      return false;
    }

    if (this.loadedResponsible == null) {
      if (other.getLoadedResponsible() != null) {
        return false;
      }
    } else if (!this.loadedResponsible.equals(other.getLoadedResponsible())) {
      return false;
    }

    if (this.current == null) {
      if (other.getCurrent() != null) {
        return false;
      }
    } else if (!this.current.equals(other.getCurrent())) {
      return false;
    }

    if (this.finishedWork == null) {
      if (other.getFinishedWork() != null) {
        return false;
      }
    } else if (!this.finishedWork.equals(other.getFinishedWork())) {
      return false;
    }

    return true;
  } // end method equals

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
   * getter method for agent call activities.
   *
   * @return  Set
   */
  public Set<AgentCallActivity> getAgentCallActivities() {
    return agentCallActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for count.
   *
   * @return  Long
   */
  public Long getCount() {
    return count;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current.
   *
   * @return  Boolean
   */
  public Boolean getCurrent() {
    return current;
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
   * getter method for finished work.
   *
   * @return  Boolean
   */
  public Boolean getFinishedWork() {
    return finishedWork;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for loaded responsible.
   *
   * @return  Responsible
   */
  public Responsible getLoadedResponsible() {
    return loadedResponsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for lock expiration time.
   *
   * @return  Date
   */
  public Date getLockExpirationTime() {
    return lockExpirationTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for source type.
   *
   * @return  String
   */
  public String getSourceType() {
    return sourceType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user loaded customer id.
   *
   * @return  Long
   */
  public Long getUserLoadedCustomerId() {
    return userLoadedCustomerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((customer != null) ? customer.hashCode() : 0);
    result = (31 * result) + ((agent != null) ? agent.hashCode() : 0);
    result = (31 * result) + ((agentCallActivities != null) ? agentCallActivities.hashCode() : 0);
    result = (31 * result) + ((current != null) ? current.hashCode() : 0);
    result = (31 * result) + ((lockExpirationTime != null) ? lockExpirationTime.hashCode() : 0);
    result = (31 * result) + ((userLoadedCustomerId != null) ? userLoadedCustomerId.hashCode() : 0);
    result = (31 * result) + ((loadedResponsible != null) ? loadedResponsible.hashCode() : 0);
    result = (31 * result) + ((count != null) ? count.hashCode() : 0);
    result = (31 * result) + ((finishedWork != null) ? finishedWork.hashCode() : 0);

    return result;
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
   * setter method for agent call activities.
   *
   * @param  agentCallActivities  Set
   */
  public void setAgentCallActivities(Set<AgentCallActivity> agentCallActivities) {
    this.agentCallActivities = agentCallActivities;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for count.
   *
   * @param  count  Long
   */
  public void setCount(Long count) {
    this.count = count;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current.
   *
   * @param  current  Boolean
   */
  public void setCurrent(Boolean current) {
    this.current = current;
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
   * setter method for finished work.
   *
   * @param  finishedWork  Boolean
   */
  public void setFinishedWork(Boolean finishedWork) {
    this.finishedWork = finishedWork;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for loaded responsible.
   *
   * @param  loadedResponsible  Responsible
   */
  public void setLoadedResponsible(Responsible loadedResponsible) {
    this.loadedResponsible = loadedResponsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for lock expiration time.
   *
   * @param  lockExpirationTime  Date
   */
  public void setLockExpirationTime(Date lockExpirationTime) {
    this.lockExpirationTime = lockExpirationTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source type.
   *
   * @param  sourceType  String
   */
  public void setSourceType(String sourceType) {
    this.sourceType = sourceType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user loaded customer id.
   *
   * @param  userLoadedCustomerId  Long
   */
  public void setUserLoadedCustomerId(Long userLoadedCustomerId) {
    this.userLoadedCustomerId = userLoadedCustomerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("UserLoadedCustomer ( ").append(super.toString()).append(TAB).append("userLoadedCustomerId = ")
      .append(this.userLoadedCustomerId).append(TAB).append("customer = ").append(this.customer).append(TAB).append(
      "agent = ").append(this.agent).append(TAB).append("lockExpirationTime = ").append(this.lockExpirationTime).append(
      TAB).append("current = ").append(this.current).append(" )").append(TAB).append("finishedWork = ").append(
      this.finishedWork);

    return retValue.toString();
  }
} // end class UserLoadedCustomer
