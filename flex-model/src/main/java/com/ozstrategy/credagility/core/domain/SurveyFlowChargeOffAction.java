package com.ozstrategy.credagility.core.domain;

import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionInterface;
import com.ozstrategy.credagility.core.domain.workflow.WorkflowNodeActionTriggerType;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by yongwenchao on 15/8/12.
 *
 * @author   <a href="mailto:wenchao.yong@ozstrategy.com">Wenchao Yong</a>
 * @version  08/12/2015 11:23
 */
@Entity @Table public class SurveyFlowChargeOffAction extends CreatorEntity implements Serializable,
  WorkflowNodeActionInterface {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -5995973132769384886L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "chargeOffActionId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ChargeOffAction chargeOffAction = new ChargeOffAction();

  /** TODO: DOCUMENT ME! */
  @Column(columnDefinition = "LONGTEXT")
  @Lob protected String criteria;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "flowId",
    nullable   = false,
    insertable = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected SurveyFlow flow = new SurveyFlow();

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(
    length   = 32,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  protected WorkflowNodeActionTriggerType triggerType = WorkflowNodeActionTriggerType.ENTRY;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  copyFrom  SurveyFlowChargeOffAction
   */
  public void deepCopy(SurveyFlowChargeOffAction copyFrom) {
    setCriteria(copyFrom.getCriteria());
    setTriggerType(copyFrom.getTriggerType());
    setChargeOffAction(copyFrom.getChargeOffAction());
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * getter method for action name.
   *
   * @return  String
   */
  @Override public String getActionName() {
    return this.chargeOffAction.getName();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off action.
   *
   * @return  ChargeOffAction
   */
  public ChargeOffAction getChargeOffAction() {
    return chargeOffAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * getter method for criteria.
   *
   * @return  String
   */
  @Override public String getCriteria() {
    return criteria;
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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * getter method for trigger type.
   *
   * @return  WorkflowNodeActionTriggerType
   */
  @Override public WorkflowNodeActionTriggerType getTriggerType() {
    return triggerType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off action.
   *
   * @param  chargeOffAction  ChargeOffAction
   */
  public void setChargeOffAction(ChargeOffAction chargeOffAction) {
    this.chargeOffAction = chargeOffAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for criteria.
   *
   * @param  criteria  String
   */
  public void setCriteria(String criteria) {
    this.criteria = criteria;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for trigger type.
   *
   * @param  triggerType  WorkflowNodeActionTriggerType
   */
  public void setTriggerType(WorkflowNodeActionTriggerType triggerType) {
    this.triggerType = triggerType;
  }
} // end class SurveyFlowChargeOffAction
