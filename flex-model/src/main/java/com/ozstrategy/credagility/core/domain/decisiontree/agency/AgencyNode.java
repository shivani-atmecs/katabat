package com.ozstrategy.credagility.core.domain.decisiontree.agency;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.BaseNode;
import com.ozstrategy.credagility.core.domain.Evaluable;
import com.ozstrategy.credagility.core.domain.Executable;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store AgencyNode information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 16:44
 */
@Entity public class AgencyNode extends BaseNode<AgencyStrategy> implements Serializable, Evaluable, Executable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 764195288323075768L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean asSub = false;

  /** Down linked child nodes. */
  @OneToMany(
    mappedBy      = "parentNode",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("priority asc")
  protected Set<AgencyNode> childNodes = new LinkedHashSet<AgencyNode>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    mappedBy      = "foldNode",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  @OrderBy("level asc , priority asc")
  protected Set<AgencyNode> childSubNodes = new LinkedHashSet<AgencyNode>();


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
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
  @ManyToOne protected AgencyNode foldNode;


  /** strategy. */
  @JoinColumn(
    name       = "foldStrategyId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyStrategy foldStrategy;

  /** primary key. */

  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Leftover Node. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean leftOver = false;

  /** Up linked parent node. */
  @JoinColumn(
    name       = "parentNodeId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne protected AgencyNode parentNode;

  /** strategy. */
  @JoinColumn(
    name       = "strategyId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyStrategy strategy = new AgencyStrategy();


  /** TODO: DOCUMENT ME! */
  @Transient protected boolean triggered = false;
  // private Map<Long, Long> actionTriggerCount = new HashMap<Long, Long>();

  @Column(nullable = true)
  private Integer bizHashCode = null;


  @Column(nullable = true)
  private Long copyFromId;

  /** Node channel actions. */
  @JoinTable(
    name               = "AgencyNodeChannelAction",
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
    cascade = CascadeType.ALL
  )
  private Set<AgencyChannelAction> nodeChannelActions = new LinkedHashSet<AgencyChannelAction>();


  /** Node queue actions. */
  @JoinTable(
    name               = "AgencyNodeQueueAction",
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
    cascade = CascadeType.ALL
  )
  private Set<AgencyQueueAction> nodeQueueActions = new LinkedHashSet<AgencyQueueAction>();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new Node object.
   */
  public AgencyNode() { }


  /**
   * Creates a new AgencyNode object.
   *
   * @param  id  Long
   */
  public AgencyNode(Long id) {
    this.id = id;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addChildNode.
   *
   * @param  childNode  AgencyNode
   */
  public void addChildNode(AgencyNode childNode) {
    addChildNode(childNode, true);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addChildNode.
   *
   * @param   childNode       AgencyNode
   * @param   createLeftOver  boolean
   *
   * @throws  IllegalArgumentException  exception
   */
  public void addChildNode(AgencyNode childNode, boolean createLeftOver) {
    if (childNode == null) {
      throw (new IllegalArgumentException("Null child node!"));
    }

    // create left over child node, if there is none
    if (createLeftOver && (!hasLeftOver())) {
      AgencyNode leftOver = new AgencyNode();
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

        for (AgencyNode n : childNodes) {
          if (n.leftOver) {
            hasLeft = true;

            if (childNode.getChildNodes().size() > 0) { // merge leftover childNodes

              for (AgencyNode ln : childNode.getChildNodes()) {
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
   * Add baseNodeAction to strategy.
   *
   * <p>@param baseNodeAction to add</p>
   *
   * @param  channelAction  baseNodeAction node action to add
   */
// public void addNodeAction(BaseNodeAction baseNodeAction) {
// baseNodeAction.setNode(this);
// this.baseNodeActions.add(baseNodeAction);
// }


  public void addNodeChannelAction(AgencyChannelAction channelAction) {
    channelAction.getChannelNodes().add(this);
    this.nodeChannelActions.add(channelAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addNodeQueueAction.
   *
   * @param  queueAction  AgencyQueueAction
   */
  public void addNodeQueueAction(AgencyQueueAction queueAction) {
    queueAction.getQueueNodes().add(this);
    this.nodeQueueActions.add(queueAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.Executable#beforeExecute()
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
   * @param  node      AgencyNode
   * @param  user      User
   * @param  foldNode  AgencyNode
   */
  public void copyChildNodes(AgencyNode node, User user, AgencyNode foldNode) {
    // verify child nodes
    for (AgencyNode childNode : node.getChildNodes()) {
      if ((node.getAsSub() != null) && (node.getAsSub() == true)) {
        foldNode = this;
      }

      AgencyNode newChildNode = childNode.duplicateWithAllChild(user, foldNode);

// if(foldNode != null){
// newChildNode.setFoldNode(foldNode);
// } else{
// newChildNode.setFoldNode(this);
// }
      Set<AgencyNode> selfUnLefts = new LinkedHashSet<AgencyNode>();

      if ((this.getId() != null) && (childNode.getId() != null) && (this.getId().equals(childNode.getId()))) {
        for (AgencyNode tempNode : node.getChildNodes()) {
          for (AgencyNode newNode : newChildNode.getChildNodes()) {
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
  }   // end method copyChildNodes

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * copyNodeActions.
   *
   * @param  node  AgencyNode
   * @param  user  User
   */
  public void copyNodeActions(AgencyNode node, User user) {
    for (AgencyQueueAction queueAction : node.getNodeQueueActions()) {
      this.addNodeQueueAction(queueAction);
    }

    for (AgencyChannelAction channelAction : node.getNodeChannelActions()) {
      this.addNodeChannelAction(channelAction);
    }
  } // end method copyNodeActions

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom   AgencyNode
   * @param  infoOnly   boolean
   * @param  childOnly  boolean
   * @param  user       User
   */
  public void deepCopy(AgencyNode copyFrom, boolean infoOnly, boolean childOnly, User user) {
    if (!childOnly) {
      updateNode(copyFrom, user);

      if (!infoOnly) {
        copyNodeActions(copyFrom, user);
      }
    }

    for (AgencyNode childNode : copyFrom.getChildNodes()) {
      AgencyNode newChild = new AgencyNode();
      newChild.deepCopy(childNode, infoOnly, false, user);
      addChildNode(newChild, false);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepPreviewCopy.
   *
   * @param   copyFrom   AgencyNode
   * @param   infoOnly   boolean
   * @param   childOnly  boolean
   * @param   user       User
   * @param   priority   Integer
   *
   * @return  Integer
   */
  public Integer deepPreviewCopy(AgencyNode copyFrom, boolean infoOnly, boolean childOnly, User user,
    Integer priority) {
    if (!childOnly) {
      updateNode(copyFrom, user);

      if (!infoOnly) {
        copyNodeActions(copyFrom, user);
      }
    }

    this.setPriority(priority);

    for (AgencyNode childNode : copyFrom.getChildNodes()) {
      ++priority;

      AgencyNode newChild = new AgencyNode();
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
   * @return  AgencyNode
   */
  public AgencyNode duplicate(User user) {
    AgencyNode newNode = new AgencyNode();
    newNode.updateNodeForDuplicate(this, user);
    newNode.copyNodeActions(this, user);

    return newNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * duplicateWithAllChild.
   *
   * @param   user      User
   * @param   foldNode  AgencyNode
   *
   * @return  AgencyNode
   */
  public AgencyNode duplicateWithAllChild(User user, AgencyNode foldNode) {
    AgencyNode newNode = new AgencyNode();
    newNode.setCreator(user);
    newNode.updateNodeForDuplicate(this, user);
    newNode.copyNodeActions(this, user);

    if (foldNode != null) {
      newNode.setFoldNode(foldNode);
    }

    newNode.copyChildNodes(this, user, foldNode);

    return newNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.BaseNode#equals(Object)
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

    AgencyNode node = (AgencyNode) o;

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

      for (AgencyNode childNode : childNodes) {
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
   * @see  com.ozstrategy.credagility.core.domain.Executable#execute(com.ozstrategy.credagility.core.helper.EvaluateHelper, com.ozstrategy.credagility.core.helper.ExecuteHelper)
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) {
    this.triggered = false;

    if (this.evaluateResult) {
      for (AgencyChannelAction action : this.nodeChannelActions) {
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


      for (AgencyQueueAction action : this.nodeQueueActions) {
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


      // trigger the children
      Boolean exclusive = this.getExclusiveChild();
      // Boolean exclusive = strategy.getExclusiveChild();

      for (AgencyNode childNode : childNodes) {
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
   * getter method for child nodes.
   *
   * @return  Set
   */
  public Set<AgencyNode> getChildNodes() {
    return childNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for child sub nodes.
   *
   * @return  Set
   */
  public Set<AgencyNode> getChildSubNodes() {
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
   * @param   node  AgencyNode
   *
   * @return  String
   */
  @Transient public String getExclusiveNodeCriteria(AgencyNode node) {
    if (node == null) {
      return "";
    }

    StringBuilder sb = new StringBuilder("");

    if (node.getParentNode() != null) {
      Set<AgencyNode> otherNodes = node.getParentNode().getChildNodes();
      boolean         appendNot  = false;

      for (AgencyNode oN : otherNodes) {
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

        if (oN.getPriority() .equals( node.getPriority()) ){
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
   * @return  AgencyNode
   */
  public AgencyNode getFoldNode() {
    return foldNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fold strategy.
   *
   * @return  AgencyStrategy
   */
  public AgencyStrategy getFoldStrategy() {
    return foldStrategy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for has action.
   *
   * @return  Boolean
   */
  public Boolean getHasAction() {
    return (this.getNodeChannelActions().size()
        + this.getNodeQueueActions().size()) > 0;
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
   * getter method for has child.
   *
   * @return  Boolean
   */
  public Boolean getHasChild() {
    return this.childNodes.size() > 0;
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
   * @see  com.ozstrategy.credagility.core.domain.BaseNode#getId()
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
   * @param   node  AgencyNode
   *
   * @return  String
   */
  public String getLeftOverCriteria(AgencyNode node) {
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

    StringBuilder   sb        = new StringBuilder("");
    Set<AgencyNode> allNodes  = node.getParentNode().getChildNodes();
    boolean         appendNot = false;

    for (AgencyNode oN : allNodes) {
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

      if (oN.getPriority().equals(node.getPriority()) ){
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
   * getter method for node and parents criteria.
   *
   * @param   node  AgencyNode
   *
   * @return  String
   */
  public String getNodeAndParentsCriteria(AgencyNode node) {
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
   * getter method for node channel actions.
   *
   * @return  Set
   */
  public Set<AgencyChannelAction> getNodeChannelActions() {
    return nodeChannelActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node extends criteria.
   *
   * @param   node  AgencyNode
   *
   * @return  String
   */
  public String getNodeExtendsCriteria(AgencyNode node) {
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
   * getter method for node queue actions.
   *
   * @return  Set
   */
  public Set<AgencyQueueAction> getNodeQueueActions() {
    return nodeQueueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for parent node.
   *
   * @return  AgencyNode
   */
  public AgencyNode getParentNode() {
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
   * Get stratgy which this node belong to.
   *
   * @return  the strategy
   */
  @Override public AgencyStrategy getStrategy() {
    return strategy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((criteria != null) ? criteria.hashCode() : 0);
    result = (31 * result) + ((description != null) ? description.hashCode() : 0);
    result = (31 * result) + ((exclusiveChild != null) ? exclusiveChild.hashCode() : 0);
    result = (31 * result) + ((leftOver != null) ? leftOver.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((parentNode != null) ? parentNode.hashCode() : 0);
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + ((valid != null) ? valid.hashCode() : 0);
    result = (31 * result) + ((copyFromId != null) ? copyFromId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for biz hash equals.
   *
   * @param   other  AgencyNode
   *
   * @return  boolean
   */
  public boolean isBizHashEquals(AgencyNode other) {
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
   * removeChildNode.
   *
   * @param  childNode  AgencyNode
   */
  public void removeChildNode(AgencyNode childNode) {
    if (this.childNodes.remove(childNode)) {
      childNode.setParentNode(null);
      childNode.setFoldNode(null);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeNodeChannelAction.
   *
   * @param  channelAction  AgencyChannelAction
   */
  public void removeNodeChannelAction(AgencyChannelAction channelAction) {
    this.nodeChannelActions.remove(channelAction);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeNodeQueueAction.
   *
   * @param  queueAction  AgencyQueueAction
   */
  public void removeNodeQueueAction(AgencyQueueAction queueAction) {
    this.nodeQueueActions.remove(queueAction);
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
   * setter method for child nodes.
   *
   * @param  childNodes  Set
   */
  public void setChildNodes(Set<AgencyNode> childNodes) {
    this.childNodes = childNodes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for child sub nodes.
   *
   * @param  childSubNodes  Set
   */
  public void setChildSubNodes(Set<AgencyNode> childSubNodes) {
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
   * @param  foldNode  AgencyNode
   */
  public void setFoldNode(AgencyNode foldNode) {
    this.foldNode = foldNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fold strategy.
   *
   * @param  foldStrategy  AgencyStrategy
   */
  public void setFoldStrategy(AgencyStrategy foldStrategy) {
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
   * setter method for node channel actions.
   *
   * @param  nodeChannelActions  Set
   */
  public void setNodeChannelActions(Set<AgencyChannelAction> nodeChannelActions) {
    this.nodeChannelActions = nodeChannelActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node queue actions.
   *
   * @param  nodeQueueActions  Set
   */
  public void setNodeQueueActions(Set<AgencyQueueAction> nodeQueueActions) {
    this.nodeQueueActions = nodeQueueActions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for parent node.
   *
   * @param  parentNode  AgencyNode
   */
  public void setParentNode(AgencyNode parentNode) {
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
   * setter method for strategy.
   *
   * @param  strategy  AgencyStrategy
   */
  public void setStrategy(AgencyStrategy strategy) {
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
   * @param  node  AgencyNode
   * @param  user  User
   */
  public void updateNode(AgencyNode node, User user) {
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
   * @param  node  AgencyNode
   * @param  user  User
   */
  public void updateNodeForDuplicate(AgencyNode node, User user) {
    updateNode(node, user);
    this.asSub        = node.getAsSub();
    this.collapse     = node.getCollapse();
    this.foldStrategy = node.getFoldStrategy();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.Evaluable#verify(com.ozstrategy.credagility.core.helper.EvaluateHelper)
   */
  @Override public void verify(EvaluateHelper helper) {
    if (helper == null) {
      return;
    }

    helper.verify(this);

    // verify child nodes
    for (AgencyNode childNode : childNodes) {
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
    for (AgencyNode childNode : childNodes) {
      if (Boolean.TRUE.equals(childNode.getLeftOver())) {
        return true;
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private boolean fallIntoLeftOver() {
    for (AgencyNode childNode : childNodes) {
      if (Boolean.FALSE.equals(childNode.leftOver) && Boolean.TRUE.equals(childNode.evaluateResult)) {
        return false;
      }
    }

    return true;
  }
} // end class AgencyNode
