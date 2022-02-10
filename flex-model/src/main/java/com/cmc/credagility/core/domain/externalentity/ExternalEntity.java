package com.cmc.credagility.core.domain.externalentity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.user.Role;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:qian.liu@ozstrategy.com">Qian Liu</a>
 * @version  10/15/2014 13:26
 */
@Entity
@Table(name = "ExternalEntity")
public class ExternalEntity extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "typeId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ExternalEntityType externalEntityType = new ExternalEntityType();


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** TODO: DOCUMENT ME! */
  @Column(
    name       = "invoiceFrequencyDate",
    length     = 50,
    insertable = true,
    updatable  = true,
    nullable   = true
  )
  protected String invoiceFrequencyDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name       = "invoiceFrequencyType",
    length     = 50,
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  protected String invoiceFrequencyType;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name       = "roleId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @OneToOne(cascade = CascadeType.ALL)
  protected Role role;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "taxId",
    length = 50
  )
  protected String taxId;

  @OneToMany(
    fetch    = FetchType.LAZY,
    mappedBy = "externalEntity",
    cascade  = CascadeType.ALL
  )
  private Set<BillingGroup> billingGroups = new LinkedHashSet<BillingGroup>();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    ExternalEntity that = (ExternalEntity) o;

    if ((externalEntityType != null) ? (!externalEntityType.equals(that.externalEntityType))
                                     : (that.externalEntityType != null)) {
      return false;
    }

    if ((invoiceFrequencyDate != null) ? (!invoiceFrequencyDate.equals(that.invoiceFrequencyDate))
                                       : (that.invoiceFrequencyDate != null)) {
      return false;
    }

    if ((invoiceFrequencyType != null) ? (!invoiceFrequencyType.equals(that.invoiceFrequencyType))
                                       : (that.invoiceFrequencyType != null)) {
      return false;
    }

    if ((role != null) ? (!role.equals(that.role)) : (that.role != null)) {
      return false;
    }

    if ((taxId != null) ? (!taxId.equals(that.taxId)) : (that.taxId != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for billing groups.
   *
   * @return  Set
   */
  public Set<BillingGroup> getBillingGroups() {
    return billingGroups;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for external entity type.
   *
   * @return  ExternalEntityType
   */
  public ExternalEntityType getExternalEntityType() {
    return externalEntityType;
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
   * getter method for invoice frequency date.
   *
   * @return  String
   */
  public String getInvoiceFrequencyDate() {
    return invoiceFrequencyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for invoice frequency type.
   *
   * @return  String
   */
  public String getInvoiceFrequencyType() {
    return invoiceFrequencyType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for role.
   *
   * @return  Role
   */
  public Role getRole() {
    return role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tax id.
   *
   * @return  String
   */
  public String getTaxId() {
    return taxId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((externalEntityType != null) ? externalEntityType.hashCode() : 0);
    result = (31 * result) + ((invoiceFrequencyDate != null) ? invoiceFrequencyDate.hashCode() : 0);
    result = (31 * result) + ((invoiceFrequencyType != null) ? invoiceFrequencyType.hashCode() : 0);
    result = (31 * result) + ((role != null) ? role.hashCode() : 0);
    result = (31 * result) + ((taxId != null) ? taxId.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for billing groups.
   *
   * @param  billingGroups  Set
   */
  public void setBillingGroups(Set<BillingGroup> billingGroups) {
    this.billingGroups = billingGroups;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for external entity type.
   *
   * @param  externalEntityType  ExternalEntityType
   */
  public void setExternalEntityType(ExternalEntityType externalEntityType) {
    this.externalEntityType = externalEntityType;
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
   * setter method for invoice frequency date.
   *
   * @param  invoiceFrequencyDate  String
   */
  public void setInvoiceFrequencyDate(String invoiceFrequencyDate) {
    this.invoiceFrequencyDate = invoiceFrequencyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for invoice frequency type.
   *
   * @param  invoiceFrequencyType  String
   */
  public void setInvoiceFrequencyType(String invoiceFrequencyType) {
    this.invoiceFrequencyType = invoiceFrequencyType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for role.
   *
   * @param  role  Role
   */
  public void setRole(Role role) {
    this.role = role;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tax id.
   *
   * @param  texId  String
   */
  public void setTaxId(String texId) {
    this.taxId = texId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    return "ExternalEntity{"
      + "externalEntityType=" + externalEntityType
      + ", id=" + id
      + ", invoiceFrequencyDate='" + invoiceFrequencyDate + '\''
      + ", invoiceFrequencyType='" + invoiceFrequencyType + '\''
      + ", role=" + role
      + ", taxId=" + taxId
      + '}';
  }
} // end class ExternalEntity
