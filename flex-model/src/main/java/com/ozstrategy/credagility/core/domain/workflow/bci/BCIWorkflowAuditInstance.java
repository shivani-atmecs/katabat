package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowAuditStepStatus;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowAuditInstance;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 11/18/13 : 12:11 PM</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCIWorkflowAuditInstance")
public class BCIWorkflowAuditInstance extends BasicWorkflowAuditInstance<BCIWorkflowAuditStep> implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5840218447146814568L;

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

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** BCIWorkflowAuditStep. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowAuditInstance"
  )
  @OrderBy("createDate asc")
  @Where(clause = "status != 'RETIRED'")
  protected Set<BCIWorkflowAuditStep> steps = new LinkedHashSet<BCIWorkflowAuditStep>();

  /** BCIWorkflowAuditStep PK workflowAuditInstance. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowAuditInstance",
    cascade  = { CascadeType.ALL }
  )
  @OrderBy protected Set<BCIWorkflowAuditStep> stepSet = new LinkedHashSet<BCIWorkflowAuditStep>();

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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowAuditInstance#equals(Object)
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

    BCIWorkflowAuditInstance that = (BCIWorkflowAuditInstance) o;

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
  public BusinessContextInstance getBci() {
    return bci;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   curStepNumber  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCIWorkflowAuditStep getCurAuditStep(Integer curStepNumber) {
    BCIWorkflowAuditStep       auditStep = null;
    List<BCIWorkflowAuditStep> stepList  = getSortedAuditSteps();

    if ((stepList != null) && !stepList.isEmpty()) {
      for (BCIWorkflowAuditStep step : stepList) {
        if ((WorkflowAuditStepStatus.FINISHED.equals(step.getStatus())
                || WorkflowAuditStepStatus.IN_PROCESS.equals(step.getStatus()))
              && (step.getWorkflowStep().getStepNumber().equals(curStepNumber))) {
          auditStep = step;

          break;
        }
      }
    }

    return auditStep;
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
  public BCIWorkflowAuditStep getLastAuditStep() {
    BCIWorkflowAuditStep       auditStep = null;
    List<BCIWorkflowAuditStep> stepList  = getSortedAuditSteps();

    if ((stepList != null) && !stepList.isEmpty()) {
      for (BCIWorkflowAuditStep step : stepList) {
        if (WorkflowAuditStepStatus.FINISHED.equals(step.getStatus())
              || WorkflowAuditStepStatus.IN_PROCESS.equals(step.getStatus())) {
          auditStep = step;
        }
      }
    }

    return auditStep;
  } // end method getLastAuditStep

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public List<BCIWorkflowAuditStep> getSortedAuditSteps() {
    List<BCIWorkflowAuditStep> stepList = new ArrayList<BCIWorkflowAuditStep>();
    stepList.addAll(steps);

    if (!steps.isEmpty()) {
      Collections.sort(stepList, new Comparator<BCIWorkflowAuditStep>() {
          @Override public int compare(BCIWorkflowAuditStep o1, BCIWorkflowAuditStep o2) {
            if ((o1.getWorkflowStep() == null) && (o1.getWorkflowStep().getStepNumber() != null)) {
              return 1;
            } else if ((o2.getWorkflowStep() == null) && (o2.getWorkflowStep().getStepNumber() != null)) {
              return -1;
            } else {
              return o1.getWorkflowStep().getStepNumber().compareTo(o2.getWorkflowStep().getStepNumber());
            }
          }
        });
    }

    return stepList;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowAuditInstance#getSteps()
   */
  @Override public Set<BCIWorkflowAuditStep> getSteps() {
    return steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowAuditInstance#getStepSet()
   */
  @Override public Set<BCIWorkflowAuditStep> getStepSet() {
    return stepSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowAuditInstance#getWorkflow()
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
   * @param  bci  DOCUMENT ME!
   */
  public void setBci(BusinessContextInstance bci) {
    this.bci = bci;
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
   * @param  steps  DOCUMENT ME!
   */
  public void setSteps(Set<BCIWorkflowAuditStep> steps) {
    this.steps = steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  stepSet  DOCUMENT ME!
   */
  public void setStepSet(Set<BCIWorkflowAuditStep> stepSet) {
    this.stepSet = stepSet;
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
} // end class BCIWorkflowAuditInstance
