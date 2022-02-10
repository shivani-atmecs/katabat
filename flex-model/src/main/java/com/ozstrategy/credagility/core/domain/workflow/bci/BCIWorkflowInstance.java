package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.cmc.credagility.core.domain.businesscontext.DynamicCase;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowInstance;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 11/18/13 : 12:06 PM</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCIWorkflowInstance")
public class BCIWorkflowInstance extends BasicWorkflowInstance<BCIWorkflowStep> implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7966444339273262085L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** BCIWorkflowAuditInstance PK auditInstanceId. */
  @JoinColumn(
    name       = "auditInstanceId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIWorkflowAuditInstance auditInstance;

  /** BusinessContextInstance PK bciId. */
  @JoinColumn(
    name       = "bciId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContextInstance bci;

  /** BCIWorkflowStep. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowInstance"
  )
  @OrderBy("stepNumber asc")
  @Where(clause = "current = 'Y'")
  protected Set<BCIWorkflowStep> currentStepSet = new LinkedHashSet<BCIWorkflowStep>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name                                        = "dynamicCaseId",
    nullable                                    = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected DynamicCase          dynamicCase;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** BCIWorkflowAuditInstance PK previousAuditInstanceId. */
  @JoinColumn(
    name       = "previousAuditInstanceId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCIWorkflowAuditInstance previousAuditInstance;

  /** BCIWorkflowStep. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowInstance"
  )
  @OrderBy("stepNumber asc")
  @Where(clause = "status != 'RETIRED'")
  protected Set<BCIWorkflowStep> steps = new LinkedHashSet<BCIWorkflowStep>();

  /** BCIWorkflowStep PK workflowInstance. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowInstance",
    cascade  = { CascadeType.ALL }
  )
  @OrderBy("stepNumber asc")
  protected Set<BCIWorkflowStep> stepSet = new LinkedHashSet<BCIWorkflowStep>();

  /** Unique id. */
  protected String uuId;

  /** BCWorkflow PK workflowId. */
  @JoinColumn(
    name       = "workflowId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCWorkflow workflow;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BCIWorkflowInstance that = (BCIWorkflowInstance) o;

    if ((bci != null) ? (!bci.equals(that.bci)) : (that.bci != null)) {
      return false;
    }

    if ((workflow != null) ? (!workflow.equals(that.workflow)) : (that.workflow != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCIWorkflowAuditInstance getAuditInstance() {
    return auditInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowInstance#getCurrentStepSet()
   */
  @Override public Set<BCIWorkflowStep> getCurrentStepSet() {
    return currentStepSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for dynamic case.
   *
   * @return  DynamicCase
   */
  public DynamicCase getDynamicCase() {
    return dynamicCase;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCIWorkflowAuditInstance getPreviousAuditInstance() {
    return previousAuditInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowInstance#getSteps()
   */
  @Override public Set<BCIWorkflowStep> getSteps() {
    return steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowInstance#getStepSet()
   */
  @Override public Set<BCIWorkflowStep> getStepSet() {
    return stepSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getUuId() {
    return uuId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowInstance#getWorkflow()
   */
  @Override public BCWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((bci != null) ? bci.hashCode() : 0);
    result = (31 * result) + ((workflow != null) ? workflow.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  auditInstance  DOCUMENT ME!
   */
  public void setAuditInstance(BCIWorkflowAuditInstance auditInstance) {
    this.auditInstance = auditInstance;
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
   * @param  currentStepSet  DOCUMENT ME!
   */
  public void setCurrentStepSet(Set<BCIWorkflowStep> currentStepSet) {
    this.currentStepSet = currentStepSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for dynamic case.
   *
   * @param  dynamicCase  DynamicCase
   */
  public void setDynamicCase(DynamicCase dynamicCase) {
    this.dynamicCase = dynamicCase;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  DOCUMENT ME!
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  previousAuditInstance  DOCUMENT ME!
   */
  public void setPreviousAuditInstance(BCIWorkflowAuditInstance previousAuditInstance) {
    this.previousAuditInstance = previousAuditInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  steps  DOCUMENT ME!
   */
  public void setSteps(Set<BCIWorkflowStep> steps) {
    this.steps = steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  stepSet  DOCUMENT ME!
   */
  public void setStepSet(Set<BCIWorkflowStep> stepSet) {
    this.stepSet = stepSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  uuId  DOCUMENT ME!
   */
  public void setUuId(String uuId) {
    this.uuId = uuId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflow  DOCUMENT ME!
   */
  public void setWorkflow(BCWorkflow workflow) {
    this.workflow = workflow;
  }
} // end class BCIWorkflowInstance
