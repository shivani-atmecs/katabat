package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.cmc.credagility.core.domain.event.Event;
import com.ozstrategy.credagility.core.domain.SurveyFlowInstance;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  03/15/2017 10:31
 */
@Entity
@Table(
  name              = "CustomerEventMapSurveyFlow",
  uniqueConstraints = @UniqueConstraint(columnNames = { "eventId", "customerWorkflowStepId", "surveyFlowInstanceId" })
)
public class CustomerEventMapSurveyFlow extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 4043027853556902460L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "eventId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Event event;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "surveyFlowInstanceId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowInstance surveyFlowInstance;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "customerWorkflowStepId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowStep workflowStep;

  @Column
  @Type(type = "yes_no")
  private Boolean isFinished = Boolean.FALSE;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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

    CustomerEventMapSurveyFlow that = (CustomerEventMapSurveyFlow) o;

    if ((event != null) ? (!event.equals(that.event)) : (that.event != null)) {
      return false;
    }

    if ((surveyFlowInstance != null) ? (!surveyFlowInstance.equals(that.surveyFlowInstance))
                                     : (that.surveyFlowInstance != null)) {
      return false;
    }

    if ((workflowStep != null) ? (!workflowStep.equals(that.workflowStep)) : (that.workflowStep != null)) {
      return false;
    }

    return (isFinished != null) ? isFinished.equals(that.isFinished) : (that.isFinished == null);
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event.
   *
   * @return  Event
   */
  public Event getEvent() {
    return event;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for finished.
   *
   * @return  Boolean
   */
  public Boolean getFinished() {
    return isFinished;
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
   * getter method for survey flow instance.
   *
   * @return  SurveyFlowInstance
   */
  public SurveyFlowInstance getSurveyFlowInstance() {
    return surveyFlowInstance;
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
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((event != null) ? event.hashCode() : 0);
    result = (31 * result) + ((surveyFlowInstance != null) ? surveyFlowInstance.hashCode() : 0);
    result = (31 * result) + ((workflowStep != null) ? workflowStep.hashCode() : 0);
    result = (31 * result) + ((isFinished != null) ? isFinished.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event.
   *
   * @param  event  Event
   */
  public void setEvent(Event event) {
    this.event = event;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for finished.
   *
   * @param  finished  Boolean
   */
  public void setFinished(Boolean finished) {
    isFinished = finished;
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
   * setter method for survey flow instance.
   *
   * @param  surveyFlowInstance  SurveyFlowInstance
   */
  public void setSurveyFlowInstance(SurveyFlowInstance surveyFlowInstance) {
    this.surveyFlowInstance = surveyFlowInstance;
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

} // end class CustomerEventMapSurveyFlow
