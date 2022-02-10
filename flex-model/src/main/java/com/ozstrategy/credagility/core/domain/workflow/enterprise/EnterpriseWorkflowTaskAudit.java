package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup;
import com.ozstrategy.credagility.core.domain.workflow.enterprise.version.EnterpriseWorkflowTaskVersion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/17/2014 13:33
 */
@Entity @Table public class EnterpriseWorkflowTaskAudit extends BasicWorkflowTask implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3921972929742954820L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  // TODO CHECK
  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String actionsString;


  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String groupTasksString;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  // TODO CHECK
  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String nextPagesString;

  /** TODO: DOCUMENT ME! */
  @Column protected Long taskId;

  /** Possible values are. */
  @Column(
    nullable = false,
    length   = 32
  )
  private String action;

  private Integer version;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
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

    EnterpriseWorkflowTaskAudit that = (EnterpriseWorkflowTaskAudit) o;

    if ((action != null) ? (!action.equals(that.action)) : (that.action != null)) {
      return false;
    }

    if ((nextPagesString != null) ? (!nextPagesString.equals(that.nextPagesString)) : (that.nextPagesString != null)) {
      return false;
    }

    if ((taskId != null) ? (!taskId.equals(that.taskId)) : (that.taskId != null)) {
      return false;
    }

    if ((version != null) ? (!version.equals(that.version)) : (that.version != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for action.
   *
   * @return  String
   */
  public String getAction() {
    return action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for actions string.
   *
   * @return  String
   */
  public String getActionsString() {
    return actionsString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for groups.
   *
   * @return  Set
   */
  @Override public Set<? extends BasicWorkflowTaskGroup> getGroups() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for group tasks string.
   *
   * @return  String
   */
  public String getGroupTasksString() {
    return groupTasksString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  @Override public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for next pages string.
   *
   * @return  String
   */
  public String getNextPagesString() {
    return nextPagesString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task elements.
   *
   * @return  Set
   */
  @Override public Set<EnterpriseWorkflowTaskGroupElement> getTaskElements() {
    return null;
// return taskElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for task id.
   *
   * @return  Long
   */
  public Long getTaskId() {
    return taskId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for version.
   *
   * @return  Integer
   */
  public Integer getVersion() {
    return version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((nextPagesString != null) ? nextPagesString.hashCode() : 0);
    result = (31 * result) + ((taskId != null) ? taskId.hashCode() : 0);
    result = (31 * result) + ((action != null) ? action.hashCode() : 0);
    result = (31 * result) + ((version != null) ? version.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for action.
   *
   * @param  action  String
   */
  public void setAction(String action) {
    this.action = action;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for actions string.
   *
   * @param  actionsString  String
   */
  public void setActionsString(String actionsString) {
    this.actionsString = actionsString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for group tasks string.
   *
   * @param  groupTasksString  String
   */
  public void setGroupTasksString(String groupTasksString) {
    this.groupTasksString = groupTasksString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for next pages string.
   *
   * @param  nextPagesString  String
   */
  public void setNextPagesString(String nextPagesString) {
    this.nextPagesString = nextPagesString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for task id.
   *
   * @param  taskId  Long
   */
  public void setTaskId(Long taskId) {
    this.taskId = taskId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for version.
   *
   * @param  version  Integer
   */
  public void setVersion(Integer version) {
    this.version = version;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("EnterpriseWorkflowTaskAudit");
    sb.append("{id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", description='").append(description).append('\'');
// sb.append(", questions=").append(questions);
    sb.append('}');

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  other  EnterpriseWorkflowTask
   */
  public void update(EnterpriseWorkflowTask other) {
    copy(other);
    this.taskId  = other.getId();
    this.version = (other.getCurrentVersion() != null) ? other.getCurrentVersion().getVersion() : 1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * update.
   *
   * @param  other  EnterpriseWorkflowTaskVersion
   */
  public void update(EnterpriseWorkflowTaskVersion other) {
    copy(other);
    this.taskId  = other.getWorkflowTask().getId();
    this.version = (other.getVersion() != null) ? other.getVersion() : 1;
  }
} // end class EnterpriseWorkflowTaskAudit
