package com.ozstrategy.credagility.core.domain;

import com.cmc.credagility.core.domain.account.Account;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:beiquan.zhu@ozstrategy.com">Beiquan Zhu</a>
 * @version  10/16/2014 10:15
 */
@Entity
@Table(
  indexes = {
    @javax.persistence.Index(
      name = "fileNameIndex",
      columnList = "fileName"
    )
  }
)
public class AccountNumPurgeSet {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.ALL }
  )
  protected Account account;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "fileName",
    length = 255
  )
  protected String fileName;


  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

// protected String originalAccountNumberHash;


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
   * getter method for file name.
   *
   * @return  String
   */
  public String getFileName() {
    return fileName;
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

// public String getOriginalAccountNumberHash() {
// return originalAccountNumberHash;
// }

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
   * setter method for file name.
   *
   * @param  fileName  String
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
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

// public void setOriginalAccountNumberHash(String originalAccountNumberHash) {
// this.originalAccountNumberHash = originalAccountNumberHash;
// }
} // end class AccountNumPurgeSet
