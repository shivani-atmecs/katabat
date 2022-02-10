package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;


/**
 * This class is used to store schedule process action result information.
 *
 * <p><a href="Process.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/16/2014 14:04
 */
public class ProcessActionResult extends BaseEntity implements Comparable<ProcessActionResult> {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The base node action which result belong to. */
  protected BaseNodeAction action;


  /** TODO: DOCUMENT ME! */
  protected Long actionAccounts = 0L;


  /** TODO: DOCUMENT ME! */
  protected Long actionResponsibles = 0L;


  /** TODO: DOCUMENT ME! */
  protected Node node = new Node();

  /** The portfolio which schedule belong to. */
  protected Portfolio portfolio = new Portfolio();

  /** The process which result belong to. */
  protected ScheduleProcess process = new ScheduleProcess();

  /** primary key: Process Id: batchId/cidRunId .. */
  protected Long resultId;


  /** TODO: DOCUMENT ME! */
  protected Schedule schedule = new Schedule();


  /** TODO: DOCUMENT ME! */
  protected Long uniqueAccounts = 0L;


  /** TODO: DOCUMENT ME! */
  protected Long uniqueResponsibles = 0L;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ProcessActionResult object.
   */
  public ProcessActionResult() { }

  /**
   * Creates a new ProcessActionResult object.
   *
   * @param  action             BaseNodeAction
   * @param  currNode           Node
   * @param  actionUniqueCount  Long
   */
  public ProcessActionResult(BaseNodeAction action, Node currNode, Long actionUniqueCount) {
    this.actionAccounts = actionUniqueCount;
    this.action         = action;
    this.node           = currNode;
  }

  /**
   * Creates a new ProcessActionResult object.
   *
   * @param  action                        BaseNodeAction
   * @param  currNode                      Node
   * @param  actionUniqueCount             Long
   * @param  actionUniqueResponsibleCount  Long
   */
  public ProcessActionResult(BaseNodeAction action, Node currNode, Long actionUniqueCount,
    Long actionUniqueResponsibleCount) {
    this(action, currNode, actionUniqueCount);
    this.actionResponsibles = actionUniqueResponsibleCount;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Comparable#compareTo(Object)
   */
  @Override public int compareTo(ProcessActionResult oResult) {
    if ((this.getAction() != null) && (this.getAction().getPriority() != null)) {
      if ((oResult.getAction() != null) && (oResult.getAction().getPriority() != null)) {
        return this.getAction().getPriority().compareTo(oResult.getAction().getPriority());
      } else {
        return 1;
      }
    } else {
      if ((oResult.getAction() != null) && (oResult.getAction().getPriority() != null)) {
        return -1;
      } else {
        return 0;
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    ProcessActionResult that = (ProcessActionResult) o;

    if ((action != null) ? (!action.equals(that.action)) : (that.action != null)) {
      return false;
    }

    if ((process != null) ? (!process.equals(that.process)) : (that.process != null)) {
      return false;
    }

    return true;
  } // end method equals

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
   * getter method for action accounts.
   *
   * @return  Long
   */
  public Long getActionAccounts() {
    return actionAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action responsibles.
   *
   * @return  Long
   */
  public Long getActionResponsibles() {
    return actionResponsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node.
   *
   * @return  Node
   */
  public Node getNode() {
    return node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
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
   * getter method for ref node.
   *
   * @return  Node
   */
  public Node getRefNode() {
    return node;


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
   * getter method for schedule.
   *
   * @return  Schedule
   */
  public Schedule getSchedule() {
    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unique accounts.
   *
   * @return  Long
   */
  public Long getUniqueAccounts() {
    return uniqueAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unique responsibles.
   *
   * @return  Long
   */
  public Long getUniqueResponsibles() {
    return uniqueResponsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((process != null) ? process.hashCode() : 0);
    result = (31 * result) + ((action != null) ? action.hashCode() : 0);

    return result;
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
   * setter method for action accounts.
   *
   * @param  actionAccounts  Long
   */
  public void setActionAccounts(Long actionAccounts) {
    this.actionAccounts = actionAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action responsibles.
   *
   * @param  actionResponsibles  Long
   */
  public void setActionResponsibles(Long actionResponsibles) {
    this.actionResponsibles = actionResponsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node.
   *
   * @param  node  Node
   */
  public void setNode(Node node) {
    this.node = node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
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
   * setter method for result id.
   *
   * @param  resultId  Long
   */
  public void setResultId(Long resultId) {
    this.resultId = resultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule.
   *
   * @param  schedule  Schedule
   */
  public void setSchedule(Schedule schedule) {
    this.schedule = schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unique accounts.
   *
   * @param  uniqueAccounts  Long
   */
  public void setUniqueAccounts(Long uniqueAccounts) {
    this.uniqueAccounts = uniqueAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unique responsibles.
   *
   * @param  uniqueResponsibles  Long
   */
  public void setUniqueResponsibles(Long uniqueResponsibles) {
    this.uniqueResponsibles = uniqueResponsibles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("ProcessActionResult{");

    // sb.append("process=").append(process);
    sb.append("action=").append(action.getName());

    if (action instanceof ChannelAction) {
      ChannelAction ca = ((ChannelAction) action);

      if (ca.getTemplate() != null) {
        sb.append("/").append(ca.getTemplate().getName());
      } else if (ca.getEnterpriseDocument() != null) {
        sb.append("/").append(ca.getEnterpriseDocument().getName());
      }
    }

    // sb.append(", resultId=").append(resultId);
    sb.append(", actionAccounts=").append(actionAccounts);
    sb.append(", actionResponsibles=").append(actionResponsibles);
    sb.append(", actionUniqueAccounts=").append(uniqueAccounts);
    sb.append(", actionUniqueResponsibles=").append(uniqueResponsibles);
    sb.append('}');

    return sb.toString();
  } // end method toString
} // end class ProcessActionResult
