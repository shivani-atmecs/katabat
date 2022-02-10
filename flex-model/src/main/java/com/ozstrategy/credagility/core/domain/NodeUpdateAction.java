package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowUpdateVariable;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by yongliu on 8/18/15.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  08/18/2015 17:12
 */

@Entity
@Table(name = "NodeUpdateAction")
public class NodeUpdateAction extends PortfolioBaseNodeAction implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2951273777861902035L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "nodeId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Node node;

  /** node . */
  @Column(length = 512)
  protected String value;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "variableId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowUpdateVariable variable;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new NodeUpdateAction object.
   */
  public NodeUpdateAction() {
    this.actionType = ActionType_Update;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------


  /**
   * beforeExecute.
   */
  @Override public void beforeExecute() { }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * duplicate.
   *
   * @return  NodeUpdateAction
   */
  @Override public NodeUpdateAction duplicate() {
    NodeUpdateAction updateAction = new NodeUpdateAction();
    updateAction.updateNodeAction(this);
    updateAction.setPortfolio(this.getPortfolio());
    updateAction.setName(updateAction.getName());
    updateAction.setPriority(this.getPriority());
    updateAction.setValue(this.getValue());
    updateAction.setVariable(this.getVariable());

    return updateAction;
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

    NodeUpdateAction that = (NodeUpdateAction) o;

    if ((priority != null) ? (!priority.equals(that.priority)) : (that.priority != null)) {
      return false;
    }

    return !((value != null) ? (!value.equals(that.value)) : (that.value != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * execute.
   *
   * @param  evaluateHelper  EvaluateHelper
   * @param  executeHelper   ExecuteHelper
   */
  @Override public void execute(EvaluateHelper evaluateHelper, ExecuteHelper executeHelper) { }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node.
   *
   * @return  Node
   */
  public Node getNode() {
    return node;
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
    int result = super.hashCode();
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + ((value != null) ? value.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node.
   *
   * @param  node  Node
   */
  public void setNode(Node node) {
    this.node = node;
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
} // end class NodeUpdateAction
