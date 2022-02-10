package com.ozstrategy.credagility.core.domain.workflow.ent;

import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowAuditInstance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * EnterpriseWorkflow Audit Instance.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 09:55
 */
@DiscriminatorValue("Enterprise")
@Entity public class EnterpriseWorkflowAuditInstance extends WorkflowAuditInstance {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowAuditInstance#setBusinessObject(Object)
   */
  @Override public void setBusinessObject(Object businessObject) {
    // nothing. No business object.
  }
}
