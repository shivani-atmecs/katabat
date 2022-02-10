package com.cmc.credagility.core.constant;

import java.util.HashMap;
import java.util.Map;

import com.cmc.credagility.core.domain.type.AccountStatusCode;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/14/2014 18:14
 */
public class COFSConstants {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  public static Map<AccountStatusCode, String> cofsStatusMap = new HashMap<AccountStatusCode, String>();

  static {
    cofsStatusMap.put(AccountStatusCode.AUTH_PROHIBITED, "A");
    cofsStatusMap.put(AccountStatusCode.BKR_UNKNOWN, "B");
    cofsStatusMap.put(AccountStatusCode.CLOSED, "C");
    cofsStatusMap.put(AccountStatusCode.REVOKED, "E");
    cofsStatusMap.put(AccountStatusCode.FREEZE, "F");
    cofsStatusMap.put(AccountStatusCode.INTEREST_ACCRUAL_PROHIBITED, "I");
    cofsStatusMap.put(AccountStatusCode.LOST, "L");
    cofsStatusMap.put(AccountStatusCode.STOLEN, "U");
    cofsStatusMap.put(AccountStatusCode.CHARGEOFF, "Z");
  }

}
