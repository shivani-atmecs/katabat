package com.ozstrategy.credagility.core.domain.workflow.ent;

import com.ozstrategy.credagility.core.domain.workflow.enterprise.EntWorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowStep;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * Enterprise Workflow Step.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 10:03
 */
@DiscriminatorValue("Enterprise")
@Entity public class EnterpriseWorkflowStep extends WorkflowStep {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowStep#copy()
   */
  @Override public EnterpriseWorkflowStep copy() {
    EnterpriseWorkflowStep step = new EnterpriseWorkflowStep();
    paste(step);

    return step;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowStep#createBusinessObject()
   */
  @Override public EntWorkflowBusinessObject createBusinessObject() {
    return new EnterpriseWorkflowBusinessObject();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowStep#setBusinessObject(Object)
   */
  @Override public void setBusinessObject(Object businessObject) {
    // nothing, not special for someone.
  }
} // end class EnterpriseWorkflowStep
