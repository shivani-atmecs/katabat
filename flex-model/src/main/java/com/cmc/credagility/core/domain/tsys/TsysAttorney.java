package com.cmc.credagility.core.domain.tsys;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 17:26
 */
@Entity
@Table(
  name    = "TsysAttorney",
  indexes = {
    @Index(
      name = "postalCodeIndex",
      columnList = "postalCode"
    ), @Index(
      name = "postalCodeIndex",
      columnList = "postalCode"
    )
  }
)
public class TsysAttorney extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  public static final String ATTORNEY_TYPE_CLIENT = "CLIENT";

  /** TODO: DOCUMENT ME! */
  public static final String ATTORNEY_TYPE_EXECUTOR = "EXECUTOR";

  /** TODO: DOCUMENT ME! */
  public static final String ATTORNEY_TYPE_CUSTOMER = "CUSTOMER";

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Embedded private Address address = new Address();


  @Column(
    name     = "name",
    length   = 145,
    nullable = false
  )
  private String name;

  /** TODO: DOCUMENT ME! */
  @Column(
    name       = "postalCode",
    length     = 15,
    insertable = false,
    updatable  = false
  )
  protected String postalCode = "";

  @Column(
    name   = "phoneNum",
    length = 20
  )
  private String phoneNum;

  @JoinColumn(
    name     = "responsibleId",
    nullable = false
  )
  @ManyToOne private Responsible responsible;

  @GeneratedValue(strategy = IDENTITY)
  @Id private Long tsysAttorneyId;

  @Column(
    name   = "type",
    length = 20
  )
  private String type;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * equals.
   *
   * @param   obj  Object
   *
   * @return  boolean
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

    final TsysAttorney other = (TsysAttorney) obj;

    if (type == null) {
      if (other.type != null) {
        return false;
      }
    } else if (!type.equals(other.type)) {
      return false;
    }

    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }

    if (phoneNum == null) {
      if (other.phoneNum != null) {
        return false;
      }
    } else if (!phoneNum.equals(other.phoneNum)) {
      return false;
    }

    if (postalCode == null) {
      if (other.postalCode != null) {
        return false;
      }
    } else if (!postalCode.equals(other.postalCode)) {
      return false;
    }

    if (responsible == null) {
      if (other.responsible != null) {
        return false;
      }
    } else if (!responsible.equals(other.responsible)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for address.
   *
   * @return  Address
   */
  public Address getAddress() {
    return address;
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
   * getter method for phone num.
   *
   * @return  String
   */
  public String getPhoneNum() {
    return phoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for postal code.
   *
   * @return  String
   */
  public String getPostalCode() {
    return postalCode;
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
   * getter method for tsys attorney id.
   *
   * @return  Long
   */
  public Long getTsysAttorneyId() {
    return tsysAttorneyId;
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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result) + ((tsysAttorneyId == null) ? 0 : tsysAttorneyId.hashCode());
    result = (prime * result) + ((responsible == null) ? 0 : responsible.hashCode());
    result = (prime * result) + ((address == null) ? 0 : address.hashCode());
    result = (prime * result) + ((name == null) ? 0 : name.hashCode());
    result = (prime * result) + ((phoneNum == null) ? 0 : phoneNum.hashCode());
    result = (prime * result) + ((postalCode == null) ? 0 : postalCode.hashCode());
    result = (prime * result) + ((type == null) ? 0 : type.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for address.
   *
   * @param  address  Address
   */
  public void setAddress(Address address) {
    this.address = address;
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
   * setter method for phone num.
   *
   * @param  phoneNum  String
   */
  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for postal code.
   *
   * @param  postalCode  String
   */
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
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
   * setter method for tsys attorney id.
   *
   * @param  tsysAttorneyId  Long
   */
  public void setTsysAttorneyId(Long tsysAttorneyId) {
    this.tsysAttorneyId = tsysAttorneyId;
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

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB      = "    ";
    String       retValue = "Attorney(" + super.toString() + TAB + "attorneyId = " + this.tsysAttorneyId + TAB
      + "type = " + this.type + TAB + "responsible = " + this.responsible + " )";

    return retValue;
  }


} // end class TsysAttorney
