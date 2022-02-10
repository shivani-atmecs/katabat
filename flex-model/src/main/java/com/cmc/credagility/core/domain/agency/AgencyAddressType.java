package com.cmc.credagility.core.domain.agency;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.address.AddressType;
import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * Workable address under agency context.
 *
 * @author   <a href="mailto:yang.wang@ozstrategy.com">Yang Wang</a>
 * @version  10/14/2014 17:24 PM
 */
@Entity
@Table(
  name              = "AgencyAddressType",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "addressTypeId" }) }
)
public class AgencyAddressType extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -727987644628760877L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** address type. */
  @JoinColumn(
    name       = "addressTypeId",
    insertable = true,
    updatable  = true,
    nullable   = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  private AddressType addressType;

  /** PK, identity property. */
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long id;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for address type.
   *
   * @return  AddressType
   */
  public AddressType getAddressType() {
    return addressType;
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
   * setter method for address type.
   *
   * @param  addressType  AddressType
   */
  public void setAddressType(AddressType addressType) {
    this.addressType = addressType;
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
} // end class AgencyAddressType
