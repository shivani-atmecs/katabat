package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionInterface;
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
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/17/2014 13:47
 */
@Entity
@Table(name = "EnterpriseWorkflowUpdateVariableAction")
public class EnterpriseWorkflowUpdateVariableAction extends CreatorEntity implements Serializable,
  WorkflowNodeActionInterface {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4387177632491405603L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String criteria;

  /** SurveyFlowNode . */
  @JoinColumn(
    name     = "flowId",
// unique   = true,
    nullable = false
  )
  @ManyToOne protected EnterpriseWorkflow flow = new EnterpriseWorkflow();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column protected Integer priority = 1;


  /** TODO: DOCUMENT ME! */
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

    EnterpriseWorkflowUpdateVariableAction that = (EnterpriseWorkflowUpdateVariableAction) o;

    if ((criteria != null) ? (!criteria.equals(that.criteria)) : (that.criteria != null)) {
      return false;
    }

    if (!flow.equals(that.flow)) {
      return false;
    }

    if ((priority != null) ? (!priority.equals(that.priority)) : (that.priority != null)) {
      return false;
    }

    if (triggerTime != that.triggerTime) {
      return false;
    }

    if ((value != null) ? (!value.equals(that.value)) : (that.value != null)) {
      return false;
    }

    if ((uniqueIdOnNode != null) ? (!uniqueIdOnNode.equals(that.uniqueIdOnNode)) : (that.uniqueIdOnNode != null)) {
      return false;
    }

    if (!variable.equals(that.variable)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action name.
   *
   * @return  String
   */
  @Override public String getActionName() {
    if (this.getVariable() != null) {
      return this.getVariable().getName();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for criteria.
   *
   * @return  String
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
   * getter method for flow.
   *
   * @return  EnterpriseWorkflow
   */
  public EnterpriseWorkflow getFlow() {
    return flow;
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
   * getter method for trigger type.
   *
   * @return  WorkflowNodeActionTriggerType
   */
  @Override public WorkflowNodeActionTriggerType getTriggerType() {
    return getTriggerTime();
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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = (criteria != null) ? criteria.hashCode() : 0;
    result = (31 * result) + flow.hashCode();
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + triggerTime.hashCode();
    result = (31 * result) + ((value != null) ? value.hashCode() : 0);
    result = (31 * result) + variable.hashCode();
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
   * setter method for flow.
   *
   * @param  flow  EnterpriseWorkflow
   */
  public void setFlow(EnterpriseWorkflow flow) {
    this.flow = flow;
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
} // end class EnterpriseWorkflowUpdateVariableAction
