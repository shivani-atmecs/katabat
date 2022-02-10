package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.sor.TransactionAction;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store strategy node information.
 *
 * <p><a href="Node.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
@Entity public class Node extends BaseNode<Strategy> implements Evaluable, Executable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6273859593196039619L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "asSub",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean asSub = false;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "chargeOffActionId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected ChargeOffAction chargeOffAction;

  /** Down linked child nodes. */
  @OneToMany(
    mappedBy      = "parentNode",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("priority asc")
  protected Set<Node> childNodes = new LinkedHashSet<Node>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    mappedBy      = "foldNode",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("level asc , priority asc")
  protected Set<Node> childSubNodes = new LinkedHashSet<Node>();

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "collapse",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean collapse = false;

  /** Trigger flag for node. */
  @Transient protected boolean evaluateResult = false;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "foldNodeId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected Node foldNode;


  /** strategy. */
  @JoinColumn(
    name       = "foldStrategyId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Strategy foldStrategy;

  /** primary key. */

  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Leftover Node. */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean leftOver = false;


  /** TODO: DOCUMENT ME! */
  protected final transient Logger log = LoggerFactory.getLogger(getClass());

  /** Up linked parent node. */
  @JoinColumn(
    name       = "parentNodeId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected Node parentNode;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "recallActionId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected RecallAction recallAction;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "statusActionId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected StatusAction statusAction;

  /** strategy. */
  @JoinColumn(
    name       = "strategyId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Strategy strategy = new Strategy();


  /** TODO: DOCUMENT ME! */
  @Transient protected boolean triggered = false;
  // private Map<Long, Long> actionTriggerCount = new HashMap<Long, Long>();

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "node",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  protected Set<NodeUpdateAction> updateActions = new LinkedHashSet<NodeUpdateAction>();

  @Column(nullable = true)
  private Integer bizHashCode = null;


  @Column(nullable = true)
  private Long copyFromId;

  @JoinTable(
    name               = "NodeAgencyAction",
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
        name           = "agencyActionId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  private Set<AgencyAssignmentAction> nodeAgencyActions = new LinkedHashSet<AgencyAssignmentAction>();


  @JoinTable(
    name               = "NodeAgentAction",
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
        name           = "agentActionId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  private Set<AgentAssignmentAction> nodeAgentActions = new LinkedHashSet<AgentAssignmentAction>();

  @JoinTable(
    name               = "NodeBureauImportAction",
    joinColumns        = {
      @JoinColumn(
        name           = "nodeId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "bureauImportActionId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL, CascadeType.REMOVE }
  )
  private Set<BureauImportAction> nodeBureauImportActions = new LinkedHashSet<>();

  /** Node channel actions. */
  @JoinTable(
    name               = "NodeChannelAction",
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
        name           = "channelActionId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  private Set<ChannelAction> nodeChannelActions = new LinkedHashSet<ChannelAction>();


  @JoinTable(
    name               = "NodeDataExportAction",
    joinColumns        = {
      @JoinColumn(
        name           = "nodeId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "dataExportActionId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  private Set<DataExportAction> nodeDataExportActions = new LinkedHashSet<>();

  @JoinTable(
    name               = "NodePersonaAction",
    joinColumns        = {
      @JoinColumn(
        name           = "nodeId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "personaActionId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  private Set<PersonaAction> nodePersonaActions = new LinkedHashSet<PersonaAction>();


  /** Node program actions. */
  @JoinTable(
    name               = "NodeProgramAction",
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
        name           = "programActionId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  private Set<ProgramAction> nodeProgramActions = new LinkedHashSet<ProgramAction>();

  /** Node queue actions. */
  @JoinTable(
    name               = "NodeQueueAction",
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
        name           = "queueActionId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  private Set<QueueAction> nodeQueueActions = new LinkedHashSet<QueueAction>();


  /** Node requeue actions. */
  @JoinTable(
    name               = "NodeReQueueAction",
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
        name           = "reQueueActionId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  private Set<ReQueueAction> nodeReQueueActions = new LinkedHashSet<ReQueueAction>();

  /** Node score actions. */
  @JoinTable(
    name               = "NodeScoreAction",
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
        name           = "scoreActionId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  private Set<ScoreAction> nodeScoreActions = new LinkedHashSet<ScoreAction>();

  @JoinTable(
    name               = "NodeTransactionAction",
    joinColumns        = {
      @JoinColumn(
        name           = "nodeId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "transActionId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  private Set<TransactionAction> nodeTransactionActions = new LinkedHashSet<TransactionAction>();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new Node object.
   */
  public Node() { }

  /**
   * Creates a new Node object.
   *
   * @param  id  Long
   */
  public Node(Long id) {
    this.id = id;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addChildNode.
   *
   * @param  childNode  Node
   */
  public void addChildNode(Node childNode) {
    addChildNode(childNode, true);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addChildNode.
   *
   * @param   childNode       Node
   * @param   createLeftOver  boolean
   *
   * @throws  IllegalArgumentException  exception
   */
  public void addChildNode(Node childNode, boolean createLeftOver) {
    if (childNode == null) {
      throw (new IllegalArgumentException("Null child node!"));
    }

    // create left over child node, if there is none
    if (createLeftOver && (!hasLeftOver())) {
      Node leftOver = new Node();
      leftOver.setName("Left Over");

      // remove left attribute
      leftOver.setLeftOver(true);
      leftOver.setPriority(Integer.MAX_VALUE);
      leftOver.setParentNode(this);
      leftOver.setCreator(childNode.getCreator());
      this.strategy.addNode(leftOver);
      childNodes.add(leftOver);
    }

    if (childNode.getParentNode() != null) {
      childNode.getParentNode().getChildNodes().remove(childNode);
    }

    childNode.setParentNode(this);
    // if (!childNodes.contains(childNode)) {

    if (!Boolean.TRUE.equals(childNode.leftOver)) {
      // childNode.setPriority(childNodes.size());
      this.strategy.addNode(childNode);
      childNodes.add(childNode);
    } else {
      if (childNodes.size() == 0) {
        this.strategy.addNode((childNode));
        childNodes.add(childNode);
      } else {
        Boolean hasLeft = false;

        for (Node n : childNodes) {
          if (n.leftOver) {
            hasLeft = true;

            if (childNode.getChildNodes().size() > 0) { // merge leftover childNodes

              for (Node ln : childNode.getChildNodes()) {
                n.addChildNode(ln, false);
              }
            }
          }
        }

        if (hasLeft == false) {
          this.strategy.addNode((childNode));
          childNodes.add(childNode);
        }
      } // end if-else
    }   // end if-else
  }     // end method addChildNode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addNodeAgencyAction.
   *
   * @param  roleAssignmentAction  AgencyAssignmentAction
   */
  public void addNodeAgencyAction(AgencyAssignmentAction roleAssignmentAction) {
    roleAssignmentAction.getAgencyNodes().add(this);
    this.nodeAgencyActions.add(roleAssignmentAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addNodeAgentAction.
   *
   * @param  agentAssignmentAction  AgentAssignmentAction
   */
  public void addNodeAgentAction(AgentAssignmentAction agentAssignmentAction) {
    agentAssignmentAction.getAgentNodes().add(this);
    this.nodeAgentActions.add(agentAssignmentAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addNodeBureauImportAction.
   *
   * @param  bureauImportAction  BureauImportAction
   */
  public void addNodeBureauImportAction(BureauImportAction bureauImportAction) {
    bureauImportAction.getBureauNodes().add(this);
    this.nodeBureauImportActions.add(bureauImportAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addNodeChannelAction.
   *
   * @param  channelAction  ChannelAction
   */
  public void addNodeChannelAction(ChannelAction channelAction) {
    channelAction.getChannelNodes().add(this);
    this.nodeChannelActions.add(channelAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addNodeDataExportAction.
   *
   * @param  dataExportAction  DataExportAction
   */
  public void addNodeDataExportAction(DataExportAction dataExportAction) {
    dataExportAction.getDataExportNodes().add(this);
    this.nodeDataExportActions.add(dataExportAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addNodeProgramAction.
   *
   * @param  programAction  ProgramAction
   */
  public void addNodeProgramAction(ProgramAction programAction) {
    programAction.getProgramNodes().add(this);
    this.nodeProgramActions.add(programAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addNodeQueueAction.
   *
   * @param  queueAction  QueueAction
   */
  public void addNodeQueueAction(QueueAction queueAction) {
    queueAction.getQueueNodes().add(this);
    this.nodeQueueActions.add(queueAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addNodeReQueueAction.
   *
   * @param  reQueueAction  ReQueueAction
   */
  public void addNodeReQueueAction(ReQueueAction reQueueAction) {
    reQueueAction.getReQueueNodes().add(this);
    this.nodeReQueueActions.add(reQueueAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addNodeScoreAction.
   *
   * @param  scoreAction  ScoreAction
   */
  public void addNodeScoreAction(ScoreAction scoreAction) {
    scoreAction.getScoreNodes().add(this);
    this.nodeScoreActions.add(scoreAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addNodeTransactionAction.
   *
   * @param  transactionAction  TransactionAction
   */
  public void addNodeTransactionAction(TransactionAction transactionAction) {
    transactionAction.getTransNodes().add(this);
    this.nodeTransactionActions.add(transactionAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * beforeExecute.
   */
  @Override public void beforeExecute() { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * calculateBizHash.
   *
   * @return  int
   */
  public int calculateBizHash() {
    int result = 37;
    result      = (31 * result) + ((criteria != null) ? criteria.hashCode() : 0);
    result      = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result      = (31 * result) + ((exclusiveChild != null) ? exclusiveChild.hashCode() : 0);
    result      = (31 * result) + ((leftOver != null) ? leftOver.hashCode() : 0);
    result      = (31 * result) + ((name != null) ? name.hashCode() : 0);
    bizHashCode = result;

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyChildNodes.
   *
   * @param  node      Node
   * @param  user      User
   * @param  foldNode  Node
   */
  public void copyChildNodes(Node node, User user, Node foldNode) {
// verify child nodes
    if (!node.equals(parentNode)) {
      for (Node childNode : node.getChildNodes()) {
        if ((node.getAsSub() != null) && (node.getAsSub() == true)) {
          foldNode = this;
        }

        Node newChildNode = childNode.duplicateWithAllChild(user, foldNode, null);

// if(foldNode != null){
// newChildNode.setFoldNode(foldNode);
// } else{
// newChildNode.setFoldNode(this);
// }
        Set<Node> selfUnLefts = new LinkedHashSet<Node>();

        if ((this.getId() != null) && (childNode.getId() != null) && (this.getId().equals(childNode.getId()))) {
          for (Node tempNode : node.getChildNodes()) {
            for (Node newNode : newChildNode.getChildNodes()) {
              // if (newNode.getName().equals(tempNode.getName()) && (tempNode.getLeftOver() != true)
              // && (newNode.getLeftOver() != true)) {
              if ((tempNode.getLeftOver() != true) && (newNode.getLeftOver() != true)) {
                selfUnLefts.add(newNode);
                // newChildNode.getChildNodes().remove(newNode);
              }
            }
          }
        }

        newChildNode.getChildNodes().removeAll(selfUnLefts);
        this.addChildNode(newChildNode, false);
      } // end for
    }   // end if

  } // end method copyChildNodes

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyNodeActions.
   *
   * @param  node  Node
   * @param  user  User
   */
  public void copyNodeActions(Node node, User user) {
    for (QueueAction queueAction : node.getNodeQueueActions()) {
      this.addNodeQueueAction(queueAction);
    }

    for (ReQueueAction requeueAction : node.getNodeReQueueActions()) {
      this.addNodeReQueueAction(requeueAction);
    }

    for (ProgramAction programAction : node.getNodeProgramActions()) {
      this.addNodeProgramAction(programAction);
    }

    for (ChannelAction channelAction : node.getNodeChannelActions()) {
      this.addNodeChannelAction(channelAction);
    }

    for (AgencyAssignmentAction agencyAssignmentAction : node.getNodeAgencyActions()) {
      this.addNodeAgencyAction(agencyAssignmentAction);
    }

    for (AgentAssignmentAction agentAssignmentAction : node.getNodeAgentActions()) {
      this.addNodeAgentAction(agentAssignmentAction);
    }

    for (NodeUpdateAction updateAction : node.getUpdateActions()) {
      NodeUpdateAction newUpdateAction = updateAction.duplicate();
      newUpdateAction.setNode(this);
      this.getUpdateActions().add(newUpdateAction);
    }

    for (TransactionAction transAction : node.getNodeTransactionActions()) {
      this.addNodeTransactionAction(transAction);
    }

    for (BureauImportAction bureauImportAction : node.getNodeBureauImportActions()) {
      this.addNodeBureauImportAction(bureauImportAction);
    }

    for (DataExportAction dataExportAction : node.getNodeDataExportActions()) {
      this.addNodeDataExportAction(dataExportAction);
    }

    this.recallAction = node.getRecallAction();
  } // end method copyNodeActions

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom   Node
   * @param  infoOnly   boolean
   * @param  childOnly  boolean
   * @param  user       User
   */
  public void deepCopy(Node copyFrom, boolean infoOnly, boolean childOnly, User user) {
    if (!childOnly) {
      updateNode(copyFrom, user);

      if (!infoOnly) {
        copyNodeActions(copyFrom, user);
      }
    }

    for (Node childNode : copyFrom.getChildNodes()) {
      Node newChild = new Node();
      newChild.deepCopy(childNode, infoOnly, false, user);
      addChildNode(newChild, false);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepPreviewCopy.
   *
   * @param   copyFrom   Node
   * @param   infoOnly   boolean
   * @param   childOnly  boolean
   * @param   user       User
   * @param   priority   Integer
   *
   * @return  Integer
   */
  public Integer deepPreviewCopy(Node copyFrom, boolean infoOnly, boolean childOnly, User user, Integer priority) {
    if (!childOnly) {
      updateNode(copyFrom, user);

      if (!infoOnly) {
        copyNodeActions(copyFrom, user);
      }
    }

    this.setPriority(priority);

    for (Node childNode : copyFrom.getChildNodes()) {
      ++priority;

      Node newChild = new Node();
      priority = newChild.deepPreviewCopy(childNode, infoOnly, false, user, priority);
      addChildNode(newChild, false);
    }

    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @param   user  User
   *
   * @return  Node
   */
  public Node duplicate(User user) {
    Node newNode = new Node();
    newNode.updateNodeForDuplicate(this, user);
    newNode.copyNodeActions(this, user);

    return newNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicateWithAllChild.
   *
   * @param   user        User
   * @param   foldNode    Node
   * @param   parentNode  Node
   *
   * @return  Node
   */
  public Node duplicateWithAllChild(User user, Node foldNode, Node parentNode) {
    Node newNode = new Node();
    newNode.setCreator(user);
    newNode.updateNodeForDuplicate(this, user);
    newNode.copyNodeActions(this, user);

    if (foldNode != null) {
      newNode.setFoldNode(foldNode);
    }

    if (log.isDebugEnabled()) {
      log.debug("Do not repeat copy child nodes to destination node.");
    }

    if ((parentNode == null) || !this.equals(parentNode)) {
      newNode.copyChildNodes(this, user, foldNode);
    }


    return newNode;
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

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    Node node = (Node) o;

    if ((copyFromId != null) ? (!copyFromId.equals(node.copyFromId)) : (node.copyFromId != null)) {
      return false;
    }

    if ((criteria != null) ? (!criteria.equals(node.criteria)) : (node.criteria != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(node.description)) : (node.description != null)) {
      return false;
    }

    if ((exclusiveChild != null) ? (!exclusiveChild.equals(node.exclusiveChild)) : (node.exclusiveChild != null)) {
      return false;
    }

    if ((leftOver != null) ? (!leftOver.equals(node.leftOver)) : (node.leftOver != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(node.name)) : (node.name != null)) {
      return false;
    }

    if ((parentNode != null) ? (!parentNode.equals(node.parentNode)) : (node.parentNode != null)) {
      return false;
    }

    if ((strategy != null) ? (!strategy.equals(node.strategy)) : (node.strategy != null)) {
      return false;
    }

    if ((priority != null) ? (!priority.equals(node.priority)) : (node.priority != null)) {
      return false;
    }

    if ((valid != null) ? (!valid.equals(node.valid)) : (node.valid != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Evaluate Account.
   *
   * @param   helper  eval helper
   *
   * @return  evaluate result, return true if criteria express is true
   */
  @Override public boolean evaluate(EvaluateHelper helper) {
    if (helper == null) {
      return false;
    }

    // record processes count
    // increaseNodeProcessCount();

    if (Boolean.TRUE.equals(leftOver)) {
      evaluateResult = (parentNode.exclusiveChild || parentNode.fallIntoLeftOver());

      // evaluateResult = (!(Boolean.FALSE.equals(strategy.getExclusiveChild())) || parentNode.fallIntoLeftOver());
    } else {
      evaluateResult = Boolean.TRUE.equals(helper.evaluate(this));
    }

    if (evaluateResult) {
      // record trigger count
      // increaseNodeTriggerCount();

      Boolean exclusive = this.getExclusiveChild();
      // Boolean exclusive = strategy.getExclusiveChild();

      for (Node childNode : childNodes) {
        if ((childNode.evaluate(helper))
              && (Boolean.TRUE.equals(exclusive))) {
          break;
        }
      }
    }

    return evaluateResult;
  } // end method evaluate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * execute.
   *
   * @param  evaluateHelper  EvaluateHelper
   * @param  executeHelper   ExecuteHelper
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) {
    this.triggered = false;

    if (this.evaluateResult) {
      for (ChannelAction action : this.nodeChannelActions) {
        String runType = action.getRunType();
        action.setTriggeredNode(this);

        if ((runType == null) || runType.isEmpty()
              || runType.equalsIgnoreCase("all")
              || runType.equalsIgnoreCase((String) executeHelper.getParameters().get(
                  "runType"))) {
          // only run action if the run type is matched
          Integer runLevel = (Integer) executeHelper.getParameters().get("runLevel");

          if ((runLevel != null) && (runLevel.intValue() == 3)) {
            continue;
          }

          action.execute(evaluateHelper, executeHelper);

          if (Boolean.TRUE.equals(action.getTriggered())) {
            this.triggered = true;
          }
        }
      } // end for

      // As the Payment Sub-Context, the node only allow the "Channel Action"
      if(strategy.getContext().equalsIgnoreCase("Payment")
          &&  ((RunType) evaluateHelper.getParameters().get("runType")).isEvent()){
        // trigger the children
        Boolean exclusive = this.getExclusiveChild();
        // Boolean exclusive = strategy.getExclusiveChild();

        for (Node childNode : childNodes) {
          if (childNode.isEvaluateResult()) {
            childNode.execute(evaluateHelper, executeHelper);

            if (Boolean.TRUE.equals(exclusive)) {
              // exclusive mode, break once triggered
              break;
            }
          }
        }

        return;
      }


      for (QueueAction action : this.nodeQueueActions) {
        String runType = action.getRunType();

        if ((executeHelper.getParameters() != null)
              && ((runType == null) || runType.isEmpty()
                || runType.equalsIgnoreCase("all")
                || runType.equalsIgnoreCase((String) executeHelper.getParameters().get(
                    "runType")))) {
          // only run action if the run type is matched
          Integer runLevel = (Integer) executeHelper.getParameters().get("runLevel");

          if ((runLevel != null) && (runLevel.intValue() == 3)) {
            continue;
          }

          action.execute(evaluateHelper, executeHelper);

          if (Boolean.TRUE.equals(action.getTriggered())) {
            this.triggered = true;
          }
        }
      } // end for

      for (PersonaAction action : this.nodePersonaActions) {
        String runType = action.getRunType();

        if ((runType == null) || runType.isEmpty()
              || runType.equalsIgnoreCase("all")
              || runType.equalsIgnoreCase((String) executeHelper.getParameters().get(
                  "runType"))) {
          // only run action if the run type is matched
          Integer runLevel = (Integer) executeHelper.getParameters().get("runLevel");

          if ((runLevel != null) && (runLevel.intValue() == 3)) {
            continue;
          }

          action.execute(evaluateHelper, executeHelper);

          if (Boolean.TRUE.equals(action.getTriggered())) {
            this.triggered = true;
          }
        }
      } // end for

      for (ScoreAction action : this.nodeScoreActions) {
        String runType = action.getRunType();

        if ((runType == null) || runType.isEmpty()
              || runType.equalsIgnoreCase("all")
              || runType.equalsIgnoreCase((String) executeHelper.getParameters().get(
                  "runType"))) {
          // only run action if the run type is matched
          Integer runLevel = (Integer) executeHelper.getParameters().get("runLevel");

          if ((runLevel != null) && (runLevel.intValue() == 3)) {
            continue;
          }

          action.execute(evaluateHelper, executeHelper);

          if (Boolean.TRUE.equals(action.getTriggered())) {
            this.triggered = true;
          }
        }
      } // end for


      for (ProgramAction action : this.nodeProgramActions) {
        String runType = action.getRunType();

        if ((runType == null) || runType.isEmpty()
              || runType.equalsIgnoreCase("all")
              || runType.equalsIgnoreCase((String) executeHelper.getParameters().get(
                  "runType"))) {
          // only run action if the run type is matched
          Integer runLevel = (Integer) executeHelper.getParameters().get("runLevel");

          action.execute(evaluateHelper, executeHelper);

          if (Boolean.TRUE.equals(action.getTriggered())) {
            this.triggered = true;
          }
        }
      } // end for

      for (AgencyAssignmentAction action : this.getNodeAgencyActions()) {
        String runType = action.getRunType();

        if ((runType == null) || runType.isEmpty()
              || runType.equalsIgnoreCase("all")
              || runType.equalsIgnoreCase((String) executeHelper.getParameters().get(
                  "runType"))) {
          // only run action if the run type is matched
          Integer runLevel = (Integer) executeHelper.getParameters().get("runLevel");

          action.execute(evaluateHelper, executeHelper);

          if (Boolean.TRUE.equals(action.getTriggered())) {
            this.triggered = true;
          }
        }
      } // end for

      for (AgentAssignmentAction action : this.getNodeAgentActions()) {
        String runType = action.getRunType();

        if ((runType == null) || runType.isEmpty()
              || runType.equalsIgnoreCase("all")
              || runType.equalsIgnoreCase((String) executeHelper.getParameters().get(
                  "runType"))) {
          // only run action if the run type is matched
          Integer runLevel = (Integer) executeHelper.getParameters().get("runLevel");

          action.execute(evaluateHelper, executeHelper);

          if (Boolean.TRUE.equals(action.getTriggered())) {
            this.triggered = true;
          }
        }
      }

      if (null != statusAction) {
        String runType = statusAction.getRunType();

        if ((evaluateHelper != null)
              && ((runType == null) || runType.isEmpty()
                || runType.equalsIgnoreCase("all")
                || runType.equalsIgnoreCase((String) executeHelper.getParameters().get(
                    "runType")))) {
          statusAction.execute(evaluateHelper, executeHelper);

          if (Boolean.TRUE.equals(statusAction.getTriggered())) {
            this.triggered = true;
          }
        }
      }

      if (null != chargeOffAction) {
        String runType = chargeOffAction.getRunType();

        if ((runType == null) || runType.isEmpty()
              || runType.equalsIgnoreCase("all")
              || runType.equalsIgnoreCase((String) executeHelper.getParameters().get(
                  "runType"))) {
          chargeOffAction.execute(evaluateHelper, executeHelper);

          if (Boolean.TRUE.equals(chargeOffAction.getTriggered())) {
            this.triggered = true;
          }
        }
      }

      if (null != recallAction) {
        String runType = recallAction.getRunType();

        if ((runType == null) || runType.isEmpty()
              || runType.equalsIgnoreCase("all")
              || runType.equalsIgnoreCase((String) executeHelper.getParameters().get(
                  "runType"))) {
          executeHelper.setCurrentNode(this);
          recallAction.execute(evaluateHelper, executeHelper);

          if (Boolean.TRUE.equals(recallAction.getTriggered())) {
            this.triggered = true;
          }

          executeHelper.setCurrentNode(null);
        }
      }

      for (TransactionAction action : this.nodeTransactionActions) {
        String runType = action.getRunType();

        if ((runType == null) || runType.isEmpty()
              || runType.equalsIgnoreCase("all")
              || runType.equalsIgnoreCase((String) executeHelper.getParameters().get(
                  "runType"))) {
          // only run action if the run type is matched
          action.execute(evaluateHelper, executeHelper);

          if (Boolean.TRUE.equals(action.getTriggered())) {
            this.triggered = true;
          }
        }
      } // end for

      for (BureauImportAction action : this.nodeBureauImportActions) {
        String runType = action.getRunType();
        action.setTriggeredNode(this);

        if ((runType == null) || runType.isEmpty()
              || runType.equalsIgnoreCase("all")
              || runType.equalsIgnoreCase((String) executeHelper.getParameters().get(
                  "runType"))) {
          // only run action if the run type is matched
          Integer runLevel = (Integer) executeHelper.getParameters().get("runLevel");

          if ((runLevel != null) && (runLevel.intValue() == 3)) {
            continue;
          }

          action.execute(evaluateHelper, executeHelper);

          if (Boolean.TRUE.equals(action.getTriggered())) {
            this.triggered = true;
          }
        }
      }

      for (DataExportAction action : this.nodeDataExportActions) {
        String runType = action.getRunType();

        if ((runType == null) || runType.isEmpty()
              || runType.equalsIgnoreCase("all")
              || runType.equalsIgnoreCase((String) executeHelper.getParameters().get(
                  "runType"))) {
          // only run action if the run type is matched
          executeHelper.setCurrentNode(this);

          Integer runLevel = (Integer) executeHelper.getParameters().get("runLevel");

          if ((runLevel != null) && (runLevel == 3)) {
            continue;
          }

          action.execute(evaluateHelper, executeHelper);

          if (Boolean.TRUE.equals(action.getTriggered())) {
            this.triggered = true;
          }

          executeHelper.setCurrentNode(null);
        }
      } // end for

      // trigger the children
      Boolean exclusive = this.getExclusiveChild();
      // Boolean exclusive = strategy.getExclusiveChild();

      for (Node childNode : childNodes) {
        if (childNode.isEvaluateResult()) {
          childNode.execute(evaluateHelper, executeHelper);

          if (Boolean.TRUE.equals(exclusive)) {
            // exclusive mode, break once triggered
            break;
          }
        }
      }
    } // end if
  }   // end method execute

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for as sub.
   *
   * @return  Boolean
   */
  public Boolean getAsSub() {
    if (asSub == null) {
      return Boolean.FALSE;
    }

    return asSub;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for biz hash code.
   *
   * @return  Integer
   */
  public Integer getBizHashCode() {
    if (bizHashCode == null) {
      calculateBizHash();
    }

    return bizHashCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off action.
   *
   * @return  ChargeOffAction
   */
  public ChargeOffAction getChargeOffAction() {
    return chargeOffAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get all child nodes.
   *
   * @return  child nodes
   */
  public Set<Node> getChildNodes() {
    return childNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for child sub nodes.
   *
   * @return  Set
   */
  public Set<Node> getChildSubNodes() {
    return childSubNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for collapse.
   *
   * @return  Boolean
   */
  public Boolean getCollapse() {
    if (collapse == null) {
      return Boolean.FALSE;
    }

    return collapse;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for complete criteria.
   *
   * @return  String
   */
  public String getCompleteCriteria() {
    if (this.leftOver) {
      return getLeftOverCriteria(this);
    } else {
      return getNodeAndParentsCriteria(this);
    }
  } // end method getCompleteCriteria

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for complete extend criteria.
   *
   * @return  String
   */
  public String getCompleteExtendCriteria() {
    return getNodeExtendsCriteria(this);
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
   * getter method for exclusive node criteria.
   *
   * @param   node  Node
   *
   * @return  String
   */
  @Transient public String getExclusiveNodeCriteria(Node node) {
    if (node == null) {
      return "";
    }

    StringBuilder sb = new StringBuilder("");

    if (node.getParentNode() != null) {
      Set<Node> otherNodes = node.getParentNode().getChildNodes();
      boolean   appendNot  = false;

      for (Node oN : otherNodes) {
        if (oN.getPriority() < node.getPriority()) {
          if (!appendNot) {
            sb.append(" !(");
            appendNot = true;
          }

          if (oN.getCriteria() != null) {
            sb.append("(");

            if ("".equals(oN.getCriteria().trim())) {
              sb.append("true");
            } else {
              sb.append(oN.getCriteria());
            }

            sb.append(")");
          }

          sb.append(" or ");
        }

        if (oN.getPriority().equals(node.getPriority())) {
          int orIndex = sb.lastIndexOf("or");

          if (orIndex != -1) {
            sb.delete(orIndex - 1, orIndex + 3);
          }
        }
      } // end for

      if (appendNot) {
        sb.append(")");
      }
    } // end if

    return sb.toString();
  } // end method getExclusiveNodeCriteria

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fold node.
   *
   * @return  Node
   */
  public Node getFoldNode() {
    return foldNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fold strategy.
   *
   * @return  Strategy
   */
  public Strategy getFoldStrategy() {
    return foldStrategy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has action.
   *
   * @return  Boolean
   */
  public Boolean getHasAction() {
    return ((this.getNodeChannelActions().size()
          + this.getNodeProgramActions().size() + this.getNodeQueueActions().size()
          + this.getNodeScoreActions().size()) + this.getNodeAgencyActions().size()
        + this.getNodeAgentActions().size() + this.getNodeTransactionActions().size()
        + this.getNodeBureauImportActions().size() + this.getNodeDataExportActions().size()) > 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has agency action.
   *
   * @return  Boolean
   */
  public Boolean getHasAgencyAction() {
    if (this.nodeAgencyActions.size() > 0) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has agent action.
   *
   * @return  Boolean
   */
  public Boolean getHasAgentAction() {
    if (this.nodeAgentActions.size() > 0) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has bureau import action.
   *
   * @return  Boolean
   */
  public Boolean getHasBureauImportAction() {
    if (this.nodeBureauImportActions.size() > 0) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has channel action.
   *
   * @return  Boolean
   */
  public Boolean getHasChannelAction() {
    if (this.nodeChannelActions.size() > 0) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has charge off action.
   *
   * @return  Boolean
   */
  public Boolean getHasChargeOffAction() {
    if (this.chargeOffAction != null) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has child.
   *
   * @return  Boolean
   */
  public Boolean getHasChild() {
    return this.childNodes.size() > 0;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has data export action.
   *
   * @return  Boolean
   */
  public Boolean getHasDataExportAction() {
    if (this.nodeDataExportActions.size() > 0) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has persona action.
   *
   * @return  Boolean
   */
  public Boolean getHasPersonaAction() {
    if (this.nodePersonaActions.size() > 0) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has program action.
   *
   * @return  Boolean
   */
  public Boolean getHasProgramAction() {
    if (this.nodeProgramActions.size() > 0) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has queue action.
   *
   * @return  Boolean
   */
  public Boolean getHasQueueAction() {
    if (this.nodeQueueActions.size() > 0) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has recall action.
   *
   * @return  Boolean
   */
  public Boolean getHasRecallAction() {
    if (this.recallAction != null) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has re queue action.
   *
   * @return  Boolean
   */
  public Boolean getHasReQueueAction() {
    if (this.nodeReQueueActions.size() > 0) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has score action.
   *
   * @return  Boolean
   */
  public Boolean getHasScoreAction() {
    if (this.nodeScoreActions.size() > 0) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has status action.
   *
   * @return  Boolean
   */
  public Boolean getHasStatusAction() {
    if (this.statusAction != null) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has transaction action.
   *
   * @return  Boolean
   */
  public Boolean getHasTransactionAction() {
    if (this.nodeTransactionActions.size() > 0) {
      return true;
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  @Override public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for left over.
   *
   * @return  Boolean
   */
  public Boolean getLeftOver() {
    if (leftOver == null) {
      return Boolean.FALSE;
    }

    return leftOver;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for left over criteria.
   *
   * @param   node  Node
   *
   * @return  String
   */
  public String getLeftOverCriteria(Node node) {
    if (node == null) {
      return "";
    }

    // get parentNodeCompleteCriteria
    String parentCompleteCriteria = "";

    if (node.getParentNode().getLeftOver()) {
      parentCompleteCriteria = getLeftOverCriteria(node.getParentNode());
    } else {
      parentCompleteCriteria = getNodeAndParentsCriteria(node.getParentNode());
    }

    StringBuilder sb        = new StringBuilder("");
    Set<Node>     allNodes  = node.getParentNode().getChildNodes();
    boolean       appendNot = false;

    for (Node oN : allNodes) {
      if (oN.getPriority() < node.getPriority()) {
        if (!appendNot) {
          sb.append(" !(");
          appendNot = true;
        }

        if (oN.getCriteria() != null) {
          sb.append("(");

          if ("".equals(oN.getCriteria().trim())) {
            sb.append("true");
          } else {
            sb.append(oN.getCriteria());
          }

          sb.append(")");
        }

        sb.append(" or ");
      }

      if (oN.getPriority().equals(node.getPriority())) {
        int orIndex = sb.lastIndexOf("or");

        if (orIndex != -1) {
          sb.delete(orIndex - 1, orIndex + 3);
        }
      }
    } // end for

    if (appendNot) {
      sb.append(")");
    }

    if ((parentCompleteCriteria != null) && !parentCompleteCriteria.trim().equals("")) {
      return parentCompleteCriteria + " and " + sb.toString();
    } else {
      return sb.toString();
    }
  } // end method getLeftOverCriteria

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node agency actions.
   *
   * @return  Set
   */
  public Set<AgencyAssignmentAction> getNodeAgencyActions() {
    return nodeAgencyActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node agent actions.
   *
   * @return  Set
   */
  public Set<AgentAssignmentAction> getNodeAgentActions() {
    return nodeAgentActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node and parents criteria.
   *
   * @param   node  Node
   *
   * @return  String
   */
  public String getNodeAndParentsCriteria(Node node) {
    if (node == null) {
      return "";
    }

    List<String> list = new ArrayList<String>();

    do {
      String criteria = "";

      if (node.getLeftOver()) {
        criteria = node.getLeftOverCriteria(node);
      } else {
        criteria = node.getCriteria();

        if ((node.getParentNode() != null) && (node.getParentNode().getExclusiveChild() != null)
              && (node.getParentNode().getExclusiveChild() == true)) {
          String exclusiveCriteria = node.getExclusiveNodeCriteria(node);

          if (!"".equals(exclusiveCriteria.trim())) {
            criteria = exclusiveCriteria + " and " + criteria;
          }
        }
      }

      if (criteria != null) {
        criteria = criteria.trim();

        if (criteria.length() > 0) {
          if (node.leftOver) {
            list.add(0, criteria);
          } else {
            list.add(0, "(" + criteria + ")");
          }
        }
      }

      if (node.leftOver) {
        node = null;
      } else {
        node = node.getParentNode();
      }
    } while (node != null);

    StringBuilder sb = new StringBuilder();
    Iterator      it = list.iterator();

    while (it.hasNext()) {
      sb.append(it.next());

      if (it.hasNext()) {
        sb.append(" and ");
      }
    }

    return sb.toString();
  } // end method getNodeAndParentsCriteria

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node bureau import actions.
   *
   * @return  Set
   */
  public Set<BureauImportAction> getNodeBureauImportActions() {
    return nodeBureauImportActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node channel actions.
   *
   * @return  Set
   */
  public Set<ChannelAction> getNodeChannelActions() {
    return nodeChannelActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node data export actions.
   *
   * @return  Set
   */
  public Set<DataExportAction> getNodeDataExportActions() {
    return nodeDataExportActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node extends criteria.
   *
   * @param   node  Node
   *
   * @return  String
   */
  public String getNodeExtendsCriteria(Node node) {
    if (node == null) {
      return "";
    }

    List<String> list     = new ArrayList<String>();
    String       criteria = "";
    criteria = node.getParentsCriteria();

    if ((node.getParentNode() != null) && (node.getParentNode().getExclusiveChild() != null)
          && (node.getParentNode().getExclusiveChild() == true)) {
      String exclusiveCriteria = node.getExclusiveNodeCriteria(node);

      if (!"".equals(exclusiveCriteria.trim())) {
        criteria = exclusiveCriteria;
      }
    }

    if (criteria != null) {
      criteria = criteria.trim();

      if (criteria.length() > 0) {
        if (node.leftOver) {
          list.add(0, criteria);
        } else {
          list.add(0, "(" + criteria + ")");
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    Iterator      it = list.iterator();

    while (it.hasNext()) {
      sb.append(it.next());

      if (it.hasNext()) {
        sb.append(" and ");
      }
    }

    return sb.toString();
  } // end method getNodeExtendsCriteria

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node persona actions.
   *
   * @return  Set
   */
  public Set<PersonaAction> getNodePersonaActions() {
    return nodePersonaActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node program actions.
   *
   * @return  Set
   */
  public Set<ProgramAction> getNodeProgramActions() {
    return nodeProgramActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node queue actions.
   *
   * @return  Set
   */
  public Set<QueueAction> getNodeQueueActions() {
    return nodeQueueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node re queue actions.
   *
   * @return  Set
   */
  public Set<ReQueueAction> getNodeReQueueActions() {
    return nodeReQueueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node score actions.
   *
   * @return  Set
   */
  public Set<ScoreAction> getNodeScoreActions() {
    return nodeScoreActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node transaction actions.
   *
   * @return  Set
   */
  public Set<TransactionAction> getNodeTransactionActions() {
    return nodeTransactionActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Parent node.
   *
   * @return  the parant node
   */
  public Node getParentNode() {
    return parentNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for parent node id.
   *
   * @return  Long
   */
  public Long getParentNodeId() {
    return (parentNode == null) ? null : parentNode.getId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for parents criteria.
   *
   * @return  String
   */
  public String getParentsCriteria() {
    return getNodeAndParentsCriteria(this.getParentNode());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recall action.
   *
   * @return  RecallAction
   */
  public RecallAction getRecallAction() {
    return recallAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for root.
   *
   * @return  Boolean
   */
  public Boolean getRoot() {
    return (parentNode == null);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for root node.
   *
   * @return  Boolean
   */
  public Boolean getRootNode() {
    return this.parentNode == null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status action.
   *
   * @return  StatusAction
   */
  public StatusAction getStatusAction() {
    return statusAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get stratgy which this node belong to.
   *
   * @return  the strategy
   */
  @Override public Strategy getStrategy() {
    return strategy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for update actions.
   *
   * @return  Set
   */
  public Set<NodeUpdateAction> getUpdateActions() {
    return updateActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((criteria != null) ? criteria.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((exclusiveChild != null) ? exclusiveChild.hashCode() : 0);
    result = (31 * result) + ((leftOver != null) ? leftOver.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((parentNode != null) ? parentNode.hashCode() : 0);
    result = (31 * result) + ((strategy != null) ? strategy.hashCode() : 0);
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + ((valid != null) ? valid.hashCode() : 0);
    result = (31 * result) + ((copyFromId != null) ? copyFromId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasUpdateAction.
   *
   * @return  Boolean
   */
  public Boolean hasUpdateAction() {
    if (this.updateActions.size() > 0) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for biz hash equals.
   *
   * @param   other  Node
   *
   * @return  boolean
   */
  public boolean isBizHashEquals(Node other) {
    return this.getBizHashCode().equals(other.getBizHashCode());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for evaluate result.
   *
   * @return  boolean
   */
  public boolean isEvaluateResult() {
    return evaluateResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for triggered.
   *
   * @return  boolean
   */
  public boolean isTriggered() {
    return triggered;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeAllChildNode.
   */
  public void removeAllChildNode() {
    this.childNodes.clear();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeBureauImportAction.
   *
   * @param  bureauImportAction  BureauImportAction
   */
  public void removeBureauImportAction(BureauImportAction bureauImportAction) {
    if (bureauImportAction != null) {
      this.nodeBureauImportActions.remove(bureauImportAction);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeChildNode.
   *
   * @param  childNode  Node
   */
  public void removeChildNode(Node childNode) {
    if (this.childNodes.remove(childNode)) {
      childNode.setParentNode(null);
      childNode.setFoldNode(null);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeDataExportAction.
   *
   * @param  dataExportAction  DataExportAction
   */
  public void removeDataExportAction(DataExportAction dataExportAction) {
    if (dataExportAction != null) {
      this.nodeDataExportActions.remove(dataExportAction);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeNodeAgencyAction.
   *
   * @param  agencyAssignmentAction  AgencyAssignmentAction
   */
  public void removeNodeAgencyAction(AgencyAssignmentAction agencyAssignmentAction) {
    this.nodeAgencyActions.remove(agencyAssignmentAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeNodeAgentAction.
   *
   * @param  agentAssignmentAction  AgentAssignmentAction
   */
  public void removeNodeAgentAction(AgentAssignmentAction agentAssignmentAction) {
    this.nodeAgentActions.remove(agentAssignmentAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeNodeChannelAction.
   *
   * @param  channelAction  ChannelAction
   */
  public void removeNodeChannelAction(ChannelAction channelAction) {
    this.nodeChannelActions.remove(channelAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeNodeProgramAction.
   *
   * @param  programAction  ProgramAction
   */
  public void removeNodeProgramAction(ProgramAction programAction) {
    this.nodeProgramActions.remove(programAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeNodeQueueAction.
   *
   * @param  queueAction  QueueAction
   */
  public void removeNodeQueueAction(QueueAction queueAction) {
    this.nodeQueueActions.remove(queueAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeNodeReQueueAction.
   *
   * @param  reQueueAction  ReQueueAction
   */
  public void removeNodeReQueueAction(ReQueueAction reQueueAction) {
    this.nodeReQueueActions.remove(reQueueAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeNodeScoreAction.
   *
   * @param  scoreAction  ScoreAction
   */
  public void removeNodeScoreAction(ScoreAction scoreAction) {
    this.nodeScoreActions.remove(scoreAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for as sub.
   *
   * @param  asSub  Boolean
   */
  public void setAsSub(Boolean asSub) {
    this.asSub = asSub;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for biz hash code.
   *
   * @param  bizHashCode  Integer
   */
  public void setBizHashCode(Integer bizHashCode) {
    this.bizHashCode = bizHashCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off action.
   *
   * @param  chargeOffAction  ChargeOffAction
   */
  public void setChargeOffAction(ChargeOffAction chargeOffAction) {
    this.chargeOffAction = chargeOffAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for child nodes.
   *
   * @param  childNodes  Set
   */
  public void setChildNodes(Set<Node> childNodes) {
    this.childNodes = childNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for child sub nodes.
   *
   * @param  childSubNodes  Set
   */
  public void setChildSubNodes(Set<Node> childSubNodes) {
    this.childSubNodes = childSubNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for collapse.
   *
   * @param  collapse  Boolean
   */
  public void setCollapse(Boolean collapse) {
    this.collapse = collapse;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for complete criteria.
   *
   * @param  criteria  String
   */
  public void setCompleteCriteria(String criteria) { }

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
   * setter method for evaluate result.
   *
   * @param  evaluateResult  boolean
   */
  public void setEvaluateResult(boolean evaluateResult) {
    this.evaluateResult = evaluateResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fold node.
   *
   * @param  foldNode  Node
   */
  public void setFoldNode(Node foldNode) {
    this.foldNode = foldNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fold strategy.
   *
   * @param  foldStrategy  Strategy
   */
  public void setFoldStrategy(Strategy foldStrategy) {
    this.foldStrategy = foldStrategy;
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
   * setter method for left over.
   *
   * @param  leftOver  Boolean
   */
  public void setLeftOver(Boolean leftOver) {
    this.leftOver = leftOver;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node agency actions.
   *
   * @param  nodeAgencyActions  Set
   */
  public void setNodeAgencyActions(Set<AgencyAssignmentAction> nodeAgencyActions) {
    this.nodeAgencyActions = nodeAgencyActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node agent actions.
   *
   * @param  nodeAgentActions  Set
   */
  public void setNodeAgentActions(Set<AgentAssignmentAction> nodeAgentActions) {
    this.nodeAgentActions = nodeAgentActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node bureau import actions.
   *
   * @param  nodeBureauImportActions  Set
   */
  public void setNodeBureauImportActions(Set<BureauImportAction> nodeBureauImportActions) {
    this.nodeBureauImportActions = nodeBureauImportActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node channel actions.
   *
   * @param  nodeChannelActions  Set
   */
  public void setNodeChannelActions(Set<ChannelAction> nodeChannelActions) {
    this.nodeChannelActions = nodeChannelActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node data export actions.
   *
   * @param  nodeDataExportActions  Set
   */
  public void setNodeDataExportActions(Set<DataExportAction> nodeDataExportActions) {
    this.nodeDataExportActions = nodeDataExportActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node persona actions.
   *
   * @param  nodePersonaActions  Set
   */
  public void setNodePersonaActions(Set<PersonaAction> nodePersonaActions) {
    this.nodePersonaActions = nodePersonaActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node program actions.
   *
   * @param  nodeProgramActions  Set
   */
  public void setNodeProgramActions(Set<ProgramAction> nodeProgramActions) {
    this.nodeProgramActions = nodeProgramActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node queue actions.
   *
   * @param  nodeQueueActions  Set
   */
  public void setNodeQueueActions(Set<QueueAction> nodeQueueActions) {
    this.nodeQueueActions = nodeQueueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node re queue actions.
   *
   * @param  nodeReQueueActions  Set
   */
  public void setNodeReQueueActions(Set<ReQueueAction> nodeReQueueActions) {
    this.nodeReQueueActions = nodeReQueueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node score actions.
   *
   * @param  nodeScoreActions  Set
   */
  public void setNodeScoreActions(Set<ScoreAction> nodeScoreActions) {
    this.nodeScoreActions = nodeScoreActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node transaction actions.
   *
   * @param  nodeTransactionActions  Set
   */
  public void setNodeTransactionActions(Set<TransactionAction> nodeTransactionActions) {
    this.nodeTransactionActions = nodeTransactionActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set parent node.
   *
   * @param  parentNode  to set
   */
  public void setParentNode(Node parentNode) {
    this.parentNode = parentNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for parent node id.
   *
   * @param  parentNodeId  Long
   */
  public void setParentNodeId(Long parentNodeId) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recall action.
   *
   * @param  recallAction  RecallAction
   */
  public void setRecallAction(RecallAction recallAction) {
    this.recallAction = recallAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status action.
   *
   * @param  statusAction  StatusAction
   */
  public void setStatusAction(StatusAction statusAction) {
    this.statusAction = statusAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for strategy.
   *
   * @param  strategy  Strategy
   */
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for triggered.
   *
   * @param  triggered  boolean
   */
  public void setTriggered(boolean triggered) {
    this.triggered = triggered;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for update actions.
   *
   * @param  updateActions  Set
   */
  public void setUpdateActions(Set<NodeUpdateAction> updateActions) {
    this.updateActions = updateActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Node");
    sb.append("{id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", description='").append(description).append('\'');
    sb.append(", criteria='").append(criteria).append('\'');
    sb.append(", priority=").append(priority);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update node based on passed in template Only update schedule it self but not the related rules.
   *
   * @param  node  to use for update
   * @param  user  User
   */
  public void updateNode(Node node, User user) {
    this.name        = node.getName();
    this.description = node.getDescription();
    this.valid       = node.getValid();

    if (this.copyFromId == null) { // avoid change the copyFromId when update node self.
      this.copyFromId = node.getId();
    }

    this.leftOver = node.getLeftOver();

    if (!Boolean.TRUE.equals(this.leftOver)) {
      // left over node could not update criteria and priority
      this.criteria = node.getCriteria();
      this.priority = node.getPriority();
    } else {
      this.priority = Integer.MAX_VALUE;
    }

    this.exclusiveChild = node.getExclusiveChild();

    if (this.creator == null) {
      this.creator = user;
    } else {
      this.lastUpdateDate = new Date();
      setLastUpdater(user);
    }
  } // end method updateNode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateNodeForDuplicate.
   *
   * @param  node  Node
   * @param  user  User
   */
  public void updateNodeForDuplicate(Node node, User user) {
    updateNode(node, user);
    this.asSub        = node.getAsSub();
    this.collapse     = node.getCollapse();
    this.foldStrategy = node.getFoldStrategy();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Verify.
   *
   * @param  helper  for verify
   */
  @Override public void verify(EvaluateHelper helper) {
    if (helper == null) {
      return;
    }

    helper.verify(this);

    // verify child nodes
    for (Node childNode : childNodes) {
      helper.evaluate(childNode);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hasLeftOver.
   *
   * @return  boolean
   */
  protected boolean hasLeftOver() {
    for (Node childNode : childNodes) {
      if (Boolean.TRUE.equals(childNode.getLeftOver())) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private boolean fallIntoLeftOver() {
    for (Node childNode : this.getChildNodes()) {
      if (Boolean.FALSE.equals(childNode.leftOver) && Boolean.TRUE.equals(childNode.evaluateResult)) {
        return false;
      }
    }

    return true;
  }
} // end class Node
