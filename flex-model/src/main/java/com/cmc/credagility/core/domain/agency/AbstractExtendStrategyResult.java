package com.cmc.credagility.core.domain.agency;

import com.cmc.credagility.core.domain.strategy.BaseExtendStrategyResult;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.StrategyRunType;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


/**
 * Abstract class for saving strategy result.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/14/2014 17:05 PM
 */
@MappedSuperclass public abstract class AbstractExtendStrategyResult extends BaseExtendStrategyResult {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1411875151375537345L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** If channel action is triggered. */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean channelAction = false;

  /** The process id, referred to {ScheduleProcess}. */
  @Column protected Long processorId;

  /** If queue action is triggered. */
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
  protected Boolean statusAction = false;

  /** Strategy run type: Non-Operational or Operational */
  @JoinColumn(name = "strategyRunTypeId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected StrategyRunType strategyRunType;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel action.
   *
   * @return  Boolean
   */
  public Boolean getChannelAction() {
    return channelAction;
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
   * getter method for queue action.
   *
   * @return  Boolean
   */
  public Boolean getQueueAction() {
    return queueAction;
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
   * getter method for strategy run type.
   *
   * @return  StrategyRunType
   */
  public StrategyRunType getStrategyRunType() {
    return strategyRunType;
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
   * setter method for processor id.
   *
   * @param  processorId  Long
   */
  public void setProcessorId(Long processorId) {
    this.processorId = processorId;
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
   * setter method for status action.
   *
   * @param  statusAction  Boolean
   */
  public void setStatusAction(Boolean statusAction) {
    this.statusAction = statusAction;
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
} // end class AbstractExtendStrategyResult
