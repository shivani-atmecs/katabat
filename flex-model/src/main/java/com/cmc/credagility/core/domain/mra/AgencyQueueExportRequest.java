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

import com.cmc.credagility.core.domain.agency.AgencyQueueFilter;
import com.cmc.credagility.core.domain.agency.AgencyQueueSorter;
import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.user.User;

import com.ozstrategy.credagility.core.domain.decisiontree.agency.AgencyQueueAction;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 12:42
 */
@Entity public class AgencyQueueExportRequest extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agencyQueueActionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyQueueAction agencyQueueAction;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "agencyQueueExportRequest",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
// @OrderBy("createDate desc")
  protected List<AgencyQueueExportPhoneType> agencyQueueExportPhoneTypes = new ArrayList<AgencyQueueExportPhoneType>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agencyQueueFilterId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyQueueFilter agencyQueueFilter;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agencyQueueSorterId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyQueueSorter agencyQueueSorter;

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

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String status = "INPROCESS";

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency queue action.
   *
   * @return  AgencyQueueAction
   */
  public AgencyQueueAction getAgencyQueueAction() {
    return agencyQueueAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency queue export phone types.
   *
   * @return  List
   */
  public List<AgencyQueueExportPhoneType> getAgencyQueueExportPhoneTypes() {
    return agencyQueueExportPhoneTypes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency queue filter.
   *
   * @return  AgencyQueueFilter
   */
  public AgencyQueueFilter getAgencyQueueFilter() {
    return agencyQueueFilter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency queue sorter.
   *
   * @return  AgencyQueueSorter
   */
  public AgencyQueueSorter getAgencyQueueSorter() {
    return agencyQueueSorter;
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
   * setter method for agency queue action.
   *
   * @param  agencyQueueAction  AgencyQueueAction
   */
  public void setAgencyQueueAction(AgencyQueueAction agencyQueueAction) {
    this.agencyQueueAction = agencyQueueAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency queue export phone types.
   *
   * @param  agencyQueueExportPhoneTypes  List
   */
  public void setAgencyQueueExportPhoneTypes(List<AgencyQueueExportPhoneType> agencyQueueExportPhoneTypes) {
    this.agencyQueueExportPhoneTypes = agencyQueueExportPhoneTypes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency queue filter.
   *
   * @param  agencyQueueFilter  AgencyQueueFilter
   */
  public void setAgencyQueueFilter(AgencyQueueFilter agencyQueueFilter) {
    this.agencyQueueFilter = agencyQueueFilter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency queue sorter.
   *
   * @param  agencyQueueSorter  AgencyQueueSorter
   */
  public void setAgencyQueueSorter(AgencyQueueSorter agencyQueueSorter) {
    this.agencyQueueSorter = agencyQueueSorter;
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
} // end class AgencyQueueExportRequest
