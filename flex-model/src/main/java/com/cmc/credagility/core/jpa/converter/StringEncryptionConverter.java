package com.cmc.credagility.core.jpa.converter;

import javax.persistence.AttributeConverter;

import com.cmc.credagility.util.EncryptorFactory;


/**
 * JPA Converter for String Encryptor.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/15/2014 11:01 AM
 */
public class StringEncryptionConverter implements AttributeConverter<String, String> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Encrypt value when saving into database.
   *
   * @param   attribute  String
   *
   * @return  encrypt value when saving into database.
   */
  @Override public String convertToDatabaseColumn(String attribute) {
    if (attribute == null) {
      return null;
    }

    if (EncryptorFactory.getStringEncryptor() == null) {
      return attribute;
    }

    return EncryptorFactory.getStringEncryptor().encrypt(attribute);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Decrypt value when reading from database.
   *
   * @param   dbData  String
   *
   * @return  decrypt value when reading from database.
   */
  @Override public String convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    }

    if (EncryptorFactory.getStringEncryptor() == null) {
      return dbData;
    }

    return EncryptorFactory.getStringEncryptor().decrypt(dbData);
  }
} // end class StringEncryptionConverter
