package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.ozstrategy.credagility.core.converter.StringBooleanConverter;
import com.ozstrategy.credagility.core.domain.entity.BaseEntity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * For Persona Action.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  11/19/2014 23:49
 */
@Entity public class PersonaAccount extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean historical = Boolean.FALSE;

  @JoinColumn(
    name      = "accountNum",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Account account;

  @Column(
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  private Boolean deltaBatch = Boolean.FALSE;


  @Column(
    unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  @Column(nullable = true)
  private Long masterBatchId;

  @JoinColumn(
    name       = "personaActionId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private PersonaAction personaAction = new PersonaAction();
  @JoinColumn(
    name                              = "responsibleId",
    updatable                         = false,
    nullable                          = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Responsible   responsible;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new PersonaAccount object.
   */
  public PersonaAccount() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#equals(Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PersonaAccount)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    PersonaAccount that = (PersonaAccount) o;

    if ((historical != null) ? (!historical.equals(that.historical)) : (that.historical != null)) {
      return false;
    }

    if ((responsible != null) ? (!responsible.equals(that.responsible)) : (that.responsible != null)) {
      return false;
    }

    if ((account != null) ? (!account.equals(that.account)) : (that.account != null)) {
      return false;
    }

    if ((deltaBatch != null) ? (!deltaBatch.equals(that.deltaBatch)) : (that.deltaBatch != null)) {
      return false;
    }

    if ((id != null) ? (!id.equals(that.id)) : (that.id != null)) {
      return false;
    }

    if ((masterBatchId != null) ? (!masterBatchId.equals(that.masterBatchId)) : (that.masterBatchId != null)) {
      return false;
    }

    return !((personaAction != null) ? (!personaAction.equals(that.personaAction)) : (that.personaAction != null));

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delta batch.
   *
   * @return  Boolean
   */
  public Boolean getDeltaBatch() {
    return deltaBatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for historical.
   *
   * @return  Boolean
   */
  public Boolean getHistorical() {
    if (null == historical) {
      return Boolean.FALSE;
    }

    return historical;
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
   * getter method for master batch id.
   *
   * @return  Long
   */
  public Long getMasterBatchId() {
    return masterBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for persona action.
   *
   * @return  PersonaAction
   */
  public PersonaAction getPersonaAction() {
    return personaAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((historical != null) ? historical.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((deltaBatch != null) ? deltaBatch.hashCode() : 0);
    result = (31 * result) + ((id != null) ? id.hashCode() : 0);
    result = (31 * result) + ((masterBatchId != null) ? masterBatchId.hashCode() : 0);
    result = (31 * result) + ((personaAction != null) ? personaAction.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delta batch.
   *
   * @param  deltaBatch  Boolean
   */
  public void setDeltaBatch(Boolean deltaBatch) {
    this.deltaBatch = deltaBatch;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for historical.
   *
   * @param  historical  Boolean
   */
  public void setHistorical(Boolean historical) {
    this.historical = historical;
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
   * setter method for master batch id.
   *
   * @param  masterBatchId  Long
   */
  public void setMasterBatchId(Long masterBatchId) {
    this.masterBatchId = masterBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for persona action.
   *
   * @param  personaAction  PersonaAction
   */
  public void setPersonaAction(PersonaAction personaAction) {
    this.personaAction = personaAction;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.domain.entity.BaseEntity#toString()
   */
  @Override public String toString() {
    return "PersonaAccount{"
      + "historical=" + historical
      + ", responsible=" + responsible
      + ", account=" + account
      + ", deltaBatch=" + deltaBatch
      + ", id=" + id
      + ", masterBatchId=" + masterBatchId
      + ", personaAction=" + personaAction
      + '}';
  }

  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  public Responsible getResponsible() {
    return responsible;
  }
} // end class PersonaAccount
