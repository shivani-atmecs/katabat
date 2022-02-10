package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.cmc.credagility.core.domain.customer.Customer;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowInstance;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  03/12/2017 14:39
 */
@Entity
@Table(name = "CustomerWorkflowInstance")
public class CustomerWorkflowInstance extends BasicWorkflowInstance<CustomerWorkflowStep> implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3646953072317800323L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowInstance"
  )
  @OrderBy("stepNumber asc")
  @Where(clause = "current = 'Y'")
  protected Set<CustomerWorkflowStep> currentStepSet = new LinkedHashSet<CustomerWorkflowStep>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "customerId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** DOCUMENT ME! */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowInstance"
  )
  @OrderBy("stepNumber asc")
  @Where(clause = "status != 'RETIRED'")
  protected Set<CustomerWorkflowStep> steps = new LinkedHashSet<CustomerWorkflowStep>();

  /** DOCUMENT ME! */
  @Cascade({ org.hibernate.annotations.CascadeType.ALL })
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "workflowInstance"
  )
  @OrderBy("stepNumber asc")
  protected Set<CustomerWorkflowStep> stepSet = new LinkedHashSet<CustomerWorkflowStep>();

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "triggerWorkflowInstanceId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowInstance triggerWorkflowInstance;

  /** The triggerWorkflowStep which trigger this flow. See Flow Action */
  @JoinColumn(
    name       = "triggerWorkflowStepId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowStep triggerWorkflowStep;

  /** DOCUMENT ME! */
  @JoinColumn(
    name       = "workflowId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflow workflow;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowInstance#equals(Object)
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

    CustomerWorkflowInstance that = (CustomerWorkflowInstance) o;

    if ((triggerWorkflowStep != null) ? (!triggerWorkflowStep.equals(that.triggerWorkflowStep))
                                      : (that.triggerWorkflowStep != null)) {
      return false;
    }

    if ((workflow != null) ? (!workflow.equals(that.workflow)) : (that.workflow != null)) {
      return false;
    }

    if ((customer != null) ? (!customer.equals(that.customer)) : (that.customer != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowInstance#getCurrentStepSet()
   */
  @Override public Set<CustomerWorkflowStep> getCurrentStepSet() {
    return currentStepSet;
  }

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
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowInstance#getSteps()
   */
  @Override public Set<CustomerWorkflowStep> getSteps() {
    return steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowInstance#getStepSet()
   */
  @Override public Set<CustomerWorkflowStep> getStepSet() {
    return stepSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trigger workflow instance.
   *
   * @return  CustomerWorkflowInstance
   */
  public CustomerWorkflowInstance getTriggerWorkflowInstance() {
    return triggerWorkflowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trigger workflow step.
   *
   * @return  CustomerWorkflowStep
   */
  public CustomerWorkflowStep getTriggerWorkflowStep() {
    return triggerWorkflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowInstance#getWorkflow()
   */
  @Override public CustomerWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowInstance#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((workflow != null) ? workflow.hashCode() : 0);
    result = (31 * result) + ((triggerWorkflowStep != null) ? triggerWorkflowStep.hashCode() : 0);
    result = (31 * result) + ((workflow != null) ? workflow.hashCode() : 0);
    result = (31 * result) + ((customer != null) ? customer.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  currentStepSet  DOCUMENT ME!
   */
  public void setCurrentStepSet(Set<CustomerWorkflowStep> currentStepSet) {
    this.currentStepSet = currentStepSet;
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
  public void setSteps(Set<CustomerWorkflowStep> steps) {
    this.steps = steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  stepSet  DOCUMENT ME!
   */
  public void setStepSet(Set<CustomerWorkflowStep> stepSet) {
    this.stepSet = stepSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trigger workflow instance.
   *
   * @param  triggerWorkflowInstance  CustomerWorkflowInstance
   */
  public void setTriggerWorkflowInstance(CustomerWorkflowInstance triggerWorkflowInstance) {
    this.triggerWorkflowInstance = triggerWorkflowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trigger workflow step.
   *
   * @param  triggerWorkflowStep  CustomerWorkflowStep
   */
  public void setTriggerWorkflowStep(CustomerWorkflowStep triggerWorkflowStep) {
    this.triggerWorkflowStep = triggerWorkflowStep;
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
} // end class CustomerWorkflowInstance
