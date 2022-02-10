package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to store survey group and survey question information.
 *
 * <p><a href="PortfolioSurveyGroupQuestion.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  uniqueConstraints = { @UniqueConstraint(columnNames = { "questionId", "surveyId", "groupId" }) },
  indexes           = {
    @Index(
      name          = "FKC6_questionId",
      columnList    = "questionId"
    )
  }
)
public class PortfolioSurveyGroupQuestion implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1155874656739787918L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

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
    cascade = CascadeType.REFRESH
  )
  protected PortfolioSurveyGroup group;

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
    cascade = CascadeType.REFRESH
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
    cascade = CascadeType.REFRESH
  )
  protected PortfolioSurvey survey;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   survey  group DOCUMENT ME!
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyGroupQuestionVersion duplicateVersion() {
    PortfolioSurveyGroupQuestionVersion newGroupQuestionVersion = new PortfolioSurveyGroupQuestionVersion();
    newGroupQuestionVersion.displayOrder = displayOrder;
    newGroupQuestionVersion.question     = question;
    newGroupQuestionVersion.setCurrentVersion(1);
    newGroupQuestionVersion.setGroupQuestionId(this.getId());

    return newGroupQuestionVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioSurveyGroupQuestion)) {
      return false;
    }

    PortfolioSurveyGroupQuestion that = (PortfolioSurveyGroupQuestion) o;

    if ((question != null) ? (!question.equals(that.question)) : (that.question != null)) {
      return false;
    }

    if ((group != null) ? (!group.equals(that.group)) : (that.group != null)) {
      return false;
    }

    if ((survey != null) ? (!survey.equals(that.survey)) : (that.survey != null)) {
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
  public Integer getDisplayOrder() {
    return displayOrder;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyGroup getGroup() {
    return group;
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
  public PortfolioSurvey getSurvey() {
    return survey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = (survey != null) ? survey.hashCode() : 0;
    result = (31 * result) + ((group != null) ? group.hashCode() : 0);
    result = (31 * result) + ((question != null) ? question.hashCode() : 0);

    return result;
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
  public void setGroup(PortfolioSurveyGroup group) {
    this.group = group;
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
  public void setSurvey(PortfolioSurvey survey) {
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
    sb.append("PortfolioSurveyGroupQuestion");
    sb.append("{id=").append(id);
    sb.append(", group=").append(group);
    sb.append(", question=").append(question);
    sb.append(", displayOrder=").append(displayOrder);
    sb.append('}');

    return sb.toString();
  }
} // end class PortfolioSurveyGroupQuestion
