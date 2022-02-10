package com.ozstrategy.credagility.core.domain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by yongliu on 9/2/16.
 *
 * @author   <a href="mailto:yong.liu@ozstrategy.com">Yong Liu</a>
 * @version  09/02/2016 15:21
 */
@Entity
@Table(name = "WorkflowSubMenu")
public class WorkflowSubMenu extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7207221380357557546L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  @Transient private SurveyFlow persistenceWorkflow;

  private Integer priority;

  @Column(length = 255)
  private String subMenuTitle;

  @JoinColumn(
    name     = "workflowId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private SurveyFlow workflow;

  @JoinColumn(
    name     = "workflowMenuId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private WorkflowMenu workflowMenu;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
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

    WorkflowSubMenu that = (WorkflowSubMenu) o;

    if ((subMenuTitle != null) ? (!subMenuTitle.equals(that.subMenuTitle)) : (that.subMenuTitle != null)) {
      return false;
    }

    if ((workflowMenu != null) ? (!workflowMenu.equals(that.workflowMenu)) : (that.workflowMenu != null)) {
      return false;
    }

    if ((priority != null) ? (!priority.equals(that.priority)) : (that.priority != null)) {
      return false;
    }

    return !((workflow != null) ? (!workflow.equals(that.workflow)) : (that.workflow != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for persistence workflow.
   *
   * @return  SurveyFlow
   */
  public SurveyFlow getPersistenceWorkflow() {
    if (null == persistenceWorkflow) {
      return workflow;
    }

    return persistenceWorkflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for priority.
   *
   * @return  Integer
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sub menu title.
   *
   * @return  String
   */
  public String getSubMenuTitle() {
    return subMenuTitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow.
   *
   * @return  SurveyFlow
   */
  public SurveyFlow getWorkflow() {
    return workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for workflow menu.
   *
   * @return  WorkflowMenu
   */
  public WorkflowMenu getWorkflowMenu() {
    return workflowMenu;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((subMenuTitle != null) ? subMenuTitle.hashCode() : 0);
    result = (31 * result) + ((workflowMenu != null) ? workflowMenu.hashCode() : 0);
    result = (31 * result) + ((priority != null) ? priority.hashCode() : 0);
    result = (31 * result) + ((workflow != null) ? workflow.hashCode() : 0);

    return result;
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
   * setter method for persistence workflow.
   *
   * @param  persistenceWorkflow  SurveyFlow
   */
  public void setPersistenceWorkflow(SurveyFlow persistenceWorkflow) {
    this.persistenceWorkflow = persistenceWorkflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for priority.
   *
   * @param  priority  Integer
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sub menu title.
   *
   * @param  subMenuTitle  String
   */
  public void setSubMenuTitle(String subMenuTitle) {
    this.subMenuTitle = subMenuTitle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow.
   *
   * @param  workflow  SurveyFlow
   */
  public void setWorkflow(SurveyFlow workflow) {
    this.workflow = workflow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for workflow menu.
   *
   * @param  workflowMenu  WorkflowMenu
   */
  public void setWorkflowMenu(WorkflowMenu workflowMenu) {
    this.workflowMenu = workflowMenu;
  }
} // end class WorkflowSubMenu
