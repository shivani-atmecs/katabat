package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:13
 */
public enum AccountStatusCode {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  // ScoreNet Introduced
  // Primary placement: ADS ScoreNet: 90 Days after write-off, balance > 100
  PRIMARY_PLACEMENT("100", 6L),

  // Secondary placement: ADS ScoreNet: 30 Days after recalled from primary,
  // balance > 100
  SECONDARY_PLACEMENT("200", 7L),

  // Tertiary placement: ADS ScoreNet: 30 Days after recalled from secondary
  TERTIARY_PLACEMENT("300", 8L),

  // Law suite: Legal Account
  LAW_SUIT_FILED("LGL", 9L),

  // Bankrupt. Required.
  B07("B07", 10L),

  //
  B13("B13", 11L),

  //
  BKR_UNKNOWN("BKR", 12L),

  // Deceased. Required
  DECEASED("DEC", 13L),

  // Settled in full, required if this happens
  SETTLED_IN_FULL("SIF", 14L),

  // Paid in full, required if this happens
  PAID_IN_FULL("PIF", 15L),

  // CeaseAndDessist. Required.
  CEASE_AND_DESIST("CAD", 16L),

  // Dispute
  DISPUTE("DSP", 17L),

  // Fraud
  FRAUD("FRD", 18L),

  // Credit Counseling
  CREDIT_COUNSELING("CCS", 19L),

  // Uncollectible
  UNCOLLECTIBLE("UNC", 20L),

  // Lost
  LOST("LST", 21L),

  // Stolen
  STOLEN("STL", 22L),

  // Chargeoff
  CHARGEOFF("CHA", 23L),

  // Closed
  CLOSED("CLO", 24L),

  // Freeze
  FREEZE("FRE", 25L),

  // Revoked
  REVOKED("REV", 26L),

  // AUth Prohibited
  AUTH_PROHIBITED("PAU", 27L),

  // Interest freezed
  INTEREST_ACCRUAL_PROHIBITED("IAP", 28L),

  /** Added for Home Equity - National City ASAP Project. */

  REFERRED_CUSTOMER_TO_NCC_LOSS_MITIGATION("H01", 31L),

  REFERRED_CUSTOMER_TO_PLC("H02", 32L),

  FULL_PRINCIPAL_LOAN_MOD_PROGRAM_APPROVED_REQUIRE_DOCUMENTATION("H03", 33L),

  REDUCED_PRINCIPAL_LOAN_MOD_PROGRAM_APPROVED_REQUIRE_DOCUMENTATION("H04", 34L),

  SCHEDULED_FEDERAL_EXPRESS_PICK_UP("H05", 35L),

  SENT_CUSTOMER_AN_EMAIL("H06", 36L),

  REQUEST_TO_SEND_FINANCIAL_INFORMATION_WORKSHEET_LETTER("H07", 37L),

  CUSTOMER_REFUSED_ALL_PROGRAM_OFFERS("H09", 39L),

  RECEIVED_ALL_SUPPORTING_DOCUMENTATION("H10", 40L),

  RECEIVED_PARTIAL_SUPPORTING_DOCUMENTATION("H11", 41L),

  COMPLETED_FINANCIAL_PACKAGE_SENT_TO_NCC_LOSS_MITIGATION("H12", 42L),

  NO_ANSWER("H13", 43L),

  LEFT_MESSAGE("H14", 44L),

  NO_MESSAGE_LEFT("H15", 45L),

  WRONG_NUMBER("H16", 46L),

  CUSTOMER_REQUEST_DO_NOT_CONTACT("H17", 47L),

  LOAN_MODIFICATION_PROGRAM_DECLINED("H18", 48L),

  FULL_PRINCIPAL_LOAN_MODIFICATION_PROGRAM_APPROVED("H19", 49L),

  REDUCED_PRINCIPAL_LOAN_MODIFICATION_PROGRAM_APPROVED("H20", 50L),

  REFI_PROGRAM_APPROVED_WITH_BALANCE_REDUCTION("H21", 51L),

  REFI_PROGRAM_APPROVED_WITHOUT_BALANCE_REDUCTION("H22", 52L),

  OTHER_DETAIL_WRITTEN_IN_NOTES("H23", 53L),

  CUSTOMER_NOT_ELIGIBLE_FOR_PROGRAMS("H24", 54L),

  INELIGIBLE_ADDRESS_IS_NOT_PRIMARY_RESIDENCE("H25", 55L),

  PLM("H26", 56L),

  PRF("H27", 57L),

  REFI_PROGRAM_DECLINED_REFERRED_TO_AGENCY("H28", 58L),

  REFI_PROGRAM_DECLINED_NO_FURTHER_ACTION("H29", 59L),

  // Citi Mortgage Codes
  C01("C01", 60L), C02("C02", 61L), C03("C03", 62L), C04("C04", 63L), C05("C05", 64L), C06("C06", 65L), C07("C07", 66L),
  C08("C08", 67L), C09("C09", 68L), C10("C10", 69L), C11("C11", 70L), C12("C12", 71L), C13("C13", 72L), C14("C14", 73L),
  C15("C15", 74L), C16("C16", 75L), C17("C17", 76L), C18("C18", 77L), C19("C19", 78L), C20("C20", 79L), C21("C21", 80L),
  C22("C22", 81L), C23("C23", 82L), C24("C24", 83L), C25("C25", 84L), C26("C26", 85L), C27("C27", 86L), C40("C40", 87L),
  C41("C41", 88L), C28("C28", 90L), C29("C29", 91L), C30("C30", 92L), C31("C31", 93L), C32("C32", 94L), C33("C33", 95L),
  C34("C34", 96L), C35("C35", 97L), C36("C36", 98L), C37("C37", 99L), C38("C38", 100L), C39("C39", 101L),
  C43("C43", 102L),

  // 800 to 900 is for Internal Application Tracking for HE
  DEBTOR_INTERESTED_IN_OFFER("800", 89L);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Long statusId;

  /** String value. */
  private String strValue;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum with string value.
   *
   * @param  strValue  $param.type$
   * @param  statusId  Long
   */
  private AccountStatusCode(String strValue, Long statusId) {
    this.strValue = strValue;
    this.statusId = statusId;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toAccountStatusCode.
   *
   * @param   statusId  Long
   *
   * @return  AccountStatusCode
   */
  public static AccountStatusCode toAccountStatusCode(Long statusId) {
    if (statusId == null) {
      return null;
    }

    for (AccountStatusCode b : AccountStatusCode.values()) {
      if (statusId.compareTo(b.getStatusId()) == 0) {
        return b;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toAccountStatusCode.
   *
   * @param   strValue  String
   *
   * @return  AccountStatusCode
   */
  public static AccountStatusCode toAccountStatusCode(String strValue) {
    if (strValue == null) {
      return null;
    }

    for (AccountStatusCode b : AccountStatusCode.values()) {
      if (b.toString().equalsIgnoreCase(strValue)) {
        return b;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status id.
   *
   * @return  Long
   */
  public Long getStatusId() {
    return this.statusId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Get the string value for the enum.
   *
   * @return  enum string value
   */
  @Override public String toString() {
    return strValue;
  }

}
