package com.cmc.credagility.core.domain.channel;

import javax.persistence.CascadeType;
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


/**
 * This class is used to store actual address where the letter has ben sent by cmc letter vendor.
 *
 * <p><a href="LetterChannelVerifiedAddress.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 10:38
 */
@Entity
@Table(
  name    = "LetterChannelVerifiedAddress",
  indexes = {
    @Index(
      name = "postalCodeIndex",
      columnList = "postalCode"
    )
  }
)
public class LetterChannelVerifiedAddress extends BaseEntity {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6982090216591627060L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** Address. */
  @Embedded protected Address address = new Address();


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "letterResultActualId",
    updatable = false
  )
  @ManyToOne(cascade = CascadeType.ALL)
  protected LetterChannelActualResult letterChannelActualResult;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "letterChannelVerifiedAddressId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long letterChannelVerifiedAddressId;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "mailingDate",
    length = 50
  )
  protected String mailingDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "moveType",
    length = 20
  )
  protected String moveType;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "returnCode",
    length = 20
  )
  protected String returnCode;

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

    final LetterChannelVerifiedAddress other = (LetterChannelVerifiedAddress) obj;

    if (address == null) {
      if (other.getAddress() != null) {
        return false;
      }
    } else if (!address.equals(other.getAddress())) {
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
   * getter method for letter channel actual result.
   *
   * @return  LetterChannelActualResult
   */
  public LetterChannelActualResult getLetterChannelActualResult() {
    return letterChannelActualResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for letter channel verified address id.
   *
   * @return  Long
   */
  public Long getLetterChannelVerifiedAddressId() {
    return letterChannelVerifiedAddressId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for mailing date.
   *
   * @return  String
   */
  public String getMailingDate() {
    return mailingDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for move type.
   *
   * @return  String
   */
  public String getMoveType() {
    return moveType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for return code.
   *
   * @return  String
   */
  public String getReturnCode() {
    return returnCode;
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
   * setter method for letter channel actual result.
   *
   * @param  letterChannelActualResult  LetterChannelActualResult
   */
  public void setLetterChannelActualResult(LetterChannelActualResult letterChannelActualResult) {
    this.letterChannelActualResult = letterChannelActualResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for letter channel verified address id.
   *
   * @param  letterChannelVerifiedAddressId  Long
   */
  public void setLetterChannelVerifiedAddressId(Long letterChannelVerifiedAddressId) {
    this.letterChannelVerifiedAddressId = letterChannelVerifiedAddressId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for mailing date.
   *
   * @param  mailingDate  String
   */
  public void setMailingDate(String mailingDate) {
    this.mailingDate = mailingDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for move type.
   *
   * @param  moveType  String
   */
  public void setMoveType(String moveType) {
    this.moveType = moveType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for return code.
   *
   * @param  returnCode  String
   */
  public void setReturnCode(String returnCode) {
    this.returnCode = returnCode;
  }
} // end class LetterChannelVerifiedAddress
