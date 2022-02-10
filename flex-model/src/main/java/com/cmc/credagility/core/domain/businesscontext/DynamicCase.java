package com.cmc.credagility.core.domain.businesscontext;

import com.cmc.credagility.core.domain.base.CreatorEntity;
import com.cmc.credagility.core.domain.customer.Customer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.li@ozstrategy.com">Hao Li</a>
 * @version  10/15/2014 11:47
 */
@Entity public class DynamicCase extends CreatorEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 7302241909472199079L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    mappedBy = "dynamicCase",
    cascade  = { CascadeType.PERSIST, CascadeType.MERGE }
  )
  protected Set<BusinessContextInstance> businessContextInstanceSet = new HashSet<BusinessContextInstance>();

  /** TODO: DOCUMENT ME! */
  @Column(
    unique = true,
    length = 255
  )
  protected String caseNumber;

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "customerId",
    nullable   = true,
    updatable  = true,
    insertable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Customer customer;

  /** TODO: DOCUMENT ME! */
  @Column(
    unique = true,
    length = 255
  )
  protected String   externalRefNumber;

  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof DynamicCase)) {
      return false;
    }

    DynamicCase aCase = (DynamicCase) o;

    if ((caseNumber != null) ? (!caseNumber.equals(aCase.caseNumber)) : (aCase.caseNumber != null)) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for business context instance set.
   *
   * @return  Set
   */
  public Set<BusinessContextInstance> getBusinessContextInstanceSet() {
    return businessContextInstanceSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for case number.
   *
   * @return  String
   */
  public String getCaseNumber() {
    return caseNumber;
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
   * getter method for external ref number.
   *
   * @return  String
   */
  public String getExternalRefNumber() {
    return externalRefNumber;
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = 31;
    result = (31 * result) + ((caseNumber != null) ? caseNumber.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for business context instance set.
   *
   * @param  businessContextInstanceSet  Set
   */
  public void setBusinessContextInstanceSet(Set<BusinessContextInstance> businessContextInstanceSet) {
    this.businessContextInstanceSet = businessContextInstanceSet;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for case number.
   *
   * @param  caseNumber  String
   */
  public void setCaseNumber(String caseNumber) {
    this.caseNumber = caseNumber;
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
   * setter method for external ref number.
   *
   * @param  externalRefNumber  String
   */
  public void setExternalRefNumber(String externalRefNumber) {
    this.externalRefNumber = externalRefNumber;
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
   * @see  com.cmc.credagility.core.domain.base.CreatorEntity#toString()
   */
  @Override public String toString() {
    return "Case{"
      + "id=" + id
      + ", caseNumber='" + caseNumber + '\''
      + '}';
  }
} // end class DynamicCase
