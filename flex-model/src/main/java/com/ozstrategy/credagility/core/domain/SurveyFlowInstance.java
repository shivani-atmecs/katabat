package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.event.EventInstance;
import com.cmc.credagility.core.domain.user.User;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowTriggerSource;
import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Exe SurveyFlow Instance.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/16/2014 11:19
 */
@Entity
@Table(
  name    = "SurveyFlowInstance",
  indexes = {
    @Index(
      name = "statusIndex",
      columnList = "status"
    )
  }
)
public class SurveyFlowInstance extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -2041879081180954581L;

  /** the depth separator. */
  public static final String SEPARATOR = "|";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account. */
  @JoinColumn(
    name       = "accountNum",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;


  /** anchor. */
  @Column protected Float anchor = 0.0F;


  /** SurveyFlow AuditInstance. */
  @JoinColumn(
    name       = "auditInstanceId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowAuditInstance auditInstance;

  /** The agent who cancel this flow. */
  @JoinColumn(name = "cancelBy")
  @ManyToOne(fetch = FetchType.LAZY)
  protected User cancelBy;

  /** The eventInstance which trigger this flow. */
  @JoinColumn(
    name       = "eventInstanceId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EventInstance eventInstance;


  /** this instance for which SurveyFlow. */
  @JoinColumn(
    name       = "flowId",
    nullable   = false,
    updatable  = false,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlow flow;

  /** The hotSpot which trigger this flow. */
  @JoinColumn(
    name       = "hotSpotId",
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected HotSpot hotSpot;

  /** Primary key. */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** previous AuditInstance. */
  @JoinColumn(
    name       = "previousAuditInstanceId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowAuditInstance previousAuditInstance;

  /** The agent who start this flow. */
  @JoinColumn(
    name       = "starterId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected User starter;


  /** Flow exe Status. */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected FlowRunningStatus status = FlowRunningStatus.IN_PROCESS;


  /** SurveyFlowStep not contain RETIRED. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "surveyFlowInstance"
  )
  @OrderBy("stepNumber asc")
  @Where(clause = "status != 'RETIRED'")
  protected Set<SurveyFlowStep> steps = new LinkedHashSet<SurveyFlowStep>();


  /** All SurveyFlowStep. */
  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "surveyFlowInstance",
    cascade  = CascadeType.ALL
  )
  @OrderBy("stepNumber asc")
  protected Set<SurveyFlowStep> stepSet = new LinkedHashSet<SurveyFlowStep>();

  /** The triggerFlowInstance which trigger this flow. See Flow Action */
  @JoinColumn(
    name       = "triggerFlowInstanceId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowInstance triggerFlowInstance;

  /** The triggerFlowStep which trigger this flow. See Flow Action */
  @JoinColumn(
    name       = "triggerFlowStepId",
    insertable = true,
    updatable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlowStep triggerFlowStep;


  /** triggerSource. */
  @Column(length = 32)
  @Enumerated(value = EnumType.STRING)
  protected WorkflowTriggerSource triggerSource;


  private final transient Logger logger = LoggerFactory.getLogger(getClass());

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * addSurveyFlowStep.
   *
   * @param   step  SurveyFlowStep
   *
   * @return  boolean
   */
  public boolean addSurveyFlowStep(SurveyFlowStep step) {
    return stepSet.add(step);
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

    SurveyFlowInstance that = (SurveyFlowInstance) o;

    if (!account.equals(that.account)) {
      return false;
    }

    if ((anchor != null) ? (!anchor.equals(that.anchor)) : (that.anchor != null)) {
      return false;
    }

    if (!flow.equals(that.flow)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((starter != null) ? (!starter.equals(that.starter)) : (that.starter != null)) {
      return false;
    }

    if (status != that.status) {
      return false;
    }

    if ((stepSet != null) ? (!stepSet.equals(that.stepSet)) : (that.stepSet != null)) {
      return false;
    }

    if ((steps != null) ? (!steps.equals(that.steps)) : (that.steps != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for anchor.
   *
   * @return  Float
   */
  public Float getAnchor() {
    if (anchor == null) {
      return 0.0F;
    }

    return anchor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for audit instance.
   *
   * @return  SurveyFlowAuditInstance
   */
  public SurveyFlowAuditInstance getAuditInstance() {
    return auditInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cancel by.
   *
   * @return  User
   */
  public User getCancelBy() {
    return cancelBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current step.
   *
   * @return  SurveyFlowStep
   */
  public SurveyFlowStep getCurrentStep() {
    for (SurveyFlowStep step : stepSet) {
      if (Boolean.TRUE.equals(step.getCurrent())) {
        return step;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for event instance.
   *
   * @return  EventInstance
   */
  public EventInstance getEventInstance() {
    return eventInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for flow.
   *
   * @return  SurveyFlow
   */
  public SurveyFlow getFlow() {
    return flow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hot spot.
   *
   * @return  HotSpot
   */
  public HotSpot getHotSpot() {
    return hotSpot;
  }

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
   * getter method for last step.
   *
   * @return  SurveyFlowStep
   */
  public SurveyFlowStep getLastStep() {
    SurveyFlowStep lastStep = null;

    for (SurveyFlowStep step : stepSet) {
      if (Boolean.TRUE.equals(step.getCurrent())) {
        return step;
      }

      lastStep = step;
    }

    return lastStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   curStep  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public SurveyFlowStep getNextStep(SurveyFlowStep curStep) {
    SurveyFlowStep             nextStep = null;
    LinkedList<SurveyFlowStep> list     = new LinkedList<SurveyFlowStep>(steps);
    Iterator<SurveyFlowStep>   itr      = list.descendingIterator();

    if (logger.isDebugEnabled()) {
      logger.debug("To get next step, current step is:" + curStep.getId());
    }

    while (itr.hasNext()) {
      SurveyFlowStep step = itr.next();

      if (stepEqual(curStep, step.getPreviousSurveyFlowStep())) {
        nextStep = step;

        break;
      }
    }

    if (logger.isDebugEnabled()) {
      logger.debug("The next step is: " + ((nextStep == null) ? null : nextStep.getId()));
    }

    return nextStep;
  } // end method getNextStep

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous audit instance.
   *
   * @return  SurveyFlowAuditInstance
   */
  public SurveyFlowAuditInstance getPreviousAuditInstance() {
    return previousAuditInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   depth  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSeparator(int depth) {
    String ret = "";

    for (int i = 0; i < depth; i++) {
      ret += SEPARATOR;
    }

    return ret;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for starter.
   *
   * @return  User
   */
  public User getStarter() {
    return starter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  FlowRunningStatus
   */
  public FlowRunningStatus getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for steps.
   *
   * @return  Set
   */
  public Set<SurveyFlowStep> getSteps() {
    return steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for step set.
   *
   * @return  Set
   */
  public Set<SurveyFlowStep> getStepSet() {
    return stepSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for steps string.
   *
   * @return  String
   */
  public String getStepsString() {
    return getStepsString(0);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for steps string.
   *
   * @param   depth  int
   *
   * @return  String
   */
  public String getStepsString(int depth) {
    StringBuffer sb           = new StringBuffer();
    String       curSeparator = getSeparator(depth);
    String       subSeparator = getSeparator(depth + 1);

    sb.append(curSeparator).append(flow.getName());

    for (SurveyFlowStep step : getSteps()) {
      sb.append(subSeparator).append(step.getName());
    }

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trigger flow instance.
   *
   * @return  SurveyFlowInstance
   */
  public SurveyFlowInstance getTriggerFlowInstance() {
    return triggerFlowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trigger flow step.
   *
   * @return  SurveyFlowStep
   */
  public SurveyFlowStep getTriggerFlowStep() {
    return triggerFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for trigger source.
   *
   * @return  WorkflowTriggerSource
   */
  public WorkflowTriggerSource getTriggerSource() {
    return triggerSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((flow != null) ? flow.hashCode() : 0);
    result = (31 * result) + id.hashCode();
    result = (31 * result) + status.hashCode();

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * removeRetiredStep.
   *
   * @param   step  SurveyFlowStep
   *
   * @return  boolean
   */
  public boolean removeRetiredStep(SurveyFlowStep step) {
    return steps.remove(step);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for anchor.
   *
   * @param  anchor  Float
   */
  public void setAnchor(Float anchor) {
    this.anchor = anchor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for audit instance.
   *
   * @param  auditInstance  SurveyFlowAuditInstance
   */
  public void setAuditInstance(SurveyFlowAuditInstance auditInstance) {
    this.auditInstance = auditInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cancel by.
   *
   * @param  cancelBy  User
   */
  public void setCancelBy(User cancelBy) {
    this.cancelBy = cancelBy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for event instance.
   *
   * @param  eventInstance  EventInstance
   */
  public void setEventInstance(EventInstance eventInstance) {
    this.eventInstance = eventInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for flow.
   *
   * @param  flow  SurveyFlow
   */
  public void setFlow(SurveyFlow flow) {
    this.flow = flow;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hot spot.
   *
   * @param  hotSpot  HotSpot
   */
  public void setHotSpot(HotSpot hotSpot) {
    this.hotSpot = hotSpot;
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
   * setter method for previous audit instance.
   *
   * @param  previousAuditInstance  SurveyFlowAuditInstance
   */
  public void setPreviousAuditInstance(SurveyFlowAuditInstance previousAuditInstance) {
    this.previousAuditInstance = previousAuditInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for starter.
   *
   * @param  starter  User
   */
  public void setStarter(User starter) {
    this.starter = starter;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  FlowRunningStatus
   */
  public void setStatus(FlowRunningStatus status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for steps.
   *
   * @param  steps  Set
   */
  public void setSteps(Set<SurveyFlowStep> steps) {
    this.steps = steps;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for step set.
   *
   * @param  stepSet  Set
   */
  public void setStepSet(Set<SurveyFlowStep> stepSet) {
    this.stepSet = stepSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trigger flow instance.
   *
   * @param  triggerFlowInstance  SurveyFlowInstance
   */
  public void setTriggerFlowInstance(SurveyFlowInstance triggerFlowInstance) {
    this.triggerFlowInstance = triggerFlowInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trigger flow step.
   *
   * @param  triggerFlowStep  SurveyFlowStep
   */
  public void setTriggerFlowStep(SurveyFlowStep triggerFlowStep) {
    this.triggerFlowStep = triggerFlowStep;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trigger source.
   *
   * @param  triggerSource  WorkflowTriggerSource
   */
  public void setTriggerSource(WorkflowTriggerSource triggerSource) {
    this.triggerSource = triggerSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * stepEqual.
   *
   * @param   step1  SurveyFlowStep
   * @param   step2  SurveyFlowStep
   *
   * @return  boolean
   */
  public boolean stepEqual(SurveyFlowStep step1, SurveyFlowStep step2) {
    if ((step1 == null) && (step2 == null)) {
      return false;
    } else if ((step1 == null) || (step2 == null)) {
      return false;
    } else {
      if (logger.isDebugEnabled()) {
        logger.debug("Compare steps node: (" + step1.getId() + ", " + step1.getNode().getId() + ")  <--  ("
          + step2.getId() + ", " + step2.getNode().getId() + ")");
      }

      return step1.getNode().getId().equals(step2.getNode().getId());
    }
  }
} // end class SurveyFlowInstance
