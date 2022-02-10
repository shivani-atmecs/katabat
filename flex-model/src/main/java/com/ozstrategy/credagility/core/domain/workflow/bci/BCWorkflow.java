package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.cmc.credagility.core.domain.event.Event;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.EnterpriseHotSpot;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessProcess;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeType;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflow;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/31/2014 12:20
 */
@Entity
@Table(name = "BCWorkflow")
public class BCWorkflow extends BasicWorkflow implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5649441522912946252L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** <code>true</code> this workflow is business workflow. */
  @Column(
    name             = "asGather",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean asGather = false;


  /** Many to many with table BCWorkflowAssignAgent. */
  @JoinTable(
    name               = "BCWorkflowAssignAgent",
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

  /** Many to many with table BCWorkflowAssignRole. */
  @JoinTable(
    name               = "BCWorkflowAssignRole",
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

  /** many to many with table BCWorkflowAuditAssignRole. */
  @JoinTable(
    name               = "BCWorkflowAuditAssignRole",
    indexes            = { @Index(columnList = "flowId") },
    joinColumns        = {
      @JoinColumn(
        name           = "flowId",
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
  protected Set<Role> auditAssignRoles = new HashSet<Role>();

  /** WorkflowBusinessProcess PK businessProcessId. */
  @JoinColumn(
    name       = "businessProcessId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowBusinessProcess businessProcess;

  /** BCWorkflowChannelAction PK flow. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "flow",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<BCWorkflowChannelAction> channelActions = new LinkedHashSet<BCWorkflowChannelAction>();

  /** BCWorkflowFlowAction PK flow. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "flow",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<BCWorkflowFlowAction> flowActions = new LinkedHashSet<BCWorkflowFlowAction>();

  /** BCWorkflowAssignedHotSpot PK workflow. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflow",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<BCWorkflowAssignedHotSpot> hotSpotSet = new LinkedHashSet<BCWorkflowAssignedHotSpot>();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** The links belonged to this workflow. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflow",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<BCWorkflowLink> links = new LinkedHashSet<BCWorkflowLink>();

  /** The nodes belonged to this workflow. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflow",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<BCWorkflowNode> nodes = new LinkedHashSet<BCWorkflowNode>();

  /** BCWorkflowQueueAction PK flow. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "flow",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<BCWorkflowQueueAction> queueActions = new LinkedHashSet<BCWorkflowQueueAction>();

  /** Many to many with table BCWorkflowResetVariable. */
  @JoinTable(
    name               = "BCWorkflowResetVariable",
    indexes            = { @Index(columnList = "flowId") },
    joinColumns        = {
      @JoinColumn(
        name           = "flowId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "variableId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected Set<BaseVariable> resetVariables = new LinkedHashSet<BaseVariable>();

  /** The workflow schedule which flow belong to. */
  @JoinColumn(
    name       = "scheduleId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowSchedule schedule;

  /** BCWorkflowProgressStep PK workflow. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflow",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  @OrderBy("stepNumber asc")
  protected Set<BCWorkflowProgressStep> steps = new LinkedHashSet<BCWorkflowProgressStep>();

  /** BCWorkflowUpdateVariableAction PK flow. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "flow",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<BCWorkflowUpdateVariableAction> updateVariableActions =
    new LinkedHashSet<BCWorkflowUpdateVariableAction>();

  /** BCWorkflowVariableAction PK flow. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "flow",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<BCWorkflowVariableAction> variableActions = new LinkedHashSet<BCWorkflowVariableAction>();

  /** BCWorkflowEvent PK workflow. */
  @OneToOne(
    mappedBy = "workflow",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  private BCWorkflowEvent event;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  hotSpot  DOCUMENT ME!
   */
  public void addHotSpot(EnterpriseHotSpot hotSpot) {
    BCWorkflowAssignedHotSpot spotsAssigned = new BCWorkflowAssignedHotSpot();
    spotsAssigned.setHotSpot(hotSpot);
    spotsAssigned.setWorkflow(this);
    this.hotSpotSet.add(spotsAssigned);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  hotSpot           DOCUMENT ME!
   * @param  hotSpotAliasName  DOCUMENT ME!
   */
  public void addHotSpot(EnterpriseHotSpot hotSpot, String hotSpotAliasName) {
    BCWorkflowAssignedHotSpot spotsAssigned = new BCWorkflowAssignedHotSpot();
    spotsAssigned.setHotSpot(hotSpot);
    spotsAssigned.setWorkflow(this);
    spotsAssigned.setAliasName(hotSpotAliasName);
    this.hotSpotSet.add(spotsAssigned);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  step  DOCUMENT ME!
   */
  public void addStep(BCWorkflowProgressStep step) {
    if (step != null) {
      this.steps.add(step);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflow#deepCopy(com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflow,
   *       com.cmc.credagility.core.domain.user.User)
   */
  @Override public void deepCopy(BasicWorkflow copyFrom, User user) {
    copy(copyFrom, user);

    BCWorkflow bcWorkflow = (BCWorkflow) copyFrom;

    // Copy event
    if (bcWorkflow.getEvent() != null) {
      BCWorkflowEvent flowEvent = new BCWorkflowEvent();
      flowEvent.setWorkflow(this);
      flowEvent.setCriteria((bcWorkflow.getEvent() != null) ? bcWorkflow.getEvent().getCriteria() : null);
      flowEvent.setCreator(user);
      flowEvent.setCreateDate(new Date());

      for (Event e : bcWorkflow.getEvent().getEvents()) {
        flowEvent.addEvent(e);
      }

      setEvent(flowEvent);
    }

    for (BCWorkflowUpdateVariableAction updateVariableAction : bcWorkflow.getUpdateVariableActions()) {
      BCWorkflowUpdateVariableAction action = new BCWorkflowUpdateVariableAction();
      action.setCriteria(updateVariableAction.getCriteria());
      action.setCreator(updateVariableAction.getCreator());
      action.setFlow(this);
      action.setPriority(updateVariableAction.getPriority());
      action.setTriggerType(updateVariableAction.getTriggerType());
      action.setValue(updateVariableAction.getValue());
      action.setVariable(updateVariableAction.getVariable());
      action.setLastUpdater(updateVariableAction.getLastUpdater());
      this.updateVariableActions.add(action);
    }

    // Copy variableAction
    for (BCWorkflowVariableAction variableAction : bcWorkflow.getVariableActions()) {
      BCWorkflowVariableAction action = new BCWorkflowVariableAction();
      action.setCriteria(variableAction.getCriteria());
      action.setCreator(variableAction.getCreator());
      action.setFlow(this);
      action.setPriority(variableAction.getPriority());
      action.setTriggerType(variableAction.getTriggerType());
      action.setValue(variableAction.getValue());
      action.setVariable(variableAction.getVariable());
      action.setLastUpdater(variableAction.getLastUpdater());
      this.variableActions.add(action);
    }

    // Copy flow actions
    for (BCWorkflowFlowAction action : bcWorkflow.getFlowActions()) {
      BCWorkflowFlowAction act = new BCWorkflowFlowAction();
      act.deepCopy(action);
      act.setFlow(this);
      act.setCreator(copyFrom.getCreator());
      act.setCreateDate(copyFrom.getCreateDate());
      this.flowActions.add(act);
    }

    // copy flow channelaction
    for (BCWorkflowChannelAction channelAction : bcWorkflow.getChannelActions()) {
      BCWorkflowChannelAction action = new BCWorkflowChannelAction();

      action.deepCopy(channelAction);
      action.setFlow(this);
      action.setCreator(copyFrom.getCreator());
      action.setCreateDate(copyFrom.getCreateDate());
      this.channelActions.add(action);
    }
  } // end method deepCopy

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAsGather() {
    if (asGather == null) {
      return Boolean.FALSE;
    }

    return asGather;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflow#getAssignAgents()
   */
  @Override public Set<User> getAssignAgents() {
    return assignAgents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */


  @Override public Set<Role> getAssignRoles() {
    return assignRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflow#getAuditAssignRoles()
   */
  @Override public Set<Role> getAuditAssignRoles() {
    return auditAssignRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public WorkflowBusinessProcess getBusinessProcess() {
    return businessProcess;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCWorkflowChannelAction> getChannelActions() {
    return channelActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowEvent getEvent() {
    return event;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCWorkflowFlowAction> getFlowActions() {
    return flowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getHasEvent() {
    if ((event != null) && (event.getId() != null) && (event.getId().longValue() != 0L)) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCWorkflowAssignedHotSpot> getHotSpotSet() {
    return hotSpotSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflow#getLinks()
   */
  @Override public Set<BCWorkflowLink> getLinks() {
    return links;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflow#getNodes()
   */
  @Override public Set<BCWorkflowNode> getNodes() {
    return nodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCWorkflowQueueAction> getQueueActions() {
    return queueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflow#getResetVariables()
   */
  @Override public Set<BaseVariable> getResetVariables() {
    return resetVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflow#getSchedule()
   */
  @Override public BCWorkflowSchedule getSchedule() {
    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCWorkflowProgressStep> getSteps() {
    return steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCWorkflowUpdateVariableAction> getUpdateVariableActions() {
    return updateVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCWorkflowVariableAction> getVariableActions() {
    return variableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  dOCUMENT ME!
   */
  public boolean hasGatherTask() {
    boolean hasGatherTask = Boolean.FALSE;

    for (BCWorkflowNode node : nodes) {
      if (WorkflowNodeType.SURVEY_NODE.equals(node.getType()) && node.getWorkflowTask().getAsGather()) {
        hasGatherTask = Boolean.TRUE;

        break;
      }
    }

    return hasGatherTask;
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
   * DOCUMENT ME!
   */
  public void removeAllAuditAssignRoles() {
    if ((this.auditAssignRoles != null) && (this.auditAssignRoles.size() > 0)) {
      this.auditAssignRoles.clear();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  step  DOCUMENT ME!
   */
  public void removeStep(BCWorkflowProgressStep step) {
    if (step != null) {
      for (BCWorkflowProgressStep progressStep : this.steps) {
        if (step.getId().equals(progressStep.getId())) {
          // remove
          this.steps.remove(progressStep);

          return;
        }
      }
    }

    return;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  asGather  DOCUMENT ME!
   */
  public void setAsGather(Boolean asGather) {
    this.asGather = asGather;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  assignAgents  DOCUMENT ME!
   */
  public void setAssignAgents(Set<User> assignAgents) {
    this.assignAgents = assignAgents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  assignRoles  DOCUMENT ME!
   */
  public void setAssignRoles(Set<Role> assignRoles) {
    this.assignRoles = assignRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  auditAssignRoles  DOCUMENT ME!
   */
  public void setAuditAssignRoles(Set<Role> auditAssignRoles) {
    this.auditAssignRoles = auditAssignRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  businessProcess  DOCUMENT ME!
   */
  public void setBusinessProcess(WorkflowBusinessProcess businessProcess) {
    this.businessProcess = businessProcess;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  channelActions  DOCUMENT ME!
   */
  public void setChannelActions(Set<BCWorkflowChannelAction> channelActions) {
    this.channelActions = channelActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  event  DOCUMENT ME!
   */
  public void setEvent(BCWorkflowEvent event) {
    this.event = event;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  flowActions  DOCUMENT ME!
   */
  public void setFlowActions(Set<BCWorkflowFlowAction> flowActions) {
    this.flowActions = flowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  hotSpotSet  DOCUMENT ME!
   */
  public void setHotSpotSet(Set<BCWorkflowAssignedHotSpot> hotSpotSet) {
    this.hotSpotSet = hotSpotSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  @Override public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  links  DOCUMENT ME!
   */
  public void setLinks(Set<BCWorkflowLink> links) {
    this.links = links;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  nodes  DOCUMENT ME!
   */

  public void setNodes(Set<BCWorkflowNode> nodes) {
    this.nodes = nodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  queueActions  DOCUMENT ME!
   */
  public void setQueueActions(Set<BCWorkflowQueueAction> queueActions) {
    this.queueActions = queueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  resetVariables  DOCUMENT ME!
   */
  public void setResetVariables(Set<BaseVariable> resetVariables) {
    this.resetVariables = resetVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  schedule  DOCUMENT ME!
   */
  public void setSchedule(BCWorkflowSchedule schedule) {
    this.schedule = schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  steps  DOCUMENT ME!
   */
  public void setSteps(Set<BCWorkflowProgressStep> steps) {
    this.steps = steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  updateVariableActions  DOCUMENT ME!
   */
  public void setUpdateVariableActions(Set<BCWorkflowUpdateVariableAction> updateVariableActions) {
    this.updateVariableActions = updateVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variableActions  DOCUMENT ME!
   */
  public void setVariableActions(Set<BCWorkflowVariableAction> variableActions) {
    this.variableActions = variableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  step  DOCUMENT ME!
   */
  public void updateStep(BCWorkflowProgressStep step) {
    if (step != null) {
      for (BCWorkflowProgressStep progressStep : this.steps) {
        if (step.getId().equals(progressStep.getId())) {
          // update
          progressStep.setDescription(step.getDescription());
          progressStep.setStepNumber(step.getStepNumber());

          return;
        }
      }
    }

    return;
  }
} // end class BCWorkflow
