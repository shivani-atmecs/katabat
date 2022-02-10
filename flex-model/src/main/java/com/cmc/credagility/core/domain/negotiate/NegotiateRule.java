package com.cmc.credagility.core.domain.negotiate;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.payment.PaymentProgramType;
import com.cmc.credagility.core.domain.schedule.BaseRule;
import com.cmc.credagility.core.domain.util.CompareUtil;


/**
 * This class is used to store payment negotiate rule information.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/14/2014 17:56
 */
@Entity
@Table(name = "NegotiateRule")
public class NegotiateRule extends BaseRule {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2571042068968270769L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  // npelleti, 07/30, USBank, Added NotNull Annotation
  /** Floor Percentage of principal. */
  @Column(
    name      = "floorPercentage",
    nullable  = false,
    precision = 19,
    scale     = 2
  )
  protected BigDecimal floorPercentage;

  /** Longest Duration. */
  @Column(
    name     = "longestDuration",
    nullable = false
  )
  protected Integer longestDuration;


  /** Minimum Fix Fee amount. */
  @Column(name = "minFixedFee")
  protected BigDecimal minFixedFee = new BigDecimal("0.00");

  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "scheduleId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected NegotiateSchedule negotiateSchedule = new NegotiateSchedule();

  /**
   * The principal type used to calculate the payment amount. Could be totalDue, pastDue, currentDue, overLimit,
   * balance, etc.
   */
  @Column(
    name     = "principalType",
    length   = 64,
    nullable = false
  )
  protected String principalType;

  // npelleti, 07/30, USBank, Added NotNull Annotation
  /** Program valid dayes upon it was created. */
  @Column(
    name     = "programValidDays",
    length   = 11,
    nullable = false
  )
  protected Integer programValidDays = 7;

  // npelleti, 07/30, USBank, Removed unique constraint
  /** Rule Id, PK. */
  @Column(
    name     = "ruleId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long ruleId;

  /** Payment Program Type. */
  @JoinColumn(
    name     = "programTypeId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected PaymentProgramType type = new PaymentProgramType();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Business equals does not care about the createDate. Only to check if two schedule are the identical from business
   * perspective. This is perfect for dirty check when update schedule
   *
   * @param   obj  $param.type$
   *
   * @return  business equals does not care about the createDate.
   */
  public boolean businessEquals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (this.equals(obj)) {
      return true;
    }

    NegotiateRule other = (NegotiateRule) obj;

    if (minFixedFee == null) {
      if (other.minFixedFee != null) {
        return false;
      }
    } else if (minFixedFee.compareTo(other.minFixedFee) != 0) {
      return false;
    }

    if (floorPercentage == null) {
      if (other.floorPercentage != null) {
        return false;
      }
    } else if (floorPercentage.compareTo(other.floorPercentage) != 0) {
      return false;
    }

    return true;
  } // end method businessEquals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Copy criteria only rule.
   *
   * @param  other  $param.type$
   */
  public void copyCriteria(NegotiateRule other) {
    super.deepCopy(other);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Copy from other rule.
   *
   * @param  other  $param.type$
   */
  public void deepCopy(NegotiateRule other) {
    super.deepCopy(other);

    this.type = other.getType();

    if (other.getLongestDuration() != null) {
      this.longestDuration = new Integer(other.getLongestDuration());
    }

    this.floorPercentage = other.getFloorPercentage();
    this.principalType   = other.getPrincipalType();
    this.minFixedFee     = other.getMinFixedFee();

    if (other.getProgramValidDays() != null) {
      this.programValidDays = other.getProgramValidDays().intValue();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
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

    NegotiateRule other = (NegotiateRule) obj;

    if (floorPercentage == null) {
      if (other.floorPercentage != null) {
        return false;
      }
    } else if (!floorPercentage.equals(other.floorPercentage)) {
      return false;
    }

    if (longestDuration == null) {
      if (other.longestDuration != null) {
        return false;
      }
    } else if (!longestDuration.equals(other.longestDuration)) {
      return false;
    }

    if (minFixedFee == null) {
      if (other.minFixedFee != null) {
        return false;
      }
    } else if (!minFixedFee.equals(other.minFixedFee)) {
      return false;
    }

    if (principalType == null) {
      if (other.principalType != null) {
        return false;
      }
    } else if (!principalType.equals(other.principalType)) {
      return false;
    }

    if (programValidDays == null) {
      if (other.programValidDays != null) {
        return false;
      }
    } else if (!programValidDays.equals(other.programValidDays)) {
      return false;
    }

    if (type == null) {
      if (other.type != null) {
        return false;
      }
    } else if (!type.equals(other.type)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * In theory, this floorPercentage equals negotiateAmount divided by principalWhenCreated. In practice, when we
   * strategize a payment negotiate, we specify the floorPercentage. However, However the totlAmount may not be
   * divisible by the longestDuration. Say, if balance is $1,000 and we want to offer a 70% settlement and a
   * longestDuration of 3. Then we get $700/3 = $233.33333333... So in practice, we re-adjust the negotiate: 1.
   * Mathmatically round installment amount of $233.33333333... to $233.33 2. Readjust the total amount to $233.33 * 3 =
   * $699.99 (not $700 any more) 3. Keep the floorPercentage as 70% (no need to adjust to 69.99%)
   *
   * @return  the floorPercentage of the principalWhenCreated for payment negotiate
   */
  public BigDecimal getFloorPercentage() {
    return floorPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the longestDuration
   */
  public Integer getLongestDuration() {
    return longestDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  fixed fee amount of the payment negotiate. Could be null.
   */
  public BigDecimal getMinFixedFee() {
    return minFixedFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for negotiate schedule.
   *
   * @return  NegotiateSchedule
   */
  public NegotiateSchedule getNegotiateSchedule() {
    return negotiateSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  the type of the principalWhenCreated used to calculate the total amount of the negotiate. Could be
   *          "balance", "totalDue", etc.
   */
  public String getPrincipalType() {
    return principalType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program valid days.
   *
   * @return  Integer
   */
  public Integer getProgramValidDays() {
    return programValidDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule id.
   *
   * @return  Long
   */
  @Override public Long getRuleId() {
    return ruleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see com.cmc.credagility.BaseRule#getRuleType()
   */
  @Override public String getRuleType() {
    return "NegotiateRule";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type.
   *
   * @return  PaymentProgramType
   */
  public PaymentProgramType getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((floorPercentage == null) ? 0 : floorPercentage.hashCode());
    result = (prime * result)
      + ((longestDuration == null) ? 0 : longestDuration.hashCode());
    result = (prime * result)
      + ((minFixedFee == null) ? 0 : minFixedFee.hashCode());
    result = (prime * result)
      + ((principalType == null) ? 0 : principalType.hashCode());
    result = (prime * result)
      + ((programValidDays == null) ? 0 : programValidDays.hashCode());
    result = (prime * result) + ((type == null) ? 0 : type.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  percentage  the floorPercentage to set
   */
  public void setFloorPercentage(BigDecimal percentage) {
    this.floorPercentage = percentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  duration  the longestDuration to set
   */
  public void setLongestDuration(Integer duration) {
    this.longestDuration = duration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  fixedFeeAmount  the minFixedFee to set
   */
  public void setMinFixedFee(BigDecimal fixedFeeAmount) {
    this.minFixedFee = fixedFeeAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  negotiateSchedule  the negotiateSchedule to set
   */
  public void setNegotiateSchedule(NegotiateSchedule negotiateSchedule) {
    this.negotiateSchedule = negotiateSchedule;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  principalType  the principalType to set
   */
  public void setPrincipalType(String principalType) {
    this.principalType = principalType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programValidDays  the programValidDays to set
   */
  public void setProgramValidDays(Integer programValidDays) {
    this.programValidDays = programValidDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  ruleId  the ruleId to set
   */
  public void setRuleId(Long ruleId) {
    this.ruleId = ruleId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  type  the type to set
   */
  public void setType(PaymentProgramType type) {
    this.type = type;
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

    retValue.append("NegotiateRule ( ").append(super.toString()).append(TAB).append("floorPercentage = ").append(
      this.floorPercentage).append(TAB).append("longestDuration = ").append(this.longestDuration).append(TAB).append(
      "minFixedFee = ").append(this.minFixedFee).append(TAB).append(
      "negotiateSchedule = ").append(this.negotiateSchedule).append(TAB).append("principalType = ").append(
      this.principalType).append(TAB).append("programValidDays = ").append(this.programValidDays).append(TAB).append(
      "ruleId = ").append(this.ruleId).append(TAB).append("type = ").append(this.type).append(TAB).append(" )");

    return retValue.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Update rule form other rule return false if there is no difference return true if there are some difference and
   * update success.
   *
   * @param   negotiateRule  $param.type$
   *
   * @return  update rule form other rule return false if there is no difference return true if there are some
   *          difference and update success.
   */
  public boolean updateRule(NegotiateRule negotiateRule) {
    if (!businessEquals(negotiateRule) || !(CompareUtil.nullSafeEquals(this.priority, negotiateRule.priority))) {
      // there are difference, copy form it
      this.deepCopy(negotiateRule);

      return true;
    }

    return false;
  }
} // end class NegotiateRule
