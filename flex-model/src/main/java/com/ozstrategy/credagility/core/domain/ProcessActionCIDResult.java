package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;


/**
 * This class is used to store schedule process action result information.
 *
 * <p><a href="Process.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/16/2014 14:01
 */
public class ProcessActionCIDResult extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected Account account;

  /** The base node action which result belong to. */
  protected BaseNodeAction action;

  /** The process which result belong to. */
  protected ScheduleProcess process = new ScheduleProcess();


  /** TODO: DOCUMENT ME! */
  protected Responsible responsible;

  /** primary key: Process Id: batchId/cidRunId .. */
  protected Long resultId;

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

    ProcessActionCIDResult that = (ProcessActionCIDResult) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((action != null) ? (!action.equals(that.action)) : (that.action != null)) {
      return false;
    }

    if ((process != null) ? (!process.equals(that.process)) : (that.process != null)) {
      return false;
    }

    if ((responsible != null) ? (!responsible.equals(that.responsible)) : (that.responsible != null)) {
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
   * @return  BaseNodeAction
   */
  public BaseNodeAction getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for process.
   *
   * @return  ScheduleProcess
   */
  public ScheduleProcess getProcess() {
    return process;
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
   * getter method for result id.
   *
   * @return  Long
   */
  public Long getResultId() {
    return resultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((action != null) ? action.hashCode() : 0);
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result)
      + ((responsible != null) ? responsible.hashCode() : 0);
    result = (31 * result) + ((process != null) ? process.hashCode() : 0);

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
   * @param  action  BaseNodeAction
   */
  public void setAction(BaseNodeAction action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for process.
   *
   * @param  process  ScheduleProcess
   */
  public void setProcess(ScheduleProcess process) {
    this.process = process;
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
   * setter method for result id.
   *
   * @param  resultId  Long
   */
  public void setResultId(Long resultId) {
    this.resultId = resultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("ProcessActionCIDResult");
    sb.append("{action=").append(action);
    sb.append(", account=").append(account);
    sb.append(", responsible=").append(responsible);
    sb.append(", process=").append(process);
    sb.append(", resultId=").append(resultId);
    sb.append('}');

    return sb.toString();
  }
} // end class ProcessActionCIDResult
