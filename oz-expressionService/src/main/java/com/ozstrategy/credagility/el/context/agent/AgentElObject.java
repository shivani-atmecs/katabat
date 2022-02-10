package com.ozstrategy.credagility.el.context.agent;

import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowStep;
import com.ozstrategy.credagility.core.el.ElObject;


/**
 * Created by Yang Wang on 2/24/14.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class AgentElObject extends ElObject<AgentElContext> {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private User         agent;
  private WorkflowStep workflowStep;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AgentElContext object.
   */
  public AgentElObject() { }

  /**
   * Creates a new AgentElObject object.
   *
   * @param  agent  DOCUMENT ME!
   */
  public AgentElObject(User agent) {
    this.agent = agent;
  }

  /**
   * Creates a new AgentElObject object.
   *
   * @param  agent         DOCUMENT ME!
   * @param  workflowStep  DOCUMENT ME!
   */
  public AgentElObject(User agent, WorkflowStep workflowStep) {
    this.agent        = agent;
    this.workflowStep = workflowStep;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElObject#createContext()
   */
  @Override public AgentElContext createContext() {
    AgentElContext context = new AgentElContext();
    context.setAgent(agent);
    context.setWorkflowStep(workflowStep);

    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getAgentId() {
    if (agent != null) {
      return agent.getId();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElObject#getCacheKey()
   */
  @Override public String getCacheKey() {
    return "agent-" + getAgentId();
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowStep  DOCUMENT ME!
   */
  public void setWorkflowStep(WorkflowStep workflowStep) {
    this.workflowStep = workflowStep;
  }
} // end class AgentElObject
