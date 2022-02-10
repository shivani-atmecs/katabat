package com.cmc.credagility.core.domain.disposition;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cmc.credagility.core.domain.account.AccountAuthorizedContact;
import com.cmc.credagility.core.domain.account.AccountAuthorizedUser;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 11:12
 */
@Entity public class CoreAgentDispositionSpokeToRef extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name       = "accountAuthorizedContactId",
    insertable = true,
    nullable   = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private AccountAuthorizedContact accountAuthorizedContact;

  @JoinColumn(
    name       = "accountAuthorizedUserId",
    insertable = true,
    nullable   = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private AccountAuthorizedUser accountAuthorizedUser;

  @Column(
    name     = "id",
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  @JoinColumn(
    name       = "responsibleId",
    insertable = true,
    nullable   = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Responsible responsible;


  @JoinColumn(
    name       = "spokeToId",
    insertable = true,
    nullable   = true,
    updatable  = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private CoreAgentDispositionSpokeTo spokeTo;

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
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for spoke to.
   *
   * @return  CoreAgentDispositionSpokeTo
   */
  public CoreAgentDispositionSpokeTo getSpokeTo() {
    return spokeTo;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for spoke to.
   *
   * @param  spokeTo  CoreAgentDispositionSpokeTo
   */
  public void setSpokeTo(CoreAgentDispositionSpokeTo spokeTo) {
    this.spokeTo = spokeTo;
  }
} // end class CoreAgentDispositionSpokeToRef
