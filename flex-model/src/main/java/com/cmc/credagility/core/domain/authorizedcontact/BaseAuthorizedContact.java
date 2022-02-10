package com.cmc.credagility.core.domain.authorizedcontact;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.cmc.credagility.core.domain.account.AccountAuthorizedContact;
import com.cmc.credagility.core.domain.contact.AbstractBaseContact;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/14/2014 17:56
 */
@MappedSuperclass public abstract class BaseAuthorizedContact extends AbstractBaseContact {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8037911976197373141L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountAuthorizedContactId",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AccountAuthorizedContact accountAuthorizedContact;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account authorized contact.
   *
   * @return  AccountAuthorizedContact
   */
  public AccountAuthorizedContact getAccountAuthorizedContact() {
    return accountAuthorizedContact;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account authorized contact.
   *
   * @param  accountAuthorizedContact  AccountAuthorizedContact
   */
  public void setAccountAuthorizedContact(AccountAuthorizedContact accountAuthorizedContact) {
    this.accountAuthorizedContact = accountAuthorizedContact;
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

    retValue.append("BaseContact ( ").append(super.toString()).append(TAB).append("accountAuthorizedContact = ").append(
      this.accountAuthorizedContact).append(TAB).append(
      "source = ").append(this.source).append(TAB).append("status = ").append(this.status).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class BaseAuthorizedContact
