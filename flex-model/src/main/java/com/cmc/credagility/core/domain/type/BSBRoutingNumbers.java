package com.cmc.credagility.core.domain.type;

import org.apache.commons.lang3.math.NumberUtils;


/**
 * BSBRoutingNumbers.java is the enum class for BSB Routing Numbers Definitions of portfolio 61.
 *
 * @author   Venkat Vemireddy CMC - Karthikeyan Palanivelu Etisbew - Praveen Batchu
 * @version  1.0 Aug 31, 2009; Created
 */
public enum BSBRoutingNumbers {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  // ~ Enum constants
  // ---------------------------------------------------------------------------------------------------

  ASL("57", "Australian Settlements Limited"), ADL("61", "Adelaide Bank Limited"),
  ARA("917", "Arab bank Australia Limited"), ABS("630", "ABS Building Society Ltd"), AMP("939", "AMP Bank Limited"),
  ANZ("01", "Australia and New Zealand Banking Group Limited"), TC("15", "Town and Country Bank"),
  APO("90", "Australia Post (Money Orders)"), BAL("23", "Bank of America National Association"),
  BCA("980", "Bank of China (Australia) Limited"), BCY("941", "Bank of Cyprus Australia Pty Limited"),
  BOC("35", "Bank of China"), BQL("12", "Bank of Queensland Limited"),
  BOT("29", "Bank of Tokyo-Mitsubishi UFJ. Ltd (The)"), BWQ("30", "Bank of Western Australia Limited"),
  BWA("30", "Bankwest"), BAE("632", "B&E Limited"), BBL("633", "Bendigo Bank Limited"),
  CMB("21", "JPMorgan Chase Bank, N.A."), FNC("915", "Bank One NA"), CTI("24", "Citigroup Pty Limited"),
  CBA("06", "Commonwealth Bank of Australia"), CBA1("76", "Commonwealth Bank of Australia"),
  CST("40", "Colonial State Bank"), TBT("42", "Colonial Trust Bank"), TBT1("52", "Colonial Trust Bank"),
  CRU("80", "Cuscal Limited"), CUS("70", "Indue Limited"), DBA("41", "Deutsche Bank Aktiengesellschaft"),
  GBS("637", "Greater Building Society Limited"), GBS1("657", "Greater Building Society Limited"),
  HBS("638", "Heritage Building Society Limited"), HBS1("880", "Heritage Building Society Limited"),
  HBA("34", "HSBC Bank Australia Limited"), HOM("639", "Home Building Society Limited"),
  HSB("985", "Hongkong & Shanghai Banking Corporation Limited (The), Australian Branch"),
  HUM("640", "Hume Building Society Limited"), IMB("641", "IMB Limited"),
  AUB("647", "Australian Unity Building Society"), ING("923", "ING Bank Australia Limited"), GNI("936", "ING Bank, NV"),
  ICB("931", "Mega International Commercial Bank Co. Ltd"), LBA("942", "Laiki Bank Australia Ltd"),
  MPB("645", "Mackay Permanent Building Society Limited"), MBL("18", "Macquarie Bank Limited"),
  MCB("918", "Mizuho Corporate Bank Limited"), MEB("944", "Members Equity Pty Limited"),
  MMB("646", "Maitland Mutual Building Society Limited"), MET("48", "Suncorp-Metway Ltd"),
  SUN("664", "Suncorp-Metway Ltd"), MID("921", "HSBC Bank plc"), MSL("969", "MoneySwitch Limited"),
  NAB("08", "National Australia Bank Limited"), NAB1("08", "National Australia Bank Limited"),
  NEW("650", "Newcastle Permanent Building Society Limited"), OCB("45", "Oversea-Chinese Banking Corporation Limited"),
  PCU("815", "Police Department Employees Credit Union Limited (THe)"),
  PPB("653", "Pioneer Permanent Building Society Limited"), PIB("14", "Rabobank Australia Limited"),
  RBA("09", "Reserve Bank of Australia"), ROK("655", "Rock Building Society Limited (The)"),
  SSB("913", "State Street Bank and Trust Company"), STG("11", "St George Bank Limited"),
  SGP("33", "St. George Bank Limited"), ADV("46", "Advance Bank Australia"), BSA("10", "Bank of South Australia"),
  TBB("943", "Taiwan Business Bank, Sydney Branch"), UBS("946", "UBS AG, Australia Branch"),
  UOB("922", "United Overseas Bank Limited"), WBC("03", "Westpac Banking Corporation"),
  WBC1("73", "Westpac Banking Corporation"), BOM("19", "Bank of Melbourne"), BML("55", "Bank of Melbourne"),
  BTA("26", "Bankers Trust Australia"), CBL("47", "Challenge Bank"), BAY("656", "Wide Bay Australia Ltd"),
  BNP("22", "BNP Paribas"), BPS("25", "BNP Paribas Securities"), MCU("31", "Bankmecu"),
  CFC("512", "Community First Credit Union"), QTM("514", "QT Mutual Bank"), SEL("611", "Select Credit Union"),
  UFS("634", "Uniting Financial Services"), ADC("642", "Australian Defence Credit Union"), SGE("659", "GC Mutual Bank"),
  GTW("676", "	Gateway Credit Union"), HCC("721", "Holiday Coast Credit Union"), SNX("722", "Southern Cross Credit"),
  HIC("723", "Heritage Isle Credit Union"), RCU("724", "Railways Credit Union"), SCU("728", "Summerland Credit Union"),
  PNB("777", "Police & Nurse"), TMB("812", "Teachers Mutual Bank"), CAP("813", "Capricornian"),
  CUA("814", "Credit Union Australia"), WCU("817", "Warwick Credit Union"), COM("818", "Bank of Communications"),
  IBK("819", "Industrial & Commercial Bank of China"), ENC("823", "Encompass Credit Union"),
  STH("824", "Sutherland Credit Union"), SKY("825", "Big Sky Building Society"),
  MMP("882", "Maritime Mining & Power Credit Union"), SMB("911", "Sumitomo Mitsui Banking Corporation"),
  NEC("932", "Community Mutual"), INV("951", "BOQ Specialist Bank"), RBS("952", "Royal Bank of Scotland");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  // ~ Instance fields
  // --------------------------------------------------------------------------------------------------

  /** Code description. */
  private String description;

  /** Code number. */
  private String number;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  // ~ Constructors
  // -----------------------------------------------------------------------------------------------------

  /**
   * Define enum with string value.
   *
   * @param  number       DOCUMENT ME!
   * @param  description  DOCUMENT ME!
   */
  private BSBRoutingNumbers(String number, String description) {
    this.number      = number;
    this.description = description;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  // ~ Methods
  /**
   * getter method for BSBNumber.
   *
   * @param   number  String
   *
   * @return  BSBRoutingNumbers
   */
  public static BSBRoutingNumbers getBSBNumber(String number) {
    if (!NumberUtils.isNumber(number)) {
      return null;
    }

    return matchingRoutingNumber(number);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for description.
   *
   * @return  String
   */
  public String getDescription() {
    return this.description;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the string value for the enum.
   *
   * @return  enum string value
   */
  public String getNumber() {
    return this.number;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private static BSBRoutingNumbers getBsb(String in) {
    BSBRoutingNumbers routingNumber = null;

    for (BSBRoutingNumbers b : BSBRoutingNumbers.values()) {
      if (in.equalsIgnoreCase(b.getNumber())) {
        routingNumber = b;
      }
    }

    return routingNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private static BSBRoutingNumbers matchingRoutingNumber(String in) {
    BSBRoutingNumbers routingNumber = null;
    int               inLen         = in.length();

    if (inLen > 2) {
      routingNumber = getBsb(in.substring(0, 3));
    }

    if (routingNumber == null) {
      if (inLen >= 2) {
        routingNumber = getBsb(in.substring(0, 2));
      }
    }

    return routingNumber;
  }
}
