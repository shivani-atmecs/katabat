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
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  07/24/2015 17:19
 */
@Entity
@Table(name = "AccountExtensionDecimal")
public class AccountExtensionDecimal extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7098157910902637779L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "accountExtensionDecimalId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long accountExtensionCharId;


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
    name      = "clientDefinedDecimal100",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal100;


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
    name      = "clientDefinedDecimal51",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal51;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal52",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal52;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal53",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal53;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal54",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal54;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal55",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal55;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal56",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal56;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal57",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal57;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal58",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal58;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal59",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal59;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal6",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal6;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal60",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal60;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal61",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal61;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal62",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal62;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal63",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal63;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal64",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal64;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal65",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal65;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal66",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal66;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal67",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal67;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal68",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal68;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal69",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal69;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal7",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal7;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal70",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal70;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal71",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal71;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal72",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal72;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal73",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal73;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal74",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal74;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal75",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal75;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal76",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal76;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal77",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal77;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal78",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal78;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal79",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal79;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal8",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal8;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal80",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal80;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal81",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal81;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal82",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal82;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal83",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal83;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal84",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal84;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal85",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal85;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal86",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal86;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal87",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal87;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal88",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal88;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal89",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal89;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal9",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal9;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal90",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal90;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal91",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal91;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal92",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal92;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal93",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal93;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal94",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal94;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal95",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal95;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal96",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal96;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal97",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal97;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal98",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal98;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "clientDefinedDecimal99",
    precision = 19,
    scale     = 8
  )
  protected BigDecimal clientDefinedDecimal99;

  @Column(
          name = "clientDefinedDecimal101",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal101;
  @Column(
          name = "clientDefinedDecimal102",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal102;
  @Column(
          name = "clientDefinedDecimal103",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal103;
  @Column(
          name = "clientDefinedDecimal104",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal104;
  @Column(
          name = "clientDefinedDecimal105",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal105;
  @Column(
          name = "clientDefinedDecimal106",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal106;
  @Column(
          name = "clientDefinedDecimal107",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal107;
  @Column(
          name = "clientDefinedDecimal108",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal108;
  @Column(
          name = "clientDefinedDecimal109",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal109;
  @Column(
          name = "clientDefinedDecimal110",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal110;
  @Column(
          name = "clientDefinedDecimal111",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal111;
  @Column(
          name = "clientDefinedDecimal112",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal112;
  @Column(
          name = "clientDefinedDecimal113",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal113;
  @Column(
          name = "clientDefinedDecimal114",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal114;
  @Column(
          name = "clientDefinedDecimal115",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal115;
  @Column(
          name = "clientDefinedDecimal116",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal116;
  @Column(
          name = "clientDefinedDecimal117",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal117;
  @Column(
          name = "clientDefinedDecimal118",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal118;
  @Column(
          name = "clientDefinedDecimal119",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal119;
  @Column(
          name = "clientDefinedDecimal120",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal120;
  @Column(
          name = "clientDefinedDecimal121",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal121;
  @Column(
          name = "clientDefinedDecimal122",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal122;
  @Column(
          name = "clientDefinedDecimal123",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal123;
  @Column(
          name = "clientDefinedDecimal124",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal124;
  @Column(
          name = "clientDefinedDecimal125",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal125;
  @Column(
          name = "clientDefinedDecimal126",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal126;
  @Column(
          name = "clientDefinedDecimal127",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal127;
  @Column(
          name = "clientDefinedDecimal128",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal128;
  @Column(
          name = "clientDefinedDecimal129",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal129;
  @Column(
          name = "clientDefinedDecimal130",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal130;
  @Column(
          name = "clientDefinedDecimal131",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal131;
  @Column(
          name = "clientDefinedDecimal132",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal132;
  @Column(
          name = "clientDefinedDecimal133",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal133;
  @Column(
          name = "clientDefinedDecimal134",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal134;
  @Column(
          name = "clientDefinedDecimal135",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal135;
  @Column(
          name = "clientDefinedDecimal136",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal136;
  @Column(
          name = "clientDefinedDecimal137",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal137;
  @Column(
          name = "clientDefinedDecimal138",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal138;
  @Column(
          name = "clientDefinedDecimal139",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal139;
  @Column(
          name = "clientDefinedDecimal140",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal140;
  @Column(
          name = "clientDefinedDecimal141",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal141;
  @Column(
          name = "clientDefinedDecimal142",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal142;
  @Column(
          name = "clientDefinedDecimal143",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal143;
  @Column(
          name = "clientDefinedDecimal144",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal144;
  @Column(
          name = "clientDefinedDecimal145",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal145;
  @Column(
          name = "clientDefinedDecimal146",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal146;
  @Column(
          name = "clientDefinedDecimal147",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal147;
  @Column(
          name = "clientDefinedDecimal148",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal148;
  @Column(
          name = "clientDefinedDecimal149",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal149;
  @Column(
          name = "clientDefinedDecimal150",
          precision = 19,
          scale = 8
  )
  protected BigDecimal clientDefinedDecimal150;

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
  public Long getAccountExtensionCharId() {
    return accountExtensionCharId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal1() {
    return clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal10() {
    return clientDefinedDecimal10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal100.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal100() {
    return clientDefinedDecimal100;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal11() {
    return clientDefinedDecimal11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal12() {
    return clientDefinedDecimal12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal13() {
    return clientDefinedDecimal13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal14() {
    return clientDefinedDecimal14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal15() {
    return clientDefinedDecimal15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal16() {
    return clientDefinedDecimal16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal17() {
    return clientDefinedDecimal17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal18() {
    return clientDefinedDecimal18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal19() {
    return clientDefinedDecimal19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal2() {
    return clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
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
   * BigDecimal.
   *
   * @return  BigDecimal.
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
   * BigDecimal.
   *
   * @return  BigDecimal.
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
   * BigDecimal.
   *
   * @return  BigDecimal.
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
   * getter method for client defined decimal51.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal51() {
    return clientDefinedDecimal51;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal52.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal52() {
    return clientDefinedDecimal52;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal53.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal53() {
    return clientDefinedDecimal53;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal54.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal54() {
    return clientDefinedDecimal54;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal55.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal55() {
    return clientDefinedDecimal55;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal56.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal56() {
    return clientDefinedDecimal56;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal57.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal57() {
    return clientDefinedDecimal57;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal58.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal58() {
    return clientDefinedDecimal58;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal59.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal59() {
    return clientDefinedDecimal59;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal6() {
    return clientDefinedDecimal6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal60.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal60() {
    return clientDefinedDecimal60;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal61.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal61() {
    return clientDefinedDecimal61;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal62.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal62() {
    return clientDefinedDecimal62;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal63.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal63() {
    return clientDefinedDecimal63;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal64.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal64() {
    return clientDefinedDecimal64;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal65.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal65() {
    return clientDefinedDecimal65;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal66.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal66() {
    return clientDefinedDecimal66;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal67.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal67() {
    return clientDefinedDecimal67;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal68.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal68() {
    return clientDefinedDecimal68;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal69.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal69() {
    return clientDefinedDecimal69;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal7() {
    return clientDefinedDecimal7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal70.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal70() {
    return clientDefinedDecimal70;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal71.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal71() {
    return clientDefinedDecimal71;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal72.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal72() {
    return clientDefinedDecimal72;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal73.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal73() {
    return clientDefinedDecimal73;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal74.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal74() {
    return clientDefinedDecimal74;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal75.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal75() {
    return clientDefinedDecimal75;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal76.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal76() {
    return clientDefinedDecimal76;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal77.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal77() {
    return clientDefinedDecimal77;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal78.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal78() {
    return clientDefinedDecimal78;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal79.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal79() {
    return clientDefinedDecimal79;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal8() {
    return clientDefinedDecimal8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal80.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal80() {
    return clientDefinedDecimal80;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal81.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal81() {
    return clientDefinedDecimal81;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal82.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal82() {
    return clientDefinedDecimal82;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal83.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal83() {
    return clientDefinedDecimal83;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal84.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal84() {
    return clientDefinedDecimal84;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal85.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal85() {
    return clientDefinedDecimal85;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal86.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal86() {
    return clientDefinedDecimal86;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal87.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal87() {
    return clientDefinedDecimal87;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal88.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal88() {
    return clientDefinedDecimal88;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal89.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal89() {
    return clientDefinedDecimal89;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * BigDecimal.
   *
   * @return  BigDecimal.
   */
  public BigDecimal getClientDefinedDecimal9() {
    return clientDefinedDecimal9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal90.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal90() {
    return clientDefinedDecimal90;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal91.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal91() {
    return clientDefinedDecimal91;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal92.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal92() {
    return clientDefinedDecimal92;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal93.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal93() {
    return clientDefinedDecimal93;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal94.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal94() {
    return clientDefinedDecimal94;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal95.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal95() {
    return clientDefinedDecimal95;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal96.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal96() {
    return clientDefinedDecimal96;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal97.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal97() {
    return clientDefinedDecimal97;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal98.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal98() {
    return clientDefinedDecimal98;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal99.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal99() {
    return clientDefinedDecimal99;
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
   * setClientDefinedDecimal1.
   *
   * @param  clientDefinedDecimal1  $param.type$
   */
  public void setClientDefinedDecimal1(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDecimal10.
   *
   * @param  clientDefinedDecimal10  $param.type$
   */
  public void setClientDefinedDecimal10(BigDecimal clientDefinedDecimal10) {
    this.clientDefinedDecimal10 = clientDefinedDecimal10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal100.
   *
   * @param  clientDefinedDecimal100  BigDecimal
   */
  public void setClientDefinedDecimal100(BigDecimal clientDefinedDecimal100) {
    this.clientDefinedDecimal100 = clientDefinedDecimal100;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDecimal11.
   *
   * @param  clientDefinedDecimal11  $param.type$
   */
  public void setClientDefinedDecimal11(BigDecimal clientDefinedDecimal11) {
    this.clientDefinedDecimal11 = clientDefinedDecimal11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDecimal12.
   *
   * @param  clientDefinedDecimal12  $param.type$
   */
  public void setClientDefinedDecimal12(BigDecimal clientDefinedDecimal12) {
    this.clientDefinedDecimal12 = clientDefinedDecimal12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDecimal13.
   *
   * @param  clientDefinedDecimal13  $param.type$
   */
  public void setClientDefinedDecimal13(BigDecimal clientDefinedDecimal13) {
    this.clientDefinedDecimal13 = clientDefinedDecimal13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDecimal14.
   *
   * @param  clientDefinedDecimal14  $param.type$
   */
  public void setClientDefinedDecimal14(BigDecimal clientDefinedDecimal14) {
    this.clientDefinedDecimal14 = clientDefinedDecimal14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDecimal15.
   *
   * @param  clientDefinedDecimal15  $param.type$
   */
  public void setClientDefinedDecimal15(BigDecimal clientDefinedDecimal15) {
    this.clientDefinedDecimal15 = clientDefinedDecimal15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDecimal16.
   *
   * @param  clientDefinedDecimal16  $param.type$
   */
  public void setClientDefinedDecimal16(BigDecimal clientDefinedDecimal16) {
    this.clientDefinedDecimal16 = clientDefinedDecimal16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDecimal17.
   *
   * @param  clientDefinedDecimal17  $param.type$
   */
  public void setClientDefinedDecimal17(BigDecimal clientDefinedDecimal17) {
    this.clientDefinedDecimal17 = clientDefinedDecimal17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDecimal18.
   *
   * @param  clientDefinedDecimal18  $param.type$
   */
  public void setClientDefinedDecimal18(BigDecimal clientDefinedDecimal18) {
    this.clientDefinedDecimal18 = clientDefinedDecimal18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDecimal19.
   *
   * @param  clientDefinedDecimal19  $param.type$
   */
  public void setClientDefinedDecimal19(BigDecimal clientDefinedDecimal19) {
    this.clientDefinedDecimal19 = clientDefinedDecimal19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDecimal2.
   *
   * @param  clientDefinedDecimal2  $param.type$
   */
  public void setClientDefinedDecimal2(BigDecimal clientDefinedDecimal2) {
    this.clientDefinedDecimal2 = clientDefinedDecimal2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDecimal20.
   *
   * @param  clientDefinedDecimal20  $param.type$
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
   * setClientDefinedDecimal3.
   *
   * @param  clientDefinedDecimal3  $param.type$
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
   * setClientDefinedDecimal4.
   *
   * @param  clientDefinedDecimal4  $param.type$
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
   * setClientDefinedDecimal5.
   *
   * @param  clientDefinedDecimal5  $param.type$
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
   * setter method for client defined decimal51.
   *
   * @param  clientDefinedDecimal51  BigDecimal
   */
  public void setClientDefinedDecimal51(BigDecimal clientDefinedDecimal51) {
    this.clientDefinedDecimal51 = clientDefinedDecimal51;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal52.
   *
   * @param  clientDefinedDecimal52  BigDecimal
   */
  public void setClientDefinedDecimal52(BigDecimal clientDefinedDecimal52) {
    this.clientDefinedDecimal52 = clientDefinedDecimal52;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal53.
   *
   * @param  clientDefinedDecimal53  BigDecimal
   */
  public void setClientDefinedDecimal53(BigDecimal clientDefinedDecimal53) {
    this.clientDefinedDecimal53 = clientDefinedDecimal53;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal54.
   *
   * @param  clientDefinedDecimal54  BigDecimal
   */
  public void setClientDefinedDecimal54(BigDecimal clientDefinedDecimal54) {
    this.clientDefinedDecimal54 = clientDefinedDecimal54;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal55.
   *
   * @param  clientDefinedDecimal55  BigDecimal
   */
  public void setClientDefinedDecimal55(BigDecimal clientDefinedDecimal55) {
    this.clientDefinedDecimal55 = clientDefinedDecimal55;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal56.
   *
   * @param  clientDefinedDecimal56  BigDecimal
   */
  public void setClientDefinedDecimal56(BigDecimal clientDefinedDecimal56) {
    this.clientDefinedDecimal56 = clientDefinedDecimal56;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal57.
   *
   * @param  clientDefinedDecimal57  BigDecimal
   */
  public void setClientDefinedDecimal57(BigDecimal clientDefinedDecimal57) {
    this.clientDefinedDecimal57 = clientDefinedDecimal57;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal58.
   *
   * @param  clientDefinedDecimal58  BigDecimal
   */
  public void setClientDefinedDecimal58(BigDecimal clientDefinedDecimal58) {
    this.clientDefinedDecimal58 = clientDefinedDecimal58;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal59.
   *
   * @param  clientDefinedDecimal59  BigDecimal
   */
  public void setClientDefinedDecimal59(BigDecimal clientDefinedDecimal59) {
    this.clientDefinedDecimal59 = clientDefinedDecimal59;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDecimal6.
   *
   * @param  clientDefinedDecimal6  $param.type$
   */
  public void setClientDefinedDecimal6(BigDecimal clientDefinedDecimal6) {
    this.clientDefinedDecimal6 = clientDefinedDecimal6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal60.
   *
   * @param  clientDefinedDecimal60  BigDecimal
   */
  public void setClientDefinedDecimal60(BigDecimal clientDefinedDecimal60) {
    this.clientDefinedDecimal60 = clientDefinedDecimal60;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal61.
   *
   * @param  clientDefinedDecimal61  BigDecimal
   */
  public void setClientDefinedDecimal61(BigDecimal clientDefinedDecimal61) {
    this.clientDefinedDecimal61 = clientDefinedDecimal61;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal62.
   *
   * @param  clientDefinedDecimal62  BigDecimal
   */
  public void setClientDefinedDecimal62(BigDecimal clientDefinedDecimal62) {
    this.clientDefinedDecimal62 = clientDefinedDecimal62;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal63.
   *
   * @param  clientDefinedDecimal63  BigDecimal
   */
  public void setClientDefinedDecimal63(BigDecimal clientDefinedDecimal63) {
    this.clientDefinedDecimal63 = clientDefinedDecimal63;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal64.
   *
   * @param  clientDefinedDecimal64  BigDecimal
   */
  public void setClientDefinedDecimal64(BigDecimal clientDefinedDecimal64) {
    this.clientDefinedDecimal64 = clientDefinedDecimal64;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal65.
   *
   * @param  clientDefinedDecimal65  BigDecimal
   */
  public void setClientDefinedDecimal65(BigDecimal clientDefinedDecimal65) {
    this.clientDefinedDecimal65 = clientDefinedDecimal65;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal66.
   *
   * @param  clientDefinedDecimal66  BigDecimal
   */
  public void setClientDefinedDecimal66(BigDecimal clientDefinedDecimal66) {
    this.clientDefinedDecimal66 = clientDefinedDecimal66;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal67.
   *
   * @param  clientDefinedDecimal67  BigDecimal
   */
  public void setClientDefinedDecimal67(BigDecimal clientDefinedDecimal67) {
    this.clientDefinedDecimal67 = clientDefinedDecimal67;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal68.
   *
   * @param  clientDefinedDecimal68  BigDecimal
   */
  public void setClientDefinedDecimal68(BigDecimal clientDefinedDecimal68) {
    this.clientDefinedDecimal68 = clientDefinedDecimal68;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal69.
   *
   * @param  clientDefinedDecimal69  BigDecimal
   */
  public void setClientDefinedDecimal69(BigDecimal clientDefinedDecimal69) {
    this.clientDefinedDecimal69 = clientDefinedDecimal69;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDecimal7.
   *
   * @param  clientDefinedDecimal7  $param.type$
   */
  public void setClientDefinedDecimal7(BigDecimal clientDefinedDecimal7) {
    this.clientDefinedDecimal7 = clientDefinedDecimal7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal70.
   *
   * @param  clientDefinedDecimal70  BigDecimal
   */
  public void setClientDefinedDecimal70(BigDecimal clientDefinedDecimal70) {
    this.clientDefinedDecimal70 = clientDefinedDecimal70;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal71.
   *
   * @param  clientDefinedDecimal71  BigDecimal
   */
  public void setClientDefinedDecimal71(BigDecimal clientDefinedDecimal71) {
    this.clientDefinedDecimal71 = clientDefinedDecimal71;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal72.
   *
   * @param  clientDefinedDecimal72  BigDecimal
   */
  public void setClientDefinedDecimal72(BigDecimal clientDefinedDecimal72) {
    this.clientDefinedDecimal72 = clientDefinedDecimal72;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal73.
   *
   * @param  clientDefinedDecimal73  BigDecimal
   */
  public void setClientDefinedDecimal73(BigDecimal clientDefinedDecimal73) {
    this.clientDefinedDecimal73 = clientDefinedDecimal73;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal74.
   *
   * @param  clientDefinedDecimal74  BigDecimal
   */
  public void setClientDefinedDecimal74(BigDecimal clientDefinedDecimal74) {
    this.clientDefinedDecimal74 = clientDefinedDecimal74;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal75.
   *
   * @param  clientDefinedDecimal75  BigDecimal
   */
  public void setClientDefinedDecimal75(BigDecimal clientDefinedDecimal75) {
    this.clientDefinedDecimal75 = clientDefinedDecimal75;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal76.
   *
   * @param  clientDefinedDecimal76  BigDecimal
   */
  public void setClientDefinedDecimal76(BigDecimal clientDefinedDecimal76) {
    this.clientDefinedDecimal76 = clientDefinedDecimal76;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal77.
   *
   * @param  clientDefinedDecimal77  BigDecimal
   */
  public void setClientDefinedDecimal77(BigDecimal clientDefinedDecimal77) {
    this.clientDefinedDecimal77 = clientDefinedDecimal77;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal78.
   *
   * @param  clientDefinedDecimal78  BigDecimal
   */
  public void setClientDefinedDecimal78(BigDecimal clientDefinedDecimal78) {
    this.clientDefinedDecimal78 = clientDefinedDecimal78;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal79.
   *
   * @param  clientDefinedDecimal79  BigDecimal
   */
  public void setClientDefinedDecimal79(BigDecimal clientDefinedDecimal79) {
    this.clientDefinedDecimal79 = clientDefinedDecimal79;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDecimal8.
   *
   * @param  clientDefinedDecimal8  $param.type$
   */
  public void setClientDefinedDecimal8(BigDecimal clientDefinedDecimal8) {
    this.clientDefinedDecimal8 = clientDefinedDecimal8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal80.
   *
   * @param  clientDefinedDecimal80  BigDecimal
   */
  public void setClientDefinedDecimal80(BigDecimal clientDefinedDecimal80) {
    this.clientDefinedDecimal80 = clientDefinedDecimal80;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal81.
   *
   * @param  clientDefinedDecimal81  BigDecimal
   */
  public void setClientDefinedDecimal81(BigDecimal clientDefinedDecimal81) {
    this.clientDefinedDecimal81 = clientDefinedDecimal81;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal82.
   *
   * @param  clientDefinedDecimal82  BigDecimal
   */
  public void setClientDefinedDecimal82(BigDecimal clientDefinedDecimal82) {
    this.clientDefinedDecimal82 = clientDefinedDecimal82;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal83.
   *
   * @param  clientDefinedDecimal83  BigDecimal
   */
  public void setClientDefinedDecimal83(BigDecimal clientDefinedDecimal83) {
    this.clientDefinedDecimal83 = clientDefinedDecimal83;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal84.
   *
   * @param  clientDefinedDecimal84  BigDecimal
   */
  public void setClientDefinedDecimal84(BigDecimal clientDefinedDecimal84) {
    this.clientDefinedDecimal84 = clientDefinedDecimal84;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal85.
   *
   * @param  clientDefinedDecimal85  BigDecimal
   */
  public void setClientDefinedDecimal85(BigDecimal clientDefinedDecimal85) {
    this.clientDefinedDecimal85 = clientDefinedDecimal85;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal86.
   *
   * @param  clientDefinedDecimal86  BigDecimal
   */
  public void setClientDefinedDecimal86(BigDecimal clientDefinedDecimal86) {
    this.clientDefinedDecimal86 = clientDefinedDecimal86;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal87.
   *
   * @param  clientDefinedDecimal87  BigDecimal
   */
  public void setClientDefinedDecimal87(BigDecimal clientDefinedDecimal87) {
    this.clientDefinedDecimal87 = clientDefinedDecimal87;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal88.
   *
   * @param  clientDefinedDecimal88  BigDecimal
   */
  public void setClientDefinedDecimal88(BigDecimal clientDefinedDecimal88) {
    this.clientDefinedDecimal88 = clientDefinedDecimal88;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal89.
   *
   * @param  clientDefinedDecimal89  BigDecimal
   */
  public void setClientDefinedDecimal89(BigDecimal clientDefinedDecimal89) {
    this.clientDefinedDecimal89 = clientDefinedDecimal89;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setClientDefinedDecimal9.
   *
   * @param  clientDefinedDecimal9  $param.type$
   */
  public void setClientDefinedDecimal9(BigDecimal clientDefinedDecimal9) {
    this.clientDefinedDecimal9 = clientDefinedDecimal9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal90.
   *
   * @param  clientDefinedDecimal90  BigDecimal
   */
  public void setClientDefinedDecimal90(BigDecimal clientDefinedDecimal90) {
    this.clientDefinedDecimal90 = clientDefinedDecimal90;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal91.
   *
   * @param  clientDefinedDecimal91  BigDecimal
   */
  public void setClientDefinedDecimal91(BigDecimal clientDefinedDecimal91) {
    this.clientDefinedDecimal91 = clientDefinedDecimal91;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal92.
   *
   * @param  clientDefinedDecimal92  BigDecimal
   */
  public void setClientDefinedDecimal92(BigDecimal clientDefinedDecimal92) {
    this.clientDefinedDecimal92 = clientDefinedDecimal92;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal93.
   *
   * @param  clientDefinedDecimal93  BigDecimal
   */
  public void setClientDefinedDecimal93(BigDecimal clientDefinedDecimal93) {
    this.clientDefinedDecimal93 = clientDefinedDecimal93;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal94.
   *
   * @param  clientDefinedDecimal94  BigDecimal
   */
  public void setClientDefinedDecimal94(BigDecimal clientDefinedDecimal94) {
    this.clientDefinedDecimal94 = clientDefinedDecimal94;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal95.
   *
   * @param  clientDefinedDecimal95  BigDecimal
   */
  public void setClientDefinedDecimal95(BigDecimal clientDefinedDecimal95) {
    this.clientDefinedDecimal95 = clientDefinedDecimal95;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal96.
   *
   * @param  clientDefinedDecimal96  BigDecimal
   */
  public void setClientDefinedDecimal96(BigDecimal clientDefinedDecimal96) {
    this.clientDefinedDecimal96 = clientDefinedDecimal96;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal97.
   *
   * @param  clientDefinedDecimal97  BigDecimal
   */
  public void setClientDefinedDecimal97(BigDecimal clientDefinedDecimal97) {
    this.clientDefinedDecimal97 = clientDefinedDecimal97;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal98.
   *
   * @param  clientDefinedDecimal98  BigDecimal
   */
  public void setClientDefinedDecimal98(BigDecimal clientDefinedDecimal98) {
    this.clientDefinedDecimal98 = clientDefinedDecimal98;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal99.
   *
   * @param  clientDefinedDecimal99  BigDecimal
   */
  public void setClientDefinedDecimal99(BigDecimal clientDefinedDecimal99) {
    this.clientDefinedDecimal99 = clientDefinedDecimal99;
  }

  public BigDecimal getClientDefinedDecimal101() {
    return clientDefinedDecimal101;
  }

  public void setClientDefinedDecimal101(BigDecimal clientDefinedDecimal101) {
    this.clientDefinedDecimal101 = clientDefinedDecimal101;
  }

  public BigDecimal getClientDefinedDecimal102() {
    return clientDefinedDecimal102;
  }

  public void setClientDefinedDecimal102(BigDecimal clientDefinedDecimal102) {
    this.clientDefinedDecimal102 = clientDefinedDecimal102;
  }

  public BigDecimal getClientDefinedDecimal103() {
    return clientDefinedDecimal103;
  }

  public void setClientDefinedDecimal103(BigDecimal clientDefinedDecimal103) {
    this.clientDefinedDecimal103 = clientDefinedDecimal103;
  }

  public BigDecimal getClientDefinedDecimal104() {
    return clientDefinedDecimal104;
  }

  public void setClientDefinedDecimal104(BigDecimal clientDefinedDecimal104) {
    this.clientDefinedDecimal104 = clientDefinedDecimal104;
  }

  public BigDecimal getClientDefinedDecimal105() {
    return clientDefinedDecimal105;
  }

  public void setClientDefinedDecimal105(BigDecimal clientDefinedDecimal105) {
    this.clientDefinedDecimal105 = clientDefinedDecimal105;
  }

  public BigDecimal getClientDefinedDecimal106() {
    return clientDefinedDecimal106;
  }

  public void setClientDefinedDecimal106(BigDecimal clientDefinedDecimal106) {
    this.clientDefinedDecimal106 = clientDefinedDecimal106;
  }

  public BigDecimal getClientDefinedDecimal107() {
    return clientDefinedDecimal107;
  }

  public void setClientDefinedDecimal107(BigDecimal clientDefinedDecimal107) {
    this.clientDefinedDecimal107 = clientDefinedDecimal107;
  }

  public BigDecimal getClientDefinedDecimal108() {
    return clientDefinedDecimal108;
  }

  public void setClientDefinedDecimal108(BigDecimal clientDefinedDecimal108) {
    this.clientDefinedDecimal108 = clientDefinedDecimal108;
  }

  public BigDecimal getClientDefinedDecimal109() {
    return clientDefinedDecimal109;
  }

  public void setClientDefinedDecimal109(BigDecimal clientDefinedDecimal109) {
    this.clientDefinedDecimal109 = clientDefinedDecimal109;
  }

  public BigDecimal getClientDefinedDecimal110() {
    return clientDefinedDecimal110;
  }

  public void setClientDefinedDecimal110(BigDecimal clientDefinedDecimal110) {
    this.clientDefinedDecimal110 = clientDefinedDecimal110;
  }

  public BigDecimal getClientDefinedDecimal111() {
    return clientDefinedDecimal111;
  }

  public void setClientDefinedDecimal111(BigDecimal clientDefinedDecimal111) {
    this.clientDefinedDecimal111 = clientDefinedDecimal111;
  }

  public BigDecimal getClientDefinedDecimal112() {
    return clientDefinedDecimal112;
  }

  public void setClientDefinedDecimal112(BigDecimal clientDefinedDecimal112) {
    this.clientDefinedDecimal112 = clientDefinedDecimal112;
  }

  public BigDecimal getClientDefinedDecimal113() {
    return clientDefinedDecimal113;
  }

  public void setClientDefinedDecimal113(BigDecimal clientDefinedDecimal113) {
    this.clientDefinedDecimal113 = clientDefinedDecimal113;
  }

  public BigDecimal getClientDefinedDecimal114() {
    return clientDefinedDecimal114;
  }

  public void setClientDefinedDecimal114(BigDecimal clientDefinedDecimal114) {
    this.clientDefinedDecimal114 = clientDefinedDecimal114;
  }

  public BigDecimal getClientDefinedDecimal115() {
    return clientDefinedDecimal115;
  }

  public void setClientDefinedDecimal115(BigDecimal clientDefinedDecimal115) {
    this.clientDefinedDecimal115 = clientDefinedDecimal115;
  }

  public BigDecimal getClientDefinedDecimal116() {
    return clientDefinedDecimal116;
  }

  public void setClientDefinedDecimal116(BigDecimal clientDefinedDecimal116) {
    this.clientDefinedDecimal116 = clientDefinedDecimal116;
  }

  public BigDecimal getClientDefinedDecimal117() {
    return clientDefinedDecimal117;
  }

  public void setClientDefinedDecimal117(BigDecimal clientDefinedDecimal117) {
    this.clientDefinedDecimal117 = clientDefinedDecimal117;
  }

  public BigDecimal getClientDefinedDecimal118() {
    return clientDefinedDecimal118;
  }

  public void setClientDefinedDecimal118(BigDecimal clientDefinedDecimal118) {
    this.clientDefinedDecimal118 = clientDefinedDecimal118;
  }

  public BigDecimal getClientDefinedDecimal119() {
    return clientDefinedDecimal119;
  }

  public void setClientDefinedDecimal119(BigDecimal clientDefinedDecimal119) {
    this.clientDefinedDecimal119 = clientDefinedDecimal119;
  }

  public BigDecimal getClientDefinedDecimal120() {
    return clientDefinedDecimal120;
  }

  public void setClientDefinedDecimal120(BigDecimal clientDefinedDecimal120) {
    this.clientDefinedDecimal120 = clientDefinedDecimal120;
  }

  public BigDecimal getClientDefinedDecimal121() {
    return clientDefinedDecimal121;
  }

  public void setClientDefinedDecimal121(BigDecimal clientDefinedDecimal121) {
    this.clientDefinedDecimal121 = clientDefinedDecimal121;
  }

  public BigDecimal getClientDefinedDecimal122() {
    return clientDefinedDecimal122;
  }

  public void setClientDefinedDecimal122(BigDecimal clientDefinedDecimal122) {
    this.clientDefinedDecimal122 = clientDefinedDecimal122;
  }

  public BigDecimal getClientDefinedDecimal123() {
    return clientDefinedDecimal123;
  }

  public void setClientDefinedDecimal123(BigDecimal clientDefinedDecimal123) {
    this.clientDefinedDecimal123 = clientDefinedDecimal123;
  }

  public BigDecimal getClientDefinedDecimal124() {
    return clientDefinedDecimal124;
  }

  public void setClientDefinedDecimal124(BigDecimal clientDefinedDecimal124) {
    this.clientDefinedDecimal124 = clientDefinedDecimal124;
  }

  public BigDecimal getClientDefinedDecimal125() {
    return clientDefinedDecimal125;
  }

  public void setClientDefinedDecimal125(BigDecimal clientDefinedDecimal125) {
    this.clientDefinedDecimal125 = clientDefinedDecimal125;
  }

  public BigDecimal getClientDefinedDecimal126() {
    return clientDefinedDecimal126;
  }

  public void setClientDefinedDecimal126(BigDecimal clientDefinedDecimal126) {
    this.clientDefinedDecimal126 = clientDefinedDecimal126;
  }

  public BigDecimal getClientDefinedDecimal127() {
    return clientDefinedDecimal127;
  }

  public void setClientDefinedDecimal127(BigDecimal clientDefinedDecimal127) {
    this.clientDefinedDecimal127 = clientDefinedDecimal127;
  }

  public BigDecimal getClientDefinedDecimal128() {
    return clientDefinedDecimal128;
  }

  public void setClientDefinedDecimal128(BigDecimal clientDefinedDecimal128) {
    this.clientDefinedDecimal128 = clientDefinedDecimal128;
  }

  public BigDecimal getClientDefinedDecimal129() {
    return clientDefinedDecimal129;
  }

  public void setClientDefinedDecimal129(BigDecimal clientDefinedDecimal129) {
    this.clientDefinedDecimal129 = clientDefinedDecimal129;
  }

  public BigDecimal getClientDefinedDecimal130() {
    return clientDefinedDecimal130;
  }

  public void setClientDefinedDecimal130(BigDecimal clientDefinedDecimal130) {
    this.clientDefinedDecimal130 = clientDefinedDecimal130;
  }

  public BigDecimal getClientDefinedDecimal131() {
    return clientDefinedDecimal131;
  }

  public void setClientDefinedDecimal131(BigDecimal clientDefinedDecimal131) {
    this.clientDefinedDecimal131 = clientDefinedDecimal131;
  }

  public BigDecimal getClientDefinedDecimal132() {
    return clientDefinedDecimal132;
  }

  public void setClientDefinedDecimal132(BigDecimal clientDefinedDecimal132) {
    this.clientDefinedDecimal132 = clientDefinedDecimal132;
  }

  public BigDecimal getClientDefinedDecimal133() {
    return clientDefinedDecimal133;
  }

  public void setClientDefinedDecimal133(BigDecimal clientDefinedDecimal133) {
    this.clientDefinedDecimal133 = clientDefinedDecimal133;
  }

  public BigDecimal getClientDefinedDecimal134() {
    return clientDefinedDecimal134;
  }

  public void setClientDefinedDecimal134(BigDecimal clientDefinedDecimal134) {
    this.clientDefinedDecimal134 = clientDefinedDecimal134;
  }

  public BigDecimal getClientDefinedDecimal135() {
    return clientDefinedDecimal135;
  }

  public void setClientDefinedDecimal135(BigDecimal clientDefinedDecimal135) {
    this.clientDefinedDecimal135 = clientDefinedDecimal135;
  }

  public BigDecimal getClientDefinedDecimal136() {
    return clientDefinedDecimal136;
  }

  public void setClientDefinedDecimal136(BigDecimal clientDefinedDecimal136) {
    this.clientDefinedDecimal136 = clientDefinedDecimal136;
  }

  public BigDecimal getClientDefinedDecimal137() {
    return clientDefinedDecimal137;
  }

  public void setClientDefinedDecimal137(BigDecimal clientDefinedDecimal137) {
    this.clientDefinedDecimal137 = clientDefinedDecimal137;
  }

  public BigDecimal getClientDefinedDecimal138() {
    return clientDefinedDecimal138;
  }

  public void setClientDefinedDecimal138(BigDecimal clientDefinedDecimal138) {
    this.clientDefinedDecimal138 = clientDefinedDecimal138;
  }

  public BigDecimal getClientDefinedDecimal139() {
    return clientDefinedDecimal139;
  }

  public void setClientDefinedDecimal139(BigDecimal clientDefinedDecimal139) {
    this.clientDefinedDecimal139 = clientDefinedDecimal139;
  }

  public BigDecimal getClientDefinedDecimal140() {
    return clientDefinedDecimal140;
  }

  public void setClientDefinedDecimal140(BigDecimal clientDefinedDecimal140) {
    this.clientDefinedDecimal140 = clientDefinedDecimal140;
  }

  public BigDecimal getClientDefinedDecimal141() {
    return clientDefinedDecimal141;
  }

  public void setClientDefinedDecimal141(BigDecimal clientDefinedDecimal141) {
    this.clientDefinedDecimal141 = clientDefinedDecimal141;
  }

  public BigDecimal getClientDefinedDecimal142() {
    return clientDefinedDecimal142;
  }

  public void setClientDefinedDecimal142(BigDecimal clientDefinedDecimal142) {
    this.clientDefinedDecimal142 = clientDefinedDecimal142;
  }

  public BigDecimal getClientDefinedDecimal143() {
    return clientDefinedDecimal143;
  }

  public void setClientDefinedDecimal143(BigDecimal clientDefinedDecimal143) {
    this.clientDefinedDecimal143 = clientDefinedDecimal143;
  }

  public BigDecimal getClientDefinedDecimal144() {
    return clientDefinedDecimal144;
  }

  public void setClientDefinedDecimal144(BigDecimal clientDefinedDecimal144) {
    this.clientDefinedDecimal144 = clientDefinedDecimal144;
  }

  public BigDecimal getClientDefinedDecimal145() {
    return clientDefinedDecimal145;
  }

  public void setClientDefinedDecimal145(BigDecimal clientDefinedDecimal145) {
    this.clientDefinedDecimal145 = clientDefinedDecimal145;
  }

  public BigDecimal getClientDefinedDecimal146() {
    return clientDefinedDecimal146;
  }

  public void setClientDefinedDecimal146(BigDecimal clientDefinedDecimal146) {
    this.clientDefinedDecimal146 = clientDefinedDecimal146;
  }

  public BigDecimal getClientDefinedDecimal147() {
    return clientDefinedDecimal147;
  }

  public void setClientDefinedDecimal147(BigDecimal clientDefinedDecimal147) {
    this.clientDefinedDecimal147 = clientDefinedDecimal147;
  }

  public BigDecimal getClientDefinedDecimal148() {
    return clientDefinedDecimal148;
  }

  public void setClientDefinedDecimal148(BigDecimal clientDefinedDecimal148) {
    this.clientDefinedDecimal148 = clientDefinedDecimal148;
  }

  public BigDecimal getClientDefinedDecimal149() {
    return clientDefinedDecimal149;
  }

  public void setClientDefinedDecimal149(BigDecimal clientDefinedDecimal149) {
    this.clientDefinedDecimal149 = clientDefinedDecimal149;
  }

  public BigDecimal getClientDefinedDecimal150() {
    return clientDefinedDecimal150;
  }

  public void setClientDefinedDecimal150(BigDecimal clientDefinedDecimal150) {
    this.clientDefinedDecimal150 = clientDefinedDecimal150;
  }
} // end class AccountExtensionDecimal
