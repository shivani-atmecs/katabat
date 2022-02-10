package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by david on 8/7/15.
 *
 * @author   <a href="mailto:wei.dai@ozstrategy.com">Wei Dai</a>
 * @version  08/07/2015 16:21
 */
@Entity public class ChargeOffResult extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "accountNum",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account = new Account();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "chargeOffActionId",
    nullable = false
  )
  @ManyToOne protected ChargeOffAction chargeOffAction;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "chargeOffDate",
    nullable  = false,
    updatable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date chargeOffDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean deltaBatch = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Long masterBatchId;

  /** TODO: DOCUMENT ME! */
  @Column(length = 255)
  protected String reasonCode;

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
   * getter method for charge off action.
   *
   * @return  ChargeOffAction
   */
  public ChargeOffAction getChargeOffAction() {
    return chargeOffAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off date.
   *
   * @return  Date
   */
  public Date getChargeOffDate() {
    return chargeOffDate;
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
   * getter method for id.
   *
   * @return  Long
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
   * getter method for reason code.
   *
   * @return  String
   */
  public String getReasonCode() {
    return reasonCode;
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
   * setter method for charge off action.
   *
   * @param  chargeOffAction  ChargeOffAction
   */
  public void setChargeOffAction(ChargeOffAction chargeOffAction) {
    this.chargeOffAction = chargeOffAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off date.
   *
   * @param  chargeOffDate  Date
   */
  public void setChargeOffDate(Date chargeOffDate) {
    this.chargeOffDate = chargeOffDate;
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
   * setter method for reason code.
   *
   * @param  reasonCode  String
   */
  public void setReasonCode(String reasonCode) {
    this.reasonCode = reasonCode;
  }
} // end class ChargeOffResult
