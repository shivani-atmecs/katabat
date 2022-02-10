package com.cmc.credagility.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/23/2014 16:55
 */
public class IPUtil {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static Logger log = LoggerFactory.getLogger(IPUtil.class);

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Called to determine if a given remote IP address is valid against the list of addresses.
   *
   * @param   remoteAddr   The IP address to be tested.
   * @param   addressList  The IP address list to be matched against.
   *
   * @return  True if the address is in the list, false if not.
   */
  public static boolean addressInList(String remoteAddr, String[] addressList) {
    return addressInList(remoteAddr, Arrays.asList(addressList));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Called to determine if a given remote IP address is valid against the list of addresses.
   *
   * @param   remoteAddr   The IP address to be tested.
   * @param   addressList  The IP address list to be matched against.
   *
   * @return  True if the address is in the list, false if not.
   */
  public static boolean addressInList(String remoteAddr, List<String> addressList) {
    // Scan the list of addresses configured and see if the remoteAddr
    // matches any.
    boolean ret = false;

    for (Iterator<String> it = addressList.iterator(); it.hasNext();) {
      String nextAddr = it.next();

      // Match test 1: exact address match.
      if ((nextAddr.indexOf("*") == -1) & (nextAddr.indexOf("-") == -1)) {
        log.info("Match test 1: Exact match");

        if (remoteAddr.equalsIgnoreCase(nextAddr)) {
          ret = true;
        }
      }

      // Match test 2: A single address with wildcards.
      if (nextAddr.indexOf("*") != -1) {
        log.info("Match test 2: Single address match with wildcards");

        // Get all four octets from both the next address in the list and
        // the remote address so we can examine them individually.
        StringTokenizer nt               = new StringTokenizer(nextAddr, ".:");
        StringTokenizer rt               = new StringTokenizer(remoteAddr, ".:");
        String          nextAddrOctet1   = (String) nt.nextToken();
        String          nextAddrOctet2   = (String) nt.nextToken();
        String          nextAddrOctet3   = (String) nt.nextToken();
        String          nextAddrOctet4   = (String) nt.nextToken();
        String          remoteAddrOctet1 = (String) rt.nextToken();
        String          remoteAddrOctet2 = (String) rt.nextToken();
        String          remoteAddrOctet3 = (String) rt.nextToken();
        String          remoteAddrOctet4 = (String) rt.nextToken();

        // Now, for each octet, see if we have either an exact match or a
        // wildcard match, and if so set the appropriate octet flag.
        boolean octet1Ok = false;
        boolean octet2Ok = false;
        boolean octet3Ok = false;
        boolean octet4Ok = false;

        if (remoteAddrOctet1.equalsIgnoreCase(nextAddrOctet1)
              || nextAddrOctet1.equalsIgnoreCase("*")) {
          octet1Ok = true;
        }

        if (remoteAddrOctet2.equalsIgnoreCase(nextAddrOctet2)
              || nextAddrOctet2.equalsIgnoreCase("*")) {
          octet2Ok = true;
        }

        if (remoteAddrOctet3.equalsIgnoreCase(nextAddrOctet3)
              || nextAddrOctet3.equalsIgnoreCase("*")) {
          octet3Ok = true;
        }

        if (remoteAddrOctet4.equalsIgnoreCase(nextAddrOctet4)
              || nextAddrOctet4.equalsIgnoreCase("*")) {
          octet4Ok = true;
        }

        // Finally, if all four flags are true, the address is OK.
        if (octet1Ok & octet2Ok & octet3Ok & octet4Ok) {
          ret = true;
        }
      } // end if

      // Match test 4: IP range.
      if (nextAddr.indexOf("-") != -1) {
        log.info("Match test 4: Match IP range");

        StringTokenizer st             = new StringTokenizer(nextAddr, "-");
        String          rangeStart     = st.nextToken();
        String          rangeEnd       = st.nextToken();
        long            rangeStartLong = ipToLong(rangeStart);
        long            rangeEndLong   = ipToLong(rangeEnd);
        long            remoteAddrLong = ipToLong(remoteAddr);

        if ((remoteAddrLong >= rangeStartLong) && (remoteAddrLong <= rangeEndLong)) {
          ret = true;
        }
      }

    } // End iterator loop.

    return ret;

  } // End addressInList().

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Method that converts an IP address to a long.
   *
   * @param   ip  The IP address to convert.
   *
   * @return  The IP address as a long.
   */
  public static long ipToLong(String ip) {
    StringTokenizer st  = new StringTokenizer(ip, ".:");
    int             o1  = Integer.parseInt((String) st.nextToken());
    int             o2  = Integer.parseInt((String) st.nextToken());
    int             o3  = Integer.parseInt((String) st.nextToken());
    int             o4  = Integer.parseInt((String) st.nextToken());
    String          o1S = Integer.toBinaryString(o1).trim();
    String          o2S = Integer.toBinaryString(o2).trim();
    String          o3S = Integer.toBinaryString(o3).trim();
    String          o4S = Integer.toBinaryString(o4).trim();
    o1S = padBinByteStr(o1S);
    o2S = padBinByteStr(o2S);
    o3S = padBinByteStr(o3S);
    o4S = padBinByteStr(o4S);

    String bin = o1S + o2S + o3S + o4S;
    long   res = 0;
    long   j   = 2147483648L;

    for (int i = 0; i < 32; i++) {
      char c = bin.charAt(i);

      if (c == '1') {
        res = res + j;
      }

      j = j / 2;
    }

    return res;

  } // End ipToLong().

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Method that pads (prefixes) a string representation of a byte with 0's.
   *
   * @param   binByte  String of the byte (maybe less than 8 bits) to pad.
   *
   * @return  String of the byte guaranteed to have 8 bits.
   */
  private static String padBinByteStr(String binByte) {
    if (binByte.length() == 8) {
      return binByte;
    }

    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < (8 - binByte.length()); i++) {
      sb.append("0");
    }

    sb.append(binByte);

    return sb.toString();

  } // End padBinByteStr().

} // end class IPUtil
