package com.ozstrategy.credagility.core.domain.decisiontree.agency;

import com.cmc.credagility.core.domain.user.Role;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * This class is used to store TriggeredAgencyAbstractQueue information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 17:34
 */
@MappedSuperclass public class TriggeredAgencyAbstractQueue extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "agencyId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Role agency;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean deltaBatch = Boolean.FALSE;


  /** TODO: DOCUMENT ME! */
  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = true)
  protected Long masterBatchId;

  @JoinColumn(
    name       = "queueActionId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private AgencyQueueAction queueAction = new AgencyQueueAction();

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

    TriggeredAgencyAbstractQueue that = (TriggeredAgencyAbstractQueue) o;

    if ((deltaBatch != null) ? (!deltaBatch.equals(that.deltaBatch)) : (that.deltaBatch != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((masterBatchId != null) ? (!masterBatchId.equals(that.masterBatchId)) : (that.masterBatchId != null)) {
      return false;
    }

    if ((queueAction != null) ? (!queueAction.equals(that.queueAction)) : (that.queueAction != null)) {
      return false;
    }

    if ((agency != null) ? (!agency.equals(that.agency)) : (that.agency != null)) {
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
   * getter method for delta batch.
   *
   * @return  Boolean
   */
  public Boolean getDeltaBatch() {
    return deltaBatch;
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
   * getter method for master batch id.
   *
   * @return  Long
   */
  public Long getMasterBatchId() {
    return masterBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for queue action.
   *
   * @return  AgencyQueueAction
   */
  public AgencyQueueAction getQueueAction() {
    return queueAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((deltaBatch != null) ? deltaBatch.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((masterBatchId != null) ? masterBatchId.hashCode() : 0);
    result = (31 * result) + ((agency != null) ? agency.hashCode() : 0);
    result = (31 * result) + ((queueAction != null) ? queueAction.hashCode() : 0);

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
   * setter method for delta batch.
   *
   * @param  deltaBatch  Boolean
   */
  public void setDeltaBatch(Boolean deltaBatch) {
    this.deltaBatch = deltaBatch;
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
   * setter method for master batch id.
   *
   * @param  masterBatchId  Long
   */
  public void setMasterBatchId(Long masterBatchId) {
    this.masterBatchId = masterBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for queue action.
   *
   * @param  queueAction  AgencyQueueAction
   */
  public void setQueueAction(AgencyQueueAction queueAction) {
    this.queueAction = queueAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    return "TriggeredAgencyAbstractQueue{"
      + "deltaBatch=" + deltaBatch
      + ", id=" + id
      + ", masterBatchId=" + masterBatchId
      + ", agency=" + agency
      + ", queueAction=" + queueAction
      + '}';
  }
} // end class TriggeredAgencyAbstractQueue
