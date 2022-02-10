package com.ozstrategy.credagility.core.converter;

import com.cmc.credagility.util.EncryptorFactory;

import javax.persistence.AttributeConverter;


/**
 * JPA Converter for String Encryptor.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/15/2014 11:01 AM
 */
public class ByteEncryptedConverter implements AttributeConverter<byte[], byte[]> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Encrypt value when saving into database.
   *
   * @param   attribute  String
   *
   * @return  encrypt value when saving into database.
   */
  @Override public byte[] convertToDatabaseColumn(byte[] attribute) {
    if (attribute == null) {
      return null;
    }

    if (EncryptorFactory.getByteEncryptor() == null) {
      return attribute;
    }

    return EncryptorFactory.getByteEncryptor().encrypt(attribute);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Decrypt value when reading from database.
   *
   * @param   dbData  String
   *
   * @return  decrypt value when reading from database.
   */
  @Override public byte[] convertToEntityAttribute(byte[] dbData) {
    if (dbData == null) {
      return null;
    }

    if (EncryptorFactory.getByteEncryptor() == null) {
      return dbData;
    }

    return EncryptorFactory.getByteEncryptor().decrypt(dbData);
  }
} // end class ByteEncryptedConverter
