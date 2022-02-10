package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.account.Account;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 10:07
 */
@MappedSuperclass public abstract class AbstractQueueAccount extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean deltaBatch = Boolean.FALSE;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Long masterBatchId;


  /** TODO: DOCUMENT ME! */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long queueAccountId;

  @JoinColumn(
    name       = "queueActionId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private QueueAction queueAction = new QueueAction();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    AbstractQueueAccount that = (AbstractQueueAccount) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((queueAction != null) ? (!queueAction.equals(that.queueAction)) : (that.queueAction != null)) {
      return false;
    }

    return true;
  }

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
   * getter method for delta batch.
   *
   * @return  Boolean
   */
  public Boolean getDeltaBatch() {
    return deltaBatch;
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
   * getter method for queue account id.
   *
   * @return  Long
   */
  public Long getQueueAccountId() {
    return queueAccountId;
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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result)
      + ((queueAction != null) ? queueAction.hashCode() : 0);
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);

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
   * setter method for delta batch.
   *
   * @param  deltaBatch  Boolean
   */
  public void setDeltaBatch(Boolean deltaBatch) {
    this.deltaBatch = deltaBatch;
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
   * setter method for queue account id.
   *
   * @param  queueAccountId  Long
   */
  public void setQueueAccountId(Long queueAccountId) {
    this.queueAccountId = queueAccountId;
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
} // end class AbstractQueueAccount
