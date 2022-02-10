package com.cmc.credagility.core.domain.account;

import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  07/24/2015 17:20
 */
@Entity
@Table(name = "AccountExtensionDate")
public class AccountExtensionDate extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7098157920902637779L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "accountExtensionDateId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long accountExtensionDateId;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate1")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate1;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate10")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate10;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate100")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate100;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate11")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate11;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate12")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate12;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate13")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate13;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate14")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate14;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate15")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate15;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate16")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate16;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate17")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate17;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate18")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate18;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate19")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate19;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate2")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate2;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate20")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate20;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate21")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate21;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate22")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate22;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate23")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate23;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate24")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate24;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate25")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate25;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate26")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate26;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate27")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate27;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate28")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate28;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate29")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate29;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate3")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate3;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate30")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate30;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate31")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate31;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate32")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate32;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate33")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate33;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate34")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate34;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate35")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate35;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate36")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate36;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate37")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate37;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate38")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate38;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate39")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate39;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate4")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate4;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate40")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate40;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate41")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate41;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate42")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate42;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate43")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate43;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate44")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate44;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate45")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate45;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate46")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate46;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate47")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate47;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate48")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate48;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate49")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate49;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate5")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate5;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate50")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate50;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate51")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate51;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate52")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate52;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate53")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate53;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate54")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate54;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate55")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate55;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate56")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate56;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate57")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate57;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate58")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate58;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate59")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate59;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate6")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate6;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate60")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate60;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate61")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate61;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate62")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate62;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate63")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate63;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate64")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate64;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate65")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate65;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate66")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate66;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate67")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate67;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate68")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate68;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate69")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate69;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate7")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate7;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate70")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate70;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate71")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate71;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate72")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate72;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate73")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate73;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate74")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate74;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate75")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate75;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate76")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate76;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate77")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate77;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate78")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate78;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate79")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate79;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate8")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate8;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate80")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate80;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate81")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate81;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate82")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate82;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate83")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate83;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate84")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate84;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate85")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate85;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate86")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate86;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate87")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate87;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate88")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate88;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate89")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate89;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate9")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate9;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate90")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate90;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate91")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate91;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate92")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate92;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate93")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate93;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate94")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate94;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate95")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate95;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate96")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate96;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate97")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate97;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate98")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate98;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate99")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate99;

  @Column(name = "clientDefinedDate101")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate101;
  @Column(name = "clientDefinedDate102")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate102;
  @Column(name = "clientDefinedDate103")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate103;
  @Column(name = "clientDefinedDate104")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate104;
  @Column(name = "clientDefinedDate105")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate105;
  @Column(name = "clientDefinedDate106")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate106;
  @Column(name = "clientDefinedDate107")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate107;
  @Column(name = "clientDefinedDate108")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate108;
  @Column(name = "clientDefinedDate109")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate109;
  @Column(name = "clientDefinedDate110")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate110;
  @Column(name = "clientDefinedDate111")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate111;
  @Column(name = "clientDefinedDate112")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate112;
  @Column(name = "clientDefinedDate113")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate113;
  @Column(name = "clientDefinedDate114")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate114;
  @Column(name = "clientDefinedDate115")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate115;
  @Column(name = "clientDefinedDate116")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate116;
  @Column(name = "clientDefinedDate117")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate117;
  @Column(name = "clientDefinedDate118")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate118;
  @Column(name = "clientDefinedDate119")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate119;
  @Column(name = "clientDefinedDate120")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate120;
  @Column(name = "clientDefinedDate121")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate121;
  @Column(name = "clientDefinedDate122")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate122;
  @Column(name = "clientDefinedDate123")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate123;
  @Column(name = "clientDefinedDate124")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate124;
  @Column(name = "clientDefinedDate125")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate125;
  @Column(name = "clientDefinedDate126")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate126;
  @Column(name = "clientDefinedDate127")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate127;
  @Column(name = "clientDefinedDate128")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate128;
  @Column(name = "clientDefinedDate129")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate129;
  @Column(name = "clientDefinedDate130")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate130;
  @Column(name = "clientDefinedDate131")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate131;
  @Column(name = "clientDefinedDate132")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate132;
  @Column(name = "clientDefinedDate133")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate133;
  @Column(name = "clientDefinedDate134")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate134;
  @Column(name = "clientDefinedDate135")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate135;
  @Column(name = "clientDefinedDate136")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate136;
  @Column(name = "clientDefinedDate137")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate137;
  @Column(name = "clientDefinedDate138")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate138;
  @Column(name = "clientDefinedDate139")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate139;
  @Column(name = "clientDefinedDate140")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate140;
  @Column(name = "clientDefinedDate141")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate141;
  @Column(name = "clientDefinedDate142")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate142;
  @Column(name = "clientDefinedDate143")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate143;
  @Column(name = "clientDefinedDate144")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate144;
  @Column(name = "clientDefinedDate145")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate145;
  @Column(name = "clientDefinedDate146")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate146;
  @Column(name = "clientDefinedDate147")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate147;
  @Column(name = "clientDefinedDate148")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate148;
  @Column(name = "clientDefinedDate149")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate149;
  @Column(name = "clientDefinedDate150")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate150;


  @JoinColumn(
    name   = "accountNum",
    unique = true
  )
  @ManyToOne private Account account;

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
  public Long getAccountExtensionDateId() {
    return accountExtensionDateId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate1() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate10() {
    return clientDefinedDate10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date100.
   *
   * @return  Date
   */
  public Date getClientDefinedDate100() {
    return clientDefinedDate100;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate11() {
    return clientDefinedDate11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate12() {
    return clientDefinedDate12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate13() {
    return clientDefinedDate13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate14() {
    return clientDefinedDate14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate15() {
    return clientDefinedDate15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate16() {
    return clientDefinedDate16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate17() {
    return clientDefinedDate17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate18() {
    return clientDefinedDate18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate19() {
    return clientDefinedDate19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate2() {
    return clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate20() {
    return clientDefinedDate20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date21.
   *
   * @return  Date
   */
  public Date getClientDefinedDate21() {
    return clientDefinedDate21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date22.
   *
   * @return  Date
   */
  public Date getClientDefinedDate22() {
    return clientDefinedDate22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date23.
   *
   * @return  Date
   */
  public Date getClientDefinedDate23() {
    return clientDefinedDate23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date24.
   *
   * @return  Date
   */
  public Date getClientDefinedDate24() {
    return clientDefinedDate24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date25.
   *
   * @return  Date
   */
  public Date getClientDefinedDate25() {
    return clientDefinedDate25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date26.
   *
   * @return  Date
   */
  public Date getClientDefinedDate26() {
    return clientDefinedDate26;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date27.
   *
   * @return  Date
   */
  public Date getClientDefinedDate27() {
    return clientDefinedDate27;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date28.
   *
   * @return  Date
   */
  public Date getClientDefinedDate28() {
    return clientDefinedDate28;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date29.
   *
   * @return  Date
   */
  public Date getClientDefinedDate29() {
    return clientDefinedDate29;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate3() {
    return clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date30.
   *
   * @return  Date
   */
  public Date getClientDefinedDate30() {
    return clientDefinedDate30;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date31.
   *
   * @return  Date
   */
  public Date getClientDefinedDate31() {
    return clientDefinedDate31;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date32.
   *
   * @return  Date
   */
  public Date getClientDefinedDate32() {
    return clientDefinedDate32;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date33.
   *
   * @return  Date
   */
  public Date getClientDefinedDate33() {
    return clientDefinedDate33;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date34.
   *
   * @return  Date
   */
  public Date getClientDefinedDate34() {
    return clientDefinedDate34;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date35.
   *
   * @return  Date
   */
  public Date getClientDefinedDate35() {
    return clientDefinedDate35;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date36.
   *
   * @return  Date
   */
  public Date getClientDefinedDate36() {
    return clientDefinedDate36;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date37.
   *
   * @return  Date
   */
  public Date getClientDefinedDate37() {
    return clientDefinedDate37;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date38.
   *
   * @return  Date
   */
  public Date getClientDefinedDate38() {
    return clientDefinedDate38;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date39.
   *
   * @return  Date
   */
  public Date getClientDefinedDate39() {
    return clientDefinedDate39;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate4() {
    return clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date40.
   *
   * @return  Date
   */
  public Date getClientDefinedDate40() {
    return clientDefinedDate40;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date41.
   *
   * @return  Date
   */
  public Date getClientDefinedDate41() {
    return clientDefinedDate41;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date42.
   *
   * @return  Date
   */
  public Date getClientDefinedDate42() {
    return clientDefinedDate42;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date43.
   *
   * @return  Date
   */
  public Date getClientDefinedDate43() {
    return clientDefinedDate43;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date44.
   *
   * @return  Date
   */
  public Date getClientDefinedDate44() {
    return clientDefinedDate44;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date45.
   *
   * @return  Date
   */
  public Date getClientDefinedDate45() {
    return clientDefinedDate45;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date46.
   *
   * @return  Date
   */
  public Date getClientDefinedDate46() {
    return clientDefinedDate46;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date47.
   *
   * @return  Date
   */
  public Date getClientDefinedDate47() {
    return clientDefinedDate47;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date48.
   *
   * @return  Date
   */
  public Date getClientDefinedDate48() {
    return clientDefinedDate48;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date49.
   *
   * @return  Date
   */
  public Date getClientDefinedDate49() {
    return clientDefinedDate49;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate5() {
    return clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date50.
   *
   * @return  Date
   */
  public Date getClientDefinedDate50() {
    return clientDefinedDate50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date51.
   *
   * @return  Date
   */
  public Date getClientDefinedDate51() {
    return clientDefinedDate51;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date52.
   *
   * @return  Date
   */
  public Date getClientDefinedDate52() {
    return clientDefinedDate52;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date53.
   *
   * @return  Date
   */
  public Date getClientDefinedDate53() {
    return clientDefinedDate53;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date54.
   *
   * @return  Date
   */
  public Date getClientDefinedDate54() {
    return clientDefinedDate54;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date55.
   *
   * @return  Date
   */
  public Date getClientDefinedDate55() {
    return clientDefinedDate55;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date56.
   *
   * @return  Date
   */
  public Date getClientDefinedDate56() {
    return clientDefinedDate56;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date57.
   *
   * @return  Date
   */
  public Date getClientDefinedDate57() {
    return clientDefinedDate57;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date58.
   *
   * @return  Date
   */
  public Date getClientDefinedDate58() {
    return clientDefinedDate58;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date59.
   *
   * @return  Date
   */
  public Date getClientDefinedDate59() {
    return clientDefinedDate59;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate6() {
    return clientDefinedDate6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date60.
   *
   * @return  Date
   */
  public Date getClientDefinedDate60() {
    return clientDefinedDate60;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date61.
   *
   * @return  Date
   */
  public Date getClientDefinedDate61() {
    return clientDefinedDate61;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date62.
   *
   * @return  Date
   */
  public Date getClientDefinedDate62() {
    return clientDefinedDate62;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date63.
   *
   * @return  Date
   */
  public Date getClientDefinedDate63() {
    return clientDefinedDate63;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date64.
   *
   * @return  Date
   */
  public Date getClientDefinedDate64() {
    return clientDefinedDate64;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date65.
   *
   * @return  Date
   */
  public Date getClientDefinedDate65() {
    return clientDefinedDate65;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date66.
   *
   * @return  Date
   */
  public Date getClientDefinedDate66() {
    return clientDefinedDate66;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date67.
   *
   * @return  Date
   */
  public Date getClientDefinedDate67() {
    return clientDefinedDate67;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date68.
   *
   * @return  Date
   */
  public Date getClientDefinedDate68() {
    return clientDefinedDate68;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date69.
   *
   * @return  Date
   */
  public Date getClientDefinedDate69() {
    return clientDefinedDate69;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate7() {
    return clientDefinedDate7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date70.
   *
   * @return  Date
   */
  public Date getClientDefinedDate70() {
    return clientDefinedDate70;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date71.
   *
   * @return  Date
   */
  public Date getClientDefinedDate71() {
    return clientDefinedDate71;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date72.
   *
   * @return  Date
   */
  public Date getClientDefinedDate72() {
    return clientDefinedDate72;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date73.
   *
   * @return  Date
   */
  public Date getClientDefinedDate73() {
    return clientDefinedDate73;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date74.
   *
   * @return  Date
   */
  public Date getClientDefinedDate74() {
    return clientDefinedDate74;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date75.
   *
   * @return  Date
   */
  public Date getClientDefinedDate75() {
    return clientDefinedDate75;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date76.
   *
   * @return  Date
   */
  public Date getClientDefinedDate76() {
    return clientDefinedDate76;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date77.
   *
   * @return  Date
   */
  public Date getClientDefinedDate77() {
    return clientDefinedDate77;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date78.
   *
   * @return  Date
   */
  public Date getClientDefinedDate78() {
    return clientDefinedDate78;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date79.
   *
   * @return  Date
   */
  public Date getClientDefinedDate79() {
    return clientDefinedDate79;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate8() {
    return clientDefinedDate8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date80.
   *
   * @return  Date
   */
  public Date getClientDefinedDate80() {
    return clientDefinedDate80;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date81.
   *
   * @return  Date
   */
  public Date getClientDefinedDate81() {
    return clientDefinedDate81;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date82.
   *
   * @return  Date
   */
  public Date getClientDefinedDate82() {
    return clientDefinedDate82;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date83.
   *
   * @return  Date
   */
  public Date getClientDefinedDate83() {
    return clientDefinedDate83;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date84.
   *
   * @return  Date
   */
  public Date getClientDefinedDate84() {
    return clientDefinedDate84;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date85.
   *
   * @return  Date
   */
  public Date getClientDefinedDate85() {
    return clientDefinedDate85;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date86.
   *
   * @return  Date
   */
  public Date getClientDefinedDate86() {
    return clientDefinedDate86;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date87.
   *
   * @return  Date
   */
  public Date getClientDefinedDate87() {
    return clientDefinedDate87;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date88.
   *
   * @return  Date
   */
  public Date getClientDefinedDate88() {
    return clientDefinedDate88;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date89.
   *
   * @return  Date
   */
  public Date getClientDefinedDate89() {
    return clientDefinedDate89;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Date.
   *
   * @return  Date.
   */
  public Date getClientDefinedDate9() {
    return clientDefinedDate9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date90.
   *
   * @return  Date
   */
  public Date getClientDefinedDate90() {
    return clientDefinedDate90;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date91.
   *
   * @return  Date
   */
  public Date getClientDefinedDate91() {
    return clientDefinedDate91;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date92.
   *
   * @return  Date
   */
  public Date getClientDefinedDate92() {
    return clientDefinedDate92;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date93.
   *
   * @return  Date
   */
  public Date getClientDefinedDate93() {
    return clientDefinedDate93;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date94.
   *
   * @return  Date
   */
  public Date getClientDefinedDate94() {
    return clientDefinedDate94;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date95.
   *
   * @return  Date
   */
  public Date getClientDefinedDate95() {
    return clientDefinedDate95;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date96.
   *
   * @return  Date
   */
  public Date getClientDefinedDate96() {
    return clientDefinedDate96;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date97.
   *
   * @return  Date
   */
  public Date getClientDefinedDate97() {
    return clientDefinedDate97;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date98.
   *
   * @return  Date
   */
  public Date getClientDefinedDate98() {
    return clientDefinedDate98;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date99.
   *
   * @return  Date
   */
  public Date getClientDefinedDate99() {
    return clientDefinedDate99;
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
   * setAccountExtensionDateId.
   *
   * @param  accountExtensionDateId  $param.type$
   */
  public void setAccountExtensionDateId(Long accountExtensionDateId) {
    this.accountExtensionDateId = accountExtensionDateId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate1.
   *
   * @param  clientDefinedDate1  $param.type$
   */
  public void setClientDefinedDate1(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate10.
   *
   * @param  clientDefinedDate10  $param.type$
   */
  public void setClientDefinedDate10(Date clientDefinedDate10) {
    this.clientDefinedDate10 = clientDefinedDate10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date100.
   *
   * @param  clientDefinedDate100  Date
   */
  public void setClientDefinedDate100(Date clientDefinedDate100) {
    this.clientDefinedDate100 = clientDefinedDate100;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate11.
   *
   * @param  clientDefinedDate11  $param.type$
   */
  public void setClientDefinedDate11(Date clientDefinedDate11) {
    this.clientDefinedDate11 = clientDefinedDate11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate12.
   *
   * @param  clientDefinedDate12  $param.type$
   */
  public void setClientDefinedDate12(Date clientDefinedDate12) {
    this.clientDefinedDate12 = clientDefinedDate12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate13.
   *
   * @param  clientDefinedDate13  $param.type$
   */
  public void setClientDefinedDate13(Date clientDefinedDate13) {
    this.clientDefinedDate13 = clientDefinedDate13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate14.
   *
   * @param  clientDefinedDate14  $param.type$
   */
  public void setClientDefinedDate14(Date clientDefinedDate14) {
    this.clientDefinedDate14 = clientDefinedDate14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate15.
   *
   * @param  clientDefinedDate15  $param.type$
   */
  public void setClientDefinedDate15(Date clientDefinedDate15) {
    this.clientDefinedDate15 = clientDefinedDate15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate16.
   *
   * @param  clientDefinedDate16  $param.type$
   */
  public void setClientDefinedDate16(Date clientDefinedDate16) {
    this.clientDefinedDate16 = clientDefinedDate16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate17.
   *
   * @param  clientDefinedDate17  $param.type$
   */
  public void setClientDefinedDate17(Date clientDefinedDate17) {
    this.clientDefinedDate17 = clientDefinedDate17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate18.
   *
   * @param  clientDefinedDate18  $param.type$
   */
  public void setClientDefinedDate18(Date clientDefinedDate18) {
    this.clientDefinedDate18 = clientDefinedDate18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate19.
   *
   * @param  clientDefinedDate19  $param.type$
   */
  public void setClientDefinedDate19(Date clientDefinedDate19) {
    this.clientDefinedDate19 = clientDefinedDate19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate2.
   *
   * @param  clientDefinedDate2  $param.type$
   */
  public void setClientDefinedDate2(Date clientDefinedDate2) {
    this.clientDefinedDate2 = clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate20.
   *
   * @param  clientDefinedDate20  $param.type$
   */
  public void setClientDefinedDate20(Date clientDefinedDate20) {
    this.clientDefinedDate20 = clientDefinedDate20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date21.
   *
   * @param  clientDefinedDate21  Date
   */
  public void setClientDefinedDate21(Date clientDefinedDate21) {
    this.clientDefinedDate21 = clientDefinedDate21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date22.
   *
   * @param  clientDefinedDate22  Date
   */
  public void setClientDefinedDate22(Date clientDefinedDate22) {
    this.clientDefinedDate22 = clientDefinedDate22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date23.
   *
   * @param  clientDefinedDate23  Date
   */
  public void setClientDefinedDate23(Date clientDefinedDate23) {
    this.clientDefinedDate23 = clientDefinedDate23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date24.
   *
   * @param  clientDefinedDate24  Date
   */
  public void setClientDefinedDate24(Date clientDefinedDate24) {
    this.clientDefinedDate24 = clientDefinedDate24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date25.
   *
   * @param  clientDefinedDate25  Date
   */
  public void setClientDefinedDate25(Date clientDefinedDate25) {
    this.clientDefinedDate25 = clientDefinedDate25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date26.
   *
   * @param  clientDefinedDate26  Date
   */
  public void setClientDefinedDate26(Date clientDefinedDate26) {
    this.clientDefinedDate26 = clientDefinedDate26;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date27.
   *
   * @param  clientDefinedDate27  Date
   */
  public void setClientDefinedDate27(Date clientDefinedDate27) {
    this.clientDefinedDate27 = clientDefinedDate27;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date28.
   *
   * @param  clientDefinedDate28  Date
   */
  public void setClientDefinedDate28(Date clientDefinedDate28) {
    this.clientDefinedDate28 = clientDefinedDate28;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date29.
   *
   * @param  clientDefinedDate29  Date
   */
  public void setClientDefinedDate29(Date clientDefinedDate29) {
    this.clientDefinedDate29 = clientDefinedDate29;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate3.
   *
   * @param  clientDefinedDate3  $param.type$
   */
  public void setClientDefinedDate3(Date clientDefinedDate3) {
    this.clientDefinedDate3 = clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date30.
   *
   * @param  clientDefinedDate30  Date
   */
  public void setClientDefinedDate30(Date clientDefinedDate30) {
    this.clientDefinedDate30 = clientDefinedDate30;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date31.
   *
   * @param  clientDefinedDate31  Date
   */
  public void setClientDefinedDate31(Date clientDefinedDate31) {
    this.clientDefinedDate31 = clientDefinedDate31;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date32.
   *
   * @param  clientDefinedDate32  Date
   */
  public void setClientDefinedDate32(Date clientDefinedDate32) {
    this.clientDefinedDate32 = clientDefinedDate32;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date33.
   *
   * @param  clientDefinedDate33  Date
   */
  public void setClientDefinedDate33(Date clientDefinedDate33) {
    this.clientDefinedDate33 = clientDefinedDate33;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date34.
   *
   * @param  clientDefinedDate34  Date
   */
  public void setClientDefinedDate34(Date clientDefinedDate34) {
    this.clientDefinedDate34 = clientDefinedDate34;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date35.
   *
   * @param  clientDefinedDate35  Date
   */
  public void setClientDefinedDate35(Date clientDefinedDate35) {
    this.clientDefinedDate35 = clientDefinedDate35;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date36.
   *
   * @param  clientDefinedDate36  Date
   */
  public void setClientDefinedDate36(Date clientDefinedDate36) {
    this.clientDefinedDate36 = clientDefinedDate36;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date37.
   *
   * @param  clientDefinedDate37  Date
   */
  public void setClientDefinedDate37(Date clientDefinedDate37) {
    this.clientDefinedDate37 = clientDefinedDate37;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date38.
   *
   * @param  clientDefinedDate38  Date
   */
  public void setClientDefinedDate38(Date clientDefinedDate38) {
    this.clientDefinedDate38 = clientDefinedDate38;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date39.
   *
   * @param  clientDefinedDate39  Date
   */
  public void setClientDefinedDate39(Date clientDefinedDate39) {
    this.clientDefinedDate39 = clientDefinedDate39;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate4.
   *
   * @param  clientDefinedDate4  $param.type$
   */
  public void setClientDefinedDate4(Date clientDefinedDate4) {
    this.clientDefinedDate4 = clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date40.
   *
   * @param  clientDefinedDate40  Date
   */
  public void setClientDefinedDate40(Date clientDefinedDate40) {
    this.clientDefinedDate40 = clientDefinedDate40;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date41.
   *
   * @param  clientDefinedDate41  Date
   */
  public void setClientDefinedDate41(Date clientDefinedDate41) {
    this.clientDefinedDate41 = clientDefinedDate41;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date42.
   *
   * @param  clientDefinedDate42  Date
   */
  public void setClientDefinedDate42(Date clientDefinedDate42) {
    this.clientDefinedDate42 = clientDefinedDate42;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date43.
   *
   * @param  clientDefinedDate43  Date
   */
  public void setClientDefinedDate43(Date clientDefinedDate43) {
    this.clientDefinedDate43 = clientDefinedDate43;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date44.
   *
   * @param  clientDefinedDate44  Date
   */
  public void setClientDefinedDate44(Date clientDefinedDate44) {
    this.clientDefinedDate44 = clientDefinedDate44;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date45.
   *
   * @param  clientDefinedDate45  Date
   */
  public void setClientDefinedDate45(Date clientDefinedDate45) {
    this.clientDefinedDate45 = clientDefinedDate45;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date46.
   *
   * @param  clientDefinedDate46  Date
   */
  public void setClientDefinedDate46(Date clientDefinedDate46) {
    this.clientDefinedDate46 = clientDefinedDate46;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date47.
   *
   * @param  clientDefinedDate47  Date
   */
  public void setClientDefinedDate47(Date clientDefinedDate47) {
    this.clientDefinedDate47 = clientDefinedDate47;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date48.
   *
   * @param  clientDefinedDate48  Date
   */
  public void setClientDefinedDate48(Date clientDefinedDate48) {
    this.clientDefinedDate48 = clientDefinedDate48;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date49.
   *
   * @param  clientDefinedDate49  Date
   */
  public void setClientDefinedDate49(Date clientDefinedDate49) {
    this.clientDefinedDate49 = clientDefinedDate49;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate5.
   *
   * @param  clientDefinedDate5  $param.type$
   */
  public void setClientDefinedDate5(Date clientDefinedDate5) {
    this.clientDefinedDate5 = clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date50.
   *
   * @param  clientDefinedDate50  Date
   */
  public void setClientDefinedDate50(Date clientDefinedDate50) {
    this.clientDefinedDate50 = clientDefinedDate50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date51.
   *
   * @param  clientDefinedDate51  Date
   */
  public void setClientDefinedDate51(Date clientDefinedDate51) {
    this.clientDefinedDate51 = clientDefinedDate51;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date52.
   *
   * @param  clientDefinedDate52  Date
   */
  public void setClientDefinedDate52(Date clientDefinedDate52) {
    this.clientDefinedDate52 = clientDefinedDate52;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date53.
   *
   * @param  clientDefinedDate53  Date
   */
  public void setClientDefinedDate53(Date clientDefinedDate53) {
    this.clientDefinedDate53 = clientDefinedDate53;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date54.
   *
   * @param  clientDefinedDate54  Date
   */
  public void setClientDefinedDate54(Date clientDefinedDate54) {
    this.clientDefinedDate54 = clientDefinedDate54;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date55.
   *
   * @param  clientDefinedDate55  Date
   */
  public void setClientDefinedDate55(Date clientDefinedDate55) {
    this.clientDefinedDate55 = clientDefinedDate55;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date56.
   *
   * @param  clientDefinedDate56  Date
   */
  public void setClientDefinedDate56(Date clientDefinedDate56) {
    this.clientDefinedDate56 = clientDefinedDate56;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date57.
   *
   * @param  clientDefinedDate57  Date
   */
  public void setClientDefinedDate57(Date clientDefinedDate57) {
    this.clientDefinedDate57 = clientDefinedDate57;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date58.
   *
   * @param  clientDefinedDate58  Date
   */
  public void setClientDefinedDate58(Date clientDefinedDate58) {
    this.clientDefinedDate58 = clientDefinedDate58;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date59.
   *
   * @param  clientDefinedDate59  Date
   */
  public void setClientDefinedDate59(Date clientDefinedDate59) {
    this.clientDefinedDate59 = clientDefinedDate59;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate6.
   *
   * @param  clientDefinedDate6  $param.type$
   */
  public void setClientDefinedDate6(Date clientDefinedDate6) {
    this.clientDefinedDate6 = clientDefinedDate6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date60.
   *
   * @param  clientDefinedDate60  Date
   */
  public void setClientDefinedDate60(Date clientDefinedDate60) {
    this.clientDefinedDate60 = clientDefinedDate60;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date61.
   *
   * @param  clientDefinedDate61  Date
   */
  public void setClientDefinedDate61(Date clientDefinedDate61) {
    this.clientDefinedDate61 = clientDefinedDate61;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date62.
   *
   * @param  clientDefinedDate62  Date
   */
  public void setClientDefinedDate62(Date clientDefinedDate62) {
    this.clientDefinedDate62 = clientDefinedDate62;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date63.
   *
   * @param  clientDefinedDate63  Date
   */
  public void setClientDefinedDate63(Date clientDefinedDate63) {
    this.clientDefinedDate63 = clientDefinedDate63;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date64.
   *
   * @param  clientDefinedDate64  Date
   */
  public void setClientDefinedDate64(Date clientDefinedDate64) {
    this.clientDefinedDate64 = clientDefinedDate64;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date65.
   *
   * @param  clientDefinedDate65  Date
   */
  public void setClientDefinedDate65(Date clientDefinedDate65) {
    this.clientDefinedDate65 = clientDefinedDate65;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date66.
   *
   * @param  clientDefinedDate66  Date
   */
  public void setClientDefinedDate66(Date clientDefinedDate66) {
    this.clientDefinedDate66 = clientDefinedDate66;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date67.
   *
   * @param  clientDefinedDate67  Date
   */
  public void setClientDefinedDate67(Date clientDefinedDate67) {
    this.clientDefinedDate67 = clientDefinedDate67;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date68.
   *
   * @param  clientDefinedDate68  Date
   */
  public void setClientDefinedDate68(Date clientDefinedDate68) {
    this.clientDefinedDate68 = clientDefinedDate68;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date69.
   *
   * @param  clientDefinedDate69  Date
   */
  public void setClientDefinedDate69(Date clientDefinedDate69) {
    this.clientDefinedDate69 = clientDefinedDate69;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate7.
   *
   * @param  clientDefinedDate7  $param.type$
   */
  public void setClientDefinedDate7(Date clientDefinedDate7) {
    this.clientDefinedDate7 = clientDefinedDate7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date70.
   *
   * @param  clientDefinedDate70  Date
   */
  public void setClientDefinedDate70(Date clientDefinedDate70) {
    this.clientDefinedDate70 = clientDefinedDate70;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date71.
   *
   * @param  clientDefinedDate71  Date
   */
  public void setClientDefinedDate71(Date clientDefinedDate71) {
    this.clientDefinedDate71 = clientDefinedDate71;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date72.
   *
   * @param  clientDefinedDate72  Date
   */
  public void setClientDefinedDate72(Date clientDefinedDate72) {
    this.clientDefinedDate72 = clientDefinedDate72;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date73.
   *
   * @param  clientDefinedDate73  Date
   */
  public void setClientDefinedDate73(Date clientDefinedDate73) {
    this.clientDefinedDate73 = clientDefinedDate73;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date74.
   *
   * @param  clientDefinedDate74  Date
   */
  public void setClientDefinedDate74(Date clientDefinedDate74) {
    this.clientDefinedDate74 = clientDefinedDate74;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date75.
   *
   * @param  clientDefinedDate75  Date
   */
  public void setClientDefinedDate75(Date clientDefinedDate75) {
    this.clientDefinedDate75 = clientDefinedDate75;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date76.
   *
   * @param  clientDefinedDate76  Date
   */
  public void setClientDefinedDate76(Date clientDefinedDate76) {
    this.clientDefinedDate76 = clientDefinedDate76;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date77.
   *
   * @param  clientDefinedDate77  Date
   */
  public void setClientDefinedDate77(Date clientDefinedDate77) {
    this.clientDefinedDate77 = clientDefinedDate77;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date78.
   *
   * @param  clientDefinedDate78  Date
   */
  public void setClientDefinedDate78(Date clientDefinedDate78) {
    this.clientDefinedDate78 = clientDefinedDate78;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date79.
   *
   * @param  clientDefinedDate79  Date
   */
  public void setClientDefinedDate79(Date clientDefinedDate79) {
    this.clientDefinedDate79 = clientDefinedDate79;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate8.
   *
   * @param  clientDefinedDate8  $param.type$
   */
  public void setClientDefinedDate8(Date clientDefinedDate8) {
    this.clientDefinedDate8 = clientDefinedDate8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date80.
   *
   * @param  clientDefinedDate80  Date
   */
  public void setClientDefinedDate80(Date clientDefinedDate80) {
    this.clientDefinedDate80 = clientDefinedDate80;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date81.
   *
   * @param  clientDefinedDate81  Date
   */
  public void setClientDefinedDate81(Date clientDefinedDate81) {
    this.clientDefinedDate81 = clientDefinedDate81;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date82.
   *
   * @param  clientDefinedDate82  Date
   */
  public void setClientDefinedDate82(Date clientDefinedDate82) {
    this.clientDefinedDate82 = clientDefinedDate82;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date83.
   *
   * @param  clientDefinedDate83  Date
   */
  public void setClientDefinedDate83(Date clientDefinedDate83) {
    this.clientDefinedDate83 = clientDefinedDate83;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date84.
   *
   * @param  clientDefinedDate84  Date
   */
  public void setClientDefinedDate84(Date clientDefinedDate84) {
    this.clientDefinedDate84 = clientDefinedDate84;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date85.
   *
   * @param  clientDefinedDate85  Date
   */
  public void setClientDefinedDate85(Date clientDefinedDate85) {
    this.clientDefinedDate85 = clientDefinedDate85;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date86.
   *
   * @param  clientDefinedDate86  Date
   */
  public void setClientDefinedDate86(Date clientDefinedDate86) {
    this.clientDefinedDate86 = clientDefinedDate86;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date87.
   *
   * @param  clientDefinedDate87  Date
   */
  public void setClientDefinedDate87(Date clientDefinedDate87) {
    this.clientDefinedDate87 = clientDefinedDate87;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date88.
   *
   * @param  clientDefinedDate88  Date
   */
  public void setClientDefinedDate88(Date clientDefinedDate88) {
    this.clientDefinedDate88 = clientDefinedDate88;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date89.
   *
   * @param  clientDefinedDate89  Date
   */
  public void setClientDefinedDate89(Date clientDefinedDate89) {
    this.clientDefinedDate89 = clientDefinedDate89;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDate9.
   *
   * @param  clientDefinedDate9  $param.type$
   */
  public void setClientDefinedDate9(Date clientDefinedDate9) {
    this.clientDefinedDate9 = clientDefinedDate9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date90.
   *
   * @param  clientDefinedDate90  Date
   */
  public void setClientDefinedDate90(Date clientDefinedDate90) {
    this.clientDefinedDate90 = clientDefinedDate90;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date91.
   *
   * @param  clientDefinedDate91  Date
   */
  public void setClientDefinedDate91(Date clientDefinedDate91) {
    this.clientDefinedDate91 = clientDefinedDate91;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date92.
   *
   * @param  clientDefinedDate92  Date
   */
  public void setClientDefinedDate92(Date clientDefinedDate92) {
    this.clientDefinedDate92 = clientDefinedDate92;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date93.
   *
   * @param  clientDefinedDate93  Date
   */
  public void setClientDefinedDate93(Date clientDefinedDate93) {
    this.clientDefinedDate93 = clientDefinedDate93;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date94.
   *
   * @param  clientDefinedDate94  Date
   */
  public void setClientDefinedDate94(Date clientDefinedDate94) {
    this.clientDefinedDate94 = clientDefinedDate94;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date95.
   *
   * @param  clientDefinedDate95  Date
   */
  public void setClientDefinedDate95(Date clientDefinedDate95) {
    this.clientDefinedDate95 = clientDefinedDate95;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date96.
   *
   * @param  clientDefinedDate96  Date
   */
  public void setClientDefinedDate96(Date clientDefinedDate96) {
    this.clientDefinedDate96 = clientDefinedDate96;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date97.
   *
   * @param  clientDefinedDate97  Date
   */
  public void setClientDefinedDate97(Date clientDefinedDate97) {
    this.clientDefinedDate97 = clientDefinedDate97;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date98.
   *
   * @param  clientDefinedDate98  Date
   */
  public void setClientDefinedDate98(Date clientDefinedDate98) {
    this.clientDefinedDate98 = clientDefinedDate98;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date99.
   *
   * @param  clientDefinedDate99  Date
   */
  public void setClientDefinedDate99(Date clientDefinedDate99) {
    this.clientDefinedDate99 = clientDefinedDate99;
  }

  public Date getClientDefinedDate101() {
    return clientDefinedDate101;
  }

  public void setClientDefinedDate101(Date clientDefinedDate101) {
    this.clientDefinedDate101 = clientDefinedDate101;
  }

  public Date getClientDefinedDate102() {
    return clientDefinedDate102;
  }

  public void setClientDefinedDate102(Date clientDefinedDate102) {
    this.clientDefinedDate102 = clientDefinedDate102;
  }

  public Date getClientDefinedDate103() {
    return clientDefinedDate103;
  }

  public void setClientDefinedDate103(Date clientDefinedDate103) {
    this.clientDefinedDate103 = clientDefinedDate103;
  }

  public Date getClientDefinedDate104() {
    return clientDefinedDate104;
  }

  public void setClientDefinedDate104(Date clientDefinedDate104) {
    this.clientDefinedDate104 = clientDefinedDate104;
  }

  public Date getClientDefinedDate105() {
    return clientDefinedDate105;
  }

  public void setClientDefinedDate105(Date clientDefinedDate105) {
    this.clientDefinedDate105 = clientDefinedDate105;
  }

  public Date getClientDefinedDate106() {
    return clientDefinedDate106;
  }

  public void setClientDefinedDate106(Date clientDefinedDate106) {
    this.clientDefinedDate106 = clientDefinedDate106;
  }

  public Date getClientDefinedDate107() {
    return clientDefinedDate107;
  }

  public void setClientDefinedDate107(Date clientDefinedDate107) {
    this.clientDefinedDate107 = clientDefinedDate107;
  }

  public Date getClientDefinedDate108() {
    return clientDefinedDate108;
  }

  public void setClientDefinedDate108(Date clientDefinedDate108) {
    this.clientDefinedDate108 = clientDefinedDate108;
  }

  public Date getClientDefinedDate109() {
    return clientDefinedDate109;
  }

  public void setClientDefinedDate109(Date clientDefinedDate109) {
    this.clientDefinedDate109 = clientDefinedDate109;
  }

  public Date getClientDefinedDate110() {
    return clientDefinedDate110;
  }

  public void setClientDefinedDate110(Date clientDefinedDate110) {
    this.clientDefinedDate110 = clientDefinedDate110;
  }

  public Date getClientDefinedDate111() {
    return clientDefinedDate111;
  }

  public void setClientDefinedDate111(Date clientDefinedDate111) {
    this.clientDefinedDate111 = clientDefinedDate111;
  }

  public Date getClientDefinedDate112() {
    return clientDefinedDate112;
  }

  public void setClientDefinedDate112(Date clientDefinedDate112) {
    this.clientDefinedDate112 = clientDefinedDate112;
  }

  public Date getClientDefinedDate113() {
    return clientDefinedDate113;
  }

  public void setClientDefinedDate113(Date clientDefinedDate113) {
    this.clientDefinedDate113 = clientDefinedDate113;
  }

  public Date getClientDefinedDate114() {
    return clientDefinedDate114;
  }

  public void setClientDefinedDate114(Date clientDefinedDate114) {
    this.clientDefinedDate114 = clientDefinedDate114;
  }

  public Date getClientDefinedDate115() {
    return clientDefinedDate115;
  }

  public void setClientDefinedDate115(Date clientDefinedDate115) {
    this.clientDefinedDate115 = clientDefinedDate115;
  }

  public Date getClientDefinedDate116() {
    return clientDefinedDate116;
  }

  public void setClientDefinedDate116(Date clientDefinedDate116) {
    this.clientDefinedDate116 = clientDefinedDate116;
  }

  public Date getClientDefinedDate117() {
    return clientDefinedDate117;
  }

  public void setClientDefinedDate117(Date clientDefinedDate117) {
    this.clientDefinedDate117 = clientDefinedDate117;
  }

  public Date getClientDefinedDate118() {
    return clientDefinedDate118;
  }

  public void setClientDefinedDate118(Date clientDefinedDate118) {
    this.clientDefinedDate118 = clientDefinedDate118;
  }

  public Date getClientDefinedDate119() {
    return clientDefinedDate119;
  }

  public void setClientDefinedDate119(Date clientDefinedDate119) {
    this.clientDefinedDate119 = clientDefinedDate119;
  }

  public Date getClientDefinedDate120() {
    return clientDefinedDate120;
  }

  public void setClientDefinedDate120(Date clientDefinedDate120) {
    this.clientDefinedDate120 = clientDefinedDate120;
  }

  public Date getClientDefinedDate121() {
    return clientDefinedDate121;
  }

  public void setClientDefinedDate121(Date clientDefinedDate121) {
    this.clientDefinedDate121 = clientDefinedDate121;
  }

  public Date getClientDefinedDate122() {
    return clientDefinedDate122;
  }

  public void setClientDefinedDate122(Date clientDefinedDate122) {
    this.clientDefinedDate122 = clientDefinedDate122;
  }

  public Date getClientDefinedDate123() {
    return clientDefinedDate123;
  }

  public void setClientDefinedDate123(Date clientDefinedDate123) {
    this.clientDefinedDate123 = clientDefinedDate123;
  }

  public Date getClientDefinedDate124() {
    return clientDefinedDate124;
  }

  public void setClientDefinedDate124(Date clientDefinedDate124) {
    this.clientDefinedDate124 = clientDefinedDate124;
  }

  public Date getClientDefinedDate125() {
    return clientDefinedDate125;
  }

  public void setClientDefinedDate125(Date clientDefinedDate125) {
    this.clientDefinedDate125 = clientDefinedDate125;
  }

  public Date getClientDefinedDate126() {
    return clientDefinedDate126;
  }

  public void setClientDefinedDate126(Date clientDefinedDate126) {
    this.clientDefinedDate126 = clientDefinedDate126;
  }

  public Date getClientDefinedDate127() {
    return clientDefinedDate127;
  }

  public void setClientDefinedDate127(Date clientDefinedDate127) {
    this.clientDefinedDate127 = clientDefinedDate127;
  }

  public Date getClientDefinedDate128() {
    return clientDefinedDate128;
  }

  public void setClientDefinedDate128(Date clientDefinedDate128) {
    this.clientDefinedDate128 = clientDefinedDate128;
  }

  public Date getClientDefinedDate129() {
    return clientDefinedDate129;
  }

  public void setClientDefinedDate129(Date clientDefinedDate129) {
    this.clientDefinedDate129 = clientDefinedDate129;
  }

  public Date getClientDefinedDate130() {
    return clientDefinedDate130;
  }

  public void setClientDefinedDate130(Date clientDefinedDate130) {
    this.clientDefinedDate130 = clientDefinedDate130;
  }

  public Date getClientDefinedDate131() {
    return clientDefinedDate131;
  }

  public void setClientDefinedDate131(Date clientDefinedDate131) {
    this.clientDefinedDate131 = clientDefinedDate131;
  }

  public Date getClientDefinedDate132() {
    return clientDefinedDate132;
  }

  public void setClientDefinedDate132(Date clientDefinedDate132) {
    this.clientDefinedDate132 = clientDefinedDate132;
  }

  public Date getClientDefinedDate133() {
    return clientDefinedDate133;
  }

  public void setClientDefinedDate133(Date clientDefinedDate133) {
    this.clientDefinedDate133 = clientDefinedDate133;
  }

  public Date getClientDefinedDate134() {
    return clientDefinedDate134;
  }

  public void setClientDefinedDate134(Date clientDefinedDate134) {
    this.clientDefinedDate134 = clientDefinedDate134;
  }

  public Date getClientDefinedDate135() {
    return clientDefinedDate135;
  }

  public void setClientDefinedDate135(Date clientDefinedDate135) {
    this.clientDefinedDate135 = clientDefinedDate135;
  }

  public Date getClientDefinedDate136() {
    return clientDefinedDate136;
  }

  public void setClientDefinedDate136(Date clientDefinedDate136) {
    this.clientDefinedDate136 = clientDefinedDate136;
  }

  public Date getClientDefinedDate137() {
    return clientDefinedDate137;
  }

  public void setClientDefinedDate137(Date clientDefinedDate137) {
    this.clientDefinedDate137 = clientDefinedDate137;
  }

  public Date getClientDefinedDate138() {
    return clientDefinedDate138;
  }

  public void setClientDefinedDate138(Date clientDefinedDate138) {
    this.clientDefinedDate138 = clientDefinedDate138;
  }

  public Date getClientDefinedDate139() {
    return clientDefinedDate139;
  }

  public void setClientDefinedDate139(Date clientDefinedDate139) {
    this.clientDefinedDate139 = clientDefinedDate139;
  }

  public Date getClientDefinedDate140() {
    return clientDefinedDate140;
  }

  public void setClientDefinedDate140(Date clientDefinedDate140) {
    this.clientDefinedDate140 = clientDefinedDate140;
  }

  public Date getClientDefinedDate141() {
    return clientDefinedDate141;
  }

  public void setClientDefinedDate141(Date clientDefinedDate141) {
    this.clientDefinedDate141 = clientDefinedDate141;
  }

  public Date getClientDefinedDate142() {
    return clientDefinedDate142;
  }

  public void setClientDefinedDate142(Date clientDefinedDate142) {
    this.clientDefinedDate142 = clientDefinedDate142;
  }

  public Date getClientDefinedDate143() {
    return clientDefinedDate143;
  }

  public void setClientDefinedDate143(Date clientDefinedDate143) {
    this.clientDefinedDate143 = clientDefinedDate143;
  }

  public Date getClientDefinedDate144() {
    return clientDefinedDate144;
  }

  public void setClientDefinedDate144(Date clientDefinedDate144) {
    this.clientDefinedDate144 = clientDefinedDate144;
  }

  public Date getClientDefinedDate145() {
    return clientDefinedDate145;
  }

  public void setClientDefinedDate145(Date clientDefinedDate145) {
    this.clientDefinedDate145 = clientDefinedDate145;
  }

  public Date getClientDefinedDate146() {
    return clientDefinedDate146;
  }

  public void setClientDefinedDate146(Date clientDefinedDate146) {
    this.clientDefinedDate146 = clientDefinedDate146;
  }

  public Date getClientDefinedDate147() {
    return clientDefinedDate147;
  }

  public void setClientDefinedDate147(Date clientDefinedDate147) {
    this.clientDefinedDate147 = clientDefinedDate147;
  }

  public Date getClientDefinedDate148() {
    return clientDefinedDate148;
  }

  public void setClientDefinedDate148(Date clientDefinedDate148) {
    this.clientDefinedDate148 = clientDefinedDate148;
  }

  public Date getClientDefinedDate149() {
    return clientDefinedDate149;
  }

  public void setClientDefinedDate149(Date clientDefinedDate149) {
    this.clientDefinedDate149 = clientDefinedDate149;
  }

  public Date getClientDefinedDate150() {
    return clientDefinedDate150;
  }

  public void setClientDefinedDate150(Date clientDefinedDate150) {
    this.clientDefinedDate150 = clientDefinedDate150;
  }
} // end class AccountExtensionDate
