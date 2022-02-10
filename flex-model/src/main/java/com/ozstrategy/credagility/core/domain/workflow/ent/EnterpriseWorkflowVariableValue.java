package com.ozstrategy.credagility.core.domain.workflow.ent;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowVariableValue;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * Enterprise Workflow VariableValue.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 10:05
 */
@DiscriminatorValue("Enterprise")
@Entity public class EnterpriseWorkflowVariableValue extends WorkflowVariableValue {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * createBusinessObject.
   *
   * @return  WorkflowBusinessObject
   */
  @Override public WorkflowBusinessObject createBusinessObject() {
    EnterpriseWorkflowBusinessObject obj = new EnterpriseWorkflowBusinessObject();

    return obj;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business object.
   *
   * @param  businessObject  Object
   */
  @Override public void setBusinessObject(Object businessObject) { }
} // end class EnterpriseWorkflowVariableValue
