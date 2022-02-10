package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to represent the actions after survey was taken.
 *
 * <p><a href="PortfolioSurveyAction.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojerluo@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
@Entity @Table public class PortfolioSurveyNextPage extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2392217526265955526L;

  /** TODO: DOCUMENT ME! */
  public static transient String DEFAULT_THANKYOU_PAGE = "thankYou";

  /** TODO: DOCUMENT ME! */
  public static transient String STATIC_PAGE = "static";

  /** TODO: DOCUMENT ME! */
  public static transient String ANOTHER_SURVEY = "anotherSurvey";

  /** TODO: DOCUMENT ME! */
  public static transient String PRESENT_PROGRAM = "presentProgram";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Criteria for trigger this action. */
  @Column(
    columnDefinition = "LONGTEXT",
    nullable         = true
  )
  @Lob protected String entryCriteria;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** PortfolioStaticPage PK nextStaticPageId. */
  @JoinColumn(
    name     = "nextStaticPageId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected PortfolioStaticPage nextStaticPage;

  /** Next survey code. */
  @Column(
    length   = 256,
    nullable = true
  )
  protected String nextSurveyCode;

  /** Survey next page priority. */
  @Column(nullable = false)
  protected Integer priority;

  /** Survey group. */
  @JoinColumn(
    name     = "surveyId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected PortfolioSurvey survey;

  @Transient private PortfolioSurvey nextSurvey = null;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyNextPage duplicate() {
    PortfolioSurveyNextPage newNextPage = new PortfolioSurveyNextPage();
    newNextPage.entryCriteria  = entryCriteria;
    newNextPage.nextStaticPage = nextStaticPage;
    newNextPage.nextSurveyCode = nextSurveyCode;
    newNextPage.priority       = priority;

    return newNextPage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
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

    PortfolioSurveyNextPage nextPage = (PortfolioSurveyNextPage) o;

    if ((entryCriteria != null) ? (!entryCriteria.equals(nextPage.entryCriteria)) : (nextPage.entryCriteria != null)) {
      return false;
    }

    if ((nextStaticPage != null) ? (!nextStaticPage.equals(nextPage.nextStaticPage))
                                 : (nextPage.nextStaticPage != null)) {
      return false;
    }

    if ((nextSurveyCode != null) ? (!nextSurveyCode.equals(nextPage.nextSurveyCode))
                                 : (nextPage.nextSurveyCode != null)) {
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
  public String getEntryCriteria() {
    return entryCriteria;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFlexStationText() {
    if (nextStaticPage != null) {
      return nextStaticPage.getFlexStationText();
    }

    return null;
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
  public PortfolioStaticPage getNextStaticPage() {
    return nextStaticPage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurvey getNextSurvey() {
    return nextSurvey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getNextSurveyCode() {
    return nextSurveyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPageType() {
    if (StringUtils.hasText(this.nextSurveyCode)) {
      return ANOTHER_SURVEY;
    } else if (getNextStaticPage() != null) {
      return STATIC_PAGE;
    }

    return DEFAULT_THANKYOU_PAGE;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getPriority() {
    return priority;
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
    result = (31 * result) + ((entryCriteria != null) ? entryCriteria.hashCode() : 0);
    result = (31 * result) + ((nextStaticPage != null) ? nextStaticPage.hashCode() : 0);
    result = (31 * result) + ((nextSurveyCode != null) ? nextSurveyCode.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isProgramPage() {
    if (this.nextStaticPage != null) {
      return "PresentProgram".equalsIgnoreCase(nextStaticPage.getPageName())
        || "Present Program".equalsIgnoreCase(nextStaticPage.getPageName())
        || "Program".equalsIgnoreCase(nextStaticPage.getPageName());
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isSurveyPage() {
    return StringUtils.hasText(this.nextSurveyCode);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public boolean isThankYouPage() {
    if (this.nextStaticPage != null) {
      return "Thank You".equalsIgnoreCase(nextStaticPage.getPageName())
        || "thankYou".equalsIgnoreCase(nextStaticPage.getPageName());
    }

    return false;
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
   * @param  nextStaticPage  DOCUMENT ME!
   */
  public void setNextStaticPage(PortfolioStaticPage nextStaticPage) {
    this.nextStaticPage = nextStaticPage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  nextSurvey  DOCUMENT ME!
   */
  public void setNextSurvey(PortfolioSurvey nextSurvey) {
    this.nextSurvey = nextSurvey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  nextSurveyCode  DOCUMENT ME!
   */
  public void setNextSurveyCode(String nextSurveyCode) {
    this.nextSurveyCode = nextSurveyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  priority  DOCUMENT ME!
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
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
    sb.append("PortfolioSurveyNextPage");
    sb.append("{entryCriteria='").append(entryCriteria).append('\'');
    sb.append(", id=").append(id);
    sb.append(", priority=").append(priority);
    sb.append(", survey=").append(survey);
    sb.append(", nextStaticPage=").append(nextStaticPage);
    sb.append(", nextSurveyCode='").append(nextSurveyCode).append('\'');
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  other  DOCUMENT ME!
   */
  public void update(PortfolioSurveyNextPage other) {
    this.entryCriteria  = other.getEntryCriteria();
    this.priority       = other.getPriority();
    this.nextStaticPage = other.getNextStaticPage();
    this.nextSurveyCode = other.getNextSurveyCode();
  }
} // end class PortfolioSurveyNextPage
