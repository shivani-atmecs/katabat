package com.cmc.credagility.core.domain.assignmentaction;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.tranche.TrancheInfo;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ozstrategy.credagility.core.domain.AgencyAssignmentAction;
import com.ozstrategy.credagility.core.domain.Node;

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
import java.math.BigDecimal;
import java.util.Date;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/14/2014 17:20
 */
@Entity
@Table(
  name    = "AgencyAccount",
  indexes = {
    @Index(
      columnList = "deltaBatch",
      name = "deltaBatchIndex"
    ),
    @Index(
      columnList = "masterId",
      name = "masterIdIndex"
    ),
    @Index(
      columnList = "strategyDate",
      name = "strategyDateIndex"
    ),
    @Index(
      columnList = "previousTrancheInfoKey",
      name = "previousTrancheInfoKeyIndex"
    ),
    @Index(
      columnList = "trancheInfoKey",
      name = "trancheInfoKeyIndex"
    )
  }
)
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope = AgencyAccount.class)
public class AgencyAccount extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "accountNum")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "actionId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyAssignmentAction agencyAssignmentAction;

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
    name     = "assignmentType",
    nullable = true,
    length   = 255
  )
  protected String assignmentType;

  /** TODO: DOCUMENT ME! */
  @Column(name = "billingGroupId")
  protected Long billingGroupId;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1,
    nullable         = true
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
  @Column(
    name      = "previousAssignmentBalance",
    precision = 19,
    scale     = 2
  )
  protected BigDecimal previousAssignmentBalance;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "previousAssignmentType",
    length = 255
  )
  protected String previousAssignmentType;

  /** TODO: DOCUMENT ME! */
  @Column(name = "previousBillingGroupId")
  protected Long previousBillingGroupId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "previousSalesPrice",
    precision = 19,
    scale     = 4
  )
  protected BigDecimal previousSalesPrice;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "previousTrancheInfoKey",
    length = 255
  )
  protected String previousTrancheInfoKey;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "roleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Role role;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "salesPrice",
    precision = 19,
    scale     = 4
  )
  protected BigDecimal salesPrice;


  /** TODO: DOCUMENT ME! */
  @Column(name = "strategyDate")
  protected Date strategyDate;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "trancheId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected TrancheInfo trancheInfo;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "trancheInfoKey",
    length = 255
  )
  protected String trancheInfoKey;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AgencyAccount object.
   */
  public AgencyAccount() { }

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
   * getter method for agency assignment action.
   *
   * @return  AgencyAssignmentAction
   */
  public AgencyAssignmentAction getAgencyAssignmentAction() {
    return agencyAssignmentAction;
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
   * getter method for assignment type.
   *
   * @return  String
   */
  public String getAssignmentType() {
    return assignmentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for billing group id.
   *
   * @return  Long
   */
  public Long getBillingGroupId() {
    return billingGroupId;
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
   * getter method for previous assignment balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPreviousAssignmentBalance() {
    return previousAssignmentBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous assignment type.
   *
   * @return  String
   */
  public String getPreviousAssignmentType() {
    return previousAssignmentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous billing group id.
   *
   * @return  Long
   */
  public Long getPreviousBillingGroupId() {
    return previousBillingGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous sales price.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPreviousSalesPrice() {
    return previousSalesPrice;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for previous tranche info key.
   *
   * @return  String
   */
  public String getPreviousTrancheInfoKey() {
    return previousTrancheInfoKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role.
   *
   * @return  Role
   */
  public Role getRole() {
    return role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sales price.
   *
   * @return  BigDecimal
   */
  public BigDecimal getSalesPrice() {
    return salesPrice;
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
   * getter method for tranche info.
   *
   * @return  TrancheInfo
   */
  public TrancheInfo getTrancheInfo() {
    return trancheInfo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tranche info key.
   *
   * @return  String
   */
  public String getTrancheInfoKey() {
    return trancheInfoKey;
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
   * setter method for agency assignment action.
   *
   * @param  agencyAssignmentAction  AgencyAssignmentAction
   */
  public void setAgencyAssignmentAction(AgencyAssignmentAction agencyAssignmentAction) {
    this.agencyAssignmentAction = agencyAssignmentAction;
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
   * setter method for assignment type.
   *
   * @param  assignmentType  String
   */
  public void setAssignmentType(String assignmentType) {
    this.assignmentType = assignmentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for billing group id.
   *
   * @param  billingGroupId  Long
   */
  public void setBillingGroupId(Long billingGroupId) {
    this.billingGroupId = billingGroupId;
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
   * setter method for previous assignment balance.
   *
   * @param  previousAssignmentBalance  BigDecimal
   */
  public void setPreviousAssignmentBalance(BigDecimal previousAssignmentBalance) {
    this.previousAssignmentBalance = previousAssignmentBalance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous assignment type.
   *
   * @param  previousAssignmentType  String
   */
  public void setPreviousAssignmentType(String previousAssignmentType) {
    this.previousAssignmentType = previousAssignmentType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous billing group id.
   *
   * @param  previousBillingGroupId  Long
   */
  public void setPreviousBillingGroupId(Long previousBillingGroupId) {
    this.previousBillingGroupId = previousBillingGroupId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous sales price.
   *
   * @param  previousSalesPrice  BigDecimal
   */
  public void setPreviousSalesPrice(BigDecimal previousSalesPrice) {
    this.previousSalesPrice = previousSalesPrice;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for previous tranche info key.
   *
   * @param  previousTrancheInfoKey  String
   */
  public void setPreviousTrancheInfoKey(String previousTrancheInfoKey) {
    this.previousTrancheInfoKey = previousTrancheInfoKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role.
   *
   * @param  role  Role
   */
  public void setRole(Role role) {
    this.role = role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sales price.
   *
   * @param  salesPrice  BigDecimal
   */
  public void setSalesPrice(BigDecimal salesPrice) {
    this.salesPrice = salesPrice;
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
   * setter method for tranche info.
   *
   * @param  trancheInfo  TrancheInfo
   */
  public void setTrancheInfo(TrancheInfo trancheInfo) {
    this.trancheInfo = trancheInfo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tranche info key.
   *
   * @param  trancheInfoKey  String
   */
  public void setTrancheInfoKey(String trancheInfoKey) {
    this.trancheInfoKey = trancheInfoKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "AgencyAccount{"
      + "assignmentBalance=" + assignmentBalance
      + ", assignmentType='" + assignmentType + '\''
      + ", billingGroupId=" + billingGroupId
      + ", deltaBatch=" + deltaBatch
      + ", id=" + id
      + ", masterId=" + masterId
      + ", previousAssignmentBalance=" + previousAssignmentBalance
      + ", previousAssignmentType='" + previousAssignmentType + '\''
      + ", previousBillingGroupId=" + previousBillingGroupId
      + ", previousSalesPrice=" + previousSalesPrice
      + ", previousTrancheInfoKey='" + previousTrancheInfoKey + '\''
      + ", salesPrice=" + salesPrice
      + ", strategyDate=" + strategyDate
      + ", trancheInfoKey='" + trancheInfoKey + '\''
      + '}';
  }
} // end class AgencyAccount
