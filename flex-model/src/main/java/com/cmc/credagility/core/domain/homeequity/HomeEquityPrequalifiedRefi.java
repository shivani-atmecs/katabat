package com.cmc.credagility.core.domain.homeequity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * This class is used to present the Prequalified Refi information.
 *
 * <p><a href="HomeEquityPrequalifiedRefi.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 *
 *           <p>table = "HomeEquityPrequalifiedRefi"</p>
 * @version  10/15/2014 13:36
 */
@Entity
@Table(
  name    = "HomeEquityPrequalifiedRefi",
  indexes = {
    @Index(
      name = "hePreOrigAcctNumIndex",
      columnList = "originalAccountNum"
    )
  }
)
public class HomeEquityPrequalifiedRefi extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7764516908924321701L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Account. */
  @JoinColumn(updatable = false)
  @OneToOne(mappedBy = "homeEquityPrequalifiedRefi")
  protected Account account;

  /** id PK. */
  // npelleti dropped unique const.
  @Column(
    name     = "id", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  /** MAPR. */
  @Column(
    name     = "mapr",
    nullable = false
  )
  protected Integer mapr;

  // npelleti, 07/30, USBank, Added NotNull Annotation
  /** Original Account Number. */
  @Column(
    name     = "originalAccountNum",
    nullable = false,
    length   = 255
  )
  protected String originalAccountNum;

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

    final HomeEquityPrequalifiedRefi other = (HomeEquityPrequalifiedRefi) obj;

    if (originalAccountNum == null) {
      if (other.originalAccountNum != null) {
        return false;
      }
    } else if (!originalAccountNum.equals(other.originalAccountNum)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The account.
   *
   * @return  the account
   *
   *          <p>property-ref = "homeEquityPrequalifiedRefi" class = "com.cmc.credagility.Account" insert = "true"
   *          update = "false" cascade = "none"</p>
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The id.
   *
   * @return  the id
   *
   *          <p>generator-class = "native" unsaved-value = "null"</p>
   */
  public Long getId() {
    return id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The mapr.
   *
   * @return  the mapr
   *
   *          <p>not-null = "true"</p>
   */
  public Integer getMapr() {
    return mapr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The orginalAccountNum.
   *
   * @return  the orginalAccountNum
   *
   *          <p>not-null = "true" index = "hePreOrigAcctNumIndex"</p>
   */
  public String getOriginalAccountNum() {
    return originalAccountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((originalAccountNum == null) ? 0 : originalAccountNum.hashCode());

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
   * setId.
   *
   * @param  id  the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setMapr.
   *
   * @param  mapr  the mapr to set
   */
  public void setMapr(Integer mapr) {
    this.mapr = mapr;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for original account num.
   *
   * @param  originalAccountNum  String
   */
  public void setOriginalAccountNum(String originalAccountNum) {
    this.originalAccountNum = originalAccountNum;
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

    retValue.append("HomeEquityPrequalifiedRefi ( ").append(super.toString()).append(TAB).append("id = ").append(
      this.id).append(TAB).append(
      "mapr = ").append(this.mapr).append(TAB).append(
      "orginalAccountNum = ").append(this.originalAccountNum).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class HomeEquityPrequalifiedRefi
