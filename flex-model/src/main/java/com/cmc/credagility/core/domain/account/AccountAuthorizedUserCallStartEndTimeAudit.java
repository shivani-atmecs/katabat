package com.cmc.credagility.core.domain.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.portfolio.BaseCallStartEndTimeAudit;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/14/2014 17:29
 */
@Entity public class AccountAuthorizedUserCallStartEndTimeAudit extends BaseCallStartEndTimeAudit {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name       = "accountAuthorizedUserId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private AccountAuthorizedUser accountAuthorizedUser;

  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }
} // end class AccountAuthorizedUserCallStartEndTimeAudit
