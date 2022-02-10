package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
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

import com.ozstrategy.credagility.core.domain.workflow.WorkflowTaskStatus;


/**
 * This class is used to represent survey.
 *
 * <p><a href="PortfolioSurvey.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojerluo@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
  indexes = {
    @Index(
      name = "FKA1_activeVersionId",
      columnList = "activeVersionId"
    ), @Index(
      name = "FKA1_currentVersionId",
      columnList = "currentVersionId"
    )
  }
)
public class PortfolioSurvey extends AbstractPortfolioSurvey implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3842000216966336704L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Survey action, after survey was token, which actions need to be triggered. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "survey",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  protected Set<PortfolioSurveyAction> actions = new LinkedHashSet<PortfolioSurveyAction>();

  /** PortfolioSurveyVersion PK activeVersionId. */
  @JoinColumn(
    name       = "activeVersionId",
    nullable   = true,
    insertable = true,
    updatable  = true,
    unique     = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioSurveyVersion activeVersion;

  /** PortfolioSurveyVersion PK currentVersionId. */
  @JoinColumn(
    name       = "currentVersionId",
    nullable   = true,
    insertable = true,
    updatable  = true,
    unique     = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PortfolioSurveyVersion currentVersion;


  /** Question for this survey group. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "survey",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  @OrderBy("displayOrder asc, lastUpdateDate DESC")
  protected Set<PortfolioSurveyGroup> groups = new LinkedHashSet<PortfolioSurveyGroup>();


  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** Survey action, after survey was token, which actions need to be triggered. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "survey",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  @OrderBy("priority asc")
  protected Set<PortfolioSurveyNextPage> nextPages = new LinkedHashSet<PortfolioSurveyNextPage>();

  /** Survey Group Questions. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "survey",
    cascade  = { CascadeType.REMOVE, CascadeType.ALL }
  )
  @OrderBy("displayOrder asc")
  protected Set<PortfolioSurveyGroupQuestion> surveyQuestions = new LinkedHashSet<PortfolioSurveyGroupQuestion>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  action  DOCUMENT ME!
   */
  public void addAction(PortfolioSurveyAction action) {
    action.setSurvey(this);
    this.actions.add(action);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Add group to survey.
   *
   * @param  group  DOCUMENT ME!
   */
  public void addGroup(PortfolioSurveyGroup group) {
    group.setSurvey(this);
    this.groups.add(group);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   action  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyAction addOrUpdateAction(PortfolioSurveyAction action) {
    PortfolioSurveyAction curAction = getActionNameMap().get(action.getActionName());

    if (curAction == null) {
      // not found, just add new
      action.setSurvey(this);
      this.actions.add(action);

      return action;
    } else {
      curAction.update(action);

      return curAction;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   nextPage  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyNextPage addOrUpdateNextPage(PortfolioSurveyNextPage nextPage) {
    PortfolioSurveyNextPage curNextPage = null;
    Long                    id          = nextPage.getId();

    if (id != null) {
      curNextPage = this.getNexPageMap().get(nextPage.getId());
    }

    if (curNextPage == null) {
      // not found, just add new
      nextPage.setSurvey(this);
      this.nextPages.add(nextPage);

      return nextPage;
    } else {
      curNextPage.update(nextPage);

      return curNextPage;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  surveyQuestion  DOCUMENT ME!
   */
  public void addSurveyQuestion(PortfolioSurveyGroupQuestion surveyQuestion) {
    surveyQuestion.setSurvey(this);
    this.surveyQuestions.add(surveyQuestion);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  other  DOCUMENT ME!
   */
  public void copyElementGroupDetails(PortfolioSurvey other) {
    for (PortfolioSurveyGroup group : other.getGroups()) {
      addGroup(group.duplicate(this));
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurvey duplicate() {
    PortfolioSurvey newSurvey = new PortfolioSurvey();

    newSurvey.copy(this);

    for (PortfolioSurveyAction action : actions) {
      newSurvey.addAction(action.duplicate());
    }

// for (PortfolioSurveyGroup group : groups) {
// newSurvey.addGroup(group.duplicate(newSurvey));
// }

    for (PortfolioSurveyGroupVersion group : currentVersion.getGroups()) {
      newSurvey.addGroup(group.duplicate(newSurvey));
    }

    for (PortfolioSurveyNextPage nextPage : nextPages) {
      newSurvey.addOrUpdateNextPage(nextPage.duplicate());
    }

    newSurvey.status = "DRAFT";

    return newSurvey;
  } // end method duplicate

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.portfolio.AbstractPortfolioSurvey#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PortfolioSurvey)) {
      return false;
    }

    if (!super.equals(o)) {
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
  public Map<String, PortfolioSurveyAction> getActionNameMap() {
    Map<String, PortfolioSurveyAction> map = new LinkedHashMap<String, PortfolioSurveyAction>();

    for (PortfolioSurveyAction action : this.actions) {
      map.put(action.getActionName(), action);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioSurveyAction> getActions() {
    return actions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyVersion getActiveVersion() {
    return activeVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyVersion getCurrentVersion() {
    return currentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get group id -&gt; map.
   *
   * @return  get group id -&gt; map.
   */
  public Map<Long, PortfolioSurveyGroup> getGroupMap() {
    Map<Long, PortfolioSurveyGroup> map = new LinkedHashMap<Long, PortfolioSurveyGroup>();

    for (PortfolioSurveyGroup group : this.groups) {
      map.put(group.getId(), group);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get group header name -&gt; map.
   *
   * @return  get group id -&gt; map.
   */
  public Map<String, PortfolioSurveyGroup> getGroupNameMap() {
    Map<String, PortfolioSurveyGroup> map = new LinkedHashMap<String, PortfolioSurveyGroup>();

    for (PortfolioSurveyGroup group : this.groups) {
      map.put(group.getGroupHeader(), group);
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioSurveyGroup> getGroups() {
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
  public Map<Long, PortfolioSurveyNextPage> getNexPageMap() {
    Map<Long, PortfolioSurveyNextPage> map = new HashMap<Long, PortfolioSurveyNextPage>();

    if (this.nextPages != null) {
      for (PortfolioSurveyNextPage nextPage : this.nextPages) {
        map.put(nextPage.getId(), nextPage);
      }
    }

    return map;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioSurveyNextPage> getNextPages() {
    return nextPages;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<PortfolioSurveyGroupQuestion> getSurveyQuestions() {
    return surveyQuestions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   actionId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyAction removeAction(Long actionId) {
    for (PortfolioSurveyAction action : this.actions) {
      if (action.getId().equals(actionId)) {
        if (this.actions.remove(action)) {
          action.setSurvey(null);

          return action;
        }
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Remove group by group id.
   *
   * @param   groupId  DOCUMENT ME!
   *
   * @return  group been removed if success, otherwise return null
   */
  public PortfolioSurveyGroup removeGroup(Long groupId) {
    for (PortfolioSurveyGroup group : this.groups) {
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
   * @param   pageId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public PortfolioSurveyNextPage removeNextPage(Long pageId) {
    for (PortfolioSurveyNextPage nextPage : this.nextPages) {
      if (nextPage.getId().equals(pageId)) {
        if (this.nextPages.remove(nextPage)) {
          nextPage.setSurvey(null);

          return nextPage;
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
  public PortfolioSurveyGroupQuestion removeSurveyQuestion(long surveyQuestionId) {
    for (PortfolioSurveyGroupQuestion surveyQuestion : this.surveyQuestions) {
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
   * @param  actions  DOCUMENT ME!
   */
  public void setActions(Set<PortfolioSurveyAction> actions) {
    this.actions = actions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  activeVersion  DOCUMENT ME!
   */
  public void setActiveVersion(PortfolioSurveyVersion activeVersion) {
    this.activeVersion = activeVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  currentVersion  DOCUMENT ME!
   */
  public void setCurrentVersion(PortfolioSurveyVersion currentVersion) {
    this.currentVersion = currentVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  groups  DOCUMENT ME!
   */
  public void setGroups(Set<PortfolioSurveyGroup> groups) {
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
   * @param  nextPages  DOCUMENT ME!
   */
  public void setNextPages(Set<PortfolioSurveyNextPage> nextPages) {
    this.nextPages = nextPages;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  surveyQuestions  DOCUMENT ME!
   */
  public void setSurveyQuestions(Set<PortfolioSurveyGroupQuestion> surveyQuestions) {
    this.surveyQuestions = surveyQuestions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("PortfolioSurvey");
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
    this.alignAcrossGroup        = other.getAlignAcrossGroup();
    this.agentFooter             = other.getAgentFooter();
    this.agentIntroduction       = other.getAgentIntroduction();
    this.agentPostText           = other.getAgentPostText();
    this.agentTitle              = other.getAgentTitle();
    this.allowTempSave           = other.getAllowTempSave();
    this.allowConfirm            = other.getAllowConfirm();
    this.allowPrevious           = other.getAllowPrevious();
    this.allowNext               = other.getAllowNext();
    this.allowCancel             = other.getAllowCancel();
    this.tempSaveButtonText      = other.getTempSaveButtonText();
    this.confirmButtonText       = other.getConfirmButtonText();
    this.nextButtonText          = other.getNextButtonText();
    this.previousButtonText      = other.getPreviousButtonText();
    this.cancelButtonText        = other.getCancelButtonText();
    this.cancelButtonURL         = other.getCancelButtonURL();
    this.skipButtonText          = other.getSkipButtonText();
    this.skipButtonWarningText   = other.getSkipButtonWarningText();
    this.customerFooter          = other.getCustomerFooter();
    this.customerIntroduction    = other.getCustomerIntroduction();
    this.customerPostText        = other.getCustomerPostText();
    this.customerTitle           = other.getCustomerTitle();
    this.description             = other.getDescription();
    this.entryCriteria           = other.getEntryCriteria();
    this.groupsPerRow            = other.getGroupsPerRow();
    this.name                    = other.getName();
    this.priority                = other.getPriority();
    this.qaFixedTableLayOut      = other.getQaFixedTableLayOut();
    this.qaTextWidth             = other.getQaTextWidth();
    this.questionsPerRowInGroup  = other.getQuestionsPerRowInGroup();
    this.questionWidthPercentage = other.getQuestionWidthPercentage();

    this.questionTableHeader      = other.getQuestionTableHeader();
    this.restartNumberPerGroup    = other.getRestartNumberPerGroup();
    this.showAgentIntroduction    = other.getShowAgentIntroduction();
    this.showAgentPrintButton     = other.getShowAgentPrintButton();
    this.showAgentPostText        = other.getShowAgentPostText();
    this.showCustomerIntroduction = other.getShowCustomerIntroduction();
    this.showCustomerPrintButton  = other.getShowCustomerPrintButton();
    this.showCustomerPostText     = other.getShowCustomerPostText();
    this.showGroupHeader          = other.getShowGroupHeader();
    this.showQuestionNumber       = other.getShowQuestionNumber();
    this.status                   = WorkflowTaskStatus.DRAFT.toString();
    this.surveyCode               = other.getSurveyCode();
    this.surveyFrequency          = other.getSurveyFrequency();
    this.customerOnly             = other.getCustomerOnly();

    this.flexSiteNATitle                  = other.getFlexSiteNATitle();
    this.flexSiteNAText                   = other.getFlexSiteNAText();
    this.flexStationNATitle               = other.getFlexStationNATitle();
    this.flexStationNAText                = other.getFlexStationNAText();
    this.submitButtonText                 = other.getSubmitButtonText();
    this.changeButtonText                 = other.getChangeButtonText();
    this.btnAlignmentMode                 = other.getBtnAlignmentMode();
    this.allowCancelWorkflowInFlexSite    = other.getAllowCancelWorkflowInFlexSite();
    this.allowCancelWorkflowInFlexStation = other.getAllowCancelWorkflowInFlexStation();

    this.expirationDateExpression = other.getExpirationDateExpression();

    this.lastUpdateDate = new Date();

    this.showAgentPrintButton                  = other.getShowAgentPrintButton();
    this.showCustomerPrintButton               = other.getShowCustomerPrintButton();
    this.flexStationEndFlowTextAfterSubmission = other.getFlexStationEndFlowTextAfterSubmission();
    this.customerEndFlowTextAfterSubmission    = other.getCustomerEndFlowTextAfterSubmission();
    this.submitEndFlowUrl                      = other.getSubmitEndFlowUrl();
    this.customerEndFlowTextAfterNext          = other.getCustomerEndFlowTextAfterNext();
    this.flexStationEndFlowTextAfterNext       = other.getFlexStationEndFlowTextAfterNext();
  } // end method update
} // end class PortfolioSurvey
