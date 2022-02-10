package com.cmc.credagility.core.domain.assignmentaction;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.User;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ozstrategy.credagility.core.domain.AgentAssignmentAction;
import com.ozstrategy.credagility.core.domain.Node;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/14/2014 17:29
 */
@Entity
@Table(
  name    = "AgentAccount",
  indexes = {
    @Index(
      name = "deltaBatchIndex",
      columnList = "deltaBatch"
    ),
    @Index(
      name = "masterIdIndex",
      columnList = "masterId"
    ),
    @Index(
      name = "strategyDateIndex",
      columnList = "strategyDate"
    )
  }
)
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope = AgentAccount.class)
public class AgentAccount extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "accountNum")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "actionId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgentAssignmentAction agentAssignmentAction;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "assignmentBalance",
    nullable  = false,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal assignmentBalance;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean deltaBatch = Boolean.FALSE;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(name = "masterId")
  protected Long masterId;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "nodeId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Node node;

  /** TODO: DOCUMENT ME! */
  @Column(name = "strategyDate")
  protected Date strategyDate;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "agentId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected User user;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AgentAccount object.
   */
  public AgentAccount() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

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
   * getter method for agent assignment action.
   *
   * @return  AgentAssignmentAction
   */
  public AgentAssignmentAction getAgentAssignmentAction() {
    return agentAssignmentAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for assignment balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAssignmentBalance() {
    return assignmentBalance;
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
   * getter method for master id.
   *
   * @return  Long
   */
  public Long getMasterId() {
    return masterId;
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
   * getter method for strategy date.
   *
   * @return  Date
   */
  public Date getStrategyDate() {
    return strategyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for user.
   *
   * @return  User
   */
  public User getUser() {
    return user;
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
   * setter method for agent assignment action.
   *
   * @param  agentAssignmentAction  AgentAssignmentAction
   */
  public void setAgentAssignmentAction(AgentAssignmentAction agentAssignmentAction) {
    this.agentAssignmentAction = agentAssignmentAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for assignment balance.
   *
   * @param  assignmentBalance  BigDecimal
   */
  public void setAssignmentBalance(BigDecimal assignmentBalance) {
    this.assignmentBalance = assignmentBalance;
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
   * setter method for master id.
   *
   * @param  masterId  Long
   */
  public void setMasterId(Long masterId) {
    this.masterId = masterId;
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
   * setter method for strategy date.
   *
   * @param  strategyDate  Date
   */
  public void setStrategyDate(Date strategyDate) {
    this.strategyDate = strategyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for user.
   *
   * @param  user  User
   */
  public void setUser(User user) {
    this.user = user;
  }
} // end class AgentAccount
