package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.ozstrategy.credagility.core.domain.EnterpriseHotSpot;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessProcess;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflow;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/17/2014 11:28
 */
@Entity
@Table(name = "EnterpriseWorkflow")
public class EnterpriseWorkflow extends BasicWorkflow<EnterpriseWorkflow> implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -167872600069350809L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "WorkflowAssignAgent",
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
    name               = "WorkflowAssignRole",
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
  @JoinTable(
    name               = "WorkflowAuditAssignRole",
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


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "businessProcessId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowBusinessProcess businessProcess;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "flow",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  protected Set<EnterpriseWorkflowFlowAction> flowActions = new LinkedHashSet<EnterpriseWorkflowFlowAction>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "workflow",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  protected Set<EnterpriseWorkflowAssignedHotSpot> hotSpotSet = new LinkedHashSet<EnterpriseWorkflowAssignedHotSpot>();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** The links belonged to this workflow. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "workflow",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  protected Set<EnterpriseWorkflowLink> links = new LinkedHashSet<EnterpriseWorkflowLink>();

  /** The nodes belonged to this workflow. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "workflow",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  protected Set<EnterpriseWorkflowNode> nodes = new LinkedHashSet<EnterpriseWorkflowNode>();


  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "WorkflowResetVariable",
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
  protected WorkflowSchedule schedule;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "workflow",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("stepNumber asc")
  protected Set<EnterpriseWorkflowProgressStep> steps = new LinkedHashSet<EnterpriseWorkflowProgressStep>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "flow",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  protected Set<EnterpriseWorkflowUpdateVariableAction> updateVariableActions =
    new LinkedHashSet<EnterpriseWorkflowUpdateVariableAction>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "flow",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  protected Set<EnterpriseWorkflowVariableAction> variableActions =
    new LinkedHashSet<EnterpriseWorkflowVariableAction>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addHotSpot.
   *
   * @param  hotSpot  $param.type$
   */
  public void addHotSpot(EnterpriseHotSpot hotSpot) {
    EnterpriseWorkflowAssignedHotSpot spotsAssigned = new EnterpriseWorkflowAssignedHotSpot();
    spotsAssigned.setHotSpot(hotSpot);
    spotsAssigned.setWorkflow(this);
    this.hotSpotSet.add(spotsAssigned);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addHotSpot.
   *
   * @param  hotSpot           $param.type$
   * @param  hotSpotAliasName  $param.type$
   */
  public void addHotSpot(EnterpriseHotSpot hotSpot, String hotSpotAliasName) {
    EnterpriseWorkflowAssignedHotSpot spotsAssigned = new EnterpriseWorkflowAssignedHotSpot();
    spotsAssigned.setHotSpot(hotSpot);
    spotsAssigned.setWorkflow(this);
    spotsAssigned.setAliasName(hotSpotAliasName);
    this.hotSpotSet.add(spotsAssigned);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addStep.
   *
   * @param  step  $param.type$
   */
  public void addStep(EnterpriseWorkflowProgressStep step) {
    if (step != null) {
      this.steps.add(step);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  $param.type$
   * @param  user      $param.type$
   */
  @Override public void deepCopy(EnterpriseWorkflow copyFrom, User user) {
    copy(copyFrom, user);
    setBusinessProcess(copyFrom.getBusinessProcess());

    // Copy flow updateVariableAction
    for (EnterpriseWorkflowUpdateVariableAction updateVariableAction : copyFrom.getUpdateVariableActions()) {
      EnterpriseWorkflowUpdateVariableAction action = new EnterpriseWorkflowUpdateVariableAction();
      action.setCriteria(updateVariableAction.getCriteria());
      action.setCreator(updateVariableAction.getCreator());
      action.setFlow(this);
      action.setPriority(updateVariableAction.getPriority());
      action.setTriggerTime(updateVariableAction.getTriggerTime());
      action.setValue(updateVariableAction.getValue());
      action.setVariable(updateVariableAction.getVariable());
      action.setLastUpdater(updateVariableAction.getLastUpdater());
      this.updateVariableActions.add(action);
    }

    // Copy variableAction
    for (EnterpriseWorkflowVariableAction variableAction : copyFrom.getVariableActions()) {
      EnterpriseWorkflowVariableAction action = new EnterpriseWorkflowVariableAction();
      action.setCriteria(variableAction.getCriteria());
      action.setCreator(variableAction.getCreator());
      action.setFlow(this);
      action.setPriority(variableAction.getPriority());
      action.setTriggerTime(variableAction.getTriggerTime());
      action.setValue(variableAction.getValue());
      action.setVariable(variableAction.getVariable());
      action.setLastUpdater(variableAction.getLastUpdater());
      this.variableActions.add(action);
    }

    // Copy flow actions
    for (EnterpriseWorkflowFlowAction action : copyFrom.getFlowActions()) {
      EnterpriseWorkflowFlowAction act = new EnterpriseWorkflowFlowAction();
      act.deepCopy(action);
      act.setFlow(this);
      act.setCreator(copyFrom.getCreator());
      act.setCreateDate(copyFrom.getCreateDate());
      this.flowActions.add(act);
    }
  } // end method deepCopy

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
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

    EnterpriseWorkflow that = (EnterpriseWorkflow) o;

    if (!schedule.equals(that.schedule)) {
      return false;
    }

    return true;
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflow#getAssignRoles()
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
   * WorkflowBusinessProcess.
   *
   * @return  WorkflowBusinessProcess.
   */
  public WorkflowBusinessProcess getBusinessProcess() {
    return businessProcess;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set.
   *
   * @return  Set.
   */
  public Set<EnterpriseWorkflowFlowAction> getFlowActions() {
    return flowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set.
   *
   * @return  Set.
   */
  public Set<EnterpriseWorkflowAssignedHotSpot> getHotSpotSet() {
    return hotSpotSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  @Override public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflow#getLinks()
   */
  @Override public Set<EnterpriseWorkflowLink> getLinks() {
    return links;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflow#getNodes()
   */
  @Override public Set<EnterpriseWorkflowNode> getNodes() {
    return nodes;
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
  @Override public WorkflowSchedule getSchedule() {
    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set.
   *
   * @return  Set.
   */
  public Set<EnterpriseWorkflowProgressStep> getSteps() {
    return steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set.
   *
   * @return  Set.
   */
  public Set<EnterpriseWorkflowUpdateVariableAction> getUpdateVariableActions() {
    return updateVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set.
   *
   * @return  Set.
   */
  public Set<EnterpriseWorkflowVariableAction> getVariableActions() {
    return variableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + (((schedule != null) && (schedule.getId() != null)) ? schedule.getId().hashCode() : 0);

    return result;
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
   * removeAllAuditAssignRoles.
   */
  public void removeAllAuditAssignRoles() {
    if ((this.auditAssignRoles != null) && (this.auditAssignRoles.size() > 0)) {
      this.auditAssignRoles.clear();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeAssignedRole.
   *
   * @param  role  $param.type$
   */
  public void removeAssignedRole(Role role) {
    if (null != role) {
      this.assignRoles.remove(role);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeStep.
   *
   * @param  step  $param.type$
   */
  public void removeStep(EnterpriseWorkflowProgressStep step) {
    if (step != null) {
      for (EnterpriseWorkflowProgressStep progressStep : this.steps) {
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
   * setAssignAgents.
   *
   * @param  assignAgents  $param.type$
   */
  public void setAssignAgents(Set<User> assignAgents) {
    this.assignAgents = assignAgents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAssignRoles.
   *
   * @param  assignRoles  $param.type$
   */
  public void setAssignRoles(Set<Role> assignRoles) {
    this.assignRoles = assignRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAuditAssignRoles.
   *
   * @param  auditAssignRoles  $param.type$
   */
  public void setAuditAssignRoles(Set<Role> auditAssignRoles) {
    this.auditAssignRoles = auditAssignRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setBusinessProcess.
   *
   * @param  businessProcess  $param.type$
   */
  public void setBusinessProcess(WorkflowBusinessProcess businessProcess) {
    this.businessProcess = businessProcess;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setFlowActions.
   *
   * @param  flowActions  $param.type$
   */
  public void setFlowActions(Set<EnterpriseWorkflowFlowAction> flowActions) {
    this.flowActions = flowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setHotSpotSet.
   *
   * @param  hotSpotSet  $param.type$
   */
  public void setHotSpotSet(Set<EnterpriseWorkflowAssignedHotSpot> hotSpotSet) {
    this.hotSpotSet = hotSpotSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setId.
   *
   * @param  id  $param.type$
   */
  @Override public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setLinks.
   *
   * @param  links  $param.type$
   */
  public void setLinks(Set<EnterpriseWorkflowLink> links) {
    this.links = links;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setNodes.
   *
   * @param  nodes  $param.type$
   */
  public void setNodes(Set<EnterpriseWorkflowNode> nodes) {
    this.nodes = nodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setResetVariables.
   *
   * @param  resetVariables  $param.type$
   */
  public void setResetVariables(Set<BaseVariable> resetVariables) {
    this.resetVariables = resetVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setSchedule.
   *
   * @param  schedule  $param.type$
   */
  public void setSchedule(WorkflowSchedule schedule) {
    this.schedule = schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setSteps.
   *
   * @param  steps  $param.type$
   */
  public void setSteps(Set<EnterpriseWorkflowProgressStep> steps) {
    this.steps = steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setUpdateVariableActions.
   *
   * @param  updateVariableActions  $param.type$
   */
  public void setUpdateVariableActions(Set<EnterpriseWorkflowUpdateVariableAction> updateVariableActions) {
    this.updateVariableActions = updateVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setVariableActions.
   *
   * @param  variableActions  $param.type$
   */
  public void setVariableActions(Set<EnterpriseWorkflowVariableAction> variableActions) {
    this.variableActions = variableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateStep.
   *
   * @param  step  $param.type$
   */
  public void updateStep(EnterpriseWorkflowProgressStep step) {
    if (step != null) {
      for (EnterpriseWorkflowProgressStep progressStep : this.steps) {
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
} // end class EnterpriseWorkflow
