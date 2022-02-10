package com.ozstrategy.credagility.core.domain.audit;

import com.cmc.credagility.core.domain.account.Account;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.QueueAction;
import com.ozstrategy.credagility.core.domain.ReQueueAction;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * ReQueue Audit.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 17:29
 */
@Entity public class ReQueueAudit extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account. */
  @JoinColumn(
    name       = "accountNum",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** 'R' 'I'. */
  protected String action;

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** Queue Action. */
  @JoinColumn(
    name       = "queueActionId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected QueueAction queueAction;


  /** ReQueue Action. */
  @JoinColumn(
    name       = "reQueueActionId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ReQueueAction reQueueAction;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ReQueueAudit object.
   */
  public ReQueueAudit() { }

  /**
   * Creates a new ReQueueAudit object.
   *
   * @param  account        DOCUMENT ME!
   * @param  reQueueAction  DOCUMENT ME!
   * @param  queueAction    DOCUMENT ME!
   * @param  auditType      DOCUMENT ME!
   */
  public ReQueueAudit(Account account, ReQueueAction reQueueAction, QueueAction queueAction,
    ReQueueActionAuditType auditType) {
    this.account       = account;
    this.reQueueAction = reQueueAction;
    this.action        = auditType.name();
    this.queueAction   = queueAction;
  }

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

    if (!super.equals(o)) {
      return false;
    }

    ReQueueAudit that = (ReQueueAudit) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((action != null) ? (!action.equals(that.action)) : (that.action != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((queueAction != null) ? (!queueAction.equals(that.queueAction)) : (that.queueAction != null)) {
      return false;
    }

    if ((reQueueAction != null) ? (!reQueueAction.equals(that.reQueueAction)) : (that.reQueueAction != null)) {
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
   * getter method for action.
   *
   * @return  String
   */
  public String getAction() {
    return action;
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
   * getter method for re queue action.
   *
   * @return  ReQueueAction
   */
  public ReQueueAction getReQueueAction() {
    return reQueueAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((action != null) ? action.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((queueAction != null) ? queueAction.hashCode() : 0);
    result = (31 * result) + ((reQueueAction != null) ? reQueueAction.hashCode() : 0);

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
   * setter method for action.
   *
   * @param  action  String
   */
  public void setAction(String action) {
    this.action = action;
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
   * setter method for re queue action.
   *
   * @param  reQueueAction  ReQueueAction
   */
  public void setReQueueAction(ReQueueAction reQueueAction) {
    this.reQueueAction = reQueueAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.CreatorEntity#toString()
   */
  @Override public String toString() {
    return "ReQueueAudit{"
      + "account=" + account
      + ", action='" + action + '\''
      + ", id=" + id
      + ", queueAction=" + queueAction
      + ", reQueueAction=" + reQueueAction
      + '}';
  }
} // end class ReQueueAudit
