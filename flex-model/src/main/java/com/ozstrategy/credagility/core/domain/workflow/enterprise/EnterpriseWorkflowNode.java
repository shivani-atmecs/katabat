package com.ozstrategy.credagility.core.domain.workflow.enterprise;

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
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/17/2014 11:37
 */
@Entity
@Table(name = "EnterpriseWorkflowNode")
public class EnterpriseWorkflowNode extends BasicWorkflowNode implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 5277271371564851096L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "WorkflowNodeAssignAgent",
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


  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "WorkflowNodeAssignRole",
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


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "node",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @Where(clause = "triggerType = 'DAILY'")
  protected Set<EnterpriseWorkflowNodeFlowAction> dailyFlowActions =
    new LinkedHashSet<EnterpriseWorkflowNodeFlowAction>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "node",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @Where(clause = "triggerTime = 'DAILY'")
  protected Set<EnterpriseWorkflowNodeVariableAction> dailyVariableActions =
    new LinkedHashSet<EnterpriseWorkflowNodeVariableAction>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "node",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  protected Set<EnterpriseWorkflowNodeFlowAction> flowActions = new LinkedHashSet<EnterpriseWorkflowNodeFlowAction>();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "to"
  )
  @OrderBy("priority asc")
  protected Set<EnterpriseWorkflowLink> inSet = new LinkedHashSet<EnterpriseWorkflowLink>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "from"
  )
  @OrderBy("priority asc")
  protected Set<EnterpriseWorkflowLink> outSet = new LinkedHashSet<EnterpriseWorkflowLink>();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "stepId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowProgressStep step;

  /** Sub flow. */
  @JoinColumn(
    name       = "subFlowId",
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflow subFlow;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "from"
  )
  @OrderBy("priority asc")
  @Where(clause = "drivenType = 'BATCH'")
  protected Set<EnterpriseWorkflowLink> systemOutputLinks = new LinkedHashSet<EnterpriseWorkflowLink>();

  // todo: Actions [Channel/Program/Variable]


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "node",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  protected Set<EnterpriseWorkflowNodeUpdateVariableAction> updateVariableActions =
    new LinkedHashSet<EnterpriseWorkflowNodeUpdateVariableAction>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "node",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  protected Set<EnterpriseWorkflowNodeVariableAction> variableActions =
    new LinkedHashSet<EnterpriseWorkflowNodeVariableAction>();

  /** The workflow this node belonged to. */
  @JoinColumn(
    name       = "workflowId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflow workflow;

  /** WorkflowTask. */
  @JoinColumn(
    name       = "workflowTaskId",
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflowTask workflowTask;

  @Transient private Long subFlowCopyFromId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addAssignAgent.
   *
   * @param  user  $param.type$
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
   * addAssignAgents.
   *
   * @param  agents  $param.type$
   */
  public void addAssignAgents(List<User> agents) {
    if ((agents != null) && (agents.size() > 0)) {
      this.assignAgents.addAll(agents);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addAssignRole.
   *
   * @param  role  $param.type$
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
   * addAssignRoles.
   *
   * @param  roles  $param.type$
   */
  public void addAssignRoles(List<Role> roles) {
    if ((roles != null) && (roles.size() > 0)) {
      this.assignRoles.addAll(roles);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addFlowAction.
   *
   * @param  flowAction  $param.type$
   */
  public void addFlowAction(EnterpriseWorkflowNodeFlowAction flowAction) {
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
   * deepCopy.
   *
   * @param  copyFrom  $param.type$
   */
  public void deepCopy(EnterpriseWorkflowNode copyFrom) {
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
    for (EnterpriseWorkflowNodeUpdateVariableAction updateVariableAction : copyFrom.getUpdateVariableActions()) {
      EnterpriseWorkflowNodeUpdateVariableAction action = new EnterpriseWorkflowNodeUpdateVariableAction();
      action.setCriteria(updateVariableAction.getCriteria());
      action.setCreator(updateVariableAction.getCreator());
      action.setNode(this);
      action.setPriority(updateVariableAction.getPriority());
      action.setTriggerTime(updateVariableAction.getTriggerTime());
      action.setValue(updateVariableAction.getValue());
      action.setVariable(updateVariableAction.getVariable());
      action.setLastUpdater(updateVariableAction.getLastUpdater());
      this.updateVariableActions.add(action);
    }

    // Copy variableAction
    for (EnterpriseWorkflowNodeVariableAction variableAction : copyFrom.getVariableActions()) {
      EnterpriseWorkflowNodeVariableAction action = new EnterpriseWorkflowNodeVariableAction();
      action.setCriteria(variableAction.getCriteria());
      action.setCreator(variableAction.getCreator());
      action.setNode(this);
      action.setPriority(variableAction.getPriority());
      action.setTriggerTime(variableAction.getTriggerTime());
      action.setValue(variableAction.getValue());
      action.setVariable(variableAction.getVariable());
      action.setLastUpdater(variableAction.getLastUpdater());
      this.variableActions.add(action);
    }

    // Copy flow actions
    for (EnterpriseWorkflowNodeFlowAction action : copyFrom.getFlowActions()) {
      EnterpriseWorkflowNodeFlowAction act = new EnterpriseWorkflowNodeFlowAction();
      act.deepCopy(action);
      act.setNode(this);
      act.setCreator(copyFrom.getCreator());
      act.setCreateDate(copyFrom.getCreateDate());
      this.addFlowAction(act);
    }

    // !-----------------------------------------------
  } // end method deepCopy

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

    EnterpriseWorkflowNode that = (EnterpriseWorkflowNode) o;

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

  /**
   * getter method for assign agents.
   *
   * @return  Set
   */
  @Override public Set<User> getAssignAgents() {
    return assignAgents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for assign roles.
   *
   * @return  Set
   */
  @Override public Set<Role> getAssignRoles() {
    return assignRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set.
   *
   * @return  Set.
   */
  public Set<EnterpriseWorkflowNodeFlowAction> getDailyFlowActions() {
    return dailyFlowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set.
   *
   * @return  Set.
   */
  public Set<EnterpriseWorkflowNodeVariableAction> getDailyVariableActions() {
    return dailyVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set.
   *
   * @return  Set.
   */
  public Set<EnterpriseWorkflowNodeFlowAction> getFlowActions() {
    return flowActions;
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
   * getter method for in set.
   *
   * @return  Set
   */
  @Override public Set<EnterpriseWorkflowLink> getInSet() {
    return inSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
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
   * getter method for name.
   *
   * @return  String
   */
  @Override public String getName() {
    if (this.workflowTask == null) {
      return subFlow.getName();
    }

    return getWorkflowTask().getName();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for out set.
   *
   * @return  Set
   */
  @Override public Set<EnterpriseWorkflowLink> getOutSet() {
    return outSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * EnterpriseWorkflowProgressStep.
   *
   * @return  EnterpriseWorkflowProgressStep.
   */
  public EnterpriseWorkflowProgressStep getStep() {
    return step;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * EnterpriseWorkflow.
   *
   * @return  EnterpriseWorkflow.
   */
  public EnterpriseWorkflow getSubFlow() {
    return subFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getSubFlowCopyFromId() {
    return subFlowCopyFromId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for system output links.
   *
   * @return  Set
   */
  @Override public Set<EnterpriseWorkflowLink> getSystemOutputLinks() {
    return systemOutputLinks;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set.
   *
   * @return  Set.
   */
  public Set<EnterpriseWorkflowNodeUpdateVariableAction> getUpdateVariableActions() {
    return updateVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set.
   *
   * @return  Set.
   */
  public Set<EnterpriseWorkflowNodeVariableAction> getVariableActions() {
    return variableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow.
   *
   * @return  EnterpriseWorkflow
   */
  @Override public EnterpriseWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * EnterpriseWorkflowTask.
   *
   * @return  EnterpriseWorkflowTask.
   */
  public EnterpriseWorkflowTask getWorkflowTask() {
    return workflowTask;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
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
   * Boolean.
   *
   * @return  Boolean.
   */
  public Boolean isRoot() {
    if (root == null) {
      return Boolean.FALSE;
    }

    return root;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeAllAssignAgents.
   */
  public void removeAllAssignAgents() {
    if ((this.assignAgents != null) && (this.assignAgents.size() > 0)) {
      this.assignAgents.clear();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeAllAssignRoles.
   */
  public void removeAllAssignRoles() {
    if ((this.assignRoles != null) && (this.assignRoles.size() > 0)) {
      this.assignRoles.clear();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for assign agents.
   *
   * @param  assignAgents  Set
   */
  @Override public void setAssignAgents(Set<User> assignAgents) {
    this.assignAgents = assignAgents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for assign roles.
   *
   * @param  assignRoles  Set
   */
  @Override public void setAssignRoles(Set<Role> assignRoles) {
    this.assignRoles = assignRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setDailyFlowActions.
   *
   * @param  dailyFlowActions  $param.type$
   */
  public void setDailyFlowActions(Set<EnterpriseWorkflowNodeFlowAction> dailyFlowActions) {
    this.dailyFlowActions = dailyFlowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setDailyVariableActions.
   *
   * @param  dailyVariableActions  $param.type$
   */
  public void setDailyVariableActions(Set<EnterpriseWorkflowNodeVariableAction> dailyVariableActions) {
    this.dailyVariableActions = dailyVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setFlowActions.
   *
   * @param  flowActions  $param.type$
   */
  public void setFlowActions(Set<EnterpriseWorkflowNodeFlowAction> flowActions) {
    this.flowActions = flowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setId.
   *
   * @param  id  $param.type$
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setInSet.
   *
   * @param  inSet  $param.type$
   */
  public void setInSet(Set<EnterpriseWorkflowLink> inSet) {
    this.inSet = inSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setOutSet.
   *
   * @param  outSet  $param.type$
   */
  public void setOutSet(Set<EnterpriseWorkflowLink> outSet) {
    this.outSet = outSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setStep.
   *
   * @param  step  $param.type$
   */
  public void setStep(EnterpriseWorkflowProgressStep step) {
    this.step = step;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setSubFlow.
   *
   * @param  subFlow  $param.type$
   */
  public void setSubFlow(EnterpriseWorkflow subFlow) {
    this.subFlow = subFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setSystemOutputLinks.
   *
   * @param  systemOutputLinks  $param.type$
   */
  public void setSystemOutputLinks(Set<EnterpriseWorkflowLink> systemOutputLinks) {
    this.systemOutputLinks = systemOutputLinks;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setUpdateVariableActions.
   *
   * @param  updateVariableActions  $param.type$
   */
  public void setUpdateVariableActions(Set<EnterpriseWorkflowNodeUpdateVariableAction> updateVariableActions) {
    this.updateVariableActions = updateVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setVariableActions.
   *
   * @param  variableActions  $param.type$
   */
  public void setVariableActions(Set<EnterpriseWorkflowNodeVariableAction> variableActions) {
    this.variableActions = variableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setWorkflow.
   *
   * @param  workflow  $param.type$
   */
  public void setWorkflow(EnterpriseWorkflow workflow) {
    this.workflow = workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setWorkflowTask.
   *
   * @param  workflowTask  $param.type$
   */
  public void setWorkflowTask(EnterpriseWorkflowTask workflowTask) {
    this.workflowTask = workflowTask;
  }
} // end class EnterpriseWorkflowNode
