package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowBusinessProcessAssignment;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/17/2014 11:33
 */
@DiscriminatorValue("Enterprise")
@Entity public class EnterpriseWorkflowBusinessProcessAssignment extends WorkflowBusinessProcessAssignment {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1310119003650630117L;
}
