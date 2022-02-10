package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowUpdateVariable;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/22/2015 14:00
 */
@Entity public class UpdateActionTriggeredAccount extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2142316214117832085L;

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
  @Column(nullable = true)
  protected Long masterBatchId;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "responsibleId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;


  /** TODO: DOCUMENT ME! */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long updateActionAccountId;

  @JoinColumn(
    name       = "updateActionId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private NodeUpdateAction updateAction;

  @JoinColumn(
    name       = "updateVariableId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private WorkflowUpdateVariable updateVariable = new WorkflowUpdateVariable();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
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

    UpdateActionTriggeredAccount that = (UpdateActionTriggeredAccount) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((responsible != null) ? (!responsible.equals(that.responsible)) : (that.responsible != null)) {
      return false;
    }

    return !((updateVariable != null) ? (!updateVariable.equals(that.updateVariable)) : (that.updateVariable != null));

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
   * getter method for master batch id.
   *
   * @return  Long
   */
  public Long getMasterBatchId() {
    return masterBatchId;
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
   * getter method for update action.
   *
   * @return  NodeUpdateAction
   */
  public NodeUpdateAction getUpdateAction() {
    return updateAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for update action account id.
   *
   * @return  Long
   */
  public Long getUpdateActionAccountId() {
    return updateActionAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for update variable.
   *
   * @return  WorkflowUpdateVariable
   */
  public WorkflowUpdateVariable getUpdateVariable() {
    return updateVariable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);
    result = (31 * result) + ((updateVariable != null) ? updateVariable.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  account  DOCUMENT ME!
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  masterBatchId  DOCUMENT ME!
   */
  public void setMasterBatchId(Long masterBatchId) {
    this.masterBatchId = masterBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  responsible  DOCUMENT ME!
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  updateAction  DOCUMENT ME!
   */
  public void setUpdateAction(NodeUpdateAction updateAction) {
    this.updateAction = updateAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  updateActionAccountId  DOCUMENT ME!
   */
  public void setUpdateActionAccountId(Long updateActionAccountId) {
    this.updateActionAccountId = updateActionAccountId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  updateVariable  DOCUMENT ME!
   */
  public void setUpdateVariable(WorkflowUpdateVariable updateVariable) {
    this.updateVariable = updateVariable;
  }
} // end class UpdateActionTriggeredAccount
