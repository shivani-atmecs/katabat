package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.schedule.BaseStrategyResult;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;

import javax.persistence.*;
import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 10:01
 */
@MappedSuperclass public abstract class AbstractNodeStrategyResult extends BaseStrategyResult {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7545258932472991399L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean agencyAssignmentAction = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean agentAssignmentAction = false;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean bureauImportAction = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean channelAction = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean chargeOffAction = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean dataExportAction = false;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "nodeId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Node node;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "paymentId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Payment payment;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean personaAction = false;


  /** TODO: DOCUMENT ME! */
  @Column protected Long processorId;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean programAction = false;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean programCreated = false;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean queueAction = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean recallAction = false;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "scheduleId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Schedule schedule;


  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean scoreAction = false;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean statusAction = false;


  /** TODO: DOCUMENT ME! */
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  protected Date         strategyDate;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "strategyRunTypeId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected StrategyRunType strategyRunType;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean updateAction = false;

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

    AbstractNodeStrategyResult that = (AbstractNodeStrategyResult) o;

    if ((node != null) ? (!node.equals(that.node)) : (that.node != null)) {
      return false;
    }

    if ((payment != null) ? (!payment.equals(that.payment)) : (that.payment != null)) {
      return false;
    }

    if ((processorId != null) ? (!processorId.equals(that.processorId)) : (that.processorId != null)) {
      return false;
    }

    if ((schedule != null) ? (!schedule.equals(that.schedule)) : (that.schedule != null)) {
      return false;
    }

    if ((strategyDate != null) ? (!strategyDate.equals(
              that.strategyDate)) : (that.strategyDate != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency assignment action.
   *
   * @return  Boolean
   */
  public Boolean getAgencyAssignmentAction() {
    return agencyAssignmentAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent assignment action.
   *
   * @return  Boolean
   */
  public Boolean getAgentAssignmentAction() {
    return agentAssignmentAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bureau import action.
   *
   * @return  Boolean
   */
  public Boolean getBureauImportAction() {
    if (null == bureauImportAction) {
      return Boolean.FALSE;
    }

    return bureauImportAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel action.
   *
   * @return  Boolean
   */
  public Boolean getChannelAction() {
    if (channelAction == null) {
      return Boolean.FALSE;
    }

    return channelAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for charge off action.
   *
   * @return  Boolean
   */
  public Boolean getChargeOffAction() {
    return chargeOffAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data export action.
   *
   * @return  Boolean
   */
  public Boolean getDataExportAction() {
    if (null == dataExportAction) {
      return Boolean.FALSE;
    }

    return dataExportAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node.
   *
   * @return  Node
   */
  public Node getNode() {
    return node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment.
   *
   * @return  Payment
   */
  public Payment getPayment() {
    return payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for persona action.
   *
   * @return  Boolean
   */
  public Boolean getPersonaAction() {
    return personaAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for processor id.
   *
   * @return  Long
   */
  public Long getProcessorId() {
    return processorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program action.
   *
   * @return  Boolean
   */
  public Boolean getProgramAction() {
    if (programAction == null) {
      return Boolean.FALSE;
    }

    return programAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program created.
   *
   * @return  Boolean
   */
  public Boolean getProgramCreated() {
    if (programCreated == null) {
      return Boolean.FALSE;
    }

    return programCreated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue action.
   *
   * @return  Boolean
   */
  public Boolean getQueueAction() {
    if (queueAction == null) {
      return Boolean.FALSE;
    }

    return queueAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recall action.
   *
   * @return  Boolean
   */
  public Boolean getRecallAction() {
    if (recallAction == null) {
      return Boolean.FALSE;
    }

    return recallAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule.
   *
   * @return  Schedule
   */
  public Schedule getSchedule() {
    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for score action.
   *
   * @return  Boolean
   */
  public Boolean getScoreAction() {
    if (scoreAction == null) {
      return Boolean.FALSE;
    }

    return scoreAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status action.
   *
   * @return  Boolean
   */
  public Boolean getStatusAction() {
    if (statusAction == null) {
      return Boolean.FALSE;
    }

    return statusAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for strategy date.
   *
   * @return  Date
   */
  public Date getStrategyDate() {
    return strategyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for strategy run type.
   *
   * @return  StrategyRunType
   */
  public StrategyRunType getStrategyRunType() {
    return strategyRunType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for update action.
   *
   * @return  Boolean
   */
  public Boolean getUpdateAction() {
    if (updateAction == null) {
      return Boolean.FALSE;
    }

    return updateAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((node != null) ? node.hashCode() : 0);
    result = (31 * result)
      + ((processorId != null) ? processorId.hashCode() : 0);
    result = (31 * result) + ((schedule != null) ? schedule.hashCode() : 0);
    result = (31 * result)
      + ((strategyDate != null) ? strategyDate.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency assignment action.
   *
   * @param  agencyAssignmentAction  Boolean
   */
  public void setAgencyAssignmentAction(Boolean agencyAssignmentAction) {
    this.agencyAssignmentAction = agencyAssignmentAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent assignment action.
   *
   * @param  agentAssignmentAction  Boolean
   */
  public void setAgentAssignmentAction(Boolean agentAssignmentAction) {
    this.agentAssignmentAction = agentAssignmentAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bureau import action.
   *
   * @param  bureauImportAction  Boolean
   */
  public void setBureauImportAction(Boolean bureauImportAction) {
    this.bureauImportAction = bureauImportAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel action.
   *
   * @param  channelAction  Boolean
   */
  public void setChannelAction(Boolean channelAction) {
    this.channelAction = channelAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for charge off action.
   *
   * @param  chargeOffAction  Boolean
   */
  public void setChargeOffAction(Boolean chargeOffAction) {
    this.chargeOffAction = chargeOffAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data export action.
   *
   * @param  dataExportAction  Boolean
   */
  public void setDataExportAction(Boolean dataExportAction) {
    this.dataExportAction = dataExportAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node.
   *
   * @param  node  Node
   */
  public void setNode(Node node) {
    this.node = node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment.
   *
   * @param  payment  Payment
   */
  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for persona action.
   *
   * @param  personaAction  Boolean
   */
  public void setPersonaAction(Boolean personaAction) {
    this.personaAction = personaAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for processor id.
   *
   * @param  processorId  Long
   */
  public void setProcessorId(Long processorId) {
    this.processorId = processorId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program action.
   *
   * @param  programAction  Boolean
   */
  public void setProgramAction(Boolean programAction) {
    this.programAction = programAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program created.
   *
   * @param  programCreated  Boolean
   */
  public void setProgramCreated(Boolean programCreated) {
    this.programCreated = programCreated;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue action.
   *
   * @param  queueAction  Boolean
   */
  public void setQueueAction(Boolean queueAction) {
    this.queueAction = queueAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recall action.
   *
   * @param  recallAction  Boolean
   */
  public void setRecallAction(Boolean recallAction) {
    this.recallAction = recallAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule.
   *
   * @param  schedule  Schedule
   */
  public void setSchedule(Schedule schedule) {
    this.schedule = schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for score action.
   *
   * @param  scoreAction  Boolean
   */
  public void setScoreAction(Boolean scoreAction) {
    this.scoreAction = scoreAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status action.
   *
   * @param  statusAction  Boolean
   */
  public void setStatusAction(Boolean statusAction) {
    this.statusAction = statusAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for strategy date.
   *
   * @param  strategyDate  Date
   */
  public void setStrategyDate(Date strategyDate) {
    this.strategyDate = strategyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for strategy run type.
   *
   * @param  strategyRunType  StrategyRunType
   */
  public void setStrategyRunType(StrategyRunType strategyRunType) {
    this.strategyRunType = strategyRunType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for update action.
   *
   * @param  updateAction  Boolean
   */
  public void setUpdateAction(Boolean updateAction) {
    this.updateAction = updateAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("NodeStrategyResult");
    sb.append("{node=").append(node);
    sb.append(", processorId=").append(processorId);
    sb.append(", schedule=").append(schedule).append('\'');
    sb.append('}');

    return sb.toString();
  }
} // end class AbstractNodeStrategyResult
