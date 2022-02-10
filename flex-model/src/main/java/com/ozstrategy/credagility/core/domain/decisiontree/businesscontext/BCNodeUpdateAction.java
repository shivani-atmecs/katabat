package com.ozstrategy.credagility.core.domain.decisiontree.businesscontext;


import com.ozstrategy.credagility.core.domain.workflow.bci.BCWorkflowUpdateVariable;
import com.ozstrategy.credagility.core.helper.EvaluateHelper;
import com.ozstrategy.credagility.core.helper.ExecuteHelper;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by yongliu on 8/18/15.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  08/18/2015 17:15
 */

@Entity
@Table(name = "BCNodeUpdateAction")
public class BCNodeUpdateAction extends BCBaseNodeAction implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5984392754559989723L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "nodeId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCNode node;

  /** node . */
  @Column(length = 512)
  protected String value;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "variableId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowUpdateVariable variable;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BCNodeUpdateAction object.
   */
  public BCNodeUpdateAction() {
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
   * @return  BCNodeUpdateAction
   */
  @Override public BCNodeUpdateAction duplicate() {
    BCNodeUpdateAction updateAction = new BCNodeUpdateAction();
    updateAction.updateNodeAction(this);
    updateAction.setBusinessContext(this.getBusinessContext());
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

    BCNodeUpdateAction that = (BCNodeUpdateAction) o;

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
   * @return  BCNode
   */
  public BCNode getNode() {
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
   * @return  BCWorkflowUpdateVariable
   */
  public BCWorkflowUpdateVariable getVariable() {
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
   * @param  node  BCNode
   */
  public void setNode(BCNode node) {
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
   * @param  variable  BCWorkflowUpdateVariable
   */
  public void setVariable(BCWorkflowUpdateVariable variable) {
    this.variable = variable;
  }
} // end class BCNodeUpdateAction
