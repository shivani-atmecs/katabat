package com.cmc.credagility.core.domain.portfolio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.account.AccountOverallStatusDetail;
import com.cmc.credagility.core.domain.account.AccountStatusDetail;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * This class is used to store Outcome Type information.
 *
 * <p><a href="OutcomeType.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 *
 *           <p>table = "OutcomeType"</p>
 * @version  10/15/2014 16:16
 */
@Entity
@Table(
  name              = "OutcomeType",
  uniqueConstraints = { @UniqueConstraint(columnNames = "statusId") }
)
public class OutcomeType extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -8173313065306266136L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** link to account overall status detail. */
  @JoinColumn(
    name   = "overallId",
    unique = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AccountOverallStatusDetail accountOverallStatusDetail;

  /** link to account status detail. */
  @JoinColumn(
    name   = "statusId",
    unique = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected AccountStatusDetail accountStatusDetail;

  /** Call Back flag. */
  @Column(
    name             = "callBack",
    columnDefinition = "char",
    length           = 1
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean callBack;

  /** Outcome Type Name. */
  @Column(
    name   = "name",
    length = 100
  )
  protected String name;

  // npelleti, 07/30, USBank, Removed unique constraint
  /** Outcome Type PK. */
  @Column(
    name     = "resultId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long resultId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!super.equals(obj)) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final OutcomeType other = (OutcomeType) obj;

    if (this.name == null) {
      if (other.getName() != null) {
        return false;
      }
    } else if (!this.name.equals(other.getName())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account overall status detail.
   *
   * @return  AccountOverallStatusDetail
   */
  public AccountOverallStatusDetail getAccountOverallStatusDetail() {
    return accountOverallStatusDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The accountStatusDetail.
   *
   * @return  the accountStatusDetail
   *
   *          <p>class = "com.cmc.credagility.AccountStatusDetail" column = "statusId" unique = "true" not-null =
   *          "false"</p>
   */
  public AccountStatusDetail getAccountStatusDetail() {
    return accountStatusDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The callBack.
   *
   * @return  the callBack
   *
   *          <p>not-null = "false" type = "yes_no"</p>
   */
  public Boolean getCallBack() {
    return callBack;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The name.
   *
   * @return  the name
   *
   *          <p>not-null = "false" length = "100"</p>
   */
  public String getName() {
    return this.name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The resultId.
   *
   * @return  the resultId
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getResultId() {
    return this.resultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * type code.
   *
   * @return  type code.
   */
  public String getTypeCode() {
    return getClass().getSimpleName() + this.resultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = super.hashCode();
    result = (PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account overall status detail.
   *
   * @param  accountOverallStatusDetail  AccountOverallStatusDetail
   */
  public void setAccountOverallStatusDetail(AccountOverallStatusDetail accountOverallStatusDetail) {
    this.accountOverallStatusDetail = accountOverallStatusDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setAccountStatusDetail.
   *
   * @param  accountStatusDetail  the accountStatusDetail to set
   */
  public void setAccountStatusDetail(AccountStatusDetail accountStatusDetail) {
    this.accountStatusDetail = accountStatusDetail;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setCallBack.
   *
   * @param  callBack  the callBack to set
   */
  public void setCallBack(Boolean callBack) {
    this.callBack = callBack;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setName.
   *
   * @param  name  the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setResultId.
   *
   * @param  resultId  the resultId to set
   */
  public void setResultId(Long resultId) {
    this.resultId = resultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("OutcomeType ( ").append(super.toString()).append(TAB).append("name = ").append(this.name).append(
      TAB).append("resultId = ").append(this.resultId).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class OutcomeType
