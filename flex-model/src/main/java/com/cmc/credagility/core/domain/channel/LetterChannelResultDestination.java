package com.cmc.credagility.core.domain.channel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.contact.ContactAddress;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 10:42
 */
@Entity
@Table(
  name              = "LetterChannelResultDestination",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "channelResultId", "addressId" }) }
)
public class LetterChannelResultDestination extends BaseEntity {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** pk. */
  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** address. */
  @JoinColumn(
    name     = "addressId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  ContactAddress address;


  /** channel result. */
  @JoinColumn(
    name     = "channelResultId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  LetterChannelResult channelResult;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for address.
   *
   * @return  ContactAddress
   */
  public ContactAddress getAddress() {
    return address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel result.
   *
   * @return  LetterChannelResult
   */
  public LetterChannelResult getChannelResult() {
    return channelResult;
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
   * setter method for address.
   *
   * @param  address  ContactAddress
   */
  public void setAddress(ContactAddress address) {
    this.address = address;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel result.
   *
   * @param  channelResult  LetterChannelResult
   */
  public void setChannelResult(LetterChannelResult channelResult) {
    this.channelResult = channelResult;
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
} // end class LetterChannelResultDestination
