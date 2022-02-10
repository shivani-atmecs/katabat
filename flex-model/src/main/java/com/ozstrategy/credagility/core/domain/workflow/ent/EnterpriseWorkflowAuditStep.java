package com.ozstrategy.credagility.core.domain.workflow.ent;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessObject;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowAuditStep;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * Enterprise Workflow Audit Step.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 09:56
 */
@DiscriminatorValue("Enterprise")
@Entity public class EnterpriseWorkflowAuditStep extends WorkflowAuditStep {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowAuditStep#createBusinessObject()
   */
  @Override public WorkflowBusinessObject createBusinessObject() {
    return new EnterpriseWorkflowBusinessObject();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowAuditStep#setBusinessObject(Object)
   */
  @Override public void setBusinessObject(Object businessObject) {
    // nothing, not special for someone.
  }
}
