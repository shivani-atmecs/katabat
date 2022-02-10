package com.cmc.credagility.util;

import java.io.UnsupportedEncodingException;

import java.security.MessageDigest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.util.StringUtils;


/**
 * String Utility Class This is used to encode passwords programmatically.
 *
 * @author   <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * @version  10/23/2014 17:09
 */
public class StringUtil {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final Logger log = LoggerFactory.getLogger(StringUtil.class);

  /** TODO: DOCUMENT ME! */
  public static final String CONTROL_CHARACTERS = "[\u0000-\u001f]";

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Decode a string using Base64 encoding.
   *
   * @param   str  String
   *
   * @return  decode a string using Base64 encoding.
   */
  public static String decodeString(String str) {
    // sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
    // try {
    // return new String(dec.decodeBuffer(str));
    // } catch (IOException io) {
    // throw new RuntimeException(io.getMessage(), io.getCause());
    // }
    return new String(Base64.decodeBase64(str.getBytes()));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Encode a string using algorithm specified in web.xml and return the resulting encrypted password. If exception, the
   * plain credentials string is returned
   *
   * @param   password   String
   * @param   algorithm  String
   *
   * @return  encypted password based on the algorithm.
   */
  public static String encodePassword(String password, String algorithm) {
    byte[] unencodedPassword = password.getBytes();

    MessageDigest md = null;

    try {
      // first create an instance, given the provider
      md = MessageDigest.getInstance(algorithm);
    } catch (Exception e) {
      log.error("Exception: " + e, e);

      return password;
    }

    md.reset();

    // call the update method one or more times
    // (useful when you don't know the size of your data, eg. stream)
    md.update(unencodedPassword);

    // now calculate the hash
    byte[] encodedPassword = md.digest();

    StringBuffer buf = new StringBuffer();

    for (int i = 0; i < encodedPassword.length; i++) {
      if ((encodedPassword[i] & 0xff) < 0x10) {
        buf.append("0");
      }

      buf.append(Long.toString(encodedPassword[i] & 0xff, 16));
    }

    return buf.toString();
  } // end method encodePassword

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Encode a string using Base64 encoding. Used when storing passwords as cookies. This is weak encoding in that anyone
   * can use the decodeString routine to reverse the encoding.
   *
   * @param   str  String
   *
   * @return  String
   */
  public static String encodeString(String str) {
    // sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    // return encoder.encodeBuffer(str.getBytes()).trim();
    return new String(Base64.encodeBase64(str.getBytes())).trim();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   s  DOCUMENT ME!
   * @param   n  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getFirstNChars(String s, int n) {
    if ((s != null) && (s.length() > n)) {
      return s.substring(0, n);
    } else {
      return s;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   s  DOCUMENT ME!
   * @param   n  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */

  public static String getLastNChars(String s, int n) {
    if ((s != null) && (s.length() > n)) {
      return s.substring(s.length() - n);
    } else {
      return s;
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check if a String element is in a String Array.
   *
   * @param   element  String
   * @param   array    String[]
   *
   * @return  check if a String element is in a String Array.
   */
  public static boolean isInArray(String element, String[] array) {
    if (element == null) {
      for (String a : array) {
        if (a == null) {
          return true;
        }
      }
    } else {
      for (String a : array) {
        if (element.equals(a)) {
          return true;
        }
      }
    }

    return false;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   key  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String last4DigitsOfString(String key) {
    if (key == null) {
      return "";
    }

    if (key.length() > 4) {
      return key.substring(key.length() - 4);
    }

    return key;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * mask.
   *
   * @param   input            String
   * @param   totalLength      int
   * @param   clearTextLength  int
   * @param   maskChar         String
   *
   * @return  String
   */
  public static String mask(String input, int totalLength, int clearTextLength, String maskChar) {
    if (StringUtils.hasText(input)) {
      // String padding to clearLength
      if (input.length() < clearTextLength) {
        int           appendLength = clearTextLength - input.length();
        StringBuilder prefix       = new StringBuilder();

        for (int i = 0; i < appendLength; i++) {
          prefix.append(maskChar);
        }

        input = prefix.append(input).toString();
      } else {
        input = input.substring(input.length() - clearTextLength, input.length());
      }

      // Pad the prefix
      StringBuilder paddingPrefix = new StringBuilder();

      for (int i = 0; i < (totalLength - input.length()); i++) {
        paddingPrefix.append(maskChar);
      }

      return paddingPrefix.append(input).toString();
    } else {
      StringBuilder paddingPrefix = new StringBuilder();

      for (int i = 0; i < totalLength; i++) {
        paddingPrefix.append(maskChar);
      }

      return paddingPrefix.toString();
    } // end if-else
  }   // end method mask

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * stringReplace.
   *
   * @param   inputStr        String
   * @param   patternStr      String
   * @param   replacementStr  String
   *
   * @return  String
   */
  public static String stringReplace(String inputStr, String patternStr,
    String replacementStr) {
    // Compile regular expression
    Pattern pattern = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);

    // Replace all occurrences of pattern in input
    Matcher matcher   = pattern.matcher(inputStr);
    String  outputStr = matcher.replaceAll(Matcher.quoteReplacement(replacementStr));

    return outputStr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * stripInvalidChar.
   *
   * @param   in  String
   *
   * @return  String
   */
  public static String stripInvalidChar(String in) {
    byte[] utf = new byte[] {};

    try {
      utf = in.getBytes("UTF-8");

      int len = utf.length;

      for (int i = 0; i < len; i++) {
        int ii = utf[i];

        if (ii < 0) {
          utf[i] = 32;
        }
      }
    } catch (UnsupportedEncodingException c) {
      return "";
    }

    return new String(utf);
  }

} // end class StringUtil
