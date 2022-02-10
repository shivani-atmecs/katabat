package com.cmc.credagility.core.domain.channel;

import java.math.BigDecimal;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.contact.ContactPhone;
import com.cmc.credagility.core.jpa.converter.StringBooleanConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/14/2014 18:02
 */
@Entity
@Table(
  name    = "SmsChannelActualResult",
  indexes = {
    @Index(
      name = "phoneNumberIndex",
      columnList = "phoneNumber"
    ),
    @Index(
      name = "deliveryStatusIndex",
      columnList = "deliveryStatus"
    ), @Index(
      name = "uniqueSessionIdIndex",
      columnList = "uniqueSessionId"
    )
  }
)
public class SmsChannelActualResult extends BaseChannelActualResult {
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
  @JoinColumn(
    name     = "contactPhoneId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected ContactPhone contactPhone;

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
    length = 150
  )
  protected String data5;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data6",
    length = 2048
  )
  protected String data6;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data7",
    length = 2048
  )
  protected String data7;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "data8",
    length = 2048
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
    name   = "deliveryStatus",
    length = 20
  )
  protected String deliveryStatus;


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
  @Column(name = "phoneNumber")
  protected String phoneNumber;


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
    name   = "responseMessage",
    length = 255
  )
  protected String responseMessage;


  /** TODO: DOCUMENT ME! */
  @Column(name = "responseTime")
  @Temporal(TemporalType.TIMESTAMP)
  protected Date responseTime;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "returnCode",
    length = 10
  )
  protected String returnCode;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "salutation",
    length = 10
  )
  protected String salutation;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "smsActualResultId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long smsActualResultId;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "smsCampaignId",
    updatable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected SmsCampaign smsCampaign;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name      = "smsResultId",
    updatable = false
  )
  @ManyToOne(
    fetch   = FetchType.LAZY,
    cascade = CascadeType.ALL
  )
  protected SmsChannelResult smsChannelResult;

  /** TODO: DOCUMENT ME! */
  @OneToMany(
    fetch         = FetchType.LAZY,
    mappedBy      = "smsChannelActualResult",
    cascade       = CascadeType.ALL,
    orphanRemoval = true
  )
  protected Set<SmsOutboundAudit> smsOutboundAudits = new LinkedHashSet<SmsOutboundAudit>();


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "statusDescription",
    length = 250
  )
  protected String statusDescription;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "title",
    length = 10
  )
  protected String title;


  /** TODO: DOCUMENT ME! */
  @Column(
    name             = "unsubscribed",
    length           = 1,
    columnDefinition = "char"
  )
  @Convert(converter = StringBooleanConverter.class)
  protected Boolean unsubscribed;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  smsOutboundAudit  DOCUMENT ME!
   */
  public void addSmsOutboundAudit(SmsOutboundAudit smsOutboundAudit) {
    getSmsOutboundAudits().add(smsOutboundAudit);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

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

    final SmsChannelActualResult other = (SmsChannelActualResult) obj;

    if ((contactPhone != null) ? (!contactPhone.equals(other.contactPhone)) : (other.contactPhone != null)) {
      return false;
    }

    if ((phoneNumber != null) ? (!phoneNumber.equals(other.phoneNumber)) : (other.phoneNumber != null)) {
      return false;
    }

    if (this.data1 == null) {
      if (other.data1 != null) {
        return false;
      }
    } else if (!this.data1.equals(other.data1)) {
      return false;
    }

    if (this.data2 == null) {
      if (other.data2 != null) {
        return false;
      }
    } else if (!this.data2.equals(other.data2)) {
      return false;
    }

    if (this.data3 == null) {
      if (other.data3 != null) {
        return false;
      }
    } else if (!this.data3.equals(other.data3)) {
      return false;
    }

    if (this.data4 == null) {
      if (other.data4 != null) {
        return false;
      }
    } else if (!this.data4.equals(other.data4)) {
      return false;
    }

    if (this.data5 == null) {
      if (other.data5 != null) {
        return false;
      }
    } else if (!this.data5.equals(other.data5)) {
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

    if (this.data8 == null) {
      if (other.data8 != null) {
        return false;
      }
    } else if (!this.data8.equals(other.data8)) {
      return false;
    }

    if (this.data9 == null) {
      if (other.data9 != null) {
        return false;
      }
    } else if (!this.data9.equals(other.data9)) {
      return false;
    }

    if (this.data10 == null) {
      if (other.data10 != null) {
        return false;
      }
    } else if (!this.data10.equals(other.data10)) {
      return false;
    }

    if (this.data11 == null) {
      if (other.data11 != null) {
        return false;
      }
    } else if (!this.data11.equals(other.data11)) {
      return false;
    }

    if (this.template == null) {
      if (other.template != null) {
        return false;
      }
    } else if (!this.template.equals(other.template)) {
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
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBalance() {
    return balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getBatchId() {
    return batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBucketAmount1() {
    return bucketAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBucketAmount2() {
    return bucketAmount2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBucketAmount3() {
    return bucketAmount3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBucketAmount4() {
    return bucketAmount4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBucketAmount5() {
    return bucketAmount5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBucketAmount6() {
    return bucketAmount6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getBucketAmount7() {
    return bucketAmount7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public ContactPhone getContactPhone() {
    return contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getCurrentDue() {
    return currentDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData1() {
    return data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData10() {
    return data10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData11() {
    return data11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData12() {
    return data12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData13() {
    return data13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData14() {
    return data14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData15() {
    return data15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData2() {
    return data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData3() {
    return data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData4() {
    return data4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData5() {
    return data5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData6() {
    return data6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData7() {
    return data7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData8() {
    return data8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getData9() {
    return data9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDelinquencyCycle() {
    return delinquencyCycle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Integer getDelinquencyDays() {
    return delinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getDeliveryStatus() {
    return deliveryStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getFirstName() {
    return firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getLastName() {
    return lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getMiddleInitial() {
    return middleInitial;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getPastDue() {
    return pastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPaymentCreateDate() {
    return paymentCreateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getPlacementDate() {
    return placementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public BigDecimal getProgramAmount() {
    return programAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getProgramExtra() {
    return programExtra;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getProgramName() {
    return programName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getResponseMessage() {
    return responseMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Date getResponseTime() {
    return responseTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getReturnCode() {
    return returnCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getSalutation() {
    return salutation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Long getSmsActualResultId() {
    return smsActualResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public SmsCampaign getSmsCampaign() {
    return smsCampaign;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public SmsChannelResult getSmsChannelResult() {
    return smsChannelResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

/*
  //~ ------------------------------------------------------------------------------------------------------------------

 */
  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  /*

  public SmsChannelResultDocument getSmsChannelResultDocument() {
  return smsChannelResultDocument;
  }
   */

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Set<SmsOutboundAudit> getSmsOutboundAudits() {
    return smsOutboundAudits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getStatusDescription() {
    return statusDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public String getTitle() {
    return title;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public Boolean getUnsubscribed() {
    return unsubscribed;
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
    result = (prime * result)
      + ((this.phoneNumber == null) ? 0 : this.phoneNumber.hashCode());
    result = (prime * result)
      + ((this.template == null) ? 0 : this.template.hashCode());
    result = (prime * result)
      + ((this.data1 == null) ? 0 : this.data1.hashCode());
    result = (prime * result)
      + ((this.data2 == null) ? 0 : this.data2.hashCode());
    result = (prime * result)
      + ((this.data3 == null) ? 0 : this.data3.hashCode());
    result = (prime * result)
      + ((this.data4 == null) ? 0 : this.data4.hashCode());
    result = (prime * result)
      + ((this.data5 == null) ? 0 : this.data5.hashCode());
    result = (prime * result)
      + ((this.data6 == null) ? 0 : this.data6.hashCode());
    result = (prime * result)
      + ((this.data7 == null) ? 0 : this.data7.hashCode());
    result = (prime * result)
      + ((this.data8 == null) ? 0 : this.data8.hashCode());
    result = (prime * result)
      + ((this.data9 == null) ? 0 : this.data9.hashCode());
    result = (prime * result)
      + ((this.data10 == null) ? 0 : this.data10.hashCode());
    result = (prime * result)
      + ((this.data11 == null) ? 0 : this.data11.hashCode());
    result = (prime * result)
      + ((this.strategyDate == null) ? 0 : this.strategyDate.hashCode());
    result = (prime * result)
      + ((this.paymentCreateDate == null) ? 0 : this.paymentCreateDate.hashCode());

    return result;
  } // end method hashCode

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  balance  DOCUMENT ME!
   */
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  batchId  DOCUMENT ME!
   */
  public void setBatchId(Long batchId) {
    this.batchId = batchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bucketAmount1  DOCUMENT ME!
   */
  public void setBucketAmount1(BigDecimal bucketAmount1) {
    this.bucketAmount1 = bucketAmount1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bucketAmount2  DOCUMENT ME!
   */
  public void setBucketAmount2(BigDecimal bucketAmount2) {
    this.bucketAmount2 = bucketAmount2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bucketAmount3  DOCUMENT ME!
   */
  public void setBucketAmount3(BigDecimal bucketAmount3) {
    this.bucketAmount3 = bucketAmount3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bucketAmount4  DOCUMENT ME!
   */
  public void setBucketAmount4(BigDecimal bucketAmount4) {
    this.bucketAmount4 = bucketAmount4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bucketAmount5  DOCUMENT ME!
   */
  public void setBucketAmount5(BigDecimal bucketAmount5) {
    this.bucketAmount5 = bucketAmount5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bucketAmount6  DOCUMENT ME!
   */
  public void setBucketAmount6(BigDecimal bucketAmount6) {
    this.bucketAmount6 = bucketAmount6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  bucketAmount7  DOCUMENT ME!
   */
  public void setBucketAmount7(BigDecimal bucketAmount7) {
    this.bucketAmount7 = bucketAmount7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  contactPhone  DOCUMENT ME!
   */
  public void setContactPhone(ContactPhone contactPhone) {
    this.contactPhone = contactPhone;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  currentDue  DOCUMENT ME!
   */
  public void setCurrentDue(BigDecimal currentDue) {
    this.currentDue = currentDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data1  DOCUMENT ME!
   */
  public void setData1(String data1) {
    this.data1 = data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data10  DOCUMENT ME!
   */
  public void setData10(String data10) {
    this.data10 = data10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data11  DOCUMENT ME!
   */
  public void setData11(String data11) {
    this.data11 = data11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data12  DOCUMENT ME!
   */
  public void setData12(String data12) {
    this.data12 = data12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data13  DOCUMENT ME!
   */
  public void setData13(String data13) {
    this.data13 = data13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data14  DOCUMENT ME!
   */
  public void setData14(String data14) {
    this.data14 = data14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data15  DOCUMENT ME!
   */
  public void setData15(String data15) {
    this.data15 = data15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data2  DOCUMENT ME!
   */
  public void setData2(String data2) {
    this.data2 = data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data3  DOCUMENT ME!
   */
  public void setData3(String data3) {
    this.data3 = data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data4  DOCUMENT ME!
   */
  public void setData4(String data4) {
    this.data4 = data4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data5  DOCUMENT ME!
   */
  public void setData5(String data5) {
    this.data5 = data5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data6  DOCUMENT ME!
   */
  public void setData6(String data6) {
    this.data6 = data6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data7  DOCUMENT ME!
   */
  public void setData7(String data7) {
    this.data7 = data7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data8  DOCUMENT ME!
   */
  public void setData8(String data8) {
    this.data8 = data8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  data9  DOCUMENT ME!
   */
  public void setData9(String data9) {
    this.data9 = data9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  delinquencyCycle  DOCUMENT ME!
   */
  public void setDelinquencyCycle(Integer delinquencyCycle) {
    this.delinquencyCycle = delinquencyCycle;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  delinquencyDays  DOCUMENT ME!
   */
  public void setDelinquencyDays(Integer delinquencyDays) {
    this.delinquencyDays = delinquencyDays;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  deliveryStatus  DOCUMENT ME!
   */
  public void setDeliveryStatus(String deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  firstName  DOCUMENT ME!
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  lastName  DOCUMENT ME!
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  middleInitial  DOCUMENT ME!
   */
  public void setMiddleInitial(String middleInitial) {
    this.middleInitial = middleInitial;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  pastDue  DOCUMENT ME!
   */
  public void setPastDue(BigDecimal pastDue) {
    this.pastDue = pastDue;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  paymentCreateDate  DOCUMENT ME!
   */
  public void setPaymentCreateDate(Date paymentCreateDate) {
    this.paymentCreateDate = paymentCreateDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  phoneNumber  DOCUMENT ME!
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  placementDate  DOCUMENT ME!
   */
  public void setPlacementDate(Date placementDate) {
    this.placementDate = placementDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programAmount  DOCUMENT ME!
   */
  public void setProgramAmount(BigDecimal programAmount) {
    this.programAmount = programAmount;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programExtra  DOCUMENT ME!
   */
  public void setProgramExtra(String programExtra) {
    this.programExtra = programExtra;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  programName  DOCUMENT ME!
   */
  public void setProgramName(String programName) {
    this.programName = programName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  responseMessage  DOCUMENT ME!
   */
  public void setResponseMessage(String responseMessage) {
    this.responseMessage = responseMessage;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  responseTime  DOCUMENT ME!
   */
  public void setResponseTime(Date responseTime) {
    this.responseTime = responseTime;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  returnCode  DOCUMENT ME!
   */
  public void setReturnCode(String returnCode) {
    this.returnCode = returnCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  salutation  DOCUMENT ME!
   */
  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  smsActualResultId  DOCUMENT ME!
   */
  public void setSmsActualResultId(Long smsActualResultId) {
    this.smsActualResultId = smsActualResultId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  smsCampaign  DOCUMENT ME!
   */
  public void setSmsCampaign(SmsCampaign smsCampaign) {
    this.smsCampaign = smsCampaign;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  smsChannelResult  DOCUMENT ME!
   */
  public void setSmsChannelResult(SmsChannelResult smsChannelResult) {
    this.smsChannelResult = smsChannelResult;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

/*
  //~ ------------------------------------------------------------------------------------------------------------------

 */
  /**
   * DOCUMENT ME!
   *
   * @param  smsOutboundAudits  smsChannelResultDocument DOCUMENT ME!
   */
  /*

  public void setSmsChannelResultDocument(SmsChannelResultDocument smsChannelResultDocument) {
  this.smsChannelResultDocument = smsChannelResultDocument;
  }

   */

  /**
   * DOCUMENT ME!
   *
   * @param  smsOutboundAudits  DOCUMENT ME!
   */
  public void setSmsOutboundAudits(Set<SmsOutboundAudit> smsOutboundAudits) {
    this.smsOutboundAudits = smsOutboundAudits;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  statusDescription  DOCUMENT ME!
   */
  public void setStatusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  title  DOCUMENT ME!
   */
  public void setTitle(String title) {
    this.title = title;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param  unsubscribed  DOCUMENT ME!
   */
  public void setUnsubscribed(Boolean unsubscribed) {
    this.unsubscribed = unsubscribed;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * toString.
   *
   * @return  String
   */
  @Override public String toString() {
    final String TAB = "    ";

    String retValue = "";

    retValue = "smsChannelActualResult ( " + super.toString() + TAB
      + "smsActualResultId = " + this.smsActualResultId + TAB + " )";

    return retValue;
  }
} // end class SmsChannelActualResult
