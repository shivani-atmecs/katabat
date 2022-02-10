package com.cmc.credagility.core.domain.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.type.AccountStatusCode;


/**
 * Account status detail table is a set of statuses supported by the system. Note that the same business status may have
 * different codes depending on different portfolios.
 *
 * @author   <a href="mailto:dongming.liao@ozstrategy.com">Dongming Liao</a>
 * @version  10/16/2014 11:47
 */
@Entity
@Table(
  name              = "AccountStatusDetail",
  uniqueConstraints = { @UniqueConstraint(columnNames = "statusCode") },
  indexes           = {
    @Index(
      name          = "statusCode_2",
      columnList    = "statusCode",
      unique        = true
    )
  }
)
public class AccountStatusDetail extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 3269478495635579210L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "statusCode",
    unique   = true,
    nullable = false,
    length   = 6
  )
  protected String statusCode;


  /** TODO: DOCUMENT ME! */
  @Column(name = "statusDescription")
  protected String statusDescription;


  // npelleti, 07/30, USBank, Removed unique constraint

  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "statusId",

    // unique   = true,
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long statusId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final AccountStatusDetail other = (AccountStatusDetail) obj;

    if (statusCode == null) {
      if (other.statusCode != null) {
        return false;
      }
    } else if (!statusCode.equals(other.statusCode)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * An enum of AccountStatusCode.
   *
   * @return  An enum of AccountStatusCode.
   */
  public AccountStatusCode getAccountStatusCode() {
    AccountStatusCode codeEnum = AccountStatusCode.toAccountStatusCode(statusCode);

    if (codeEnum == null) {
      codeEnum = AccountStatusCode.toAccountStatusCode(statusId);
    }

    return codeEnum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status code.
   *
   * @return  String
   */
  public String getStatusCode() {
    return statusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status description.
   *
   * @return  String
   */
  public String getStatusDescription() {
    return statusDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status id.
   *
   * @return  Long
   */
  public Long getStatusId() {
    return statusId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((statusCode != null) ? statusCode.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status code.
   *
   * @param  statusCode  String
   */
  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status description.
   *
   * @param  statusDescription  String
   */
  public void setStatusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status id.
   *
   * @param  statusId  Long
   */
  public void setStatusId(Long statusId) {
    this.statusId = statusId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "AccountStatusDetail ( " + TAB + "statusId = " + this.statusId + TAB + "statusCode = "
      + this.statusCode + TAB + "statusDescription = " + this.statusDescription + TAB + " )";

    return retValue;
  }

} // end class AccountStatusDetail
