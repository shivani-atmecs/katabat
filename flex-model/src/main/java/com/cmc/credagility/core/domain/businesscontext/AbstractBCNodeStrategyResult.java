package com.cmc.credagility.core.domain.businesscontext;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.agency.AbstractExtendStrategyResult;

import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.BCNode;
import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.BCSchedule;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 10:41
 */
@MappedSuperclass public abstract class AbstractBCNodeStrategyResult extends AbstractExtendStrategyResult {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "businessContextId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContext businessContext;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "businessContextInstanceId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContextInstance businessContextInstance;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "nodeId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCNode node;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "scheduleId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCSchedule schedule;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.strategy.BaseExtendStrategyResult#equals(java.lang.Object)
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

    AbstractBCNodeStrategyResult that = (AbstractBCNodeStrategyResult) o;

    if ((businessContext != null) ? (!businessContext.equals(that.businessContext)) : (that.businessContext != null)) {
      return false;
    }

    if ((businessContextInstance != null) ? (!businessContextInstance.equals(that.businessContextInstance))
                                          : (that.businessContextInstance != null)) {
      return false;
    }

    if ((node != null) ? (!node.equals(that.node)) : (that.node != null)) {
      return false;
    }

    if ((schedule != null) ? (!schedule.equals(that.schedule)) : (that.schedule != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context.
   *
   * @return  BusinessContext
   */
  public BusinessContext getBusinessContext() {
    return businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context instance.
   *
   * @return  BusinessContextInstance
   */
  public BusinessContextInstance getBusinessContextInstance() {
    return businessContextInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node.
   *
   * @return  BCNode
   */
  public BCNode getNode() {
    return node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule.
   *
   * @return  BCSchedule
   */
  public BCSchedule getSchedule() {
    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.strategy.BaseExtendStrategyResult#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((businessContext != null) ? businessContext.hashCode() : 0);
    result = (31 * result) + ((node != null) ? node.hashCode() : 0);
    result = (31 * result) + ((schedule != null) ? schedule.hashCode() : 0);
    result = (31 * result) + ((businessContextInstance != null) ? businessContextInstance.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business context.
   *
   * @param  businessContext  BusinessContext
   */
  public void setBusinessContext(BusinessContext businessContext) {
    this.businessContext = businessContext;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business context instance.
   *
   * @param  businessContextInstance  BusinessContextInstance
   */
  public void setBusinessContextInstance(BusinessContextInstance businessContextInstance) {
    this.businessContextInstance = businessContextInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node.
   *
   * @param  node  BCNode
   */
  public void setNode(BCNode node) {
    this.node = node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule.
   *
   * @param  schedule  BCSchedule
   */
  public void setSchedule(BCSchedule schedule) {
    this.schedule = schedule;
  }
} // end class AbstractBCNodeStrategyResult
