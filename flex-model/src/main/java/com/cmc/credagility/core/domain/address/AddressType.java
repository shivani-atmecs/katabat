package com.cmc.credagility.core.domain.address;

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
import com.cmc.credagility.core.domain.contact.ContactType;


/**
 * This class is used to store Address Type information.
 *
 * <p><a href="AddressType.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/17/2014 10:09
 */
@Entity
@Table(
  name              = "AddressType",
  uniqueConstraints = { @UniqueConstraint(columnNames = "name") },
  indexes           = {
    @Index(
      name          = "name_2",
      columnList    = "name",
      unique        = true
    ),
    @Index(
      name          = "idx_clientAddressTypeAlias",
      columnList    = "clientAddressTypeAlias"
    )
  }
)
public class AddressType extends BaseEntity implements Serializable, ContactType {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 0L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "clientAddressTypeAlias",
    length = 255
  )
  protected String clientAddressTypeAlias;

  /** Phone Type Name. */
  @Column(
    name   = "name",
    length = 30,
    unique = true
  )
  protected String name;


  /** TODO: DOCUMENT ME! */
  @Column(name = "priority")
  protected Integer priority;

  // npelleti, 07/30, USBank, Removed unique constraint
  /** Phone Type PK. */
  @Column(
    name     = "typeId", /*unique = true,*/
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long typeId;

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new AddressType object.
   */
  public AddressType() {
    super();
  }

  /**
   * Creates a new AddressType object.
   *
   * @param  typeId  $param.type$
   * @param  name    $param.type$
   */
  public AddressType(Long typeId, String name) {
    super();
    this.typeId = typeId;
    this.name   = name;
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * deepCopy.
   *
   * @param  type  $param.type$
   */
  public void deepCopy(AddressType type) {
    if (type != null) {
      this.typeId = type.getTypeId();
      this.name   = type.getName();
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    final AddressType other = (AddressType) obj;

    if (this.name == null) {
      if (other.getName() != null) {
        return false;
      }
    } else if (!this.name.equals(other.getName())) {
      return false;
    }

    return true;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client address type alias.
   *
   * @return  String
   */
  public String getClientAddressTypeAlias() {
    return clientAddressTypeAlias;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The name.
   *
   * @return  the name
   */
  public String getName() {
    return this.name;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Integer.
   *
   * @return  Integer.
   */
  public Integer getPriority() {
    return priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see com.cmc.credagility.ContactType#getTypeCode()
   */
  @Override public String getTypeCode() {
    return getClass().getSimpleName() + this.typeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * The typeId.
   *
   * @return  the typeId
   */
  public Long getTypeId() {
    return this.typeId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    final int PRIME  = 31;
    int       result = 1;
    result = (PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client address type alias.
   *
   * @param  clientAddressTypeAlias  String
   */
  public void setClientAddressTypeAlias(String clientAddressTypeAlias) {
    this.clientAddressTypeAlias = clientAddressTypeAlias;
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
   * setPriority.
   *
   * @param  priority  $param.type$
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setTypeId.
   *
   * @param  typeId  the typeId to set
   */
  public void setTypeId(Long typeId) {
    this.typeId = typeId;
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

    retValue.append("AddressType ( ").append(super.toString()).append(TAB).append("name = ").append(this.name).append(
      TAB).append("typeId = ").append(this.typeId).append(TAB).append(" )");

    return retValue.toString();
  }
} // end class AddressType
