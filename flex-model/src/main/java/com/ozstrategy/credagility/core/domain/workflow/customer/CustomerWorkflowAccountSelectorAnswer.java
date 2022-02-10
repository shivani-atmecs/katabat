package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.responsible.Responsible;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by tangwei on 17/4/18.
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  04/18/2017 10:17
 */
@Entity
@Table(name = "CustomerWorkflowAccountSelectorAnswer")
public class CustomerWorkflowAccountSelectorAnswer implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -8339222937472007811L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "answerDate",
    nullable  = false,
    updatable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date answerDate;

  /** TODO: DOCUMENT ME! */
  @Column(length = 20)
  protected String channel;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "customerId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data",
    length = 1024
  )
  protected String data;

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "answerId",
    nullable = false
  )
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "responsibleId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "workflowId",
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflow workflow;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "workflowStepId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowStep workflowStep;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if ((obj == null) || (obj.getClass() != getClass())) {
      return false;
    }

    if (!super.equals(obj)) {
      return false;
    }

    CustomerWorkflowAccountSelectorAnswer that = (CustomerWorkflowAccountSelectorAnswer) obj;

    if ((data != null) ? (!data.equals(that.data)) : (that.data != null)) {
      return false;
    }

    if ((channel != null) ? (!channel.equals(that.channel)) : (that.channel != null)) {
      return false;
    }

    if ((answerDate != null) ? (!answerDate.equals(that.answerDate)) : (that.answerDate != null)) {
      return false;
    }

    if ((customer != null) ? (!customer.equals(that.customer)) : (that.customer != null)) {
      return false;
    }

    if ((workflowStep != null) ? (!workflowStep.equals(that.workflowStep)) : (that.workflowStep != null)) {
      return false;
    }

    if ((workflow != null) ? (!workflow.equals(that.workflow)) : (that.workflow != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for answer date.
   *
   * @return  Date
   */
  public Date getAnswerDate() {
    return answerDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel.
   *
   * @return  String
   */
  public String getChannel() {
    return channel;
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
   * getter method for data.
   *
   * @return  String
   */
  public String getData() {
    return data;
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
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow.
   *
   * @return  CustomerWorkflow
   */
  public CustomerWorkflow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow step.
   *
   * @return  CustomerWorkflowStep
   */
  public CustomerWorkflowStep getWorkflowStep() {
    return workflowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((channel != null) ? channel.hashCode() : 0);
    result = (31 * result) + ((data != null) ? data.hashCode() : 0);
    result = (31 * result) + ((answerDate != null) ? answerDate.hashCode() : 0);
    result = (31 * result) + ((workflowStep != null) ? workflowStep.hashCode() : 0);
    result = (31 * result) + ((workflow != null) ? workflow.hashCode() : 0);
    result = (31 * result) + ((customer != null) ? customer.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for answer date.
   *
   * @param  answerDate  Date
   */
  public void setAnswerDate(Date answerDate) {
    this.answerDate = answerDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel.
   *
   * @param  channel  String
   */
  public void setChannel(String channel) {
    this.channel = channel;
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
   * setter method for data.
   *
   * @param  data  String
   */
  public void setData(String data) {
    this.data = data;
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
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow.
   *
   * @param  workflow  CustomerWorkflow
   */
  public void setWorkflow(CustomerWorkflow workflow) {
    this.workflow = workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow step.
   *
   * @param  workflowStep  CustomerWorkflowStep
   */
  public void setWorkflowStep(CustomerWorkflowStep workflowStep) {
    this.workflowStep = workflowStep;
  }
} // end class CustomerWorkflowAccountSelectorAnswer
