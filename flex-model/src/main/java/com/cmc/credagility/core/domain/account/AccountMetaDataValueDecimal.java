package com.cmc.credagility.core.domain.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.metadata.MetaDataValueDecimal;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 10:36
 */
@Entity
@Table(
  name    = "AccountMetaDataValueDecimal",
  indexes = {
    @Index(
      name = "decimal_value_idx",
      columnList = "value"
    )
  }
)
public class AccountMetaDataValueDecimal extends MetaDataValueDecimal {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 5091634510582639701L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  @JoinColumn(
    name   = "accountMetaDataId",
    unique = true
  )
  @ManyToOne private AccountMetaData accountMetaData;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account meta data.
   *
   * @return  AccountMetaData
   */
  public AccountMetaData getAccountMetaData() {
    return accountMetaData;
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
   * setter method for account meta data.
   *
   * @param  accountMetaData  AccountMetaData
   */
  public void setAccountMetaData(AccountMetaData accountMetaData) {
    this.accountMetaData = accountMetaData;
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


} // end class AccountMetaDataValueDecimal
