package com.cmc.credagility.core.domain.account;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.InfoSource;


/**
 * This is the table to capture financial adjustmentw. Mainly come from the client. These adjustments will be directly
 * applied to the account balance while imported.
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 12:08
 */
@Entity
@Table(name = "FinancialAdjustment")
public class FinancialAdjustment extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 2116949914491708132L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @JoinColumn(
    name      = "accountNum",
    updatable = false,
    nullable  = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private Account account;

  @Column(name = "adjustDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date adjustDate;

  @Column(
    name     = "amount",
    nullable = false
  )
  private BigDecimal amount;

  @Column(name = "balance")
  private BigDecimal balance;
  @Column(name = "batchDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date       batchDate;

  // Only make sense if it is imported by batch
  @Column(name = "batchId")
  private Long batchId;

  @Column(
    name   = "comment",
    length = 256
  )
  private String comment;

  // npelleti, 07/30, USBank, Removed unique constraint
  @Column(
    name     = "id",

    // unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id private Long id;

  // npelleti, 07/30, USBank, NotNull Annotation
  @Column(
    name     = "infoSource",
    nullable = false,
    length   = 8
  )
  @Enumerated(EnumType.STRING)
  private InfoSource infoSource;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final FinancialAdjustment other = (FinancialAdjustment) obj;

    if (adjustDate == null) {
      if (other.adjustDate != null) {
        return false;
      }
    } else if (!adjustDate.equals(other.adjustDate)) {
      return false;
    }

    if (amount == null) {
      if (other.amount != null) {
        return false;
      }
    } else if (!amount.equals(other.amount)) {
      return false;
    }

    if (balance == null) {
      if (other.balance != null) {
        return false;
      }
    } else if (!balance.equals(other.balance)) {
      return false;
    }

    if (batchDate == null) {
      if (other.batchDate != null) {
        return false;
      }
    } else if (!batchDate.equals(other.batchDate)) {
      return false;
    }

    if (batchId == null) {
      if (other.batchId != null) {
        return false;
      }
    } else if (!batchId.equals(other.batchId)) {
      return false;
    }

    if (infoSource == null) {
      if (other.infoSource != null) {
        return false;
      }
    } else if (!infoSource.equals(other.infoSource)) {
      return false;
    }

    return true;
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
   * getter method for adjust date.
   *
   * @return  Date
   */
  public Date getAdjustDate() {
    return adjustDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getAmount() {
    return amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBalance() {
    return balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for batch date.
   *
   * @return  Date
   */
  public Date getBatchDate() {
    return batchDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for batch id.
   *
   * @return  Long
   */
  public Long getBatchId() {
    return batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for comment.
   *
   * @return  String
   */
  public String getComment() {
    return comment;
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
   * getter method for info source.
   *
   * @return  InfoSource
   */
  public InfoSource getInfoSource() {
    return infoSource;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = 1;
    result = (prime * result)
      + ((adjustDate == null) ? 0 : adjustDate.hashCode());
    result = (prime * result) + ((amount == null) ? 0 : amount.hashCode());
    result = (prime * result) + ((balance == null) ? 0 : balance.hashCode());
    result = (prime * result) + ((batchDate == null) ? 0 : batchDate.hashCode());
    result = (prime * result) + ((batchId == null) ? 0 : batchId.hashCode());
    result = (prime * result)
      + ((infoSource == null) ? 0 : infoSource.hashCode());

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
   * setter method for adjust date.
   *
   * @param  adjustDate  Date
   */
  public void setAdjustDate(Date adjustDate) {
    this.adjustDate = adjustDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for amount.
   *
   * @param  amount  BigDecimal
   */
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for balance.
   *
   * @param  balance  BigDecimal
   */
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for batch date.
   *
   * @param  batchDate  Date
   */
  public void setBatchDate(Date batchDate) {
    this.batchDate = batchDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for batch id.
   *
   * @param  batchId  Long
   */
  public void setBatchId(Long batchId) {
    this.batchId = batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for comment.
   *
   * @param  comment  String
   */
  public void setComment(String comment) {
    this.comment = comment;
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
   * setter method for info source.
   *
   * @param  infoSource  InfoSource
   */
  public void setInfoSource(InfoSource infoSource) {
    this.infoSource = infoSource;
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

    retValue = "FinancialAdjustment ( " + super.toString() + TAB + "id = "
      + this.id + TAB + "account = " + this.account.getAccountNum() + TAB
      + "infoSource = " + this.infoSource + TAB + "amount = " + this.amount
      + TAB + "balance = " + this.balance + TAB + "comment = " + this.comment
      + TAB + "batchId = " + this.batchId + TAB + "batchDate = "
      + this.batchDate + TAB + " )";

    return retValue;
  }
} // end class FinancialAdjustment
