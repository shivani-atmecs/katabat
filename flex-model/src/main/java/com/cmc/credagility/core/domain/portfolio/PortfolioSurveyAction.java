package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to represent the actions after survey was taken.
 *
 * <p><a href="PortfolioSurveyAction.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojerluo@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
@Entity @Table public class PortfolioSurveyAction extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8092697330862951259L;

  /** TODO: DOCUMENT ME! */
  public static String PROGRAM_ACTION = "program";

  /** TODO: DOCUMENT ME! */
  public static String CHANNEL_ACTION = "channel";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Survey action name. */
  @Column(length = 256)
  protected String actionName;

  /** <code>true</code> enabled. */
  @Column(
    name             = "enabled",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean enabled;

  /** Criteria for trigger this action. */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String entryCriteria;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** Survey group. */
  @JoinColumn(
    name     = "surveyId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected PortfolioSurvey survey;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyAction duplicate() {
    PortfolioSurveyAction newAction = new PortfolioSurveyAction();
    newAction.entryCriteria = entryCriteria;
    newAction.actionName    = actionName;
    newAction.enabled       = enabled;

    return newAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioSurveyAction)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioSurveyAction that = (PortfolioSurveyAction) o;

    if ((actionName != null) ? (!actionName.equals(that.actionName)) : (that.actionName != null)) {
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
  public String getActionName() {
    return actionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getEnabled() {
    return enabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getEntryCriteria() {
    return entryCriteria;
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
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((actionName != null) ? actionName.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  actionName  DOCUMENT ME!
   */
  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  enabled  DOCUMENT ME!
   */
  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  entryCriteria  DOCUMENT ME!
   */
  public void setEntryCriteria(String entryCriteria) {
    this.entryCriteria = entryCriteria;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PortfolioSurveyAction");
    sb.append("{id=").append(id);
    sb.append(", actionName='").append(actionName).append('\'');
    sb.append(", entryCriteria='").append(entryCriteria).append('\'');
    sb.append(", survey=").append(survey);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  other  DOCUMENT ME!
   */
  public void update(PortfolioSurveyAction other) {
    this.actionName     = other.getActionName();
    this.entryCriteria  = other.getEntryCriteria();
    this.enabled        = other.getEnabled();
    this.lastUpdateDate = new Date();
  }
} // end class PortfolioSurveyAction
