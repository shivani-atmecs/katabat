package com.ozstrategy.credagility.core.domain.decisiontree.businesscontext;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.*;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store BCStrategy information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 11:13
 */
@Entity public class BCStrategy extends BaseStrategy implements Evaluable, Executable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  public static final Map<String, Integer> types = new HashMap<String, Integer>();

  static {
    types.put("General", 1);
    types.put("Event", 2);

    types.put("ScoreCard", 3);
  }

  private static final long serialVersionUID = -8914663886705503271L;

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
  protected Set<BCNode> foldSubNodes = new LinkedHashSet<BCNode>();

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
  protected Set<BCNode> nodes = new LinkedHashSet<BCNode>();


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
  protected BCNode rootNode = null;

  /** schedule. */
  @JoinColumn(
    name       = "scheduleId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCSchedule schedule = new BCSchedule();


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
   * @param  node  BCNode
   */
  public void addChildNodeWithParent(BCNode node) {
    node.setStrategy(this);

    // add to parent node also
    BCNode parentNode = node.getParentNode();

    if (parentNode != null) {
      parentNode = findNode(parentNode);
      parentNode.addChildNode(node, true);
    } else {
      // no parent, this is a root node
      setRootNode(node);
      this.nodes.add(node);
    }

    for (BCNode childNode : node.getChildNodes()) {
      addNode(childNode);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addFoldNodeFromOtherStrategy.
   *
   * @param  node  BCNode
   */
  public void addFoldNodeFromOtherStrategy(BCNode node) {
    if (node.getFoldStrategy() != null) {
      node.setFoldStrategy(this);
      this.foldSubNodes.add(node);

      for (BCNode childNode : node.getChildNodes()) {
        addFoldNodeFromOtherStrategy(childNode);
      }
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addNode.
   *
   * @param  node  BCNode
   */
  public void addNode(BCNode node) {
    node.setStrategy(this);
    this.nodes.add(node);

    for (BCNode childNode : node.getChildNodes()) {
      addNode(childNode);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.Executable#beforeExecute()
   */
  @Override public void beforeExecute() {
    this.triggered = false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * calculateBizHash.
   */
  public void calculateBizHash() {
    for (BCNode node : nodes) {
      node.calculateBizHash();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * checkOnlyGraphDataChange.
   *
   * @param  dbStrategy  BCStrategy
   */
  public void checkOnlyGraphDataChange(BCStrategy dbStrategy) {
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
   * @param  copyFrom  BCStrategy
   * @param  user      User
   */
  public void copyAllNodes(BCStrategy copyFrom, User user) {
    BCNode rootNode = copyFrom.getRootNode().duplicateWithAllChild(user, null);
    setRootNode(rootNode);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  BCStrategy
   * @param  infoOnly  boolean
   * @param  user      User
   */
  public void deepCopy(BCStrategy copyFrom, boolean infoOnly, User user) {
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

    BCNode rootNode = new BCNode();
    addNode(rootNode);
    setRootNode(rootNode);

    rootNode.deepCopy(copyFrom.getRootNode(), infoOnly, false, user);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepPreviewCopy.
   *
   * @param  copyFrom  BCStrategy
   * @param  infoOnly  boolean
   * @param  user      User
   */
  public void deepPreviewCopy(BCStrategy copyFrom, boolean infoOnly, User user) {
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

    BCNode rootNode = new BCNode();
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
   * @return  BCStrategy
   */
  public BCStrategy duplicate(User user) {
    BCStrategy newCopy = new BCStrategy();

    newCopy.setDescription(description);
    newCopy.setName(name);
    newCopy.setPriority(priority);
    newCopy.setSchedule(schedule);
    newCopy.setUserData1(userData1);
    newCopy.setContext(context);
    newCopy.setCreator(user);
    newCopy.setStrategyRunType(strategyRunType);

    BCNode rootNode = this.rootNode.duplicateWithAllChild(user, null);
    newCopy.setRootNode(rootNode);

    return newCopy;
  }

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

    BCStrategy strategy = (BCStrategy) o;

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
   * @see  com.ozstrategy.credagility.core.domain.Evaluable#evaluate(com.ozstrategy.credagility.core.helper.EvaluateHelper)
   */
  @Override public boolean evaluate(EvaluateHelper helper) {
    if (helper == null) {
      return false;
    }

    // clear all node's results first
    for (BCNode node : this.getNodes()) {
      node.setEvaluateResult(false);
    }

    evaluateResult = this.rootNode.evaluate(helper);

    return evaluateResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.Executable#execute(com.ozstrategy.credagility.core.helper.EvaluateHelper, com.ozstrategy.credagility.core.helper.ExecuteHelper)
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) {
    // To change body of implemented methods use File | Settings | File
    // Templates.
    triggered = false;

    if (this.skippedExecution == false) {
      this.rootNode.execute(evaluateHelper, executeHelper);

      for (BCNode node : nodes) {
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
   * @param   node  BCNode
   *
   * @return  BCNode
   */
  public BCNode findNode(BCNode node) {
    if (node == null) {
      return null;
    }

    // find node by id first,
    // PLEASE NOTE: 0 would be considered no id
    Long nodeId = node.getId();

    if ((nodeId != null) && (nodeId.longValue() != 0L)) {
      // lookup through id
      for (BCNode curNode : this.nodes) {
        if (curNode.getId().equals(nodeId)) {
          return curNode;
        }
      }

      return null;
    } else {
      // lookup through equal
      Iterator<BCNode> it = this.nodes.iterator();

      while (it.hasNext()) {
        BCNode ret = it.next();

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

  /**
   * getter method for fold sub node ids.
   *
   * @return  List
   */
  public List<Long> getFoldSubNodeIds() {
    List<Long> ids = new ArrayList<Long>();

    if ((this.foldSubNodes != null) && (this.foldSubNodes.size() > 0)) {
      for (BCNode n : this.foldSubNodes) {
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
  public Set<BCNode> getFoldSubNodes() {
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
  public Map<Long, BCNode> getNodeMap() {
    Map<Long, BCNode> map = new HashMap<Long, BCNode>();

    for (BCNode node : nodes) {
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
  public Set<BCNode> getNodes() {
    return nodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get Root node.
   *
   * @return  root node
   */
  public BCNode getRootNode() {
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
   * @return  BCSchedule
   */
  public BCSchedule getSchedule() {
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
    Integer v = BCStrategy.types.get(this.type);

    if (v != null) {
      return v;
    }

    return new Integer(3);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.BaseStrategy#hashCode()
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
    rootNode = new BCNode();

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
   * removeNode.
   *
   * @param   node       BCNode
   * @param   childOnly  boolean
   *
   * @return  BCNode
   */
  public BCNode removeNode(BCNode node, boolean childOnly) {
    if (childOnly) {
      // remove all child node from strategy
      for (BCNode childNode : node.getChildNodes()) {
// childNode.removeNodeActions();
        this.nodes.remove(childNode);
        childNode.setFoldStrategy(null);
        childNode.setStrategy(null);
      }

      node.removeAllChildNode();
      node.setAsSub(false);
    } else {
      // remove this node from parent
      BCNode parentNode = node.getParentNode();
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
  public void setFoldSubNodes(Set<BCNode> foldSubNodes) {
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
  public void setNodes(Set<BCNode> nodes) {
    this.nodes = nodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for root node.
   *
   * @param  rootNode  BCNode
   */
  public void setRootNode(BCNode rootNode) {
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
   * @param  schedule  BCSchedule
   */
  public void setSchedule(BCSchedule schedule) {
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
    sb.append("BCStrategy");
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
  public boolean updateStrategy(BCStrategy strategy) {
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
} // end class BCStrategy
