package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import java.util.LinkedHashSet;
import java.util.Set;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;


import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * Created with IntelliJ IDEA. User: weitang Date: 13-10-10 Time: PM2:36 To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity @Table public class PortfolioSurveyGroupVersion extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3415980508879619102L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Current verison number. */
  @Column(nullable = false)
  protected Integer currentVersion;

  /** Group display order. */
  @Column protected Integer displayOrder;

  /** Group display header. */
  @Column(
    columnDefinition = "LONGTEXT",
    nullable         = false
  )
  @Lob protected String groupHeader = "";

  /** Survey Group Questions. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "group",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  @OrderBy("displayOrder asc")
  protected Set<PortfolioSurveyGroupQuestionVersion> groupQuestions =
    new LinkedHashSet<PortfolioSurveyGroupQuestionVersion>();

  /** Document Type PK. */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** Survey group. */
  @JoinColumn(
    name     = "surveyId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioSurveyVersion survey;

  /** Survey groupId. */
  @Column(
    name       = "surveyGroupId",
    updatable  = false,
    insertable = true,
    nullable   = false
  )
  protected Long surveyGroupId;

  /** CA-11591 Allow show more button Default is false. */
  @Column
  @Convert(converter = StringBooleanConverter.class)
  private Boolean         allowShowMoreBtn = Boolean.FALSE;

  /**
   * CA-11591 The group/section name, may be lots of group belongs this section if the @allowShowMoreBtn is True, then
   * this field is required.
   */
  @Column(length = 255)
  private String sectionName;

  /** CA-11591 The show more button text if the @allowShowMoreBtn is True, then this field is required. */
  @Column(length = 255)
  private String showMoreBtnText;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   orgStr  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String replaceSpecStr(String orgStr) {
    String  regEx = "[~·`!！@#￥$%^……&*（()=+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";
    Pattern p     = Pattern.compile(regEx);
    Matcher m     = p.matcher(orgStr);

    return m.replaceAll("");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groupQuestion  DOCUMENT ME!
   */
  public void addGroupQuestion(PortfolioSurveyGroupQuestionVersion groupQuestion) {
    groupQuestion.setGroup(this);
    this.groupQuestions.add(groupQuestion);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   surveyVersion  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyGroupVersion duplicate(PortfolioSurveyVersion surveyVersion) {
    PortfolioSurveyGroupVersion newGroup = new PortfolioSurveyGroupVersion();
    newGroup.displayOrder   = displayOrder;
    newGroup.groupHeader    = groupHeader;
    newGroup.currentVersion = 1;
    newGroup.setSurveyGroupId(this.getSurveyGroupId());

    for (PortfolioSurveyGroupQuestionVersion groupQuestionVersion : groupQuestions) {
      newGroup.addGroupQuestion(groupQuestionVersion.duplicate(surveyVersion));
    }

    return newGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   survey  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyGroup duplicate(PortfolioSurvey survey) {
    PortfolioSurveyGroup newGroup = new PortfolioSurveyGroup();
    newGroup.displayOrder = displayOrder;
    newGroup.groupHeader  = groupHeader;
    newGroup.setAllowShowMoreBtn(this.getAllowShowMoreBtn());
    newGroup.setShowMoreBtnText(this.getShowMoreBtnText());
    newGroup.setSectionName(this.getSectionName());

    for (PortfolioSurveyGroupQuestionVersion groupQuestion : groupQuestions) {
      newGroup.addGroupQuestion(groupQuestion.duplicate(survey));
    }

    return newGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioSurveyGroupVersion)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PortfolioSurveyGroupVersion that = (PortfolioSurveyGroupVersion) o;

    if ((currentVersion != null) ? (!currentVersion.equals(that.currentVersion)) : (that.currentVersion != null)) {
      return false;
    }

    if ((displayOrder != null) ? (!displayOrder.equals(that.displayOrder)) : (that.displayOrder != null)) {
      return false;
    }

    if ((groupHeader != null) ? (!groupHeader.equals(that.groupHeader)) : (that.groupHeader != null)) {
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
  public Set<PortfolioQuestionVersion> getActiveQuestionVersion() {
    Set<PortfolioQuestionVersion> questions = new LinkedHashSet<PortfolioQuestionVersion>();

    for (PortfolioSurveyGroupQuestionVersion groupQuestion : groupQuestions) {
      questions.add(groupQuestion.getQuestion().getActiveVersion());
    }

    return questions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowShowMoreBtn() {
    if (null == allowShowMoreBtn) {
      return Boolean.FALSE;
    }

    return allowShowMoreBtn;
  }

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
  public String getDisplayGroupHeaderWithColon() {
    if (StringUtils.hasText(groupHeader)) {
      if (groupHeader.endsWith(":")) {
        return groupHeader;
      }

      return groupHeader + ":";
    }

    return "";
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
  public String getGroupHeader() {
    return groupHeader;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioSurveyGroupQuestionVersion> getGroupQuestions() {
    return groupQuestions;
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
  public Set<PortfolioQuestion> getQuestions() {
    Set<PortfolioQuestion> questions = new LinkedHashSet<PortfolioQuestion>();

    for (PortfolioSurveyGroupQuestionVersion groupQuestion : groupQuestions) {
      questions.add(groupQuestion.getQuestion());
    }

    return questions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSectionName() {
    return sectionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSectionNameWithDash() {
    if ((sectionName != null) && StringUtils.hasText(sectionName)) {
      return replaceSpecStr(sectionName).replaceAll("\\s+", "_");
    }

    return sectionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getShowMoreBtnText() {
    return showMoreBtnText;
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getSurveyGroupId() {
    return surveyGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((currentVersion != null) ? currentVersion.hashCode() : 0);
    result = (31 * result) + ((displayOrder != null) ? displayOrder.hashCode() : 0);
    result = (31 * result) + ((groupHeader != null) ? groupHeader.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groupQuestion  DOCUMENT ME!
   */
  public void removeGroupQuestion(PortfolioSurveyGroupQuestionVersion groupQuestion) {
    if (this.groupQuestions.remove(groupQuestion)) {
      groupQuestion.setGroup(null);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Remove group question.
   *
   * @param   questionVersionId  question to be removed
   *
   * @return  removed question
   */
  public PortfolioSurveyGroupQuestionVersion removeGroupQuestion(Long questionVersionId) {
    for (PortfolioSurveyGroupQuestionVersion groupQuestion : this.groupQuestions) {
      if (groupQuestion.getQuestion().getId().equals(questionVersionId)) {
        this.groupQuestions.remove(groupQuestion);
        groupQuestion.setGroup(null);

        return groupQuestion;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   questionId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyGroupQuestionVersion removeGroupQuestionVersion(Long questionId) {
    for (PortfolioSurveyGroupQuestionVersion groupQuestion : this.groupQuestions) {
      if (groupQuestion.getQuestion().getId().equals(questionId)) {
        this.groupQuestions.remove(groupQuestion);
        groupQuestion.setGroup(null);

        return groupQuestion;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowShowMoreBtn  DOCUMENT ME!
   */
  public void setAllowShowMoreBtn(Boolean allowShowMoreBtn) {
    this.allowShowMoreBtn = allowShowMoreBtn;
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
   * @param  groupHeader  DOCUMENT ME!
   */
  public void setGroupHeader(String groupHeader) {
    this.groupHeader = groupHeader;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groupQuestions  DOCUMENT ME!
   */
  public void setGroupQuestions(Set<PortfolioSurveyGroupQuestionVersion> groupQuestions) {
    this.groupQuestions = groupQuestions;
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
   * @param  sectionName  DOCUMENT ME!
   */
  public void setSectionName(String sectionName) {
    this.sectionName = sectionName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  showMoreBtnText  DOCUMENT ME!
   */
  public void setShowMoreBtnText(String showMoreBtnText) {
    this.showMoreBtnText = showMoreBtnText;
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
   * DOCUMENT ME!
   *
   * @param  surveyGroupId  DOCUMENT ME!
   */
  public void setSurveyGroupId(Long surveyGroupId) {
    this.surveyGroupId = surveyGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PortfolioSurveyGroupVersion");
    sb.append("{id=").append(id);
    sb.append(", survey=").append(survey);
    sb.append(", displayOrder=").append(displayOrder);
    sb.append(", groupHeader='").append(groupHeader).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class PortfolioSurveyGroupVersion
