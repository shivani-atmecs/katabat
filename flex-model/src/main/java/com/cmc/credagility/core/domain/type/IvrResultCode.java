package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:24
 */
public enum IvrResultCode {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  NO_ANSWER(1L, "0005", "No answer"),                                                                                    //
  BUSY(2L, "0010", "Busy"),                                                                                              //
  NO_RING(3L, "0015", "No ring"),                                                                                        //
  SIT_TONE(4L, "0017", "SIT Tone"),                                                                                      //
  CALLS_ANSWERED_WITH_ANSWERING_MACHINE_BUT_MESSAGE_NOT_LEFT(5L, "0018",
    "Calls answered with answering machine but message not left"),                                                       //
  DISCONNECTED_AT_OUTBOUND_GREETING(6L, "0020", "Disconnected at outbound greeting"),                                    //
  DISCONNECTED_AFTER_OUTBOUND_SECURITY_INFORMATION_AUTHENTICATION(7L, "0021",
    "Disconnected after outbound security information authentication"),                                                  //
  DISCONNECTED_AFTER_INBOUND_GREETING(8L, "0022", "Disconnected after inbound greeting"),                                //
  DISCONNECTED_AFTER_INBOUND_REFERENCE_NUMBER_AUTHENTICATION(9L, "0023",
    "Disconnected after inbound reference number authentication"),                                                       //
  DISCONNECTED_AFTER_INBOUND_REFERENCE_NUMBER_REMINDER(10L, "0024",
    "Disconnected after inbound reference number reminder"),                                                             //
  DISCONNECTED_AFTER_INBOUND_SECURITY_INFORMATION_AUTHENTICATION(11L, "0025",
    "Disconnected after inbound security information authentication"),                                                   //
  DISCONNECTED_AFTER_OUTBOUND_ACCOUNT_IDENTIFICATION(12L, "0026", "Disconnected after outbound account identification"), //
  DISCONNECTED_AFTER_INBOUND_ACCOUNT_IDENTIFICATION(13L, "0027", "Disconnected after inbound account identification"),   //
  DISCONNECTED_AFTER_AUTOMATED_VS_ADVISOR_CHOICE(14L, "0028", "Disconnected after automated vs. advisor choice"),        //
  DISCONNECTED_AFTER_CURRENTLY_ON_A_PROGRAM(15L, "0029", "Disconnected after currently on a program"),                   //
  DISCONNECTED_AFTER_OFFER(16L, "0030", "Disconnected after offer"),                                                     //
  DISCONNECTED_AFTER_OFFER_ACCEPTANCE(17L, "0031", "Disconnected after offer acceptance"),                               //
  DISCONNECTED_AFTER_OFFER_ACCEPTANCE_REMINDER(18L, "0032", "Disconnected after offer acceptance reminder"),             //
  DISCONNECTED_AFTER_MINI_MIRANDA(19L, "0033", "Disconnected after mini Miranda"),                                       //
  DISCONNECTED_AFTER_PAYMENT_CHANNEL(20L, "0034", "Disconnected after payment channel"),                                 //
  DISCONNECTED_AFTER_PAYMENT_CHANNEL_TYPE(21L, "0035", "Disconnected after payment channel type"),                       //
  DISCONNECTED_AFTER_OPTIONAL_WEBSITE_INFORMATION(22L, "0036", "Disconnected after optional website information"),       //
  DISCONNECTED_AFTER_CHECKING_SAVINGS_ACCOUNT_OVERVIEW(23L, "0037",
    "Disconnected after checking/saving account overview"),                                                             //
  DISCONNECTED_AFTER_ROUTING_NUMBER_ENTRY(24L, "0038", "Disconnected after routing number entry"),                       //
  DISCONNECTED_AFTER_ROUTING_NUMBER_CONFIRMATION(25L, "0039", "Disconnected after routing number confirmation"),         //
  DISCONNECTED_AFTER_INVALID_ROUTING_NUMBER(26L, "0040", "Disconnected after invalid routing number"),                   //
  DISCONNECTED_AFTER_CHECKING_SAVINGS_ACCOUNT_ENTRY(27L, "0041", "Disconnected after checking/saving account entry"),   //
  DISCONNECTED_AFTER_CHECKING_SAVINGS_CONFIRMATION(28L, "0042", "Disconnected after checking/saving confirmation"),     //
  DISCONNECTED_AFTER_INVALID_CHECKING_SAVINGS(29L, "0043", "Disconnected after invalid checking/saving"),               //
  DISCONNECTED_AFTER_CREDIT_DEBIT_CARD_OVERVIEW(30L, "0044", "Disconnected after credit/debit card overview"),           //
  DISCONNECTED_AFTER_CARD_NUMBER_ENTRY(31L, "0045", "Disconnected after card number entry"),                             //
  DISCONNECTED_AFTER_CARD_NUMBER_CONFIRMATION(32L, "0046", "Disconnected after card number confirmation"),               //
  DISCONNECTED_AFTER_INVALID_CARD_NUMBER(33L, "0047", "Disconnected after invalid card number"),                         //
  DISCONNECTED_AFTER_EXPIRATION_DATE_ENTRY(34L, "0048", "Disconnected after expiration date entry"),                     //
  DISCONNECTED_AFTER_EXPIRATION_DATE_CONFIRMATION(35L, "0049", "Disconnected after expiration date confirmation"),       //
  DISCONNECTED_AFTER_INVALID_EXPIRATION_DATE(36L, "0050", "Disconnected after invalid expiration date"),                 //
  DISCONNECTED_AFTER_PAYMENT_AGREEMENT(37L, "0051", "Disconnected after payment agreement"),                             //
  DISCONNECTED_AFTER_NACHA_AUTHORIZATION(38L, "0052", "Disconnected after NACHA authorization"),                         //
  DISCONNECTED_AFTER_HOLDING_FOR_TRACKING_NUMBER(39L, "0053", "Disconnected after holding for tracking number"),         //
  DISCONNECTED_AFTER_TRACKING_NUMBER(40L, "0054", "Disconnected after tracking number"),                                 //
  DISCONNECTED_AFTER_TRANSACTION_COMPLETE(41L, "0055", "Disconnected after transaction complete"),                       //
  DISCONNECTED_AFTER_TRANSACTION_COULD_NOT_BE_COMPLETED(42L, "0056",
    "Disconnected after transaction could not be completed"),                                                            //
  DISCONNECTED_AFTER_PAYMENT_SUMMARY(43L, "0057", "Disconnected after payment summary"),                                 //
  DISCONNECTED_AFTER_ADVISOR_TRANSFER(44L, "0058", "Disconnected after advisor transfer"),                               //
  DISCONNECTED_AFTER_ADVISORS_NOT_AVAILABLE(45L, "0059", "Disconnected after advisors not available"),                   //
  DISCONNECTED_AFTER_HOURS_OF_OPERATION(46L, "0060", "Disconnected after hours of operation"),                           //
  DISCONNECTED_AFTER_WEBSITE_INFORMATION(47L, "0061", "Disconnected after website information"),                         //
  DISCONNECTED_AFTER_CALLER_IDENTIFICATION(48L, "0062", "Disconnected after caller identification"),                     //
  ADVISOR_OPT_OUT_AT_OUTBOUND_GREETING(49L, "0063", "Advisor opt out at outbound greeting"),                             //
  ADVISOR_OPT_OUT_AT_OUTBOUND_SECURITY_INFORMATION_AUTHENTICATION(50L, "0064",
    "Advisor opt out at outbound security information authentication"),                                                  //
  ADVISOR_OPT_OUT_AT_INBOUND_REFERENCE_NUMBER_AUTHENTICATION(51L, "0065",
    "Advisor opt out at inbound reference number authentication"),                                                       //
  ADVISOR_OPT_OUT_AT_INBOUND_SECURITY_INFORMATION_AUTHENTICATION(52L, "0066",
    "Advisor opt out at inbound security information authentication"),                                                   //
  ADVISOR_OPT_OUT_AT_AUTOMATED_VS_ADVISOR_CHOICE(53L, "0067", "Advisor opt out at automated vs. advisor choice"),        //
  ADVISOR_OPT_OUT_AT_OFFER_ACCEPTANCE(54L, "0068", "Advisor opt out at offer acceptance"),                               //
  ADVISOR_OPT_OUT_AT_PAYMENT_CHANNEL(55L, "0069", "Advisor opt out at payment channel"),                                 //
  ADVISOR_OPT_OUT_AT_PAYMENT_CHANNEL_TYPE(56L, "0070", "Advisor opt out at payment channel type"),                       //
  ADVISOR_OPT_OUT_AT_CHECKING_SAVINGS_ACCOUNT_OVERVIEW(57L, "0071",
    "Advisor opt out at checking/saving account overview"),                                                             //
  ADVISOR_OPT_OUT_AT_ROUTING_NUMBER_ENTRY(58L, "0072", "Advisor opt out at routing number entry"),                       //
  ADVISOR_OPT_OUT_AT_ROUTING_NUMBER_CONFIRMATION(59L, "0073", "Advisor opt out at routing number confirmation"),         //
  ADVISOR_OPT_OUT_AT_INVALID_ROUTING_NUMBER(60L, "0074", "Advisor opt out at invalid routing number"),                   //
  ADVISOR_OPT_OUT_AT_CHECKING_SAVINGS_ACCOUNT_ENTRY(61L, "0075", "Advisor opt out at checking/saving account entry"),   //
  ADVISOR_OPT_OUT_AT_CHECKING_SAVINGS_CONFIRMATION(62L, "0076", "Advisor opt out at checking/saving confirmation"),     //
  ADVISOR_OPT_OUT_AT_INVALID_CHECKING_SAVINGS(63L, "0077", "Advisor opt out at invalid checking/saving"),               //
  ADVISOR_OPT_OUT_AT_CREDIT_DEBIT_CARD_OVERVIEW(64L, "0078", "Advisor opt out at credit/debit card overview"),           //
  ADVISOR_OPT_OUT_AT_CARD_NUMBER_ENTRY(65L, "0079", "Advisor opt out at card number entry"),                             //
  ADVISOR_OPT_OUT_AT_CARD_NUMBER_CONFIRMATION(66L, "0080", "Advisor opt out at card number confirmation"),               //
  ADVISOR_OPT_OUT_AT_INVALID_CARD_NUMBER(67L, "0081", "Advisor opt out at invalid card number"),                         //
  ADVISOR_OPT_OUT_AT_EXPIRATION_DATE_ENTRY(68L, "0082", "Advisor opt out at expiration date entry"),                     //
  ADVISOR_OPT_OUT_AT_EXPIRATION_DATE_CONFIRMATION(69L, "0083", "Advisor opt out at expiration date confirmation"),       //
  ADVISOR_OPT_OUT_AT_INVALID_EXPIRATION_DATE(70L, "0084", "Advisor opt out at invalid expiration date"),                 //
  ADVISOR_OPT_OUT_AT_NACHA_AUTHORIZATION(71L, "0085", "Advisor opt out at NACHA authorization"),                         //
  ADVISOR_OPT_OUT_AT_TRANSACTION_COULD_NOT_BE_COMPLETED(72L, "0086",
    "Advisor opt out at transaction could not be completed"),                                                            //
  VOICE_MAIL(73L, "0203", "Voice Mail"),                                                                                 //
  OUTBOUND_SPANISH_OPT_OUT(74L, "0609", "Outbound Spanish opt out"),                                                     //
  PAY_BY_CC_AUTO_PAY_CC(75L, "0900", "Pay by CC/Auto Pay CC"),                                                           //
  PAY_BY_CHECK_AUTO_PAY_CC(76L, "0912", "Pay by Check/Auto Pay CC"),                                                     //
  OPERATOR_TRANSFER(77L, "0087", "Operator Transfer"),                                                                   //
  CALL_BACK(78L, "0706", "Call Back"),                                                                                   //
  DO_NOT_CALL_BACK(79L, "0707", "Do Not Call Back"),

  // Added newly by kpalanivelu for standard IVR codes
  SYSTEM_AUTHENTICATED_TRANSFERRED_TO_AGENT(80L, "3020", "System: Authenticated Transferred to Agent"),
  SYSTEM_AUTHENTICATED_TRANSFERRED_TO_AGENT_1(81L, "3054", "System: Authenticated Transferred to Agent"),
  SYSTEM_AUTHENTICATED_TRANSFERRED_TO_AGENT_2(82L, "3055", "System: Authenticated Transferred to Agent"),
  SYSTEM_AUTHENTICATED_TRANSFERRED_TO_AGENT_3(83L, "3056", "System: Authenticated Transferred to Agent"),
  SYSTEM_AUTHENTICATED_HUNG_UP_IN_IVR_AFTER_AUTHENTICATION(84L, "3067",
    "System: Authenticated Hung-up in IVR after Authentication"),
  AGENT_THIRD_PARTY(85L, "3501", "Agent: Third Party"),
  AGENT_RIGHT_PARTY_CONTACT(86L, "3502", "Agent: Right Party Contact"),
  AGENT_WRONG_NUMBER(87L, "3503", "Agent: Wrong Number"), AGENT_NO_ANSWER_BUSY(88L, "5501", "Agent: No Answer/Busy"),
  AGENT_LEFT_MESSAGE_WITH_PERSON(89L, "5502", "Agent: Left Message with Person"),
  AGENT_NO_MESSAGE_LEFT_WITH_PERSON(90L, "5503", "Agent: No Message Left with Person"),
  AGENT_VOICEMAIL_LEFT_MESSAGE(91L, "5504", "Agent: Voicemail - Left Message"),
  AGENT_VOICEMAIL_NO_MESSAGE_LEFT(92L, "5505", "Agent: Voicemail - No Message Left"),
  AGENT_RIGHT_PARTY_CONTACT1(93L, "5506", "Agent: Right Party Contact"),
  AGENT_WRONG_NUMBER1(94L, "5507", "Agent: Wrong Number"),
  AGENT_DISCONNECTED_INVALID_A(95L, "5508", "Agent: Disconnected/Invalid #"),
  AGENT_PRIVACY_MANAGER(96L, "5509", "Agent: Privacy Manager"),
  SYSTEM_VOICEMAIL_LEFT_MESSAGE(97L, "6014", "System: Voicemail - Left Message"),
  SYSTEM_LEFT_MESSAGE_WITH_PERSON(98L, "6015", "System: Left message with Person"),
  SYSTEM_ANSWERED_HUNG_UP_IN_IVR_DURING_GREETING(99L, "6017", "System: Answered & Hung-up in IVR During Greeting"),
  SYSTEM_LEFT_MESSAGE_WITH_PERSON1(100L, "6031", "System: Left message with Person"),
  SYSTEM_AUTHENTICATED_TRANSFERRED_TO_AGENT4(101L, "6057", "System: Authenticated Transferred to Agent"),
  SYSTEM_AUTHENTICATED_TRANSFERRED_TO_AGENT5(102L, "6058", "System: Authenticated Transferred to Agent"),
  SYSTEM_VOICEMAIL_NO_MESSAGE_LEFT(103L, "6061", "System: Voicemail - No Message Left"),
  SYSTEM_LEFT_MESSAGE_WITH_PERSON12(104L, "6063", "System: Left message with Person"),
  SYSTEM_DISCONNECTED_INVALID_A(105L, "9019", "System: Disconnected/Invalid#"),
  SYSTEM_NO_ANSWER_BUSY(106L, "9041", "System: No Answer/Busy"),
  SYSTEM_NO_ANSWER_BUSY_1(107L, "9042", "System: No Answer/Busy"),
  SYSTEM_NO_ANSWER_BUSY_2(108L, "9043", "System: No Answer/Busy"),
  SYSTEM_CALL_NOT_MADE_MOBILE_SCRUB(109L, "9084", "System: Call Not Made Mobile Scrub"),
  SYSTEM_CALL_NOT_MADE_NOT_ATTEMPTED(110L, "9085", "System: Call Not Made - Not Attempted"),
  SYSTEM_CALL_NOT_MADE(111L, "9087", "System: Call Not Made"),
  SYSTEM_CALL_NOT_MADE_1(112L, "9088", "System: Call Not Made"),
  SYSTEM_CALL_NOT_MADE_2(113L, "9089", "System: Call Not Made"),
  SYSTEM_CALL_NOT_MADE_3(114L, "9090", "System: Call Not Made"),
  SYSTEM_CALL_NOT_MADE_4(115L, "9091", "System: Call Not Made"),
  SYSTEM_CALL_NOT_MADE_5(116L, "9092", "System: Call Not Made"),
  SYSTEM_CALL_NOT_MADE_6(117L, "9093", "System: Call Not Made"),
  SYSTEM_CALL_NOT_MADE_7(118L, "9094", "System: Call Not Made"),
  SYSTEM_CALL_NOT_MADE_8(119L, "9095", "System: Call Not Made"),
  SYSTEM_CALL_NOT_MADE_9(120L, "9096", "System: Call Not Made"),
  SYSTEM_CALL_NOT_MADE_10(121L, "9097", "System: Call Not Made"),
  SYSTEM_CALL_NOT_MADE_11(122L, "9098", "System: Call Not Made"),
  SYSTEM_CALL_NOT_MADE_DUPLICATE(123L, "9099", "System: Call Not Made - Duplicate"),
  SYSTEM_LEFT_MESSAGE_WITH_PERSON_2(124L, "6068", "System: Left message with Person"),
  AGENT_OPERATOR_TRANSFER_AGENT_TERMINATED_CALL(125L, "6076", "Agent: Operator Transfer (Agent Terminated Call)");

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Code. */
  private String code;

  /** Code description. */
  private String description;

  /** Code id. */
  private Long id;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum with string value.
   *
   * @param  id           DOCUMENT ME!
   * @param  code         DOCUMENT ME!
   * @param  description  DOCUMENT ME!
   */
  private IvrResultCode(Long id, String code, String description) {
    this.id          = id;
    this.code        = code;
    this.description = description;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toIvrResultCode.
   *
   * @param   id  Long
   *
   * @return  IvrResultCode
   */
  public static IvrResultCode toIvrResultCode(Long id) {
    if (id == null) {
      return null;
    }

    for (IvrResultCode b : IvrResultCode.values()) {
      if (id.compareTo(b.getId()) == 0) {
        return b;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toIvrResultCode.
   *
   * @param   code  String
   *
   * @return  IvrResultCode
   */
  public static IvrResultCode toIvrResultCode(String code) {
    if (code == null) {
      return null;
    }

    for (IvrResultCode b : IvrResultCode.values()) {
      if (b.toString().equalsIgnoreCase(code)) {
        return b;
      }
    }

    return null;
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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return this.id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the string value for the enum.
   *
   * @return  enum string value
   */
  @Override public String toString() {
    return code;
  }
}
