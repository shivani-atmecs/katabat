package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

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

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * Account balance and bucket amount break down details.
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/14/2014 17:43
 */
@Entity
@Table(name = "AccountBalanceBreakDown")
public class AccountBalanceBreakDown extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3103431996320501353L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account Balance Break Down id PK. */
  @Column
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long         id;

  @JoinColumn(
    name     = "accountNum",
    unique   = true,
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Account account;

  @Column(name = "arrearsAmount")
  private BigDecimal arrearsAmount;

  @Column(name = "arrearsAmountFee")
  private BigDecimal arrearsAmountFee;

  @Column(name = "arrearsAmountInterest")
  private BigDecimal arrearsAmountInterest;

  @Column(name = "arrearsAmountPrincipal")
  private BigDecimal arrearsAmountPrincipal;

  @Column(name = "balanceAmountFee")
  private BigDecimal balanceAmountFee;

  @Column(name = "balanceAmountInterest")
  private BigDecimal balanceAmountInterest;

  @Column(name = "balanceAmountPrincipal")
  private BigDecimal balanceAmountPrincipal;

  @Column(name = "bucket1AmountFee")
  private BigDecimal bucket1AmountFee;

  @Column(name = "bucket1AmountInterest")
  private BigDecimal bucket1AmountInterest;

  @Column(name = "bucket1AmountPrincipal")
  private BigDecimal bucket1AmountPrincipal;

  @Column(name = "bucket2AmountFee")
  private BigDecimal bucket2AmountFee;

  @Column(name = "bucket2AmountInterest")
  private BigDecimal bucket2AmountInterest;

  @Column(name = "bucket2AmountPrincipal")
  private BigDecimal bucket2AmountPrincipal;

  @Column(name = "bucket3AmountFee")
  private BigDecimal bucket3AmountFee;

  @Column(name = "bucket3AmountInterest")
  private BigDecimal bucket3AmountInterest;

  @Column(name = "bucket3AmountPrincipal")
  private BigDecimal bucket3AmountPrincipal;

  @Column(name = "bucket4AmountFee")
  private BigDecimal bucket4AmountFee;

  @Column(name = "bucket4AmountInterest")
  private BigDecimal bucket4AmountInterest;

  @Column(name = "bucket4AmountPrincipal")
  private BigDecimal bucket4AmountPrincipal;

  @Column(name = "bucket5AmountFee")
  private BigDecimal bucket5AmountFee;

  @Column(name = "bucket5AmountInterest")
  private BigDecimal bucket5AmountInterest;

  @Column(name = "bucket5AmountPrincipal")
  private BigDecimal bucket5AmountPrincipal;
  @Column(name = "bucket6AmountFee")
  private BigDecimal bucket6AmountFee;

  @Column(name = "bucket6AmountInterest")
  private BigDecimal bucket6AmountInterest;

  @Column(name = "bucket6AmountPrincipal")
  private BigDecimal bucket6AmountPrincipal;

  @Column(name = "bucket7AmountFee")
  private BigDecimal bucket7AmountFee;

  @Column(name = "bucket7AmountInterest")
  private BigDecimal bucket7AmountInterest;

  @Column(name = "bucket7AmountPrincipal")
  private BigDecimal bucket7AmountPrincipal;

  @Column(name = "fee")
  private BigDecimal fee;

  @Column(name = "interest")
  private BigDecimal interest;

  @Column(name = "other")
  private BigDecimal other;

  @Column(name = "outstandingAmount")
  private BigDecimal outstandingAmount;

  @Column(name = "outstandingAmountFee")
  private BigDecimal outstandingAmountFee;

  @Column(name = "outstandingAmountInterest")
  private BigDecimal outstandingAmountInterest;

  @Column(name = "outstandingAmountPrincipal")
  private BigDecimal outstandingAmountPrincipal;

  @Column(name = "principal")
  private BigDecimal principal;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new $class.name$ object.
   */
  public AccountBalanceBreakDown() { }

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

    AccountBalanceBreakDown that = (AccountBalanceBreakDown) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((arrearsAmount != null) ? (!arrearsAmount.equals(that.arrearsAmount)) : (that.arrearsAmount != null)) {
      return false;
    }

    if ((arrearsAmountFee != null) ? (!arrearsAmountFee.equals(that.arrearsAmountFee))
                                   : (that.arrearsAmountFee != null)) {
      return false;
    }

    if ((arrearsAmountInterest != null) ? (!arrearsAmountInterest.equals(that.arrearsAmountInterest))
                                        : (that.arrearsAmountInterest != null)) {
      return false;
    }

    if ((arrearsAmountPrincipal != null) ? (!arrearsAmountPrincipal.equals(that.arrearsAmountPrincipal))
                                         : (that.arrearsAmountPrincipal != null)) {
      return false;
    }

    if ((balanceAmountFee != null) ? (!balanceAmountFee.equals(that.balanceAmountFee))
                                   : (that.balanceAmountFee != null)) {
      return false;
    }

    if ((balanceAmountInterest != null) ? (!balanceAmountInterest.equals(that.balanceAmountInterest))
                                        : (that.balanceAmountInterest != null)) {
      return false;
    }

    if ((balanceAmountPrincipal != null) ? (!balanceAmountPrincipal.equals(that.balanceAmountPrincipal))
                                         : (that.balanceAmountPrincipal != null)) {
      return false;
    }

    if ((bucket1AmountFee != null) ? (!bucket1AmountFee.equals(that.bucket1AmountFee))
                                   : (that.bucket1AmountFee != null)) {
      return false;
    }

    if ((bucket1AmountInterest != null) ? (!bucket1AmountInterest.equals(that.bucket1AmountInterest))
                                        : (that.bucket1AmountInterest != null)) {
      return false;
    }

    if ((bucket1AmountPrincipal != null) ? (!bucket1AmountPrincipal.equals(that.bucket1AmountPrincipal))
                                         : (that.bucket1AmountPrincipal != null)) {
      return false;
    }

    if ((bucket2AmountFee != null) ? (!bucket2AmountFee.equals(that.bucket2AmountFee))
                                   : (that.bucket2AmountFee != null)) {
      return false;
    }

    if ((bucket2AmountInterest != null) ? (!bucket2AmountInterest.equals(that.bucket2AmountInterest))
                                        : (that.bucket2AmountInterest != null)) {
      return false;
    }

    if ((bucket2AmountPrincipal != null) ? (!bucket2AmountPrincipal.equals(that.bucket2AmountPrincipal))
                                         : (that.bucket2AmountPrincipal != null)) {
      return false;
    }

    if ((bucket3AmountFee != null) ? (!bucket3AmountFee.equals(that.bucket3AmountFee))
                                   : (that.bucket3AmountFee != null)) {
      return false;
    }

    if ((bucket3AmountInterest != null) ? (!bucket3AmountInterest.equals(that.bucket3AmountInterest))
                                        : (that.bucket3AmountInterest != null)) {
      return false;
    }

    if ((bucket3AmountPrincipal != null) ? (!bucket3AmountPrincipal.equals(that.bucket3AmountPrincipal))
                                         : (that.bucket3AmountPrincipal != null)) {
      return false;
    }

    if ((bucket4AmountFee != null) ? (!bucket4AmountFee.equals(that.bucket4AmountFee))
                                   : (that.bucket4AmountFee != null)) {
      return false;
    }

    if ((bucket4AmountInterest != null) ? (!bucket4AmountInterest.equals(that.bucket4AmountInterest))
                                        : (that.bucket4AmountInterest != null)) {
      return false;
    }

    if ((bucket4AmountPrincipal != null) ? (!bucket4AmountPrincipal.equals(that.bucket4AmountPrincipal))
                                         : (that.bucket4AmountPrincipal != null)) {
      return false;
    }

    if ((bucket5AmountFee != null) ? (!bucket5AmountFee.equals(that.bucket5AmountFee))
                                   : (that.bucket5AmountFee != null)) {
      return false;
    }

    if ((bucket5AmountInterest != null) ? (!bucket5AmountInterest.equals(that.bucket5AmountInterest))
                                        : (that.bucket5AmountInterest != null)) {
      return false;
    }

    if ((bucket5AmountPrincipal != null) ? (!bucket5AmountPrincipal.equals(that.bucket5AmountPrincipal))
                                         : (that.bucket5AmountPrincipal != null)) {
      return false;
    }

    if ((bucket6AmountFee != null) ? (!bucket6AmountFee.equals(that.bucket6AmountFee))
                                   : (that.bucket6AmountFee != null)) {
      return false;
    }

    if ((bucket6AmountInterest != null) ? (!bucket6AmountInterest.equals(that.bucket6AmountInterest))
                                        : (that.bucket6AmountInterest != null)) {
      return false;
    }

    if ((bucket6AmountPrincipal != null) ? (!bucket6AmountPrincipal.equals(that.bucket6AmountPrincipal))
                                         : (that.bucket6AmountPrincipal != null)) {
      return false;
    }

    if ((bucket7AmountFee != null) ? (!bucket7AmountFee.equals(that.bucket7AmountFee))
                                   : (that.bucket7AmountFee != null)) {
      return false;
    }

    if ((bucket7AmountInterest != null) ? (!bucket7AmountInterest.equals(that.bucket7AmountInterest))
                                        : (that.bucket7AmountInterest != null)) {
      return false;
    }

    if ((bucket7AmountPrincipal != null) ? (!bucket7AmountPrincipal.equals(that.bucket7AmountPrincipal))
                                         : (that.bucket7AmountPrincipal != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((outstandingAmount != null) ? (!outstandingAmount.equals(that.outstandingAmount))
                                    : (that.outstandingAmount != null)) {
      return false;
    }

    if ((outstandingAmountFee != null) ? (!outstandingAmountFee.equals(that.outstandingAmountFee))
                                       : (that.outstandingAmountFee != null)) {
      return false;
    }

    if ((outstandingAmountInterest != null) ? (!outstandingAmountInterest.equals(that.outstandingAmountInterest))
                                            : (that.outstandingAmountInterest != null)) {
      return false;
    }

    if ((outstandingAmountPrincipal != null) ? (!outstandingAmountPrincipal.equals(that.outstandingAmountPrincipal))
                                             : (that.outstandingAmountPrincipal != null)) {
      return false;
    }

    if ((principal != null) ? (!principal.equals(that.principal)) : (that.principal != null)) {
      return false;
    }

    if ((interest != null) ? (!interest.equals(that.interest)) : (that.interest != null)) {
      return false;
    }

    if ((fee != null) ? (!fee.equals(that.fee)) : (that.fee != null)) {
      return false;
    }

    if ((other != null) ? (!other.equals(that.other)) : (that.other != null)) {
      return false;
    }

    return true;
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
   * getter method for arrears amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getArrearsAmount() {
    return arrearsAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for arrears amount fee.
   *
   * @return  BigDecimal
   */
  public BigDecimal getArrearsAmountFee() {
    return arrearsAmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for arrears amount interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getArrearsAmountInterest() {
    return arrearsAmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for arrears amount principal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getArrearsAmountPrincipal() {
    return arrearsAmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for balance amount fee.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBalanceAmountFee() {
    return balanceAmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for balance amount interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBalanceAmountInterest() {
    return balanceAmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for balance amount principal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBalanceAmountPrincipal() {
    return balanceAmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket1 amount fee.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket1AmountFee() {
    return bucket1AmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket1 amount interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket1AmountInterest() {
    return bucket1AmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket1 amount principal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket1AmountPrincipal() {
    return bucket1AmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket2 amount fee.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket2AmountFee() {
    return bucket2AmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket2 amount interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket2AmountInterest() {
    return bucket2AmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket2 amount principal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket2AmountPrincipal() {
    return bucket2AmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket3 amount fee.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket3AmountFee() {
    return bucket3AmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket3 amount interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket3AmountInterest() {
    return bucket3AmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket3 amount principal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket3AmountPrincipal() {
    return bucket3AmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket4 amount fee.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket4AmountFee() {
    return bucket4AmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket4 amount interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket4AmountInterest() {
    return bucket4AmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket4 amount principal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket4AmountPrincipal() {
    return bucket4AmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket5 amount fee.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket5AmountFee() {
    return bucket5AmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket5 amount interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket5AmountInterest() {
    return bucket5AmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket5 amount principal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket5AmountPrincipal() {
    return bucket5AmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket6 amount fee.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket6AmountFee() {
    return bucket6AmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket6 amount interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket6AmountInterest() {
    return bucket6AmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket6 amount principal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket6AmountPrincipal() {
    return bucket6AmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket7 amount fee.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket7AmountFee() {
    return bucket7AmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket7 amount interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket7AmountInterest() {
    return bucket7AmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket7 amount principal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucket7AmountPrincipal() {
    return bucket7AmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fee.
   *
   * @return  BigDecimal
   */
  public BigDecimal getFee() {
    return fee;
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
   * getter method for interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getInterest() {
    return interest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for other.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOther() {
    return other;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for outstanding amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOutstandingAmount() {
    return outstandingAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for outstanding amount fee.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOutstandingAmountFee() {
    return outstandingAmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for outstanding amount interest.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOutstandingAmountInterest() {
    return outstandingAmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for outstanding amount principal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getOutstandingAmountPrincipal() {
    return outstandingAmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for principal.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPrincipal() {
    return principal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((arrearsAmount != null) ? arrearsAmount.hashCode() : 0);
    result = (31 * result) + ((arrearsAmountFee != null) ? arrearsAmountFee.hashCode() : 0);
    result = (31 * result) + ((arrearsAmountInterest != null) ? arrearsAmountInterest.hashCode() : 0);
    result = (31 * result) + ((arrearsAmountPrincipal != null) ? arrearsAmountPrincipal.hashCode() : 0);
    result = (31 * result) + ((balanceAmountFee != null) ? balanceAmountFee.hashCode() : 0);
    result = (31 * result) + ((balanceAmountInterest != null) ? balanceAmountInterest.hashCode() : 0);
    result = (31 * result) + ((balanceAmountPrincipal != null) ? balanceAmountPrincipal.hashCode() : 0);
    result = (31 * result) + ((bucket1AmountFee != null) ? bucket1AmountFee.hashCode() : 0);
    result = (31 * result) + ((bucket1AmountInterest != null) ? bucket1AmountInterest.hashCode() : 0);
    result = (31 * result) + ((bucket1AmountPrincipal != null) ? bucket1AmountPrincipal.hashCode() : 0);
    result = (31 * result) + ((bucket2AmountFee != null) ? bucket2AmountFee.hashCode() : 0);
    result = (31 * result) + ((bucket2AmountInterest != null) ? bucket2AmountInterest.hashCode() : 0);
    result = (31 * result) + ((bucket2AmountPrincipal != null) ? bucket2AmountPrincipal.hashCode() : 0);
    result = (31 * result) + ((bucket3AmountFee != null) ? bucket3AmountFee.hashCode() : 0);
    result = (31 * result) + ((bucket3AmountInterest != null) ? bucket3AmountInterest.hashCode() : 0);
    result = (31 * result) + ((bucket3AmountPrincipal != null) ? bucket3AmountPrincipal.hashCode() : 0);
    result = (31 * result) + ((bucket4AmountFee != null) ? bucket4AmountFee.hashCode() : 0);
    result = (31 * result) + ((bucket4AmountInterest != null) ? bucket4AmountInterest.hashCode() : 0);
    result = (31 * result) + ((bucket4AmountPrincipal != null) ? bucket4AmountPrincipal.hashCode() : 0);
    result = (31 * result) + ((bucket5AmountFee != null) ? bucket5AmountFee.hashCode() : 0);
    result = (31 * result) + ((bucket5AmountInterest != null) ? bucket5AmountInterest.hashCode() : 0);
    result = (31 * result) + ((bucket5AmountPrincipal != null) ? bucket5AmountPrincipal.hashCode() : 0);
    result = (31 * result) + ((bucket6AmountFee != null) ? bucket6AmountFee.hashCode() : 0);
    result = (31 * result) + ((bucket6AmountInterest != null) ? bucket6AmountInterest.hashCode() : 0);
    result = (31 * result) + ((bucket6AmountPrincipal != null) ? bucket6AmountPrincipal.hashCode() : 0);
    result = (31 * result) + ((bucket7AmountFee != null) ? bucket7AmountFee.hashCode() : 0);
    result = (31 * result) + ((bucket7AmountInterest != null) ? bucket7AmountInterest.hashCode() : 0);
    result = (31 * result) + ((bucket7AmountPrincipal != null) ? bucket7AmountPrincipal.hashCode() : 0);
    result = (31 * result) + ((outstandingAmount != null) ? outstandingAmount.hashCode() : 0);
    result = (31 * result) + ((outstandingAmountFee != null) ? outstandingAmountFee.hashCode() : 0);
    result = (31 * result) + ((outstandingAmountInterest != null) ? outstandingAmountInterest.hashCode() : 0);
    result = (31 * result) + ((outstandingAmountPrincipal != null) ? outstandingAmountPrincipal.hashCode() : 0);
    result = (31 * result) + ((principal != null) ? principal.hashCode() : 0);
    result = (31 * result) + ((interest != null) ? interest.hashCode() : 0);
    result = (31 * result) + ((fee != null) ? fee.hashCode() : 0);
    result = (31 * result) + ((other != null) ? other.hashCode() : 0);

    return result;
  } // end method hashCode

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
   * setter method for arrears amount.
   *
   * @param  arrearsAmount  BigDecimal
   */
  public void setArrearsAmount(BigDecimal arrearsAmount) {
    this.arrearsAmount = arrearsAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for arrears amount fee.
   *
   * @param  arrearsAmountFee  BigDecimal
   */
  public void setArrearsAmountFee(BigDecimal arrearsAmountFee) {
    this.arrearsAmountFee = arrearsAmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for arrears amount interest.
   *
   * @param  arrearsAmountInterest  BigDecimal
   */
  public void setArrearsAmountInterest(BigDecimal arrearsAmountInterest) {
    this.arrearsAmountInterest = arrearsAmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for arrears amount principal.
   *
   * @param  arrearsAmountPrincipal  BigDecimal
   */
  public void setArrearsAmountPrincipal(BigDecimal arrearsAmountPrincipal) {
    this.arrearsAmountPrincipal = arrearsAmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for balance amount fee.
   *
   * @param  balanceAmountFee  BigDecimal
   */
  public void setBalanceAmountFee(BigDecimal balanceAmountFee) {
    this.balanceAmountFee = balanceAmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for balance amount interest.
   *
   * @param  balanceAmountInterest  BigDecimal
   */
  public void setBalanceAmountInterest(BigDecimal balanceAmountInterest) {
    this.balanceAmountInterest = balanceAmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for balance amount principal.
   *
   * @param  balanceAmountPrincipal  BigDecimal
   */
  public void setBalanceAmountPrincipal(BigDecimal balanceAmountPrincipal) {
    this.balanceAmountPrincipal = balanceAmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket1 amount fee.
   *
   * @param  bucket1AmountFee  BigDecimal
   */
  public void setBucket1AmountFee(BigDecimal bucket1AmountFee) {
    this.bucket1AmountFee = bucket1AmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket1 amount interest.
   *
   * @param  bucket1AmountInterest  BigDecimal
   */
  public void setBucket1AmountInterest(BigDecimal bucket1AmountInterest) {
    this.bucket1AmountInterest = bucket1AmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket1 amount principal.
   *
   * @param  bucket1AmountPrincipal  BigDecimal
   */
  public void setBucket1AmountPrincipal(BigDecimal bucket1AmountPrincipal) {
    this.bucket1AmountPrincipal = bucket1AmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket2 amount fee.
   *
   * @param  bucket2AmountFee  BigDecimal
   */
  public void setBucket2AmountFee(BigDecimal bucket2AmountFee) {
    this.bucket2AmountFee = bucket2AmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket2 amount interest.
   *
   * @param  bucket2AmountInterest  BigDecimal
   */
  public void setBucket2AmountInterest(BigDecimal bucket2AmountInterest) {
    this.bucket2AmountInterest = bucket2AmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket2 amount principal.
   *
   * @param  bucket2AmountPrincipal  BigDecimal
   */
  public void setBucket2AmountPrincipal(BigDecimal bucket2AmountPrincipal) {
    this.bucket2AmountPrincipal = bucket2AmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket3 amount fee.
   *
   * @param  bucket3AmountFee  BigDecimal
   */
  public void setBucket3AmountFee(BigDecimal bucket3AmountFee) {
    this.bucket3AmountFee = bucket3AmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket3 amount interest.
   *
   * @param  bucket3AmountInterest  BigDecimal
   */
  public void setBucket3AmountInterest(BigDecimal bucket3AmountInterest) {
    this.bucket3AmountInterest = bucket3AmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket3 amount principal.
   *
   * @param  bucket3AmountPrincipal  BigDecimal
   */
  public void setBucket3AmountPrincipal(BigDecimal bucket3AmountPrincipal) {
    this.bucket3AmountPrincipal = bucket3AmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket4 amount fee.
   *
   * @param  bucket4AmountFee  BigDecimal
   */
  public void setBucket4AmountFee(BigDecimal bucket4AmountFee) {
    this.bucket4AmountFee = bucket4AmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket4 amount interest.
   *
   * @param  bucket4AmountInterest  BigDecimal
   */
  public void setBucket4AmountInterest(BigDecimal bucket4AmountInterest) {
    this.bucket4AmountInterest = bucket4AmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket4 amount principal.
   *
   * @param  bucket4AmountPrincipal  BigDecimal
   */
  public void setBucket4AmountPrincipal(BigDecimal bucket4AmountPrincipal) {
    this.bucket4AmountPrincipal = bucket4AmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket5 amount fee.
   *
   * @param  bucket5AmountFee  BigDecimal
   */
  public void setBucket5AmountFee(BigDecimal bucket5AmountFee) {
    this.bucket5AmountFee = bucket5AmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket5 amount interest.
   *
   * @param  bucket5AmountInterest  BigDecimal
   */
  public void setBucket5AmountInterest(BigDecimal bucket5AmountInterest) {
    this.bucket5AmountInterest = bucket5AmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket5 amount principal.
   *
   * @param  bucket5AmountPrincipal  BigDecimal
   */
  public void setBucket5AmountPrincipal(BigDecimal bucket5AmountPrincipal) {
    this.bucket5AmountPrincipal = bucket5AmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket6 amount fee.
   *
   * @param  bucket6AmountFee  BigDecimal
   */
  public void setBucket6AmountFee(BigDecimal bucket6AmountFee) {
    this.bucket6AmountFee = bucket6AmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket6 amount interest.
   *
   * @param  bucket6AmountInterest  BigDecimal
   */
  public void setBucket6AmountInterest(BigDecimal bucket6AmountInterest) {
    this.bucket6AmountInterest = bucket6AmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket6 amount principal.
   *
   * @param  bucket6AmountPrincipal  BigDecimal
   */
  public void setBucket6AmountPrincipal(BigDecimal bucket6AmountPrincipal) {
    this.bucket6AmountPrincipal = bucket6AmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket7 amount fee.
   *
   * @param  bucket7AmountFee  BigDecimal
   */
  public void setBucket7AmountFee(BigDecimal bucket7AmountFee) {
    this.bucket7AmountFee = bucket7AmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket7 amount interest.
   *
   * @param  bucket7AmountInterest  BigDecimal
   */
  public void setBucket7AmountInterest(BigDecimal bucket7AmountInterest) {
    this.bucket7AmountInterest = bucket7AmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket7 amount principal.
   *
   * @param  bucket7AmountPrincipal  BigDecimal
   */
  public void setBucket7AmountPrincipal(BigDecimal bucket7AmountPrincipal) {
    this.bucket7AmountPrincipal = bucket7AmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fee.
   *
   * @param  fee  BigDecimal
   */
  public void setFee(BigDecimal fee) {
    this.fee = fee;
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
   * setter method for interest.
   *
   * @param  interest  BigDecimal
   */
  public void setInterest(BigDecimal interest) {
    this.interest = interest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for other.
   *
   * @param  other  BigDecimal
   */
  public void setOther(BigDecimal other) {
    this.other = other;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for outstanding amount.
   *
   * @param  outstandingAmount  BigDecimal
   */
  public void setOutstandingAmount(BigDecimal outstandingAmount) {
    this.outstandingAmount = outstandingAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for outstanding amount fee.
   *
   * @param  outstandingAmountFee  BigDecimal
   */
  public void setOutstandingAmountFee(BigDecimal outstandingAmountFee) {
    this.outstandingAmountFee = outstandingAmountFee;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for outstanding amount interest.
   *
   * @param  outstandingAmountInterest  BigDecimal
   */
  public void setOutstandingAmountInterest(BigDecimal outstandingAmountInterest) {
    this.outstandingAmountInterest = outstandingAmountInterest;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for outstanding amount principal.
   *
   * @param  outstandingAmountPrincipal  BigDecimal
   */
  public void setOutstandingAmountPrincipal(BigDecimal outstandingAmountPrincipal) {
    this.outstandingAmountPrincipal = outstandingAmountPrincipal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for principal.
   *
   * @param  principal  BigDecimal
   */
  public void setPrincipal(BigDecimal principal) {
    this.principal = principal;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("AccountBalanceBreakDown{");
    sb.append("account=").append(account);
    sb.append(", id=").append(id);
    sb.append(", arrearsAmount=").append(arrearsAmount);
    sb.append(", arrearsAmountFee=").append(arrearsAmountFee);
    sb.append(", arrearsAmountInterest=").append(arrearsAmountInterest);
    sb.append(", arrearsAmountPrincipal=").append(arrearsAmountPrincipal);
    sb.append(", balanceAmountFee=").append(balanceAmountFee);
    sb.append(", balanceAmountInterest=").append(balanceAmountInterest);
    sb.append(", balanceAmountPrincipal=").append(balanceAmountPrincipal);
    sb.append(", bucket1AmountFee=").append(bucket1AmountFee);
    sb.append(", bucket1AmountInterest=").append(bucket1AmountInterest);
    sb.append(", bucket1AmountPrincipal=").append(bucket1AmountPrincipal);
    sb.append(", bucket2AmountFee=").append(bucket2AmountFee);
    sb.append(", bucket2AmountInterest=").append(bucket2AmountInterest);
    sb.append(", bucket2AmountPrincipal=").append(bucket2AmountPrincipal);
    sb.append(", bucket3AmountFee=").append(bucket3AmountFee);
    sb.append(", bucket3AmountInterest=").append(bucket3AmountInterest);
    sb.append(", bucket3AmountPrincipal=").append(bucket3AmountPrincipal);
    sb.append(", bucket4AmountFee=").append(bucket4AmountFee);
    sb.append(", bucket4AmountInterest=").append(bucket4AmountInterest);
    sb.append(", bucket4AmountPrincipal=").append(bucket4AmountPrincipal);
    sb.append(", bucket5AmountFee=").append(bucket5AmountFee);
    sb.append(", bucket5AmountInterest=").append(bucket5AmountInterest);
    sb.append(", bucket5AmountPrincipal=").append(bucket5AmountPrincipal);
    sb.append(", bucket6AmountFee=").append(bucket6AmountFee);
    sb.append(", bucket6AmountInterest=").append(bucket6AmountInterest);
    sb.append(", bucket6AmountPrincipal=").append(bucket6AmountPrincipal);
    sb.append(", bucket7AmountFee=").append(bucket7AmountFee);
    sb.append(", bucket7AmountInterest=").append(bucket7AmountInterest);
    sb.append(", bucket7AmountPrincipal=").append(bucket7AmountPrincipal);
    sb.append(", outstandingAmount=").append(outstandingAmount);
    sb.append(", outstandingAmountFee=").append(outstandingAmountFee);
    sb.append(", outstandingAmountInterest=").append(outstandingAmountInterest);
    sb.append(", outstandingAmountPrincipal=").append(outstandingAmountPrincipal);
    sb.append(", principal=").append(principal);
    sb.append(", interest=").append(interest);
    sb.append(", fee=").append(fee);
    sb.append(", other=").append(other);
    sb.append('}');

    return sb.toString();
  } // end method toString
} // end class AccountBalanceBreakDown
