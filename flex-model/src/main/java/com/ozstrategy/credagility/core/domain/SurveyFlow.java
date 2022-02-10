package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.event.Event;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.domain.variable.BaseVariable;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.sor.SurveyFlowTransactionAction;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessProcess;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * workflow for responsible.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 09:38
 */
@Entity public class SurveyFlow extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3890117652366012167L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** flow is allow SPOC. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowSPOC;


  /** allow use on Web flexsite. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowWeb;


  /** current flow whether or not subflow. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean asSubFlow = false;


  /** Audit result by Criteria. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String auditPassCriteria;


  /** Workflow Business Process. */
  @JoinColumn(
    name       = "businessProcessId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowBusinessProcess businessProcess;

  /** Criteria for enter this survey. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String criteria;


  /** Map to hotSpots. */
  @Transient protected Collection<Long> hotSpots;


  /** map to SurveyFlowHotSpots Assignment. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "surveyFlow",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<SurveyFlowHotSpotsAssignment> hotSpotSet = new HashSet<SurveyFlowHotSpotsAssignment>();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Survey Template Instance Mapping. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "surveyFlow",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<SurveyFlowLink> links = new LinkedHashSet<SurveyFlowLink>();


  /** Flow's name. */
  @Column(
    length   = 256,
    nullable = false
  )
  protected String name;


  /** who can start this flow. */
  @JoinTable(
    name               = "SurveyFlowAssignAgent",
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
    cascade = { CascadeType.PERSIST, CascadeType.MERGE }
  )
  protected Set<User> assignAgents = new HashSet<User>();


  /** the role who can start this flow. */
  @JoinTable(
    name               = "SurveyFlowAssignRole",
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
    cascade = { CascadeType.PERSIST, CascadeType.MERGE }
  )
  protected Set<Role> assignRoles = new HashSet<Role>();


  /** the role who can audit this flow. */
  @JoinTable(
    name               = "SurveyFlowAuditAssignRole",
    indexes            = { @Index(columnList = "surveyFlowId") },
    joinColumns        = {
      @JoinColumn(
        name           = "surveyFlowId",
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
    cascade = { CascadeType.PERSIST, CascadeType.MERGE }
  )
  protected Set<Role> auditAssignRoles = new HashSet<Role>();


  /** ChannelActions assign to this flow. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "flow",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<SurveyFlowChannelAction> channelActions = new LinkedHashSet<SurveyFlowChannelAction>();


  /** FlowActions assign to this flow. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "flow",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected Set<SurveyFlowFlowAction> flowActions = new LinkedHashSet<SurveyFlowFlowAction>();

  /** Survey Template Instance. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "surveyFlow",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<SurveyFlowNode> nodes = new LinkedHashSet<SurveyFlowNode>();


  /** priority ,maybe use for the data order. */
  @Column protected Integer priority;


  /** programActions assign to this flow. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "flow",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected Set<SurveyFlowProgramAction> programActions = new LinkedHashSet<SurveyFlowProgramAction>();


  /** reQueueActions assign to this flow. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "flow",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected Set<SurveyFlowReQueueAction> reQueueActions = new LinkedHashSet<SurveyFlowReQueueAction>();


  /** SurveyFlowResetVariable assign to this flow. */
  @JoinTable(
    name               = "SurveyFlowResetVariable",
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
    cascade = { CascadeType.PERSIST, CascadeType.MERGE }
  )
  protected Set<BaseVariable> resetVariables = new LinkedHashSet<BaseVariable>();

  /** The survey schedule which flow belong to. */
  @JoinColumn(
    name       = "scheduleId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveySchedule schedule;


  /** is show step in flex site. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean showStepInSite = false;


  /** statusAction assign to this flow. */
  @OneToOne(
    mappedBy      = "flow",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected SurveyFlowStatusAction statusAction;


  /** the flow task run will create step,flow map to step. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "surveyFlow",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  @OrderBy("stepNumber asc")
  protected Set<SurveyFlowProgressStep> steps = new HashSet<SurveyFlowProgressStep>();


  /** flow 's nodes. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "surveyFlow"
  )
  @Where(clause = "type = 'SUB_FLOW_NODE'")
  protected Set<SurveyFlowNode> subFlowNodes = new LinkedHashSet<SurveyFlowNode>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "flow",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected Set<SurveyFlowTransactionAction> transactionActions = new LinkedHashSet<SurveyFlowTransactionAction>();


  /** updateVariableActions assign to this flow. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "flow",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected Set<SurveyFlowUpdateVariableAction> updateVariableActions =
    new LinkedHashSet<SurveyFlowUpdateVariableAction>();


  /** variableActions assign to this flow. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "flow",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  protected Set<SurveyFlowVariableAction> variableActions = new LinkedHashSet<SurveyFlowVariableAction>();


  @Column(nullable = true)
  private Long copyFromId;

  @Column(columnDefinition = "LONGTEXT")
  @Lob private String customerTitle;

  @OneToOne(
    mappedBy      = "flow",
    orphanRemoval = true,
    cascade       = CascadeType.ALL
  )
  private SurveyFlowEvent event;

  @Column private Integer flowFrequency;

  @Column private Long frequencyMinutes;

  @Column(length = 30)
  private String persistenceCode;

  @Column(
    length   = 50,
    nullable = true
  )
  private String tag;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  user  DOCUMENT ME!
   */
  public void addAssignAgent(User user) {
    if (null != user) {
      if (this.assignAgents == null) {
        this.assignAgents = new LinkedHashSet<>();
      }

      if (!this.assignAgents.contains(user)) {
        this.assignAgents.add(user);
      }
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
      if (this.assignRoles == null) {
        this.assignRoles = new LinkedHashSet<>();
      }

      if (!this.assignRoles.contains(role)) {
        this.assignRoles.add(role);
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  role  DOCUMENT ME!
   */
  public void addAuditAssignRole(Role role) {
    if (null != role) {
      if ((null != this.auditAssignRoles) && (this.auditAssignRoles.size() > 0)
            && !this.auditAssignRoles.contains(role)) {
        this.auditAssignRoles.add(role);
      } else {
        this.auditAssignRoles.add(role);
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  hotSpot  DOCUMENT ME!
   */
  public void addHotSpot(HotSpot hotSpot) {
    SurveyFlowHotSpotsAssignment spotsAssigned = new SurveyFlowHotSpotsAssignment();
    spotsAssigned.setHotSpot(hotSpot);
    spotsAssigned.setSurveyFlow(this);
    this.hotSpotSet.add(spotsAssigned);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  hotSpot            DOCUMENT ME!
   * @param  hostSpotAliasName  DOCUMENT ME!
   * @param  openInCurrentTab   Boolean
   */
  public void addHotSpot(HotSpot hotSpot, String hostSpotAliasName, Boolean openInCurrentTab) {
    SurveyFlowHotSpotsAssignment spotsAssigned = new SurveyFlowHotSpotsAssignment();
    spotsAssigned.setHotSpot(hotSpot);
    spotsAssigned.setSurveyFlow(this);
    spotsAssigned.setHotSpotAliasName(hostSpotAliasName);
    spotsAssigned.setOpenInCurrentTab(openInCurrentTab);
    this.hotSpotSet.add(spotsAssigned);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  step  DOCUMENT ME!
   */
  public void addStep(SurveyFlowProgressStep step) {
    if (step != null) {
      this.steps.add(step);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  copyFrom  DOCUMENT ME!
   * @param  user      DOCUMENT ME!
   */
  public void deepCopy(SurveyFlow copyFrom, User user) {
    setName(copyFrom.getName());
    setCopyFromId(copyFrom.getId());
    setPriority(copyFrom.getPriority());
    setCriteria(copyFrom.getCriteria());
    setAsSubFlow(copyFrom.getAsSubFlow());
    setShowStepInSite(copyFrom.getShowStepInSite());
    setFlowFrequency(copyFrom.getFlowFrequency());
    setFrequencyMinutes(copyFrom.getFrequencyMinutes());
    setAllowSPOC(copyFrom.getAllowSPOC());
    setAllowWeb(copyFrom.getAllowWeb());
    setCustomerTitle(copyFrom.getCustomerTitle());
    setTag(copyFrom.getTag());
    setBusinessProcess(copyFrom.getBusinessProcess());

    for (SurveyFlowHotSpotsAssignment hotSpotsAssignment : copyFrom.getHotSpotSet()) {
      addHotSpot(hotSpotsAssignment.getHotSpot(), hotSpotsAssignment.getHotSpotAliasName(),
        hotSpotsAssignment.getOpenInCurrentTab());
    }

    for (BaseVariable variable : copyFrom.getResetVariables()) {
      this.getResetVariables().add(variable);
    }

    // ----- add assigned agents & roles -------------
    for (User agent : copyFrom.getAssignAgents()) {
      addAssignAgent(agent);
    }

    for (Role role : copyFrom.getAssignRoles()) {
      addAssignRole(role);
    }

    for (Role role : copyFrom.getAuditAssignRoles()) {
      addAuditAssignRole(role);
    }

    // Copy event
    if (copyFrom.getEvent() != null) {
      SurveyFlowEvent flowEvent = new SurveyFlowEvent();
      flowEvent.setFlow(this);
      flowEvent.setCriteria((copyFrom.getEvent() != null) ? copyFrom.getEvent().getCriteria() : null);
      flowEvent.setCreator(user);
      flowEvent.setCreateDate(new Date());

      for (Event e : copyFrom.getEvent().getEvents()) {
        flowEvent.addEvent(e);
      }

      setEvent(flowEvent);
    }

    // Copy channel actions
    for (SurveyFlowChannelAction action : copyFrom.getChannelActions()) {
      SurveyFlowChannelAction act = new SurveyFlowChannelAction();
      act.deepCopy(action);
      act.setFlow(this);
      act.setCreator(copyFrom.getCreator());
      act.setCreateDate(copyFrom.getCreateDate());
      this.channelActions.add(act);
    }

    // Copy program actions
    for (SurveyFlowProgramAction action : copyFrom.getProgramActions()) {
      SurveyFlowProgramAction act = new SurveyFlowProgramAction();
      act.deepCopy(action);
      act.setFlow(this);
      act.setCreator(copyFrom.getCreator());
      act.setCreateDate(copyFrom.getCreateDate());
      this.programActions.add(act);
    }

    // Copy requeue actions
    for (SurveyFlowReQueueAction action : copyFrom.getReQueueActions()) {
      SurveyFlowReQueueAction act = new SurveyFlowReQueueAction();
      act.deepCopy(action);
      act.setFlow(this);
      act.setCreator(copyFrom.getCreator());
      act.setCreateDate(copyFrom.getCreateDate());
      this.reQueueActions.add(act);
    }

    // Copy flow updateVariableAction
    for (SurveyFlowUpdateVariableAction updateVariableAction : copyFrom.getUpdateVariableActions()) {
      SurveyFlowUpdateVariableAction action = new SurveyFlowUpdateVariableAction();
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

    // Copy variable actions
    for (SurveyFlowVariableAction action : copyFrom.getVariableActions()) {
      SurveyFlowVariableAction act = new SurveyFlowVariableAction();
      act.deepCopy(action);
      act.setFlow(this);
      act.setCreator(copyFrom.getCreator());
      act.setCreateDate(copyFrom.getCreateDate());
      this.variableActions.add(act);
    }

    // Copy flow actions
    for (SurveyFlowFlowAction action : copyFrom.getFlowActions()) {
      SurveyFlowFlowAction act = new SurveyFlowFlowAction();
      act.deepCopy(action);
      act.setFlow(this);
      act.setCreator(copyFrom.getCreator());
      act.setCreateDate(copyFrom.getCreateDate());
      this.flowActions.add(act);
    }

    // copy transaction actions
    for (SurveyFlowTransactionAction action : copyFrom.getTransactionActions()) {
      SurveyFlowTransactionAction act = new SurveyFlowTransactionAction();
      act.deepCopy(action);
      act.setFlow(this);
      act.setCreator(copyFrom.getCreator());
      act.setCreateDate(copyFrom.getCreateDate());
      this.transactionActions.add(act);
    }


    // Copy variable actions
    SurveyFlowStatusAction action = copyFrom.getStatusAction();

    if (action != null) {
      statusAction = new SurveyFlowStatusAction();
      statusAction.deepCopy(action);
      statusAction.setFlow(this);
      statusAction.setCreator(copyFrom.getCreator());
      statusAction.setCreateDate(copyFrom.getCreateDate());
    }

    // !----------------------------------------------

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

    SurveyFlow that = (SurveyFlow) o;

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(that.name)) : (that.name != null)) {
      return false;
    }

    if ((schedule != null) ? (!schedule.equals(that.schedule)) : (that.schedule != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for access type.
   *
   * @return  String
   */
  public String getAccessType() {
    boolean hasUserAccess = false;
    boolean hasRoleAccess = false;

    if (this.getAllowSPOC() || ((this.assignAgents != null) && (this.assignAgents.size() > 0))) {
      hasUserAccess = true;
    }

    if (this.getAllowWeb() || ((this.assignRoles != null) && (this.assignRoles.size() > 0))) {
      hasRoleAccess = true;
    }

    if (hasUserAccess && hasRoleAccess) {
      return "UR";
    } else if (hasUserAccess) {
      return "U";
    } else if (hasRoleAccess) {
      return "R";
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow SPOC.
   *
   * @return  Boolean
   */
  public Boolean getAllowSPOC() {
    if (allowSPOC == null) {
      return Boolean.FALSE;
    }

    return allowSPOC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for allow web.
   *
   * @return  Boolean
   */
  public Boolean getAllowWeb() {
    if (allowWeb == null) {
      return Boolean.FALSE;
    }

    return allowWeb;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for assign agents.
   *
   * @return  Set
   */
  public Set<User> getAssignAgents() {
    return assignAgents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for assign roles.
   *
   * @return  Set
   */
  public Set<Role> getAssignRoles() {
    return assignRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for as sub flow.
   *
   * @return  Boolean
   */
  public Boolean getAsSubFlow() {
    if (asSubFlow == null) {
      return Boolean.FALSE;
    }

    return asSubFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for audit assign roles.
   *
   * @return  Set
   */
  public Set<Role> getAuditAssignRoles() {
    return auditAssignRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for audit pass criteria.
   *
   * @return  String
   */
  public String getAuditPassCriteria() {
    return auditPassCriteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business process.
   *
   * @return  WorkflowBusinessProcess
   */
  public WorkflowBusinessProcess getBusinessProcess() {
    return businessProcess;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel actions.
   *
   * @return  Set
   */
  public Set<SurveyFlowChannelAction> getChannelActions() {
    return channelActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for copy from id.
   *
   * @return  Long
   */
  public Long getCopyFromId() {
    return copyFromId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria.
   *
   * @return  String
   */
  public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer title.
   *
   * @return  String
   */
  public String getCustomerTitle() {
    return customerTitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event.
   *
   * @return  SurveyFlowEvent
   */
  public SurveyFlowEvent getEvent() {
    return event;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flow actions.
   *
   * @return  Set
   */
  public Set<SurveyFlowFlowAction> getFlowActions() {
    return flowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flow frequency.
   *
   * @return  Integer
   */
  public Integer getFlowFrequency() {
    return flowFrequency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for frequency minutes.
   *
   * @return  Long
   */
  public Long getFrequencyMinutes() {
    return frequencyMinutes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has event.
   *
   * @return  Boolean
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
   * getter method for has reset variable.
   *
   * @return  Boolean
   */
  public Boolean getHasResetVariable() {
    if ((null != resetVariables) && (resetVariables.size() > 0)) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hot spot ids.
   *
   * @return  Collection
   */
  public Collection<Long> getHotSpotIds() {
    return this.hotSpots;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hot spots.
   *
   * @return  Collection
   */
  public Collection<Long> getHotSpots() {
    Set<Long> ids = new HashSet<Long>();

    for (SurveyFlowHotSpotsAssignment hotSpot : hotSpotSet) {
      if (hotSpot.getHotSpot() != null) {
        ids.add(hotSpot.getHotSpot().getId());
      }
    }

    return ids;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hot spot set.
   *
   * @return  Set
   */
  public Set<SurveyFlowHotSpotsAssignment> getHotSpotSet() {
    return hotSpotSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for links.
   *
   * @return  Set
   */
  public Set<SurveyFlowLink> getLinks() {
    return links;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for nodes.
   *
   * @return  Set
   */
  public Set<SurveyFlowNode> getNodes() {
    return nodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for persistence code.
   *
   * @return  String
   */
  public String getPersistenceCode() {
    return persistenceCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program actions.
   *
   * @return  Set
   */
  public Set<SurveyFlowProgramAction> getProgramActions() {
    return programActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for re queue actions.
   *
   * @return  Set
   */
  public Set<SurveyFlowReQueueAction> getReQueueActions() {
    return reQueueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reset variables.
   *
   * @return  Set
   */
  public Set<BaseVariable> getResetVariables() {
    return resetVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule.
   *
   * @return  SurveySchedule
   */
  public SurveySchedule getSchedule() {
    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for show step in site.
   *
   * @return  Boolean
   */
  public Boolean getShowStepInSite() {
    if (showStepInSite == null) {
      return Boolean.FALSE;
    }

    return showStepInSite;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status action.
   *
   * @return  SurveyFlowStatusAction
   */
  public SurveyFlowStatusAction getStatusAction() {
    return statusAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for steps.
   *
   * @return  Set
   */
  public Set<SurveyFlowProgressStep> getSteps() {
    return steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sub flow nodes.
   *
   * @return  Set
   */
  public Set<SurveyFlowNode> getSubFlowNodes() {
    return subFlowNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tag.
   *
   * @return  String
   */
  public String getTag() {
    return tag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total node.
   *
   * @return  int
   */
  public int getTotalNode() {
    return nodes.size();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction actions.
   *
   * @return  Set
   */
  public Set<SurveyFlowTransactionAction> getTransactionActions() {
    return transactionActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for update variable actions.
   *
   * @return  Set
   */
  public Set<SurveyFlowUpdateVariableAction> getUpdateVariableActions() {
    return updateVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable actions.
   *
   * @return  Set
   */
  public Set<SurveyFlowVariableAction> getVariableActions() {
    return variableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasHotSpotById.
   *
   * @param   hotSpotId  Long
   *
   * @return  boolean
   */
  public boolean hasHotSpotById(Long hotSpotId) {
    for (SurveyFlowHotSpotsAssignment hotSpotsAssignment : hotSpotSet) {
      return hotSpotsAssignment.getHotSpot().getId().equals(hotSpotId);
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasHotSpotByName.
   *
   * @param   hotspotName  String
   *
   * @return  boolean
   */
  public boolean hasHotSpotByName(String hotspotName) {
    for (SurveyFlowHotSpotsAssignment hotSpotsAssignment : hotSpotSet) {
      return hotSpotsAssignment.getHotSpot().getValue().equals(hotspotName);
    }

    return Boolean.FALSE;
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
   * removeAssignAgent.
   *
   * @param  user  User
   */
  public void removeAssignAgent(User user) {
    if (null != user) {
      this.assignAgents.remove(user);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeAssignRole.
   *
   * @param  role  Role
   */
  public void removeAssignRole(Role role) {
    if (null != role) {
      this.assignRoles.remove(role);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeStep.
   *
   * @param  step  SurveyFlowProgressStep
   */
  public void removeStep(SurveyFlowProgressStep step) {
    if (step != null) {
      for (SurveyFlowProgressStep progressStep : this.steps) {
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
   * setter method for allow SPOC.
   *
   * @param  allowSPOC  Boolean
   */
  public void setAllowSPOC(Boolean allowSPOC) {
    this.allowSPOC = allowSPOC;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for allow web.
   *
   * @param  allowWeb  Boolean
   */
  public void setAllowWeb(Boolean allowWeb) {
    this.allowWeb = allowWeb;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for assign agents.
   *
   * @param  assignAgents  Set
   */
  public void setAssignAgents(Set<User> assignAgents) {
    this.assignAgents = assignAgents;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for assign roles.
   *
   * @param  assignRoles  Set
   */
  public void setAssignRoles(Set<Role> assignRoles) {
    this.assignRoles = assignRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for as sub flow.
   *
   * @param  asSubFlow  Boolean
   */
  public void setAsSubFlow(Boolean asSubFlow) {
    this.asSubFlow = asSubFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for audit assign roles.
   *
   * @param  auditAssignRoles  Set
   */
  public void setAuditAssignRoles(Set<Role> auditAssignRoles) {
    this.auditAssignRoles = auditAssignRoles;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for audit pass criteria.
   *
   * @param  auditPassCriteria  String
   */
  public void setAuditPassCriteria(String auditPassCriteria) {
    this.auditPassCriteria = auditPassCriteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business process.
   *
   * @param  businessProcess  WorkflowBusinessProcess
   */
  public void setBusinessProcess(WorkflowBusinessProcess businessProcess) {
    this.businessProcess = businessProcess;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel actions.
   *
   * @param  channelActions  Set
   */
  public void setChannelActions(Set<SurveyFlowChannelAction> channelActions) {
    this.channelActions = channelActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for copy from id.
   *
   * @param  copyFromId  Long
   */
  public void setCopyFromId(Long copyFromId) {
    this.copyFromId = copyFromId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for criteria.
   *
   * @param  criteria  String
   */
  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer title.
   *
   * @param  customerTitle  String
   */
  public void setCustomerTitle(String customerTitle) {
    this.customerTitle = customerTitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event.
   *
   * @param  event  SurveyFlowEvent
   */
  public void setEvent(SurveyFlowEvent event) {
    this.event = event;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flow actions.
   *
   * @param  flowActions  Set
   */
  public void setFlowActions(Set<SurveyFlowFlowAction> flowActions) {
    this.flowActions = flowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flow frequency.
   *
   * @param  flowFrequency  Integer
   */
  public void setFlowFrequency(Integer flowFrequency) {
    this.flowFrequency = flowFrequency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for frequency minutes.
   *
   * @param  frequencyMinutes  Long
   */
  public void setFrequencyMinutes(Long frequencyMinutes) {
    this.frequencyMinutes = frequencyMinutes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hot spots.
   *
   * @param  ids  Collection
   */
  public void setHotSpots(Collection<Long> ids) {
    this.hotSpots = ids;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hot spot set.
   *
   * @param  hotSpotSet  Set
   */
  public void setHotSpotSet(Set<SurveyFlowHotSpotsAssignment> hotSpotSet) {
    this.hotSpotSet = hotSpotSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for links.
   *
   * @param  links  Set
   */
  public void setLinks(Set<SurveyFlowLink> links) {
    this.links = links;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for nodes.
   *
   * @param  nodes  Set
   */
  public void setNodes(Set<SurveyFlowNode> nodes) {
    this.nodes = nodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for persistence code.
   *
   * @param  persistenceCode  String
   */
  public void setPersistenceCode(String persistenceCode) {
    this.persistenceCode = persistenceCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program actions.
   *
   * @param  programActions  Set
   */
  public void setProgramActions(Set<SurveyFlowProgramAction> programActions) {
    this.programActions = programActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for re queue actions.
   *
   * @param  reQueueActions  Set
   */
  public void setReQueueActions(Set<SurveyFlowReQueueAction> reQueueActions) {
    this.reQueueActions = reQueueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for reset variables.
   *
   * @param  resetVariables  Set
   */
  public void setResetVariables(Set<BaseVariable> resetVariables) {
    this.resetVariables = resetVariables;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule.
   *
   * @param  schedule  SurveySchedule
   */
  public void setSchedule(SurveySchedule schedule) {
    this.schedule = schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for show step in site.
   *
   * @param  showStepInSite  Boolean
   */
  public void setShowStepInSite(Boolean showStepInSite) {
    this.showStepInSite = showStepInSite;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status action.
   *
   * @param  statusAction  SurveyFlowStatusAction
   */
  public void setStatusAction(SurveyFlowStatusAction statusAction) {
    this.statusAction = statusAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for steps.
   *
   * @param  steps  Set
   */
  public void setSteps(Set<SurveyFlowProgressStep> steps) {
    this.steps = steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sub flow nodes.
   *
   * @param  subFlowNodes  Set
   */
  public void setSubFlowNodes(Set<SurveyFlowNode> subFlowNodes) {
    this.subFlowNodes = subFlowNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tag.
   *
   * @param  tag  String
   */
  public void setTag(String tag) {
    this.tag = tag;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transaction actions.
   *
   * @param  transactionActions  Set
   */
  public void setTransactionActions(Set<SurveyFlowTransactionAction> transactionActions) {
    this.transactionActions = transactionActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for update variable actions.
   *
   * @param  updateVariableActions  Set
   */
  public void setUpdateVariableActions(Set<SurveyFlowUpdateVariableAction> updateVariableActions) {
    this.updateVariableActions = updateVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable actions.
   *
   * @param  variableActions  Set
   */
  public void setVariableActions(Set<SurveyFlowVariableAction> variableActions) {
    this.variableActions = variableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateStep.
   *
   * @param  step  SurveyFlowProgressStep
   */
  public void updateStep(SurveyFlowProgressStep step) {
    if (step != null) {
      for (SurveyFlowProgressStep progressStep : this.steps) {
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
} // end class SurveyFlow
