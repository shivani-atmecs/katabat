package com.ozstrategy.credagility.core.domain.workflow.basic;

import com.cmc.credagility.core.domain.user.User;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 11/19/13 : 4:11 PM</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@MappedSuperclass public abstract class BasicWorkflowTaskElementTempAnswer extends BasicWorkflowTaskElementAnswer {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Agent party submitted this Agent. */
  @JoinColumn(
    name      = "agentId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public User getAgent() {
    return agent;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  agent  DOCUMENT ME!
   */
  public void setAgent(User agent) {
    this.agent = agent;
  }
} // end class BasicWorkflowTaskElementTempAnswer
