package com.cmc.credagility.core.domain.tsys;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.message.MessageStaging;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.responsible.ResponsibleDetail;
import com.cmc.credagility.core.domain.user.User;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 09:28
 */
@Entity
@Table(
  name =
    "TsysMQRequest"
    /*uniqueConstraints = { @UniqueConstraint(columnNames = {}) }*/
)
public class TsysMQRequest extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 6831285031301934048L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "accountNum",
    unique   = false,
    nullable = false
  )
  @ManyToOne protected Account account;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agentId",
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "data1",
    length   = 400,
    nullable = true
  )
  protected String data1;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "data2",
    length   = 255,
    nullable = true
  )
  protected String data2;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "data3",
    length   = 255,
    nullable = true
  )
  protected String data3;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "data4",
    length   = 255,
    nullable = true
  )
  protected String data4;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "data5",
    length   = 255,
    nullable = true
  )
  protected String data5;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "messageStagingId",
    nullable = true,
    unique   = true
  )
  @ManyToOne(cascade = { CascadeType.ALL })
  protected MessageStaging messageStaging;


  /** TODO: DOCUMENT ME! */
  @Column(name = "processedDate")
  protected Date processedDate;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "responsibleId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected Responsible responsible;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "status",
    length   = 100,
    nullable = false
  )
  protected String status;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "transactionType",
    length   = 100,
    nullable = false
  )
  protected String transactionType;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long tsysMQRequestId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for cust ID.
   *
   * @return  String
   */
  public String getCustID() {
    String custID = null;

    if (getResponsible() != null) {
      ResponsibleDetail detail = getResponsible().getResponsibleDetail();

      if (detail != null) {
        custID = detail.getClientReferenceId();
      }
    }

    return custID;
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
   * getter method for message staging.
   *
   * @return  MessageStaging
   */
  public MessageStaging getMessageStaging() {
    return messageStaging;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for processed date.
   *
   * @return  Date
   */
  public Date getProcessedDate() {
    return processedDate;
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
   * @return  String
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction type.
   *
   * @return  String
   */
  public String getTransactionType() {
    return transactionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys account id.
   *
   * @return  String
   */
  public String getTsysAccountId() {
    String tsysAccountId = null;

    if (getAccount() != null) {
      TsysAccount tsysAccount = getAccount().getTsysAccount();

      if (tsysAccount != null) {
        tsysAccountId = tsysAccount.getTsysAccountIdentifier().toString();
      }
    }

    return tsysAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys MQRequest id.
   *
   * @return  Long
   */
  public Long getTsysMQRequestId() {
    return tsysMQRequestId;
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
   * setter method for message staging.
   *
   * @param  messageStaging  MessageStaging
   */
  public void setMessageStaging(MessageStaging messageStaging) {
    this.messageStaging = messageStaging;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for processed date.
   *
   * @param  processedDate  Date
   */
  public void setProcessedDate(Date processedDate) {
    this.processedDate = processedDate;
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
   * @param  status  String
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transaction type.
   *
   * @param  transactionType  String
   */
  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys MQRequest id.
   *
   * @param  tsysMQRequestId  Long
   */
  public void setTsysMQRequestId(Long tsysMQRequestId) {
    this.tsysMQRequestId = tsysMQRequestId;
  }
} // end class TsysMQRequest
