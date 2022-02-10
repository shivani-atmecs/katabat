package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * Created with IntelliJ IDEA. User: weitang Date: 13-10-10 Time: PM2:34 To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity @Table public class PortfolioSurveyGroupQuestionVersion implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8894339771712051161L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Current version number. */
  @Column(nullable = false)
  protected Integer currentVersion;

  /** Question display order in group. */
  @Column(nullable = false)
  protected Integer displayOrder;

  /** Portfolio Survey group. */
  @JoinColumn(
    name       = "groupId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected PortfolioSurveyGroupVersion group;

  /** Group questionId. */
  @Column(
    name       = "groupQuestionId",
    updatable  = false,
    insertable = true,
    nullable   = false
  )
  protected Long groupQuestionId;

  /** Id, PK. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Portfolio Survey question. */
  @JoinColumn(
    name       = "questionId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected PortfolioQuestion question;

  /** Portfolio Survey. */
  @JoinColumn(
    name       = "surveyId",
    updatable  = true,
    insertable = true,
    nullable   = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected PortfolioSurveyVersion survey;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   survey  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyGroupQuestionVersion duplicate(PortfolioSurveyVersion survey) {
    PortfolioSurveyGroupQuestionVersion newGroupQuestionVersion = new PortfolioSurveyGroupQuestionVersion();
    newGroupQuestionVersion.displayOrder = displayOrder;
    newGroupQuestionVersion.question     = question;
    newGroupQuestionVersion.setSurvey(survey);
    newGroupQuestionVersion.setCurrentVersion(1);
    newGroupQuestionVersion.setGroupQuestionId(this.getGroupQuestionId());
    newGroupQuestionVersion.setGroup(this.getGroup());

    return newGroupQuestionVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   survey  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyGroupQuestion duplicate(PortfolioSurvey survey) {
    PortfolioSurveyGroupQuestion newGroupQuestion = new PortfolioSurveyGroupQuestion();
    newGroupQuestion.displayOrder = displayOrder;
    newGroupQuestion.question     = question;
    newGroupQuestion.setSurvey(survey);

    return newGroupQuestion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioSurveyGroupQuestionVersion)) {
      return false;
    }

    PortfolioSurveyGroupQuestionVersion that = (PortfolioSurveyGroupQuestionVersion) o;

    if ((currentVersion != null) ? (!currentVersion.equals(that.currentVersion)) : (that.currentVersion != null)) {
      return false;
    }

    if ((displayOrder != null) ? (!displayOrder.equals(that.displayOrder)) : (that.displayOrder != null)) {
      return false;
    }

    if ((question != null) ? (!question.equals(that.question)) : (that.question != null)) {
      return false;
    }

    if ((group != null) ? (!group.equals(that.group)) : (that.group != null)) {
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
  public Integer getCurrentVersion() {
    return currentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDisplayOrder() {
    return displayOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyGroupVersion getGroup() {
    return group;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getGroupQuestionId() {
    return groupQuestionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the id
   */
  public Long getId() {
    return this.id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioQuestion getQuestion() {
    return question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyVersion getSurvey() {
    return survey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = (currentVersion != null) ? currentVersion.hashCode() : 0;
    result = (31 * result) + ((displayOrder != null) ? displayOrder.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  currentVersion  DOCUMENT ME!
   */
  public void setCurrentVersion(Integer currentVersion) {
    this.currentVersion = currentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  displayOrder  DOCUMENT ME!
   */
  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  group  DOCUMENT ME!
   */
  public void setGroup(PortfolioSurveyGroupVersion group) {
    this.group = group;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groupQuestionId  DOCUMENT ME!
   */
  public void setGroupQuestionId(Long groupQuestionId) {
    this.groupQuestionId = groupQuestionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  id  the typeId to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  question  DOCUMENT ME!
   */
  public void setQuestion(PortfolioQuestion question) {
    this.question = question;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  survey  DOCUMENT ME!
   */
  public void setSurvey(PortfolioSurveyVersion survey) {
    this.survey = survey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PortfolioSurveyGroupQuestionVersion");
    sb.append("{id=").append(id);
    sb.append(", group=").append(group);
    sb.append(", question=").append(question);
    sb.append(", displayOrder=").append(displayOrder);
    sb.append('}');

    return sb.toString();
  }
} // end class PortfolioSurveyGroupQuestionVersion
