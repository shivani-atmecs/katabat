package com.cmc.credagility.core.domain.channel;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 10:14
 */
@Entity
@Table(
  name    = "SecurePdfChannelActualResult",
  indexes =
    @Index(
      name = "uniqueSessionIdIndex",
      columnList = "uniqueSessionId"
    )
)
public class SecurePdfChannelActualResult extends BaseChannelActualResult {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @Column(name = "balance")
  protected BigDecimal balance;

  /** Import batch job Id. */
  @Column(name = "batchId")
  protected Long batchId;


  /** TODO: DOCUMENT ME! */
  @Column(name = "bucketAmount1")
  protected BigDecimal bucketAmount1;

  /** bucket amount 2. */
  @Column(name = "bucketAmount2")
  protected BigDecimal bucketAmount2;

  /** bucket amount 3. */
  @Column(name = "bucketAmount3")
  protected BigDecimal bucketAmount3;

  /** bucket amount 4. */
  @Column(name = "bucketAmount4")
  protected BigDecimal bucketAmount4;

  /** bucket amount 5. */
  @Column(name = "bucketAmount5")
  protected BigDecimal bucketAmount5;

  /** bucket amount 6. */
  @Column(name = "bucketAmount6")
  protected BigDecimal bucketAmount6;


  /** TODO: DOCUMENT ME! */
  @Column(name = "bucketAmount7")
  protected BigDecimal bucketAmount7;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "channelActualResultId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long channelActualResultId;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "channelResultId",
    updatable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected SecurePdfChannelResult channelResult;

  /** Account current due. */
  @Column(name = "currentDue")
  protected BigDecimal currentDue;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data1",
    length = 100
  )
  protected String data1;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data10",
    length = 100
  )
  protected String data10;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data11",
    length = 100
  )
  protected String data11;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data12",
    length = 100
  )
  protected String data12;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data13",
    length = 100
  )
  protected String data13;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data14",
    length = 100
  )
  protected String data14;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data15",
    length = 100
  )
  protected String data15;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data2",
    length = 100
  )
  protected String data2;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data3",
    length = 100
  )
  protected String data3;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data4",
    length = 100
  )
  protected String data4;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data5",
    length = 130
  )
  protected String data5;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data6",
    length = 100
  )
  protected String data6;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data7",
    length = 100
  )
  protected String data7;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data8",
    length = 100
  )
  protected String data8;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data9",
    length = 100
  )
  protected String data9;


  /** TODO: DOCUMENT ME! */
  @Column(name = "delinquencyStage")
  protected Integer delinquencyCycle;


  /** TODO: DOCUMENT ME! */
  @Column(name = "delinquencyDays")
  protected Integer delinquencyDays;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "emailAddress",
    length = 80
  )
  protected String emailAddress;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "firstName",
    length = 45
  )
  protected String firstName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "lastName",
    length = 45
  )
  protected String lastName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "middleInitial",
    length = 45
  )
  protected String middleInitial;


  /** TODO: DOCUMENT ME! */
  @Column(name = "pastDue")
  protected BigDecimal pastDue;


  /** TODO: DOCUMENT ME! */
  @Column(name = "paymentCreateDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date paymentCreateDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "placementDate")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date placementDate;


  /** TODO: DOCUMENT ME! */
  @Column(name = "programAmount")
  protected BigDecimal programAmount;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "programExtra",
    length = 45
  )
  protected String programExtra;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "programName",
    length = 45
  )
  protected String programName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "salutation",
    length = 10
  )
  protected String salutation;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "title",
    length = 10
  )
  protected String title;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.BaseChannelActualResult#equals(java.lang.Object)
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

    final SecurePdfChannelActualResult other = (SecurePdfChannelActualResult) obj;

    if (this.emailAddress == null) {
      if (other.emailAddress != null) {
        return false;
      }
    } else if (!this.emailAddress.equals(other.emailAddress)) {
      return false;
    }

    if (this.template == null) {
      if (other.template != null) {
        return false;
      }
    } else if (!this.template.equals(other.template)) {
      return false;
    }

    if (this.data6 == null) {
      if (other.data6 != null) {
        return false;
      }
    } else if (!this.data6.equals(other.data6)) {
      return false;
    }

    if (this.data7 == null) {
      if (other.data7 != null) {
        return false;
      }
    } else if (!this.data7.equals(other.data7)) {
      return false;
    }

    if (this.strategyDate == null) {
      if (other.strategyDate != null) {
        return false;
      }
    } else if (!this.strategyDate.equals(other.strategyDate)) {
      return false;
    }

    if (this.paymentCreateDate == null) {
      if (other.paymentCreateDate != null) {
        return false;
      }
    } else if (!this.paymentCreateDate.equals(other.paymentCreateDate)) {
      return false;
    }

    return true;
  } // end method equals

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for balance.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBalance() {
    return balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for batch id.
   *
   * @return  Long
   */
  public Long getBatchId() {
    return batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount1.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount1() {
    return bucketAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount2.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount2() {
    return bucketAmount2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount3.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount3() {
    return bucketAmount3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount4.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount4() {
    return bucketAmount4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount5.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount5() {
    return bucketAmount5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount6.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount6() {
    return bucketAmount6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for bucket amount7.
   *
   * @return  BigDecimal
   */
  public BigDecimal getBucketAmount7() {
    return bucketAmount7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel actual result id.
   *
   * @return  Long
   */
  public Long getChannelActualResultId() {
    return channelActualResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for channel result.
   *
   * @return  SecurePdfChannelResult
   */
  public SecurePdfChannelResult getChannelResult() {
    return channelResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for current due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getCurrentDue() {
    return currentDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data1.
   *
   * @return  String
   */
  public String getData1() {
    return data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data10.
   *
   * @return  String
   */
  public String getData10() {
    return data10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data11.
   *
   * @return  String
   */
  public String getData11() {
    return data11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data12.
   *
   * @return  String
   */
  public String getData12() {
    return data12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data13.
   *
   * @return  String
   */
  public String getData13() {
    return data13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data14.
   *
   * @return  String
   */
  public String getData14() {
    return data14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data15.
   *
   * @return  String
   */
  public String getData15() {
    return data15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data2.
   *
   * @return  String
   */
  public String getData2() {
    return data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data3.
   *
   * @return  String
   */
  public String getData3() {
    return data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data4.
   *
   * @return  String
   */
  public String getData4() {
    return data4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data5.
   *
   * @return  String
   */
  public String getData5() {
    return data5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data6.
   *
   * @return  String
   */
  public String getData6() {
    return data6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data7.
   *
   * @return  String
   */
  public String getData7() {
    return data7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data8.
   *
   * @return  String
   */
  public String getData8() {
    return data8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data9.
   *
   * @return  String
   */
  public String getData9() {
    return data9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquency cycle.
   *
   * @return  Integer
   */
  public Integer getDelinquencyCycle() {
    return delinquencyCycle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for delinquency days.
   *
   * @return  Integer
   */
  public Integer getDelinquencyDays() {
    return delinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email address.
   *
   * @return  String
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first name.
   *
   * @return  String
   */
  public String getFirstName() {
    return firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last name.
   *
   * @return  String
   */
  public String getLastName() {
    return lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for middle initial.
   *
   * @return  String
   */
  public String getMiddleInitial() {
    return middleInitial;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for past due.
   *
   * @return  BigDecimal
   */
  public BigDecimal getPastDue() {
    return pastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for payment create date.
   *
   * @return  Date
   */
  public Date getPaymentCreateDate() {
    return paymentCreateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for placement date.
   *
   * @return  Date
   */
  public Date getPlacementDate() {
    return placementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program amount.
   *
   * @return  BigDecimal
   */
  public BigDecimal getProgramAmount() {
    return programAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program extra.
   *
   * @return  String
   */
  public String getProgramExtra() {
    return programExtra;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for program name.
   *
   * @return  String
   */
  public String getProgramName() {
    return programName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for salutation.
   *
   * @return  String
   */
  public String getSalutation() {
    return salutation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for title.
   *
   * @return  String
   */
  public String getTitle() {
    return title;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.BaseChannelActualResult#hashCode()
   */
  @Override public int hashCode() {
    final int prime  = 31;
    int       result = super.hashCode();

    result = (prime * result)
      + ((this.emailAddress == null) ? 0 : this.emailAddress.hashCode());
    result = (prime * result)
      + ((this.template == null) ? 0 : this.template.hashCode());
    result = (prime * result)
      + ((this.data6 == null) ? 0 : this.data6.hashCode());
    result = (prime * result)
      + ((this.data7 == null) ? 0 : this.data7.hashCode());
    result = (prime * result)
      + ((this.strategyDate == null) ? 0 : this.strategyDate.hashCode());
    result = (prime * result)
      + ((this.paymentCreateDate == null) ? 0 : this.paymentCreateDate.hashCode());

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for balance.
   *
   * @param  balance  BigDecimal
   */
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for batch id.
   *
   * @param  batchId  Long
   */
  public void setBatchId(Long batchId) {
    this.batchId = batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket amount1.
   *
   * @param  bucketAmount1  BigDecimal
   */
  public void setBucketAmount1(BigDecimal bucketAmount1) {
    this.bucketAmount1 = bucketAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket amount2.
   *
   * @param  bucketAmount2  BigDecimal
   */
  public void setBucketAmount2(BigDecimal bucketAmount2) {
    this.bucketAmount2 = bucketAmount2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket amount3.
   *
   * @param  bucketAmount3  BigDecimal
   */
  public void setBucketAmount3(BigDecimal bucketAmount3) {
    this.bucketAmount3 = bucketAmount3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket amount4.
   *
   * @param  bucketAmount4  BigDecimal
   */
  public void setBucketAmount4(BigDecimal bucketAmount4) {
    this.bucketAmount4 = bucketAmount4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket amount5.
   *
   * @param  bucketAmount5  BigDecimal
   */
  public void setBucketAmount5(BigDecimal bucketAmount5) {
    this.bucketAmount5 = bucketAmount5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket amount6.
   *
   * @param  bucketAmount6  BigDecimal
   */
  public void setBucketAmount6(BigDecimal bucketAmount6) {
    this.bucketAmount6 = bucketAmount6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for bucket amount7.
   *
   * @param  bucketAmount7  BigDecimal
   */
  public void setBucketAmount7(BigDecimal bucketAmount7) {
    this.bucketAmount7 = bucketAmount7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for channel actual result id.
   *
   * @param  channelActualResultId  Long
   */
  public void setChannelActualResultId(Long channelActualResultId) {
    this.channelActualResultId = channelActualResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for current due.
   *
   * @param  currentDue  BigDecimal
   */
  public void setCurrentDue(BigDecimal currentDue) {
    this.currentDue = currentDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data1.
   *
   * @param  data1  String
   */
  public void setData1(String data1) {
    this.data1 = data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data10.
   *
   * @param  data10  String
   */
  public void setData10(String data10) {
    this.data10 = data10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data11.
   *
   * @param  data11  String
   */
  public void setData11(String data11) {
    this.data11 = data11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data12.
   *
   * @param  data12  String
   */
  public void setData12(String data12) {
    this.data12 = data12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data13.
   *
   * @param  data13  String
   */
  public void setData13(String data13) {
    this.data13 = data13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data14.
   *
   * @param  data14  String
   */
  public void setData14(String data14) {
    this.data14 = data14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data15.
   *
   * @param  data15  String
   */
  public void setData15(String data15) {
    this.data15 = data15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data2.
   *
   * @param  data2  String
   */
  public void setData2(String data2) {
    this.data2 = data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data3.
   *
   * @param  data3  String
   */
  public void setData3(String data3) {
    this.data3 = data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data4.
   *
   * @param  data4  String
   */
  public void setData4(String data4) {
    this.data4 = data4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data5.
   *
   * @param  data5  String
   */
  public void setData5(String data5) {
    this.data5 = data5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data6.
   *
   * @param  data6  String
   */
  public void setData6(String data6) {
    this.data6 = data6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data7.
   *
   * @param  data7  String
   */
  public void setData7(String data7) {
    this.data7 = data7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data8.
   *
   * @param  data8  String
   */
  public void setData8(String data8) {
    this.data8 = data8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data9.
   *
   * @param  data9  String
   */
  public void setData9(String data9) {
    this.data9 = data9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delinquency cycle.
   *
   * @param  delinquencyCycle  Integer
   */
  public void setDelinquencyCycle(Integer delinquencyCycle) {
    this.delinquencyCycle = delinquencyCycle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for delinquency days.
   *
   * @param  delinquencyDays  Integer
   */
  public void setDelinquencyDays(Integer delinquencyDays) {
    this.delinquencyDays = delinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email address.
   *
   * @param  emailAddress  String
   */
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for first name.
   *
   * @param  firstName  String
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last name.
   *
   * @param  lastName  String
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for middle initial.
   *
   * @param  middleInitial  String
   */
  public void setMiddleInitial(String middleInitial) {
    this.middleInitial = middleInitial;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for past due.
   *
   * @param  pastDue  BigDecimal
   */
  public void setPastDue(BigDecimal pastDue) {
    this.pastDue = pastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for payment create date.
   *
   * @param  paymentCreateDate  Date
   */
  public void setPaymentCreateDate(Date paymentCreateDate) {
    this.paymentCreateDate = paymentCreateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for placement date.
   *
   * @param  placementDate  Date
   */
  public void setPlacementDate(Date placementDate) {
    this.placementDate = placementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program amount.
   *
   * @param  programAmount  BigDecimal
   */
  public void setProgramAmount(BigDecimal programAmount) {
    this.programAmount = programAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program extra.
   *
   * @param  programExtra  String
   */
  public void setProgramExtra(String programExtra) {
    this.programExtra = programExtra;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for program name.
   *
   * @param  programName  String
   */
  public void setProgramName(String programName) {
    this.programName = programName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for salutation.
   *
   * @param  salutation  String
   */
  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for secure pdf channel result.
   *
   * @param  channelResult  SecurePdfChannelResult
   */
  public void setSecurePdfChannelResult(SecurePdfChannelResult channelResult) {
    this.channelResult = channelResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for title.
   *
   * @param  title  String
   */
  public void setTitle(String title) {
    this.title = title;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.channel.BaseChannelActualResult#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "SecurePdfChannelActualResult ( " + super.toString() + TAB
      + "channelActualResultId = " + this.channelActualResultId + TAB + " )";

    return retValue;
  }


} // end class SecurePdfChannelActualResult
