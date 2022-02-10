package com.cmc.credagility.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.StringUtils;

/**
 * Created by mrouthu on 4/7/2018.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class CoreUtil {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final Log log = LogFactory.getLog(CoreUtil.class);

  private static final String mask = "XXXXXXXXXX";

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   obj  content requestBody content DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String maskSensitiveData(Object obj) {
    String content = null;

    if (StringUtils.hasText(obj.toString())) {
      Map<String, Object> map;

      // Convert json to map
      ObjectMapper mapper = new ObjectMapper();

      try {
        // TypeReference ref = new TypeReference<Map<String, Object>>() { };
        map = mapper.convertValue(obj, Map.class);

        // Process map
        checkCustomerAccountInfo(map);
        checkOriginalAccountNumber(map);
        checkFundingAccountInfo(map);   // used for createFundingAccountREQUEST

        if (map.containsKey("fundingAccounts")) {
          List<Object> fundingAccountsArray = (List<Object>) map.get("fundingAccounts");
          checkArrayOfFundingAccounts(fundingAccountsArray);
        }

        if (map.containsKey("payments")) {
          List<Object> paymentsArray = (List<Object>) map.get("payments");
          checkArrayOfPayments(paymentsArray);
        }

        if (map.containsKey("fundingAccount")) {
          Map<String, Object> fundingAcctMap = (Map<String, Object>) map.get("fundingAccount");
          checkFundingAccountInfo(fundingAcctMap);
        }

        try {
          content = mapper.writeValueAsString(map);
        } catch (IOException e) {
          log.error("cannot create json from Map" + e.getMessage());
        }
      } catch (Exception e) {
        log.error("cannot create Map from object" + e.getMessage());
      } // end try-catch
    } // end if

    return content;
  } // end method maskSensitiveData

  //~ Private Methods ----------------------------------------------------------------------------------------------------------

  private static void checkArrayOfFundingAccounts(List<Object> fundingAccountsArray) {
    if (fundingAccountsArray != null) {
      for (Object item : fundingAccountsArray) {
        Map<String, Object> itemMap = (Map<String, Object>)item;
        checkFundingAccountInfo(itemMap);
      }
    }
  }

  private static void checkArrayOfPayments(List<Object> paymentsArray) {
    if (paymentsArray != null) {
      for (Object item : paymentsArray) {
        Map<String, Object> itemMap = (Map<String, Object>)item;
        checkCustomerAccountInfo(itemMap);

        if (itemMap.containsKey("fundingAccount")) {
          Map<String, Object> fundingAcctMap = (Map<String, Object>) itemMap.get("fundingAccount");
          checkFundingAccountInfo(fundingAcctMap);
        }
      }
    }
  }

  private static void checkFundingAccountInfo(Map<String, Object> map) {
    if (map != null) {
      checkCustomerAccountInfo(map);

      if (map.containsKey("achInfo")) {
        Map<String, Object> achInfoMap = (Map<String, Object>) map.get("achInfo");

        if (achInfoMap != null) {
          if (achInfoMap.containsKey("fundingAccountNumber")) {
            achInfoMap.put("fundingAccountNumber",
                    (achInfoMap.get("fundingAccountNumber") != null ?
                            (mask + getLast4StringObject(achInfoMap.get("fundingAccountNumber"))) : ""));
          }
        }
      }

      if (map.containsKey("cardInfo")) {
        Map<String, Object> cardInfoMap = (Map<String, Object>) map.get("cardInfo");

        log.debug("cardInfo = " + map.get("cardInfo") + ", cardInfo map = " + cardInfoMap);

        if (cardInfoMap != null) {
          if (cardInfoMap.containsKey("cvv")) {
            cardInfoMap.put("cvv", "xxx");
          }
          if (cardInfoMap.containsKey("fundingAccountNumber")) {
            cardInfoMap.put("fundingAccountNumber",
                    (cardInfoMap.get("fundingAccountNumber") != null ?
                            (mask + getLast4StringObject(cardInfoMap.get("fundingAccountNumber"))) : ""));
          }

          log.debug("after masking, cardInfo map = " + cardInfoMap);
        }
      }
    }
  }

  private static void checkCustomerAccountInfo(Map<String, Object> map) {
    if (map != null) {
      if (map.containsKey("customerAccountInfo")) {
        Map<String, Object> custAcctInfoMap = (Map<String, Object>) map.get("customerAccountInfo");
        checkOriginalAccountNumber(custAcctInfoMap);
      }
    }
  }

  private static void checkOriginalAccountNumber(Map<String, Object> map) {
    if (map != null) {
      if (map.containsKey("originalAccountNumber")) {
        map.put("originalAccountNumber",
                (map.get("originalAccountNumber") != null ?
                        (mask + getLast4StringObject(map.get("originalAccountNumber"))) : ""));
      }
    }
  }

  private static String getLast4StringObject(Object obj) {
    String result = "";

    try {
      if (obj != null) {
        String text = obj.toString();
        if (StringUtils.hasText(text)) {
          result = text;

          if (text.length() > 4) {
            result = text.substring(text.length() - 4, text.length());
          }
        }
      }
    } catch (Exception ex) { }

    return result;
  }

} // end class CoreUtil
