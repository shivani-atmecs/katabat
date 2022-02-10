package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:18
 */
public enum ContactChannel {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  HOMEPHONE("HomePhone", 1L), WORKPHONE("WorkPhone", 2L), MOBILEPHONE("MobilePhone", 3L), OTHERPHONE("OtherPhone", 4L),
  SMSPHONE("SMSPhone", 5L), HOMEPHONE2("HomePhone2", 6L), OTHERPHONE2("OtherPhone2", 7L),
  OTHERPHONE3("OtherPhone3", 8L), OTHERPHONE4("OtherPhone4", 9L), MOBILEPHONE2("MobilePhone2", 10L),
  EMPLOYERPHONE("EmployerPhone", 11L), SCHOOLPHONE("SchoolPhone", 12L), REMINDERPHONE("ReminderPhone", 13L),
  APPOINTMENTPHONE("AppointmentPhone", 14L), BUSINESSPHONE("BusinessPhone", 15L), ALTPHONE1("AltPhone1", 16L),
  ALTPHONE2("AltPhone2", 17L), ALTPHONE3("AltPhone3", 18L), ALTPHONE4("AltPhone4", 19L), ALTPHONE5("AltPhone5", 20L),
  ALTPHONE6("AltPhone6", 21L), FAXPHONE("FaxPhone", 22L), AGENCYHOMEPHONE("AgencyHomePhone", 23L),
  AGENCYWORKPHONE("AgencyWorkPhone", 24L), AGENCYMOBILEPHONE("AgencyMobilePhone", 25L),
  AGENCYFAXPHONE("AgencyFaxPhone", 26L), PAGERPHONE("PagerPhone", 27L), WORKPHONE2("WorkPhone2", 28L),
  PRIMARYCONTACTPHONE("PrimaryContactPhone", 29L), BUREAUPHONE1("BureauPhone1", 30L), BUREAUPHONE2("BureauPhone2", 31L),
  BUREAUPHONE3("BureauPhone3", 32L),

  // EMAIL
  HOMEEMAIL("HomeEmail", 1L, ContactChannelType.EMAIL), WORKEMAIL("WorkEmail", 2L, ContactChannelType.EMAIL),
  OTHEREMAIL("OtherEmail", 3L, ContactChannelType.EMAIL), REMINDEREMAIL("ReminderEmail", 4L, ContactChannelType.EMAIL),
  BUSINESSEMAIL("BusinessEmail", 5L, ContactChannelType.EMAIL),
  AGENCYHOMEEMAIL("AgencyHomeEmail", 6L, ContactChannelType.EMAIL),
  AGENCYOTHEREMAIL("AgencyOtherEmail", 7L, ContactChannelType.EMAIL),
  PRIMARYCONTACTEMAIL("PrimaryContactEmail", 8L, ContactChannelType.EMAIL),
  THIRDPARTYEMAIL("ThirdPartyEmail", 9L, ContactChannelType.EMAIL),  
  SERVICEEMAIL("ServiceEmail", 10L, ContactChannelType.EMAIL),

  // ADDRESS
  HOMEADDRESS("HomeAddress", 1L, ContactChannelType.ADDRESS),
  WORKADDRESS("WorkAddress", 2L, ContactChannelType.ADDRESS),
  OTHERADDRESS("OtherAddress", 3L, ContactChannelType.ADDRESS),
  STATEMENTADDRESS("StatementAddress", 4L, ContactChannelType.ADDRESS),
  BUSINESSADDRESS("BusinessAddress", 5L, ContactChannelType.ADDRESS),
  MAILINGADDRESS("MailingAddress", 6L, ContactChannelType.ADDRESS),
  PREVIOUSHOMEADDRESS("PreviousHomeAddress", 7L, ContactChannelType.ADDRESS),
  AGENCYHOMEADDRESS("AgencyHomeAddress", 8L, ContactChannelType.ADDRESS),
  AGENCYMAILINGADDRESS("AgencyMailingAddress", 9L, ContactChannelType.ADDRESS),
  PAYGADDRESS("PayGAddress", 10L, ContactChannelType.ADDRESS), POSTALADDRESS("Postal", 11L, ContactChannelType.ADDRESS),
  REGISTEREDADDRESS("Registered", 12L, ContactChannelType.ADDRESS),
  DELIVERYADDRESS("Delivery", 13L, ContactChannelType.ADDRESS),
  BILLINGADDRESS("BillingAddress", 14L, ContactChannelType.ADDRESS),
  PRIMARYCONTACTADDRESS("PrimaryContactAddress", 15L, ContactChannelType.ADDRESS),
  BUREAUADDRESS1("BureauAddress1", 16L, ContactChannelType.ADDRESS),
  BUREAUADDRESS2("BureauAddress2", 17L, ContactChannelType.ADDRESS),
  BUREAUADDRESS3("BureauAddress3", 18L, ContactChannelType.ADDRESS);

  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  public static final ContactChannel[] PHONE_CHANNELS = new ContactChannel[] {
    ContactChannel.HOMEPHONE,
    ContactChannel.HOMEPHONE2,
    ContactChannel.WORKPHONE,
    ContactChannel.WORKPHONE2,
    ContactChannel.MOBILEPHONE,
    ContactChannel.SMSPHONE,
    ContactChannel.OTHERPHONE,
    ContactChannel.OTHERPHONE2,
    ContactChannel.OTHERPHONE3,
    ContactChannel.OTHERPHONE4,
    ContactChannel.MOBILEPHONE2,
    ContactChannel.EMPLOYERPHONE,
    ContactChannel.SCHOOLPHONE,
    ContactChannel.REMINDERPHONE,
    ContactChannel.APPOINTMENTPHONE
  };


  /** TODO: DOCUMENT ME! */
  public static final ContactChannel[] EMAIL_CHANNELS = new ContactChannel[] {
    ContactChannel.HOMEEMAIL,
    ContactChannel.WORKEMAIL,
    ContactChannel.REMINDEREMAIL
  };


  /** TODO: DOCUMENT ME! */
  public static final ContactChannel[] ADDRESS_CHANNELS = new ContactChannel[] {
    ContactChannel.HOMEADDRESS,
    ContactChannel.WORKADDRESS,
    ContactChannel.OTHERADDRESS,
    ContactChannel.STATEMENTADDRESS
  };

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private ContactChannelType channelType;
  private String             strValue;
  private Long               typeId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  private ContactChannel(String strValue, Long typeId) {
    this.strValue    = strValue;
    this.typeId      = typeId;
    this.channelType = ContactChannelType.PHONE;
  }

  private ContactChannel(String strValue, Long typeId, ContactChannelType channelType) {
    this.strValue    = strValue;
    this.typeId      = typeId;
    this.channelType = channelType;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toContactChannel.
   *
   * @param   strValue  String
   *
   * @return  ContactChannel
   */
  public static ContactChannel toContactChannel(String strValue) {
    if (strValue == null) {
      return null;
    }

    for (ContactChannel b : ContactChannel.values()) {
      if (b.toString().equalsIgnoreCase(strValue)) {
        return b;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toContactChannel.
   *
   * @param   typeId       Long
   * @param   channelType  ContactChannelType
   *
   * @return  ContactChannel
   */
  public static ContactChannel toContactChannel(Long typeId, ContactChannelType channelType) {
    if ((typeId == null) || (channelType == null)) {
      return null;
    }

    for (ContactChannel b : ContactChannel.values()) {
      if ((typeId.equals(b.getTypeId())) && b.getChannelType().equals(channelType)) {
        return b;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel type.
   *
   * @return  ContactChannelType
   */
  public ContactChannelType getChannelType() {
    return channelType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for string type id.
   *
   * @return  String
   */
  public String getStringTypeId() {
    return typeId.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for type id.
   *
   * @return  Long
   */
  public Long getTypeId() {
    return typeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  Enum#toString()
   */
  @Override public String toString() {
    return strValue;
  }
}
