package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowUpdateVariable;
import com.ozstrategy.credagility.core.util.DataFormatter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * storage the UpdateVariableAction for node.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 15:04
 */
@Entity
@Table(name = "SurveyFlowNodeUpdateVariableAction")
public class SurveyFlowNodeUpdateVariableAction extends CreatorEntity implements Serializable,
  SurveyFlowNodeActionInterface {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1288336137839146423L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** trigger the action criteria. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String criteria;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** SurveyFlowNode . */
  @JoinColumn(
    name     = "nodeId",
    nullable = false
  )
  @ManyToOne protected SurveyFlowNode node = new SurveyFlowNode();

  /** priority order. */
  @Column protected Integer priority = 1;

  /** trigger Time Type. */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowNodeActionTriggerType triggerTime = WorkflowNodeActionTriggerType.ENTRY;

  /** TODO: DOCUMENT ME! */
  @Column(length = 50)
  protected String uniqueIdOnNode;

  /** node . */
  @Column(length = 512)
  protected String value;

  /** node . */
  @JoinColumn(
    name       = "variableId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowUpdateVariable variable;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  SurveyFlowNodeUpdateVariableAction
   */
  public void deepCopy(SurveyFlowNodeUpdateVariableAction copyFrom) {
    this.setVariable(copyFrom.getVariable());
    this.setValue(copyFrom.getValue());
    this.setCriteria(copyFrom.getCriteria());
    this.setUniqueIdOnNode(copyFrom.getUniqueIdOnNode());
    this.setTriggerTime(copyFrom.getTriggerTime());
    this.setPriority(copyFrom.getPriority());
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

    if (!super.equals(o)) {
      return false;
    }

    SurveyFlowNodeUpdateVariableAction action = (SurveyFlowNodeUpdateVariableAction) o;

    if ((criteria != null) ? (!criteria.equals(action.criteria)) : (action.criteria != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(action.id)) : (action.id != null)) {
      return false;
    }

    if ((node != null) ? (!node.equals(action.node)) : (action.node != null)) {
      return false;
    }

    if ((priority != null) ? (!priority.equals(action.priority)) : (action.priority != null)) {
      return false;
    }

    if (triggerTime != action.triggerTime) {
      return false;
    }

    if ((value != null) ? (!value.equals(action.value)) : (action.value != null)) {
      return false;
    }

    if ((variable != null) ? (!variable.equals(action.variable)) : (action.variable != null)) {
      return false;
    }

    if ((uniqueIdOnNode != null) ? (!uniqueIdOnNode.equals(action.uniqueIdOnNode)) : (action.uniqueIdOnNode != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  SurveyFlowNodeActionInterface#getActionName()
   */
  @Override public String getActionName() {
    if (this.getVariable() != null) {
      return this.getVariable().getName();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  SurveyFlowNodeActionInterface#getCriteria()
   */
  @Override public String getCriteria() {
    return criteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data type.
   *
   * @return  String
   */
  public String getDataType() {
    return this.getVariable().getDataType();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data value.
   *
   * @return  Object
   */
  public Object getDataValue() {
    String type = this.getVariable().getDataType();

    if ("Integer".equalsIgnoreCase(type)
          || "java.lang.Integer".equalsIgnoreCase(type)) {
      return new Integer(value);
    } else if ("Long".equalsIgnoreCase(type)
          || "java.lang.Long".equalsIgnoreCase(type)) {
      return new Long(value);
    } else if ("BigDecimal".equalsIgnoreCase(type)
          || "java.math.BigDecimal".equalsIgnoreCase(type)) {
      return new BigDecimal(value);
    } else if ("Boolean".equalsIgnoreCase(type)
          || "java.lang.Boolean".equalsIgnoreCase(type)) {
      return Boolean.valueOf(value);
    } else if ("Date".equalsIgnoreCase(type)
          || "java.util.Date".equalsIgnoreCase(type)) {
      try {
        return new SimpleDateFormat(DataFormatter.getDefaultDatePattern()).parse(value);
      } catch (ParseException e) {
        e.printStackTrace();
      }
    } else if ("String".equalsIgnoreCase(type)
          || "java.lang.String".equalsIgnoreCase(type)) {
      return value;
    }

    return null;
  } // end method getDataValue

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
   * getter method for node.
   *
   * @return  SurveyFlowNode
   */
  public SurveyFlowNode getNode() {
    return node;
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
   * getter method for trigger time.
   *
   * @return  WorkflowNodeActionTriggerType
   */
  public WorkflowNodeActionTriggerType getTriggerTime() {
    return triggerTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  SurveyFlowNodeActionInterface#getTriggerType()
   */
  @Override public WorkflowNodeActionTriggerType getTriggerType() {
    return this.getTriggerTime();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unique id on node.
   *
   * @return  String
   */
  public String getUniqueIdOnNode() {
    return uniqueIdOnNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for value.
   *
   * @return  String
   */
  public String getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for variable.
   *
   * @return  WorkflowUpdateVariable
   */
  public WorkflowUpdateVariable getVariable() {
    return variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((criteria != null) ? criteria.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((node != null) ? node.hashCode() : 0);
    result = (31 * result) + ((variable != null) ? variable.hashCode() : 0);
    result = (31 * result) + ((triggerTime != null) ? triggerTime.hashCode() : 0);
    result = (31 * result) + ((value != null) ? value.hashCode() : 0);
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + ((uniqueIdOnNode != null) ? uniqueIdOnNode.hashCode() : 0);

    return result;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node.
   *
   * @param  node  SurveyFlowNode
   */
  public void setNode(SurveyFlowNode node) {
    this.node = node;
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
   * setter method for trigger time.
   *
   * @param  triggerTime  WorkflowNodeActionTriggerType
   */
  public void setTriggerTime(WorkflowNodeActionTriggerType triggerTime) {
    this.triggerTime = triggerTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for unique id on node.
   *
   * @param  uniqueIdOnNode  String
   */
  public void setUniqueIdOnNode(String uniqueIdOnNode) {
    this.uniqueIdOnNode = uniqueIdOnNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value.
   *
   * @param  value  String
   */
  public void setValue(String value) {
    this.value = value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for variable.
   *
   * @param  variable  WorkflowUpdateVariable
   */
  public void setVariable(WorkflowUpdateVariable variable) {
    this.variable = variable;
  }
} // end class SurveyFlowNodeUpdateVariableAction
