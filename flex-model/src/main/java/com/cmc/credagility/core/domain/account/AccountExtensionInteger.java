package com.cmc.credagility.core.domain.account;

import com.cmc.credagility.core.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  07/24/2015 17:18
 */
@Entity
@Table(name = "AccountExtensionInteger")
public class AccountExtensionInteger extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7098157900902637779L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "accountExtensionIntegerId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long accountExtensionIntegerId;


  @JoinColumn(
    name   = "accountNum",
    unique = true
  )
  @ManyToOne private Account account;

  @Column(name = "clientDefinedBigInt1")
  private Long clientDefinedBigInt1;

  @Column(name = "clientDefinedBigInt2")
  private Long clientDefinedBigInt2;

  @Column(name = "clientDefinedBigInt3")
  private Long clientDefinedBigInt3;

  @Column(name = "clientDefinedBigInt4")
  private Long clientDefinedBigInt4;


  @Column(
    name   = "clientDefinedInteger1",
    length = 9
  )
  private Integer clientDefinedInteger1;

  @Column(
    name   = "clientDefinedInteger10",
    length = 9
  )
  private Integer clientDefinedInteger10;
  @Column(
    name   = "clientDefinedInteger100",
    length = 9
  )
  private Integer clientDefinedInteger100;
  @Column(
    name   = "clientDefinedInteger11",
    length = 9
  )
  private Integer clientDefinedInteger11;
  @Column(
    name   = "clientDefinedInteger12",
    length = 9
  )
  private Integer clientDefinedInteger12;
  @Column(
    name   = "clientDefinedInteger13",
    length = 9
  )
  private Integer clientDefinedInteger13;
  @Column(
    name   = "clientDefinedInteger14",
    length = 9
  )
  private Integer clientDefinedInteger14;
  @Column(
    name   = "clientDefinedInteger15",
    length = 9
  )
  private Integer clientDefinedInteger15;
  @Column(
    name   = "clientDefinedInteger16",
    length = 9
  )
  private Integer clientDefinedInteger16;
  @Column(
    name   = "clientDefinedInteger17",
    length = 9
  )
  private Integer clientDefinedInteger17;
  @Column(
    name   = "clientDefinedInteger18",
    length = 9
  )
  private Integer clientDefinedInteger18;
  @Column(
    name   = "clientDefinedInteger19",
    length = 9
  )
  private Integer clientDefinedInteger19;
  @Column(
    name   = "clientDefinedInteger2",
    length = 9
  )
  private Integer clientDefinedInteger2;
  @Column(
    name   = "clientDefinedInteger20",
    length = 9
  )
  private Integer clientDefinedInteger20;

  @Column(
    name   = "clientDefinedInteger21",
    length = 9
  )
  private Integer clientDefinedInteger21;
  @Column(
    name   = "clientDefinedInteger22",
    length = 9
  )
  private Integer clientDefinedInteger22;
  @Column(
    name   = "clientDefinedInteger23",
    length = 9
  )
  private Integer clientDefinedInteger23;
  @Column(
    name   = "clientDefinedInteger24",
    length = 9
  )
  private Integer clientDefinedInteger24;
  @Column(
    name   = "clientDefinedInteger25",
    length = 9
  )
  private Integer clientDefinedInteger25;
  @Column(
    name   = "clientDefinedInteger26",
    length = 9
  )
  private Integer clientDefinedInteger26;
  @Column(
    name   = "clientDefinedInteger27",
    length = 9
  )
  private Integer clientDefinedInteger27;
  @Column(
    name   = "clientDefinedInteger28",
    length = 9
  )
  private Integer clientDefinedInteger28;
  @Column(
    name   = "clientDefinedInteger29",
    length = 9
  )
  private Integer clientDefinedInteger29;

  @Column(
    name   = "clientDefinedInteger3",
    length = 9
  )
  private Integer clientDefinedInteger3;
  @Column(
    name   = "clientDefinedInteger30",
    length = 9
  )
  private Integer clientDefinedInteger30;
  @Column(
    name   = "clientDefinedInteger31",
    length = 9
  )
  private Integer clientDefinedInteger31;
  @Column(
    name   = "clientDefinedInteger32",
    length = 9
  )
  private Integer clientDefinedInteger32;
  @Column(
    name   = "clientDefinedInteger33",
    length = 9
  )
  private Integer clientDefinedInteger33;
  @Column(
    name   = "clientDefinedInteger34",
    length = 9
  )
  private Integer clientDefinedInteger34;
  @Column(
    name   = "clientDefinedInteger35",
    length = 9
  )
  private Integer clientDefinedInteger35;
  @Column(
    name   = "clientDefinedInteger36",
    length = 9
  )
  private Integer clientDefinedInteger36;
  @Column(
    name   = "clientDefinedInteger37",
    length = 9
  )
  private Integer clientDefinedInteger37;
  @Column(
    name   = "clientDefinedInteger38",
    length = 9
  )
  private Integer clientDefinedInteger38;
  @Column(
    name   = "clientDefinedInteger39",
    length = 9
  )
  private Integer clientDefinedInteger39;
  @Column(
    name   = "clientDefinedInteger4",
    length = 9
  )
  private Integer clientDefinedInteger4;

  @Column(
    name   = "clientDefinedInteger40",
    length = 9
  )
  private Integer clientDefinedInteger40;
  @Column(
    name   = "clientDefinedInteger41",
    length = 9
  )
  private Integer clientDefinedInteger41;
  @Column(
    name   = "clientDefinedInteger42",
    length = 9
  )
  private Integer clientDefinedInteger42;
  @Column(
    name   = "clientDefinedInteger43",
    length = 9
  )
  private Integer clientDefinedInteger43;
  @Column(
    name   = "clientDefinedInteger44",
    length = 9
  )
  private Integer clientDefinedInteger44;
  @Column(
    name   = "clientDefinedInteger45",
    length = 9
  )
  private Integer clientDefinedInteger45;
  @Column(
    name   = "clientDefinedInteger46",
    length = 9
  )
  private Integer clientDefinedInteger46;
  @Column(
    name   = "clientDefinedInteger47",
    length = 9
  )
  private Integer clientDefinedInteger47;
  @Column(
    name   = "clientDefinedInteger48",
    length = 9
  )
  private Integer clientDefinedInteger48;
  @Column(
    name   = "clientDefinedInteger49",
    length = 9
  )
  private Integer clientDefinedInteger49;

  @Column(
    name   = "clientDefinedInteger5",
    length = 9
  )
  private Integer clientDefinedInteger5;
  @Column(
    name   = "clientDefinedInteger50",
    length = 9
  )
  private Integer clientDefinedInteger50;
  @Column(
    name   = "clientDefinedInteger51",
    length = 9
  )
  private Integer clientDefinedInteger51;
  @Column(
    name   = "clientDefinedInteger52",
    length = 9
  )
  private Integer clientDefinedInteger52;
  @Column(
    name   = "clientDefinedInteger53",
    length = 9
  )
  private Integer clientDefinedInteger53;
  @Column(
    name   = "clientDefinedInteger54",
    length = 9
  )
  private Integer clientDefinedInteger54;
  @Column(
    name   = "clientDefinedInteger55",
    length = 9
  )
  private Integer clientDefinedInteger55;
  @Column(
    name   = "clientDefinedInteger56",
    length = 9
  )
  private Integer clientDefinedInteger56;
  @Column(
    name   = "clientDefinedInteger57",
    length = 9
  )
  private Integer clientDefinedInteger57;
  @Column(
    name   = "clientDefinedInteger58",
    length = 9
  )
  private Integer clientDefinedInteger58;
  @Column(
    name   = "clientDefinedInteger59",
    length = 9
  )
  private Integer clientDefinedInteger59;
  @Column(
    name   = "clientDefinedInteger6",
    length = 9
  )
  private Integer clientDefinedInteger6;

  @Column(
    name   = "clientDefinedInteger60",
    length = 9
  )
  private Integer clientDefinedInteger60;
  @Column(
    name   = "clientDefinedInteger61",
    length = 9
  )
  private Integer clientDefinedInteger61;
  @Column(
    name   = "clientDefinedInteger62",
    length = 9
  )
  private Integer clientDefinedInteger62;
  @Column(
    name   = "clientDefinedInteger63",
    length = 9
  )
  private Integer clientDefinedInteger63;
  @Column(
    name   = "clientDefinedInteger64",
    length = 9
  )
  private Integer clientDefinedInteger64;
  @Column(
    name   = "clientDefinedInteger65",
    length = 9
  )
  private Integer clientDefinedInteger65;
  @Column(
    name   = "clientDefinedInteger66",
    length = 9
  )
  private Integer clientDefinedInteger66;
  @Column(
    name   = "clientDefinedInteger67",
    length = 9
  )
  private Integer clientDefinedInteger67;
  @Column(
    name   = "clientDefinedInteger68",
    length = 9
  )
  private Integer clientDefinedInteger68;
  @Column(
    name   = "clientDefinedInteger69",
    length = 9
  )
  private Integer clientDefinedInteger69;
  @Column(
    name   = "clientDefinedInteger7",
    length = 9
  )
  private Integer clientDefinedInteger7;

  @Column(
    name   = "clientDefinedInteger70",
    length = 9
  )
  private Integer clientDefinedInteger70;
  @Column(
    name   = "clientDefinedInteger71",
    length = 9
  )
  private Integer clientDefinedInteger71;
  @Column(
    name   = "clientDefinedInteger72",
    length = 9
  )
  private Integer clientDefinedInteger72;
  @Column(
    name   = "clientDefinedInteger73",
    length = 9
  )
  private Integer clientDefinedInteger73;
  @Column(
    name   = "clientDefinedInteger74",
    length = 9
  )
  private Integer clientDefinedInteger74;
  @Column(
    name   = "clientDefinedInteger75",
    length = 9
  )
  private Integer clientDefinedInteger75;
  @Column(
    name   = "clientDefinedInteger76",
    length = 9
  )
  private Integer clientDefinedInteger76;
  @Column(
    name   = "clientDefinedInteger77",
    length = 9
  )
  private Integer clientDefinedInteger77;
  @Column(
    name   = "clientDefinedInteger78",
    length = 9
  )
  private Integer clientDefinedInteger78;
  @Column(
    name   = "clientDefinedInteger79",
    length = 9
  )
  private Integer clientDefinedInteger79;
  @Column(
    name   = "clientDefinedInteger8",
    length = 9
  )
  private Integer clientDefinedInteger8;

  @Column(
    name   = "clientDefinedInteger80",
    length = 9
  )
  private Integer clientDefinedInteger80;
  @Column(
    name   = "clientDefinedInteger81",
    length = 9
  )
  private Integer clientDefinedInteger81;
  @Column(
    name   = "clientDefinedInteger82",
    length = 9
  )
  private Integer clientDefinedInteger82;
  @Column(
    name   = "clientDefinedInteger83",
    length = 9
  )
  private Integer clientDefinedInteger83;
  @Column(
    name   = "clientDefinedInteger84",
    length = 9
  )
  private Integer clientDefinedInteger84;
  @Column(
    name   = "clientDefinedInteger85",
    length = 9
  )
  private Integer clientDefinedInteger85;
  @Column(
    name   = "clientDefinedInteger86",
    length = 9
  )
  private Integer clientDefinedInteger86;
  @Column(
    name   = "clientDefinedInteger87",
    length = 9
  )
  private Integer clientDefinedInteger87;
  @Column(
    name   = "clientDefinedInteger88",
    length = 9
  )
  private Integer clientDefinedInteger88;
  @Column(
    name   = "clientDefinedInteger89",
    length = 9
  )
  private Integer clientDefinedInteger89;
  @Column(
    name   = "clientDefinedInteger9",
    length = 9
  )
  private Integer clientDefinedInteger9;

  @Column(
    name   = "clientDefinedInteger90",
    length = 9
  )
  private Integer clientDefinedInteger90;
  @Column(
    name   = "clientDefinedInteger91",
    length = 9
  )
  private Integer clientDefinedInteger91;
  @Column(
    name   = "clientDefinedInteger92",
    length = 9
  )
  private Integer clientDefinedInteger92;
  @Column(
    name   = "clientDefinedInteger93",
    length = 9
  )
  private Integer clientDefinedInteger93;
  @Column(
    name   = "clientDefinedInteger94",
    length = 9
  )
  private Integer clientDefinedInteger94;
  @Column(
    name   = "clientDefinedInteger95",
    length = 9
  )
  private Integer clientDefinedInteger95;
  @Column(
    name   = "clientDefinedInteger96",
    length = 9
  )
  private Integer clientDefinedInteger96;
  @Column(
    name   = "clientDefinedInteger97",
    length = 9
  )
  private Integer clientDefinedInteger97;
  @Column(
    name   = "clientDefinedInteger98",
    length = 9
  )
  private Integer clientDefinedInteger98;
  @Column(
    name   = "clientDefinedInteger99",
    length = 9
  )
  private Integer clientDefinedInteger99;

  @Column(
          name = "clientDefinedInteger101",
          length = 9
  )
  private Integer clientDefinedInteger101;
  @Column(
          name = "clientDefinedInteger102",
          length = 9
  )
  private Integer clientDefinedInteger102;
  @Column(
          name = "clientDefinedInteger103",
          length = 9
  )
  private Integer clientDefinedInteger103;
  @Column(
          name = "clientDefinedInteger104",
          length = 9
  )
  private Integer clientDefinedInteger104;
  @Column(
          name = "clientDefinedInteger105",
          length = 9
  )
  private Integer clientDefinedInteger105;
  @Column(
          name = "clientDefinedInteger106",
          length = 9
  )
  private Integer clientDefinedInteger106;
  @Column(
          name = "clientDefinedInteger107",
          length = 9
  )
  private Integer clientDefinedInteger107;
  @Column(
          name = "clientDefinedInteger108",
          length = 9
  )
  private Integer clientDefinedInteger108;
  @Column(
          name = "clientDefinedInteger109",
          length = 9
  )
  private Integer clientDefinedInteger109;
  @Column(
          name = "clientDefinedInteger110",
          length = 9
  )
  private Integer clientDefinedInteger110;
  @Column(
          name = "clientDefinedInteger111",
          length = 9
  )
  private Integer clientDefinedInteger111;
  @Column(
          name = "clientDefinedInteger112",
          length = 9
  )
  private Integer clientDefinedInteger112;
  @Column(
          name = "clientDefinedInteger113",
          length = 9
  )
  private Integer clientDefinedInteger113;
  @Column(
          name = "clientDefinedInteger114",
          length = 9
  )
  private Integer clientDefinedInteger114;
  @Column(
          name = "clientDefinedInteger115",
          length = 9
  )
  private Integer clientDefinedInteger115;
  @Column(
          name = "clientDefinedInteger116",
          length = 9
  )
  private Integer clientDefinedInteger116;
  @Column(
          name = "clientDefinedInteger117",
          length = 9
  )
  private Integer clientDefinedInteger117;
  @Column(
          name = "clientDefinedInteger118",
          length = 9
  )
  private Integer clientDefinedInteger118;
  @Column(
          name = "clientDefinedInteger119",
          length = 9
  )
  private Integer clientDefinedInteger119;
  @Column(
          name = "clientDefinedInteger120",
          length = 9
  )
  private Integer clientDefinedInteger120;
  @Column(
          name = "clientDefinedInteger121",
          length = 9
  )
  private Integer clientDefinedInteger121;
  @Column(
          name = "clientDefinedInteger122",
          length = 9
  )
  private Integer clientDefinedInteger122;
  @Column(
          name = "clientDefinedInteger123",
          length = 9
  )
  private Integer clientDefinedInteger123;
  @Column(
          name = "clientDefinedInteger124",
          length = 9
  )
  private Integer clientDefinedInteger124;
  @Column(
          name = "clientDefinedInteger125",
          length = 9
  )
  private Integer clientDefinedInteger125;
  @Column(
          name = "clientDefinedInteger126",
          length = 9
  )
  private Integer clientDefinedInteger126;
  @Column(
          name = "clientDefinedInteger127",
          length = 9
  )
  private Integer clientDefinedInteger127;
  @Column(
          name = "clientDefinedInteger128",
          length = 9
  )
  private Integer clientDefinedInteger128;
  @Column(
          name = "clientDefinedInteger129",
          length = 9
  )
  private Integer clientDefinedInteger129;
  @Column(
          name = "clientDefinedInteger130",
          length = 9
  )
  private Integer clientDefinedInteger130;
  @Column(
          name = "clientDefinedInteger131",
          length = 9
  )
  private Integer clientDefinedInteger131;
  @Column(
          name = "clientDefinedInteger132",
          length = 9
  )
  private Integer clientDefinedInteger132;
  @Column(
          name = "clientDefinedInteger133",
          length = 9
  )
  private Integer clientDefinedInteger133;
  @Column(
          name = "clientDefinedInteger134",
          length = 9
  )
  private Integer clientDefinedInteger134;
  @Column(
          name = "clientDefinedInteger135",
          length = 9
  )
  private Integer clientDefinedInteger135;
  @Column(
          name = "clientDefinedInteger136",
          length = 9
  )
  private Integer clientDefinedInteger136;
  @Column(
          name = "clientDefinedInteger137",
          length = 9
  )
  private Integer clientDefinedInteger137;
  @Column(
          name = "clientDefinedInteger138",
          length = 9
  )
  private Integer clientDefinedInteger138;
  @Column(
          name = "clientDefinedInteger139",
          length = 9
  )
  private Integer clientDefinedInteger139;
  @Column(
          name = "clientDefinedInteger140",
          length = 9
  )
  private Integer clientDefinedInteger140;
  @Column(
          name = "clientDefinedInteger141",
          length = 9
  )
  private Integer clientDefinedInteger141;
  @Column(
          name = "clientDefinedInteger142",
          length = 9
  )
  private Integer clientDefinedInteger142;
  @Column(
          name = "clientDefinedInteger143",
          length = 9
  )
  private Integer clientDefinedInteger143;
  @Column(
          name = "clientDefinedInteger144",
          length = 9
  )
  private Integer clientDefinedInteger144;
  @Column(
          name = "clientDefinedInteger145",
          length = 9
  )
  private Integer clientDefinedInteger145;
  @Column(
          name = "clientDefinedInteger146",
          length = 9
  )
  private Integer clientDefinedInteger146;
  @Column(
          name = "clientDefinedInteger147",
          length = 9
  )
  private Integer clientDefinedInteger147;
  @Column(
          name = "clientDefinedInteger148",
          length = 9
  )
  private Integer clientDefinedInteger148;
  @Column(
          name = "clientDefinedInteger149",
          length = 9
  )
  private Integer clientDefinedInteger149;
  @Column(
          name = "clientDefinedInteger150",
          length = 9
  )
  private Integer clientDefinedInteger150;


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
  public Long getAccountExtensionIntegerId() {
    return accountExtensionIntegerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined big int1.
   *
   * @return  Long
   */
  public Long getClientDefinedBigInt1() {
    return clientDefinedBigInt1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined big int2.
   *
   * @return  Long
   */
  public Long getClientDefinedBigInt2() {
    return clientDefinedBigInt2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined big int3.
   *
   * @return  Long
   */
  public Long getClientDefinedBigInt3() {
    return clientDefinedBigInt3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined big int4.
   *
   * @return  Long
   */
  public Long getClientDefinedBigInt4() {
    return clientDefinedBigInt4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger1() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger10() {
    return clientDefinedInteger10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer100.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger100() {
    return clientDefinedInteger100;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger11() {
    return clientDefinedInteger11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger12() {
    return clientDefinedInteger12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger13() {
    return clientDefinedInteger13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger14() {
    return clientDefinedInteger14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger15() {
    return clientDefinedInteger15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger16() {
    return clientDefinedInteger16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger17() {
    return clientDefinedInteger17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger18() {
    return clientDefinedInteger18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger19() {
    return clientDefinedInteger19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger2() {
    return clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger20() {
    return clientDefinedInteger20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer21.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger21() {
    return clientDefinedInteger21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer22.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger22() {
    return clientDefinedInteger22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer23.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger23() {
    return clientDefinedInteger23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer24.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger24() {
    return clientDefinedInteger24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer25.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger25() {
    return clientDefinedInteger25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer26.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger26() {
    return clientDefinedInteger26;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer27.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger27() {
    return clientDefinedInteger27;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer28.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger28() {
    return clientDefinedInteger28;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer29.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger29() {
    return clientDefinedInteger29;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger3() {
    return clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer30.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger30() {
    return clientDefinedInteger30;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer31.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger31() {
    return clientDefinedInteger31;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer32.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger32() {
    return clientDefinedInteger32;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer33.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger33() {
    return clientDefinedInteger33;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer34.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger34() {
    return clientDefinedInteger34;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer35.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger35() {
    return clientDefinedInteger35;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer36.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger36() {
    return clientDefinedInteger36;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer37.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger37() {
    return clientDefinedInteger37;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer38.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger38() {
    return clientDefinedInteger38;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer39.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger39() {
    return clientDefinedInteger39;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger4() {
    return clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer40.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger40() {
    return clientDefinedInteger40;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer41.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger41() {
    return clientDefinedInteger41;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer42.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger42() {
    return clientDefinedInteger42;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer43.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger43() {
    return clientDefinedInteger43;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer44.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger44() {
    return clientDefinedInteger44;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer45.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger45() {
    return clientDefinedInteger45;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer46.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger46() {
    return clientDefinedInteger46;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer47.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger47() {
    return clientDefinedInteger47;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer48.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger48() {
    return clientDefinedInteger48;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer49.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger49() {
    return clientDefinedInteger49;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger5() {
    return clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer50.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger50() {
    return clientDefinedInteger50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer51.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger51() {
    return clientDefinedInteger51;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer52.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger52() {
    return clientDefinedInteger52;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer53.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger53() {
    return clientDefinedInteger53;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer54.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger54() {
    return clientDefinedInteger54;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer55.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger55() {
    return clientDefinedInteger55;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer56.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger56() {
    return clientDefinedInteger56;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer57.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger57() {
    return clientDefinedInteger57;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer58.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger58() {
    return clientDefinedInteger58;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer59.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger59() {
    return clientDefinedInteger59;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger6() {
    return clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer60.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger60() {
    return clientDefinedInteger60;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer61.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger61() {
    return clientDefinedInteger61;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer62.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger62() {
    return clientDefinedInteger62;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer63.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger63() {
    return clientDefinedInteger63;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer64.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger64() {
    return clientDefinedInteger64;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer65.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger65() {
    return clientDefinedInteger65;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer66.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger66() {
    return clientDefinedInteger66;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer67.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger67() {
    return clientDefinedInteger67;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer68.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger68() {
    return clientDefinedInteger68;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer69.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger69() {
    return clientDefinedInteger69;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger7() {
    return clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer70.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger70() {
    return clientDefinedInteger70;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer71.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger71() {
    return clientDefinedInteger71;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer72.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger72() {
    return clientDefinedInteger72;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer73.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger73() {
    return clientDefinedInteger73;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer74.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger74() {
    return clientDefinedInteger74;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer75.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger75() {
    return clientDefinedInteger75;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer76.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger76() {
    return clientDefinedInteger76;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer77.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger77() {
    return clientDefinedInteger77;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer78.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger78() {
    return clientDefinedInteger78;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer79.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger79() {
    return clientDefinedInteger79;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger8() {
    return clientDefinedInteger8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer80.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger80() {
    return clientDefinedInteger80;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer81.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger81() {
    return clientDefinedInteger81;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer82.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger82() {
    return clientDefinedInteger82;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer83.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger83() {
    return clientDefinedInteger83;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer84.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger84() {
    return clientDefinedInteger84;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer85.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger85() {
    return clientDefinedInteger85;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer86.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger86() {
    return clientDefinedInteger86;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer87.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger87() {
    return clientDefinedInteger87;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer88.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger88() {
    return clientDefinedInteger88;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer89.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger89() {
    return clientDefinedInteger89;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getClientDefinedInteger9() {
    return clientDefinedInteger9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer90.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger90() {
    return clientDefinedInteger90;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer91.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger91() {
    return clientDefinedInteger91;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer92.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger92() {
    return clientDefinedInteger92;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer93.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger93() {
    return clientDefinedInteger93;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer94.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger94() {
    return clientDefinedInteger94;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer95.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger95() {
    return clientDefinedInteger95;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer96.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger96() {
    return clientDefinedInteger96;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer97.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger97() {
    return clientDefinedInteger97;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer98.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger98() {
    return clientDefinedInteger98;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer99.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger99() {
    return clientDefinedInteger99;
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
   * setAccountExtensionIntegerId.
   *
   * @param  accountExtensionIntegerId  $param.type$
   */
  public void setAccountExtensionIntegerId(Long accountExtensionIntegerId) {
    this.accountExtensionIntegerId = accountExtensionIntegerId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined big int1.
   *
   * @param  clientDefinedBigInt1  Long
   */
  public void setClientDefinedBigInt1(Long clientDefinedBigInt1) {
    this.clientDefinedBigInt1 = clientDefinedBigInt1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined big int2.
   *
   * @param  clientDefinedBigInt2  Long
   */
  public void setClientDefinedBigInt2(Long clientDefinedBigInt2) {
    this.clientDefinedBigInt2 = clientDefinedBigInt2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined big int3.
   *
   * @param  clientDefinedBigInt3  Long
   */
  public void setClientDefinedBigInt3(Long clientDefinedBigInt3) {
    this.clientDefinedBigInt3 = clientDefinedBigInt3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined big int4.
   *
   * @param  clientDefinedBigInt4  Long
   */
  public void setClientDefinedBigInt4(Long clientDefinedBigInt4) {
    this.clientDefinedBigInt4 = clientDefinedBigInt4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger1.
   *
   * @param  clientDefinedInteger1  $param.type$
   */
  public void setClientDefinedInteger1(Integer clientDefinedInteger1) {
    this.clientDefinedInteger1 = clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger10.
   *
   * @param  clientDefinedInteger10  $param.type$
   */
  public void setClientDefinedInteger10(Integer clientDefinedInteger10) {
    this.clientDefinedInteger10 = clientDefinedInteger10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer100.
   *
   * @param  clientDefinedInteger100  Integer
   */
  public void setClientDefinedInteger100(Integer clientDefinedInteger100) {
    this.clientDefinedInteger100 = clientDefinedInteger100;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger11.
   *
   * @param  clientDefinedInteger11  $param.type$
   */
  public void setClientDefinedInteger11(Integer clientDefinedInteger11) {
    this.clientDefinedInteger11 = clientDefinedInteger11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger12.
   *
   * @param  clientDefinedInteger12  $param.type$
   */
  public void setClientDefinedInteger12(Integer clientDefinedInteger12) {
    this.clientDefinedInteger12 = clientDefinedInteger12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger13.
   *
   * @param  clientDefinedInteger13  $param.type$
   */
  public void setClientDefinedInteger13(Integer clientDefinedInteger13) {
    this.clientDefinedInteger13 = clientDefinedInteger13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger14.
   *
   * @param  clientDefinedInteger14  $param.type$
   */
  public void setClientDefinedInteger14(Integer clientDefinedInteger14) {
    this.clientDefinedInteger14 = clientDefinedInteger14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger15.
   *
   * @param  clientDefinedInteger15  $param.type$
   */
  public void setClientDefinedInteger15(Integer clientDefinedInteger15) {
    this.clientDefinedInteger15 = clientDefinedInteger15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger16.
   *
   * @param  clientDefinedInteger16  $param.type$
   */
  public void setClientDefinedInteger16(Integer clientDefinedInteger16) {
    this.clientDefinedInteger16 = clientDefinedInteger16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger17.
   *
   * @param  clientDefinedInteger17  $param.type$
   */
  public void setClientDefinedInteger17(Integer clientDefinedInteger17) {
    this.clientDefinedInteger17 = clientDefinedInteger17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger18.
   *
   * @param  clientDefinedInteger18  $param.type$
   */
  public void setClientDefinedInteger18(Integer clientDefinedInteger18) {
    this.clientDefinedInteger18 = clientDefinedInteger18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger19.
   *
   * @param  clientDefinedInteger19  $param.type$
   */
  public void setClientDefinedInteger19(Integer clientDefinedInteger19) {
    this.clientDefinedInteger19 = clientDefinedInteger19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger2.
   *
   * @param  clientDefinedInteger2  $param.type$
   */
  public void setClientDefinedInteger2(Integer clientDefinedInteger2) {
    this.clientDefinedInteger2 = clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger20.
   *
   * @param  clientDefinedInteger20  $param.type$
   */
  public void setClientDefinedInteger20(Integer clientDefinedInteger20) {
    this.clientDefinedInteger20 = clientDefinedInteger20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer21.
   *
   * @param  clientDefinedInteger21  Integer
   */
  public void setClientDefinedInteger21(Integer clientDefinedInteger21) {
    this.clientDefinedInteger21 = clientDefinedInteger21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer22.
   *
   * @param  clientDefinedInteger22  Integer
   */
  public void setClientDefinedInteger22(Integer clientDefinedInteger22) {
    this.clientDefinedInteger22 = clientDefinedInteger22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer23.
   *
   * @param  clientDefinedInteger23  Integer
   */
  public void setClientDefinedInteger23(Integer clientDefinedInteger23) {
    this.clientDefinedInteger23 = clientDefinedInteger23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer24.
   *
   * @param  clientDefinedInteger24  Integer
   */
  public void setClientDefinedInteger24(Integer clientDefinedInteger24) {
    this.clientDefinedInteger24 = clientDefinedInteger24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer25.
   *
   * @param  clientDefinedInteger25  Integer
   */
  public void setClientDefinedInteger25(Integer clientDefinedInteger25) {
    this.clientDefinedInteger25 = clientDefinedInteger25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer26.
   *
   * @param  clientDefinedInteger26  Integer
   */
  public void setClientDefinedInteger26(Integer clientDefinedInteger26) {
    this.clientDefinedInteger26 = clientDefinedInteger26;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer27.
   *
   * @param  clientDefinedInteger27  Integer
   */
  public void setClientDefinedInteger27(Integer clientDefinedInteger27) {
    this.clientDefinedInteger27 = clientDefinedInteger27;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer28.
   *
   * @param  clientDefinedInteger28  Integer
   */
  public void setClientDefinedInteger28(Integer clientDefinedInteger28) {
    this.clientDefinedInteger28 = clientDefinedInteger28;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer29.
   *
   * @param  clientDefinedInteger29  Integer
   */
  public void setClientDefinedInteger29(Integer clientDefinedInteger29) {
    this.clientDefinedInteger29 = clientDefinedInteger29;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger3.
   *
   * @param  clientDefinedInteger3  $param.type$
   */
  public void setClientDefinedInteger3(Integer clientDefinedInteger3) {
    this.clientDefinedInteger3 = clientDefinedInteger3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer30.
   *
   * @param  clientDefinedInteger30  Integer
   */
  public void setClientDefinedInteger30(Integer clientDefinedInteger30) {
    this.clientDefinedInteger30 = clientDefinedInteger30;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer31.
   *
   * @param  clientDefinedInteger31  Integer
   */
  public void setClientDefinedInteger31(Integer clientDefinedInteger31) {
    this.clientDefinedInteger31 = clientDefinedInteger31;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer32.
   *
   * @param  clientDefinedInteger32  Integer
   */
  public void setClientDefinedInteger32(Integer clientDefinedInteger32) {
    this.clientDefinedInteger32 = clientDefinedInteger32;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer33.
   *
   * @param  clientDefinedInteger33  Integer
   */
  public void setClientDefinedInteger33(Integer clientDefinedInteger33) {
    this.clientDefinedInteger33 = clientDefinedInteger33;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer34.
   *
   * @param  clientDefinedInteger34  Integer
   */
  public void setClientDefinedInteger34(Integer clientDefinedInteger34) {
    this.clientDefinedInteger34 = clientDefinedInteger34;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer35.
   *
   * @param  clientDefinedInteger35  Integer
   */
  public void setClientDefinedInteger35(Integer clientDefinedInteger35) {
    this.clientDefinedInteger35 = clientDefinedInteger35;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer36.
   *
   * @param  clientDefinedInteger36  Integer
   */
  public void setClientDefinedInteger36(Integer clientDefinedInteger36) {
    this.clientDefinedInteger36 = clientDefinedInteger36;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer37.
   *
   * @param  clientDefinedInteger37  Integer
   */
  public void setClientDefinedInteger37(Integer clientDefinedInteger37) {
    this.clientDefinedInteger37 = clientDefinedInteger37;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer38.
   *
   * @param  clientDefinedInteger38  Integer
   */
  public void setClientDefinedInteger38(Integer clientDefinedInteger38) {
    this.clientDefinedInteger38 = clientDefinedInteger38;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer39.
   *
   * @param  clientDefinedInteger39  Integer
   */
  public void setClientDefinedInteger39(Integer clientDefinedInteger39) {
    this.clientDefinedInteger39 = clientDefinedInteger39;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger4.
   *
   * @param  clientDefinedInteger4  $param.type$
   */
  public void setClientDefinedInteger4(Integer clientDefinedInteger4) {
    this.clientDefinedInteger4 = clientDefinedInteger4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer40.
   *
   * @param  clientDefinedInteger40  Integer
   */
  public void setClientDefinedInteger40(Integer clientDefinedInteger40) {
    this.clientDefinedInteger40 = clientDefinedInteger40;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer41.
   *
   * @param  clientDefinedInteger41  Integer
   */
  public void setClientDefinedInteger41(Integer clientDefinedInteger41) {
    this.clientDefinedInteger41 = clientDefinedInteger41;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer42.
   *
   * @param  clientDefinedInteger42  Integer
   */
  public void setClientDefinedInteger42(Integer clientDefinedInteger42) {
    this.clientDefinedInteger42 = clientDefinedInteger42;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer43.
   *
   * @param  clientDefinedInteger43  Integer
   */
  public void setClientDefinedInteger43(Integer clientDefinedInteger43) {
    this.clientDefinedInteger43 = clientDefinedInteger43;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer44.
   *
   * @param  clientDefinedInteger44  Integer
   */
  public void setClientDefinedInteger44(Integer clientDefinedInteger44) {
    this.clientDefinedInteger44 = clientDefinedInteger44;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer45.
   *
   * @param  clientDefinedInteger45  Integer
   */
  public void setClientDefinedInteger45(Integer clientDefinedInteger45) {
    this.clientDefinedInteger45 = clientDefinedInteger45;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer46.
   *
   * @param  clientDefinedInteger46  Integer
   */
  public void setClientDefinedInteger46(Integer clientDefinedInteger46) {
    this.clientDefinedInteger46 = clientDefinedInteger46;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer47.
   *
   * @param  clientDefinedInteger47  Integer
   */
  public void setClientDefinedInteger47(Integer clientDefinedInteger47) {
    this.clientDefinedInteger47 = clientDefinedInteger47;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer48.
   *
   * @param  clientDefinedInteger48  Integer
   */
  public void setClientDefinedInteger48(Integer clientDefinedInteger48) {
    this.clientDefinedInteger48 = clientDefinedInteger48;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer49.
   *
   * @param  clientDefinedInteger49  Integer
   */
  public void setClientDefinedInteger49(Integer clientDefinedInteger49) {
    this.clientDefinedInteger49 = clientDefinedInteger49;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger5.
   *
   * @param  clientDefinedInteger5  $param.type$
   */
  public void setClientDefinedInteger5(Integer clientDefinedInteger5) {
    this.clientDefinedInteger5 = clientDefinedInteger5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer50.
   *
   * @param  clientDefinedInteger50  Integer
   */
  public void setClientDefinedInteger50(Integer clientDefinedInteger50) {
    this.clientDefinedInteger50 = clientDefinedInteger50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer51.
   *
   * @param  clientDefinedInteger51  Integer
   */
  public void setClientDefinedInteger51(Integer clientDefinedInteger51) {
    this.clientDefinedInteger51 = clientDefinedInteger51;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer52.
   *
   * @param  clientDefinedInteger52  Integer
   */
  public void setClientDefinedInteger52(Integer clientDefinedInteger52) {
    this.clientDefinedInteger52 = clientDefinedInteger52;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer53.
   *
   * @param  clientDefinedInteger53  Integer
   */
  public void setClientDefinedInteger53(Integer clientDefinedInteger53) {
    this.clientDefinedInteger53 = clientDefinedInteger53;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer54.
   *
   * @param  clientDefinedInteger54  Integer
   */
  public void setClientDefinedInteger54(Integer clientDefinedInteger54) {
    this.clientDefinedInteger54 = clientDefinedInteger54;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer55.
   *
   * @param  clientDefinedInteger55  Integer
   */
  public void setClientDefinedInteger55(Integer clientDefinedInteger55) {
    this.clientDefinedInteger55 = clientDefinedInteger55;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer56.
   *
   * @param  clientDefinedInteger56  Integer
   */
  public void setClientDefinedInteger56(Integer clientDefinedInteger56) {
    this.clientDefinedInteger56 = clientDefinedInteger56;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer57.
   *
   * @param  clientDefinedInteger57  Integer
   */
  public void setClientDefinedInteger57(Integer clientDefinedInteger57) {
    this.clientDefinedInteger57 = clientDefinedInteger57;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer58.
   *
   * @param  clientDefinedInteger58  Integer
   */
  public void setClientDefinedInteger58(Integer clientDefinedInteger58) {
    this.clientDefinedInteger58 = clientDefinedInteger58;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer59.
   *
   * @param  clientDefinedInteger59  Integer
   */
  public void setClientDefinedInteger59(Integer clientDefinedInteger59) {
    this.clientDefinedInteger59 = clientDefinedInteger59;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger6.
   *
   * @param  clientDefinedInteger6  $param.type$
   */
  public void setClientDefinedInteger6(Integer clientDefinedInteger6) {
    this.clientDefinedInteger6 = clientDefinedInteger6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer60.
   *
   * @param  clientDefinedInteger60  Integer
   */
  public void setClientDefinedInteger60(Integer clientDefinedInteger60) {
    this.clientDefinedInteger60 = clientDefinedInteger60;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer61.
   *
   * @param  clientDefinedInteger61  Integer
   */
  public void setClientDefinedInteger61(Integer clientDefinedInteger61) {
    this.clientDefinedInteger61 = clientDefinedInteger61;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer62.
   *
   * @param  clientDefinedInteger62  Integer
   */
  public void setClientDefinedInteger62(Integer clientDefinedInteger62) {
    this.clientDefinedInteger62 = clientDefinedInteger62;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer63.
   *
   * @param  clientDefinedInteger63  Integer
   */
  public void setClientDefinedInteger63(Integer clientDefinedInteger63) {
    this.clientDefinedInteger63 = clientDefinedInteger63;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer64.
   *
   * @param  clientDefinedInteger64  Integer
   */
  public void setClientDefinedInteger64(Integer clientDefinedInteger64) {
    this.clientDefinedInteger64 = clientDefinedInteger64;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer65.
   *
   * @param  clientDefinedInteger65  Integer
   */
  public void setClientDefinedInteger65(Integer clientDefinedInteger65) {
    this.clientDefinedInteger65 = clientDefinedInteger65;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer66.
   *
   * @param  clientDefinedInteger66  Integer
   */
  public void setClientDefinedInteger66(Integer clientDefinedInteger66) {
    this.clientDefinedInteger66 = clientDefinedInteger66;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer67.
   *
   * @param  clientDefinedInteger67  Integer
   */
  public void setClientDefinedInteger67(Integer clientDefinedInteger67) {
    this.clientDefinedInteger67 = clientDefinedInteger67;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer68.
   *
   * @param  clientDefinedInteger68  Integer
   */
  public void setClientDefinedInteger68(Integer clientDefinedInteger68) {
    this.clientDefinedInteger68 = clientDefinedInteger68;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer69.
   *
   * @param  clientDefinedInteger69  Integer
   */
  public void setClientDefinedInteger69(Integer clientDefinedInteger69) {
    this.clientDefinedInteger69 = clientDefinedInteger69;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger7.
   *
   * @param  clientDefinedInteger7  $param.type$
   */
  public void setClientDefinedInteger7(Integer clientDefinedInteger7) {
    this.clientDefinedInteger7 = clientDefinedInteger7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer70.
   *
   * @param  clientDefinedInteger70  Integer
   */
  public void setClientDefinedInteger70(Integer clientDefinedInteger70) {
    this.clientDefinedInteger70 = clientDefinedInteger70;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer71.
   *
   * @param  clientDefinedInteger71  Integer
   */
  public void setClientDefinedInteger71(Integer clientDefinedInteger71) {
    this.clientDefinedInteger71 = clientDefinedInteger71;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer72.
   *
   * @param  clientDefinedInteger72  Integer
   */
  public void setClientDefinedInteger72(Integer clientDefinedInteger72) {
    this.clientDefinedInteger72 = clientDefinedInteger72;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer73.
   *
   * @param  clientDefinedInteger73  Integer
   */
  public void setClientDefinedInteger73(Integer clientDefinedInteger73) {
    this.clientDefinedInteger73 = clientDefinedInteger73;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer74.
   *
   * @param  clientDefinedInteger74  Integer
   */
  public void setClientDefinedInteger74(Integer clientDefinedInteger74) {
    this.clientDefinedInteger74 = clientDefinedInteger74;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer75.
   *
   * @param  clientDefinedInteger75  Integer
   */
  public void setClientDefinedInteger75(Integer clientDefinedInteger75) {
    this.clientDefinedInteger75 = clientDefinedInteger75;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer76.
   *
   * @param  clientDefinedInteger76  Integer
   */
  public void setClientDefinedInteger76(Integer clientDefinedInteger76) {
    this.clientDefinedInteger76 = clientDefinedInteger76;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer77.
   *
   * @param  clientDefinedInteger77  Integer
   */
  public void setClientDefinedInteger77(Integer clientDefinedInteger77) {
    this.clientDefinedInteger77 = clientDefinedInteger77;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer78.
   *
   * @param  clientDefinedInteger78  Integer
   */
  public void setClientDefinedInteger78(Integer clientDefinedInteger78) {
    this.clientDefinedInteger78 = clientDefinedInteger78;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer79.
   *
   * @param  clientDefinedInteger79  Integer
   */
  public void setClientDefinedInteger79(Integer clientDefinedInteger79) {
    this.clientDefinedInteger79 = clientDefinedInteger79;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger8.
   *
   * @param  clientDefinedInteger8  $param.type$
   */
  public void setClientDefinedInteger8(Integer clientDefinedInteger8) {
    this.clientDefinedInteger8 = clientDefinedInteger8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer80.
   *
   * @param  clientDefinedInteger80  Integer
   */
  public void setClientDefinedInteger80(Integer clientDefinedInteger80) {
    this.clientDefinedInteger80 = clientDefinedInteger80;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer81.
   *
   * @param  clientDefinedInteger81  Integer
   */
  public void setClientDefinedInteger81(Integer clientDefinedInteger81) {
    this.clientDefinedInteger81 = clientDefinedInteger81;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer82.
   *
   * @param  clientDefinedInteger82  Integer
   */
  public void setClientDefinedInteger82(Integer clientDefinedInteger82) {
    this.clientDefinedInteger82 = clientDefinedInteger82;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer83.
   *
   * @param  clientDefinedInteger83  Integer
   */
  public void setClientDefinedInteger83(Integer clientDefinedInteger83) {
    this.clientDefinedInteger83 = clientDefinedInteger83;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer84.
   *
   * @param  clientDefinedInteger84  Integer
   */
  public void setClientDefinedInteger84(Integer clientDefinedInteger84) {
    this.clientDefinedInteger84 = clientDefinedInteger84;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer85.
   *
   * @param  clientDefinedInteger85  Integer
   */
  public void setClientDefinedInteger85(Integer clientDefinedInteger85) {
    this.clientDefinedInteger85 = clientDefinedInteger85;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer86.
   *
   * @param  clientDefinedInteger86  Integer
   */
  public void setClientDefinedInteger86(Integer clientDefinedInteger86) {
    this.clientDefinedInteger86 = clientDefinedInteger86;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer87.
   *
   * @param  clientDefinedInteger87  Integer
   */
  public void setClientDefinedInteger87(Integer clientDefinedInteger87) {
    this.clientDefinedInteger87 = clientDefinedInteger87;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer88.
   *
   * @param  clientDefinedInteger88  Integer
   */
  public void setClientDefinedInteger88(Integer clientDefinedInteger88) {
    this.clientDefinedInteger88 = clientDefinedInteger88;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer89.
   *
   * @param  clientDefinedInteger89  Integer
   */
  public void setClientDefinedInteger89(Integer clientDefinedInteger89) {
    this.clientDefinedInteger89 = clientDefinedInteger89;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedInteger9.
   *
   * @param  clientDefinedInteger9  $param.type$
   */
  public void setClientDefinedInteger9(Integer clientDefinedInteger9) {
    this.clientDefinedInteger9 = clientDefinedInteger9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer90.
   *
   * @param  clientDefinedInteger90  Integer
   */
  public void setClientDefinedInteger90(Integer clientDefinedInteger90) {
    this.clientDefinedInteger90 = clientDefinedInteger90;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer91.
   *
   * @param  clientDefinedInteger91  Integer
   */
  public void setClientDefinedInteger91(Integer clientDefinedInteger91) {
    this.clientDefinedInteger91 = clientDefinedInteger91;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer92.
   *
   * @param  clientDefinedInteger92  Integer
   */
  public void setClientDefinedInteger92(Integer clientDefinedInteger92) {
    this.clientDefinedInteger92 = clientDefinedInteger92;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer93.
   *
   * @param  clientDefinedInteger93  Integer
   */
  public void setClientDefinedInteger93(Integer clientDefinedInteger93) {
    this.clientDefinedInteger93 = clientDefinedInteger93;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer94.
   *
   * @param  clientDefinedInteger94  Integer
   */
  public void setClientDefinedInteger94(Integer clientDefinedInteger94) {
    this.clientDefinedInteger94 = clientDefinedInteger94;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer95.
   *
   * @param  clientDefinedInteger95  Integer
   */
  public void setClientDefinedInteger95(Integer clientDefinedInteger95) {
    this.clientDefinedInteger95 = clientDefinedInteger95;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer96.
   *
   * @param  clientDefinedInteger96  Integer
   */
  public void setClientDefinedInteger96(Integer clientDefinedInteger96) {
    this.clientDefinedInteger96 = clientDefinedInteger96;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer97.
   *
   * @param  clientDefinedInteger97  Integer
   */
  public void setClientDefinedInteger97(Integer clientDefinedInteger97) {
    this.clientDefinedInteger97 = clientDefinedInteger97;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer98.
   *
   * @param  clientDefinedInteger98  Integer
   */
  public void setClientDefinedInteger98(Integer clientDefinedInteger98) {
    this.clientDefinedInteger98 = clientDefinedInteger98;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer99.
   *
   * @param  clientDefinedInteger99  Integer
   */
  public void setClientDefinedInteger99(Integer clientDefinedInteger99) {
    this.clientDefinedInteger99 = clientDefinedInteger99;
  }

  public Integer getClientDefinedInteger101() {
    return clientDefinedInteger101;
  }

  public void setClientDefinedInteger101(Integer clientDefinedInteger101) {
    this.clientDefinedInteger101 = clientDefinedInteger101;
  }

  public Integer getClientDefinedInteger102() {
    return clientDefinedInteger102;
  }

  public void setClientDefinedInteger102(Integer clientDefinedInteger102) {
    this.clientDefinedInteger102 = clientDefinedInteger102;
  }

  public Integer getClientDefinedInteger103() {
    return clientDefinedInteger103;
  }

  public void setClientDefinedInteger103(Integer clientDefinedInteger103) {
    this.clientDefinedInteger103 = clientDefinedInteger103;
  }

  public Integer getClientDefinedInteger104() {
    return clientDefinedInteger104;
  }

  public void setClientDefinedInteger104(Integer clientDefinedInteger104) {
    this.clientDefinedInteger104 = clientDefinedInteger104;
  }

  public Integer getClientDefinedInteger105() {
    return clientDefinedInteger105;
  }

  public void setClientDefinedInteger105(Integer clientDefinedInteger105) {
    this.clientDefinedInteger105 = clientDefinedInteger105;
  }

  public Integer getClientDefinedInteger106() {
    return clientDefinedInteger106;
  }

  public void setClientDefinedInteger106(Integer clientDefinedInteger106) {
    this.clientDefinedInteger106 = clientDefinedInteger106;
  }

  public Integer getClientDefinedInteger107() {
    return clientDefinedInteger107;
  }

  public void setClientDefinedInteger107(Integer clientDefinedInteger107) {
    this.clientDefinedInteger107 = clientDefinedInteger107;
  }

  public Integer getClientDefinedInteger108() {
    return clientDefinedInteger108;
  }

  public void setClientDefinedInteger108(Integer clientDefinedInteger108) {
    this.clientDefinedInteger108 = clientDefinedInteger108;
  }

  public Integer getClientDefinedInteger109() {
    return clientDefinedInteger109;
  }

  public void setClientDefinedInteger109(Integer clientDefinedInteger109) {
    this.clientDefinedInteger109 = clientDefinedInteger109;
  }

  public Integer getClientDefinedInteger110() {
    return clientDefinedInteger110;
  }

  public void setClientDefinedInteger110(Integer clientDefinedInteger110) {
    this.clientDefinedInteger110 = clientDefinedInteger110;
  }

  public Integer getClientDefinedInteger111() {
    return clientDefinedInteger111;
  }

  public void setClientDefinedInteger111(Integer clientDefinedInteger111) {
    this.clientDefinedInteger111 = clientDefinedInteger111;
  }

  public Integer getClientDefinedInteger112() {
    return clientDefinedInteger112;
  }

  public void setClientDefinedInteger112(Integer clientDefinedInteger112) {
    this.clientDefinedInteger112 = clientDefinedInteger112;
  }

  public Integer getClientDefinedInteger113() {
    return clientDefinedInteger113;
  }

  public void setClientDefinedInteger113(Integer clientDefinedInteger113) {
    this.clientDefinedInteger113 = clientDefinedInteger113;
  }

  public Integer getClientDefinedInteger114() {
    return clientDefinedInteger114;
  }

  public void setClientDefinedInteger114(Integer clientDefinedInteger114) {
    this.clientDefinedInteger114 = clientDefinedInteger114;
  }

  public Integer getClientDefinedInteger115() {
    return clientDefinedInteger115;
  }

  public void setClientDefinedInteger115(Integer clientDefinedInteger115) {
    this.clientDefinedInteger115 = clientDefinedInteger115;
  }

  public Integer getClientDefinedInteger116() {
    return clientDefinedInteger116;
  }

  public void setClientDefinedInteger116(Integer clientDefinedInteger116) {
    this.clientDefinedInteger116 = clientDefinedInteger116;
  }

  public Integer getClientDefinedInteger117() {
    return clientDefinedInteger117;
  }

  public void setClientDefinedInteger117(Integer clientDefinedInteger117) {
    this.clientDefinedInteger117 = clientDefinedInteger117;
  }

  public Integer getClientDefinedInteger118() {
    return clientDefinedInteger118;
  }

  public void setClientDefinedInteger118(Integer clientDefinedInteger118) {
    this.clientDefinedInteger118 = clientDefinedInteger118;
  }

  public Integer getClientDefinedInteger119() {
    return clientDefinedInteger119;
  }

  public void setClientDefinedInteger119(Integer clientDefinedInteger119) {
    this.clientDefinedInteger119 = clientDefinedInteger119;
  }

  public Integer getClientDefinedInteger120() {
    return clientDefinedInteger120;
  }

  public void setClientDefinedInteger120(Integer clientDefinedInteger120) {
    this.clientDefinedInteger120 = clientDefinedInteger120;
  }

  public Integer getClientDefinedInteger121() {
    return clientDefinedInteger121;
  }

  public void setClientDefinedInteger121(Integer clientDefinedInteger121) {
    this.clientDefinedInteger121 = clientDefinedInteger121;
  }

  public Integer getClientDefinedInteger122() {
    return clientDefinedInteger122;
  }

  public void setClientDefinedInteger122(Integer clientDefinedInteger122) {
    this.clientDefinedInteger122 = clientDefinedInteger122;
  }

  public Integer getClientDefinedInteger123() {
    return clientDefinedInteger123;
  }

  public void setClientDefinedInteger123(Integer clientDefinedInteger123) {
    this.clientDefinedInteger123 = clientDefinedInteger123;
  }

  public Integer getClientDefinedInteger124() {
    return clientDefinedInteger124;
  }

  public void setClientDefinedInteger124(Integer clientDefinedInteger124) {
    this.clientDefinedInteger124 = clientDefinedInteger124;
  }

  public Integer getClientDefinedInteger125() {
    return clientDefinedInteger125;
  }

  public void setClientDefinedInteger125(Integer clientDefinedInteger125) {
    this.clientDefinedInteger125 = clientDefinedInteger125;
  }

  public Integer getClientDefinedInteger126() {
    return clientDefinedInteger126;
  }

  public void setClientDefinedInteger126(Integer clientDefinedInteger126) {
    this.clientDefinedInteger126 = clientDefinedInteger126;
  }

  public Integer getClientDefinedInteger127() {
    return clientDefinedInteger127;
  }

  public void setClientDefinedInteger127(Integer clientDefinedInteger127) {
    this.clientDefinedInteger127 = clientDefinedInteger127;
  }

  public Integer getClientDefinedInteger128() {
    return clientDefinedInteger128;
  }

  public void setClientDefinedInteger128(Integer clientDefinedInteger128) {
    this.clientDefinedInteger128 = clientDefinedInteger128;
  }

  public Integer getClientDefinedInteger129() {
    return clientDefinedInteger129;
  }

  public void setClientDefinedInteger129(Integer clientDefinedInteger129) {
    this.clientDefinedInteger129 = clientDefinedInteger129;
  }

  public Integer getClientDefinedInteger130() {
    return clientDefinedInteger130;
  }

  public void setClientDefinedInteger130(Integer clientDefinedInteger130) {
    this.clientDefinedInteger130 = clientDefinedInteger130;
  }

  public Integer getClientDefinedInteger131() {
    return clientDefinedInteger131;
  }

  public void setClientDefinedInteger131(Integer clientDefinedInteger131) {
    this.clientDefinedInteger131 = clientDefinedInteger131;
  }

  public Integer getClientDefinedInteger132() {
    return clientDefinedInteger132;
  }

  public void setClientDefinedInteger132(Integer clientDefinedInteger132) {
    this.clientDefinedInteger132 = clientDefinedInteger132;
  }

  public Integer getClientDefinedInteger133() {
    return clientDefinedInteger133;
  }

  public void setClientDefinedInteger133(Integer clientDefinedInteger133) {
    this.clientDefinedInteger133 = clientDefinedInteger133;
  }

  public Integer getClientDefinedInteger134() {
    return clientDefinedInteger134;
  }

  public void setClientDefinedInteger134(Integer clientDefinedInteger134) {
    this.clientDefinedInteger134 = clientDefinedInteger134;
  }

  public Integer getClientDefinedInteger135() {
    return clientDefinedInteger135;
  }

  public void setClientDefinedInteger135(Integer clientDefinedInteger135) {
    this.clientDefinedInteger135 = clientDefinedInteger135;
  }

  public Integer getClientDefinedInteger136() {
    return clientDefinedInteger136;
  }

  public void setClientDefinedInteger136(Integer clientDefinedInteger136) {
    this.clientDefinedInteger136 = clientDefinedInteger136;
  }

  public Integer getClientDefinedInteger137() {
    return clientDefinedInteger137;
  }

  public void setClientDefinedInteger137(Integer clientDefinedInteger137) {
    this.clientDefinedInteger137 = clientDefinedInteger137;
  }

  public Integer getClientDefinedInteger138() {
    return clientDefinedInteger138;
  }

  public void setClientDefinedInteger138(Integer clientDefinedInteger138) {
    this.clientDefinedInteger138 = clientDefinedInteger138;
  }

  public Integer getClientDefinedInteger139() {
    return clientDefinedInteger139;
  }

  public void setClientDefinedInteger139(Integer clientDefinedInteger139) {
    this.clientDefinedInteger139 = clientDefinedInteger139;
  }

  public Integer getClientDefinedInteger140() {
    return clientDefinedInteger140;
  }

  public void setClientDefinedInteger140(Integer clientDefinedInteger140) {
    this.clientDefinedInteger140 = clientDefinedInteger140;
  }

  public Integer getClientDefinedInteger141() {
    return clientDefinedInteger141;
  }

  public void setClientDefinedInteger141(Integer clientDefinedInteger141) {
    this.clientDefinedInteger141 = clientDefinedInteger141;
  }

  public Integer getClientDefinedInteger142() {
    return clientDefinedInteger142;
  }

  public void setClientDefinedInteger142(Integer clientDefinedInteger142) {
    this.clientDefinedInteger142 = clientDefinedInteger142;
  }

  public Integer getClientDefinedInteger143() {
    return clientDefinedInteger143;
  }

  public void setClientDefinedInteger143(Integer clientDefinedInteger143) {
    this.clientDefinedInteger143 = clientDefinedInteger143;
  }

  public Integer getClientDefinedInteger144() {
    return clientDefinedInteger144;
  }

  public void setClientDefinedInteger144(Integer clientDefinedInteger144) {
    this.clientDefinedInteger144 = clientDefinedInteger144;
  }

  public Integer getClientDefinedInteger145() {
    return clientDefinedInteger145;
  }

  public void setClientDefinedInteger145(Integer clientDefinedInteger145) {
    this.clientDefinedInteger145 = clientDefinedInteger145;
  }

  public Integer getClientDefinedInteger146() {
    return clientDefinedInteger146;
  }

  public void setClientDefinedInteger146(Integer clientDefinedInteger146) {
    this.clientDefinedInteger146 = clientDefinedInteger146;
  }

  public Integer getClientDefinedInteger147() {
    return clientDefinedInteger147;
  }

  public void setClientDefinedInteger147(Integer clientDefinedInteger147) {
    this.clientDefinedInteger147 = clientDefinedInteger147;
  }

  public Integer getClientDefinedInteger148() {
    return clientDefinedInteger148;
  }

  public void setClientDefinedInteger148(Integer clientDefinedInteger148) {
    this.clientDefinedInteger148 = clientDefinedInteger148;
  }

  public Integer getClientDefinedInteger149() {
    return clientDefinedInteger149;
  }

  public void setClientDefinedInteger149(Integer clientDefinedInteger149) {
    this.clientDefinedInteger149 = clientDefinedInteger149;
  }

  public Integer getClientDefinedInteger150() {
    return clientDefinedInteger150;
  }

  public void setClientDefinedInteger150(Integer clientDefinedInteger150) {
    this.clientDefinedInteger150 = clientDefinedInteger150;
  }
} // end class AccountExtensionInteger
