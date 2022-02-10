package com.cmc.credagility.core.domain.tsys;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 17:20
 */
@Entity
@Table(name = "TsysAccountStatusCode")
public class TsysAccountStatusCode extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -958787748974482187L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "accountNum",
    unique   = true,
    nullable = false
  )
  @OneToOne(
    cascade       = { CascadeType.ALL, CascadeType.REMOVE },
    orphanRemoval = true
  )
  protected Account account;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode1",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode1;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode10",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode10;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode11",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode11;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode12",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode12;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode13",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode13;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode14",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode14;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode15",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode15;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode16",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode16;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode17",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode17;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode18",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode18;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode19",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode19;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode2",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode2;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode20",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode20;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode3",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode3;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode4",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode4;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode5",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode5;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode6",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode6;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode7",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode7;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode8",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode8;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedReasonCode9",
    length   = 2,
    nullable = true
  )
  protected String prioritizedReasonCode9;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode1",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode1;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode10",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode10;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode11",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode11;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode12",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode12;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode13",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode13;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode14",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode14;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode15",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode15;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode16",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode16;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode17",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode17;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode18",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode18;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode19",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode19;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode2",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode2;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode20",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode20;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode3",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode3;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode4",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode4;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode5",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode5;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode6",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode6;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode7",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode7;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode8",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode8;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "prioritizedStatusCode9",
    length   = 2,
    nullable = true
  )
  protected String prioritizedStatusCode9;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "prioritizedStatusReasonCodeAll",
    length = 100
  )
  protected String prioritizedStatusReasonCodeAll;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long tsysAccountStatusCodeId;

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
   * getter method for prioritized reason code1.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode1() {
    return prioritizedReasonCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code10.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode10() {
    return prioritizedReasonCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code11.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode11() {
    return prioritizedReasonCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code12.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode12() {
    return prioritizedReasonCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code13.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode13() {
    return prioritizedReasonCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code14.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode14() {
    return prioritizedReasonCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code15.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode15() {
    return prioritizedReasonCode15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code16.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode16() {
    return prioritizedReasonCode16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code17.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode17() {
    return prioritizedReasonCode17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code18.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode18() {
    return prioritizedReasonCode18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code19.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode19() {
    return prioritizedReasonCode19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code2.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode2() {
    return prioritizedReasonCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code20.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode20() {
    return prioritizedReasonCode20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code3.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode3() {
    return prioritizedReasonCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code4.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode4() {
    return prioritizedReasonCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code5.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode5() {
    return prioritizedReasonCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code6.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode6() {
    return prioritizedReasonCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code7.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode7() {
    return prioritizedReasonCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code8.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode8() {
    return prioritizedReasonCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized reason code9.
   *
   * @return  String
   */
  public String getPrioritizedReasonCode9() {
    return prioritizedReasonCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code1.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode1() {
    return prioritizedStatusCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code10.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode10() {
    return prioritizedStatusCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code11.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode11() {
    return prioritizedStatusCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code12.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode12() {
    return prioritizedStatusCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code13.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode13() {
    return prioritizedStatusCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code14.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode14() {
    return prioritizedStatusCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code15.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode15() {
    return prioritizedStatusCode15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code16.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode16() {
    return prioritizedStatusCode16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code17.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode17() {
    return prioritizedStatusCode17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code18.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode18() {
    return prioritizedStatusCode18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code19.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode19() {
    return prioritizedStatusCode19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code2.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode2() {
    return prioritizedStatusCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code20.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode20() {
    return prioritizedStatusCode20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code3.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode3() {
    return prioritizedStatusCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code4.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode4() {
    return prioritizedStatusCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code5.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode5() {
    return prioritizedStatusCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code6.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode6() {
    return prioritizedStatusCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code7.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode7() {
    return prioritizedStatusCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code8.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode8() {
    return prioritizedStatusCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status code9.
   *
   * @return  String
   */
  public String getPrioritizedStatusCode9() {
    return prioritizedStatusCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for prioritized status reason code all.
   *
   * @return  String
   */
  public String getPrioritizedStatusReasonCodeAll() {
    return prioritizedStatusReasonCodeAll;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code1.
   *
   * @return  String
   */
  public String getStatusReasonCode1() {
    return this.prioritizedStatusCode1 + this.prioritizedReasonCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code10.
   *
   * @return  String
   */
  public String getStatusReasonCode10() {
    return this.prioritizedStatusCode10 + this.prioritizedReasonCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code11.
   *
   * @return  String
   */
  public String getStatusReasonCode11() {
    return this.prioritizedStatusCode11 + this.prioritizedReasonCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code12.
   *
   * @return  String
   */
  public String getStatusReasonCode12() {
    return this.prioritizedStatusCode12 + this.prioritizedReasonCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code13.
   *
   * @return  String
   */
  public String getStatusReasonCode13() {
    return this.prioritizedStatusCode13 + this.prioritizedReasonCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code14.
   *
   * @return  String
   */
  public String getStatusReasonCode14() {
    return this.prioritizedStatusCode14 + this.prioritizedReasonCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code15.
   *
   * @return  String
   */
  public String getStatusReasonCode15() {
    return this.prioritizedStatusCode15 + this.prioritizedReasonCode15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code16.
   *
   * @return  String
   */
  public String getStatusReasonCode16() {
    return this.prioritizedStatusCode16 + this.prioritizedReasonCode16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code17.
   *
   * @return  String
   */
  public String getStatusReasonCode17() {
    return this.prioritizedStatusCode17 + this.prioritizedReasonCode17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code18.
   *
   * @return  String
   */
  public String getStatusReasonCode18() {
    return this.prioritizedStatusCode18 + this.prioritizedReasonCode18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code19.
   *
   * @return  String
   */
  public String getStatusReasonCode19() {
    return this.prioritizedStatusCode19 + this.prioritizedReasonCode19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code2.
   *
   * @return  String
   */
  public String getStatusReasonCode2() {
    return this.prioritizedStatusCode2 + this.prioritizedReasonCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code20.
   *
   * @return  String
   */
  public String getStatusReasonCode20() {
    return this.prioritizedStatusCode20 + this.prioritizedReasonCode20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code3.
   *
   * @return  String
   */
  public String getStatusReasonCode3() {
    return this.prioritizedStatusCode3 + this.prioritizedReasonCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code4.
   *
   * @return  String
   */
  public String getStatusReasonCode4() {
    return this.prioritizedStatusCode4 + this.prioritizedReasonCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code5.
   *
   * @return  String
   */
  public String getStatusReasonCode5() {
    return this.prioritizedStatusCode5 + this.prioritizedReasonCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code6.
   *
   * @return  String
   */
  public String getStatusReasonCode6() {
    return this.prioritizedStatusCode6 + this.prioritizedReasonCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code7.
   *
   * @return  String
   */
  public String getStatusReasonCode7() {
    return this.prioritizedStatusCode7 + this.prioritizedReasonCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code8.
   *
   * @return  String
   */
  public String getStatusReasonCode8() {
    return this.prioritizedStatusCode8 + this.prioritizedReasonCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status reason code9.
   *
   * @return  String
   */
  public String getStatusReasonCode9() {
    return this.prioritizedStatusCode9 + this.prioritizedReasonCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys account status code id.
   *
   * @return  Long
   */
  public Long getTsysAccountStatusCodeId() {
    return tsysAccountStatusCodeId;
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
   * setter method for prioritized reason code1.
   *
   * @param  prioritizedReasonCode1  String
   */
  public void setPrioritizedReasonCode1(String prioritizedReasonCode1) {
    this.prioritizedReasonCode1 = prioritizedReasonCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code10.
   *
   * @param  prioritizedReasonCode10  String
   */
  public void setPrioritizedReasonCode10(String prioritizedReasonCode10) {
    this.prioritizedReasonCode10 = prioritizedReasonCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code11.
   *
   * @param  prioritizedReasonCode11  String
   */
  public void setPrioritizedReasonCode11(String prioritizedReasonCode11) {
    this.prioritizedReasonCode11 = prioritizedReasonCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code12.
   *
   * @param  prioritizedReasonCode12  String
   */
  public void setPrioritizedReasonCode12(String prioritizedReasonCode12) {
    this.prioritizedReasonCode12 = prioritizedReasonCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code13.
   *
   * @param  prioritizedReasonCode13  String
   */
  public void setPrioritizedReasonCode13(String prioritizedReasonCode13) {
    this.prioritizedReasonCode13 = prioritizedReasonCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code14.
   *
   * @param  prioritizedReasonCode14  String
   */
  public void setPrioritizedReasonCode14(String prioritizedReasonCode14) {
    this.prioritizedReasonCode14 = prioritizedReasonCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code15.
   *
   * @param  prioritizedReasonCode15  String
   */
  public void setPrioritizedReasonCode15(String prioritizedReasonCode15) {
    this.prioritizedReasonCode15 = prioritizedReasonCode15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code16.
   *
   * @param  prioritizedReasonCode16  String
   */
  public void setPrioritizedReasonCode16(String prioritizedReasonCode16) {
    this.prioritizedReasonCode16 = prioritizedReasonCode16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code17.
   *
   * @param  prioritizedReasonCode17  String
   */
  public void setPrioritizedReasonCode17(String prioritizedReasonCode17) {
    this.prioritizedReasonCode17 = prioritizedReasonCode17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code18.
   *
   * @param  prioritizedReasonCode18  String
   */
  public void setPrioritizedReasonCode18(String prioritizedReasonCode18) {
    this.prioritizedReasonCode18 = prioritizedReasonCode18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code19.
   *
   * @param  prioritizedReasonCode19  String
   */
  public void setPrioritizedReasonCode19(String prioritizedReasonCode19) {
    this.prioritizedReasonCode19 = prioritizedReasonCode19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code2.
   *
   * @param  prioritizedReasonCode2  String
   */
  public void setPrioritizedReasonCode2(String prioritizedReasonCode2) {
    this.prioritizedReasonCode2 = prioritizedReasonCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code20.
   *
   * @param  prioritizedReasonCode20  String
   */
  public void setPrioritizedReasonCode20(String prioritizedReasonCode20) {
    this.prioritizedReasonCode20 = prioritizedReasonCode20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code3.
   *
   * @param  prioritizedReasonCode3  String
   */
  public void setPrioritizedReasonCode3(String prioritizedReasonCode3) {
    this.prioritizedReasonCode3 = prioritizedReasonCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code4.
   *
   * @param  prioritizedReasonCode4  String
   */
  public void setPrioritizedReasonCode4(String prioritizedReasonCode4) {
    this.prioritizedReasonCode4 = prioritizedReasonCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code5.
   *
   * @param  prioritizedReasonCode5  String
   */
  public void setPrioritizedReasonCode5(String prioritizedReasonCode5) {
    this.prioritizedReasonCode5 = prioritizedReasonCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code6.
   *
   * @param  prioritizedReasonCode6  String
   */
  public void setPrioritizedReasonCode6(String prioritizedReasonCode6) {
    this.prioritizedReasonCode6 = prioritizedReasonCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code7.
   *
   * @param  prioritizedReasonCode7  String
   */
  public void setPrioritizedReasonCode7(String prioritizedReasonCode7) {
    this.prioritizedReasonCode7 = prioritizedReasonCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code8.
   *
   * @param  prioritizedReasonCode8  String
   */
  public void setPrioritizedReasonCode8(String prioritizedReasonCode8) {
    this.prioritizedReasonCode8 = prioritizedReasonCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized reason code9.
   *
   * @param  prioritizedReasonCode9  String
   */
  public void setPrioritizedReasonCode9(String prioritizedReasonCode9) {
    this.prioritizedReasonCode9 = prioritizedReasonCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code1.
   *
   * @param  prioritizedStatusCode1  String
   */
  public void setPrioritizedStatusCode1(String prioritizedStatusCode1) {
    this.prioritizedStatusCode1 = prioritizedStatusCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code10.
   *
   * @param  prioritizedStatusCode10  String
   */
  public void setPrioritizedStatusCode10(String prioritizedStatusCode10) {
    this.prioritizedStatusCode10 = prioritizedStatusCode10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code11.
   *
   * @param  prioritizedStatusCode11  String
   */
  public void setPrioritizedStatusCode11(String prioritizedStatusCode11) {
    this.prioritizedStatusCode11 = prioritizedStatusCode11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code12.
   *
   * @param  prioritizedStatusCode12  String
   */
  public void setPrioritizedStatusCode12(String prioritizedStatusCode12) {
    this.prioritizedStatusCode12 = prioritizedStatusCode12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code13.
   *
   * @param  prioritizedStatusCode13  String
   */
  public void setPrioritizedStatusCode13(String prioritizedStatusCode13) {
    this.prioritizedStatusCode13 = prioritizedStatusCode13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code14.
   *
   * @param  prioritizedStatusCode14  String
   */
  public void setPrioritizedStatusCode14(String prioritizedStatusCode14) {
    this.prioritizedStatusCode14 = prioritizedStatusCode14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code15.
   *
   * @param  prioritizedStatusCode15  String
   */
  public void setPrioritizedStatusCode15(String prioritizedStatusCode15) {
    this.prioritizedStatusCode15 = prioritizedStatusCode15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code16.
   *
   * @param  prioritizedStatusCode16  String
   */
  public void setPrioritizedStatusCode16(String prioritizedStatusCode16) {
    this.prioritizedStatusCode16 = prioritizedStatusCode16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code17.
   *
   * @param  prioritizedStatusCode17  String
   */
  public void setPrioritizedStatusCode17(String prioritizedStatusCode17) {
    this.prioritizedStatusCode17 = prioritizedStatusCode17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code18.
   *
   * @param  prioritizedStatusCode18  String
   */
  public void setPrioritizedStatusCode18(String prioritizedStatusCode18) {
    this.prioritizedStatusCode18 = prioritizedStatusCode18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code19.
   *
   * @param  prioritizedStatusCode19  String
   */
  public void setPrioritizedStatusCode19(String prioritizedStatusCode19) {
    this.prioritizedStatusCode19 = prioritizedStatusCode19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code2.
   *
   * @param  prioritizedStatusCode2  String
   */
  public void setPrioritizedStatusCode2(String prioritizedStatusCode2) {
    this.prioritizedStatusCode2 = prioritizedStatusCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code20.
   *
   * @param  prioritizedStatusCode20  String
   */
  public void setPrioritizedStatusCode20(String prioritizedStatusCode20) {
    this.prioritizedStatusCode20 = prioritizedStatusCode20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code3.
   *
   * @param  prioritizedStatusCode3  String
   */
  public void setPrioritizedStatusCode3(String prioritizedStatusCode3) {
    this.prioritizedStatusCode3 = prioritizedStatusCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code4.
   *
   * @param  prioritizedStatusCode4  String
   */
  public void setPrioritizedStatusCode4(String prioritizedStatusCode4) {
    this.prioritizedStatusCode4 = prioritizedStatusCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code5.
   *
   * @param  prioritizedStatusCode5  String
   */
  public void setPrioritizedStatusCode5(String prioritizedStatusCode5) {
    this.prioritizedStatusCode5 = prioritizedStatusCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code6.
   *
   * @param  prioritizedStatusCode6  String
   */
  public void setPrioritizedStatusCode6(String prioritizedStatusCode6) {
    this.prioritizedStatusCode6 = prioritizedStatusCode6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code7.
   *
   * @param  prioritizedStatusCode7  String
   */
  public void setPrioritizedStatusCode7(String prioritizedStatusCode7) {
    this.prioritizedStatusCode7 = prioritizedStatusCode7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code8.
   *
   * @param  prioritizedStatusCode8  String
   */
  public void setPrioritizedStatusCode8(String prioritizedStatusCode8) {
    this.prioritizedStatusCode8 = prioritizedStatusCode8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status code9.
   *
   * @param  prioritizedStatusCode9  String
   */
  public void setPrioritizedStatusCode9(String prioritizedStatusCode9) {
    this.prioritizedStatusCode9 = prioritizedStatusCode9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for prioritized status reason code all.
   *
   * @param  prioritizedStatusReasonCodeAll  String
   */
  public void setPrioritizedStatusReasonCodeAll(String prioritizedStatusReasonCodeAll) {
    this.prioritizedStatusReasonCodeAll = prioritizedStatusReasonCodeAll;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys account status code id.
   *
   * @param  tsysAccountStatusCodeId  Long
   */
  public void setTsysAccountStatusCodeId(Long tsysAccountStatusCodeId) {
    this.tsysAccountStatusCodeId = tsysAccountStatusCodeId;
  }
} // end class TsysAccountStatusCode
