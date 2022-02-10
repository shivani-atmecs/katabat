package com.cmc.credagility.core.domain.contact;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * This class is used to store ContactResultAudit information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 11:20
 */
@Entity
@Table(name = "ContactResultAudit")
public class ContactResultAudit extends BasePhoneNumberAudit {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -7890945465720007251L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Contact result. Refers {@link ContactResult} */
  @JoinColumn(
    name       = "contactResultId",
    insertable = true,
    updatable  = false,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.EAGER)
  protected ContactResult contactResult;


  /** Phone type. Refers {@link PhoneType} */
  @JoinTable(
    name               = "ContactResultAuditPhoneTypes",
    indexes            = { @Index(columnList = "auditId") },
    joinColumns        = {
      @JoinColumn(
        name           = "auditId",
        nullable       = false,
        updatable      = false
      )
    },
    inverseJoinColumns = {
      @JoinColumn(
        name           = "phoneTypeId",
        nullable       = false,
        updatable      = false
      )
    }
  )
  @ManyToMany(
    fetch   = FetchType.LAZY,
    cascade = { CascadeType.PERSIST, CascadeType.MERGE }
  )
  protected Set<PhoneType> phoneTypes = new HashSet<PhoneType>();

  @Column(
    name     = "contactDate",
    nullable = false
  )
  private Date contactDate = new Date();

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   o  Object
   *
   * @return  boolean
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof ContactResultAudit)) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    ContactResultAudit that = (ContactResultAudit) o;

    if ((contactDate != null) ? (!contactDate.equals(that.contactDate)) : (that.contactDate != null)) {
      return false;
    }

    if ((contactResult != null) ? (!contactResult.equals(that.contactResult)) : (that.contactResult != null)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact date.
   *
   * @return  Date
   */
  public Date getContactDate() {
    return contactDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for contact result.
   *
   * @return  ContactResult
   */
  public ContactResult getContactResult() {
    return contactResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for phone types.
   *
   * @return  Set
   */
  public Set<PhoneType> getPhoneTypes() {
    return phoneTypes;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((contactResult != null) ? contactResult.hashCode() : 0);
    result = (31 * result) + ((contactDate != null) ? contactDate.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact date.
   *
   * @param  contactDate  Date
   */
  public void setContactDate(Date contactDate) {
    this.contactDate = contactDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for contact result.
   *
   * @param  contactResult  ContactResult
   */
  public void setContactResult(ContactResult contactResult) {
    this.contactResult = contactResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for phone types.
   *
   * @param  phoneTypes  Set
   */
  public void setPhoneTypes(Set<PhoneType> phoneTypes) {
    this.phoneTypes = phoneTypes;
  }
} // end class ContactResultAudit
