package com.cmc.credagility.core.domain.message;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.tsys.TsysMQRequest;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.webactivity.Session;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 12:25
 */
@Entity
@Table(
  name              = "MessageStaging",
  uniqueConstraints = {
    @UniqueConstraint(
      name          = "uniqueSessionId",
      columnNames   = "uniqueSessionId"
    )
  },
  indexes           = {
    @Index(
      name          = "uniqueSessionIdIndex",
      columnList    = "uniqueSessionId"
    )
  }
)
public class MessageStaging extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 703231960228684095L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Fk link to account. */
  @JoinColumn(
    name       = "accountNum",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @Column(name = "channel")
  protected String channel;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "data1",
    nullable = true
  )
  protected String data1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "data2",
    nullable = true
  )
  protected String data2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "data3",
    nullable = true
  )
  protected String data3;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "data4",
    nullable = true
  )
  protected String data4;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "data5",
    nullable = true
  )
  protected String data5;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "errorCode",
    length   = 255,
    nullable = true
  )
  protected String errorCode;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "errorDescription",
    length   = 255,
    nullable = true
  )
  protected String errorDescription;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "errorDetail",
    length   = 255,
    nullable = true
  )
  protected String errorDetail;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "messageDestination",
    nullable = false
  )
  protected String messageDestination;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "messageStaging",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected Set<MessagePacketStatus> messagePacketStatus = new LinkedHashSet<MessagePacketStatus>();

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy      = "messageStaging",
    fetch         = FetchType.EAGER,
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected MessageResponseStore messageResponseStore = null;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "messageStagingId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long messageStagingId;

  /** TODO: DOCUMENT ME! */
  @Column(name = "messageState")
  protected String messageState;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy      = "messageStaging",
    fetch         = FetchType.EAGER,
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected MessageStore messageStore = null;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "messageType",
    nullable = false
  )
  protected String messageType;

  /** FK link to Portfolio. */
  @JoinColumn(
    name       = "portfolioId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

/*  */
  /*
  @Column(name = "portfolioId")
  protected String portfolioId;*/

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "portfolioName",
    length = 255
  )
  protected String portfolioName;

  /** TODO: DOCUMENT ME! */
  @Column(name = "receivedDate")
  protected Date receivedDate;

  /** TODO: DOCUMENT ME! */
  @Column(name = "reProcessedDate")
  protected Date reProcessedDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "responseProcessedCount",
    length = 2
  )
  protected Integer responseProcessedCount = 0;

  /** TODO: DOCUMENT ME! */
  @Column(name = "responseProcessedDate")
  protected Date responseProcessedDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "responseProcessedStatus",
    nullable = false,
    length   = 255
  )
  protected String responseProcessedStatus = "NA";

  /** FK link to Responsible. */
  @JoinColumn(
    name      = "responsibleId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "retryCount",
    nullable = true
  )
  protected Integer retryCount = 0;

  /** TODO: DOCUMENT ME! */
  @Column(name = "sentDate")
  protected Date sentDate;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "sessionId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Session session;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "status",
    nullable = false,
    length   = 255
  )
  protected String status;

  /** Indicates this req is synchronous MQ Call. */
  @Column(
    name             = "synchronousCall",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean synchronousCall;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "transactionName",
    nullable = false,
    length   = 255
  )
  protected String transactionName;

  /** Transaction key. */
  @Column(
    name   = "transViewKey",
    length = 255
  )
  protected String transViewKey;

  /** TODO: DOCUMENT ME! */
  @OneToOne(
    mappedBy      = "messageStaging",
    fetch         = FetchType.EAGER,
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected TsysMQRequest tsysMQRequest = null;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "uniqueSessionId",
    nullable = false,
    length   = 255
  )
  protected String uniqueSessionId;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agentId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User user;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  message  DOCUMENT ME!
   */
  public void addMessageResponseStore(MessageResponseStore message) {
    message.setMessageStaging(this);
    setMessageResponseStore(message);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  message  DOCUMENT ME!
   */
  public void addMessageStore(MessageStore message) {
    message.setMessageStaging(this);
    setMessageStore(message);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    MessageStaging other = (MessageStaging) obj;

    if (this.uniqueSessionId == null) {
      if (other.getUniqueSessionId() != null) {
        return false;
      }
    } else if (!this.uniqueSessionId.equals(other.getUniqueSessionId())) {
      return false;
    }

    if (this.messageType == null) {
      if (other.getMessageType() != null) {
        return false;
      }
    } else if (!this.messageType.equals(other.getMessageType())) {
      return false;
    }

    if (createDate == null) {
      if (other.getCreateDate() != null) {
        return false;
      }
    } else if (!createDate.equals(other.getCreateDate())) {
      return false;
    }

    if (lastUpdateDate == null) {
      if (other.getLastUpdateDate() != null) {
        return false;
      }
    } else if (!lastUpdateDate.equals(other.getLastUpdateDate())) {
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
   * getter method for channel.
   *
   * @return  String
   */
  public String getChannel() {
    return channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data1.
   *
   * @return  String
   */
  public String getData1() {
    return data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data2.
   *
   * @return  String
   */
  public String getData2() {
    return data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data3.
   *
   * @return  String
   */
  public String getData3() {
    return data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data4.
   *
   * @return  String
   */
  public String getData4() {
    return data4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data5.
   *
   * @return  String
   */
  public String getData5() {
    return data5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for error code.
   *
   * @return  String
   */
  public String getErrorCode() {
    return errorCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for error description.
   *
   * @return  String
   */
  public String getErrorDescription() {
    return errorDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for error detail.
   *
   * @return  String
   */
  public String getErrorDetail() {
    return errorDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message destination.
   *
   * @return  String
   */
  public String getMessageDestination() {
    return messageDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message packet status.
   *
   * @return  Set
   */
  public Set<MessagePacketStatus> getMessagePacketStatus() {
    return messagePacketStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message response store.
   *
   * @return  MessageResponseStore
   */
  public MessageResponseStore getMessageResponseStore() {
    return messageResponseStore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message staging id.
   *
   * @return  Long
   */
  public Long getMessageStagingId() {
    return messageStagingId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message state.
   *
   * @return  String
   */
  public String getMessageState() {
    return messageState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message store.
   *
   * @return  MessageStore
   */
  public MessageStore getMessageStore() {
    return messageStore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message type.
   *
   * @return  String
   */
  public String getMessageType() {
    return messageType;
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
   * getter method for portfolio name.
   *
   * @return  String
   */
  public String getPortfolioName() {
    return portfolioName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for received date.
   *
   * @return  Date
   */
  public Date getReceivedDate() {
    return receivedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for re processed date.
   *
   * @return  Date
   */
  public Date getReProcessedDate() {
    return reProcessedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for response processed count.
   *
   * @return  Integer
   */
  public Integer getResponseProcessedCount() {
    return responseProcessedCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for response processed date.
   *
   * @return  Date
   */
  public Date getResponseProcessedDate() {
    return responseProcessedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for response processed status.
   *
   * @return  String
   */
  public String getResponseProcessedStatus() {
    return responseProcessedStatus;
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
   * getter method for retry count.
   *
   * @return  Integer
   */
  public Integer getRetryCount() {
    return retryCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sent date.
   *
   * @return  Date
   */
  public Date getSentDate() {
    return sentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for session.
   *
   * @return  Session
   */
  public Session getSession() {
    return session;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  String
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for synchronous call.
   *
   * @return  Boolean
   */
  public Boolean getSynchronousCall() {
    return synchronousCall;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction name.
   *
   * @return  String
   */
  public String getTransactionName() {
    return transactionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trans view key.
   *
   * @return  String
   */
  public String getTransViewKey() {
    return transViewKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys MQRequest.
   *
   * @return  TsysMQRequest
   */
  public TsysMQRequest getTsysMQRequest() {
    return tsysMQRequest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unique session id.
   *
   * @return  String
   */
  public String getUniqueSessionId() {
    return uniqueSessionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user.
   *
   * @return  User
   */
  public User getUser() {
    return user;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((this.uniqueSessionId == null) ? 0 : this.uniqueSessionId.hashCode());
    result = (prime * result)
      + ((this.status == null) ? 0 : this.status.hashCode());
    result = (prime * result)
      + ((this.messageState == null) ? 0 : this.messageState.hashCode());

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
   * setter method for channel.
   *
   * @param  channel  String
   */
  public void setChannel(String channel) {
    this.channel = channel;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data1.
   *
   * @param  data1  String
   */
  public void setData1(String data1) {
    this.data1 = data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data2.
   *
   * @param  data2  String
   */
  public void setData2(String data2) {
    this.data2 = data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data3.
   *
   * @param  data3  String
   */
  public void setData3(String data3) {
    this.data3 = data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data4.
   *
   * @param  data4  String
   */
  public void setData4(String data4) {
    this.data4 = data4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data5.
   *
   * @param  data5  String
   */
  public void setData5(String data5) {
    this.data5 = data5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for error code.
   *
   * @param  errorCode  String
   */
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for error description.
   *
   * @param  errorDescription  String
   */
  public void setErrorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for error detail.
   *
   * @param  errorDetail  String
   */
  public void setErrorDetail(String errorDetail) {
    this.errorDetail = errorDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message destination.
   *
   * @param  messageDestination  String
   */
  public void setMessageDestination(String messageDestination) {
    this.messageDestination = messageDestination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message packet status.
   *
   * @param  messagePacketStatus  Set
   */
  public void setMessagePacketStatus(Set<MessagePacketStatus> messagePacketStatus) {
    this.messagePacketStatus = messagePacketStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message response store.
   *
   * @param  messageResponseStore  MessageResponseStore
   */
  public void setMessageResponseStore(MessageResponseStore messageResponseStore) {
    this.messageResponseStore = messageResponseStore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message staging id.
   *
   * @param  messageStagingId  Long
   */
  public void setMessageStagingId(Long messageStagingId) {
    this.messageStagingId = messageStagingId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message state.
   *
   * @param  messageState  String
   */
  public void setMessageState(String messageState) {
    this.messageState = messageState;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message store.
   *
   * @param  messageStore  MessageStore
   */
  public void setMessageStore(MessageStore messageStore) {
    this.messageStore = messageStore;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message type.
   *
   * @param  messageType  String
   */
  public void setMessageType(String messageType) {
    this.messageType = messageType;
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
   * setter method for portfolio name.
   *
   * @param  portfolioName  String
   */
  public void setPortfolioName(String portfolioName) {
    this.portfolioName = portfolioName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for received date.
   *
   * @param  receivedDate  Date
   */
  public void setReceivedDate(Date receivedDate) {
    this.receivedDate = receivedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for re processed date.
   *
   * @param  reProcessedDate  Date
   */
  public void setReProcessedDate(Date reProcessedDate) {
    this.reProcessedDate = reProcessedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for response processed count.
   *
   * @param  responseProcessedCount  Integer
   */
  public void setResponseProcessedCount(Integer responseProcessedCount) {
    this.responseProcessedCount = responseProcessedCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for response processed date.
   *
   * @param  responseProcessedDate  Date
   */
  public void setResponseProcessedDate(Date responseProcessedDate) {
    this.responseProcessedDate = responseProcessedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for response processed status.
   *
   * @param  responseProcessedStatus  String
   */
  public void setResponseProcessedStatus(String responseProcessedStatus) {
    this.responseProcessedStatus = responseProcessedStatus;
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
   * setter method for retry count.
   *
   * @param  retryCount  Integer
   */
  public void setRetryCount(Integer retryCount) {
    this.retryCount = retryCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sent date.
   *
   * @param  sentDate  Date
   */
  public void setSentDate(Date sentDate) {
    this.sentDate = sentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for session.
   *
   * @param  session  Session
   */
  public void setSession(Session session) {
    this.session = session;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  String
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for synchronous call.
   *
   * @param  synchronousCall  Boolean
   */
  public void setSynchronousCall(Boolean synchronousCall) {
    this.synchronousCall = synchronousCall;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transaction name.
   *
   * @param  transactionName  String
   */
  public void setTransactionName(String transactionName) {
    this.transactionName = transactionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trans view key.
   *
   * @param  transViewKey  String
   */
  public void setTransViewKey(String transViewKey) {
    this.transViewKey = transViewKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys MQRequest.
   *
   * @param  tsysMQRequest  TsysMQRequest
   */
  public void setTsysMQRequest(TsysMQRequest tsysMQRequest) {
    this.tsysMQRequest = tsysMQRequest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unique session id.
   *
   * @param  uniqueSessionId  String
   */
  public void setUniqueSessionId(String uniqueSessionId) {
    this.uniqueSessionId = uniqueSessionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user.
   *
   * @param  user  User
   */
  public void setUser(User user) {
    this.user = user;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "MessageStaging{"
      + ", channel='" + channel + '\''
      + ", data1='" + data1 + '\''
      + ", data2='" + data2 + '\''
      + ", data3='" + data3 + '\''
      + ", data4='" + data4 + '\''
      + ", data5='" + data5 + '\''
      + ", messageDestination='" + messageDestination + '\''
      + ", messageStagingId=" + messageStagingId
      + ", messageState='" + messageState + '\''
      + ", messageType='" + messageType + '\''
      + ", portfolioName='" + portfolioName + '\''
      + ", receivedDate=" + receivedDate
      + ", reProcessedDate=" + reProcessedDate
      + ", responseProcessedCount=" + responseProcessedCount
      + ", responseProcessedDate=" + responseProcessedDate
      + ", responseProcessedStatus='" + responseProcessedStatus + '\''
      + ", retryCount=" + retryCount
      + ", sentDate=" + sentDate
      + ", session=" + session
      + ", status='" + status + '\''
      + ", synchronousCall=" + synchronousCall
      + ", transactionName='" + transactionName + '\''
      + ", transViewKey='" + transViewKey + '\''
      + ", uniqueSessionId='" + uniqueSessionId + '\''
      + '}';
  } // end method toString
} // end class MessageStaging
