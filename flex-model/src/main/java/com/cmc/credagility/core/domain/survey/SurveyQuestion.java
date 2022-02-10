package com.cmc.credagility.core.domain.survey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to represent survey questions. Survey questions are a collection of facts we want to collect.
 * These facts can be grouped in different styles such as multi-choice, single-choice, etc in JSP.
 *
 * <p><a href="SurveyQuestion.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:yzhang@bridgeforce.com">Ye Zhang</a>
 * @version  10/15/2014 15:23
 */
@Entity
@Table(name = "SurveyQuestion")
public class SurveyQuestion extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3834363761436740188L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "requireData",
    nullable         = false,
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean requireData = false;

  // npelleti, 07/30, USBank, Removed unique constraint
  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "surveyQuestionId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long surveyQuestionId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "surveyQuestionText",
    length = 512
  )
  protected String surveyQuestionText;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final SurveyQuestion other = (SurveyQuestion) obj;

    if (requireData == null) {
      if (other.getRequireData() != null) {
        return false;
      }
    } else if (!requireData.equals(other.getRequireData())) {
      return false;
    }

    if (surveyQuestionText == null) {
      if (other.getSurveyQuestionText() != null) {
        return false;
      }
    } else if (!surveyQuestionText.equals(other.getSurveyQuestionText())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * True means this question (fact) requires data in corresponding survey answer. If there is no data, then survey
   * answer for this survey question will not be persisted. If this field is true, validAnswer flag in SurveyAnswer
   * should be ignored when consider whether to persist SurveyAnswer or not. Do not persist Survey Answer if no data
   * even validAnswer is true. Do persist it if has data even validAnswer is false. If this field is false, then this
   * flag is ignored. Do not persist survey answer if validAnswer is false. Do persist it if validAnswer is true.
   *
   * @return  true means this question (fact) requires data in corresponding survey answer.
   */
  public Boolean getRequireData() {
    return requireData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for survey question id.
   *
   * @return  Long
   */
  public Long getSurveyQuestionId() {
    return surveyQuestionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The question text is for qucik reference. The realy text is in the resource bundle where the texts are
   * internationalized.
   *
   * @return  the question text is for qucik reference.
   */
  public String getSurveyQuestionText() {
    return surveyQuestionText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = 1;
    result = (PRIME * result)
      + ((requireData == null) ? 0 : requireData.hashCode());
    result = (PRIME * result)
      + ((surveyQuestionText == null) ? 0 : surveyQuestionText.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for require data.
   *
   * @param  requireData  Boolean
   */
  public void setRequireData(Boolean requireData) {
    this.requireData = requireData;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey question id.
   *
   * @param  surveyQuestionId  Long
   */
  public void setSurveyQuestionId(Long surveyQuestionId) {
    this.surveyQuestionId = surveyQuestionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for survey question text.
   *
   * @param  surveyQuestionText  String
   */
  public void setSurveyQuestionText(String surveyQuestionText) {
    this.surveyQuestionText = surveyQuestionText;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("SurveyQuestion ( ").append(super.toString()).append(TAB).append("surveyQuestionText = ").append(
      this.surveyQuestionText).append(TAB).append("requireData = ").append(this.requireData).append(
      TAB).append(" )");

    return retValue.toString();
  }

} // end class SurveyQuestion
