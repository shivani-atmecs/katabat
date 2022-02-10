package com.ozstrategy.credagility.core.domain.workflow.agency;

import com.cmc.credagility.core.domain.user.Role;
import com.ozstrategy.credagility.core.domain.document.agency.AgencyDocumentInstance;
import com.ozstrategy.credagility.core.domain.workflow.basic.WorkflowBusinessProcessInstance;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.WorkflowSchedule;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/17/2014 10:06
 */
@Entity
@Table(name = "AgencyBusinessProcessInstance")
public class AgencyBusinessProcessInstance extends WorkflowBusinessProcessInstance implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1306790689797590984L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "agencyId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Role agency;

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "AgencyBusinessProcessDocmentInstance",
    indexes            = { @Index(columnList = "processInstanceId") },
    joinColumns        = {
      @JoinColumn(
        name           = "processInstanceId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "documentInstanceId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected Set<AgencyDocumentInstance> documentInstances = new HashSet<AgencyDocumentInstance>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "scheduleId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WorkflowSchedule schedule;

  /** TODO: DOCUMENT ME! */
  @JoinTable(
    name               = "AgencyBusinessProcessWorkflowInstance",
    indexes            = { @Index(columnList = "processInstanceId") },
    joinColumns        = {
      @JoinColumn(
        name           = "processInstanceId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "workflowInstanceId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected Set<AgencyWorkflowInstance> workflowInstances = new HashSet<AgencyWorkflowInstance>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency.
   *
   * @return  Role
   */
  public Role getAgency() {
    return agency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document instances.
   *
   * @return  Set
   */
  public Set<AgencyDocumentInstance> getDocumentInstances() {
    return documentInstances;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule.
   *
   * @return  WorkflowSchedule
   */
  public WorkflowSchedule getSchedule() {
    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow instances.
   *
   * @return  Set
   */
  public Set<AgencyWorkflowInstance> getWorkflowInstances() {
    return workflowInstances;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency.
   *
   * @param  agency  Role
   */
  public void setAgency(Role agency) {
    this.agency = agency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document instances.
   *
   * @param  documentInstances  Set
   */
  public void setDocumentInstances(Set<AgencyDocumentInstance> documentInstances) {
    this.documentInstances = documentInstances;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule.
   *
   * @param  schedule  WorkflowSchedule
   */
  public void setSchedule(WorkflowSchedule schedule) {
    this.schedule = schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow instances.
   *
   * @param  workflowInstances  Set
   */
  public void setWorkflowInstances(Set<AgencyWorkflowInstance> workflowInstances) {
    this.workflowInstances = workflowInstances;
  }
} // end class AgencyBusinessProcessInstance
