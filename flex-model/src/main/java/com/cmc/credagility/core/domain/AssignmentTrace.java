package com.cmc.credagility.core.domain;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.assignmentaction.AgencyAccount;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.externalentity.ExternalEntityPutBackData;
import com.cmc.credagility.core.domain.user.Role;
import com.cmc.credagility.core.domain.user.User;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ozstrategy.credagility.core.domain.RecallResult;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:pan.kang@ozstrategy.com">Pan Kang</a>
 * @version  10/21/2015 11:37
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope = AssignmentTrace.class)
@Entity public class AssignmentTrace extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 3791657770137495966L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "agencyAccountId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected AgencyAccount agencyAccount;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "agentId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected User agent;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "assignmentType",
    length = 255
  )
  protected String assignmentType;


  /** TODO: DOCUMENT ME! */
  @Column(name = "endDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date endDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "externalReferenceNumber",
    length = 255
  )
  protected String externalReferenceNumber;

  /** Account Index id PK. */
  @Column
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long         id;


  /** TODO: DOCUMENT ME! */
  @Column(name = "reassignDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date reassignDate;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "roleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Role role;

  /** TODO: DOCUMENT ME! */
  @Column(name = "startDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date startDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "totalAmount",
    precision = 19,
    scale     = 2
  )
  protected BigDecimal totalAmount;

  /** Account link accountNum. */
  @JoinColumn(name = "accountNum")
  @ManyToOne(fetch = FetchType.LAZY)
  private Account account;

  @JoinColumn(name = "previousTraceId")
  @ManyToOne(fetch = FetchType.LAZY)
  private AssignmentTrace previousTrace;

  @JoinColumn(name = "putBackId")
  @ManyToOne(fetch = FetchType.LAZY)
  private ExternalEntityPutBackData putBack;


  @JoinColumn(name = "recallResultId")
  @ManyToOne(fetch = FetchType.LAZY)
  private RecallResult recallResult;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    AssignmentTrace that = (AssignmentTrace) o;

    if ((reassignDate != null) ? (!reassignDate.equals(that.reassignDate)) : (that.reassignDate != null)) {
      return false;
    }

    if ((endDate != null) ? (!endDate.equals(that.endDate)) : (that.endDate != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((role != null) ? (!role.equals(that.role)) : (that.role != null)) {
      return false;
    }

    if ((startDate != null) ? (!startDate.equals(that.startDate)) : (that.startDate != null)) {
      return false;
    }

    if ((totalAmount != null) ? (!totalAmount.equals(that.totalAmount)) : (that.totalAmount != null)) {
      return false;
    }

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((previousTrace != null) ? (!previousTrace.equals(that.previousTrace)) : (that.previousTrace != null)) {
      return false;
    }

    if ((putBack != null) ? (!putBack.equals(that.putBack)) : (that.putBack != null)) {
      return false;
    }

    return !((recallResult != null) ? (!recallResult.equals(that.recallResult)) : (that.recallResult != null));

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
   * getter method for agency account.
   *
   * @return  AgencyAccount
   */
  public AgencyAccount getAgencyAccount() {
    return agencyAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for agent.
   *
   * @return  User
   */
  public User getAgent() {
    return agent;
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
   * getter method for end date.
   *
   * @return  Date
   */
  public Date getEndDate() {
    return endDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for external reference number.
   *
   * @return  String
   */
  public String getExternalReferenceNumber() {
    return externalReferenceNumber;
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
   * getter method for previous trace.
   *
   * @return  AssignmentTrace
   */
  public AssignmentTrace getPreviousTrace() {
    return previousTrace;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for put back.
   *
   * @return  ExternalEntityPutBackData
   */
  public ExternalEntityPutBackData getPutBack() {
    return putBack;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for reassign date.
   *
   * @return  Date
   */
  public Date getReassignDate() {
    return reassignDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for recall result.
   *
   * @return  RecallResult
   */
  public RecallResult getRecallResult() {
    return recallResult;
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
   * getter method for start date.
   *
   * @return  Date
   */
  public Date getStartDate() {
    return startDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for total amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((reassignDate != null) ? reassignDate.hashCode() : 0);
    result = (31 * result) + ((endDate != null) ? endDate.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((role != null) ? role.hashCode() : 0);
    result = (31 * result) + ((startDate != null) ? startDate.hashCode() : 0);
    result = (31 * result) + ((totalAmount != null) ? totalAmount.hashCode() : 0);
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((previousTrace != null) ? previousTrace.hashCode() : 0);
    result = (31 * result) + ((putBack != null) ? putBack.hashCode() : 0);
    result = (31 * result) + ((recallResult != null) ? recallResult.hashCode() : 0);

    return result;
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
   * setter method for agency account.
   *
   * @param  agencyAccount  AgencyAccount
   */
  public void setAgencyAccount(AgencyAccount agencyAccount) {
    this.agencyAccount = agencyAccount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for agent.
   *
   * @param  agent  User
   */
  public void setAgent(User agent) {
    this.agent = agent;
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
   * setter method for end date.
   *
   * @param  endDate  Date
   */
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for external reference number.
   *
   * @param  externalReferenceNumber  String
   */
  public void setExternalReferenceNumber(String externalReferenceNumber) {
    this.externalReferenceNumber = externalReferenceNumber;
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
   * setter method for previous trace.
   *
   * @param  previousTrace  AssignmentTrace
   */
  public void setPreviousTrace(AssignmentTrace previousTrace) {
    this.previousTrace = previousTrace;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for put back.
   *
   * @param  putBack  ExternalEntityPutBackData
   */
  public void setPutBack(ExternalEntityPutBackData putBack) {
    this.putBack = putBack;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for reassign date.
   *
   * @param  reassignDate  Date
   */
  public void setReassignDate(Date reassignDate) {
    this.reassignDate = reassignDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for recall result.
   *
   * @param  recallResult  RecallResult
   */
  public void setRecallResult(RecallResult recallResult) {
    this.recallResult = recallResult;
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
   * setter method for start date.
   *
   * @param  startDate  Date
   */
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for total amount.
   *
   * @param  totalAmount  BigDecimal
   */
  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }
} // end class AssignmentTrace
