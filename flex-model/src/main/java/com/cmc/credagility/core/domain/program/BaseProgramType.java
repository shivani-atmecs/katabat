package com.cmc.credagility.core.domain.program;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.payment.PaymentProgramType;


/**
 * This class is used to store Program Type information.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 10:10
 */
@MappedSuperclass public abstract class BaseProgramType extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -6406498559178122627L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** floor percent. */
  @Column(
    name     = "floorPercentage",
    nullable = false
  )
  protected BigDecimal floorPercentage;

  /** the longest durations. */
  @Column(
    name     = "longestDuration",
    nullable = false
  )
  protected Integer longestDuration;

  /** minimum fixed fee. */
  @Column(
    name     = "minFixedFee",
    nullable = false
  )
  protected BigDecimal minFixedFee;

  /** payment program type. */
  @JoinColumn(
    name      = "programTypeId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected PaymentProgramType paymentProgramType;

  /** principalWhenCreated type, which amount should be calculate based on. */
  @Column(
    name     = "principalType",
    nullable = false,
    length   = 50
  )
  protected String principalType;

  /** Program valid dates upon it was created. */
  @Column(
    name     = "programValidDays",
    nullable = false
  )
  protected Integer programValidDays = 7;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new BaseProgramType object.
   */
  public BaseProgramType() {
    super();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Business equals does not care about the createDate. It does not care about the java.util.Set contract. Only to
   * check if two payments are the identical from business perspective. This is perfect for dirty check when edit
   * payments.
   *
   * @param   obj  DOCUMENT ME!
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

    BaseProgramType other = (BaseProgramType) obj;

    if (floorPercentage == null) {
      if (other.getFloorPercentage() != null) {
        return false;
      }
    } else if (floorPercentage.compareTo(other.getFloorPercentage()) != 0) {
      return false;
    }

    if (longestDuration == null) {
      if (other.getLongestDuration() != null) {
        return false;
      }
    } else if (!longestDuration.equals(other.getLongestDuration())) {
      return false;
    }

    if (minFixedFee == null) {
      if (other.getMinFixedFee() != null) {
        return false;
      }
    } else if (minFixedFee.compareTo(other.getMinFixedFee()) != 0) {
      return false;
    }

    if (paymentProgramType == null) {
      if (other.getPaymentProgramType() != null) {
        return false;
      }
    } else if (!paymentProgramType.getProgramTypeId().equals(
            other.getPaymentProgramType().getProgramTypeId())) {
      return false;
    }

    if (principalType == null) {
      if (other.getPrincipalType() != null) {
        return false;
      }
    } else if (!principalType.equals(other.getPrincipalType())) {
      return false;
    }

    if (programValidDays == null) {
      if (other.getProgramValidDays() != null) {
        return false;
      }
    } else if (!programValidDays.equals(other.getProgramValidDays())) {
      return false;
    }

    return true;
  } // end method businessEquals

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */

  // end method businessEquals

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    if (!super.equals(obj)) {
      return false;
    }

    BaseProgramType other = (BaseProgramType) obj;

    if (floorPercentage == null) {
      if (other.floorPercentage != null) {
        return false;
      }
    } else if (!floorPercentage.equals(other.getFloorPercentage())) {
      return false;
    }

    if (longestDuration == null) {
      if (other.longestDuration != null) {
        return false;
      }
    } else if (!longestDuration.equals(other.getLongestDuration())) {
      return false;
    }

    if (minFixedFee == null) {
      if (other.minFixedFee != null) {
        return false;
      }
    } else if (!minFixedFee.equals(other.getMinFixedFee())) {
      return false;
    }

    if (paymentProgramType == null) {
      if (other.paymentProgramType != null) {
        return false;
      }
    } else if (!paymentProgramType.equals(other.getPaymentProgramType())) {
      return false;
    }

    if (principalType == null) {
      if (other.principalType != null) {
        return false;
      }
    } else if (!principalType.equals(other.getPrincipalType())) {
      return false;
    }

    if (programValidDays == null) {
      if (other.programValidDays != null) {
        return false;
      }
    } else if (!programValidDays.equals(other.getProgramValidDays())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for floor percentage.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFloorPercentage() {
    return this.floorPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for longest duration.
   *
   * @return  Integer
   */
  public Integer getLongestDuration() {
    return this.longestDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for min fixed fee.
   *
   * @return  BigDecimal
   */
  public BigDecimal getMinFixedFee() {
    return this.minFixedFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment program type.
   *
   * @return  PaymentProgramType
   */
  public PaymentProgramType getPaymentProgramType() {
    return this.paymentProgramType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for principal type.
   *
   * @return  String
   */
  public String getPrincipalType() {
    return this.principalType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program valid days.
   *
   * @return  Integer
   */
  public Integer getProgramValidDays() {
    return this.programValidDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
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
      + ((paymentProgramType == null) ? 0 : paymentProgramType.hashCode());
    result = (prime * result)
      + ((principalType == null) ? 0 : principalType.hashCode());
    result = (prime * result)
      + ((programValidDays == null) ? 0 : programValidDays.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for floor percentage.
   *
   * @param  floorPercentage  BigDecimal
   */
  public void setFloorPercentage(BigDecimal floorPercentage) {
    this.floorPercentage = floorPercentage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for longest duration.
   *
   * @param  longestDuration  Integer
   */
  public void setLongestDuration(Integer longestDuration) {
    this.longestDuration = longestDuration;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for min fixed fee.
   *
   * @param  minFixedFee  BigDecimal
   */
  public void setMinFixedFee(BigDecimal minFixedFee) {
    this.minFixedFee = minFixedFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment program type.
   *
   * @param  paymentProgramType  PaymentProgramType
   */
  public void setPaymentProgramType(PaymentProgramType paymentProgramType) {
    this.paymentProgramType = paymentProgramType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for principal type.
   *
   * @param  principalType  String
   */
  public void setPrincipalType(String principalType) {
    this.principalType = principalType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program valid days.
   *
   * @param  programValidDays  Integer
   */
  public void setProgramValidDays(Integer programValidDays) {
    this.programValidDays = programValidDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("BaseProgramType ( ").append(super.toString()).append(TAB).append("floorPercentage = ").append(
      this.floorPercentage).append(TAB).append("longestDuration = ").append(this.longestDuration).append(TAB).append(
      "minFixedFee = ").append(this.minFixedFee).append(TAB).append(
      "paymentProgramType = ").append(this.paymentProgramType).append(TAB).append("principalType = ").append(
      this.principalType).append(TAB).append("programValidDays = ").append(
      this.programValidDays).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class BaseProgramType
