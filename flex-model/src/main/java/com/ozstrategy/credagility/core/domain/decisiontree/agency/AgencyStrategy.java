package com.ozstrategy.credagility.core.domain.decisiontree.agency;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.*;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store AgencyStrategy information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 17:29
 */
@Entity public class AgencyStrategy extends BaseStrategy implements Serializable, Evaluable, Executable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  public static final Map<String, Integer> types = new HashMap<String, Integer>();

  static {
    types.put("General", 1);
    types.put("Event", 2);
  }

  private static final long serialVersionUID = 6504032443531151913L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Trigger flag for strategy. */
  @Transient protected boolean evaluateResult = false;

  /** Strategy . */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "foldStrategy",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("level asc, priority asc ")
  protected Set<AgencyNode> foldSubNodes = new LinkedHashSet<AgencyNode>();

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(length = 32)
  @Enumerated(value = EnumType.STRING)
  protected LayoutType layoutType = LayoutType.COMPACT_TREE;

  /** Strategy . */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "strategy",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("level asc, priority asc ")
  protected Set<AgencyNode> nodes = new LinkedHashSet<AgencyNode>();


  /** Strategy root node. */
  @JoinColumn(
    name       = "rootNodeId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected AgencyNode rootNode = null;

  /** schedule. */
  @JoinColumn(
    name       = "scheduleId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencySchedule schedule = new AgencySchedule();


  /** TODO: DOCUMENT ME! */
  @Transient protected String scoreTypeName;


  /** TODO: DOCUMENT ME! */
  @Transient protected boolean skippedExecution = false;


  /** TODO: DOCUMENT ME! */
  @Transient protected int totalActions = 0;


  /** TODO: DOCUMENT ME! */
  @Transient protected int totalNodes = 0;


  /** TODO: DOCUMENT ME! */
  @Transient protected boolean triggered = false;

  /** Define the type for Strategy,such as ScoreCard, Events. */
  @Transient protected Integer typeIndex;

  @Column(nullable = true)
  private Long copyFromId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addChildNodeWithParent.
   *
   * @param  node  AgencyNode
   */
  public void addChildNodeWithParent(AgencyNode node) {
    node.setStrategy(this);

    // add to parent node also
    AgencyNode parentNode = node.getParentNode();

    if (parentNode != null) {
      parentNode = findNode(parentNode);
      parentNode.addChildNode(node, true);
    } else {
      // no parent, this is a root node
      setRootNode(node);
      this.nodes.add(node);
    }

    for (AgencyNode childNode : node.getChildNodes()) {
      addNode(childNode);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addFoldNodeFromOtherStrategy.
   *
   * @param  node  AgencyNode
   */
  public void addFoldNodeFromOtherStrategy(AgencyNode node) {
    if (node.getFoldStrategy() != null) {
      node.setFoldStrategy(this);
      this.foldSubNodes.add(node);

      for (AgencyNode childNode : node.getChildNodes()) {
        addFoldNodeFromOtherStrategy(childNode);
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addNode.
   *
   * @param  node  AgencyNode
   */
  public void addNode(AgencyNode node) {
    node.setStrategy(this);
    this.nodes.add(node);

    for (AgencyNode childNode : node.getChildNodes()) {
      addNode(childNode);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * beforeExecute.
   */
  @Override public void beforeExecute() {
    this.triggered = false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * calculateBizHash.
   */
  public void calculateBizHash() {
    for (AgencyNode node : nodes) {
      node.calculateBizHash();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * checkOnlyGraphDataChange.
   *
   * @param  dbStrategy  AgencyStrategy
   */
  public void checkOnlyGraphDataChange(AgencyStrategy dbStrategy) {
    Boolean only = true;

    if ((name != null) ? (!name.equals(dbStrategy.name)) : (dbStrategy.name != null)) {
      only = false;
    }

    if ((description != null) ? (!description.equals(dbStrategy.description)) : (dbStrategy.description != null)) {
      only = false;
    }

    if ((priority != null) ? (!priority.equals(dbStrategy.priority)) : (dbStrategy.priority != null)) {
      only = false;
    }

    this.onlyGraphDataChange = only;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyAllNodes.
   *
   * @param  copyFrom  AgencyStrategy
   * @param  user      User
   */
  public void copyAllNodes(AgencyStrategy copyFrom, User user) {
    AgencyNode rootNode = copyFrom.getRootNode().duplicateWithAllChild(user, null);
    setRootNode(rootNode);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  AgencyStrategy
   * @param  infoOnly  boolean
   * @param  user      User
   */
  public void deepCopy(AgencyStrategy copyFrom, boolean infoOnly, User user) {
    setDescription(copyFrom.getDescription());
    setName(copyFrom.getName());
    setCopyFromId(copyFrom.getId());
    setPriority(copyFrom.getPriority());
    setUserData1(copyFrom.getUserData1());
    setType(copyFrom.getType());
    setExclusiveChild(copyFrom.getExclusiveChild());
    setEvent(copyFrom.getEvent());
    setEventId(copyFrom.getEventId());
    setScoreTypeId(copyFrom.getScoreTypeId());
    setContext(copyFrom.getContext());
    setStrategyRunType(copyFrom.getStrategyRunType());
    setStrategyRunTypeId(copyFrom.getStrategyRunTypeId());
    // setEventType(copyFrom.getEventType());

    AgencyNode rootNode = new AgencyNode();
    addNode(rootNode);
    setRootNode(rootNode);

    rootNode.deepCopy(copyFrom.getRootNode(), infoOnly, false, user);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepPreviewCopy.
   *
   * @param  copyFrom  AgencyStrategy
   * @param  infoOnly  boolean
   * @param  user      User
   */
  public void deepPreviewCopy(AgencyStrategy copyFrom, boolean infoOnly, User user) {
    setDescription(copyFrom.getDescription());
    setName(copyFrom.getName());
    setCopyFromId(copyFrom.getId());
    setPriority(copyFrom.getPriority());
    setUserData1(copyFrom.getUserData1());
    setType(copyFrom.getType());
    setExclusiveChild(copyFrom.getExclusiveChild());
    setEvent(copyFrom.getEvent());
    setEventId(copyFrom.getEventId());
    setScoreTypeId(copyFrom.getScoreTypeId());
    setContext(copyFrom.getContext());
    setStrategyRunType(copyFrom.getStrategyRunType());
    setStrategyRunTypeId(copyFrom.getStrategyRunTypeId());
    // setEventType(copyFrom.getEventType());

    AgencyNode rootNode = new AgencyNode();
    addNode(rootNode);
    setRootNode(rootNode);

    rootNode.deepPreviewCopy(copyFrom.getRootNode(), infoOnly, false, user, 1);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicate.
   *
   * @param   user  User
   *
   * @return  AgencyStrategy
   */
  public AgencyStrategy duplicate(User user) {
    AgencyStrategy newCopy = new AgencyStrategy();

    newCopy.setDescription(description);
    newCopy.setName(name);
    newCopy.setPriority(priority);
    newCopy.setSchedule(schedule);
    newCopy.setUserData1(userData1);
    newCopy.setContext(context);
    newCopy.setCreator(user);
    newCopy.setStrategyRunType(strategyRunType);

    AgencyNode rootNode = this.rootNode.duplicateWithAllChild(user, null);
    newCopy.setRootNode(rootNode);

    return newCopy;
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

    AgencyStrategy strategy = (AgencyStrategy) o;

    if ((name != null) ? (!name.equals(strategy.name)) : (strategy.name != null)) {
      return false;
    }

    if ((description != null) ? (!description.equals(strategy.description)) : (strategy.description != null)) {
      return false;
    }

    if ((scoreCard != null) ? (!scoreCard.equals(strategy.scoreCard)) : (strategy.scoreCard != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * evaluate.
   *
   * @param   helper  EvaluateHelper
   *
   * @return  boolean
   */
  @Override public boolean evaluate(EvaluateHelper helper) {
    if (helper == null) {
      return false;
    }

    // clear all node's results first
    for (AgencyNode node : this.getNodes()) {
      node.setEvaluateResult(false);
    }

    evaluateResult = this.rootNode.evaluate(helper);

    return evaluateResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * execute.
   *
   * @param  evaluateHelper  EvaluateHelper
   * @param  executeHelper   ExecuteHelper
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) {
    // To change body of implemented methods use File | Settings | File
    // Templates.
    triggered = false;

    if (this.skippedExecution == false) {
      this.rootNode.execute(evaluateHelper, executeHelper);

      for (AgencyNode node : nodes) {
        if (node.isTriggered()) {
          triggered = true;

          break;
        }
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * findNode.
   *
   * @param   node  AgencyNode
   *
   * @return  AgencyNode
   */
  public AgencyNode findNode(AgencyNode node) {
    if (node == null) {
      return null;
    }

    // find node by id first,
    // PLEASE NOTE: 0 would be considered no id
    Long nodeId = node.getId();

    if ((nodeId != null) && (nodeId.longValue() != 0L)) {
      // lookup through id
      for (AgencyNode curNode : this.nodes) {
        if (curNode.getId().equals(nodeId)) {
          return curNode;
        }
      }

      return null;
    } else {
      // lookup through equal
      Iterator<AgencyNode> it = this.nodes.iterator();

      while (it.hasNext()) {
        AgencyNode ret = it.next();

        if (ret.equals(node)) {
          return ret;
        }
      }

    } // end if-else

    return null;
  } // end method findNode

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

  // /**
  // * Evaluate node to get list of triggered nodes.
  // *
  // * @param domain account to evaluate
  // * @return triggered nodes
  // */
  // public Set<Node> execute(BaseDomain domain) {
  // return execute(domain, true);
  // }
  //
  // /**
  // * Evaluate node to get list of triggered nodes.
  // *
  // * @param domain       account to be evaluate
  // * @param evaluateOnly only evaluate without trigger action
  // * @return triggered nodes
  // */
  // public Set<Node> execute(BaseDomain domain, boolean evaluateOnly) {
  // Set<Node> triggered = new LinkedHashSet<Node>();
  //
  // // evaluate from root node
  // getRootNode().execute(domain);
  //
  // for (Node node : nodes) {
  // if (node.isTriggered) {
  // triggered.add(node);
  // if (!evaluateOnly) {
  // // trigger all node actions
  // for (BaseNodeAction action : node.getBaseNodeActions()) {
  // action.execute(domain);
  // }
  // }
  // }
  // }
  //
  // return triggered;
  // }

  // public EventType getEventType() {
  // return eventType;
  // }

  // @RemoteProperty
  // public Long getEventTypeId() {
  // return eventTypeId;
  // }


  /**
   * getter method for fold sub node ids.
   *
   * @return  List
   */
  public List<Long> getFoldSubNodeIds() {
    List<Long> ids = new ArrayList<Long>();

    if ((this.foldSubNodes != null) && (this.foldSubNodes.size() > 0)) {
      for (AgencyNode n : this.foldSubNodes) {
        ids.add(n.getId());
      }
    }

    return ids;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fold sub nodes.
   *
   * @return  Set
   */
  public Set<AgencyNode> getFoldSubNodes() {
    return foldSubNodes;
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
   * getter method for layout.
   *
   * @return  String
   */
  public String getLayout() {
    return layoutType.name();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for layout type.
   *
   * @return  LayoutType
   */
  public LayoutType getLayoutType() {
    return layoutType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node map.
   *
   * @return  Map
   */
  public Map<Long, AgencyNode> getNodeMap() {
    Map<Long, AgencyNode> map = new HashMap<Long, AgencyNode>();

    for (AgencyNode node : nodes) {
      map.put(node.getId(), node);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for nodes.
   *
   * @return  Set
   */
  public Set<AgencyNode> getNodes() {
    return nodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get Root node.
   *
   * @return  root node
   */
  public AgencyNode getRootNode() {
    return rootNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for root node id.
   *
   * @return  Long
   */
  public Long getRootNodeId() {
    if (rootNode != null) {
      return rootNode.getId();
    } else {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule.
   *
   * @return  AgencySchedule
   */
  public AgencySchedule getSchedule() {
    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule id.
   *
   * @return  Long
   */
  public Long getScheduleId() {
    if (this.schedule != null) {
      return schedule.getScheduleId();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score type name.
   *
   * @return  String
   */
  public String getScoreTypeName() {
    return scoreTypeName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for strategy id.
   *
   * @return  Long
   */
  public Long getStrategyId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total nodes.
   *
   * @return  int
   */
  public int getTotalNodes() {
    totalNodes = getNodes().size();

    return totalNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type index.
   *
   * @return  Integer
   */
  public Integer getTypeIndex() {
    Integer v = AgencyStrategy.types.get(this.type);

    if (v != null) {
      return v;
    }

    return new Integer(3);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for valid context.
   *
   * @return  String
   */
  public String getValidContext() {
    if (StringUtils.hasText(context)) {
      return context;
    }

    return "responsible";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((scoreCard != null) ? scoreCard.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * init.
   */
  public void init() {
    rootNode = new AgencyNode();

    rootNode.setName((this.getEvent() == null) ? "Root" : this.getEvent().getEventName());

    rootNode.setCreator(creator);

    addNode(rootNode);
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
   * getter method for skipped execution.
   *
   * @return  boolean
   */
  public boolean isSkippedExecution() {
    return skippedExecution;
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
   * Remove node from strategy.
   *
   * @param   node       AgencyNode
   * @param   childOnly  boolean
   *
   * @return  AgencyNode
   */
  public AgencyNode removeNode(AgencyNode node, boolean childOnly) {
    if (childOnly) {
      // remove all child node from strategy
      for (AgencyNode childNode : node.getChildNodes()) {
// childNode.removeNodeActions();
        this.nodes.remove(childNode);
        childNode.setFoldStrategy(null);
        childNode.setStrategy(null);
      }

      node.removeAllChildNode();
      node.setAsSub(false);
    } else {
      // remove this node from parent
      AgencyNode parentNode = node.getParentNode();
      parentNode.removeChildNode(node);

      if (parentNode.getChildNodes().size() == 0) {
        parentNode.setAsSub(false);
      }

      // remove this node from strategy
// node.removeNodeActions();
      this.nodes.remove(node);
      node.setFoldStrategy(null);
      node.setStrategy(null);
    } // end if-else

    return node;
  } // end method removeNode

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
   * setter method for fold sub nodes.
   *
   * @param  foldSubNodes  Set
   */
  public void setFoldSubNodes(Set<AgencyNode> foldSubNodes) {
    this.foldSubNodes = foldSubNodes;
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
   * setter method for layout.
   *
   * @param  layout  String
   */
  public void setLayout(String layout) {
    this.layoutType = LayoutType.toLayoutType(layout);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for layout type.
   *
   * @param  layoutType  LayoutType
   */
  public void setLayoutType(LayoutType layoutType) {
    this.layoutType = layoutType;

    if (layoutType == null) {
      this.layoutType = LayoutType.COMPACT_TREE;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for nodes.
   *
   * @param  nodes  Set
   */
  public void setNodes(Set<AgencyNode> nodes) {
    this.nodes = nodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for root node.
   *
   * @param  rootNode  AgencyNode
   */
  public void setRootNode(AgencyNode rootNode) {
    this.rootNode = rootNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for root node id.
   *
   * @param  nodeId  Long
   */
  public void setRootNodeId(Long nodeId) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule.
   *
   * @param  schedule  AgencySchedule
   */
  public void setSchedule(AgencySchedule schedule) {
    this.schedule = schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score type name.
   *
   * @param  scoreTypeName  String
   */
  public void setScoreTypeName(String scoreTypeName) {
    this.scoreTypeName = scoreTypeName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for skipped execution.
   *
   * @param  skippedExecution  boolean
   */
  public void setSkippedExecution(boolean skippedExecution) {
    this.skippedExecution = skippedExecution;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for strategy id.
   *
   * @param  strategyId  Long
   */
  public void setStrategyId(Long strategyId) {
    this.id = strategyId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total actions.
   *
   * @param  totalActions  int
   */
  public void setTotalActions(int totalActions) {
    this.totalActions = totalActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total nodes.
   *
   * @param  totalNodes  int
   */
  public void setTotalNodes(int totalNodes) {
    this.totalNodes = totalNodes;
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
   * setter method for type index.
   *
   * @param  typeIndex  Integer
   */
  public void setTypeIndex(Integer typeIndex) {
    this.typeIndex = typeIndex;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("AgencyStrategy");
    sb.append("{id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", description='").append(description).append('\'');
    sb.append(", priority=").append(priority);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update strategy based on passed in template Only update schedule it self but not the related rules.
   *
   * @param   strategy  to use for update
   *
   * @return  update strategy based on passed in template Only update schedule it self but not the related rules.
   */
  public boolean updateStrategy(AgencyStrategy strategy) {
    boolean ret = false;

    if (!this.equals(strategy)) {
      ret                 = true;
      this.lastUpdateDate = new Date();
    }

    this.name        = strategy.getName();
    this.description = strategy.getDescription();
    this.type        = strategy.getType();
    this.priority    = strategy.getPriority();
    this.context     = strategy.getContext();

    if (this.event != null) {
      this.rootNode.setName(this.event.getEventName());
    }

    if ((strategy.getStrategyRunTypeId() != null) && (strategy.getStrategyRunTypeId() != 0)) {
      StrategyRunType strategyRunType = new StrategyRunType();
      strategyRunType.setId(strategy.getStrategyRunTypeId());
      this.strategyRunType = strategyRunType;
    } else {
      this.strategyRunType = strategy.getStrategyRunType();
    }

    return ret;
  } // end method updateStrategy

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

    this.rootNode.verify(helper);
  }
} // end class AgencyStrategy
