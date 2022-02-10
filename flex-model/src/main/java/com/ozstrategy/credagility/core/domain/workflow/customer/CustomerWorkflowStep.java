package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.cmc.credagility.core.domain.customer.Customer;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeType;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowStepStatus;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStep;
import com.ozstrategy.credagility.core.domain.workflow.customer.version.CustomerWorkflowTaskVersion;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  03/15/2017 10:31
 */
@Entity
@Table(name = "CustomerWorkflowStep")
public class CustomerWorkflowStep extends BasicWorkflowStep implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7569096469822364140L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "customerId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;

  /** DOCUMENT ME! */
  @Cascade({ org.hibernate.annotations.CascadeType.ALL })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowStep"
  )
  protected Set<CustomerWorkflowStepTaskElementSnapshot> elementSnapshots =
    new LinkedHashSet<CustomerWorkflowStepTaskElementSnapshot>();

  /** TODO: DOCUMENT ME! */
  @Cascade({ org.hibernate.annotations.CascadeType.ALL })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowStep"
  )
  protected Set<CustomerEventMapSurveyFlow> eventMapSurveyFlows = new LinkedHashSet<CustomerEventMapSurveyFlow>();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "mainFlowStepId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowStep mainFlowStep;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "nodeId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowNode node;

  /** DOCUMENT ME! */
  @JoinColumn(
    name     = "previousStepId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowStep previousStep;

  /** TODO: DOCUMENT ME! */
  @Cascade({ org.hibernate.annotations.CascadeType.ALL })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowStep"
  )
  protected Set<CustomerWorkflowAccountSelectorAnswer> selectedAccounts =
    new LinkedHashSet<CustomerWorkflowAccountSelectorAnswer>();

  /** TODO: DOCUMENT ME! */
  @Column
  @Type(type = "yes_no")
  protected Boolean         skipped;

  /** DOCUMENT ME! */
  @Cascade({ org.hibernate.annotations.CascadeType.ALL })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "mainFlowStep"
  )
  @OrderBy("stepNumber asc")
  @Where(clause = "status != 'RETIRED'")
  protected Set<CustomerWorkflowStep> subSteps = new LinkedHashSet<CustomerWorkflowStep>();

  /** DOCUMENT ME! */
  @Cascade({ org.hibernate.annotations.CascadeType.ALL })
  @OneToOne(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowStep"
  )
  protected CustomerWorkflowStepTaskSnapshot taskSnapshot;

  /** DOCUMENT ME! */
  @JoinColumn(
    name      = "taskVersionId",
    nullable  = true,
    updatable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowTaskVersion taskVersion;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "flowId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflow workflow;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "workflowInstanceId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowInstance workflowInstance;

  @Column
  @Type(type = "yes_no")
  private Boolean         holdOnEvent;

  @Transient private Map<String, CustomerWorkflowTaskElementAnswer> tempAnswers =
    new HashMap<String, CustomerWorkflowTaskElementAnswer>();

  @Transient private Map<String, String> updateActionResponse = new HashMap<String, String>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  name    DOCUMENT ME!
   * @param  answer  DOCUMENT ME!
   */
  public void addTempAnswer(String name, CustomerWorkflowTaskElementAnswer answer) {
    tempAnswers.put(name, answer);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStep#copy()
   */
  @Override public CustomerWorkflowStep copy() {
    CustomerWorkflowStep step = new CustomerWorkflowStep();
    paste(step);

    return step;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowStep copyWithSnapshot() {
    CustomerWorkflowStep workflowStep = copy();

    if (this.getTaskSnapshot() != null) {
      CustomerWorkflowStepTaskSnapshot             snapshot    = this.getTaskSnapshot();
      CustomerWorkflowStepTaskSnapshot             newSnapshot = snapshot.copy();
      Set<CustomerWorkflowStepTaskElementSnapshot> elements    = getElementSnapshots();

      newSnapshot.setWorkflowStep(workflowStep);
      workflowStep.setTaskSnapshot(newSnapshot);

      for (CustomerWorkflowStepTaskElementSnapshot element : elements) {
        element.copy();
        element.setWorkflowStep(workflowStep);
        workflowStep.getElementSnapshots().add(element);
      }
    }

    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
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

    CustomerWorkflowStep that = (CustomerWorkflowStep) o;

    if ((mainFlowStep != null) ? (!mainFlowStep.equals(that.mainFlowStep)) : (that.mainFlowStep != null)) {
      return false;
    }

    if ((node != null) ? (!node.equals(that.node)) : (that.node != null)) {
      return false;
    }

    if ((previousStep != null) ? (!previousStep.equals(that.previousStep)) : (that.previousStep != null)) {
      return false;
    }

    if ((workflow != null) ? (!workflow.equals(that.workflow)) : (that.workflow != null)) {
      return false;
    }

    if ((workflowInstance != null) ? (!workflowInstance.equals(that.workflowInstance))
                                   : (that.workflowInstance != null)) {
      return false;
    }

    if ((customer != null) ? (!customer.equals(that.customer)) : (that.customer != null)) {
      return false;
    }


    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer.
   *
   * @return  Customer
   */
  public Customer getCustomer() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<CustomerWorkflowStepTaskElementSnapshot> getElementSnapshots() {
    return elementSnapshots;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<Long, CustomerWorkflowStepTaskElementSnapshot> getElementSnapshotsMap() {
    Map<Long, CustomerWorkflowStepTaskElementSnapshot> map = new HashMap<Long, CustomerWorkflowStepTaskElementSnapshot>(
        elementSnapshots.size());

    for (CustomerWorkflowStepTaskElementSnapshot elementSnapshot : elementSnapshots) {
      map.put(elementSnapshot.getTaskElement().getId(), elementSnapshot);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event map survey flows.
   *
   * @return  Set
   */
  public Set<CustomerEventMapSurveyFlow> getEventMapSurveyFlows() {
    return eventMapSurveyFlows;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hold on event.
   *
   * @return  Boolean
   */
  public Boolean getHoldOnEvent() {
    if (holdOnEvent == null) {
      return Boolean.FALSE;
    }

    return holdOnEvent;
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStep#getMainFlowStep()
   */
  @Override public CustomerWorkflowStep getMainFlowStep() {
    return mainFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowStep getNextStep() {
    CustomerWorkflowStep      nextStep = null;
    CustomerWorkflowStep      pStep    = this.getMainFlowStep();
    Set<CustomerWorkflowStep> steps    = null;

    steps = this.getWorkflowInstance().getSteps();

    if (steps != null) {
      for (CustomerWorkflowStep step : steps) {
        if (WorkflowStepStatus.FINISHED.equals(step.getStatus())
              && !WorkflowNodeType.END_NODE.equals(step.getNode().getType())
              && !WorkflowNodeType.STATIC_PAGE_NODE.equals(step.getNode().getType())) {
          if (step.getStepNumber().equals(this.getStepNumber())) {
            nextStep = step;
          } else if (step.getStepNumber() > this.getStepNumber()) {
            nextStep = step;

            break;
          }
        }
      }
    }

    return nextStep;
  } // end method getNextStep

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStep#getNode()
   */
  @Override public CustomerWorkflowNode getNode() {
    return node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStep#getPreviousStep()
   */
  @Override public CustomerWorkflowStep getPreviousStep() {
    return previousStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for selected accounts.
   *
   * @return  Set
   */
  public Set<CustomerWorkflowAccountSelectorAnswer> getSelectedAccounts() {
    return selectedAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for skipped.
   *
   * @return  Boolean
   */
  public Boolean getSkipped() {
    if (skipped == null) {
      return Boolean.FALSE;
    }

    return skipped;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStep#getSubSteps()
   */
  @Override public Set<CustomerWorkflowStep> getSubSteps() {
    return subSteps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowStepTaskSnapshot getTaskSnapshot() {
    return taskSnapshot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskVersion getTaskVersion() {
    return taskVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   name  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public CustomerWorkflowTaskElementAnswer getTempAnswer(String name) {
    return tempAnswers.get(name);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<String, String> getUpdateActionResponse() {
    return updateActionResponse;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStep#getWorkflow()
   */
  @Override public CustomerWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowStep#getWorkflowInstance()
   */
  @Override public CustomerWorkflowInstance getWorkflowInstance() {
    return workflowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((mainFlowStep != null) ? mainFlowStep.hashCode() : 0);
    result = (31 * result) + ((node != null) ? node.hashCode() : 0);
    result = (31 * result) + ((previousStep != null) ? previousStep.hashCode() : 0);
    result = (31 * result) + ((workflow != null) ? workflow.hashCode() : 0);
    result = (31 * result) + ((workflowInstance != null) ? workflowInstance.hashCode() : 0);
    result = (31 * result) + ((customer != null) ? customer.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isEntrySubFlowStep() {
    return (subSteps != null) && !subSteps.isEmpty();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  step  DOCUMENT ME!
   */
  public void paste(CustomerWorkflowStep step) {
    super.paste(step);
    step.setWorkflow(workflow);
    step.setMainFlowStep(mainFlowStep);
    step.setNode(node);
    step.setPreviousStep(previousStep);
    step.setWorkflowInstance(workflowInstance);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer.
   *
   * @param  customer  Customer
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  elementSnapshots  DOCUMENT ME!
   */
  public void setElementSnapshots(Set<CustomerWorkflowStepTaskElementSnapshot> elementSnapshots) {
    this.elementSnapshots = elementSnapshots;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event map survey flows.
   *
   * @param  eventMapSurveyFlows  Set
   */
  public void setEventMapSurveyFlows(Set<CustomerEventMapSurveyFlow> eventMapSurveyFlows) {
    this.eventMapSurveyFlows = eventMapSurveyFlows;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hold on event.
   *
   * @param  holdOnEvent  Boolean
   */
  public void setHoldOnEvent(Boolean holdOnEvent) {
    this.holdOnEvent = holdOnEvent;
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
   * DOCUMENT ME!
   *
   * @param  mainFlowStep  DOCUMENT ME!
   */
  public void setMainFlowStep(CustomerWorkflowStep mainFlowStep) {
    this.mainFlowStep = mainFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  node  DOCUMENT ME!
   */
  public void setNode(CustomerWorkflowNode node) {
    this.node = node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  previousStep  DOCUMENT ME!
   */
  public void setPreviousStep(CustomerWorkflowStep previousStep) {
    this.previousStep = previousStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for selected accounts.
   *
   * @param  selectedAccounts  Set
   */
  public void setSelectedAccounts(Set<CustomerWorkflowAccountSelectorAnswer> selectedAccounts) {
    this.selectedAccounts = selectedAccounts;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for skipped.
   *
   * @param  skipped  Boolean
   */
  public void setSkipped(Boolean skipped) {
    this.skipped = skipped;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  subSteps  DOCUMENT ME!
   */
  public void setSubSteps(Set<CustomerWorkflowStep> subSteps) {
    this.subSteps = subSteps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskSnapshot  DOCUMENT ME!
   */
  public void setTaskSnapshot(CustomerWorkflowStepTaskSnapshot taskSnapshot) {
    this.taskSnapshot = taskSnapshot;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskVersion  DOCUMENT ME!
   */
  public void setTaskVersion(CustomerWorkflowTaskVersion taskVersion) {
    this.taskVersion = taskVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  updateActionResponse  DOCUMENT ME!
   */
  public void setUpdateActionResponse(Map<String, String> updateActionResponse) {
    this.updateActionResponse = updateActionResponse;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflow  DOCUMENT ME!
   */
  public void setWorkflow(CustomerWorkflow workflow) {
    this.workflow = workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  workflowInstance  DOCUMENT ME!
   */
  public void setWorkflowInstance(CustomerWorkflowInstance workflowInstance) {
    this.workflowInstance = workflowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   key  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String updateActionResponse(String key) {
    return updateActionResponse.get(key);
  }
} // end class CustomerWorkflowStep
