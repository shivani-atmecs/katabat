package com.ozstrategy.credagility.el.context.agency;

import com.cmc.credagility.core.domain.user.Role;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowStep;
import com.ozstrategy.credagility.core.el.ElObject;


/**
 * Created by Yang Wang on 2/24/14.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class AgencyElObject extends ElObject<AgencyElContext> {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Role         agency;
  private WorkflowStep workflowStep;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AgencyElContext object.
   */
  public AgencyElObject() { }

  /**
   * Creates a new AgencyElObject object.
   *
   * @param  agency  DOCUMENT ME!
   */
  public AgencyElObject(Role agency) {
    this.agency = agency;
  }

  /**
   * Creates a new AgencyElObject object.
   *
   * @param  agency        DOCUMENT ME!
   * @param  workflowStep  DOCUMENT ME!
   */
  public AgencyElObject(Role agency, WorkflowStep workflowStep) {
    this.agency       = agency;
    this.workflowStep = workflowStep;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElObject#createContext()
   */
  @Override public AgencyElContext createContext() {
    AgencyElContext context = new AgencyElContext();
    context.setAgency(agency);
    context.setWorkflowStep(workflowStep);
    context.setExecutor(this.getExecutor());

    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getAgencyId() {
    if (agency != null) {
      return agency.getId();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElObject#getCacheKey()
   */
  @Override public String getCacheKey() {
    return "agency-" + getAgencyId();
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
} // end class AgencyElObject
