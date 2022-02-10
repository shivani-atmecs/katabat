package com.ozstrategy.credagility.core.domain.workflow.bci.version;

import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCWorkflowTask;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.bci.BCWorkflowTaskGroup;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created with IntelliJ IDEA. User: yongliu Date: 10/9/13 Time: 3:42 PM To change this template use File | Settings |
 * File Templates.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCWorkflowTaskGroupVersion")
public class BCWorkflowTaskGroupVersion extends BasicWorkflowTaskGroup implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3495183290815637789L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** BCWorkflowTaskGroupElementVersion. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "group",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  @OrderBy("displayOrder asc")
  protected Set<BCWorkflowTaskGroupElementVersion> groupElements =
    new LinkedHashSet<BCWorkflowTaskGroupElementVersion>();

  /** Primary key. */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** Task group. */
  @JoinColumn(
    name     = "taskId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected BCWorkflowTaskVersion task;

  /** Task group id. */
  @Column(
    name       = "taskGroupId",
    updatable  = false,
    insertable = true,
    nullable   = false
  )
  protected Long taskGroupId;

  /** Version number. */
  protected Integer version = 1;

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
   * @param  groupElement  DOCUMENT ME!
   */
  public void addGroupElement(BCWorkflowTaskGroupElementVersion groupElement) {
    groupElement.setGroup(this);
    this.getGroupElements().add(groupElement);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   task  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskGroupVersion duplicate(BCWorkflowTaskVersion task) {
    BCWorkflowTaskGroupVersion newGroup = new BCWorkflowTaskGroupVersion();
    newGroup.displayOrder = displayOrder;
    newGroup.groupHeader  = groupHeader;
    newGroup.setTaskGroupId(this.getTaskGroupId());
    newGroup.setAllowShowMoreBtn(this.getAllowShowMoreBtn());
    newGroup.setShowMoreBtnText(this.getShowMoreBtnText());
    newGroup.setSectionName(this.getSectionName());

    for (BCWorkflowTaskGroupElementVersion groupElement : groupElements) {
      newGroup.addGroupElement(groupElement.duplicate(task));
    }

    return newGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   task  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskGroup duplicate(BCWorkflowTask task) {
    BCWorkflowTaskGroup newGroup = new BCWorkflowTaskGroup();
    newGroup.setDisplayOrder(displayOrder);
    newGroup.setGroupHeader(groupHeader);
    newGroup.setAllowShowMoreBtn(this.getAllowShowMoreBtn());
    newGroup.setShowMoreBtnText(this.getShowMoreBtnText());
    newGroup.setSectionName(this.getSectionName());

    for (BCWorkflowTaskGroupElementVersion groupElement : groupElements) {
      newGroup.addGroupElement(groupElement.duplicate(task));
    }
// for (PortfolioSurveyGroupQuestion groupQuestion : groupElements) {
// newGroup.addGroupQuestion(groupQuestion.duplicate(survey));
// }

    return newGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof BCWorkflowTaskGroupVersion)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    BCWorkflowTaskGroupVersion that = (BCWorkflowTaskGroupVersion) o;

    if ((version != null) ? (!version.equals(that.version)) : (that.version != null)) {
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#getActiveElements()
   */
  @Override public Set<? extends BasicWorkflowTaskElement> getActiveElements() {
    Set<BCWorkflowTaskElementVersion> questions = new LinkedHashSet<BCWorkflowTaskElementVersion>();

    for (BCWorkflowTaskGroupElementVersion groupQuestion : groupElements) {
      questions.add(groupQuestion.getTaskElement().getActiveVersion());
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
    if (allowShowMoreBtn == null) {
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
  @Override public Set<BCWorkflowTaskElement> getElements() {
    Set<BCWorkflowTaskElement> questions = new LinkedHashSet<BCWorkflowTaskElement>();

    for (BCWorkflowTaskGroupElementVersion groupQuestion : groupElements) {
      questions.add(groupQuestion.getTaskElement());
    }

    return questions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#getGroupElements()
   */
  @Override public Set<BCWorkflowTaskGroupElementVersion> getGroupElements() {
    return groupElements;
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#getTask()
   */
  @Override public BasicWorkflowTask getTask() {
    return task;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getTaskGroupId() {
    return taskGroupId;
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
   * @see  Object#hashCode()
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
   * @param   elementId  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskGroupElementVersion removeGroupElement(Long elementId) {
    for (BCWorkflowTaskGroupElementVersion groupElement : groupElements) {
      if (groupElement.getTaskElement().getId().equals(elementId)) {
        this.getGroupElements().remove(groupElement);
        groupElement.setGroup(null);

        return groupElement;
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
   * @param  groupElements  DOCUMENT ME!
   */
  public void setGroupElements(Set<BCWorkflowTaskGroupElementVersion> groupElements) {
    this.groupElements = groupElements;
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
   * @param  task  DOCUMENT ME!
   */
  public void setTask(BCWorkflowTaskVersion task) {
    this.task = task;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskGroupId  DOCUMENT ME!
   */
  public void setTaskGroupId(Long taskGroupId) {
    this.taskGroupId = taskGroupId;
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

  public static String replaceSpecStr(String orgStr){
    String regEx="[~·`!！@#￥$%^……&*（()=+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";
    Pattern p = Pattern.compile(regEx);
    Matcher m = p.matcher(orgStr);
    return m.replaceAll("");
  }
} // end class BCWorkflowTaskGroupVersion
