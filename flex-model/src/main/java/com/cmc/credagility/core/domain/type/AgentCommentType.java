package com.cmc.credagility.core.domain.type;

// Wrong Party (Wrong Phone Number)
// Busy
// Bad Phone Number (Disconnected Number)
// Fax Machine
// Hung up
// Right Party Not In
// Left Message (Answer Machine)
// Left Message (Spouse)
// Left Message (Other)
// No Answer
// Processed Payment on the Spot
// Scheduled Future Payment(s)
// Promise to Pay (No Payment Scheduled)
// Refusal to Pay
// Pending Bankrupcy (Chapter 7)
// Pending Bankrupcy (Chapter 13)
// Pending Bankrupcy (Unknown Type)
// Bankrupt (Chapter 7)
// Bankrupt (Chapter 13)
// Bankrupt (Unknown Type)
// Deceased
// Do Not Speak English
// Cease & Desist
// Dispute
// Fraud
// Already Settled in Full (SIF)
// Already Paid in Full (PIF)
// Credit Counseling
// Law Suit
// Speak Spanish
// Other

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:13
 */
public enum AgentCommentType {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  // Wrong Party (Wrong Phone Number)
  WRONG_PHONE(1L),

  // Busy
  BUSY(2L),

  // Bad Phone Number (Disconnected Number)
  BAD_PHONE(3L),

  // Fax Machine
  FAX_MACHINE(4L),

  // Hung up
  HUNG_UP(5L),

  // Right Party Not In
  RIGHT_PARTY_NOT_IN(6L),

  // Left Message (Answer Machine)
  LEFT_MESSAGE_ON_MACHINE(7L),

  // Left Message (Spouse)
  LEFT_MESSAGE_TO_SPOUSE(8L),

  // Left Message (Other)
  LEFT_MESSAGE_OTHER(9L),

  // No Answer
  NO_ANSWER(10L),

  // Scheduled Payment(s) (At Least One Payment Is on Today
  PAID_ON_SPOT(11L),

  // Scheduled Future Payment(s) Only
  SCHEDULED_PAYMENT(12L),

  // Promise to Pay (No Payment Scheduled)
  PTP(13L),

  // Refusal to Pay
  REFUSE_TO_PAY(14L),

  // Pending Bankrupcy (Chapter 7)
  BK07_PENDING(15L),

  // Pending Bankrupcy (Chapter 13)
  BK13_PENDING(16L),

  // Pending Bankrupcy (Unknown Type)
  BKUNKNOWN_PENDING(17L),

  // Bankrupt (Chapter 7)
  BK07(18L),

  // Bankrupt (Chapter 13)
  BK13(19L),

  // Bankrupt (Unknown Type)
  BKUNKNOWN(20L),

  // Deceased
  DECEASED(21L),

  // Do Not Speak English
  NO_ENGLISH(22L),

  // Cease & Desist
  CEASE_DESIST(23L),

  // Dispute
  DISPUTE(24L),

  // Fraud
  FRAUD(25L),

  // Already Settled in Full (SIF)
  SIF(26L),

  // Already Paid in Full (PIF)
  PIF(27L),

  // Credit Counseling
  CREDIT_COUNSELING(28L),

  // Law Suit Filed
  LAW_SUIT_FILED(29L),

  //
  SPANISH(30L),

  // Other
  OTHER(31L),

  // Referred customer to NCC Loss Mitigation
  H41(41L),

  // Referred customer to PLC
  H42(42L),

  // Full principal loan mod program approved - require documentation
  H43(43L),

  // Reduced principal loan mod program approved - require documentation
  H44(44L),

  // Scheduled Federal Express pick-up
  H45(45L),

  // Sent customer an email
  H46(46L),

  // Request to send Financial Information Worksheet letter
  H47(47L),

  // Request to send Settlement Forgiveness Form letter
  H48(48L),

  // Customer refused all program offers
  H49(49L),

  // Received all supporting documentation
  H50(50L),

  // Received partial supporting documentation
  H51(51L),

  // Completed financial package sent to NCC Loss Mitigation
  H52(52L),

  // No answer
  H53(53L),

  // Left message
  H54(54L),

  // No message left
  H55(55L),

  // Wrong number
  H56(56L),

  // Customer request - Do Not Contact
  H57(57L),

  // Loan modification program declined
  H58(58L),

  // Full principal loan modification program approved
  H59(59L),

  // Reduced principal loan modification program approved
  H60(60L),

  // Refi program approved
  H61(61L),

  // Refi program declined
  H62(62L),

  // Other - detail written in notes
  H63(63L);

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Long resultId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum with string value.
   *
   * @param  resultId  Long
   */
  private AgentCommentType(Long resultId) {
    this.resultId = resultId;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toAgentCommentType.
   *
   * @param   resultId  Long
   *
   * @return  AgentCommentType
   */
  public static AgentCommentType toAgentCommentType(Long resultId) {
    for (AgentCommentType a : AgentCommentType.values()) {
      if (a.getResultId().compareTo(resultId) == 0) {
        return a;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for result id.
   *
   * @return  Long
   */
  public Long getResultId() {
    return resultId;
  }

}
