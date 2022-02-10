package com.cmc.credagility.core.domain.tsys;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:chenglong.du@ozstrategy.com">Chenglong Du</a>
 * @version  10/16/2014 09:25
 */
@Entity
@Table(name = "TsysMemo")
public class TsysMemo extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = 3960685759506336187L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "accountNum",
    unique   = false,
    nullable = false
  )
  @ManyToOne protected Account account;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "collectorNum",
    length = 255
  )
  protected String collectorNum;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "message1",
    length = 255
  )
  protected String message1;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "message2",
    length = 255
  )
  protected String message2;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "message3",
    length = 255
  )
  protected String message3;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "message4",
    length = 255
  )
  protected String message4;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "message5",
    length = 255
  )
  protected String message5;


  /** TODO: DOCUMENT ME! */
  @Column(name = "messageDate")
  protected Date messageDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "sequenceNumber")
  protected Integer sequenceNumber;


  /** TODO: DOCUMENT ME! */
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long tsysMemoId;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#equals(java.lang.Object)
   */
  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    TsysMemo other = (TsysMemo) o;

    if (account == null) {
      if (other.account != null) {
        return false;
      }
    } else if (!account.equals(other.account)) {
      return false;
    }

    if (message1 == null) {
      if (other.message1 != null) {
        return false;
      }
    } else if (!message1.equals(other.message1)) {
      return false;
    }

    if (message2 == null) {
      if (other.message2 != null) {
        return false;
      }
    } else if (!message2.equals(other.message2)) {
      return false;
    }

    if (message3 == null) {
      if (other.message3 != null) {
        return false;
      }
    } else if (!message3.equals(other.message3)) {
      return false;
    }

    if (message4 == null) {
      if (other.message4 != null) {
        return false;
      }
    } else if (!message4.equals(other.message4)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for collector num.
   *
   * @return  String
   */
  public String getCollectorNum() {
    return collectorNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message1.
   *
   * @return  String
   */
  public String getMessage1() {
    return message1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message2.
   *
   * @return  String
   */
  public String getMessage2() {
    return message2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message3.
   *
   * @return  String
   */
  public String getMessage3() {
    return message3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message4.
   *
   * @return  String
   */
  public String getMessage4() {
    return message4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message5.
   *
   * @return  String
   */
  public String getMessage5() {
    return message5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for message date.
   *
   * @return  Date
   */
  public Date getMessageDate() {
    return messageDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for sequence number.
   *
   * @return  Integer
   */
  public Integer getSequenceNumber() {
    return sequenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for tsys memo id.
   *
   * @return  Long
   */
  public Long getTsysMemoId() {
    return tsysMemoId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    int result = super.hashCode();
    result = (31 * result) + ((tsysMemoId != null) ? tsysMemoId.hashCode() : 0);
    result = (31 * result) + ((account != null) ? account.hashCode() : 0);
    result = (31 * result) + ((message1 != null) ? message1.hashCode() : 0);
    result = (31 * result) + ((message2 != null) ? message2.hashCode() : 0);
    result = (31 * result) + ((message3 != null) ? message3.hashCode() : 0);
    result = (31 * result) + ((message4 != null) ? message4.hashCode() : 0);
    result = (31 * result) + ((message5 != null) ? message5.hashCode() : 0);

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for collector num.
   *
   * @param  collectorNum  String
   */
  public void setCollectorNum(String collectorNum) {
    this.collectorNum = collectorNum;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message1.
   *
   * @param  message1  String
   */
  public void setMessage1(String message1) {
    this.message1 = message1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message2.
   *
   * @param  message2  String
   */
  public void setMessage2(String message2) {
    this.message2 = message2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message3.
   *
   * @param  message3  String
   */
  public void setMessage3(String message3) {
    this.message3 = message3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message4.
   *
   * @param  message4  String
   */
  public void setMessage4(String message4) {
    this.message4 = message4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message5.
   *
   * @param  message5  String
   */
  public void setMessage5(String message5) {
    this.message5 = message5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for message date.
   *
   * @param  messageDate  Date
   */
  public void setMessageDate(Date messageDate) {
    this.messageDate = messageDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for sequence number.
   *
   * @param  sequenceNumber  Integer
   */
  public void setSequenceNumber(Integer sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for tsys memo id.
   *
   * @param  tsysMemoId  Long
   */
  public void setTsysMemoId(Long tsysMemoId) {
    this.tsysMemoId = tsysMemoId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  java.lang.Object#toString()
   */
  @Override public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("TsysMemo");
    sb.append("{account=").append(account);
    sb.append(super.toString());
    sb.append('}');

    return sb.toString();
  }
} // end class TsysMemo
