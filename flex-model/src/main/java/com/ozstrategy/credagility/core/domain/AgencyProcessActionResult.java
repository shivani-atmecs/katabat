package com.ozstrategy.credagility.core.domain;

import javax.persistence.Column;
import javax.persistence.Id;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 10:25
 */
public class AgencyProcessActionResult implements Comparable<AgencyProcessActionResult> {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  protected BaseNodeAction action;


  /** TODO: DOCUMENT ME! */
  protected Long actionAgencyCounts = 0L;


  /** TODO: DOCUMENT ME! */
  protected BaseNode node;


  /** TODO: DOCUMENT ME! */
  @Id protected Long resultId;


  /** TODO: DOCUMENT ME! */
  protected BaseSchedule schedule;


  /** TODO: DOCUMENT ME! */
  @Column protected Long uniqueAgencyCounts = 0L;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Comparable#compareTo(Object)
   */
  @Override public int compareTo(AgencyProcessActionResult oResult) {
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

    if (!(o instanceof AgencyProcessActionResult)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    AgencyProcessActionResult that = (AgencyProcessActionResult) o;

    if ((action != null) ? (!action.equals(that.action)) : (that.action != null)) {
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
   * getter method for action agency counts.
   *
   * @return  Long
   */
  public Long getActionAgencyCounts() {
    return actionAgencyCounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node.
   *
   * @return  BaseNode
   */
  public BaseNode getNode() {
    return node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ref node.
   *
   * @return  BaseNode
   */
  public BaseNode getRefNode() {
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
   * @return  BaseSchedule
   */
  public BaseSchedule getSchedule() {
    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unique agency counts.
   *
   * @return  Long
   */
  public Long getUniqueAgencyCounts() {
    return uniqueAgencyCounts;
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
   * setter method for action agency counts.
   *
   * @param  actionAgencyCounts  Long
   */
  public void setActionAgencyCounts(Long actionAgencyCounts) {
    this.actionAgencyCounts = actionAgencyCounts;
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
   * setter method for node.
   *
   * @param  node  BaseNode
   */
  public void setNode(BaseNode node) {
    this.node = node;
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
   * @param  schedule  BaseSchedule
   */
  public void setSchedule(BaseSchedule schedule) {
    this.schedule = schedule;
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
   * setter method for unique agency counts.
   *
   * @param  uniqueAgencyCounts  Long
   */
  public void setUniqueAgencyCounts(Long uniqueAgencyCounts) {
    this.uniqueAgencyCounts = uniqueAgencyCounts;
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

    sb.append("action=").append(action.getName());

    if (action instanceof ChannelAction) {
      ChannelAction ca = ((ChannelAction) action);

      if (ca.getTemplate() != null) {
        sb.append("/").append(ca.getTemplate().getName());
      } else if (ca.getEnterpriseDocument() != null) {
        sb.append("/").append(ca.getEnterpriseDocument().getName());
      }
    }

    sb.append(", actionAgencyCounts=").append(actionAgencyCounts);
    sb.append(", uniqueAgencyCounts=").append(uniqueAgencyCounts);
    sb.append('}');

    return sb.toString();
  } // end method toString
} // end class AgencyProcessActionResult
