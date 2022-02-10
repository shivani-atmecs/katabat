package com.ozstrategy.credagility.el.context.accountauthorizeduser;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.account.AccountAuthorizedUser;
import com.cmc.credagility.core.domain.account.AccountDetail;
import com.cmc.credagility.core.domain.account.AccountIndex;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.ozstrategy.credagility.core.el.ElObject;


/**
 * Created by Yang Wang on 2/24/14.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
public class AccountAuthUserElObject extends ElObject<AccountAuthUserElContext> {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  protected Account account;

  /** DOCUMENT ME! */
  protected AccountAuthorizedUser accountAuthorizedUser;

  /** DOCUMENT ME! */
  protected AccountDetail accountDetail;

  /** DOCUMENT ME! */
  protected AccountIndex accountIndex;

  /** DOCUMENT ME! */
  protected Portfolio portfolio;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public AccountAuthUserElObject(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  /**
   * Creates a new AccountAuthUserElObject object.
   *
   * @param  account  DOCUMENT ME!
   */
  public AccountAuthUserElObject(Account account) {
    this.account   = account;
    this.portfolio = this.account.getPortfolio();
  }

  /**
   * Creates a new AccountAuthUserElObject object.
   *
   * @param  entity  DOCUMENT ME!
   */
  public AccountAuthUserElObject(AccountAuthorizedUser entity) {
    this.accountAuthorizedUser = entity;
    this.account               = entity.getAccount();
    this.portfolio             = this.account.getPortfolio();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElObject#createContext()
   */
  @Override public AccountAuthUserElContext createContext() {
    AccountAuthUserElContext context = new AccountAuthUserElContext();
    context.setAccount(account);
    context.setAccountAuthorizedUser(accountAuthorizedUser);
    context.setAccountDetails(accountDetail);
    context.setAccountIndex(accountIndex);
    context.setPortfolio(portfolio);

    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElObject#getCacheKey()
   */
  @Override public String getCacheKey() {
    return "acct_auth_user" + getId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    if (accountAuthorizedUser != null) {
      return accountAuthorizedUser.getAuthorizedUserId();
    }

    return null;
  }
} // end class AccountAuthUserElObject
