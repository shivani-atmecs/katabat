package com.ozstrategy.credagility.core.domain.workflow.customer;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  03/18/2017 15:50
 */
@Entity
@Table(name = "CustomerWorkflowVariableAction")
public class CustomerWorkflowVariableAction extends CustomerWorkflowAction implements Serializable {
  //~ Instance fields --------------------------------------------------------------------------------------------------

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
  protected CustomerFlowVariable variable = new CustomerFlowVariable();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  CustomerWorkflowAction#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    CustomerWorkflowVariableAction that = (CustomerWorkflowVariableAction) o;

    if ((value != null) ? (!value.equals(that.value)) : (that.value != null)) {
      return false;
    }

    if (!variable.equals(that.variable)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionInterface#getActionName()
   */
  @Override public String getActionName() {
    if (this.getVariable() != null) {
      return this.getVariable().getDisplayName();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerFlowVariable getVariable() {
    return variable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  CustomerWorkflowAction#hashCode()
   */
  @Override public int hashCode() {
    int result = ((value != null) ? value.hashCode() : 0);
    result = (31 * result) + variable.hashCode();

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  value  DOCUMENT ME!
   */
  public void setValue(String value) {
    this.value = value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  variable  DOCUMENT ME!
   */
  public void setVariable(CustomerFlowVariable variable) {
    this.variable = variable;
  }
} // end class CustomerWorkflowVariableAction
