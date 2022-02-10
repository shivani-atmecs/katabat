package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.cmc.credagility.core.domain.webactivity.WebActivity;
import com.ozstrategy.credagility.core.domain.CreatorEntity;
import com.ozstrategy.credagility.core.domain.SurveyFlowStep;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by tangwei on 17/5/9.
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  05/09/2017 11:27
 */
@Entity
@Table(
  name              = "WorkflowStepMapWebActivity",
  uniqueConstraints = @UniqueConstraint(columnNames = { "webActivityId", "surveyFlowStepId", "customerWorkflowStepId" })
)
public class WorkflowStepMapWebActivity extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8194891423236072658L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "customerWorkflowStepId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowStep customerWorkflowStep;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "surveyFlowStepId",
    nullable   = true,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowStep surveyFlowStep;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "webActivityId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected WebActivity webActivity;

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

    WorkflowStepMapWebActivity that = (WorkflowStepMapWebActivity) o;


    if ((customerWorkflowStep != null) ? (!customerWorkflowStep.equals(that.customerWorkflowStep))
                                       : (that.customerWorkflowStep != null)) {
      return false;
    }

    if ((surveyFlowStep != null) ? (!surveyFlowStep.equals(that.surveyFlowStep)) : (that.surveyFlowStep != null)) {
      return false;
    }

    if ((webActivity != null) ? (!webActivity.equals(that.webActivity)) : (that.webActivity != null)) {
      return false;
    }

    return true;

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer workflow step.
   *
   * @return  CustomerWorkflowStep
   */
  public CustomerWorkflowStep getCustomerWorkflowStep() {
    return customerWorkflowStep;
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
   * getter method for survey flow step.
   *
   * @return  SurveyFlowStep
   */
  public SurveyFlowStep getSurveyFlowStep() {
    return surveyFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for web activity.
   *
   * @return  WebActivity
   */
  public WebActivity getWebActivity() {
    return webActivity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((customerWorkflowStep != null) ? customerWorkflowStep.hashCode() : 0);
    result = (31 * result) + ((surveyFlowStep != null) ? surveyFlowStep.hashCode() : 0);
    result = (31 * result) + ((webActivity != null) ? webActivity.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer workflow step.
   *
   * @param  customerWorkflowStep  CustomerWorkflowStep
   */
  public void setCustomerWorkflowStep(CustomerWorkflowStep customerWorkflowStep) {
    this.customerWorkflowStep = customerWorkflowStep;
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
   * setter method for survey flow step.
   *
   * @param  surveyFlowStep  SurveyFlowStep
   */
  public void setSurveyFlowStep(SurveyFlowStep surveyFlowStep) {
    this.surveyFlowStep = surveyFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for web activity.
   *
   * @param  webActivity  WebActivity
   */
  public void setWebActivity(WebActivity webActivity) {
    this.webActivity = webActivity;
  }
} // end class WorkflowStepMapWebActivity
