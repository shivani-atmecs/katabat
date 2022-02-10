package com.cmc.credagility.core.domain.util;

import java.io.UnsupportedEncodingException;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 17:09
 */
public class CipherUtil {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * decrypt3DES.
   *
   * @param   message  byte[]
   * @param   key      String
   *
   * @return  String
   *
   * @throws  Exception  exception
   */
  public static String decrypt3DES(byte[] message, String key) throws Exception {
    // Converting key in Hex String to byte Array
    // byte[] rawKey = new BigInteger(key, 16).toByteArray();
    // Creating SecretKey from rawKey using Triple DES
    final SecretKey secretKey = new SecretKeySpec(key.getBytes(), "DESede");

    final IvParameterSpec iv = new IvParameterSpec(new byte[8]);

    final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");

    decipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

    final byte[] plainText = decipher.doFinal(message);

    return new String(plainText, "ASCII");

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * encrypt3DES.
   *
   * @param   message  String
   * @param   key      String
   *
   * @return  byte[]
   *
   * @throws  UnsupportedEncodingException        exception
   * @throws  IllegalStateException               exception
   * @throws  IllegalBlockSizeException           exception
   * @throws  BadPaddingException                 exception
   * @throws  InvalidKeyException                 exception
   * @throws  InvalidAlgorithmParameterException  exception
   * @throws  NoSuchAlgorithmException            exception
   * @throws  NoSuchPaddingException              exception
   * @throws  InvalidKeySpecException             exception
   */
  public static byte[] encrypt3DES(String message, String key) throws UnsupportedEncodingException,
    IllegalStateException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException,
    InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException {
    // Converting key in Hex String to byte Array
    // byte[] rawKey = new BigInteger(key).toByteArray();
    // Creating SecretKey from rawKey using Triple DES
    final SecretKey secretKey = new SecretKeySpec(key.getBytes(), "DESede");

    final IvParameterSpec iv = new IvParameterSpec(new byte[8]);

    final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");

    cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

    final byte[] plainTextBytes = message.getBytes("ASCII");

    final byte[] cipherText = cipher.doFinal(plainTextBytes);

    return cipherText;

  }

} // end class CipherUtil
