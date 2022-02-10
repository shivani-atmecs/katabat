package com.cmc.credagility.core.domain.type;

/**
 * Typesafe enumeration class for country list codes.
 *
 * <p><a href="SLMCountryCodes.java.html"><i>View Source</i></a></p>
 *
 * @author   ramakrishna.g
 * @version  10/16/2014 14:29
 */
public enum SLMCountryCodes {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  AFG("Afghanistan"), AGU("Anguilla"), ALB("Albania"), ALG("Algeria"), AND("Andorra"), ANG("Angola"),
  ANT("Antigua and Barbuda"), ARG("Argentina"), ARM("Armenia"), ARU("Aruba"), ASC("Ascension"), AUS("Australia"),
  AUT("Austria"), AZE("Azerbaijan"), AZO("Azores"), BAH("Bahamas"), BAN("Bangladesh"), BAR("Barbados"),
  BAT("British Antartic Terr"), BEL("Belgium"), BEN("Benin"), BER("Bermuda"), BHR("Bahrain"), BHU("Bhutan"),
  BIO("British Indian Ocean Terr"), BLR("Belarus"), BLZ("Belize"), BOL("Bolivia"), BOS("Bosnia-Hercegovina"),
  BOT("Botswana"), BRA("Brazil"), BRD("Burundi"), BRM("Burma"), BRU("Brunei Darussalam"), BUL("Bulgaria"),
  BUR("Burkina Faso"), BVI("British Virgin Islands"), CAM("Cameroon"), CAN("Canada"), CAP("Cape Verde"),
  CAR("Central African Republic"), CAY("Cayman Islands"), CHA("Chad"), CHI("Chile"), CHN("China"), COL("Colombia"),
  COM("Comoros"), CON("Congo"), COR("Corsica"), COS("Costa Rica"), COT("Cote D'Ivoire"), CRO("Croatia"), CUB("Cuba"),
  CYP("Cyprus"), CZE("Czech Republic"), DEN("Denmark"), DJI("Djibouti"), DMR("Dominican Republic"), DOM("Dominica"),
  ECU("Ecuador"), EGY("Egypt"), ELS("El Salvador"), EQU("Equatorial Guinea"), ERI("Eritrea"), EST("Estonia"),
  ETH("Ethiopia"), ETI("East Timor"), FAL("Falkland Islands"), FAR("Faroe Islands"), FIJ("Fiji"), FIN("Finland"),
  FRA("France"), FRG("French Guiana"), FRP("French Polynesia"), GAB("Gabon"), GAM("Gambia"), GEO("Republic of Georgia"),
  GER("Germany"), GHA("Ghana"), GIB("Gibraltar"), GRE("Greece"), GRL("Greenland"), GRN("Grenada"), GUB("Guinea-Bissau"),
  GUD("Guadeloupe"), GUI("Guinea"), GUT("Guatemala"), GUY("Guyana"), HAI("Haiti"), HNK("Hong Kong"), HON("Honduras"),
  HUN("Hungary"), ICE("Iceland"), IDO("Indonesia"), IND("India"), IRA("Iran"), IRE("Ireland"), IRQ("Iraq"),
  ISR("Israel"), ITA("Italy"), JAM("Jamaica"), JOR("Jordan"), JPN("Japan"), KAM("Kampuchea"), KAZ("Kazakhstan"),
  KEN("Kenya"), KIR("Kiribati"), KUW("Kuwait"), KYR("Kyrgyzstan"), LAO("Laos"), LAT("Latvia"), LBY("Libya"),
  LEB("Lebanon"), LES("Lesotho"), LIB("Liberia"), LIE("Liechtenstein"), LIT("Lithuania"), LUX("Luxembourg"),
  MAC("Macao"), MAD("Madagascar"), MAL("Malawi"), MAR("Martinique"), MAU("Mauritania"), MCE("Macedonia"),
  MDR("Madeira Islands"), MEX("Mexico"), MLD("Maldives"), MLI("Mali"), MLT("Malta"), MLY("Malaysia"), MNG("Mongolia"),
  MNO("Montenegro"), MNT("Montserrat"), MOL("Moldova"), MOR("Morocco"), MOZ("Mozambique"), MRT("Mauritius"),
  NAM("Namibia"), NAU("Nauru"), NCA("New Caledonia"), NEP("Nepal"), NET("Netherlands"), NGR("Nigeria"),
  NIC("Nicaragua"), NIG("Niger"), NKR("North Korea"), NOR("Norway"), NTA("Netherlands Antilles"), NZE("New Zealand"),
  OMA("Oman"), PAK("Pakistan"), PAN("Panama"), PAP("Papua New Guinea"), PAR("Paraguay"), PER("Peru"),
  PHI("Philippines"), PIT("Pitcairn Island"), POL("Poland"), POR("Portugal"), QAT("Qatar"), REU("Reunion Island"),
  ROM("Romania"), RUS("Russia"), RWA("Rwanda"), SAF("South Africa"), SAO("Sao Tome and Principe"), SAU("Saudi Arabia"),
  SEN("Senegal"), SER("Serbia"), SEY("Seychelles"), SIE("Sierra Leone"), SIN("Singapore"), SKR("South Korea"),
  SOL("Solomon Islands"), SOM("Somalia"), SPN("Spain"), SRI("Sri Lanka"), STC("St Christopher and Nevis"),
  STH("St Helena"), STL("St Lucia"), STP("St Pierre and Miquelon"), STV("St Vincent and Grenadines"), SUD("Sudan"),
  SUR("Suriname"), SVK("Slovak Republic"), SVN("Slovenia"), SWA("Swaziland"), SWE("Sweden"), SWI("Switzerland"),
  SYR("Syria"), TAI("Taiwan"), TAJ("Tajikistan"), TAN("Tanzania"), TCI("Turks and Caicos Islands"), THA("Thailand"),
  TOG("Togo"), TON("Tonga"), TRI("Trinidad and Tobago"), TRK("Turkmenistan"), TRS("Tristan Da Cunha"), TUN("Tunisia"),
  TUR("Turkey"), TUV("Tuvalu"), UAE("United Arab Emirates"), UGA("Uganda"), UKN("United Kingdom"), UKR("Ukraine"),
  URU("Uruguay"), USA("United States"), UZB("Uzbekistan"), VAN("Vanuatu"), VAT("Vatican City"), VEN("Venezuela"),
  VIE("Vietnam"), WAF("West Africa"), WAL("Wallis and Futuna Islands"), WSM("Western Samoa"), YEM("Republic of Yemen"),
  YUG("Yugoslavia"), ZAI("Zaire"), ZAM("Zambia"), ZIM("Zimbabwe");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String value;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private SLMCountryCodes() {
    this.value = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  value  name
   */
  private SLMCountryCodes(String value) {
    this.value = value;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Get the string value for the enum.
   *
   * @return  enum string value
   */
  @Override public String toString() {
    return value;
  }

}
