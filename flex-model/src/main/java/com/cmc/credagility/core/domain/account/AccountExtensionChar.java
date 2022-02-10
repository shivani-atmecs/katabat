package com.cmc.credagility.core.domain.account;

import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  07/24/2015 17:21
 */
@Entity
@Table(name = "AccountExtensionChar")
public class AccountExtensionChar extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7098157910902637779L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "accountExtensionCharId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long accountExtensionCharId;


  @JoinColumn(
    name   = "accountNum",
    unique = true
  )
  @ManyToOne private Account account;

  @Column(name = "clientDefinedChar1")
  @Lob private String clientDefinedChar1;

  @Column(name = "clientDefinedChar10")
  @Lob private String clientDefinedChar10;

  @Column(name = "clientDefinedChar100")
  @Lob private String clientDefinedChar100;

  @Column(name = "clientDefinedChar11")
  @Lob private String clientDefinedChar11;

  @Column(name = "clientDefinedChar12")
  @Lob private String clientDefinedChar12;

  @Column(name = "clientDefinedChar13")
  @Lob private String clientDefinedChar13;

  @Column(name = "clientDefinedChar14")
  @Lob private String clientDefinedChar14;

  @Column(name = "clientDefinedChar15")
  @Lob private String clientDefinedChar15;

  @Column(name = "clientDefinedChar16")
  @Lob private String clientDefinedChar16;

  @Column(name = "clientDefinedChar17")
  @Lob private String clientDefinedChar17;

  @Column(name = "clientDefinedChar18")
  @Lob private String clientDefinedChar18;

  @Column(name = "clientDefinedChar19")
  @Lob private String clientDefinedChar19;

  @Column(name = "clientDefinedChar2")
  @Lob private String clientDefinedChar2;

  @Column(name = "clientDefinedChar20")
  @Lob private String clientDefinedChar20;

  @Column(name = "clientDefinedChar21")
  @Lob private String clientDefinedChar21;

  @Column(name = "clientDefinedChar22")
  @Lob private String clientDefinedChar22;

  @Column(name = "clientDefinedChar23")
  @Lob private String clientDefinedChar23;

  @Column(name = "clientDefinedChar24")
  @Lob private String clientDefinedChar24;

  @Column(name = "clientDefinedChar25")
  @Lob private String clientDefinedChar25;

  @Column(name = "clientDefinedChar26")
  @Lob private String clientDefinedChar26;

  @Column(name = "clientDefinedChar27")
  @Lob private String clientDefinedChar27;

  @Column(name = "clientDefinedChar28")
  @Lob private String clientDefinedChar28;

  @Column(name = "clientDefinedChar29")
  @Lob private String clientDefinedChar29;

  @Column(name = "clientDefinedChar3")
  @Lob private String clientDefinedChar3;

  @Column(name = "clientDefinedChar30")
  @Lob private String clientDefinedChar30;

  @Column(name = "clientDefinedChar31")
  @Lob private String clientDefinedChar31;

  @Column(name = "clientDefinedChar32")
  @Lob private String clientDefinedChar32;

  @Column(name = "clientDefinedChar33")
  @Lob private String clientDefinedChar33;

  @Column(name = "clientDefinedChar34")
  @Lob private String clientDefinedChar34;

  @Column(name = "clientDefinedChar35")
  @Lob private String clientDefinedChar35;

  @Column(name = "clientDefinedChar36")
  @Lob private String clientDefinedChar36;

  @Column(name = "clientDefinedChar37")
  @Lob private String clientDefinedChar37;

  @Column(name = "clientDefinedChar38")
  @Lob private String clientDefinedChar38;

  @Column(name = "clientDefinedChar39")
  @Lob private String clientDefinedChar39;

  @Column(name = "clientDefinedChar4")
  @Lob private String clientDefinedChar4;

  @Column(name = "clientDefinedChar40")
  @Lob private String clientDefinedChar40;

  @Column(name = "clientDefinedChar41")
  @Lob private String clientDefinedChar41;

  @Column(name = "clientDefinedChar42")
  @Lob private String clientDefinedChar42;

  @Column(name = "clientDefinedChar43")
  @Lob private String clientDefinedChar43;

  @Column(name = "clientDefinedChar44")
  @Lob private String clientDefinedChar44;

  @Column(name = "clientDefinedChar45")
  @Lob private String clientDefinedChar45;

  @Column(name = "clientDefinedChar46")
  @Lob private String clientDefinedChar46;

  @Column(name = "clientDefinedChar47")
  @Lob private String clientDefinedChar47;

  @Column(name = "clientDefinedChar48")
  @Lob private String clientDefinedChar48;

  @Column(name = "clientDefinedChar49")
  @Lob private String clientDefinedChar49;

  @Column(name = "clientDefinedChar5")
  @Lob private String clientDefinedChar5;

  @Column(name = "clientDefinedChar50")
  @Lob private String clientDefinedChar50;

  @Column(name = "clientDefinedChar51")
  @Lob private String clientDefinedChar51;

  @Column(name = "clientDefinedChar52")
  @Lob private String clientDefinedChar52;

  @Column(name = "clientDefinedChar53")
  @Lob private String clientDefinedChar53;

  @Column(name = "clientDefinedChar54")
  @Lob private String clientDefinedChar54;

  @Column(name = "clientDefinedChar55")
  @Lob private String clientDefinedChar55;

  @Column(name = "clientDefinedChar56")
  @Lob private String clientDefinedChar56;

  @Column(name = "clientDefinedChar57")
  @Lob private String clientDefinedChar57;

  @Column(name = "clientDefinedChar58")
  @Lob private String clientDefinedChar58;

  @Column(name = "clientDefinedChar59")
  @Lob private String clientDefinedChar59;

  @Column(name = "clientDefinedChar6")
  @Lob private String clientDefinedChar6;

  @Column(name = "clientDefinedChar60")
  @Lob private String clientDefinedChar60;

  @Column(name = "clientDefinedChar61")
  @Lob private String clientDefinedChar61;

  @Column(name = "clientDefinedChar62")
  @Lob private String clientDefinedChar62;

  @Column(name = "clientDefinedChar63")
  @Lob private String clientDefinedChar63;

  @Column(name = "clientDefinedChar64")
  @Lob private String clientDefinedChar64;

  @Column(name = "clientDefinedChar65")
  @Lob private String clientDefinedChar65;

  @Column(name = "clientDefinedChar66")
  @Lob private String clientDefinedChar66;

  @Column(name = "clientDefinedChar67")
  @Lob private String clientDefinedChar67;

  @Column(name = "clientDefinedChar68")
  @Lob private String clientDefinedChar68;

  @Column(name = "clientDefinedChar69")
  @Lob private String clientDefinedChar69;

  @Column(name = "clientDefinedChar7")
  @Lob private String clientDefinedChar7;

  @Column(name = "clientDefinedChar70")
  @Lob private String clientDefinedChar70;

  @Column(name = "clientDefinedChar71")
  @Lob private String clientDefinedChar71;

  @Column(name = "clientDefinedChar72")
  @Lob private String clientDefinedChar72;

  @Column(name = "clientDefinedChar73")
  @Lob private String clientDefinedChar73;

  @Column(name = "clientDefinedChar74")
  @Lob private String clientDefinedChar74;

  @Column(name = "clientDefinedChar75")
  @Lob private String clientDefinedChar75;

  @Column(name = "clientDefinedChar76")
  @Lob private String clientDefinedChar76;

  @Column(name = "clientDefinedChar77")
  @Lob private String clientDefinedChar77;

  @Column(name = "clientDefinedChar78")
  @Lob private String clientDefinedChar78;

  @Column(name = "clientDefinedChar79")
  @Lob private String clientDefinedChar79;

  @Column(name = "clientDefinedChar8")
  @Lob private String clientDefinedChar8;

  @Column(name = "clientDefinedChar80")
  @Lob private String clientDefinedChar80;

  @Column(name = "clientDefinedChar81")
  @Lob private String clientDefinedChar81;

  @Column(name = "clientDefinedChar82")
  @Lob private String clientDefinedChar82;

  @Column(name = "clientDefinedChar83")
  @Lob private String clientDefinedChar83;

  @Column(name = "clientDefinedChar84")
  @Lob private String clientDefinedChar84;

  @Column(name = "clientDefinedChar85")
  @Lob private String clientDefinedChar85;

  @Column(name = "clientDefinedChar86")
  @Lob private String clientDefinedChar86;

  @Column(name = "clientDefinedChar87")
  @Lob private String clientDefinedChar87;

  @Column(name = "clientDefinedChar88")
  @Lob private String clientDefinedChar88;

  @Column(name = "clientDefinedChar89")
  @Lob private String clientDefinedChar89;

  @Column(name = "clientDefinedChar9")
  @Lob private String clientDefinedChar9;

  @Column(name = "clientDefinedChar90")
  @Lob private String clientDefinedChar90;

  @Column(name = "clientDefinedChar91")
  @Lob private String clientDefinedChar91;

  @Column(name = "clientDefinedChar92")
  @Lob private String clientDefinedChar92;

  @Column(name = "clientDefinedChar93")
  @Lob private String clientDefinedChar93;

  @Column(name = "clientDefinedChar94")
  @Lob private String clientDefinedChar94;

  @Column(name = "clientDefinedChar95")
  @Lob private String clientDefinedChar95;

  @Column(name = "clientDefinedChar96")
  @Lob private String clientDefinedChar96;

  @Column(name = "clientDefinedChar97")
  @Lob private String clientDefinedChar97;

  @Column(name = "clientDefinedChar98")
  @Lob private String clientDefinedChar98;

  @Column(name = "clientDefinedChar99")
  @Lob private String clientDefinedChar99;

  @Column(
    name       = "clientDefinedChar6",
    length     = 1000,
    updatable  = false,
    insertable = false
  )
  private String clientDefinedString6;

  @Column(name = "clientDefinedChar101")
  @Lob  private String clientDefinedChar101;
  
  @Column(name = "clientDefinedChar102")
  @Lob  private String clientDefinedChar102;
  
  @Column(name = "clientDefinedChar103")
  @Lob private String clientDefinedChar103;
  
  @Column(name = "clientDefinedChar104")
  @Lob private String clientDefinedChar104;
  
  @Column(name = "clientDefinedChar105")
  @Lob private String clientDefinedChar105;
  
  @Column(name = "clientDefinedChar106")
  @Lob private String clientDefinedChar106;
  
  @Column(name = "clientDefinedChar107")
  @Lob private String clientDefinedChar107;
  @Column(name = "clientDefinedChar108")
  @Lob private String clientDefinedChar108;
  @Column(name = "clientDefinedChar109")
  @Lob private String clientDefinedChar109;
  @Column(name = "clientDefinedChar110")
  @Lob private String clientDefinedChar110;
  @Column(name = "clientDefinedChar111")
  @Lob private String clientDefinedChar111;
  @Column(name = "clientDefinedChar112")
  @Lob private String clientDefinedChar112;
  @Column(name = "clientDefinedChar113")
  @Lob private String clientDefinedChar113;
  @Column(name = "clientDefinedChar114")
  @Lob private String clientDefinedChar114;
  @Column(name = "clientDefinedChar115")
  @Lob private String clientDefinedChar115;
  @Column(name = "clientDefinedChar116")
  @Lob private String clientDefinedChar116;
  @Column(name = "clientDefinedChar117")
  @Lob private String clientDefinedChar117;
  @Column(name = "clientDefinedChar118")
  @Lob private String clientDefinedChar118;
  @Column(name = "clientDefinedChar119")
  @Lob private String clientDefinedChar119;
  @Column(name = "clientDefinedChar120")
  @Lob private String clientDefinedChar120;
  @Column(name = "clientDefinedChar121")
  @Lob private String clientDefinedChar121;
  @Column(name = "clientDefinedChar122")
  @Lob private String clientDefinedChar122;
  @Column(name = "clientDefinedChar123")
  @Lob private String clientDefinedChar123;
  @Column(name = "clientDefinedChar124")
  @Lob private String clientDefinedChar124;
  @Column(name = "clientDefinedChar125")
  @Lob private String clientDefinedChar125;
  @Column(name = "clientDefinedChar126")
  @Lob private String clientDefinedChar126;
  @Column(name = "clientDefinedChar127")
  @Lob private String clientDefinedChar127;
  @Column(name = "clientDefinedChar128")
  @Lob private String clientDefinedChar128;
  @Column(name = "clientDefinedChar129")
  @Lob private String clientDefinedChar129;
  @Column(name = "clientDefinedChar130")
  @Lob private String clientDefinedChar130;
  @Column(name = "clientDefinedChar131")
  @Lob private String clientDefinedChar131;
  @Column(name = "clientDefinedChar132")
  @Lob private String clientDefinedChar132;
  @Column(name = "clientDefinedChar133")
  @Lob private String clientDefinedChar133;
  @Column(name = "clientDefinedChar134")
  @Lob private String clientDefinedChar134;
  @Column(name = "clientDefinedChar135")
  @Lob private String clientDefinedChar135;
  @Column(name = "clientDefinedChar136")
  @Lob private String clientDefinedChar136;
  @Column(name = "clientDefinedChar137")
  @Lob private String clientDefinedChar137;
  @Column(name = "clientDefinedChar138")
  @Lob private String clientDefinedChar138;
  @Column(name = "clientDefinedChar139")
  @Lob private String clientDefinedChar139;
  @Column(name = "clientDefinedChar140")
  @Lob private String clientDefinedChar140;
  @Column(name = "clientDefinedChar141")
  @Lob private String clientDefinedChar141;
  @Column(name = "clientDefinedChar142")
  @Lob private String clientDefinedChar142;
  @Column(name = "clientDefinedChar143")
  @Lob private String clientDefinedChar143;
  @Column(name = "clientDefinedChar144")
  @Lob private String clientDefinedChar144;
  @Column(name = "clientDefinedChar145")
  @Lob private String clientDefinedChar145;
  @Column(name = "clientDefinedChar146")
  @Lob private String clientDefinedChar146;
  @Column(name = "clientDefinedChar147")
  @Lob private String clientDefinedChar147;
  @Column(name = "clientDefinedChar148")
  @Lob private String clientDefinedChar148;
  @Column(name = "clientDefinedChar149")
  @Lob private String clientDefinedChar149;
  @Column(name = "clientDefinedChar150")
  @Lob private String clientDefinedChar150;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Account.
   *
   * @return  Account.
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Long.
   *
   * @return  Long.
   */
  public Long getAccountExtensionCharId() {
    return accountExtensionCharId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar1() {
    return clientDefinedChar1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar10() {
    return clientDefinedChar10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char100.
   *
   * @return  String
   */
  public String getClientDefinedChar100() {
    return clientDefinedChar100;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar11() {
    return clientDefinedChar11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar12() {
    return clientDefinedChar12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar13() {
    return clientDefinedChar13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar14() {
    return clientDefinedChar14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar15() {
    return clientDefinedChar15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar16() {
    return clientDefinedChar16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar17() {
    return clientDefinedChar17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar18() {
    return clientDefinedChar18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char19.
   *
   * @return  String
   */
  public String getClientDefinedChar19() {
    return clientDefinedChar19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar2() {
    return clientDefinedChar2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar20() {
    return clientDefinedChar20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar21() {
    return clientDefinedChar21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char22.
   *
   * @return  String
   */
  public String getClientDefinedChar22() {
    return clientDefinedChar22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char23.
   *
   * @return  String
   */
  public String getClientDefinedChar23() {
    return clientDefinedChar23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char24.
   *
   * @return  String
   */
  public String getClientDefinedChar24() {
    return clientDefinedChar24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char25.
   *
   * @return  String
   */
  public String getClientDefinedChar25() {
    return clientDefinedChar25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char26.
   *
   * @return  String
   */
  public String getClientDefinedChar26() {
    return clientDefinedChar26;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char27.
   *
   * @return  String
   */
  public String getClientDefinedChar27() {
    return clientDefinedChar27;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char28.
   *
   * @return  String
   */
  public String getClientDefinedChar28() {
    return clientDefinedChar28;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char29.
   *
   * @return  String
   */
  public String getClientDefinedChar29() {
    return clientDefinedChar29;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar3() {
    return clientDefinedChar3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char30.
   *
   * @return  String
   */
  public String getClientDefinedChar30() {
    return clientDefinedChar30;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char31.
   *
   * @return  String
   */
  public String getClientDefinedChar31() {
    return clientDefinedChar31;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char32.
   *
   * @return  String
   */
  public String getClientDefinedChar32() {
    return clientDefinedChar32;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char33.
   *
   * @return  String
   */
  public String getClientDefinedChar33() {
    return clientDefinedChar33;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char34.
   *
   * @return  String
   */
  public String getClientDefinedChar34() {
    return clientDefinedChar34;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char35.
   *
   * @return  String
   */
  public String getClientDefinedChar35() {
    return clientDefinedChar35;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char36.
   *
   * @return  String
   */
  public String getClientDefinedChar36() {
    return clientDefinedChar36;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char37.
   *
   * @return  String
   */
  public String getClientDefinedChar37() {
    return clientDefinedChar37;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char38.
   *
   * @return  String
   */
  public String getClientDefinedChar38() {
    return clientDefinedChar38;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char39.
   *
   * @return  String
   */
  public String getClientDefinedChar39() {
    return clientDefinedChar39;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar4() {
    return clientDefinedChar4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char40.
   *
   * @return  String
   */
  public String getClientDefinedChar40() {
    return clientDefinedChar40;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char41.
   *
   * @return  String
   */
  public String getClientDefinedChar41() {
    return clientDefinedChar41;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char42.
   *
   * @return  String
   */
  public String getClientDefinedChar42() {
    return clientDefinedChar42;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char43.
   *
   * @return  String
   */
  public String getClientDefinedChar43() {
    return clientDefinedChar43;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char44.
   *
   * @return  String
   */
  public String getClientDefinedChar44() {
    return clientDefinedChar44;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char45.
   *
   * @return  String
   */
  public String getClientDefinedChar45() {
    return clientDefinedChar45;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char46.
   *
   * @return  String
   */
  public String getClientDefinedChar46() {
    return clientDefinedChar46;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char47.
   *
   * @return  String
   */
  public String getClientDefinedChar47() {
    return clientDefinedChar47;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char48.
   *
   * @return  String
   */
  public String getClientDefinedChar48() {
    return clientDefinedChar48;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char49.
   *
   * @return  String
   */
  public String getClientDefinedChar49() {
    return clientDefinedChar49;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar5() {
    return clientDefinedChar5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char50.
   *
   * @return  String
   */
  public String getClientDefinedChar50() {
    return clientDefinedChar50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char51.
   *
   * @return  String
   */
  public String getClientDefinedChar51() {
    return clientDefinedChar51;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char52.
   *
   * @return  String
   */
  public String getClientDefinedChar52() {
    return clientDefinedChar52;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char53.
   *
   * @return  String
   */
  public String getClientDefinedChar53() {
    return clientDefinedChar53;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char54.
   *
   * @return  String
   */
  public String getClientDefinedChar54() {
    return clientDefinedChar54;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char55.
   *
   * @return  String
   */
  public String getClientDefinedChar55() {
    return clientDefinedChar55;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char56.
   *
   * @return  String
   */
  public String getClientDefinedChar56() {
    return clientDefinedChar56;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char57.
   *
   * @return  String
   */
  public String getClientDefinedChar57() {
    return clientDefinedChar57;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char58.
   *
   * @return  String
   */
  public String getClientDefinedChar58() {
    return clientDefinedChar58;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char59.
   *
   * @return  String
   */
  public String getClientDefinedChar59() {
    return clientDefinedChar59;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char6.
   *
   * @return  String
   */
  public String getClientDefinedChar6() {
    return clientDefinedChar6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char60.
   *
   * @return  String
   */
  public String getClientDefinedChar60() {
    return clientDefinedChar60;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char61.
   *
   * @return  String
   */
  public String getClientDefinedChar61() {
    return clientDefinedChar61;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char62.
   *
   * @return  String
   */
  public String getClientDefinedChar62() {
    return clientDefinedChar62;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char63.
   *
   * @return  String
   */
  public String getClientDefinedChar63() {
    return clientDefinedChar63;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char64.
   *
   * @return  String
   */
  public String getClientDefinedChar64() {
    return clientDefinedChar64;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char65.
   *
   * @return  String
   */
  public String getClientDefinedChar65() {
    return clientDefinedChar65;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char66.
   *
   * @return  String
   */
  public String getClientDefinedChar66() {
    return clientDefinedChar66;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char67.
   *
   * @return  String
   */
  public String getClientDefinedChar67() {
    return clientDefinedChar67;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char68.
   *
   * @return  String
   */
  public String getClientDefinedChar68() {
    return clientDefinedChar68;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char69.
   *
   * @return  String
   */
  public String getClientDefinedChar69() {
    return clientDefinedChar69;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar7() {
    return clientDefinedChar7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char70.
   *
   * @return  String
   */
  public String getClientDefinedChar70() {
    return clientDefinedChar70;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char71.
   *
   * @return  String
   */
  public String getClientDefinedChar71() {
    return clientDefinedChar71;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char72.
   *
   * @return  String
   */
  public String getClientDefinedChar72() {
    return clientDefinedChar72;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char73.
   *
   * @return  String
   */
  public String getClientDefinedChar73() {
    return clientDefinedChar73;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char74.
   *
   * @return  String
   */
  public String getClientDefinedChar74() {
    return clientDefinedChar74;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char75.
   *
   * @return  String
   */
  public String getClientDefinedChar75() {
    return clientDefinedChar75;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char76.
   *
   * @return  String
   */
  public String getClientDefinedChar76() {
    return clientDefinedChar76;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char77.
   *
   * @return  String
   */
  public String getClientDefinedChar77() {
    return clientDefinedChar77;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char78.
   *
   * @return  String
   */
  public String getClientDefinedChar78() {
    return clientDefinedChar78;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char79.
   *
   * @return  String
   */
  public String getClientDefinedChar79() {
    return clientDefinedChar79;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedChar8() {
    return clientDefinedChar8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char80.
   *
   * @return  String
   */
  public String getClientDefinedChar80() {
    return clientDefinedChar80;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char81.
   *
   * @return  String
   */
  public String getClientDefinedChar81() {
    return clientDefinedChar81;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char82.
   *
   * @return  String
   */
  public String getClientDefinedChar82() {
    return clientDefinedChar82;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char83.
   *
   * @return  String
   */
  public String getClientDefinedChar83() {
    return clientDefinedChar83;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char84.
   *
   * @return  String
   */
  public String getClientDefinedChar84() {
    return clientDefinedChar84;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char85.
   *
   * @return  String
   */
  public String getClientDefinedChar85() {
    return clientDefinedChar85;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char86.
   *
   * @return  String
   */
  public String getClientDefinedChar86() {
    return clientDefinedChar86;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char87.
   *
   * @return  String
   */
  public String getClientDefinedChar87() {
    return clientDefinedChar87;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char88.
   *
   * @return  String
   */
  public String getClientDefinedChar88() {
    return clientDefinedChar88;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char89.
   *
   * @return  String
   */
  public String getClientDefinedChar89() {
    return clientDefinedChar89;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char9.
   *
   * @return  String
   */
  public String getClientDefinedChar9() {
    return clientDefinedChar9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char90.
   *
   * @return  String
   */
  public String getClientDefinedChar90() {
    return clientDefinedChar90;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char91.
   *
   * @return  String
   */
  public String getClientDefinedChar91() {
    return clientDefinedChar91;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char92.
   *
   * @return  String
   */
  public String getClientDefinedChar92() {
    return clientDefinedChar92;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char93.
   *
   * @return  String
   */
  public String getClientDefinedChar93() {
    return clientDefinedChar93;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char94.
   *
   * @return  String
   */
  public String getClientDefinedChar94() {
    return clientDefinedChar94;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char95.
   *
   * @return  String
   */
  public String getClientDefinedChar95() {
    return clientDefinedChar95;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char96.
   *
   * @return  String
   */
  public String getClientDefinedChar96() {
    return clientDefinedChar96;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char97.
   *
   * @return  String
   */
  public String getClientDefinedChar97() {
    return clientDefinedChar97;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char98.
   *
   * @return  String
   */
  public String getClientDefinedChar98() {
    return clientDefinedChar98;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined char99.
   *
   * @return  String
   */
  public String getClientDefinedChar99() {
    return clientDefinedChar99;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * String.
   *
   * @return  String.
   */
  public String getClientDefinedString6() {
    return clientDefinedString6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAccount.
   *
   * @param  account  $param.type$
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAccountExtensionCharId.
   *
   * @param  accountExtensionCharId  $param.type$
   */
  public void setAccountExtensionCharId(Long accountExtensionCharId) {
    this.accountExtensionCharId = accountExtensionCharId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar1.
   *
   * @param  clientDefinedChar1  $param.type$
   */
  public void setClientDefinedChar1(String clientDefinedChar1) {
    this.clientDefinedChar1 = clientDefinedChar1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar10.
   *
   * @param  clientDefinedChar10  $param.type$
   */
  public void setClientDefinedChar10(String clientDefinedChar10) {
    this.clientDefinedChar10 = clientDefinedChar10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char100.
   *
   * @param  clientDefinedChar100  String
   */
  public void setClientDefinedChar100(String clientDefinedChar100) {
    this.clientDefinedChar100 = clientDefinedChar100;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar11.
   *
   * @param  clientDefinedChar11  $param.type$
   */
  public void setClientDefinedChar11(String clientDefinedChar11) {
    this.clientDefinedChar11 = clientDefinedChar11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar12.
   *
   * @param  clientDefinedChar12  $param.type$
   */
  public void setClientDefinedChar12(String clientDefinedChar12) {
    this.clientDefinedChar12 = clientDefinedChar12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar13.
   *
   * @param  clientDefinedChar13  $param.type$
   */
  public void setClientDefinedChar13(String clientDefinedChar13) {
    this.clientDefinedChar13 = clientDefinedChar13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar14.
   *
   * @param  clientDefinedChar14  $param.type$
   */
  public void setClientDefinedChar14(String clientDefinedChar14) {
    this.clientDefinedChar14 = clientDefinedChar14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar15.
   *
   * @param  clientDefinedChar15  $param.type$
   */
  public void setClientDefinedChar15(String clientDefinedChar15) {
    this.clientDefinedChar15 = clientDefinedChar15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar16.
   *
   * @param  clientDefinedChar16  $param.type$
   */
  public void setClientDefinedChar16(String clientDefinedChar16) {
    this.clientDefinedChar16 = clientDefinedChar16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar17.
   *
   * @param  clientDefinedChar17  $param.type$
   */
  public void setClientDefinedChar17(String clientDefinedChar17) {
    this.clientDefinedChar17 = clientDefinedChar17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar18.
   *
   * @param  clientDefinedChar18  $param.type$
   */
  public void setClientDefinedChar18(String clientDefinedChar18) {
    this.clientDefinedChar18 = clientDefinedChar18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char19.
   *
   * @param  clientDefinedChar19  String
   */
  public void setClientDefinedChar19(String clientDefinedChar19) {
    this.clientDefinedChar19 = clientDefinedChar19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar2.
   *
   * @param  clientDefinedChar2  $param.type$
   */
  public void setClientDefinedChar2(String clientDefinedChar2) {
    this.clientDefinedChar2 = clientDefinedChar2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar20.
   *
   * @param  clientDefinedChar20  $param.type$
   */
  public void setClientDefinedChar20(String clientDefinedChar20) {
    this.clientDefinedChar20 = clientDefinedChar20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar21.
   *
   * @param  clientDefinedChar21  $param.type$
   */
  public void setClientDefinedChar21(String clientDefinedChar21) {
    this.clientDefinedChar21 = clientDefinedChar21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char22.
   *
   * @param  clientDefinedChar22  String
   */
  public void setClientDefinedChar22(String clientDefinedChar22) {
    this.clientDefinedChar22 = clientDefinedChar22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char23.
   *
   * @param  clientDefinedChar23  String
   */
  public void setClientDefinedChar23(String clientDefinedChar23) {
    this.clientDefinedChar23 = clientDefinedChar23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char24.
   *
   * @param  clientDefinedChar24  String
   */
  public void setClientDefinedChar24(String clientDefinedChar24) {
    this.clientDefinedChar24 = clientDefinedChar24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char25.
   *
   * @param  clientDefinedChar25  String
   */
  public void setClientDefinedChar25(String clientDefinedChar25) {
    this.clientDefinedChar25 = clientDefinedChar25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char26.
   *
   * @param  clientDefinedChar26  String
   */
  public void setClientDefinedChar26(String clientDefinedChar26) {
    this.clientDefinedChar26 = clientDefinedChar26;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char27.
   *
   * @param  clientDefinedChar27  String
   */
  public void setClientDefinedChar27(String clientDefinedChar27) {
    this.clientDefinedChar27 = clientDefinedChar27;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char28.
   *
   * @param  clientDefinedChar28  String
   */
  public void setClientDefinedChar28(String clientDefinedChar28) {
    this.clientDefinedChar28 = clientDefinedChar28;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char29.
   *
   * @param  clientDefinedChar29  String
   */
  public void setClientDefinedChar29(String clientDefinedChar29) {
    this.clientDefinedChar29 = clientDefinedChar29;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar3.
   *
   * @param  clientDefinedChar3  $param.type$
   */
  public void setClientDefinedChar3(String clientDefinedChar3) {
    this.clientDefinedChar3 = clientDefinedChar3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char30.
   *
   * @param  clientDefinedChar30  String
   */
  public void setClientDefinedChar30(String clientDefinedChar30) {
    this.clientDefinedChar30 = clientDefinedChar30;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char31.
   *
   * @param  clientDefinedChar31  String
   */
  public void setClientDefinedChar31(String clientDefinedChar31) {
    this.clientDefinedChar31 = clientDefinedChar31;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char32.
   *
   * @param  clientDefinedChar32  String
   */
  public void setClientDefinedChar32(String clientDefinedChar32) {
    this.clientDefinedChar32 = clientDefinedChar32;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char33.
   *
   * @param  clientDefinedChar33  String
   */
  public void setClientDefinedChar33(String clientDefinedChar33) {
    this.clientDefinedChar33 = clientDefinedChar33;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char34.
   *
   * @param  clientDefinedChar34  String
   */
  public void setClientDefinedChar34(String clientDefinedChar34) {
    this.clientDefinedChar34 = clientDefinedChar34;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char35.
   *
   * @param  clientDefinedChar35  String
   */
  public void setClientDefinedChar35(String clientDefinedChar35) {
    this.clientDefinedChar35 = clientDefinedChar35;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char36.
   *
   * @param  clientDefinedChar36  String
   */
  public void setClientDefinedChar36(String clientDefinedChar36) {
    this.clientDefinedChar36 = clientDefinedChar36;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char37.
   *
   * @param  clientDefinedChar37  String
   */
  public void setClientDefinedChar37(String clientDefinedChar37) {
    this.clientDefinedChar37 = clientDefinedChar37;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char38.
   *
   * @param  clientDefinedChar38  String
   */
  public void setClientDefinedChar38(String clientDefinedChar38) {
    this.clientDefinedChar38 = clientDefinedChar38;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char39.
   *
   * @param  clientDefinedChar39  String
   */
  public void setClientDefinedChar39(String clientDefinedChar39) {
    this.clientDefinedChar39 = clientDefinedChar39;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar4.
   *
   * @param  clientDefinedChar4  $param.type$
   */
  public void setClientDefinedChar4(String clientDefinedChar4) {
    this.clientDefinedChar4 = clientDefinedChar4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char40.
   *
   * @param  clientDefinedChar40  String
   */
  public void setClientDefinedChar40(String clientDefinedChar40) {
    this.clientDefinedChar40 = clientDefinedChar40;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char41.
   *
   * @param  clientDefinedChar41  String
   */
  public void setClientDefinedChar41(String clientDefinedChar41) {
    this.clientDefinedChar41 = clientDefinedChar41;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char42.
   *
   * @param  clientDefinedChar42  String
   */
  public void setClientDefinedChar42(String clientDefinedChar42) {
    this.clientDefinedChar42 = clientDefinedChar42;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char43.
   *
   * @param  clientDefinedChar43  String
   */
  public void setClientDefinedChar43(String clientDefinedChar43) {
    this.clientDefinedChar43 = clientDefinedChar43;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char44.
   *
   * @param  clientDefinedChar44  String
   */
  public void setClientDefinedChar44(String clientDefinedChar44) {
    this.clientDefinedChar44 = clientDefinedChar44;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char45.
   *
   * @param  clientDefinedChar45  String
   */
  public void setClientDefinedChar45(String clientDefinedChar45) {
    this.clientDefinedChar45 = clientDefinedChar45;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char46.
   *
   * @param  clientDefinedChar46  String
   */
  public void setClientDefinedChar46(String clientDefinedChar46) {
    this.clientDefinedChar46 = clientDefinedChar46;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char47.
   *
   * @param  clientDefinedChar47  String
   */
  public void setClientDefinedChar47(String clientDefinedChar47) {
    this.clientDefinedChar47 = clientDefinedChar47;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char48.
   *
   * @param  clientDefinedChar48  String
   */
  public void setClientDefinedChar48(String clientDefinedChar48) {
    this.clientDefinedChar48 = clientDefinedChar48;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char49.
   *
   * @param  clientDefinedChar49  String
   */
  public void setClientDefinedChar49(String clientDefinedChar49) {
    this.clientDefinedChar49 = clientDefinedChar49;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar5.
   *
   * @param  clientDefinedChar5  $param.type$
   */
  public void setClientDefinedChar5(String clientDefinedChar5) {
    this.clientDefinedChar5 = clientDefinedChar5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char50.
   *
   * @param  clientDefinedChar50  String
   */
  public void setClientDefinedChar50(String clientDefinedChar50) {
    this.clientDefinedChar50 = clientDefinedChar50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char51.
   *
   * @param  clientDefinedChar51  String
   */
  public void setClientDefinedChar51(String clientDefinedChar51) {
    this.clientDefinedChar51 = clientDefinedChar51;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char52.
   *
   * @param  clientDefinedChar52  String
   */
  public void setClientDefinedChar52(String clientDefinedChar52) {
    this.clientDefinedChar52 = clientDefinedChar52;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char53.
   *
   * @param  clientDefinedChar53  String
   */
  public void setClientDefinedChar53(String clientDefinedChar53) {
    this.clientDefinedChar53 = clientDefinedChar53;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char54.
   *
   * @param  clientDefinedChar54  String
   */
  public void setClientDefinedChar54(String clientDefinedChar54) {
    this.clientDefinedChar54 = clientDefinedChar54;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char55.
   *
   * @param  clientDefinedChar55  String
   */
  public void setClientDefinedChar55(String clientDefinedChar55) {
    this.clientDefinedChar55 = clientDefinedChar55;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char56.
   *
   * @param  clientDefinedChar56  String
   */
  public void setClientDefinedChar56(String clientDefinedChar56) {
    this.clientDefinedChar56 = clientDefinedChar56;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char57.
   *
   * @param  clientDefinedChar57  String
   */
  public void setClientDefinedChar57(String clientDefinedChar57) {
    this.clientDefinedChar57 = clientDefinedChar57;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char58.
   *
   * @param  clientDefinedChar58  String
   */
  public void setClientDefinedChar58(String clientDefinedChar58) {
    this.clientDefinedChar58 = clientDefinedChar58;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char59.
   *
   * @param  clientDefinedChar59  String
   */
  public void setClientDefinedChar59(String clientDefinedChar59) {
    this.clientDefinedChar59 = clientDefinedChar59;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char6.
   *
   * @param  clientDefinedChar6  String
   */
  public void setClientDefinedChar6(String clientDefinedChar6) {
    this.clientDefinedChar6 = clientDefinedChar6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char60.
   *
   * @param  clientDefinedChar60  String
   */
  public void setClientDefinedChar60(String clientDefinedChar60) {
    this.clientDefinedChar60 = clientDefinedChar60;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char61.
   *
   * @param  clientDefinedChar61  String
   */
  public void setClientDefinedChar61(String clientDefinedChar61) {
    this.clientDefinedChar61 = clientDefinedChar61;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char62.
   *
   * @param  clientDefinedChar62  String
   */
  public void setClientDefinedChar62(String clientDefinedChar62) {
    this.clientDefinedChar62 = clientDefinedChar62;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char63.
   *
   * @param  clientDefinedChar63  String
   */
  public void setClientDefinedChar63(String clientDefinedChar63) {
    this.clientDefinedChar63 = clientDefinedChar63;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char64.
   *
   * @param  clientDefinedChar64  String
   */
  public void setClientDefinedChar64(String clientDefinedChar64) {
    this.clientDefinedChar64 = clientDefinedChar64;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char65.
   *
   * @param  clientDefinedChar65  String
   */
  public void setClientDefinedChar65(String clientDefinedChar65) {
    this.clientDefinedChar65 = clientDefinedChar65;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char66.
   *
   * @param  clientDefinedChar66  String
   */
  public void setClientDefinedChar66(String clientDefinedChar66) {
    this.clientDefinedChar66 = clientDefinedChar66;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char67.
   *
   * @param  clientDefinedChar67  String
   */
  public void setClientDefinedChar67(String clientDefinedChar67) {
    this.clientDefinedChar67 = clientDefinedChar67;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char68.
   *
   * @param  clientDefinedChar68  String
   */
  public void setClientDefinedChar68(String clientDefinedChar68) {
    this.clientDefinedChar68 = clientDefinedChar68;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char69.
   *
   * @param  clientDefinedChar69  String
   */
  public void setClientDefinedChar69(String clientDefinedChar69) {
    this.clientDefinedChar69 = clientDefinedChar69;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar7.
   *
   * @param  clientDefinedChar7  $param.type$
   */
  public void setClientDefinedChar7(String clientDefinedChar7) {
    this.clientDefinedChar7 = clientDefinedChar7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char70.
   *
   * @param  clientDefinedChar70  String
   */
  public void setClientDefinedChar70(String clientDefinedChar70) {
    this.clientDefinedChar70 = clientDefinedChar70;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char71.
   *
   * @param  clientDefinedChar71  String
   */
  public void setClientDefinedChar71(String clientDefinedChar71) {
    this.clientDefinedChar71 = clientDefinedChar71;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char72.
   *
   * @param  clientDefinedChar72  String
   */
  public void setClientDefinedChar72(String clientDefinedChar72) {
    this.clientDefinedChar72 = clientDefinedChar72;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char73.
   *
   * @param  clientDefinedChar73  String
   */
  public void setClientDefinedChar73(String clientDefinedChar73) {
    this.clientDefinedChar73 = clientDefinedChar73;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char74.
   *
   * @param  clientDefinedChar74  String
   */
  public void setClientDefinedChar74(String clientDefinedChar74) {
    this.clientDefinedChar74 = clientDefinedChar74;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char75.
   *
   * @param  clientDefinedChar75  String
   */
  public void setClientDefinedChar75(String clientDefinedChar75) {
    this.clientDefinedChar75 = clientDefinedChar75;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char76.
   *
   * @param  clientDefinedChar76  String
   */
  public void setClientDefinedChar76(String clientDefinedChar76) {
    this.clientDefinedChar76 = clientDefinedChar76;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char77.
   *
   * @param  clientDefinedChar77  String
   */
  public void setClientDefinedChar77(String clientDefinedChar77) {
    this.clientDefinedChar77 = clientDefinedChar77;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char78.
   *
   * @param  clientDefinedChar78  String
   */
  public void setClientDefinedChar78(String clientDefinedChar78) {
    this.clientDefinedChar78 = clientDefinedChar78;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char79.
   *
   * @param  clientDefinedChar79  String
   */
  public void setClientDefinedChar79(String clientDefinedChar79) {
    this.clientDefinedChar79 = clientDefinedChar79;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedChar8.
   *
   * @param  clientDefinedChar8  $param.type$
   */
  public void setClientDefinedChar8(String clientDefinedChar8) {
    this.clientDefinedChar8 = clientDefinedChar8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char80.
   *
   * @param  clientDefinedChar80  String
   */
  public void setClientDefinedChar80(String clientDefinedChar80) {
    this.clientDefinedChar80 = clientDefinedChar80;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char81.
   *
   * @param  clientDefinedChar81  String
   */
  public void setClientDefinedChar81(String clientDefinedChar81) {
    this.clientDefinedChar81 = clientDefinedChar81;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char82.
   *
   * @param  clientDefinedChar82  String
   */
  public void setClientDefinedChar82(String clientDefinedChar82) {
    this.clientDefinedChar82 = clientDefinedChar82;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char83.
   *
   * @param  clientDefinedChar83  String
   */
  public void setClientDefinedChar83(String clientDefinedChar83) {
    this.clientDefinedChar83 = clientDefinedChar83;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char84.
   *
   * @param  clientDefinedChar84  String
   */
  public void setClientDefinedChar84(String clientDefinedChar84) {
    this.clientDefinedChar84 = clientDefinedChar84;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char85.
   *
   * @param  clientDefinedChar85  String
   */
  public void setClientDefinedChar85(String clientDefinedChar85) {
    this.clientDefinedChar85 = clientDefinedChar85;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char86.
   *
   * @param  clientDefinedChar86  String
   */
  public void setClientDefinedChar86(String clientDefinedChar86) {
    this.clientDefinedChar86 = clientDefinedChar86;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char87.
   *
   * @param  clientDefinedChar87  String
   */
  public void setClientDefinedChar87(String clientDefinedChar87) {
    this.clientDefinedChar87 = clientDefinedChar87;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char88.
   *
   * @param  clientDefinedChar88  String
   */
  public void setClientDefinedChar88(String clientDefinedChar88) {
    this.clientDefinedChar88 = clientDefinedChar88;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char89.
   *
   * @param  clientDefinedChar89  String
   */
  public void setClientDefinedChar89(String clientDefinedChar89) {
    this.clientDefinedChar89 = clientDefinedChar89;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char9.
   *
   * @param  clientDefinedChar9  String
   */
  public void setClientDefinedChar9(String clientDefinedChar9) {
    this.clientDefinedChar9 = clientDefinedChar9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char90.
   *
   * @param  clientDefinedChar90  String
   */
  public void setClientDefinedChar90(String clientDefinedChar90) {
    this.clientDefinedChar90 = clientDefinedChar90;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char91.
   *
   * @param  clientDefinedChar91  String
   */
  public void setClientDefinedChar91(String clientDefinedChar91) {
    this.clientDefinedChar91 = clientDefinedChar91;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char92.
   *
   * @param  clientDefinedChar92  String
   */
  public void setClientDefinedChar92(String clientDefinedChar92) {
    this.clientDefinedChar92 = clientDefinedChar92;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char93.
   *
   * @param  clientDefinedChar93  String
   */
  public void setClientDefinedChar93(String clientDefinedChar93) {
    this.clientDefinedChar93 = clientDefinedChar93;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char94.
   *
   * @param  clientDefinedChar94  String
   */
  public void setClientDefinedChar94(String clientDefinedChar94) {
    this.clientDefinedChar94 = clientDefinedChar94;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char95.
   *
   * @param  clientDefinedChar95  String
   */
  public void setClientDefinedChar95(String clientDefinedChar95) {
    this.clientDefinedChar95 = clientDefinedChar95;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char96.
   *
   * @param  clientDefinedChar96  String
   */
  public void setClientDefinedChar96(String clientDefinedChar96) {
    this.clientDefinedChar96 = clientDefinedChar96;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char97.
   *
   * @param  clientDefinedChar97  String
   */
  public void setClientDefinedChar97(String clientDefinedChar97) {
    this.clientDefinedChar97 = clientDefinedChar97;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char98.
   *
   * @param  clientDefinedChar98  String
   */
  public void setClientDefinedChar98(String clientDefinedChar98) {
    this.clientDefinedChar98 = clientDefinedChar98;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined char99.
   *
   * @param  clientDefinedChar99  String
   */
  public void setClientDefinedChar99(String clientDefinedChar99) {
    this.clientDefinedChar99 = clientDefinedChar99;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedString6.
   *
   * @param  clientDefinedString6  $param.type$
   */
  public void setClientDefinedString6(String clientDefinedString6) {
    this.clientDefinedString6 = clientDefinedString6;
  }

  public String getClientDefinedChar101() {
    return clientDefinedChar101;
  }

  public void setClientDefinedChar101(String clientDefinedChar101) {
    this.clientDefinedChar101 = clientDefinedChar101;
  }

  public String getClientDefinedChar102() {
    return clientDefinedChar102;
  }

  public void setClientDefinedChar102(String clientDefinedChar102) {
    this.clientDefinedChar102 = clientDefinedChar102;
  }

  public String getClientDefinedChar103() {
    return clientDefinedChar103;
  }

  public void setClientDefinedChar103(String clientDefinedChar103) {
    this.clientDefinedChar103 = clientDefinedChar103;
  }

  public String getClientDefinedChar104() {
    return clientDefinedChar104;
  }

  public void setClientDefinedChar104(String clientDefinedChar104) {
    this.clientDefinedChar104 = clientDefinedChar104;
  }

  public String getClientDefinedChar105() {
    return clientDefinedChar105;
  }

  public void setClientDefinedChar105(String clientDefinedChar105) {
    this.clientDefinedChar105 = clientDefinedChar105;
  }

  public String getClientDefinedChar106() {
    return clientDefinedChar106;
  }

  public void setClientDefinedChar106(String clientDefinedChar106) {
    this.clientDefinedChar106 = clientDefinedChar106;
  }

  public String getClientDefinedChar107() {
    return clientDefinedChar107;
  }

  public void setClientDefinedChar107(String clientDefinedChar107) {
    this.clientDefinedChar107 = clientDefinedChar107;
  }

  public String getClientDefinedChar108() {
    return clientDefinedChar108;
  }

  public void setClientDefinedChar108(String clientDefinedChar108) {
    this.clientDefinedChar108 = clientDefinedChar108;
  }

  public String getClientDefinedChar109() {
    return clientDefinedChar109;
  }

  public void setClientDefinedChar109(String clientDefinedChar109) {
    this.clientDefinedChar109 = clientDefinedChar109;
  }

  public String getClientDefinedChar110() {
    return clientDefinedChar110;
  }

  public void setClientDefinedChar110(String clientDefinedChar110) {
    this.clientDefinedChar110 = clientDefinedChar110;
  }

  public String getClientDefinedChar111() {
    return clientDefinedChar111;
  }

  public void setClientDefinedChar111(String clientDefinedChar111) {
    this.clientDefinedChar111 = clientDefinedChar111;
  }

  public String getClientDefinedChar112() {
    return clientDefinedChar112;
  }

  public void setClientDefinedChar112(String clientDefinedChar112) {
    this.clientDefinedChar112 = clientDefinedChar112;
  }

  public String getClientDefinedChar113() {
    return clientDefinedChar113;
  }

  public void setClientDefinedChar113(String clientDefinedChar113) {
    this.clientDefinedChar113 = clientDefinedChar113;
  }

  public String getClientDefinedChar114() {
    return clientDefinedChar114;
  }

  public void setClientDefinedChar114(String clientDefinedChar114) {
    this.clientDefinedChar114 = clientDefinedChar114;
  }

  public String getClientDefinedChar115() {
    return clientDefinedChar115;
  }

  public void setClientDefinedChar115(String clientDefinedChar115) {
    this.clientDefinedChar115 = clientDefinedChar115;
  }

  public String getClientDefinedChar116() {
    return clientDefinedChar116;
  }

  public void setClientDefinedChar116(String clientDefinedChar116) {
    this.clientDefinedChar116 = clientDefinedChar116;
  }

  public String getClientDefinedChar117() {
    return clientDefinedChar117;
  }

  public void setClientDefinedChar117(String clientDefinedChar117) {
    this.clientDefinedChar117 = clientDefinedChar117;
  }

  public String getClientDefinedChar118() {
    return clientDefinedChar118;
  }

  public void setClientDefinedChar118(String clientDefinedChar118) {
    this.clientDefinedChar118 = clientDefinedChar118;
  }

  public String getClientDefinedChar119() {
    return clientDefinedChar119;
  }

  public void setClientDefinedChar119(String clientDefinedChar119) {
    this.clientDefinedChar119 = clientDefinedChar119;
  }

  public String getClientDefinedChar120() {
    return clientDefinedChar120;
  }

  public void setClientDefinedChar120(String clientDefinedChar120) {
    this.clientDefinedChar120 = clientDefinedChar120;
  }

  public String getClientDefinedChar121() {
    return clientDefinedChar121;
  }

  public void setClientDefinedChar121(String clientDefinedChar121) {
    this.clientDefinedChar121 = clientDefinedChar121;
  }

  public String getClientDefinedChar122() {
    return clientDefinedChar122;
  }

  public void setClientDefinedChar122(String clientDefinedChar122) {
    this.clientDefinedChar122 = clientDefinedChar122;
  }

  public String getClientDefinedChar123() {
    return clientDefinedChar123;
  }

  public void setClientDefinedChar123(String clientDefinedChar123) {
    this.clientDefinedChar123 = clientDefinedChar123;
  }

  public String getClientDefinedChar124() {
    return clientDefinedChar124;
  }

  public void setClientDefinedChar124(String clientDefinedChar124) {
    this.clientDefinedChar124 = clientDefinedChar124;
  }

  public String getClientDefinedChar125() {
    return clientDefinedChar125;
  }

  public void setClientDefinedChar125(String clientDefinedChar125) {
    this.clientDefinedChar125 = clientDefinedChar125;
  }

  public String getClientDefinedChar126() {
    return clientDefinedChar126;
  }

  public void setClientDefinedChar126(String clientDefinedChar126) {
    this.clientDefinedChar126 = clientDefinedChar126;
  }

  public String getClientDefinedChar127() {
    return clientDefinedChar127;
  }

  public void setClientDefinedChar127(String clientDefinedChar127) {
    this.clientDefinedChar127 = clientDefinedChar127;
  }

  public String getClientDefinedChar128() {
    return clientDefinedChar128;
  }

  public void setClientDefinedChar128(String clientDefinedChar128) {
    this.clientDefinedChar128 = clientDefinedChar128;
  }

  public String getClientDefinedChar129() {
    return clientDefinedChar129;
  }

  public void setClientDefinedChar129(String clientDefinedChar129) {
    this.clientDefinedChar129 = clientDefinedChar129;
  }

  public String getClientDefinedChar130() {
    return clientDefinedChar130;
  }

  public void setClientDefinedChar130(String clientDefinedChar130) {
    this.clientDefinedChar130 = clientDefinedChar130;
  }

  public String getClientDefinedChar131() {
    return clientDefinedChar131;
  }

  public void setClientDefinedChar131(String clientDefinedChar131) {
    this.clientDefinedChar131 = clientDefinedChar131;
  }

  public String getClientDefinedChar132() {
    return clientDefinedChar132;
  }

  public void setClientDefinedChar132(String clientDefinedChar132) {
    this.clientDefinedChar132 = clientDefinedChar132;
  }

  public String getClientDefinedChar133() {
    return clientDefinedChar133;
  }

  public void setClientDefinedChar133(String clientDefinedChar133) {
    this.clientDefinedChar133 = clientDefinedChar133;
  }

  public String getClientDefinedChar134() {
    return clientDefinedChar134;
  }

  public void setClientDefinedChar134(String clientDefinedChar134) {
    this.clientDefinedChar134 = clientDefinedChar134;
  }

  public String getClientDefinedChar135() {
    return clientDefinedChar135;
  }

  public void setClientDefinedChar135(String clientDefinedChar135) {
    this.clientDefinedChar135 = clientDefinedChar135;
  }

  public String getClientDefinedChar136() {
    return clientDefinedChar136;
  }

  public void setClientDefinedChar136(String clientDefinedChar136) {
    this.clientDefinedChar136 = clientDefinedChar136;
  }

  public String getClientDefinedChar137() {
    return clientDefinedChar137;
  }

  public void setClientDefinedChar137(String clientDefinedChar137) {
    this.clientDefinedChar137 = clientDefinedChar137;
  }

  public String getClientDefinedChar138() {
    return clientDefinedChar138;
  }

  public void setClientDefinedChar138(String clientDefinedChar138) {
    this.clientDefinedChar138 = clientDefinedChar138;
  }

  public String getClientDefinedChar139() {
    return clientDefinedChar139;
  }

  public void setClientDefinedChar139(String clientDefinedChar139) {
    this.clientDefinedChar139 = clientDefinedChar139;
  }

  public String getClientDefinedChar140() {
    return clientDefinedChar140;
  }

  public void setClientDefinedChar140(String clientDefinedChar140) {
    this.clientDefinedChar140 = clientDefinedChar140;
  }

  public String getClientDefinedChar141() {
    return clientDefinedChar141;
  }

  public void setClientDefinedChar141(String clientDefinedChar141) {
    this.clientDefinedChar141 = clientDefinedChar141;
  }

  public String getClientDefinedChar142() {
    return clientDefinedChar142;
  }

  public void setClientDefinedChar142(String clientDefinedChar142) {
    this.clientDefinedChar142 = clientDefinedChar142;
  }

  public String getClientDefinedChar143() {
    return clientDefinedChar143;
  }

  public void setClientDefinedChar143(String clientDefinedChar143) {
    this.clientDefinedChar143 = clientDefinedChar143;
  }

  public String getClientDefinedChar144() {
    return clientDefinedChar144;
  }

  public void setClientDefinedChar144(String clientDefinedChar144) {
    this.clientDefinedChar144 = clientDefinedChar144;
  }

  public String getClientDefinedChar145() {
    return clientDefinedChar145;
  }

  public void setClientDefinedChar145(String clientDefinedChar145) {
    this.clientDefinedChar145 = clientDefinedChar145;
  }

  public String getClientDefinedChar146() {
    return clientDefinedChar146;
  }

  public void setClientDefinedChar146(String clientDefinedChar146) {
    this.clientDefinedChar146 = clientDefinedChar146;
  }

  public String getClientDefinedChar147() {
    return clientDefinedChar147;
  }

  public void setClientDefinedChar147(String clientDefinedChar147) {
    this.clientDefinedChar147 = clientDefinedChar147;
  }

  public String getClientDefinedChar148() {
    return clientDefinedChar148;
  }

  public void setClientDefinedChar148(String clientDefinedChar148) {
    this.clientDefinedChar148 = clientDefinedChar148;
  }

  public String getClientDefinedChar149() {
    return clientDefinedChar149;
  }

  public void setClientDefinedChar149(String clientDefinedChar149) {
    this.clientDefinedChar149 = clientDefinedChar149;
  }

  public String getClientDefinedChar150() {
    return clientDefinedChar150;
  }

  public void setClientDefinedChar150(String clientDefinedChar150) {
    this.clientDefinedChar150 = clientDefinedChar150;
  }
} // end class AccountExtensionChar
