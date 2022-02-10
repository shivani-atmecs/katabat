package com.cmc.credagility.core.domain.client;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.domain.type.InfoSource;


/**
 * This class is used to store Attorney information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 15:38
 */
@Entity
@Table(
  name    = "Attorney",
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
public class Attorney extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 154756887L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Embedded private Address address = new Address();

  // npelleti, 07/30, USBank, Remove unique constraint
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id private Long         attorneyId;

  @Column(
    name   = "defendantAttorneyCode",
    length = 4
  )
  private String defendantAttorneyCode;
  @Column(name = "entryDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date   entryDate;

  @Column(
    name   = "faxNum",
    length = 20
  )
  private String faxNum;

  // npelleti, 07/30, USBank, Added NotNull Annotation
  @Column(
    name     = "infoSource",
    length   = 8,
    nullable = false
  )
  @Enumerated(value = EnumType.STRING)
  private InfoSource infoSource;

  @Column(
    name     = "name",
    length   = 145,
    nullable = false
  )
  private String name;

  // npelleti, 07/30, USBank, Added Annotation, Var, get/Set methods
  /** DOCUMENT ME! */
  @Column(
    name       = "postalCode",
    length     = 15,
    insertable = false,
    updatable  = false
  )
  protected String    postalCode  = "";
  @Column(
    name                          = "phoneNum",
    length                        = 20
  )
  private String      phoneNum;
  @OneToOne(mappedBy = "attorney")
  private Responsible responsible;

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

    final Attorney other = (Attorney) obj;

    if (address == null) {
      if (other.address != null) {
        return false;
      }
    } else if (!address.equals(other.address)) {
      return false;
    }

    if (defendantAttorneyCode == null) {
      if (other.defendantAttorneyCode != null) {
        return false;
      }
    } else if (!defendantAttorneyCode.equals(other.defendantAttorneyCode)) {
      return false;
    }

    if (faxNum == null) {
      if (other.faxNum != null) {
        return false;
      }
    } else if (!faxNum.equals(other.faxNum)) {
      return false;
    }

    if (infoSource == null) {
      if (other.infoSource != null) {
        return false;
      }
    } else if (!infoSource.equals(other.infoSource)) {
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
   * getter method for attorney id.
   *
   * @return  Long
   */
  public Long getAttorneyId() {
    return attorneyId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for defendant attorney code.
   *
   * @return  String
   */
  public String getDefendantAttorneyCode() {
    return defendantAttorneyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for entry date.
   *
   * @return  Date
   */
  public Date getEntryDate() {
    return entryDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for fax num.
   *
   * @return  String
   */
  public String getFaxNum() {
    return faxNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for info source.
   *
   * @return  InfoSource
   */
  public InfoSource getInfoSource() {
    return infoSource;
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
   * hashCode.
   *
   * @return  int
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result) + ((address == null) ? 0 : address.hashCode());
    result = (prime
        * result)
      + ((defendantAttorneyCode == null) ? 0 : defendantAttorneyCode.hashCode());
    result = (prime * result) + ((faxNum == null) ? 0 : faxNum.hashCode());
    result = (prime * result)
      + ((infoSource == null) ? 0 : infoSource.hashCode());
    result = (prime * result) + ((name == null) ? 0 : name.hashCode());
    result = (prime * result) + ((phoneNum == null) ? 0 : phoneNum.hashCode());

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
   * setter method for attorney id.
   *
   * @param  attorneyId  Long
   */
  public void setAttorneyId(Long attorneyId) {
    this.attorneyId = attorneyId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for defendant attorney code.
   *
   * @param  defendantAttorneyCode  String
   */
  public void setDefendantAttorneyCode(String defendantAttorneyCode) {
    this.defendantAttorneyCode = defendantAttorneyCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for entry date.
   *
   * @param  entryDate  Date
   */
  public void setEntryDate(Date entryDate) {
    this.entryDate = entryDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for fax num.
   *
   * @param  faxNum  String
   */
  public void setFaxNum(String faxNum) {
    this.faxNum = faxNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for info source.
   *
   * @param  infoSource  InfoSource
   */
  public void setInfoSource(InfoSource infoSource) {
    this.infoSource = infoSource;
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
   * Constructs a <code>String</code> with all attributes in name = value format.
   *
   * @return  a <code>String</code> representation of this object.
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "Attorney ( " + super.toString() + TAB + "attorneyId = "
      + this.attorneyId + TAB + "address = " + this.address + TAB
      + "phoneNum = " + this.phoneNum + TAB + "faxNum = " + this.faxNum + TAB
      + "name = " + this.name + TAB + "defendantAttorneyCode = "
      + this.defendantAttorneyCode + TAB + "entryDate = " + this.entryDate
      + TAB + "infoSource = " + this.infoSource + TAB + " )";

    return retValue;
  }

} // end class Attorney
