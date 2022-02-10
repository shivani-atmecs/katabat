package com.cmc.credagility.core.domain.account;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 14:21
 */
@Entity
@Table(name = "PolicyClaim")
public class PolicyClaim extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -2043140984116183399L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "accountPolicyId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected AccountPolicy accountPolicy;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "claimMode",
    length = 32
  )
  protected String claimMode;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "claimRef",
    length = 32
  )
  protected String claimRef;


  /** TODO: DOCUMENT ME! */
  @Column(name = "closeDate")
  protected Date closeDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "decision",
    length = 20
  )
  protected String decision;


  /** TODO: DOCUMENT ME! */
  @Column(name = "decisionDate")
  protected Date decisionDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "disabilityDate")
  protected Date disabilityDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "passId",
    length = 20
  )
  protected String passId;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long policyClaimId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "status",
    length = 32
  )
  protected String status;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "subStatus",
    length = 32
  )
  protected String subStatus;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account policy.
   *
   * @return  AccountPolicy
   */
  public AccountPolicy getAccountPolicy() {
    return accountPolicy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for claim mode.
   *
   * @return  String
   */
  public String getClaimMode() {
    return claimMode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for claim ref.
   *
   * @return  String
   */
  public String getClaimRef() {
    return claimRef;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for close date.
   *
   * @return  Date
   */
  public Date getCloseDate() {
    return closeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for decision.
   *
   * @return  String
   */
  public String getDecision() {
    return decision;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for decision date.
   *
   * @return  Date
   */
  public Date getDecisionDate() {
    return decisionDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for disability date.
   *
   * @return  Date
   */
  public Date getDisabilityDate() {
    return disabilityDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for pass id.
   *
   * @return  String
   */
  public String getPassId() {
    return passId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for policy claim id.
   *
   * @return  Long
   */
  public Long getPolicyClaimId() {
    return policyClaimId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  String
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sub status.
   *
   * @return  String
   */
  public String getSubStatus() {
    return subStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account policy.
   *
   * @param  accountPolicy  AccountPolicy
   */
  public void setAccountPolicy(AccountPolicy accountPolicy) {
    this.accountPolicy = accountPolicy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for claim mode.
   *
   * @param  claimMode  String
   */
  public void setClaimMode(String claimMode) {
    this.claimMode = claimMode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for claim ref.
   *
   * @param  claimRef  String
   */
  public void setClaimRef(String claimRef) {
    this.claimRef = claimRef;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for close date.
   *
   * @param  closeDate  Date
   */
  public void setCloseDate(Date closeDate) {
    this.closeDate = closeDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for decision.
   *
   * @param  decision  String
   */
  public void setDecision(String decision) {
    this.decision = decision;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for decision date.
   *
   * @param  decisionDate  Date
   */
  public void setDecisionDate(Date decisionDate) {
    this.decisionDate = decisionDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for disability date.
   *
   * @param  disabilityDate  Date
   */
  public void setDisabilityDate(Date disabilityDate) {
    this.disabilityDate = disabilityDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for pass id.
   *
   * @param  passId  String
   */
  public void setPassId(String passId) {
    this.passId = passId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for policy claim id.
   *
   * @param  policyClaimId  Long
   */
  public void setPolicyClaimId(Long policyClaimId) {
    this.policyClaimId = policyClaimId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  String
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sub status.
   *
   * @param  subStatus  String
   */
  public void setSubStatus(String subStatus) {
    this.subStatus = subStatus;
  }
} // end class PolicyClaim
