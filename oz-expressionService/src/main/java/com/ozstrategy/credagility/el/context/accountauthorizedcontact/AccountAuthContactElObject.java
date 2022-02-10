package com.ozstrategy.credagility.el.context.accountauthorizedcontact;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.account.AccountAuthorizedContact;
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
public class AccountAuthContactElObject extends ElObject<AccountAuthContactElContext> {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  protected Account account;

  /** DOCUMENT ME! */
  protected AccountAuthorizedContact accountAuthorizedContact;

  /** DOCUMENT ME! */
  protected Portfolio   portfolio;
  private AccountDetail accountDetail;
  private AccountIndex  accountIndex;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AccountAuthContactElObject object.
   *
   * @param  portfolio  DOCUMENT ME!
   */
  public AccountAuthContactElObject(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  /**
   * Creates a new AccountAuthContactElObject object.
   *
   * @param  account  DOCUMENT ME!
   */
  public AccountAuthContactElObject(Account account) {
    this.account   = account;
    this.portfolio = this.account.getPortfolio();

  }

  /**
   * Creates a new AccountAuthContactElObject object.
   *
   * @param  entity  DOCUMENT ME!
   */
  public AccountAuthContactElObject(AccountAuthorizedContact entity) {
    this.accountAuthorizedContact = entity;
    this.account                  = entity.getAccount();
    this.portfolio                = this.account.getPortfolio();
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElObject#createContext()
   */
  @Override public AccountAuthContactElContext createContext() {
    AccountAuthContactElContext context = new AccountAuthContactElContext();
    context.setAccount(account);
    context.setAccountAuthorizedContact(accountAuthorizedContact);
    context.setAccountDetail(accountDetail);
    context.setAccountIndex(accountIndex);
    context.setPortfolio(portfolio);

    return context;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.el.ElObject#getCacheKey()
   */
  @Override public String getCacheKey() {
    return "acct_auth_contact" + getId();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getId() {
    if (accountAuthorizedContact != null) {
      return accountAuthorizedContact.getAccountAuthorizedId();
    }

    return null;
  }
} // end class AccountAuthContactElObject
