package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/14/2014 17:35
 */
@Entity
@Table(name = "AccountAuthorizedUserDetail")
public class AccountAuthorizedUserDetail extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 5255143217933066488L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name     = "authorizedUserId",
    unique   = true,
    nullable = false
  )
  @ManyToOne(cascade = { CascadeType.ALL })
  private AccountAuthorizedUser accountAuthorizedUser;

  @Column(
    name     = "accountAuthorizedUserDetailId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long accountAuthorizedUserDetailId;

  @Column(
    name   = "clientDefined15CharCode1",
    length = 15
  )
  private String clientDefined15CharCode1;

  @Column(
    name   = "clientDefined1CharCode1",
    length = 1
  )
  private String clientDefined1CharCode1;

  @Column(
    name   = "clientDefined20CharCode1",
    length = 20
  )
  private String clientDefined20CharCode1;

  @Column(
    name   = "clientDefined20CharCode2",
    length = 20
  )
  private String clientDefined20CharCode2;

  @Column(
    name   = "clientDefined3CharCode1",
    length = 3
  )
  private String clientDefined3CharCode1;

  @Column(name = "clientDefinedDate1")
  private Date clientDefinedDate1;

  @Column(name = "clientDefinedDecimal1")
  private BigDecimal clientDefinedDecimal1;

  @Column(
    name             = "clientDefinedFlag1",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean clientDefinedFlag1;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account authorized user.
   *
   * @return  AccountAuthorizedUser
   */
  public AccountAuthorizedUser getAccountAuthorizedUser() {
    return accountAuthorizedUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account authorized user detail id.
   *
   * @return  Long
   */
  public Long getAccountAuthorizedUserDetailId() {
    return accountAuthorizedUserDetailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined15 char code1.
   *
   * @return  String
   */
  public String getClientDefined15CharCode1() {
    return clientDefined15CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined1 char code1.
   *
   * @return  String
   */
  public String getClientDefined1CharCode1() {
    return clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code1.
   *
   * @return  String
   */
  public String getClientDefined20CharCode1() {
    return clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined20 char code2.
   *
   * @return  String
   */
  public String getClientDefined20CharCode2() {
    return clientDefined20CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined3 char code1.
   *
   * @return  String
   */
  public String getClientDefined3CharCode1() {
    return clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined date1.
   *
   * @return  Date
   */
  public Date getClientDefinedDate1() {
    return clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined decimal1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getClientDefinedDecimal1() {
    return clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client defined flag1.
   *
   * @return  Boolean
   */
  public Boolean getClientDefinedFlag1() {
    return clientDefinedFlag1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account authorized user.
   *
   * @param  accountAuthorizedUser  AccountAuthorizedUser
   */
  public void setAccountAuthorizedUser(AccountAuthorizedUser accountAuthorizedUser) {
    this.accountAuthorizedUser = accountAuthorizedUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account authorized user detail id.
   *
   * @param  accountAuthorizedUserDetailId  Long
   */
  public void setAccountAuthorizedUserDetailId(Long accountAuthorizedUserDetailId) {
    this.accountAuthorizedUserDetailId = accountAuthorizedUserDetailId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined15 char code1.
   *
   * @param  clientDefined15CharCode1  String
   */
  public void setClientDefined15CharCode1(String clientDefined15CharCode1) {
    this.clientDefined15CharCode1 = clientDefined15CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined1 char code1.
   *
   * @param  clientDefined1CharCode1  String
   */
  public void setClientDefined1CharCode1(String clientDefined1CharCode1) {
    this.clientDefined1CharCode1 = clientDefined1CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code1.
   *
   * @param  clientDefined20CharCode1  String
   */
  public void setClientDefined20CharCode1(String clientDefined20CharCode1) {
    this.clientDefined20CharCode1 = clientDefined20CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined20 char code2.
   *
   * @param  clientDefined20CharCode2  String
   */
  public void setClientDefined20CharCode2(String clientDefined20CharCode2) {
    this.clientDefined20CharCode2 = clientDefined20CharCode2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined3 char code1.
   *
   * @param  clientDefined3CharCode1  String
   */
  public void setClientDefined3CharCode1(String clientDefined3CharCode1) {
    this.clientDefined3CharCode1 = clientDefined3CharCode1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined date1.
   *
   * @param  clientDefinedDate1  Date
   */
  public void setClientDefinedDate1(Date clientDefinedDate1) {
    this.clientDefinedDate1 = clientDefinedDate1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined decimal1.
   *
   * @param  clientDefinedDecimal1  BigDecimal
   */
  public void setClientDefinedDecimal1(BigDecimal clientDefinedDecimal1) {
    this.clientDefinedDecimal1 = clientDefinedDecimal1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client defined flag1.
   *
   * @param  clientDefinedFlag1  Boolean
   */
  public void setClientDefinedFlag1(Boolean clientDefinedFlag1) {
    this.clientDefinedFlag1 = clientDefinedFlag1;
  }
} // end class AccountAuthorizedUserDetail
