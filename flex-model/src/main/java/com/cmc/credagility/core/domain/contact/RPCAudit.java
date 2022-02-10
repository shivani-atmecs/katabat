package com.cmc.credagility.core.domain.contact;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * This class is used to store RPCAudit information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 10:44
 */
@Entity
@Table(name = "RPCAudit")
public class RPCAudit extends BasePhoneNumberAudit {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 6842930645932094427L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(name = "rpcDate")
  private Date rpcDate = new Date();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new RPCAudit object.
   */
  public RPCAudit() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for rpc date.
   *
   * @return  Date
   */
  public Date getRpcDate() {
    return rpcDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rpc date.
   *
   * @param  rpcDate  Date
   */
  public void setRpcDate(Date rpcDate) {
    this.rpcDate = rpcDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.contact.BasePhoneNumberAudit#toString()
   */
  @Override public String toString() {
    return "RPCAudit{"
      + "id=" + this.id
      + ", activity=" + activity
      + ", phoneNum='" + phoneNum + '\''
      + ", account=" + account
      + ", rpcDate=" + rpcDate
      + ", callType=" + callType
      + '}';
  }
} // end class RPCAudit
