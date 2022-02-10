package com.cmc.credagility.core.domain.authorizeduser;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.account.AccountAuthorizedUser;
import com.cmc.credagility.core.domain.contact.AbstractBaseContact;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 09:40
 */
@MappedSuperclass public abstract class BaseAuthorizedUser extends AbstractBaseContact {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8037911976197373141L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountAuthorizedUserId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AccountAuthorizedUser accountAuthorizedUser;

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
   * setter method for account authorized user.
   *
   * @param  accountAuthorizedUser  AccountAuthorizedUser
   */
  public void setAccountAuthorizedUser(AccountAuthorizedUser accountAuthorizedUser) {
    this.accountAuthorizedUser = accountAuthorizedUser;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("BaseContact ( ").append(super.toString()).append(TAB).append("accountAuthorizedUser = ").append(
      this.accountAuthorizedUser).append(TAB).append(
      "source = ").append(this.source).append(TAB).append("status = ").append(this.status).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class BaseAuthorizedUser
