package com.cmc.credagility.core.domain.mra;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.businesscontext.BCIQueueFilter;
import com.cmc.credagility.core.domain.businesscontext.BCIQueueSorter;
import com.cmc.credagility.core.domain.user.User;

import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.BCQueueAction;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 12:54
 */
@Entity public class BCIQueueExportRequest extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "bciQueueExportRequest",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
// @OrderBy("createDate desc")
  protected List<BCIQueueExportPhoneType> bciQueueExportPhoneType = new ArrayList<BCIQueueExportPhoneType>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "bciQueueFilterId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIQueueFilter bciQueueFilter;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "bciQueueSorterId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIQueueSorter bciQueueSorter;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "bcQueueActionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCQueueAction bcQueueAction;

  /** TODO: DOCUMENT ME! */
  protected BigDecimal exportedBalance;

  /** TODO: DOCUMENT ME! */
  protected Integer exportedCountOfInstances;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String fileName;

  /** TODO: DOCUMENT ME! */
  @Column(name = "finishedTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date finishedTime;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "queueExportDestinationId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected QueueExportDestination queueExportDestination;

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

  // QueueExportRequest status: INPROCESS/FINISHED
  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String status = "INPROCESS";

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for bci queue export phone type.
   *
   * @return  List
   */
  public List<BCIQueueExportPhoneType> getBciQueueExportPhoneType() {
    return bciQueueExportPhoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bci queue filter.
   *
   * @return  BCIQueueFilter
   */
  public BCIQueueFilter getBciQueueFilter() {
    return bciQueueFilter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bci queue sorter.
   *
   * @return  BCIQueueSorter
   */
  public BCIQueueSorter getBciQueueSorter() {
    return bciQueueSorter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bc queue action.
   *
   * @return  BCQueueAction
   */
  public BCQueueAction getBcQueueAction() {
    return bcQueueAction;
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
   * getter method for exported count of instances.
   *
   * @return  Integer
   */
  public Integer getExportedCountOfInstances() {
    return exportedCountOfInstances;
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
   * getter method for queue export destination.
   *
   * @return  QueueExportDestination
   */
  public QueueExportDestination getQueueExportDestination() {
    return queueExportDestination;
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
   * getter method for status.
   *
   * @return  String
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bci queue export phone type.
   *
   * @param  bciQueueExportPhoneType  List
   */
  public void setBciQueueExportPhoneType(List<BCIQueueExportPhoneType> bciQueueExportPhoneType) {
    this.bciQueueExportPhoneType = bciQueueExportPhoneType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bci queue filter.
   *
   * @param  bciQueueFilter  BCIQueueFilter
   */
  public void setBciQueueFilter(BCIQueueFilter bciQueueFilter) {
    this.bciQueueFilter = bciQueueFilter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bci queue sorter.
   *
   * @param  bciQueueSorter  BCIQueueSorter
   */
  public void setBciQueueSorter(BCIQueueSorter bciQueueSorter) {
    this.bciQueueSorter = bciQueueSorter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bc queue action.
   *
   * @param  bcQueueAction  BCQueueAction
   */
  public void setBcQueueAction(BCQueueAction bcQueueAction) {
    this.bcQueueAction = bcQueueAction;
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
   * setter method for exported count of instances.
   *
   * @param  exportedCountOfInstances  Integer
   */
  public void setExportedCountOfInstances(Integer exportedCountOfInstances) {
    this.exportedCountOfInstances = exportedCountOfInstances;
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
   * setter method for queue export destination.
   *
   * @param  queueExportDestination  QueueExportDestination
   */
  public void setQueueExportDestination(QueueExportDestination queueExportDestination) {
    this.queueExportDestination = queueExportDestination;
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
   * setter method for status.
   *
   * @param  status  String
   */
  public void setStatus(String status) {
    this.status = status;
  }
} // end class BCIQueueExportRequest
