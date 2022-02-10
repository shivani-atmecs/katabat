package com.cmc.credagility.core.domain.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.score.BaseScore;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 11:16
 */
@Entity
@Table(name = "AccountScore")
public class AccountScore extends BaseScore {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 1735158534298950551L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name     = "accountNum", /*insertable = true, updatable = false, */
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Account account;

  // npelleti removed unique key constraint.
  @Column(
    name     = "accountScoreLinkId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long accountScoreLinkId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.score.BaseScore#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    return super.equals(obj);
  }

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
   * getter method for account score link id.
   *
   * @return  Long
   */
  public Long getAccountScoreLinkId() {
    return accountScoreLinkId;
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
   * setter method for account score link id.
   *
   * @param  accountScoreLinkId  Long
   */
  public void setAccountScoreLinkId(Long accountScoreLinkId) {
    this.accountScoreLinkId = accountScoreLinkId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "AccountScore ( " + super.toString() + TAB
      + "accountScoreLinkId = " + this.accountScoreLinkId + TAB
      + "accountNum = " + this.account.getAccountNum() + TAB + " )";

    return retValue;
  }
} // end class AccountScore
