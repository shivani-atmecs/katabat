package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;


/**
 * This class is used to store Account Level Configuration Information.
 *
 * <p><a href="AccountConfig.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:kpalanivelu@cmcagile.com">Karthikeyan Palanivelu</a>
 * @version  $Revision$, $Date$
 *
 *           <p>table = "AccountConfig"</p>
 */
@Entity
@Table(
  name    = "AccountConfig",
  indexes = {
    @Index(
      name = "originalAccountNumberHash2Index",
      columnList = "originalAccountNumberHash2"
    ),
    @Index(
      name = "previousAccountNumberHashIndex",
      columnList = "previousAccountNumberHash"
    )
  }
)
public class AccountConfig extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  // ~ Static fields/initializers
  // ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 6392258380848853540L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "accountNum",
    nullable = false
  )
  @ManyToOne(cascade = CascadeType.ALL)
  protected Account account;


  /** TODO: DOCUMENT ME! */
  @Column(name = "accountConfigId")
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long accountConfigId;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowChannelStrategy;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowNegotiationStrategy;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowProgramStrategy;


  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean allowQueueStrategy;


  /** TODO: DOCUMENT ME! */
  @Column(name = "clientConsentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date clientConsentDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "cmcConsentDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date cmcConsentDate;

  /** payment amount. */
  @Column(name = "deactivateDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date deactivateDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "lastImportDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastImportDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "lastLoginFailureDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastLoginFailureDate;

  @Column(
    length   = 2,
    nullable = true,
    name     = "loginFailureCount"
  )
  private Integer loginFailureCount;

  @Column(
    length   = 48,
    nullable = true
  )
  private String originalAccountNumberHash2;

  @Column(
    name     = "previousAccountNumber",
    length   = 200,
    nullable = true
  )
  @Convert(converter = StringEncryptionConverter.class)
  private String previousAccountNumber;

  @Column(
    length   = 200,
    nullable = true
  )
  private String previousAccountNumberHash;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * default constructor.
   */
  public AccountConfig() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof AccountConfig)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    AccountConfig that = (AccountConfig) o;

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((accountConfigId != null) ? (!accountConfigId.equals(that.accountConfigId)) : (that.accountConfigId != null)) {
      return false;
    }

    if ((deactivateDate != null) ? (!deactivateDate.equals(that.deactivateDate)) : (that.deactivateDate != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Account getAccount() {
    return this.account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getAccountConfigId() {
    return accountConfigId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowChannelStrategy() {
    return allowChannelStrategy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowNegotiationStrategy() {
    return allowNegotiationStrategy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // ~ Methods
  // ----------------------------------------------------------------------------------------------------------
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowProgramStrategy() {
    return allowProgramStrategy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getAllowQueueStrategy() {
    return allowQueueStrategy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The clientConsentDate.
   *
   * @return  the clientConsentDate
   */
  public Date getClientConsentDate() {
    return clientConsentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  // Constructors
  /**
   * The cmcConsentDate.
   *
   * @return  the cmcConsentDate
   */
  public Date getCmcConsentDate() {
    return cmcConsentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getDeactivateDate() {
    return deactivateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getLastImportDate() {
    return lastImportDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getLastLoginFailureDate() {
    return lastLoginFailureDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getLoginFailureCount() {
    return loginFailureCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getOriginalAccountNumberHash2() {
    return originalAccountNumberHash2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPreviousAccountNumber() {
    return previousAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPreviousAccountNumberHash() {
    return previousAccountNumberHash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result)
      + ((accountConfigId != null) ? accountConfigId.hashCode() : 0);
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result)
      + ((deactivateDate != null) ? deactivateDate.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  account  DOCUMENT ME!
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  accountConfigId  DOCUMENT ME!
   */
  public void setAccountConfigId(Long accountConfigId) {
    this.accountConfigId = accountConfigId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowChannelStrategy  DOCUMENT ME!
   */
  public void setAllowChannelStrategy(Boolean allowChannelStrategy) {
    this.allowChannelStrategy = allowChannelStrategy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowNegotiationStrategy  DOCUMENT ME!
   */
  public void setAllowNegotiationStrategy(Boolean allowNegotiationStrategy) {
    this.allowNegotiationStrategy = allowNegotiationStrategy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowProgramStrategy  DOCUMENT ME!
   */
  public void setAllowProgramStrategy(Boolean allowProgramStrategy) {
    this.allowProgramStrategy = allowProgramStrategy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  allowQueueStrategy  DOCUMENT ME!
   */
  public void setAllowQueueStrategy(Boolean allowQueueStrategy) {
    this.allowQueueStrategy = allowQueueStrategy;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  clientConsentDate  the clientConsentDate to set
   */
  public void setClientConsentDate(Date clientConsentDate) {
    this.clientConsentDate = clientConsentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  cmcConsentDate  the cmcConsentDate to set
   */
  public void setCmcConsentDate(Date cmcConsentDate) {
    this.cmcConsentDate = cmcConsentDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  deactivateDate  DOCUMENT ME!
   */
  public void setDeactivateDate(Date deactivateDate) {
    this.deactivateDate = deactivateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastImportDate  DOCUMENT ME!
   */
  public void setLastImportDate(Date lastImportDate) {
    this.lastImportDate = lastImportDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastLoginFailureDate  DOCUMENT ME!
   */
  public void setLastLoginFailureDate(Date lastLoginFailureDate) {
    this.lastLoginFailureDate = lastLoginFailureDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  loginFailureCount  DOCUMENT ME!
   */
  public void setLoginFailureCount(Integer loginFailureCount) {
    this.loginFailureCount = loginFailureCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  originalAccountNumberHash2  DOCUMENT ME!
   */
  public void setOriginalAccountNumberHash2(String originalAccountNumberHash2) {
    this.originalAccountNumberHash2 = originalAccountNumberHash2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  previousAccountNumber  DOCUMENT ME!
   */
  public void setPreviousAccountNumber(String previousAccountNumber) {
    this.previousAccountNumber = previousAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  previousAccountNumberHash  DOCUMENT ME!
   */
  public void setPreviousAccountNumberHash(String previousAccountNumberHash) {
    this.previousAccountNumberHash = previousAccountNumberHash;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    return "AccountConfig{" + "accountConfigId=" + accountConfigId
      + ", account=" + account + ", deactivateDate=" + deactivateDate
      + '}';
  }
} // end class AccountConfig
