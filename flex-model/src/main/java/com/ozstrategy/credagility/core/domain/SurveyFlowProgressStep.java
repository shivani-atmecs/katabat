package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * SurveyFlow Progress Step.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 15:13
 */
@Entity public class SurveyFlowProgressStep extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -1968428920447768552L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** description of the progress step. */
  @Column(
    nullable = false,
    length   = 255
  )
  protected String description;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** step Number. */
  @Column(nullable = false)
  protected Integer stepNumber;

  /** surveyFlow. */
  @JoinColumn(
    name     = "surveyFlowId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlow surveyFlow;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  step  SurveyFlowProgressStep
   */
  public void deepCopy(SurveyFlowProgressStep step) {
    this.setDescription(step.getDescription());
    this.setStepNumber(step.getStepNumber());
    this.setCreateDate(new Date());
    this.setLastUpdateDate(new Date());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    SurveyFlowProgressStep that = (SurveyFlowProgressStep) o;

    if (!description.equals(that.description)) {
      return false;
    }

    if (!id.equals(that.id)) {
      return false;
    }

    if (!stepNumber.equals(that.stepNumber)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return description;
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
   * getter method for step number.
   *
   * @return  Integer
   */
  public Integer getStepNumber() {
    return stepNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey flow.
   *
   * @return  SurveyFlow
   */
  public SurveyFlow getSurveyFlow() {
    return surveyFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + stepNumber.hashCode();
    result = (31 * result) + description.hashCode();

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for description.
   *
   * @param  description  String
   */
  public void setDescription(String description) {
    this.description = description;
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
   * setter method for step number.
   *
   * @param  stepNumber  Integer
   */
  public void setStepNumber(Integer stepNumber) {
    this.stepNumber = stepNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey flow.
   *
   * @param  surveyFlow  SurveyFlow
   */
  public void setSurveyFlow(SurveyFlow surveyFlow) {
    this.surveyFlow = surveyFlow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#toString()
   */
  @Override public String toString() {
    return "SurveyFlowProgressStep{"
      + "id=" + id
      + ", stepNumber=" + stepNumber
      + ", description='" + description + '\''
      + '}';
  }
} // end class SurveyFlowProgressStep
