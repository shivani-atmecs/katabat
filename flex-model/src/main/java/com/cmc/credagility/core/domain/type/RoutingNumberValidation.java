package com.cmc.credagility.core.domain.type;

/**
 * Default is ABA;
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  01/18/2016 14:41 PM
 */
public enum RoutingNumberValidation {
  //~ Enum constants ---------------------------------------------------------------------------------------------------

  /**
   * An ABA routing transit number (ABA RTN) is a nine digit code, used in the United States, which appears on the
   * bottom of negotiable instruments such as checks to identify the financial institution on which it was drawn. The
   * ABA RTN was originally designed to facilitate the sorting, bundling, and shipment of paper checks back to the
   * drawer's (check writer's) account. As new payment methods were developed (ACH and Wire), the system was expanded to
   * accommodate these payment methods.<br/>
   * <br/>
   * The ABA RTN is necessary for the Federal Reserve Banks to process Fedwire funds transfers, and by the Automated
   * Clearing House to process direct deposits, bill payments, and other such automated transfers.<br/>
   * <br/>
   * The ABA RTN system was developed in 1910 by the American Bankers Association.
   */
  ABA,

  /**
   * BSB (Bank-State-Branch) Number is a six digits numerical codes used to identify an individual branch of a financial
   * institution in Australia. BSB Number is used in Australian Paper Clearing System (APCS) and Bulk Electronic
   * Clearing System (BECS) payment systems. To make money transfer, the BSB Number is used together with the bank
   * account number of the recipient. For international inward money transfer, a SWIFT code must be used together with a
   * BSB Number and Account Number.<br/>
   * <br/>
   * In APCS payment system, BSB and account numbers, are used to identify the account to be debited and are printed on
   * the cheque. Mean while in BECS system, BSB and account numbers, are used when transferring funds via the Direct
   * Entry System.<br/>
   * <br/>
   * The Australian BSB Numbers consists of three parts in the format of<br/>
   *
   * <pre>
   XXY-ZZZ
   </pre>
   *
   * <ul>
   *   <li>The First two digits (XX) specify the parent financial institution.</li>
   *   <li>Third digit (Y) specifies the state where the branch is located.</li>
   *   <li>Fourth, fifth and sixth digits (ZZZ) specify the branch location.</li>
   * </ul>
   */
  BSB;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * convert.
   *
   * @param   strValue  String
   *
   * @return  RoutingNumberValidation
   */
  public static RoutingNumberValidation convert(String strValue) {
    try {
      return valueOf(strValue.toUpperCase());
    } catch (Exception e) {
      return null;
    }
  }
}
