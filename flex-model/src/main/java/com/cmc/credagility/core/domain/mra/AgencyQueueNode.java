package com.cmc.credagility.core.domain.mra;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ozstrategy.credagility.core.domain.workflow.ContextType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/15/2014 12:45
 */
public class AgencyQueueNode {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private List<AgencyQueueNode> children;

  private Boolean expanded;

  private String  iconCls;
  private Boolean leaf;

  private Integer level;
  private String  name;
  private String  nameWithId;

  private AgencyQueueNode parentNode;

  private String qtip;
  private String queueId;
  private String text;

  private String type;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AgencyQueueNode object.
   */
  public AgencyQueueNode() { }

  /**
   * Creates a new AgencyQueueNode object.
   *
   * @param  nameWithId  DOCUMENT ME!
   * @param  type        DOCUMENT ME!
   * @param  level       DOCUMENT ME!
   */
  public AgencyQueueNode(String nameWithId, String type, Integer level) {
    this.level      = level;
    this.type       = type;
    this.nameWithId = nameWithId;

    if (this.nameWithId != null) {
      String[] nis = this.nameWithId.split("!");
      this.name     = nis[0];
      this.expanded = true;

      if (nis.length > 1) {
        if ((type != null) && ContextType.AGENCY.name().equalsIgnoreCase(type)) {
          this.text = this.name + " (Agency)";
        } else {
          this.queueId = nis[nis.length - 1];
          this.text    = this.name + " (Queue Id: " + this.queueId + ")";
// this.checked = false;
        }
      }
    }
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addChild.
   *
   * @param  childNode  AgencyQueueNode
   */
  public void addChild(AgencyQueueNode childNode) {
    this.getChildren().add(childNode);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * addChildren.
   *
   * @param  childNodes  List
   */
  public void addChildren(List<AgencyQueueNode> childNodes) {
    this.getChildren().addAll(childNodes);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof AgencyQueueNode)) {
      return false;
    }

    AgencyQueueNode queueNode = (AgencyQueueNode) o;

    if ((nameWithId != null) ? (!nameWithId.equals(queueNode.nameWithId)) : (queueNode.nameWithId != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for children.
   *
   * @return  List
   */
  public List<AgencyQueueNode> getChildren() {
    if (children == null) {
      children = new ArrayList<AgencyQueueNode>();
    }

    return children;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for expanded.
   *
   * @return  Boolean
   */
  public Boolean getExpanded() {
    if (expanded == null) {
      expanded = false;
    }

    return expanded;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for icon cls.
   *
   * @return  String
   */
  public String getIconCls() {
    if ((this.getType() != null) && ContextType.AGENCY.name().equalsIgnoreCase(this.getType())) {
      this.iconCls = "portfolio_tree_node";
    } else {
      this.iconCls = "queue_tree_node";
    }

    return this.iconCls;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for leaf.
   *
   * @return  Boolean
   */
  public Boolean getLeaf() {
    if (this.getChildren().size() == 0) {
      this.leaf = true;
    } else {
      this.leaf = false;
    }

    return this.leaf;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

// public Boolean getChecked() {
// return checked;
// }
//
// public void setChecked(Boolean checked) {
// this.checked = checked;
// }

  /**
   * getter method for level.
   *
   * @return  Integer
   */
  public Integer getLevel() {
    return level;
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
   * getter method for name with id.
   *
   * @return  String
   */
  public String getNameWithId() {
    return nameWithId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for parent node.
   *
   * @return  AgencyQueueNode
   */
  public AgencyQueueNode getParentNode() {
    return parentNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for qtip.
   *
   * @return  String
   */
  public String getQtip() {
    return qtip;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue id.
   *
   * @return  String
   */
  public String getQueueId() {
    return queueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for text.
   *
   * @return  String
   */
  public String getText() {
    return text;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  String
   */
  public String getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = (nameWithId != null) ? nameWithId.hashCode() : 0;

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for children.
   *
   * @param  children  List
   */
  public void setChildren(List<AgencyQueueNode> children) {
    this.children = children;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for expanded.
   *
   * @param  expanded  Boolean
   */
  public void setExpanded(Boolean expanded) {
    this.expanded = expanded;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for icon cls.
   *
   * @param  iconCls  String
   */
  public void setIconCls(String iconCls) {
    this.iconCls = iconCls;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for leaf.
   *
   * @param  leaf  Boolean
   */
  public void setLeaf(Boolean leaf) {
    this.leaf = leaf;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for level.
   *
   * @param  level  Integer
   */
  public void setLevel(Integer level) {
    this.level = level;
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
   * setter method for name with id.
   *
   * @param  nameWithId  String
   */
  public void setNameWithId(String nameWithId) {
    this.nameWithId = nameWithId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for parent node.
   *
   * @param  parentNode  AgencyQueueNode
   */
  public void setParentNode(AgencyQueueNode parentNode) {
    this.parentNode = parentNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for qtip.
   *
   * @param  qtip  String
   */
  public void setQtip(String qtip) {
    this.qtip = qtip;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue id.
   *
   * @param  queueId  String
   */
  public void setQueueId(String queueId) {
    this.queueId = queueId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for text.
   *
   * @param  text  String
   */
  public void setText(String text) {
    this.text = text;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type.
   *
   * @param  type  String
   */
  public void setType(String type) {
    this.type = type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return new ToStringBuilder(this).append("name", name).append("queueId", queueId).append("children", children)
      .append("parentNode", parentNode).toString();
  }
} // end class AgencyQueueNode
