package com.ozstrategy.credagility.core.domain.workflow.enterprise;

import com.cmc.credagility.core.domain.type.ScheduleStatus;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.workflow.basic.BasicWorkflowSchedule;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/17/2014 14:08
 */
@DiscriminatorColumn(
  name              = "category",
  discriminatorType = DiscriminatorType.STRING
)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(
  name    = "EnterpriseWorkflowSchedule",
  indexes = {
    @Index(
      name = "statusIndex",
      columnList = "scheduleStatus"
    )
  }
)
public abstract class WorkflowSchedule extends BasicWorkflowSchedule<WorkflowSchedule> implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5465691162437028464L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Category : Enterprise / Agency/ Agent. */
  @Column(
    nullable   = false,
    insertable = false,
    updatable  = false,
    length     = 10
  )
  protected String category;

  /** Schedule flows . */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "schedule",
    cascade  = CascadeType.ALL
  )
  @OrderBy("priority asc")
  private Set<EnterpriseWorkflow> flows = new LinkedHashSet<EnterpriseWorkflow>();

  /** primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new WorkflowSchedule object.
   */
  public WorkflowSchedule() { }


  /**
   * Creates a new WorkflowSchedule object.
   *
   * @param  workflowSchedule  DOCUMENT ME!
   */
  public WorkflowSchedule(WorkflowSchedule workflowSchedule) {
    updateSchedule(workflowSchedule);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * createSchedule.
   *
   * @return  WorkflowSchedule
   */
  @Override public abstract WorkflowSchedule createSchedule();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * paste.
   *
   * @return  WorkflowSchedule
   */
  @Override public abstract WorkflowSchedule paste();

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  WorkflowSchedule
   * @param  user      User
   */
  @Override public void deepCopy(WorkflowSchedule copyFrom, User user) {
    updateSchedule(copyFrom);

    for (EnterpriseWorkflow flow : copyFrom.getFlows()) {
      EnterpriseWorkflow newFlow = new EnterpriseWorkflow();
      newFlow.deepCopy(flow, user);

      if (user != null) {
        newFlow.setCreator(user);
        newFlow.setLastUpdater(user);
      } else {
        newFlow.setCreator(this.getLastUpdater());
        newFlow.setLastUpdater(this.getLastUpdater());
      }

      newFlow.setLastUpdateDate(new Date());
      newFlow.setSchedule(this);
      this.getFlows().add(newFlow);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    WorkflowSchedule that = (WorkflowSchedule) o;

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for category.
   *
   * @return  String
   */
  public String getCategory() {
    return category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for enterprise workflow.
   *
   * @param   name  String
   *
   * @return  EnterpriseWorkflow
   */
  public EnterpriseWorkflow getEnterpriseWorkflow(String name) {
    for (EnterpriseWorkflow workflow : flows) {
      if (workflow.getName().equals(name)) {
        return workflow;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flows.
   *
   * @return  Set
   */
  @Override public Set<EnterpriseWorkflow> getFlows() {
    return flows;
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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Flag which the schedule could be changed.
   *
   * <p>1. ACTIVE/OLD schedule could not be changed</p>
   *
   * <p>2. Schedule belong to view only portfolio could not be changed</p>
   *
   * @return  the readOnly
   */
  @Override public boolean isReadOnly() {
    if ((getScheduleStatus() == ScheduleStatus.ACTIVE)
          || (getScheduleStatus() == ScheduleStatus.OLD)) {
      return true;
    } else {
      return false;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for category.
   *
   * @param  category  String
   */
  public void setCategory(String category) {
    this.category = category;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flows.
   *
   * @param  flows  Set
   */
  public void setFlows(Set<EnterpriseWorkflow> flows) {
    this.flows = flows;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  @Override public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * updateSchedule.
   *
   * @param  schedule  WorkflowSchedule
   */
  @Override public void updateSchedule(WorkflowSchedule schedule) {
    update(schedule);
    this.setCategory(schedule.getCategory());
  }
} // end class WorkflowSchedule
