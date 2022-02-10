package com.cmc.credagility.core.domain.responsible;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.customer.Customer;
import com.cmc.credagility.core.domain.score.BaseScore;


/**
 * Created by wangjp on 16/11/17.
 *
 * @author   <a href="mailto:jianping.wang@ozstrategy.com">Jianping Wang</a>
 * @version  11/17/2016 22:24
 */
@Entity
@Table(name = "ResponsibleReAge")
public class ResponsibleReAge extends BaseScore {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 7256799627239651073L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "accountNum",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account accountNum;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "customerId",
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;

  /** TODO: DOCUMENT ME! */
  @Column(name = "effectiveDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date effectiveDate;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "input1",
    length = 100
  )
  protected String input1;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "input2",
    length = 100
  )
  protected String input2;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "name",
    length = 10
  )
  protected String name;

  /** TODO: DOCUMENT ME! */
  @Column(name = "rank")
  protected Integer rank;

  /** TODO: DOCUMENT ME! */
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long reAgeId;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "type",
    length = 10
  )
  protected String               type;
  @JoinColumn(
    name     = "responsibleId",
    nullable = false
  )
  @ManyToOne private Responsible responsible;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.score.BaseScore#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    ResponsibleReAge reAge = (ResponsibleReAge) o;

    if ((accountNum != null) ? (!accountNum.equals(reAge.accountNum)) : (reAge.accountNum != null)) {
      return false;
    }

    if ((customer != null) ? (!customer.equals(reAge.customer)) : (reAge.customer != null)) {
      return false;
    }

    if ((effectiveDate != null) ? (!effectiveDate.equals(reAge.effectiveDate)) : (reAge.effectiveDate != null)) {
      return false;
    }

    if ((input1 != null) ? (!input1.equals(reAge.input1)) : (reAge.input1 != null)) {
      return false;
    }

    if ((input2 != null) ? (!input2.equals(reAge.input2)) : (reAge.input2 != null)) {
      return false;
    }

    if ((name != null) ? (!name.equals(reAge.name)) : (reAge.name != null)) {
      return false;
    }

    if ((rank != null) ? (!rank.equals(reAge.rank)) : (reAge.rank != null)) {
      return false;
    }

    if ((reAgeId != null) ? (!reAgeId.equals(reAge.reAgeId)) : (reAge.reAgeId != null)) {
      return false;
    }

    if ((type != null) ? (!type.equals(reAge.type)) : (reAge.type != null)) {
      return false;
    }

    return (responsible != null) ? responsible.equals(reAge.responsible) : (reAge.responsible == null);

  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account num.
   *
   * @return  Account
   */
  public Account getAccountNum() {
    return accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for customer.
   *
   * @return  Customer
   */
  public Customer getCustomer() {
    return customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for effective date.
   *
   * @return  Date
   */
  public Date getEffectiveDate() {
    return effectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for input1.
   *
   * @return  String
   */
  public String getInput1() {
    return input1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for input2.
   *
   * @return  String
   */
  public String getInput2() {
    return input2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for name.
   *
   * @return  String
   */
  public String getName() {
    return name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rank.
   *
   * @return  Integer
   */
  public Integer getRank() {
    return rank;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for re age id.
   *
   * @return  Long
   */
  public Long getReAgeId() {
    return reAgeId;
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
   * getter method for type.
   *
   * @return  String
   */
  public String getType() {
    return type;
  }

  //~ ------------------------------------------------------------------------------------------------------------------


  /**
   * @see  com.cmc.credagility.core.domain.score.BaseScore#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((accountNum != null) ? accountNum.hashCode() : 0);
    result = (31 * result) + ((customer != null) ? customer.hashCode() : 0);
    result = (31 * result) + ((effectiveDate != null) ? effectiveDate.hashCode() : 0);
    result = (31 * result) + ((input1 != null) ? input1.hashCode() : 0);
    result = (31 * result) + ((input2 != null) ? input2.hashCode() : 0);
    result = (31 * result) + ((name != null) ? name.hashCode() : 0);
    result = (31 * result) + ((rank != null) ? rank.hashCode() : 0);
    result = (31 * result) + ((reAgeId != null) ? reAgeId.hashCode() : 0);
    result = (31 * result) + ((type != null) ? type.hashCode() : 0);
    result = (31 * result) + ((responsible != null) ? responsible.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account num.
   *
   * @param  accountNum  Account
   */
  public void setAccountNum(Account accountNum) {
    this.accountNum = accountNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for customer.
   *
   * @param  customer  Customer
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for effective date.
   *
   * @param  effectiveDate  Date
   */
  public void setEffectiveDate(Date effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for input1.
   *
   * @param  input1  String
   */
  public void setInput1(String input1) {
    this.input1 = input1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for input2.
   *
   * @param  input2  String
   */
  public void setInput2(String input2) {
    this.input2 = input2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for name.
   *
   * @param  name  String
   */
  public void setName(String name) {
    this.name = name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rank.
   *
   * @param  rank  Integer
   */
  public void setRank(Integer rank) {
    this.rank = rank;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for re age id.
   *
   * @param  reAgeId  Long
   */
  public void setReAgeId(Long reAgeId) {
    this.reAgeId = reAgeId;
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
   * setter method for type.
   *
   * @param  type  String
   */
  public void setType(String type) {
    this.type = type;
  }
} // end class ResponsibleReAge
