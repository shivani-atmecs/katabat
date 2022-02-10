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
 * @version  10/16/2014 14:54
 */
@Entity public class AccountAuthorizedContactCallStartEndTimeAudit extends BaseCallStartEndTimeAudit {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name       = "accountAuthorizedContactId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private AccountAuthorizedContact accountAuthorizedContact;

  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

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
   * getter method for id.
   *
   * @return  Long
   */
  public Long getId() {
    return id;
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
   * setter method for id.
   *
   * @param  id  Long
   */
  public void setId(Long id) {
    this.id = id;
  }

} // end class AccountAuthorizedContactCallStartEndTimeAudit
