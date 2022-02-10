package com.cmc.credagility.core.domain.agency;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.user.Role;

import com.ozstrategy.credagility.core.domain.decisiontree.agency.AgencyNode;
import com.ozstrategy.credagility.core.domain.decisiontree.agency.AgencySchedule;


/**
 * Abstract class for saving agency strategy result.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/14/2014 17:04 PM
 */
@MappedSuperclass public abstract class AbstractAgencyNodeStrategyResult extends AbstractExtendStrategyResult {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7388386518628426664L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** The agency this result belonged to. */
  @JoinColumn(
    name      = "roleId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Role agency;

  /** The node this result generated for. */
  @JoinColumn(
    name      = "nodeId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyNode node;

  /** The node this result generated for. */
  @JoinColumn(
    name      = "scheduleId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencySchedule schedule;

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

    AbstractAgencyNodeStrategyResult that = (AbstractAgencyNodeStrategyResult) o;

    if ((agency != null) ? (!agency.equals(that.agency)) : (that.agency != null)) {
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
   * getter method for agency.
   *
   * @return  Role
   */
  public Role getAgency() {
    return agency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for node.
   *
   * @return  AgencyNode
   */
  public AgencyNode getNode() {
    return node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for schedule.
   *
   * @return  AgencySchedule
   */
  public AgencySchedule getSchedule() {
    return schedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.agency.AbstractExtendStrategyResult#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((agency != null) ? agency.hashCode() : 0);
    result = (31 * result) + ((node != null) ? node.hashCode() : 0);
    result = (31 * result) + ((schedule != null) ? schedule.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency.
   *
   * @param  agency  Role
   */
  public void setAgency(Role agency) {
    this.agency = agency;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for node.
   *
   * @param  node  AgencyNode
   */
  public void setNode(AgencyNode node) {
    this.node = node;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for schedule.
   *
   * @param  schedule  AgencySchedule
   */
  public void setSchedule(AgencySchedule schedule) {
    this.schedule = schedule;
  }
} // end class AbstractAgencyNodeStrategyResult
