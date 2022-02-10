package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:31
 */
public enum USBFieldCodes {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  // Customer (Primary)
  P_ADDR1("MASAD1"), P_ADDR2("MASAD2"), P_CITY("MASCTY"), P_STATE("MASSTC"), P_ZIP("MASZIP"), P_HOMEPHONE("MASHPH"),
  P_WORKPHONE("MASOPH"), P_EXP_CONSENT_CODE("CMCECC"), P_MOBILEPHONE("CMCCP1"), P_MOBILEPHONE2("CMCCP1"),
  P_HOMEEMAIL("N00ENM"), P_OTHEREMAIL("N00EAD"),

  // Co-Maker(Secondary)
  C_ADDR1("C01AD1"), C_ADDR2("C01AD2"), C_CITY("C01CTY"), C_STATE("C01STC"), C_ZIP("C01ZIP"), C_HOMEPHONE("C01HPH"),
  C_WORKPHONE("C01OPH"), C_EXP_CONSENT_CODE(""), C_MOBILEPHONE("C011"), C_MOBILEPHONE2("C012"), C_HOMEEMAIL("C011"),
  C_OTHEREMAIL("C012"),

  // Approving Officer
  A_ADDR1("C10AD1"), A_ADDR2("C10AD2"), A_CITY("C10CTY"), A_STATE("C10STC"), A_ZIP("C10ZIP"), A_HOMEPHONE("C10HPH"),
  A_WORKPHONE("C10OPH"), A_EXP_CONSENT_CODE(""), A_MOBILEPHONE("C101"), A_MOBILEPHONE2("C102"), A_HOMEEMAIL("C101"),
  A_OTHEREMAIL("C102"),
  // Other use full values

  ADDR1("1"), ADDR2("2"), CITY("3"), STATE("4"), ZIP("5"), MOBILEPHONE2("");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  String value;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private USBFieldCodes() { }

  private USBFieldCodes(String value) {
    this.value = value;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for value.
   *
   * @return  String
   */
  public String getValue() {
    return value;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for value.
   *
   * @param  value  String
   */
  public void setValue(String value) {
    this.value = value;
  }
}
