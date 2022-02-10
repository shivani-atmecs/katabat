package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.assignmentaction.AgentAssignmentUserRole;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 10:53
 */
@Entity
@Table(
  name    = "AgentAssignmentAction",
  indexes = {
    @Index(
      name = "actionNameIndex",
      columnList = "name"
    )
  }
)
public class AgentAssignmentAction extends PortfolioBaseNodeAction {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -1L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         accountLabeledDate;


  /** TODO: DOCUMENT ME! */
  @ManyToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "nodeAgentActions"
  )
  protected Set<Node> agentNodes = new LinkedHashSet<Node>();


  /** TODO: DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         assignDate;


  /** TODO: DOCUMENT ME! */
  @Column(length = 1024)
  protected String path;


  /** TODO: DOCUMENT ME! */
  @Transient protected String tempPath;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean visible;

  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "agentAssignmentAction",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  private Set<AgentAssignmentUserRole> agentAssignmentUserRoles = new LinkedHashSet<AgentAssignmentUserRole>();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new QueueAction object.
   */
  public AgentAssignmentAction() {
    actionType = BaseNodeAction.ActionType_AGENTASSIGN;
  }

  /**
   * Creates a new QueueAction object.
   *
   * @param  id  Long
   */
  public AgentAssignmentAction(Long id) {
    this.id = id;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * beforeExecute.
   */
  @Override public void beforeExecute() { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @return  BaseNodeAction
   */
  @Override public BaseNodeAction duplicate() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  PortfolioBaseNodeAction#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof AgentAssignmentAction)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    AgentAssignmentAction that = (AgentAssignmentAction) o;

    if ((accountLabeledDate != null) ? (!accountLabeledDate.equals(that.accountLabeledDate))
                                     : (that.accountLabeledDate != null)) {
      return false;
    }

// if ((assignAgents != null) ? (!assignAgents.equals(
// that.assignAgents)) : (that.assignAgents != null)) {
// return false;
// }

    if ((assignDate != null) ? (!assignDate.equals(that.assignDate)) : (that.assignDate != null)) {
      return false;
    }

    if ((agentAssignmentUserRoles != null) ? (!agentAssignmentUserRoles.equals(that.agentAssignmentUserRoles))
                                           : (that.agentAssignmentUserRoles != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Executable#execute(com.ozstrategy.credagility.core.helper.EvaluateHelper,
   *       com.ozstrategy.credagility.core.helper.ExecuteHelper)
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get Account labeled date.
   *
   * @return  Account labeled date
   */
  public Date getAccountLabeledDate() {
    return accountLabeledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent assignment user roles.
   *
   * @return  Set
   */
  public Set<AgentAssignmentUserRole> getAgentAssignmentUserRoles() {
    return agentAssignmentUserRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent nodes.
   *
   * @return  Set
   */
  public Set<Node> getAgentNodes() {
    return agentNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all queue assigned agents.
   *
   * @return  queue assign agents
   */
// public Set<User> getAssignAgents() {
// return assignAgents;
// }

  /**
   * Get assignment date.
   *
   * @return  queue assign date
   */
  public Date getAssignDate() {
    return assignDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Stashed changes DOCUMENT ME!
   *
   * @return  stashed changes DOCUMENT ME!
   */
  public String getPath() {
    return path;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for temp path.
   *
   * @return  String
   */
  public String getTempPath() {
    return tempPath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for visible.
   *
   * @return  Boolean
   */
  public Boolean getVisible() {
    if (visible == null) {
      return Boolean.TRUE;
    }

    return visible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Com.ozstrategy.com.ozstrategy.credagility.core.domain.QueueAction#hashCode().
   *
   * @return  com.ozstrategy.com.ozstrategy.credagility.core.domain.QueueAction#hashCode().
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result)
      + ((accountLabeledDate != null) ? accountLabeledDate.hashCode() : 0);

// result = (31 * result)
// + ((assignAgents != null) ? assignAgents.hashCode() : 0);
    result = (31 * result)
      + ((assignDate != null) ? assignDate.hashCode() : 0);
    result = (31 * result)
      + ((agentAssignmentUserRoles != null) ? agentAssignmentUserRoles.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set account labeled date.
   *
   * @param  accountLabeledDate  account label date
   */
  public void setAccountLabeledDate(Date accountLabeledDate) {
    this.accountLabeledDate = accountLabeledDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent assignment user roles.
   *
   * @param  agentAssignmentUserRoles  Set
   */
  public void setAgentAssignmentUserRoles(Set<AgentAssignmentUserRole> agentAssignmentUserRoles) {
    this.agentAssignmentUserRoles = agentAssignmentUserRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent nodes.
   *
   * @param  agentNodes  Set
   */
  public void setAgentNodes(Set<Node> agentNodes) {
    this.agentNodes = agentNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set assign date.
   *
   * @param  assignDate  assign date to set
   */
  public void setAssignDate(Date assignDate) {
    this.assignDate = assignDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  @Override public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for path.
   *
   * @param  path  String
   */
  public void setPath(String path) {
    this.path = path;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for temp path.
   *
   * @param  tempPath  String
   */
  public void setTempPath(String tempPath) {
    this.tempPath = tempPath;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for visible.
   *
   * @param  visible  Boolean
   */
  public void setVisible(Boolean visible) {
    this.visible = visible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("AgentAssignmentAction{");
    sb.append("accountLabeledDate=").append(accountLabeledDate);
// sb.append(", assignAgents=").append(assignAgents);
    sb.append(", assignDate=").append(assignDate);
    sb.append(", agentAssignmentUserRoles=").append(agentAssignmentUserRoles);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private String buildSegmentPath(String trimPath, String splitTag) {
    StringBuilder sb        = new StringBuilder();
    String[]      trimPaths = trimPath.split(splitTag);
    int           length    = trimPaths.length;

    if (length > 1) {
      int i = 1;

      while (i < length) {
        String tPath = trimPaths[i];

        if (tPath.split(":").length > 1) { // more than one parent queue in the node.

          String[] tPaths = tPath.split(":");
          int      j      = 0;

          for (String s : tPaths) {
            sb.append(trimPaths[0]);
            sb.append(splitTag);
            sb.append(s);
            j++;

            if (j < tPaths.length) {
              sb.append(",");
            }
          }
        } else {
          sb.append(trimPaths[0]);
          sb.append(splitTag);
          sb.append(trimPaths[i]);
        }

        i++;

        if (i < length) {
          sb.append(",");
        }
      } // end while
    } else {
      sb.append(trimPath);
    }   // end if-else

    return sb.toString();
  } // end method buildSegmentPath

  //~ ------------------------------------------------------------------------------------------------------------------

  private void generateParentPath(Node parent, StringBuilder sb, String splitTag) {
    if (parent != null) {
      if (parent.getNodeQueueActions().size() > 0) {
        sb.append(splitTag);

        Set<QueueAction> queues    = parent.getNodeQueueActions();
        int              loopIndex = 0;

        for (QueueAction queue : queues) {
          sb.append(queue.getName());
          sb.append("!");
          sb.append(queue.getId());
          loopIndex++;

          if (loopIndex < queues.size()) {
            sb.append(":");
          }
        }
      }

      generateParentPath(parent.getParentNode(), sb, splitTag);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private String queuePathTrim(String path, String splitTag) {
    String[]    ap        = path.split(",");
    int         length    = ap.length;
    Set<String> resultSet = new LinkedHashSet<String>();

    for (int i = 0; i < length; i++) {
      String   pps = ap[i];
      String[] ppa = pps.split(splitTag);

      for (String pp : ppa) {
        int     index = 0;
        boolean match = false;

        while (index < length) {
          if (!ap[index].contains(pp)) {
            match = false;

            break;
          }

          match = true;
          index++;
        }

        if (match == true) {
          resultSet.add(pp);
        }
      }
    }

    StringBuilder sb           = new StringBuilder();
    int           resultLength = resultSet.size();

    for (String s : resultSet) {
      sb.append(s);
      --resultLength;

      if (resultLength != 0) {
        sb.append(splitTag);
      }
    }

    return sb.toString();
  } // end method queuePathTrim
} // end class AgentAssignmentAction
