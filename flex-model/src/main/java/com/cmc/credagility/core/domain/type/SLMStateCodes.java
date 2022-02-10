package com.cmc.credagility.core.domain.type;

/**
 * Typesafe enumeration class for US States list codes.
 *
 * <p><a href="SLMStateCodes.java.html"><i>View Source</i></a></p>
 *
 * @author   ramakrishna.g
 * @version  10/16/2014 14:29
 */
public enum SLMStateCodes {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  AK("Alaska"), AL("Alabama"), AR("Arkansas"), AS("American Samoa"), AZ("Arizona"), CA("California"), CO("Colorado"),
  CT("Connecticut"), DC("District Of Columbia"), DE("Delaware"), FL("Florida"), FM("Federated States of Micronesia"),
  FO("Foreign"), GA("Georgia"), GU("Guam"), HI("Hawaii"), IA("Iowa"), ID("Idaho"), IL("Illinois"), IN("Indiana"),
  KS("Kansas"), KY("Kentucky"), LA("Louisiana"), MA("Massachusetts"), MD("Maryland"), ME("Maine"),
  MH("Marshall Islands"), MI("Michigan"), MN("Minnesota"), MO("Missouri"), MP("Northern Mariana Islands"),
  MS("Mississippi"), MT("Montana"), NC("North Carolina"), ND("North Dakota"), NE("Nebraska"), NH("New Hampshire"),
  NJ("New Jersey"), NM("New Mexico"), NV("Nevada"), NY("New York"), OH("Ohio"), OK("Oklahoma"), OR("Oregon"),
  PA("Pennsylvania"), PR("Puerto Rico"), PW("Palau"), RI("Rhode Island"), SC("South Carolina"), SD("South Dakota"),
  TN("Tennessee"), TT("Trust Territories"), TX("Texas"), UM("U.S. Minor Outlying Islands"), UT("Utah"), VA("Virginia"),
  VI("Virgin Islands of the U.S."), VT("Vermont"), WA("Washington"), WI("Wisconsin"), WV("West Virginia"),
  WY("Wyoming");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String value;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum.
   */
  private SLMStateCodes() {
    this.value = this.name();
  }

  /**
   * Define enum with string value.
   *
   * @param  value  String
   */
  private SLMStateCodes(String value) {
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
