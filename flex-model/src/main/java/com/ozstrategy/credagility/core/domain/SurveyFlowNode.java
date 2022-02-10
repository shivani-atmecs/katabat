package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.portfolio.PortfolioStaticPage;
import com.cmc.credagility.core.domain.portfolio.PortfolioSurvey;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.sor.SurveyFlowNodeTransactionAction;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeType;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * this class the flow node info.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 14:18
 */
@Entity
@Table(
  name              = "SurveyFlowNode",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "surveyFlowId", "surveyId", "staticPageId", "subFlowId" }) }
)
public class SurveyFlowNode extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 537405815492561110L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** allow SPOC. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowSPOC;


  /** is allow on web. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowWeb;


  /** who can exe this node. */
  @JoinTable(
    name               = "SurveyFlowNodeAssignAgent",
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


  /** this role who can exe this node. */
  @JoinTable(
    name               = "SurveyFlowNodeAssignRole",
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


  /** the channel actions assign to this node. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "node",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<SurveyFlowNodeChannelAction> channelActions = new LinkedHashSet<SurveyFlowNodeChannelAction>();


  /** the trigger type is daily channel action assign to this node. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "node"
  )
  @Where(clause = "triggerType = 'DAILY'")
  protected Set<SurveyFlowNodeChannelAction> dailyChannelActions = new LinkedHashSet<SurveyFlowNodeChannelAction>();


  /** the trigger type is daily flow action assign to this node. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "node"
  )
  @Where(clause = "triggerType = 'DAILY'")
  protected Set<SurveyFlowNodeFlowAction> dailyFlowActions = new LinkedHashSet<SurveyFlowNodeFlowAction>();


  /** the trigger type is daily program action assign to this node. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "node"
  )
  @Where(clause = "triggerType = 'DAILY'")
  protected Set<SurveyFlowNodeProgramAction> dailyProgramActions = new LinkedHashSet<SurveyFlowNodeProgramAction>();

  /** the flow action assign to this node. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "node",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<SurveyFlowNodeFlowAction> flowActions = new LinkedHashSet<SurveyFlowNodeFlowAction>();


  /** the survey flow from link. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "from"
  )
  @OrderBy("priority asc")
  protected Set<SurveyFlowLink> fromSet = new LinkedHashSet<SurveyFlowLink>();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** no Regret if true ,you can't back the previous node to redo task. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean noRegret = false;

  /** the Program action assign to this node. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "node",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<SurveyFlowNodeProgramAction> programActions = new LinkedHashSet<SurveyFlowNodeProgramAction>();


  /** the reQueue action assign to this node. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "node",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<SurveyFlowNodeReQueueAction> reQueueActions = new LinkedHashSet<SurveyFlowNodeReQueueAction>();

  /** is the root node. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean root = false;

  /** Static Page. */
  @JoinColumn(
    name       = "staticPageId",
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioStaticPage staticPage;

  /** SurveyFlowNodeStatusAction. */
  @OneToOne(
    mappedBy      = "node",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected SurveyFlowNodeStatusAction statusAction;


  /** assign step info to this node. */
  @JoinColumn(name = "stepId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowProgressStep step;

  /** Static Page. */
  @JoinColumn(
    name       = "subFlowId",
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlow subFlow;

  /** PortfolioSurvey. */
  @JoinColumn(
    name       = "surveyId",
    updatable  = true,
    insertable = true,
    nullable   = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioSurvey survey;

  /** Survey Flow. */
  @JoinColumn(
    name       = "surveyFlowId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlow surveyFlow;


  /** drivenType = 'BATCH' survey flow link. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "from"
  )
  @OrderBy("priority asc")
  @Where(clause = "drivenType = 'BATCH'")
  protected Set<SurveyFlowLink> systemOutputLinks = new LinkedHashSet<SurveyFlowLink>();


  /** SurveyFlowLink end. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "to"
  )
  @OrderBy("priority asc")
  protected Set<SurveyFlowLink> toSet = new LinkedHashSet<SurveyFlowLink>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "node",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<SurveyFlowNodeTransactionAction> transactionActions =
    new LinkedHashSet<SurveyFlowNodeTransactionAction>();


  /** Node Type contain STATIC_PAGE_NODE, SUB_FLOW_NODE, SURVEY_NODE, END_NODE, ROOT_NODE. */
  @Column(length = 32)
  @Enumerated(value = EnumType.STRING)
  protected WorkflowNodeType type = WorkflowNodeType.SURVEY_NODE;

  /** updateVariableActions assign to the node. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "node",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<SurveyFlowNodeUpdateVariableAction> updateVariableActions =
    new LinkedHashSet<SurveyFlowNodeUpdateVariableAction>();


  /** variableActions assign to node. */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "node",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<SurveyFlowNodeVariableAction> variableActions = new LinkedHashSet<SurveyFlowNodeVariableAction>();

  @Transient private Long subFlowCopyFromId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addAssignAgent.
   *
   * @param  user  User
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
   * @param  agents  List
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
   * @param  role  Role
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
   * @param  roles  List
   */
  public void addAssignRoles(List<Role> roles) {
    if ((roles != null) && (roles.size() > 0)) {
      this.assignRoles.addAll(roles);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addChannelAction.
   *
   * @param  channelAction  SurveyFlowNodeChannelAction
   */
  public void addChannelAction(SurveyFlowNodeChannelAction channelAction) {
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
   * addFlowAction.
   *
   * @param  flowAction  SurveyFlowNodeFlowAction
   */
  public void addFlowAction(SurveyFlowNodeFlowAction flowAction) {
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
   * addProgramAction.
   *
   * @param  programAction  SurveyFlowNodeProgramAction
   */
  public void addProgramAction(SurveyFlowNodeProgramAction programAction) {
    if (programAction != null) {
      if ((null != this.programActions) && (this.programActions.size() > 0)
            && !this.programActions.contains(programAction)) {
        this.programActions.add(programAction);
      } else {
        this.programActions.add(programAction);
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addReQueueAction.
   *
   * @param  reQueueAction  SurveyFlowNodeReQueueAction
   */
  public void addReQueueAction(SurveyFlowNodeReQueueAction reQueueAction) {
    if (reQueueAction != null) {
      if ((null != this.reQueueActions) && (this.reQueueActions.size() > 0)
            && !this.reQueueActions.contains(reQueueAction)) {
        this.reQueueActions.add(reQueueAction);
      } else {
        this.reQueueActions.add(reQueueAction);
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * AddTransactionAction.
   *
   * @param  transAction  SurveyFlowNodeTransactionAction
   */
  public void AddTransactionAction(SurveyFlowNodeTransactionAction transAction) {
    if (null != transAction) {
      if ((null != this.transactionActions) && (this.transactionActions.size() > 0)
            && !this.transactionActions.contains(transAction)) {
        this.transactionActions.add(transAction);
      } else {
        this.transactionActions.add(transAction);
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addVariableAction.
   *
   * @param  variableAction  SurveyFlowNodeVariableAction
   */
  public void addVariableAction(SurveyFlowNodeVariableAction variableAction) {
    if (variableAction != null) {
      if ((null != this.variableActions) && (this.variableActions.size() > 0)
            && !this.variableActions.contains(variableAction)) {
        this.variableActions.add(variableAction);
      } else {
        this.variableActions.add(variableAction);
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  SurveyFlowNode
   */
  public void deepCopy(SurveyFlowNode copyFrom) {
    setRoot(copyFrom.isRoot());
    setStaticPage(copyFrom.getStaticPage());
    setSurvey(copyFrom.getSurvey());
    setSubFlow(copyFrom.getSubFlow());
    setType(copyFrom.getType());
    setNoRegret(copyFrom.getNoRegret());
    setAllowWeb(copyFrom.getAllowWeb());
    setAllowSPOC(copyFrom.getAllowSPOC());

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

    // Copy channel actions
    for (SurveyFlowNodeChannelAction action : copyFrom.getChannelActions()) {
      SurveyFlowNodeChannelAction act = new SurveyFlowNodeChannelAction();
      act.deepCopy(action);
      act.setNode(this);
      act.setCreator(copyFrom.getCreator());
      act.setCreateDate(copyFrom.getCreateDate());
      this.addChannelAction(act);
    }

    // Copy program actions
    for (SurveyFlowNodeProgramAction action : copyFrom.getProgramActions()) {
      SurveyFlowNodeProgramAction act = new SurveyFlowNodeProgramAction();
      act.deepCopy(action);
      act.setNode(this);
      act.setCreator(copyFrom.getCreator());
      act.setCreateDate(copyFrom.getCreateDate());
      this.addProgramAction(act);
    }

    // Copy requeue actions
    for (SurveyFlowNodeReQueueAction action : copyFrom.getReQueueActions()) {
      SurveyFlowNodeReQueueAction act = new SurveyFlowNodeReQueueAction();
      act.deepCopy(action);
      act.setNode(this);
      act.setCreator(copyFrom.getCreator());
      act.setCreateDate(copyFrom.getCreateDate());
      this.addReQueueAction(act);
    }

    // Copy flow updateVariableAction
    for (SurveyFlowNodeUpdateVariableAction updateVariableAction : copyFrom.getUpdateVariableActions()) {
      SurveyFlowNodeUpdateVariableAction action = new SurveyFlowNodeUpdateVariableAction();
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

    // Copy variable actions
    for (SurveyFlowNodeVariableAction action : copyFrom.getVariableActions()) {
      SurveyFlowNodeVariableAction act = new SurveyFlowNodeVariableAction();
      act.deepCopy(action);
      act.setNode(this);
      act.setCreator(copyFrom.getCreator());
      act.setCreateDate(copyFrom.getCreateDate());
      this.addVariableAction(act);
    }

    // Copy flow actions
    for (SurveyFlowNodeFlowAction action : copyFrom.getFlowActions()) {
      SurveyFlowNodeFlowAction act = new SurveyFlowNodeFlowAction();
      act.deepCopy(action);
      act.setNode(this);
      act.setCreator(copyFrom.getCreator());
      act.setCreateDate(copyFrom.getCreateDate());
      this.addFlowAction(act);
    }

    // Copy transaction actions
    for (SurveyFlowNodeTransactionAction action : copyFrom.getTransactionActions()) {
      SurveyFlowNodeTransactionAction act = new SurveyFlowNodeTransactionAction();
      act.deepCopy(action);
      act.setNode(this);
      act.setCreator(copyFrom.getCreator());
      act.setCreateDate(copyFrom.getCreateDate());
      this.AddTransactionAction(act);
    }


    // Copy variable actions
    SurveyFlowNodeStatusAction action = copyFrom.getStatusAction();

    if (action != null) {
      statusAction = new SurveyFlowNodeStatusAction();
      statusAction.deepCopy(action);
      statusAction.setNode(this);
      statusAction.setCreator(copyFrom.getCreator());
      statusAction.setCreateDate(copyFrom.getCreateDate());
    }
    // !-----------------------------------------------
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

    SurveyFlowNode that = (SurveyFlowNode) o;

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((staticPage != null) ? (!staticPage.equals(that.staticPage)) : (that.staticPage != null)) {
      return false;
    }

    if ((survey != null) ? (!survey.equals(that.survey)) : (that.survey != null)) {
      return false;
    }

    if ((surveyFlow != null) ? (!surveyFlow.equals(that.surveyFlow)) : (that.surveyFlow != null)) {
      return false;
    }

    if ((allowWeb != null) ? (!allowWeb.equals(that.allowWeb)) : (that.allowWeb != null)) {
      return false;
    }

    if ((allowSPOC != null) ? (!allowSPOC.equals(that.allowSPOC)) : (that.allowSPOC != null)) {
      return false;
    }

    return true;
  } // end method equals

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
   * getter method for channel actions.
   *
   * @return  Set
   */
  public Set<SurveyFlowNodeChannelAction> getChannelActions() {
    return channelActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for daily channel actions.
   *
   * @return  Set
   */
  public Set<SurveyFlowNodeChannelAction> getDailyChannelActions() {
    return dailyChannelActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for daily flow actions.
   *
   * @return  Set
   */
  public Set<SurveyFlowNodeFlowAction> getDailyFlowActions() {
    return dailyFlowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for daily program actions.
   *
   * @return  Set
   */
  public Set<SurveyFlowNodeProgramAction> getDailyProgramActions() {
    return dailyProgramActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flow actions.
   *
   * @return  Set
   */
  public Set<SurveyFlowNodeFlowAction> getFlowActions() {
    return flowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for from set.
   *
   * @return  Set
   */
  public Set<SurveyFlowLink> getFromSet() {
    return fromSet;
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
   * getter method for instance id.
   *
   * @return  Long
   */
  public Long getInstanceId() {
    Long instanceId = null;

    switch (getType()) {
      case SURVEY_NODE: {
        instanceId = getSurvey().getId();

        break;
      }

      case STATIC_PAGE_NODE: {
        instanceId = getStaticPage().getStaticPageId();

        break;
      }

      case SUB_FLOW_NODE: {
        instanceId = getSubFlow().getId();

        break;
      }

      default: { }
    }

    return instanceId;
  } // end method getInstanceId

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    String name = null;

    switch (type) {
      case STATIC_PAGE_NODE: {
        name = getStaticPage().getPageName();

        break;
      }

      case SUB_FLOW_NODE: {
        name = getSubFlow().getName();

        break;
      }

      case SURVEY_NODE: {
        name = getSurvey().getName();

        break;
      }

      case ROOT_NODE: {
        name = "Root";

        break;
      }

      default: { }
    } // end switch

    return name;
  } // end method getName

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for no regret.
   *
   * @return  Boolean
   */
  public Boolean getNoRegret() {
    if (noRegret == null) {
      return Boolean.FALSE;
    }

    return noRegret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program actions.
   *
   * @return  Set
   */
  public Set<SurveyFlowNodeProgramAction> getProgramActions() {
    return programActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for re queue actions.
   *
   * @return  Set
   */
  public Set<SurveyFlowNodeReQueueAction> getReQueueActions() {
    return reQueueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for static page.
   *
   * @return  PortfolioStaticPage
   */
  public PortfolioStaticPage getStaticPage() {
    return staticPage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status action.
   *
   * @return  SurveyFlowNodeStatusAction
   */
  public SurveyFlowNodeStatusAction getStatusAction() {
    return statusAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for step.
   *
   * @return  SurveyFlowProgressStep
   */
  public SurveyFlowProgressStep getStep() {
    return step;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sub flow.
   *
   * @return  SurveyFlow
   */
  public SurveyFlow getSubFlow() {
    return subFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sub flow copy from id.
   *
   * @return  Long
   */
  public Long getSubFlowCopyFromId() {
    return subFlowCopyFromId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey.
   *
   * @return  PortfolioSurvey
   */
  public PortfolioSurvey getSurvey() {
    return survey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey flow.
   *
   * @return  SurveyFlow
   */
  public SurveyFlow getSurveyFlow() {
    return surveyFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for system output links.
   *
   * @return  Set
   */
  public Set<SurveyFlowLink> getSystemOutputLinks() {
    return systemOutputLinks;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for to set.
   *
   * @return  Set
   */
  public Set<SurveyFlowLink> getToSet() {
    return toSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for transaction actions.
   *
   * @return  Set
   */
  public Set<SurveyFlowNodeTransactionAction> getTransactionActions() {
    return transactionActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  WorkflowNodeType
   */
  public WorkflowNodeType getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for update variable actions.
   *
   * @return  Set
   */
  public Set<SurveyFlowNodeUpdateVariableAction> getUpdateVariableActions() {
    return updateVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable actions.
   *
   * @return  Set
   */
  public Set<SurveyFlowNodeVariableAction> getVariableActions() {
    return variableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((staticPage != null) ? staticPage.hashCode() : 0);
    result = (31 * result) + ((survey != null) ? survey.hashCode() : 0);
    result = (31 * result) + ((surveyFlow != null) ? surveyFlow.hashCode() : 0);
    result = (31 * result) + ((allowWeb != null) ? allowWeb.hashCode() : 0);
    result = (31 * result) + ((allowSPOC != null) ? allowSPOC.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for end flow.
   *
   * @return  boolean
   */
  public boolean isEndFlow() {
    return (this.survey != null && this.survey.getActiveVersion() != null) ? this.survey.getActiveVersion().getEndFlow() : Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for root.
   *
   * @return  Boolean
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
   * getter method for static page.
   *
   * @return  boolean
   */
  public boolean isStaticPage() {
    return this.staticPage != null;
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
   * setter method for channel actions.
   *
   * @param  channelActions  Set
   */
  public void setChannelActions(Set<SurveyFlowNodeChannelAction> channelActions) {
    this.channelActions = channelActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for daily channel actions.
   *
   * @param  dailyChannelActions  Set
   */
  public void setDailyChannelActions(Set<SurveyFlowNodeChannelAction> dailyChannelActions) {
    this.dailyChannelActions = dailyChannelActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for daily flow actions.
   *
   * @param  dailyFlowActions  Set
   */
  public void setDailyFlowActions(Set<SurveyFlowNodeFlowAction> dailyFlowActions) {
    this.dailyFlowActions = dailyFlowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for daily program actions.
   *
   * @param  dailyProgramActions  Set
   */
  public void setDailyProgramActions(Set<SurveyFlowNodeProgramAction> dailyProgramActions) {
    this.dailyProgramActions = dailyProgramActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flow actions.
   *
   * @param  flowActions  Set
   */
  public void setFlowActions(Set<SurveyFlowNodeFlowAction> flowActions) {
    this.flowActions = flowActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for from set.
   *
   * @param  fromSet  Set
   */
  public void setFromSet(Set<SurveyFlowLink> fromSet) {
    this.fromSet = fromSet;
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
   * setter method for no regret.
   *
   * @param  noRegret  Boolean
   */
  public void setNoRegret(Boolean noRegret) {
    this.noRegret = noRegret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program actions.
   *
   * @param  programActions  Set
   */
  public void setProgramActions(Set<SurveyFlowNodeProgramAction> programActions) {
    this.programActions = programActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for re queue actions.
   *
   * @param  reQueueActions  Set
   */
  public void setReQueueActions(Set<SurveyFlowNodeReQueueAction> reQueueActions) {
    this.reQueueActions = reQueueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for root.
   *
   * @param  root  Boolean
   */
  public void setRoot(Boolean root) {
    this.root = root;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for static page.
   *
   * @param  staticPage  PortfolioStaticPage
   */
  public void setStaticPage(PortfolioStaticPage staticPage) {
    this.staticPage = staticPage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status action.
   *
   * @param  statusAction  SurveyFlowNodeStatusAction
   */
  public void setStatusAction(SurveyFlowNodeStatusAction statusAction) {
    this.statusAction = statusAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for step.
   *
   * @param  step  SurveyFlowProgressStep
   */
  public void setStep(SurveyFlowProgressStep step) {
    this.step = step;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sub flow.
   *
   * @param  subFlow  SurveyFlow
   */
  public void setSubFlow(SurveyFlow subFlow) {
    this.subFlow = subFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey.
   *
   * @param  survey  PortfolioSurvey
   */
  public void setSurvey(PortfolioSurvey survey) {
    this.survey = survey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey flow.
   *
   * @param  surveyFlow  SurveyFlow
   */
  public void setSurveyFlow(SurveyFlow surveyFlow) {
    this.surveyFlow = surveyFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for system output links.
   *
   * @param  systemOutputLinks  Set
   */
  public void setSystemOutputLinks(Set<SurveyFlowLink> systemOutputLinks) {
    this.systemOutputLinks = systemOutputLinks;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for to set.
   *
   * @param  toSet  Set
   */
  public void setToSet(Set<SurveyFlowLink> toSet) {
    this.toSet = toSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for transaction actions.
   *
   * @param  transactionActions  Set
   */
  public void setTransactionActions(Set<SurveyFlowNodeTransactionAction> transactionActions) {
    this.transactionActions = transactionActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type.
   *
   * @param  type  WorkflowNodeType
   */
  public void setType(WorkflowNodeType type) {
    this.type = type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for update variable actions.
   *
   * @param  updateVariableActions  Set
   */
  public void setUpdateVariableActions(Set<SurveyFlowNodeUpdateVariableAction> updateVariableActions) {
    this.updateVariableActions = updateVariableActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable actions.
   *
   * @param  variableActions  Set
   */
  public void setVariableActions(Set<SurveyFlowNodeVariableAction> variableActions) {
    this.variableActions = variableActions;
  }
} // end class SurveyFlowNode
