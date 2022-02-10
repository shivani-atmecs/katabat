package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:30
 */
public enum SmsResultCode {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  CALL_PASS_REJECTED(1L, "CALL_PASS_REJECTED", "Call Rejected"),                                       //
  BUSY(2L, "BUSY", "Busy"),                                                                            //
  TEXT_MSG_FTEU_NOT_SUPPORTED(3L, "TEXT_MSG_FTEU_NOT_SUPPORTED", "SMS Not Supported"),                 //
  TEXT_MSG_SENT(4L, "TEXT_MSG_SENT", "Text Message Sent"),                                             //
  TEXT_MSG_DEVICE_UNREACHABLE(5L, "TEXT_MSG_DEVICE_UNREACHABLE", "Text Message device not reachable"), //
  TEXT_MSG_CARRIER_BLOCKED(6L, "TEXT_MSG_CARRIER_BLOCKED", "Text Message carrier blocked");

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
   * @param  id           $param.type$
   * @param  code         $param.type$
   * @param  description  $param.type$
   */
  private SmsResultCode(Long id, String code, String description) {
    this.id          = id;
    this.code        = code;
    this.description = description;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toSmsResultCode.
   *
   * @param   id  Long
   *
   * @return  SmsResultCode
   */
  public static SmsResultCode toSmsResultCode(Long id) {
    if (id == null) {
      return null;
    }

    for (SmsResultCode b : SmsResultCode.values()) {
      if (id.compareTo(b.getId()) == 0) {
        return b;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toSmsResultCode.
   *
   * @param   code  String
   *
   * @return  SmsResultCode
   */
  public static SmsResultCode toSmsResultCode(String code) {
    if (code == null) {
      return null;
    }

    for (SmsResultCode b : SmsResultCode.values()) {
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
