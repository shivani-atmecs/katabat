package com.cmc.credagility.core.domain.customer;

import java.math.BigDecimal;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.user.User;


/**
 * Created by tangwei on 1/9/17.
 *
 * @author   <a href="mailto:wei.tang@ozstrategy.com">Wei Tang</a>
 * @version  01/09/2017 16:20
 */
@Entity
@Table(name = "CustomerFinancialStatement")
public class CustomerFinancialStatement extends CreatorEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column protected Integer columnCount;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "statement",
    cascade       = { javax.persistence.CascadeType.ALL },
    orphanRemoval = true
  )
  protected Set<CustomerFinancialStatementDetail> details = new LinkedHashSet<CustomerFinancialStatementDetail>();

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id protected Long id;

  /** TODO: DOCUMENT ME! */
  @Column(name = "jointDisposable")
  protected BigDecimal jointDisposable;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "primaryCustomerId",
    nullable  = false,
    updatable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer primaryCustomer;

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "updatedCustomerInfo",
    length = 150
  )
  protected String updatedCustomerInfo;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof CustomerFinancialStatement)) {
      return false;
    }

    CustomerFinancialStatement that = (CustomerFinancialStatement) obj;

    if (!super.equals(obj)) {
      return false;
    }


    if ((creator != null) ? (!primaryCustomer.equals(that.getCreator())) : (that.getCreator() != null)) {
      return false;
    }

    if ((primaryCustomer != null) ? (!primaryCustomer.equals(that.getPrimaryCustomer()))
                                  : (that.getPrimaryCustomer() != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for column count.
   *
   * @return  Integer
   */
  public Integer getColumnCount() {
    return columnCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for create date.
   *
   * @return  Date
   */
  @Override public Date getCreateDate() {
    return createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for creator.
   *
   * @return  User
   */
  @Override public User getCreator() {
    return creator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for details.
   *
   * @return  Set
   */
  public Set<CustomerFinancialStatementDetail> getDetails() {
    return details;
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
   * getter method for joint disposable.
   *
   * @return  BigDecimal
   */
  public BigDecimal getJointDisposable() {
    return jointDisposable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Customer getPrimaryCustomer() {
    return primaryCustomer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for updated customer info.
   *
   * @return  String
   */
  public String getUpdatedCustomerInfo() {
    return updatedCustomerInfo;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  BaseObject#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((creator != null) ? creator.hashCode() : 0);
    result = (31 * result) + ((primaryCustomer != null) ? primaryCustomer.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for column count.
   *
   * @param  columnCount  Integer
   */
  public void setColumnCount(Integer columnCount) {
    this.columnCount = columnCount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for create date.
   *
   * @param  createDate  Date
   */
  @Override public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for creator.
   *
   * @param  creator  User
   */
  @Override public void setCreator(User creator) {
    this.creator = creator;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for details.
   *
   * @param  details  Set
   */
  public void setDetails(Set<CustomerFinancialStatementDetail> details) {
    this.details = details;
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
   * setter method for joint disposable.
   *
   * @param  jointDisposable  BigDecimal
   */
  public void setJointDisposable(BigDecimal jointDisposable) {
    this.jointDisposable = jointDisposable;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  primaryCustomer  Responsible
   */
  public void setPrimaryCustomer(Customer primaryCustomer) {
    this.primaryCustomer = primaryCustomer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for updated customer info.
   *
   * @param  updatedCustomerInfo  String
   */
  public void setUpdatedCustomerInfo(String updatedCustomerInfo) {
    this.updatedCustomerInfo = updatedCustomerInfo;
  }
} // end class CustomerFinancialStatement
