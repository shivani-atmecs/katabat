package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


/**
 * Created by IntelliJ IDEA. User: ye Date: May 7, 2010 Time: 12:11:34 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity @Table public class PortfolioSurveyAudit extends AbstractPortfolioSurvey implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -8353176515891875783L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /**
   * All of the Task's Action <code>Channel Action</code> <code>Program Action</code> <code>Variable Action</code>
   * <code>Update Action</code> <code>Flow Action.</code>
   */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String actionsString;


  /** Stored the question in this task info. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String groupQuestionsString;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** The String of next page url. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String nextPagesString;

  /** TODO: DOCUMENT ME! */
  @Column protected Long surveyId;

  /**
   * Action List.
   *
   * <ul>
   *   <li>Create</li>
   *   <li>Update</li>
   *   <li>Delete</li>
   *   <li>Disable</li>
   *   <li>Enable</li>
   *   <li>Publish</li>
   * </ul>
   *
   * @see  com.ozstrategy.credagility.core.domain.AuditOperation
   */
  @Column(
    nullable = false,
    length   = 32
  )
  private String action;

  private Integer version = 0;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.portfolio.AbstractPortfolioSurvey#equals(java.lang.Object)
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

    PortfolioSurveyAudit that = (PortfolioSurveyAudit) o;

    if ((action != null) ? (!action.equals(that.action)) : (that.action != null)) {
      return false;
    }

    if ((groupQuestionsString != null) ? (!groupQuestionsString.equals(that.groupQuestionsString))
                                       : (that.groupQuestionsString != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((surveyId != null) ? (!surveyId.equals(that.surveyId)) : (that.surveyId != null)) {
      return false;
    }

    if ((version != null) ? (!version.equals(that.version)) : (that.version != null)) {
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
  public String getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getActionsString() {
    return actionsString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getGroupQuestionsString() {
    return groupQuestionsString;
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
  public String getNextPagesString() {
    return nextPagesString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getSurveyId() {
    return surveyId;
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
   * @see  com.cmc.credagility.core.domain.portfolio.AbstractPortfolioSurvey#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((groupQuestionsString != null) ? groupQuestionsString.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((surveyId != null) ? surveyId.hashCode() : 0);
    result = (31 * result) + ((action != null) ? action.hashCode() : 0);
    result = (31 * result) + ((version != null) ? version.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  action  DOCUMENT ME!
   */
  public void setAction(String action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  actionsString  DOCUMENT ME!
   */
  public void setActionsString(String actionsString) {
    this.actionsString = actionsString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groupQuestionsString  DOCUMENT ME!
   */
  public void setGroupQuestionsString(String groupQuestionsString) {
    this.groupQuestionsString = groupQuestionsString;
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
   * @param  nextPagesString  DOCUMENT ME!
   */
  public void setNextPagesString(String nextPagesString) {
    this.nextPagesString = nextPagesString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  surveyId  DOCUMENT ME!
   */
  public void setSurveyId(Long surveyId) {
    this.surveyId = surveyId;
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
   * @see  com.cmc.credagility.core.domain.base.CreatorEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PortfolioSurveyAudit");
    sb.append("{id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", description='").append(description).append('\'');
    sb.append(", portfolio=").append(portfolio.getPortfolioId());
// sb.append(", questions=").append(questions);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  other  DOCUMENT ME!
   */
  public void update(PortfolioSurvey other) {
    copy(other);
    this.surveyId             = other.getId();
    this.version              = (other.getCurrentVersion() != null) ? other.getCurrentVersion().getVersion() : 1;
    this.actionsString        = other.getActions().toString();
    this.nextPagesString      = other.getNextPages().toString();
    this.groupQuestionsString = other.getGroups().toString();
  } // end method update

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  other  DOCUMENT ME!
   */
  public void update(PortfolioSurveyVersion other) {
    copy(other);
    this.surveyId             = other.getSurvey().getId();
    this.version              = (other.getVersion() != null) ? other.getVersion() : 1;
    this.groupQuestionsString = other.getGroups().toString();
  } // end method update
} // end class PortfolioSurveyAudit
