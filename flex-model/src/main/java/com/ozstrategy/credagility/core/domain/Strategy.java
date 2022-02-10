package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store portfolio schedule strategy information.
 *
 * <p><a href="Strategy.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/16/2014 15:04
 */
@Entity public class Strategy extends BaseStrategy implements Evaluable, Executable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  public static final Map<String, Integer> types = new HashMap<String, Integer>();

  static {
    types.put("General", 1);
    types.put("Event", 2);

    types.put("ScoreCard", 3);
  }

  private static final long serialVersionUID = -1107574704186853432L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Trigger flag for strategy. */
  @Transient protected boolean evaluateResult = false;

  /** Strategy . */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "foldStrategy",
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("level asc, priority asc ")
  protected Set<Node> foldSubNodes = new LinkedHashSet<Node>();

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
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  @OrderBy("level asc, priority asc ")
  protected Set<Node> nodes = new LinkedHashSet<Node>();

  /** PortfolioScoreType. */
  @JoinColumn(
    name       = "portfolioScoreTypeId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioScoreType portfolioScoreType;


  /** Strategy root node. */
  @JoinColumn(
    name       = "rootNodeId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected Node rootNode = null;

  /** schedule. */
  @JoinColumn(
    name       = "scheduleId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Schedule schedule = new Schedule();


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
   * Add node to strategy.
   *
   * <p>.@param node to add</p>
   *
   * @param  node  Node
   */
  public void addChildNodeWithParent(Node node) {
    node.setStrategy(this);

    // add to parent node also
    Node parentNode = node.getParentNode();

    if (parentNode != null) {
      parentNode = findNode(parentNode);
      parentNode.addChildNode(node, true);
    } else {
      // no parent, this is a root node
      setRootNode(node);
      this.nodes.add(node);
    }

    for (Node childNode : node.getChildNodes()) {
      addNode(childNode);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addFoldNodeFromOtherStrategy.
   *
   * @param  node  Node
   */
  public void addFoldNodeFromOtherStrategy(Node node) {
    if (node.getFoldStrategy() != null) {
      node.setFoldStrategy(this);
      this.foldSubNodes.add(node);

      for (Node childNode : node.getChildNodes()) {
        addFoldNodeFromOtherStrategy(childNode);
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add node to strategy.
   *
   * <p>.@param node to add</p>
   *
   * @param  node  Node
   */
  public void addNode(Node node) {
    node.setStrategy(this);
    this.nodes.add(node);

    for (Node childNode : node.getChildNodes()) {
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
    for (Node node : nodes) {
      node.calculateBizHash();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * checkOnlyGraphDataChange.
   *
   * @param  dbStrategy  Strategy
   */
  public void checkOnlyGraphDataChange(Strategy dbStrategy) {
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
   * @param  copyFrom  Strategy
   * @param  user      User
   */
  public void copyAllNodes(Strategy copyFrom, User user) {
    Node rootNode = copyFrom.getRootNode().duplicateWithAllChild(user, null, new Node());
    setRootNode(rootNode);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  Strategy
   * @param  infoOnly  boolean
   * @param  user      User
   */
  public void deepCopy(Strategy copyFrom, boolean infoOnly, User user) {
    setDescription(copyFrom.getDescription());
    setName(copyFrom.getName());
    setCopyFromId(copyFrom.getId());
    setPriority(copyFrom.getPriority());
    setUserData1(copyFrom.getUserData1());
    setType(copyFrom.getType());
    setExclusiveChild(copyFrom.getExclusiveChild());
    setPortfolioScoreType(copyFrom.getPortfolioScoreType());
    setEvent(copyFrom.getEvent());
    setEventId(copyFrom.getEventId());
    setPortfolioScoreType(copyFrom.getPortfolioScoreType());
    setScoreTypeId(copyFrom.getScoreTypeId());
    setContext(copyFrom.getContext());
    setStrategyRunType(copyFrom.getStrategyRunType());
    setStrategyRunTypeId(copyFrom.getStrategyRunTypeId());
    // setEventType(copyFrom.getEventType());

    Node rootNode = new Node();
    addNode(rootNode);
    setRootNode(rootNode);

    rootNode.deepCopy(copyFrom.getRootNode(), infoOnly, false, user);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepPreviewCopy.
   *
   * @param  copyFrom  Strategy
   * @param  infoOnly  boolean
   * @param  user      User
   */
  public void deepPreviewCopy(Strategy copyFrom, boolean infoOnly, User user) {
    setDescription(copyFrom.getDescription());
    setName(copyFrom.getName());
    setCopyFromId(copyFrom.getId());
    setPriority(copyFrom.getPriority());
    setUserData1(copyFrom.getUserData1());
    setType(copyFrom.getType());
    setExclusiveChild(copyFrom.getExclusiveChild());
    setPortfolioScoreType(copyFrom.getPortfolioScoreType());
    setEvent(copyFrom.getEvent());
    setEventId(copyFrom.getEventId());
    setPortfolioScoreType(copyFrom.getPortfolioScoreType());
    setScoreTypeId(copyFrom.getScoreTypeId());
    setContext(copyFrom.getContext());
    setStrategyRunType(copyFrom.getStrategyRunType());
    setStrategyRunTypeId(copyFrom.getStrategyRunTypeId());
    // setEventType(copyFrom.getEventType());

    Node rootNode = new Node();
    addNode(rootNode);
    setRootNode(rootNode);

    rootNode.deepPreviewCopy(copyFrom.getRootNode(), infoOnly, false, user, 1);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Duplicate current strategy.
   *
   * @param   user  User
   *
   * @return  duplicate current strategy.
   */
  public Strategy duplicate(User user) {
    Strategy newCopy = new Strategy();

    newCopy.setDescription(description);
    newCopy.setName(name);
    newCopy.setPriority(priority);
    newCopy.setSchedule(schedule);
    newCopy.setUserData1(userData1);
    newCopy.setContext(context);
    newCopy.setCreator(user);
    newCopy.setStrategyRunType(strategyRunType);

    Node rootNode = this.rootNode.duplicateWithAllChild(user, null, new Node());
    newCopy.setRootNode(rootNode);

    return newCopy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    Strategy strategy = (Strategy) o;

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

    if (this.skippedExecution) {
      return false;
    }

    // clear all node's results first
    for (Node node : this.getNodes()) {
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

      for (Node node : nodes) {
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
   * @param   node  Node
   *
   * @return  Node
   */
  public Node findNode(Node node) {
    if (node == null) {
      return null;
    }

    // find node by id first,
    // PLEASE NOTE: 0 would be considered no id
    Long nodeId = node.getId();

    if ((nodeId != null) && (nodeId.longValue() != 0L)) {
      // lookup through id
      for (Node curNode : this.nodes) {
        if (curNode.getId().equals(nodeId)) {
          return curNode;
        }
      }

      return null;
    } else {
      // lookup through equal
      Iterator<Node> it = this.nodes.iterator();

      while (it.hasNext()) {
        Node ret = it.next();

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

  // /**
  // *
  // */
  // public EventType getEventType() {
  // return eventType;
  // }

  // /**
  // *
  // */
  //
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
      for (Node n : this.foldSubNodes) {
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
  public Set<Node> getFoldSubNodes() {
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
  public Map<Long, Node> getNodeMap() {
    Map<Long, Node> map = new HashMap<Long, Node>();

    for (Node node : nodes) {
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
  public Set<Node> getNodes() {
    return nodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio score type.
   *
   * @return  PortfolioScoreType
   */
  public PortfolioScoreType getPortfolioScoreType() {
    return portfolioScoreType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get Root node.
   *
   * @return  root node
   */
  public Node getRootNode() {
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
   * Get strategy schedule.
   *
   * <p>.@return schedule</p>
   *
   * @return  get strategy schedule.
   */
  public Schedule getSchedule() {
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
    if (this.getPortfolioScoreType() != null) {
      return this.getPortfolioScoreType().getScoreName();
    } else {
      return scoreTypeName;
    }
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
    Integer v = Strategy.types.get(this.type);

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
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((scoreCard != null) ? scoreCard.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   */
  public void init() {
    rootNode = new Node();

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
   * <p>.@param node to remove</p>
   *
   * @param   node       Node
   * @param   childOnly  boolean
   *
   * @return  remove node from strategy.
   */
  public Node removeNode(Node node, boolean childOnly) {
    if (childOnly) {
      // remove all child node from strategy
      for (Node childNode : node.getChildNodes()) {
// childNode.removeNodeActions();
        this.nodes.remove(childNode);
        childNode.setFoldStrategy(null);
        childNode.setStrategy(null);
      }

      node.removeAllChildNode();
      node.setAsSub(false);
    } else {
      // remove this node from parent
      Node parentNode = node.getParentNode();
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
   * setFoldSubNodes.
   *
   * @param  foldSubNodes  exclusiveChild eventTypeId DOCUMENT ME!
   */
  // public void setEventType(EventType eventType) {
  // this.eventType = eventType;
  // }

  // /**
  // *
  // */
  // public void setEventTypeId(Long eventTypeId) {
  // this.eventTypeId = eventTypeId;
  // }

  public void setFoldSubNodes(Set<Node> foldSubNodes) {
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
  public void setNodes(Set<Node> nodes) {
    this.nodes = nodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio score type.
   *
   * @param  portfolioScoreType  PortfolioScoreType
   */
  public void setPortfolioScoreType(PortfolioScoreType portfolioScoreType) {
    this.portfolioScoreType = portfolioScoreType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Set root node.
   *
   * @param  rootNode  root node to set
   */
  public void setRootNode(Node rootNode) {
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
   * @param  schedule  Schedule
   */
  public void setSchedule(Schedule schedule) {
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
    sb.append("Strategy");
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
  public boolean updateStrategy(Strategy strategy) {
    boolean ret = false;

    if (!this.equals(strategy)) {
      ret                 = true;
      this.lastUpdateDate = new Date();
    }

    this.name        = strategy.getName();
    this.description = strategy.getDescription();
    this.userData1   = strategy.getUserData1();
    this.zoom        = strategy.getZoom();
    this.type        = strategy.getType();
    this.layoutType  = strategy.getLayoutType();
    this.priority    = strategy.getPriority();
    this.eventId     = strategy.getEventId();
    this.scoreTypeId = strategy.getScoreTypeId();
    this.event       = strategy.getEvent();
    this.context     = strategy.getContext();

    if (this.event != null) {
      this.rootNode.setName(this.event.getEventName());
    }

    this.strategyRunType   = strategy.getStrategyRunType();
    this.strategyRunTypeId = strategy.getStrategyRunTypeId();

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
} // end class Strategy
