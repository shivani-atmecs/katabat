package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 10/9/13 Time: 12:05 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */

@Entity
@Table(
  indexes = {
    @Index(
      name = "idx_version",
      columnList = "version"
    )
  }
)
public class PortfolioSurveyVersion extends AbstractPortfolioSurvey implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -4257999777883339577L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.portfolio.PortfolioSurveyGroupQuestionVersion
   */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "survey",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  @OrderBy("displayOrder asc")
  protected Set<PortfolioSurveyGroupVersion> groups = new LinkedHashSet<PortfolioSurveyGroupVersion>();

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** PortfolioSurvey PK surveyId. */
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
  protected PortfolioSurvey survey;

  /**
   * @see  com.cmc.credagility.core.domain.portfolio.PortfolioSurveyGroupQuestionVersion
   */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "survey",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  @OrderBy("displayOrder asc")
  protected Set<PortfolioSurveyGroupQuestionVersion> surveyQuestions =
    new LinkedHashSet<PortfolioSurveyGroupQuestionVersion>();

  /** version number. */
  protected Integer version;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  group  DOCUMENT ME!
   */
  public void addGroup(PortfolioSurveyGroupVersion group) {
    group.setSurvey(this);
    this.groups.add(group);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  surveyQuestion  DOCUMENT ME!
   */
  public void addSurveyQuestion(PortfolioSurveyGroupQuestionVersion surveyQuestion) {
    surveyQuestion.setSurvey(this);
    this.surveyQuestions.add(surveyQuestion);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  o  DOCUMENT ME!
   */
  public void copyFrom(PortfolioSurvey o) {
    super.copy(o);
    this.version = (o.getCurrentVersion() != null) ? (o.getCurrentVersion().getVersion() + 1) : 1;
  } // end method copyFrom

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioSurveyVersion)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioSurveyVersion that = (PortfolioSurveyVersion) o;

    if ((version != null) ? (!version.equals(that.version)) : (that.version != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<Long, PortfolioSurveyGroupVersion> getGroupMap() {
    Map<Long, PortfolioSurveyGroupVersion> map = new LinkedHashMap<Long, PortfolioSurveyGroupVersion>();

    for (PortfolioSurveyGroupVersion group : this.groups) {
      map.put(group.getSurveyGroupId(), group);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioSurveyGroupVersion> getGroups() {
    return groups;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurvey getSurvey() {
    return survey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioSurveyGroupQuestionVersion> getSurveyQuestions() {
    return surveyQuestions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getVersion() {
    return version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((version != null) ? version.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   groupId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyGroupVersion removeGroup(Long groupId) {
    for (PortfolioSurveyGroupVersion group : groups) {
      if (group.getId().equals(groupId)) {
        // found and try to remove it
        if (this.groups.remove(group)) {
          group.setSurvey(null);

          return group;
        } else {
          break;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   surveyQuestionId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyGroupQuestionVersion removeSurveyQuestion(long surveyQuestionId) {
    for (PortfolioSurveyGroupQuestionVersion surveyQuestion : this.surveyQuestions) {
      if (surveyQuestion.getId().equals(surveyQuestionId)) {
        this.surveyQuestions.remove(surveyQuestion);
        surveyQuestion.setSurvey(null);

        return surveyQuestion;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groups  DOCUMENT ME!
   */
  public void setGroups(Set<PortfolioSurveyGroupVersion> groups) {
    this.groups = groups;
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
   * @param  survey  DOCUMENT ME!
   */
  public void setSurvey(PortfolioSurvey survey) {
    this.survey = survey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  surveyQuestions  DOCUMENT ME!
   */
  public void setSurveyQuestions(Set<PortfolioSurveyGroupQuestionVersion> surveyQuestions) {
    this.surveyQuestions = surveyQuestions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  version  DOCUMENT ME!
   */
  public void setVersion(Integer version) {
    this.version = version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("PortfolioSurveyVersion{");
    sb.append("id=").append(id);
    sb.append("taskCode=").append(surveyCode);
    sb.append(", version=").append(version);
    sb.append('}');

    return sb.toString();
  }
} // end class PortfolioSurveyVersion
