package com.ozstrategy.credagility.core.domain.workflow.ent;

import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowTaskElementAnswer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * EnterpriseWorkflow TaskElement Answer.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 10:03
 */
@DiscriminatorValue("Enterprise")
@Entity public class EnterpriseWorkflowTaskElementAnswer extends WorkflowTaskElementAnswer {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowTaskElementAnswer#getBusinessObject()
   */
  @Override public Object getBusinessObject() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowTaskElementAnswer#setBusinessObject(Object)
   */
  @Override public void setBusinessObject(Object businessObject) { }
}
