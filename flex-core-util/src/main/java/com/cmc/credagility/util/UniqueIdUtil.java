package com.cmc.credagility.util;

import java.sql.Timestamp;

import java.util.Random;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  01/16/2015 18:42 PM
 */
public class UniqueIdUtil {
  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new UniqueIdUtil object.
   */
  public UniqueIdUtil() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for sync mq call trans view key.
   *
   * @param   httpSessionId  String
   * @param   nanoTime       String
   *
   * @return  String
   */
  public static synchronized String getSyncMqCallTransViewKey(String httpSessionId, String nanoTime) {
    StringBuffer sb = new StringBuffer();
    sb.append(httpSessionId);
    sb.append(nanoTime);

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unique alpha num10.
   *
   * @return  String
   */
  public static synchronized String getUniqueAlphaNum10() {
    long          decimalNumber = System.nanoTime();
    String        strBaseDigits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuilder strTempVal    = new StringBuilder("");
    boolean       mod           = false;

    for (int authCodeLength = 0; (decimalNumber != 0L) && (authCodeLength < 10); ++authCodeLength) {
      int var6 = (int) (decimalNumber % 36L);
      strTempVal.append(strBaseDigits.substring(var6, var6 + 1));
      decimalNumber /= 36L;
    }

    return strTempVal.reverse().toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unique id for BBLPayment ref num.
   *
   * @return  String
   */
  public static synchronized String getUniqueIdForBBLPaymentRefNum() {
    long      tenDigitNum = (long) Math.floor(Math.random() * 9.0E9D) + 1000000000L;
    Timestamp startTime   = new Timestamp(System.currentTimeMillis());
    String    stamp       = "" + startTime.getTime();

    if (stamp.endsWith("000")) {
      stamp = stamp.substring(0, stamp.length() - 3);
    }

    StringBuffer sb = new StringBuffer();
    sb.append("CW").append(tenDigitNum).append("-").append(stamp);

    return sb.toString();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for unique session id.
   *
   * @return  String
   */
  public static synchronized String getUniqueSessionId() {
    String sessionId = String.valueOf(System.nanoTime());
    Random generator = new Random();
    int    i         = generator.nextInt(5121);
    sessionId = sessionId + i;

    return sessionId;
  }
} // end class UniqueIdUtil
