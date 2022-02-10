package com.cmc.credagility.util;

import org.jasypt.encryption.ByteEncryptor;
import org.jasypt.encryption.StringEncryptor;


/**
 * Static factory to provide the encryptors.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/15/2014 14:13 PM
 */
public class EncryptorFactory {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static EncryptorFactory _instance;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private ByteEncryptor byteEncryptor;

  private StringEncryptor stringEncryptor;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for byte encryptor.
   *
   * @return  ByteEncryptor
   */
  public static ByteEncryptor getByteEncryptor() {
    return instance().byteEncryptor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for string encryptor.
   *
   * @return  StringEncryptor
   */
  public static StringEncryptor getStringEncryptor() {
    return instance().stringEncryptor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for byte encryptor.
   *
   * @param  byteEncryptor  ByteEncryptor
   */
  public static void setByteEncryptor(ByteEncryptor byteEncryptor) {
    instance().byteEncryptor = byteEncryptor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for string encryptor.
   *
   * @param  stringEncryptor  StringEncryptor
   */
  public static void setStringEncryptor(StringEncryptor stringEncryptor) {
    instance().stringEncryptor = stringEncryptor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private static EncryptorFactory instance() {
    if (_instance == null) {
      _instance = new EncryptorFactory();
    }

    return _instance;
  }
} // end class EncryptorFactory
