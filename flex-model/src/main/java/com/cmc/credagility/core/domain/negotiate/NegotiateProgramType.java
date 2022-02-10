package com.cmc.credagility.core.domain.negotiate;

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
import javax.persistence.Table;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.program.BaseProgramType;


/**
 * This class is used to store Account Program Type information.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/14/2014 17:52
 */
@Entity
@Table(name = "NegotiateProgramType")
public class NegotiateProgramType extends BaseProgramType {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1719381378118572979L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** account. */
  @JoinColumn(
    name      = "accountNum",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;

  /** TODO: DOCUMENT ME! */
  @Column(name = "ruleBatchId")
  protected Long ruleBatchId;

  /** generating negotiate program rule id. */
  @Column(name = "ruleId")
  protected Long ruleId;

  // npelleti, 07/30, USBank, Removed unique constraint
  /** Account program type Id, PK. */
  @Column(
    name     = "typeId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long typeId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Business equals does not care about the createDate. It does not care about the java.util.Set contract. Only to
   * check if two payments are the identical from business perspective. This is perfect for dirty check when edit
   * payments.
   *
   * @param   obj  $param.type$
   *
   * @return  business equals does not care about the createDate.
   */
  @Override public boolean businessEquals(Object obj) {
    return super.businessEquals(obj);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The account.
   *
   * @return  the account
   */
  public Account getAccount() {
    return this.account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get principal amount based on principal type.
   *
   * @return  get principal amount based on principal type.
   */
  public BigDecimal getPrincipalAmount() {
    try {
      return account.getPrincipalAmount(principalType);
    } catch (Exception e) {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule batch id.
   *
   * @return  Long
   */
  public Long getRuleBatchId() {
    return ruleBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The Id of the rule creating this channel result. Could be null if this channel result is generated manually.
   *
   * @return  the Id of the rule creating this channel result. Could be null if this channel result is generated
   *          manually.
   */
  public Long getRuleId() {
    return ruleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get Program total amount based on floorPercentage.
   *
   * @return  get Program total amount based on floorPercentage.
   */
  public BigDecimal getTotalFloorAmount() {
    try {
      return account.getNegotiatedProgramAmount(principalType, floorPercentage);
    } catch (Exception e) {
      return null;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type id.
   *
   * @return  Long
   */
  public Long getTypeId() {
    return this.typeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    return super.hashCode();
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
   * setter method for rule batch id.
   *
   * @param  ruleBatchId  Long
   */
  public void setRuleBatchId(Long ruleBatchId) {
    this.ruleBatchId = ruleBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule id.
   *
   * @param  ruleId  Long
   */
  public void setRuleId(Long ruleId) {
    this.ruleId = ruleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for type id.
   *
   * @param  typeId  Long
   */
  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("NegotiateProgramType ( ").append(super.toString()).append(
      TAB).append("floorPercentage = ").append(this.floorPercentage).append(
      TAB).append("longestDuration = ").append(this.longestDuration).append(
      TAB).append("minFixedFee = ").append(this.minFixedFee).append(TAB).append("paymentProgramType = ").append(
      this.paymentProgramType).append(TAB).append("principalType = ").append(this.principalType).append(TAB).append(
      "typeId = ").append(this.typeId).append(TAB).append(" )");

    return retValue.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update Negotiate Program type.
   *
   * @param  other  $param.type$
   */
  public void update(NegotiateProgramType other) {
    this.setRuleBatchId(other.getRuleBatchId());
    this.setRuleId(other.getRuleId());
    this.setFloorPercentage(other.getFloorPercentage());
    this.setPrincipalType(other.getPrincipalType());
    this.setProgramValidDays(other.getProgramValidDays().intValue());
    this.setLongestDuration(other.getLongestDuration().intValue());
    this.setMinFixedFee(other.getMinFixedFee());
    this.setPaymentProgramType(other.getPaymentProgramType());
    this.setAccount(other.getAccount());
    this.setLastUpdateDate(new Date());
  }
} // end class NegotiateProgramType
