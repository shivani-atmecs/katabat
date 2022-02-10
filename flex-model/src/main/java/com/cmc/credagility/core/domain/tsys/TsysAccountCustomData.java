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
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/15/2014 16:46
 */
@Entity
@Table(name = "TsysAccountCustomData")
public class TsysAccountCustomData extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -1655978868326293544L;

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
    name   = "customCode15",
    length = 255
  )
  protected String customCode15;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode16",
    length = 255
  )
  protected String customCode16;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode17",
    length = 255
  )
  protected String customCode17;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode18",
    length = 255
  )
  protected String customCode18;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode19",
    length = 255
  )
  protected String customCode19;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode45",
    length = 255
  )
  protected String customCode45;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode46",
    length = 255
  )
  protected String customCode46;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode47",
    length = 255
  )
  protected String customCode47;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode48",
    length = 255
  )
  protected String customCode48;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode50",
    length = 255
  )
  protected String customCode50;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode51",
    length = 255
  )
  protected String customCode51;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode52",
    length = 255
  )
  protected String customCode52;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode53",
    length = 255
  )
  protected String customCode53;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode65",
    length = 255
  )
  protected String customCode65;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode66",
    length = 255
  )
  protected String customCode66;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode67",
    length = 255
  )
  protected String customCode67;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode68",
    length = 255
  )
  protected String customCode68;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode69",
    length = 255
  )
  protected String customCode69;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode82",
    length = 255
  )
  protected String customCode82;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode83",
    length = 255
  )
  protected String customCode83;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode84",
    length = 255
  )
  protected String customCode84;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode85",
    length = 255
  )
  protected String customCode85;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode86",
    length = 255
  )
  protected String customCode86;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode87",
    length = 255
  )
  protected String customCode87;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode94",
    length = 255
  )
  protected String customCode94;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode95",
    length = 255
  )
  protected String customCode95;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode96",
    length = 255
  )
  protected String customCode96;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode97",
    length = 255
  )
  protected String customCode97;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customCode98",
    length = 255
  )
  protected String customCode98;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData10",
    length = 255
  )
  protected String customData10;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData11",
    length = 255
  )
  protected String customData11;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData12",
    length = 255
  )
  protected String customData12;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData13",
    length = 255
  )
  protected String customData13;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData14",
    length = 255
  )
  protected String customData14;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData20",
    length = 255
  )
  protected String customData20;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData21",
    length = 255
  )
  protected String customData21;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData22",
    length = 255
  )
  protected String customData22;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData23",
    length = 255
  )
  protected String customData23;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData24",
    length = 255
  )
  protected String customData24;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData40",
    length = 255
  )
  protected String customData40;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData41",
    length = 255
  )
  protected String customData41;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData42",
    length = 255
  )
  protected String customData42;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData43",
    length = 255
  )
  protected String customData43;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData44",
    length = 255
  )
  protected String customData44;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData60",
    length = 255
  )
  protected String customData60;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData61",
    length = 255
  )
  protected String customData61;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData62",
    length = 255
  )
  protected String customData62;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData63",
    length = 255
  )
  protected String customData63;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData64",
    length = 255
  )
  protected String customData64;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData80",
    length = 255
  )
  protected String customData80;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData81",
    length = 255
  )
  protected String customData81;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData83",
    length = 100
  )
  protected String customData83;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData87",
    length = 100
  )
  protected String customData87;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData90",
    length = 255
  )
  protected String customData90;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData91",
    length = 255
  )
  protected String customData91;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData92",
    length = 255
  )
  protected String customData92;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "customData93",
    length = 255
  )
  protected String customData93;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long tsysAccountCustomDataId;

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
   * getter method for custom code15.
   *
   * @return  String
   */
  public String getCustomCode15() {
    return customCode15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code16.
   *
   * @return  String
   */
  public String getCustomCode16() {
    return customCode16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code17.
   *
   * @return  String
   */
  public String getCustomCode17() {
    return customCode17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code18.
   *
   * @return  String
   */
  public String getCustomCode18() {
    return customCode18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code19.
   *
   * @return  String
   */
  public String getCustomCode19() {
    return customCode19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code45.
   *
   * @return  String
   */
  public String getCustomCode45() {
    return customCode45;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code46.
   *
   * @return  String
   */
  public String getCustomCode46() {
    return customCode46;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code47.
   *
   * @return  String
   */
  public String getCustomCode47() {
    return customCode47;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code48.
   *
   * @return  String
   */
  public String getCustomCode48() {
    return customCode48;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code50.
   *
   * @return  String
   */
  public String getCustomCode50() {
    return customCode50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code51.
   *
   * @return  String
   */
  public String getCustomCode51() {
    return customCode51;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code52.
   *
   * @return  String
   */
  public String getCustomCode52() {
    return customCode52;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code53.
   *
   * @return  String
   */
  public String getCustomCode53() {
    return customCode53;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code65.
   *
   * @return  String
   */
  public String getCustomCode65() {
    return customCode65;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code66.
   *
   * @return  String
   */
  public String getCustomCode66() {
    return customCode66;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code67.
   *
   * @return  String
   */
  public String getCustomCode67() {
    return customCode67;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code68.
   *
   * @return  String
   */
  public String getCustomCode68() {
    return customCode68;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code69.
   *
   * @return  String
   */
  public String getCustomCode69() {
    return customCode69;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code82.
   *
   * @return  String
   */
  public String getCustomCode82() {
    return customCode82;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code83.
   *
   * @return  String
   */
  public String getCustomCode83() {
    return customCode83;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code84.
   *
   * @return  String
   */
  public String getCustomCode84() {
    return customCode84;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code85.
   *
   * @return  String
   */
  public String getCustomCode85() {
    return customCode85;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code86.
   *
   * @return  String
   */
  public String getCustomCode86() {
    return customCode86;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code87.
   *
   * @return  String
   */
  public String getCustomCode87() {
    return customCode87;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code94.
   *
   * @return  String
   */
  public String getCustomCode94() {
    return customCode94;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code95.
   *
   * @return  String
   */
  public String getCustomCode95() {
    return customCode95;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code96.
   *
   * @return  String
   */
  public String getCustomCode96() {
    return customCode96;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code97.
   *
   * @return  String
   */
  public String getCustomCode97() {
    return customCode97;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom code98.
   *
   * @return  String
   */
  public String getCustomCode98() {
    return customCode98;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data10.
   *
   * @return  String
   */
  public String getCustomData10() {
    return customData10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data11.
   *
   * @return  String
   */
  public String getCustomData11() {
    return customData11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data12.
   *
   * @return  String
   */
  public String getCustomData12() {
    return customData12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data13.
   *
   * @return  String
   */
  public String getCustomData13() {
    return customData13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data14.
   *
   * @return  String
   */
  public String getCustomData14() {
    return customData14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data20.
   *
   * @return  String
   */
  public String getCustomData20() {
    return customData20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data21.
   *
   * @return  String
   */
  public String getCustomData21() {
    return customData21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data22.
   *
   * @return  String
   */
  public String getCustomData22() {
    return customData22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data23.
   *
   * @return  String
   */
  public String getCustomData23() {
    return customData23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data24.
   *
   * @return  String
   */
  public String getCustomData24() {
    return customData24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data40.
   *
   * @return  String
   */
  public String getCustomData40() {
    return customData40;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data41.
   *
   * @return  String
   */
  public String getCustomData41() {
    return customData41;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data42.
   *
   * @return  String
   */
  public String getCustomData42() {
    return customData42;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data43.
   *
   * @return  String
   */
  public String getCustomData43() {
    return customData43;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data44.
   *
   * @return  String
   */
  public String getCustomData44() {
    return customData44;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data60.
   *
   * @return  String
   */
  public String getCustomData60() {
    return customData60;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data61.
   *
   * @return  String
   */
  public String getCustomData61() {
    return customData61;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data62.
   *
   * @return  String
   */
  public String getCustomData62() {
    return customData62;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data63.
   *
   * @return  String
   */
  public String getCustomData63() {
    return customData63;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data64.
   *
   * @return  String
   */
  public String getCustomData64() {
    return customData64;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data80.
   *
   * @return  String
   */
  public String getCustomData80() {
    return customData80;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data81.
   *
   * @return  String
   */
  public String getCustomData81() {
    return customData81;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data83.
   *
   * @return  String
   */
  public String getCustomData83() {
    return customData83;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data87.
   *
   * @return  String
   */
  public String getCustomData87() {
    return customData87;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data90.
   *
   * @return  String
   */
  public String getCustomData90() {
    return customData90;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data91.
   *
   * @return  String
   */
  public String getCustomData91() {
    return customData91;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data92.
   *
   * @return  String
   */
  public String getCustomData92() {
    return customData92;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for custom data93.
   *
   * @return  String
   */
  public String getCustomData93() {
    return customData93;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys account custom data id.
   *
   * @return  Long
   */
  public Long getTsysAccountCustomDataId() {
    return tsysAccountCustomDataId;
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
   * setter method for custom code15.
   *
   * @param  customCode15  String
   */
  public void setCustomCode15(String customCode15) {
    this.customCode15 = customCode15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code16.
   *
   * @param  customCode16  String
   */
  public void setCustomCode16(String customCode16) {
    this.customCode16 = customCode16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code17.
   *
   * @param  customCode17  String
   */
  public void setCustomCode17(String customCode17) {
    this.customCode17 = customCode17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code18.
   *
   * @param  customCode18  String
   */
  public void setCustomCode18(String customCode18) {
    this.customCode18 = customCode18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code19.
   *
   * @param  customCode19  String
   */
  public void setCustomCode19(String customCode19) {
    this.customCode19 = customCode19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code45.
   *
   * @param  customCode45  String
   */
  public void setCustomCode45(String customCode45) {
    this.customCode45 = customCode45;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code46.
   *
   * @param  customCode46  String
   */
  public void setCustomCode46(String customCode46) {
    this.customCode46 = customCode46;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code47.
   *
   * @param  customCode47  String
   */
  public void setCustomCode47(String customCode47) {
    this.customCode47 = customCode47;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code48.
   *
   * @param  customCode48  String
   */
  public void setCustomCode48(String customCode48) {
    this.customCode48 = customCode48;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code50.
   *
   * @param  customCode50  String
   */
  public void setCustomCode50(String customCode50) {
    this.customCode50 = customCode50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code51.
   *
   * @param  customCode51  String
   */
  public void setCustomCode51(String customCode51) {
    this.customCode51 = customCode51;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code52.
   *
   * @param  customCode52  String
   */
  public void setCustomCode52(String customCode52) {
    this.customCode52 = customCode52;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code53.
   *
   * @param  customCode53  String
   */
  public void setCustomCode53(String customCode53) {
    this.customCode53 = customCode53;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code65.
   *
   * @param  customCode65  String
   */
  public void setCustomCode65(String customCode65) {
    this.customCode65 = customCode65;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code66.
   *
   * @param  customCode66  String
   */
  public void setCustomCode66(String customCode66) {
    this.customCode66 = customCode66;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code67.
   *
   * @param  customCode67  String
   */
  public void setCustomCode67(String customCode67) {
    this.customCode67 = customCode67;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code68.
   *
   * @param  customCode68  String
   */
  public void setCustomCode68(String customCode68) {
    this.customCode68 = customCode68;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code69.
   *
   * @param  customCode69  String
   */
  public void setCustomCode69(String customCode69) {
    this.customCode69 = customCode69;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code82.
   *
   * @param  customCode82  String
   */
  public void setCustomCode82(String customCode82) {
    this.customCode82 = customCode82;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code83.
   *
   * @param  customCode83  String
   */
  public void setCustomCode83(String customCode83) {
    this.customCode83 = customCode83;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code84.
   *
   * @param  customCode84  String
   */
  public void setCustomCode84(String customCode84) {
    this.customCode84 = customCode84;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code85.
   *
   * @param  customCode85  String
   */
  public void setCustomCode85(String customCode85) {
    this.customCode85 = customCode85;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code86.
   *
   * @param  customCode86  String
   */
  public void setCustomCode86(String customCode86) {
    this.customCode86 = customCode86;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code87.
   *
   * @param  customCode87  String
   */
  public void setCustomCode87(String customCode87) {
    this.customCode87 = customCode87;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code94.
   *
   * @param  customCode94  String
   */
  public void setCustomCode94(String customCode94) {
    this.customCode94 = customCode94;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code95.
   *
   * @param  customCode95  String
   */
  public void setCustomCode95(String customCode95) {
    this.customCode95 = customCode95;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code96.
   *
   * @param  customCode96  String
   */
  public void setCustomCode96(String customCode96) {
    this.customCode96 = customCode96;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code97.
   *
   * @param  customCode97  String
   */
  public void setCustomCode97(String customCode97) {
    this.customCode97 = customCode97;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom code98.
   *
   * @param  customCode98  String
   */
  public void setCustomCode98(String customCode98) {
    this.customCode98 = customCode98;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data10.
   *
   * @param  customData10  String
   */
  public void setCustomData10(String customData10) {
    this.customData10 = customData10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data11.
   *
   * @param  customData11  String
   */
  public void setCustomData11(String customData11) {
    this.customData11 = customData11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data12.
   *
   * @param  customData12  String
   */
  public void setCustomData12(String customData12) {
    this.customData12 = customData12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data13.
   *
   * @param  customData13  String
   */
  public void setCustomData13(String customData13) {
    this.customData13 = customData13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data14.
   *
   * @param  customData14  String
   */
  public void setCustomData14(String customData14) {
    this.customData14 = customData14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data20.
   *
   * @param  customData20  String
   */
  public void setCustomData20(String customData20) {
    this.customData20 = customData20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data21.
   *
   * @param  customData21  String
   */
  public void setCustomData21(String customData21) {
    this.customData21 = customData21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data22.
   *
   * @param  customData22  String
   */
  public void setCustomData22(String customData22) {
    this.customData22 = customData22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data23.
   *
   * @param  customData23  String
   */
  public void setCustomData23(String customData23) {
    this.customData23 = customData23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data24.
   *
   * @param  customData24  String
   */
  public void setCustomData24(String customData24) {
    this.customData24 = customData24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data40.
   *
   * @param  customData40  String
   */
  public void setCustomData40(String customData40) {
    this.customData40 = customData40;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data41.
   *
   * @param  customData41  String
   */
  public void setCustomData41(String customData41) {
    this.customData41 = customData41;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data42.
   *
   * @param  customData42  String
   */
  public void setCustomData42(String customData42) {
    this.customData42 = customData42;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data43.
   *
   * @param  customData43  String
   */
  public void setCustomData43(String customData43) {
    this.customData43 = customData43;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data44.
   *
   * @param  customData44  String
   */
  public void setCustomData44(String customData44) {
    this.customData44 = customData44;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data60.
   *
   * @param  customData60  String
   */
  public void setCustomData60(String customData60) {
    this.customData60 = customData60;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data61.
   *
   * @param  customData61  String
   */
  public void setCustomData61(String customData61) {
    this.customData61 = customData61;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data62.
   *
   * @param  customData62  String
   */
  public void setCustomData62(String customData62) {
    this.customData62 = customData62;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data63.
   *
   * @param  customData63  String
   */
  public void setCustomData63(String customData63) {
    this.customData63 = customData63;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data64.
   *
   * @param  customData64  String
   */
  public void setCustomData64(String customData64) {
    this.customData64 = customData64;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data80.
   *
   * @param  customData80  String
   */
  public void setCustomData80(String customData80) {
    this.customData80 = customData80;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data81.
   *
   * @param  customData81  String
   */
  public void setCustomData81(String customData81) {
    this.customData81 = customData81;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data83.
   *
   * @param  customData83  String
   */
  public void setCustomData83(String customData83) {
    this.customData83 = customData83;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data87.
   *
   * @param  customData87  String
   */
  public void setCustomData87(String customData87) {
    this.customData87 = customData87;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data90.
   *
   * @param  customData90  String
   */
  public void setCustomData90(String customData90) {
    this.customData90 = customData90;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data91.
   *
   * @param  customData91  String
   */
  public void setCustomData91(String customData91) {
    this.customData91 = customData91;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data92.
   *
   * @param  customData92  String
   */
  public void setCustomData92(String customData92) {
    this.customData92 = customData92;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for custom data93.
   *
   * @param  customData93  String
   */
  public void setCustomData93(String customData93) {
    this.customData93 = customData93;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys account custom data id.
   *
   * @param  tsysAccountCustomDataId  Long
   */
  public void setTsysAccountCustomDataId(Long tsysAccountCustomDataId) {
    this.tsysAccountCustomDataId = tsysAccountCustomDataId;
  }
} // end class TsysAccountCustomData
