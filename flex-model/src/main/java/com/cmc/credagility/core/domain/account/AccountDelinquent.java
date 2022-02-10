package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/14/2014 17:55
 */
@Entity
@Table(name = "AccountDelinquent")
public class AccountDelinquent extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -64927369404746903L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "accountNum",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @OneToOne(cascade = CascadeType.ALL)
  protected Account account;

  /** AccountDelinquent id PK. */
  @Column(
    name     = "accountDelinquentId", /* unique = true, */
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long accountDelinquentId;

  /** bucket amount 10. */
  @Column(name = "bucketAmount10")
  protected BigDecimal bucketAmount10;

  /** bucket amount 11. */
  @Column(name = "bucketAmount11")
  protected BigDecimal bucketAmount11;

  /** bucket amount 11. */
  @Column(name = "bucketAmount12")
  protected BigDecimal bucketAmount12;

  /** bucket amount 8. */
  @Column(name = "bucketAmount8")
  protected BigDecimal bucketAmount8;

  /** bucket amount 9. */
  @Column(name = "bucketAmount9")
  protected BigDecimal bucketAmount9;

  /** TODO: DOCUMENT ME! */
  @Column(name = "consDaysPastDue")
  protected Integer consDaysPastDue;

  /** TODO: DOCUMENT ME! */
  @Column(name = "delinquentAmount")
  protected BigDecimal delinquentAmount;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timesPastDue1")
  protected Integer timesPastDue1;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timesPastDue10")
  protected Integer timesPastDue10;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timesPastDue11")
  protected Integer timesPastDue11;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timesPastDue12")
  protected Integer timesPastDue12;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timesPastDue2")
  protected Integer timesPastDue2;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timesPastDue3")
  protected Integer timesPastDue3;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timesPastDue4")
  protected Integer timesPastDue4;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timesPastDue5")
  protected Integer timesPastDue5;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timesPastDue6")
  protected Integer timesPastDue6;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timesPastDue7")
  protected Integer timesPastDue7;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timesPastDue8")
  protected Integer timesPastDue8;

  /** TODO: DOCUMENT ME! */
  @Column(name = "timesPastDue9")
  protected Integer timesPastDue9;

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
   * getter method for account delinquent id.
   *
   * @return  Long
   */
  public Long getAccountDelinquentId() {
    return accountDelinquentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount10.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount10() {
    return bucketAmount10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount11.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount11() {
    return bucketAmount11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount12.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount12() {
    return bucketAmount12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount8.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount8() {
    return bucketAmount8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount9.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount9() {
    return bucketAmount9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for cons days past due.
   *
   * @return  Integer
   */
  public Integer getConsDaysPastDue() {
    return consDaysPastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquent amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getDelinquentAmount() {
    return delinquentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for times past due1.
   *
   * @return  Integer
   */
  public Integer getTimesPastDue1() {
    return timesPastDue1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for times past due10.
   *
   * @return  Integer
   */
  public Integer getTimesPastDue10() {
    return timesPastDue10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for times past due11.
   *
   * @return  Integer
   */
  public Integer getTimesPastDue11() {
    return timesPastDue11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for times past due12.
   *
   * @return  Integer
   */
  public Integer getTimesPastDue12() {
    return timesPastDue12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for times past due2.
   *
   * @return  Integer
   */
  public Integer getTimesPastDue2() {
    return timesPastDue2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for times past due3.
   *
   * @return  Integer
   */
  public Integer getTimesPastDue3() {
    return timesPastDue3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for times past due4.
   *
   * @return  Integer
   */
  public Integer getTimesPastDue4() {
    return timesPastDue4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for times past due5.
   *
   * @return  Integer
   */
  public Integer getTimesPastDue5() {
    return timesPastDue5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for times past due6.
   *
   * @return  Integer
   */
  public Integer getTimesPastDue6() {
    return timesPastDue6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for times past due7.
   *
   * @return  Integer
   */
  public Integer getTimesPastDue7() {
    return timesPastDue7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for times past due8.
   *
   * @return  Integer
   */
  public Integer getTimesPastDue8() {
    return timesPastDue8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for times past due9.
   *
   * @return  Integer
   */
  public Integer getTimesPastDue9() {
    return timesPastDue9;
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
   * setter method for account delinquent id.
   *
   * @param  accountDelinquentId  Long
   */
  public void setAccountDelinquentId(Long accountDelinquentId) {
    this.accountDelinquentId = accountDelinquentId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket amount10.
   *
   * @param  bucketAmount10  BigDecimal
   */
  public void setBucketAmount10(BigDecimal bucketAmount10) {
    this.bucketAmount10 = bucketAmount10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket amount11.
   *
   * @param  bucketAmount11  BigDecimal
   */
  public void setBucketAmount11(BigDecimal bucketAmount11) {
    this.bucketAmount11 = bucketAmount11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket amount12.
   *
   * @param  bucketAmount12  BigDecimal
   */
  public void setBucketAmount12(BigDecimal bucketAmount12) {
    this.bucketAmount12 = bucketAmount12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket amount8.
   *
   * @param  bucketAmount8  BigDecimal
   */
  public void setBucketAmount8(BigDecimal bucketAmount8) {
    this.bucketAmount8 = bucketAmount8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket amount9.
   *
   * @param  bucketAmount9  BigDecimal
   */
  public void setBucketAmount9(BigDecimal bucketAmount9) {
    this.bucketAmount9 = bucketAmount9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for cons days past due.
   *
   * @param  consDaysPastDue  Integer
   */
  public void setConsDaysPastDue(Integer consDaysPastDue) {
    this.consDaysPastDue = consDaysPastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delinquent amount.
   *
   * @param  delinquentAmount  BigDecimal
   */
  public void setDelinquentAmount(BigDecimal delinquentAmount) {
    this.delinquentAmount = delinquentAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for times past due1.
   *
   * @param  timesPastDue1  Integer
   */
  public void setTimesPastDue1(Integer timesPastDue1) {
    this.timesPastDue1 = timesPastDue1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for times past due10.
   *
   * @param  timesPastDue10  Integer
   */
  public void setTimesPastDue10(Integer timesPastDue10) {
    this.timesPastDue10 = timesPastDue10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for times past due11.
   *
   * @param  timesPastDue11  Integer
   */
  public void setTimesPastDue11(Integer timesPastDue11) {
    this.timesPastDue11 = timesPastDue11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for times past due12.
   *
   * @param  timesPastDue12  Integer
   */
  public void setTimesPastDue12(Integer timesPastDue12) {
    this.timesPastDue12 = timesPastDue12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for times past due2.
   *
   * @param  timesPastDue2  Integer
   */
  public void setTimesPastDue2(Integer timesPastDue2) {
    this.timesPastDue2 = timesPastDue2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for times past due3.
   *
   * @param  timesPastDue3  Integer
   */
  public void setTimesPastDue3(Integer timesPastDue3) {
    this.timesPastDue3 = timesPastDue3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for times past due4.
   *
   * @param  timesPastDue4  Integer
   */
  public void setTimesPastDue4(Integer timesPastDue4) {
    this.timesPastDue4 = timesPastDue4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for times past due5.
   *
   * @param  timesPastDue5  Integer
   */
  public void setTimesPastDue5(Integer timesPastDue5) {
    this.timesPastDue5 = timesPastDue5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for times past due6.
   *
   * @param  timesPastDue6  Integer
   */
  public void setTimesPastDue6(Integer timesPastDue6) {
    this.timesPastDue6 = timesPastDue6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for times past due7.
   *
   * @param  timesPastDue7  Integer
   */
  public void setTimesPastDue7(Integer timesPastDue7) {
    this.timesPastDue7 = timesPastDue7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for times past due8.
   *
   * @param  timesPastDue8  Integer
   */
  public void setTimesPastDue8(Integer timesPastDue8) {
    this.timesPastDue8 = timesPastDue8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for times past due9.
   *
   * @param  timesPastDue9  Integer
   */
  public void setTimesPastDue9(Integer timesPastDue9) {
    this.timesPastDue9 = timesPastDue9;
  }
} // end class AccountDelinquent
