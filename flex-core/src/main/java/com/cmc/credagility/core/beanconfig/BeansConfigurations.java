package com.cmc.credagility.core.beanconfig;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import org.springframework.core.env.Environment;

import com.cmc.encryption.CmcPBEByteEncryptor;
import com.cmc.encryption.CmcPBEStringEncryptor;
import com.cmc.credagility.util.EncryptorFactory;


/**
 * Defines beans.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/15/2014 14:13 PM
 */
@Configuration
@PropertySource(value = { "classpath:application.properties" })
public class BeansConfigurations {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  static {
    // Add BC Provider
    Security.addProvider(new BouncyCastleProvider());
  }

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Autowired private Environment env;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  Exception  DOCUMENT ME!
   */
  @Bean
  @Qualifier("hashEncryptor")
  public ConfigurablePasswordEncryptor hashEncryptor() throws Exception {
    ConfigurablePasswordEncryptor encryptor = new ConfigurablePasswordEncryptor();
    encryptor.setAlgorithm(env.getProperty("hashAlgorithm"));
    encryptor.setPlainDigest(true);

    return encryptor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * multiPasswordPBEByteEncryptor.
   *
   * @return  MultiPasswordPBEByteEncryptor
   *
   * @throws  Exception  exception
   */
  @Bean
  @Qualifier("cmcPBEByteEncryptor")
  public CmcPBEByteEncryptor cmcPBEByteEncryptor() throws Exception {
    CmcPBEByteEncryptor pbeByteEncryptor = new CmcPBEByteEncryptor();
    pbeByteEncryptor.setProvider(new BouncyCastleProvider());
    pbeByteEncryptor.setAlgorithm(env.getProperty("pbeAlgorithm"));
    pbeByteEncryptor.setPassword(env.getProperty("pbePassword"));
    pbeByteEncryptor.setCompletelyEncryptedEnv("completelyEncryptedEnv");
    pbeByteEncryptor.setUseIndexQuery(env.getProperty("useIndexQuery"));

    EncryptorFactory.setByteEncryptor(pbeByteEncryptor);

    return pbeByteEncryptor;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  Exception  DOCUMENT ME!
   */
  @Bean
  @Qualifier("cmcPBEStringEncryptor")
  public CmcPBEStringEncryptor cmcPBEStringEncryptor() throws Exception {
    CmcPBEStringEncryptor pbeStringEncryptor = new CmcPBEStringEncryptor();
    pbeStringEncryptor.setProvider(new BouncyCastleProvider());
    pbeStringEncryptor.setAlgorithm(env.getProperty("pbeAlgorithm"));
    pbeStringEncryptor.setPassword(env.getProperty("pbePassword"));
    pbeStringEncryptor.setCompletelyEncryptedEnv("completelyEncryptedEnv");
    pbeStringEncryptor.setUseIndexQuery(env.getProperty("useIndexQuery"));

    EncryptorFactory.setStringEncryptor(pbeStringEncryptor);

    return pbeStringEncryptor;
  }

// @Bean
// @Qualifier("encryptorBean")
// public EncryptorBean encryptorBean() throws Exception {
// EncryptorBean pbeStringEncryptor = new EncryptorBean();
//
// return pbeStringEncryptor;
// }

} // end class BeansConfigurations
