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


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 11:19
 */
@Entity
@Table(
  name              = "IvrChannelResultDestination",
  uniqueConstraints = { @UniqueConstraint(columnNames = { "channelResultId", "phoneId" }) }
)
public class IvrChannelResultDestination extends PhoneChannelResultDestination {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** PK. */
  @Column(
    name     = "id",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long id;


  /** Ivr Channel Result. */
  @JoinColumn(
    name     = "channelResultId",
    nullable = false
  )
  @ManyToOne(fetch = FetchType.LAZY)
  IvrChannelResult channelResult;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
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

    final IvrChannelResultDestination other = (IvrChannelResultDestination) obj;

    if (channelResult == null) {
      if (other.getChannelResult() != null) {
        return false;
      }
    } else if (!channelResult.equals(
            other.getChannelResult())) {
      return false;
    }

    if (phone == null) {
      if (other.getPhone() != null) {
        return false;
      }
    } else if (!phone.equals(
            other.getPhone())) {
      return false;
    }

    if (id == null) {
      if (other.getId() != null) {
        return false;
      }
    } else if (!id.equals(other.getId())) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel result.
   *
   * @return  IvrChannelResult
   */
  public IvrChannelResult getChannelResult() {
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
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();
    result = (prime * result)
      + ((this.phone == null) ? 0 : phone.hashCode())
      + ((this.channelResult == null) ? 0 : channelResult.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel result.
   *
   * @param  channelResult  IvrChannelResult
   */
  public void setChannelResult(IvrChannelResult channelResult) {
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
} // end class IvrChannelResultDestination
