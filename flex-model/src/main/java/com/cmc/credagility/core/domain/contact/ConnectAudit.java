package com.cmc.credagility.core.domain.contact;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * This class is used to store ConnectAudit information.
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/15/2014 14:11
 */
@Entity
@Table(name = "ConnectAudit")
public class ConnectAudit extends BasePhoneNumberAudit {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -1835635121534661523L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  @Column(name = "connectDate")
  private Date connectDate = new Date();

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new ConnectAudit object.
   */
  public ConnectAudit() { }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for connect date.
   *
   * @return  Date
   */
  public Date getConnectDate() {
    return connectDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for connect date.
   *
   * @param  connectDate  Date
   */
  public void setConnectDate(Date connectDate) {
    this.connectDate = connectDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    return "ConnectAudit{"
      + "id=" + id
      + ", activity=" + activity
      + ", phoneNum='" + phoneNum + '\''
      + ", account=" + account
      + ", connectDate=" + connectDate
      + ", callType=" + callType
      + '}';
  }
} // end class ConnectAudit
