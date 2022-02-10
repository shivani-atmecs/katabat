package com.ozstrategy.credagility.core.domain.workflow.customer;

import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTaskGroup;
import com.ozstrategy.credagility.core.domain.workflow.customer.version.CustomerWorkflowTaskVersion;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by tangwei on 17/3/22.
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  03/22/2017 10:38
 */
@Entity @Table public class CustomerWorkflowTaskAudit extends BasicWorkflowTask implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -9052266335072987438L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  // TODO CHECK
  @Column
  @Type(type = "text")
  protected String         actionsString;

  /** DOCUMENT ME! */
  @Column
  @Type(type = "text")
  protected String         groupTasksString;

  /** DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** DOCUMENT ME! */
  // TODO CHECK
  @Column
  @Type(type = "text")
  protected String         nextPagesString;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "specialFunctionId",
    nullable   = true,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected CustomerWorkflowSpecialFunction specialFunction;

  /** TODO: DOCUMENT ME! */
  @Column
  @Type(type = "yes_no")
  protected Boolean         specialTask;

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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#equals(Object)
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

    CustomerWorkflowTaskAudit that = (CustomerWorkflowTaskAudit) o;

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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#getGroups()
   */
  @Override public Set<? extends BasicWorkflowTaskGroup> getGroups() {
    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getGroupTasksString() {
    return groupTasksString;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Override public Long getId() {
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
   * getter method for special function.
   *
   * @return  CustomerWorkflowSpecialFunction
   */
  public CustomerWorkflowSpecialFunction getSpecialFunction() {
    return specialFunction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for special task.
   *
   * @return  Boolean
   */
  public Boolean getSpecialTask() {
    if (specialTask == null) {
      return Boolean.FALSE;
    }

    return specialTask;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#getTaskElements()
   */
  @Override public Set<CustomerWorkflowTaskGroupElement> getTaskElements() {
    return null;
// return taskElements;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getTaskId() {
    return taskId;
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#hashCode()
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
   * @param  groupTasksString  DOCUMENT ME!
   */
  public void setGroupTasksString(String groupTasksString) {
    this.groupTasksString = groupTasksString;
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
   * setter method for special function.
   *
   * @param  specialFunction  CustomerWorkflowSpecialFunction
   */
  public void setSpecialFunction(CustomerWorkflowSpecialFunction specialFunction) {
    this.specialFunction = specialFunction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for special task.
   *
   * @param  specialTask  Boolean
   */
  public void setSpecialTask(Boolean specialTask) {
    this.specialTask = specialTask;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  taskId  DOCUMENT ME!
   */
  public void setTaskId(Long taskId) {
    this.taskId = taskId;
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
   * @see  com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowTask#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("CustomerWorkflowTaskAudit");
    sb.append("{id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", description='").append(description).append('\'');
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
  public void update(CustomerWorkflowTask other) {
    copy(other);
    this.taskId          = other.getId();
    this.version         = (other.getCurrentVersion() != null) ? other.getCurrentVersion().getVersion() : 1;
    this.specialTask     = other.getSpecialTask();
    this.specialFunction = other.getSpecialFunction();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  other  DOCUMENT ME!
   */
  public void update(CustomerWorkflowTaskVersion other) {
    copy(other);
    this.taskId          = other.getWorkflowTask().getId();
    this.version         = (other.getVersion() != null) ? other.getVersion() : 1;
    this.specialTask     = other.getSpecialTask();
    this.specialFunction = other.getSpecialFunction();
  }
} // end class CustomerWorkflowTaskAudit
