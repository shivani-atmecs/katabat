package com.cmc.credagility.core.domain.mra;

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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.type.StopCampaignStatus;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import com.ozstrategy.credagility.core.domain.QueueAction;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 14:17
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "queueExportRecoveryKeyIndex",
      columnList = "recoveryKey"
    )
  }
)
public class QueueExportRequest extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "destinationId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected QueueExportDestination destination;

  /** TODO: DOCUMENT ME! */
  protected BigDecimal exportedBalance;

  /** TODO: DOCUMENT ME! */
  protected Integer exportedCountOfAccounts;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fileName;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "filterId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected QueueAccountFilter filter;

  /** TODO: DOCUMENT ME! */
  @Column(name = "finishedTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date finishedTime;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "queueActionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected QueueAction queueAction;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "queueExportFileName")
  @ManyToOne(fetch = FetchType.LAZY)
  protected QueueExportFileName queueExportFileName;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "queueExportRequest",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
// @OrderBy("createDate desc")
  protected List<QueueExportPhoneType> queueExportPhoneType = new ArrayList<QueueExportPhoneType>();

  /** TODO: DOCUMENT ME! */
  @Column(name = "recoveryKey")
  protected Long recoveryKey;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "requestedByUserId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User requestedBy;

  /** TODO: DOCUMENT ME! */
  @Column(name = "requestTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date requestTime;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "sorterId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected QueueAccountSorter sorter;

  // QueueExportRequest status: INPROCESS/FINISHED
  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String status = "INPROCESS";

  /** TODO: DOCUMENT ME! */
  @Column(name = "stopCampaignFinishedTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date stopCampaignFinishedTime;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean stopCampaignRequest;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "stopCampaignRequestedByUserId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User stopCampaignRequestedBy;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String stopCampaignRequestId;

  /** TODO: DOCUMENT ME! */
  @Column(name = "stopCampaignRequestTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date stopCampaignRequestTime;

  /** TODO: DOCUMENT ME! */
  protected Integer stopCampaignRound = 0;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  @Enumerated(EnumType.STRING)
  protected StopCampaignStatus stopCampaignStatus;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new QueueExportRequest object.
   */
  public QueueExportRequest() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof QueueExportRequest)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    QueueExportRequest that = (QueueExportRequest) o;

    if (!destination.equals(that.destination)) {
      return false;
    }

    if (!exportedBalance.equals(that.exportedBalance)) {
      return false;
    }

    if (!exportedCountOfAccounts.equals(that.exportedCountOfAccounts)) {
      return false;
    }

    if (!fileName.equals(that.fileName)) {
      return false;
    }

    if ((filter != null) ? (!filter.equals(that.filter)) : (that.filter != null)) {
      return false;
    }

    if (!finishedTime.equals(that.finishedTime)) {
      return false;
    }

    if (!id.equals(that.id)) {
      return false;
    }

    if (!queueAction.equals(that.queueAction)) {
      return false;
    }

    if ((queueExportPhoneType != null) ? (!queueExportPhoneType.equals(that.queueExportPhoneType))
                                       : (that.queueExportPhoneType != null)) {
      return false;
    }

    if ((recoveryKey != null) ? (!recoveryKey.equals(that.recoveryKey)) : (that.recoveryKey != null)) {
      return false;
    }

    if (!requestTime.equals(that.requestTime)) {
      return false;
    }

    if (!requestedBy.equals(that.requestedBy)) {
      return false;
    }

    if ((sorter != null) ? (!sorter.equals(that.sorter)) : (that.sorter != null)) {
      return false;
    }

    if (!status.equals(that.status)) {
      return false;
    }

    if ((stopCampaignFinishedTime != null) ? (!stopCampaignFinishedTime.equals(that.stopCampaignFinishedTime))
                                           : (that.stopCampaignFinishedTime != null)) {
      return false;
    }

    if ((stopCampaignRequest != null) ? (!stopCampaignRequest.equals(that.stopCampaignRequest))
                                      : (that.stopCampaignRequest != null)) {
      return false;
    }

    if ((stopCampaignRequestId != null) ? (!stopCampaignRequestId.equals(that.stopCampaignRequestId))
                                        : (that.stopCampaignRequestId != null)) {
      return false;
    }

    if ((stopCampaignRequestTime != null) ? (!stopCampaignRequestTime.equals(that.stopCampaignRequestTime))
                                          : (that.stopCampaignRequestTime != null)) {
      return false;
    }

    if ((stopCampaignRequestedBy != null) ? (!stopCampaignRequestedBy.equals(that.stopCampaignRequestedBy))
                                          : (that.stopCampaignRequestedBy != null)) {
      return false;
    }

    if ((stopCampaignRound != null) ? (!stopCampaignRound.equals(that.stopCampaignRound))
                                    : (that.stopCampaignRound != null)) {
      return false;
    }

    if (stopCampaignStatus != that.stopCampaignStatus) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for destination.
   *
   * @return  QueueExportDestination
   */
  public QueueExportDestination getDestination() {
    return destination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for exported balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getExportedBalance() {
    return exportedBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for exported count of accounts.
   *
   * @return  Integer
   */
  public Integer getExportedCountOfAccounts() {
    return exportedCountOfAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for file name.
   *
   * @return  String
   */
  public String getFileName() {
    return fileName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for filter.
   *
   * @return  QueueAccountFilter
   */
  public QueueAccountFilter getFilter() {
    return filter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for finished time.
   *
   * @return  Date
   */
  public Date getFinishedTime() {
    return finishedTime;
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
   * getter method for queue action.
   *
   * @return  QueueAction
   */
  public QueueAction getQueueAction() {
    return queueAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue export file name.
   *
   * @return  QueueExportFileName
   */
  public QueueExportFileName getQueueExportFileName() {
    return queueExportFileName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue export phone type.
   *
   * @return  List
   */
  public List<QueueExportPhoneType> getQueueExportPhoneType() {
    return queueExportPhoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recovery key.
   *
   * @return  Long
   */
  public Long getRecoveryKey() {
    return recoveryKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for requested by.
   *
   * @return  User
   */
  public User getRequestedBy() {
    return requestedBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for request time.
   *
   * @return  Date
   */
  public Date getRequestTime() {
    return requestTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sorter.
   *
   * @return  QueueAccountSorter
   */
  public QueueAccountSorter getSorter() {
    return sorter;
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
   * getter method for stop campaign finished time.
   *
   * @return  Date
   */
  public Date getStopCampaignFinishedTime() {
    return stopCampaignFinishedTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stop campaign request.
   *
   * @return  Boolean
   */
  public Boolean getStopCampaignRequest() {
    return stopCampaignRequest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stop campaign requested by.
   *
   * @return  User
   */
  public User getStopCampaignRequestedBy() {
    return stopCampaignRequestedBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stop campaign request id.
   *
   * @return  String
   */
  public String getStopCampaignRequestId() {
    return stopCampaignRequestId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stop campaign request time.
   *
   * @return  Date
   */
  public Date getStopCampaignRequestTime() {
    return stopCampaignRequestTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stop campaign round.
   *
   * @return  Integer
   */
  public Integer getStopCampaignRound() {
    return stopCampaignRound;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for stop campaign status.
   *
   * @return  StopCampaignStatus
   */
  public StopCampaignStatus getStopCampaignStatus() {
    return stopCampaignStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + destination.hashCode();
    result = (31 * result) + exportedBalance.hashCode();
    result = (31 * result) + exportedCountOfAccounts.hashCode();
    result = (31 * result) + fileName.hashCode();
    result = (31 * result) + ((filter != null) ? filter.hashCode() : 0);
    result = (31 * result) + finishedTime.hashCode();
    result = (31 * result) + id.hashCode();
    result = (31 * result) + queueAction.hashCode();
    result = (31 * result) + ((queueExportPhoneType != null) ? queueExportPhoneType.hashCode() : 0);
    result = (31 * result) + ((recoveryKey != null) ? recoveryKey.hashCode() : 0);
    result = (31 * result) + requestedBy.hashCode();
    result = (31 * result) + requestTime.hashCode();
    result = (31 * result) + ((sorter != null) ? sorter.hashCode() : 0);
    result = (31 * result) + status.hashCode();
    result = (31 * result) + ((stopCampaignFinishedTime != null) ? stopCampaignFinishedTime.hashCode() : 0);
    result = (31 * result) + ((stopCampaignRequest != null) ? stopCampaignRequest.hashCode() : 0);
    result = (31 * result) + ((stopCampaignRequestedBy != null) ? stopCampaignRequestedBy.hashCode() : 0);
    result = (31 * result) + ((stopCampaignRequestId != null) ? stopCampaignRequestId.hashCode() : 0);
    result = (31 * result) + ((stopCampaignRequestTime != null) ? stopCampaignRequestTime.hashCode() : 0);
    result = (31 * result) + ((stopCampaignRound != null) ? stopCampaignRound.hashCode() : 0);
    result = (31 * result) + ((stopCampaignStatus != null) ? stopCampaignStatus.hashCode() : 0);

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for destination.
   *
   * @param  destination  QueueExportDestination
   */
  public void setDestination(QueueExportDestination destination) {
    this.destination = destination;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for exported balance.
   *
   * @param  exportedBalance  BigDecimal
   */
  public void setExportedBalance(BigDecimal exportedBalance) {
    this.exportedBalance = exportedBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for exported count of accounts.
   *
   * @param  exportedCountOfAccounts  Integer
   */
  public void setExportedCountOfAccounts(Integer exportedCountOfAccounts) {
    this.exportedCountOfAccounts = exportedCountOfAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for file name.
   *
   * @param  fileName  String
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for filter.
   *
   * @param  filter  QueueAccountFilter
   */
  public void setFilter(QueueAccountFilter filter) {
    this.filter = filter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for finished time.
   *
   * @param  finishedTime  Date
   */
  public void setFinishedTime(Date finishedTime) {
    this.finishedTime = finishedTime;
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
   * setter method for queue action.
   *
   * @param  queueAction  QueueAction
   */
  public void setQueueAction(QueueAction queueAction) {
    this.queueAction = queueAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue export file name.
   *
   * @param  queueExportFileName  QueueExportFileName
   */
  public void setQueueExportFileName(QueueExportFileName queueExportFileName) {
    this.queueExportFileName = queueExportFileName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue export phone type.
   *
   * @param  queueExportPhoneType  List
   */
  public void setQueueExportPhoneType(List<QueueExportPhoneType> queueExportPhoneType) {
    this.queueExportPhoneType = queueExportPhoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recovery key.
   *
   * @param  recoveryKey  Long
   */
  public void setRecoveryKey(Long recoveryKey) {
    this.recoveryKey = recoveryKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for requested by.
   *
   * @param  requestedBy  User
   */
  public void setRequestedBy(User requestedBy) {
    this.requestedBy = requestedBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for request time.
   *
   * @param  requestTime  Date
   */
  public void setRequestTime(Date requestTime) {
    this.requestTime = requestTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sorter.
   *
   * @param  sorter  QueueAccountSorter
   */
  public void setSorter(QueueAccountSorter sorter) {
    this.sorter = sorter;
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
   * setter method for stop campaign finished time.
   *
   * @param  stopCampaignFinishedTime  Date
   */
  public void setStopCampaignFinishedTime(Date stopCampaignFinishedTime) {
    this.stopCampaignFinishedTime = stopCampaignFinishedTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stop campaign request.
   *
   * @param  stopCampaignRequest  Boolean
   */
  public void setStopCampaignRequest(Boolean stopCampaignRequest) {
    this.stopCampaignRequest = stopCampaignRequest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stop campaign requested by.
   *
   * @param  stopCampaignRequestedBy  User
   */
  public void setStopCampaignRequestedBy(User stopCampaignRequestedBy) {
    this.stopCampaignRequestedBy = stopCampaignRequestedBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stop campaign request id.
   *
   * @param  stopCampaignRequestId  String
   */
  public void setStopCampaignRequestId(String stopCampaignRequestId) {
    this.stopCampaignRequestId = stopCampaignRequestId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stop campaign request time.
   *
   * @param  stopCampaignRequestTime  Date
   */
  public void setStopCampaignRequestTime(Date stopCampaignRequestTime) {
    this.stopCampaignRequestTime = stopCampaignRequestTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stop campaign round.
   *
   * @param  stopCampaignRound  Integer
   */
  public void setStopCampaignRound(Integer stopCampaignRound) {
    this.stopCampaignRound = stopCampaignRound;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for stop campaign status.
   *
   * @param  stopCampaignStatus  StopCampaignStatus
   */
  public void setStopCampaignStatus(StopCampaignStatus stopCampaignStatus) {
    this.stopCampaignStatus = stopCampaignStatus;
  }
} // end class QueueExportRequest
