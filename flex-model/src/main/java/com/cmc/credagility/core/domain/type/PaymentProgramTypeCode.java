package com.cmc.credagility.core.domain.type;

/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/16/2014 14:26
 */
public enum PaymentProgramTypeCode {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  // Full payment
  FULL("FULL", 1L),

  // Settlement
  SETTLEMENT("SETTLEMENT", 2L),

  // Min Monthly
  MINMONTHLY("MINMONTHLY", 3L),

  // ReAge
  REAGE("REAGE", 4L),

  // Workout
  WORKOUT("WORKOUT", 5L),

  //
  OVERLIMIT("OverLimit", 6L),               //
  PASTDUE("PastDue", 7L),                   //
  PASTDUEOVERLIMIT("PastDueOverLimit", 8L), //

  // NCC Payment Programs
  NCC1ALL("1ALL", 9L),                                   //
  NCC2CONS("2CONS", 10L),                                //
  NCC3ALL("3ALL", 11L),                                  //
  NCC4ALL("4ALL", 12L),                                  //
  NCC7ALL("7ALL", 13L),                                  //
  NCC9BUS("9BUS", 14L), NCCEXTENSION("EXTENSION", 100L), // Fix for NC-278,279
  NCCREAGE("REAGE", 101L),                               // Fix for NC-278,279

  // DFS Payment Programs
  DFSAPR1299("DFSAPR12.99", 15L),                           //
  DFSAPR139915MINPAY("DFSAPR13.99-1.5MinPay", 16L),         //
  DFSAPR1599("DFSAPR15.99", 17L),                           //
  DFSAPR1599TEMP("DFSAPR15.99Temp", 18L),                   //
  DFSAPR1799("DFSAPR17.99", 19L),                           //
  DFSAPR179915MINPAY("DFSAPR17.99-1.5MinPay", 20L),         //
  DFSAPR1999("DFSAPR19.99", 21L),                           //
  DFSAPR2199("DFSAPR21.99", 22L),                           //
  DFSAPR59960MINPAY("DFSAPR5.99-6.0MinPay", 23L),           //
  DFSAPR599SUSPEND("DFSAPR5.99Suspend", 24L),               //
  DFSAPR599TEMP("DFSAPR5.99Temp", 25L),                     //
  DFSAPR599("DFSAPR5.99", 26L),                             //
  DFSAPR799SUSPEND("DFSAPR7.99Suspend", 27L),               //
  DFSAPR799("DFSAPR7.99", 28L),                             //
  DFSAPR999("DFSAPR9.99", 29L),                             //
  DFSAPR99915MINPAY("DFSAPR9.99-1.5MinPay", 30L),           //
  DFSAPR99920MINPAY("DFSAPR9.99-2.0MinPay", 31L),           //
  DFSAPR999SUSPEND("DFSAPR9.99Suspend", 32L),               //
  DFSAPR999TEMP("DFSAPR9.99Temp", 33L),                     //
  DFSAPR09918MINPAY60MON("DFSAPR0.99-1.8MinPay60Mon", 34L), //
  DFSAPR09915MINPAY60MON("DFSAPR0.99-1.5MinPay60Mon", 35L); //

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** String value. */
  private String code;

  private Long id;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Define enum with string value.
   *
   * @param  strValue  code
   * @param  id        Long
   */
  private PaymentProgramTypeCode(String strValue, Long id) {
    this.code = strValue;
    this.id   = id;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * toPaymentProgramTypeCode.
   *
   * @param   id  Long
   *
   * @return  PaymentProgramTypeCode
   */
  public static PaymentProgramTypeCode toPaymentProgramTypeCode(Long id) {
    if (id == null) {
      return null;
    }

    for (PaymentProgramTypeCode b : PaymentProgramTypeCode.values()) {
      if (id.compareTo(b.getId()) == 0) {
        return b;
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toPaymentProgramTypeCode.
   *
   * @param   code  String
   *
   * @return  PaymentProgramTypeCode
   */
  public static PaymentProgramTypeCode toPaymentProgramTypeCode(String code) {
    if (code == null) {
      return null;
    }

    for (PaymentProgramTypeCode b : PaymentProgramTypeCode.values()) {
      if (b.toString().equalsIgnoreCase(code)) {
        return b;
      }
    }

    return null;
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
