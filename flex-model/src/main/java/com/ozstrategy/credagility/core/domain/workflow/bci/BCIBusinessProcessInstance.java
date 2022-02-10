package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.ozstrategy.credagility.core.domain.document.bci.BCIDocumentInstance;
import com.ozstrategy.credagility.core.domain.workflow.basic.WorkflowBusinessProcessInstance;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 12/3/13 Time: 5:32 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCIBusinessProcessInstance")
public class BCIBusinessProcessInstance extends WorkflowBusinessProcessInstance {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1836320830581567893L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** BusinessContextInstance PK bciId. */
  @JoinColumn(
    name       = "bciId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContextInstance bci;

  /** Many to many with table BCIBusinessProcessDocumentInstance. */
  @JoinTable(
    name               = "BCIBusinessProcessDocumentInstance",
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
    cascade = { CascadeType.ALL }
  )
  protected Set<BCIDocumentInstance> documentInstances = new HashSet<BCIDocumentInstance>();

  /** BCWorkflowSchedule PK scheduleId. */
  @JoinColumn(
    name       = "scheduleId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflowSchedule schedule;


  /** Many to many with table BCIBusinessProcessWorkflowInstance. */
  @JoinTable(
    name               = "BCIBusinessProcessWorkflowInstance",
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
    cascade = { CascadeType.ALL }
  )
  protected Set<BCIWorkflowInstance> workflowInstances = new HashSet<BCIWorkflowInstance>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BusinessContextInstance getBci() {
    return bci;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCIDocumentInstance> getDocumentInstances() {
    return documentInstances;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowSchedule getSchedule() {
    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<BCIWorkflowInstance> getWorkflowInstances() {
    return workflowInstances;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bci  DOCUMENT ME!
   */
  public void setBci(BusinessContextInstance bci) {
    this.bci = bci;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  documentInstances  DOCUMENT ME!
   */
  public void setDocumentInstances(Set<BCIDocumentInstance> documentInstances) {
    this.documentInstances = documentInstances;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  schedule  DOCUMENT ME!
   */
  public void setSchedule(BCWorkflowSchedule schedule) {
    this.schedule = schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowInstances  DOCUMENT ME!
   */
  public void setWorkflowInstances(Set<BCIWorkflowInstance> workflowInstances) {
    this.workflowInstances = workflowInstances;
  }

} // end class BCIBusinessProcessInstance
