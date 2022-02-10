package com.ozstrategy.credagility.core.converter;

import com.cmc.credagility.util.EncryptorFactory;

import javax.persistence.AttributeConverter;


/**
 * JPA Converter for String Encryptor.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/15/2014 11:01 AM
 */
public class StringEncryptionConverter implements AttributeConverter<String, String> {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  javax.persistence.AttributeConverter#convertToDatabaseColumn(String)
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
   * @see  javax.persistence.AttributeConverter#convertToEntityAttribute(String)
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
