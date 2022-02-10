package com.ozstrategy.credagility.core.domain.workflow.ent;

import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowInstance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * Enterprise Workflow Instance.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 10:00
 */
@DiscriminatorValue("Enterprise")
@Entity public class EnterpriseWorkflowInstance extends WorkflowInstance {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowInstance#setBusinessObject(Object)
   */
  @Override public void setBusinessObject(Object businessObject) {
    // nothing. No business object.
  }
}
