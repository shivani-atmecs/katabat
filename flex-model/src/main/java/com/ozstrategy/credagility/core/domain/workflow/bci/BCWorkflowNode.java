package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeType;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowNode;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 *
 * @author   $author$
 * @version  $Revision$, $Date$ : Wang Yang : 13-2-26
 */
@Entity
@Table(name = "BCWorkflowNode")
public class BCWorkflowNode extends BasicWorkflowNode implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -1201666009314775366L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Many to many with table BCWorkflowNodeAssignAgent. */
  @JoinTable(
    name               = "BCWorkflowNodeAssignAgent",
    indexes            = { @Index(columnList = "nodeId") },
    joinColumns        = {
      @JoinColumn(
        name           = "nodeId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "agentId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected Set<User> assignAgents = new HashSet<User>();

  /** Many to many with table BCWorkflowNodeAssignRole. */
  @JoinTable(
    name               = "BCWorkflowNodeAssignRole",
    indexes            = { @Index(columnList = "nodeId") },
    joinColumns        = {
      @JoinColumn(
        name           = "nodeId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "roleId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected Set<Role> assignRoles = new HashSet<Role>();


  /** BCWorkflowNodeChannelAction PK node. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "node",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<BCWorkflowNodeChannelAction> channelActions = new LinkedHashSet<BCWorkflowNodeChannelAction>();

  /** BCWorkflowNodeChannelAction PK node. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "node",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  @Where(clause = "triggerType = 'DAILY'")
  protected Set<BCWorkflowNodeChannelAction> dailyChannelActions = new LinkedHashSet<BCWorkflowNodeChannelAction>();

  /** BCWorkflowNodeFlowAction PK node. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "node",
    cascade  = { CascadeType.ALL }
  )
  @Where(clause = "triggerType = 'DAILY'")
  protected Set<BCWorkflowNodeFlowAction> dailyFlowActions = new LinkedHashSet<BCWorkflowNodeFlowAction>();

  /** BCWorkflowNodeQueueAction PK node. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "node",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  @Where(clause = "triggerType = 'DAILY'")
  protected Set<BCWorkflowNodeQueueAction> dailyQueueActions = new LinkedHashSet<BCWorkflowNodeQueueAction>();

  /** BCWorkflowNodeVariableAction PK node. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "node",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  @Where(clause = "triggerType = 'DAILY'")
  protected Set<BCWorkflowNodeVariableAction> dailyVariableActions = new LinkedHashSet<BCWorkflowNodeVariableAction>();

  /** BCWorkflowNodeFlowAction PK node. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "node",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<BCWorkflowNodeFlowAction> flowActions = new LinkedHashSet<BCWorkflowNodeFlowAction>();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "to"
  )
  @OrderBy("priority asc")
  protected Set<BCWorkflowLink> inSet = new LinkedHashSet<BCWorkflowLink>();

  /** DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "from"
  )
  @OrderBy("priority asc")
  protected Set<BCWorkflowLink> outSet = new LinkedHashSet<BCWorkflowLink>();

  /** DOCUMENT ME! */
  @JoinColumn(name = "progressStepId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowProgressStep progressStep;

  /** BCWorkflowNodeQueueAction PK node. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "node",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<BCWorkflowNodeQueueAction> queueActions = new LinkedHashSet<BCWorkflowNodeQueueAction>();

  /** Sub flow. */
  @JoinColumn(
    name       = "subFlowId",
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflow subFlow;

  /** DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "from"
  )
  @OrderBy("priority asc")
  @Where(clause = "drivenType = 'BATCH'")
  protected Set<BCWorkflowLink> systemOutputLinks = new LinkedHashSet<BCWorkflowLink>();

  /** BCWorkflowNodeUpdateVariableAction PK node. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "node",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<BCWorkflowNodeUpdateVariableAction> updateVariableActions =
    new LinkedHashSet<BCWorkflowNodeUpdateVariableAction>();

  /** BCWorkflowNodeVariableAction PK node. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "node",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<BCWorkflowNodeVariableAction> variableActions = new LinkedHashSet<BCWorkflowNodeVariableAction>();

  /** The workflow this node belonged to. */
  @JoinColumn(
    name       = "workflowId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflow workflow;

  /** WorkflowTask. */
  @JoinColumn(
    name       = "workflowTaskId",
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowTask workflowTask;

  @Transient private Long subFlowCopyFromId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  user  DOCUMENT ME!
   */
  public void addAssignAgent(User user) {
    if (null != user) {
      if ((null != this.assignAgents) && (this.assignAgents.size() > 0) && !this.assignAgents.contains(user)) {
        this.assignAgents.add(user);
      } else {
        this.assignAgents.add(user);
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agents  DOCUMENT ME!
   */
  public void addAssignAgents(List<User> agents) {
    if ((agents != null) && (agents.size() > 0)) {
      this.assignAgents.addAll(agents);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  role  DOCUMENT ME!
   */
  public void addAssignRole(Role role) {
    if (null != role) {
      if ((null != this.assignRoles) && (this.assignRoles.size() > 0) && !this.assignRoles.contains(role)) {
        this.assignRoles.add(role);
      } else {
        this.assignRoles.add(role);
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  roles  DOCUMENT ME!
   */
  public void addAssignRoles(List<Role> roles) {
    if ((roles != null) && (roles.size() > 0)) {
      this.assignRoles.addAll(roles);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  channelAction  DOCUMENT ME!
   */
  public void addChannelAction(BCWorkflowNodeChannelAction channelAction) {
    if (channelAction != null) {
      if ((null != this.channelActions) && (this.channelActions.size() > 0)
            && !this.channelActions.contains(channelAction)) {
        this.channelActions.add(channelAction);
      } else {
        this.channelActions.add(channelAction);
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flowAction  DOCUMENT ME!
   */
  public void addFlowAction(BCWorkflowNodeFlowAction flowAction) {
    if (flowAction != null) {
      if ((null != this.flowActions) && (this.flowActions.size() > 0)
            && !this.flowActions.contains(flowAction)) {
        this.flowActions.add(flowAction);
      } else {
        this.flowActions.add(flowAction);
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  copyFrom  DOCUMENT ME!
   */
  public void deepCopy(BCWorkflowNode copyFrom) {
    setRoot(copyFrom.isRoot());
    setWorkflowTask(copyFrom.getWorkflowTask());
    setSubFlow(copyFrom.getSubFlow());
    setType(copyFrom.getType());
    setNoRegret(copyFrom.getNoRegret());
    setAllowWeb(copyFrom.getAllowWeb());
    setAllowSPOC(copyFrom.getAllowSPOC());
    setWorkflow(copyFrom.getWorkflow());

    if (WorkflowNodeType.SUB_FLOW_NODE.equals(copyFrom.getType())) {
      subFlowCopyFromId = copyFrom.getSubFlow().getId();
    }

    // copy assign agents & assign roles--------------
    for (User assignAgent : copyFrom.getAssignAgents()) {
      addAssignAgent(assignAgent);
    }

    for (Role assignRole : copyFrom.getAssignRoles()) {
      addAssignRole(assignRole);
    }

    // Copy flow updateVariableAction
    for (BCWorkflowNodeUpdateVariableAction updateVariableAction : copyFrom.getUpdateVariableActions()) {
      BCWorkflowNodeUpdateVariableAction action = new BCWorkflowNodeUpdateVariableAction();
      action.setCriteria(updateVariableAction.getCriteria());
      action.setCreator(updateVariableAction.getCreator());
      action.setNode(this);
      action.setPriority(updateVariableAction.getPriority());
      action.setTriggerType(updateVariableAction.getTriggerType());
      action.setValue(updateVariableAction.getValue());
      action.setVariable(updateVariableAction.getVariable());
      action.setLastUpdater(updateVariableAction.getLastUpdater());
      this.updateVariableActions.add(action);
    }

    // Copy variableAction
    for (BCWorkflowNodeVariableAction variableAction : copyFrom.getVariableActions()) {
      BCWorkflowNodeVariableAction action = new BCWorkflowNodeVariableAction();
      action.setCriteria(variableAction.getCriteria());
      action.setCreator(variableAction.getCreator());
      action.setNode(this);
      action.setPriority(variableAction.getPriority());
      action.setTriggerType(variableAction.getTriggerType());
      action.setValue(variableAction.getValue());
      action.setVariable(variableAction.getVariable());
      action.setLastUpdater(variableAction.getLastUpdater());
      this.variableActions.add(action);
    }

    // Copy flow actions
    for (BCWorkflowNodeFlowAction action : copyFrom.getFlowActions()) {
      BCWorkflowNodeFlowAction act = new BCWorkflowNodeFlowAction();
      act.deepCopy(action);
      act.setNode(this);
      act.setCreator(copyFrom.getCreator());
      act.setCreateDate(copyFrom.getCreateDate());
      this.addFlowAction(act);
    }

    // copy flow channelaction
    for (BCWorkflowNodeChannelAction channelAction : copyFrom.getChannelActions()) {
      BCWorkflowNodeChannelAction acti = new BCWorkflowNodeChannelAction();

      acti.deepCopy(channelAction);
      acti.setNode(this);
      acti.setCreator(copyFrom.getCreator());
      acti.setCreateDate(copyFrom.getCreateDate());
      this.addChannelAction(acti);
    }
    // !-----------------------------------------------
  } // end method deepCopy

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowNode#equals(Object)
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

    BCWorkflowNode that = (BCWorkflowNode) o;

    if ((subFlow != null) ? (!subFlow.equals(that.subFlow)) : (that.subFlow != null)) {
      return false;
    }

    if (!workflow.equals(that.workflow)) {
      return false;
    }

    if ((workflowTask != null) ? (!workflowTask.equals(that.workflowTask)) : (that.workflowTask != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  public boolean isEndFlow() {
    return (this.workflowTask != null && this.workflowTask.getActiveVersion() != null) ? this.workflowTask.getActiveVersion().getEndFlow() : Boolean.FALSE;
  }


  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowNode#getAssignAgents()
   */
  @Override public Set<User> getAssignAgents() {
    return assignAgents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowNode#getAssignRoles()
   */
  @Override public Set<Role> getAssignRoles() {
    return assignRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCWorkflowNodeChannelAction> getChannelActions() {
    return channelActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCWorkflowNodeChannelAction> getDailyChannelActions() {
    return dailyChannelActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCWorkflowNodeFlowAction> getDailyFlowActions() {
    return dailyFlowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCWorkflowNodeQueueAction> getDailyQueueActions() {
    return dailyQueueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCWorkflowNodeVariableAction> getDailyVariableActions() {
    return dailyVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCWorkflowNodeFlowAction> getFlowActions() {
    return flowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowNode#getInSet()
   */
  @Override public Set<BCWorkflowLink> getInSet() {
    return inSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getInstanceId() {
    Long instanceId = null;

    switch (getType()) {
      case SURVEY_NODE: {
        instanceId = getWorkflowTask().getId();

        break;
      }

      case SUB_FLOW_NODE: {
        instanceId = getSubFlow().getId();

        break;
      }

      default: { }
    }

    return instanceId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowNode#getName()
   */
  @Override public String getName() {
    if (this.workflowTask == null) {
      return subFlow.getName();
    }

    return getWorkflowTask().getName();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowNode#getOutSet()
   */
  @Override public Set<BCWorkflowLink> getOutSet() {
    return outSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowProgressStep getProgressStep() {
    return progressStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCWorkflowNodeQueueAction> getQueueActions() {
    return queueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflow getSubFlow() {
    return subFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getSubFlowCopyFromId() {
    return subFlowCopyFromId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowNode#getSystemOutputLinks()
   */
  @Override public Set<BCWorkflowLink> getSystemOutputLinks() {
    return systemOutputLinks;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCWorkflowNodeUpdateVariableAction> getUpdateVariableActions() {
    return updateVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCWorkflowNodeVariableAction> getVariableActions() {
    return variableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowNode#getWorkflow()
   */
  @Override public BCWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTask getWorkflowTask() {
    return workflowTask;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((subFlow != null) ? subFlow.hashCode() : 0);
    result = (31 * result) + workflow.hashCode();
    result = (31 * result) + ((workflowTask != null) ? workflowTask.hashCode() : 0);

    return result;
  }
  

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean isRoot() {
    if (root == null) {
      return Boolean.FALSE;
    }

    return root;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void removeAllAssignAgents() {
    if ((this.assignAgents != null) && (this.assignAgents.size() > 0)) {
      this.assignAgents.clear();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void removeAllAssignRoles() {
    if ((this.assignRoles != null) && (this.assignRoles.size() > 0)) {
      this.assignRoles.clear();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowNode#setAssignAgents(java.util.Set)
   */
  @Override public void setAssignAgents(Set<User> assignAgents) {
    this.assignAgents = assignAgents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowNode#setAssignRoles(java.util.Set)
   */
  @Override public void setAssignRoles(Set<Role> assignRoles) {
    this.assignRoles = assignRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  channelActions  DOCUMENT ME!
   */
  public void setChannelActions(Set<BCWorkflowNodeChannelAction> channelActions) {
    this.channelActions = channelActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dailyChannelActions  DOCUMENT ME!
   */
  public void setDailyChannelActions(Set<BCWorkflowNodeChannelAction> dailyChannelActions) {
    this.dailyChannelActions = dailyChannelActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dailyFlowActions  DOCUMENT ME!
   */
  public void setDailyFlowActions(Set<BCWorkflowNodeFlowAction> dailyFlowActions) {
    this.dailyFlowActions = dailyFlowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dailyQueueActions  DOCUMENT ME!
   */
  public void setDailyQueueActions(Set<BCWorkflowNodeQueueAction> dailyQueueActions) {
    this.dailyQueueActions = dailyQueueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  dailyVariableActions  DOCUMENT ME!
   */
  public void setDailyVariableActions(Set<BCWorkflowNodeVariableAction> dailyVariableActions) {
    this.dailyVariableActions = dailyVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flowActions  DOCUMENT ME!
   */
  public void setFlowActions(Set<BCWorkflowNodeFlowAction> flowActions) {
    this.flowActions = flowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  inSet  DOCUMENT ME!
   */
  public void setInSet(Set<BCWorkflowLink> inSet) {
    this.inSet = inSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  outSet  DOCUMENT ME!
   */
  public void setOutSet(Set<BCWorkflowLink> outSet) {
    this.outSet = outSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  progressStep  DOCUMENT ME!
   */
  public void setProgressStep(BCWorkflowProgressStep progressStep) {
    this.progressStep = progressStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  queueActions  DOCUMENT ME!
   */
  public void setQueueActions(Set<BCWorkflowNodeQueueAction> queueActions) {
    this.queueActions = queueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  subFlow  DOCUMENT ME!
   */
  public void setSubFlow(BCWorkflow subFlow) {
    this.subFlow = subFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  subFlowCopyFromId  DOCUMENT ME!
   */
  public void setSubFlowCopyFromId(Long subFlowCopyFromId) {
    this.subFlowCopyFromId = subFlowCopyFromId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  systemOutputLinks  DOCUMENT ME!
   */
  public void setSystemOutputLinks(Set<BCWorkflowLink> systemOutputLinks) {
    this.systemOutputLinks = systemOutputLinks;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  updateVariableActions  DOCUMENT ME!
   */
  public void setUpdateVariableActions(Set<BCWorkflowNodeUpdateVariableAction> updateVariableActions) {
    this.updateVariableActions = updateVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variableActions  DOCUMENT ME!
   */
  public void setVariableActions(Set<BCWorkflowNodeVariableAction> variableActions) {
    this.variableActions = variableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflow  DOCUMENT ME!
   */
  public void setWorkflow(BCWorkflow workflow) {
    this.workflow = workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowTask  DOCUMENT ME!
   */
  public void setWorkflowTask(BCWorkflowTask workflowTask) {
    this.workflowTask = workflowTask;
  }
} // end class BCWorkflowNode
