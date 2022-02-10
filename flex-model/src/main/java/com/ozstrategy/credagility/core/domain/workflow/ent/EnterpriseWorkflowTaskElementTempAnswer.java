package com.ozstrategy.credagility.core.domain.workflow.ent;

import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowTaskElementTempAnswer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * Enterprise Workflow TaskElement TempAnswer.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 10:04
 */
@DiscriminatorValue("Enterprise")
@Entity public class EnterpriseWorkflowTaskElementTempAnswer extends WorkflowTaskElementTempAnswer {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowTaskElementTempAnswer#getBusinessObject()
   */
  @Override public Object getBusinessObject() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowTaskElementTempAnswer#setBusinessObject(Object)
   */
  @Override public void setBusinessObject(Object businessObject) { }
}
