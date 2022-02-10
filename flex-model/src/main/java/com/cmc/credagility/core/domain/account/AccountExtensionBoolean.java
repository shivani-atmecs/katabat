package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  07/24/2015 17:22
 */
@Entity
@Table(name = "AccountExtensionBoolean")
public class AccountExtensionBoolean extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -7098157910902637779L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "accountExtensionBooleanId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long accountExtensionBooleanId;


  @JoinColumn(
    name   = "accountNum",
    unique = true
  )
  @ManyToOne private Account account;


  @Column(
    name   = "clientDefinedBoolean1",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean1;
  @Column(
    name   = "clientDefinedBoolean10",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean10;
  @Column(
    name   = "clientDefinedBoolean100",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean100;
  @Column(
    name   = "clientDefinedBoolean11",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean11;
  @Column(
    name   = "clientDefinedBoolean12",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean12;
  @Column(
    name   = "clientDefinedBoolean13",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean13;
  @Column(
    name   = "clientDefinedBoolean14",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean14;
  @Column(
    name   = "clientDefinedBoolean15",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean15;
  @Column(
    name   = "clientDefinedBoolean16",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean16;
  @Column(
    name   = "clientDefinedBoolean17",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean17;
  @Column(
    name   = "clientDefinedBoolean18",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean18;
  @Column(
    name   = "clientDefinedBoolean19",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean19;

  @Column(
    name   = "clientDefinedBoolean2",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean2;
  @Column(
    name   = "clientDefinedBoolean20",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean20;
  @Column(
    name   = "clientDefinedBoolean21",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean21;
  @Column(
    name   = "clientDefinedBoolean22",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean22;
  @Column(
    name   = "clientDefinedBoolean23",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean23;
  @Column(
    name   = "clientDefinedBoolean24",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean24;
  @Column(
    name   = "clientDefinedBoolean25",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean25;
  @Column(
    name   = "clientDefinedBoolean26",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean26;
  @Column(
    name   = "clientDefinedBoolean27",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean27;
  @Column(
    name   = "clientDefinedBoolean28",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean28;
  @Column(
    name   = "clientDefinedBoolean29",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean29;

  @Column(
    name   = "clientDefinedBoolean3",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean3;
  @Column(
    name   = "clientDefinedBoolean30",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean30;
  @Column(
    name   = "clientDefinedBoolean31",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean31;
  @Column(
    name   = "clientDefinedBoolean32",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean32;
  @Column(
    name   = "clientDefinedBoolean33",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean33;
  @Column(
    name   = "clientDefinedBoolean34",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean34;
  @Column(
    name   = "clientDefinedBoolean35",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean35;
  @Column(
    name   = "clientDefinedBoolean36",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean36;
  @Column(
    name   = "clientDefinedBoolean37",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean37;
  @Column(
    name   = "clientDefinedBoolean38",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean38;
  @Column(
    name   = "clientDefinedBoolean39",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean39;
  @Column(
    name   = "clientDefinedBoolean4",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean4;
  @Column(
    name   = "clientDefinedBoolean40",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean40;
  @Column(
    name   = "clientDefinedBoolean41",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean41;
  @Column(
    name   = "clientDefinedBoolean42",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean42;
  @Column(
    name   = "clientDefinedBoolean43",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean43;
  @Column(
    name   = "clientDefinedBoolean44",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean44;
  @Column(
    name   = "clientDefinedBoolean45",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean45;
  @Column(
    name   = "clientDefinedBoolean46",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean46;
  @Column(
    name   = "clientDefinedBoolean47",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean47;
  @Column(
    name   = "clientDefinedBoolean48",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean48;
  @Column(
    name   = "clientDefinedBoolean49",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean49;

  @Column(
    name   = "clientDefinedBoolean5",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean5;
  @Column(
    name   = "clientDefinedBoolean50",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean50;
  @Column(
    name   = "clientDefinedBoolean51",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean51;
  @Column(
    name   = "clientDefinedBoolean52",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean52;
  @Column(
    name   = "clientDefinedBoolean53",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean53;
  @Column(
    name   = "clientDefinedBoolean54",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean54;
  @Column(
    name   = "clientDefinedBoolean55",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean55;
  @Column(
    name   = "clientDefinedBoolean56",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean56;
  @Column(
    name   = "clientDefinedBoolean57",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean57;
  @Column(
    name   = "clientDefinedBoolean58",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean58;
  @Column(
    name   = "clientDefinedBoolean59",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean59;
  @Column(
    name   = "clientDefinedBoolean6",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean6;
  @Column(
    name   = "clientDefinedBoolean60",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean60;
  @Column(
    name   = "clientDefinedBoolean61",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean61;
  @Column(
    name   = "clientDefinedBoolean62",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean62;
  @Column(
    name   = "clientDefinedBoolean63",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean63;
  @Column(
    name   = "clientDefinedBoolean64",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean64;
  @Column(
    name   = "clientDefinedBoolean65",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean65;
  @Column(
    name   = "clientDefinedBoolean66",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean66;
  @Column(
    name   = "clientDefinedBoolean67",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean67;
  @Column(
    name   = "clientDefinedBoolean68",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean68;
  @Column(
    name   = "clientDefinedBoolean69",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean69;
  @Column(
    name   = "clientDefinedBoolean7",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean7;
  @Column(
    name   = "clientDefinedBoolean70",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean70;
  @Column(
    name   = "clientDefinedBoolean71",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean71;
  @Column(
    name   = "clientDefinedBoolean72",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean72;
  @Column(
    name   = "clientDefinedBoolean73",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean73;
  @Column(
    name   = "clientDefinedBoolean74",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean74;
  @Column(
    name   = "clientDefinedBoolean75",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean75;
  @Column(
    name   = "clientDefinedBoolean76",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean76;
  @Column(
    name   = "clientDefinedBoolean77",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean77;
  @Column(
    name   = "clientDefinedBoolean78",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean78;
  @Column(
    name   = "clientDefinedBoolean79",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean79;
  @Column(
    name   = "clientDefinedBoolean8",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean8;
  @Column(
    name   = "clientDefinedBoolean80",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean80;
  @Column(
    name   = "clientDefinedBoolean81",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean81;
  @Column(
    name   = "clientDefinedBoolean82",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean82;
  @Column(
    name   = "clientDefinedBoolean83",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean83;
  @Column(
    name   = "clientDefinedBoolean84",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean84;
  @Column(
    name   = "clientDefinedBoolean85",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean85;
  @Column(
    name   = "clientDefinedBoolean86",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean86;
  @Column(
    name   = "clientDefinedBoolean87",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean87;
  @Column(
    name   = "clientDefinedBoolean88",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean88;
  @Column(
    name   = "clientDefinedBoolean89",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean89;
  @Column(
    name   = "clientDefinedBoolean9",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean9;
  @Column(
    name   = "clientDefinedBoolean90",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean90;
  @Column(
    name   = "clientDefinedBoolean91",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean91;
  @Column(
    name   = "clientDefinedBoolean92",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean92;
  @Column(
    name   = "clientDefinedBoolean93",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean93;
  @Column(
    name   = "clientDefinedBoolean94",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean94;
  @Column(
    name   = "clientDefinedBoolean95",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean95;
  @Column(
    name   = "clientDefinedBoolean96",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean96;
  @Column(
    name   = "clientDefinedBoolean97",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean97;
  @Column(
    name   = "clientDefinedBoolean98",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean98;
  @Column(
    name   = "clientDefinedBoolean99",
    length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean99;

  @Column(
          name = "clientDefinedBoolean101",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean101;
  @Column(
          name = "clientDefinedBoolean102",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean102;
  @Column(
          name = "clientDefinedBoolean103",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean103;
  @Column(
          name = "clientDefinedBoolean104",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean104;
  @Column(
          name = "clientDefinedBoolean105",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean105;
  @Column(
          name = "clientDefinedBoolean106",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean106;
  @Column(
          name = "clientDefinedBoolean107",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean107;
  @Column(
          name = "clientDefinedBoolean108",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean108;
  @Column(
          name = "clientDefinedBoolean109",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean109;
  @Column(
          name = "clientDefinedBoolean110",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean110;
  @Column(
          name = "clientDefinedBoolean111",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean111;
  @Column(
          name = "clientDefinedBoolean112",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean112;
  @Column(
          name = "clientDefinedBoolean113",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean113;
  @Column(
          name = "clientDefinedBoolean114",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean114;
  @Column(
          name = "clientDefinedBoolean115",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean115;
  @Column(
          name = "clientDefinedBoolean116",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean116;
  @Column(
          name = "clientDefinedBoolean117",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean117;
  @Column(
          name = "clientDefinedBoolean118",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean118;
  @Column(
          name = "clientDefinedBoolean119",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean119;
  @Column(
          name = "clientDefinedBoolean120",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean120;
  @Column(
          name = "clientDefinedBoolean121",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean121;
  @Column(
          name = "clientDefinedBoolean122",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean122;
  @Column(
          name = "clientDefinedBoolean123",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean123;
  @Column(
          name = "clientDefinedBoolean124",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean124;
  @Column(
          name = "clientDefinedBoolean125",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean125;
  @Column(
          name = "clientDefinedBoolean126",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean126;
  @Column(
          name = "clientDefinedBoolean127",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean127;
  @Column(
          name = "clientDefinedBoolean128",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean128;
  @Column(
          name = "clientDefinedBoolean129",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean129;
  @Column(
          name = "clientDefinedBoolean130",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean130;
  @Column(
          name = "clientDefinedBoolean131",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean131;
  @Column(
          name = "clientDefinedBoolean132",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean132;
  @Column(
          name = "clientDefinedBoolean133",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean133;
  @Column(
          name = "clientDefinedBoolean134",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean134;
  @Column(
          name = "clientDefinedBoolean135",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean135;
  @Column(
          name = "clientDefinedBoolean136",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean136;
  @Column(
          name = "clientDefinedBoolean137",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean137;
  @Column(
          name = "clientDefinedBoolean138",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean138;
  @Column(
          name = "clientDefinedBoolean139",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean139;
  @Column(
          name = "clientDefinedBoolean140",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean140;
  @Column(
          name = "clientDefinedBoolean141",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean141;
  @Column(
          name = "clientDefinedBoolean142",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean142;
  @Column(
          name = "clientDefinedBoolean143",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean143;
  @Column(
          name = "clientDefinedBoolean144",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean144;
  @Column(
          name = "clientDefinedBoolean145",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean145;
  @Column(
          name = "clientDefinedBoolean146",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean146;
  @Column(
          name = "clientDefinedBoolean147",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean147;
  @Column(
          name = "clientDefinedBoolean148",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean148;
  @Column(
          name = "clientDefinedBoolean149",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean149;
  @Column(
          name = "clientDefinedBoolean150",
          length = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedBoolean150;
  
  
  

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
   * getter method for account extension boolean id.
   *
   * @return  Long
   */
  public Long getAccountExtensionBooleanId() {
    return accountExtensionBooleanId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean1.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean1() {
    return clientDefinedBoolean1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean10.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean10() {
    return clientDefinedBoolean10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean100.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean100() {
    return clientDefinedBoolean100;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean11.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean11() {
    return clientDefinedBoolean11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean12.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean12() {
    return clientDefinedBoolean12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean13.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean13() {
    return clientDefinedBoolean13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean14.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean14() {
    return clientDefinedBoolean14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean15.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean15() {
    return clientDefinedBoolean15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean16.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean16() {
    return clientDefinedBoolean16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean17.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean17() {
    return clientDefinedBoolean17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean18.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean18() {
    return clientDefinedBoolean18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean19.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean19() {
    return clientDefinedBoolean19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean2.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean2() {
    return clientDefinedBoolean2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean20.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean20() {
    return clientDefinedBoolean20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean21.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean21() {
    return clientDefinedBoolean21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean22.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean22() {
    return clientDefinedBoolean22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean23.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean23() {
    return clientDefinedBoolean23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean24.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean24() {
    return clientDefinedBoolean24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean25.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean25() {
    return clientDefinedBoolean25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean26.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean26() {
    return clientDefinedBoolean26;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean27.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean27() {
    return clientDefinedBoolean27;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean28.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean28() {
    return clientDefinedBoolean28;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean29.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean29() {
    return clientDefinedBoolean29;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean3.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean3() {
    return clientDefinedBoolean3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean30.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean30() {
    return clientDefinedBoolean30;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean31.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean31() {
    return clientDefinedBoolean31;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean32.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean32() {
    return clientDefinedBoolean32;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean33.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean33() {
    return clientDefinedBoolean33;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean34.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean34() {
    return clientDefinedBoolean34;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean35.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean35() {
    return clientDefinedBoolean35;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean36.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean36() {
    return clientDefinedBoolean36;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean37.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean37() {
    return clientDefinedBoolean37;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean38.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean38() {
    return clientDefinedBoolean38;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean39.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean39() {
    return clientDefinedBoolean39;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean4.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean4() {
    return clientDefinedBoolean4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean40.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean40() {
    return clientDefinedBoolean40;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean41.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean41() {
    return clientDefinedBoolean41;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean42.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean42() {
    return clientDefinedBoolean42;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean43.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean43() {
    return clientDefinedBoolean43;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean44.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean44() {
    return clientDefinedBoolean44;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean45.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean45() {
    return clientDefinedBoolean45;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean46.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean46() {
    return clientDefinedBoolean46;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean47.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean47() {
    return clientDefinedBoolean47;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean48.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean48() {
    return clientDefinedBoolean48;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean49.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean49() {
    return clientDefinedBoolean49;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean5.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean5() {
    return clientDefinedBoolean5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean50.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean50() {
    return clientDefinedBoolean50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean51.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean51() {
    return clientDefinedBoolean51;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean52.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean52() {
    return clientDefinedBoolean52;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean53.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean53() {
    return clientDefinedBoolean53;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean54.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean54() {
    return clientDefinedBoolean54;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean55.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean55() {
    return clientDefinedBoolean55;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean56.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean56() {
    return clientDefinedBoolean56;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean57.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean57() {
    return clientDefinedBoolean57;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean58.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean58() {
    return clientDefinedBoolean58;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean59.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean59() {
    return clientDefinedBoolean59;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean6.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean6() {
    return clientDefinedBoolean6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean60.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean60() {
    return clientDefinedBoolean60;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean61.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean61() {
    return clientDefinedBoolean61;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean62.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean62() {
    return clientDefinedBoolean62;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean63.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean63() {
    return clientDefinedBoolean63;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean64.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean64() {
    return clientDefinedBoolean64;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean65.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean65() {
    return clientDefinedBoolean65;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean66.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean66() {
    return clientDefinedBoolean66;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean67.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean67() {
    return clientDefinedBoolean67;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean68.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean68() {
    return clientDefinedBoolean68;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean69.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean69() {
    return clientDefinedBoolean69;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean7.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean7() {
    return clientDefinedBoolean7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean70.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean70() {
    return clientDefinedBoolean70;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean71.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean71() {
    return clientDefinedBoolean71;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean72.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean72() {
    return clientDefinedBoolean72;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean73.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean73() {
    return clientDefinedBoolean73;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean74.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean74() {
    return clientDefinedBoolean74;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean75.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean75() {
    return clientDefinedBoolean75;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean76.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean76() {
    return clientDefinedBoolean76;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean77.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean77() {
    return clientDefinedBoolean77;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean78.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean78() {
    return clientDefinedBoolean78;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean79.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean79() {
    return clientDefinedBoolean79;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean8.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean8() {
    return clientDefinedBoolean8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean80.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean80() {
    return clientDefinedBoolean80;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean81.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean81() {
    return clientDefinedBoolean81;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean82.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean82() {
    return clientDefinedBoolean82;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean83.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean83() {
    return clientDefinedBoolean83;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean84.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean84() {
    return clientDefinedBoolean84;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean85.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean85() {
    return clientDefinedBoolean85;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean86.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean86() {
    return clientDefinedBoolean86;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean87.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean87() {
    return clientDefinedBoolean87;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean88.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean88() {
    return clientDefinedBoolean88;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean89.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean89() {
    return clientDefinedBoolean89;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean9.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean9() {
    return clientDefinedBoolean9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean90.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean90() {
    return clientDefinedBoolean90;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean91.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean91() {
    return clientDefinedBoolean91;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean92.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean92() {
    return clientDefinedBoolean92;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean93.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean93() {
    return clientDefinedBoolean93;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean94.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean94() {
    return clientDefinedBoolean94;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean95.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean95() {
    return clientDefinedBoolean95;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean96.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean96() {
    return clientDefinedBoolean96;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean97.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean97() {
    return clientDefinedBoolean97;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean98.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean98() {
    return clientDefinedBoolean98;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined boolean99.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedBoolean99() {
    return clientDefinedBoolean99;
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
   * setter method for account extension boolean id.
   *
   * @param  accountExtensionBooleanId  Long
   */
  public void setAccountExtensionBooleanId(Long accountExtensionBooleanId) {
    this.accountExtensionBooleanId = accountExtensionBooleanId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean1.
   *
   * @param  clientDefinedBoolean1  Boolean
   */
  public void setClientDefinedBoolean1(Boolean clientDefinedBoolean1) {
    this.clientDefinedBoolean1 = clientDefinedBoolean1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean10.
   *
   * @param  clientDefinedBoolean10  Boolean
   */
  public void setClientDefinedBoolean10(Boolean clientDefinedBoolean10) {
    this.clientDefinedBoolean10 = clientDefinedBoolean10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean100.
   *
   * @param  clientDefinedBoolean100  Boolean
   */
  public void setClientDefinedBoolean100(Boolean clientDefinedBoolean100) {
    this.clientDefinedBoolean100 = clientDefinedBoolean100;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean11.
   *
   * @param  clientDefinedBoolean11  Boolean
   */
  public void setClientDefinedBoolean11(Boolean clientDefinedBoolean11) {
    this.clientDefinedBoolean11 = clientDefinedBoolean11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean12.
   *
   * @param  clientDefinedBoolean12  Boolean
   */
  public void setClientDefinedBoolean12(Boolean clientDefinedBoolean12) {
    this.clientDefinedBoolean12 = clientDefinedBoolean12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean13.
   *
   * @param  clientDefinedBoolean13  Boolean
   */
  public void setClientDefinedBoolean13(Boolean clientDefinedBoolean13) {
    this.clientDefinedBoolean13 = clientDefinedBoolean13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean14.
   *
   * @param  clientDefinedBoolean14  Boolean
   */
  public void setClientDefinedBoolean14(Boolean clientDefinedBoolean14) {
    this.clientDefinedBoolean14 = clientDefinedBoolean14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean15.
   *
   * @param  clientDefinedBoolean15  Boolean
   */
  public void setClientDefinedBoolean15(Boolean clientDefinedBoolean15) {
    this.clientDefinedBoolean15 = clientDefinedBoolean15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean16.
   *
   * @param  clientDefinedBoolean16  Boolean
   */
  public void setClientDefinedBoolean16(Boolean clientDefinedBoolean16) {
    this.clientDefinedBoolean16 = clientDefinedBoolean16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean17.
   *
   * @param  clientDefinedBoolean17  Boolean
   */
  public void setClientDefinedBoolean17(Boolean clientDefinedBoolean17) {
    this.clientDefinedBoolean17 = clientDefinedBoolean17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean18.
   *
   * @param  clientDefinedBoolean18  Boolean
   */
  public void setClientDefinedBoolean18(Boolean clientDefinedBoolean18) {
    this.clientDefinedBoolean18 = clientDefinedBoolean18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean19.
   *
   * @param  clientDefinedBoolean19  Boolean
   */
  public void setClientDefinedBoolean19(Boolean clientDefinedBoolean19) {
    this.clientDefinedBoolean19 = clientDefinedBoolean19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean2.
   *
   * @param  clientDefinedBoolean2  Boolean
   */
  public void setClientDefinedBoolean2(Boolean clientDefinedBoolean2) {
    this.clientDefinedBoolean2 = clientDefinedBoolean2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean20.
   *
   * @param  clientDefinedBoolean20  Boolean
   */
  public void setClientDefinedBoolean20(Boolean clientDefinedBoolean20) {
    this.clientDefinedBoolean20 = clientDefinedBoolean20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean21.
   *
   * @param  clientDefinedBoolean21  Boolean
   */
  public void setClientDefinedBoolean21(Boolean clientDefinedBoolean21) {
    this.clientDefinedBoolean21 = clientDefinedBoolean21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean22.
   *
   * @param  clientDefinedBoolean22  Boolean
   */
  public void setClientDefinedBoolean22(Boolean clientDefinedBoolean22) {
    this.clientDefinedBoolean22 = clientDefinedBoolean22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean23.
   *
   * @param  clientDefinedBoolean23  Boolean
   */
  public void setClientDefinedBoolean23(Boolean clientDefinedBoolean23) {
    this.clientDefinedBoolean23 = clientDefinedBoolean23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean24.
   *
   * @param  clientDefinedBoolean24  Boolean
   */
  public void setClientDefinedBoolean24(Boolean clientDefinedBoolean24) {
    this.clientDefinedBoolean24 = clientDefinedBoolean24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean25.
   *
   * @param  clientDefinedBoolean25  Boolean
   */
  public void setClientDefinedBoolean25(Boolean clientDefinedBoolean25) {
    this.clientDefinedBoolean25 = clientDefinedBoolean25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean26.
   *
   * @param  clientDefinedBoolean26  Boolean
   */
  public void setClientDefinedBoolean26(Boolean clientDefinedBoolean26) {
    this.clientDefinedBoolean26 = clientDefinedBoolean26;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean27.
   *
   * @param  clientDefinedBoolean27  Boolean
   */
  public void setClientDefinedBoolean27(Boolean clientDefinedBoolean27) {
    this.clientDefinedBoolean27 = clientDefinedBoolean27;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean28.
   *
   * @param  clientDefinedBoolean28  Boolean
   */
  public void setClientDefinedBoolean28(Boolean clientDefinedBoolean28) {
    this.clientDefinedBoolean28 = clientDefinedBoolean28;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean29.
   *
   * @param  clientDefinedBoolean29  Boolean
   */
  public void setClientDefinedBoolean29(Boolean clientDefinedBoolean29) {
    this.clientDefinedBoolean29 = clientDefinedBoolean29;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean3.
   *
   * @param  clientDefinedBoolean3  Boolean
   */
  public void setClientDefinedBoolean3(Boolean clientDefinedBoolean3) {
    this.clientDefinedBoolean3 = clientDefinedBoolean3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean30.
   *
   * @param  clientDefinedBoolean30  Boolean
   */
  public void setClientDefinedBoolean30(Boolean clientDefinedBoolean30) {
    this.clientDefinedBoolean30 = clientDefinedBoolean30;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean31.
   *
   * @param  clientDefinedBoolean31  Boolean
   */
  public void setClientDefinedBoolean31(Boolean clientDefinedBoolean31) {
    this.clientDefinedBoolean31 = clientDefinedBoolean31;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean32.
   *
   * @param  clientDefinedBoolean32  Boolean
   */
  public void setClientDefinedBoolean32(Boolean clientDefinedBoolean32) {
    this.clientDefinedBoolean32 = clientDefinedBoolean32;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean33.
   *
   * @param  clientDefinedBoolean33  Boolean
   */
  public void setClientDefinedBoolean33(Boolean clientDefinedBoolean33) {
    this.clientDefinedBoolean33 = clientDefinedBoolean33;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean34.
   *
   * @param  clientDefinedBoolean34  Boolean
   */
  public void setClientDefinedBoolean34(Boolean clientDefinedBoolean34) {
    this.clientDefinedBoolean34 = clientDefinedBoolean34;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean35.
   *
   * @param  clientDefinedBoolean35  Boolean
   */
  public void setClientDefinedBoolean35(Boolean clientDefinedBoolean35) {
    this.clientDefinedBoolean35 = clientDefinedBoolean35;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean36.
   *
   * @param  clientDefinedBoolean36  Boolean
   */
  public void setClientDefinedBoolean36(Boolean clientDefinedBoolean36) {
    this.clientDefinedBoolean36 = clientDefinedBoolean36;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean37.
   *
   * @param  clientDefinedBoolean37  Boolean
   */
  public void setClientDefinedBoolean37(Boolean clientDefinedBoolean37) {
    this.clientDefinedBoolean37 = clientDefinedBoolean37;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean38.
   *
   * @param  clientDefinedBoolean38  Boolean
   */
  public void setClientDefinedBoolean38(Boolean clientDefinedBoolean38) {
    this.clientDefinedBoolean38 = clientDefinedBoolean38;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean39.
   *
   * @param  clientDefinedBoolean39  Boolean
   */
  public void setClientDefinedBoolean39(Boolean clientDefinedBoolean39) {
    this.clientDefinedBoolean39 = clientDefinedBoolean39;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean4.
   *
   * @param  clientDefinedBoolean4  Boolean
   */
  public void setClientDefinedBoolean4(Boolean clientDefinedBoolean4) {
    this.clientDefinedBoolean4 = clientDefinedBoolean4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean40.
   *
   * @param  clientDefinedBoolean40  Boolean
   */
  public void setClientDefinedBoolean40(Boolean clientDefinedBoolean40) {
    this.clientDefinedBoolean40 = clientDefinedBoolean40;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean41.
   *
   * @param  clientDefinedBoolean41  Boolean
   */
  public void setClientDefinedBoolean41(Boolean clientDefinedBoolean41) {
    this.clientDefinedBoolean41 = clientDefinedBoolean41;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean42.
   *
   * @param  clientDefinedBoolean42  Boolean
   */
  public void setClientDefinedBoolean42(Boolean clientDefinedBoolean42) {
    this.clientDefinedBoolean42 = clientDefinedBoolean42;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean43.
   *
   * @param  clientDefinedBoolean43  Boolean
   */
  public void setClientDefinedBoolean43(Boolean clientDefinedBoolean43) {
    this.clientDefinedBoolean43 = clientDefinedBoolean43;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean44.
   *
   * @param  clientDefinedBoolean44  Boolean
   */
  public void setClientDefinedBoolean44(Boolean clientDefinedBoolean44) {
    this.clientDefinedBoolean44 = clientDefinedBoolean44;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean45.
   *
   * @param  clientDefinedBoolean45  Boolean
   */
  public void setClientDefinedBoolean45(Boolean clientDefinedBoolean45) {
    this.clientDefinedBoolean45 = clientDefinedBoolean45;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean46.
   *
   * @param  clientDefinedBoolean46  Boolean
   */
  public void setClientDefinedBoolean46(Boolean clientDefinedBoolean46) {
    this.clientDefinedBoolean46 = clientDefinedBoolean46;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean47.
   *
   * @param  clientDefinedBoolean47  Boolean
   */
  public void setClientDefinedBoolean47(Boolean clientDefinedBoolean47) {
    this.clientDefinedBoolean47 = clientDefinedBoolean47;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean48.
   *
   * @param  clientDefinedBoolean48  Boolean
   */
  public void setClientDefinedBoolean48(Boolean clientDefinedBoolean48) {
    this.clientDefinedBoolean48 = clientDefinedBoolean48;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean49.
   *
   * @param  clientDefinedBoolean49  Boolean
   */
  public void setClientDefinedBoolean49(Boolean clientDefinedBoolean49) {
    this.clientDefinedBoolean49 = clientDefinedBoolean49;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean5.
   *
   * @param  clientDefinedBoolean5  Boolean
   */
  public void setClientDefinedBoolean5(Boolean clientDefinedBoolean5) {
    this.clientDefinedBoolean5 = clientDefinedBoolean5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean50.
   *
   * @param  clientDefinedBoolean50  Boolean
   */
  public void setClientDefinedBoolean50(Boolean clientDefinedBoolean50) {
    this.clientDefinedBoolean50 = clientDefinedBoolean50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean51.
   *
   * @param  clientDefinedBoolean51  Boolean
   */
  public void setClientDefinedBoolean51(Boolean clientDefinedBoolean51) {
    this.clientDefinedBoolean51 = clientDefinedBoolean51;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean52.
   *
   * @param  clientDefinedBoolean52  Boolean
   */
  public void setClientDefinedBoolean52(Boolean clientDefinedBoolean52) {
    this.clientDefinedBoolean52 = clientDefinedBoolean52;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean53.
   *
   * @param  clientDefinedBoolean53  Boolean
   */
  public void setClientDefinedBoolean53(Boolean clientDefinedBoolean53) {
    this.clientDefinedBoolean53 = clientDefinedBoolean53;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean54.
   *
   * @param  clientDefinedBoolean54  Boolean
   */
  public void setClientDefinedBoolean54(Boolean clientDefinedBoolean54) {
    this.clientDefinedBoolean54 = clientDefinedBoolean54;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean55.
   *
   * @param  clientDefinedBoolean55  Boolean
   */
  public void setClientDefinedBoolean55(Boolean clientDefinedBoolean55) {
    this.clientDefinedBoolean55 = clientDefinedBoolean55;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean56.
   *
   * @param  clientDefinedBoolean56  Boolean
   */
  public void setClientDefinedBoolean56(Boolean clientDefinedBoolean56) {
    this.clientDefinedBoolean56 = clientDefinedBoolean56;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean57.
   *
   * @param  clientDefinedBoolean57  Boolean
   */
  public void setClientDefinedBoolean57(Boolean clientDefinedBoolean57) {
    this.clientDefinedBoolean57 = clientDefinedBoolean57;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean58.
   *
   * @param  clientDefinedBoolean58  Boolean
   */
  public void setClientDefinedBoolean58(Boolean clientDefinedBoolean58) {
    this.clientDefinedBoolean58 = clientDefinedBoolean58;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean59.
   *
   * @param  clientDefinedBoolean59  Boolean
   */
  public void setClientDefinedBoolean59(Boolean clientDefinedBoolean59) {
    this.clientDefinedBoolean59 = clientDefinedBoolean59;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean6.
   *
   * @param  clientDefinedBoolean6  Boolean
   */
  public void setClientDefinedBoolean6(Boolean clientDefinedBoolean6) {
    this.clientDefinedBoolean6 = clientDefinedBoolean6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean60.
   *
   * @param  clientDefinedBoolean60  Boolean
   */
  public void setClientDefinedBoolean60(Boolean clientDefinedBoolean60) {
    this.clientDefinedBoolean60 = clientDefinedBoolean60;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean61.
   *
   * @param  clientDefinedBoolean61  Boolean
   */
  public void setClientDefinedBoolean61(Boolean clientDefinedBoolean61) {
    this.clientDefinedBoolean61 = clientDefinedBoolean61;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean62.
   *
   * @param  clientDefinedBoolean62  Boolean
   */
  public void setClientDefinedBoolean62(Boolean clientDefinedBoolean62) {
    this.clientDefinedBoolean62 = clientDefinedBoolean62;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean63.
   *
   * @param  clientDefinedBoolean63  Boolean
   */
  public void setClientDefinedBoolean63(Boolean clientDefinedBoolean63) {
    this.clientDefinedBoolean63 = clientDefinedBoolean63;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean64.
   *
   * @param  clientDefinedBoolean64  Boolean
   */
  public void setClientDefinedBoolean64(Boolean clientDefinedBoolean64) {
    this.clientDefinedBoolean64 = clientDefinedBoolean64;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean65.
   *
   * @param  clientDefinedBoolean65  Boolean
   */
  public void setClientDefinedBoolean65(Boolean clientDefinedBoolean65) {
    this.clientDefinedBoolean65 = clientDefinedBoolean65;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean66.
   *
   * @param  clientDefinedBoolean66  Boolean
   */
  public void setClientDefinedBoolean66(Boolean clientDefinedBoolean66) {
    this.clientDefinedBoolean66 = clientDefinedBoolean66;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean67.
   *
   * @param  clientDefinedBoolean67  Boolean
   */
  public void setClientDefinedBoolean67(Boolean clientDefinedBoolean67) {
    this.clientDefinedBoolean67 = clientDefinedBoolean67;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean68.
   *
   * @param  clientDefinedBoolean68  Boolean
   */
  public void setClientDefinedBoolean68(Boolean clientDefinedBoolean68) {
    this.clientDefinedBoolean68 = clientDefinedBoolean68;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean69.
   *
   * @param  clientDefinedBoolean69  Boolean
   */
  public void setClientDefinedBoolean69(Boolean clientDefinedBoolean69) {
    this.clientDefinedBoolean69 = clientDefinedBoolean69;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean7.
   *
   * @param  clientDefinedBoolean7  Boolean
   */
  public void setClientDefinedBoolean7(Boolean clientDefinedBoolean7) {
    this.clientDefinedBoolean7 = clientDefinedBoolean7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean70.
   *
   * @param  clientDefinedBoolean70  Boolean
   */
  public void setClientDefinedBoolean70(Boolean clientDefinedBoolean70) {
    this.clientDefinedBoolean70 = clientDefinedBoolean70;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean71.
   *
   * @param  clientDefinedBoolean71  Boolean
   */
  public void setClientDefinedBoolean71(Boolean clientDefinedBoolean71) {
    this.clientDefinedBoolean71 = clientDefinedBoolean71;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean72.
   *
   * @param  clientDefinedBoolean72  Boolean
   */
  public void setClientDefinedBoolean72(Boolean clientDefinedBoolean72) {
    this.clientDefinedBoolean72 = clientDefinedBoolean72;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean73.
   *
   * @param  clientDefinedBoolean73  Boolean
   */
  public void setClientDefinedBoolean73(Boolean clientDefinedBoolean73) {
    this.clientDefinedBoolean73 = clientDefinedBoolean73;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean74.
   *
   * @param  clientDefinedBoolean74  Boolean
   */
  public void setClientDefinedBoolean74(Boolean clientDefinedBoolean74) {
    this.clientDefinedBoolean74 = clientDefinedBoolean74;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean75.
   *
   * @param  clientDefinedBoolean75  Boolean
   */
  public void setClientDefinedBoolean75(Boolean clientDefinedBoolean75) {
    this.clientDefinedBoolean75 = clientDefinedBoolean75;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean76.
   *
   * @param  clientDefinedBoolean76  Boolean
   */
  public void setClientDefinedBoolean76(Boolean clientDefinedBoolean76) {
    this.clientDefinedBoolean76 = clientDefinedBoolean76;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean77.
   *
   * @param  clientDefinedBoolean77  Boolean
   */
  public void setClientDefinedBoolean77(Boolean clientDefinedBoolean77) {
    this.clientDefinedBoolean77 = clientDefinedBoolean77;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean78.
   *
   * @param  clientDefinedBoolean78  Boolean
   */
  public void setClientDefinedBoolean78(Boolean clientDefinedBoolean78) {
    this.clientDefinedBoolean78 = clientDefinedBoolean78;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean79.
   *
   * @param  clientDefinedBoolean79  Boolean
   */
  public void setClientDefinedBoolean79(Boolean clientDefinedBoolean79) {
    this.clientDefinedBoolean79 = clientDefinedBoolean79;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean8.
   *
   * @param  clientDefinedBoolean8  Boolean
   */
  public void setClientDefinedBoolean8(Boolean clientDefinedBoolean8) {
    this.clientDefinedBoolean8 = clientDefinedBoolean8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean80.
   *
   * @param  clientDefinedBoolean80  Boolean
   */
  public void setClientDefinedBoolean80(Boolean clientDefinedBoolean80) {
    this.clientDefinedBoolean80 = clientDefinedBoolean80;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean81.
   *
   * @param  clientDefinedBoolean81  Boolean
   */
  public void setClientDefinedBoolean81(Boolean clientDefinedBoolean81) {
    this.clientDefinedBoolean81 = clientDefinedBoolean81;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean82.
   *
   * @param  clientDefinedBoolean82  Boolean
   */
  public void setClientDefinedBoolean82(Boolean clientDefinedBoolean82) {
    this.clientDefinedBoolean82 = clientDefinedBoolean82;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean83.
   *
   * @param  clientDefinedBoolean83  Boolean
   */
  public void setClientDefinedBoolean83(Boolean clientDefinedBoolean83) {
    this.clientDefinedBoolean83 = clientDefinedBoolean83;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean84.
   *
   * @param  clientDefinedBoolean84  Boolean
   */
  public void setClientDefinedBoolean84(Boolean clientDefinedBoolean84) {
    this.clientDefinedBoolean84 = clientDefinedBoolean84;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean85.
   *
   * @param  clientDefinedBoolean85  Boolean
   */
  public void setClientDefinedBoolean85(Boolean clientDefinedBoolean85) {
    this.clientDefinedBoolean85 = clientDefinedBoolean85;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean86.
   *
   * @param  clientDefinedBoolean86  Boolean
   */
  public void setClientDefinedBoolean86(Boolean clientDefinedBoolean86) {
    this.clientDefinedBoolean86 = clientDefinedBoolean86;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean87.
   *
   * @param  clientDefinedBoolean87  Boolean
   */
  public void setClientDefinedBoolean87(Boolean clientDefinedBoolean87) {
    this.clientDefinedBoolean87 = clientDefinedBoolean87;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean88.
   *
   * @param  clientDefinedBoolean88  Boolean
   */
  public void setClientDefinedBoolean88(Boolean clientDefinedBoolean88) {
    this.clientDefinedBoolean88 = clientDefinedBoolean88;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean89.
   *
   * @param  clientDefinedBoolean89  Boolean
   */
  public void setClientDefinedBoolean89(Boolean clientDefinedBoolean89) {
    this.clientDefinedBoolean89 = clientDefinedBoolean89;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean9.
   *
   * @param  clientDefinedBoolean9  Boolean
   */
  public void setClientDefinedBoolean9(Boolean clientDefinedBoolean9) {
    this.clientDefinedBoolean9 = clientDefinedBoolean9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean90.
   *
   * @param  clientDefinedBoolean90  Boolean
   */
  public void setClientDefinedBoolean90(Boolean clientDefinedBoolean90) {
    this.clientDefinedBoolean90 = clientDefinedBoolean90;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean91.
   *
   * @param  clientDefinedBoolean91  Boolean
   */
  public void setClientDefinedBoolean91(Boolean clientDefinedBoolean91) {
    this.clientDefinedBoolean91 = clientDefinedBoolean91;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean92.
   *
   * @param  clientDefinedBoolean92  Boolean
   */
  public void setClientDefinedBoolean92(Boolean clientDefinedBoolean92) {
    this.clientDefinedBoolean92 = clientDefinedBoolean92;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean93.
   *
   * @param  clientDefinedBoolean93  Boolean
   */
  public void setClientDefinedBoolean93(Boolean clientDefinedBoolean93) {
    this.clientDefinedBoolean93 = clientDefinedBoolean93;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean94.
   *
   * @param  clientDefinedBoolean94  Boolean
   */
  public void setClientDefinedBoolean94(Boolean clientDefinedBoolean94) {
    this.clientDefinedBoolean94 = clientDefinedBoolean94;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean95.
   *
   * @param  clientDefinedBoolean95  Boolean
   */
  public void setClientDefinedBoolean95(Boolean clientDefinedBoolean95) {
    this.clientDefinedBoolean95 = clientDefinedBoolean95;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean96.
   *
   * @param  clientDefinedBoolean96  Boolean
   */
  public void setClientDefinedBoolean96(Boolean clientDefinedBoolean96) {
    this.clientDefinedBoolean96 = clientDefinedBoolean96;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean97.
   *
   * @param  clientDefinedBoolean97  Boolean
   */
  public void setClientDefinedBoolean97(Boolean clientDefinedBoolean97) {
    this.clientDefinedBoolean97 = clientDefinedBoolean97;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean98.
   *
   * @param  clientDefinedBoolean98  Boolean
   */
  public void setClientDefinedBoolean98(Boolean clientDefinedBoolean98) {
    this.clientDefinedBoolean98 = clientDefinedBoolean98;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined boolean99.
   *
   * @param  clientDefinedBoolean99  Boolean
   */
  public void setClientDefinedBoolean99(Boolean clientDefinedBoolean99) {
    this.clientDefinedBoolean99 = clientDefinedBoolean99;
  }

  public Boolean getClientDefinedBoolean101() {
    return clientDefinedBoolean101;
  }

  public void setClientDefinedBoolean101(Boolean clientDefinedBoolean101) {
    this.clientDefinedBoolean101 = clientDefinedBoolean101;
  }

  public Boolean getClientDefinedBoolean102() {
    return clientDefinedBoolean102;
  }

  public void setClientDefinedBoolean102(Boolean clientDefinedBoolean102) {
    this.clientDefinedBoolean102 = clientDefinedBoolean102;
  }

  public Boolean getClientDefinedBoolean103() {
    return clientDefinedBoolean103;
  }

  public void setClientDefinedBoolean103(Boolean clientDefinedBoolean103) {
    this.clientDefinedBoolean103 = clientDefinedBoolean103;
  }

  public Boolean getClientDefinedBoolean104() {
    return clientDefinedBoolean104;
  }

  public void setClientDefinedBoolean104(Boolean clientDefinedBoolean104) {
    this.clientDefinedBoolean104 = clientDefinedBoolean104;
  }

  public Boolean getClientDefinedBoolean105() {
    return clientDefinedBoolean105;
  }

  public void setClientDefinedBoolean105(Boolean clientDefinedBoolean105) {
    this.clientDefinedBoolean105 = clientDefinedBoolean105;
  }

  public Boolean getClientDefinedBoolean106() {
    return clientDefinedBoolean106;
  }

  public void setClientDefinedBoolean106(Boolean clientDefinedBoolean106) {
    this.clientDefinedBoolean106 = clientDefinedBoolean106;
  }

  public Boolean getClientDefinedBoolean107() {
    return clientDefinedBoolean107;
  }

  public void setClientDefinedBoolean107(Boolean clientDefinedBoolean107) {
    this.clientDefinedBoolean107 = clientDefinedBoolean107;
  }

  public Boolean getClientDefinedBoolean108() {
    return clientDefinedBoolean108;
  }

  public void setClientDefinedBoolean108(Boolean clientDefinedBoolean108) {
    this.clientDefinedBoolean108 = clientDefinedBoolean108;
  }

  public Boolean getClientDefinedBoolean109() {
    return clientDefinedBoolean109;
  }

  public void setClientDefinedBoolean109(Boolean clientDefinedBoolean109) {
    this.clientDefinedBoolean109 = clientDefinedBoolean109;
  }

  public Boolean getClientDefinedBoolean110() {
    return clientDefinedBoolean110;
  }

  public void setClientDefinedBoolean110(Boolean clientDefinedBoolean110) {
    this.clientDefinedBoolean110 = clientDefinedBoolean110;
  }

  public Boolean getClientDefinedBoolean111() {
    return clientDefinedBoolean111;
  }

  public void setClientDefinedBoolean111(Boolean clientDefinedBoolean111) {
    this.clientDefinedBoolean111 = clientDefinedBoolean111;
  }

  public Boolean getClientDefinedBoolean112() {
    return clientDefinedBoolean112;
  }

  public void setClientDefinedBoolean112(Boolean clientDefinedBoolean112) {
    this.clientDefinedBoolean112 = clientDefinedBoolean112;
  }

  public Boolean getClientDefinedBoolean113() {
    return clientDefinedBoolean113;
  }

  public void setClientDefinedBoolean113(Boolean clientDefinedBoolean113) {
    this.clientDefinedBoolean113 = clientDefinedBoolean113;
  }

  public Boolean getClientDefinedBoolean114() {
    return clientDefinedBoolean114;
  }

  public void setClientDefinedBoolean114(Boolean clientDefinedBoolean114) {
    this.clientDefinedBoolean114 = clientDefinedBoolean114;
  }

  public Boolean getClientDefinedBoolean115() {
    return clientDefinedBoolean115;
  }

  public void setClientDefinedBoolean115(Boolean clientDefinedBoolean115) {
    this.clientDefinedBoolean115 = clientDefinedBoolean115;
  }

  public Boolean getClientDefinedBoolean116() {
    return clientDefinedBoolean116;
  }

  public void setClientDefinedBoolean116(Boolean clientDefinedBoolean116) {
    this.clientDefinedBoolean116 = clientDefinedBoolean116;
  }

  public Boolean getClientDefinedBoolean117() {
    return clientDefinedBoolean117;
  }

  public void setClientDefinedBoolean117(Boolean clientDefinedBoolean117) {
    this.clientDefinedBoolean117 = clientDefinedBoolean117;
  }

  public Boolean getClientDefinedBoolean118() {
    return clientDefinedBoolean118;
  }

  public void setClientDefinedBoolean118(Boolean clientDefinedBoolean118) {
    this.clientDefinedBoolean118 = clientDefinedBoolean118;
  }

  public Boolean getClientDefinedBoolean119() {
    return clientDefinedBoolean119;
  }

  public void setClientDefinedBoolean119(Boolean clientDefinedBoolean119) {
    this.clientDefinedBoolean119 = clientDefinedBoolean119;
  }

  public Boolean getClientDefinedBoolean120() {
    return clientDefinedBoolean120;
  }

  public void setClientDefinedBoolean120(Boolean clientDefinedBoolean120) {
    this.clientDefinedBoolean120 = clientDefinedBoolean120;
  }

  public Boolean getClientDefinedBoolean121() {
    return clientDefinedBoolean121;
  }

  public void setClientDefinedBoolean121(Boolean clientDefinedBoolean121) {
    this.clientDefinedBoolean121 = clientDefinedBoolean121;
  }

  public Boolean getClientDefinedBoolean122() {
    return clientDefinedBoolean122;
  }

  public void setClientDefinedBoolean122(Boolean clientDefinedBoolean122) {
    this.clientDefinedBoolean122 = clientDefinedBoolean122;
  }

  public Boolean getClientDefinedBoolean123() {
    return clientDefinedBoolean123;
  }

  public void setClientDefinedBoolean123(Boolean clientDefinedBoolean123) {
    this.clientDefinedBoolean123 = clientDefinedBoolean123;
  }

  public Boolean getClientDefinedBoolean124() {
    return clientDefinedBoolean124;
  }

  public void setClientDefinedBoolean124(Boolean clientDefinedBoolean124) {
    this.clientDefinedBoolean124 = clientDefinedBoolean124;
  }

  public Boolean getClientDefinedBoolean125() {
    return clientDefinedBoolean125;
  }

  public void setClientDefinedBoolean125(Boolean clientDefinedBoolean125) {
    this.clientDefinedBoolean125 = clientDefinedBoolean125;
  }

  public Boolean getClientDefinedBoolean126() {
    return clientDefinedBoolean126;
  }

  public void setClientDefinedBoolean126(Boolean clientDefinedBoolean126) {
    this.clientDefinedBoolean126 = clientDefinedBoolean126;
  }

  public Boolean getClientDefinedBoolean127() {
    return clientDefinedBoolean127;
  }

  public void setClientDefinedBoolean127(Boolean clientDefinedBoolean127) {
    this.clientDefinedBoolean127 = clientDefinedBoolean127;
  }

  public Boolean getClientDefinedBoolean128() {
    return clientDefinedBoolean128;
  }

  public void setClientDefinedBoolean128(Boolean clientDefinedBoolean128) {
    this.clientDefinedBoolean128 = clientDefinedBoolean128;
  }

  public Boolean getClientDefinedBoolean129() {
    return clientDefinedBoolean129;
  }

  public void setClientDefinedBoolean129(Boolean clientDefinedBoolean129) {
    this.clientDefinedBoolean129 = clientDefinedBoolean129;
  }

  public Boolean getClientDefinedBoolean130() {
    return clientDefinedBoolean130;
  }

  public void setClientDefinedBoolean130(Boolean clientDefinedBoolean130) {
    this.clientDefinedBoolean130 = clientDefinedBoolean130;
  }

  public Boolean getClientDefinedBoolean131() {
    return clientDefinedBoolean131;
  }

  public void setClientDefinedBoolean131(Boolean clientDefinedBoolean131) {
    this.clientDefinedBoolean131 = clientDefinedBoolean131;
  }

  public Boolean getClientDefinedBoolean132() {
    return clientDefinedBoolean132;
  }

  public void setClientDefinedBoolean132(Boolean clientDefinedBoolean132) {
    this.clientDefinedBoolean132 = clientDefinedBoolean132;
  }

  public Boolean getClientDefinedBoolean133() {
    return clientDefinedBoolean133;
  }

  public void setClientDefinedBoolean133(Boolean clientDefinedBoolean133) {
    this.clientDefinedBoolean133 = clientDefinedBoolean133;
  }

  public Boolean getClientDefinedBoolean134() {
    return clientDefinedBoolean134;
  }

  public void setClientDefinedBoolean134(Boolean clientDefinedBoolean134) {
    this.clientDefinedBoolean134 = clientDefinedBoolean134;
  }

  public Boolean getClientDefinedBoolean135() {
    return clientDefinedBoolean135;
  }

  public void setClientDefinedBoolean135(Boolean clientDefinedBoolean135) {
    this.clientDefinedBoolean135 = clientDefinedBoolean135;
  }

  public Boolean getClientDefinedBoolean136() {
    return clientDefinedBoolean136;
  }

  public void setClientDefinedBoolean136(Boolean clientDefinedBoolean136) {
    this.clientDefinedBoolean136 = clientDefinedBoolean136;
  }

  public Boolean getClientDefinedBoolean137() {
    return clientDefinedBoolean137;
  }

  public void setClientDefinedBoolean137(Boolean clientDefinedBoolean137) {
    this.clientDefinedBoolean137 = clientDefinedBoolean137;
  }

  public Boolean getClientDefinedBoolean138() {
    return clientDefinedBoolean138;
  }

  public void setClientDefinedBoolean138(Boolean clientDefinedBoolean138) {
    this.clientDefinedBoolean138 = clientDefinedBoolean138;
  }

  public Boolean getClientDefinedBoolean139() {
    return clientDefinedBoolean139;
  }

  public void setClientDefinedBoolean139(Boolean clientDefinedBoolean139) {
    this.clientDefinedBoolean139 = clientDefinedBoolean139;
  }

  public Boolean getClientDefinedBoolean140() {
    return clientDefinedBoolean140;
  }

  public void setClientDefinedBoolean140(Boolean clientDefinedBoolean140) {
    this.clientDefinedBoolean140 = clientDefinedBoolean140;
  }

  public Boolean getClientDefinedBoolean141() {
    return clientDefinedBoolean141;
  }

  public void setClientDefinedBoolean141(Boolean clientDefinedBoolean141) {
    this.clientDefinedBoolean141 = clientDefinedBoolean141;
  }

  public Boolean getClientDefinedBoolean142() {
    return clientDefinedBoolean142;
  }

  public void setClientDefinedBoolean142(Boolean clientDefinedBoolean142) {
    this.clientDefinedBoolean142 = clientDefinedBoolean142;
  }

  public Boolean getClientDefinedBoolean143() {
    return clientDefinedBoolean143;
  }

  public void setClientDefinedBoolean143(Boolean clientDefinedBoolean143) {
    this.clientDefinedBoolean143 = clientDefinedBoolean143;
  }

  public Boolean getClientDefinedBoolean144() {
    return clientDefinedBoolean144;
  }

  public void setClientDefinedBoolean144(Boolean clientDefinedBoolean144) {
    this.clientDefinedBoolean144 = clientDefinedBoolean144;
  }

  public Boolean getClientDefinedBoolean145() {
    return clientDefinedBoolean145;
  }

  public void setClientDefinedBoolean145(Boolean clientDefinedBoolean145) {
    this.clientDefinedBoolean145 = clientDefinedBoolean145;
  }

  public Boolean getClientDefinedBoolean146() {
    return clientDefinedBoolean146;
  }

  public void setClientDefinedBoolean146(Boolean clientDefinedBoolean146) {
    this.clientDefinedBoolean146 = clientDefinedBoolean146;
  }

  public Boolean getClientDefinedBoolean147() {
    return clientDefinedBoolean147;
  }

  public void setClientDefinedBoolean147(Boolean clientDefinedBoolean147) {
    this.clientDefinedBoolean147 = clientDefinedBoolean147;
  }

  public Boolean getClientDefinedBoolean148() {
    return clientDefinedBoolean148;
  }

  public void setClientDefinedBoolean148(Boolean clientDefinedBoolean148) {
    this.clientDefinedBoolean148 = clientDefinedBoolean148;
  }

  public Boolean getClientDefinedBoolean149() {
    return clientDefinedBoolean149;
  }

  public void setClientDefinedBoolean149(Boolean clientDefinedBoolean149) {
    this.clientDefinedBoolean149 = clientDefinedBoolean149;
  }

  public Boolean getClientDefinedBoolean150() {
    return clientDefinedBoolean150;
  }

  public void setClientDefinedBoolean150(Boolean clientDefinedBoolean150) {
    this.clientDefinedBoolean150 = clientDefinedBoolean150;
  }
} // end class AccountExtensionBoolean
