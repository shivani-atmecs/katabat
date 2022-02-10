package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.assignmentaction.AgencyAccount;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.customer.Customer;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  09/23/2015 17:38
 */
@Entity @Table public class RecallResult extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -8095979237580447156L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "accountNum",
    nullable = false
  )
  @ManyToOne protected Account account;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "agencyAccountId",
    nullable = true
  )
  @ManyToOne protected AgencyAccount agencyAccount;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "customerId",
    nullable = true
  )
  @ManyToOne protected Customer customer;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean deltaBatch = Boolean.FALSE;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Long masterBatchId;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "recallActionId",
    nullable = false
  )
  @ManyToOne protected RecallAction recallAction;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "recallExportedDate",
    nullable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date recallExportedDate;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "recallReasonId",
    nullable = false
  )
  @ManyToOne protected RecallReason recallReason;


  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected RecallResultSourceType sourceType;


  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected RecallResultStatus status = RecallResultStatus.INIT;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new RecallResult object.
   */
  public RecallResult() { }

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
   * getter method for agency account.
   *
   * @return  AgencyAccount
   */
  public AgencyAccount getAgencyAccount() {
    return agencyAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Customer.
   *
   * @return  Customer.
   */
  public Customer getCustomer() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delta batch.
   *
   * @return  Boolean
   */
  public Boolean getDeltaBatch() {
    return deltaBatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for master batch id.
   *
   * @return  Long
   */
  public Long getMasterBatchId() {
    return masterBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * RecallAction.
   *
   * @return  RecallAction.
   */
  public RecallAction getRecallAction() {
    return recallAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recall exported date.
   *
   * @return  Date
   */
  public Date getRecallExportedDate() {
    return recallExportedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * RecallReason.
   *
   * @return  RecallReason.
   */
  public RecallReason getRecallReason() {
    return recallReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * RecallResultSourceType.
   *
   * @return  RecallResultSourceType.
   */
  public RecallResultSourceType getSourceType() {
    return sourceType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * RecallResultStatus.
   *
   * @return  RecallResultStatus.
   */
  public RecallResultStatus getStatus() {
    return status;
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
   * setter method for agency account.
   *
   * @param  agencyAccount  AgencyAccount
   */
  public void setAgencyAccount(AgencyAccount agencyAccount) {
    this.agencyAccount = agencyAccount;
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
   * setter method for delta batch.
   *
   * @param  deltaBatch  Boolean
   */
  public void setDeltaBatch(Boolean deltaBatch) {
    this.deltaBatch = deltaBatch;
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
   * setter method for master batch id.
   *
   * @param  masterBatchId  Long
   */
  public void setMasterBatchId(Long masterBatchId) {
    this.masterBatchId = masterBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recall action.
   *
   * @param  recallAction  RecallAction
   */
  public void setRecallAction(RecallAction recallAction) {
    this.recallAction = recallAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recall exported date.
   *
   * @param  recallExportedDate  Date
   */
  public void setRecallExportedDate(Date recallExportedDate) {
    this.recallExportedDate = recallExportedDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recall reason.
   *
   * @param  recallReason  RecallReason
   */
  public void setRecallReason(RecallReason recallReason) {
    this.recallReason = recallReason;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for source type.
   *
   * @param  sourceType  RecallResultSourceType
   */
  public void setSourceType(RecallResultSourceType sourceType) {
    this.sourceType = sourceType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  RecallResultStatus
   */
  public void setStatus(RecallResultStatus status) {
    this.status = status;
  }
} // end class RecallResult
