package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeType;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowNode;
import org.hibernate.annotations.Cascade;
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
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  03/08/2017 14:48
 */
@Entity
@Table(name = "CustomerWorkflowNode")
public class CustomerWorkflowNode extends BasicWorkflowNode implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 6028703755822900590L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @Cascade(value = { org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.REMOVE })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "node"
  )
  protected Set<CustomerWorkflowNodeAccountSelectorAction> accountSelectorActions =
    new LinkedHashSet<CustomerWorkflowNodeAccountSelectorAction>();

  /** DOCUMENT ME! */
  @Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
  @JoinTable(
    name               = "CustomerWorkflowNodeAssignAgent",
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
  @ManyToMany(fetch = FetchType.LAZY)
  protected Set<User> assignAgents = new HashSet<User>();

  /** DOCUMENT ME! */
  @Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
  @JoinTable(
    name               = "CustomerWorkflowNodeAssignRole",
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
  @ManyToMany(fetch = FetchType.LAZY)
  protected Set<Role> assignRoles = new HashSet<Role>();


  /** DOCUMENT ME! */
  @Cascade(value = { org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.REMOVE })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "node"
  )
  @Where(clause = "triggerType = 'DAILY'")
  protected Set<CustomerWorkflowNodeVariableAction> dailyVariableActions =
    new LinkedHashSet<CustomerWorkflowNodeVariableAction>();

  /** TODO: DOCUMENT ME! */
  @Cascade(value = { org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.REMOVE })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "node"
  )
  protected Set<CustomerWorkflowNodeEventAction> eventActions = new LinkedHashSet<CustomerWorkflowNodeEventAction>();

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
  protected Set<CustomerWorkflowLink> inSet = new LinkedHashSet<CustomerWorkflowLink>();

  /** DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "from"
  )
  @OrderBy("priority asc")
  protected Set<CustomerWorkflowLink> outSet = new LinkedHashSet<CustomerWorkflowLink>();


  /** DOCUMENT ME! */
  @JoinColumn(name = "progressStepId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowProgressStep progressStep;


  /** Sub flow. */
  @JoinColumn(
    name       = "subFlowId",
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflow subFlow;

  /** DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "from"
  )
  @OrderBy("priority asc")
  @Where(clause = "drivenType = 'BATCH'")
  protected Set<CustomerWorkflowLink> systemOutputLinks = new LinkedHashSet<CustomerWorkflowLink>();


  /** DOCUMENT ME! */
  @Cascade(value = { org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.REMOVE })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "node"
  )
  protected Set<CustomerWorkflowNodeVariableAction> variableActions =
    new LinkedHashSet<CustomerWorkflowNodeVariableAction>();

  /** The workflow this node belonged to. */
  @JoinColumn(
    name       = "workflowId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflow workflow;

  /** WorkflowTask. */
  @JoinColumn(
    name       = "workflowTaskId",
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTask workflowTask;

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
   * @param  copyFrom  DOCUMENT ME!
   */
  public void deepCopy(CustomerWorkflowNode copyFrom) {
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

    // Copy variableAction
    for (CustomerWorkflowNodeVariableAction variableAction : copyFrom.getVariableActions()) {
      CustomerWorkflowNodeVariableAction action = new CustomerWorkflowNodeVariableAction();
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

    // Copy variableAction
    for (CustomerWorkflowNodeAccountSelectorAction accountSelectorAction : copyFrom.getAccountSelectorActions()) {
      CustomerWorkflowNodeAccountSelectorAction action = new CustomerWorkflowNodeAccountSelectorAction();
      action.setCriteria(accountSelectorAction.getCriteria());
      action.setCreator(accountSelectorAction.getCreator());
      action.setNode(this);
      action.setPriority(accountSelectorAction.getPriority());
      action.setTriggerType(accountSelectorAction.getTriggerType());
      action.setAccountExportLayout(accountSelectorAction.getAccountExportLayout());
      action.setLastUpdater(accountSelectorAction.getLastUpdater());
      this.accountSelectorActions.add(action);
    }

    // Copy eventAction
    for (CustomerWorkflowNodeEventAction eventAction : copyFrom.getEventActions()) {
      CustomerWorkflowNodeEventAction action = new CustomerWorkflowNodeEventAction();
      action.setCriteria(eventAction.getCriteria());
      action.setCreator(eventAction.getCreator());
      action.setNode(this);
      action.setEvent(eventAction.getEvent());
      action.setPriority(eventAction.getPriority());
      action.setTriggerType(eventAction.getTriggerType());
      action.setLastUpdater(eventAction.getLastUpdater());
      action.setSynchronous(eventAction.getSynchronous());
      this.eventActions.add(action);
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

    CustomerWorkflowNode that = (CustomerWorkflowNode) o;

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
   * getter method for account selector actions.
   *
   * @return  Set
   */
  public Set<CustomerWorkflowNodeAccountSelectorAction> getAccountSelectorActions() {
    return accountSelectorActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
  public Set<CustomerWorkflowNodeVariableAction> getDailyVariableActions() {
    return dailyVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event actions.
   *
   * @return  Set
   */
  public Set<CustomerWorkflowNodeEventAction> getEventActions() {
    return eventActions;
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
  @Override public Set<CustomerWorkflowLink> getInSet() {
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
  @Override public Set<CustomerWorkflowLink> getOutSet() {
    return outSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowProgressStep getProgressStep() {
    return progressStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflow getSubFlow() {
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
  @Override public Set<CustomerWorkflowLink> getSystemOutputLinks() {
    return systemOutputLinks;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<CustomerWorkflowNodeVariableAction> getVariableActions() {
    return variableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowNode#getWorkflow()
   */
  @Override public CustomerWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTask getWorkflowTask() {
    return workflowTask;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowNode#hashCode()
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
   * getter method for end node.
   *
   * @return  boolean
   */
  public boolean isEndNode() {
    if (workflowTask != null) {
      return workflowTask.getEndFlow();
    }

    return false;
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
   * getter method for root node.
   *
   * @return  boolean
   */
  public boolean isRootNode() {
    return WorkflowNodeType.ROOT_NODE.name().equals(this.type.name());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sub flow.
   *
   * @return  boolean
   */
  public boolean isSubFlow() {
    return this.subFlow != null;
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
   * setter method for account selector actions.
   *
   * @param  accountSelectorActions  Set
   */
  public void setAccountSelectorActions(Set<CustomerWorkflowNodeAccountSelectorAction> accountSelectorActions) {
    this.accountSelectorActions = accountSelectorActions;
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
   * @param  dailyVariableActions  DOCUMENT ME!
   */
  public void setDailyVariableActions(Set<CustomerWorkflowNodeVariableAction> dailyVariableActions) {
    this.dailyVariableActions = dailyVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event actions.
   *
   * @param  eventActions  Set
   */
  public void setEventActions(Set<CustomerWorkflowNodeEventAction> eventActions) {
    this.eventActions = eventActions;
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
  public void setInSet(Set<CustomerWorkflowLink> inSet) {
    this.inSet = inSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  outSet  DOCUMENT ME!
   */
  public void setOutSet(Set<CustomerWorkflowLink> outSet) {
    this.outSet = outSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  progressStep  DOCUMENT ME!
   */
  public void setProgressStep(CustomerWorkflowProgressStep progressStep) {
    this.progressStep = progressStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  subFlow  DOCUMENT ME!
   */
  public void setSubFlow(CustomerWorkflow subFlow) {
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
  public void setSystemOutputLinks(Set<CustomerWorkflowLink> systemOutputLinks) {
    this.systemOutputLinks = systemOutputLinks;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variableActions  DOCUMENT ME!
   */
  public void setVariableActions(Set<CustomerWorkflowNodeVariableAction> variableActions) {
    this.variableActions = variableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflow  DOCUMENT ME!
   */
  public void setWorkflow(CustomerWorkflow workflow) {
    this.workflow = workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowTask  DOCUMENT ME!
   */
  public void setWorkflowTask(CustomerWorkflowTask workflowTask) {
    this.workflowTask = workflowTask;
  }
} // end class CustomerWorkflowNode
