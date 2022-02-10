package com.cmc.credagility.core.domain.channel;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.cmc.credagility.core.domain.businesscontext.BusinessContextInstance;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.event.EventInstance;
import com.cmc.credagility.core.domain.payment.Payment;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.webactivity.Session;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import com.ozstrategy.credagility.core.domain.decisiontree.agency.AgencyChannelAction;
import com.ozstrategy.credagility.core.domain.decisiontree.agency.AgencyNode;
import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.BCChannelAction;
import com.ozstrategy.credagility.core.domain.decisiontree.businesscontext.BCNode;


/**
 * This class is used to store base channel action information.
 *
 * <p><a href="BaseChannelResult.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 15:15
 */
@MappedSuperclass public abstract class BaseChannelResult extends AbstractChannelResult {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Role. */
  @JoinColumn(
    name     = "agencyId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Role agency;


  /** Agency ChannelAction. */
  @JoinColumn(
    name     = "agencyChannelActionId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyChannelAction agencyChannelAction;


  /** Agency Node. */
  @JoinColumn(name = "agencyNodeId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyNode agencyNode;

  /** BCChannel Action. */
  @JoinColumn(
    name     = "bcChannelActionId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCChannelAction bcChannelAction;


  /** BC Node. */
  @JoinColumn(name = "bcNodeId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected BCNode bcNode;


  /** Business Context Instance. */
  @JoinColumn(
    name     = "businessContextInstanceId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected BusinessContextInstance businessContextInstance;


  /** Customer. */
  @JoinColumn(
    name     = "customerId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;


  /** is delta Batch. */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean deltaBatch = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @Column protected String eeVariableName;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "executionInstanceId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected EventInstance executionInstance;


  /** TODO: DOCUMENT ME! */
  @Transient protected Long externalEntityId;

  /** Payment. */
  @JoinColumn(
    name      = "paymentId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Payment payment;

  /** TODO: DOCUMENT ME! */
  @Column(length = 20)
  protected String recipientType;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "sessionId",
    updatable = false,
    nullable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Session session;

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for agency channel action.
   *
   * @return  AgencyChannelAction
   */
  public AgencyChannelAction getAgencyChannelAction() {
    return agencyChannelAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agency node.
   *
   * @return  AgencyNode
   */
  public AgencyNode getAgencyNode() {
    return agencyNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bc channel action.
   *
   * @return  BCChannelAction
   */
  public BCChannelAction getBcChannelAction() {
    return bcChannelAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bc node.
   *
   * @return  BCNode
   */
  public BCNode getBcNode() {
    return bcNode;
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
   * getter method for customer.
   *
   * @return  Customer
   */
  public Customer getCustomer() {
    return customer;
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
   * getter method for ee variable name.
   *
   * @return  String
   */
  public String getEeVariableName() {
    return eeVariableName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for execution instance.
   *
   * @return  EventInstance
   */
  public EventInstance getExecutionInstance() {
    return executionInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for external entity id.
   *
   * @return  Long
   */
  public Long getExternalEntityId() {
    return externalEntityId;
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
   * getter method for recipient type.
   *
   * @return  String
   */
  public String getRecipientType() {
    return recipientType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for session.
   *
   * @return  Session
   */
  public Session getSession() {
    return session;
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
   * setter method for agency channel action.
   *
   * @param  agencyChannelAction  AgencyChannelAction
   */
  public void setAgencyChannelAction(AgencyChannelAction agencyChannelAction) {
    this.agencyChannelAction = agencyChannelAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agency node.
   *
   * @param  agencyNode  AgencyNode
   */
  public void setAgencyNode(AgencyNode agencyNode) {
    this.agencyNode = agencyNode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bc channel action.
   *
   * @param  bcChannelAction  BCChannelAction
   */
  public void setBcChannelAction(BCChannelAction bcChannelAction) {
    this.bcChannelAction = bcChannelAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bc node.
   *
   * @param  bcNode  BCNode
   */
  public void setBcNode(BCNode bcNode) {
    this.bcNode = bcNode;
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
   * setter method for customer.
   *
   * @param  customer  Customer
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
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
   * setter method for ee variable name.
   *
   * @param  eeVariableName  String
   */
  public void setEeVariableName(String eeVariableName) {
    this.eeVariableName = eeVariableName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for execution instance.
   *
   * @param  executionInstance  EventInstance
   */
  public void setExecutionInstance(EventInstance executionInstance) {
    this.executionInstance = executionInstance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for external entity id.
   *
   * @param  externalEntityId  Long
   */
  public void setExternalEntityId(Long externalEntityId) {
    this.externalEntityId = externalEntityId;
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
   * setter method for recipient type.
   *
   * @param  recipientType  String
   */
  public void setRecipientType(String recipientType) {
    this.recipientType = recipientType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for session.
   *
   * @param  session  Session
   */
  public void setSession(Session session) {
    this.session = session;
  }
} // end class BaseChannelResult
