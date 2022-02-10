package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/15/2014 10:34
 */
@Entity
@Table(name = "AccountExtension")
public class AccountExtension extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -3567634213371061608L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "accountExtensionId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long accountExtensionId;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate1")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate1;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate2")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate2;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate3")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate3;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate4")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate4;

  /** TODO: DOCUMENT ME! */
  @Column(name = "clientDefinedDate5")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientDefinedDate5;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal1",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal10",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal10;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal11",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal11;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal12",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal12;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal13",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal13;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal14",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal14;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal15",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal15;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal16",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal16;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal17",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal17;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal18",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal18;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal19",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal19;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal2",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal2;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal20",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal20;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal21",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal21;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal22",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal22;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal23",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal23;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal24",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal24;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal25",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal25;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal26",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal26;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal27",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal27;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal28",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal28;

  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal29",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal29;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal3",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal3;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal30",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal30;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal31",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal31;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal32",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal32;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal33",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal33;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal34",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal34;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal35",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal35;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal36",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal36;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal37",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal37;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal38",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal38;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal39",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal39;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal4",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal4;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal40",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal40;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal41",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal41;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal42",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal42;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal43",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal43;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal44",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal44;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal45",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal45;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal46",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal46;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal47",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal47;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal48",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal48;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal49",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal49;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal5",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal5;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal50",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal50;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal6",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal6;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal7",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal7;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal8",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal8;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal9",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal9;

  @JoinColumn(
    name   = "accountNum",
    unique = true
  )
  @ManyToOne private Account account;
  @Column(
    name   = "clientDefined10CharCode1",
    length = 50
  )
  private String             clientDefined10CharCode1;
  @Column(
    name   = "clientDefined10CharCode2",
    length = 50
  )
  private String             clientDefined10CharCode2;
  @Column(
    name   = "clientDefined10CharCode3",
    length = 255
  )
  private String             clientDefined10CharCode3;

  @Column(
    name   = "clientDefined10CharCode4",
    length = 50
  )
  private String clientDefined10CharCode4;
  @Column(
    name   = "clientDefined10CharCode5",
    length = 255
  )
  private String clientDefined10CharCode5;

  @Column(
    name   = "clientDefined1CharCode1",
    length = 255
  )
  private String clientDefined1CharCode1;

  @Column(
    name   = "clientDefined1CharCode2",
    length = 255
  )
  private String clientDefined1CharCode2;
  @Column(
    name   = "clientDefined1CharCode3",
    length = 50
  )
  private String clientDefined1CharCode3;

  @Column(
    name   = "clientDefined1CharCode4",
    length = 50
  )
  private String clientDefined1CharCode4;
  @Column(
    name   = "clientDefined1CharCode5",
    length = 50
  )
  private String clientDefined1CharCode5;

  @Column(
    name   = "clientDefined2CharCode1",
    length = 2
  )
  private String clientDefined2CharCode1;
  @Column(
    name   = "clientDefined2CharCode2",
    length = 2
  )
  private String clientDefined2CharCode2;
  @Column(
    name   = "clientDefined2CharCode3",
    length = 2
  )
  private String clientDefined2CharCode3;

  @Column(
    name   = "clientDefined2CharCode4",
    length = 2
  )
  private String clientDefined2CharCode4;
  @Column(
    name   = "clientDefined2CharCode5",
    length = 2
  )
  private String clientDefined2CharCode5;

  @Column(
    name   = "clientDefined3CharCode1",
    length = 3
  )
  private String clientDefined3CharCode1;
  @Column(
    name   = "clientDefined3CharCode2",
    length = 3
  )
  private String clientDefined3CharCode2;
  @Column(
    name   = "clientDefined3CharCode3",
    length = 3
  )
  private String clientDefined3CharCode3;

  @Column(
    name   = "clientDefined3CharCode4",
    length = 3
  )
  private String clientDefined3CharCode4;
  @Column(
    name   = "clientDefined3CharCode5",
    length = 3
  )
  private String clientDefined3CharCode5;
  @Column(
    name   = "clientDefined4CharCode1",
    length = 4
  )
  private String clientDefined4CharCode1;
  @Column(
    name   = "clientDefined4CharCode2",
    length = 4
  )
  private String clientDefined4CharCode2;
  @Column(
    name   = "clientDefined4CharCode3",
    length = 4
  )
  private String clientDefined4CharCode3;

  @Column(
    name   = "clientDefined4CharCode4",
    length = 4
  )
  private String clientDefined4CharCode4;
  @Column(
    name   = "clientDefined4CharCode5",
    length = 4
  )
  private String clientDefined4CharCode5;
  @Column(
    name   = "clientDefined5CharCode1",
    length = 5
  )
  private String clientDefined5CharCode1;
  @Column(
    name   = "clientDefined5CharCode2",
    length = 5
  )
  private String clientDefined5CharCode2;
  @Column(
    name   = "clientDefined5CharCode3",
    length = 5
  )
  private String clientDefined5CharCode3;

  @Column(
    name   = "clientDefined5CharCode4",
    length = 5
  )
  private String clientDefined5CharCode4;
  @Column(
    name   = "clientDefined5CharCode5",
    length = 5
  )
  private String clientDefined5CharCode5;
  @Column(
    name   = "clientDefined8CharCode1",
    length = 8
  )
  private String clientDefined8CharCode1;
  @Column(
    name   = "clientDefined8CharCode2",
    length = 8
  )
  private String clientDefined8CharCode2;
  @Column(
    name   = "clientDefined8CharCode3",
    length = 8
  )
  private String clientDefined8CharCode3;

  @Column(
    name   = "clientDefined8CharCode4",
    length = 8
  )
  private String  clientDefined8CharCode4;
  @Column(
    name   = "clientDefined8CharCode5",
    length = 8
  )
  private String  clientDefined8CharCode5;
  @Column(
    name   = "clientDefinedInteger1",
    length = 11
  )
  private Integer clientDefinedInteger1;
  @Column(
    name   = "clientDefinedInteger10",
    length = 11
  )
  private Integer clientDefinedInteger10;
  @Column(
    name   = "clientDefinedInteger100",
    length = 11
  )
  private Integer clientDefinedInteger100;
  @Column(
    name   = "clientDefinedInteger101",
    length = 11
  )
  private Integer clientDefinedInteger101;

  @Column(
    name   = "clientDefinedInteger102",
    length = 11
  )
  private Integer clientDefinedInteger102;
  @Column(
    name   = "clientDefinedInteger103",
    length = 11
  )
  private Integer clientDefinedInteger103;
  @Column(
    name   = "clientDefinedInteger104",
    length = 11
  )
  private Integer clientDefinedInteger104;
  @Column(
    name   = "clientDefinedInteger105",
    length = 11
  )
  private Integer clientDefinedInteger105;
  @Column(
    name   = "clientDefinedInteger106",
    length = 11
  )
  private Integer clientDefinedInteger106;
  @Column(
    name   = "clientDefinedInteger107",
    length = 11
  )
  private Integer clientDefinedInteger107;
  @Column(
    name   = "clientDefinedInteger108",
    length = 11
  )
  private Integer clientDefinedInteger108;
  @Column(
    name   = "clientDefinedInteger109",
    length = 11
  )
  private Integer clientDefinedInteger109;


  @Column(
    name   = "clientDefinedInteger11",
    length = 11
  )
  private Integer clientDefinedInteger11;
  @Column(
    name   = "clientDefinedInteger110",
    length = 11
  )
  private Integer clientDefinedInteger110;

  @Column(
    name   = "clientDefinedInteger111",
    length = 11
  )
  private Integer clientDefinedInteger111;

  @Column(
    name   = "clientDefinedInteger112",
    length = 11
  )
  private Integer clientDefinedInteger112;
  @Column(
    name   = "clientDefinedInteger113",
    length = 11
  )
  private Integer clientDefinedInteger113;
  @Column(
    name   = "clientDefinedInteger114",
    length = 11
  )
  private Integer clientDefinedInteger114;
  @Column(
    name   = "clientDefinedInteger115",
    length = 11
  )
  private Integer clientDefinedInteger115;
  @Column(
    name   = "clientDefinedInteger116",
    length = 11
  )
  private Integer clientDefinedInteger116;
  @Column(
    name   = "clientDefinedInteger117",
    length = 11
  )
  private Integer clientDefinedInteger117;
  @Column(
    name   = "clientDefinedInteger118",
    length = 11
  )
  private Integer clientDefinedInteger118;
  @Column(
    name   = "clientDefinedInteger119",
    length = 11
  )
  private Integer clientDefinedInteger119;
  @Column(
    name   = "clientDefinedInteger12",
    length = 11
  )
  private Integer clientDefinedInteger12;
  @Column(
    name   = "clientDefinedInteger120",
    length = 11
  )
  private Integer clientDefinedInteger120;
  @Column(
    name   = "clientDefinedInteger121",
    length = 11
  )
  private Integer clientDefinedInteger121;

  @Column(
    name   = "clientDefinedInteger122",
    length = 11
  )
  private Integer clientDefinedInteger122;
  @Column(
    name   = "clientDefinedInteger123",
    length = 11
  )
  private Integer clientDefinedInteger123;
  @Column(
    name   = "clientDefinedInteger124",
    length = 11
  )
  private Integer clientDefinedInteger124;
  @Column(
    name   = "clientDefinedInteger125",
    length = 11
  )
  private Integer clientDefinedInteger125;
  @Column(
    name   = "clientDefinedInteger126",
    length = 11
  )
  private Integer clientDefinedInteger126;
  @Column(
    name   = "clientDefinedInteger127",
    length = 11
  )
  private Integer clientDefinedInteger127;
  @Column(
    name   = "clientDefinedInteger128",
    length = 11
  )
  private Integer clientDefinedInteger128;
  @Column(
    name   = "clientDefinedInteger129",
    length = 11
  )
  private Integer clientDefinedInteger129;
  @Column(
    name   = "clientDefinedInteger13",
    length = 11
  )
  private Integer clientDefinedInteger13;
  @Column(
    name   = "clientDefinedInteger130",
    length = 11
  )
  private Integer clientDefinedInteger130;


  @Column(
    name   = "clientDefinedInteger131",
    length = 11
  )
  private Integer clientDefinedInteger131;

  @Column(
    name   = "clientDefinedInteger132",
    length = 11
  )
  private Integer clientDefinedInteger132;
  @Column(
    name   = "clientDefinedInteger133",
    length = 11
  )
  private Integer clientDefinedInteger133;
  @Column(
    name   = "clientDefinedInteger134",
    length = 11
  )
  private Integer clientDefinedInteger134;
  @Column(
    name   = "clientDefinedInteger135",
    length = 11
  )
  private Integer clientDefinedInteger135;
  @Column(
    name   = "clientDefinedInteger136",
    length = 11
  )
  private Integer clientDefinedInteger136;
  @Column(
    name   = "clientDefinedInteger137",
    length = 11
  )
  private Integer clientDefinedInteger137;
  @Column(
    name   = "clientDefinedInteger138",
    length = 11
  )
  private Integer clientDefinedInteger138;
  @Column(
    name   = "clientDefinedInteger139",
    length = 11
  )
  private Integer clientDefinedInteger139;
  @Column(
    name   = "clientDefinedInteger14",
    length = 11
  )
  private Integer clientDefinedInteger14;
  @Column(
    name   = "clientDefinedInteger140",
    length = 11
  )
  private Integer clientDefinedInteger140;

  @Column(
    name   = "clientDefinedInteger141",
    length = 11
  )
  private Integer clientDefinedInteger141;

  @Column(
    name   = "clientDefinedInteger142",
    length = 11
  )
  private Integer clientDefinedInteger142;
  @Column(
    name   = "clientDefinedInteger143",
    length = 11
  )
  private Integer clientDefinedInteger143;
  @Column(
    name   = "clientDefinedInteger144",
    length = 11
  )
  private Integer clientDefinedInteger144;
  @Column(
    name   = "clientDefinedInteger145",
    length = 11
  )
  private Integer clientDefinedInteger145;
  @Column(
    name   = "clientDefinedInteger146",
    length = 11
  )
  private Integer clientDefinedInteger146;
  @Column(
    name   = "clientDefinedInteger147",
    length = 11
  )
  private Integer clientDefinedInteger147;
  @Column(
    name   = "clientDefinedInteger148",
    length = 11
  )
  private Integer clientDefinedInteger148;
  @Column(
    name   = "clientDefinedInteger149",
    length = 11
  )
  private Integer clientDefinedInteger149;
  @Column(
    name   = "clientDefinedInteger15",
    length = 11
  )
  private Integer clientDefinedInteger15;
  @Column(
    name   = "clientDefinedInteger150",
    length = 11
  )
  private Integer clientDefinedInteger150;

  @Column(
    name   = "clientDefinedInteger151",
    length = 11
  )
  private Integer clientDefinedInteger151;

  @Column(
    name   = "clientDefinedInteger152",
    length = 11
  )
  private Integer clientDefinedInteger152;
  @Column(
    name   = "clientDefinedInteger153",
    length = 11
  )
  private Integer clientDefinedInteger153;
  @Column(
    name   = "clientDefinedInteger154",
    length = 11
  )
  private Integer clientDefinedInteger154;
  @Column(
    name   = "clientDefinedInteger155",
    length = 11
  )
  private Integer clientDefinedInteger155;
  @Column(
    name   = "clientDefinedInteger156",
    length = 11
  )
  private Integer clientDefinedInteger156;
  @Column(
    name   = "clientDefinedInteger157",
    length = 11
  )
  private Integer clientDefinedInteger157;
  @Column(
    name   = "clientDefinedInteger158",
    length = 11
  )
  private Integer clientDefinedInteger158;
  @Column(
    name   = "clientDefinedInteger159",
    length = 11
  )
  private Integer clientDefinedInteger159;
  @Column(
    name   = "clientDefinedInteger16",
    length = 11
  )
  private Integer clientDefinedInteger16;

  @Column(
    name   = "clientDefinedInteger160",
    length = 11
  )
  private Integer clientDefinedInteger160;

  @Column(
    name   = "clientDefinedInteger161",
    length = 11
  )
  private Integer clientDefinedInteger161;

  @Column(
    name   = "clientDefinedInteger162",
    length = 11
  )
  private Integer clientDefinedInteger162;
  @Column(
    name   = "clientDefinedInteger163",
    length = 11
  )
  private Integer clientDefinedInteger163;
  @Column(
    name   = "clientDefinedInteger164",
    length = 11
  )
  private Integer clientDefinedInteger164;
  @Column(
    name   = "clientDefinedInteger165",
    length = 11
  )
  private Integer clientDefinedInteger165;
  @Column(
    name   = "clientDefinedInteger166",
    length = 11
  )
  private Integer clientDefinedInteger166;
  @Column(
    name   = "clientDefinedInteger167",
    length = 11
  )
  private Integer clientDefinedInteger167;
  @Column(
    name   = "clientDefinedInteger168",
    length = 11
  )
  private Integer clientDefinedInteger168;
  @Column(
    name   = "clientDefinedInteger169",
    length = 11
  )
  private Integer clientDefinedInteger169;
  @Column(
    name   = "clientDefinedInteger17",
    length = 11
  )
  private Integer clientDefinedInteger17;

  @Column(
    name   = "clientDefinedInteger170",
    length = 11
  )
  private Integer clientDefinedInteger170;

  @Column(
    name   = "clientDefinedInteger171",
    length = 11
  )
  private Integer clientDefinedInteger171;

  @Column(
    name   = "clientDefinedInteger172",
    length = 11
  )
  private Integer clientDefinedInteger172;
  @Column(
    name   = "clientDefinedInteger173",
    length = 11
  )
  private Integer clientDefinedInteger173;
  @Column(
    name   = "clientDefinedInteger174",
    length = 11
  )
  private Integer clientDefinedInteger174;
  @Column(
    name   = "clientDefinedInteger175",
    length = 11
  )
  private Integer clientDefinedInteger175;
  @Column(
    name   = "clientDefinedInteger176",
    length = 11
  )
  private Integer clientDefinedInteger176;
  @Column(
    name   = "clientDefinedInteger177",
    length = 11
  )
  private Integer clientDefinedInteger177;
  @Column(
    name   = "clientDefinedInteger178",
    length = 11
  )
  private Integer clientDefinedInteger178;
  @Column(
    name   = "clientDefinedInteger179",
    length = 11
  )
  private Integer clientDefinedInteger179;
  @Column(
    name   = "clientDefinedInteger18",
    length = 11
  )
  private Integer clientDefinedInteger18;
  @Column(
    name   = "clientDefinedInteger180",
    length = 11
  )
  private Integer clientDefinedInteger180;

  @Column(
    name   = "clientDefinedInteger181",
    length = 11
  )
  private Integer clientDefinedInteger181;

  @Column(
    name   = "clientDefinedInteger182",
    length = 11
  )
  private Integer clientDefinedInteger182;
  @Column(
    name   = "clientDefinedInteger183",
    length = 11
  )
  private Integer clientDefinedInteger183;
  @Column(
    name   = "clientDefinedInteger184",
    length = 11
  )
  private Integer clientDefinedInteger184;
  @Column(
    name   = "clientDefinedInteger185",
    length = 11
  )
  private Integer clientDefinedInteger185;
  @Column(
    name   = "clientDefinedInteger186",
    length = 11
  )
  private Integer clientDefinedInteger186;
  @Column(
    name   = "clientDefinedInteger187",
    length = 11
  )
  private Integer clientDefinedInteger187;
  @Column(
    name   = "clientDefinedInteger188",
    length = 11
  )
  private Integer clientDefinedInteger188;
  @Column(
    name   = "clientDefinedInteger189",
    length = 11
  )
  private Integer clientDefinedInteger189;
  @Column(
    name   = "clientDefinedInteger19",
    length = 11
  )
  private Integer clientDefinedInteger19;

  @Column(
    name   = "clientDefinedInteger190",
    length = 11
  )
  private Integer clientDefinedInteger190;

  @Column(
    name   = "clientDefinedInteger191",
    length = 11
  )
  private Integer clientDefinedInteger191;

  @Column(
    name   = "clientDefinedInteger192",
    length = 11
  )
  private Integer clientDefinedInteger192;
  @Column(
    name   = "clientDefinedInteger193",
    length = 11
  )
  private Integer clientDefinedInteger193;
  @Column(
    name   = "clientDefinedInteger194",
    length = 11
  )
  private Integer clientDefinedInteger194;
  @Column(
    name   = "clientDefinedInteger195",
    length = 11
  )
  private Integer clientDefinedInteger195;
  @Column(
    name   = "clientDefinedInteger196",
    length = 11
  )
  private Integer clientDefinedInteger196;
  @Column(
    name   = "clientDefinedInteger197",
    length = 11
  )
  private Integer clientDefinedInteger197;
  @Column(
    name   = "clientDefinedInteger198",
    length = 11
  )
  private Integer clientDefinedInteger198;
  @Column(
    name   = "clientDefinedInteger199",
    length = 11
  )
  private Integer clientDefinedInteger199;

  @Column(
    name   = "clientDefinedInteger2",
    length = 11
  )
  private Integer clientDefinedInteger2;
  @Column(
    name   = "clientDefinedInteger20",
    length = 11
  )
  private Integer clientDefinedInteger20;

  @Column(
    name   = "clientDefinedInteger200",
    length = 11
  )
  private Integer clientDefinedInteger200;


  @Column(
    name   = "clientDefinedInteger201",
    length = 11
  )
  private Integer clientDefinedInteger201;

  @Column(
    name   = "clientDefinedInteger202",
    length = 11
  )
  private Integer clientDefinedInteger202;
  @Column(
    name   = "clientDefinedInteger203",
    length = 11
  )
  private Integer clientDefinedInteger203;
  @Column(
    name   = "clientDefinedInteger204",
    length = 11
  )
  private Integer clientDefinedInteger204;
  @Column(
    name   = "clientDefinedInteger205",
    length = 11
  )
  private Integer clientDefinedInteger205;

  @Column(
    name   = "clientDefinedInteger21",
    length = 11
  )
  private Integer clientDefinedInteger21;

  @Column(
    name   = "clientDefinedInteger22",
    length = 11
  )
  private Integer clientDefinedInteger22;
  @Column(
    name   = "clientDefinedInteger23",
    length = 11
  )
  private Integer clientDefinedInteger23;
  @Column(
    name   = "clientDefinedInteger24",
    length = 11
  )
  private Integer clientDefinedInteger24;
  @Column(
    name   = "clientDefinedInteger25",
    length = 11
  )
  private Integer clientDefinedInteger25;
  @Column(
    name   = "clientDefinedInteger26",
    length = 11
  )
  private Integer clientDefinedInteger26;
  @Column(
    name   = "clientDefinedInteger27",
    length = 11
  )
  private Integer clientDefinedInteger27;
  @Column(
    name   = "clientDefinedInteger28",
    length = 11
  )
  private Integer clientDefinedInteger28;
  @Column(
    name   = "clientDefinedInteger29",
    length = 11
  )
  private Integer clientDefinedInteger29;
  @Column(
    name   = "clientDefinedInteger3",
    length = 11
  )
  private Integer clientDefinedInteger3;
  @Column(
    name   = "clientDefinedInteger30",
    length = 11
  )
  private Integer clientDefinedInteger30;
  @Column(
    name   = "clientDefinedInteger31",
    length = 11
  )
  private Integer clientDefinedInteger31;

  @Column(
    name   = "clientDefinedInteger32",
    length = 11
  )
  private Integer clientDefinedInteger32;
  @Column(
    name   = "clientDefinedInteger33",
    length = 11
  )
  private Integer clientDefinedInteger33;
  @Column(
    name   = "clientDefinedInteger34",
    length = 11
  )
  private Integer clientDefinedInteger34;
  @Column(
    name   = "clientDefinedInteger35",
    length = 11
  )
  private Integer clientDefinedInteger35;
  @Column(
    name   = "clientDefinedInteger36",
    length = 11
  )
  private Integer clientDefinedInteger36;
  @Column(
    name   = "clientDefinedInteger37",
    length = 11
  )
  private Integer clientDefinedInteger37;
  @Column(
    name   = "clientDefinedInteger38",
    length = 11
  )
  private Integer clientDefinedInteger38;
  @Column(
    name   = "clientDefinedInteger39",
    length = 11
  )
  private Integer clientDefinedInteger39;
  @Column(
    name   = "clientDefinedInteger4",
    length = 11
  )
  private Integer clientDefinedInteger4;
  @Column(
    name   = "clientDefinedInteger40",
    length = 11
  )
  private Integer clientDefinedInteger40;
  @Column(
    name   = "clientDefinedInteger41",
    length = 11
  )
  private Integer clientDefinedInteger41;

  @Column(
    name   = "clientDefinedInteger42",
    length = 11
  )
  private Integer clientDefinedInteger42;
  @Column(
    name   = "clientDefinedInteger43",
    length = 11
  )
  private Integer clientDefinedInteger43;
  @Column(
    name   = "clientDefinedInteger44",
    length = 11
  )
  private Integer clientDefinedInteger44;
  @Column(
    name   = "clientDefinedInteger45",
    length = 11
  )
  private Integer clientDefinedInteger45;
  @Column(
    name   = "clientDefinedInteger46",
    length = 11
  )
  private Integer clientDefinedInteger46;
  @Column(
    name   = "clientDefinedInteger47",
    length = 11
  )
  private Integer clientDefinedInteger47;
  @Column(
    name   = "clientDefinedInteger48",
    length = 11
  )
  private Integer clientDefinedInteger48;
  @Column(
    name   = "clientDefinedInteger49",
    length = 11
  )
  private Integer clientDefinedInteger49;
  @Column(
    name   = "clientDefinedInteger5",
    length = 11
  )
  private Integer clientDefinedInteger5;
  @Column(
    name   = "clientDefinedInteger50",
    length = 11
  )
  private Integer clientDefinedInteger50;

  @Column(
    name   = "clientDefinedInteger51",
    length = 11
  )
  private Integer clientDefinedInteger51;

  @Column(
    name   = "clientDefinedInteger52",
    length = 11
  )
  private Integer clientDefinedInteger52;
  @Column(
    name   = "clientDefinedInteger53",
    length = 11
  )
  private Integer clientDefinedInteger53;
  @Column(
    name   = "clientDefinedInteger54",
    length = 11
  )
  private Integer clientDefinedInteger54;
  @Column(
    name   = "clientDefinedInteger55",
    length = 11
  )
  private Integer clientDefinedInteger55;
  @Column(
    name   = "clientDefinedInteger56",
    length = 11
  )
  private Integer clientDefinedInteger56;
  @Column(
    name   = "clientDefinedInteger57",
    length = 11
  )
  private Integer clientDefinedInteger57;
  @Column(
    name   = "clientDefinedInteger58",
    length = 11
  )
  private Integer clientDefinedInteger58;
  @Column(
    name   = "clientDefinedInteger59",
    length = 11
  )
  private Integer clientDefinedInteger59;
  @Column(
    name   = "clientDefinedInteger6",
    length = 11
  )
  private Integer clientDefinedInteger6;
  @Column(
    name   = "clientDefinedInteger60",
    length = 11
  )
  private Integer clientDefinedInteger60;

  @Column(
    name   = "clientDefinedInteger61",
    length = 11
  )
  private Integer clientDefinedInteger61;

  @Column(
    name   = "clientDefinedInteger62",
    length = 11
  )
  private Integer clientDefinedInteger62;
  @Column(
    name   = "clientDefinedInteger63",
    length = 11
  )
  private Integer clientDefinedInteger63;
  @Column(
    name   = "clientDefinedInteger64",
    length = 11
  )
  private Integer clientDefinedInteger64;
  @Column(
    name   = "clientDefinedInteger65",
    length = 11
  )
  private Integer clientDefinedInteger65;
  @Column(
    name   = "clientDefinedInteger66",
    length = 11
  )
  private Integer clientDefinedInteger66;
  @Column(
    name   = "clientDefinedInteger67",
    length = 11
  )
  private Integer clientDefinedInteger67;
  @Column(
    name   = "clientDefinedInteger68",
    length = 11
  )
  private Integer clientDefinedInteger68;
  @Column(
    name   = "clientDefinedInteger69",
    length = 11
  )
  private Integer clientDefinedInteger69;
  @Column(
    name   = "clientDefinedInteger7",
    length = 11
  )
  private Integer clientDefinedInteger7;
  @Column(
    name   = "clientDefinedInteger70",
    length = 11
  )
  private Integer clientDefinedInteger70;

  @Column(
    name   = "clientDefinedInteger71",
    length = 11
  )
  private Integer clientDefinedInteger71;

  @Column(
    name   = "clientDefinedInteger72",
    length = 11
  )
  private Integer clientDefinedInteger72;
  @Column(
    name   = "clientDefinedInteger73",
    length = 11
  )
  private Integer clientDefinedInteger73;
  @Column(
    name   = "clientDefinedInteger74",
    length = 11
  )
  private Integer clientDefinedInteger74;
  @Column(
    name   = "clientDefinedInteger75",
    length = 11
  )
  private Integer clientDefinedInteger75;
  @Column(
    name   = "clientDefinedInteger76",
    length = 11
  )
  private Integer clientDefinedInteger76;
  @Column(
    name   = "clientDefinedInteger77",
    length = 11
  )
  private Integer clientDefinedInteger77;
  @Column(
    name   = "clientDefinedInteger78",
    length = 11
  )
  private Integer clientDefinedInteger78;
  @Column(
    name   = "clientDefinedInteger79",
    length = 11
  )
  private Integer clientDefinedInteger79;
  @Column(
    name   = "clientDefinedInteger8",
    length = 11
  )
  private Integer clientDefinedInteger8;
  @Column(
    name   = "clientDefinedInteger80",
    length = 11
  )
  private Integer clientDefinedInteger80;
  @Column(
    name   = "clientDefinedInteger81",
    length = 11
  )
  private Integer clientDefinedInteger81;

  @Column(
    name   = "clientDefinedInteger82",
    length = 11
  )
  private Integer clientDefinedInteger82;
  @Column(
    name   = "clientDefinedInteger83",
    length = 11
  )
  private Integer clientDefinedInteger83;
  @Column(
    name   = "clientDefinedInteger84",
    length = 11
  )
  private Integer clientDefinedInteger84;
  @Column(
    name   = "clientDefinedInteger85",
    length = 11
  )
  private Integer clientDefinedInteger85;
  @Column(
    name   = "clientDefinedInteger86",
    length = 11
  )
  private Integer clientDefinedInteger86;
  @Column(
    name   = "clientDefinedInteger87",
    length = 11
  )
  private Integer clientDefinedInteger87;
  @Column(
    name   = "clientDefinedInteger88",
    length = 11
  )
  private Integer clientDefinedInteger88;
  @Column(
    name   = "clientDefinedInteger89",
    length = 11
  )
  private Integer clientDefinedInteger89;
  @Column(
    name   = "clientDefinedInteger9",
    length = 11
  )
  private Integer clientDefinedInteger9;
  @Column(
    name   = "clientDefinedInteger90",
    length = 11
  )
  private Integer clientDefinedInteger90;
  @Column(
    name   = "clientDefinedInteger91",
    length = 11
  )
  private Integer clientDefinedInteger91;

  @Column(
    name   = "clientDefinedInteger92",
    length = 11
  )
  private Integer clientDefinedInteger92;
  @Column(
    name   = "clientDefinedInteger93",
    length = 11
  )
  private Integer clientDefinedInteger93;
  @Column(
    name   = "clientDefinedInteger94",
    length = 11
  )
  private Integer clientDefinedInteger94;
  @Column(
    name   = "clientDefinedInteger95",
    length = 11
  )
  private Integer clientDefinedInteger95;
  @Column(
    name   = "clientDefinedInteger96",
    length = 11
  )
  private Integer clientDefinedInteger96;
  @Column(
    name   = "clientDefinedInteger97",
    length = 11
  )
  private Integer clientDefinedInteger97;
  @Column(
    name   = "clientDefinedInteger98",
    length = 11
  )
  private Integer clientDefinedInteger98;
  @Column(
    name   = "clientDefinedInteger99",
    length = 11
  )
  private Integer clientDefinedInteger99;
  @Column(
    name   = "clientDefinedLong1",
    length = 30
  )
  private Long    clientDefinedLong1;

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
   * getter method for account extension id.
   *
   * @return  Long
   */
  public Long getAccountExtensionId() {
    return accountExtensionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code1.
   *
   * @return  String
   */
  public String getClientDefined10CharCode1() {
    return clientDefined10CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code2.
   *
   * @return  String
   */
  public String getClientDefined10CharCode2() {
    return clientDefined10CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code3.
   *
   * @return  String
   */
  public String getClientDefined10CharCode3() {
    return clientDefined10CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code4.
   *
   * @return  String
   */
  public String getClientDefined10CharCode4() {
    return clientDefined10CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined10 char code5.
   *
   * @return  String
   */
  public String getClientDefined10CharCode5() {
    return clientDefined10CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code1.
   *
   * @return  String
   */
  public String getClientDefined1CharCode1() {
    return clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code2.
   *
   * @return  String
   */
  public String getClientDefined1CharCode2() {
    return clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code3.
   *
   * @return  String
   */
  public String getClientDefined1CharCode3() {
    return clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code4.
   *
   * @return  String
   */
  public String getClientDefined1CharCode4() {
    return clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code5.
   *
   * @return  String
   */
  public String getClientDefined1CharCode5() {
    return clientDefined1CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined2 char code1.
   *
   * @return  String
   */
  public String getClientDefined2CharCode1() {
    return clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined2 char code2.
   *
   * @return  String
   */
  public String getClientDefined2CharCode2() {
    return clientDefined2CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined2 char code3.
   *
   * @return  String
   */
  public String getClientDefined2CharCode3() {
    return clientDefined2CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined2 char code4.
   *
   * @return  String
   */
  public String getClientDefined2CharCode4() {
    return clientDefined2CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined2 char code5.
   *
   * @return  String
   */
  public String getClientDefined2CharCode5() {
    return clientDefined2CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code1.
   *
   * @return  String
   */
  public String getClientDefined3CharCode1() {
    return clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code2.
   *
   * @return  String
   */
  public String getClientDefined3CharCode2() {
    return clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code3.
   *
   * @return  String
   */
  public String getClientDefined3CharCode3() {
    return clientDefined3CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code4.
   *
   * @return  String
   */
  public String getClientDefined3CharCode4() {
    return clientDefined3CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code5.
   *
   * @return  String
   */
  public String getClientDefined3CharCode5() {
    return clientDefined3CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined4 char code1.
   *
   * @return  String
   */
  public String getClientDefined4CharCode1() {
    return clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined4 char code2.
   *
   * @return  String
   */
  public String getClientDefined4CharCode2() {
    return clientDefined4CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined4 char code3.
   *
   * @return  String
   */
  public String getClientDefined4CharCode3() {
    return clientDefined4CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined4 char code4.
   *
   * @return  String
   */
  public String getClientDefined4CharCode4() {
    return clientDefined4CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined4 char code5.
   *
   * @return  String
   */
  public String getClientDefined4CharCode5() {
    return clientDefined4CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined5 char code1.
   *
   * @return  String
   */
  public String getClientDefined5CharCode1() {
    return clientDefined5CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined5 char code2.
   *
   * @return  String
   */
  public String getClientDefined5CharCode2() {
    return clientDefined5CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined5 char code3.
   *
   * @return  String
   */
  public String getClientDefined5CharCode3() {
    return clientDefined5CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined5 char code4.
   *
   * @return  String
   */
  public String getClientDefined5CharCode4() {
    return clientDefined5CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined5 char code5.
   *
   * @return  String
   */
  public String getClientDefined5CharCode5() {
    return clientDefined5CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined8 char code1.
   *
   * @return  String
   */
  public String getClientDefined8CharCode1() {
    return clientDefined8CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined8 char code2.
   *
   * @return  String
   */
  public String getClientDefined8CharCode2() {
    return clientDefined8CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined8 char code3.
   *
   * @return  String
   */
  public String getClientDefined8CharCode3() {
    return clientDefined8CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined8 char code4.
   *
   * @return  String
   */
  public String getClientDefined8CharCode4() {
    return clientDefined8CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined8 char code5.
   *
   * @return  String
   */
  public String getClientDefined8CharCode5() {
    return clientDefined8CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date1.
   *
   * @return  Date
   */
  public Date getClientDefinedDate1() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date2.
   *
   * @return  Date
   */
  public Date getClientDefinedDate2() {
    return clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date3.
   *
   * @return  Date
   */
  public Date getClientDefinedDate3() {
    return clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date4.
   *
   * @return  Date
   */
  public Date getClientDefinedDate4() {
    return clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date5.
   *
   * @return  Date
   */
  public Date getClientDefinedDate5() {
    return clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal1() {
    return clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal10.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal10() {
    return clientDefinedDecimal10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal11.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal11() {
    return clientDefinedDecimal11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal12.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal12() {
    return clientDefinedDecimal12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal13.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal13() {
    return clientDefinedDecimal13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal14.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal14() {
    return clientDefinedDecimal14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal15.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal15() {
    return clientDefinedDecimal15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal16.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal16() {
    return clientDefinedDecimal16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal17.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal17() {
    return clientDefinedDecimal17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal18.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal18() {
    return clientDefinedDecimal18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal19.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal19() {
    return clientDefinedDecimal19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal2.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal2() {
    return clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal20.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal20() {
    return clientDefinedDecimal20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal21.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal21() {
    return clientDefinedDecimal21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal22.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal22() {
    return clientDefinedDecimal22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal23.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal23() {
    return clientDefinedDecimal23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal24.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal24() {
    return clientDefinedDecimal24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal25.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal25() {
    return clientDefinedDecimal25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal26.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal26() {
    return clientDefinedDecimal26;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal27.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal27() {
    return clientDefinedDecimal27;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal28.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal28() {
    return clientDefinedDecimal28;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal29.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal29() {
    return clientDefinedDecimal29;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal3.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal3() {
    return clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal30.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal30() {
    return clientDefinedDecimal30;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal31.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal31() {
    return clientDefinedDecimal31;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal32.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal32() {
    return clientDefinedDecimal32;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal33.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal33() {
    return clientDefinedDecimal33;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal34.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal34() {
    return clientDefinedDecimal34;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal35.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal35() {
    return clientDefinedDecimal35;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal36.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal36() {
    return clientDefinedDecimal36;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal37.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal37() {
    return clientDefinedDecimal37;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal38.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal38() {
    return clientDefinedDecimal38;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal39.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal39() {
    return clientDefinedDecimal39;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal4.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal4() {
    return clientDefinedDecimal4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal40.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal40() {
    return clientDefinedDecimal40;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal41.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal41() {
    return clientDefinedDecimal41;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal42.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal42() {
    return clientDefinedDecimal42;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal43.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal43() {
    return clientDefinedDecimal43;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal44.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal44() {
    return clientDefinedDecimal44;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal45.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal45() {
    return clientDefinedDecimal45;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal46.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal46() {
    return clientDefinedDecimal46;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal47.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal47() {
    return clientDefinedDecimal47;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal48.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal48() {
    return clientDefinedDecimal48;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal49.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal49() {
    return clientDefinedDecimal49;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal5.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal5() {
    return clientDefinedDecimal5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal50.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal50() {
    return clientDefinedDecimal50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal6.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal6() {
    return clientDefinedDecimal6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal7.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal7() {
    return clientDefinedDecimal7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal8.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal8() {
    return clientDefinedDecimal8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal9.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal9() {
    return clientDefinedDecimal9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer1.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger1() {
    return clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer10.
   *
   * @return  Integer
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
   * getter method for client defined integer101.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger101() {
    return clientDefinedInteger101;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer102.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger102() {
    return clientDefinedInteger102;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer103.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger103() {
    return clientDefinedInteger103;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer104.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger104() {
    return clientDefinedInteger104;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer105.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger105() {
    return clientDefinedInteger105;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer106.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger106() {
    return clientDefinedInteger106;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer107.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger107() {
    return clientDefinedInteger107;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer108.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger108() {
    return clientDefinedInteger108;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer109.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger109() {
    return clientDefinedInteger109;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer11.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger11() {
    return clientDefinedInteger11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer110.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger110() {
    return clientDefinedInteger110;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer111.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger111() {
    return clientDefinedInteger111;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer112.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger112() {
    return clientDefinedInteger112;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer113.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger113() {
    return clientDefinedInteger113;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer114.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger114() {
    return clientDefinedInteger114;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer115.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger115() {
    return clientDefinedInteger115;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer116.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger116() {
    return clientDefinedInteger116;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer117.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger117() {
    return clientDefinedInteger117;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer118.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger118() {
    return clientDefinedInteger118;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer119.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger119() {
    return clientDefinedInteger119;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer12.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger12() {
    return clientDefinedInteger12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer120.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger120() {
    return clientDefinedInteger120;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer121.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger121() {
    return clientDefinedInteger121;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer122.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger122() {
    return clientDefinedInteger122;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer123.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger123() {
    return clientDefinedInteger123;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer124.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger124() {
    return clientDefinedInteger124;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer125.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger125() {
    return clientDefinedInteger125;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer126.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger126() {
    return clientDefinedInteger126;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer127.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger127() {
    return clientDefinedInteger127;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer128.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger128() {
    return clientDefinedInteger128;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer129.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger129() {
    return clientDefinedInteger129;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer13.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger13() {
    return clientDefinedInteger13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer130.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger130() {
    return clientDefinedInteger130;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer131.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger131() {
    return clientDefinedInteger131;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer132.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger132() {
    return clientDefinedInteger132;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer133.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger133() {
    return clientDefinedInteger133;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer134.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger134() {
    return clientDefinedInteger134;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer135.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger135() {
    return clientDefinedInteger135;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer136.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger136() {
    return clientDefinedInteger136;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer137.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger137() {
    return clientDefinedInteger137;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer138.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger138() {
    return clientDefinedInteger138;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer139.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger139() {
    return clientDefinedInteger139;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer14.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger14() {
    return clientDefinedInteger14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer140.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger140() {
    return clientDefinedInteger140;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer141.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger141() {
    return clientDefinedInteger141;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer142.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger142() {
    return clientDefinedInteger142;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer143.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger143() {
    return clientDefinedInteger143;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer144.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger144() {
    return clientDefinedInteger144;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer145.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger145() {
    return clientDefinedInteger145;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer146.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger146() {
    return clientDefinedInteger146;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer147.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger147() {
    return clientDefinedInteger147;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer148.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger148() {
    return clientDefinedInteger148;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer149.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger149() {
    return clientDefinedInteger149;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer15.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger15() {
    return clientDefinedInteger15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer150.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger150() {
    return clientDefinedInteger150;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer151.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger151() {
    return clientDefinedInteger151;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer152.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger152() {
    return clientDefinedInteger152;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer153.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger153() {
    return clientDefinedInteger153;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer154.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger154() {
    return clientDefinedInteger154;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer155.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger155() {
    return clientDefinedInteger155;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer156.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger156() {
    return clientDefinedInteger156;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer157.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger157() {
    return clientDefinedInteger157;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer158.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger158() {
    return clientDefinedInteger158;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer159.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger159() {
    return clientDefinedInteger159;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer16.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger16() {
    return clientDefinedInteger16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer160.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger160() {
    return clientDefinedInteger160;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer161.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger161() {
    return clientDefinedInteger161;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer162.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger162() {
    return clientDefinedInteger162;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer163.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger163() {
    return clientDefinedInteger163;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer164.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger164() {
    return clientDefinedInteger164;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer165.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger165() {
    return clientDefinedInteger165;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer166.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger166() {
    return clientDefinedInteger166;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer167.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger167() {
    return clientDefinedInteger167;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer168.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger168() {
    return clientDefinedInteger168;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer169.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger169() {
    return clientDefinedInteger169;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer17.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger17() {
    return clientDefinedInteger17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer170.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger170() {
    return clientDefinedInteger170;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer171.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger171() {
    return clientDefinedInteger171;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer172.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger172() {
    return clientDefinedInteger172;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer173.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger173() {
    return clientDefinedInteger173;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer174.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger174() {
    return clientDefinedInteger174;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer175.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger175() {
    return clientDefinedInteger175;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer176.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger176() {
    return clientDefinedInteger176;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer177.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger177() {
    return clientDefinedInteger177;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer178.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger178() {
    return clientDefinedInteger178;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer179.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger179() {
    return clientDefinedInteger179;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer18.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger18() {
    return clientDefinedInteger18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer180.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger180() {
    return clientDefinedInteger180;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer181.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger181() {
    return clientDefinedInteger181;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer182.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger182() {
    return clientDefinedInteger182;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer183.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger183() {
    return clientDefinedInteger183;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer184.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger184() {
    return clientDefinedInteger184;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer185.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger185() {
    return clientDefinedInteger185;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer186.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger186() {
    return clientDefinedInteger186;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer187.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger187() {
    return clientDefinedInteger187;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer188.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger188() {
    return clientDefinedInteger188;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer189.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger189() {
    return clientDefinedInteger189;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer19.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger19() {
    return clientDefinedInteger19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer190.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger190() {
    return clientDefinedInteger190;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer191.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger191() {
    return clientDefinedInteger191;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer192.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger192() {
    return clientDefinedInteger192;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer193.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger193() {
    return clientDefinedInteger193;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer194.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger194() {
    return clientDefinedInteger194;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer195.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger195() {
    return clientDefinedInteger195;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer196.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger196() {
    return clientDefinedInteger196;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer197.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger197() {
    return clientDefinedInteger197;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer198.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger198() {
    return clientDefinedInteger198;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer199.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger199() {
    return clientDefinedInteger199;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer2.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger2() {
    return clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer20.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger20() {
    return clientDefinedInteger20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer200.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger200() {
    return clientDefinedInteger200;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer201.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger201() {
    return clientDefinedInteger201;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer202.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger202() {
    return clientDefinedInteger202;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer203.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger203() {
    return clientDefinedInteger203;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer204.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger204() {
    return clientDefinedInteger204;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined integer205.
   *
   * @return  Integer
   */
  public Integer getClientDefinedInteger205() {
    return clientDefinedInteger205;
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
   * getter method for client defined integer3.
   *
   * @return  Integer
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
   * getter method for client defined integer4.
   *
   * @return  Integer
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
   * getter method for client defined integer5.
   *
   * @return  Integer
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
   * getter method for client defined integer6.
   *
   * @return  Integer
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
   * getter method for client defined integer7.
   *
   * @return  Integer
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
   * getter method for client defined integer8.
   *
   * @return  Integer
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
   * getter method for client defined integer9.
   *
   * @return  Integer
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
   * getter method for client defined long1.
   *
   * @return  Long
   */
  public Long getClientDefinedLong1() {
    return clientDefinedLong1;
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
   * setter method for account extension id.
   *
   * @param  accountExtensionId  Long
   */
  public void setAccountExtensionId(Long accountExtensionId) {
    this.accountExtensionId = accountExtensionId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code1.
   *
   * @param  clientDefined10CharCode1  String
   */
  public void setClientDefined10CharCode1(String clientDefined10CharCode1) {
    this.clientDefined10CharCode1 = clientDefined10CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code2.
   *
   * @param  clientDefined10CharCode2  String
   */
  public void setClientDefined10CharCode2(String clientDefined10CharCode2) {
    this.clientDefined10CharCode2 = clientDefined10CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code3.
   *
   * @param  clientDefined10CharCode3  String
   */
  public void setClientDefined10CharCode3(String clientDefined10CharCode3) {
    this.clientDefined10CharCode3 = clientDefined10CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code4.
   *
   * @param  clientDefined10CharCode4  String
   */
  public void setClientDefined10CharCode4(String clientDefined10CharCode4) {
    this.clientDefined10CharCode4 = clientDefined10CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined10 char code5.
   *
   * @param  clientDefined10CharCode5  String
   */
  public void setClientDefined10CharCode5(String clientDefined10CharCode5) {
    this.clientDefined10CharCode5 = clientDefined10CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code1.
   *
   * @param  clientDefined1CharCode1  String
   */
  public void setClientDefined1CharCode1(String clientDefined1CharCode1) {
    this.clientDefined1CharCode1 = clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code2.
   *
   * @param  clientDefined1CharCode2  String
   */
  public void setClientDefined1CharCode2(String clientDefined1CharCode2) {
    this.clientDefined1CharCode2 = clientDefined1CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code3.
   *
   * @param  clientDefined1CharCode3  String
   */
  public void setClientDefined1CharCode3(String clientDefined1CharCode3) {
    this.clientDefined1CharCode3 = clientDefined1CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code4.
   *
   * @param  clientDefined1CharCode4  String
   */
  public void setClientDefined1CharCode4(String clientDefined1CharCode4) {
    this.clientDefined1CharCode4 = clientDefined1CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code5.
   *
   * @param  clientDefined1CharCode5  String
   */
  public void setClientDefined1CharCode5(String clientDefined1CharCode5) {
    this.clientDefined1CharCode5 = clientDefined1CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined2 char code1.
   *
   * @param  clientDefined2CharCode1  String
   */
  public void setClientDefined2CharCode1(String clientDefined2CharCode1) {
    this.clientDefined2CharCode1 = clientDefined2CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined2 char code2.
   *
   * @param  clientDefined2CharCode2  String
   */
  public void setClientDefined2CharCode2(String clientDefined2CharCode2) {
    this.clientDefined2CharCode2 = clientDefined2CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined2 char code3.
   *
   * @param  clientDefined2CharCode3  String
   */
  public void setClientDefined2CharCode3(String clientDefined2CharCode3) {
    this.clientDefined2CharCode3 = clientDefined2CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined2 char code4.
   *
   * @param  clientDefined2CharCode4  String
   */
  public void setClientDefined2CharCode4(String clientDefined2CharCode4) {
    this.clientDefined2CharCode4 = clientDefined2CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined2 char code5.
   *
   * @param  clientDefined2CharCode5  String
   */
  public void setClientDefined2CharCode5(String clientDefined2CharCode5) {
    this.clientDefined2CharCode5 = clientDefined2CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined3 char code1.
   *
   * @param  clientDefined3CharCode1  String
   */
  public void setClientDefined3CharCode1(String clientDefined3CharCode1) {
    this.clientDefined3CharCode1 = clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined3 char code2.
   *
   * @param  clientDefined3CharCode2  String
   */
  public void setClientDefined3CharCode2(String clientDefined3CharCode2) {
    this.clientDefined3CharCode2 = clientDefined3CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined3 char code3.
   *
   * @param  clientDefined3CharCode3  String
   */
  public void setClientDefined3CharCode3(String clientDefined3CharCode3) {
    this.clientDefined3CharCode3 = clientDefined3CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined3 char code4.
   *
   * @param  clientDefined3CharCode4  String
   */
  public void setClientDefined3CharCode4(String clientDefined3CharCode4) {
    this.clientDefined3CharCode4 = clientDefined3CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined3 char code5.
   *
   * @param  clientDefined3CharCode5  String
   */
  public void setClientDefined3CharCode5(String clientDefined3CharCode5) {
    this.clientDefined3CharCode5 = clientDefined3CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined4 char code1.
   *
   * @param  clientDefined4CharCode1  String
   */
  public void setClientDefined4CharCode1(String clientDefined4CharCode1) {
    this.clientDefined4CharCode1 = clientDefined4CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined4 char code2.
   *
   * @param  clientDefined4CharCode2  String
   */
  public void setClientDefined4CharCode2(String clientDefined4CharCode2) {
    this.clientDefined4CharCode2 = clientDefined4CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined4 char code3.
   *
   * @param  clientDefined4CharCode3  String
   */
  public void setClientDefined4CharCode3(String clientDefined4CharCode3) {
    this.clientDefined4CharCode3 = clientDefined4CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined4 char code4.
   *
   * @param  clientDefined4CharCode4  String
   */
  public void setClientDefined4CharCode4(String clientDefined4CharCode4) {
    this.clientDefined4CharCode4 = clientDefined4CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined4 char code5.
   *
   * @param  clientDefined4CharCode5  String
   */
  public void setClientDefined4CharCode5(String clientDefined4CharCode5) {
    this.clientDefined4CharCode5 = clientDefined4CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined5 char code1.
   *
   * @param  clientDefined5CharCode1  String
   */
  public void setClientDefined5CharCode1(String clientDefined5CharCode1) {
    this.clientDefined5CharCode1 = clientDefined5CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined5 char code2.
   *
   * @param  clientDefined5CharCode2  String
   */
  public void setClientDefined5CharCode2(String clientDefined5CharCode2) {
    this.clientDefined5CharCode2 = clientDefined5CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined5 char code3.
   *
   * @param  clientDefined5CharCode3  String
   */
  public void setClientDefined5CharCode3(String clientDefined5CharCode3) {
    this.clientDefined5CharCode3 = clientDefined5CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined5 char code4.
   *
   * @param  clientDefined5CharCode4  String
   */
  public void setClientDefined5CharCode4(String clientDefined5CharCode4) {
    this.clientDefined5CharCode4 = clientDefined5CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined5 char code5.
   *
   * @param  clientDefined5CharCode5  String
   */
  public void setClientDefined5CharCode5(String clientDefined5CharCode5) {
    this.clientDefined5CharCode5 = clientDefined5CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined8 char code1.
   *
   * @param  clientDefined8CharCode1  String
   */
  public void setClientDefined8CharCode1(String clientDefined8CharCode1) {
    this.clientDefined8CharCode1 = clientDefined8CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined8 char code2.
   *
   * @param  clientDefined8CharCode2  String
   */
  public void setClientDefined8CharCode2(String clientDefined8CharCode2) {
    this.clientDefined8CharCode2 = clientDefined8CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined8 char code3.
   *
   * @param  clientDefined8CharCode3  String
   */
  public void setClientDefined8CharCode3(String clientDefined8CharCode3) {
    this.clientDefined8CharCode3 = clientDefined8CharCode3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined8 char code4.
   *
   * @param  clientDefined8CharCode4  String
   */
  public void setClientDefined8CharCode4(String clientDefined8CharCode4) {
    this.clientDefined8CharCode4 = clientDefined8CharCode4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined8 char code5.
   *
   * @param  clientDefined8CharCode5  String
   */
  public void setClientDefined8CharCode5(String clientDefined8CharCode5) {
    this.clientDefined8CharCode5 = clientDefined8CharCode5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date1.
   *
   * @param  clientDefinedDate1  Date
   */
  public void setClientDefinedDate1(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date2.
   *
   * @param  clientDefinedDate2  Date
   */
  public void setClientDefinedDate2(Date clientDefinedDate2) {
    this.clientDefinedDate2 = clientDefinedDate2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date3.
   *
   * @param  clientDefinedDate3  Date
   */
  public void setClientDefinedDate3(Date clientDefinedDate3) {
    this.clientDefinedDate3 = clientDefinedDate3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date4.
   *
   * @param  clientDefinedDate4  Date
   */
  public void setClientDefinedDate4(Date clientDefinedDate4) {
    this.clientDefinedDate4 = clientDefinedDate4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date5.
   *
   * @param  clientDefinedDate5  Date
   */
  public void setClientDefinedDate5(Date clientDefinedDate5) {
    this.clientDefinedDate5 = clientDefinedDate5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal1.
   *
   * @param  clientDefinedDecimal1  BigDecimal
   */
  public void setClientDefinedDecimal1(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal10.
   *
   * @param  clientDefinedDecimal10  BigDecimal
   */
  public void setClientDefinedDecimal10(BigDecimal clientDefinedDecimal10) {
    this.clientDefinedDecimal10 = clientDefinedDecimal10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal11.
   *
   * @param  clientDefinedDecimal11  BigDecimal
   */
  public void setClientDefinedDecimal11(BigDecimal clientDefinedDecimal11) {
    this.clientDefinedDecimal11 = clientDefinedDecimal11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal12.
   *
   * @param  clientDefinedDecimal12  BigDecimal
   */
  public void setClientDefinedDecimal12(BigDecimal clientDefinedDecimal12) {
    this.clientDefinedDecimal12 = clientDefinedDecimal12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal13.
   *
   * @param  clientDefinedDecimal13  BigDecimal
   */
  public void setClientDefinedDecimal13(BigDecimal clientDefinedDecimal13) {
    this.clientDefinedDecimal13 = clientDefinedDecimal13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal14.
   *
   * @param  clientDefinedDecimal14  BigDecimal
   */
  public void setClientDefinedDecimal14(BigDecimal clientDefinedDecimal14) {
    this.clientDefinedDecimal14 = clientDefinedDecimal14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal15.
   *
   * @param  clientDefinedDecimal15  BigDecimal
   */
  public void setClientDefinedDecimal15(BigDecimal clientDefinedDecimal15) {
    this.clientDefinedDecimal15 = clientDefinedDecimal15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal16.
   *
   * @param  clientDefinedDecimal16  BigDecimal
   */
  public void setClientDefinedDecimal16(BigDecimal clientDefinedDecimal16) {
    this.clientDefinedDecimal16 = clientDefinedDecimal16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal17.
   *
   * @param  clientDefinedDecimal17  BigDecimal
   */
  public void setClientDefinedDecimal17(BigDecimal clientDefinedDecimal17) {
    this.clientDefinedDecimal17 = clientDefinedDecimal17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal18.
   *
   * @param  clientDefinedDecimal18  BigDecimal
   */
  public void setClientDefinedDecimal18(BigDecimal clientDefinedDecimal18) {
    this.clientDefinedDecimal18 = clientDefinedDecimal18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal19.
   *
   * @param  clientDefinedDecimal19  BigDecimal
   */
  public void setClientDefinedDecimal19(BigDecimal clientDefinedDecimal19) {
    this.clientDefinedDecimal19 = clientDefinedDecimal19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal2.
   *
   * @param  clientDefinedDecimal2  BigDecimal
   */
  public void setClientDefinedDecimal2(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal20.
   *
   * @param  clientDefinedDecimal20  BigDecimal
   */
  public void setClientDefinedDecimal20(BigDecimal clientDefinedDecimal20) {
    this.clientDefinedDecimal20 = clientDefinedDecimal20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal21.
   *
   * @param  clientDefinedDecimal21  BigDecimal
   */
  public void setClientDefinedDecimal21(BigDecimal clientDefinedDecimal21) {
    this.clientDefinedDecimal21 = clientDefinedDecimal21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal22.
   *
   * @param  clientDefinedDecimal22  BigDecimal
   */
  public void setClientDefinedDecimal22(BigDecimal clientDefinedDecimal22) {
    this.clientDefinedDecimal22 = clientDefinedDecimal22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal23.
   *
   * @param  clientDefinedDecimal23  BigDecimal
   */
  public void setClientDefinedDecimal23(BigDecimal clientDefinedDecimal23) {
    this.clientDefinedDecimal23 = clientDefinedDecimal23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal24.
   *
   * @param  clientDefinedDecimal24  BigDecimal
   */
  public void setClientDefinedDecimal24(BigDecimal clientDefinedDecimal24) {
    this.clientDefinedDecimal24 = clientDefinedDecimal24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal25.
   *
   * @param  clientDefinedDecimal25  BigDecimal
   */
  public void setClientDefinedDecimal25(BigDecimal clientDefinedDecimal25) {
    this.clientDefinedDecimal25 = clientDefinedDecimal25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal26.
   *
   * @param  clientDefinedDecimal26  BigDecimal
   */
  public void setClientDefinedDecimal26(BigDecimal clientDefinedDecimal26) {
    this.clientDefinedDecimal26 = clientDefinedDecimal26;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal27.
   *
   * @param  clientDefinedDecimal27  BigDecimal
   */
  public void setClientDefinedDecimal27(BigDecimal clientDefinedDecimal27) {
    this.clientDefinedDecimal27 = clientDefinedDecimal27;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal28.
   *
   * @param  clientDefinedDecimal28  BigDecimal
   */
  public void setClientDefinedDecimal28(BigDecimal clientDefinedDecimal28) {
    this.clientDefinedDecimal28 = clientDefinedDecimal28;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal29.
   *
   * @param  clientDefinedDecimal29  BigDecimal
   */
  public void setClientDefinedDecimal29(BigDecimal clientDefinedDecimal29) {
    this.clientDefinedDecimal29 = clientDefinedDecimal29;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal3.
   *
   * @param  clientDefinedDecimal3  BigDecimal
   */
  public void setClientDefinedDecimal3(BigDecimal clientDefinedDecimal3) {
    this.clientDefinedDecimal3 = clientDefinedDecimal3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal30.
   *
   * @param  clientDefinedDecimal30  BigDecimal
   */
  public void setClientDefinedDecimal30(BigDecimal clientDefinedDecimal30) {
    this.clientDefinedDecimal30 = clientDefinedDecimal30;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal31.
   *
   * @param  clientDefinedDecimal31  BigDecimal
   */
  public void setClientDefinedDecimal31(BigDecimal clientDefinedDecimal31) {
    this.clientDefinedDecimal31 = clientDefinedDecimal31;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal32.
   *
   * @param  clientDefinedDecimal32  BigDecimal
   */
  public void setClientDefinedDecimal32(BigDecimal clientDefinedDecimal32) {
    this.clientDefinedDecimal32 = clientDefinedDecimal32;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal33.
   *
   * @param  clientDefinedDecimal33  BigDecimal
   */
  public void setClientDefinedDecimal33(BigDecimal clientDefinedDecimal33) {
    this.clientDefinedDecimal33 = clientDefinedDecimal33;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal34.
   *
   * @param  clientDefinedDecimal34  BigDecimal
   */
  public void setClientDefinedDecimal34(BigDecimal clientDefinedDecimal34) {
    this.clientDefinedDecimal34 = clientDefinedDecimal34;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal35.
   *
   * @param  clientDefinedDecimal35  BigDecimal
   */
  public void setClientDefinedDecimal35(BigDecimal clientDefinedDecimal35) {
    this.clientDefinedDecimal35 = clientDefinedDecimal35;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal36.
   *
   * @param  clientDefinedDecimal36  BigDecimal
   */
  public void setClientDefinedDecimal36(BigDecimal clientDefinedDecimal36) {
    this.clientDefinedDecimal36 = clientDefinedDecimal36;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal37.
   *
   * @param  clientDefinedDecimal37  BigDecimal
   */
  public void setClientDefinedDecimal37(BigDecimal clientDefinedDecimal37) {
    this.clientDefinedDecimal37 = clientDefinedDecimal37;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal38.
   *
   * @param  clientDefinedDecimal38  BigDecimal
   */
  public void setClientDefinedDecimal38(BigDecimal clientDefinedDecimal38) {
    this.clientDefinedDecimal38 = clientDefinedDecimal38;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal39.
   *
   * @param  clientDefinedDecimal39  BigDecimal
   */
  public void setClientDefinedDecimal39(BigDecimal clientDefinedDecimal39) {
    this.clientDefinedDecimal39 = clientDefinedDecimal39;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal4.
   *
   * @param  clientDefinedDecimal4  BigDecimal
   */
  public void setClientDefinedDecimal4(BigDecimal clientDefinedDecimal4) {
    this.clientDefinedDecimal4 = clientDefinedDecimal4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal40.
   *
   * @param  clientDefinedDecimal40  BigDecimal
   */
  public void setClientDefinedDecimal40(BigDecimal clientDefinedDecimal40) {
    this.clientDefinedDecimal40 = clientDefinedDecimal40;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal41.
   *
   * @param  clientDefinedDecimal41  BigDecimal
   */
  public void setClientDefinedDecimal41(BigDecimal clientDefinedDecimal41) {
    this.clientDefinedDecimal41 = clientDefinedDecimal41;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal42.
   *
   * @param  clientDefinedDecimal42  BigDecimal
   */
  public void setClientDefinedDecimal42(BigDecimal clientDefinedDecimal42) {
    this.clientDefinedDecimal42 = clientDefinedDecimal42;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal43.
   *
   * @param  clientDefinedDecimal43  BigDecimal
   */
  public void setClientDefinedDecimal43(BigDecimal clientDefinedDecimal43) {
    this.clientDefinedDecimal43 = clientDefinedDecimal43;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal44.
   *
   * @param  clientDefinedDecimal44  BigDecimal
   */
  public void setClientDefinedDecimal44(BigDecimal clientDefinedDecimal44) {
    this.clientDefinedDecimal44 = clientDefinedDecimal44;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal45.
   *
   * @param  clientDefinedDecimal45  BigDecimal
   */
  public void setClientDefinedDecimal45(BigDecimal clientDefinedDecimal45) {
    this.clientDefinedDecimal45 = clientDefinedDecimal45;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal46.
   *
   * @param  clientDefinedDecimal46  BigDecimal
   */
  public void setClientDefinedDecimal46(BigDecimal clientDefinedDecimal46) {
    this.clientDefinedDecimal46 = clientDefinedDecimal46;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal47.
   *
   * @param  clientDefinedDecimal47  BigDecimal
   */
  public void setClientDefinedDecimal47(BigDecimal clientDefinedDecimal47) {
    this.clientDefinedDecimal47 = clientDefinedDecimal47;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal48.
   *
   * @param  clientDefinedDecimal48  BigDecimal
   */
  public void setClientDefinedDecimal48(BigDecimal clientDefinedDecimal48) {
    this.clientDefinedDecimal48 = clientDefinedDecimal48;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal49.
   *
   * @param  clientDefinedDecimal49  BigDecimal
   */
  public void setClientDefinedDecimal49(BigDecimal clientDefinedDecimal49) {
    this.clientDefinedDecimal49 = clientDefinedDecimal49;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal5.
   *
   * @param  clientDefinedDecimal5  BigDecimal
   */
  public void setClientDefinedDecimal5(BigDecimal clientDefinedDecimal5) {
    this.clientDefinedDecimal5 = clientDefinedDecimal5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal50.
   *
   * @param  clientDefinedDecimal50  BigDecimal
   */
  public void setClientDefinedDecimal50(BigDecimal clientDefinedDecimal50) {
    this.clientDefinedDecimal50 = clientDefinedDecimal50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal6.
   *
   * @param  clientDefinedDecimal6  BigDecimal
   */
  public void setClientDefinedDecimal6(BigDecimal clientDefinedDecimal6) {
    this.clientDefinedDecimal6 = clientDefinedDecimal6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal7.
   *
   * @param  clientDefinedDecimal7  BigDecimal
   */
  public void setClientDefinedDecimal7(BigDecimal clientDefinedDecimal7) {
    this.clientDefinedDecimal7 = clientDefinedDecimal7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal8.
   *
   * @param  clientDefinedDecimal8  BigDecimal
   */
  public void setClientDefinedDecimal8(BigDecimal clientDefinedDecimal8) {
    this.clientDefinedDecimal8 = clientDefinedDecimal8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal9.
   *
   * @param  clientDefinedDecimal9  BigDecimal
   */
  public void setClientDefinedDecimal9(BigDecimal clientDefinedDecimal9) {
    this.clientDefinedDecimal9 = clientDefinedDecimal9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer1.
   *
   * @param  clientDefinedInteger1  Integer
   */
  public void setClientDefinedInteger1(Integer clientDefinedInteger1) {
    this.clientDefinedInteger1 = clientDefinedInteger1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer10.
   *
   * @param  clientDefinedInteger10  Integer
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
   * setter method for client defined integer101.
   *
   * @param  clientDefinedInteger101  Integer
   */
  public void setClientDefinedInteger101(Integer clientDefinedInteger101) {
    this.clientDefinedInteger101 = clientDefinedInteger101;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer102.
   *
   * @param  clientDefinedInteger102  Integer
   */
  public void setClientDefinedInteger102(Integer clientDefinedInteger102) {
    this.clientDefinedInteger102 = clientDefinedInteger102;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer103.
   *
   * @param  clientDefinedInteger103  Integer
   */
  public void setClientDefinedInteger103(Integer clientDefinedInteger103) {
    this.clientDefinedInteger103 = clientDefinedInteger103;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer104.
   *
   * @param  clientDefinedInteger104  Integer
   */
  public void setClientDefinedInteger104(Integer clientDefinedInteger104) {
    this.clientDefinedInteger104 = clientDefinedInteger104;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer105.
   *
   * @param  clientDefinedInteger105  Integer
   */
  public void setClientDefinedInteger105(Integer clientDefinedInteger105) {
    this.clientDefinedInteger105 = clientDefinedInteger105;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer106.
   *
   * @param  clientDefinedInteger106  Integer
   */
  public void setClientDefinedInteger106(Integer clientDefinedInteger106) {
    this.clientDefinedInteger106 = clientDefinedInteger106;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer107.
   *
   * @param  clientDefinedInteger107  Integer
   */
  public void setClientDefinedInteger107(Integer clientDefinedInteger107) {
    this.clientDefinedInteger107 = clientDefinedInteger107;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer108.
   *
   * @param  clientDefinedInteger108  Integer
   */
  public void setClientDefinedInteger108(Integer clientDefinedInteger108) {
    this.clientDefinedInteger108 = clientDefinedInteger108;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer109.
   *
   * @param  clientDefinedInteger109  Integer
   */
  public void setClientDefinedInteger109(Integer clientDefinedInteger109) {
    this.clientDefinedInteger109 = clientDefinedInteger109;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer11.
   *
   * @param  clientDefinedInteger11  Integer
   */
  public void setClientDefinedInteger11(Integer clientDefinedInteger11) {
    this.clientDefinedInteger11 = clientDefinedInteger11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer110.
   *
   * @param  clientDefinedInteger110  Integer
   */
  public void setClientDefinedInteger110(Integer clientDefinedInteger110) {
    this.clientDefinedInteger110 = clientDefinedInteger110;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer111.
   *
   * @param  clientDefinedInteger111  Integer
   */
  public void setClientDefinedInteger111(Integer clientDefinedInteger111) {
    this.clientDefinedInteger111 = clientDefinedInteger111;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer112.
   *
   * @param  clientDefinedInteger112  Integer
   */
  public void setClientDefinedInteger112(Integer clientDefinedInteger112) {
    this.clientDefinedInteger112 = clientDefinedInteger112;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer113.
   *
   * @param  clientDefinedInteger113  Integer
   */
  public void setClientDefinedInteger113(Integer clientDefinedInteger113) {
    this.clientDefinedInteger113 = clientDefinedInteger113;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer114.
   *
   * @param  clientDefinedInteger114  Integer
   */
  public void setClientDefinedInteger114(Integer clientDefinedInteger114) {
    this.clientDefinedInteger114 = clientDefinedInteger114;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer115.
   *
   * @param  clientDefinedInteger115  Integer
   */
  public void setClientDefinedInteger115(Integer clientDefinedInteger115) {
    this.clientDefinedInteger115 = clientDefinedInteger115;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer116.
   *
   * @param  clientDefinedInteger116  Integer
   */
  public void setClientDefinedInteger116(Integer clientDefinedInteger116) {
    this.clientDefinedInteger116 = clientDefinedInteger116;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer117.
   *
   * @param  clientDefinedInteger117  Integer
   */
  public void setClientDefinedInteger117(Integer clientDefinedInteger117) {
    this.clientDefinedInteger117 = clientDefinedInteger117;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer118.
   *
   * @param  clientDefinedInteger118  Integer
   */
  public void setClientDefinedInteger118(Integer clientDefinedInteger118) {
    this.clientDefinedInteger118 = clientDefinedInteger118;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer119.
   *
   * @param  clientDefinedInteger119  Integer
   */
  public void setClientDefinedInteger119(Integer clientDefinedInteger119) {
    this.clientDefinedInteger119 = clientDefinedInteger119;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer12.
   *
   * @param  clientDefinedInteger12  Integer
   */
  public void setClientDefinedInteger12(Integer clientDefinedInteger12) {
    this.clientDefinedInteger12 = clientDefinedInteger12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer120.
   *
   * @param  clientDefinedInteger120  Integer
   */
  public void setClientDefinedInteger120(Integer clientDefinedInteger120) {
    this.clientDefinedInteger120 = clientDefinedInteger120;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer121.
   *
   * @param  clientDefinedInteger121  Integer
   */
  public void setClientDefinedInteger121(Integer clientDefinedInteger121) {
    this.clientDefinedInteger121 = clientDefinedInteger121;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer122.
   *
   * @param  clientDefinedInteger122  Integer
   */
  public void setClientDefinedInteger122(Integer clientDefinedInteger122) {
    this.clientDefinedInteger122 = clientDefinedInteger122;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer123.
   *
   * @param  clientDefinedInteger123  Integer
   */
  public void setClientDefinedInteger123(Integer clientDefinedInteger123) {
    this.clientDefinedInteger123 = clientDefinedInteger123;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer124.
   *
   * @param  clientDefinedInteger124  Integer
   */
  public void setClientDefinedInteger124(Integer clientDefinedInteger124) {
    this.clientDefinedInteger124 = clientDefinedInteger124;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer125.
   *
   * @param  clientDefinedInteger125  Integer
   */
  public void setClientDefinedInteger125(Integer clientDefinedInteger125) {
    this.clientDefinedInteger125 = clientDefinedInteger125;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer126.
   *
   * @param  clientDefinedInteger126  Integer
   */
  public void setClientDefinedInteger126(Integer clientDefinedInteger126) {
    this.clientDefinedInteger126 = clientDefinedInteger126;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer127.
   *
   * @param  clientDefinedInteger127  Integer
   */
  public void setClientDefinedInteger127(Integer clientDefinedInteger127) {
    this.clientDefinedInteger127 = clientDefinedInteger127;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer128.
   *
   * @param  clientDefinedInteger128  Integer
   */
  public void setClientDefinedInteger128(Integer clientDefinedInteger128) {
    this.clientDefinedInteger128 = clientDefinedInteger128;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer129.
   *
   * @param  clientDefinedInteger129  Integer
   */
  public void setClientDefinedInteger129(Integer clientDefinedInteger129) {
    this.clientDefinedInteger129 = clientDefinedInteger129;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer13.
   *
   * @param  clientDefinedInteger13  Integer
   */
  public void setClientDefinedInteger13(Integer clientDefinedInteger13) {
    this.clientDefinedInteger13 = clientDefinedInteger13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer130.
   *
   * @param  clientDefinedInteger130  Integer
   */
  public void setClientDefinedInteger130(Integer clientDefinedInteger130) {
    this.clientDefinedInteger130 = clientDefinedInteger130;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer131.
   *
   * @param  clientDefinedInteger131  Integer
   */
  public void setClientDefinedInteger131(Integer clientDefinedInteger131) {
    this.clientDefinedInteger131 = clientDefinedInteger131;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer132.
   *
   * @param  clientDefinedInteger132  Integer
   */
  public void setClientDefinedInteger132(Integer clientDefinedInteger132) {
    this.clientDefinedInteger132 = clientDefinedInteger132;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer133.
   *
   * @param  clientDefinedInteger133  Integer
   */
  public void setClientDefinedInteger133(Integer clientDefinedInteger133) {
    this.clientDefinedInteger133 = clientDefinedInteger133;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer134.
   *
   * @param  clientDefinedInteger134  Integer
   */
  public void setClientDefinedInteger134(Integer clientDefinedInteger134) {
    this.clientDefinedInteger134 = clientDefinedInteger134;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer135.
   *
   * @param  clientDefinedInteger135  Integer
   */
  public void setClientDefinedInteger135(Integer clientDefinedInteger135) {
    this.clientDefinedInteger135 = clientDefinedInteger135;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer136.
   *
   * @param  clientDefinedInteger136  Integer
   */
  public void setClientDefinedInteger136(Integer clientDefinedInteger136) {
    this.clientDefinedInteger136 = clientDefinedInteger136;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer137.
   *
   * @param  clientDefinedInteger137  Integer
   */
  public void setClientDefinedInteger137(Integer clientDefinedInteger137) {
    this.clientDefinedInteger137 = clientDefinedInteger137;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer138.
   *
   * @param  clientDefinedInteger138  Integer
   */
  public void setClientDefinedInteger138(Integer clientDefinedInteger138) {
    this.clientDefinedInteger138 = clientDefinedInteger138;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer139.
   *
   * @param  clientDefinedInteger139  Integer
   */
  public void setClientDefinedInteger139(Integer clientDefinedInteger139) {
    this.clientDefinedInteger139 = clientDefinedInteger139;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer14.
   *
   * @param  clientDefinedInteger14  Integer
   */
  public void setClientDefinedInteger14(Integer clientDefinedInteger14) {
    this.clientDefinedInteger14 = clientDefinedInteger14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer140.
   *
   * @param  clientDefinedInteger140  Integer
   */
  public void setClientDefinedInteger140(Integer clientDefinedInteger140) {
    this.clientDefinedInteger140 = clientDefinedInteger140;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer141.
   *
   * @param  clientDefinedInteger141  Integer
   */
  public void setClientDefinedInteger141(Integer clientDefinedInteger141) {
    this.clientDefinedInteger141 = clientDefinedInteger141;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer142.
   *
   * @param  clientDefinedInteger142  Integer
   */
  public void setClientDefinedInteger142(Integer clientDefinedInteger142) {
    this.clientDefinedInteger142 = clientDefinedInteger142;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer143.
   *
   * @param  clientDefinedInteger143  Integer
   */
  public void setClientDefinedInteger143(Integer clientDefinedInteger143) {
    this.clientDefinedInteger143 = clientDefinedInteger143;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer144.
   *
   * @param  clientDefinedInteger144  Integer
   */
  public void setClientDefinedInteger144(Integer clientDefinedInteger144) {
    this.clientDefinedInteger144 = clientDefinedInteger144;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer145.
   *
   * @param  clientDefinedInteger145  Integer
   */
  public void setClientDefinedInteger145(Integer clientDefinedInteger145) {
    this.clientDefinedInteger145 = clientDefinedInteger145;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer146.
   *
   * @param  clientDefinedInteger146  Integer
   */
  public void setClientDefinedInteger146(Integer clientDefinedInteger146) {
    this.clientDefinedInteger146 = clientDefinedInteger146;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer147.
   *
   * @param  clientDefinedInteger147  Integer
   */
  public void setClientDefinedInteger147(Integer clientDefinedInteger147) {
    this.clientDefinedInteger147 = clientDefinedInteger147;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer148.
   *
   * @param  clientDefinedInteger148  Integer
   */
  public void setClientDefinedInteger148(Integer clientDefinedInteger148) {
    this.clientDefinedInteger148 = clientDefinedInteger148;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer149.
   *
   * @param  clientDefinedInteger149  Integer
   */
  public void setClientDefinedInteger149(Integer clientDefinedInteger149) {
    this.clientDefinedInteger149 = clientDefinedInteger149;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer15.
   *
   * @param  clientDefinedInteger15  Integer
   */
  public void setClientDefinedInteger15(Integer clientDefinedInteger15) {
    this.clientDefinedInteger15 = clientDefinedInteger15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer150.
   *
   * @param  clientDefinedInteger150  Integer
   */
  public void setClientDefinedInteger150(Integer clientDefinedInteger150) {
    this.clientDefinedInteger150 = clientDefinedInteger150;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer151.
   *
   * @param  clientDefinedInteger151  Integer
   */
  public void setClientDefinedInteger151(Integer clientDefinedInteger151) {
    this.clientDefinedInteger151 = clientDefinedInteger151;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer152.
   *
   * @param  clientDefinedInteger152  Integer
   */
  public void setClientDefinedInteger152(Integer clientDefinedInteger152) {
    this.clientDefinedInteger152 = clientDefinedInteger152;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer153.
   *
   * @param  clientDefinedInteger153  Integer
   */
  public void setClientDefinedInteger153(Integer clientDefinedInteger153) {
    this.clientDefinedInteger153 = clientDefinedInteger153;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer154.
   *
   * @param  clientDefinedInteger154  Integer
   */
  public void setClientDefinedInteger154(Integer clientDefinedInteger154) {
    this.clientDefinedInteger154 = clientDefinedInteger154;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer155.
   *
   * @param  clientDefinedInteger155  Integer
   */
  public void setClientDefinedInteger155(Integer clientDefinedInteger155) {
    this.clientDefinedInteger155 = clientDefinedInteger155;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer156.
   *
   * @param  clientDefinedInteger156  Integer
   */
  public void setClientDefinedInteger156(Integer clientDefinedInteger156) {
    this.clientDefinedInteger156 = clientDefinedInteger156;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer157.
   *
   * @param  clientDefinedInteger157  Integer
   */
  public void setClientDefinedInteger157(Integer clientDefinedInteger157) {
    this.clientDefinedInteger157 = clientDefinedInteger157;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer158.
   *
   * @param  clientDefinedInteger158  Integer
   */
  public void setClientDefinedInteger158(Integer clientDefinedInteger158) {
    this.clientDefinedInteger158 = clientDefinedInteger158;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer159.
   *
   * @param  clientDefinedInteger159  Integer
   */
  public void setClientDefinedInteger159(Integer clientDefinedInteger159) {
    this.clientDefinedInteger159 = clientDefinedInteger159;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer16.
   *
   * @param  clientDefinedInteger16  Integer
   */
  public void setClientDefinedInteger16(Integer clientDefinedInteger16) {
    this.clientDefinedInteger16 = clientDefinedInteger16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer160.
   *
   * @param  clientDefinedInteger160  Integer
   */
  public void setClientDefinedInteger160(Integer clientDefinedInteger160) {
    this.clientDefinedInteger160 = clientDefinedInteger160;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer161.
   *
   * @param  clientDefinedInteger161  Integer
   */
  public void setClientDefinedInteger161(Integer clientDefinedInteger161) {
    this.clientDefinedInteger161 = clientDefinedInteger161;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer162.
   *
   * @param  clientDefinedInteger162  Integer
   */
  public void setClientDefinedInteger162(Integer clientDefinedInteger162) {
    this.clientDefinedInteger162 = clientDefinedInteger162;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer163.
   *
   * @param  clientDefinedInteger163  Integer
   */
  public void setClientDefinedInteger163(Integer clientDefinedInteger163) {
    this.clientDefinedInteger163 = clientDefinedInteger163;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer164.
   *
   * @param  clientDefinedInteger164  Integer
   */
  public void setClientDefinedInteger164(Integer clientDefinedInteger164) {
    this.clientDefinedInteger164 = clientDefinedInteger164;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer165.
   *
   * @param  clientDefinedInteger165  Integer
   */
  public void setClientDefinedInteger165(Integer clientDefinedInteger165) {
    this.clientDefinedInteger165 = clientDefinedInteger165;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer166.
   *
   * @param  clientDefinedInteger166  Integer
   */
  public void setClientDefinedInteger166(Integer clientDefinedInteger166) {
    this.clientDefinedInteger166 = clientDefinedInteger166;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer167.
   *
   * @param  clientDefinedInteger167  Integer
   */
  public void setClientDefinedInteger167(Integer clientDefinedInteger167) {
    this.clientDefinedInteger167 = clientDefinedInteger167;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer168.
   *
   * @param  clientDefinedInteger168  Integer
   */
  public void setClientDefinedInteger168(Integer clientDefinedInteger168) {
    this.clientDefinedInteger168 = clientDefinedInteger168;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer169.
   *
   * @param  clientDefinedInteger169  Integer
   */
  public void setClientDefinedInteger169(Integer clientDefinedInteger169) {
    this.clientDefinedInteger169 = clientDefinedInteger169;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer17.
   *
   * @param  clientDefinedInteger17  Integer
   */
  public void setClientDefinedInteger17(Integer clientDefinedInteger17) {
    this.clientDefinedInteger17 = clientDefinedInteger17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer170.
   *
   * @param  clientDefinedInteger170  Integer
   */
  public void setClientDefinedInteger170(Integer clientDefinedInteger170) {
    this.clientDefinedInteger170 = clientDefinedInteger170;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer171.
   *
   * @param  clientDefinedInteger171  Integer
   */
  public void setClientDefinedInteger171(Integer clientDefinedInteger171) {
    this.clientDefinedInteger171 = clientDefinedInteger171;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer172.
   *
   * @param  clientDefinedInteger172  Integer
   */
  public void setClientDefinedInteger172(Integer clientDefinedInteger172) {
    this.clientDefinedInteger172 = clientDefinedInteger172;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer173.
   *
   * @param  clientDefinedInteger173  Integer
   */
  public void setClientDefinedInteger173(Integer clientDefinedInteger173) {
    this.clientDefinedInteger173 = clientDefinedInteger173;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer174.
   *
   * @param  clientDefinedInteger174  Integer
   */
  public void setClientDefinedInteger174(Integer clientDefinedInteger174) {
    this.clientDefinedInteger174 = clientDefinedInteger174;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer175.
   *
   * @param  clientDefinedInteger175  Integer
   */
  public void setClientDefinedInteger175(Integer clientDefinedInteger175) {
    this.clientDefinedInteger175 = clientDefinedInteger175;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer176.
   *
   * @param  clientDefinedInteger176  Integer
   */
  public void setClientDefinedInteger176(Integer clientDefinedInteger176) {
    this.clientDefinedInteger176 = clientDefinedInteger176;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer177.
   *
   * @param  clientDefinedInteger177  Integer
   */
  public void setClientDefinedInteger177(Integer clientDefinedInteger177) {
    this.clientDefinedInteger177 = clientDefinedInteger177;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer178.
   *
   * @param  clientDefinedInteger178  Integer
   */
  public void setClientDefinedInteger178(Integer clientDefinedInteger178) {
    this.clientDefinedInteger178 = clientDefinedInteger178;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer179.
   *
   * @param  clientDefinedInteger179  Integer
   */
  public void setClientDefinedInteger179(Integer clientDefinedInteger179) {
    this.clientDefinedInteger179 = clientDefinedInteger179;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer18.
   *
   * @param  clientDefinedInteger18  Integer
   */
  public void setClientDefinedInteger18(Integer clientDefinedInteger18) {
    this.clientDefinedInteger18 = clientDefinedInteger18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer180.
   *
   * @param  clientDefinedInteger180  Integer
   */
  public void setClientDefinedInteger180(Integer clientDefinedInteger180) {
    this.clientDefinedInteger180 = clientDefinedInteger180;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer181.
   *
   * @param  clientDefinedInteger181  Integer
   */
  public void setClientDefinedInteger181(Integer clientDefinedInteger181) {
    this.clientDefinedInteger181 = clientDefinedInteger181;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer182.
   *
   * @param  clientDefinedInteger182  Integer
   */
  public void setClientDefinedInteger182(Integer clientDefinedInteger182) {
    this.clientDefinedInteger182 = clientDefinedInteger182;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer183.
   *
   * @param  clientDefinedInteger183  Integer
   */
  public void setClientDefinedInteger183(Integer clientDefinedInteger183) {
    this.clientDefinedInteger183 = clientDefinedInteger183;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer184.
   *
   * @param  clientDefinedInteger184  Integer
   */
  public void setClientDefinedInteger184(Integer clientDefinedInteger184) {
    this.clientDefinedInteger184 = clientDefinedInteger184;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer185.
   *
   * @param  clientDefinedInteger185  Integer
   */
  public void setClientDefinedInteger185(Integer clientDefinedInteger185) {
    this.clientDefinedInteger185 = clientDefinedInteger185;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer186.
   *
   * @param  clientDefinedInteger186  Integer
   */
  public void setClientDefinedInteger186(Integer clientDefinedInteger186) {
    this.clientDefinedInteger186 = clientDefinedInteger186;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer187.
   *
   * @param  clientDefinedInteger187  Integer
   */
  public void setClientDefinedInteger187(Integer clientDefinedInteger187) {
    this.clientDefinedInteger187 = clientDefinedInteger187;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer188.
   *
   * @param  clientDefinedInteger188  Integer
   */
  public void setClientDefinedInteger188(Integer clientDefinedInteger188) {
    this.clientDefinedInteger188 = clientDefinedInteger188;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer189.
   *
   * @param  clientDefinedInteger189  Integer
   */
  public void setClientDefinedInteger189(Integer clientDefinedInteger189) {
    this.clientDefinedInteger189 = clientDefinedInteger189;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer19.
   *
   * @param  clientDefinedInteger19  Integer
   */
  public void setClientDefinedInteger19(Integer clientDefinedInteger19) {
    this.clientDefinedInteger19 = clientDefinedInteger19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer190.
   *
   * @param  clientDefinedInteger190  Integer
   */
  public void setClientDefinedInteger190(Integer clientDefinedInteger190) {
    this.clientDefinedInteger190 = clientDefinedInteger190;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer191.
   *
   * @param  clientDefinedInteger191  Integer
   */
  public void setClientDefinedInteger191(Integer clientDefinedInteger191) {
    this.clientDefinedInteger191 = clientDefinedInteger191;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer192.
   *
   * @param  clientDefinedInteger192  Integer
   */
  public void setClientDefinedInteger192(Integer clientDefinedInteger192) {
    this.clientDefinedInteger192 = clientDefinedInteger192;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer193.
   *
   * @param  clientDefinedInteger193  Integer
   */
  public void setClientDefinedInteger193(Integer clientDefinedInteger193) {
    this.clientDefinedInteger193 = clientDefinedInteger193;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer194.
   *
   * @param  clientDefinedInteger194  Integer
   */
  public void setClientDefinedInteger194(Integer clientDefinedInteger194) {
    this.clientDefinedInteger194 = clientDefinedInteger194;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer195.
   *
   * @param  clientDefinedInteger195  Integer
   */
  public void setClientDefinedInteger195(Integer clientDefinedInteger195) {
    this.clientDefinedInteger195 = clientDefinedInteger195;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer196.
   *
   * @param  clientDefinedInteger196  Integer
   */
  public void setClientDefinedInteger196(Integer clientDefinedInteger196) {
    this.clientDefinedInteger196 = clientDefinedInteger196;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer197.
   *
   * @param  clientDefinedInteger197  Integer
   */
  public void setClientDefinedInteger197(Integer clientDefinedInteger197) {
    this.clientDefinedInteger197 = clientDefinedInteger197;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer198.
   *
   * @param  clientDefinedInteger198  Integer
   */
  public void setClientDefinedInteger198(Integer clientDefinedInteger198) {
    this.clientDefinedInteger198 = clientDefinedInteger198;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer199.
   *
   * @param  clientDefinedInteger199  Integer
   */
  public void setClientDefinedInteger199(Integer clientDefinedInteger199) {
    this.clientDefinedInteger199 = clientDefinedInteger199;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer2.
   *
   * @param  clientDefinedInteger2  Integer
   */
  public void setClientDefinedInteger2(Integer clientDefinedInteger2) {
    this.clientDefinedInteger2 = clientDefinedInteger2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer20.
   *
   * @param  clientDefinedInteger20  Integer
   */
  public void setClientDefinedInteger20(Integer clientDefinedInteger20) {
    this.clientDefinedInteger20 = clientDefinedInteger20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer200.
   *
   * @param  clientDefinedInteger200  Integer
   */
  public void setClientDefinedInteger200(Integer clientDefinedInteger200) {
    this.clientDefinedInteger200 = clientDefinedInteger200;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer201.
   *
   * @param  clientDefinedInteger201  Integer
   */
  public void setClientDefinedInteger201(Integer clientDefinedInteger201) {
    this.clientDefinedInteger201 = clientDefinedInteger201;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer202.
   *
   * @param  clientDefinedInteger202  Integer
   */
  public void setClientDefinedInteger202(Integer clientDefinedInteger202) {
    this.clientDefinedInteger202 = clientDefinedInteger202;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer203.
   *
   * @param  clientDefinedInteger203  Integer
   */
  public void setClientDefinedInteger203(Integer clientDefinedInteger203) {
    this.clientDefinedInteger203 = clientDefinedInteger203;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer204.
   *
   * @param  clientDefinedInteger204  Integer
   */
  public void setClientDefinedInteger204(Integer clientDefinedInteger204) {
    this.clientDefinedInteger204 = clientDefinedInteger204;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined integer205.
   *
   * @param  clientDefinedInteger205  Integer
   */
  public void setClientDefinedInteger205(Integer clientDefinedInteger205) {
    this.clientDefinedInteger205 = clientDefinedInteger205;
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
   * setter method for client defined integer3.
   *
   * @param  clientDefinedInteger3  Integer
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
   * setter method for client defined integer4.
   *
   * @param  clientDefinedInteger4  Integer
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
   * setter method for client defined integer5.
   *
   * @param  clientDefinedInteger5  Integer
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
   * setter method for client defined integer6.
   *
   * @param  clientDefinedInteger6  Integer
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
   * setter method for client defined integer7.
   *
   * @param  clientDefinedInteger7  Integer
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
   * setter method for client defined integer8.
   *
   * @param  clientDefinedInteger8  Integer
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
   * setter method for client defined integer9.
   *
   * @param  clientDefinedInteger9  Integer
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined long1.
   *
   * @param  clientDefinedLong1  Long
   */
  public void setClientDefinedLong1(Long clientDefinedLong1) {
    this.clientDefinedLong1 = clientDefinedLong1;
  }
} // end class AccountExtension
