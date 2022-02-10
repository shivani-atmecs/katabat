package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowAuditStepStatus;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowAuditInstance;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/17/2014 13:54
 */
@DiscriminatorColumn(
  name              = "category",
  discriminatorType = DiscriminatorType.STRING
)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(
  name    = "EnterpriseWorkflowAuditInstance",
  indexes =
    @Index(
      name = "categoryIndex",
      columnList = "category"
    )
)
public abstract class WorkflowAuditInstance extends BasicWorkflowAuditInstance<WorkflowAuditStep>
  implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4278310087203093252L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Category : Enterprise / Agency/ Agent. */
  @Column(
    nullable   = false,
    insertable = false,
    updatable  = false,
    length     = 10
  )
  protected String category;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowAuditInstance"
  )
  @OrderBy("createDate asc")
  @Where(clause = "status != 'RETIRED'")
  protected Set<WorkflowAuditStep> steps = new LinkedHashSet<WorkflowAuditStep>();


  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowAuditInstance",
    cascade  = CascadeType.ALL
  )
  @OrderBy protected Set<WorkflowAuditStep> stepSet = new LinkedHashSet<WorkflowAuditStep>();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "workflowId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EnterpriseWorkflow workflow;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * setter method for business object.
   *
   * @param  businessObject  Object
   */
  public abstract void setBusinessObject(Object businessObject);

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
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

    WorkflowAuditInstance that = (WorkflowAuditInstance) o;

    if ((category != null) ? (!category.equals(that.category)) : (that.category != null)) {
      return false;
    }

    if ((workflow != null) ? (!workflow.equals(that.workflow)) : (that.workflow != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category.
   *
   * @return  String
   */
  public String getCategory() {
    return category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cur audit step.
   *
   * @param   curStepNumber  Integer
   *
   * @return  WorkflowAuditStep
   */
  public WorkflowAuditStep getCurAuditStep(Integer curStepNumber) {
    WorkflowAuditStep       auditStep = null;
    List<WorkflowAuditStep> stepList  = getSortedAuditStep();

    if ((stepList != null) && !stepList.isEmpty()) {
      for (WorkflowAuditStep step : stepList) {
        if ((WorkflowAuditStepStatus.FINISHED.equals(step.getStatus())
                || WorkflowAuditStepStatus.IN_PROCESS.equals(step.getStatus()))
              && (step.getWorkflowStep().getStepNumber().equals(curStepNumber))) {
          auditStep = step;
        }
      }
    }

    return auditStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last audit step.
   *
   * @return  WorkflowAuditStep
   */
  public WorkflowAuditStep getLastAuditStep() {
    WorkflowAuditStep       auditStep = null;
    List<WorkflowAuditStep> stepList  = getSortedAuditStep();

    if ((stepList != null) && !stepList.isEmpty()) {
      for (WorkflowAuditStep step : stepList) {
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
   * getter method for sorted audit step.
   *
   * @return  List
   */
  public List<WorkflowAuditStep> getSortedAuditStep() {
    List<WorkflowAuditStep> stepList = new ArrayList<WorkflowAuditStep>();
    stepList.addAll(steps);

    if (!steps.isEmpty()) {
      Collections.sort(stepList, new Comparator<WorkflowAuditStep>() {
          @Override public int compare(WorkflowAuditStep o1, WorkflowAuditStep o2) {
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
   * getter method for steps.
   *
   * @return  Set
   */
  @Override public Set<WorkflowAuditStep> getSteps() {
    return steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for step set.
   *
   * @return  Set
   */
  @Override public Set<WorkflowAuditStep> getStepSet() {
    return stepSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow.
   *
   * @return  EnterpriseWorkflow
   */
  @Override public EnterpriseWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((category != null) ? category.hashCode() : 0);
    result = (31 * result) + ((workflow != null) ? workflow.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category.
   *
   * @param  category  String
   */
  public void setCategory(String category) {
    this.category = category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for steps.
   *
   * @param  steps  Set
   */
  public void setSteps(Set<WorkflowAuditStep> steps) {
    this.steps = steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for step set.
   *
   * @param  stepSet  Set
   */
  public void setStepSet(Set<WorkflowAuditStep> stepSet) {
    this.stepSet = stepSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow.
   *
   * @param  workflow  EnterpriseWorkflow
   */
  public void setWorkflow(EnterpriseWorkflow workflow) {
    this.workflow = workflow;
  }
} // end class WorkflowAuditInstance
