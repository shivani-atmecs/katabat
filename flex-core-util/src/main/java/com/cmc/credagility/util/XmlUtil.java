package com.cmc.credagility.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * This is Util class to support any XML related work.
 *
 * @author   sdharmaraj
 * @version  1.0, 3/23/12
 */
public class XmlUtil {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final String PCI_DATA_MASK = "***PCI DSS***";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  protected final transient Log log = LogFactory.getLog(getClass());

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  args  DOCUMENT ME!
   */
  public static void main(String[] args) {
    String message =
      "<?xml version='1.0' encoding='utf-8'?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Body><urn:runTransaction xmlns:urn=\"urn:usaepay\"><Token><PinHash><Type>MD5</Type><HashValue>9dc695ae0f4dbb04e8b946fc4b9b27ba</HashValue><Seed>Sat Jan 05 11:49:57 EST 2013</Seed></PinHash><SourceKey>_48q3Ld7nxpf7XqgAxSsT4FM0QTOlvDI</SourceKey></Token><Parameters><AccountHolder>Selva Dharmaraj</AccountHolder><CustomerID>23000001</CustomerID><BillingAddress><FirstName>Selva</FirstName><LastName>Dharmaraj</LastName><Street>300 Water Street</Street><Street2>Suite 100</Street2><City>Willmington</City><Country>USA</Country><State>DE</State><Zip>19801</Zip></BillingAddress><CreditCardData><AvsStreet>300 Water Street</AvsStreet><AvsZip>19801</AvsZip><CardExpiration>0915</CardExpiration><CardNumber>4000100011112224</CardNumber><CardType>Visa</CardType></CreditCardData><Details><Amount>250.23</Amount><Invoice>1789153423099223859</Invoice></Details></Parameters></urn:runTransaction></soapenv:Body></soapenv:Envelope>";
    maskSensitiveData(message, new String[] { "HashValue", "Seed", "SourceKey", "CardNumber", "ns2:CardNum" });


  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This method mask the sensitive data.
   *
   * @param   message       - Message with contains sensitive data
   * @param   maskElements  - Elements names in a array which you would like to mask.
   *
   * @return  return the String with out sensitive data for the elements passed in.
   */
  public static String maskSensitiveData(String message, String[] maskElements) {
    if (StringUtils.isEmpty(message)) {
      return message;
    }

    if ((maskElements != null) && (maskElements.length > 0)) {
      StringBuffer sb = new StringBuffer();

      // (?:<tok:TokenCardNumber[^>]*>).*?>|(?:<ext:CardCVVNumber[^>]*>).*?>
      // Pass any element you would like to be masked.
      for (String mask : maskElements) {
        if (sb.length() == 0) {
          sb.append("(?:<");
        } else {
          sb.append("|(?:<");
        }

        System.out.println("mask : " + mask);
        sb.append(mask);
        sb.append("[^>]*>).*?>");
      }

      Matcher matcher = Pattern.compile(sb.toString()).matcher(message);

      while (matcher.find()) {
        String match = matcher.group();
        System.out.println("match :" + match);
        message = message.replaceAll(match, match.replaceAll("(?<=>)(.*\\n?)(?=<)", PCI_DATA_MASK));
      }


      return message;
    } // end if


    return message;
  } // end method maskSensitiveData
} // end class XmlUtil
