package com.ozstrategy.credagility.core.domain.workflow.responsible;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.ozstrategy.credagility.core.domain.SurveyFlowInstance;
import com.ozstrategy.credagility.core.domain.SurveySchedule;
import com.ozstrategy.credagility.core.domain.document.responsible.ResponsibleDocumentInstance;
import com.ozstrategy.credagility.core.domain.workflow.basic.WorkflowBusinessProcessInstance;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Responsible Business Process Instance.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/17/2014 10:20
 */
@Entity
@Table(name = "ResponsibleBusinessProcessInstance")
public class ResponsibleBusinessProcessInstance extends WorkflowBusinessProcessInstance implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7759702711501920391L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account. */
  @JoinColumn(
    name      = "accountNum",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** document Instances! */
  @JoinTable(
    name               = "ResponsibleBusinessProcessDocumentInstance",
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
    cascade = { CascadeType.MERGE, CascadeType.PERSIST }
  )
  protected Set<ResponsibleDocumentInstance> documentInstances = new HashSet<ResponsibleDocumentInstance>();

  /** Responsible owner. */
  @JoinColumn(
    name      = "responsibleId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible owner;

  /** SurveySchedule. */
  @JoinColumn(
    name       = "scheduleId",
    nullable   = false,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveySchedule schedule;

  /** workflow Instances. */
  @JoinTable(
    name               = "ResponsibleBusinessProcessWorkflowInstance",
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
    cascade = { CascadeType.MERGE, CascadeType.PERSIST }
  )
  protected Set<SurveyFlowInstance> workflowInstances = new HashSet<SurveyFlowInstance>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for document instances.
   *
   * @return  Set
   */
  public Set<ResponsibleDocumentInstance> getDocumentInstances() {
    return documentInstances;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for owner.
   *
   * @return  Responsible
   */
  public Responsible getOwner() {
    return owner;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule.
   *
   * @return  SurveySchedule
   */
  public SurveySchedule getSchedule() {
    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow instances.
   *
   * @return  Set
   */
  public Set<SurveyFlowInstance> getWorkflowInstances() {
    return workflowInstances;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for document instances.
   *
   * @param  documentInstances  Set
   */
  public void setDocumentInstances(Set<ResponsibleDocumentInstance> documentInstances) {
    this.documentInstances = documentInstances;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for owner.
   *
   * @param  owner  Responsible
   */
  public void setOwner(Responsible owner) {
    this.owner = owner;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule.
   *
   * @param  schedule  SurveySchedule
   */
  public void setSchedule(SurveySchedule schedule) {
    this.schedule = schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow instances.
   *
   * @param  workflowInstances  Set
   */
  public void setWorkflowInstances(Set<SurveyFlowInstance> workflowInstances) {
    this.workflowInstances = workflowInstances;
  }
} // end class ResponsibleBusinessProcessInstance
