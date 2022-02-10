package com.cmc.credagility.core.domain.config;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * Created by lihao1 on 12/29/15.
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  01/11/2016 14:05
 */
@Entity
@Table(name = "FlexSiteSSOConfig")
public class FlexSiteSSOConfig implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3718982798460934451L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "portfolioId",
    nullable = false
  )
  @OneToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;

  /** TODO: DOCUMENT ME! */
  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean signature;

  /** TODO: DOCUMENT ME! */
  @Column(length = 2048)
  protected String signatureKey;

  /** TODO: DOCUMENT ME! */
  @Column(length = 32)
  protected String ssoIdentity;

  /** TODO: DOCUMENT ME! */
  @Column(length = 2048)
  protected String ssoPrivateKey;

  /** TODO: DOCUMENT ME! */
  @Column(length = 2048)
  protected String ssoPublicKey;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for signature.
   *
   * @return  Boolean
   */
  public Boolean getSignature() {
    return signature;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for signature key.
   *
   * @return  String
   */
  public String getSignatureKey() {
    return signatureKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sso identity.
   *
   * @return  String
   */
  public String getSsoIdentity() {
    return ssoIdentity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sso private key.
   *
   * @return  String
   */
  public String getSsoPrivateKey() {
    return ssoPrivateKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sso public key.
   *
   * @return  String
   */
  public String getSsoPublicKey() {
    return ssoPublicKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for signature.
   *
   * @param  signature  Boolean
   */
  public void setSignature(Boolean signature) {
    this.signature = signature;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for signature key.
   *
   * @param  signatureKey  String
   */
  public void setSignatureKey(String signatureKey) {
    this.signatureKey = signatureKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sso identity.
   *
   * @param  ssoIdentity  String
   */
  public void setSsoIdentity(String ssoIdentity) {
    this.ssoIdentity = ssoIdentity;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sso private key.
   *
   * @param  ssoPrivateKey  String
   */
  public void setSsoPrivateKey(String ssoPrivateKey) {
    this.ssoPrivateKey = ssoPrivateKey;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sso public key.
   *
   * @param  ssoPublicKey  String
   */
  public void setSsoPublicKey(String ssoPublicKey) {
    this.ssoPublicKey = ssoPublicKey;
  }
} // end class FlexSiteSSOConfig
