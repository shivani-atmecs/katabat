package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.cmc.credagility.core.domain.event.Event;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.ozstrategy.credagility.core.domain.EnterpriseHotSpot;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessProcess;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflow;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Created by tangwei on 17/3/6.
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  03/08/2017 11:27
 */
@Entity
@Table(name = "CustomerWorkflow")
public class CustomerWorkflow extends BasicWorkflow implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 7340699447287808902L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */


  /** DOCUMENT ME! */
  @Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
  @JoinTable(
    name               = "CustomerWorkflowAssignAgent",
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
    name               = "CustomerWorkflowAssignRole",
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
  @Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
  @JoinTable(
    name               = "CustomerWorkflowAuditAssignRole",
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
  @ManyToMany(fetch = FetchType.LAZY)
  protected Set<Role> auditAssignRoles = new HashSet<Role>();

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "businessProcessId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowBusinessProcess businessProcess;


  /** TODO: DOCUMENT ME! */
  @Cascade({ org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflow"
  )
  protected Set<CustomerWorkflowAssignedHotSpot> hotSpotSet = new LinkedHashSet<CustomerWorkflowAssignedHotSpot>();


  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** The links belonged to this workflow. */
  @Cascade({ org.hibernate.annotations.CascadeType.DELETE_ORPHAN, org.hibernate.annotations.CascadeType.ALL })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflow"
  )
  protected Set<CustomerWorkflowLink> links = new LinkedHashSet<CustomerWorkflowLink>();

  /** The nodes belonged to this workflow. */
  @Cascade({ org.hibernate.annotations.CascadeType.DELETE_ORPHAN, org.hibernate.annotations.CascadeType.ALL })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflow"
  )
  protected Set<CustomerWorkflowNode> nodes = new LinkedHashSet<CustomerWorkflowNode>();


  /** DOCUMENT ME! */
  @Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
  @JoinTable(
    name               = "CustomerWorkflowResetVariable",
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
  @ManyToMany(fetch = FetchType.LAZY)
  protected Set<BaseVariable> resetVariables = new LinkedHashSet<BaseVariable>();

  /** The workflow schedule which flow belong to. */
  @JoinColumn(
    name       = "scheduleId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowSchedule schedule;

  /** DOCUMENT ME! */
  @Cascade({ org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflow"
  )
  @OrderBy("stepNumber asc")
  protected Set<CustomerWorkflowProgressStep> steps = new LinkedHashSet<CustomerWorkflowProgressStep>();

  /** DOCUMENT ME! */
  @Cascade(value = { org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.REMOVE })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "flow"
  )
  protected Set<CustomerWorkflowVariableAction> variableActions = new LinkedHashSet<CustomerWorkflowVariableAction>();

  @Cascade({ org.hibernate.annotations.CascadeType.DELETE_ORPHAN, org.hibernate.annotations.CascadeType.ALL })
  @OneToOne(mappedBy = "flow")
  private CustomerWorkflowEvent event;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addHotSpot.
   *
   * @param  hotSpot  EnterpriseHotSpot
   */
  public void addHotSpot(EnterpriseHotSpot hotSpot) {
    CustomerWorkflowAssignedHotSpot spotsAssigned = new CustomerWorkflowAssignedHotSpot();
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
   * @param  openInCurrentTab  DOCUMENT ME!
   */
  public void addHotSpot(EnterpriseHotSpot hotSpot, String hotSpotAliasName, Boolean openInCurrentTab) {
    CustomerWorkflowAssignedHotSpot spotsAssigned = new CustomerWorkflowAssignedHotSpot();
    spotsAssigned.setHotSpot(hotSpot);
    spotsAssigned.setWorkflow(this);
    spotsAssigned.setAliasName(hotSpotAliasName);
    spotsAssigned.setOpenInCurrentTab(openInCurrentTab);

    this.hotSpotSet.add(spotsAssigned);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  step  DOCUMENT ME!
   */
  public void addStep(CustomerWorkflowProgressStep step) {
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

    CustomerWorkflow customerWorkflow = (CustomerWorkflow) copyFrom;

    // Copy event
    if (customerWorkflow.getEvent() != null) {
      CustomerWorkflowEvent flowEvent = new CustomerWorkflowEvent();
      flowEvent.setFlow(this);
      flowEvent.setCriteria((customerWorkflow.getEvent() != null) ? customerWorkflow.getEvent().getCriteria() : null);
      flowEvent.setCreator(user);
      flowEvent.setCreateDate(new Date());

      for (Event e : customerWorkflow.getEvent().getEvents()) {
        flowEvent.addEvent(e);
      }

      setEvent(flowEvent);
    }

    for (CustomerWorkflowAssignedHotSpot CustomerWorkflowAssignedHotSpot : customerWorkflow.getHotSpotSet()) {
      addHotSpot(CustomerWorkflowAssignedHotSpot.getHotSpot());
    }

    // Copy variableAction
    for (CustomerWorkflowVariableAction variableAction : customerWorkflow.getVariableActions()) {
      CustomerWorkflowVariableAction action = new CustomerWorkflowVariableAction();
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


  } // end method deepCopy

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
  public CustomerWorkflowEvent getEvent() {
    return event;
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
  public Set<CustomerWorkflowAssignedHotSpot> getHotSpotSet() {
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
  @Override public Set<CustomerWorkflowLink> getLinks() {
    return links;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflow#getNodes()
   */
  @Override public Set<CustomerWorkflowNode> getNodes() {
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
  @Override public CustomerWorkflowSchedule getSchedule() {
    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<CustomerWorkflowProgressStep> getSteps() {
    return steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<CustomerWorkflowVariableAction> getVariableActions() {
    return variableActions;
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
   * removeAssignedAuditRole.
   *
   * @param  role  Role
   */
  public void removeAssignedAuditRole(Role role) {
    if (role != null) {
      this.auditAssignRoles.remove(role);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeAssignedRole.
   *
   * @param  role  Role
   */
  public void removeAssignedRole(Role role) {
    if (role != null) {
      this.assignRoles.remove(role);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  step  DOCUMENT ME!
   */
  public void removeStep(CustomerWorkflowProgressStep step) {
    if (step != null) {
      for (CustomerWorkflowProgressStep progressStep : this.steps) {
//        if (step.getId().equals(progressStep.getId())) {
//          // remove
//          this.steps.remove(progressStep);
//
//          return;
//        }
      }
    }

    return;
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
   * @param  event  DOCUMENT ME!
   */
  public void setEvent(CustomerWorkflowEvent event) {
    this.event = event;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  hotSpotSet  DOCUMENT ME!
   */
  public void setHotSpotSet(Set<CustomerWorkflowAssignedHotSpot> hotSpotSet) {
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
  public void setLinks(Set<CustomerWorkflowLink> links) {
    this.links = links;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  nodes  DOCUMENT ME!
   */

  public void setNodes(Set<CustomerWorkflowNode> nodes) {
    this.nodes = nodes;
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
  public void setSchedule(CustomerWorkflowSchedule schedule) {
    this.schedule = schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  steps  DOCUMENT ME!
   */
  public void setSteps(Set<CustomerWorkflowProgressStep> steps) {
    this.steps = steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variableActions  DOCUMENT ME!
   */
  public void setVariableActions(Set<CustomerWorkflowVariableAction> variableActions) {
    this.variableActions = variableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  step  DOCUMENT ME!
   */
  public void updateStep(CustomerWorkflowProgressStep step) {
    if (step != null) {
      for (CustomerWorkflowProgressStep progressStep : this.steps) {
//        if (step.getId().equals(progressStep.getId())) {
//          // update
//          progressStep.setDescription(step.getDescription());
//          progressStep.setStepNumber(step.getStepNumber());
//
//          return;
//        }
      }
    }

    return;
  }
} // end class CustomerWorkflow
