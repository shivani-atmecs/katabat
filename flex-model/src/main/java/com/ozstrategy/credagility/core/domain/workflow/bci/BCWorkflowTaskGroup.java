package com.ozstrategy.credagility.core.domain.workflow.bci;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskElement;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup;
import com.ozstrategy.credagility.core.domain.workflow.bci.version.BCWorkflowTaskGroupElementVersion;
import com.ozstrategy.credagility.core.domain.workflow.bci.version.BCWorkflowTaskGroupVersion;
import com.ozstrategy.credagility.core.domain.workflow.bci.version.BCWorkflowTaskVersion;
import org.hibernate.annotations.Type;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created with IntelliJ IDEA.
 *
 * <p>: Wang Yang : 13-2-26 : PM5:17</p>
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "BCWorkflowTaskGroup")
public class BCWorkflowTaskGroup extends BasicWorkflowTaskGroup implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6880157258787639804L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Task Group Elements. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "group",
    cascade  = { CascadeType.ALL, CascadeType.REMOVE }
  )
  @OrderBy("displayOrder asc")
  protected Set<BCWorkflowTaskGroupElement> groupElements = new LinkedHashSet<BCWorkflowTaskGroupElement>();

  /** Document Type PK. */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** Task group. */
  @JoinColumn(
    name     = "taskId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected BCWorkflowTask task;

  /** CA-11591 Allow show more button Default is false. */
  @Column
  @Type(type = "yes_no")
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
  public void addGroupElement(BCWorkflowTaskGroupElement groupElement) {
    groupElement.setGroup(this);
    this.groupElements.add(groupElement);
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
    newGroup.displayOrder = displayOrder;
    newGroup.groupHeader  = groupHeader;
    newGroup.setAllowShowMoreBtn(this.getAllowShowMoreBtn());
    newGroup.setShowMoreBtnText(this.getShowMoreBtnText());
    newGroup.setSectionName(this.getSectionName());

    for (BCWorkflowTaskGroupElement groupElement : groupElements) {
      newGroup.addGroupElement(groupElement.duplicate(task));
    }

    return newGroup;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   taskVersion  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BCWorkflowTaskGroupVersion duplicateGroupVersion(BCWorkflowTaskVersion taskVersion) {
    BCWorkflowTaskGroupVersion groupVersion = new BCWorkflowTaskGroupVersion();

    groupVersion.setTaskGroupId(this.getId());
    groupVersion.setGroupHeader(this.getGroupHeader());
    groupVersion.setDisplayOrder(this.getDisplayOrder());
    groupVersion.setTask(taskVersion);
    groupVersion.setAllowShowMoreBtn(this.getAllowShowMoreBtn());
    groupVersion.setShowMoreBtnText(this.getShowMoreBtnText());
    groupVersion.setSectionName(this.getSectionName());

    for (BCWorkflowTaskGroupElement groupElement : groupElements) {
      BCWorkflowTaskGroupElementVersion groupElementVersion = groupElement.duplicateVersion();
      groupElementVersion.setTaskVersion(taskVersion);
      groupElementVersion.setGroup(groupVersion);
      groupVersion.addGroupElement(groupElementVersion);
    }

    return groupVersion;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#equals(Object)
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

    BCWorkflowTaskGroup that = (BCWorkflowTaskGroup) o;

    if ((task != null) ? (!task.equals(that.task)) : (that.task != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#getActiveElements()
   */
  @Override public Set<? extends BasicWorkflowTaskElement> getActiveElements() {
    return Collections.emptySet();
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#getElements()
   */
  @Override public Set<BCWorkflowTaskElement> getElements() {
    Set<BCWorkflowTaskElement> questions = new LinkedHashSet<BCWorkflowTaskElement>();

    for (BCWorkflowTaskGroupElement groupQuestion : groupElements) {
      questions.add(groupQuestion.getTaskElement());
    }

    return questions;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup#getGroupElements()
   */
  @Override public Set<BCWorkflowTaskGroupElement> getGroupElements() {
    return groupElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Map<Long, BCWorkflowTaskGroupElement> getGroupQuestionsMap() {
    Map<Long, BCWorkflowTaskGroupElement> result = new HashMap<Long, BCWorkflowTaskGroupElement>();

    for (BCWorkflowTaskGroupElement groupQuestion : groupElements) {
      result.put(groupQuestion.getTaskElement().getId(), groupQuestion);
    }

    return result;
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
  @Override public BCWorkflowTask getTask() {
    return task;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((task != null) ? task.hashCode() : 0);

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
  public BCWorkflowTaskGroupElement removeGroupElement(Long elementId) {
    for (BCWorkflowTaskGroupElement groupElement : groupElements) {
      if (groupElement.getTaskElement().getId().equals(elementId)) {
        this.groupElements.remove(groupElement);
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
  public void setGroupElements(Set<BCWorkflowTaskGroupElement> groupElements) {
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
  public void setTask(BCWorkflowTask task) {
    this.task = task;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("BCWorkflowTaskGroup");
    sb.append("{id=").append(id);
    sb.append(", task=").append(task);
    sb.append(", displayOrder=").append(displayOrder);
    sb.append(", groupHeader='").append(groupHeader).append('\'');
    sb.append('}');

    return sb.toString();
  }
  //~ ------------------------------------------------------------------------------------------------------------------

  public static String replaceSpecStr(String orgStr){
    String regEx="[~·`!！@#￥$%^……&*（()=+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";
    Pattern p = Pattern.compile(regEx);
    Matcher m = p.matcher(orgStr);
    return m.replaceAll("");
  }
} // end class BCWorkflowTaskGroup
